package thelight0804.SpringIntroduction.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;
import thelight0804.SpringIntroduction.domain.Member;

public class JPAMemberRepository implements MemberRepository{

  private final EntityManager em; //JPA가 EntityManager로 동작하기 위해서 필요한 객체

  public JPAMemberRepository(EntityManager em) {
    this.em = em;
  }

  @Override
  public Member save(Member member) {
    //entity 인스턴트를 관리하고 저장
    em.persist(member);
    return member;
  }

  @Override
  public Optional<Member> findById(Long id) {
    //Primary key 찾기
    Member member = em.find(Member.class, id);
    return Optional.ofNullable(member);
  }

  @Override
  public Optional<Member> findByName(String name) {
    //JPQL Query 생성
    List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
      .setParameter("name", name)
      .getResultList();
    return result.stream().findAny();
  }

  @Override
  public List<Member> findAll() {
    return em.createQuery("select m from Member", Member.class)
      .getResultList();
  }
}
