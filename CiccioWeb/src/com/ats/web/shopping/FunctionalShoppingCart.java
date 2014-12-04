package com.ats.web.shopping;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class FunctionalShoppingCart implements ICart {
	private List<OrderLine> lines = new ArrayList<>();

	
	@Override
	public Collection<OrderLine> orderLines() {
		return Collections.unmodifiableCollection(lines);
	}

	
	@Override
	public void add(Product prod, int quantity) {
		lines.stream().filter(line -> line.getProduct().equals(prod))
				.findFirst().orElseGet(() -> {
					OrderLine line = new OrderLine(prod, 0);
					lines.add(line);
					return line;
				}).addQuantity(quantity);

	}

	
	@Override
	public double total() {
		return lines.stream()
			.map(line -> line.getPrice())
			.reduce(Double::sum).orElse(0.0);
	}
	
	
	@Override
	public boolean isEmpty() {
		return lines.isEmpty();
	}


	@Override
	public void clear() {
		lines.clear();
		
	}
	
	

}
