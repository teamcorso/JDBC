package com.ats.web.shopping;

public class Product {

	private String name;
    private double price;
    
    public Product(String name) {
		this.name = name;
		switch (name) {
		case "Bambola Gonfiabile":
			price = 50.0;
			break;
		case "Carro Armato":
			price = 1000.0;
			break;
		case "Libro Java":
			price = 30.0;
			break;
		case "Scettro del Potere":
			price = 10000.0;
			break;
		default:
			price = 1.0;
			break;
		}
	}
	public double getPrice() {
		return price;
	}
	public String getName() {
		return name;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
