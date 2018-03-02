package Enums;

public enum Dropdown {
    PRINT_SIZE, PRINT_FINISH;

    // used to populate menus
    private String[] options;
    // used to lookup in dropdown collection
    private int index;

    static {
        PRINT_SIZE.options = new String [] { "4x6", "5x7", "8x10" };
        PRINT_SIZE.index = 0;

        PRINT_FINISH.options = new String [] { "Glossy", "Matte" };
        PRINT_FINISH.index = 1;
    }

    public String[] getOptions() {
        return options;
    }

    public int getIndex() {
        return index;
    }
}
