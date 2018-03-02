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

    private static JPanel containerPanel;
    private static JPanel printSettingsPanel;
    private static JPanel printInfoPanel;
    private static List<JButton> buttons = new ArrayList<>();
    private static List<JComboBox> dropdowns = new ArrayList<>();
    private static Order order = new Order();

    private PPSFrame() {
        setSize(800, 600);
        setTitle("PPS");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        containerPanel = new JPanel();
        containerPanel.setLayout(new BoxLayout(containerPanel, BoxLayout.X_AXIS));

        printSettingsPanel = new JPanel();
        printInfoPanel = new JPanel();

        containerPanel.add(printSettingsPanel);
        containerPanel.add(printInfoPanel);

        getContentPane().add(containerPanel);
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
        printSettingsPanel.add(buttons.get(Button.ADD_PRINT.getValue()));
    }

    private static void createDropdowns() {
        JComboBox<String> printSizes = new JComboBox<>(Dropdown.PRINT_SIZE.getOptions());
        printSizes.setSelectedIndex(0);
        printSizes.addActionListener(new PrintSizeEventHandler());
        printSizes.setBounds(400, 60, 100, 30);

        dropdowns.add(Dropdown.PRINT_SIZE.getIndex(), printSizes);
    }

    private static void addDropdownsToPanel() {
        printSettingsPanel.add(dropdowns.get(Dropdown.PRINT_SIZE.getIndex()));
    }

    private static void setupInfoPanel() {
        printInfoPanel.add(new JLabel("test"));
    }

    public static void main(String[] args) {
        PPSFrame frame = new PPSFrame();
        PPSFrame.createButtons();
        PPSFrame.addButtonsToPanel();
        PPSFrame.createDropdowns();
        PPSFrame.addDropdownsToPanel();
        PPSFrame.setupInfoPanel();
        frame.setVisible(true);
    }
}
