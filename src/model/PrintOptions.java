package model;

import java.util.ArrayList;

public class PrintOptions {

    private static final int SIZE = 0;
    private static final int FINISH = 1;
    private static final int PROCTIME = 2;

    private ArrayList<String> printOptions;

    public PrintOptions() {
        printOptions = new ArrayList<>();
    }

    public PrintOptions(String[] options) {
        printOptions = new ArrayList<>();
        printOptions.add(SIZE, options[SIZE]);
//        printOptions.add(FINISH, options[FINISH]);
//        printOptions.add(PROCTIME, options[PROCTIME]);
    }

    public String getSizeOption() {
        return printOptions.get(SIZE);
    }

    public String getFinishOption() {
        return printOptions.get(FINISH);
    }

    public String getProcTimeOption() {
        return printOptions.get(PROCTIME);
    }
}
