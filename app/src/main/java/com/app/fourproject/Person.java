package com.app.fourproject;

public class Person {
    String name;
    String phone;
    String address;

    public Person(String name, String phone, String address) {
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return name;
    }
}
