package view;

import javax.swing.*;
import java.awt.*;

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
}
