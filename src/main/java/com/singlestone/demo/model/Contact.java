package com.singlestone.demo.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "contacts")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public Contact(String firstName, String lastName) {
        Name name = new Name(firstName, lastName);
        this.name = name;
    }

    public Contact() {}

    private Name name;
    private Address address;
    private Phone phone;
    private String email;
}
