package istts.pbo;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CreationPanel extends JPanel {
    JLabel back;
    public CreationPanel(){
        init();

    }

    private void init(){
        setBackground(Color.YELLOW);
        setLayout(null);

        back = new JLabel("BAAACK");
        back.setBounds(20,20,50,50);
        back.setBackground(Color.red);
        back.setOpaque(true);
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
        JLabel nama = new JLabel("Tempet nama");
        ImageIcon scrollnama = new ImageIcon("src/istts/pbo/res/scrollNew.png");
        nama.setIcon(scrollnama);
        nama.setPreferredSize(new Dimension(200,130));
        nama.setVerticalAlignment(SwingConstants.BOTTOM);
        nama.setHorizontalAlignment(SwingConstants.CENTER);
        profile.add(nama,BorderLayout.NORTH);

        //bagian tengah

        //panel
        JPanel tengah = new JPanel();
        tengah.setLayout(new FlowLayout(FlowLayout.CENTER,50,20));
        tengah.setBackground(Color.cyan);
        tengah.setOpaque(false);
        profile.add(tengah,BorderLayout.CENTER);

        //class1
        JLabel tombolclass1 = new JLabel("Class1");
        ImageIcon gambarclass1 = new ImageIcon("src/istts/pbo/res/scrollNew.png");
        tombolclass1.setBackground(Color.green);
        tombolclass1.setOpaque(true);
        tombolclass1.setPreferredSize(new Dimension(100,100));
        tombolclass1.setVerticalAlignment(SwingConstants.CENTER);
        tombolclass1.setHorizontalAlignment(SwingConstants.CENTER);
        tombolclass1.setIcon(gambarclass1);
        tengah.add(tombolclass1);

        //class2
        JLabel tombolclass2 = new JLabel("Class2");
        ImageIcon gambarclass2 = new ImageIcon("src/istts/pbo/res/scrollNew.png");
        tombolclass2.setBackground(Color.green);
        tombolclass2.setOpaque(true);
        tombolclass2.setPreferredSize(new Dimension(100,100));
        tombolclass2.setVerticalAlignment(SwingConstants.CENTER);
        tombolclass2.setHorizontalAlignment(SwingConstants.CENTER);
        tombolclass2.setIcon(gambarclass2);
        tengah.add(tombolclass2);

        //class3
        JLabel tombolclass3 = new JLabel("Class3");
        ImageIcon gambarclass3 = new ImageIcon("src/istts/pbo/res/scrollNew.png");
        tombolclass3.setBackground(Color.green);
        tombolclass3.setOpaque(true);
        tombolclass3.setPreferredSize(new Dimension(100,100));
        tombolclass3.setVerticalAlignment(SwingConstants.CENTER);
        tombolclass3.setHorizontalAlignment(SwingConstants.CENTER);
        tombolclass3.setIcon(gambarclass3);
        tengah.add(tombolclass3);
        //bagian bawah

        //panel
        JPanel bawah = new JPanel();
        bawah.setLayout(new FlowLayout(FlowLayout.CENTER,50,20));
        bawah.setPreferredSize(new Dimension(200,125));
        bawah.setBackground(Color.cyan);
        bawah.setOpaque(false);
        profile.add(bawah,BorderLayout.SOUTH);
        //set
        JLabel tombolset = new JLabel("Class3");
        ImageIcon gambarset = new ImageIcon("src/istts/pbo/res/scrollNew.png");
        tombolset.setBackground(Color.cyan);
        tombolset.setOpaque(true);
        tombolset.setPreferredSize(new Dimension(100,50));
        tombolset.setVerticalAlignment(SwingConstants.TOP);
        tombolset.setHorizontalAlignment(SwingConstants.CENTER);
        tombolset.setIcon(gambarset);
        bawah.add(tombolset);

        //ok
        JLabel tombolok = new JLabel("Class3");
        ImageIcon gambarok = new ImageIcon("src/istts/pbo/res/scrollNew.png");
        tombolok.setBackground(Color.cyan);
        tombolok.setOpaque(true);
        tombolok.setPreferredSize(new Dimension(100,50));
        tombolok.setVerticalAlignment(SwingConstants.TOP);
        tombolok.setHorizontalAlignment(SwingConstants.CENTER);
        tombolok.setIcon(gambarok);
        bawah.add(tombolok);

        JLabel player = new JLabel("Tempet PLayer");
        player.setBounds(50,150,500,450);
        player.setBackground(new Color(160,160,200));
        player.setOpaque(true);
        add(player);

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
            BufferedImage bg = ImageIO.read(new File("src/istts/pbo/res/BackgroundCreateCharacter.png"));
            g.drawImage(bg,0,0,null);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }


}
