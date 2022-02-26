package com.singlestone.demo.model;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class Phone {

    public enum PhoneType {home, work, mobile};

    private String number;
    private PhoneType type;

    public Phone() {}

    public Phone(String number, PhoneType type) {
        this.number = number;
        this.type = type;
    }
}
