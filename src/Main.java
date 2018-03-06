import control.PPSControl;
import model.PPSModel;
import view.PPSView;

import javax.swing.*;

public class Main {

        private static void createAndShowGui() {
            PPSView view = new PPSView("PPS");
            PPSModel model = new PPSModel();
            PPSControl control = new PPSControl(view, model);

            control.showView(true);
        }

        public static void main(String[] args) {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    createAndShowGui();
                }
            });
        }
}
