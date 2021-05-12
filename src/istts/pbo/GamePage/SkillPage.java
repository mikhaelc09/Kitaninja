package istts.pbo.GamePage;

import javax.swing.*;
import java.awt.*;

public class SkillPage extends JPanel{
    JPanel parent;
    JLabel back;
    JPanel Bgdesc;
    JTextField desc;
    JPanel gambar;
    JLabel learn;
    JPanel kanan;

    public SkillPage(){init();}

    private void init(){
        int SWIDTH = 1280;
        int SHEIGHT = 760;
        setSize(new Dimension(SWIDTH,SHEIGHT));

        //mainpanel
        JPanel parent = new JPanel();
        parent.setBounds(0,0,SWIDTH,SHEIGHT);
        parent.setLayout(null);
        parent.setPreferredSize(new Dimension(SWIDTH,SHEIGHT));
        parent.setBackground(Color.GRAY);
        parent.setOpaque(true);

        //back
        JLabel back = new JLabel("BAAACK");
        back.setBounds(20,20,50,50);
        back.setBackground(Color.red);
        back.setOpaque(true);

        //bgdesc
        class Bgdesc extends JPanel{
            public Bgdesc(){}
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
        Bgdesc bgdesc = new Bgdesc();
        bgdesc.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
        bgdesc.setBounds(20,350,455,280);
        bgdesc.setBackground(Color.CYAN);
        bgdesc.setOpaque(true);

        //
        JTextField desc = new JTextField();
        desc.setText("PLS BISA KEBAWAH KUMOHON BISA KEBAWAH AKU SUDAH FREESTYLE UNTUK INI JADI KUMOHON DENGAN SANGAT INI BISA KEBAWAH YA");
        desc.setAlignmentX(LEFT_ALIGNMENT);
        desc.setAlignmentY(TOP_ALIGNMENT);
        desc.setPreferredSize(new Dimension(430,250));
        desc.setBackground(new Color(200,100,100));
        desc.setOpaque(true);

        //Gambar
        JPanel gambar = new JPanel();
        gambar.setBounds(120,100,255,220);
        gambar.setLayout(new BorderLayout(0,0));
        //
        gambar.setBackground(new Color(0,255,100));
        gambar.setOpaque(true);


        //Learn
        JLabel learn = new JLabel("Learn");
        learn.setBounds(20,650,455,50);
        learn.setHorizontalTextPosition(SwingConstants.CENTER);
        learn.setVerticalTextPosition(SwingConstants.CENTER);
        learn.setBackground(Color.BLUE);
        learn.setOpaque(true);

        //Kanan
        JPanel kanan = new JPanel();
        kanan.setBounds(500,20,750,680);
        kanan.setLayout(null);
        kanan.setPreferredSize(new Dimension(SWIDTH,SHEIGHT));
        kanan.setBackground(Color.PINK);
        kanan.setOpaque(true);

        //
        //Add And Revalidate every shit
        this.add(parent);
        parent.revalidate();
        parent.repaint();
        parent.setVisible(true);

        parent.add(back);
        back.revalidate();
        back.repaint();
        back.setVisible(true);

        parent.add(gambar);
        gambar.revalidate();
        gambar.repaint();
        gambar.setVisible(true);

        parent.add(bgdesc);
        bgdesc.revalidate();
        bgdesc.repaint();
        bgdesc.setVisible(true);

        bgdesc.add(desc);
        desc.revalidate();
        desc.repaint();
        desc.setVisible(true);

        parent.add(learn);
        learn.revalidate();
        learn.repaint();
        learn.setVisible(true);

        parent.add(desc);
        desc.revalidate();
        desc.repaint();
        desc.setVisible(true);

        parent.add(kanan);
        kanan.revalidate();
        kanan.repaint();
        kanan.setVisible(true);
    }



}

