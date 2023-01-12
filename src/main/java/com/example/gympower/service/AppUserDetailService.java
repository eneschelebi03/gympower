package com.example.gympower.service;

import com.example.gympower.model.entity.UserRole;
import com.example.gympower.model.entity.UserEntity;
import com.example.gympower.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

// NOTE: Not annotated as service cuz it is returned as bean
public class AppUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    public AppUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return this.userRepository.findByUsername(username)
                .map(this::map)
                .orElseThrow(() -> new UsernameNotFoundException("User with username " + username + " not found!"));

    }

    private UserDetails map(UserEntity userEntity) {
        UserDetails result = User.builder()
                .username(userEntity.getUsername())
                .password(userEntity.getPassword())
                .authorities(userEntity.getRoles().stream()
                        .map(this::mapRole)
                        .toList())
                .build();

        return result;
    }

    private GrantedAuthority mapRole(UserRole userRole) {
        return new SimpleGrantedAuthority("ROLE_" + userRole.getRole().name());
    }
}

