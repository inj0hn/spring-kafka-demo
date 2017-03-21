package com.vagrant;

import java.io.Serializable;

public class Person implements Serializable{
	private static final long serialVersionUID = 1L;

	private Gender gender;
	private String firstName;
	private String lastName;
	
	public Person(Gender gender, String firstName, String lastName) {
		this.gender = gender;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public Gender getGender() {
		return gender;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public enum Gender {
		MALE, FEMALE;
	}
	
	@Override
	public String toString() {
		return "Person [gender=" + gender + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
}
