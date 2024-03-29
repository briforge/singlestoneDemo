package com.singlestone.demo.exceptions;

public class ContactNotFoundException extends RuntimeException {

    public ContactNotFoundException(Long id) {
        super("Could not find contact " + id);
    }
}
