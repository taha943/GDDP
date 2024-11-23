package com.GDDP.GDDP.repository;

import java.util.Optional;

import com.GDDP.GDDP.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepo extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}