package thelight0804.SpringIntroduction.domain;

public class Member {

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
