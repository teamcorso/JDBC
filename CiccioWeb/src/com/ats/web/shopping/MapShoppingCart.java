package com.ats.web.shopping;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;


public class MapShoppingCart implements ICart {

	private Map<String, OrderLine> lineMap = new HashMap<>();
	@Override
	public Collection<OrderLine> orderLines() {
		return lineMap.values();
	}

	@Override
	public void add(Product prod, int quantity) {
		
	 
//	  lineMap.putIfAbsent(prod.getName(),new OrderLine(prod, 0));
//	  lineMap.get(prod.getName()).addQuantity(quantity);
	  
	  
	  lineMap.putIfAbsent(prod.getName(), new OrderLine(prod, 0));
	  
	  lineMap.values().stream().filter(ol -> ol.getProduct().equals(prod))
	                  .findAny().get().addQuantity(quantity);
	  
	  lineMap.keySet().stream()
	                  .filter(key -> key.equals(prod.getName()))
	                  .findAny()
	                  .ifPresent(key-> lineMap.get(key).addQuantity(quantity));
	                  
	  lineMap.entrySet().stream()
	          .filter(e -> e.getKey().equals(prod.getName()))
	          .findAny()
	          .ifPresent((e) -> e.getValue().addQuantity(quantity));
	         

	  
	  
//	  for (String s : lineMap.keySet()){
//		  System.out.printf("key: %s, value: %s",
//				  s, lineMap.get(s).getProduct().getName());
//	  }
//	  
//	  for(OrderLine ol : lineMap.values()) {
//		  System.out.printf("key: %s, value: %s",
//				  ol.getProduct().getName(), ol.getProduct().getName());
//	  }
//	  
//	  for( Entry<String, OrderLine> entry : lineMap.entrySet()) {
//		  System.out.printf("key: %s, value: %s",
//				  entry.getKey(), entry.getValue().getProduct().getName());
//	  }
	  
	  
//	  OrderLine line = 	lineMap.get(prod.getName());
//	  if(line == null) {
//		  line = new OrderLine(prod, 0);
//		  lineMap.put(prod.getName(), line);
//	  }
//      line.addQuantity(quantity);
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

	@Override
	public void clear() {
		lineMap.clear();
		
	}

}
