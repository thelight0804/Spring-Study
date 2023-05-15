package Jumptospringboot.thelight0804.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Song {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(length = 200)
  private String title;

  @Column(columnDefinition = "TEXT")
  private String detail;

  private LocalDateTime createDate;

  @OneToMany(mappedBy = "song", cascade = CascadeType.REMOVE)
  private List<Comment> commentList;
}
