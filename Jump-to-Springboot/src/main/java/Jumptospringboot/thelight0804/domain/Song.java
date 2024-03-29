package Jumptospringboot.thelight0804.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
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

  @ManyToOne //글쓴이
  private SiteUser author;

  private LocalDateTime createDate; //생성 시간

  private LocalDateTime updateDate; //수정 시간

  @OneToMany(mappedBy = "song", cascade = CascadeType.REMOVE)
  private List<Comment> commentList;

  @ManyToMany
  Set<SiteUser> voter; //추천인
}
