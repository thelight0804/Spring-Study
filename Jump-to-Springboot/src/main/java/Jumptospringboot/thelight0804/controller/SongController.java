package Jumptospringboot.thelight0804.controller;

import Jumptospringboot.thelight0804.domain.Song;
import Jumptospringboot.thelight0804.form.CommentForm;
import Jumptospringboot.thelight0804.form.SongForm;
import Jumptospringboot.thelight0804.repository.SongRepository;
import Jumptospringboot.thelight0804.service.SongService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/song")
@RequiredArgsConstructor
@Controller
public class SongController {

  private final SongService songService; //Service 객체 선언

  @GetMapping("/list")
  public String list(Model model, @RequestParam(value="page", defaultValue = "0") int page) {
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
  @GetMapping("/create")
  public String songCreate(SongForm songForm) {
    return "song_form";
  }

  //음악 등록
  @PostMapping("/create")
  public String songCreate(@Valid SongForm songForm, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) { //form 입력 값 체크
      return "song_form";
    }
    this.songService.create(songForm.getTitle(), songForm.getDetail());
    return "redirect:/song/list"; //전송 후 해당 페이지로 이동
  }
}
