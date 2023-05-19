package Jumptospringboot.thelight0804.service;

import Jumptospringboot.thelight0804.domain.Comment;
import Jumptospringboot.thelight0804.domain.Song;
import Jumptospringboot.thelight0804.repository.CommentRepository;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CommentService {

  private final CommentRepository commentRepository;

  public void create(Song song, String content) {
    Comment comment = new Comment();
    comment.setContent(content);
    comment.setCreateDate(LocalDateTime.now());
    comment.setSong(song);
    this.commentRepository.save(comment);
  }
}
