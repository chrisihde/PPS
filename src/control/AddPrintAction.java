package control;

import dal.Print;
import enums.PrintFinish;
import enums.PrintProcessingTime;
import enums.PrintSize;
import enums.PrintType;
import model.PPSModel;
import model.PrintOptions;
import view.PPSView;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class AddPrintAction extends AbstractAction {

    private PPSView view;
    private PPSModel model;

    AddPrintAction(PPSView view2, PPSModel model) {
        super();
        this.view = view2;
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Print print = new Print();
        PrintOptions printOptions = view.getPrintOptions();

        String sizeOption = printOptions.getSizeOption();
        print.setSize(PrintSize.getFromString(sizeOption));

        String finishOption = printOptions.getFinishOption();
        print.setFinish(PrintFinish.getFromString(finishOption));

        String procTimeOption = printOptions.getProcTimeOption();
        print.setProcessingTime(PrintProcessingTime.getFromString(procTimeOption));

        // TODO: replace "magic strings" with constants
        if (sizeOption.equalsIgnoreCase("4x6") &&
            finishOption.equalsIgnoreCase("Matte") &&
            procTimeOption.equalsIgnoreCase("Next Day"))
        {
            print.setType(PrintType.getFromString("Standard"));
        }
        else {
            print.setType(PrintType.getFromString("Custom"));
        }
        
        model.addPrintToOrder(print);
        
        view.refreshTable();
    }
}
