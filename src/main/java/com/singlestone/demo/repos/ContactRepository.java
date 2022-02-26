package com.singlestone.demo.repos;

import com.singlestone.demo.model.Contact;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Long> {

    Contact findById(long id);

    @Query("Select * from Contacts c where c.phone.type = 'home")
    List<Contact> getCallListAndSort(Sort sort);
}
