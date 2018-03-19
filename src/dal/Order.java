package dal;

import java.util.ArrayList;

import enums.PrintFinish;
import enums.PrintProcessingTime;
import enums.PrintSize;

public class Order {
	public ArrayList<Print> listOfPrints;
	public double orderDiscount;
	public double totalOrderCost;
	
	public Order() {
		Print test = new Print();
		test.setQuantity(1);
		test.setFinish(PrintFinish.MATTE);
		test.setSize(PrintSize.MEDIUM);
		test.setId(1);
		test.setProcessingTime(PrintProcessingTime.NEXTDAY);
		listOfPrints = new ArrayList<>();
		listOfPrints.add(test);
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
	
	public Order addPrint(Print print) {
		this.listOfPrints.add(print);
		return this;
	}
	
	public Order removePrint(Print print) {
		
		for(int i = 0; i < this.listOfPrints.size(); i++)
		{
			Print p = this.listOfPrints.get(i);
			
			if(p.getId() == print.getId()) {
				this.listOfPrints.remove(i);
			}
		}
		
		return this;
	}
}
