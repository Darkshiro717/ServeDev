package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ContactService {
    List<Contact> getAll();

    void add(Contact contact);
}
