package istts.pbo.LandingPage;

import istts.pbo.System.CustomExitConfirm;
import istts.pbo.System.CustomTitlebar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static istts.pbo.Main.*;


public class StartPage extends JFrame {
    MenuPanel menu;
    CreationPanel create;
    CustomTitlebar title;
    CustomExitConfirm exitConfirm;
    private int cx, cy;

    public StartPage() {
       init();
        exitConfirm = new CustomExitConfirm();

       menu.lbNewGame.addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent e) {
               super.mouseClicked(e);
               menu.setVisible(false);
               create.setVisible(true);
           }
       });

       create.back.addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent e) {
               super.mouseClicked(e);
               menu.setVisible(true);
               create.setVisible(false);
           }
       });

       menu.lbExit.addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent e) {
               super.mouseClicked(e);
               exitConfirm.setVisible(true);
           }
       });

       exitConfirm.getLbYes().addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent e) {
               exit();
           }
       });

       exitConfirm.getLbNo().addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent e) {
               exitConfirm.setVisible(false);
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

        menu = new MenuPanel();
        menu.setBounds(0,40,this.getWidth(),this.getHeight());

        create = new CreationPanel();
        create.setBounds(0,40,this.getWidth(),this.getHeight());
        create.setVisible(false);

        title = new CustomTitlebar();
        title.setBounds(0,0,getWidth(),40);

        parent.add(create);
        parent.add(menu);
        parent.add(title);

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

    private void exit(){
        System.exit(0);
    }

    private void topMousePressed(MouseEvent e){
        cx = e.getX();
        cy = e.getY();
    }

    private void topMouseDragged(MouseEvent e){
        this.setLocation(e.getXOnScreen()-cx, e.getYOnScreen()-cy);
    }

    private void cancelExit(CustomExitConfirm c){
        c.dispose();
    }

}
