package thelight0804.SpringIntroduction.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import thelight0804.SpringIntroduction.domain.Member;
import thelight0804.SpringIntroduction.repository.MemberRepository;
import thelight0804.SpringIntroduction.repository.MemoryMemberRepository;

@SpringBootTest //Use Spring Container
@Transactional //rollback before test
class MemberServiceJDBCTest {

  //Add Spring Container DI
  @Autowired
  MemberService memberService;
  @Autowired
  MemberRepository memberRepository;

  @Test
  void join() {
    //given 입력 받아서
    Member member = new Member();
    member.setName("member1");

    //when 실행했을 때
    Long saveId = memberService.join(member);

    //then 원하는 결과
    Member findMember = memberService.findOne(saveId).get();
    assertThat(member.getName()).isEqualTo(findMember.getName());
  }

  @Test
  public void join_same(){
    //given
    Member member1 = new Member();
    member1.setName("member1");

    Member member11 = new Member();
    member11.setName("member1");

    //when
    memberService.join(member1);
    IllegalStateException e = assertThrows(IllegalStateException.class,
        () -> memberService.join(member11));//일치하는 예외
    //같은 예외 내용인지 확인
    assertThat(e.getMessage()).isEqualTo("exist member");
//    assertThrows(NullPointerException.class,  () -> memberService.join(member11)); //일치하지 않는 예외
  }
}