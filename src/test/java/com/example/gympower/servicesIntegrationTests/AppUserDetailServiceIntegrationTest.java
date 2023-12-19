package com.example.gympower.servicesIntegrationTests;

import com.example.gympower.model.entity.UserEntity;
import com.example.gympower.model.entity.UserRole;
import com.example.gympower.model.entity.enums.UserRolesEnum;
import com.example.gympower.repository.UserRepository;
import com.example.gympower.service.AppUserDetailService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class AppUserDetailServiceIntegrationTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private AppUserDetailService appUserDetailService;

    @Test
    public void testLoadUserByUsername() {
        // Arrange
        String username = "testUser";
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(username);
        userEntity.setPassword("password");
        userEntity.setRoles(Collections.singleton(new UserRole().setRole(UserRolesEnum.USER)));

        when(userRepository.findByEmailOrUsername(username, username)).thenReturn(Optional.of(userEntity));

        // Act
        UserDetails userDetails = appUserDetailService.loadUserByUsername(username);

        // Assert
        assertEquals(username, userDetails.getUsername());
        assertEquals("password", userDetails.getPassword());
        assertEquals(1, userDetails.getAuthorities().size());
        assertEquals("ROLE_USER", userDetails.getAuthorities().iterator().next().getAuthority());

        // Verify that the repository method was called
        Mockito.verify(userRepository, Mockito.times(1)).findByEmailOrUsername(username, username);
    }

    @Test
    public void testLoadUserByUsername_UserNotFound() {
        // Arrange
        String nonExistingUsername = "nonExistingUser";
        when(userRepository.findByEmailOrUsername(nonExistingUsername, nonExistingUsername)).thenReturn(Optional.empty());

        // Act and Assert
        UsernameNotFoundException exception = org.junit.jupiter.api.Assertions.assertThrows(
                UsernameNotFoundException.class,
                () -> appUserDetailService.loadUserByUsername(nonExistingUsername)
        );

        assertEquals("User with email or username" + nonExistingUsername + " not found!", exception.getMessage());

        // Verify that the repository method was called
        Mockito.verify(userRepository, Mockito.times(1)).findByEmailOrUsername(nonExistingUsername, nonExistingUsername);
    }
}
