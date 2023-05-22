package Jumptospringboot.thelight0804.repository;

import Jumptospringboot.thelight0804.domain.Song;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Integer> {
  Song findByTitle(String title);
  Song findByTitleAndDetail(String title, String detail);
  List<Song> findByTitleLike(String title);
  Page<Song> findAll(Pageable pageable);
}