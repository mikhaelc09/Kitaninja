package istts.pbo;

import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class musicPlayer2 extends JFrame implements LineListener, ChangeListener, Runnable {
    boolean playCompleted2= false;
    JLabel current2;
    JSlider slider2;
    FloatControl aud2;
    Clip clip2;
    float range2;
    JPanel p2;


    public musicPlayer2() {
        setLocationRelativeTo(null);
        setLayout(null);
        setUndecorated(true);
        setSize(new Dimension(300, 200));
        setVisible(false);

        p2 = new JPanel();
        p2.setBounds(0, 0, 400, 400);
        p2.setBackground(new Color(255, 222, 70));
        p2.setLayout(null);

        JLabel lbTitle = new JLabel("Volume");
        lbTitle.setFont(new Font("Arial", Font.BOLD, 25));
        lbTitle.setBounds(25, 50, 200, 50);

        slider2 = new JSlider(JSlider.HORIZONTAL, 0, 100, 100);
        slider2.setBounds(25, 100, 200, 50);
        slider2.setBackground(new Color(255, 222, 70));
        slider2.setPaintTrack(true);
        slider2.setPaintTicks(true);
        slider2.setMinorTickSpacing(10);
        slider2.setMajorTickSpacing(50);
        slider2.setFont(new Font("Arial", Font.BOLD, 25));
        slider2.addChangeListener(this);

        current2 = new JLabel();
        current2.setText(slider2.getValue() + "");
        current2.setFont(new Font("Arial", Font.BOLD, 25));
        current2.setBounds(240, 100, 50, 40);

        p2.add(lbTitle);
        p2.add(slider2);
        p2.add(current2);
        add(p2);
        setContentPane(p2);

        File a = new File("src/istts/pbo/res/audio/Soundtrack/Peta.wav");
        try {
            AudioInputStream stream = AudioSystem.getAudioInputStream(a);
            AudioFormat format = stream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            clip2 = (Clip) AudioSystem.getLine(info);
            clip2.addLineListener(this);
            clip2.open(stream);
            aud2 = (FloatControl) clip2.getControl(FloatControl.Type.MASTER_GAIN);
            range2 = -5 - aud2.getMinimum();
            aud2.setValue(-5);
            clip2.loop(2);

        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(LineEvent event) {
        LineEvent.Type type = event.getType();

    }

    @Override
    public void stateChanged(ChangeEvent e) {
        current2.setText(slider2.getValue() + "");
        float gain = (float) (aud2.getMinimum() + (slider2.getValue() * 1.0 / 100 * range2));
        aud2.setValue(gain);
    }

    @Override
    public void run() {
        clip2.start();
        while (!playCompleted2) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        clip2.close();
    }

    public Clip getClip() {
        return clip2;
    }

    public JPanel getP() {
        return p2;
    }

    ;
}
