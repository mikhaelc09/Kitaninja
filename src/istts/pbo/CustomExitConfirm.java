package istts.pbo;

import javax.swing.*;
import java.awt.*;

public class CustomExitConfirm extends JFrame {
    private JPanel p;
    private JLabel lbYes;
    private JLabel lbNo;

    public CustomExitConfirm() {
        init();

    }

    private void init(){
        setSize(400,300);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setUndecorated(true);
        setVisible(true);

        p = new JPanel();
        p.setBounds(0,0,400,300);
        p.setLayout(null);
        p.setBackground(new Color(255,222,70));

        Font f = new Font("Arial", Font.BOLD, 40);
        FontMetrics fm = getFontMetrics(f);

        JLabel lbQuestion = new JLabel("Are you sure you want to Exit?");
        lbQuestion.setFont(new Font("Arial", Font.BOLD,25));
        FontMetrics m = getFontMetrics(lbQuestion.getFont());
        lbQuestion.setBounds((400-m.stringWidth(lbQuestion.getText()))/2,50,m.stringWidth(lbQuestion.getText()),40);

        lbYes = new JLabel("Yes");
        lbYes.setBackground(new Color(160,150,30));
        lbYes.setOpaque(true);
        lbYes.setBounds(80,200,80,50);
        lbYes.setFont(f);

        lbNo = new JLabel(" No");
        lbNo.setBackground(new Color(160,150,30));
        lbNo.setOpaque(true);
        lbNo.setBounds(250,200,80,50);
        lbNo.setFont(f);

        p.add(lbQuestion);
        p.add(lbYes);
        p.add(lbNo);
        add(p);
    }
}
