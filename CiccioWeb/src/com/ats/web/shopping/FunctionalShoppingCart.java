package com.ats.web.shopping;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


public class FunctionalShoppingCart implements ICart {
	private List<OrderLine> lines = new ArrayList<>();
	@Override
	public Collection<OrderLine> orderLines() {
		return Collections.unmodifiableCollection(lines);
	}
	@Override
	public void add(Product prod, int quantity) {
		
		boolean isNew = true;
//		for(OrderLine ol : lines) {
//			if(ol.getProduct().equals(prod)) {
//				ol.addQuantity(quantity);
//			    isNew = false;
//				break;
//			}
//		}
//		if(isNew) {
//			lines.add(new OrderLine(prod, quantity));
//		}
		lines.stream().filter(line -> line.getProduct().equals(prod))
				.findFirst().orElseGet(() -> {
					OrderLine line = new OrderLine(prod, 0);
					lines.add(line);
					return line;
				}).addQuantity(quantity);

	}
	@Override
	public double total() {
		
//	  Optional<Double> x =	lines.stream()
//		.map(line -> line.getPrice())
//		.reduce(Double::sum);
//		
//	  if(x.isPresent()) {
//		  double t = x.get();
//	  }
//	  double u = x.orElse(0.0);
//		double total = 0.0;
//	    for(OrderLine ol : lines) {
//	    	double price = ol.getPrice();
//	    	total += price;
//	    }
//		return total;
		
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
