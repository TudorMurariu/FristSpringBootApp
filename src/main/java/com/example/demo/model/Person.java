package com.example.demo.model;

import java.util.UUID;

public class Person {

    private UUID ID;

    private String name;

    public Person(UUID ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public UUID getID() {
        return ID;
    }

    public String getName() {
        return name;
    }
}
