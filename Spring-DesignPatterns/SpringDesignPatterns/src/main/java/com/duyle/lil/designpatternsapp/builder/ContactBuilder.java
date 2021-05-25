package com.duyle.lil.designpatternsapp.builder;

public class ContactBuilder {
    private String firstName;
    private String lastName;
    private String emailAddress;

    public ContactBuilder firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public ContactBuilder lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public ContactBuilder emailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    public Contact buildContact() {
        return new Contact(firstName, lastName, emailAddress);
    }
}
