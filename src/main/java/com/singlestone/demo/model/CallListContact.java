package com.singlestone.demo.model;

import lombok.Data;

import javax.persistence.Column;

@Data
public class CallListContact {
    private Name name;
    private String phone;

    public CallListContact() {}

    public CallListContact(Name name, String phone) {
        this.name = name;
        this.phone = phone;
    }
}
