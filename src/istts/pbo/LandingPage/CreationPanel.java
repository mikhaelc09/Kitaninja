package istts.pbo.LandingPage;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CreationPanel extends JPanel {
    JLabel back;
    JLabel tombolok;
    JLabel tombolreset;
    JTextField nama;
    ImageIcon descNin = new ImageIcon("src/istts/pbo/res/DescNinjutsu.png");
    ImageIcon descQig = new ImageIcon("src/istts/pbo/res/DescQiqong.png");
    ImageIcon descTai = new ImageIcon("src/istts/pbo/res/DescTaijutsu.png");
    ImageIcon spriteNin = new ImageIcon("src/istts/pbo/res/sprites/ninjutsu_big.gif");
    ImageIcon spriteQig = new ImageIcon("src/istts/pbo/res/sprites/qigong_big.gif");
    ImageIcon spriteTai = new ImageIcon("src/istts/pbo/res/sprites/taijutsu_big.gif");
    int classPicked = 1;
    public CreationPanel(){
        init();

    }

    private void init(){
        setBackground(Color.YELLOW);
        setLayout(null);

        back = new JLabel();
        back.setBounds(20,15,100,50);
        back.setOpaque(false);
        back.setIcon(new ImageIcon("src/istts/pbo/res/buttons/Back.png"));
        back.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(back);


        //kotak
//        ImageIcon temp = new ImageIcon("src/istts/pbo/res/about.png");
//        JLabel kotak = new JLabel();
//        kotak.setIcon(temp);
//        kotak.setBounds(600,150,600,450);
//        add(kotak);


        //profile
        Profile profile = new Profile();
        profile.setBounds(600,150,600,450);
        profile.setOpaque(false);
        add(profile);

        //bagian atas
        JPanel top = new JPanel();
        top.setPreferredSize(new Dimension(600,130));
        top.setOpaque(false);
        top.setLayout(null);

        JLabel lb1 = new JLabel("Name : ");
        lb1.setFont(new Font("Arial", Font.BOLD, 35));
        FontMetrics fm = getFontMetrics(lb1.getFont());
        lb1.setBounds(50,80,fm.stringWidth(lb1.getText()), 40);

        nama = new JTextField();
        nama.setFont(new Font("Arial", Font.BOLD, 35));
        nama.setPreferredSize(new Dimension(190,50));
        nama.setHorizontalAlignment(SwingConstants.CENTER);
        nama.setBounds(250,75,300,45);

        top.add(lb1);
        top.add(nama);

        profile.add(top,BorderLayout.NORTH);

        //bagian tengah

        //panel
        JPanel tengah = new JPanel();
        tengah.setLayout(new FlowLayout(FlowLayout.CENTER,50,20));
        tengah.setBackground(Color.cyan);
        tengah.setOpaque(false);
        profile.add(tengah,BorderLayout.CENTER);

        //class1
        JLabel tombolclass1 = new JLabel();
        ImageIcon gambarclass1 = new ImageIcon("src/istts/pbo/res/IconSkill/Taijutsu-FalconPunch.png");
        tombolclass1.setOpaque(false);
        tombolclass1.setPreferredSize(new Dimension(120,120));
        tombolclass1.setVerticalAlignment(SwingConstants.CENTER);
        tombolclass1.setHorizontalAlignment(SwingConstants.CENTER);
        tombolclass1.setIcon(gambarclass1);
        tombolclass1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        tengah.add(tombolclass1);

        //class2
        JLabel tombolclass2 = new JLabel();
        ImageIcon gambarclass2 = new ImageIcon("src/istts/pbo/res/IconSkill/Ninjutsu-ShurikenThrow.png");
        tombolclass2.setOpaque(false);
        tombolclass2.setPreferredSize(new Dimension(120,120));
        tombolclass2.setVerticalAlignment(SwingConstants.CENTER);
        tombolclass2.setHorizontalAlignment(SwingConstants.CENTER);
        tombolclass2.setIcon(gambarclass2);
        tombolclass2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        tengah.add(tombolclass2);

        //class3
        JLabel tombolclass3 = new JLabel();
        ImageIcon gambarclass3 = new ImageIcon("src/istts/pbo/res/IconSkill/Qiqong-Kamehameha.png");
        tombolclass3.setOpaque(false);
        tombolclass3.setPreferredSize(new Dimension(120,120));
        tombolclass3.setVerticalAlignment(SwingConstants.CENTER);
        tombolclass3.setHorizontalAlignment(SwingConstants.CENTER);
        tombolclass3.setIcon(gambarclass3);
        tombolclass3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        tengah.add(tombolclass3);
        //bagian bawah

        //panel
        JPanel bawah = new JPanel();
        bawah.setLayout(new FlowLayout(FlowLayout.CENTER,50,20));
        bawah.setPreferredSize(new Dimension(200,120));
        bawah.setBackground(Color.cyan);
        bawah.setOpaque(false);
        profile.add(bawah,BorderLayout.SOUTH);

        //reset
        tombolreset = new JLabel();
        ImageIcon gambarreset = new ImageIcon("src/istts/pbo/res/buttons/Reset.png");
        tombolreset.setOpaque(false);
        tombolreset.setPreferredSize(new Dimension(120,60));
        tombolreset.setVerticalAlignment(SwingConstants.TOP);
        tombolreset.setHorizontalAlignment(SwingConstants.CENTER);
        tombolreset.setCursor(new Cursor(Cursor.HAND_CURSOR));
        tombolreset.setIcon(gambarreset);
        bawah.add(tombolreset);

        //ok
        tombolok = new JLabel();
        ImageIcon gambarok = new ImageIcon("src/istts/pbo/res/buttons/Confirm.png");
        tombolok.setOpaque(false);
        tombolok.setPreferredSize(new Dimension(120,60));
        tombolok.setVerticalAlignment(SwingConstants.TOP);
        tombolok.setHorizontalAlignment(SwingConstants.CENTER);
        tombolok.setIcon(gambarok);
        tombolok.setCursor(new Cursor(Cursor.HAND_CURSOR));
        bawah.add(tombolok);

        JPanel player = new JPanel();
        player.setBounds(50,150,500,450);
        player.setLayout(null);
        player.setBackground(new Color(160,160,200));
        player.setOpaque(true);
        add(player);

        JLabel gambarplayer = new JLabel("");
        gambarplayer.setPreferredSize(new Dimension(250,200));
        gambarplayer.setBackground(new Color(255,160,200));
        gambarplayer.setBounds(175,30,150,170);
        gambarplayer.setIcon(spriteTai);
        gambarplayer.setOpaque(false);
        player.add(gambarplayer);

        JLabel deskripsi = new JLabel("");
        deskripsi.setPreferredSize(new Dimension(450,195));
        deskripsi.setBackground(new Color(100,160,200));
        deskripsi.setBounds(25,220,450,200);
        deskripsi.setIcon(descTai);
        deskripsi.setOpaque(false);
        player.add(deskripsi);

        tombolreset.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                nama.setText("");
            }
        });

        tombolclass1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                deskripsi.setIcon(descTai);
                gambarplayer.setIcon(spriteTai);
                classPicked = 1;
            }
        });

        tombolclass2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                deskripsi.setIcon(descNin);
                gambarplayer.setIcon(spriteNin);
                classPicked = 2;
            }
        });

        tombolclass3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                deskripsi.setIcon(descQig);
                gambarplayer.setIcon(spriteQig);
                classPicked = 3;
            }
        });


    }

    class Profile extends JPanel{
        public Profile(){
            this.setLayout(new BorderLayout(0,30));
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            draw(g);
        }

        private void draw(Graphics g){
            try {
                BufferedImage bg = ImageIO.read(new File("src/istts/pbo/res/papan.png"));
                g.drawImage(bg,0,0,null);
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    private void draw(Graphics g){
        try {
            BufferedImage bg = ImageIO.read(new File("src/istts/pbo/res/backgrounds/BackgroundCreateCharacter.png"));
            g.drawImage(bg,0,0,null);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
