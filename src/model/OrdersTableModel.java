package model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import dal.Order;
import dal.Print;

public class OrdersTableModel extends AbstractTableModel {

	private Order order;
	private final String[] columns;
	
	public OrdersTableModel(Order order) {
		super();
		this.order = order;		
		columns = new String[] {"Quantity", "Size", "Finish", "Processing Time", "Cost"};
	}
		
	@Override
	public int getRowCount() {
		return order.listOfPrints.size();
	}

	@Override
	public int getColumnCount() {
		return columns.length;
	}
	
	@Override
	public String getColumnName(int column) {
		return columns[column];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Print print = order.listOfPrints.get(rowIndex);
		switch(columnIndex) {
		case 0: return print.getQuantity();
		case 1: return print.getSize();
		case 2: return print.getPrintFinish();
		case 3: return print.getProcessingTime();
		case 4: return 5.00;
		default: return null;
		}
	}
	
	public void updateData(Order order) {
		this.order = order;
	}
	
	
	
}
