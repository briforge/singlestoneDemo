package com.singlestone.demo.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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

    @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonProperty("phone")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Phone> phones = new HashSet<>();

    private String email;

    public void addPhone(Phone phone) {
        phones.add(phone);
        phone.setContact(this);
    }
    public void removePhone(Phone phone) {
        phones.remove(phone);
        phone.setContact(null);
    }
}
