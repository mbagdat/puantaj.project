package com.puantaj.project.config;

import com.puantaj.project.models.ERole;
import com.puantaj.project.models.Role;
import com.puantaj.project.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitializer implements CommandLineRunner {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public void run(String... args) {
        initializeRoles();
    }

    private void initializeRoles() {
        if (roleRepository.findByName(ERole.ROLE_USER).isEmpty()) {
            Role userRole = new Role();
            userRole.setName(ERole.ROLE_USER);
            userRole.setDescription("User role description");
            roleRepository.save(userRole);
        }

        if (roleRepository.findByName(ERole.ROLE_MODERATOR).isEmpty()) {
            Role moderatorRole = new Role();
            moderatorRole.setName(ERole.ROLE_MODERATOR);
            moderatorRole.setDescription("Moderator role description");
            roleRepository.save(moderatorRole);
        }

        if (roleRepository.findByName(ERole.ROLE_ADMIN).isEmpty()) {
            Role adminRole = new Role();
            adminRole.setName(ERole.ROLE_ADMIN);
            adminRole.setDescription("Admin role description");
            roleRepository.save(adminRole);
        }



    }
}
