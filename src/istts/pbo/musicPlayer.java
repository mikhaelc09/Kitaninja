package istts.pbo;

import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class musicPlayer extends JFrame implements LineListener, ChangeListener {
    boolean playCompleted = false;
    JLabel current;
    JSlider vol;
    FloatControl aud;
    float range;
    public musicPlayer() {
        setVisible(true);
        setSize(500, 300);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        vol = new JSlider(JSlider.HORIZONTAL, 0, 100, 100);
        vol.setBounds(50, 50, 350, 100);
        vol.setPaintTicks(true);
        vol.setPaintTrack(true);
        vol.setMinorTickSpacing(5);
        vol.setMajorTickSpacing(10);
        vol.setFont(new Font("Arial", Font.PLAIN, 10));
        vol.addChangeListener(this);
        add(vol);

        current = new JLabel();
        current.setText(vol.getValue() + "");
        current.setBounds(10, 10, 100, 100);
        add(current);
        File f = new File("src/istts/pbo/res/audio/Soundtrack/MainMenuTheme.wav");
        try{
            AudioInputStream stream = AudioSystem.getAudioInputStream(f);
            AudioFormat format =  stream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class,format);
            Clip clip = (Clip) AudioSystem.getLine(info);
            clip.addLineListener(this);
            clip.open(stream);
            aud = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            range =aud.getMaximum() - aud.getMinimum();
            clip.loop(2);
            clip.start();
            while(!playCompleted){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            clip.close();
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
            current.setText(vol.getValue()+"");
            float gain =(float)(aud.getMinimum() + (vol.getValue()*1.0/100*range));
            aud.setValue(gain);
        }

}
