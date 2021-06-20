package istts.pbo.GamePage;

import istts.pbo.Players.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class EquipSelection extends JFrame {
    Player p;
    int tipe;
    JLabel jitemBack;
    ArrayList<JLabel> jitem = new ArrayList<>();
    ArrayList<Item> item = new ArrayList<>();
    JLabel close;
    public EquipSelection(Player p, int tipe, JLabel gambar, JLabel stat, JLabel nama){
        this.p = p;
        this.tipe=tipe;
        init(gambar,stat,nama);
    }

    public void init(JLabel gambar, JLabel stat, JLabel nama){
        setLocation(630,150);
        setLayout(null);
        setResizable(false);
        setUndecorated(true);
        setVisible(true);
        setSize(680,720);

        close = new JLabel("X");
        close.setCursor(new Cursor(Cursor.HAND_CURSOR));
        close.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                exit();
            }
        });
        close.setBounds(635,3,50,50);
        close.setFont(new Font("Ninja Naruto",Font.BOLD,50));
        add(close);

        jitemBack = new JLabel();
        jitemBack.setHorizontalAlignment(SwingConstants.CENTER);
        jitemBack.setVerticalAlignment(SwingConstants.NORTH);
        jitemBack.setBackground(Color.blue);
        jitemBack.setOpaque(true);
        jitemBack.setBounds(0, 0, 680, 720);
        add(jitemBack);

        int N=0;
        for (int i = 0; i < 25; i++) {
            jitem.add(new JLabel());
        }

        jitem.get(0).setBounds(15, 60, 120, 120);
        jitem.get(1).setBounds(145, 60, 120, 120);
        jitem.get(2).setBounds(275, 60, 120, 120);
        jitem.get(3).setBounds(405, 60, 120, 120);
        jitem.get(4).setBounds(535, 60, 120, 120);

        jitem.get(5).setBounds(15, 190, 120, 120);
        jitem.get(6).setBounds(145, 190, 120, 120);
        jitem.get(7).setBounds(275, 190, 120, 120);
        jitem.get(8).setBounds(405, 190, 120, 120);
        jitem.get(9).setBounds(535, 190, 120, 120);

        jitem.get(10).setBounds(15, 320, 120, 120);
        jitem.get(11).setBounds(145, 320, 120, 120);
        jitem.get(12).setBounds(275, 320, 120, 120);
        jitem.get(13).setBounds(405, 320, 120, 120);
        jitem.get(14).setBounds(535, 320, 120, 120);

        jitem.get(15).setBounds(15, 450, 120, 120);
        jitem.get(16).setBounds(145, 450, 120, 120);
        jitem.get(17).setBounds(275, 450, 120, 120);
        jitem.get(18).setBounds(405, 450, 120, 120);
        jitem.get(19).setBounds(535, 450, 120, 120);

        jitem.get(20).setBounds(15, 580, 120, 120);
        jitem.get(21).setBounds(145, 580, 120, 120);
        jitem.get(22).setBounds(275, 580, 120, 120);
        jitem.get(23).setBounds(405, 580, 120, 120);
        jitem.get(24).setBounds(535, 580, 120, 120);

        for (int i = 0; i < 25; i++) {
            if (tipe==1){
                if (p.getItems().get(i) instanceof Helmet){
                    item.add(p.getItems().get(i));
                    N++;
                }
            }else if (tipe==2){
                if (p.getItems().get(i) instanceof Weapon){
                    item.add(p.getItems().get(i));
                    N++;
                }
            }else if (tipe==3){
                if (p.getItems().get(i) instanceof Body){
                    item.add(p.getItems().get(i));
                    N++;
                }
            }else if (tipe==4){
                if (p.getItems().get(i) instanceof Boots){
                    item.add(p.getItems().get(i));
                    N++;
                }
            }else if (tipe==5){
                if (p.getItems().get(i) instanceof Accesories){
                    item.add(p.getItems().get(i));
                    N++;
                }
            }
        }
        for (int i = N; i < 25; i++) {
            item.add(new Weapon("-",0,0,"src/istts/pbo/res/Item/Blank.png",0));
        }
        for (int i = 0; i < 25; i++) {
            jitem.get(i).setIcon(new ImageIcon(item.get(i).getSpritePath()));
            if (i<N){
                jitem.get(i).setCursor(new Cursor(Cursor.HAND_CURSOR));
                int a=i;
                jitem.get(i).addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (tipe==1){
                            p.getStats().setHealth(p.getStats().getHealth()-p.getEquipment().getHead().getStat());
                            p.getEquipment().setHead((Helmet) item.get(a));
                            p.getStats().setHealth(p.getStats().getHealth()+p.getEquipment().getHead().getStat());
                            gambar.setIcon(im.getSIcon(p.getEquipment().getHead().getSpritePath()));
                            stat.setText("Hp : "+p.getStats().getHealth());
                            nama.setText(p.getEquipment().getHead().getName());
                        }else if (tipe==2){
                            p.getStats().setAttack(p.getStats().getAttack()-p.getEquipment().getWeapon().getStat());
                            p.getEquipment().setWeapon((Weapon) item.get(a));
                            p.getStats().setAttack(p.getStats().getAttack()+p.getEquipment().getWeapon().getStat());
                            gambar.setIcon(im.getSIcon(p.getEquipment().getWeapon().getSpritePath()));
                            stat.setText("Attack : "+p.getStats().getAttack());
                            nama.setText(p.getEquipment().getWeapon().getName());
                        }else if (tipe==3){
                            p.getStats().setDefense(p.getStats().getDefense()-p.getEquipment().getBody().getStat());
                            p.getEquipment().setBody((Body) item.get(a));
                            p.getStats().setDefense(p.getStats().getDefense()+p.getEquipment().getBody().getStat());
                            gambar.setIcon(im.getSIcon(p.getEquipment().getBody().getSpritePath()));
                            stat.setText("Defense : "+p.getStats().getDefense());
                            nama.setText(p.getEquipment().getBody().getName());
                        }else if (tipe==4){
                            p.getStats().setSpeed(p.getStats().getSpeed()-p.getEquipment().getBoots().getStat());
                            p.getEquipment().setBoots((Boots) item.get(a));
                            p.getStats().setSpeed(p.getStats().getSpeed()+p.getEquipment().getBoots().getStat());
                            gambar.setIcon(im.getSIcon(p.getEquipment().getBoots().getSpritePath()));
                            stat.setText("Speed : "+p.getStats().getSpeed());
                            nama.setText(p.getEquipment().getBoots().getName());
                        }else if (tipe==5){
                            p.getStats().setMana(p.getStats().getMana()-p.getEquipment().getAccesories().getStat());
                            p.getEquipment().setAccesories((Accesories) item.get(a));
                            p.getStats().setMana(p.getStats().getMana()+p.getEquipment().getAccesories().getStat());
                            gambar.setIcon(im.getSIcon(p.getEquipment().getAccesories().getSpritePath()));
                            stat.setText("Mana : "+p.getStats().getMana());
                            nama.setText(p.getEquipment().getAccesories().getName());
                        }
                        dispose();
                    }
                });
            }
            jitemBack.add(jitem.get(i));
        }
    }

    public void exit(){
        dispose();
    }
}
