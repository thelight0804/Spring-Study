package Jumptospringboot.thelight0804.service;

import Jumptospringboot.thelight0804.DataNotFoundException;
import Jumptospringboot.thelight0804.domain.Song;
import Jumptospringboot.thelight0804.repository.SongRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service //스프링부트에서 Service로 인식하는 어노테이션
public class SongService {

  private final SongRepository songRepository;

  public List<Song> getList() {
    return this.songRepository.findAll();
  }

  public Song getSong(Integer id){
    Optional<Song> song = this.songRepository.findById(id);
    if (song.isPresent()) {
      return song.get();
    }
    else{
      throw new DataNotFoundException("DataNotFoundException: song not found");
    }
  }

  public void create(String title, String detail) {
    Song s = new Song(); //객체 생성
    s.setTitle(title); //set 제목
    s.setDetail(detail); //set 내용
    s.setCreateDate(LocalDateTime.now()); //set 시간
    this.songRepository.save(s); //Repository에 넘김
  }
}