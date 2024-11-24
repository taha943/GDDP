package com.GDDP.GDDP.services;

import com.GDDP.GDDP.entity.User;
import com.GDDP.GDDP.payload.RegistrationRequest;
import com.GDDP.GDDP.repository.RoleRepo;
import com.GDDP.GDDP.repository.UserRepo;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final RoleRepo roleRepo;

    private final UserRepo userRepo;

    private final PasswordEncoder passwordEncoder;

    public void register(RegistrationRequest registrationRequest) {


        var userRole = roleRepo.findByName("USER")
                .orElseThrow(() -> new IllegalStateException("Role User was not initilaized"));

        var user = User.builder()
                .firstName(registrationRequest.getFirstName())
                .lastName(registrationRequest.getLastName())
                .email(registrationRequest.getEmail())
                .password(passwordEncoder.encode(registrationRequest.getPassword()))
                .accountLocked(false)
                .enabled(false)
                .roles(List.of(userRole))
                .createdDate(LocalDateTime.now())
                .build();
        userRepo.save(user);

    }
}