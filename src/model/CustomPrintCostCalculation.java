package model;

public class CustomPrintCostCalculation implements PrintCostCalculator {
	
	@Override
	public double getSizeCost(int quantity, String size) 
	{
		double smallSizeTotal = 0;
		double mediumSizeTotal = 0;
		double largeSizeTotal = 0;
		
		if (size.equals("4 x 6")) 
			smallSizeTotal = quantity * 0.19;
			
		if (size.equals("5 x 7")) 
			mediumSizeTotal = quantity * 0.39;
		
		if (size.equals("8 x 10"))	 
			largeSizeTotal = quantity * 0.79; 
		 
		return (smallSizeTotal + mediumSizeTotal + largeSizeTotal);
		
	}

	@Override
	public double getFinishCost(int quantity, String finish, String size) 
	{
		double smallSizeTotal = 0;
		double mediumSizeTotal = 0;
		double largeSizeTotal = 0;
		
		if (finish.equals("matte")) {
			if (size.equals("4 x 6")) {
				smallSizeTotal = 0.04 * quantity;
			}
			if (size.equals("5 x 7")) {
				mediumSizeTotal = 0.06 * quantity;
			}
			if (size.equals("8 x 10")) {
				largeSizeTotal = 0.08 * quantity;
			}
		}
		return (smallSizeTotal + mediumSizeTotal + largeSizeTotal);
		
	}

	@Override
	public double getProcessingTimeCost(int quantity, String processingTime) 
	{
		//BUG: Does not check for 1-Hour or next day.  Just applies 1-Hour processing time cost to all.
		if (quantity >= 1 && quantity <= 60) {
			return 2.00;
		} else if (quantity >= 61 && quantity <= 100){ 
			return 2.50;
		}
		
		//This is correct code.
		//if (processingTime.equals("1-Hour")) {
		//	if (quantity >= 1 && quantity <= 60) {
		//		return 2.00;
		//	} else if (quantity >= 61 && quantity <= 100){ 
		//		return 2.50;
		//	}
		//}
		return 0.0;
	}
}