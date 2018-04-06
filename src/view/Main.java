package view;


import javax.swing.JOptionPane;

import model.CustomPrintCostCalculation;
import model.StandardPrintCostCalculation;

public class Main {
private static Object[] options = {"Standard", "Custom"};
	
	public static void main(String[] args) { 
	      int choice = JOptionPane.showOptionDialog(null, "Choose an option:\n\nStandard: " +
	    		  										"Prints have same size, finish, and processing time.\n" +
	    		  										"Custom: Each print can have a different size, finish, and processing time.\n\n", "Photo Print Shop",
	                      JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,
	                      options, options[0]);
	   
	      if (choice == 0) {
	    	  StandardPrintCostCalculation standardCalculator = new StandardPrintCostCalculation();
	          StandardPrintView standardMode = new StandardPrintView(standardCalculator);
	      } 
	      else if (choice == 1) {
	    	  CustomPrintCostCalculation customCalculator = new CustomPrintCostCalculation();
	          CustomPrintView customMode = new CustomPrintView(customCalculator);
	      }
	  }
}
