package com.singlestone.demo.repos;

import com.singlestone.demo.model.Contact;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Long> {

//    Contact findById(long id);

    @Query(value = "Select * from Contacts c where c.phone_type = 'home' ORDER BY last_name, first_name ", nativeQuery = true)
    List<Contact> getCallList();

}
