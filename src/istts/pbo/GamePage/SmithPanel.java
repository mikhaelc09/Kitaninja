package istts.pbo.GamePage;

import istts.pbo.Players.*;
import istts.pbo.Players.skilltrees.skills.Skill;

import javax.swing.*;
import javax.imageio.ImageIO;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class SmithPanel extends JPanel {
    ArrayList<upgradelabel> lbItemUpgrade = new ArrayList<>();
    JLabel TombolBack;
    JLabel lbItem;
    JLabel listitem;
    JLabel Equipment;
    JLabel stat;
    int uang = 0;
    int upgradecounter;
    JLabel lbIconItemSmith;
    JLabel btUp;
    JLabel upgradeitem;
    JLabel Uangmu;
    JPanel a1;
    JPanel a2;
    int type = 0;
    Font fontlb = new Font("Ninja Naruto", Font.PLAIN, 30);
    FontMetrics fm = getFontMetrics(fontlb);

    public SmithPanel(Player a) {
        init(a);
    }

    private void init(Player a) {
        setLayout(null);
        setVisible(false);

        a1 = new JPanel();
        a1.setBounds(0, 0, 450, 720);
        a1.setLayout(null);
        a1.setOpaque(false);

        a2 = new JPanel();
        a2.setBounds(450, 0, 830, 720);
        a2.setLayout(null);
        a2.setOpaque(false);

        initc1(a);
        initc2(a);

        add(a1);
        add(a2);
    }

    private void initc1(Player p) {
        TombolBack = new JLabel();
        TombolBack.setIcon(new ImageIcon("src/istts/pbo/res/buttons/Back.png"));
        TombolBack.setBounds(10, 20, 100, 50);
        TombolBack.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Equipment = new JLabel();
        Equipment.setText("Equipment");
        Equipment.setFont(fontlb);
        Equipment.setForeground(Color.WHITE);
        Equipment.setBounds((450 - fm.stringWidth(Equipment.getText())) / 2, 245, fm.stringWidth(Equipment.getText()), fm.getHeight());
        //icon item
        lbIconItemSmith = new JLabel();
        lbIconItemSmith.setBackground(Color.blue);
        lbIconItemSmith.setOpaque(false);
        lbIconItemSmith.setBounds(125, 50, 200, 200);

        btUp = new JLabel("Upgrade");
        btUp.setBounds(125, 600, 200, 50);
        btUp.setBackground(Color.orange);
        btUp.setOpaque(true);
        btUp.setFont(fontlb);
        btUp.setHorizontalAlignment(SwingConstants.CENTER);
        btUp.setVerticalAlignment(SwingConstants.CENTER);
        btUp.setCursor(new Cursor(Cursor.HAND_CURSOR));

        this.btUp.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(p.getGold()>=p.getItems().get(upgradecounter).getUpgradecost()){
                    p.setGold(p.getGold()-p.getItems().get(upgradecounter).getUpgradecost());
                    Uangmu.setText("Gold "+p.getGold());
                    p.getItems().get(upgradecounter).setStat(p.getItems().get(upgradecounter).getStat() + p.getItems().get(upgradecounter).getStat()*30/100);
                    if (p.getItems().get(upgradecounter) instanceof Weapon){
                        stat.setText("Attack "+p.getItems().get(upgradecounter).getStat());
                    }else if (p.getItems().get(upgradecounter) instanceof Helmet){
                        stat.setText("HP "+p.getItems().get(upgradecounter).getStat());
                    }else if (p.getItems().get(upgradecounter) instanceof Body){
                        stat.setText("Def "+p.getItems().get(upgradecounter).getStat());
                    }else if (p.getItems().get(upgradecounter) instanceof Boots){
                        stat.setText("Speed "+p.getItems().get(upgradecounter).getStat());
                    }else if (p.getItems().get(upgradecounter) instanceof Accesories){
                        stat.setText("Mana "+p.getItems().get(upgradecounter).getStat());
                    }
                }
            }
        });

        Uangmu = new JLabel("Gold " + p.getGold());
        Uangmu.setBounds(125, 500, 200, 50);
        Uangmu.setBackground(Color.orange);
        Uangmu.setOpaque(true);
        Uangmu.setFont(fontlb);
        Uangmu.setHorizontalAlignment(SwingConstants.CENTER);
        Uangmu.setVerticalAlignment(SwingConstants.CENTER);

        upgradeitem = new JLabel("Cost " +0);
        upgradeitem.setBounds(125, 400, 200, 50);
        upgradeitem.setBackground(Color.orange);
        upgradeitem.setOpaque(true);
        upgradeitem.setFont(fontlb);
        upgradeitem.setHorizontalAlignment(SwingConstants.CENTER);
        upgradeitem.setVerticalAlignment(SwingConstants.CENTER);

        stat = new JLabel("Stat 0");
        stat.setBounds(125, 300, 200, 50);
        stat.setBackground(Color.orange);
        stat.setOpaque(true);
        stat.setFont(fontlb);
        stat.setHorizontalAlignment(SwingConstants.CENTER);
        stat.setVerticalAlignment(SwingConstants.CENTER);


        a1.add(TombolBack);
        a1.add(Uangmu);
        a1.add(btUp);
        a1.add(upgradeitem);
        a1.add(lbIconItemSmith);
        a1.add(stat);
    }

    private void initc2(Player p) {

        lbItem = new JLabel();
        lbItem.setHorizontalAlignment(SwingConstants.CENTER);
        lbItem.setVerticalAlignment(SwingConstants.NORTH);
        lbItem.setIcon(new ImageIcon("src/istts/pbo/res/Tab/SmithTab1.png"));
        lbItem.setFont(fontlb);
        lbItem.setForeground(Color.WHITE);
        lbItem.setOpaque(false);
        lbItem.setBounds(55, 27, 700, 680);
        for (int i = 0; i < 25; i++) {
            lbItemUpgrade.add(new upgradelabel());
            lbItemUpgrade.get(i).setText(i + "");
            lbItemUpgrade.get(i).setCursor(new Cursor(Cursor.HAND_CURSOR));
            upgradelabel x = lbItemUpgrade.get(i);
            int sel = i;
            lbItemUpgrade.get(i).addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
//                    lbIconItemSmith.setIcon(resizeIcon((ImageIcon) x.getIcon(),120,120));
//                    lbIconItemSmith.setBounds((450-fm.stringWidth(lbIconItemSmith.getText()))/2,
//                            245,
//                            fm.stringWidth(lbIconItemSmith.getText()),
//                            fm.getHeight());
                    lbIconItemSmith.setIcon(im.resizeIcon(p.getItems().get(sel).getSpritePath(), 200, 200));
                    upgradeitem.setText("Cost " + p.getItems().get(sel).getUpgradecost());
                    upgradecounter=sel;
                    if (p.getItems().get(sel) instanceof Weapon){
                        stat.setText("Attack "+p.getItems().get(sel).getStat());
                    }else if (p.getItems().get(sel) instanceof Helmet){
                        stat.setText("HP "+p.getItems().get(sel).getStat());
                    }else if (p.getItems().get(sel) instanceof Body){
                        stat.setText("Def "+p.getItems().get(sel).getStat());
                    }else if (p.getItems().get(sel) instanceof Boots){
                        stat.setText("Speed "+p.getItems().get(sel).getStat());
                    }else if (p.getItems().get(sel) instanceof Accesories){
                        stat.setText("Mana "+p.getItems().get(sel).getStat());
                    }
                }
            });
        }
        lbItemUpgrade.get(0).setBounds(80, 45, 120, 120);
        lbItemUpgrade.get(1).setBounds(210, 45, 120, 120);
        lbItemUpgrade.get(2).setBounds(340, 45, 120, 120);
        lbItemUpgrade.get(3).setBounds(470, 45, 120, 120);
        lbItemUpgrade.get(4).setBounds(600, 45, 120, 120);

        lbItemUpgrade.get(5).setBounds(80, 175, 120, 120);
        lbItemUpgrade.get(6).setBounds(210, 175, 120, 120);
        lbItemUpgrade.get(7).setBounds(340, 175, 120, 120);
        lbItemUpgrade.get(8).setBounds(470, 175, 120, 120);
        lbItemUpgrade.get(9).setBounds(600, 175, 120, 120);

        lbItemUpgrade.get(10).setBounds(80, 305, 120, 120);
        lbItemUpgrade.get(11).setBounds(210, 305, 120, 120);
        lbItemUpgrade.get(12).setBounds(340, 305, 120, 120);
        lbItemUpgrade.get(13).setBounds(470, 305, 120, 120);
        lbItemUpgrade.get(14).setBounds(600, 305, 120, 120);

        lbItemUpgrade.get(15).setBounds(80, 435, 120, 120);
        lbItemUpgrade.get(16).setBounds(210, 435, 120, 120);
        lbItemUpgrade.get(17).setBounds(340, 435, 120, 120);
        lbItemUpgrade.get(18).setBounds(470, 435, 120, 120);
        lbItemUpgrade.get(19).setBounds(600, 435, 120, 120);

        lbItemUpgrade.get(20).setBounds(80, 565, 120, 120);
        lbItemUpgrade.get(21).setBounds(210, 565, 120, 120);
        lbItemUpgrade.get(22).setBounds(340, 565, 120, 120);
        lbItemUpgrade.get(23).setBounds(470, 565, 120, 120);
        lbItemUpgrade.get(24).setBounds(600, 565, 120, 120);

        for (int i = 0; i < 25; i++) {
            lbItemUpgrade.get(i).setOpaque(false);
            lbItemUpgrade.get(i).setBackground(Color.red);
            lbItemUpgrade.get(i).setIcon(new ImageIcon(p.getItems().get(i).getSpritePath()));
            a2.add(lbItemUpgrade.get(i));
        }
        a2.add(lbItem);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawbg(g);
    }

    public void drawbg(Graphics g) {
        try {
            BufferedImage bg = ImageIO.read(new File("src/istts/pbo/res/backgrounds/smith.png"));
            g.drawImage(bg, 0, 0, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ImageIcon resizeIcon(String im, int w, int h) {
        return new ImageIcon(new ImageIcon(im).getImage().getScaledInstance(w, h, Image.SCALE_DEFAULT));
    }

    public ImageIcon resizeIcon(ImageIcon im, int w, int h) {
        return new ImageIcon(im.getImage().getScaledInstance(w, h, Image.SCALE_DEFAULT));
    }
}

class upgradelabel extends JLabel {
    int cost;

    public upgradelabel() {
        cost = 0;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public upgradelabel(int cost) {
        this.cost = cost;
    }
}