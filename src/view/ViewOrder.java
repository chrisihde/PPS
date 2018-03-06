package view;

import javax.swing.*;

public class ViewOrder {

    private static final String PANEL_LABEL = "Order Info";

    private JPanel orderPanel = new JPanel();

    ViewOrder() {
        orderPanel.add(new JLabel(PANEL_LABEL));
    }

    public JComponent getComponent() {
        return orderPanel;
    }
}
