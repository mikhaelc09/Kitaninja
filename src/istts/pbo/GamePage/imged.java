package istts.pbo.GamePage;

import javax.swing.*;
import java.awt.*;

public class imged {
    public static ImageIcon resizeIcon(String im , int w, int h){
        return new ImageIcon(new ImageIcon(im).getImage().getScaledInstance(w,h, Image.SCALE_DEFAULT));
    }

    public static ImageIcon resizeIcon(ImageIcon im , int w, int h){
        return new ImageIcon(im.getImage().getScaledInstance(w,h,Image.SCALE_DEFAULT));
    }

    public static ImageIcon grayscaleIcon(String im){
        return new ImageIcon(GrayFilter.createDisabledImage(new ImageIcon(im).getImage()));
    }

    public static ImageIcon grayscaleIcon(ImageIcon im){
        return new ImageIcon(GrayFilter.createDisabledImage(im.getImage()));
    }
}
