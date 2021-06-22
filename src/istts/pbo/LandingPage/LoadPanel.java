package istts.pbo.LandingPage;

import istts.pbo.Classes.Ninjutsu;
import istts.pbo.Classes.Qiqong;
import istts.pbo.Classes.Taijutsu;
import istts.pbo.GamePage.im;
import istts.pbo.Players.Player;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static istts.pbo.Main.SWIDTH;

public class LoadPanel extends JPanel {
    JLabel back;
    JLabel[] kotakLoad = new JLabel[3];
    JLabel[] sprite = new JLabel[3];
    JLabel[] nama = new JLabel[3];

    Font fontlb = new Font("Ninja Naruto",Font.BOLD,50);
    ArrayList<Player> player = new ArrayList<>();

    public LoadPanel(ArrayList<Player> p) {
        player = p;
        init();
    }

    private void init(){
        setBackground(Color.BLACK);
        setLayout(null);

        back = new JLabel();
        back.setBounds(20,15,100,50);
        back.setOpaque(false);
        back.setIcon(new ImageIcon("src/istts/pbo/res/buttons/Back.png"));
        back.setCursor(new Cursor(Cursor.HAND_CURSOR));

        initState();

        for (int i = 0; i < 3; i++) {
            kotakLoad[i].add(sprite[i]);
            kotakLoad[i].add(nama[i]);
            add(kotakLoad[i]);
        }

        add(back);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    private void draw(Graphics g){
        try {
            BufferedImage bg = ImageIO.read(new File("src/istts/pbo/res/backgrounds/MainMenu2.png"));
            g.drawImage(bg,0,0,null);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void initState(){
        for (int i = 0; i < 3; i++) {
            kotakLoad[i] = new JLabel();
            kotakLoad[i].setBounds(20,100+200*i,1240,175);
            kotakLoad[i].setOpaque(false);
            kotakLoad[i].setIcon(im.resizeIcon("src/istts/pbo/res/papan.png",1240,175));
            sprite[i] = new JLabel();
            sprite[i].setBounds(50,0,175,175);
            nama[i] = new JLabel();
            nama[i].setBounds(270,175/4,600,100);
            nama[i].setBackground(Color.black);
            nama[i].setFont(fontlb);
            nama[i].setOpaque(false);
            nama[i].setText(player.get(i).getName());
            kotakLoad[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
            sprite[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
            nama[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
            if(!player.get(i).getName().equalsIgnoreCase("Blank")){
                sprite[i].setIcon(im.resizeIcon(player.get(i).getPlayerClass().getSpritePath(),170,170));
            }
            else{
                sprite[i].setIcon(im.resizeIcon("src/istts/pbo/res/sprites/siluet.png",170,170));
            }
        }
    }

}
