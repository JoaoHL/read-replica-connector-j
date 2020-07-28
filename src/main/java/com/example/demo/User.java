package com.example.demo;

import javax.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public Long getId(){
        return id;
    }

    public String getName(){
        return name;
    }
}
