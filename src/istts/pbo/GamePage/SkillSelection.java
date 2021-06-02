package istts.pbo.GamePage;

import istts.pbo.Classes.Taijutsu;
import istts.pbo.Players.Player;
import istts.pbo.Players.skilltrees.skills.Skill;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SkillSelection extends JFrame {
    Player p;
    Skill selected;
    JPanel parent;
    ArrayList<JLabel> skillIcons;

    public SkillSelection(){
        p = new Player("Tester", new Taijutsu());
        selected = (Skill) p.getPlayerClass().getSkillTree().getSkills().get(0);

        init();
//        lbSkillBox.setBorder(BorderFactory.createLineBorder(Color.RED,5,true));

    }

    public SkillSelection(Player p, Skill selected) {
        this.p = p;
        this.selected = selected;

        init();
    }

    private void init() {

        setSize(new Dimension(700,450));
        setLocationRelativeTo(null);
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setBackground(Color.ORANGE);
        setResizable(false);
        setUndecorated(true);
        setVisible(true);

        parent = new JPanel();
        parent.setBounds(0,0,this.getWidth(),this.getHeight());
        parent.setSize(new Dimension(700,450));
        parent.setBackground(Color.BLACK);
        parent.setOpaque(true);
        parent.setLayout(null);
        parent.setPreferredSize(new Dimension(700,450));

        add(parent);

        setContentPane(parent);

        JLabel lbSkillBox = new JLabel();
        lbSkillBox.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lbSkillBox.setBounds(0,0, 450, 450);
        lbSkillBox.setBackground(Color.cyan);
        lbSkillBox.setOpaque(true);
        lbSkillBox.setLayout(new GridLayout(3,5));
        parent.add(lbSkillBox);

        JLabel lbActiveBox = new JLabel();
        lbActiveBox.setBounds(450,0, 300, 450);
        lbActiveBox.setBackground(Color.GREEN);
        lbActiveBox.setOpaque(true);
        parent.add(lbActiveBox);

        for (int i = 0; i < 15; i++) {
            Skill temp = (Skill) p.getPlayerClass().getSkillTree().getAt(i);
            skillIcons.add(new JLabel());
            skillIcons.get(i).setIcon();
        }
    }

}
