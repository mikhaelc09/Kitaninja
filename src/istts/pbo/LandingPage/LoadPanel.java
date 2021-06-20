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
    JLabel kotakload1; //kotakload buat yg di klik klik buat load
    JLabel kotakload2;
    JLabel kotakload3;

    JLabel sprite1;
    JLabel sprite2;
    JLabel sprite3;

    JLabel nama1;
    JLabel nama2;
    JLabel nama3;

    Font fontlb = new Font("Ninja Naruto",Font.BOLD,50);
    ArrayList<Player> player = new ArrayList<>();

    public LoadPanel() {
        player.add(null);
        player.add(null);
        player.add(null);

        player.set(0,new Player("Daniel",new Qiqong()));
        player.set(1,new Player("Ivan Nob",new Taijutsu()));
//        player.set(2,new Player("derson",new Ninjutsu()));

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


        kotakload1 = new JLabel();
        kotakload1.setBounds(20,100,1240,175);
        kotakload1.setOpaque(false);
        kotakload1.setIcon(im.resizeIcon("src/istts/pbo/res/papan.png",1240,175));

        sprite1 = new JLabel();
        sprite1.setBounds(50,0,175,175);
        sprite1.setIcon(im.resizeIcon("src/istts/pbo/res/sprites/siluet.png",170,170));

        nama1 = new JLabel("blank");
        nama1.setBounds(270,175/4,600,100);
        nama1.setBackground(Color.black);
        nama1.setFont(fontlb);
        nama1.setOpaque(false);

        if (player.get(0)!=null){
            sprite1.setIcon(im.resizeIcon(player.get(0).getPlayerClass().getSpritePath(),170,170));
            nama1.setText(player.get(0).getName());
        }


        kotakload2 = new JLabel();
        kotakload2.setBounds(20,300,1240,175);
        kotakload2.setOpaque(false);
        kotakload2.setIcon(im.resizeIcon("src/istts/pbo/res/papan.png",1240,175));

        sprite2 = new JLabel();
        sprite2.setBounds(50,0,175,175);
        sprite2.setIcon(im.resizeIcon("src/istts/pbo/res/sprites/siluet.png",170,170));

        nama2 = new JLabel("blank");
        nama2.setBounds(270,175/4,600,100);
        nama2.setBackground(Color.black);
        nama2.setFont(fontlb);
        nama2.setOpaque(false);

        if (player.get(1)!=null){
            sprite2.setIcon(im.resizeIcon(player.get(1).getPlayerClass().getSpritePath(),170,170));
            nama2.setText(player.get(1).getName());
        }

        kotakload3 = new JLabel();
        kotakload3.setBounds(20,500,1240,175);
        kotakload3.setOpaque(false);
        kotakload3.setIcon(im.resizeIcon("src/istts/pbo/res/papan.png",1240,175));

        sprite3 = new JLabel();
        sprite3.setBounds(50,0,175,175);
        sprite3.setIcon(im.resizeIcon("src/istts/pbo/res/sprites/siluet.png",170,170));

        nama3 = new JLabel("blank");
        nama3.setBounds(270,175/4,600,100);
        nama3.setBackground(Color.black);
        nama3.setFont(fontlb);
        nama3.setOpaque(false);

        if (player.get(2)!=null){
            sprite3.setIcon(im.resizeIcon(player.get(2).getPlayerClass().getSpritePath(),170,170));
            nama3.setText(player.get(2).getName());
        }

        add(back);
        add(kotakload1);
        add(kotakload2);
        add(kotakload3);
        kotakload1.add(sprite1);
        kotakload1.add(nama1);
        kotakload2.add(sprite2);
        kotakload2.add(nama2);
        kotakload3.add(sprite3);
        kotakload3.add(nama3);
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

}
