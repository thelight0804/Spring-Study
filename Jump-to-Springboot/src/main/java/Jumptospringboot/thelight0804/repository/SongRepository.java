package Jumptospringboot.thelight0804.repository;

import Jumptospringboot.thelight0804.domain.Song;
import java.util.List;
import org.aspectj.weaver.patterns.TypePatternQuestions.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SongRepository extends JpaRepository<Song, Integer> {
  Song findByTitle(String title);
  Song findByTitleAndDetail(String title, String detail);
  List<Song> findByTitleLike(String title);
  Page<Song> findAll(Pageable pageable);
  Page<Song> findAll(Specification<Song> spec, Pageable pageable);

  //Query
  @Query("select "
    + "distinct q "
    + "from Song q "
    + "left outer join SiteUser u1 on q.author=u1 "
    + "left outer join Comment a on a.song=q "
    + "left outer join SiteUser u2 on a.author=u2 "
    + "where "
    + "   q.title like %:kw% "
    + "   or q.detail like %:kw% "
    + "   or u1.username like %:kw% "
    + "   or a.content like %:kw% "
    + "   or u2.username like %:kw% ")
  Page<Song> findAllByKeyword(@Param("kw") String kw, Pageable pageable);
}