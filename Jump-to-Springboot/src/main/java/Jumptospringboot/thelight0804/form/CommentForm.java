package Jumptospringboot.thelight0804.form;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SongForm {

  @NotEmpty(message = "제목은 필수항목입니다.")
  @Size(max=200)
  private String title;

  @NotEmpty(message = "상세 내용은 필수항목입니다.")
  private String detail;
}
