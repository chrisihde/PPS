package Enums;

public enum PrintProcessingTime {
    ONEHOUR ("1 Hour"),
    NEXTDAY ("Next Day");

	private String value;

	PrintProcessingTime(String value){
		this.value = value;
	}

	public static PrintProcessingTime getFromString(String s) {
		for (PrintProcessingTime p : PrintProcessingTime.values()) {
			if (p.value.equalsIgnoreCase(s)) {
				return p;
			}
		}
		throw new IllegalArgumentException("No constant with text " + s + " found");
	}
}
