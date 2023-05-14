package com.sarita.ContactBook.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Data
public class ContactDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long contactId;
    private String firstName;
    private String lastName;
    private String contactNumber;
    @Column(unique = true)
    private String email;

}
