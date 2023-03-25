package thelight0804.SpringIntroduction;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import thelight0804.SpringIntroduction.repository.JDBCMemberRepository;
import thelight0804.SpringIntroduction.repository.JDBCTemplateMemberRepository;
import thelight0804.SpringIntroduction.repository.MemberRepository;
import thelight0804.SpringIntroduction.repository.MemoryMemberRepository;
import thelight0804.SpringIntroduction.service.MemberService;

@Configuration
public class SpringConfig {

  private DataSource dataSource;

  @Autowired
  public SpringConfig(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  @Bean
  public MemberService memberService() {
    return new MemberService(memberRepository());
  }

  @Bean
  public MemberRepository memberRepository() {
//    return new MemoryMemberRepository();
//    return new JDBCMemberRepository(dataSource);
    return new JDBCTemplateMemberRepository(dataSource);
  }
}
