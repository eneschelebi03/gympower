package com.example.gympower.web;

import com.example.gympower.model.dto.logic.LoginDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class AuthController {

//    private final AppUserDetailService userDetailsService;

    private final AuthenticationManager authenticationManager;

    public AuthController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/users/auth/login")
    public ResponseEntity<List<String>> authenticateUser(@RequestBody LoginDTO loginDto){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUsername(), loginDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new ResponseEntity<>(authentication.getAuthorities().stream()
                .map(Object::toString)
                .toList(), HttpStatus.OK);
    }

    @GetMapping("/users/user")
    public ResponseEntity<List<String>> getUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        List<String> authorities = authentication.getAuthorities().stream()
                .map(Object::toString)
                .toList();

        return ResponseEntity.ok(authorities);
    }
}
