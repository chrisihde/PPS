package view;

import javax.swing.*;

public class ViewPrints {

    private static final String PANEL_LABEL = "Print Settings";

    private JPanel printsPanel = new JPanel();

    ViewPrints() {
        printsPanel.add(new JLabel(PANEL_LABEL));
    }

    public JComponent getComponent() {
        return printsPanel;
    }
}
