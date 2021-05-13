package istts.pbo.GamePage;

import istts.pbo.Players.Player;

import javax.swing.*;
import java.awt.*;
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
    Font fontlb = new Font("Ninja Naruto", Font.PLAIN, 30);
    FontMetrics fm = getFontMetrics(fontlb);
    public DojoPanel(Player p) {
        init(p);
    }

    private void init(Player p){
        setBackground(Color.orange);
        setLayout(null);
        setVisible(false);

        c1 = new JPanel();
        c1.setBounds(0,0,450,720);
        c1.setBackground(Color.yellow);
        c1.setLayout(null);
        c1.setOpaque(true);

        c2 = new JPanel();
        c2.setBounds(450,0,830,720);
        c2.setBackground(Color.MAGENTA);
        c2.setLayout(null);
        c2.setOpaque(true);

        initc1(p);
        initc2(p);
        add(c1);
        add(c2);
    }

    private void initc1(Player p){
        btBack = new JLabel();
        btBack.setIcon(new ImageIcon("src/istts/pbo/res/buttons/Back.png"));
        btBack.setBounds(10,20,100,50);
        btBack.setCursor(new Cursor(Cursor.HAND_CURSOR));

        lbActiveIcon = new JLabel();
        lbActiveIcon.setBackground(Color.GREEN);
        lbActiveIcon.setOpaque(true);
        lbActiveIcon.setBounds(165,100,120,120);

        lbActiveName = new JLabel();
        lbActiveName.setText("Nama Skill");
        lbActiveName.setFont(fontlb);
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
            lbSkill.get(i).setBackground(Color.GREEN);
            lbSkill.get(i).setOpaque(true);
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
}
