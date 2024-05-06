package com.blockarch.blockarch.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;

    private String lastName;

    private String emailAddress;

    private String password;

    private String phoneNumber;

    private String accountType;

    private String companyName;

    private String jobRole;

    private Integer companySize;

    public Users() {
    }

    public Users(Long id,
                 String firstName,
                 String lastName,
                 String emailAddress,
                 String password,
                 String phoneNumber,
                 String accountType,
                 String companyName,
                 String jobRole,
                 Integer companySize) {

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.accountType = accountType;
        this.companyName = companyName;
        this.jobRole = jobRole;
        this.companySize = companySize;
    }
}
