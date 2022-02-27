package com.singlestone.demo.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@Embeddable
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Name {

    @Column(name = "firstName")
    private String first;
    @Column(name = "middleName")
    private String middle;
    @Column(name = "lastName")
    private String last;

    public Name(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public Name() {}
}
