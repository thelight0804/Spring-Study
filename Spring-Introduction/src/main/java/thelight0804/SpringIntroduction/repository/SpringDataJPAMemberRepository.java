package thelight0804.SpringIntroduction.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import thelight0804.SpringIntroduction.domain.Member;

//extends: interface가 interface를 받을 때 사용한다
public interface SpringDataJPAMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

  @Override
  Optional<Member> findByName(String name);
  //Spring Data JPA에 내장되어 있지 않는 메서드는 선언해준다
  //JPQL => select m from Member m where m.name = ?
}
