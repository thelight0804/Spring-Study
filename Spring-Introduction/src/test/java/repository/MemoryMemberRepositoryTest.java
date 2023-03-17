//MemoryMemberRepository 테스트 코드

package repository;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import thelight0804.SpringIntroduction.domain.Member;
import thelight0804.SpringIntroduction.repository.MemoryMemberRepository;

public class MemoryMemberRepositoryTest {
  MemoryMemberRepository repository = new MemoryMemberRepository();

  /**
   * 테스트 종료 시 repository 비우기
   */
  @AfterEach
  public void afterEach(){
    repository.clearStore();
  }

  @Test
  public void save(){
    Member member = new Member(); //Member 객체 생성
    member.setName("thelight0804"); //Name 세팅

    repository.save(member); //Member 저장

    Member result = repository.findById(member.getId()).get(); //repository에서 가져온 값
//    System.out.println("result  = " + (result == member)); //repository 저장값과 Member 객체 값 비교
//    Assertions.assertEquals(member, null);
    assertThat(member).isEqualTo(result);

  }

  @Test
  public void findByName(){
    //member1 객체 생성
    Member member1 = new Member();
    member1.setName("member1");
    repository.save(member1);

    //member2 객체 생성
    Member member2 = new Member();
    member2.setName("member2");
    repository.save(member2);

    Member result = repository.findByName("member1").get();
    assertThat(result).isEqualTo(member1); //같은 값인지 확인
  }

  @Test
  public void findAll(){
    //member1 객체 생성
    Member member1 = new Member();
    member1.setName("member1");
    repository.save(member1);

    //member2 객체 생성
    Member member2 = new Member();
    member2.setName("member2");
    repository.save(member2);
    
    //테스트
    List<Member> result = repository.findAll();
    assertThat(result.size()).isEqualTo(2); //저장 사이즈로 비교
  }

}
