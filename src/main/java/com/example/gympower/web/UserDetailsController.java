package com.example.gympower.web;

import com.example.gympower.model.dto.DisplayUserDTO;
import com.example.gympower.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
public class UserDetailsController {

    private final UserService userService;

    public UserDetailsController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/users/user/details")
    public ResponseEntity<DisplayUserDTO> getUser(@RequestParam String email) {

        DisplayUserDTO userDetails = this.userService.getUserDetails(email);

        return ResponseEntity.ok(userDetails);
    }
}
