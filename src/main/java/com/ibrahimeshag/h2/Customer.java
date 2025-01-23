package com.ibrahimeshag.h2;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Customer {
    @Id
    @GeneratedValue(generator = "system-uuid")
    private String id;
    private String name;
    private String email;
    private String phone;

}
