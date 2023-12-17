package com.example.gympower;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class GympowerApplication {

    public static void main(String[] args) {
        SpringApplication.run(GympowerApplication.class, args);
    }

}
