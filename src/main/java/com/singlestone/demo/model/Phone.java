package com.singlestone.demo.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@Embeddable
public class Phone {

    public enum PhoneType {home, work, mobile};

    @Column(name = "phoneNumber")
    private String number;
    @Column(name = "phoneType")
    @Enumerated(EnumType.STRING)
    private PhoneType type;

    public Phone() {}

    public Phone(String number, PhoneType type) {
        this.number = number;
        this.type = type;
    }
}
