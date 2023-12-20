import javax.swing.*;

public class WiiFrame extends JFrame {

    WiiPanel wiiPanel;
    public WiiFrame(){
        setSize(300,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        wiiPanel = new WiiPanel();

        add(wiiPanel);
        setVisible(true);
    }

}
