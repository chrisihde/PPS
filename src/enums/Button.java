package enums;

public enum Button {
    ADD_PRINT;

    private int value;

    static {
        ADD_PRINT.value = 0;
    }

    public int getValue() {
        return value;
    }
}

