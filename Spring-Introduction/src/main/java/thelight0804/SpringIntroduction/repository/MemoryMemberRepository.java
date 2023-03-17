package thelight0804.SpringIntroduction.repository;

import java.util.*;
import thelight0804.SpringIntroduction.domain.Member;

public class MemoryMemberRepository implements MemberRepository {

  private static Map<Long, Member> store = new HashMap<>();
  private static long sequence = 0L; //key값


  /**
   * 회원 생성
   *
   * @param member
   * @return member
   */
  @Override
  public Member save(Member member) {
    member.setId(++sequence);
    store.put(member.getId(), member);
    return member;
  }

  /**
   * id 찾기
   *
   * @param id
   * @return Optional.ofNullable()
   */
  @Override
  public Optional<Member> findById(Long id) {
    return Optional.ofNullable(store.get(id));
  }

  /**
   * 이름 찾기
   *
   * @param name
   * @return store.filter().findAny()
   */
  @Override
  public Optional<Member> findByName(String name) {
    return store.values().stream()
        .filter(member -> member.getName().equals(name))
        .findAny();
  }

  /**
   * 회원 목록 전부 출력
   *
   * @return 회원 목록
   */
  @Override
  public List<Member> findAll() {
    return new ArrayList<>(store.values());
  }

  /**
   * store 초기화
   */
  public void clearStore(){
    store.clear();
  }
}
