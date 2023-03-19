package thelight0804.SpringIntroduction.service;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import thelight0804.SpringIntroduction.domain.Member;
import thelight0804.SpringIntroduction.repository.MemoryMemberRepository;

class MemberServiceTest {

  MemberService memberService;
  MemoryMemberRepository memberRepository;

  @BeforeEach //테스트 실행 전
  public void beforeEach(){
    memberRepository = new MemoryMemberRepository();
    memberService = new MemberService(memberRepository);
  }

  @AfterEach //저장소 초기화
  public void afterEach() {
    memberRepository.clearStore();
  }

  @Test
  void 회원가입() {
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
  public void 중복_회원_가입(){
    //given
    Member member1 = new Member();
    member1.setName("member1");

    Member member11 = new Member();
    member11.setName("member1");

    //when
    memberService.join(member1);
    assertThrows(NullPointerException.class,  () -> memberService.join(member11)); //일치하지 않는 예외
//    IllegalStateException e = assertThrows(IllegalStateException.class,
//        () -> memberService.join(member11));//일치하는 예외
//    //같은 예외 내용인지 확인
//    assertThat(e.getMessage()).isEqualTo("exist member");
  }

  @Test
  void findMembers() {
  }

  @Test
  void findOne() {
  }
}