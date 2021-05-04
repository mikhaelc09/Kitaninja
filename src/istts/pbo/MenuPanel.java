package istts.pbo;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static istts.pbo.Main.*;

public class MenuPanel extends JPanel {
    JLabel lbSetting;
    JLabel lbNewGame;

    public MenuPanel() {
        setBackground(Color.BLACK);
        setLayout(null);

        lbSetting = new JLabel();
        lbSetting.setBounds(SWIDTH-100,SHEIGHT-150, 100,100);
        lbSetting.setIcon(new ImageIcon("src/istts/pbo/res/gear4.png"));
        lbSetting.setCursor(new Cursor(Cursor.HAND_CURSOR));

        lbNewGame = new JLabel();
        lbNewGame.setBounds((SWIDTH-270)/2, 250, 300,120);
        lbNewGame.setIcon(new ImageIcon("src/istts/pbo/res/newGame.png"));
        lbNewGame.setCursor(new Cursor(Cursor.HAND_CURSOR));

        add(lbNewGame);
        add(lbSetting);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    private void draw(Graphics g){
        try {
            BufferedImage bg = ImageIO.read(new File("src/istts/pbo/res/MainMenu2.png"));
            g.drawImage(bg,0,0,null);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
