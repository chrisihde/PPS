package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

import dal.Order;
import dal.Print;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.JToggleButton;
import javax.swing.JTextField;

public class AppMain {

	private JFrame frmPhotoPrintShop;
	private JTable table;
	private Order order = new Order();
	private JPanel panel;
	private JTextField textField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain window = new AppMain();
					window.frmPhotoPrintShop.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AppMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPhotoPrintShop = new JFrame();
		frmPhotoPrintShop.setTitle("Photo Print Shop");
		frmPhotoPrintShop.setBounds(100, 100, 826, 588);
		frmPhotoPrintShop.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPhotoPrintShop.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 810, 95);
		frmPhotoPrintShop.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("Quantity:");
		lblNewLabel.setBounds(10, 22, 57, 15);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 13));
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(72, 18, 56, 22);
		spinner.setFont(new Font("Arial", Font.PLAIN, 13));
		spinner.setModel(new SpinnerNumberModel(1, 1, 100, 1));
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(280, 22, 54, 21);
		comboBox.setFont(new Font("Arial", Font.PLAIN, 13));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"4x6", "5x7", "8x10"}));
		
		JLabel lblPrintFinish = new JLabel("Finish:");
		lblPrintFinish.setBounds(433, 25, 42, 15);
		lblPrintFinish.setFont(new Font("Arial", Font.BOLD, 13));
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(480, 22, 67, 21);
		comboBox_1.setFont(new Font("Arial", Font.PLAIN, 13));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Glossy", "Matte"}));
		
		JLabel lblNewLabel_2 = new JLabel("Processing Time:");
		lblNewLabel_2.setBounds(604, 25, 109, 15);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 13));
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(716, 23, 84, 20);
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"1 Hour", "Next Day"}));
		panel.setLayout(null);
		panel.add(lblNewLabel);
		panel.add(spinner);
		
		JLabel lblNewLabel_1 = new JLabel("Size:");
		lblNewLabel_1.setBounds(243, 25, 32, 15);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 13));
		panel.add(lblNewLabel_1);
		panel.add(comboBox);
		panel.add(lblPrintFinish);
		panel.add(comboBox_1);
		panel.add(lblNewLabel_2);
		panel.add(comboBox_2);
		
		JButton btnAddPrint = new JButton("Add Print");
		btnAddPrint.setBounds(691, 61, 109, 23);
		btnAddPrint.setBackground(new Color(175, 238, 238));
		btnAddPrint.setForeground(new Color(0, 0, 0));
		btnAddPrint.setFont(new Font("Arial", Font.BOLD, 13));
		panel.add(btnAddPrint);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 122, 810, 345);
		frmPhotoPrintShop.getContentPane().add(scrollPane);
		
		String[] columnNames = new String[] {"Quantity", "Size", "Finish", "Processing Time", "Cost"};	
		DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
		for(Print print : order.listOfPrints) {
			Vector rowData = new Vector();
			rowData.add(print.getQuantity());
			rowData.add(print.getSize());
			rowData.add(print.getPrintFinish());
			rowData.add(print.getProcessingTime());
			rowData.add(99);
			tableModel.addRow(rowData);
		}
		table = new JTable(tableModel);
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
		frmPhotoPrintShop.getContentPane().add(panel_1);
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
		
		JLabel lblNewLabel_3 = new JLabel("$0.00");
		lblNewLabel_3.setForeground(Color.BLUE);
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_3.setBounds(670, 34, 74, 14);
		panel_1.add(lblNewLabel_3);
	}
}
