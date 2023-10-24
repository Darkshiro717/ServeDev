package com.example.contact.data;

import com.example.contact.Contact;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("mongoContactRepository")
public interface ContactRepository extends MongoRepository<Contact, String> {
    // ...
}


