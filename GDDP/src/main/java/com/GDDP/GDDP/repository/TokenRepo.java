package com.GDDP.GDDP.repository;

import java.util.Optional;

import com.GDDP.GDDP.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;
public interface TokenRepo extends JpaRepository<Token, Long> {

    Optional<Token> findByToken(String token);

}