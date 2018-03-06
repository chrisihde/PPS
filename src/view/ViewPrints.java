package view;

import javax.swing.*;

public class ViewPrints {

    private static final String PANEL_LABEL = "Print Settings";
    private static final String[][] DROPDOWN_MENU_OPTIONS =
            {{ "4x6", "5x7", "8x10" },
             { "Glossy", "Matte" },
             { "1 Hour", "Next Day" }};
    private static final int PRINT_SIZES = 0;
    private static final int PRINT_FINISHES = 1;
    private static final int PRINT_PROCTIMES = 2;
    private static final String PRINT_SIZE_LABEL = "Size: ";
    private static final String PRINT_FINISH_LABEL = "Finish: ";
    private static final String PRINT_PROCTIMES_LABEL = "Processing Time: ";
    private static final String ADD_PRINT_BUTTON_LABEL = "Add Print";

    private JPanel printsPanel = new JPanel();
    private JPanel labelPanel = new JPanel();
    private JPanel sizePanel = new JPanel();
    private JPanel finishPanel = new JPanel();
    private JPanel procTimePanel = new JPanel();
    private JPanel buttonPanel = new JPanel();
    private JComboBox<String> sizeOptions = new JComboBox<>(DROPDOWN_MENU_OPTIONS[PRINT_SIZES]);
    private JComboBox<String> finishOptions = new JComboBox<>(DROPDOWN_MENU_OPTIONS[PRINT_FINISHES]);
    private JComboBox<String> procTimeOptions = new JComboBox<>(DROPDOWN_MENU_OPTIONS[PRINT_PROCTIMES]);
    private JButton addPrintButton = new JButton(ADD_PRINT_BUTTON_LABEL);

    ViewPrints() {
        labelPanel.add(new JLabel(PANEL_LABEL));
        sizePanel.add(new JLabel(PRINT_SIZE_LABEL));
        sizePanel.add(sizeOptions);
        finishPanel.add(new JLabel(PRINT_FINISH_LABEL));
        finishPanel.add(finishOptions);
        procTimePanel.add(new JLabel(PRINT_PROCTIMES_LABEL));
        procTimePanel.add(procTimeOptions);
        buttonPanel.add(addPrintButton);

        printsPanel.setLayout(new BoxLayout(printsPanel, BoxLayout.Y_AXIS));
        printsPanel.add(labelPanel);
        printsPanel.add(sizePanel);
        printsPanel.add(finishPanel);
        printsPanel.add(procTimePanel);
        printsPanel.add(buttonPanel);
    }

    public JComponent getComponent() {
        return printsPanel;
    }
}
