package Jumptospringboot.thelight0804.controller;

import Jumptospringboot.thelight0804.domain.SiteUser;
import Jumptospringboot.thelight0804.domain.Song;
import Jumptospringboot.thelight0804.form.CommentForm;
import Jumptospringboot.thelight0804.service.CommentService;
import Jumptospringboot.thelight0804.service.SongService;
import Jumptospringboot.thelight0804.service.UserService;
import jakarta.validation.Valid;
import java.security.Principal;
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
  private final UserService userService;

  @PostMapping("/create/{id}")
  public String createComment(Model model, @PathVariable("id") Integer id,
    @Valid CommentForm commentForm, BindingResult bindingResult, Principal principal) {
    Song song = this.songService.getSong(id);
    SiteUser siteUser = this.userService.getUser(principal.getName()); //유저 객체
    if (bindingResult.hasErrors()){
      model.addAttribute("song", song);
      return "song_detail";
    }
    this.commentService.create(song, commentForm.getContent(), siteUser);
    return String.format("redirect:/song/detail/%s", id);
  }
}
