package istts.pbo.GamePage;

import istts.pbo.LandingPage.StartPage;
import istts.pbo.Players.Player;
import istts.pbo.System.CustomTitlebar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static istts.pbo.Main.SHEIGHT;
import static istts.pbo.Main.SWIDTH;

public class TownPage extends JFrame {
    private int cx, cy;
    CustomTitlebar title;
    TownPanel town;
    Player player;
    ProfilePage profil;
    SkillPage skillpage;
    public TownPage(Player player){
        this.player = player;
        init();

        town.back.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                backMainMenu();
            }
        });

        town.profil.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                profil.setVisible(true);
                town.setVisible(false);
            }
        });

        town.lbDojo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                skillpage.setVisible(true);
                town.setVisible(false);
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

        title = new CustomTitlebar();
        title.setBounds(0,0,getWidth(),40);

        town = new TownPanel(player);
        profil = new ProfilePage();
        skillpage = new SkillPage();


        town.setBounds(0,40,this.getWidth(),this.getHeight());
        profil.setBounds(0,40,this.getWidth(),this.getHeight());
        skillpage.setBounds(0,40,this.getWidth(),this.getHeight());

        parent.add(title);
        parent.add(town);
        parent.add(profil);
        parent.add(skillpage);
        profil.setVisible(false);

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

    private void backMainMenu(){
        this.dispose();
        new StartPage();
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

}
