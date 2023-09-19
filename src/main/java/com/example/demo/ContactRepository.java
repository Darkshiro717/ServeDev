package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public interface ContactRepository {
    List<Contact> findAll();

    void save(Contact contact);

    void clear();
}
