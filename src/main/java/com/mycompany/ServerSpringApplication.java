package com.mycompany;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.RemovalNotification;
import com.mycompany.resurse.Lease;
import com.mycompany.service.LeaseService;
import java.util.concurrent.TimeUnit;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication

public class ServerSpringApplication { 
    
    
    public static Cache<Integer,Integer> cache = CacheBuilder.newBuilder()
                .removalListener((RemovalNotification<Integer, Integer> notification) -> {
                    System.out.println(".onRemoval()");
                })
                .expireAfterWrite(1, TimeUnit.MINUTES)
                .build();
    public static Cache<Integer,Lease> cacheLease = CacheBuilder.newBuilder()
                .removalListener((RemovalNotification<Integer, Lease> notification) -> {
                    System.out.println(".onRemoval()");
                })
                .expireAfterWrite(3, TimeUnit.HOURS)
                .build();
	
    
    public static void main(String[] args) {
      SpringApplication.run(ServerSpringApplication.class, args);
    }  
    
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
    
        
}
