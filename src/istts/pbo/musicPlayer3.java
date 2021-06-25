package istts.pbo;

import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class musicPlayer3 extends JFrame implements LineListener, ChangeListener, Runnable {
    boolean playCompleted3= false;
    JLabel current3;
    JSlider slider3;
    FloatControl aud3;
    Clip clip3;
    float range3;
    JPanel p3;


    public musicPlayer3() {
        setLocationRelativeTo(null);
        setLayout(null);
        setUndecorated(true);
        setSize(new Dimension(300, 200));
        setVisible(false);

        p3 = new JPanel();
        p3.setBounds(0, 0, 400, 400);
        p3.setBackground(new Color(255, 222, 70));
        p3.setLayout(null);

        JLabel lbTitle = new JLabel("Volume");
        lbTitle.setFont(new Font("Arial", Font.BOLD, 25));
        lbTitle.setBounds(25, 50, 200, 50);

        slider3 = new JSlider(JSlider.HORIZONTAL, 0, 100, 100);
        slider3.setBounds(25, 100, 200, 50);
        slider3.setBackground(new Color(255, 222, 70));
        slider3.setPaintTrack(true);
        slider3.setPaintTicks(true);
        slider3.setMinorTickSpacing(10);
        slider3.setMajorTickSpacing(50);
        slider3.setFont(new Font("Arial", Font.BOLD, 25));
        slider3.addChangeListener(this);

        current3 = new JLabel();
        current3.setText(slider3.getValue() + "");
        current3.setFont(new Font("Arial", Font.BOLD, 25));
        current3.setBounds(240, 100, 50, 40);

        p3.add(lbTitle);
        p3.add(slider3);
        p3.add(current3);
        add(p3);
        setContentPane(p3);

        File a = new File("src/istts/pbo/res/audio/Soundtrack/BattleBGM.wav");
        try {
            AudioInputStream stream = AudioSystem.getAudioInputStream(a);
            AudioFormat format = stream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            clip3 = (Clip) AudioSystem.getLine(info);
            clip3.addLineListener(this);
            clip3.open(stream);
            aud3 = (FloatControl) clip3.getControl(FloatControl.Type.MASTER_GAIN);
            range3 = -5 - aud3.getMinimum();
            aud3.setValue(-5);
            clip3.loop(2);

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
        current3.setText(slider3.getValue() + "");
        float gain = (float) (aud3.getMinimum() + (slider3.getValue() * 1.0 / 100 * range3));
        aud3.setValue(gain);
    }

    @Override
    public void run() {
        clip3.start();
        while (!playCompleted3) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        clip3.close();
    }

    public Clip getClip() {
        return clip3;
    }

    public JPanel getP() {
        return p3;
    }

    ;
}
