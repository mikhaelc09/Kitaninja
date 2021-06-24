package istts.pbo.GamePage;

import istts.pbo.Enemy.Enemy1;
import istts.pbo.Enemy.Enemy2;
import istts.pbo.Enemy.Enemy3;
import istts.pbo.Players.Player;
import istts.pbo.Players.skilltrees.skills.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

public class BattleGUI extends JPanel {

    class Timerdanstage extends JPanel {

        public Timerdanstage() {

        }
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            draw(g);
        }

        private void draw(Graphics g) {
            ImageIcon sementara1 = im.resizeIcon("src/istts/pbo/res/papantimer.png",500,80);
            g.drawImage(sementara1.getImage(), 0, 0, null);
        }

    }
    class StatPlayer extends JPanel {

        public StatPlayer() {

        }
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            draw(g);
        }

        private void draw(Graphics g) {
            ImageIcon sementara1 = im.resizeIcon("src/istts/pbo/res/papanstat (1).png",300,150);
            g.drawImage(sementara1.getImage(), 0, 0, null);
        }

    }
    class StatEnemy extends JPanel {

        public StatEnemy() {

        }
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            draw(g);
        }

        private void draw(Graphics g) {
            ImageIcon sementara1 = im.resizeIcon("src/istts/pbo/res/papanstat (1).png",300,150);
            g.drawImage(sementara1.getImage(), 0, 0, null);
        }

    }
    class PanelSkill extends JPanel {

        public PanelSkill() {

        }
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            draw(g);
        }

        private void draw(Graphics g) {
            ImageIcon sementara1 = im.resizeIcon("src/istts/pbo/res/papan skill.jpg",555,150);
            g.drawImage(sementara1.getImage(), 0, 0, null);
        }

    }
    class Parent extends JPanel {

        public Parent() {

        }
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            draw(g);
        }

        private void draw(Graphics g) {
            ImageIcon sementara1 = new ImageIcon("src/istts/pbo/res/backgrounds/backgroundbattle.png");
            g.drawImage(sementara1.getImage(), 0, 0, null);
        }

    }
    PanelSkill panelskill = new PanelSkill();
    StatPlayer statplayer = new StatPlayer();
    StatEnemy statenemy = new StatEnemy();
    Parent parent = new Parent();
    Random r = new Random();

    int rand;
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
    private int playerAttack;
    private int playerDef;
    private int enemyDef;
    private int enemyAttack;
    private int currentstage;
    private int currentturn;
    private boolean isPlayerTurn=false;
    private ArrayList<int[]> enemyBuff = new ArrayList<>();
    private ArrayList<int[]> enemyDebuff = new ArrayList<>();
    private ArrayList<int[]> playerBuff = new ArrayList<>();
    private ArrayList<int[]> playerDebuff = new ArrayList<>();

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

    JLabel nameenemy;
    JLabel spriteenemy;
    JPanel debuffenemy;

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
    istts.pbo.Enemy.StatEnemy currentEnemy;

    ArrayList<istts.pbo.Enemy.StatEnemy> enemy = new ArrayList<>();

    public BattleGUI(Player p) {
        debufflist = new ArrayList<>();
        init(p);
        startPos = turnplayer.getX();
    }

    private void init(Player p) {
        int SWIDTH = 1280;
        int SHEIGHT = 760;
        //beragam get yang harus dirubah
        enemy.add(new Enemy1());
        enemy.add(new Enemy2());
        enemy.add(new Enemy3());
        rand = r.nextInt(3);
        currentEnemy = enemy.get(rand);

        namaplayer = p.getName();
        playerHP = p.getStats().getHealth();
        playermaksHP = p.getStats().getHealth();
        playerMP = p.getStats().getMana();
        playermaksMP = p.getStats().getMana();
        playerspeed = p.getStats().getSpeed();
        playerAttack = p.getStats().getAttack();
        playerDef = p.getStats().getDefense();
        namaenemy = "isinamaenemy";
        enemyHP = currentEnemy.getEnemyhealth();
        enemymaksHP = currentEnemy.getEnemyhealth();
        enemyMP = currentEnemy.getEnemymana();
        enemymaksMP = currentEnemy.getEnemymana();
        enemyspeed = currentEnemy.getEnemyspeed()/10;
        enemyDef = currentEnemy.getEnemydef();
        enemyAttack = currentEnemy.getEnemyatt();
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
        timerdanstage.setBackground(null);
        timerdanstage.setOpaque(false);

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
        papanturn.setIcon(new ImageIcon("src/istts/pbo/res/attackbar.png"));
        //turnplayer
        turnplayer = new JLabel();
        turnplayer.setBounds(400, 100, 50, 50);
        turnplayer.setBackground(new Color(200, 50, 200));
        turnplayer.setText("S");
        turnplayer.setIcon(im.resizeIcon("src/istts/pbo/res/PlayerEnemy.png",50,50));

        turnplayer.setOpaque(false);
        //turnenemy
        turnenemy = new JLabel();
        turnenemy.setBounds(400, 100, 50, 50);
        turnenemy.setBackground(new Color(150, 10, 255));
        turnenemy.setText("E");
        turnenemy.setIcon(im.resizeIcon(im.colorFillRed("src/istts/pbo/res/PlayerEnemy.png"),50,50));
        turnenemy.setOpaque(false);

        //turncount

        turncount = new JLabel();
        turncount.setBounds(520, 225, 240, 50);
        turncount.setBackground(new Color(70, 200, 70));
        turncount.setText("turn : " + currentturn);
        turncount.setIcon(new ImageIcon("src/istts/pbo/res/papanob.png"));
        turncount.setOpaque(false);
        turncount.setHorizontalTextPosition(SwingConstants.CENTER);

        //displayskillname

        displayskillname = new JLabel();
        displayskillname.setBounds(400, 400, 480, 50);
        displayskillname.setBackground(new Color(0, 255, 150));
        displayskillname.setText("cuma ngecek tombol");
        displayskillname.setOpaque(false);
        displayskillname.setIcon(im.resizeIcon("src/istts/pbo/res/papan.png",480,50));
        displayskillname.setHorizontalTextPosition(SwingConstants.CENTER);
        displayskillname.setVerticalTextPosition(SwingConstants.CENTER);

        //nameplayer
        nameplayer = new JLabel();
        nameplayer.setBounds(75, 150, 200, 40);
        nameplayer.setHorizontalTextPosition(SwingConstants.CENTER);
        nameplayer.setVerticalTextPosition(SwingConstants.CENTER);
        nameplayer.setForeground(Color.white);
        nameplayer.setText(namaplayer);
        nameplayer.setFont(new Font("Ninja Naruto",Font.BOLD,15));


        //spriteplayer
        spriteplayer = new JLabel("gambar player");
        spriteplayer.setBounds(75, 200, 200, 200);
        spriteplayer.setIcon(gambarplayerbesar);
        spriteplayer.setBackground(Color.green);
        spriteplayer.setOpaque(false);

        //Debuffplayer

        debuffplayer = new JPanel();
        debuffplayer.setBounds(20, 500, 400, 50);
        debuffplayer.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        debuffplayer.setBackground(Color.cyan);
        debuffplayer.setOpaque(true);

        //Statplayer

        statplayer.setBounds(20, 560, 300, 150);
        statplayer.setLayout(new FlowLayout(FlowLayout.CENTER, 3, 12));
        statplayer.setBackground(Color.orange);
        statplayer.setOpaque(false);

        //Gambarplayer

        gambarplayer = new JLabel("gambar player");
        gambarplayer.setPreferredSize(new Dimension(120, 120));
        gambarplayer.setBackground(Color.green);
        gambarplayer.setIcon(gambarplayerkecil);
        gambarplayer.setOpaque(false);

        //Tampungan HP MP player
        panelHPMPplayer = new JPanel();
        panelHPMPplayer.setLayout(new FlowLayout(FlowLayout.CENTER,0,3));
        panelHPMPplayer.setPreferredSize(new Dimension(140, 120));
        panelHPMPplayer.setBackground(Color.gray);
        panelHPMPplayer.setOpaque(false);

        //labelHPplayer

        labelHPplayer = new JLabel("HP : " + playerHP + " / " + playermaksHP);
        labelHPplayer.setPreferredSize(new Dimension(120, 20));
        labelHPplayer.setBackground(Color.cyan);
        labelHPplayer.setOpaque(false);
        labelHPplayer.setFont(new Font("Arial",Font.BOLD,15));

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
        labelMPplayer.setOpaque(false);
        labelMPplayer.setFont(new Font("Arial",Font.BOLD,15));

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
        nameenemy.setForeground(Color.WHITE);
        nameenemy.setFont(new Font("Ninja Naruto",Font.BOLD,15));

        //spriteenemy
        spriteenemy = new JLabel("gambar enemy");
        spriteenemy.setBounds(SWIDTH - 75 - 200, 200, 200, 200);
        spriteenemy.setBackground(Color.green);
        spriteenemy.setOpaque(false);


        //Debuffenemy

        debuffenemy = new JPanel();
        debuffenemy.setBounds(SWIDTH - 20 - 400, 500, 400, 50);
        debuffenemy.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 12));
        debuffenemy.setBackground(Color.cyan);
        debuffenemy.setOpaque(true);

        //Statenemy

        statenemy.setBounds(SWIDTH - 20 - 300, 560, 300, 150);
        statenemy.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        statenemy.setBackground(Color.orange);
        statenemy.setOpaque(false);


        //Gambarenemy

        gambarenemy = new JLabel("gambar enemy");
        gambarenemy.setPreferredSize(new Dimension(120, 120));
        gambarenemy.setBackground(Color.green);
        gambarenemy.setOpaque(false);

        //Tampungan HP MP enemy
        panelHPMPenemy = new JPanel();
        panelHPMPenemy.setLayout(new FlowLayout(FlowLayout.CENTER,0,3));
        panelHPMPenemy.setPreferredSize(new Dimension(140, 120));
        panelHPMPenemy.setBackground(Color.gray);
        panelHPMPenemy.setOpaque(false);

        //labelHPenemy

        labelHPenemy = new JLabel("HP : " + enemyHP + " / " + enemymaksHP);
        labelHPenemy.setPreferredSize(new Dimension(120, 20));
        labelHPenemy.setBackground(Color.cyan);
        labelHPenemy.setOpaque(false);
        labelHPenemy.setFont(new Font("Arial",Font.BOLD,15));

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
        labelMPenemy.setOpaque(false);
        labelMPenemy.setFont(new Font("Arial",Font.BOLD,15));

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
        panelskill.setBounds(365, 560, 555, 150);
        panelskill.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 15));
        panelskill.setBackground(Color.red);
        panelskill.setOpaque(false);

        //skill 1
        skill1 = new JLabel("Skill1");
        skill1.setPreferredSize(new Dimension(120, 120));
        skill1.setIcon(gambarskill1);
        skill1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (isPlayerTurn){
                    boolean temp = useskil(0,p);
                    if(temp){
                        timergame.start();
                        isPlayerTurn=false;
                        turnplayer.setBounds(startPos,turnplayer.getY(),turnplayer.getWidth(),turnplayer.getHeight());
                        statBuffcek(p);

                        attack.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                        skill1.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                        skill2.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                        skill3.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                    }
                }
            }
        });

        //skill 2
        skill2 = new JLabel("Skill2");
        skill2.setPreferredSize(new Dimension(120, 120));
        skill2.setIcon(gambarskill2);
        skill2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (isPlayerTurn){
                    boolean temp = useskil(1,p);
                    if(temp){
                        timergame.start();
                        isPlayerTurn=false;
                        turnplayer.setBounds(startPos,turnplayer.getY(),turnplayer.getWidth(),turnplayer.getHeight());
                        statBuffcek(p);

                        attack.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                        skill1.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                        skill2.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                        skill3.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                    }
                }
            }
        });

        //skill 3
        skill3 = new JLabel("Skill3");
        skill3.setPreferredSize(new Dimension(120, 120));
        skill3.setIcon(gambarskill3);
        skill3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (isPlayerTurn){
                    boolean temp = useskil(2,p);
                    if(temp){
                        timergame.start();
                        isPlayerTurn=false;
                        turnplayer.setBounds(startPos,turnplayer.getY(),turnplayer.getWidth(),turnplayer.getHeight());
                        statBuffcek(p);

                        attack.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                        skill1.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                        skill2.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                        skill3.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                    }
                }
            }
        });

        //attack
        attack = new JLabel("Attack");
        attack.setPreferredSize(new Dimension(120, 120));
        attack.setIcon(new ImageIcon("src/istts/pbo/res/IconSkill/Attack.png"));
        attack.setOpaque(false);

        attack.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (isPlayerTurn){
                    timergame.start();
                    isPlayerTurn=false;
                    turnplayer.setBounds(startPos,turnplayer.getY(),turnplayer.getWidth(),turnplayer.getHeight());
                    statBuffcek(p);

                    /*
                     * Attack Process
                     */
                    int damage = playerAttack - (playerAttack *  enemyDef / 100);

                    enemyHP = enemyHP - damage;
                    labelHPenemy.setText("HP : " + enemyHP + " / " + enemymaksHP);

                    double tes = 110 * (enemyHP * 1.0 / enemymaksHP);
                    int tes1 = (int) Math.round(tes);

                    HPBARenemyfront.setBounds(5, 5, tes1, 20);
                    HPBARenemyfront.setBackground(new Color(255, 0, 0));
                    HPBARenemyfront.setOpaque(true);
                    HPBARenemyfront.repaint();
                    HPBARenemyfront.revalidate();

                    displayskillname.setText(p.getName()+" Basic Attack ("+damage+")");

                    /*
                     * end Attack Process
                     */

                    attack.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                    skill1.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                    skill2.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                    skill3.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                }
            }
        });

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
                    isPlayerTurn=true;
                    attack.setCursor(new Cursor(Cursor.HAND_CURSOR));
                    skill1.setCursor(new Cursor(Cursor.HAND_CURSOR));
                    skill2.setCursor(new Cursor(Cursor.HAND_CURSOR));
                    skill3.setCursor(new Cursor(Cursor.HAND_CURSOR));
                    /*
                   Process
                     */
//                    try {
//                        Thread.sleep(0);
//                    } catch (InterruptedException interruptedException) {
//                        interruptedException.printStackTrace();
//                    }
//                    timergame.start();
//                    turnplayer.setBounds(startPos,turnplayer.getY(),turnplayer.getWidth(),turnplayer.getHeight());
                }
                if(turnenemy.getX()+turnenemy.getWidth()>=papanturn.getX()+papanturn.getWidth()){
                    timergame.stop();
                    int damage = currentEnemy.getEnemyatt() - (currentEnemy.getEnemyatt() * playerDef / 100);
                    playerHP = playerHP - damage;
                    labelHPplayer.setText("HP : " + playerHP + " / " + playermaksHP);

                    double tes = 110 * (playerHP * 1.0 / playermaksHP);
                    int tes1 = (int) Math.round(tes);

                    HPBARplayerfront.setBounds(5, 5, tes1, 20);
                    HPBARplayerfront.repaint();
                    HPBARplayerfront.revalidate();

                    displayskillname.setText(currentEnemy.getName()+" Basic Attack ("+damage+")");

                    turnenemy.setBounds(startPos, turnenemy.getY(),turnenemy.getWidth(),turnenemy.getHeight());
                    timergame.start();
                }
                if (enemyHP<=0){
                    rand = r.nextInt(3);
                    System.out.println(rand);
                    currentEnemy = enemy.get(rand);
                    namaenemy = "isinamaenemy";
                    enemyHP = currentEnemy.getEnemyhealth();
                    enemymaksHP = currentEnemy.getEnemyhealth();
                    enemyMP = currentEnemy.getEnemymana();
                    enemyDef = currentEnemy.getEnemydef();
                    enemyAttack = currentEnemy.getEnemyatt();
                    enemymaksMP = currentEnemy.getEnemymana();
                    enemyspeed = currentEnemy.getEnemyspeed();
                    labelHPenemy.setText("HP : " + enemyHP + " / " + enemymaksHP);
                    labelMPenemy.setText("MP : " + enemyMP + " / " + enemymaksMP);
                    turnenemy.setBounds(startPos, turnenemy.getY(),turnenemy.getWidth(),turnenemy.getHeight());
                    spriteenemy.setIcon(new ImageIcon(currentEnemy.getEnemysprite()));
                    gambarenemy.setIcon(new ImageIcon(currentEnemy.getEnemysprite()));
                    nameenemy.setText(currentEnemy.getName());

                    HPBARenemyfront.setBounds(5, 5, 110, 20);
                    HPBARenemyfront.setBackground(new Color(255, 0, 0));
                    HPBARenemyfront.setOpaque(true);
                    HPBARenemyfront.revalidate();
                    HPBARenemyfront.repaint();

                    currentstage++;

                    stage.setText("Stage : "+currentstage);
                }
                if (playerHP<=0){
                    JOptionPane.showMessageDialog(null,"Kalah sayang!");
                    timergame.stop();
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

        //beragam get yang harus dirubah
        namaplayer = p.getName();
        playerHP = p.getPlayerClass().getStats().getHealth();
        playermaksHP = p.getPlayerClass().getStats().getHealth();
        playerMP = p.getPlayerClass().getStats().getMana();
        playermaksMP = p.getPlayerClass().getStats().getMana();
        playerAttack = p.getStats().getAttack();
        playerDef = p.getStats().getDefense();
        playerspeed = p.getPlayerClass().getStats().getSpeed();
        namaenemy = "isinamaenemy";
        enemyHP = currentEnemy.getEnemyhealth();
        enemyDef = currentEnemy.getEnemydef();
        enemyAttack = currentEnemy.getEnemyatt();
        enemymaksHP = currentEnemy.getEnemyhealth();
        enemyMP = currentEnemy.getEnemymana();
        enemymaksMP = currentEnemy.getEnemymana();
        gambarenemy.setIcon(im.resizeIcon(currentEnemy.getEnemysprite(),120,120));
        enemyspeed = currentEnemy.getEnemyspeed();
        spriteenemy.setIcon(new ImageIcon(currentEnemy.getEnemysprite()));
        currentstage = 1;
        currentturn = 1;
        nameenemy.setText(currentEnemy.getName());
        turnplayer.setBounds(startPos,turnplayer.getY(),turnplayer.getWidth(),turnplayer.getHeight());
        turnenemy.setBounds(startPos,turnenemy.getY(),turnenemy.getWidth(),turnenemy.getHeight());
        spriteenemy.setIcon(new ImageIcon(currentEnemy.getEnemysprite()));

        ManaBARplayerfront.setBounds(5,5,110,20);
        HPBARplayerfront.setBounds(5,5,110,20);
        ManaBARenemyfront.setBounds(5,5,110,20);
        HPBARenemyfront.setBounds(5,5,110,20);
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

        //lalalala

        parent.add(menu);
        menu.revalidate();
        menu.repaint();
        menu.setVisible(true);

        labelHPplayer.setText("HP : " + playerHP + " / " + playermaksHP);
        labelMPplayer.setText("MP : " + playerMP + " / " + playermaksMP);
        labelHPenemy.setText("HP : " + enemyHP + " / " + enemymaksHP);
        labelMPenemy.setText("MP : " + enemyMP + " / " + enemymaksMP);



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

    private boolean useskil(int index, Player p){
        if(p.getEquippedSkills()[index] instanceof DamageOnly){
            int[] values = ((DamageOnly) p.getEquippedSkills()[index]).useSkill();
            if (playerMP>=values[1]){
                enemyHP = enemyHP-values[0];
                playerMP = playerMP-values[1];
                labelHPenemy.setText("HP : "+enemyHP + " / " + enemymaksHP);
                labelMPplayer.setText("MP : "+playerMP+" / "+playermaksMP);

                int scaledEnemyHP =(int) Math.round(110 * (enemyHP*1.0/enemymaksHP));

                HPBARenemyfront.setBounds(5,5,scaledEnemyHP,20);
                HPBARenemyfront.revalidate();
                HPBARenemyfront.repaint();

                int scaledPlayerMP = (int) Math.round(110 * (playerMP*1.0/playermaksMP));

                ManaBARplayerfront.setBounds(5,5,scaledPlayerMP,20);
                ManaBARplayerfront.revalidate();
                ManaBARplayerfront.repaint();

                displayskillname.setText(p.getName()+" use "+p.getEquippedSkills()[index].getName()+"("+values[0]+")");

                return true;
            }else {
                JOptionPane.showMessageDialog(null,"Mana tidak cukup");
                return false;
            }
        }
        else if(p.getEquippedSkills()[index] instanceof Buff){
            int[] values = ((Buff) p.getEquippedSkills()[index]).useskill();
            if (playerMP>=values[3]){
                playerBuff.add(values);

                playerMP-=values[3];

                labelMPplayer.setText("MP : "+playerMP+" / "+playermaksMP);

                int scaledPlayerMP = (int) Math.round(110 * (playerMP*1.0/playermaksMP));

                displayskillname.setText(p.getName()+" use "+p.getEquippedSkills()[index].getName());

                ManaBARplayerfront.setBounds(5,5,scaledPlayerMP,20);
                ManaBARplayerfront.revalidate();
                ManaBARplayerfront.repaint();

                return true;
            }else{
                JOptionPane.showMessageDialog(null,"Mana tidak cukup");
                return false;
            }
        }
        else if(p.getEquippedSkills()[index] instanceof StatusEffect){
            int[] values = ((StatusEffect) p.getEquippedSkills()[index]).useskill();
            if (playerMP>=values[3]){
                enemyDebuff.add(values);
                playerMP-=values[3];

                labelMPplayer.setText("MP : "+playerMP+" / "+playermaksMP);

                int scaledPlayerMP = (int) Math.round(110 * (playerMP*1.0/playermaksMP));

                displayskillname.setText(p.getName()+" use "+p.getEquippedSkills()[index].getName());

                ManaBARplayerfront.setBounds(5,5,scaledPlayerMP,20);
                ManaBARplayerfront.revalidate();
                ManaBARplayerfront.repaint();

                return true;

            }else {
                JOptionPane.showMessageDialog(null,"Mana tidak cukup");
                return false;
            }
        }else if (p.getEquippedSkills()[index] instanceof Heal){
            int[] values = ((Heal) p.getEquippedSkills()[index]).useSkill();
            if (playerMP>=values[1]){

                int recover = playermaksHP * values[0] / 100;
                playerMP-=values[1];
                if (playermaksHP-playerHP<recover){
                    playerHP=playermaksHP;
                }else {
                    playerHP= playerHP + recover;
                }

                labelHPplayer.setText("HP : "+playerHP + " / " + playermaksHP);
                labelMPplayer.setText("MP : "+playerMP+" / "+playermaksMP);

                displayskillname.setText(p.getName()+" use "+p.getEquippedSkills()[index].getName()+" heal ("+recover+") hp");

                int scaledEnemyHP =(int) Math.round(110 * (playerHP*1.0/playermaksHP));

                HPBARplayerfront.setBounds(5,5,scaledEnemyHP,20);
                HPBARplayerfront.revalidate();
                HPBARplayerfront.repaint();

                int scaledPlayerMP = (int) Math.round(110 * (playerMP*1.0/playermaksMP));

                ManaBARplayerfront.setBounds(5,5,scaledPlayerMP,20);
                ManaBARplayerfront.revalidate();
                ManaBARplayerfront.repaint();

                return true;
            }else {
                JOptionPane.showMessageDialog(null,"Mana tidak cukup");
                return false;
            }
        }else if (p.getEquippedSkills()[index] instanceof Mana){
            int recover = ((Mana) p.getEquippedSkills()[index]).useSkill();
            if (playermaksMP-playerMP<recover){
                playerMP=playermaksMP;
            }else {
                playerMP= playerMP + recover;
            }
            int scaledPlayerMP = (int) Math.round(110 * (playerMP*1.0/playermaksMP));

            ManaBARplayerfront.setBounds(5,5,scaledPlayerMP,20);
            ManaBARplayerfront.revalidate();
            ManaBARplayerfront.repaint();

            labelMPplayer.setText("MP : "+playerMP+" / "+playermaksMP);

            displayskillname.setText(p.getName()+" use "+p.getEquippedSkills()[index].getName()+" recover ("+recover+") mana");

            return true;
        }
        return false;
    }

    private void statBuffcek(Player p){
        for (int i = 0; i < playerBuff.size(); i++) {
            if (playerBuff.get(i)[0]==3){
                if (playerBuff.get(i)[2]>=1){
                    playerspeed = p.getStats().getSpeed() + playerBuff.get(i)[1];
                    playerBuff.get(i)[2]=playerBuff.get(i)[2] - 1;
                }else {
                    playerspeed = p.getStats().getSpeed();
                }
            }
            else if (playerBuff.get(i)[0]==2){
                if (playerBuff.get(i)[2]>=1) {
                    playerAttack = p.getStats().getAttack() + (p.getStats().getAttack() * playerBuff.get(i)[1] / 100);
                    playerBuff.get(i)[2]=playerBuff.get(i)[2] - 1;
                }else {
                    playerAttack = p.getStats().getAttack();
                }
            }
            else if (playerBuff.get(i)[0]==4){
                if (playerBuff.get(i)[2]>=1) {
                    playerDef = p.getStats().getDefense() + (p.getStats().getDefense() * playerBuff.get(i)[1] / 100);
                    playerBuff.get(i)[2]=playerBuff.get(i)[2] - 1;
                }else {
                    playerDef = p.getStats().getDefense();
                }
            }
            else if (playerBuff.get(i)[0]==5){
                if (playerBuff.get(i)[2]>=1) {
                    playerAttack = p.getStats().getAttack() + p.getStats().getAttack();
                    playerBuff.get(i)[2]=playerBuff.get(i)[2] - 1;
                }else {
                    playerAttack = p.getStats().getAttack();
                }
            }
        }
    }


    private void repaintturn() {

    }

    private void repaintdebuff() {

    }
}
