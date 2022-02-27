package com.singlestone.demo.service;

import com.singlestone.demo.exceptions.ContactNotFoundException;
import com.singlestone.demo.model.CallListContact;
import com.singlestone.demo.model.Contact;
import com.singlestone.demo.repos.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactService {

    @Autowired
    ContactRepository repository;

    public List<CallListContact> getCallList() {
        return repository.getCallList().stream().map(contact -> new CallListContact(contact.getName(), contact.getPhone().getNumber())).collect(Collectors.toList());
    }

    public Contact updateContact(Contact newContact, Long id) throws ContactNotFoundException {
        return repository.findById(id)
                .map(contact -> {
                    contact.getName().setFirst(newContact.getName().getFirst() );
                    contact.getName().setLast(newContact.getName().getLast() );
                    contact.getName().setMiddle(newContact.getName().getMiddle() );
                    if(contact.getAddress() == null) {
                        contact.setAddress(newContact.getAddress());
                    } else {
                        if(newContact.getAddress() == null) {
                            contact.setAddress(null);
                        } else {
                            contact.getAddress().setStreet(newContact.getAddress().getStreet());
                            contact.getAddress().setCity(newContact.getAddress().getCity());
                            contact.getAddress().setState(newContact.getAddress().getState());
                            contact.getAddress().setZip(newContact.getAddress().getZip());
                        }
                    }
                    if(contact.getPhone() == null) {
                        contact.setPhone(newContact.getPhone());
                    } else {
                        if(newContact.getPhone() == null) {
                            contact.setPhone(null);
                        } else {
                            contact.getPhone().setNumber(newContact.getPhone().getNumber());
                            contact.getPhone().setType(newContact.getPhone().getType());
                        }
                    }
                    contact.setEmail(newContact.getEmail());
                    return repository.save(contact);
                })
                .orElseThrow(() -> new ContactNotFoundException(id));
    }
}
