package gui;

import javax.swing.*;
import java.awt.*;
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

    // main panels
    private static JPanel containerPanel;
    private static JPanel printSettingsPanel;
    private static JPanel printInfoPanel;

    // subpanels
    private static JPanel printSettingsLabelPanel;
    private static JPanel printSizePanel;
    private static JPanel addPrintPanel;

    //widgets
    private static List<JButton> buttons = new ArrayList<>();
    private static List<JComboBox> dropdowns = new ArrayList<>();

    // data
    private static Order order = new Order();

    private PPSFrame() {
        setSize(800, 600);
        setTitle("PPS");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // the main window
        containerPanel = new JPanel();
        containerPanel.setLayout(new BoxLayout(containerPanel, BoxLayout.X_AXIS));

        // the left and right halves of the window
        printSettingsPanel = new JPanel();
        printInfoPanel = new JPanel();

        // each row in the left window
        printSettingsLabelPanel = new JPanel();
        printSizePanel = new JPanel();
        addPrintPanel = new JPanel();
        printSettingsPanel.setLayout(new GridLayout(4,2));
        printSettingsPanel.add(printSettingsLabelPanel);
        printSettingsPanel.add(printSizePanel);
        printSettingsPanel.add(addPrintPanel);

        // add left and right sides to main window
        containerPanel.add(printSettingsPanel);
        containerPanel.add(printInfoPanel);

        // add main panel to window
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
        addPrintPanel.add(buttons.get(Button.ADD_PRINT.getValue()));
    }

    private static void createDropdowns() {
        JComboBox<String> printSizes = new JComboBox<>(Dropdown.PRINT_SIZE.getOptions());
        printSizes.setSelectedIndex(0);
        printSizes.addActionListener(new PrintSizeEventHandler());
        printSizes.setBounds(400, 60, 100, 30);

        dropdowns.add(Dropdown.PRINT_SIZE.getIndex(), printSizes);
    }

    private static void addDropdownsToPanel() {
        // print size
        printSizePanel.add(new JLabel("Print Size: "));
        printSizePanel.add(dropdowns.get(Dropdown.PRINT_SIZE.getIndex()));
    }

    private static void setupSettingsPanel() {
        printSettingsLabelPanel.add(new JLabel("Print Settings: "));
        PPSFrame.createButtons();
        PPSFrame.addButtonsToPanel();
        PPSFrame.createDropdowns();
        PPSFrame.addDropdownsToPanel();
    }

    private static void setupInfoPanel() {
        printInfoPanel.add(new JLabel("Print Info:"));
    }

    public static void main(String[] args) {
        PPSFrame frame = new PPSFrame();
        PPSFrame.setupSettingsPanel();
        PPSFrame.setupInfoPanel();
        frame.setVisible(true);
    }
}
