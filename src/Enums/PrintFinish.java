package Enums;

public enum PrintFinish {
    GLOSSY ("Glossy"),
	MATTE ("Matte");

    private String value;

    PrintFinish(String value){
        this.value = value;
    }

    public static PrintFinish getFromString(String s) {
        for (PrintFinish p : PrintFinish.values()) {
            if (p.value.equalsIgnoreCase(s)) {
                return p;
            }
        }
        throw new IllegalArgumentException("No constant with text " + s + " found");
    }
}
