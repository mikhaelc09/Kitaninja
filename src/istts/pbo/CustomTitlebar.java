package istts.pbo;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

import static istts.pbo.Main.SWIDTH;


public class CustomTitlebar extends JPanel {
    private JLabel lbTitle;
    private JLabel lbExit;
    private Font f = new Font("Arial", Font.BOLD, 20);
    private Color c = new Color(200,200,200);

    public CustomTitlebar() {
        init();
    }

    private void init(){
        setBackground(new Color(96,101,95));
        setLayout(null);
        ImageIcon icon = new ImageIcon("src/istts/pbo/res/Icon.png");

        lbTitle = new JLabel("  Kitaninja");
        lbTitle.setFont(f);
        lbTitle.setForeground(c);
        lbTitle.setIcon(icon);
        lbTitle.setBounds(10,0,400,40);

        lbExit = new JLabel("  X");
        lbExit.setFont(f);
        lbExit.setForeground(c);
        lbExit.setBounds(SWIDTH-60,0,40,40);
        lbExit.setCursor(new Cursor(Cursor.HAND_CURSOR));

        add(lbTitle);
        add(lbExit);
    }

    public JLabel getLbTitle() {
        return lbTitle;
    }

    public void setLbTitle(JLabel lbTitle) {
        this.lbTitle = lbTitle;
    }

    public JLabel getLbExit() {
        return lbExit;
    }

    public void setLbExit(JLabel lbExit) {
        this.lbExit = lbExit;
    }

    public Font getF() {
        return f;
    }

    public void setF(Font f) {
        this.f = f;
    }

    public Color getC() {
        return c;
    }

    public void setC(Color c) {
        this.c = c;
    }
}
