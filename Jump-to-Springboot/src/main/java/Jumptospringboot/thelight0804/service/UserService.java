package Jumptospringboot.thelight0804.service;

import Jumptospringboot.thelight0804.domain.SiteUser;
import Jumptospringboot.thelight0804.repository.UserRepository;
import lombok.RequiredArgsConstructor;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

  private final UserRepository userRepository; //Repository 객체 선언
  private final PasswordEncoder passwordEncoder; //BCryptPasswordEncoder

  public SiteUser create(String username, String email, String password) {
    SiteUser user = new SiteUser(); //user 객체 생성
    user.setUsername(username); //name 설정
    user.setEmail(email); //email 설정
    //비밀번호 암호화
    //BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    user.setPassword(passwordEncoder.encode(password)); //비밀번호 설정
    this.userRepository.save(user); //Repo -> DB 저장
    return user;
  }
}
