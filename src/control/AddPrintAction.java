package control;

import dal.Print;
import enums.PrintSize;
import model.PPSModel;
import model.PrintOptions;
import view.PPSView;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class AddPrintAction extends AbstractAction {

    private PPSView view;
    private PPSModel model;

    AddPrintAction(PPSView view, PPSModel model) {
        super();
        this.view = view;
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Print print = new Print();
        PrintOptions printOptions = view.getPrintOptions();

        String sizeOption = printOptions.getSizeOption();
        print.setSize(PrintSize.getFromString(sizeOption));

        model.addPrintToOrder(print);
    }
}
