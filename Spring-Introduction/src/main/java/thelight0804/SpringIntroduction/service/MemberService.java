package thelight0804.SpringIntroduction.service;

import java.util.List;
import java.util.Optional;
import thelight0804.SpringIntroduction.domain.Member;
import thelight0804.SpringIntroduction.repository.MemberRepository;
import thelight0804.SpringIntroduction.repository.MemoryMemberRepository;

public class MemberService {

  private final MemberRepository memberRepository = new MemoryMemberRepository();

  /**
   * 회원 가입
   */
  public Long join(Member member){
    validateDuplicateMember(member); //중복 회원 검증

    memberRepository.save(member);
    return member.getId();
  }

  private void validateDuplicateMember(Member member) {
    memberRepository.findByName(member.getName())
        .ifPresent(m -> {
          throw new IllegalStateException("exist member");
        });
  }

  /**
   * 전체 회원 조회
   */
  public List<Member> findMembers(){
    return memberRepository.findAll();
  }

  /**
   * 회원 조회
   */
  public Optional<Member> findOne(Long memberId){
    return memberRepository.findById(memberId);
  }
}