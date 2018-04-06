package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.CustomPrintCostCalculation;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.SpinnerNumberModel;

public class CustomPrintView extends JFrame {

	private JPanel contentPane;
	private CustomPrintCostCalculation calculator;
	
	private SpinnerModel quantityModel4x6Glossy;
    private JSpinner quantity4x6Glossy;
    private SpinnerModel quantityModel4x6Matte;
    private JSpinner quantity4x6Matte;
    private SpinnerModel quantityModel5x7Glossy;
    private JSpinner quantity5x7Glossy;
    private SpinnerModel quantityModel5x7Matte;
    private JSpinner quantity5x7Matte;
    private SpinnerModel quantityModel8x10Glossy;
    private JSpinner quantity8x10Glossy;
    private SpinnerModel quantityModel8x10Matte;
    private JSpinner quantity8x10Matte;
    private String[] printProcessingTimes = {"Next Day", "1-Hour"};
    private JComboBox<String> printProcessingTime;
    private JButton calculateCost;
    private JLabel lblTotalCostAmount;
	
	public CustomPrintView(CustomPrintCostCalculation calculator) {
		this.calculator = calculator;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 534, 244);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 35, 150, 78);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblX = new JLabel("Glossy:");
		lblX.setFont(new Font("Arial", Font.BOLD, 13));
		lblX.setBounds(10, 11, 46, 14);
		panel.add(lblX);
		
		JLabel lblMatte = new JLabel("Matte:");
		lblMatte.setFont(new Font("Arial", Font.BOLD, 13));
		lblMatte.setBounds(10, 52, 46, 14);
		panel.add(lblMatte);
		
		quantity4x6Glossy = new JSpinner();
		quantity4x6Glossy.setModel(new SpinnerNumberModel(1, 1, 100, 1));
		quantity4x6Glossy.setFont(new Font("Arial", Font.PLAIN, 13));
		quantity4x6Glossy.setBounds(64, 8, 57, 20);
		panel.add(quantity4x6Glossy);
		
		quantity4x6Matte = new JSpinner();
		quantity4x6Matte.setModel(new SpinnerNumberModel(1, 1, 100, 1));
		quantity4x6Matte.setFont(new Font("Arial", Font.PLAIN, 13));
		quantity4x6Matte.setBounds(64, 49, 57, 20);
		panel.add(quantity4x6Matte);
		
		JLabel lblNewLabel = new JLabel("4 x 6");
		lblNewLabel.setBounds(10, 22, 64, 14);
		contentPane.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
		
		JLabel lblX_1 = new JLabel("5 x 7");
		lblX_1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
		lblX_1.setBounds(183, 23, 46, 14);
		contentPane.add(lblX_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(183, 35, 150, 78);
		contentPane.add(panel_1);
		
		JLabel label = new JLabel("Glossy:");
		label.setFont(new Font("Arial", Font.BOLD, 13));
		label.setBounds(10, 11, 46, 14);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("Matte:");
		label_1.setFont(new Font("Arial", Font.BOLD, 13));
		label_1.setBounds(10, 52, 46, 14);
		panel_1.add(label_1);
		
		quantity5x7Glossy = new JSpinner();
		quantity5x7Glossy.setModel(new SpinnerNumberModel(1, 1, 100, 1));
		quantity5x7Glossy.setFont(new Font("Arial", Font.PLAIN, 13));
		quantity5x7Glossy.setBounds(64, 8, 57, 20);
		panel_1.add(quantity5x7Glossy);
		
		quantity5x7Matte = new JSpinner();
		quantity5x7Matte.setModel(new SpinnerNumberModel(1, 1, 100, 1));
		quantity5x7Matte.setFont(new Font("Arial", Font.PLAIN, 13));
		quantity5x7Matte.setBounds(64, 49, 57, 20);
		panel_1.add(quantity5x7Matte);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(359, 35, 150, 78);
		contentPane.add(panel_2);
		
		JLabel label_2 = new JLabel("Glossy:");
		label_2.setFont(new Font("Arial", Font.BOLD, 13));
		label_2.setBounds(10, 11, 46, 14);
		panel_2.add(label_2);
		
		JLabel label_3 = new JLabel("Matte:");
		label_3.setFont(new Font("Arial", Font.BOLD, 13));
		label_3.setBounds(10, 52, 46, 14);
		panel_2.add(label_3);
		
		quantity8x10Glossy = new JSpinner();
		quantity8x10Glossy.setModel(new SpinnerNumberModel(1, 1, 100, 1));
		quantity8x10Glossy.setFont(new Font("Arial", Font.PLAIN, 13));
		quantity8x10Glossy.setBounds(64, 8, 57, 20);
		panel_2.add(quantity8x10Glossy);
		
		quantity8x10Matte = new JSpinner();
		quantity8x10Matte.setModel(new SpinnerNumberModel(1, 1, 100, 1));
		quantity8x10Matte.setFont(new Font("Arial", Font.PLAIN, 13));
		quantity8x10Matte.setBounds(64, 49, 57, 20);
		panel_2.add(quantity8x10Matte);
		
		JLabel lblX_2 = new JLabel("8 x 10");
		lblX_2.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
		lblX_2.setBounds(359, 23, 46, 14);
		contentPane.add(lblX_2);
		
		calculateCost = new JButton("Calculate Cost");
		calculateCost.setFont(new Font("Arial", Font.BOLD, 13));
		calculateCost.setBackground(new Color(176, 224, 230));
		calculateCost.setBounds(350, 124, 159, 23);
		contentPane.add(calculateCost);
		
		JLabel label_4 = new JLabel("Total Cost:");
		label_4.setFont(new Font("Arial", Font.BOLD, 15));
		label_4.setBounds(350, 187, 77, 14);
		contentPane.add(label_4);
		
		lblTotalCostAmount = new JLabel("$0.00");
		lblTotalCostAmount.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotalCostAmount.setForeground(Color.RED);
		lblTotalCostAmount.setFont(new Font("Arial", Font.BOLD, 15));
		lblTotalCostAmount.setBounds(437, 187, 72, 14);
		contentPane.add(lblTotalCostAmount);
		
		JLabel lblNewLabel_1 = new JLabel("Processing Time:");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1.setBounds(10, 128, 114, 14);
		contentPane.add(lblNewLabel_1);
		
		printProcessingTime = new JComboBox(printProcessingTimes);
		printProcessingTime.setFont(new Font("Arial", Font.PLAIN, 13));
		printProcessingTime.setBounds(134, 124, 95, 20);
		contentPane.add(printProcessingTime);		
		
		setTitle("Photo Print Shop");
		addListeners();
		setVisible(true);
	}
	
	private void addListeners() {
		calculateCost.addActionListener(new CalculateCostButtonListener());
    }
    
    public int getQuantityTotal() {
    	return (int) quantity4x6Glossy.getValue() + (int) quantity4x6Matte.getValue() + 
    			(int) quantity5x7Glossy.getValue() + (int) quantity5x7Matte.getValue() +
    			(int) quantity8x10Glossy.getValue() + (int) quantity8x10Matte.getValue();
    }
    
    public int getQuantity4x6() {
    	return (int) quantity4x6Glossy.getValue() + (int) quantity4x6Matte.getValue();
    }
    
    public int getQuantity5x7() {
    	return (int) quantity5x7Glossy.getValue() + (int) quantity5x7Matte.getValue();
    }
    
    public int getQuantity8x10() {
    	return (int) quantity8x10Glossy.getValue() + (int) quantity8x10Matte.getValue();
    }
    
    public int getMatteFinish4x6() {
    	return (int) quantity4x6Matte.getValue();
    }
    
    public int getMatteFinish5x7() {
    	return (int) quantity5x7Matte.getValue();
    }
    
    public int getMatteFinish8x10() {
    	return (int) quantity8x10Matte.getValue();
    }
    
    public String getProcessingTime() {
    	return printProcessingTime.getSelectedItem().toString();
    }
    
    private class CalculateCostButtonListener implements ActionListener {

        /**
         * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
         */
        @Override
        public void actionPerformed(ActionEvent aE) {
            JButton b = (JButton) aE.getSource();
            
            if (b.equals(calculateCost)) {
            	//BUG:  Switched quantities gotten for 4x6 and 5x7.
            	double sizeCost4x6 = calculator.getSizeCost(getQuantity5x7(), "4 x 6");
            	double sizeCost5x7 = calculator.getSizeCost(getQuantity4x6(), "5 x 7");
            	
            	//This is correct code.
            	//double sizeCost4x6 = calculator.getSizeCost(getQuantity4x6(), "4 x 6");
            	//double sizeCost5x7 = calculator.getSizeCost(getQuantity5x7(), "5 x 7");
            	
            	double sizeCost8x10 = calculator.getSizeCost(getQuantity8x10(), "8 x 10");
            	double finishCost4x6 = calculator.getFinishCost(getMatteFinish4x6(), "matte", "4 x 6");
            	double finishCost5x7 = calculator.getFinishCost(getMatteFinish5x7(), "matte", "5 x 7");
            	double finishCost8x10 = calculator.getFinishCost(getMatteFinish8x10(), "matte", "8 x 10");
            	double processingTimeCost = calculator.getProcessingTimeCost(getQuantityTotal(), getProcessingTime());
            	double totalCost = sizeCost4x6 + sizeCost5x7 + sizeCost8x10 + finishCost4x6 + finishCost5x7
            			+ finishCost8x10 + processingTimeCost;
            	
            	if (totalCost > 35.00) {
            		totalCost = totalCost - (totalCost * 0.05);
            	}
            	
            	String total = String.format("%.2f", totalCost);
            	lblTotalCostAmount.setText("$" + total);
            }
        }
        
    }
}
