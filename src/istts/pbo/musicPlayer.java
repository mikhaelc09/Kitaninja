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
    public musicPlayer() {
        setLocation(1200,700);
        setLayout(null);
        setUndecorated(true);
        setSize(new Dimension(300,200));
        setVisible(false);

        JPanel p = new JPanel();
        p.setBounds(0,0,400,400);
        p.setBackground(new Color(255,222,70));
        p.setLayout(null);

        JLabel lbTitle = new JLabel("Volume");
        lbTitle.setFont(new Font("Arial", Font.BOLD,25));
        lbTitle.setBounds(25,50,200,50);

        slider = new JSlider(JSlider.HORIZONTAL, 0,100,100);
        slider.setBounds(25,100,200, 50);
        slider.setBackground(new Color(255,222,70));
        slider.setPaintTrack(true);
        slider.setPaintTicks(true);
        slider.setMinorTickSpacing(10);
        slider.setMajorTickSpacing(50);
        slider.setFont(new Font("Arial", Font.BOLD, 25));
        slider.addChangeListener(this);

        current = new JLabel();
        current.setText(slider.getValue() + "");
        current.setFont(new Font("Arial", Font.BOLD, 25));
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
            System.out.println(aud.getMinimum()+" - "+aud.getMaximum()+" -> "+range );
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

            if(type == LineEvent.Type.START){
                System.out.println("Start Playback");
            }
            else if(type == LineEvent.Type.STOP){
//            playCompleted = true;
                System.out.println("Playback Complete");
            }
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
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        clip.close();
    }

    public Clip getClip(){
        return clip;
    }
}
