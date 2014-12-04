package com.ats.web.shopping;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


public class MapShoppingCart implements ICart {

	private Map<String, OrderLine> lineMap = new HashMap<>();
	@Override
	public Collection<OrderLine> orderLines() {
		return lineMap.values();
	}

	@Override
	public void add(Product prod, int quantity) {
	  OrderLine line = 	lineMap.get(prod.getName());
	  if(line == null) {
		  line = new OrderLine(prod, 0);
		  lineMap.put(prod.getName(), line);
	  }
      line.addQuantity(quantity);
	}

	@Override
	public double total() {
		double total = 0.0;
		for(OrderLine line : lineMap.values()) {
			total += line.getPrice();
		}		
		return total;
	}

	@Override
	public boolean isEmpty() {
		return lineMap.isEmpty();
	}

}
