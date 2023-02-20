package com.example.gympower.web;

import com.example.gympower.model.dto.logic.RegisterDTO;
import com.example.gympower.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
public class RegisterController {

    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users/register")
    public ResponseEntity<List<String>> registerUser(@RequestBody RegisterDTO registerDTO){

        List<String> authorities = this.userService.registerAndLogin(registerDTO);

        return ResponseEntity.ok(authorities);
    }
}
