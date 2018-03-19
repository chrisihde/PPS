package model;

import java.awt.List;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import dal.Order;
import dal.Print;

public class PrintsTableModel extends DefaultTableModel{
	
	private ArrayList<Print> prints;
	private String[] columnNames;
	
	public PrintsTableModel(Order order) {
		super();
		prints = order.listOfPrints;
		columnNames = new String[] {"Quantity", "Size", "Finish", "Processing Time", "Cost"};
	}
	
	
	
	@Override
	public int getRowCount() {
		return 0;
	}
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return null;
	}
		
	
	
}
