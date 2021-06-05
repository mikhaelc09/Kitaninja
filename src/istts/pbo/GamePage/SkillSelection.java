package istts.pbo.GamePage;

import istts.pbo.Classes.Taijutsu;
import istts.pbo.Players.Player;
import istts.pbo.Players.skilltrees.skills.Skill;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class SkillSelection extends JFrame {
    Player p;
    Skill selected;
    int index;
    JPanel parent;
    ArrayList<JLabel> skillIcons = new ArrayList<>();
    JLabel chosen;
    JLabel chosenIcon;
    JLabel chosenName;
    private int screenwidth = 700;
    private int screenheight = 270;

    public SkillSelection(){
        p = new Player("Tester", new Taijutsu());
        selected = (Skill) p.getPlayerClass().getSkillTree().getSkills().get(0);
        System.out.println(selected);
        index = 0;

        init();

    }

    public SkillSelection(Player p, Skill selected, int index, JLabel chosenIcon, JLabel chosenName) {
        this.p = p;
        this.selected = selected;
        this.index = index;
        this.chosenIcon = chosenIcon;
        this.chosenName = chosenName;

        init();
    }

    private void init() {

        setSize(new Dimension(screenwidth,screenheight));
        setLocationRelativeTo(null);
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setBackground(Color.ORANGE);
        setResizable(false);
        setUndecorated(true);
        setVisible(true);

        parent = new JPanel();
        parent.setBounds(0,0,this.getWidth(),this.getHeight());
        parent.setSize(new Dimension(screenwidth,screenheight));
        parent.setBackground(Color.BLACK);
        parent.setOpaque(true);
        parent.setLayout(null);
        parent.setPreferredSize(new Dimension(screenwidth,screenheight));

        add(parent);

        setContentPane(parent);

        JPanel SkillBoxPane = new JPanel();
        SkillBoxPane.setBounds(10,10, 430, screenheight-20);
        SkillBoxPane.setBackground(Color.cyan);
        SkillBoxPane.setOpaque(true);
        SkillBoxPane.setLayout(new GridLayout(3,5,10,10));


        JPanel ActiveBoxPane = new JPanel();
        ActiveBoxPane.setBounds(450,0, 250, screenheight);
        ActiveBoxPane.setBackground(Color.GREEN);
        ActiveBoxPane.setOpaque(true);
        ActiveBoxPane.setLayout(null);

        JLabel activeIcon = new JLabel();
        activeIcon.setBounds(65,30,120,120);
        activeIcon.setBackground(Color.orange);
        activeIcon.setOpaque(false);
        if(selected != null) {
            activeIcon.setIcon(im.getLIcon(selected.getIconPath()));
        }

        JLabel activeName = new JLabel("Nama Skill");
        activeName.setFont(new Font("Arial",  Font.BOLD,25));
        FontMetrics fm = getFontMetrics(activeName.getFont());
        activeName.setOpaque(false);
        activeName.setForeground(Color.white);
        if(selected != null) {
            activeName.setText(selected.getName());
        }
        activeName.setBounds((250-fm.stringWidth(activeName.getText()))/2,160,fm.stringWidth(activeName.getText()),fm.getHeight());
//        activeName.setBackground(Color.blue);

        JPanel buttonsPane = new JPanel();
        buttonsPane.setBounds(0,200,250,70);
        buttonsPane.setBackground(Color.PINK);
        buttonsPane.setOpaque(true);
        buttonsPane.setLayout(null);

        JLabel btConfirm = new JLabel("Equip");
        JLabel btCancel = new JLabel("Exit");

        btConfirm.setBounds(130,15, 80, 40);
        btConfirm.setBackground(Color.red);
        btConfirm.setHorizontalAlignment(SwingConstants.CENTER);
        btConfirm.setOpaque(true);
        btConfirm.setFont(new Font("Arial", Font.BOLD, 20));
        btConfirm.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btConfirm.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
//                p.getEquippedSkills()[index] = selected;
                for (int i = 0; i < p.getPlayerClass().getSkillTree().getSkills().size(); i++) {
                    Skill t = (Skill) p.getPlayerClass().getSkillTree().getAt(i);
                    if(t.getName().equalsIgnoreCase(activeName.getText())){
                        boolean cek = true;
                        for (int j = 0; j < 3; j++) {
                            if(p.getEquippedSkills()[j]==t){
                                cek = false;
                            }
                        }
                        if(cek) {
                            p.getEquippedSkills()[index] = t;
                            chosenIcon.setIcon(im.getSIcon((ImageIcon) activeIcon.getIcon()));
                            chosenName.setText(activeName.getText());
                            exit();
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Skill Already Equipped!");
                        }
                        break;
                    }
                }
            }
        });

        btCancel.setBounds(40,15,80,40);
        btCancel.setBackground(Color.GREEN);
        btCancel.setHorizontalAlignment(SwingConstants.CENTER);
        btCancel.setOpaque(true);
        btCancel.setFont(new Font("Arial", Font.BOLD, 20));
        btCancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btCancel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                exit();
            }
        });

        buttonsPane.add(btConfirm);
        buttonsPane.add(btCancel);

        ActiveBoxPane.repaint();
        ActiveBoxPane.revalidate();

        ActiveBoxPane.add(activeIcon);
        ActiveBoxPane.add(activeName);
        ActiveBoxPane.add(buttonsPane);


        for (int i = 0; i < 15; i++) {
            Skill temp = (Skill) p.getPlayerClass().getSkillTree().getAt(i);
            skillIcons.add(new JLabel());
//            skillIcons.get(i).setText("AAA");
            skillIcons.get(i).setCursor(new Cursor(Cursor.HAND_CURSOR));
            skillIcons.get(i).setBackground(Color.orange);
            skillIcons.get(i).setOpaque(true);
            skillIcons.get(i).setIcon(im.resizeIcon(new ImageIcon(temp.getIconPath()),80,80));
            if(!((Skill)p.getPlayerClass().getSkillTree().getSkills().get(i)).isUnlocked()){
                skillIcons.get(i).setIcon(im.grayscaleIcon((ImageIcon) skillIcons.get(i).getIcon()));
            }
            else {
                skillIcons.get(i).addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if(chosen!= null) {
                            chosen.setBorder(null);
                        }
                        chosen = (JLabel) e.getSource();
                        chosen.setBorder(BorderFactory.createLineBorder(Color.orange, 5));
                        activeIcon.setIcon(im.getLIcon((ImageIcon) chosen.getIcon()));
                        activeName.setText(((Skill) p.getPlayerClass().getSkillTree().getSkills().get(skillIcons.indexOf(chosen))).getName());
                        activeName.setBounds((250 - fm.stringWidth(activeName.getText())) / 2, 160, fm.stringWidth(activeName.getText()), fm.getHeight());
                    }
                });
            }
            SkillBoxPane.add(skillIcons.get(i));
//            System.out.println(skillIcons.get(i));
            if(temp == selected){
                chosen = skillIcons.get(i);
                chosen.setBorder(BorderFactory.createLineBorder(Color.orange,5));
            }
        }

        parent.add(SkillBoxPane);
        parent.add(ActiveBoxPane);
        parent.repaint();
        parent.revalidate();
    }

    private void exit(){
        dispose();
    }

}
