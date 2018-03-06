import gui.PPSFrame;

public class Main {
    public static void main(String[] args) {
        PPSFrame frame = new PPSFrame();
        PPSFrame.setupSettingsPanel();
        PPSFrame.setupInfoPanel();
        frame.setVisible(true);
    }
}
