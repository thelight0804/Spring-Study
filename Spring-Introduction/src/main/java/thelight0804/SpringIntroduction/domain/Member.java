package thelight0804.SpringIntroduction.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity //해당 class를 Entity Mapping 한다
public class Member {

  @Id //Entity의 식별자를 지정하는 annotation
  @GeneratedValue(strategy = GenerationType.IDENTITY) //기본 key 값을 자동으로 생성한다
  private Long id; //id (system에서 사용)

  private String name; //이름

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
