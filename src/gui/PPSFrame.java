package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;

import DAL.Order;
import DAL.Print;
import Enums.Button;
import Enums.Dropdown;
import Enums.PrintSize;

public class PPSFrame extends JFrame {

    private static JPanel panel;
    private static List<JButton> buttons = new ArrayList<>();
    private static List<JComboBox> dropdowns = new ArrayList<>();
    private static Order order = new Order();

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
                Print print = new Print();

                String sizeValue = (String)dropdowns.get(Dropdown.PRINT_SIZE.getIndex()).getSelectedItem();
                PrintSize size = PrintSize.getFromString(sizeValue);

                print.setSize(size);

                order.addPrint(print);
            }
        });

        buttons.add(Button.ADD_PRINT.getValue(), addPrint);
    }

    private static void addButtonsToPanel() {
        panel.add(buttons.get(Button.ADD_PRINT.getValue()));
    }

    private static void createDropdowns() {
        JComboBox<String> printSizes = new JComboBox<>(Dropdown.PRINT_SIZE.getOptions());
        printSizes.setSelectedIndex(0);
        printSizes.addActionListener(new PrintSizeEventHandler());
        printSizes.setBounds(400, 60, 100, 30);

        dropdowns.add(Dropdown.PRINT_SIZE.getIndex(), printSizes);
    }

    private static void addDropdownsToPanel() {
        panel.add(dropdowns.get(Dropdown.PRINT_SIZE.getIndex()));
    }

    public static void main(String[] args) {
        PPSFrame frame = new PPSFrame();
        PPSFrame.createButtons();
        PPSFrame.addButtonsToPanel();
        PPSFrame.createDropdowns();
        PPSFrame.addDropdownsToPanel();
        frame.setVisible(true);
    }
}
