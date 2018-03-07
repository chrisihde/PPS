package enums;

public enum PrintType {
	STANDARD ("Standard"),
	CUSTOM ("Custom");

    private String value;

    PrintType(String value){
        this.value = value;
    }

    public static PrintType getFromString(String s) {
        for (PrintType p : PrintType.values()) {
            if (p.value.equalsIgnoreCase(s)) {
                return p;
            }
        }
        throw new IllegalArgumentException("No constant with text " + s + " found");
    }
}
