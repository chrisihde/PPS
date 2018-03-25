package model;

import dal.Order;
import dal.Print;

public class PPSModel {

    public Order order;

    public PPSModel() {
    	order = new Order();
    }
    
    public void addPrintToOrder(Print p) {
        this.order.addPrint(p);
    }
    
    
}
