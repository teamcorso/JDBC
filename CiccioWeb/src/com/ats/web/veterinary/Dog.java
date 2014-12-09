package com.ats.web.veterinary;

public class Dog {
	private String name;
	private String color;
	private int age;
	private String owner;

	public String getOwner() {
		System.out.println("getOwner");
		return owner;
	}

	public void setOwner(String owner) {
	     System.out.println("setOwner " + owner);
		this.owner = owner;
	}

	private String breed;

	public String getName() {
		System.out.println("getName");
		return name;
	}

	public void setName(String name) {
		System.out.println("setName " + name);
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}
}
