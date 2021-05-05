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
        add(profile);

        //bagian atas
        JLabel nama = new JLabel("Tempet nama");
        ImageIcon scrollnama = new ImageIcon("src/istts/pbo/res/scrollNew.png");
        nama.setIcon(scrollnama);
        nama.setPreferredSize(new Dimension(100,100));
        nama.setVerticalAlignment(SwingConstants.CENTER);
        nama.setHorizontalAlignment(SwingConstants.CENTER);
        profile.add(nama,BorderLayout.NORTH);

        //bagian tengah

        //panel
        JPanel tengah = new JPanel();
        tengah.setLayout(new FlowLayout(FlowLayout.CENTER,20,20));
        tengah.setBackground(Color.cyan);
        tengah.setOpaque(false);
        profile.add(tengah,BorderLayout.CENTER);

        //class1
        JLabel tombolclass1 = new JLabel("Class1");
        ImageIcon gambarclass1 = new ImageIcon("src/istts/pbo/res/scrollNew.png");
        tombolclass1.setPreferredSize(new Dimension(50,50));
        nama.setIcon(gambarclass1);
        tengah.add(tombolclass1);

        //class2
        JLabel tombolclass2 = new JLabel("Class2");
        ImageIcon gambarclass2 = new ImageIcon("src/istts/pbo/res/scrollNew.png");
        tombolclass2.setPreferredSize(new Dimension(50,50));
        nama.setIcon(gambarclass2);
        tengah.add(tombolclass2);

        //class3
        JLabel tombolclass3 = new JLabel("Class3");
        ImageIcon gambarclass3 = new ImageIcon("src/istts/pbo/res/scrollNew.png");
        tombolclass3.setPreferredSize(new Dimension(50,50));
        nama.setIcon(gambarclass3);
        tengah.add(tombolclass3);
        //bagian bawah

        //panel

        //set
        JLabel tombolSET = new JLabel("Tempet nama");
        ImageIcon gambarSET = new ImageIcon("src/istts/pbo/res/scrollNew.png");
        nama.setIcon(scrollnama);

        //ok


        JLabel player = new JLabel("Tempet PLayer");
        player.setBounds(50,150,500,450);
        player.setBackground(new Color(160,160,200));
        player.setOpaque(true);
        add(player);

    }

    class Profile extends JPanel{
        public Profile(){
            this.setBackground(new Color(200,200,100));
            this.setLayout(new BorderLayout());
            this.setOpaque(true);
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
