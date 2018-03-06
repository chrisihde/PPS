package dal;

import enums.PrintFinish;
import enums.PrintProcessingTime;
import enums.PrintSize;
import enums.PrintType;

public class Print {
	
	private int id;
	private int quantity;
	private boolean isStandardPrint;
	private PrintSize size;
	private PrintFinish finish;
	private PrintType type;
	private PrintProcessingTime processingTime;
	
	public boolean IsStandardPrint(PrintSize printSize, PrintFinish printFinish, PrintProcessingTime printProcessingTime) {
		boolean isStandardPrint = false;
		
		if(printSize == PrintSize.SMALL && printFinish == PrintFinish.GLOSSY && printProcessingTime == PrintProcessingTime.NEXTDAY) {
			isStandardPrint = true;
		}
		
		setIsStandardPrint(isStandardPrint);
		
		return getIsStandardPrint();
	}	
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public int getQuantity() {
		return this.quantity;
	}
	
	public void setIsStandardPrint(boolean isStandard) {
		this.isStandardPrint = isStandard;		
	}
	
	public boolean getIsStandardPrint() {
		return isStandardPrint;
	}
	
	public void setSize(PrintSize printSize) {
		this.size = printSize;
	}
	
	public PrintSize getSize() {
		return this.size;
	}
	
	public void setFinish(PrintFinish printFinish) {
		this.finish = printFinish;
	}
	
	public PrintFinish getPrintFinish() {
		return this.finish;
	}
	
	public void setType(PrintType printType) {
		this.type = printType;
	}
	
	public PrintType getType() {
		return this.type;
	}
	
	public void setProcessingTime(PrintProcessingTime printProcessingTime) {
		this.processingTime = printProcessingTime;
	}
	
	public PrintProcessingTime getProcessingTime() {
		return this.processingTime;
	}
}
