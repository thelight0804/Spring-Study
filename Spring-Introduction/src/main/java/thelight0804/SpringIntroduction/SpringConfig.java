package thelight0804.SpringIntroduction;

import jakarta.persistence.EntityManager;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import thelight0804.SpringIntroduction.repository.JDBCMemberRepository;
import thelight0804.SpringIntroduction.repository.JDBCTemplateMemberRepository;
import thelight0804.SpringIntroduction.repository.JPAMemberRepository;
import thelight0804.SpringIntroduction.repository.MemberRepository;
import thelight0804.SpringIntroduction.repository.MemoryMemberRepository;
import thelight0804.SpringIntroduction.service.MemberService;

@Configuration
public class SpringConfig {
//  Use DataSource
//  private DataSource dataSource;
//
//  @Autowired
//  public SpringConfig(DataSource dataSource) {
//    this.dataSource = dataSource;
//  }

//  //Use JPA
//  private EntityManager em;
//
//  @Autowired
//  public SpringConfig(EntityManager em) {
//    this.em = em;
//  }

  //Use SpringDataJpa
  private final MemberRepository memberRepository;

  @Autowired //생략 가능
  public SpringConfig(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }

  @Bean
  public MemberService memberService() {
    return new MemberService(memberRepository);
  }

//  @Bean
//  public MemberRepository memberRepository() {
//    //return new MemoryMemberRepository(); //Memory
//    //return new JDBCMemberRepository(dataSource); //JDBC
//    //return new JDBCTemplateMemberRepository(dataSource); //JdbcTemplate
//    //return new JPAMemberRepository(em); //JPA
//    return new JPAMemberRepository(em); //JPA
//  }
}
