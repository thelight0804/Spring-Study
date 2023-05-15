package Jumptospringboot.thelight0804.repository;

import Jumptospringboot.thelight0804.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

}
