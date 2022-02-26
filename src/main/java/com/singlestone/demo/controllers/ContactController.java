package com.singlestone.demo.controllers;

import com.singlestone.demo.exceptions.ContactNotFoundException;
import com.singlestone.demo.model.Contact;
import com.singlestone.demo.repos.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContactController {

    @Autowired
    private ContactRepository repository;

    @GetMapping("/contacts")
    public List<Contact> all() {
        return repository.findAll();
    }

    @PostMapping("/contacts")
    Contact newContact(@RequestBody Contact newContact) {
        return repository.save(newContact);
    }

    @GetMapping("/contacts/{id}")
    Contact one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new ContactNotFoundException(id));
    }

    @PutMapping("/contacts/{id}")
    Contact updateContact(@RequestBody Contact newContact, @PathVariable Long id) {

        return repository.findById(id)
                .map(employee -> {
                    employee.getName().setFirst( newContact.getName().getFirst() );
                    employee.getName().setLast( newContact.getName().getLast() );
                    return repository.save(employee);
                })
                .orElseGet(() -> {
                    newContact.setId(id);
                    return repository.save(newContact);
                });
    }

    @DeleteMapping("/contacts/{id}")
    void deleteContact(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
