package thelight0804.SpringIntroduction.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import thelight0804.SpringIntroduction.domain.Member;
import thelight0804.SpringIntroduction.service.MemberService;

@Controller //Spring Bean
public class MemberController {
  //생성자 주입
  private final MemberService memberService;

  @Autowired //Connect Spring Beans
  public MemberController(MemberService memberService) {
    this.memberService = memberService;
  }

  @GetMapping("/members/new")
  public String createForm(){
    return "members/createMemberForm";
  }

  @PostMapping("/members/new")
  public String create(MemberForm form){
    //Member 생성
    Member member = new Member();

    //get 이름
    member.setName(form.getName());
    memberService.join(member); //등록

    System.out.println("member = " + member.getName());

    return "redirect:/"; //되돌아가기
  }

  @GetMapping("/members")
  public String list(Model model){
    List<Member> members = memberService.findMembers();
    model.addAttribute("members", members);
    return "members/memberList";
  }
}
