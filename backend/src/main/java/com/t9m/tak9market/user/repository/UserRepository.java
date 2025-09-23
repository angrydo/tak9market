package com.t9m.tak9market.user.repository;

import com.t9m.tak9market.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    boolean existsByUsername(String username);      // id 중복체크
    boolean existsByEmail(String email);            // email 중복체크
}
