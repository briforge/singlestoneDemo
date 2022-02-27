package com.singlestone.demo.controllers;

import com.singlestone.demo.exceptions.ContactNotFoundException;
import com.singlestone.demo.model.CallListContact;
import com.singlestone.demo.model.Contact;
import com.singlestone.demo.repos.ContactRepository;
import com.singlestone.demo.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContactController {

    @Autowired
    private ContactRepository repository;

    @Autowired
    private ContactService contactService;

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
        return contactService.updateContact(newContact, id);
    }

    @DeleteMapping("/contacts/{id}")
    void deleteContact(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @GetMapping("/contacts/call-list")
    List<CallListContact> getCallList() {
        return contactService.getCallList();
    }
}
