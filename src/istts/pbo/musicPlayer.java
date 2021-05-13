package istts.pbo;

import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class musicPlayer extends JFrame implements LineListener, ChangeListener, Runnable {
    boolean playCompleted = false;
    JLabel current;
    JSlider slider;
    FloatControl aud;
    Clip clip;
    float range;
    JPanel p;
    public musicPlayer() {
        setLocationRelativeTo(null);
        setLayout(null);
        setUndecorated(true);
        setSize(new Dimension(300,200));
        setVisible(false);

        p = new JPanel();
        p.setBounds(0,0,400,400);
        p.setBackground(new Color(255,222,70));
        p.setLayout(null);

        JLabel lbTitle = new JLabel("Volume");
        lbTitle.setFont(new Font("Ninja Naruto", Font.PLAIN,25));
        lbTitle.setBounds(25,50,200,50);

        slider = new JSlider(JSlider.HORIZONTAL, 0,100,100);
        slider.setBounds(25,100,200, 50);
        slider.setBackground(new Color(255,222,70));
        slider.setPaintTrack(true);
        slider.setPaintTicks(true);
        slider.setMinorTickSpacing(10);
        slider.setMajorTickSpacing(50);
        slider.setFont(new Font("Ninja Naruto", Font.PLAIN, 25));
        slider.addChangeListener(this);

        current = new JLabel();
        current.setText(slider.getValue() + "");
        current.setFont(new Font("Ninja Naruto", Font.PLAIN, 20));
        current.setBounds(240, 100, 50, 40);

        p.add(lbTitle);
        p.add(slider);
        p.add(current);
        add(p);
        setContentPane(p);

        File f = new File("src/istts/pbo/res/audio/Soundtrack/MainMenuTheme.wav");
        try{
            AudioInputStream stream = AudioSystem.getAudioInputStream(f);
            AudioFormat format =  stream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class,format);
            clip = (Clip) AudioSystem.getLine(info);
            clip.addLineListener(this);
            clip.open(stream);
            aud = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            range = -5 - aud.getMinimum();
            aud.setValue(-5);
            clip.loop(2);

        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
    }
        @Override
        public void update (LineEvent event){
            LineEvent.Type type = event.getType();
        }

        @Override
        public void stateChanged (ChangeEvent e){
            current.setText(slider.getValue()+"");
            float gain =(float)(aud.getMinimum() + (slider.getValue()*1.0/100*range));
            aud.setValue(gain);
        }

    @Override
    public void run() {
        clip.start();
        while(!playCompleted){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        clip.close();
    }

    public Clip getClip(){
        return clip;
    }

    public JPanel getP(){return p;};
}
