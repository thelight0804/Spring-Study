package Jumptospringboot.thelight0804.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //Class를 스프링부트의 Controller로 사용한다
public class MainController {

  @GetMapping("/main") //URL 요청이 들어오면 main 메서드를 실행한다
  @ResponseBody //HTTP 바디에 담는다
  public String main(){
    return "Now is main";
  }
}