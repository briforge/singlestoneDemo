package com.singlestone.demo.service;

import com.singlestone.demo.exceptions.ContactNotFoundException;
import com.singlestone.demo.model.CallListContact;
import com.singlestone.demo.model.Contact;
import com.singlestone.demo.repos.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactService {

    @Autowired
    ContactRepository repository;

    @Autowired
    PhoneService phoneService;

    public List<CallListContact> getCallList() {
        Comparator<CallListContact> lastNameComparator = (c1, c2) -> c1.getName().getLast().compareTo(c2.getName().getLast());
        Comparator<CallListContact> firstNameComparator = (c1, c2) -> c1.getName().getFirst().compareTo(c2.getName().getFirst());

        return phoneService.getHomePhones().stream()
                .map(phone -> new CallListContact(phone.getContact().getName(), phone.getNumber()))
                .sorted(lastNameComparator.thenComparing(firstNameComparator))
                .collect(Collectors.toList());
    }

    public Contact updateContact(Contact newContact, Long id) throws ContactNotFoundException {
        return repository.findById(id)
                .map(contact -> {
                    contact.getName().setFirst(newContact.getName().getFirst() );
                    contact.getName().setLast(newContact.getName().getLast() );
                    contact.getName().setMiddle(newContact.getName().getMiddle() );
                    contact.setAddress(newContact.getAddress());

                    // have to do this because of some black box magic behind @OneToMany
                    contact.getPhones().clear();
                    contact.getPhones().addAll(newContact.getPhones());
                    contact.getPhones().forEach(phone -> {
                        phone.setContact(contact);
                    });

                    contact.setEmail(newContact.getEmail());
                    return repository.save(contact);
                })
                .orElseThrow(() -> new ContactNotFoundException(id));
    }
}
