package Enums;

public enum PrintSize {
    SMALL ("4x6"),
    MEDIUM ("5x7"),
    LARGE ("8x10");

    private String value;

    PrintSize(String value){
        this.value = value;
    }

    public static PrintSize getFromString(String s) {
        for (PrintSize p : PrintSize.values()) {
            if (p.value.equalsIgnoreCase(s)) {
                return p;
            }
        }
        throw new IllegalArgumentException("No constant with text " + s + " found");
    }
}
