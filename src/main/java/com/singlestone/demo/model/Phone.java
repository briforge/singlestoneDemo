package com.singlestone.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Data
@Embeddable
@Entity
@Table(name = "phones")
public class Phone {

    public enum PhoneType {home, work, mobile};

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String number;
    @Enumerated(EnumType.STRING)
    private PhoneType type;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    private Contact contact;

    public Phone() {}

    public Phone(String number, PhoneType type) {
        this.number = number;
        this.type = type;
    }
}
