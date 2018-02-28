package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PPSFrame extends JFrame {
    private PPSFrame() {
        setSize(800, 600);
        setTitle("PPS");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        getContentPane().add(panel);
        panel.setLayout(null);

        JButton addPrint = new JButton("Add Print");
        addPrint.setBounds(150, 60, 80, 30);
        addPrint.addActionListener(new ActionListener() {
                                       @Override
                                       public void actionPerformed(ActionEvent e) {

                                       }
        });

        panel.add(addPrint);
    }

    public static void main (String[] args) {
        PPSFrame frame = new PPSFrame();
        frame.setVisible(true);
    }
}
