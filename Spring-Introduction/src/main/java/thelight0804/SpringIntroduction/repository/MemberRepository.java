//기능
package thelight0804.SpringIntroduction.repository;

import java.util.List;
import java.util.Optional;
import thelight0804.SpringIntroduction.domain.Member;

public interface MemberRepository {
  Member save(Member member); //회원 저장
  Optional<Member> findById(Long id); //ID 찾기
  Optional<Member> findByName(String name); //이름 찾기
  List<Member> findAll(); //모든 회원 반환
}
