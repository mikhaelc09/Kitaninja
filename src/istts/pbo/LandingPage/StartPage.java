package istts.pbo.LandingPage;

import istts.pbo.Classes.Ninjutsu;
import istts.pbo.Classes.Qiqong;
import istts.pbo.Classes.Taijutsu;
import istts.pbo.GamePage.TownPage;
import istts.pbo.Players.Player;
import istts.pbo.System.CustomExitConfirm;
import istts.pbo.System.CustomTitlebar;
import istts.pbo.musicPlayer;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.MalformedURLException;
import static istts.pbo.Main.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.event.*;



public class StartPage extends JFrame{

    MenuPanel menu;
    CreationPanel create;
    CustomTitlebar title;
    CustomExitConfirm exitConfirm;
    musicPlayer music;
    private int cx, cy;
    private Clip clipNameClip;
    private AudioInputStream clipNameAIS;



    /*URL soundbyte = new File("src/istts/pbo/res/audio/sfx/yooooooooooo (3).wav").toURI().toURL();
        java.applet.AudioClip clip = java.applet.Applet.newAudioClip(soundbyte);*/

    public StartPage() {
        init();
       exitConfirm = new CustomExitConfirm();
       music = new musicPlayer();


       menu.lbNewGame.addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent e) {
               super.mouseClicked(e);
               menu.setVisible(false);
               create.setVisible(true);
               String soundName = "src/istts/pbo/res/audio/sfx/yooooooooooo (3).wav";
               AudioInputStream audioInputStream = null;
               try {
                   audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
               } catch (UnsupportedAudioFileException unsupportedAudioFileException) {
                   unsupportedAudioFileException.printStackTrace();
               } catch (IOException ioException) {
                   ioException.printStackTrace();
               }
               Clip clip = null;
               try {
                   clip = AudioSystem.getClip();
               } catch (LineUnavailableException lineUnavailableException) {
                   lineUnavailableException.printStackTrace();
               }
               try {
                   clip.open(audioInputStream);
               } catch (LineUnavailableException lineUnavailableException) {
                   lineUnavailableException.printStackTrace();
               } catch (IOException ioException) {
                   ioException.printStackTrace();
               }
               clip.start();
           }

       });

       create.back.addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent e) {
               super.mouseClicked(e);
               menu.setVisible(true);
               create.setVisible(false);

           }
       });

       create.tombolok.addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent e) {
               super.mouseClicked(e);
               Player player=null;
               if(create.nama.getText().length()>0) {
                   if (create.classPicked==1){
                       player = new Player(create.getNama(),new Taijutsu());
                   }else if (create.classPicked==2){
                       player = new Player(create.getNama(),new Ninjutsu());
                   }else if (create.classPicked==3){
                       player = new Player(create.getNama(),new Qiqong());
                   }
                   confirmCreate(player);
                   music.getClip().stop();
               }
           }
       });

       menu.lbExit.addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent e) {
               super.mouseClicked(e);
               exitConfirm.setVisible(true);
               String soundName = "src/istts/pbo/res/audio/sfx/yooooooooooo (3).wav";
               AudioInputStream audioInputStream = null;
               try {
                   audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
               } catch (UnsupportedAudioFileException unsupportedAudioFileException) {
                   unsupportedAudioFileException.printStackTrace();
               } catch (IOException ioException) {
                   ioException.printStackTrace();
               }
               Clip clip = null;
               try {
                   clip = AudioSystem.getClip();
               } catch (LineUnavailableException lineUnavailableException) {
                   lineUnavailableException.printStackTrace();
               }
               try {
                   clip.open(audioInputStream);
               } catch (LineUnavailableException lineUnavailableException) {
                   lineUnavailableException.printStackTrace();
               } catch (IOException ioException) {
                   ioException.printStackTrace();
               }
               clip.start();
           }
       });


       exitConfirm.getLbYes().addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent e) {
               exit();
           }
       });

       exitConfirm.getLbNo().addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent e) {
               exitConfirm.setVisible(false);
           }
       });

       menu.lbSetting.addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent e) {
               music.setVisible(true);
           }
       });

       music.getP().addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent e) {
               music.setVisible(false);
           }
       });

    }

    private void init(){
        ImageIcon logo = new ImageIcon("src/istts/pbo/res/Icon.png");
        setIconImage(logo.getImage());
        setSize(new Dimension(SWIDTH,SHEIGHT));
        setLocationRelativeTo(null);
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.ORANGE);
        setResizable(false);
        setUndecorated(true);
        setVisible(true);
        setTitle("KitaNinja");

        JPanel parent = new JPanel();
        parent.setBounds(0,0,this.getWidth(),this.getHeight());
        parent.setSize(new Dimension(SWIDTH,SHEIGHT));
        parent.setBackground(Color.BLACK);
        parent.setLayout(null);
        parent.setPreferredSize(new Dimension(SWIDTH,SHEIGHT));

        menu = new MenuPanel();
        menu.setBounds(0,40,this.getWidth(),this.getHeight());

        create = new CreationPanel();
        create.setBounds(0,40,this.getWidth(),this.getHeight());
        create.setVisible(false);

        title = new CustomTitlebar();
        title.setBounds(0,0,getWidth(),40);

        parent.add(create);
        parent.add(menu);
        parent.add(title);

        title.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                topMousePressed(e);
            }
        });

        title.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                topMouseDragged(e);
            }
        });

        title.getLbExit().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                exit();
            }
        });

        add(parent);
        this.pack();
    }

    private void exit(){
        System.exit(0);
    }

    private void topMousePressed(MouseEvent e){
        cx = e.getX();
        cy = e.getY();
    }

    private void topMouseDragged(MouseEvent e){
        this.setLocation(e.getXOnScreen()-cx, e.getYOnScreen()-cy);
    }

    private void cancelExit(CustomExitConfirm c){
        c.dispose();
    }

    private void confirmCreate(Player player){
        this.dispose();
        new TownPage(player);
    }
}
