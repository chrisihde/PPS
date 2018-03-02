package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;

import DAL.Print;
import Enums.Button;

public class PPSFrame extends JFrame {

    private static JPanel panel;
    private static List<JButton> buttons = new ArrayList<>();
    private static List<Print> prints = new ArrayList<>();

    private PPSFrame() {
        setSize(800, 600);
        setTitle("PPS");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        panel = new JPanel();
        getContentPane().add(panel);
        panel.setLayout(null);
    }

    private static void createButtons() {
        JButton addPrint = new JButton("Add Print");
        addPrint.setBounds(150, 60, 100, 30);
        addPrint.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        buttons.add(Button.ADD_PRINT.getValue(), addPrint);
    }

    private static void addButtonsToPanel() {
        panel.add(buttons.get(Button.ADD_PRINT.getValue()));
    }

    public static void main(String[] args) {
        PPSFrame frame = new PPSFrame();
        PPSFrame.createButtons();
        PPSFrame.addButtonsToPanel();
        frame.setVisible(true);
    }
}
