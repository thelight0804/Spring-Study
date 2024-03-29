package Jumptospringboot.thelight0804.service;

import Jumptospringboot.thelight0804.DataNotFoundException;
import Jumptospringboot.thelight0804.domain.Comment;
import Jumptospringboot.thelight0804.domain.SiteUser;
import Jumptospringboot.thelight0804.domain.Song;
import Jumptospringboot.thelight0804.repository.CommentRepository;
import java.time.LocalDateTime;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CommentService {

  private final CommentRepository commentRepository;

  public Comment create(Song song, String content, SiteUser author) {
    Comment comment = new Comment();
    comment.setContent(content);
    comment.setCreateDate(LocalDateTime.now());
    comment.setSong(song);
    comment.setAuthor(author);
    this.commentRepository.save(comment);
    return comment;
  }

  //조회
  public Comment getComment(Integer id) {
    Optional<Comment> comment = this.commentRepository.findById(id);
    if (comment.isPresent()) {
      return comment.get();
    } else{
      throw new DataNotFoundException("Comment not found");
    }
  }

  //수정
  public void modify(Comment comment, String content) {
    comment.setContent(content);
    comment.setUpdateDate(LocalDateTime.now());
    this.commentRepository.save(comment);
  }

  //삭제
  public void delete(Comment comment){
    this.commentRepository.delete(comment);
  }

  //추천
  public void vote(Comment comment, SiteUser siteUser) {
    comment.getVoter().add(siteUser);
    this.commentRepository.save(comment);
  }
}
