package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class ContactConfigAOP {

    @Bean
    public ContactAOP contactAOP(){
        ContactAOP contactAOP = new ContactAOP();
        contactAOP.addContacts();
        return contactAOP;
    }

    @Bean
    public ContactRepository contactRepository(){
        return new ContactRepositoryImpl();
    }

    @Bean
    public ContactService contactService(){
        return new ContactServiceImpl();
    }
}
