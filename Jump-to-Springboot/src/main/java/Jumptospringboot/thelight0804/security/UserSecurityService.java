package Jumptospringboot.thelight0804.security;

import Jumptospringboot.thelight0804.domain.SiteUser;
import Jumptospringboot.thelight0804.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserSecurityService implements UserDetailsService {

  private final UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
    /**
     * username으로 password를 조회한다
     */
    //username 조회
    Optional<SiteUser> _siteUser = this.userRepository.findByusername(username);
    if (_siteUser.isEmpty()){ //username이 데이터에 없는 경우
      throw new UsernameNotFoundException("사용자를 찾을 수 없습니다");
    }
    SiteUser siteUser = _siteUser.get();
    List<GrantedAuthority> authorities = new ArrayList<>();
    if ("admin".equals(username)) { //adming 권한 부여
      authorities.add(new SimpleGrantedAuthority(UserRole.ADMIN.getValue()));
    } else { //user 권한 부여
      authorities.add(new SimpleGrantedAuthority(UserRole.USER.getValue()));
    }
    //username, password를 가지고 user 객체 생성
    return new User(siteUser.getUsername(), siteUser.getPassword(), authorities);
  }
}
