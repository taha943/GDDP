package com.GDDP.GDDP;

import com.GDDP.GDDP.entity.Role;
import com.GDDP.GDDP.repository.RoleRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class GddpApplication {

	public static void main(String[] args) {
		SpringApplication.run(GddpApplication.class, args);
	}

	// Add role initialization as a CommandLineRunner bean
	@Bean
	public CommandLineRunner initializeRoles(RoleRepo roleRepository) {
		return args -> {
			String[] roles = {"USER", "ADMIN"};

			for (String roleName : roles) {
				roleRepository.findByName(roleName).orElseGet(() -> {
					Role role = new Role();
					role.setName(roleName);
					role.setCreatedDate(LocalDateTime.now());
					return roleRepository.save(role);
				});
			}
		};
	}
}
