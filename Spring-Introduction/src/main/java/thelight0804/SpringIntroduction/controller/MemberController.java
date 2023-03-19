package thelight0804.SpringIntroduction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import thelight0804.SpringIntroduction.service.MemberService;

@Controller //Spring Bean
public class MemberController {
  //필드 주입
  //@Autowired private MemberService memberService;

  //생성자 주입
  private final MemberService memberService;

  @Autowired //Connect Spring Beans
  public MemberController(MemberService memberService) {
    this.memberService = memberService;
  }

  //setter 주입
//  private MemberService memberService;
//
//  @Autowired
//  public void setMemberService(MemberService memberService) {
//    this.memberService = memberService;
//  }
}
