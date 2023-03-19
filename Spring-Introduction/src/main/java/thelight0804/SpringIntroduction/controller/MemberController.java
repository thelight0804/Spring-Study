package thelight0804.SpringIntroduction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import thelight0804.SpringIntroduction.service.MemberService;

@Controller //Spring Bean
public class MemberController {
  private final MemberService memberService;

  //생성자
  @Autowired //Connect Spring Beans
  public MemberController(MemberService memberService) {
    this.memberService = memberService;
  }
}
