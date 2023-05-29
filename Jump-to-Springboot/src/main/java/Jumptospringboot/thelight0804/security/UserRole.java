//User 권한

package Jumptospringboot.thelight0804.security;

import lombok.Getter;

@Getter
public enum UserRole {
  ADMIN("ROLE_ADMIN"), //관리자
  USER("ROLE_USER"); //일반 유저

  UserRole(String value) {
    this.value = value;
  }

  private String value;
}
