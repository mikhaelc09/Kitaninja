package istts.pbo.GamePage;

import istts.pbo.Classes.Ninjutsu;
import istts.pbo.Classes.Qiqong;
import istts.pbo.Classes.Taijutsu;
import istts.pbo.Players.Item;
import istts.pbo.Players.Player;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static istts.pbo.Main.SHEIGHT;
import static istts.pbo.Main.SWIDTH;

public class ProfilePanel extends JPanel {
    JPanel playerr;
    JLabel Foto;
    JLabel statnama;
    JLabel stat1;
    JLabel stat2;
    JLabel stat3;
    JLabel stat4;
    JLabel stat5;
    JLabel back;
    JLabel gold;
    Player player;
    JLabel exp;
    Font fontlb = new Font("Ninja Naruto", Font.PLAIN, 30);
    public ProfilePanel(Player player){
        this.player = player;
        init();
    }
    private void init(){
        setSize(new Dimension(SWIDTH,SHEIGHT));
        //mainpanel
        class Parent extends JPanel{
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                draw(g);
            }

            private void draw(Graphics g) {
                try {
                    BufferedImage bg = ImageIO.read(new File("src/istts/pbo/res/backgrounds/Profile.png"));
                    g.drawImage(bg, 0, 0, null);
                } catch (IOException e) {
                    e.printStackTrace();

                }
            }
        }
        Parent parent = new Parent();
        parent.setBounds(0,0,SWIDTH,SHEIGHT);
        parent.setSize(new Dimension(SWIDTH,SHEIGHT));
        parent.setLayout(null);
        parent.setPreferredSize(new Dimension(SWIDTH,SHEIGHT));
        parent.setBackground(Color.GRAY);
        parent.setOpaque(true);
        this.add(parent);

        //panel player
        class Playerr extends JPanel{
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                draw(g);
            }

            private void draw(Graphics g) {
                try {
                    BufferedImage bg = ImageIO.read(new File("src/istts/pbo/res/Tab/ProfilTab1.png"));
                    g.drawImage(bg, 0, 0, null);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        Playerr playerr = new Playerr();
        playerr.setBounds(50,100,400,600);
        playerr.setLayout(null);
        playerr.setOpaque(false);

        //Foto
        Foto = new JLabel();
        Foto.setBounds(100,10,200,250);
        if (player.getPlayerClass().getClassname().equalsIgnoreCase("qiqong")){
            Foto.setIcon(new ImageIcon("src/istts/pbo/res/sprites/qigong_big.gif"));
        }else if (player.getPlayerClass().getClassname().equalsIgnoreCase("taijutsu")){
            Foto.setIcon(new ImageIcon("src/istts/pbo/res/sprites/taijutsu_big.gif"));
        }else if (player.getPlayerClass().getClassname().equalsIgnoreCase("ninjutsu")){
            Foto.setIcon(new ImageIcon("src/istts/pbo/res/sprites/ninjutsu_big.gif"));
        }

        //Stat
        class Stat extends JPanel{
                        protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                draw(g);
            }

            private void draw(Graphics g) {
                try {
                    BufferedImage bg = ImageIO.read(new File("src/istts/pbo/res/Tab/ProfilTab2.png"));
                    g.drawImage(bg, 0, 0, null);
                } catch (IOException e) {
                    e.printStackTrace();

                }
            }
        }
        Stat stat = new Stat();
        stat.setBounds(10,270,380,320);
        stat.setBackground(new Color(10,10,244));
        stat.setOpaque(false);
        stat.setLayout(null);


        //nama stat
        statnama = new JLabel("Status");
        statnama.setFont(fontlb);
        statnama.setBounds(120,10,200,50);
        statnama.setBackground(Color.cyan);
        statnama.setOpaque(false);


        //stat1
        stat1 = new JLabel("HP : "+player.getPlayerClass().getStats().getHealth());
        stat1.setBounds(30,60,350,40);
        stat1.setBackground(Color.cyan);
        stat1.setOpaque(false);
        stat1.setFont(new Font("Ninja Naruto",Font.PLAIN,25));

        //stat2
        stat2 = new JLabel("Mana : "+player.getPlayerClass().getStats().getMana());
        stat2.setBounds(30,110,350,40);
        stat2.setBackground(Color.cyan);
        stat2.setOpaque(false);
        stat2.setFont(new Font("Ninja Naruto",Font.PLAIN,25));

        //stat3
        stat3 = new JLabel("Attack : "+player.getPlayerClass().getStats().getAttack());
        stat3.setBounds(30,160,350,40);
        stat3.setBackground(Color.cyan);
        stat3.setOpaque(false);
        stat3.setFont(new Font("Ninja Naruto",Font.PLAIN,25));

        //stat4
        stat4 = new JLabel("Def : "+player.getPlayerClass().getStats().getDefense());
        stat4.setBounds(30,210,350,40);
        stat4.setBackground(Color.cyan);
        stat4.setOpaque(false);
        stat4.setFont(new Font("Ninja Naruto",Font.PLAIN,25));

        //stat5
        stat5 = new JLabel("Speed : "+player.getPlayerClass().getStats().getSpeed());
        stat5.setBounds(30,260,350,40);
        stat5.setBackground(Color.cyan);
        stat5.setOpaque(false);
        stat5.setFont(new Font("Ninja Naruto",Font.PLAIN,25));

        //back
        back = new JLabel();
        back.setBounds(20,20,100,50);
        back.setIcon(new ImageIcon("src/istts/pbo/res/buttons/Back.png"));
        back.setCursor(new Cursor(Cursor.HAND_CURSOR));


        //kotak profile
        class Kotakprofile extends JPanel {
            public Kotakprofile() {
                this.setLayout(null);
            }
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                draw(g);
            }

            private void draw(Graphics g) {
                try {
                    BufferedImage bg = ImageIO.read(new File("src/istts/pbo/res/papan.png"));
//                    g.drawImage(bg, 0, 0, null);
                    g.drawImage(bg.getScaledInstance(770,620,Image.SCALE_DEFAULT), 0, 0, null);
                } catch (IOException e) {
                    e.printStackTrace();

                }
            }
        }
        Kotakprofile kprofile = new Kotakprofile();
        kprofile.setBounds(500,70,770,620);
        kprofile.setLayout(null);
        //setopaquefalse dan comment
        kprofile.setOpaque(false);
        kprofile.setBackground(new Color(0,100,0));
        //


        //Panel kiriatas
        class Pkiriatas extends JPanel{
            public Pkiriatas(){}
            //            protected void paintComponent(Graphics g) {
//                super.paintComponent(g);
//                draw(g);
//            }
//
//            private void draw(Graphics g) {
//                try {
//                    BufferedImage bg = ImageIO.read(new File("src/com/company/res/papan.png"));
//                    g.drawImage(bg, 0, 0, null);
//                } catch (IOException e) {
//                    e.printStackTrace();
//
//                }
//            }
        }
        Pkiriatas pkiriatas = new Pkiriatas();
        pkiriatas.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
        pkiriatas.setBounds(20,40,485,200);
        //
        pkiriatas.setBackground(new Color(255,51,201));
        pkiriatas.setOpaque(false);
        //

        //kiri
        JPanel kiriataskiri = new JPanel();
        kiriataskiri.setLayout(new FlowLayout(FlowLayout.CENTER,10,0));
        kiriataskiri.setPreferredSize(new Dimension(150,250));
        //
        kiriataskiri.setBackground(new Color(150,200,0));
        kiriataskiri.setOpaque(false);
        //

        //icon class
        JLabel iconclass = new JLabel();
        iconclass.setPreferredSize(new Dimension(120,120));
        //
        iconclass.setBackground(new Color(150,100,0));
        iconclass.setOpaque(true);
        String iconSprite = "";
        if (player.getPlayerClass().getClassname().equalsIgnoreCase("taijutsu")){
            iconSprite="src/istts/pbo/res/IconSkill/Taijutsu-FalconPunch.png";
        }else if (player.getPlayerClass().getClassname().equalsIgnoreCase("qiqong")){
            iconSprite="src/istts/pbo/res/IconSkill/Qiqong-Kamehameha.png";
        }else if (player.getPlayerClass().getClassname().equalsIgnoreCase("ninjutsu")){
            iconSprite="src/istts/pbo/res/IconSkill/Ninjutsu-ShurikenThrow.png";
        }
        iconclass.setIcon(new ImageIcon(iconSprite));
        //

        //nama class
        JLabel namaclass = new JLabel(player.getPlayerClass().getClassname());
        namaclass.setPreferredSize(new Dimension(140,80));
        namaclass.setFont(new Font("Ninja Naruto",Font.PLAIN,25));
        namaclass.setHorizontalTextPosition(SwingConstants.CENTER);
        //
        namaclass.setBackground(new Color(150,120,20));
        namaclass.setOpaque(false);
        //

        //kanan
        JPanel kiriataskanan = new JPanel();
        kiriataskanan.setLayout(new FlowLayout(FlowLayout.CENTER,10,15));
        kiriataskanan.setPreferredSize(new Dimension(295,280));
        //
        kiriataskanan.setBackground(new Color(150,200,0));
        kiriataskanan.setOpaque(false);
        //

        //Nama
        JLabel nama = new JLabel("Nama : "+player.getName());
        nama.setPreferredSize(new Dimension(275,30));
        nama.setFont(new Font("Arial",Font.BOLD,30));
        //
        nama.setBackground(new Color(150,120,120));
        nama.setOpaque(false);
        //

        //Gold
        gold = new JLabel("Gold : " + player.getGold());
        gold.setPreferredSize(new Dimension(275,30));
        gold.setFont(new Font("Arial",Font.BOLD,30));
        //
        gold.setBackground(Color.YELLOW);
        gold.setOpaque(false);

        //

        //Exp
        exp = new JLabel("Exp : "+ player.getXp());
        exp.setPreferredSize(new Dimension(275,30));
        exp.setFont(new Font("Arial",Font.BOLD,30));

        //
        exp.setBackground(Color.green);
        exp.setOpaque(false);
        //

        //Panel kiribawah1
        class Pkiribawah1 extends JPanel{
            public Pkiribawah1(){}
            //            protected void paintComponent(Graphics g) {
//                super.paintComponent(g);
//                draw(g);
//            }
//
//            private void draw(Graphics g) {
//                try {
//                    BufferedImage bg = ImageIO.read(new File("src/com/company/res/papan.png"));
//                    g.drawImage(bg, 0, 0, null);
//                } catch (IOException e) {
//                    e.printStackTrace();
//
//                }
//            }
        }
        Pkiribawah1 pkiribawah1 = new Pkiribawah1();
        pkiribawah1.setLayout(new FlowLayout(FlowLayout.CENTER,10,8));
        pkiribawah1.setBounds(30,245,480,320);
        //
        pkiribawah1.setBackground(new Color(200,51,201));
        pkiribawah1.setOpaque(false);
        pkiribawah1.setBorder(BorderFactory.createLineBorder(Color.RED,5,true));

        //

        //isipanel
        //nama
        JLabel skill = new JLabel();
        skill.setFont(new Font("Ninja Naruto",Font.PLAIN,30));
        skill.setPreferredSize(new Dimension(475,0));
        skill.setHorizontalTextPosition(SwingConstants.CENTER);
        skill.setVerticalAlignment(SwingConstants.CENTER);
        //
        skill.setBackground(new Color(80,60,150));
        skill.setOpaque(false);
        //
        //panel1kiribawah
        JPanel kiribawahpanel1 = new JPanel();
        kiribawahpanel1.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
        kiribawahpanel1.setPreferredSize(new Dimension(475,90));
        //
        kiribawahpanel1.setBackground(new Color(30,80,200));
        kiribawahpanel1.setOpaque(false);
        //

        //namaskill1
        JLabel namaskill1 = new JLabel("Skill 1");
        namaskill1.setPreferredSize(new Dimension(375,80));
        //
        namaskill1.setBackground(new Color(250,200,50));
        namaskill1.setOpaque(false);
        //
        //iconskill1
        JLabel iconskill1 = new JLabel("Icon S1");
        iconskill1.setPreferredSize(new Dimension(80,80));
        //
        iconskill1.setBackground(new Color(150,255,100));
        iconskill1.setIcon(im.getSIcon(new ImageIcon("src/istts/pbo/res/Item/Blank.png")));
        iconskill1.setOpaque(false);
        //

        kiribawahpanel1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                skillChange(player, 0, iconskill1,namaskill1);
            }
        });

        namaskill1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                skillChange(player,0, iconskill1,namaskill1);
            }
        });

        iconskill1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                skillChange(player,0, iconskill1,namaskill1);
            }
        });

        kiribawahpanel1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        namaskill1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        iconskill1.setCursor(new Cursor(Cursor.HAND_CURSOR));

        if(player.getEquippedSkills()[0] != null){
            iconskill1.setIcon(im.getSIcon(player.getEquippedSkills()[0].getIconPath()));
            namaskill1.setText(player.getEquippedSkills()[0].getName());
        }

        //panel2kiribawah
        JPanel kiribawahpanel2 = new JPanel();
        kiribawahpanel2.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
        kiribawahpanel2.setPreferredSize(new Dimension(475,90));
        //
        kiribawahpanel2.setBackground(new Color(30,80,200));
        kiribawahpanel2.setOpaque(false);

        //namaskill2
        JLabel namaskill2 = new JLabel("Skill 2");
        namaskill2.setPreferredSize(new Dimension(375,80));
        //
        namaskill2.setBackground(new Color(250,200,50));
        namaskill2.setOpaque(false);
        //
        //iconskill2
        JLabel iconskill2 = new JLabel("Icon S2");
        iconskill2.setPreferredSize(new Dimension(80,80));
        //
        iconskill2.setBackground(new Color(150,255,100));
        iconskill2.setIcon(im.getSIcon(new ImageIcon("src/istts/pbo/res/Item/Blank.png")));
        iconskill2.setOpaque(false);
        //

        kiribawahpanel2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                skillChange(player,1, iconskill2,namaskill2);
            }
        });

        namaskill2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                skillChange(player,1, iconskill2,namaskill2);
            }
        });

        iconskill2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                skillChange(player,1, iconskill2,namaskill2);
            }
        });

        kiribawahpanel2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        namaskill2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        iconskill2.setCursor(new Cursor(Cursor.HAND_CURSOR));

        if(player.getEquippedSkills()[1] != null){
            iconskill2.setIcon(im.getSIcon(player.getEquippedSkills()[1].getIconPath()));
            namaskill2.setText(player.getEquippedSkills()[1].getName());
        }

        //panel3kiribawah
        JPanel kiribawahpanel3 = new JPanel();
        kiribawahpanel3.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
        kiribawahpanel3.setPreferredSize(new Dimension(475,90));
        //
        kiribawahpanel3.setBackground(new Color(30,80,200));
        kiribawahpanel3.setOpaque(false);

        //namaskill3
        JLabel namaskill3 = new JLabel("Skill 3");
        namaskill3.setPreferredSize(new Dimension(375,80));
        //
        namaskill3.setBackground(new Color(250,200,50));
        namaskill3.setOpaque(false);
        //
        //iconskill3
        JLabel iconskill3 = new JLabel("Icon S3");
        iconskill3.setPreferredSize(new Dimension(80,80));
        //
        iconskill3.setBackground(new Color(150,255,100));
        iconskill3.setIcon(im.getSIcon(new ImageIcon("src/istts/pbo/res/Item/Blank.png")));
        iconskill3.setOpaque(false);
        //

        kiribawahpanel3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                skillChange(player,2, iconskill3,namaskill3);
            }
        });

        namaskill3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                skillChange(player,2, iconskill3,namaskill3);
            }
        });

        namaskill3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                skillChange(player,2, iconskill3,namaskill3);
            }
        });

        kiribawahpanel3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        namaskill3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        iconskill3.setCursor(new Cursor(Cursor.HAND_CURSOR));

        if(player.getEquippedSkills()[2] != null){
            iconskill3.setIcon(im.getSIcon(player.getEquippedSkills()[2].getIconPath()));
            namaskill3.setText(player.getEquippedSkills()[2].getName());
        }

        //Panel kanan
        class Pkanan extends JPanel{
            public Pkanan(){}
            //            protected void paintComponent(Graphics g) {
//                super.paintComponent(g);
//                draw(g);
//            }
//
//            private void draw(Graphics g) {
//                try {
//                    BufferedImage bg = ImageIO.read(new File("src/com/company/res/papan.png"));
//                    g.drawImage(bg, 0, 0, null);
//                } catch (IOException e) {
//                    e.printStackTrace();
//
//                }
//            }
        }
        Pkanan pkanan = new Pkanan();

        pkanan.setBounds(520,47,230,517);
        //
        pkanan.setBackground(new Color(255,153,51));
        pkanan.setOpaque(false);
        pkanan.setBorder(BorderFactory.createLineBorder(Color.cyan,5,true));
        pkanan.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));

        //label judul
//        JLabel equipment  = new JLabel("Equipment");
//        equipment.setPreferredSize(new Dimension(210,30));
//        equipment.setHorizontalTextPosition(SwingConstants.CENTER);
//        equipment.setVerticalAlignment(SwingConstants.CENTER);
        //
//        equipment.setBackground(new Color(150,130,190));
//        equipment.setOpaque(true);

        //Panel item item
        JPanel Equipall = new JPanel();
        Equipall.setPreferredSize(new Dimension(230,510));
        Equipall.setLayout(new FlowLayout(FlowLayout.CENTER,10,4));
        //
        Equipall.setBackground(new Color(255,70,10));
        Equipall.setOpaque(false);
        //

        //Panel Equip 1
        JPanel Equip1 = new JPanel();
        Equip1.setPreferredSize(new Dimension(225,93));
        Equip1.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
        //
        Equip1.setBackground(new Color(0,255,100));
        Equip1.setOpaque(false);
        //

        //Equip1Gambar
        JLabel Gambarequip1 = new JLabel("Equip 1");
        Gambarequip1.setPreferredSize(new Dimension(83,83));
        //
        Gambarequip1.setBackground(new Color(30,80,200));
        Gambarequip1.setOpaque(false);
        Gambarequip1.setIcon(im.getSIcon(new ImageIcon("src/istts/pbo/res/Item/Blank.png")));
        Gambarequip1.setCursor(new Cursor(Cursor.HAND_CURSOR));

        //

        //Equip1Nama
        JLabel Namaequip1 = new JLabel("Helmet");
        Namaequip1.setPreferredSize(new Dimension(124,83));
        //
        Namaequip1.setBackground(new Color(100,120,250));
        Namaequip1.setOpaque(false);
        //

        Gambarequip1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                equipSelection(player,1,Gambarequip1,stat1,Namaequip1);
            }
        });

        if(player.getEquipment().getHead()!=null){
            Namaequip1.setText(player.getEquipment().getHead().getName());
            Gambarequip1.setIcon(im.getSIcon(player.getEquipment().getHead().getSpritePath()));
        }

        //Equip1Logo

        //Panel Equip 2
        JPanel Equip2 = new JPanel();
        Equip2.setPreferredSize(new Dimension(225,93));
        Equip2.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
        //
        Equip2.setBackground(new Color(0,255,100));
        Equip2.setOpaque(false);
        //
        //Equip2Gambar
        JLabel Gambarequip2 = new JLabel("item 2");
        Gambarequip2.setPreferredSize(new Dimension(83,83));
        //
        Gambarequip2.setBackground(new Color(30,80,200));
        Gambarequip2.setOpaque(false);
        Gambarequip2.setIcon(im.getSIcon(new ImageIcon("src/istts/pbo/res/Item/Blank.png")));
        Gambarequip2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        //

        //Equip2Nama
        JLabel Namaequip2 = new JLabel("Weapon");
        Namaequip2.setPreferredSize(new Dimension(124,83));
        //
        Namaequip2.setBackground(new Color(100,120,250));
        Namaequip2.setOpaque(false);

        Gambarequip2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                equipSelection(player,2,Gambarequip2,stat3,Namaequip2);
            }
        });

        if(player.getEquipment().getWeapon()!=null){
            Namaequip2.setText(player.getEquipment().getWeapon().getName());
            Gambarequip2.setIcon(im.getSIcon(player.getEquipment().getWeapon().getSpritePath()));
        }


        //Panel Equip 3
        JPanel Equip3 = new JPanel();
        Equip3.setPreferredSize(new Dimension(225,93));
        Equip3.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
        //
        Equip3.setBackground(new Color(0,255,100));
        Equip3.setOpaque(false);
        //

        //Equip3Gambar
        JLabel Gambarequip3 = new JLabel("Equip 3");
        Gambarequip3.setPreferredSize(new Dimension(83,83));
        //
        Gambarequip3.setBackground(new Color(30,80,200));
        Gambarequip3.setOpaque(false);
        Gambarequip3.setIcon(im.getSIcon(new ImageIcon("src/istts/pbo/res/Item/Blank.png")));
        Gambarequip3.setCursor(new Cursor(Cursor.HAND_CURSOR));


        //

        //Equip3Nama
        JLabel Namaequip3 = new JLabel("Body");
        Namaequip3.setPreferredSize(new Dimension(124,83));
        //
        Namaequip3.setBackground(new Color(100,120,250));
        Namaequip3.setOpaque(false);

        Gambarequip3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                equipSelection(player,3,Gambarequip3,stat4,Namaequip3);
            }
        });

        if(player.getEquipment().getBody()!=null){
            Namaequip3.setText(player.getEquipment().getBody().getName());
            Gambarequip3.setIcon(im.getSIcon(player.getEquipment().getBody().getSpritePath()));
        }

        //Panel Equip 4
        JPanel Equip4 = new JPanel();
        Equip4.setPreferredSize(new Dimension(225,93));
        Equip4.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
        //
        Equip4.setBackground(new Color(0,255,100));
        Equip4.setOpaque(false);
        //

        //Equip4Gambar
        JLabel Gambarequip4 = new JLabel("Equip 4");
        Gambarequip4.setPreferredSize(new Dimension(83,83));
        //
        Gambarequip4.setBackground(new Color(30,80,200));
        Gambarequip4.setOpaque(false);
        Gambarequip4.setIcon(im.getSIcon(new ImageIcon("src/istts/pbo/res/Item/Blank.png")));
        Gambarequip4.setCursor(new Cursor(Cursor.HAND_CURSOR));


        //

        //Equip4Nama
        JLabel Namaequip4 = new JLabel("Boots");
        Namaequip4.setPreferredSize(new Dimension(124,83));
        //
        Namaequip4.setBackground(new Color(100,120,250));
        Namaequip4.setOpaque(false);

        Gambarequip4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                equipSelection(player,4,Gambarequip4,stat5,Namaequip4);
            }
        });

        if(player.getEquipment().getBoots()!=null){
            Namaequip4.setText(player.getEquipment().getBoots().getName());
            Gambarequip4.setIcon(im.getSIcon(player.getEquipment().getBoots().getSpritePath()));
        }

        //Panel Equip 5
        JPanel Equip5 = new JPanel();
        Equip5.setPreferredSize(new Dimension(225,93));
        Equip5.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
        //
        Equip5.setBackground(new Color(0,255,100));
        Equip5.setOpaque(false);
        //

        //Equip5Gambar
        JLabel Gambarequip5 = new JLabel("Equip 5");
        Gambarequip5.setPreferredSize(new Dimension(83,83));
        //
        Gambarequip5.setBackground(new Color(30,80,200));
        Gambarequip5.setOpaque(false);
        Gambarequip5.setIcon(im.getSIcon(new ImageIcon("src/istts/pbo/res/Item/Blank.png")));
        Gambarequip5.setCursor(new Cursor(Cursor.HAND_CURSOR));
        //

        //Equip5Nama
        JLabel Namaequip5 = new JLabel("Accesories");
        Namaequip5.setPreferredSize(new Dimension(124,83));
        //
        Namaequip5.setBackground(new Color(100,120,250));
        Namaequip5.setOpaque(false);

        Gambarequip5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                equipSelection(player,5,Gambarequip5,stat2,Namaequip5);
            }
        });

        if(player.getEquipment().getAccesories()!=null){
            Namaequip5.setText(player.getEquipment().getAccesories().getName());
            Gambarequip5.setIcon(im.getSIcon(player.getEquipment().getAccesories().getSpritePath()));
        }


        //
//        kprofile.add(pkanan);
//        pkanan.revalidate();
//        pkanan.repaint();

        //add+visible+revalidate everyshit
        parent.removeAll();

        parent.add(playerr);
        playerr.revalidate();
        playerr.repaint();
        playerr.setVisible(true);

        parent.add(back);
        back.revalidate();
        back.repaint();
        back.setVisible(true);

        parent.add(kprofile);
        kprofile.revalidate();
        kprofile.repaint();
        kprofile.setVisible(true);

//        player.removeAll();

        playerr.add(Foto);
        Foto.revalidate();
        Foto.repaint();
        Foto.setVisible(true);

        playerr.add(stat);
        stat.revalidate();
        stat.repaint();
        stat.setVisible(true);

//        stat.removeAll();


        stat.add(statnama);
        statnama.revalidate();
        statnama.repaint();
        statnama.setVisible(true);

        stat.add(stat1);
        stat1.revalidate();
        stat1.repaint();
        stat1.setVisible(true);

        stat.add(stat2);
        stat2.revalidate();
        stat2.repaint();
        stat2.setVisible(true);

        stat.add(stat3);
        stat3.revalidate();
        stat3.repaint();
        stat3.setVisible(true);

        stat.add(stat4);
        stat4.revalidate();
        stat4.repaint();
        stat4.setVisible(true);

        stat.add(stat5);
        stat5.revalidate();
        stat5.repaint();
        stat5.setVisible(true);

//        kprofile.removeAll();

        kprofile.add(pkiriatas);
        pkiriatas.revalidate();
        pkiriatas.repaint();
        pkiriatas.setVisible(true);

        pkiriatas.add(kiriataskiri);
        kiriataskiri.repaint();
        kiriataskiri.revalidate();
        kiriataskiri.setVisible(true);

        pkiriatas.add(kiriataskanan);
        kiriataskanan.repaint();
        kiriataskanan.revalidate();
        kiriataskanan.setVisible(true);

        kiriataskiri.add(iconclass);
        iconclass.repaint();
        iconclass.revalidate();
        iconclass.setVisible(true);

        kiriataskiri.add(namaclass);
        namaclass.repaint();
        namaclass.revalidate();
        namaclass.setVisible(true);

        kiriataskanan.add(nama);
        nama.repaint();
        nama.revalidate();
        nama.setVisible(true);

        kiriataskanan.add(gold);
        gold.repaint();
        gold.revalidate();
        gold.setVisible(true);

        kiriataskanan.add(exp);
        exp.repaint();
        exp.revalidate();
        exp.setVisible(true);
//
        kprofile.add(pkanan);
        pkanan.revalidate();
        pkanan.repaint();
        pkanan.setVisible(true);
//
//        pkanan.add(equipment);
//        equipment.revalidate();
//        equipment.repaint();
//        equipment.setVisible(true);

        pkanan.add(Equipall);
        Equipall.revalidate();
        Equipall.repaint();
        Equipall.setVisible(true);

        Equipall.add(Equip1);
        Equip1.revalidate();
        Equip1.repaint();
        Equip1.setVisible(true);

        Equip1.add(Gambarequip1);
        Gambarequip1.revalidate();
        Gambarequip1.repaint();
        Gambarequip1.setVisible(true);

        Equip1.add(Namaequip1);
        Namaequip1.revalidate();
        Namaequip1.repaint();
        Namaequip1.setVisible(true);

        Equipall.add(Equip2);
        Equip2.revalidate();
        Equip2.repaint();
        Equip2.setVisible(true);

        Equip2.add(Gambarequip2);
        Gambarequip2.revalidate();
        Gambarequip2.repaint();
        Gambarequip2.setVisible(true);

        Equip2.add(Namaequip2);
        Namaequip2.revalidate();
        Namaequip2.repaint();
        Namaequip2.setVisible(true);

        Equipall.add(Equip3);
        Equip3.revalidate();
        Equip3.repaint();
        Equip3.setVisible(true);

        Equip3.add(Gambarequip3);
        Gambarequip3.revalidate();
        Gambarequip3.repaint();
        Gambarequip3.setVisible(true);

        Equip3.add(Namaequip3);
        Namaequip3.revalidate();
        Namaequip3.repaint();
        Namaequip3.setVisible(true);

        Equipall.add(Equip4);
        Equip4.revalidate();
        Equip4.repaint();
        Equip4.setVisible(true);

        Equip4.add(Gambarequip4);
        Gambarequip4.revalidate();
        Gambarequip4.repaint();
        Gambarequip4.setVisible(true);

        Equip4.add(Namaequip4);
        Namaequip4.revalidate();
        Namaequip4.repaint();
        Namaequip4.setVisible(true);

        Equipall.add(Equip5);
        Equip5.revalidate();
        Equip5.repaint();
        Equip5.setVisible(true);

        Equip5.add(Gambarequip5);
        Gambarequip5.revalidate();
        Gambarequip5.repaint();
        Gambarequip5.setVisible(true);

        Equip5.add(Namaequip5);
        Namaequip5.revalidate();
        Namaequip5.repaint();
        Namaequip5.setVisible(true);
//

        kprofile.add(pkiribawah1);
        pkiribawah1.revalidate();
        pkiribawah1.repaint();
        pkiribawah1.setVisible(true);
        //
        pkiribawah1.add(skill);
        skill.revalidate();
        skill.repaint();
        skill.setVisible(true);

        pkiribawah1.add(kiribawahpanel1);
        kiribawahpanel1.revalidate();
        kiribawahpanel1.repaint();
        kiribawahpanel1.setVisible(true);

        kiribawahpanel1.add(iconskill1);
        iconskill1.revalidate();
        iconskill1.repaint();
        iconskill1.setVisible(true);

        kiribawahpanel1.add(namaskill1);
        namaskill1.revalidate();
        namaskill1.repaint();
        namaskill1.setVisible(true);


        pkiribawah1.add(kiribawahpanel2);
        kiribawahpanel2.revalidate();
        kiribawahpanel2.repaint();
        kiribawahpanel2.setVisible(true);

        kiribawahpanel2.add(iconskill2);
        iconskill2.revalidate();
        iconskill2.repaint();
        iconskill2.setVisible(true);

        kiribawahpanel2.add(namaskill2);
        namaskill2.revalidate();
        namaskill2.repaint();
        namaskill2.setVisible(true);


        pkiribawah1.add(kiribawahpanel3);
        kiribawahpanel3.revalidate();
        kiribawahpanel3.repaint();
        kiribawahpanel3.setVisible(true);

        kiribawahpanel3.add(iconskill3);
        iconskill3.revalidate();
        iconskill3.repaint();
        iconskill3.setVisible(true);

        kiribawahpanel3.add(namaskill3);
        namaskill3.revalidate();
        namaskill3.repaint();
        namaskill3.setVisible(true);


    }

    public void skillChange(Player p, int index, JLabel chosenIcon, JLabel chosenName) {
        new SkillSelection(p,p.getEquippedSkills()[index], index,chosenIcon,chosenName);
    }

    public void equipSelection(Player p, int tipe, JLabel gambarEquip,JLabel stat, JLabel nama){
        new EquipSelection(p,tipe,gambarEquip,stat,nama);
    }
}

