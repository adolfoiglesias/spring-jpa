package com.calarix.data.jpa.projection.classes;

import lombok.Data;

@Data
public class PersonDTO {

    private String firstName;
    private String lastName;

    public PersonDTO(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
