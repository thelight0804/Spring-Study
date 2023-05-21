package Jumptospringboot.thelight0804.form;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentForm {

  @NotEmpty(message = "댓글 내용은 필수항목입니다.")
  private String content;
}
