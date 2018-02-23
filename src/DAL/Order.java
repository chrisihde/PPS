package DAL;

import java.util.ArrayList;

public class Order {
	ArrayList<Print> listOfPrints;
	double orderDiscount;
	double totalOrderCost;
	
	public Order() {
		listOfPrints = new ArrayList<Print>();
		orderDiscount = 0.00;
		totalOrderCost = 0.00;
	}
	
	public void setOrderDiscount(double discount) {
		orderDiscount = discount;
	}
	
	public double getOrderDiscount() {
		return orderDiscount;
	}
	
	public void setTotalOrderCost(double orderCost) {
		totalOrderCost = orderCost;
	}
	
	public double getTotalOrderCost() {
		return totalOrderCost;
	}
	
	public double calculateTotalOrderCost() {
		
		// TODO This needs to be linked to the logic code that will calculate the cost for the complete order once that is done.
		
		double orderCost = 0.00;
		setTotalOrderCost(orderCost);
		return getTotalOrderCost();
	}
}
