package Jumptospringboot.thelight0804.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class SiteUser {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) //기본 key 값을 자동으로 생성한다
  private Long id;

  @Column(unique = true) //중복 X
  private String name; //유저 이름

  @Column(unique = true)
  private String email;

  private String password;
}
