package com.example.accessingdatajpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String firstName;
	private String lastName;
	
	// The default constructor exists only for the sake of JPA.
	// Therefore we can mark it as protected so that other classes don't accidently use it.
	protected Customer() {}
	
	public Customer(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	@Override
    public String toString() {
       return String.format(
         "Customer[id=%d, firstName='%s', lastName='%s']",
         id, firstName, lastName);
    }
	
	public Long getId() {
	  return id;
	}
	
	public String getFirstName() {
	  return firstName;
	}
	
	public String getLastName() {
	  return lastName;
	}

}
