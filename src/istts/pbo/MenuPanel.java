package istts.pbo;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static istts.pbo.Main.*;

public class MenuPanel extends JPanel {
    JLabel lbSetting;
    JLabel lbNewGame;
    JLabel lbLoadGame;
    JLabel lbAbout;
    JLabel lbExit;
    JLabel lbAboutText;

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

        lbLoadGame = new JLabel();
        lbLoadGame.setBounds((SWIDTH-270)/2, 350, 300,120);
        lbLoadGame.setIcon(new ImageIcon("src/istts/pbo/res/newGame.png"));
        lbLoadGame.setCursor(new Cursor(Cursor.HAND_CURSOR));

        lbAbout = new JLabel();
        lbAbout.setBounds((SWIDTH-270)/2, 450, 300,120);
        lbAbout.setIcon(new ImageIcon("src/istts/pbo/res/newGame.png"));
        lbAbout.setCursor(new Cursor(Cursor.HAND_CURSOR));

        lbExit = new JLabel();
        lbExit.setBounds((SWIDTH-270)/2, 550, 300,120);
        lbExit.setIcon(new ImageIcon("src/istts/pbo/res/newGame.png"));
        lbExit.setCursor(new Cursor(Cursor.HAND_CURSOR));

        lbAboutText = new JLabel();
        lbAboutText.setBounds((SWIDTH-600)/2, 200, 600,400);
        lbAboutText.setIcon(new ImageIcon("src/istts/pbo/res/about.png"));
        lbAboutText.setVisible(false);

        add(lbAboutText);
        add(lbNewGame);
        add(lbSetting);
        add(lbLoadGame);
        add(lbAbout);
        add(lbExit);

        lbAbout.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                lbAboutText.setVisible(true);
            }
        });

        lbAboutText.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                lbAboutText.setVisible(false);
            }
        });
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
