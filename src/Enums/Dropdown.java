package Enums;

public enum Dropdown {
    PRINT_SIZE;

    private String[] options;
    private int index;

    static {
        PRINT_SIZE.options = new String [] { "4x6", "5x7", "8x10" };
        PRINT_SIZE.index = 0;
    }

    public String[] getOptions() {
        return options;
    }

    public int getIndex() {
        return index;
    }
}
