package com.example.gympower.config;

import com.example.gympower.model.entity.enums.UserRolesEnum;
import com.example.gympower.repository.UserRepository;
import com.example.gympower.service.AppUserDetailService;
import org.springframework.boot.autoconfigure.security.StaticResourceLocation;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfiguration {


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new Pbkdf2PasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeHttpRequests()
                .antMatchers("/carousel", "/topSupps", "/topWear", "/wear/all", "/wear/{id}/details", "/wear/{id}/related/").permitAll()
                .antMatchers("/pages/moderators").hasRole(UserRolesEnum.MODERATOR.name())
                .antMatchers("/pages/admins").hasRole(UserRolesEnum.ADMIN.name())
                .anyRequest().authenticated()

                .and()
                .formLogin()
                .loginPage("http://127.0.0.1:5500/html/login.html")
                .usernameParameter(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY)
                .passwordParameter(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_PASSWORD_KEY)
                .defaultSuccessUrl("http://127.0.0.1:5500/html/index.html")
                .failureForwardUrl("ttp://127.0.0.1:5500/html/login-error.html")

                .and()
                .logout()
                .logoutUrl("/users/logout")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID");

        return httpSecurity.build();
    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository) {
        return new AppUserDetailService(userRepository);
    }

}
