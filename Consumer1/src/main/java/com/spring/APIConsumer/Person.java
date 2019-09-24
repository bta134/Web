package com.spring.APIConsumer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Person{

    private Long id;
    private String firstName;
    private String lastName;

    public Person() {
    }

    public Person(String f, String l) {
	this.firstName=f;
	this.lastName=l;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long i) {
        this.id = i;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String f) {
        this.firstName = f;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String l) {
        this.lastName = l;
    }

    @Override
    public String toString() {
        return "Person{" +
                "Id='" + id + '\'' +
                ", firstName=" + firstName +
		", lastName=" + lastName +
                '}';
    }
}