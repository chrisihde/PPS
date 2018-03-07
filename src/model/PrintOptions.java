package model;

import java.util.ArrayList;

public class PrintOptions {

    private static final int SIZE_INDEX = 0;
    private static final int FINISH_INDEX = 1;
    private static final int PROCTIME_INDEX = 2;

    private ArrayList<String> printOptions;

    public PrintOptions(String[] options) {
        // TODO: safety check for array size
        printOptions = new ArrayList<>();
        printOptions.add(SIZE_INDEX, options[SIZE_INDEX]);
        printOptions.add(FINISH_INDEX, options[FINISH_INDEX]);
        printOptions.add(PROCTIME_INDEX, options[PROCTIME_INDEX]);
    }

    public String getSizeOption() {
        return printOptions.get(SIZE_INDEX);
    }

    public String getFinishOption() {
        return printOptions.get(FINISH_INDEX);
    }

    public String getProcTimeOption() {
        return printOptions.get(PROCTIME_INDEX);
    }
}
