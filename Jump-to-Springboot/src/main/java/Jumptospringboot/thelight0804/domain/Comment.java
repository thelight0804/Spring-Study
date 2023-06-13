package Jumptospringboot.thelight0804.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Comment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(length = 200)
  private String content;

  @ManyToOne
  private SiteUser author;

  private LocalDateTime createDate; //생성 시간

  private LocalDateTime updateDate; //수정 시간

  @ManyToOne
  private Song song;

  @ManyToMany
  Set<SiteUser> voter; //추천인
}
