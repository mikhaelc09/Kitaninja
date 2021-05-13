package istts.pbo.GamePage;

import istts.pbo.Players.Player;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class DojoPanel extends JPanel {
    ArrayList<JLabel> lbSkill =new ArrayList<>();
    JLabel btBack;
    JLabel lbSkillBox;
    JLabel lbActiveIcon;
    JLabel lbActiveName;
    JLabel lbActiveDesc;
    JLabel btLearn;
    JPanel c1;
    JPanel c2;
    int type = 0;
    Font fontlb = new Font("Ninja Naruto", Font.PLAIN, 30);
    FontMetrics fm = getFontMetrics(fontlb);
    public DojoPanel(Player p) {
        init(p);
    }

    private void init(Player p){
        setLayout(null);
        setVisible(false);

        c1 = new JPanel();
        c1.setBounds(0,0,450,720);
//        c1.setBackground(Color.yellow);
        c1.setLayout(null);
        c1.setOpaque(false);

        c2 = new JPanel();
        c2.setBounds(450,0,830,720);
//        c2.setBackground(Color.MAGENTA);
        c2.setLayout(null);
        c2.setOpaque(false);

        String pc = p.getPlayerClass().getClassname();
        if(pc.equalsIgnoreCase("Ninjutsu") || pc.equalsIgnoreCase("Kenjutsu") || pc.equalsIgnoreCase("Shurikenjustu") || pc.equalsIgnoreCase("Kayakujutsu") || pc.equalsIgnoreCase("Shinobi")){
            type = 1;
        }
        if(pc.equalsIgnoreCase("Qiqong") || pc.equalsIgnoreCase("Fire") || pc.equalsIgnoreCase("Wind") || pc.equalsIgnoreCase("Water") || pc.equalsIgnoreCase("Sand")){
            type = 2;
        }
        if(pc.equalsIgnoreCase("Taijutsu") || pc.equalsIgnoreCase("Taekwondo") || pc.equalsIgnoreCase("Kungfu") || pc.equalsIgnoreCase("Aikido") || pc.equalsIgnoreCase("Sumo")){
            type = 3;
        }

        initc1(p);
        initc2(p);

        if(type == 1){
            lbSkill.get(0).setIcon(new ImageIcon("src/istts/pbo/res/IconSkill/medium/Ninjutsu-ShurikenThrow.png"));
            lbSkill.get(1).setIcon(new ImageIcon("src/istts/pbo/res/IconSkill/medium/Ninjutsu-Backpack.png"));
            lbSkill.get(2).setIcon(new ImageIcon("src/istts/pbo/res/IconSkill/medium/Ninjutsu-Caltrops.png"));
            lbSkill.get(3).setIcon(new ImageIcon("src/istts/pbo/res/IconSkill/medium/Kenjutsu-Onigiri.png"));
            lbSkill.get(4).setIcon(new ImageIcon("src/istts/pbo/res/IconSkill/medium/Kenjutsu-HekirekiIssen.png"));
            lbSkill.get(5).setIcon(new ImageIcon("src/istts/pbo/res/IconSkill/medium/Kenjutsu-StarburstStream.png"));
            lbSkill.get(6).setIcon(new ImageIcon("src/istts/pbo/res/IconSkill/medium/Shurikenjutsu-PoisonShuriken.png"));
            lbSkill.get(7).setIcon(new ImageIcon("src/istts/pbo/res/IconSkill/medium/Shurikenjutsu-KunaiWithChain.png"));
            lbSkill.get(8).setIcon(new ImageIcon("src/istts/pbo/res/IconSkill/medium/Shurikenjutsu-Bloonjitsu.png"));
            lbSkill.get(9).setIcon(new ImageIcon("src/istts/pbo/res/IconSkill/medium/Kayakujutsu-SmokeBomb.png"));
            lbSkill.get(10).setIcon(new ImageIcon("src/istts/pbo/res/IconSkill/medium/Kayakujutsu-Flare.png"));
            lbSkill.get(11).setIcon(new ImageIcon("src/istts/pbo/res/IconSkill/medium/Kayakujutsu-C4.png"));
            lbSkill.get(12).setIcon(new ImageIcon("src/istts/pbo/res/IconSkill/medium/Shinobi-KawarimiNoJutsu.png"));
            lbSkill.get(13).setIcon(new ImageIcon("src/istts/pbo/res/IconSkill/medium/Shinobi-Chocho.png"));
            lbSkill.get(14).setIcon(new ImageIcon("src/istts/pbo/res/IconSkill/medium/Shinobi-Hakke.png"));
            lbActiveIcon.setIcon(new ImageIcon("src/istts/pbo/res/IconSkill/Ninjutsu-ShurikenThrow.png"));
            lbActiveName.setText("Shuriken Throw");
            lbSkillBox.setText(pc);
            lbActiveName.setBounds((450-fm.stringWidth(lbActiveName.getText()))/2,
                    245,
                    fm.stringWidth(lbActiveName.getText()),
                    fm.getHeight());
        }

        if(type == 2){
            lbSkill.get(0).setIcon(new ImageIcon("src/istts/pbo/res/IconSkill/medium/Qiqong-Hadouken.png"));
            lbSkill.get(1).setIcon(new ImageIcon("src/istts/pbo/res/IconSkill/medium/Qiqong-CalmMind.png"));
            lbSkill.get(2).setIcon(new ImageIcon("src/istts/pbo/res/IconSkill/medium/Qiqong-Kamehameha.png"));
            lbSkill.get(3).setIcon(new ImageIcon("src/istts/pbo/res/IconSkill/medium/Fire-Hinotama.png"));
            lbSkill.get(4).setIcon(new ImageIcon("src/istts/pbo/res/IconSkill/medium/Fire-Heatblast.png"));
            lbSkill.get(5).setIcon(new ImageIcon("src/istts/pbo/res/IconSkill/medium/Fire-Explosion.png"));
            lbSkill.get(6).setIcon(new ImageIcon("src/istts/pbo/res/IconSkill/medium/Wind-Rasengan.png"));
            lbSkill.get(7).setIcon(new ImageIcon("src/istts/pbo/res/IconSkill/medium/Wind-WindOfNature.png"));
            lbSkill.get(8).setIcon(new ImageIcon("src/istts/pbo/res/IconSkill/medium/Wind-DivineSandstorm.png"));
            lbSkill.get(9).setIcon(new ImageIcon("src/istts/pbo/res/IconSkill/medium/Water-MysticSnake.png"));
            lbSkill.get(10).setIcon(new ImageIcon("src/istts/pbo/res/IconSkill/medium/Water-WaterPrison.png"));
            lbSkill.get(11).setIcon(new ImageIcon("src/istts/pbo/res/IconSkill/medium/Water-DaigurenHyorinmaru.png"));
            lbSkill.get(12).setIcon(new ImageIcon("src/istts/pbo/res/IconSkill/medium/Sand-SandThrow.png"));
            lbSkill.get(13).setIcon(new ImageIcon("src/istts/pbo/res/IconSkill/medium/Sand-SummonTwhomp.png"));
            lbSkill.get(14).setIcon(new ImageIcon("src/istts/pbo/res/IconSkill/medium/Sand-Harden.png"));
            lbActiveIcon.setIcon(new ImageIcon("src/istts/pbo/res/IconSkill/Qiqong-Hadouken.png"));
            lbActiveName.setText("Hadouken");
            lbSkillBox.setText(pc);
            lbActiveName.setBounds((450-fm.stringWidth(lbActiveName.getText()))/2,
                    245,
                    fm.stringWidth(lbActiveName.getText()),
                    fm.getHeight());
        }

        if(type == 3){
            lbSkill.get(0).setIcon(new ImageIcon("src/istts/pbo/res/IconSkill/medium/Taijutsu-FalconPunch.png"));
            lbSkill.get(1).setIcon(new ImageIcon("src/istts/pbo/res/IconSkill/medium/Taijutsu-FusRoDah.png"));
            lbSkill.get(2).setIcon(new ImageIcon("src/istts/pbo/res/IconSkill/medium/Taijutsu-KonohaSenpu.png"));
            lbSkill.get(3).setIcon(new ImageIcon("src/istts/pbo/res/IconSkill/medium/Taekwondo-NaryeoChagi.png"));
            lbSkill.get(4).setIcon(new ImageIcon("src/istts/pbo/res/IconSkill/medium/Taekwondo-KawiChagi.png"));
            lbSkill.get(5).setIcon(new ImageIcon("src/istts/pbo/res/IconSkill/medium/Taekwondo-DollyoChagi.png"));
            lbSkill.get(6).setIcon(new ImageIcon("src/istts/pbo/res/IconSkill/medium/Kungfu-FuJowPai.png"));
            lbSkill.get(7).setIcon(new ImageIcon("src/istts/pbo/res/IconSkill/medium/Kungfu-OneInchPunch.png"));
            lbSkill.get(8).setIcon(new ImageIcon("src/istts/pbo/res/IconSkill/medium/Kungfu-DrunkenStance.png"));
            lbSkill.get(9).setIcon(new ImageIcon("src/istts/pbo/res/IconSkill/medium/Aikido-NageWaza.png"));
            lbSkill.get(10).setIcon(new ImageIcon("src/istts/pbo/res/IconSkill/medium/Aikido-UkeNagashiIrimi.png"));
            lbSkill.get(11).setIcon(new ImageIcon("src/istts/pbo/res/IconSkill/medium/Aikido-Kubishime.png"));
            lbSkill.get(12).setIcon(new ImageIcon("src/istts/pbo/res/IconSkill/medium/Sumo-Harite.png"));
            lbSkill.get(13).setIcon(new ImageIcon("src/istts/pbo/res/IconSkill/medium/Sumo-Eat.png"));
            lbSkill.get(14).setIcon(new ImageIcon("src/istts/pbo/res/IconSkill/medium/Sumo-BodySlam.png"));
            lbActiveIcon.setIcon(new ImageIcon("src/istts/pbo/res/IconSkill/Taijutsu-FalconPunch.png"));
            lbActiveName.setText("Falcon Punch");
            lbSkillBox.setText(pc);
            lbActiveName.setBounds((450-fm.stringWidth(lbActiveName.getText()))/2,
                    245,
                    fm.stringWidth(lbActiveName.getText()),
                    fm.getHeight());
        }

        lbSkill.get(0).addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(type == 1){
                    
                }
                if(type == 2){

                }
                if(type == 3){

                }
            }
        });

        add(c1);
        add(c2);
    }

    private void initc1(Player p){
        btBack = new JLabel();
        btBack.setIcon(new ImageIcon("src/istts/pbo/res/buttons/Back.png"));
        btBack.setBounds(10,20,100,50);
        btBack.setCursor(new Cursor(Cursor.HAND_CURSOR));

        lbActiveIcon = new JLabel();
//        lbActiveIcon.setBackground(Color.GREEN);
//        lbActiveIcon.setOpaque(true);
        lbActiveIcon.setBounds(165,100,120,120);

        lbActiveName = new JLabel();
        lbActiveName.setText("Nama Skill");
        lbActiveName.setFont(fontlb);
        lbActiveName.setForeground(Color.WHITE);
        lbActiveName.setBounds((450-fm.stringWidth(lbActiveName.getText()))/2,
                245,
                fm.stringWidth(lbActiveName.getText()),
                fm.getHeight());
        lbActiveDesc = new JLabel();
        lbActiveDesc.setBackground(Color.red);
        lbActiveDesc.setOpaque(true);
        lbActiveDesc.setBounds(25,
                300,
                400,
                250);

        btLearn = new JLabel("Learn");
        btLearn.setBounds(125,600,200,60);
        btLearn.setBackground(Color.orange);
        btLearn.setOpaque(true);
        btLearn.setFont(fontlb);
        btLearn.setHorizontalAlignment(SwingConstants.CENTER);
        btLearn.setVerticalAlignment(SwingConstants.CENTER);

        c1.add(btBack);
        c1.add(lbActiveIcon);
        c1.add(lbActiveName);
        c1.add(lbActiveDesc);
        c1.add(btLearn);
    }

    private void initc2(Player p){
        lbSkillBox = new JLabel();
        lbSkillBox.setText("Nama Class");
        lbSkillBox.setHorizontalAlignment(SwingConstants.CENTER);
        lbSkillBox.setVerticalAlignment(SwingConstants.NORTH);
        lbSkillBox.setBackground(Color.blue);
        lbSkillBox.setFont(fontlb);
        lbSkillBox.setForeground(Color.WHITE);
        lbSkillBox.setOpaque(true);
        lbSkillBox.setBounds(30,35, 750,650);

        for (int i = 0; i < 15; i++) {
            lbSkill.add(new JLabel());
//            lbSkill.get(i).setBackground(Color.GREEN);
//            lbSkill.get(i).setOpaque(true);
            lbSkill.get(i).setText(i+"");
        }

        lbSkill.get(0).setBounds(30 + 30,330,100,100);
        lbSkill.get(1).setBounds(30 + 145, 330, 100, 100);
        lbSkill.get(2).setBounds(30 + 260, 330, 100, 100);

        lbSkill.get(3).setBounds(30 + 375, 90+75, 100,100);
        lbSkill.get(4).setBounds(30 + 490,90+75, 100,100);
        lbSkill.get(5).setBounds(30 + 605,90+75, 100,100);

        lbSkill.get(6).setBounds(30 + 375, 200+75, 100,100);
        lbSkill.get(7).setBounds(30 + 490,200+75, 100,100);
        lbSkill.get(8).setBounds(30 + 605,200+75, 100,100);

        lbSkill.get(9).setBounds(30 + 375, 310+75, 100,100);
        lbSkill.get(10).setBounds(30 + 490,310+75, 100,100);
        lbSkill.get(11).setBounds(30 + 605,310+75, 100,100);

        lbSkill.get(12).setBounds(30 + 375, 420+75, 100,100);
        lbSkill.get(13).setBounds(30 + 490,420+75, 100,100);
        lbSkill.get(14).setBounds(30 + 605,420+75, 100,100);

        lbSkill.get(0).setIcon(new ImageIcon("src/istts/pbo/res/IconSkill/medium/Aikido-Kubishime png.png"));

        for (int i = 0; i < 15; i++) {
            c2.add(lbSkill.get(i));
        }
        c2.add(lbSkillBox);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawbg(g);
    }

    public void drawbg(Graphics g){
        try {
            BufferedImage bg = ImageIO.read(new File("src/istts/pbo/res/backgrounds/Dojo.png"));
            g.drawImage(bg, 0, 0, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
