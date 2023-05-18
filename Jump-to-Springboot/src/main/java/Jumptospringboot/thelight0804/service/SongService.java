package Jumptospringboot.thelight0804.service;

import Jumptospringboot.thelight0804.domain.Song;
import Jumptospringboot.thelight0804.repository.SongRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service //프링부트에서 Service로 인식하는 어노테이션
public class SongService {

  private final SongRepository songRepository;

  public List<Song> getList() {
    return this.songRepository.findAll();
  }
}
