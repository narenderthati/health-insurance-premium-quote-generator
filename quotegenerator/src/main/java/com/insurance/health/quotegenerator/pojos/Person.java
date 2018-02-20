package com.insurance.health.quotegenerator.pojos;

public class Person {
	private String fullName;
	
	private String gender;
	
	private int age;

	/**
	 * Person Constructor
	 * @param fullName
	 * @param gender
	 * @param age
	 */
	public Person(String fullName, String gender, int age) {
		super();
		this.fullName = fullName;
		this.gender = gender;
		this.age = age;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "PreHealthConditions [fullName=" + fullName + ", gender=" + gender + ", age=" + age + "]";
	}
}
