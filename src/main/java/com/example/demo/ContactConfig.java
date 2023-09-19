package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContactConfig {
    @Bean
    public ContactService contactService(){
        return new ContactServiceImpl();
    }

    @Bean
    public ContactRepository contactRepository(){
        return new ContactRepositoryImpl();
    }
}
