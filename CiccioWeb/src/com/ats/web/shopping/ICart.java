package com.ats.web.shopping;

import java.util.Collection;

public interface ICart {

	public abstract Collection<OrderLine> orderLines();

	public abstract void add(Product prod, int quantity);

	public abstract double total();

	public abstract boolean isEmpty();

}