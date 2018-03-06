package control;

import model.PPSModel;
import view.PPSView;

public class PPSControl {

    private PPSView view;
    private PPSModel model;

    public PPSControl(PPSView view, PPSModel model) {
        this.view = view;
        this.model = model;

        view.setAddPrintAction(new AddPrintAction(view, model));
    }

    public void showView(boolean visible) {
        view.setVisible(visible);
    }
}
