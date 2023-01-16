package com.example.gympower.service;

import com.example.gympower.model.entity.UserEntity;
import com.example.gympower.model.entity.UserRole;
import com.example.gympower.model.entity.enums.UserRolesEnum;
import com.example.gympower.repository.UserRepository;
import com.example.gympower.repository.UserRoleRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final UserRoleRepository userRoleRepository;

    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, UserRoleRepository userRoleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void init() {
        UserRole adminRole = new UserRole().setRole(UserRolesEnum.ADMIN);
        UserRole moderatorRole = new UserRole().setRole(UserRolesEnum.MODERATOR);
        UserRole userRole = new UserRole().setRole(UserRolesEnum.USER);

        adminRole = this.userRoleRepository.save(adminRole);
        moderatorRole = this.userRoleRepository.save(moderatorRole);
        userRole = this.userRoleRepository.save(userRole);

        initAdmin(Set.of(adminRole, moderatorRole, userRole));
        initModerator(Set.of(moderatorRole, userRole));
        initUser(Set.of(userRole));
    }

    public void initUser(Set<UserRole> roles) {

        UserEntity user = new UserEntity()
                .setEmail("user_userov@gmail.com")
                .setPassword(this.passwordEncoder.encode("topsecret_user"))
                .setUsername("user123")
                .setFirstName("User")
                .setLastName("Userov")
                .setRoles(roles);

        this.userRepository.save(user);
    }

    public void initModerator(Set<UserRole> roles) {
        UserEntity moderator = new UserEntity()
                .setEmail("moderator_moderatorov@gmail.com")
                .setPassword(this.passwordEncoder.encode("topsecret_moderator"))
                .setUsername("moderator123")
                .setFirstName("Moderator")
                .setLastName("Moderatorov")
                .setRoles(roles);

        this.userRepository.save(moderator);

    }

    public void initAdmin(Set<UserRole> roles) {
        UserEntity admin = new UserEntity()
                .setEmail("admin_adminov@gmail.com")
                .setPassword(this.passwordEncoder.encode("topsecret_admin"))
                .setUsername("admin123")
                .setFirstName("Admin")
                .setLastName("Adminov")
                .setRoles(roles);

        this.userRepository.save(admin);

    }
}
