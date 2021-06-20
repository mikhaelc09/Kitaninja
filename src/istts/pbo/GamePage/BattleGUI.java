package istts.pbo.GamePage;

import istts.pbo.Players.Player;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class BattleGUI extends JPanel {

    class Timerdanstage extends JPanel {

        public Timerdanstage() {

        }
                    protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                draw(g);
            }

            private void draw(Graphics g) {
                    ImageIcon sementara1 = im.resizeIcon("src/istts/pbo/res/papanProfile.png",500,80);
                    g.drawImage(sementara1.getImage(), 0, 0, null);
            }

    }

    Timerdanstage timerdanstage;
    private String namaplayer;
    private String skill1name;
    private String skill2name;
    private String skill3name;
    private int playerHP;
    private int playermaksHP;
    private int playerMP;
    private int playermaksMP;
    private String namaenemy;
    private int enemyHP;
    private int enemymaksHP;
    private int enemyMP;
    private int enemymaksMP;
    private int playerspeed;
    private int enemyspeed;
    private int currentstage;
    private int currentturn;

    //timer
    Timer timergame;
    int startPos;

    ImageIcon gambarskill1;
    ImageIcon gambarskill2;
    ImageIcon gambarskill3;
    ImageIcon gambarplayerbesar;
    ImageIcon gambarplayerkecil;
    ImageIcon gambarenemybesar;
    ImageIcon gambarenemykecil;


    ArrayList<String> debufflist;
    JPanel parent;
    JLabel menu;
    JLabel timer;
    JLabel stage;
    JLabel nameplayer;
    JLabel papanturn;
    JLabel turnplayer;
    JLabel turnenemy;
    JLabel turncount;
    JLabel displayskillname;
    JLabel spriteplayer;
    JPanel debuffplayer;
    JPanel statplayer;
    JLabel nameenemy;
    JLabel spriteenemy;
    JPanel debuffenemy;
    JPanel statenemy;
    JPanel panelskill;
    JLabel skill1;
    JLabel skill2;
    JLabel skill3;
    JLabel attack;
    JLabel gambarplayer;
    JPanel panelHPMPplayer;
    JLabel labelHPplayer;
    JLabel labelMPplayer;
    JLabel HPBARplayerfront;
    JPanel HPBARplayerback;
    JLabel ManaBARplayerfront;
    JPanel ManaBARplayerback;
    JPanel panelHPMPenemy;
    JLabel labelHPenemy;
    JLabel labelMPenemy;
    JLabel gambarenemy;
    JLabel HPBARenemyfront;
    JPanel HPBARenemyback;
    JLabel ManaBARenemyfront;
    JPanel ManaBARenemyback;


    public BattleGUI(Player p) {
        debufflist = new ArrayList<>();
                init(p);
        startPos = turnplayer.getX();

    }

    private void init(Player p) {
        int SWIDTH = 1280;
        int SHEIGHT = 760;
        //beragam get yang harus dirubah
        namaplayer = p.getName();
        playerHP = p.getStats().getHealth();
        playermaksHP = p.getStats().getHealth();
        playerMP = p.getStats().getMana();
        playermaksMP = p.getStats().getMana();
        playerspeed = 50/10;
        namaenemy = "isinamaenemy";
        enemyHP = 100;
        enemymaksHP = 100;
        enemyMP = 100;
        enemymaksMP = 100;
        enemyspeed = 100/10;
        currentstage = 1;
        currentturn = 1;


        //beragam image yang harus di get;

        if(p.getEquippedSkills()[0]!=null) {
            gambarskill1 = new ImageIcon(p.getEquippedSkills()[0].getIconPath());
        }else{
            gambarskill1 = new ImageIcon("src/istts/pbo/res/Item/Tools.png");
        }
        if(p.getEquippedSkills()[1]!=null) {
            gambarskill2 = new ImageIcon(p.getEquippedSkills()[1].getIconPath());
        }else{
            gambarskill1 = new ImageIcon("src/istts/pbo/res/Item/Tools.png");
        }
        if(p.getEquippedSkills()[2]!=null) {
            gambarskill3 = new ImageIcon(p.getEquippedSkills()[2].getIconPath());
        }else{
            gambarskill1 = new ImageIcon("src/istts/pbo/res/Item/Tools.png");
        }



        //mainpanel
        parent = new JPanel();
        parent.setBounds(0, 0, SWIDTH, SHEIGHT);
        parent.setSize(new Dimension(SWIDTH, SHEIGHT));
        parent.setLayout(null);
        parent.setPreferredSize(new Dimension(SWIDTH, SHEIGHT));
        parent.setBackground(Color.GRAY);
        parent.setOpaque(true);
        this.add(parent);

        //menu
        menu = new JLabel();
        menu.setBounds(20, 20, 100, 50);
        menu.setBackground(new Color(100, 50, 0));
        menu.setIcon(new ImageIcon("src/istts/pbo/res/buttons/Back.png"));
        menu.setText("Menu");
        menu.setOpaque(true);

        //Timer + stage panel

        //gambar timer + stage panel
        timerdanstage = new Timerdanstage();
        timerdanstage.setBounds(SWIDTH - 20 - 500, 15, 500, 80);
        timerdanstage.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        timerdanstage.setBackground(new Color(120, 0, 0));
        timerdanstage.setOpaque(true);

        //timer
        timer = new JLabel();
        timer.setPreferredSize(new Dimension(200, 40));
        timer.setBackground(Color.yellow);
        timer.setOpaque(true);

        //stage
        stage = new JLabel("stage : " + currentstage);
        stage.setPreferredSize(new Dimension(200, 40));
        stage.setBackground(Color.yellow);
        stage.setOpaque(true);

        //papan turn
        papanturn = new JLabel();
        papanturn.setBounds(400, 150, 480, 50);
        papanturn.setBackground(new Color(135, 0, 20));
        papanturn.setText("papanturn");
        papanturn.setOpaque(true);
        //turnplayer
        turnplayer = new JLabel();
        turnplayer.setBounds(400, 100, 50, 50);
        turnplayer.setBackground(new Color(200, 50, 200));
        turnplayer.setText("S");
        turnplayer.setOpaque(true);
        //turnenemy
        turnenemy = new JLabel();
        turnenemy.setBounds(400, 100, 50, 50);
        turnenemy.setBackground(new Color(150, 10, 255));
        turnenemy.setText("E");
        turnenemy.setOpaque(true);

        //turncount

        turncount = new JLabel();
        turncount.setBounds(520, 225, 240, 50);
        turncount.setBackground(new Color(70, 200, 70));
        turncount.setText("turn : " + currentturn);
        turncount.setOpaque(true);
        turncount.setHorizontalTextPosition(SwingConstants.CENTER);

        //displayskillname

        displayskillname = new JLabel();
        displayskillname.setBounds(400, 400, 480, 50);
        displayskillname.setBackground(new Color(0, 255, 150));
        //displayskillname.setText("cuma ngecek tombol");
        displayskillname.setOpaque(true);
        displayskillname.setHorizontalTextPosition(SwingConstants.CENTER);

        //nameplayer
        nameplayer = new JLabel(namaplayer);
        nameplayer.setBounds(75, 150, 200, 40);
        nameplayer.setHorizontalTextPosition(SwingConstants.CENTER);
        nameplayer.setVerticalTextPosition(SwingConstants.CENTER);
        nameplayer.setBackground(Color.YELLOW);
        nameplayer.setOpaque(true);

        //spriteplayer
        spriteplayer = new JLabel("gambar player");
        spriteplayer.setBounds(75, 200, 200, 200);
        spriteplayer.setIcon(gambarplayerbesar);
        spriteplayer.setBackground(Color.green);
        spriteplayer.setOpaque(true);

        //Debuffplayer

        debuffplayer = new JPanel();
        debuffplayer.setBounds(20, 500, 400, 50);
        debuffplayer.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        debuffplayer.setBackground(Color.cyan);
        debuffplayer.setOpaque(true);

        //Statplayer

        statplayer = new JPanel();
        statplayer.setBounds(20, 560, 300, 150);
        statplayer.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        statplayer.setBackground(Color.orange);
        statplayer.setOpaque(true);

        //Gambarplayer

        gambarplayer = new JLabel("gambar player");
        gambarplayer.setPreferredSize(new Dimension(120, 120));
        gambarplayer.setBackground(Color.green);
        gambarplayer.setIcon(gambarplayerkecil);
        gambarplayer.setOpaque(true);

        //Tampungan HP MP player
        panelHPMPplayer = new JPanel();
        panelHPMPplayer.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelHPMPplayer.setPreferredSize(new Dimension(140, 120));
        panelHPMPplayer.setBackground(Color.gray);
        panelHPMPplayer.setOpaque(true);

        //labelHPplayer

        labelHPplayer = new JLabel("HP : " + playerHP + " / " + playermaksHP);
        labelHPplayer.setPreferredSize(new Dimension(120, 20));
        labelHPplayer.setBackground(Color.cyan);
        labelHPplayer.setOpaque(true);

        //Player HPBAR back

        HPBARplayerback = new JPanel();
        HPBARplayerback.setLayout(null);
        HPBARplayerback.setPreferredSize(new Dimension(120, 30));
        HPBARplayerback.setBackground(new Color(100, 0, 0));
        HPBARplayerback.setOpaque(true);

        //PLayer HPbar dinamis

        //rumusdinamis
        double temp = 110 * (playerHP * 1.0 / playermaksHP);
        int temp1 = (int) Math.round(temp);

        HPBARplayerfront = new JLabel();
        HPBARplayerfront.setBounds(5, 5, temp1, 20);
        HPBARplayerfront.setBackground(new Color(255, 0, 0));
        HPBARplayerfront.setOpaque(true);

        //player MP label

        labelMPplayer = new JLabel("MP : " + playerMP + " / " + playermaksMP);
        labelMPplayer.setPreferredSize(new Dimension(120, 20));
        labelMPplayer.setBackground(Color.cyan);
        labelMPplayer.setOpaque(true);

        //Player MANABAR back

        ManaBARplayerback = new JPanel();
        ManaBARplayerback.setLayout(null);
        ManaBARplayerback.setPreferredSize(new Dimension(120, 30));
        ManaBARplayerback.setBackground(new Color(0, 0, 140));
        ManaBARplayerback.setOpaque(true);

        //Player MANABAR dinamis
        temp = 110 * (playerHP * 1.0 / playermaksHP);
        temp1 = (int) Math.round(temp);

        ManaBARplayerfront = new JLabel();
        ManaBARplayerfront.setBounds(5, 5, temp1, 20);
        ManaBARplayerfront.setBackground(new Color(0, 0, 255));
        ManaBARplayerfront.setOpaque(true);


        //nameenemy
        nameenemy = new JLabel(namaenemy);
        nameenemy.setBounds(SWIDTH - 75 - 200, 150, 200, 40);
        nameenemy.setHorizontalTextPosition(SwingConstants.CENTER);
        nameenemy.setVerticalTextPosition(SwingConstants.CENTER);
        nameenemy.setBackground(Color.YELLOW);
        nameenemy.setOpaque(true);

        //spriteenemy
        spriteenemy = new JLabel("gambar enemy");
        spriteenemy.setBounds(SWIDTH - 75 - 200, 200, 200, 200);
        spriteenemy.setBackground(Color.green);
        spriteenemy.setOpaque(true);

        //Debuffenemy

        debuffenemy = new JPanel();
        debuffenemy.setBounds(SWIDTH - 20 - 400, 500, 400, 50);
        debuffenemy.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        debuffenemy.setBackground(Color.cyan);
        debuffenemy.setOpaque(true);

        //Statenemy

        statenemy = new JPanel();
        statenemy.setBounds(SWIDTH - 20 - 300, 560, 300, 150);
        statenemy.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        statenemy.setBackground(Color.orange);
        statenemy.setOpaque(true);


        //Gambarenemy

        gambarenemy = new JLabel("gambar enemy");
        gambarenemy.setPreferredSize(new Dimension(120, 120));
        gambarenemy.setBackground(Color.green);
        gambarenemy.setOpaque(true);

        //Tampungan HP MP enemy
        panelHPMPenemy = new JPanel();
        panelHPMPenemy.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelHPMPenemy.setPreferredSize(new Dimension(140, 120));
        panelHPMPenemy.setBackground(Color.gray);
        panelHPMPenemy.setOpaque(true);

        //labelHPenemy

        labelHPenemy = new JLabel("HP : " + enemyHP + " / " + enemymaksHP);
        labelHPenemy.setPreferredSize(new Dimension(120, 20));
        labelHPenemy.setBackground(Color.cyan);
        labelHPenemy.setOpaque(true);

        //enemy HPBAR back

        HPBARenemyback = new JPanel();
        HPBARenemyback.setLayout(null);
        HPBARenemyback.setPreferredSize(new Dimension(120, 30));
        HPBARenemyback.setBackground(new Color(100, 0, 0));
        HPBARenemyback.setOpaque(true);

        //enemy HPbar dinamis

        //rumusdinamis
        temp = 110 * (enemyHP * 1.0 / enemymaksHP);
        temp1 = (int) Math.round(temp);

        HPBARenemyfront = new JLabel();
        HPBARenemyfront.setBounds(5, 5, temp1, 20);
        HPBARenemyfront.setBackground(new Color(255, 0, 0));
        HPBARenemyfront.setOpaque(true);

        //enemy MP label

        labelMPenemy = new JLabel("MP : " + enemyMP + " / " + enemymaksMP);
        labelMPenemy.setPreferredSize(new Dimension(120, 20));
        labelMPenemy.setBackground(Color.cyan);
        labelMPenemy.setOpaque(true);

        //enemy MANABAR back

        ManaBARenemyback = new JPanel();
        ManaBARenemyback.setLayout(null);
        ManaBARenemyback.setPreferredSize(new Dimension(120, 30));
        ManaBARenemyback.setBackground(new Color(0, 0, 140));
        ManaBARenemyback.setOpaque(true);

        //enemy MANABAR dinamis
        temp = 110 * (enemyHP * 1.0 / enemymaksHP);
        temp1 = (int) Math.round(temp);

        ManaBARenemyfront = new JLabel();
        ManaBARenemyfront.setBounds(5, 5, temp1, 20);
        ManaBARenemyfront.setBackground(new Color(0, 0, 255));
        ManaBARenemyfront.setOpaque(true);


        //Skillpanel
        panelskill = new JPanel();
        panelskill.setBounds(365, 560, 555, 150);
        panelskill.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 15));
        panelskill.setBackground(Color.red);
        panelskill.setOpaque(true);

        //skill 1
        skill1 = new JLabel("Skill1");
        skill1.setPreferredSize(new Dimension(120, 120));

        skill1.setIcon(gambarskill1);

        //skill 2
        skill2 = new JLabel("Skill2");
        skill2.setPreferredSize(new Dimension(120, 120));
        skill2.setIcon(gambarskill2);
        //skill 3
        skill3 = new JLabel("Skill3");
        skill3.setPreferredSize(new Dimension(120, 120));
        skill3.setIcon(gambarskill3);
        //attack
        attack = new JLabel("Attack");
        attack.setPreferredSize(new Dimension(120, 120));
        attack.setIcon(new ImageIcon("src/istts/pbo/res/IconSkill/Attack.png"));
        attack.setOpaque(true);

        //Infopanel

        //
        timergame = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                turnplayer.setBounds(turnplayer.getX()+playerspeed,
                        turnplayer.getY(),
                        turnplayer.getWidth(),
                        turnplayer.getHeight());
                turnenemy.setBounds(turnenemy.getX()+enemyspeed,
                        turnenemy.getY(),
                        turnenemy.getWidth(),
                        turnenemy.getHeight());
                if(turnplayer.getX()+turnplayer.getWidth()>=papanturn.getX()+papanturn.getWidth()){
                    timergame.stop();
                    /*
                   Process
                     */
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException interruptedException) {
                        interruptedException.printStackTrace();
                    }
                    timergame.start();
                    turnplayer.setBounds(startPos,turnplayer.getY(),turnplayer.getWidth(),turnplayer.getHeight());
                }
                if(turnenemy.getX()+turnenemy.getWidth()>=papanturn.getX()+papanturn.getWidth()){
                    turnenemy.setBounds(startPos, turnenemy.getY(),turnenemy.getWidth(),turnenemy.getHeight());
                }
            }
        });


        //add and revalidate everyshit
        parent.add(menu);
        menu.revalidate();
        menu.repaint();
        menu.setVisible(true);

        //panel stage + timer

        parent.add(timerdanstage);
        timerdanstage.revalidate();
        timerdanstage.repaint();
        timerdanstage.setVisible(true);

        timerdanstage.add(timer);
        timer.revalidate();
        timer.repaint();
        timer.setVisible(true);

        timerdanstage.add(stage);
        stage.revalidate();
        stage.repaint();
        stage.setVisible(true);

        //end

        //papan turn

        parent.add(papanturn);
        papanturn.revalidate();
        papanturn.repaint();
        papanturn.setVisible(true);

        parent.add(turnplayer);
        turnplayer.revalidate();
        turnplayer.repaint();
        turnplayer.setVisible(true);

        parent.add(turnenemy);
        turnenemy.revalidate();
        turnenemy.repaint();
        turnenemy.setVisible(true);

        parent.add(turncount);
        turncount.revalidate();
        turncount.repaint();
        turncount.setVisible(true);


        parent.add(displayskillname);
        displayskillname.revalidate();
        displayskillname.repaint();
        displayskillname.setVisible(true);

        //end

        parent.add(nameplayer);
        nameplayer.revalidate();
        nameplayer.repaint();
        nameplayer.setVisible(true);

        parent.add(spriteplayer);
        spriteplayer.revalidate();
        spriteplayer.repaint();
        spriteplayer.setVisible(true);

        parent.add(debuffplayer);
        debuffplayer.revalidate();
        debuffplayer.repaint();
        debuffplayer.setVisible(true);

        parent.add(statplayer);
        statplayer.revalidate();
        statplayer.repaint();
        statplayer.setVisible(true);

        //statplayer
        statplayer.add(gambarplayer);
        gambarplayer.revalidate();
        gambarplayer.repaint();
        gambarplayer.setVisible(true);

        statplayer.add(panelHPMPplayer);
        panelHPMPplayer.revalidate();
        panelHPMPplayer.repaint();
        panelHPMPplayer.setVisible(true);

        panelHPMPplayer.add(labelHPplayer);
        labelHPplayer.revalidate();
        labelHPplayer.repaint();
        labelHPplayer.setVisible(true);

        panelHPMPplayer.add(HPBARplayerback);
        HPBARplayerback.revalidate();
        HPBARplayerback.repaint();
        HPBARplayerback.setVisible(true);

        HPBARplayerback.add(HPBARplayerfront);
        HPBARplayerfront.revalidate();
        HPBARplayerfront.repaint();
        HPBARplayerfront.setVisible(true);

        panelHPMPplayer.add(labelMPplayer);
        labelMPplayer.revalidate();
        labelMPplayer.repaint();
        labelMPplayer.setVisible(true);

        panelHPMPplayer.add(ManaBARplayerback);
        ManaBARplayerback.revalidate();
        ManaBARplayerback.repaint();
        ManaBARplayerback.setVisible(true);

        ManaBARplayerback.add(ManaBARplayerfront);
        ManaBARplayerfront.revalidate();
        ManaBARplayerfront.repaint();
        ManaBARplayerfront.setVisible(true);

        //enemy
        parent.add(nameenemy);
        nameenemy.revalidate();
        nameenemy.repaint();
        nameenemy.setVisible(true);

        parent.add(spriteenemy);
        spriteenemy.revalidate();
        spriteenemy.repaint();
        spriteenemy.setVisible(true);

        parent.add(debuffenemy);
        debuffenemy.revalidate();
        debuffenemy.repaint();
        debuffenemy.setVisible(true);

        parent.add(statenemy);
        statenemy.revalidate();
        statenemy.repaint();
        statenemy.setVisible(true);

        //statenemy
        statenemy.add(gambarenemy);
        gambarenemy.revalidate();
        gambarenemy.repaint();
        gambarenemy.setVisible(true);

        statenemy.add(panelHPMPenemy);
        panelHPMPenemy.revalidate();
        panelHPMPenemy.repaint();
        panelHPMPenemy.setVisible(true);

        panelHPMPenemy.add(labelHPenemy);
        labelHPenemy.revalidate();
        labelHPenemy.repaint();
        labelHPenemy.setVisible(true);

        panelHPMPenemy.add(HPBARenemyback);
        HPBARenemyback.revalidate();
        HPBARenemyback.repaint();
        HPBARenemyback.setVisible(true);

        HPBARenemyback.add(HPBARenemyfront);
        HPBARenemyfront.revalidate();
        HPBARenemyfront.repaint();
        HPBARenemyfront.setVisible(true);

        panelHPMPenemy.add(labelMPenemy);
        labelMPenemy.revalidate();
        labelMPenemy.repaint();
        labelMPenemy.setVisible(true);

        panelHPMPenemy.add(ManaBARenemyback);
        ManaBARenemyback.revalidate();
        ManaBARenemyback.repaint();
        ManaBARenemyback.setVisible(true);

        ManaBARenemyback.add(ManaBARenemyfront);
        ManaBARenemyfront.revalidate();
        ManaBARenemyfront.repaint();
        ManaBARenemyfront.setVisible(true);

        parent.add(panelskill);
        panelskill.revalidate();
        panelskill.repaint();
        panelskill.setVisible(true);

        panelskill.add(skill1);
        skill1.revalidate();
        skill1.repaint();
        skill1.setVisible(true);

        panelskill.add(skill2);
        skill2.revalidate();
        skill2.repaint();
        skill2.setVisible(true);

        panelskill.add(skill3);
        skill3.revalidate();
        skill3.repaint();
        skill3.setVisible(true);

        panelskill.add(attack);
        attack.revalidate();
        attack.repaint();
        attack.setVisible(true);

        //turngerak



    }
    public void revalidateeverycomp(Player p){
        timergame.start();
        //seteveryshit
        if(p.getEquippedSkills()[0]!=null) {
            gambarskill1 = new ImageIcon(p.getEquippedSkills()[0].getIconPath());
        }else{
            gambarskill1 = new ImageIcon("src/istts/pbo/res/Item/Tools.png");
        }
        if(p.getEquippedSkills()[1]!=null) {
            gambarskill2 = new ImageIcon(p.getEquippedSkills()[1].getIconPath());
        }else{
            gambarskill2= new ImageIcon("src/istts/pbo/res/Item/Tools.png");
        }
        if(p.getEquippedSkills()[2]!=null) {
            gambarskill3 = new ImageIcon(p.getEquippedSkills()[2].getIconPath());
        }else{
            gambarskill3 = new ImageIcon("src/istts/pbo/res/Item/Tools.png");
        }
        gambarplayerbesar = im.resizeIcon(p.getPlayerClass().getSpritePath(),200,200);
        gambarplayerkecil = im.resizeIcon(p.getPlayerClass().getSpritePath(),120,120);

        spriteplayer.setIcon(gambarplayerbesar);
        gambarplayer.setIcon(gambarplayerkecil);
        skill1.setIcon(gambarskill1);
        skill2.setIcon(gambarskill2);
        skill3.setIcon(gambarskill3);

        parent.add(menu);
        menu.revalidate();
        menu.repaint();
        menu.setVisible(true);

        //panel stage + timer

        parent.add(timerdanstage);
        timerdanstage.revalidate();
        timerdanstage.repaint();
        timerdanstage.setVisible(true);

        timerdanstage.add(timer);
        timer.revalidate();
        timer.repaint();
        timer.setVisible(true);

        timerdanstage.add(stage);
        stage.revalidate();
        stage.repaint();
        stage.setVisible(true);

        //end

        //papan turn

        parent.add(papanturn);
        papanturn.revalidate();
        papanturn.repaint();
        papanturn.setVisible(true);

        parent.add(turnplayer);
        turnplayer.revalidate();
        turnplayer.repaint();
        turnplayer.setVisible(true);

        parent.add(turnenemy);
        turnenemy.revalidate();
        turnenemy.repaint();
        turnenemy.setVisible(true);

        parent.add(turncount);
        turncount.revalidate();
        turncount.repaint();
        turncount.setVisible(true);


        parent.add(displayskillname);
        displayskillname.revalidate();
        displayskillname.repaint();
        displayskillname.setVisible(true);

        //end

        parent.add(nameplayer);
        nameplayer.revalidate();
        nameplayer.repaint();
        nameplayer.setVisible(true);

        parent.add(spriteplayer);
        spriteplayer.revalidate();
        spriteplayer.repaint();
        spriteplayer.setVisible(true);

        parent.add(debuffplayer);
        debuffplayer.revalidate();
        debuffplayer.repaint();
        debuffplayer.setVisible(true);

        parent.add(statplayer);
        statplayer.revalidate();
        statplayer.repaint();
        statplayer.setVisible(true);

        //statplayer
        statplayer.add(gambarplayer);
        gambarplayer.revalidate();
        gambarplayer.repaint();
        gambarplayer.setVisible(true);

        statplayer.add(panelHPMPplayer);
        panelHPMPplayer.revalidate();
        panelHPMPplayer.repaint();
        panelHPMPplayer.setVisible(true);

        panelHPMPplayer.add(labelHPplayer);
        labelHPplayer.revalidate();
        labelHPplayer.repaint();
        labelHPplayer.setVisible(true);

        panelHPMPplayer.add(HPBARplayerback);
        HPBARplayerback.revalidate();
        HPBARplayerback.repaint();
        HPBARplayerback.setVisible(true);

        HPBARplayerback.add(HPBARplayerfront);
        HPBARplayerfront.revalidate();
        HPBARplayerfront.repaint();
        HPBARplayerfront.setVisible(true);

        panelHPMPplayer.add(labelMPplayer);
        labelMPplayer.revalidate();
        labelMPplayer.repaint();
        labelMPplayer.setVisible(true);

        panelHPMPplayer.add(ManaBARplayerback);
        ManaBARplayerback.revalidate();
        ManaBARplayerback.repaint();
        ManaBARplayerback.setVisible(true);

        ManaBARplayerback.add(ManaBARplayerfront);
        ManaBARplayerfront.revalidate();
        ManaBARplayerfront.repaint();
        ManaBARplayerfront.setVisible(true);


        //enemy
        parent.add(nameenemy);
        nameenemy.revalidate();
        nameenemy.repaint();
        nameenemy.setVisible(true);

        parent.add(spriteenemy);
        spriteenemy.revalidate();
        spriteenemy.repaint();
        spriteenemy.setVisible(true);

        parent.add(debuffenemy);
        debuffenemy.revalidate();
        debuffenemy.repaint();
        debuffenemy.setVisible(true);

        parent.add(statenemy);
        statenemy.revalidate();
        statenemy.repaint();
        statenemy.setVisible(true);


        //statenemy
        statenemy.add(gambarenemy);
        gambarenemy.revalidate();
        gambarenemy.repaint();
        gambarenemy.setVisible(true);

        statenemy.add(panelHPMPenemy);
        panelHPMPenemy.revalidate();
        panelHPMPenemy.repaint();
        panelHPMPenemy.setVisible(true);

        panelHPMPenemy.add(labelHPenemy);
        labelHPenemy.revalidate();
        labelHPenemy.repaint();
        labelHPenemy.setVisible(true);

        panelHPMPenemy.add(HPBARenemyback);
        HPBARenemyback.revalidate();
        HPBARenemyback.repaint();
        HPBARenemyback.setVisible(true);

        HPBARenemyback.add(HPBARenemyfront);
        HPBARenemyfront.revalidate();
        HPBARenemyfront.repaint();
        HPBARenemyfront.setVisible(true);

        panelHPMPenemy.add(labelMPenemy);
        labelMPenemy.revalidate();
        labelMPenemy.repaint();
        labelMPenemy.setVisible(true);

        panelHPMPenemy.add(ManaBARenemyback);
        ManaBARenemyback.revalidate();
        ManaBARenemyback.repaint();
        ManaBARenemyback.setVisible(true);

        ManaBARenemyback.add(ManaBARenemyfront);
        ManaBARenemyfront.revalidate();
        ManaBARenemyfront.repaint();
        ManaBARenemyfront.setVisible(true);

        parent.add(panelskill);
        panelskill.revalidate();
        panelskill.repaint();
        panelskill.setVisible(true);

        panelskill.add(skill1);
        skill1.revalidate();
        skill1.repaint();
        skill1.setVisible(true);

        panelskill.add(skill2);
        skill2.revalidate();
        skill2.repaint();
        skill2.setVisible(true);

        panelskill.add(skill3);
        skill3.revalidate();
        skill3.repaint();
        skill3.setVisible(true);

        panelskill.add(attack);
        attack.revalidate();
        attack.repaint();
        attack.setVisible(true);
    }

    private void repaintturn() {

    }

    private void repaintdebuff() {

    }
}
