package view;

import model.PrintOptions;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class PPSView {

    private JFrame frame = new JFrame();
    private ViewPrints prints = new ViewPrints();
    private ViewOrder order = new ViewOrder();

    public PPSView(String title) {
        frame.setTitle(title);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(prints.getComponent(), BorderLayout.WEST);
        frame.getContentPane().add(order.getComponent(), BorderLayout.EAST);
    }

    public void setVisible(boolean visible) {
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public PrintOptions getPrintOptions() {
        ArrayList<String> options = new ArrayList<>();
        options.add(prints.getSizeOption());
        options.add(prints.getFinishOption());
        options.add(prints.getProcTimeOption());

        // needed to convert Object[] to String[]
        Object[] optionsArray = options.toArray();
        String[] optionsStringArray =
                Arrays.copyOf(optionsArray, optionsArray.length, String[].class);
        return new PrintOptions(optionsStringArray);
    }

    public void setAddPrintAction(Action a) {
        prints.setAddPrintButtonAction(a);
    }
}
