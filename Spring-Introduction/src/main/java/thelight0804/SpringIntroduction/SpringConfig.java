package thelight0804.SpringIntroduction;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import thelight0804.SpringIntroduction.repository.MemberRepository;
import thelight0804.SpringIntroduction.repository.MemoryMemberRepository;
import thelight0804.SpringIntroduction.service.MemberService;

@Configuration
public class SpringConfig {

  @Bean
  public MemberService memberService() {
    return new MemberService(memberRepository());
  }

  @Bean
  public MemberRepository memberRepository(){
    return new MemoryMemberRepository();
  }
}
