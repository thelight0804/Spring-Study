package Jumptospringboot.thelight0804.controller;

import Jumptospringboot.thelight0804.form.UserCreateForm;
import Jumptospringboot.thelight0804.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/user")
public class UserController {

  private final UserService userService;

  //get template
  @GetMapping("/signup")
  public String signup(UserCreateForm userCreateForm) {
    return "signup_form"; //return template
  }

  //signup
  @PostMapping("/signup")
  public String signup(@Valid UserCreateForm userCreateForm, BindingResult bindingResult) {
    //validation object
    if (bindingResult.hasErrors()) {
      return "signup_form";
    }
    //check password
    if (!userCreateForm.getPassword().equals(userCreateForm.getCheckPassword())){
      //set bindingResult error
      bindingResult.rejectValue("checkPassword", "passwordInCorrect"
      ,"2개의 비밀번호가 일치하지 않습니다");
      return "signup_form";
    }

  try {
    //create user
    userService.create(userCreateForm.getUsername(), userCreateForm.getEmail(),
    userCreateForm.getPassword());
  }catch (DataIntegrityViolationException e){ //exception same account
    e.printStackTrace();
    bindingResult.reject("signupFailed", "이미 등록된 사용자입니다.");
    return "signup_form";
  }catch(Exception e){
    e.printStackTrace();
    bindingResult.reject("signupFailed", e.getMessage());
    return "signup_form";
  }

    return "redirect:/";
  }

  //login
  @GetMapping("/login")
  public String login(){
    return "login_form";
  }
}
