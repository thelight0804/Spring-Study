package Jumptospringboot.thelight0804.controller;

import Jumptospringboot.thelight0804.domain.Song;
import Jumptospringboot.thelight0804.repository.SongRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class SongController {
  private final SongRepository songRepository;

  @GetMapping("/song/list")
  public String list(Model model){
    List<Song> songList = this.songRepository.findAll();
    model.addAttribute("songList", songList);
    return "song_list";
  }
}
