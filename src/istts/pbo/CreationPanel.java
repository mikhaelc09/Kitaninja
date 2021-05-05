package istts.pbo;

import javax.swing.*;
import java.awt.*;

public class CreationPanel extends JPanel {
    JLabel back;
    public CreationPanel(){
        init();

    }

    private void init(){
        setBackground(Color.YELLOW);
        setLayout(null);

        back = new JLabel("BAAACK");
        back.setBounds(200,200,50,50);
        add(back);
    }

}
