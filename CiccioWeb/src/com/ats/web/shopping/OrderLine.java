package com.ats.web.shopping;

public class OrderLine {
	private Product product;
	private int quantity;

	public OrderLine(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
		
		
	}
	public double getPrice() {
		return product.getPrice() * quantity;
	}
	public Product getProduct() {
		return product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void addQuantity(int quantity) {
		this.quantity+=quantity;
		
	}
}
