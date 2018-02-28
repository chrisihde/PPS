package gui;

import javax.swing.*;

public class PPSFrame extends JFrame {
    private PPSFrame() {
        setSize(800, 600);
        setTitle("PPS");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main (String[] args) {
        PPSFrame frame = new PPSFrame();
        frame.setVisible(true);
    }
}
