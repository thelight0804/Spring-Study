package Jumptospringboot.thelight0804.controller;

import Jumptospringboot.thelight0804.domain.Song;
import Jumptospringboot.thelight0804.service.CommentService;
import Jumptospringboot.thelight0804.service.SongService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/comment")
@RequiredArgsConstructor
@Controller
public class CommentController {

  private final SongService songService;
  private final CommentService commentService;

  @PostMapping("/create/{id}")
  public String createComment(Model model, @PathVariable("id") Integer id,
    @RequestParam String content) {
    Song song = this.songService.getSong(id);
    this.commentService.create(song, content);
    return String.format("redirect:/song/detail/%s", id);
  }
}
