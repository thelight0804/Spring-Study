package thelight0804.SpringIntroduction.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
public class HelloController {

  @GetMapping("click")
  public String hello(Model model) {
    model.addAttribute("data", "Clicked!");
    return "click";
  }
}
