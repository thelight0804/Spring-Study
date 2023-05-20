package Jumptospringboot.thelight0804.controller;

import Jumptospringboot.thelight0804.domain.Song;
import Jumptospringboot.thelight0804.repository.SongRepository;
import Jumptospringboot.thelight0804.service.SongService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/song")
@RequiredArgsConstructor
@Controller
public class SongController {

  private final SongService songService; //Service 객체 선언

  @GetMapping("/list")
  public String list(Model model) {
    List<Song> songList = this.songService.getList(); //Service 사용
    model.addAttribute("songList", songList);
    return "song_list";
  }

  //상세 페이지 mapping
  @GetMapping(value = "/detail/{id}") //id 값에 따라 요청이 달라진다
  public String detail(Model model, @PathVariable("id") Integer id) {
    Song song = this.songService.getSong(id);
    model.addAttribute("song", song);
    return "song_detail";
  }

  //음악 등록
  @GetMapping("/create")
  public String songCreate(){
    return "song_form";
  }
}
