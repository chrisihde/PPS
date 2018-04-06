package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.StandardPrintCostCalculation;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

public class StandardPrintView extends JFrame {

	private JPanel contentPane;
	private StandardPrintCostCalculation calculator;
	private JSpinner quantity;
    private String[] printSizes = {"4 x 6", "5 x 7", "8 x 10"};
    private JComboBox<String> printSize;
    private String[] printFinishes = {"glossy", "matte"};
    private JComboBox<String> printFinish;
    private String[] printProcessingTimes = {"Next Day", "1-Hour"};
    private JComboBox<String> printProcessingTime;
    private JTextField discountCode;
    private JButton btnCalculateCost;
    private JTextField totalCost;
    private JLabel lblTotalCost;
    private JLabel lblTotalCostAmount;
	/**
	 * Create the frame.
	 */
	public StandardPrintView(StandardPrintCostCalculation calculator) {
		setBackground(new Color(238, 232, 170));
		this.calculator = calculator;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 536, 218);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Quantity (Max 100):");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 11, 123, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Processing Time:");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1.setBounds(10, 53, 123, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Discount Code:");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_2.setBounds(10, 95, 107, 14);
		contentPane.add(lblNewLabel_2);
		
		btnCalculateCost = new JButton("Calculate Cost");
		btnCalculateCost.setBackground(new Color(176, 224, 230));
		btnCalculateCost.setFont(new Font("Arial", Font.BOLD, 13));
		btnCalculateCost.setBounds(349, 91, 159, 23);
		contentPane.add(btnCalculateCost);
		
		JLabel lblNewLabel_3 = new JLabel("Finish:");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_3.setBounds(349, 53, 52, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Size:");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_4.setBounds(349, 11, 40, 14);
		contentPane.add(lblNewLabel_4);
		
		printProcessingTime = new JComboBox(printProcessingTimes);
		printProcessingTime.setBounds(136, 51, 107, 20);
		contentPane.add(printProcessingTime);
		
		discountCode = new JTextField();
		discountCode.setBounds(136, 93, 107, 20);
		contentPane.add(discountCode);
		discountCode.setColumns(10);
		
		printSize = new JComboBox(printSizes);
		printSize.setBounds(398, 9, 107, 20);
		contentPane.add(printSize);
		
		printFinish = new JComboBox(printFinishes);
		printFinish.setBounds(398, 51, 107, 20);
		contentPane.add(printFinish);
		
		quantity = new JSpinner();
		quantity.setModel(new SpinnerNumberModel(1, 1, 100, 1));
		quantity.setBounds(136, 9, 107, 20);
		contentPane.add(quantity);
		
		lblTotalCost = new JLabel("Total Cost:");
		lblTotalCost.setFont(new Font("Arial", Font.BOLD, 15));
		lblTotalCost.setBounds(349, 154, 77, 14);
		contentPane.add(lblTotalCost);
		
		lblTotalCostAmount = new JLabel("$0.00");
		lblTotalCostAmount.setForeground(new Color(255, 0, 0));
		lblTotalCostAmount.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotalCostAmount.setFont(new Font("Arial", Font.BOLD, 15));
		lblTotalCostAmount.setBounds(436, 154, 72, 14);
		contentPane.add(lblTotalCostAmount);
		
		setTitle("Photo Print Shop");
		addListeners();
		setVisible(true);
	}

	private void addListeners() {
		btnCalculateCost.addActionListener(new CalculateCostButtonListener());
    }
    
    public int getQuantity() {
    	return (int) quantity.getValue();
    }
    
    public String getSizes() {
    	return printSize.getSelectedItem().toString();
    }
    
    public String getFinish() {
    	return printFinish.getSelectedItem().toString();
    }
    
    public String getProcessingTime() {
    	return printProcessingTime.getSelectedItem().toString();
    }
    
    public String getPromoCode() {
    	return discountCode.getText();
    }
    
    private class CalculateCostButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton b = (JButton) e.getSource();
            
            if (b.equals(btnCalculateCost)) {
            	double sizeCost = calculator.getSizeCost(getQuantity(), getSizes());
            	double finishCost = calculator.getFinishCost(getQuantity(), getFinish(), getSizes());
            	double processingTimeCost = calculator.getProcessingTimeCost(getQuantity(), getProcessingTime());
            	double promoDiscount = calculator.getPromoDiscount(getQuantity(), getPromoCode());
            	double totalCost = sizeCost + finishCost + processingTimeCost + promoDiscount;
            	
            	if (totalCost > 35.00 && promoDiscount == 0.00) {
            		totalCost = totalCost - (totalCost * 0.05);
            	}
            	
            	String total = String.format("%.2f", totalCost);
            	lblTotalCostAmount.setText("$" + total);
            }
        }
        
    }
}
