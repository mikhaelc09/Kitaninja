package istts.pbo.GamePage;

import istts.pbo.Players.Player;
import istts.pbo.Players.skilltrees.skills.Skill;

import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static istts.pbo.GamePage.im.*;

public class DojoPanel extends JPanel {
    ArrayList<skillLabel> lbSkill =new ArrayList<>();
    JLabel btBack;
    JLabel lbSkillBox;
    JLabel lbActiveIcon;
    JLabel lbActiveName;
    JLabel lbActiveDesc;
    JLabel btLearn;
    JLabel lbSkillPoint;
    JPanel c1;
    JPanel c2;
    int active = 0;
    String wrapFormat = "<html><body style=\"text-align: justify;  text-justify: inter-word;\">%s</body></html>";
    Font fontlb = new Font("Ninja Naruto", Font.PLAIN, 30);
    FontMetrics fm = getFontMetrics(fontlb);


    public DojoPanel(Player p) {
//        p.setSkillPoint(5);
        init(p);
    }

    private void init(Player p){
        setLayout(null);
        setVisible(false);

        c1 = new JPanel();
        c1.setBounds(0,0,450,720);
        c1.setLayout(null);
        c1.setOpaque(false);

        c2 = new JPanel();
        c2.setBounds(450,0,830,720);
        c2.setLayout(null);
        c2.setOpaque(false);


        String pc = p.getPlayerClass().getClassname();

        initc1(p);
        initc2(p);


        for (int i = 0; i < 15; i++) {
            lbSkill.get(i).setIcon(resizeIcon(new ImageIcon(((Skill)p.getPlayerClass().getSkillTree().getAt(i)).getIconPath()),100,100));
            lbSkill.get(i).setName(((Skill) p.getPlayerClass().getSkillTree().getAt(i)).getName());
            lbSkill.get(i).setDesc(((Skill)p.getPlayerClass().getSkillTree().getAt(i)).getDescription());
        }
        lbSkillBox.setText(pc);
        lbActiveName.setBounds((450-fm.stringWidth(lbActiveName.getText()))/2,
                245,
                fm.stringWidth(lbActiveName.getText()),
                fm.getHeight());

//        lbClass = new JLabel(pc);
//        lbClass.setFont(fontlb);
//        lbClass.setBounds();
//        c2.add(lbClass);

        lbActiveName.setText(lbSkill.get(active).getName());
        lbActiveIcon.setIcon(resizeIcon((ImageIcon) lbSkill.get(active).getIcon(),120,120));
        lbActiveDesc.setText(String.format(wrapFormat,lbSkill.get(active).getDesc()));
//        String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla ac lectus at elit rhoncus laoreet non vel lorem. Morbi quam eros, malesuada a venenatis venenatis, aliquam ac leo. In rhoncus lectus eros, id sollicitudin orci pharetra nec. Sed libero arcu .";
//        lbActiveDesc.setText(String.format(wrapFormat, text));
        lbActiveName.setBounds((450-fm.stringWidth(lbActiveName.getText()))/2,
                245,
                fm.stringWidth(lbActiveName.getText()),
                fm.getHeight());

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
//        lbActiveDesc.setBackground(Color.red);
//        lbActiveDesc.setOpaque(true);
        lbActiveDesc.setFont(new Font("Ninja Naruto", Font.PLAIN, 25));
        lbActiveDesc.setHorizontalAlignment(SwingConstants.CENTER);
        lbActiveDesc.setBounds(65,
                300,
                360,
                250);

        btLearn = new JLabel("Learn");
        btLearn.setBounds(125,600,200,60);
        btLearn.setBackground(Color.gray);
        btLearn.setOpaque(true);
        btLearn.setFont(fontlb);
        btLearn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btLearn.setHorizontalAlignment(SwingConstants.CENTER);
        btLearn.setVerticalAlignment(SwingConstants.CENTER);
        btLearn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Skill selectedSkill = ((Skill)p.getPlayerClass().getSkillTree().getAt(active));
                if(!selectedSkill.isUnlocked() && p.getSkillPoint() > 0) {
                    selectedSkill.setUnlocked(true);
                    btLearn.setBackground(Color.gray);
                    String soundName = "src/istts/pbo/res/audio/sfx/Dojo.wav";
                    p.setSkillPoint(p.getSkillPoint()-1);
                    lbSkillPoint.setText("Skill Point : "+p.getSkillPoint());
                    AudioInputStream audioInputStream = null;

                    try {
                        audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
                    } catch (UnsupportedAudioFileException | IOException unsupportedAudioFileException) {
                        unsupportedAudioFileException.printStackTrace();
                    }

                    Clip dojosound = null;

                    try {
                        dojosound = AudioSystem.getClip();
                    } catch (LineUnavailableException lineUnavailableException) {
                        lineUnavailableException.printStackTrace();
                    }

                    try {
                        dojosound.open(audioInputStream);
                    } catch (LineUnavailableException | IOException lineUnavailableException) {
                        lineUnavailableException.printStackTrace();
                    }

                    dojosound.start();
                }
            }
        });

        lbSkillPoint = new JLabel("Skill Point : "+p.getSkillPoint());
        lbSkillPoint.setFont(new Font("Comic Sans", Font.BOLD,30));
        FontMetrics fma = getFontMetrics(lbSkillPoint.getFont());
        lbSkillPoint.setBounds((450-fma.stringWidth(lbSkillPoint.getText()))/2,550,fma.stringWidth(lbSkillPoint.getText()),60);

        c1.add(btBack);
        c1.add(lbActiveIcon);
        c1.add(lbActiveName);
        c1.add(lbActiveDesc);
        c1.add(btLearn);
        c1.add(lbSkillPoint);
    }

    private void initc2(Player p){
        lbSkillBox = new JLabel();
        lbSkillBox.setText("Nama Class");
        lbSkillBox.setHorizontalAlignment(SwingConstants.CENTER);
        lbSkillBox.setVerticalAlignment(SwingConstants.NORTH);
        lbSkillBox.setBackground(Color.blue);
        lbSkillBox.setFont(fontlb);
//        lbSkillBox.setForeground(Color.WHITE);
//        lbSkillBox.setOpaque(true);
        lbSkillBox.setBounds(30,35, 750,650);
        lbSkillBox.setIcon(resizeIcon("src/istts/pbo/res/papan.png", 755, 650));

        for (int i = 0; i < 15; i++) {
            lbSkill.add(new skillLabel());
//            lbSkill.get(i).setBackground(Color.GREEN);
//            lbSkill.get(i).setOpaque(true);
            lbSkill.get(i).setText(i+"");
            lbSkill.get(i).setCursor(new Cursor(Cursor.HAND_CURSOR));
            skillLabel x = lbSkill.get(i);
            int sel = i;
            lbSkill.get(i).addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    lbActiveIcon.setIcon(resizeIcon((ImageIcon) x.getIcon(),120,120));
                    lbActiveName.setText(x.getName());
                    lbActiveDesc.setText(String.format(wrapFormat,x.getDesc()));
                    lbActiveName.setBounds((450-fm.stringWidth(lbActiveName.getText()))/2,
                            245,
                            fm.stringWidth(lbActiveName.getText()),
                            fm.getHeight());
                    if(((Skill) p.getPlayerClass().getSkillTree().getAt(sel)).isUnlocked()){
                        btLearn.setBackground(Color.gray);
                    }
                    else{
                        btLearn.setBackground(Color.orange);
                    }
                    active = sel;
                }
            });
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
        drawDesc(g);
    }

    public void drawbg(Graphics g){
        try {
            BufferedImage bg = ImageIO.read(new File("src/istts/pbo/res/backgrounds/Dojo.png"));
            g.drawImage(bg, 0, 0, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void drawDesc(Graphics g){
        try {
            BufferedImage bg = ImageIO.read(new File("src/istts/pbo/res/papan.png"));
            g.drawImage(bg.getScaledInstance(420,270,Image.SCALE_DEFAULT), 25, 300, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

class skillLabel extends JLabel{
    String name;
    String desc;

    public skillLabel(String name, String desc){
        this.name = name;
        this.desc = desc;
    }

    public skillLabel(String name) {
        this.name = name;
        this.desc = "";
    }

    public skillLabel(){
        this.name = "";
        this.desc = "";
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}