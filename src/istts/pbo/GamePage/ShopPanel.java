package istts.pbo.GamePage;

import istts.pbo.Players.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static istts.pbo.Main.SHEIGHT;
import static istts.pbo.Main.SWIDTH;

public class ShopPanel extends JPanel {
     Kanan kanan;
     int page;
     int maxpage;
     int tipe;
    JLabel shopback;
     JLabel gambar;
     JLabel buy;
     JPanel backdesc;
     JTextArea desc;
     JPanel kananatas;
     JPanel kanantengahhead;
     JPanel kanantengahhead2;
     JPanel kanantengahbody;
     JPanel kanantengahbody2;
     JPanel kanantengahboots;
     JPanel kanantengahboots2;
     JPanel kanantengahweapon;
     JPanel kanantengahweapon2;
     JPanel kanantengahaccessory;
     JPanel kanantengahaccessory2;
     JPanel kananbawah;
     JPanel kanantengahheaditem1;
     JPanel kanantengahheaditem2;
     JPanel kanantengahheaditem3;
     JPanel kanantengahheaditem4;
     JPanel kanantengahheaditem5;
     JPanel kanantengahweaponitem1;
     JPanel kanantengahweaponitem2;
     JPanel kanantengahweaponitem3;
     JPanel kanantengahweaponitem4;
     JPanel kanantengahweaponitem5;
     JPanel kanantengahbodyitem1;
     JPanel kanantengahbodyitem2;
     JPanel kanantengahbodyitem3;
     JPanel kanantengahbodyitem4;
     JPanel kanantengahbodyitem5;
     JPanel kanantengahbootsitem1;
     JPanel kanantengahbootsitem2;
     JPanel kanantengahbootsitem3;
     JPanel kanantengahbootsitem4;
     JPanel kanantengahbootsitem5;
     JPanel kanantengahaccessoryitem1;
     JPanel kanantengahaccessoryitem2;
     JPanel kanantengahaccessoryitem3;
     JPanel kanantengahaccessoryitem4;
     JPanel kanantengahaccessoryitem5;
     JLabel Head;
     JLabel Weapon;
     JLabel Body;
     JLabel Boots;
     JLabel Accessory;
     JLabel headiconitem1;
     JLabel headiconitem2;
     JLabel headiconitem3;
     JLabel headiconitem4;
     JLabel headiconitem5;
     JTextArea headicondesc1;
     JTextArea headicondesc2;
     JTextArea headicondesc3;
     JTextArea headicondesc4;
     JTextArea headicondesc5;
     JLabel weaponiconitem1;
     JLabel weaponiconitem2;
     JLabel weaponiconitem3;
     JLabel weaponiconitem4;
     JLabel weaponiconitem5;
     JTextArea weaponicondesc1;
     JTextArea weaponicondesc2;
     JTextArea weaponicondesc3;
     JTextArea weaponicondesc4;
     JTextArea weaponicondesc5;
     JLabel bodyiconitem1;
     JLabel bodyiconitem2;
     JLabel bodyiconitem3;
     JLabel bodyiconitem4;
     JLabel bodyiconitem5;
     JTextArea bodyicondesc1;
     JTextArea bodyicondesc2;
     JTextArea bodyicondesc3;
     JTextArea bodyicondesc4;
     JTextArea bodyicondesc5;
     JLabel bootsiconitem1;
     JLabel bootsiconitem2;
     JLabel bootsiconitem3;
     JLabel bootsiconitem4;
     JLabel bootsiconitem5;
     JTextArea bootsicondesc1;
     JTextArea bootsicondesc2;
     JTextArea bootsicondesc3;
     JTextArea bootsicondesc4;
     JTextArea bootsicondesc5;
     JLabel accessoryiconitem1;
     JLabel accessoryiconitem2;
     JLabel accessoryiconitem3;
     JLabel accessoryiconitem4;
     JLabel accessoryiconitem5;
     JTextArea accessoryicondesc1;
     JTextArea accessoryicondesc2;
     JTextArea accessoryicondesc3;
     JTextArea accessoryicondesc4;
     JTextArea accessoryicondesc5;
     JLabel Currgold;
     JLabel Next;
     JLabel Prev;
     JLabel CurrentPage;
     JPanel[][] Halaman = new JPanel[2][5];
     JLabel[][] Iconclick = new JLabel[5][5];
     JTextArea[][] Descclick = new JTextArea[5][5];
     Item selected;
    Weapon banditWeapon;
    Weapon chainmailWeapon;
    Weapon ironWeapon;
    Weapon steelWeapon;
    Weapon royalWeapon;
    Helmet banditHelmet;
    Helmet chainmailHelmet;
    Helmet ironHelmet;
    Helmet steelHelmet;
    Helmet royalHelmet;
    Body banditArmor;
    Body chainmailArmor;
    Body ironArmor;
    Body steelArmor;
    Body royalArmor;
    Boots banditBoots;
    Boots chainmailBoots;
    Boots ironBoots;
    Boots steelBoots;
    Boots royalBoots;
    Accesories banditAcc;
    Accesories chainmailAcc;
    Accesories ironAcc;
    Accesories steelAcc;
    Accesories royalAcc;
    Font fontlb = new Font("Arial", Font.PLAIN, 30);

    class Kanan extends JPanel{
        public Kanan(){}
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            draw(g);
        }

        private void draw(Graphics g) {
            try {
                BufferedImage bg = ImageIO.read(new File("src/istts/pbo/res/Tab/ShopTab1.png"));
                g.drawImage(bg, 0, 0, null);
            } catch (IOException e) {
                e.printStackTrace();

            }
        }
    }


    //All invisible
    public void disableall(){
        kanantengahhead.setVisible(false);
        kanantengahhead2.setVisible(false);
        kanantengahweapon.setVisible(false);
        kanantengahweapon2.setVisible(false);
        kanantengahbody.setVisible(false);
        kanantengahbody2.setVisible(false);
        kanantengahboots.setVisible(false);
        kanantengahboots2.setVisible(false);
        kanantengahaccessory.setVisible(false);
        kanantengahaccessory2.setVisible(false);
    }

    public ShopPanel(Player p){
        this.page = 0;
        this.maxpage = 1;
        this.tipe = 0;
        init(p);
        //halaman init
        Halaman[0][0]=kanantengahhead;
        Halaman[1][0]=kanantengahhead2;
        Halaman[0][1]=kanantengahweapon;
        Halaman[1][1]=kanantengahweapon2;
        Halaman[0][2]=kanantengahbody;
        Halaman[1][2]=kanantengahbody2;
        Halaman[0][3]=kanantengahboots;
        Halaman[1][3]=kanantengahboots2;
        Halaman[0][4]=kanantengahaccessory;
        Halaman[1][4]=kanantengahaccessory2;
        //Iconclick
        Iconclick[0][0]=headiconitem1;
        Iconclick[0][1]=headiconitem2;
        Iconclick[0][2]=headiconitem3;
        Iconclick[0][3]=headiconitem4;
        Iconclick[0][4]=headiconitem5;
        Iconclick[1][0]=weaponiconitem1;
        Iconclick[1][1]=weaponiconitem2;
        Iconclick[1][2]=weaponiconitem3;
        Iconclick[1][3]=weaponiconitem4;
        Iconclick[1][4]=weaponiconitem5;
        Iconclick[2][0]=bodyiconitem1;
        Iconclick[2][1]=bodyiconitem2;
        Iconclick[2][2]=bodyiconitem3;
        Iconclick[2][3]=bodyiconitem4;
        Iconclick[2][4]=bodyiconitem5;
        Iconclick[3][0]=bootsiconitem1;
        Iconclick[3][1]=bootsiconitem2;
        Iconclick[3][2]=bootsiconitem3;
        Iconclick[3][3]=bootsiconitem4;
        Iconclick[3][4]=bootsiconitem5;
        Iconclick[4][0]=accessoryiconitem1;
        Iconclick[4][1]=accessoryiconitem2;
        Iconclick[4][2]=accessoryiconitem3;
        Iconclick[4][3]=accessoryiconitem4;
        Iconclick[4][4]=accessoryiconitem5;

        //descclick
        Descclick[0][0]=headicondesc1;
        Descclick[0][1]=headicondesc2;
        Descclick[0][2]=headicondesc3;
        Descclick[0][3]=headicondesc4;
        Descclick[0][4]=headicondesc5;
        Descclick[1][0]=weaponicondesc1;
        Descclick[1][1]=weaponicondesc2;
        Descclick[1][2]=weaponicondesc3;
        Descclick[1][3]=weaponicondesc4;
        Descclick[1][4]=weaponicondesc5;
        Descclick[2][0]=bodyicondesc1;
        Descclick[2][1]=bodyicondesc2;
        Descclick[2][2]=bodyicondesc3;
        Descclick[2][3]=bodyicondesc4;
        Descclick[2][4]=bodyicondesc5;
        Descclick[3][0]=bootsicondesc1;
        Descclick[3][1]=bootsicondesc2;
        Descclick[3][2]=bootsicondesc3;
        Descclick[3][3]=bootsicondesc4;
        Descclick[3][4]=bootsicondesc5;
        Descclick[4][0]=accessoryicondesc1;
        Descclick[4][1]=accessoryicondesc2;
        Descclick[4][2]=accessoryicondesc3;
        Descclick[4][3]=accessoryicondesc4;
        Descclick[4][4]=accessoryicondesc5;


        //tombol

        //head
        this.Head.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tipe=0;
                page=0;
                disableall();
                kanan.add(kanantengahhead,BorderLayout.CENTER);
                kanantengahhead.revalidate();
                kanantengahhead.repaint();
                kanantengahhead.setVisible(true);
                CurrentPage.setText("Page : "+(page+1)+"/ 2");
                CurrentPage.revalidate();
                CurrentPage.repaint();
                CurrentPage.setVisible(true);
            }
        });
        //weapon
        this.Weapon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tipe=1;
                page=0;
                disableall();
                kanan.add(kanantengahweapon,BorderLayout.CENTER);
                kanantengahweapon.revalidate();
                kanantengahweapon.repaint();
                kanantengahweapon.setVisible(true);
                CurrentPage.setText("Page : "+(page+1)+"/ 2");
                CurrentPage.revalidate();
                CurrentPage.repaint();
                CurrentPage.setVisible(true);
            }
        });
        //body
        this.Body.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tipe=2;
                page=0;
                disableall();
                kanan.add(kanantengahbody,BorderLayout.CENTER);
                kanantengahbody.revalidate();
                kanantengahbody.repaint();
                kanantengahbody.setVisible(true);
                CurrentPage.setText("Page : "+(page+1)+"/ 2");
                CurrentPage.revalidate();
                CurrentPage.repaint();
                CurrentPage.setVisible(true);
            }
        });
        //boots
        this.Boots.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tipe=3;
                page=0;
                disableall();
                kanan.add(kanantengahboots,BorderLayout.CENTER);
                kanantengahboots.revalidate();
                kanantengahboots.repaint();
                kanantengahboots.setVisible(true);
                CurrentPage.setText("Page : "+(page+1)+"/ 2");
                CurrentPage.revalidate();
                CurrentPage.repaint();
                CurrentPage.setVisible(true);
            }
        });
        //accessory
        this.Accessory.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tipe=4;
                page=0;
                disableall();
                kanan.add(kanantengahaccessory,BorderLayout.CENTER);
                kanantengahaccessory.revalidate();
                kanantengahaccessory.repaint();
                kanantengahaccessory.setVisible(true);
                CurrentPage.setText("Page : "+(page+1)+"/ 2");
                CurrentPage.revalidate();
                CurrentPage.repaint();
                CurrentPage.setVisible(true);
            }
        });
        //prev
        this.Prev.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(page<=0) {
                    page=maxpage;
                }else{
                    page=page-1;
                }
                disableall();
                kanan.add(Halaman[page][tipe],BorderLayout.CENTER);
                Halaman[page][tipe].revalidate();
                Halaman[page][tipe].repaint();
                Halaman[page][tipe].setVisible(true);
                CurrentPage.setText("Page : "+(page+1)+"/ 2");
                CurrentPage.revalidate();
                CurrentPage.repaint();
                CurrentPage.setVisible(true);
            }
        });
        //next
        this.Next.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if(page>=maxpage) {
                    page=0;
                }else{
                    page=page+1;
                }
                disableall();
                kanan.add(Halaman[page][tipe], BorderLayout.CENTER);
                Halaman[page][tipe].revalidate();
                Halaman[page][tipe].repaint();
                Halaman[page][tipe].setVisible(true);
                CurrentPage.setText("Page : "+(page+1)+"/ 2");
                CurrentPage.revalidate();
                CurrentPage.repaint();
                CurrentPage.setVisible(true);
            }
        });
        //panel-panel yang di click click
        //head
        this.headiconitem1.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                gambar.setIcon(Iconclick[0][0].getIcon());
                gambar.setText(Iconclick[0][0].getText());
                gambar.revalidate();
                gambar.repaint();
                desc.setText(Descclick[0][0].getText());
                desc.revalidate();
                desc.repaint();
                selected = banditHelmet;
            }
        });
        this.headiconitem2.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                gambar.setIcon(Iconclick[0][1].getIcon());
                gambar.setText(Iconclick[0][1].getText());
                gambar.revalidate();
                gambar.repaint();
                desc.setText(Descclick[0][1].getText());
                desc.revalidate();
                desc.repaint();
                selected = chainmailHelmet;
            }
        });
        this.headiconitem3.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                gambar.setIcon(Iconclick[0][2].getIcon());
                gambar.setText(Iconclick[0][2].getText());
                gambar.revalidate();
                gambar.repaint();
                desc.setText(Descclick[0][2].getText());
                desc.revalidate();
                desc.repaint();
                selected = ironHelmet;
            }
        });
        this.headiconitem4.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                gambar.setIcon(Iconclick[0][3].getIcon());
                gambar.setText(Iconclick[0][3].getText());
                gambar.revalidate();
                gambar.repaint();
                desc.setText(Descclick[0][3].getText());
                desc.revalidate();
                desc.repaint();
                selected = steelHelmet;
            }
        });
        this.headiconitem5.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                gambar.setIcon(Iconclick[0][4].getIcon());
                gambar.setText(Iconclick[0][4].getText());
                gambar.revalidate();
                gambar.repaint();
                desc.setText(Descclick[0][4].getText());
                desc.revalidate();
                desc.repaint();
                selected = royalHelmet;
            }
        });
        //weapon
        this.weaponiconitem1.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                gambar.setIcon(Iconclick[1][0].getIcon());
                gambar.setText(Iconclick[1][0].getText());
                gambar.revalidate();
                gambar.repaint();
                desc.setText(Descclick[1][0].getText());
                desc.revalidate();
                desc.repaint();
                selected = banditWeapon;
            }
        });
        this.weaponiconitem2.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                gambar.setIcon(Iconclick[1][1].getIcon());
                gambar.setText(Iconclick[1][1].getText());
                gambar.revalidate();
                gambar.repaint();
                desc.setText(Descclick[1][1].getText());
                desc.revalidate();
                desc.repaint();
                selected = chainmailWeapon;
            }
        });
        this.weaponiconitem3.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                gambar.setIcon(Iconclick[1][2].getIcon());
                gambar.setText(Iconclick[1][2].getText());
                gambar.revalidate();
                gambar.repaint();
                desc.setText(Descclick[1][2].getText());
                desc.revalidate();
                desc.repaint();
                selected = ironWeapon;
            }
        });
        this.weaponiconitem4.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                gambar.setIcon(Iconclick[1][3].getIcon());
                gambar.setText(Iconclick[1][3].getText());
                gambar.revalidate();
                gambar.repaint();
                desc.setText(Descclick[1][3].getText());
                desc.revalidate();
                desc.repaint();
                selected = steelWeapon;
            }
        });
        this.weaponiconitem5.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                gambar.setIcon(Iconclick[1][4].getIcon());
                gambar.setText(Iconclick[1][4].getText());
                gambar.revalidate();
                gambar.repaint();
                desc.setText(Descclick[1][4].getText());
                desc.revalidate();
                desc.repaint();
                selected = royalWeapon;
            }
        });
        //body
        this.bodyiconitem1.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                gambar.setIcon(Iconclick[2][0].getIcon());
                gambar.setText(Iconclick[2][0].getText());
                gambar.revalidate();
                gambar.repaint();
                desc.setText(Descclick[2][0].getText());
                desc.revalidate();
                desc.repaint();
                selected = banditArmor;
            }
        });
        this.bodyiconitem2.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                gambar.setIcon(Iconclick[2][1].getIcon());
                gambar.setText(Iconclick[2][1].getText());
                gambar.revalidate();
                gambar.repaint();
                desc.setText(Descclick[2][1].getText());
                desc.revalidate();
                desc.repaint();
                selected = chainmailArmor;
            }
        });
        this.bodyiconitem3.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                gambar.setIcon(Iconclick[2][2].getIcon());
                gambar.setText(Iconclick[2][2].getText());
                gambar.revalidate();
                gambar.repaint();
                desc.setText(Descclick[2][2].getText());
                desc.revalidate();
                desc.repaint();
                selected = ironArmor;
            }
        });
        this.bodyiconitem4.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                gambar.setIcon(Iconclick[2][3].getIcon());
                gambar.setText(Iconclick[2][3].getText());
                gambar.revalidate();
                gambar.repaint();
                desc.setText(Descclick[2][3].getText());
                desc.revalidate();
                desc.repaint();
                selected = steelArmor;
            }
        });
        this.bodyiconitem5.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                gambar.setIcon(Iconclick[2][4].getIcon());
                gambar.setText(Iconclick[2][4].getText());
                gambar.revalidate();
                gambar.repaint();
                desc.setText(Descclick[2][4].getText());
                desc.revalidate();
                desc.repaint();
                selected = royalArmor;
            }
        });
        //boots
        this.bootsiconitem1.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                gambar.setIcon(Iconclick[3][0].getIcon());
                gambar.setText(Iconclick[3][0].getText());
                gambar.revalidate();
                gambar.repaint();
                desc.setText(Descclick[3][0].getText());
                desc.revalidate();
                desc.repaint();
                selected = banditBoots;
            }
        });
        this.bootsiconitem2.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                gambar.setIcon(Iconclick[3][1].getIcon());
                gambar.setText(Iconclick[3][1].getText());
                gambar.revalidate();
                gambar.repaint();
                desc.setText(Descclick[3][1].getText());
                desc.revalidate();
                desc.repaint();
                selected = chainmailBoots;
            }
        });
        this.bootsiconitem3.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                gambar.setIcon(Iconclick[3][2].getIcon());
                gambar.setText(Iconclick[3][2].getText());
                gambar.revalidate();
                gambar.repaint();
                desc.setText(Descclick[3][2].getText());
                desc.revalidate();
                desc.repaint();
                selected = ironBoots;
            }
        });
        this.bootsiconitem4.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                gambar.setIcon(Iconclick[3][3].getIcon());
                gambar.setText(Iconclick[3][3].getText());
                gambar.revalidate();
                gambar.repaint();
                desc.setText(Descclick[3][3].getText());
                desc.revalidate();
                desc.repaint();
                selected = steelBoots;
            }
        });
        this.bootsiconitem5.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                gambar.setIcon(Iconclick[3][4].getIcon());
                gambar.setText(Iconclick[3][4].getText());
                gambar.revalidate();
                gambar.repaint();
                desc.setText(Descclick[3][4].getText());
                desc.revalidate();
                desc.repaint();
                selected = royalBoots;
            }
        });
        //acc
        this.accessoryiconitem1.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                gambar.setIcon(Iconclick[4][0].getIcon());
                gambar.setText(Iconclick[4][0].getText());
                gambar.revalidate();
                gambar.repaint();
                desc.setText(Descclick[4][0].getText());
                desc.revalidate();
                desc.repaint();
                selected = banditAcc;
            }
        });
        this.accessoryiconitem2.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                gambar.setIcon(Iconclick[4][1].getIcon());
                gambar.setText(Iconclick[4][1].getText());
                gambar.revalidate();
                gambar.repaint();
                desc.setText(Descclick[4][1].getText());
                desc.revalidate();
                desc.repaint();
                selected = chainmailAcc;
            }
        });
        this.accessoryiconitem3.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                gambar.setIcon(Iconclick[4][2].getIcon());
                gambar.setText(Iconclick[4][2].getText());
                gambar.revalidate();
                gambar.repaint();
                desc.setText(Descclick[4][2].getText());
                desc.revalidate();
                desc.repaint();
                selected = ironAcc;
            }
        });
        this.accessoryiconitem4.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                gambar.setIcon(Iconclick[4][3].getIcon());
                gambar.setText(Iconclick[4][3].getText());
                gambar.revalidate();
                gambar.repaint();
                desc.setText(Descclick[4][3].getText());
                desc.revalidate();
                desc.repaint();
                selected = steelAcc;
            }
        });
        this.accessoryiconitem5.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                gambar.setIcon(Iconclick[4][4].getIcon());
                gambar.setText(Iconclick[4][4].getText());
                gambar.revalidate();
                gambar.repaint();
                desc.setText(Descclick[4][4].getText());
                desc.revalidate();
                desc.repaint();
                selected = royalAcc;
            }
        });
        this.buy.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int sett=cekInven(p);
                if (sett!=-1) {
                    if (p.getGold() >= selected.getCost()) {
                        p.setGold(p.getGold() - selected.getCost());
                        p.getItems().set(sett,selected);
                        Currgold.setText("   Gold : " + p.getGold() + "");
                        System.out.println("Beli " + selected.getName() + "   gold : " + p.getGold());
                    }
                }
            }
        });
    }

    public int cekInven(Player p){
        for (int i = 0; i < 25; i++) {
            if (p.getItems().get(i).getName().equalsIgnoreCase("-")){
                return i;
            }
        }
        return -1;
    }

    public void init(Player p) {
        this.setLayout(null);
        this.setVisible(false);

        //inisialisasi item
        banditWeapon = new Weapon("Bandit Axe",10,10,"src/istts/pbo/res/Item/BanditWeapon.png",5);
        banditHelmet = new Helmet("Bandit Helmet",20,10,"src/istts/pbo/res/Item/BanditHelmet.png",5);
        banditArmor = new Body("Bandit Armor",3,10,"src/istts/pbo/res/Item/BanditArmor.png",5);
        banditBoots = new Boots("Bandit Boots",5,10,"src/istts/pbo/res/Item/BanditBoots.png",5);
        banditAcc = new Accesories("Bandit Necklace",20,10,"src/istts/pbo/res/Item/BanditAcc.png",5);
        chainmailWeapon = new Weapon("Iron Axe",15,20,"src/istts/pbo/res/Item/ChainmailWeapon.png",10);
        chainmailHelmet = new Helmet("Chainmail Helmet",30,20,"src/istts/pbo/res/Item/ChainmailHelmet.png",10);
        chainmailArmor = new Body("Chainmail Armor",6,20,"src/istts/pbo/res/Item/ChainmailArmor.png",10);
        chainmailBoots = new Boots("Chainmail Boots",8,20,"src/istts/pbo/res/Item/ChainmailBoots.png",10);
        chainmailAcc = new Accesories("Chainmail Necklace",35,20,"src/istts/pbo/res/Item/ChainmailAcc.png",10);
        ironWeapon = new Weapon("Iron Sword",23,30,"src/istts/pbo/res/Item/IronWeapon.png",15);
        ironHelmet = new Helmet("Iron Helmet",45,30,"src/istts/pbo/res/Item/IronHelmet.png",15);
        ironArmor = new Body("Iron Armor",8,30,"src/istts/pbo/res/Item/IronArmor.png",15);
        ironBoots = new Boots("Iron Boots",12,30,"src/istts/pbo/res/Item/IronBoots.png",15);
        ironAcc = new Accesories("Iron Necklace",45,30,"src/istts/pbo/res/Item/IronAcc.png",15);
        steelWeapon = new Weapon("Steel Sword",10,40,"src/istts/pbo/res/Item/SteelWeapon.png",20);
        steelHelmet = new Helmet("Steel Helmet",55,40,"src/istts/pbo/res/Item/SteelHelmet.png",20);
        steelArmor = new Body("Steel Armor",13,40,"src/istts/pbo/res/Item/SteelArmor.png",20);
        steelBoots = new Boots("Steel Boots",14,40,"src/istts/pbo/res/Item/SteelBoots.png",20);
        steelAcc = new Accesories("Steel Necklace",60,40,"src/istts/pbo/res/Item/SteelAcc.png",20);
        royalWeapon = new Weapon("Royal Sword",40,50,"src/istts/pbo/res/Item/RoyalWeapon.png",25);
        royalHelmet = new Helmet("Royal Helmet",70,50,"src/istts/pbo/res/Item/RoyalHelmet.png",25);
        royalArmor = new Body("Royal Armor",17,50,"src/istts/pbo/res/Item/RoyalArmor.png",25);
        royalBoots = new Boots("Royal Boots",20,50,"src/istts/pbo/res/Item/RoyalBoots.png",25);
        royalAcc = new Accesories("Royal Necklace",85,50,"src/istts/pbo/res/Item/RoyalAcc.png",25);
        selected = banditHelmet;

        //mainpanel
        class Parent extends JPanel{
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                draw(g);
            }

            private void draw(Graphics g) {
                try {
                    BufferedImage bg = ImageIO.read(new File("src/istts/pbo/res/backgrounds/Shop.png"));
                    g.drawImage(bg, 0, 0, null);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        Parent parent = new Parent();
        parent.setBounds(0,0,SWIDTH,SHEIGHT);
        parent.setLayout(null);
        parent.setPreferredSize(new Dimension(SWIDTH,SHEIGHT));
        parent.setBackground(Color.GRAY);
        parent.setOpaque(false);

        //back
        shopback = new JLabel();
        shopback.setBounds(20,20,100,50);
        shopback.setIcon(new ImageIcon("src/istts/pbo/res/buttons/Back.png"));
        shopback.setCursor(new Cursor(Cursor.HAND_CURSOR));

        //Gambaritem
        gambar = new JLabel("Gambar item clicked");
        gambar.setBounds(170,145,120,120);
        gambar.setIcon(new ImageIcon(selected.getSpritePath()));

        //background desc
        class Backdesc extends JPanel{
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                draw(g);
            }

            private void draw(Graphics g) {
                try {
                    BufferedImage bg = ImageIO.read(new File("src/istts/pbo/res/Tab/ShopTab2.png"));
                    g.drawImage(bg, 0, 0, null);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        backdesc = new Backdesc();
        backdesc.setBounds(20,275,460,355);
        backdesc.setLayout(null);
        backdesc.setOpaque(false);

        //descitem
        desc = new JTextArea("lorem ");
        desc.setBounds(10,10,440,335);
        desc.setLineWrap(true);
        desc.setBackground(Color.PINK);
        desc.setOpaque(false);
        desc.setFont(fontlb);
        desc.setForeground(Color.white);

        //Buy Icon
        buy = new JLabel();
        buy.setBounds(20,650,460,50);
        buy.setHorizontalTextPosition(SwingConstants.CENTER);
        buy.setVerticalTextPosition(SwingConstants.CENTER);
        buy.setBackground(Color.GREEN);
        buy.setOpaque(false);
        buy.setIcon(new ImageIcon("src/istts/pbo/res/Tab/ShopTab4.png"));
        buy.setCursor(new Cursor(Cursor.HAND_CURSOR));

        //Kanan (BUAT BACKGROUND SHOP)
        kanan = new Kanan();
        kanan.setBounds(500,20,750,680);
        kanan.setLayout(new BorderLayout(10,10));
        kanan.setBackground(Color.PINK);
        kanan.setOpaque(false);

        //kananatas

        kananatas = new JPanel();
        kananatas.setPreferredSize(new Dimension(100,100));
        kananatas.setLayout(new FlowLayout(FlowLayout.CENTER,40,28));
        kananatas.setAlignmentY(Component.CENTER_ALIGNMENT);
        kananatas.setAlignmentX(Component.CENTER_ALIGNMENT);
//        kananatas.setBackground(Color.RED);
        kananatas.setOpaque(false);

        //Head
        Head = new JLabel();
        Head.setPreferredSize(new Dimension(100,50));
        Head.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Head.setIcon(new ImageIcon("src/istts/pbo/res/buttons/HelmetShop.png"));
        //Weapon
        Weapon = new JLabel("Weapon");
        Weapon.setPreferredSize(new Dimension(100,50));
        Weapon.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Weapon.setIcon(new ImageIcon("src/istts/pbo/res/buttons/WeaponShop.png"));
        //Body
        Body = new JLabel("Body");
        Body.setPreferredSize(new Dimension(100,50));
        Body.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Body.setIcon(new ImageIcon("src/istts/pbo/res/buttons/ArmorShop.png"));
        //Boots
        Boots = new JLabel("Boots");
        Boots.setPreferredSize(new Dimension(100,50));
        Boots.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Boots.setIcon(new ImageIcon("src/istts/pbo/res/buttons/BootsShop.png"));
        //Accessory
        Accessory = new JLabel("Accessory");
        Accessory.setPreferredSize(new Dimension(100,50));
        Accessory.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Accessory.setIcon(new ImageIcon("src/istts/pbo/res/buttons/AccShop.png"));
        //kanantengahhead(page 1)
        kanantengahhead = new JPanel();
        kanantengahhead.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
//        kanantengahhead.setBackground(Color.CYAN);
        kanantengahhead.setOpaque(false);

        //itemlist

        //item 1
        kanantengahheaditem1 = new JPanel();
        kanantengahheaditem1.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
        kanantengahheaditem1.setPreferredSize(new Dimension(730,140));
        kanantengahheaditem1.setBackground(Color.ORANGE);
        kanantengahheaditem1.setOpaque(false);

        //iconitem1
        headiconitem1 = new JLabel("iconhead1");
        headiconitem1.setPreferredSize(new Dimension(120,120));
        headiconitem1.setIcon(new ImageIcon(banditHelmet.getSpritePath()));
        headiconitem1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        //descitem1
        headicondesc1 = new JTextArea("Name : " + banditHelmet.getName() + "\nHealth : "+banditHelmet.getStat() + "\nCost : "+banditHelmet.getCost());
        headicondesc1.setEditable(false);
        headicondesc1.setFont(fontlb);
        headicondesc1.setPreferredSize(new Dimension(570,120));
        headicondesc1.setLineWrap(true);
        headicondesc1.setForeground(Color.white);
        headicondesc1.setOpaque(false);
        desc.setText(headicondesc1.getText());
        //item 2
        kanantengahheaditem2 = new JPanel();
        kanantengahheaditem2.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
        kanantengahheaditem2.setPreferredSize(new Dimension(730,140));
        kanantengahheaditem2.setBackground(Color.ORANGE);
        kanantengahheaditem2.setOpaque(false);
        //iconitem2
        headiconitem2 = new JLabel("iconhead2");
        headiconitem2.setPreferredSize(new Dimension(120,120));
        headiconitem2.setIcon(new ImageIcon(chainmailHelmet.getSpritePath()));
        headiconitem2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        //descitem2
        headicondesc2 = new JTextArea("Name : " + chainmailHelmet.getName() + "\nHealth : "+chainmailHelmet.getStat() + "\nCost : "+chainmailHelmet.getCost());
        headicondesc2.setEditable(false);
        headicondesc2.setFont(fontlb);
        headicondesc2.setPreferredSize(new Dimension(570,120));
        headicondesc2.setLineWrap(true);
        headicondesc2.setForeground(Color.white);
        headicondesc2.setOpaque(false);
        //item 3
        kanantengahheaditem3 = new JPanel();
        kanantengahheaditem3.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
        kanantengahheaditem3.setPreferredSize(new Dimension(730,140));
        kanantengahheaditem3.setBackground(Color.ORANGE);
        kanantengahheaditem3.setOpaque(false);
        //iconitem3
        headiconitem3 = new JLabel("iconhead3");
        headiconitem3.setPreferredSize(new Dimension(120,120));
        headiconitem3.setIcon(new ImageIcon(ironHelmet.getSpritePath()));
        headiconitem3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        //descitem3
        headicondesc3 = new JTextArea("Name : " + ironHelmet.getName() + "\nHealth : "+ironHelmet.getStat() + "\nCost : "+ironHelmet.getCost());
        headicondesc3.setEditable(false);
        headicondesc3.setFont(fontlb);
        headicondesc3.setPreferredSize(new Dimension(570,120));
        headicondesc3.setLineWrap(true);
        headicondesc3.setForeground(Color.white);
        headicondesc3.setOpaque(false);
        //kanantengahhead2(page2)
        kanantengahhead2 = new JPanel();
        kanantengahhead2.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
//        kanantengahhead2.setBackground(Color.CYAN);
        kanantengahhead2.setOpaque(false);

        //item 4
        kanantengahheaditem4 = new JPanel();
        kanantengahheaditem4.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
        kanantengahheaditem4.setPreferredSize(new Dimension(730,140));
        kanantengahheaditem4.setBackground(Color.ORANGE);
        kanantengahheaditem4.setOpaque(false);

        //iconitem4
        headiconitem4 = new JLabel("iconhead4");
        headiconitem4.setPreferredSize(new Dimension(120,120));
        headiconitem4.setIcon(new ImageIcon(steelHelmet.getSpritePath()));
        headiconitem4.setCursor(new Cursor(Cursor.HAND_CURSOR));
        //descitem1
        headicondesc4 = new JTextArea("Name : " + steelHelmet.getName() + "\nHealth : "+steelHelmet.getStat() + "\nCost : "+steelHelmet.getCost());
        headicondesc4.setEditable(false);
        headicondesc4.setFont(fontlb);
        headicondesc4.setPreferredSize(new Dimension(570,120));
        headicondesc4.setLineWrap(true);
        headicondesc4.setForeground(Color.white);
        headicondesc4.setOpaque(false);
        //item 5
        kanantengahheaditem5 = new JPanel();
        kanantengahheaditem5.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
        kanantengahheaditem5.setPreferredSize(new Dimension(730,140));
        kanantengahheaditem5.setBackground(Color.ORANGE);
        kanantengahheaditem5.setOpaque(false);
        //iconitem5
        headiconitem5 = new JLabel("iconhead5");
        headiconitem5.setPreferredSize(new Dimension(120,120));
        headiconitem5.setIcon(new ImageIcon(royalHelmet.getSpritePath()));
        headiconitem5.setCursor(new Cursor(Cursor.HAND_CURSOR));
        //descitem5
        headicondesc5 = new JTextArea("Name : " + royalHelmet.getName() + "\nHealth : "+royalHelmet.getStat() + "\nCost : "+royalHelmet.getCost());
        headicondesc5.setEditable(false);
        headicondesc5.setFont(fontlb);
        headicondesc5.setPreferredSize(new Dimension(570,120));
        headicondesc5.setLineWrap(true);
        headicondesc5.setForeground(Color.white);
        headicondesc5.setOpaque(false);

        //kanantengahweapon(page 1)
        kanantengahweapon = new JPanel();
        kanantengahweapon.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
//        kanantengahweapon.setBackground(Color.CYAN);
        kanantengahweapon.setOpaque(false);

        //itemlist

        //item 1
        kanantengahweaponitem1 = new JPanel();
        kanantengahweaponitem1.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
        kanantengahweaponitem1.setPreferredSize(new Dimension(730,140));
        kanantengahweaponitem1.setBackground(Color.ORANGE);
        kanantengahweaponitem1.setOpaque(false);

        //iconitem1
        weaponiconitem1 = new JLabel("iconweapon1");
        weaponiconitem1.setPreferredSize(new Dimension(120,120));
        weaponiconitem1.setIcon(new ImageIcon(banditWeapon.getSpritePath()));
        weaponiconitem1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        //descitem1
        weaponicondesc1 = new JTextArea("Name : " + banditWeapon.getName() + "\nAttack : "+banditWeapon.getStat() + "\nCost : "+banditWeapon.getCost());
        weaponicondesc1.setEditable(false);
        weaponicondesc1.setFont(fontlb);
        weaponicondesc1.setPreferredSize(new Dimension(570,120));
        weaponicondesc1.setLineWrap(true);
        weaponicondesc1.setOpaque(false);
        weaponicondesc1.setForeground(Color.white);
        //item 2
        kanantengahweaponitem2 = new JPanel();
        kanantengahweaponitem2.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
        kanantengahweaponitem2.setPreferredSize(new Dimension(730,140));
        kanantengahweaponitem2.setBackground(Color.ORANGE);
        kanantengahweaponitem2.setOpaque(false);
        //iconitem2
        weaponiconitem2 = new JLabel("iconweapon2");
        weaponiconitem2.setPreferredSize(new Dimension(120,120));
        weaponiconitem2.setIcon(new ImageIcon(chainmailWeapon.getSpritePath()));
        weaponiconitem2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        //descitem2
        weaponicondesc2 = new JTextArea("Name : " + chainmailWeapon.getName() + "\nAttack : "+chainmailWeapon.getStat() + "\nCost : "+chainmailWeapon.getCost());
        weaponicondesc2.setEditable(false);
        weaponicondesc2.setFont(fontlb);
        weaponicondesc2.setPreferredSize(new Dimension(570,120));
        weaponicondesc2.setLineWrap(true);
        weaponicondesc2.setOpaque(false);
        weaponicondesc2.setForeground(Color.white);
        //item 3
        kanantengahweaponitem3 = new JPanel();
        kanantengahweaponitem3.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
        kanantengahweaponitem3.setPreferredSize(new Dimension(730,140));
        kanantengahweaponitem3.setBackground(Color.ORANGE);
        kanantengahweaponitem3.setOpaque(false);
        //iconitem3
        weaponiconitem3 = new JLabel("iconweapon3");
        weaponiconitem3.setPreferredSize(new Dimension(120,120));
        weaponiconitem3.setIcon(new ImageIcon(ironWeapon.getSpritePath()));
        weaponiconitem3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        //descitem3
        weaponicondesc3 = new JTextArea("Name : " + ironWeapon.getName() + "\nAttack : "+ironWeapon.getStat() + "\nCost : "+ironWeapon.getCost());
        weaponicondesc3.setEditable(false);
        weaponicondesc3.setFont(fontlb);
        weaponicondesc3.setPreferredSize(new Dimension(570,120));
        weaponicondesc3.setLineWrap(true);
        weaponicondesc3.setOpaque(false);
        weaponicondesc3.setForeground(Color.white);

        //kanantengahweapon2(page2)
        kanantengahweapon2 = new JPanel();
        kanantengahweapon2.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
//        kanantengahweapon2.setBackground(Color.CYAN);
        kanantengahweapon2.setOpaque(false);


        //item 4
        kanantengahweaponitem4 = new JPanel();
        kanantengahweaponitem4.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
        kanantengahweaponitem4.setPreferredSize(new Dimension(730,140));
        kanantengahweaponitem4.setBackground(Color.ORANGE);
        kanantengahweaponitem4.setOpaque(false);

        //iconitem4
        weaponiconitem4 = new JLabel("iconweapon4");
        weaponiconitem4.setPreferredSize(new Dimension(120,120));
        weaponiconitem4.setIcon(new ImageIcon(steelWeapon.getSpritePath()));
        weaponiconitem4.setCursor(new Cursor(Cursor.HAND_CURSOR));
        //descitem1
        weaponicondesc4 = new JTextArea("Name : " + steelWeapon.getName() + "\nAttack : "+steelWeapon.getStat() + "\nCost : "+steelWeapon.getCost());
        weaponicondesc4.setEditable(false);
        weaponicondesc4.setFont(fontlb);
        weaponicondesc4.setPreferredSize(new Dimension(570,120));
        weaponicondesc4.setLineWrap(true);
        weaponicondesc4.setOpaque(false);
        weaponicondesc4.setForeground(Color.white);
        //item 5
        kanantengahweaponitem5 = new JPanel();
        kanantengahweaponitem5.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
        kanantengahweaponitem5.setPreferredSize(new Dimension(730,140));
        kanantengahweaponitem5.setBackground(Color.ORANGE);
        kanantengahweaponitem5.setOpaque(false);
        //iconitem5
        weaponiconitem5 = new JLabel("iconweapon5");
        weaponiconitem5.setPreferredSize(new Dimension(120,120));
        weaponiconitem5.setIcon(new ImageIcon(royalWeapon.getSpritePath()));
        weaponiconitem5.setCursor(new Cursor(Cursor.HAND_CURSOR));
        //descitem5
        weaponicondesc5 = new JTextArea("Name : " + royalWeapon.getName() + "\nAttack : "+royalWeapon.getStat() + "\nCost : "+royalWeapon.getCost());
        weaponicondesc5.setEditable(false);
        weaponicondesc5.setFont(fontlb);
        weaponicondesc5.setPreferredSize(new Dimension(570,120));
        weaponicondesc5.setLineWrap(true);
        weaponicondesc5.setOpaque(false);
        weaponicondesc5.setForeground(Color.white);

        //kanantengahbody(page 1)
        kanantengahbody = new JPanel();
        kanantengahbody.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
//        kanantengahbody.setBackground(Color.CYAN);
        kanantengahbody.setOpaque(false);

        //itemlist

        //item 1
        kanantengahbodyitem1 = new JPanel();
        kanantengahbodyitem1.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
        kanantengahbodyitem1.setPreferredSize(new Dimension(730,140));
        kanantengahbodyitem1.setBackground(Color.ORANGE);
        kanantengahbodyitem1.setOpaque(false);

        //iconitem1
        bodyiconitem1 = new JLabel("iconbody1");
        bodyiconitem1.setPreferredSize(new Dimension(120,120));
        bodyiconitem1.setIcon(new ImageIcon(banditArmor.getSpritePath()));
        bodyiconitem1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        //descitem1
        bodyicondesc1 = new JTextArea("Name : " + banditArmor.getName() + "\nArmor : "+banditArmor.getStat() + "\nCost : "+banditArmor.getCost());
        bodyicondesc1.setEditable(false);
        bodyicondesc1.setFont(fontlb);
        bodyicondesc1.setPreferredSize(new Dimension(570,120));
        bodyicondesc1.setLineWrap(true);
        bodyicondesc1.setOpaque(false);
        bodyicondesc1.setForeground(Color.white);
        //item 2
        kanantengahbodyitem2 = new JPanel();
        kanantengahbodyitem2.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
        kanantengahbodyitem2.setPreferredSize(new Dimension(730,140));
        kanantengahbodyitem2.setBackground(Color.ORANGE);
        kanantengahbodyitem2.setOpaque(false);
        //iconitem2
        bodyiconitem2 = new JLabel("iconbody2");
        bodyiconitem2.setPreferredSize(new Dimension(120,120));
        bodyiconitem2.setIcon(new ImageIcon(chainmailArmor.getSpritePath()));
        bodyiconitem2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        //descitem2
        bodyicondesc2 = new JTextArea("Name : " + chainmailArmor.getName() + "\nArmor : "+chainmailArmor.getStat() + "\nCost : "+chainmailArmor.getCost());
        bodyicondesc2.setEditable(false);
        bodyicondesc2.setFont(fontlb);
        bodyicondesc2.setPreferredSize(new Dimension(570,120));
        bodyicondesc2.setLineWrap(true);
        bodyicondesc2.setOpaque(false);
        bodyicondesc2.setForeground(Color.white);

        //item 3
        kanantengahbodyitem3 = new JPanel();
        kanantengahbodyitem3.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
        kanantengahbodyitem3.setPreferredSize(new Dimension(730,140));
        kanantengahbodyitem3.setBackground(Color.ORANGE);
        kanantengahbodyitem3.setOpaque(false);
        //iconitem3
        bodyiconitem3 = new JLabel("iconbody3");
        bodyiconitem3.setPreferredSize(new Dimension(120,120));
        bodyiconitem3.setIcon(new ImageIcon(ironArmor.getSpritePath()));
        bodyiconitem3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        //descitem3
        bodyicondesc3 = new JTextArea("Name : " + ironArmor.getName() + "\nArmor : "+ironArmor.getStat() + "\nCost : "+ironArmor.getCost());
        bodyicondesc3.setEditable(false);
        bodyicondesc3.setFont(fontlb);
        bodyicondesc3.setPreferredSize(new Dimension(570,120));
        bodyicondesc3.setLineWrap(true);
        bodyicondesc3.setOpaque(false);
        bodyicondesc3.setForeground(Color.white);

        //kanantengahbody2(page2)
        kanantengahbody2 = new JPanel();
        kanantengahbody2.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
//        kanantengahbody2.setBackground(Color.CYAN);
        kanantengahbody2.setOpaque(false);


        //item 4
        kanantengahbodyitem4 = new JPanel();
        kanantengahbodyitem4.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
        kanantengahbodyitem4.setPreferredSize(new Dimension(730,140));
        kanantengahbodyitem4.setBackground(Color.ORANGE);
        kanantengahbodyitem4.setOpaque(false);

        //iconitem4
        bodyiconitem4 = new JLabel("iconbody4");
        bodyiconitem4.setPreferredSize(new Dimension(120,120));
        bodyiconitem4.setIcon(new ImageIcon(steelArmor.getSpritePath()));
        bodyiconitem4.setCursor(new Cursor(Cursor.HAND_CURSOR));
        //descitem1
        bodyicondesc4 = new JTextArea("Name : " + steelArmor.getName() + "\nArmor : "+steelArmor.getStat() + "\nCost : "+steelArmor.getCost());
        bodyicondesc4.setEditable(false);
        bodyicondesc4.setFont(fontlb);
        bodyicondesc4.setPreferredSize(new Dimension(570,120));
        bodyicondesc4.setLineWrap(true);
        bodyicondesc4.setOpaque(false);
        bodyicondesc4.setForeground(Color.white);

        //item 5
        kanantengahbodyitem5 = new JPanel();
        kanantengahbodyitem5.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
        kanantengahbodyitem5.setPreferredSize(new Dimension(730,140));
        kanantengahbodyitem5.setBackground(Color.ORANGE);
        kanantengahbodyitem5.setOpaque(false);
        //iconitem5
        bodyiconitem5 = new JLabel("iconbody5");
        bodyiconitem5.setPreferredSize(new Dimension(120,120));
        bodyiconitem5.setIcon(new ImageIcon(royalArmor.getSpritePath()));
        bodyiconitem5.setCursor(new Cursor(Cursor.HAND_CURSOR));
        //descitem5
        bodyicondesc5 = new JTextArea("Name : " + royalArmor.getName() + "\nArmor : "+royalArmor.getStat() + "\nCost : "+royalArmor.getCost());
        bodyicondesc5.setEditable(false);
        bodyicondesc5.setFont(fontlb);
        bodyicondesc5.setPreferredSize(new Dimension(570,120));
        bodyicondesc5.setLineWrap(true);
        bodyicondesc5.setOpaque(false);
        bodyicondesc5.setForeground(Color.white);

        //kanantengahboots(page 1)
        kanantengahboots = new JPanel();
        kanantengahboots.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
//        kanantengahboots.setBackground(Color.CYAN);
        kanantengahboots.setOpaque(false);

        //itemlist

        //item 1
        kanantengahbootsitem1 = new JPanel();
        kanantengahbootsitem1.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
        kanantengahbootsitem1.setPreferredSize(new Dimension(730,140));
        kanantengahbootsitem1.setBackground(Color.ORANGE);
        kanantengahbootsitem1.setOpaque(false);

        //iconitem1
        bootsiconitem1 = new JLabel("iconboots1");
        bootsiconitem1.setPreferredSize(new Dimension(120,120));
        bootsiconitem1.setIcon(new ImageIcon(banditBoots.getSpritePath()));
        bootsiconitem1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        //descitem1
        bootsicondesc1 = new JTextArea("Name : " + banditBoots.getName() + "\nSpeed : "+banditBoots.getStat() + "\nCost : "+banditBoots.getCost());
        bootsicondesc1.setEditable(false);
        bootsicondesc1.setFont(fontlb);
        bootsicondesc1.setPreferredSize(new Dimension(570,120));
        bootsicondesc1.setLineWrap(true);
        bootsicondesc1.setOpaque(false);
        bootsicondesc1.setForeground(Color.white);

        //item 2
        kanantengahbootsitem2 = new JPanel();
        kanantengahbootsitem2.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
        kanantengahbootsitem2.setPreferredSize(new Dimension(730,140));
        kanantengahbootsitem2.setBackground(Color.ORANGE);
        kanantengahbootsitem2.setOpaque(false);
        //iconitem2
        bootsiconitem2 = new JLabel("iconboots2");
        bootsiconitem2.setPreferredSize(new Dimension(120,120));
        bootsiconitem2.setIcon(new ImageIcon(chainmailBoots.getSpritePath()));
        bootsiconitem2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        //descitem2
        bootsicondesc2 = new JTextArea("Name : " + chainmailBoots.getName() + "\nSpeed : "+chainmailBoots.getStat() + "\nCost : "+chainmailBoots.getCost());
        bootsicondesc2.setEditable(false);
        bootsicondesc2.setFont(fontlb);
        bootsicondesc2.setPreferredSize(new Dimension(570,120));
        bootsicondesc2.setLineWrap(true);
        bootsicondesc2.setOpaque(false);
        bootsicondesc2.setForeground(Color.white);
        //item 3
        kanantengahbootsitem3 = new JPanel();
        kanantengahbootsitem3.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
        kanantengahbootsitem3.setPreferredSize(new Dimension(730,140));
        kanantengahbootsitem3.setBackground(Color.ORANGE);
        kanantengahbootsitem3.setOpaque(false);
        //iconitem3
        bootsiconitem3 = new JLabel("iconboots3");
        bootsiconitem3.setPreferredSize(new Dimension(120,120));
        bootsiconitem3.setIcon(new ImageIcon(ironBoots.getSpritePath()));
        bootsiconitem3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        //descitem3
        bootsicondesc3 = new JTextArea("Name : " + ironBoots.getName() + "\nSpeed : "+ironBoots.getStat() + "\nCost : "+ironBoots.getCost());
        bootsicondesc3.setEditable(false);
        bootsicondesc3.setFont(fontlb);
        bootsicondesc3.setPreferredSize(new Dimension(570,120));
        bootsicondesc3.setLineWrap(true);
        bootsicondesc3.setOpaque(false);
        bootsicondesc3.setForeground(Color.white);
        //kanantengahboots2(page2)
        kanantengahboots2 = new JPanel();
        kanantengahboots2.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
//        kanantengahboots2.setBackground(Color.CYAN);
        kanantengahboots2.setOpaque(false);


        //item 4
        kanantengahbootsitem4 = new JPanel();
        kanantengahbootsitem4.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
        kanantengahbootsitem4.setPreferredSize(new Dimension(730,140));
        kanantengahbootsitem4.setBackground(Color.ORANGE);
        kanantengahbootsitem4.setOpaque(false);

        //iconitem4
        bootsiconitem4 = new JLabel("iconboots4");
        bootsiconitem4.setPreferredSize(new Dimension(120,120));
        bootsiconitem4.setIcon(new ImageIcon(steelBoots.getSpritePath()));
        bootsiconitem4.setCursor(new Cursor(Cursor.HAND_CURSOR));
        //descitem1
        bootsicondesc4 = new JTextArea("Name : " + steelBoots.getName() + "\nSpeed : "+steelBoots.getStat() + "\nCost : "+steelBoots.getCost());
        bootsicondesc4.setEditable(false);
        bootsicondesc4.setFont(fontlb);
        bootsicondesc4.setPreferredSize(new Dimension(570,120));
        bootsicondesc4.setLineWrap(true);
        bootsicondesc4.setOpaque(false);
        bootsicondesc4.setForeground(Color.white);
        //item 5
        kanantengahbootsitem5 = new JPanel();
        kanantengahbootsitem5.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
        kanantengahbootsitem5.setPreferredSize(new Dimension(730,140));
        kanantengahbootsitem5.setBackground(Color.ORANGE);
        kanantengahbootsitem5.setOpaque(false);
        //iconitem5
        bootsiconitem5 = new JLabel("iconboots5");
        bootsiconitem5.setPreferredSize(new Dimension(120,120));
        bootsiconitem5.setIcon(new ImageIcon(royalBoots.getSpritePath()));
        bootsiconitem5.setCursor(new Cursor(Cursor.HAND_CURSOR));
        //descitem5
        bootsicondesc5 = new JTextArea("Name : " + royalBoots.getName() + "\nSpeed : "+royalBoots.getStat() + "\nCost : "+royalBoots.getCost());
        bootsicondesc5.setEditable(false);
        bootsicondesc5.setFont(fontlb);
        bootsicondesc5.setPreferredSize(new Dimension(570,120));
        bootsicondesc5.setLineWrap(true);
        bootsicondesc5.setOpaque(false);
        bootsicondesc5.setForeground(Color.white);

        //kanantengahaccessory(page 1)
        kanantengahaccessory = new JPanel();
        kanantengahaccessory.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
//        kanantengahaccessory.setBackground(Color.CYAN);
        kanantengahaccessory.setOpaque(false);

        //itemlist

        //item 1
        kanantengahaccessoryitem1 = new JPanel();
        kanantengahaccessoryitem1.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
        kanantengahaccessoryitem1.setPreferredSize(new Dimension(730,140));
        kanantengahaccessoryitem1.setBackground(Color.ORANGE);
        kanantengahaccessoryitem1.setOpaque(false);

        //iconitem1
        accessoryiconitem1 = new JLabel("iconaccessory1");
        accessoryiconitem1.setPreferredSize(new Dimension(120,120));
        accessoryiconitem1.setIcon(new ImageIcon(banditAcc.getSpritePath()));
        accessoryiconitem1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        //descitem1
        accessoryicondesc1 = new JTextArea("Name : " + banditAcc.getName() + "\nMana : "+banditAcc.getStat() + "\nCost : "+banditAcc.getCost());
        accessoryicondesc1.setEditable(false);
        accessoryicondesc1.setFont(fontlb);
        accessoryicondesc1.setPreferredSize(new Dimension(570,120));
        accessoryicondesc1.setLineWrap(true);
        accessoryicondesc1.setOpaque(false);
        accessoryicondesc1.setForeground(Color.white);
        //item 2
        kanantengahaccessoryitem2 = new JPanel();
        kanantengahaccessoryitem2.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
        kanantengahaccessoryitem2.setPreferredSize(new Dimension(730,140));
        kanantengahaccessoryitem2.setBackground(Color.ORANGE);
        kanantengahaccessoryitem2.setOpaque(false);
        //iconitem2
        accessoryiconitem2 = new JLabel("iconaccessory2");
        accessoryiconitem2.setPreferredSize(new Dimension(120,120));
        accessoryiconitem2.setIcon(new ImageIcon(chainmailAcc.getSpritePath()));
        accessoryiconitem2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        //descitem2
        accessoryicondesc2 = new JTextArea("Name : " + chainmailAcc.getName() + "\nMana : "+chainmailAcc.getStat() + "\nCost : "+chainmailAcc.getCost());
        accessoryicondesc2.setEditable(false);
        accessoryicondesc2.setFont(fontlb);
        accessoryicondesc2.setPreferredSize(new Dimension(570,120));
        accessoryicondesc2.setLineWrap(true);
        accessoryicondesc2.setOpaque(false);
        accessoryicondesc2.setForeground(Color.white);
        //item 3
        kanantengahaccessoryitem3 = new JPanel();
        kanantengahaccessoryitem3.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
        kanantengahaccessoryitem3.setPreferredSize(new Dimension(730,140));
        kanantengahaccessoryitem3.setBackground(Color.ORANGE);
        kanantengahaccessoryitem3.setOpaque(false);
        //iconitem3
        accessoryiconitem3 = new JLabel("iconaccessory3");
        accessoryiconitem3.setPreferredSize(new Dimension(120,120));
        accessoryiconitem3.setIcon(new ImageIcon(ironAcc.getSpritePath()));
        accessoryiconitem3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        //descitem3
        accessoryicondesc3 = new JTextArea("Name : " + ironAcc.getName() + "\nMana : "+ironAcc.getStat() + "\nCost : "+ironAcc.getCost());
        accessoryicondesc3.setEditable(false);
        accessoryicondesc3.setFont(fontlb);
        accessoryicondesc3.setPreferredSize(new Dimension(570,120));
        accessoryicondesc3.setLineWrap(true);
        accessoryicondesc3.setOpaque(false);
        accessoryicondesc3.setForeground(Color.white);
        //kanantengahaccessory2(page2)
        kanantengahaccessory2 = new JPanel();
        kanantengahaccessory2.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
//        kanantengahaccessory2.setBackground(Color.CYAN);
        kanantengahaccessory2.setOpaque(false);


        //item 4
        kanantengahaccessoryitem4 = new JPanel();
        kanantengahaccessoryitem4.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
        kanantengahaccessoryitem4.setPreferredSize(new Dimension(730,140));
//        kanantengahaccessoryitem4.setBackground(Color.ORANGE);
        kanantengahaccessoryitem4.setOpaque(false);

        //iconitem4
        accessoryiconitem4 = new JLabel("iconaccessory4");
        accessoryiconitem4.setPreferredSize(new Dimension(120,120));
        accessoryiconitem4.setIcon(new ImageIcon(steelAcc.getSpritePath()));
        accessoryiconitem4.setCursor(new Cursor(Cursor.HAND_CURSOR));
        //descitem1
        accessoryicondesc4 = new JTextArea("Name : " + steelAcc.getName() + "\nMana : "+steelAcc.getStat() + "\nCost : "+steelAcc.getCost());
        accessoryicondesc4.setEditable(false);
        accessoryicondesc4.setFont(fontlb);
        accessoryicondesc4.setPreferredSize(new Dimension(570,120));
        accessoryicondesc4.setLineWrap(true);
        accessoryicondesc4.setOpaque(false);
        accessoryicondesc4.setForeground(Color.white);
        //item 5
        kanantengahaccessoryitem5 = new JPanel();
        kanantengahaccessoryitem5.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
        kanantengahaccessoryitem5.setPreferredSize(new Dimension(730,140));
        kanantengahaccessoryitem5.setBackground(Color.ORANGE);
        kanantengahaccessoryitem5.setOpaque(false);
        //iconitem5
        accessoryiconitem5 = new JLabel("iconaccessory5");
        accessoryiconitem5.setPreferredSize(new Dimension(120,120));
        accessoryiconitem5.setIcon(new ImageIcon(royalAcc.getSpritePath()));
        accessoryiconitem5.setCursor(new Cursor(Cursor.HAND_CURSOR));
        //descitem5
        accessoryicondesc5 = new JTextArea("Name : " + royalAcc.getName() + "\nMana : "+royalAcc.getStat() + "\nCost : "+royalAcc.getCost());
        accessoryicondesc5.setEditable(false);
        accessoryicondesc5.setFont(fontlb);
        accessoryicondesc5.setPreferredSize(new Dimension(570,120));
        accessoryicondesc5.setLineWrap(true);
        accessoryicondesc5.setOpaque(false);
        accessoryicondesc5.setForeground(Color.white);
        //kananbawah

        kananbawah = new JPanel();
        kananbawah.setLayout(new FlowLayout(FlowLayout.RIGHT,40,30));
        kananbawah.setPreferredSize(new Dimension(100,100));
//        kananbawah.setBackground(Color.YELLOW);
        kananbawah.setOpaque(false);

        //current page ...
        CurrentPage = new JLabel("Page : "+(page+1)+"/ 2");
        CurrentPage.setPreferredSize(new Dimension(200,40));
        CurrentPage.setBackground(Color.GREEN);
        CurrentPage.setOpaque(false);
        CurrentPage.setForeground(Color.white);
        CurrentPage.setFont(new Font("Arial",Font.PLAIN,25));
        //prevpage
        Prev = new JLabel();
        Prev.setPreferredSize(new Dimension(80,40));
        Prev.setIcon(new ImageIcon("src/istts/pbo/res/buttons/backShop.png"));
        Prev.setCursor(new Cursor(Cursor.HAND_CURSOR));
        //nextpage
        Next = new JLabel();
        Next.setPreferredSize(new Dimension(80,40));
        Next.setIcon(new ImageIcon("src/istts/pbo/res/buttons/nextShop.png"));
        Next.setCursor(new Cursor(Cursor.HAND_CURSOR));

        //gold sekarang
        class Currgoldbg extends JPanel{
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                draw(g);
            }

            private void draw(Graphics g) {
                try {
                    BufferedImage bg = ImageIO.read(new File("src/istts/pbo/res/Tab/ShopTab3.png"));
                    g.drawImage(bg, 0, 0, null);
                } catch (IOException e) {
                    e.printStackTrace();

                }
            }
        }

        Currgold = new JLabel("   Gold : "+p.getGold()+"");
        Currgold.setBounds(25,0,180,40);
        Currgold.setBackground(Color.yellow);
        Currgold.setOpaque(false);
        Currgold.setFont(new Font("Arial", Font.PLAIN,20));

        Currgoldbg currgoldbg = new Currgoldbg();
        currgoldbg.setBounds(550,630,180,40);
        currgoldbg.setOpaque(true);
        currgoldbg.setLayout(null);
        parent.add(currgoldbg);

        //Add And Revalidate every shit
        this.add(parent);
        parent.revalidate();
        parent.repaint();
        parent.setVisible(true);

        parent.add(shopback);
        shopback.revalidate();
        shopback.repaint();
        shopback.setVisible(true);

        parent.add(gambar);
        gambar.revalidate();
        gambar.repaint();
        gambar.setVisible(true);

        parent.add(backdesc);
        backdesc.revalidate();
        backdesc.repaint();
        backdesc.setVisible(true);


        backdesc.add(desc);
        desc.revalidate();
        desc.repaint();
        desc.setVisible(true);

        parent.add(buy);
        buy.revalidate();
        buy.repaint();
        buy.setVisible(true);

        parent.add(kanan);
        kanan.revalidate();
        kanan.repaint();
        kanan.setVisible(true);

        //kananatas start

        kanan.add(kananatas,BorderLayout.NORTH);
        kananatas.revalidate();
        kananatas.repaint();
        kananatas.setVisible(true);

        kananatas.add(Head);
        Head.revalidate();
        Head.repaint();
        Head.setVisible(true);

        kananatas.add(Weapon);
        Weapon.revalidate();
        Weapon.repaint();
        Weapon.setVisible(true);

        kananatas.add(Body);
        Body.revalidate();
        Body.repaint();
        Body.setVisible(true);

        kananatas.add(Boots);
        Boots.revalidate();
        Boots.repaint();
        Boots.setVisible(true);

        kananatas.add(Accessory);
        Accessory.revalidate();
        Accessory.repaint();
        Accessory.setVisible(true);

        //end
        //kanantengah start
        //head1
        kanan.add(kanantengahhead,BorderLayout.CENTER);
        kanantengahhead.revalidate();
        kanantengahhead.repaint();
        kanantengahhead.setVisible(true);

        kanantengahhead.add(kanantengahheaditem1);
        kanantengahheaditem1.revalidate();
        kanantengahheaditem1.repaint();
        kanantengahheaditem1.setVisible(true);

        kanantengahheaditem1.add(headiconitem1);
        headiconitem1.revalidate();
        headiconitem1.repaint();
        headiconitem1.setVisible(true);

        kanantengahheaditem1.add(headicondesc1);
        headicondesc1.revalidate();
        headicondesc1.repaint();
        headicondesc1.setVisible(true);

        kanantengahhead.add(kanantengahheaditem2);
        kanantengahheaditem2.revalidate();
        kanantengahheaditem2.repaint();
        kanantengahheaditem2.setVisible(true);

        kanantengahheaditem2.add(headiconitem2);
        headiconitem2.revalidate();
        headiconitem2.repaint();
        headiconitem2.setVisible(true);

        kanantengahheaditem2.add(headicondesc2);
        headicondesc2.revalidate();
        headicondesc2.repaint();
        headicondesc2.setVisible(true);

        kanantengahhead.add(kanantengahheaditem3);
        kanantengahheaditem3.revalidate();
        kanantengahheaditem3.repaint();
        kanantengahheaditem3.setVisible(true);

        kanantengahheaditem3.add(headiconitem3);
        headiconitem3.revalidate();
        headiconitem3.repaint();
        headiconitem3.setVisible(true);

        kanantengahheaditem3.add(headicondesc3);
        headicondesc3.revalidate();
        headicondesc3.repaint();
        headicondesc3.setVisible(true);
        //end
        //head2
        kanan.add(kanantengahhead2,BorderLayout.CENTER);
        kanantengahhead2.revalidate();
        kanantengahhead2.repaint();
        kanantengahhead2.setVisible(true);

        kanantengahhead2.add(kanantengahheaditem4);
        kanantengahheaditem4.revalidate();
        kanantengahheaditem4.repaint();
        kanantengahheaditem4.setVisible(true);

        kanantengahheaditem4.add(headiconitem4);
        headiconitem4.revalidate();
        headiconitem4.repaint();
        headiconitem4.setVisible(true);

        kanantengahheaditem4.add(headicondesc4);
        headicondesc4.revalidate();
        headicondesc4.repaint();
        headicondesc4.setVisible(true);

        kanantengahhead2.add(kanantengahheaditem5);
        kanantengahheaditem5.revalidate();
        kanantengahheaditem5.repaint();
        kanantengahheaditem5.setVisible(true);

        kanantengahheaditem5.add(headiconitem5);
        headiconitem5.revalidate();
        headiconitem5.repaint();
        headiconitem5.setVisible(true);

        kanantengahheaditem5.add(headicondesc5);
        headicondesc5.revalidate();
        headicondesc5.repaint();
        headicondesc5.setVisible(true);
        //end
        //weapon1
        kanan.add(kanantengahweapon,BorderLayout.CENTER);
        kanantengahweapon.revalidate();
        kanantengahweapon.repaint();
        kanantengahweapon.setVisible(true);

        kanantengahweapon.add(kanantengahweaponitem1);
        kanantengahweaponitem1.revalidate();
        kanantengahweaponitem1.repaint();
        kanantengahweaponitem1.setVisible(true);

        kanantengahweaponitem1.add(weaponiconitem1);
        weaponiconitem1.revalidate();
        weaponiconitem1.repaint();
        weaponiconitem1.setVisible(true);

        kanantengahweaponitem1.add(weaponicondesc1);
        weaponicondesc1.revalidate();
        weaponicondesc1.repaint();
        weaponicondesc1.setVisible(true);

        kanantengahweapon.add(kanantengahweaponitem2);
        kanantengahweaponitem2.revalidate();
        kanantengahweaponitem2.repaint();
        kanantengahweaponitem2.setVisible(true);

        kanantengahweaponitem2.add(weaponiconitem2);
        weaponiconitem2.revalidate();
        weaponiconitem2.repaint();
        weaponiconitem2.setVisible(true);

        kanantengahweaponitem2.add(weaponicondesc2);
        weaponicondesc2.revalidate();
        weaponicondesc2.repaint();
        weaponicondesc2.setVisible(true);

        kanantengahweapon.add(kanantengahweaponitem3);
        kanantengahweaponitem3.revalidate();
        kanantengahweaponitem3.repaint();
        kanantengahweaponitem3.setVisible(true);

        kanantengahweaponitem3.add(weaponiconitem3);
        weaponiconitem3.revalidate();
        weaponiconitem3.repaint();
        weaponiconitem3.setVisible(true);

        kanantengahweaponitem3.add(weaponicondesc3);
        weaponicondesc3.revalidate();
        weaponicondesc3.repaint();
        weaponicondesc3.setVisible(true);
        //end
        //weapon2
        kanan.add(kanantengahweapon2,BorderLayout.CENTER);
        kanantengahweapon2.revalidate();
        kanantengahweapon2.repaint();
        kanantengahweapon2.setVisible(true);

        kanantengahweapon2.add(kanantengahweaponitem4);
        kanantengahweaponitem4.revalidate();
        kanantengahweaponitem4.repaint();
        kanantengahweaponitem4.setVisible(true);

        kanantengahweaponitem4.add(weaponiconitem4);
        weaponiconitem4.revalidate();
        weaponiconitem4.repaint();
        weaponiconitem4.setVisible(true);

        kanantengahweaponitem4.add(weaponicondesc4);
        weaponicondesc4.revalidate();
        weaponicondesc4.repaint();
        weaponicondesc4.setVisible(true);

        kanantengahweapon2.add(kanantengahweaponitem5);
        kanantengahweaponitem5.revalidate();
        kanantengahweaponitem5.repaint();
        kanantengahweaponitem5.setVisible(true);

        kanantengahweaponitem5.add(weaponiconitem5);
        weaponiconitem5.revalidate();
        weaponiconitem5.repaint();
        weaponiconitem5.setVisible(true);

        kanantengahweaponitem5.add(weaponicondesc5);
        weaponicondesc5.revalidate();
        weaponicondesc5.repaint();
        weaponicondesc5.setVisible(true);
        //end
        //body1
        kanan.add(kanantengahbody,BorderLayout.CENTER);
        kanantengahbody.revalidate();
        kanantengahbody.repaint();
        kanantengahbody.setVisible(true);

        kanantengahbody.add(kanantengahbodyitem1);
        kanantengahbodyitem1.revalidate();
        kanantengahbodyitem1.repaint();
        kanantengahbodyitem1.setVisible(true);

        kanantengahbodyitem1.add(bodyiconitem1);
        bodyiconitem1.revalidate();
        bodyiconitem1.repaint();
        bodyiconitem1.setVisible(true);

        kanantengahbodyitem1.add(bodyicondesc1);
        bodyicondesc1.revalidate();
        bodyicondesc1.repaint();
        bodyicondesc1.setVisible(true);

        kanantengahbody.add(kanantengahbodyitem2);
        kanantengahbodyitem2.revalidate();
        kanantengahbodyitem2.repaint();
        kanantengahbodyitem2.setVisible(true);

        kanantengahbodyitem2.add(bodyiconitem2);
        bodyiconitem2.revalidate();
        bodyiconitem2.repaint();
        bodyiconitem2.setVisible(true);

        kanantengahbodyitem2.add(bodyicondesc2);
        bodyicondesc2.revalidate();
        bodyicondesc2.repaint();
        bodyicondesc2.setVisible(true);

        kanantengahbody.add(kanantengahbodyitem3);
        kanantengahbodyitem3.revalidate();
        kanantengahbodyitem3.repaint();
        kanantengahbodyitem3.setVisible(true);

        kanantengahbodyitem3.add(bodyiconitem3);
        bodyiconitem3.revalidate();
        bodyiconitem3.repaint();
        bodyiconitem3.setVisible(true);

        kanantengahbodyitem3.add(bodyicondesc3);
        bodyicondesc3.revalidate();
        bodyicondesc3.repaint();
        bodyicondesc3.setVisible(true);
        //end
        //body2
        kanan.add(kanantengahbody2,BorderLayout.CENTER);
        kanantengahbody2.revalidate();
        kanantengahbody2.repaint();
        kanantengahbody2.setVisible(true);

        kanantengahbody2.add(kanantengahbodyitem4);
        kanantengahbodyitem4.revalidate();
        kanantengahbodyitem4.repaint();
        kanantengahbodyitem4.setVisible(true);

        kanantengahbodyitem4.add(bodyiconitem4);
        bodyiconitem4.revalidate();
        bodyiconitem4.repaint();
        bodyiconitem4.setVisible(true);

        kanantengahbodyitem4.add(bodyicondesc4);
        bodyicondesc4.revalidate();
        bodyicondesc4.repaint();
        bodyicondesc4.setVisible(true);

        kanantengahbody2.add(kanantengahbodyitem5);
        kanantengahbodyitem5.revalidate();
        kanantengahbodyitem5.repaint();
        kanantengahbodyitem5.setVisible(true);

        kanantengahbodyitem5.add(bodyiconitem5);
        bodyiconitem5.revalidate();
        bodyiconitem5.repaint();
        bodyiconitem5.setVisible(true);

        kanantengahbodyitem5.add(bodyicondesc5);
        bodyicondesc5.revalidate();
        bodyicondesc5.repaint();
        bodyicondesc5.setVisible(true);
        //end
        //boots1
        kanan.add(kanantengahboots,BorderLayout.CENTER);
        kanantengahboots.revalidate();
        kanantengahboots.repaint();
        kanantengahboots.setVisible(true);

        kanantengahboots.add(kanantengahbootsitem1);
        kanantengahbootsitem1.revalidate();
        kanantengahbootsitem1.repaint();
        kanantengahbootsitem1.setVisible(true);

        kanantengahbootsitem1.add(bootsiconitem1);
        bootsiconitem1.revalidate();
        bootsiconitem1.repaint();
        bootsiconitem1.setVisible(true);

        kanantengahbootsitem1.add(bootsicondesc1);
        bootsicondesc1.revalidate();
        bootsicondesc1.repaint();
        bootsicondesc1.setVisible(true);

        kanantengahboots.add(kanantengahbootsitem2);
        kanantengahbootsitem2.revalidate();
        kanantengahbootsitem2.repaint();
        kanantengahbootsitem2.setVisible(true);

        kanantengahbootsitem2.add(bootsiconitem2);
        bootsiconitem2.revalidate();
        bootsiconitem2.repaint();
        bootsiconitem2.setVisible(true);

        kanantengahbootsitem2.add(bootsicondesc2);
        bootsicondesc2.revalidate();
        bootsicondesc2.repaint();
        bootsicondesc2.setVisible(true);

        kanantengahboots.add(kanantengahbootsitem3);
        kanantengahbootsitem3.revalidate();
        kanantengahbootsitem3.repaint();
        kanantengahbootsitem3.setVisible(true);

        kanantengahbootsitem3.add(bootsiconitem3);
        bootsiconitem3.revalidate();
        bootsiconitem3.repaint();
        bootsiconitem3.setVisible(true);

        kanantengahbootsitem3.add(bootsicondesc3);
        bootsicondesc3.revalidate();
        bootsicondesc3.repaint();
        bootsicondesc3.setVisible(true);
        //end
        //boots2
        kanan.add(kanantengahboots2,BorderLayout.CENTER);
        kanantengahboots2.revalidate();
        kanantengahboots2.repaint();
        kanantengahboots2.setVisible(true);

        kanantengahboots2.add(kanantengahbootsitem4);
        kanantengahbootsitem4.revalidate();
        kanantengahbootsitem4.repaint();
        kanantengahbootsitem4.setVisible(true);

        kanantengahbootsitem4.add(bootsiconitem4);
        bootsiconitem4.revalidate();
        bootsiconitem4.repaint();
        bootsiconitem4.setVisible(true);

        kanantengahbootsitem4.add(bootsicondesc4);
        bootsicondesc4.revalidate();
        bootsicondesc4.repaint();
        bootsicondesc4.setVisible(true);

        kanantengahboots2.add(kanantengahbootsitem5);
        kanantengahbootsitem5.revalidate();
        kanantengahbootsitem5.repaint();
        kanantengahbootsitem5.setVisible(true);

        kanantengahbootsitem5.add(bootsiconitem5);
        bootsiconitem5.revalidate();
        bootsiconitem5.repaint();
        bootsiconitem5.setVisible(true);

        kanantengahbootsitem5.add(bootsicondesc5);
        bootsicondesc5.revalidate();
        bootsicondesc5.repaint();
        bootsicondesc5.setVisible(true);
        //end
        //accessory1
        kanan.add(kanantengahaccessory,BorderLayout.CENTER);
        kanantengahaccessory.revalidate();
        kanantengahaccessory.repaint();
        kanantengahaccessory.setVisible(true);

        kanantengahaccessory.add(kanantengahaccessoryitem1);
        kanantengahaccessoryitem1.revalidate();
        kanantengahaccessoryitem1.repaint();
        kanantengahaccessoryitem1.setVisible(true);

        kanantengahaccessoryitem1.add(accessoryiconitem1);
        accessoryiconitem1.revalidate();
        accessoryiconitem1.repaint();
        accessoryiconitem1.setVisible(true);

        kanantengahaccessoryitem1.add(accessoryicondesc1);
        accessoryicondesc1.revalidate();
        accessoryicondesc1.repaint();
        accessoryicondesc1.setVisible(true);

        kanantengahaccessory.add(kanantengahaccessoryitem2);
        kanantengahaccessoryitem2.revalidate();
        kanantengahaccessoryitem2.repaint();
        kanantengahaccessoryitem2.setVisible(true);

        kanantengahaccessoryitem2.add(accessoryiconitem2);
        accessoryiconitem2.revalidate();
        accessoryiconitem2.repaint();
        accessoryiconitem2.setVisible(true);

        kanantengahaccessoryitem2.add(accessoryicondesc2);
        accessoryicondesc2.revalidate();
        accessoryicondesc2.repaint();
        accessoryicondesc2.setVisible(true);

        kanantengahaccessory.add(kanantengahaccessoryitem3);
        kanantengahaccessoryitem3.revalidate();
        kanantengahaccessoryitem3.repaint();
        kanantengahaccessoryitem3.setVisible(true);

        kanantengahaccessoryitem3.add(accessoryiconitem3);
        accessoryiconitem3.revalidate();
        accessoryiconitem3.repaint();
        accessoryiconitem3.setVisible(true);

        kanantengahaccessoryitem3.add(accessoryicondesc3);
        accessoryicondesc3.revalidate();
        accessoryicondesc3.repaint();
        accessoryicondesc3.setVisible(true);
        //end
        //accessory2
        kanan.add(kanantengahaccessory2,BorderLayout.CENTER);
        kanantengahaccessory2.revalidate();
        kanantengahaccessory2.repaint();
        kanantengahaccessory2.setVisible(true);

        kanantengahaccessory2.add(kanantengahaccessoryitem4);
        kanantengahaccessoryitem4.revalidate();
        kanantengahaccessoryitem4.repaint();
        kanantengahaccessoryitem4.setVisible(true);

        kanantengahaccessoryitem4.add(accessoryiconitem4);
        accessoryiconitem4.revalidate();
        accessoryiconitem4.repaint();
        accessoryiconitem4.setVisible(true);

        kanantengahaccessoryitem4.add(accessoryicondesc4);
        accessoryicondesc4.revalidate();
        accessoryicondesc4.repaint();
        accessoryicondesc4.setVisible(true);

        kanantengahaccessory2.add(kanantengahaccessoryitem5);
        kanantengahaccessoryitem5.revalidate();
        kanantengahaccessoryitem5.repaint();
        kanantengahaccessoryitem5.setVisible(true);

        kanantengahaccessoryitem5.add(accessoryiconitem5);
        accessoryiconitem5.revalidate();
        accessoryiconitem5.repaint();
        accessoryiconitem5.setVisible(true);

        kanantengahaccessoryitem5.add(accessoryicondesc5);
        accessoryicondesc5.revalidate();
        accessoryicondesc5.repaint();
        accessoryicondesc5.setVisible(true);
        //end
        //kananbawahstart

        kanan.add(kananbawah,BorderLayout.SOUTH);
        kananbawah.revalidate();
        kananbawah.repaint();
        kananbawah.setVisible(true);

        currgoldbg.add(Currgold);
        currgoldbg.revalidate();
        currgoldbg.repaint();
        currgoldbg.setVisible(true);

        kananbawah.add(CurrentPage);
        CurrentPage.revalidate();
        CurrentPage.repaint();
        CurrentPage.setVisible(true);

        kananbawah.add(Prev);
        Prev.revalidate();
        Prev.repaint();
        Prev.setVisible(true);

        kananbawah.add(Next);
        Next.revalidate();
        Next.repaint();
        Next.setVisible(true);


        //init
        kanan.add(kanantengahhead,BorderLayout.CENTER);
        kanantengahhead.revalidate();
        kanantengahhead.repaint();
        kanantengahhead.setVisible(true);

        kanantengahhead.add(kanantengahheaditem1);
        kanantengahheaditem1.revalidate();
        kanantengahheaditem1.repaint();
        kanantengahheaditem1.setVisible(true);

        kanantengahheaditem1.add(headiconitem1);
        headiconitem1.revalidate();
        headiconitem1.repaint();
        headiconitem1.setVisible(true);

        kanantengahheaditem1.add(headicondesc1);
        headicondesc1.revalidate();
        headicondesc1.repaint();
        headicondesc1.setVisible(true);

        kanantengahhead.add(kanantengahheaditem2);
        kanantengahheaditem2.revalidate();
        kanantengahheaditem2.repaint();
        kanantengahheaditem2.setVisible(true);

        kanantengahheaditem2.add(headiconitem2);
        headiconitem2.revalidate();
        headiconitem2.repaint();
        headiconitem2.setVisible(true);

        kanantengahheaditem2.add(headicondesc2);
        headicondesc2.revalidate();
        headicondesc2.repaint();
        headicondesc2.setVisible(true);

        kanantengahhead.add(kanantengahheaditem3);
        kanantengahheaditem3.revalidate();
        kanantengahheaditem3.repaint();
        kanantengahheaditem3.setVisible(true);

        kanantengahheaditem3.add(headiconitem3);
        headiconitem3.revalidate();
        headiconitem3.repaint();
        headiconitem3.setVisible(true);

        kanantengahheaditem3.add(headicondesc3);
        headicondesc3.revalidate();
        headicondesc3.repaint();
        headicondesc3.setVisible(true);

    }
}
