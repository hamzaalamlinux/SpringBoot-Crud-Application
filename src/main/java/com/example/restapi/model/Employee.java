package com.example.restapi.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "firstname" , nullable = false)
    private  String firstname;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "email" )
    private  String email;

}
