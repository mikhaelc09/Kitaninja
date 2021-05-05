package istts.pbo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Splash extends JFrame {
    private JPanel p;
    private Timer t = new Timer(10, null);
    private int ctr = 0;

    public Splash() {
        init();

        ImageIcon logo = new ImageIcon("src/istts/pbo/res/logo.png");
        ImageIcon anim = new ImageIcon("src/istts/pbo/res/anim.gif");

        JLabel lbIcon = new JLabel();
        lbIcon.setIcon(logo);
        lbIcon.setBounds(140,50, 300,300);

        JLabel lbLoad = new JLabel("Loading");
        lbLoad.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 25));
        lbLoad.setForeground(Color.black);
        lbLoad.setBounds(370,350,160,30);

        JLabel lbAnim = new JLabel();
        lbAnim.setIcon(anim);
        lbAnim.setBounds(530,330,50,50);

        t.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(ctr%4 == 0){
                    lbLoad.setText("Loading");
                }
                if(ctr%4 == 1){
                    lbLoad.setText("Loading.");
                }
                if(ctr%4 == 2){
                    lbLoad.setText("Loading..");
                }
                if(ctr%4 == 3){
                    lbLoad.setText("Loading...");
                }
                ctr++;
                if(ctr==40){
                    startApp();
                }
            }
        });

        p.add(lbLoad);
        p.add(lbIcon);
        p.add(lbAnim);
        add(p);
        setContentPane(p);
        t.start();
    }

    private void init(){
        setSize(new Dimension(600,400));
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setUndecorated(true);
        setVisible(true);

        p = new JPanel();
        p.setBounds(0,0,600,400);
        p.setSize(new Dimension(600,400));
        p.setLayout(null);
        p.setBackground(new Color(235, 222, 52));
    }

    private void startApp(){
        this.dispose();
        new StartPage();
    }

}
