package istts.pbo.GamePage;

import istts.pbo.Players.Player;
import javax.swing.*;
import javax.imageio.ImageIO;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class SmithPanel extends JPanel{
    ArrayList<skillLabel> lbSkill =new ArrayList<>();
    JLabel TombolBack;
    JLabel lbItem;
    JLabel listitem;
    JLabel Equipment;
    int uang=0;
    JLabel lbDeskrpsi;
    JLabel btUp;
    JLabel Gold;
    JLabel Uangmu;
    JPanel a1;
    JPanel a2;
    int type = 0;
    Font fontlb = new Font("Ninja Naruto", Font.PLAIN, 30);
    FontMetrics fm = getFontMetrics(fontlb);
    public SmithPanel(Player a) {
        init(a);
    }

    private void init(Player a){
        setLayout(null);
        setVisible(false);

        a1 = new JPanel();
        a1.setBounds(0,0,450,720);
        a1.setLayout(null);
        a1.setOpaque(false);

        a2 = new JPanel();
        a2.setBounds(450,0,830,720);
        a2.setLayout(null);
        a2.setOpaque(false);

        initc1(a);
        initc2(a);

        add(a1);
        add(a2);
    }

    private void initc1(Player p){
        TombolBack = new JLabel();
        TombolBack.setIcon(new ImageIcon("src/istts/pbo/res/buttons/Back.png"));
        TombolBack.setBounds(10,20,100,50);
        TombolBack.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Equipment = new JLabel();
        Equipment.setText("Equipment");
        Equipment.setFont(fontlb);
        Equipment.setForeground(Color.WHITE);
        Equipment.setBounds((450-fm.stringWidth(Equipment.getText()))/2, 245, fm.stringWidth(Equipment.getText()), fm.getHeight());
        lbDeskrpsi = new JLabel();
        lbDeskrpsi.setBackground(Color.blue);
        lbDeskrpsi.setOpaque(true);
        lbDeskrpsi.setBounds(125, 150, 200, 200);
        btUp = new JLabel("Upgrade");
        btUp.setBounds(125,600,200,50);
        btUp.setBackground(Color.orange);
        btUp.setOpaque(true);
        btUp.setFont(fontlb);
        btUp.setHorizontalAlignment(SwingConstants.CENTER);
        btUp.setVerticalAlignment(SwingConstants.CENTER);

        Uangmu = new JLabel("Gold "+uang);
        Uangmu.setBounds(125,500,200,50);
        Uangmu.setBackground(Color.orange);
        Uangmu.setOpaque(true);
        Uangmu.setFont(fontlb);
        Uangmu.setHorizontalAlignment(SwingConstants.CENTER);
        Uangmu.setVerticalAlignment(SwingConstants.CENTER);

        Gold = new JLabel("Cost "+uang);
        Gold.setBounds(125,400,200,50);
        Gold.setBackground(Color.orange);
        Gold.setOpaque(true);
        Gold.setFont(fontlb);
        Gold.setHorizontalAlignment(SwingConstants.CENTER);
        Gold.setVerticalAlignment(SwingConstants.CENTER);

        a1.add(TombolBack);
        a1.add(btUp);
        a1.add(Uangmu);
        a1.add(Gold);
        a1.add(lbDeskrpsi);
    }

    private void initc2(Player p){
        lbItem = new JLabel();
        lbItem.setText("Equipment List");
        lbItem.setHorizontalAlignment(SwingConstants.CENTER);
        lbItem.setVerticalAlignment(SwingConstants.NORTH);
        lbItem.setBackground(Color.black);
        lbItem.setFont(fontlb);
        lbItem.setForeground(Color.WHITE);
        lbItem.setOpaque(true);
        lbItem.setBounds(30,35, 750,650);

        a2.add(lbItem);
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawbg(g);
    }

    public void drawbg(Graphics g){
        try {
            BufferedImage bg = ImageIO.read(new File("src/istts/pbo/res/backgrounds/smith.png"));
            g.drawImage(bg, 0, 0, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

