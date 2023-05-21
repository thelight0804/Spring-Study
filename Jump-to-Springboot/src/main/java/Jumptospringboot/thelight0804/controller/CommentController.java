package Jumptospringboot.thelight0804.controller;

import Jumptospringboot.thelight0804.domain.Song;
import Jumptospringboot.thelight0804.form.CommentForm;
import Jumptospringboot.thelight0804.service.CommentService;
import Jumptospringboot.thelight0804.service.SongService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
    @Valid CommentForm commentForm, BindingResult bindingResult) {
    Song song = this.songService.getSong(id);
    if (bindingResult.hasErrors()){
      model.addAttribute("song", song);
      return "song_detail";
    }
    this.commentService.create(song, commentForm.getContent());
    return String.format("redirect:/song/detail/%s", id);
  }
}
