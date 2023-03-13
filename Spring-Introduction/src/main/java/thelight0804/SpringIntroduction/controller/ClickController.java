package thelight0804.SpringIntroduction.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ClickController {

  @GetMapping("click")
  public String click(Model model) {
    model.addAttribute("data", "Clicked!");
    return "click";
  }

  @GetMapping("view")
  public String view(@RequestParam("value") String data, Model model){
    model.addAttribute("value", data);
    return "view";
  }

  @GetMapping("api")
  @ResponseBody
  public String api(@RequestParam("value") String data){
    return "value = " + data;
  }


  @GetMapping("api-class")
  @ResponseBody
  public Person apiClass(@RequestParam("value") String data){
    Person person = new Person();
    person.setName(data);
    return person;
  }

  //static : class 안에서 class 사용 가능
  //ClickController.data
  static class Person{
    private String name;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
  }
}
