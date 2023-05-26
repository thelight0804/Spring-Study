package Jumptospringboot.thelight0804.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateForm {
  //check validation
  @Size(min = 3, max = 25)
  @NotEmpty(message = "ID는 필수항목입니다.")
  private String username;

  @NotEmpty(message = "비밀번호는 필수항목입니다.")
  private String password;

  @NotEmpty(message = "비밀번호 확인은 필수항목입니다.")
  private String checkPassword; //비밀번호 확인

  @NotEmpty(message = "이메일은 필수항목입니다.")
  @Email
  private String email;
}
