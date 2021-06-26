package istts.pbo.LandingPage;

import istts.pbo.Classes.Ninjutsu;
import istts.pbo.Classes.Qiqong;
import istts.pbo.Classes.Taijutsu;
import istts.pbo.GamePage.TownPage;
import istts.pbo.Players.Player;
import istts.pbo.System.CustomExitConfirm;
import istts.pbo.System.CustomTitlebar;
import istts.pbo.musicPlayer;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.io.*;
import java.net.URL;
import java.net.MalformedURLException;
import static istts.pbo.Main.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.event.*;
import java.util.ArrayList;


public class StartPage extends JFrame{
    ArrayList<Player> saveset;
    MenuPanel menu;
    CreationPanel create;
    LoadPanel load;
    CustomTitlebar title;
    CustomExitConfirm exitConfirm;
    musicPlayer music;
    ChooseData choose;
    private int cx, cy;
    private Clip clipNameClip;
    private AudioInputStream clipNameAIS;
    private int selected = -1;

    /*URL soundbyte = new File("src/istts/pbo/res/audio/sfx/yooooooooooo (3).wav").toURI().toURL();
        java.applet.AudioClip clip = java.applet.Applet.newAudioClip(soundbyte);*/

    public StartPage() {
        saveset = new ArrayList<>();
        updateSaves();
//        initFiles();
       init();
       exitConfirm = new CustomExitConfirm();
       music = new musicPlayer();

       menu.lbNewGame.addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent e) {
               super.mouseClicked(e);
               menu.setVisible(false);
               choose.setVisible(true);
               String soundName = "src/istts/pbo/res/audio/sfx/yooooooooooo (3).wav";
               AudioInputStream audioInputStream = null;
               try {
                   audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
               } catch (UnsupportedAudioFileException unsupportedAudioFileException) {
                   unsupportedAudioFileException.printStackTrace();
               } catch (IOException ioException) {
                   ioException.printStackTrace();
               }
               Clip clip = null;
               try {
                   clip = AudioSystem.getClip();
               } catch (LineUnavailableException lineUnavailableException) {
                   lineUnavailableException.printStackTrace();
               }
               try {
                   clip.open(audioInputStream);
               } catch (LineUnavailableException lineUnavailableException) {
                   lineUnavailableException.printStackTrace();
               } catch (IOException ioException) {
                   ioException.printStackTrace();
               }
               clip.start();
           }

       });

       menu.lbLoadGame.addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent e) {
               super.mouseClicked(e);
               menu.setVisible(false);
               load.setVisible(true);
               String soundName = "src/istts/pbo/res/audio/sfx/yooooooooooo (3).wav";
               AudioInputStream audioInputStream = null;
               try {
                   audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
               } catch (UnsupportedAudioFileException unsupportedAudioFileException) {
                   unsupportedAudioFileException.printStackTrace();
               } catch (IOException ioException) {
                   ioException.printStackTrace();
               }
               Clip clip = null;
               try {
                   clip = AudioSystem.getClip();
               } catch (LineUnavailableException lineUnavailableException) {
                   lineUnavailableException.printStackTrace();
               }
               try {
                   clip.open(audioInputStream);
               } catch (LineUnavailableException lineUnavailableException) {
                   lineUnavailableException.printStackTrace();
               } catch (IOException ioException) {
                   ioException.printStackTrace();
               }
               clip.start();
           }
       });


        for (int i = 0; i < 3; i++) {
            int index = i;
            choose.kotakLoad[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    choose.setVisible(false);
                    create.setVisible(true);
                    selected = index;
                }
            });
            choose.sprite[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    create.setVisible(true);
                    choose.setVisible(false);
                    selected = index;
                }
            });
            choose.nama[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    create.setVisible(true);
                    choose.setVisible(false);
                    selected = index;
                }
            });
            if(!saveset.get(i).getName().equalsIgnoreCase("Blank")) {
                load.kotakLoad[i].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        super.mouseClicked(e);
                        selected = index;
                        confirmCreate(saveset.get(index));
                    }
                });
                load.sprite[i].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        super.mouseClicked(e);
                        selected = index;
                        confirmCreate(saveset.get(index));
                    }
                });
                load.nama[i].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        super.mouseClicked(e);
                        selected = index;
                        confirmCreate(saveset.get(index));
                    }
                });
            }
        }

       create.back.addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent e) {
               super.mouseClicked(e);
               menu.setVisible(true);
               create.setVisible(false);
           }
       });

       create.tombolok.addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent e) {
               super.mouseClicked(e);
               Player player=null;
               if(create.nama.getText().length()>0) {
                   if (create.classPicked==1){
                       player = new Player(create.getNama(),new Taijutsu());
                   }else if (create.classPicked==2){
                       player = new Player(create.getNama(),new Ninjutsu());
                   }else if (create.classPicked==3){
                       player = new Player(create.getNama(),new Qiqong());
                   }
                   confirmCreate(player);
                   music.getClip().stop();
               }
           }
       });

       menu.lbLoadGame.addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent e) {
               menu.setVisible(false);
               load.setVisible(true);
           }
       });

       load.back.addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent e) {
               menu.setVisible(true);
               load.setVisible(false);
           }
       });

       choose.back.addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent e) {
               menu.setVisible(true);
               choose.setVisible(false);
           }
       });

       menu.lbClearData.addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent e) {
               super.mouseClicked(e);
               String[] opt = new String[]{"No","Yes"};
               int conf = JOptionPane.showOptionDialog(null,
                       "Are you sure you want to clear data? (The data will be cleared after you close the game)",
                       "Clear Data",
                       JOptionPane.YES_NO_OPTION,
                       JOptionPane.WARNING_MESSAGE,
                       null,
                       opt,
                       opt[0]);
               if(conf == 1){
                   initFiles();
                   saveset = new ArrayList<>();
                   updateSaves();
                   load.initState();
                   choose.initState();
                   JOptionPane.showMessageDialog(null,"Data Cleared!");
               }
           }
       });

       menu.lbExit.addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent e) {
               super.mouseClicked(e);
               exitConfirm.setVisible(true);
               String soundName = "src/istts/pbo/res/audio/sfx/yooooooooooo (3).wav";
               AudioInputStream audioInputStream = null;
               try {
                   audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
               } catch (UnsupportedAudioFileException unsupportedAudioFileException) {
                   unsupportedAudioFileException.printStackTrace();
               } catch (IOException ioException) {
                   ioException.printStackTrace();
               }
               Clip clip = null;
               try {
                   clip = AudioSystem.getClip();
               } catch (LineUnavailableException lineUnavailableException) {
                   lineUnavailableException.printStackTrace();
               }
               try {
                   clip.open(audioInputStream);
               } catch (LineUnavailableException lineUnavailableException) {
                   lineUnavailableException.printStackTrace();
               } catch (IOException ioException) {
                   ioException.printStackTrace();
               }
               clip.start();
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

       menu.lbSetting.addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent e) {
               music.setVisible(true);
           }
       });

       music.getP().addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent e) {
               music.setVisible(false);
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
        setTitle("KitaNinja");

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

        choose = new ChooseData(saveset);
        choose.setBounds(0,40,this.getWidth(),this.getHeight());
        choose.setVisible(false);

        load = new LoadPanel(saveset);
        load.setBounds(0,40,this.getWidth(),this.getHeight());
        load.setVisible(false);

        title = new CustomTitlebar();
        title.setBounds(0,0,getWidth(),40);

        parent.add(create);
        parent.add(menu);
        parent.add(title);
        parent.add(load);
        parent.add(choose);

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

    private void confirmCreate(Player player){
        this.dispose();
        new TownPage(player, selected);
    }

    private void initFiles(){
        for (int i = 0; i < 3; i++) {
            String filename = (i+1)+".ser";
            try {
                FileOutputStream f = new FileOutputStream("src/istts/pbo/System/saves/"+filename);
                ObjectOutputStream o = new ObjectOutputStream(f);
                o.writeObject(new Player());
                o.close(); f.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            saveset.add(new Player());
        }
    }

    private void updateSaves(){
        for (int i = 0; i < 3; i++) {
            try {
                String filename = (i+1)+".ser";
                FileInputStream f = new FileInputStream("src/istts/pbo/System/saves/"+filename);
                ObjectInputStream o = new ObjectInputStream(f);
                saveset.add((Player) o.readObject());
                o.close();
                f.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
