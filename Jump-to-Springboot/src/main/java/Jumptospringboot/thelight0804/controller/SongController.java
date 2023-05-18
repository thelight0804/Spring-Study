package Jumptospringboot.thelight0804.controller;

import Jumptospringboot.thelight0804.domain.Song;
import Jumptospringboot.thelight0804.repository.SongRepository;
import Jumptospringboot.thelight0804.service.SongService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class SongController {

  //  private final SongRepository songRepository; //Repository 객체 선언
  private final SongService songService; //Service 객체 선언

  @GetMapping("/song/list")
  public String list(Model model){
//    List<Song> songList = this.songRepository.findAll(); //Repository 사용
    List<Song> songList = this.songService.getList(); //Service 사용
    model.addAttribute("songList", songList);
    return "song_list";
  }
}
