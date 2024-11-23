package com.GDDP.GDDP.repository;

import java.util.Optional;

import com.GDDP.GDDP.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
public interface RoleRepo  extends JpaRepository<Role, Integer>{

    Optional<Role> findByName(String roleName);
}