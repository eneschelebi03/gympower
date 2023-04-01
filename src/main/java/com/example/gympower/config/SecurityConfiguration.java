package com.example.gympower.config;

import com.example.gympower.model.entity.enums.UserRolesEnum;
import com.example.gympower.repository.UserRepository;
import com.example.gympower.service.AppUserDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableMethodSecurity
public class SecurityConfiguration {

    private final UserDetailsService userDetailsService;

    public SecurityConfiguration(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new Pbkdf2PasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/products/**", "/users/user").permitAll()
                .antMatchers("/offers/carousel", "/users/auth/login", "/users/register",
                        "/cart/addProduct", "/cart/products", "/cart/removeProduct", "/order/new",
                        "/order/current/products", "/users/user/details",
                        "/admin-panel/recent/finances", "/admin-panel/recent/orders",
                        "/admin-panel/all/customers", "/admin-panel/all/orders", "/admin-panel/all/products").permitAll()
                .anyRequest().authenticated()
                .and()
                .logout()
                .logoutUrl("/users/logout")
                .logoutSuccessUrl("https://gympower.onrender.com")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID");

        return httpSecurity.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

}
