import javax.swing.*;
import java.awt.*;

public class WiiPanel extends JPanel  {

    JButton connectButton;
    PairWii pairWii;

    public WiiPanel(){
        pairWii = new PairWii();
        setBackground(Color.magenta);
        connectButton = new JButton("CONNECT WII");
        connectButton.setBackground(Color.white);

        connectButton.addActionListener(e -> pairWii.findRemote());
        add(connectButton);
    }


}
