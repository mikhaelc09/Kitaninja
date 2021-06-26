package istts.pbo.GamePage;

import istts.pbo.LandingPage.StartPage;
import istts.pbo.Players.Player;
import istts.pbo.System.CustomTitlebar;
import istts.pbo.musicPlayer2;
import istts.pbo.musicPlayer3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;

import static istts.pbo.Main.SHEIGHT;
import static istts.pbo.Main.SWIDTH;

public class TownPage extends JFrame {
    private int cx, cy;
    CustomTitlebar title;
    TownPanel town;
    Player player;
    ProfilePanel profil;
    musicPlayer2 musictown;
    musicPlayer3 musicbattle;
//    SkillPage skillpage;
    DojoPanel dojo;
    SmithPanel smith;
    ShopPanel shop;
    BattleGUI battle;
    int index;
    public TownPage(Player player, int index){
        this.player = player;
        this.index = index;
        init();
        musictown=new musicPlayer2();
        musicbattle=new musicPlayer3();
        musicbattle.getClip().stop();
        town.back.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                backMainMenu();
            }
        });

        town.profil.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                profil.gold.setText("Gold : "+player.getGold());
                profil.setVisible(true);
                town.setVisible(false);
            }
        });
        town.lbBattle.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                battle.revalidateeverycomp(player);
                battle.setVisible(true);
                town.setVisible(false);
                musictown.getClip().stop();
                musicbattle.getClip().start();
            }
        });


        town.lbDojo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dojo.setVisible(true);
                town.setVisible(false);
            }
        });

        town.lbSmith.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                for (int i = 0; i < 25; i++) {
                    smith.lbItemUpgrade.get(i).setIcon(new ImageIcon(player.getItems().get(i).getSpritePath()));
                }
                smith.setVisible(true);
                town.setVisible(false);
                smith.Uangmu.setText("Gold " + player.getGold());
                smith.stat.setText("Stat 0");
            }
        });
        
        town.lbShop.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                shop.setVisible(true);
                town.setVisible(false);
            }
        });
        profil.back.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                profil.setVisible(false);
                town.setVisible(true);
            }
        });

        battle.menu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                battle.setVisible(false);
                town.setVisible(true);
                int stageFinished = battle.getCurrentstage();
                int xpGain = 20*stageFinished;
                if(battle.getEnemyHP()>0){
                    stageFinished--;
                }
                int levelGain = (xpGain+player.getXp())/100;
                int xpModed = (xpGain+player.getXp())%100;
                JOptionPane.showMessageDialog(null,"Kamu sudah menyelesaikan "+stageFinished+" stage, kamu mendapat "+xpGain+" XP");
                for (int i = 0; i < levelGain; i++) {
                    JOptionPane.showMessageDialog(null, "Level Up!");
                }
                player.setLevel(player.getLevel()+levelGain);
                player.setXp(xpModed);
                battle.timergame.stop();
                musictown.getClip().start();
                musicbattle.getClip().stop();
            }
        });

        dojo.btBack.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dojo.setVisible(false);
                town.setVisible(true);
            }
        });
        shop.shopback.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                shop.setVisible(false);
                town.setVisible(true);
            }
        });

        smith.TombolBack.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                town.setVisible(true);
                smith.setVisible(false);
            }
        });
        town.settingsound.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                musictown.setVisible(true);
            }
        });
        musictown.getP().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                musictown.setVisible(false);
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
        setTitle("Kitaninja");

        JPanel parent = new JPanel();
        parent.setBounds(0,0,this.getWidth(),this.getHeight());
        parent.setSize(new Dimension(SWIDTH,SHEIGHT));
        parent.setBackground(Color.BLACK);
        parent.setLayout(null);
        parent.setPreferredSize(new Dimension(SWIDTH,SHEIGHT));

        title = new CustomTitlebar();
        title.setBounds(0,0,getWidth(),40);

        town = new TownPanel(player);
        profil = new ProfilePanel(player);
        dojo = new DojoPanel(player);
        smith= new SmithPanel(player);
        shop = new ShopPanel(player);
        battle = new BattleGUI(player);

        town.setBounds(0,40,this.getWidth(),this.getHeight());
        profil.setBounds(0,35,this.getWidth(),this.getHeight());
        dojo.setBounds(0,40,this.getWidth(),this.getHeight());
        smith.setBounds(0,40,this.getWidth(),this.getHeight());
        shop.setBounds(0,30,this.getWidth(),this.getHeight());
        battle.setBounds(0,30,this.getWidth(),this.getHeight());

        parent.add(title);
        parent.add(town);
        parent.add(profil);
        parent.add(dojo);
        parent.add(smith);
        parent.add(shop);
        parent.add(battle);
        profil.setVisible(false);

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

    private void backMainMenu(){
        this.dispose();
        saveFile();
        new StartPage();
        musictown.getClip().stop();
    }

    private void exit(){
        saveFile();
        System.exit(0);
    }

    private void saveFile(){
        try {
            FileOutputStream f = new FileOutputStream("src/istts/pbo/System/saves/"+(index+1)+".ser");
            ObjectOutputStream o  = new ObjectOutputStream(f);
            o.writeObject(player);
            o.close();
            f.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void topMousePressed(MouseEvent e){
        cx = e.getX();
        cy = e.getY();
    }

    private void topMouseDragged(MouseEvent e){
        this.setLocation(e.getXOnScreen()-cx, e.getYOnScreen()-cy);
    }

}
