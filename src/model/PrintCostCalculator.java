package model;

public interface PrintCostCalculator {
	public double getSizeCost(int quantity, String size);
	
	public double getFinishCost(int quantity, String finish, String size);
	
	public double getProcessingTimeCost(int quantity, String processingTime);

}
