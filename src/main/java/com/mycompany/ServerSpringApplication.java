package com.mycompany;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication

public class ServerSpringApplication { 
    public static void main(String[] args) {
	SpringApplication.run(ServerSpringApplication.class, args);
        System.out.println(new BCryptPasswordEncoder().encode("admin"));
    }
    
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
    
        
}
