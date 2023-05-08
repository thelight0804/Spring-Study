package Jumptospringboot.thelight0804.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //컨트롤러 기능 수행
public class HelloController {

  @GetMapping("/hello") //"URL/hello"로 요청이 발생하면 메서드 실행
  @ResponseBody
  public String hello() {
    return "Hello World";
  }
}
