package Jumptospringboot.thelight0804.controller;

import Jumptospringboot.thelight0804.domain.SiteUser;
import Jumptospringboot.thelight0804.domain.Song;
import Jumptospringboot.thelight0804.form.CommentForm;
import Jumptospringboot.thelight0804.form.SongForm;
import Jumptospringboot.thelight0804.repository.SongRepository;
import Jumptospringboot.thelight0804.service.SongService;
import Jumptospringboot.thelight0804.service.UserService;
import jakarta.validation.Valid;
import java.security.Principal;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

@RequestMapping("/song")
@RequiredArgsConstructor
@Controller
public class SongController {

  private final SongService songService; //Service 객체 선언
  private final UserService userService; //유저 service 객체 선언

  @GetMapping("/list")
  public String list(Model model, @RequestParam(value = "page", defaultValue = "0") int page) {
    //List<Song> songList = this.songService.getList(); //Service 사용
    Page<Song> paging = this.songService.getList(page);
    //model.addAttribute("songList", songList);
    model.addAttribute("paging", paging);
    return "song_list";
  }

  //상세 페이지 mapping
  @GetMapping(value = "/detail/{id}") //id 값에 따라 요청이 달라진다
  public String detail(Model model, @PathVariable("id") Integer id, CommentForm commentForm) {
    Song song = this.songService.getSong(id);
    model.addAttribute("song", song);
    return "song_detail";
  }

  //음악 등록 템플릿 이동
  @PreAuthorize("isAuthenticated()") //require login
  @GetMapping("/create")
  public String songCreate(SongForm songForm) {
    return "song_form";
  }

  //음악 등록
  @PreAuthorize("isAuthenticated()") //require login
  @PostMapping("/create")
  public String songCreate(@Valid SongForm songForm,
    BindingResult bindingResult, Principal principal) {
    if (bindingResult.hasErrors()) { //form 입력 값 체크
      return "song_form";
    }
    SiteUser siteUser = this.userService.getUser(principal.getName());
    this.songService.create(songForm.getTitle(), songForm.getDetail(), siteUser);
    return "redirect:/song/list"; //전송 후 해당 페이지로 이동
  }

  //수정
  @PreAuthorize("isAuthenticated()")
  @GetMapping("/modify/{id}")
  public String songModify(SongForm songForm, @PathVariable("id") Integer id, Principal principal){
    Song song = this.songService.getSong(id);
    if (!song.getAuthor().getUsername().equals(principal.getName())) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "😟 수정 권한이 없습니다!");
    }
    songForm.setTitle(song.getTitle());
    songForm.setDetail(song.getDetail());
    return "song_form";
  }

  @PreAuthorize("isAuthenticated()")
  @PostMapping("/modify/{id}")
  public String songModify(@Valid SongForm songForm, BindingResult bindingResult,
    Principal principal, @PathVariable("id") Integer id) {
    if (bindingResult.hasErrors()) {
      return "song_form";
    }
    Song song = this.songService.getSong(id);
    if (!song.getAuthor().getUsername().equals(principal.getName())) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "😟 수정권한이 없습니다.");
    }
    this.songService.modify(song, songForm.getTitle(), songForm.getDetail());
    return String.format("redirect:/song/detail/%s", id);
  }

  //삭제
  @PreAuthorize("isAuthenticated()")
  @GetMapping("/delete/{id}")
  public String songDelete(Principal principal, @PathVariable("id") Integer id) {
    Song song = this.songService.getSong(id);
    if (!song.getAuthor().getUsername().equals(principal.getName())) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "😟 삭제 권한이 없습니다");
    }
    this.songService.delete(song);
    return "redirect:/";
  }
}
