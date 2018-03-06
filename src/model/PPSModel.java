package model;

import dal.Order;
import dal.Print;

public class PPSModel {

    private Order order = new Order();

    public void addPrintToOrder(Print p) {
        order.addPrint(p);
    }
}
