package view;

import model.OrdersTableModel;
import model.PPSModel;
import model.PrintOptions;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import dal.Order;
import dal.Print;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

public class PPSView {

    private JFrame frame = new JFrame();
    JPanel panel = new JPanel();

    public JComboBox<String> sizeOptions = new JComboBox<>();
    private JComboBox<String> finishOptions = new JComboBox<>();
    private JComboBox<String> procTimeOptions = new JComboBox<>();
    private JTable table;
    private JButton addPrintButton;
    private JTextField textField;
    JLabel costLabel = new JLabel("$0.00");
    private PPSModel ppsModel;
    private OrdersTableModel ordersTableModel;

    public PPSView(String title, PPSModel model) {
    	ppsModel = model;
    	ordersTableModel = new OrdersTableModel(ppsModel.order);
    	frame = new JFrame();
		frame.setTitle(title);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 826, 588);
        frame.getContentPane().setLayout(null);
        
    	frame.setPreferredSize(new Dimension(826, 588));
        
        panel = new JPanel();
		panel.setBounds(0, 0, 810, 95);
		
		frame.getContentPane().add(panel);
		JLabel lblNewLabel = new JLabel("Quantity:");
		lblNewLabel.setBounds(10, 22, 57, 15);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 13));
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(72, 18, 56, 22);
		spinner.setFont(new Font("Arial", Font.PLAIN, 13));
		spinner.setModel(new SpinnerNumberModel(1, 1, 100, 1));
		
		sizeOptions.setBounds(280, 22, 54, 21);
		sizeOptions.setFont(new Font("Arial", Font.PLAIN, 13));
		sizeOptions.setModel(new DefaultComboBoxModel(new String[] {"4x6", "5x7", "8x10"}));
		
		JLabel lblPrintFinish = new JLabel("Finish:");
		lblPrintFinish.setBounds(433, 25, 42, 15);
		lblPrintFinish.setFont(new Font("Arial", Font.BOLD, 13));
		
		finishOptions.setBounds(480, 22, 67, 21);
		finishOptions.setFont(new Font("Arial", Font.PLAIN, 13));
		finishOptions.setModel(new DefaultComboBoxModel(new String[] {"Glossy", "Matte"}));
		
		JLabel lblNewLabel_2 = new JLabel("Processing Time:");
		lblNewLabel_2.setBounds(604, 25, 109, 15);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 13));
		
		procTimeOptions.setBounds(716, 23, 84, 20);
		procTimeOptions.setModel(new DefaultComboBoxModel(new String[] {"1 Hour", "Next Day"}));
		panel.setLayout(null);
		panel.add(lblNewLabel);
		panel.add(spinner);
		
		JLabel lblNewLabel_1 = new JLabel("Size:");
		lblNewLabel_1.setBounds(243, 25, 32, 15);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 13));
		panel.add(lblNewLabel_1);
		panel.add(sizeOptions);
		panel.add(lblPrintFinish);
		panel.add(finishOptions);
		panel.add(lblNewLabel_2);
		panel.add(procTimeOptions);
		
		addPrintButton = new JButton("Add");
		addPrintButton.setBounds(691, 61, 109, 23);
		addPrintButton.setBackground(new Color(175, 238, 238));
		addPrintButton.setForeground(new Color(0, 0, 0));
		addPrintButton.setFont(new Font("Arial", Font.BOLD, 13));
		
		panel.add(addPrintButton);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 122, 810, 345);
		frame.getContentPane().add(scrollPane);
		
		String[] columnNames = new String[] {"Quantity", "Size", "Finish", "Processing Time", "Cost"};	
		//efaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
		//or(Print print : order.listOfPrints) {
		//	Vector<Comparable> rowData = new Vector<Comparable>();
		//	rowData.add(print.getQuantity());
		//	rowData.add(print.getSize());
		//	rowData.add(print.getPrintFinish());
		//	rowData.add(print.getProcessingTime());
		//	rowData.add(99);
		//	tableModel.addRow(rowData);
		//
		table = new JTable(ordersTableModel);
		table.setFont(new Font("Arial", Font.PLAIN, 13));
		table.setShowVerticalLines(false);
		table.setShowHorizontalLines(false);
		table.setShowGrid(false);
		table.setRowSelectionAllowed(false);
		Font font = new Font("Aril", Font.BOLD, 13);
		table.getTableHeader().setFont(font);
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 478, 810, 71);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblTotalCost = new JLabel("Total Cost:");
		lblTotalCost.setFont(new Font("Arial", Font.BOLD, 13));
		lblTotalCost.setBounds(594, 33, 74, 14);
		panel_1.add(lblTotalCost);
		
		JLabel lblDiscountCode = new JLabel("Discount Code?");
		lblDiscountCode.setFont(new Font("Arial", Font.BOLD, 13));
		lblDiscountCode.setBounds(10, 34, 101, 14);
		panel_1.add(lblDiscountCode);
		
		textField = new JTextField();
		textField.setBounds(112, 31, 136, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		
		costLabel.setForeground(Color.BLUE);
		costLabel.setFont(new Font("Arial", Font.BOLD, 13));
		costLabel.setBounds(670, 34, 74, 14);
		panel_1.add(costLabel);
		
    }

    public void setVisible(boolean visible) {
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public PrintOptions getPrintOptions() {
        ArrayList<String> options = new ArrayList<>();
        options.add((String)sizeOptions.getSelectedItem());
        options.add((String)finishOptions.getSelectedItem());
        options.add((String)procTimeOptions.getSelectedItem());

        // needed to convert Object[] to String[]
        Object[] optionsArray = options.toArray();
        String[] optionsStringArray =
                Arrays.copyOf(optionsArray, optionsArray.length, String[].class);
        return new PrintOptions(optionsStringArray);
    }
    
    public String getDiscountCode() {
    	return textField.getText();
    }

    public void setAddPrintAction(Action a) {
    	addPrintButton.setAction(a);
    	addPrintButton.setText("Add Print");
    }
    
    public void refreshTable() {
    	ordersTableModel.updateData(ppsModel.order);
    	ordersTableModel.fireTableDataChanged();
    	table.repaint();
    	int x = 0;
    }
    
    public void updateCost(String cost) {
    	costLabel.setText(cost);
    }
}
