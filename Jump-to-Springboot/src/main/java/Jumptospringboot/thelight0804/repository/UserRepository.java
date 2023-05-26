package Jumptospringboot.thelight0804.repository;

import Jumptospringboot.thelight0804.domain.SiteUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<SiteUser, Long> {

}
