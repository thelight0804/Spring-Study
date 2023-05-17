package Jumptospringboot.thelight0804;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import Jumptospringboot.thelight0804.domain.Comment;
import Jumptospringboot.thelight0804.domain.Song;
import Jumptospringboot.thelight0804.repository.CommentRepository;
import Jumptospringboot.thelight0804.repository.SongRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class Thelight0804ApplicationTests {

  @Autowired
  private SongRepository songRepository;

  ////Test Song

  //save Song
  /*@Test
  void testJpa() {
    //첫번째 곡 저장
    Song s1 = new Song(); //Song 객체 생성
    //객체 데이터 저장
    s1.setTitle("I AM");
    s1.setDetail("IVE");
    s1.setCreateDate(LocalDateTime.now());
    //Repository를 통해 DB 저장
    this.songRepository.save(s1);

    //두번째 곡 저장
    Song s2 = new Song();
    s2.setTitle("손오공");
    s2.setDetail("세븐틴");
    s2.setCreateDate(LocalDateTime.now());
    this.songRepository.save(s2);

    //두번째 곡 저장
    Song s3 = new Song();
    s3.setTitle("Ditto");
    s3.setDetail("NewJeans");
    s3.setCreateDate(LocalDateTime.now());
    this.songRepository.save(s3);
  }*/

  //findAll
  /*@Test
  void testJpa(){
    List<Song> all = this.songRepository.findAll();
    //개수 체크
    assertEquals(2, all.size());

    Song s = all.get(0);
    //개수 체크
    assertEquals("三日月の舞", s.getTitle());
  }*/

  //findById
  /*@Test
  void testJpa(){
    //id 값 조회
    Optional<Song> os = this.songRepository.findById(1);
    //null 확인
    if (os.isPresent()){
      Song s = os.get();
      //title 확인
      assertEquals("三日月の舞", s.getTitle());
    }
  }*/

  //findByTitle
  /*@Test
  void testJpa(){
    Song s = this.songRepository.findByTitle("三日月の舞");
    assertEquals(5, s.getId());
  }*/

  //findByTitleAndDetail
  /*@Test
  void testJpa(){
    Song s = this.songRepository.findByTitleAndDetail("三日月の舞", "발매: 2015년 7월 8일");
    assertEquals(5, s.getId());
  }*/

  //findBySongLike
  /*@Test
  void testJpa(){
    List<Song> songList = this.songRepository.findBySongLike("三日%");
    Song s = songList.get(0);
    assertEquals("三日月の舞", s.getTitle());
  }*/

  //update title
  /*@Test
  void testJpa(){
    Optional<Song> os = this.songRepository.findById(5);
    assertTrue(os.isPresent());
    Song s = os.get();
    s.setTitle("Dream Solister");
    this.songRepository.save(s);
  }*/

  //delete song data
  /*@Test
  void testJpa(){
    assertEquals(2, this.songRepository.count());
    Optional<Song> os = this.songRepository.findById(5);
    assertTrue(os.isPresent());
    Song s = os.get();
    this.songRepository.delete(s);
    assertEquals(1, this.songRepository.count());
  }*/



  ////Test Comment

  @Autowired
  private CommentRepository commentRepository;

  //Create comment
  /*@Test
  void testJpa(){
    Optional<Song> os = this.songRepository.findById(2);
    assertTrue(os.isPresent());
    Song s = os.get();

    Comment c = new Comment();
    c.setContent("갓띵곡");
    c.setSong(s);
    c.setCreateDate(LocalDateTime.now());
    this.commentRepository.save(c);
  }*/

  //get comment
  /*@Test
  void testJpa(){
    Optional<Comment> oc = this.commentRepository.findById(1);
    assertTrue(oc.isPresent());
    Comment c = oc.get();
    assertEquals(6, c.getSong().getId());
  }*/

  //Comment ID by Song
  /*@Transactional
  @Test
  void testJpa(){
    Optional<Song> os = this.songRepository.findById(6);
    assertTrue(os.isPresent());
    Song s = os.get();

    List<Comment> commentList = s.getCommentList();

    assertEquals(1, commentList.size());
    assertEquals("갓띵곡", commentList.get(0).getContent());
  }*/
}
