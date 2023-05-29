package Jumptospringboot.thelight0804.repository;

import Jumptospringboot.thelight0804.domain.SiteUser;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<SiteUser, Long> {
  Optional<SiteUser> findByusername(String username);
}
