package com.ats.web.shopping;

import java.util.Collection;

public interface ICart {

	Collection<OrderLine> orderLines();

	void add(Product prod, int quantity);

	double total();

	boolean isEmpty();
	
	void clear();

}