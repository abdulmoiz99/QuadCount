package com.example.quadcount;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.example.quadcount.model")
public class QuadCountApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuadCountApplication.class, args);
    }

}
