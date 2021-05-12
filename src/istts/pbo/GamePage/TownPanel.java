package istts.pbo.GamePage;

import istts.pbo.Players.Player;
import istts.pbo.musicPlayer;
import istts.pbo.musicPlayer2;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import static istts.pbo.Main.*;
import static istts.pbo.Main.SHEIGHT;
import static istts.pbo.Main.SWIDTH;

public class TownPanel extends JPanel {
    JLabel lbShop;
    JLabel lbSmith;
    JLabel lbBattle;
    JLabel lbDojo;
    Player player;
    JLabel profil;
    JLabel back;
    JLabel name;
    JLabel job;
    JLabel lvl;
    JLabel exp;
    musicPlayer2 music;
    public TownPanel(Player player){
        this.player = player;
        init();
        back.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                music.getClip().stop();
            }
        });
    }

    private void init(){
        setBackground(Color.BLACK);
        setLayout(null);
        music = new musicPlayer2();

        lbShop = new JLabel();
        lbShop.setBounds(1110,415, 120,120);
        lbShop.setIcon(new ImageIcon("src/istts/pbo/res/buttons/Shop.png"));
        lbShop.setCursor(new Cursor(Cursor.HAND_CURSOR));

        lbBattle = new JLabel();
        lbBattle.setBounds(55,300, 120,120);
        lbBattle.setIcon(new ImageIcon("src/istts/pbo/res/buttons/Battle.png"));
        lbBattle.setCursor(new Cursor(Cursor.HAND_CURSOR));

        lbDojo = new JLabel();
        lbDojo.setBounds(510,50, 120,200);
        lbDojo.setIcon(new ImageIcon("src/istts/pbo/res/buttons/Dojo.png"));
        lbDojo.setCursor(new Cursor(Cursor.HAND_CURSOR));

        lbSmith = new JLabel();
        lbSmith.setBounds(730,35, 120,350);
        lbSmith.setIcon(new ImageIcon("src/istts/pbo/res/buttons/Smith.png"));
        lbSmith.setCursor(new Cursor(Cursor.HAND_CURSOR));

        back = new JLabel();
        back.setBounds(8,658,100,50);
        back.setIcon(new ImageIcon("src/istts/pbo/res/buttons/Back.png"));
        back.setCursor(new Cursor(Cursor.HAND_CURSOR));

        name = new JLabel("Name : "+player.getName());
        name.setBounds(15,10,120,30);

        job = new JLabel("Job : "+player.getPlayerClass().getClassname());
        job.setBounds(15,30,120,30);

        lvl = new JLabel("Level : "+player.getLevel());
        lvl.setBounds(15,50   ,120,30);

        exp = new JLabel("Xp : "+player.getXp());
        exp.setBounds(15,70,120,30);

        profil = new JLabel();
        profil.setBounds(0,0,200,120);
        profil.setIcon(new ImageIcon("src/istts/pbo/res/papanProfile.png"));

        add(lbShop);
        add(lbSmith);
        add(lbDojo);
        add(lbBattle);
        add(back);
        add(name);
        add(job);
        add(lvl);
        add(exp);
        add(profil);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    private void draw(Graphics g){
        try {
            BufferedImage bg = ImageIO.read(new File("src/istts/pbo/res/backgrounds/Town.png"));
            g.drawImage(bg,0,0,null);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
