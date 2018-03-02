package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;

import DAL.Order;
import DAL.Print;
import Enums.*;
import Enums.Button;

public class PPSFrame extends JFrame {

    // main panels
    private static JPanel containerPanel;
    private static JPanel printSettingsPanel;
    private static JPanel printInfoPanel;

    // subpanels
    private static JPanel printSettingsLabelPanel;
    private static JPanel printSizePanel;
    private static JPanel printFinishPanel;
    private static JPanel printProcessingTimePanel;
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
        printFinishPanel = new JPanel();
        printProcessingTimePanel = new JPanel();
        addPrintPanel = new JPanel();
        printSettingsPanel.setLayout(new BoxLayout(printSettingsPanel, BoxLayout.Y_AXIS));
        printSettingsPanel.add(printSettingsLabelPanel);
        printSettingsPanel.add(printSizePanel);
        printSettingsPanel.add(printFinishPanel);
        printSettingsPanel.add(printProcessingTimePanel);
        printSettingsPanel.add(addPrintPanel);

        // add left and right sides to main window
        containerPanel.add(printSettingsPanel);
        containerPanel.add(printInfoPanel);

        // add main panel to window
        getContentPane().add(containerPanel);
    }

    private static void createButtons() {
        // create 'Add Print' button
        JButton addPrint = new JButton("Add Print");
        addPrint.setBounds(150, 60, 100, 30);
        addPrint.addActionListener(new ActionListener() {
            // 'Add Print' button functionality
            @Override
            public void actionPerformed(ActionEvent e) {
                Print print = new Print();

                // get size setting
                String sizeValue = (String)dropdowns.get(Dropdown.PRINT_SIZE.getIndex()).getSelectedItem();
                PrintSize size = PrintSize.getFromString(sizeValue);

                // get finish setting
                String finishValue = (String)dropdowns.get(Dropdown.PRINT_FINISH.getIndex()).getSelectedItem();
                PrintFinish finish = PrintFinish.getFromString(finishValue);

                // get processing time setting
                String timeValue = (String)dropdowns.get(Dropdown.PRINT_TIME.getIndex()).getSelectedItem();
                PrintProcessingTime time = PrintProcessingTime.getFromString(timeValue);

                print.setSize(size);
                print.setFinish(finish);
                print.setProcessingTime(time);

                order.addPrint(print);
            }
        });

        buttons.add(Button.ADD_PRINT.getValue(), addPrint);
    }

    private static void addButtonsToPanel() {
        addPrintPanel.add(buttons.get(Button.ADD_PRINT.getValue()));
    }

    private static void createDropdowns() {
        // create dropdown menu for print size
        JComboBox<String> printSizes = new JComboBox<>(Dropdown.PRINT_SIZE.getOptions());
        // default option for this menu
        printSizes.setSelectedIndex(0);
        printSizes.addActionListener(new PrintSizeEventHandler());
        printSizes.setBounds(400, 60, 100, 30);

        // create dropdown menu for print finish
        JComboBox<String> printFinishes = new JComboBox<>(Dropdown.PRINT_FINISH.getOptions());
        // default option for this menu
        printFinishes.setSelectedIndex(1);
        printFinishes.addActionListener(new PrintFinishEventHandler());
        printFinishes.setBounds(400, 60, 100, 30);

        // create dropdown menu for print type
        JComboBox<String> printTimes = new JComboBox<>(Dropdown.PRINT_TIME.getOptions());
        // default option for this menu
        printTimes.setSelectedIndex(1);
        printTimes.addActionListener(new PrintProcessingTimeEventHandler());
        printTimes.setBounds(400, 60, 100, 30);

        dropdowns.add(Dropdown.PRINT_SIZE.getIndex(), printSizes);
        dropdowns.add(Dropdown.PRINT_FINISH.getIndex(), printFinishes);
        dropdowns.add(Dropdown.PRINT_TIME.getIndex(), printTimes);
    }

    private static void addDropdownsToPanel() {
        // print size
        printSizePanel.add(new JLabel("Print Size: "));
        printSizePanel.add(dropdowns.get(Dropdown.PRINT_SIZE.getIndex()));

        // print finish
        printFinishPanel.add(new JLabel("Print Finish: "));
        printFinishPanel.add(dropdowns.get(Dropdown.PRINT_FINISH.getIndex()));

        // print time
        printProcessingTimePanel.add(new JLabel("Print Processing Time: "));
        printProcessingTimePanel.add(dropdowns.get(Dropdown.PRINT_TIME.getIndex()));
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
