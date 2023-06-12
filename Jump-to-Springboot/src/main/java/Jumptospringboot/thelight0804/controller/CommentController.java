package Jumptospringboot.thelight0804.controller;

import Jumptospringboot.thelight0804.domain.Comment;
import Jumptospringboot.thelight0804.domain.SiteUser;
import Jumptospringboot.thelight0804.domain.Song;
import Jumptospringboot.thelight0804.form.CommentForm;
import Jumptospringboot.thelight0804.service.CommentService;
import Jumptospringboot.thelight0804.service.SongService;
import Jumptospringboot.thelight0804.service.UserService;
import jakarta.validation.Valid;
import java.security.Principal;
import lombok.RequiredArgsConstructor;
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

@RequestMapping("/comment")
@RequiredArgsConstructor
@Controller
public class CommentController {

  private final SongService songService;
  private final CommentService commentService;
  private final UserService userService;

  @PreAuthorize("isAuthenticated()") //require login
  @PostMapping("/create/{id}")
  public String createComment(Model model, @PathVariable("id") Integer id,
    @Valid CommentForm commentForm, BindingResult bindingResult, Principal principal) {
    Song song = this.songService.getSong(id);
    SiteUser siteUser = this.userService.getUser(principal.getName()); //유저 객체
    if (bindingResult.hasErrors()) {
      model.addAttribute("song", song);
      return "song_detail";
    }
    this.commentService.create(song, commentForm.getContent(), siteUser);
    return String.format("redirect:/song/detail/%s", id);
  }

  //수정
  @PreAuthorize("isAuthenticated()")
  @GetMapping("/modify/{id}")
  public String commentModify(CommentForm commentForm, @PathVariable("id") Integer id,
    Principal principal) {
    Comment comment = this.commentService.getComment(id);
    if (!comment.getAuthor().getUsername().equals(principal.getName())) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "😟 수정권한이 없습니다.");
    }
    commentForm.getContent();
    return "comment_form";
  }

  @PreAuthorize("isAuthenticated()")
  @PostMapping("/modify/{id}")
  public String commentModify(@Valid CommentForm commentForm, BindingResult bindingResult,
    @PathVariable("id") Integer id, Principal principal) {
    if (bindingResult.hasErrors()) {
      return "comment_form";
    }
    Comment comment = this.commentService.getComment(id);
    if (!comment.getAuthor().getUsername().equals(principal.getName())) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "😟 수정권한이 없습니다.");
    }
    this.commentService.modify(comment, commentForm.getContent());
    return String.format("redirect:/song/detail/%s", comment.getSong().getId());
  }

  //삭제
  @PreAuthorize("isAuthenticated()")
  @GetMapping("/delete/{id}")
  public String commentDelete(Principal principal, @PathVariable("id") Integer id) {
    Comment comment = this.commentService.getComment(id);
    if (!comment.getAuthor().getUsername().equals(principal.getName())) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "😟 삭제권한이 없습니다.");
    }
    this.commentService.delete(comment);
    return String.format("redirect:/song/detail/%s", comment.getSong().getId());
  }
}
