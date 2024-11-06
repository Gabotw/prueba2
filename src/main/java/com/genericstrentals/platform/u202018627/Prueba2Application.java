package com.genericstrentals.platform.u202018627;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Prueba2Application {

    public static void main(String[] args) {
        SpringApplication.run(Prueba2Application.class, args);
    }

}
