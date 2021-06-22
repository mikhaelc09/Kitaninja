package istts.pbo.GamePage;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class im {
    public static int SIZE_L = 120;
    public static int SIZE_M = 100;
    public static int SIZE_S = 80;
    public static int SIZE_XS = 55;

    public static ImageIcon resizeIcon(String im , int w, int h){
        return new ImageIcon(new ImageIcon(im).getImage().getScaledInstance(w,h, Image.SCALE_DEFAULT));
    }

    public static ImageIcon resizeIcon(ImageIcon im , int w, int h){
        return new ImageIcon(im.getImage().getScaledInstance(w,h,Image.SCALE_DEFAULT));
    }

    public static ImageIcon getLIcon(ImageIcon im){
        return resizeIcon(im, SIZE_L, SIZE_L);
    }

    public static ImageIcon getLIcon(String im){
        return resizeIcon(im, SIZE_L, SIZE_L);
    }

    public static ImageIcon getMIcon(ImageIcon im){
        return resizeIcon(im, SIZE_M, SIZE_M);
    }

    public static ImageIcon getMIcon(String im){
        return resizeIcon(im, SIZE_M, SIZE_M);
    }

    public static ImageIcon getSIcon(ImageIcon im){
        return resizeIcon(im, SIZE_S, SIZE_S);
    }

    public static ImageIcon getSIcon(String im){
        return resizeIcon(im, SIZE_S, SIZE_S);
    }

    public static ImageIcon getXSIcon(ImageIcon im){
        return resizeIcon(im, SIZE_XS, SIZE_XS);
    }

    public static ImageIcon getXSIcon(String im){
        return resizeIcon(im, SIZE_XS, SIZE_XS);
    }

    public static ImageIcon grayscaleIcon(String im){
        return new ImageIcon(GrayFilter.createDisabledImage(new ImageIcon(im).getImage()));
    }

    public static ImageIcon grayscaleIcon(ImageIcon im){
        return new ImageIcon(GrayFilter.createDisabledImage(im.getImage()));
    }
    public static ImageIcon colorFillGreen(String path){
        BufferedImage img;
        try {
            img = ImageIO.read(new File("src/istts/pbo/res/PlayerEnemy.png"));
            for (int i = 0; i < img.getWidth(); i++) {
                for (int j = 0; j < img.getHeight(); j++) {
                    Color c = new Color(img.getRGB(j,i),true);
                    if(c.getAlpha()>0) {
//                        System.out.println(c + "-" + c.getAlpha());
                        img.setRGB(j,i,new Color(0,255,0).getRGB());
                    }
                }
            }
            return new ImageIcon(img);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ImageIcon colorFillBlue(String path){
        BufferedImage img;
        try {
            img = ImageIO.read(new File("src/istts/pbo/res/PlayerEnemy.png"));
            for (int i = 0; i < img.getWidth(); i++) {
                for (int j = 0; j < img.getHeight(); j++) {
                    Color c = new Color(img.getRGB(j,i),true);
                    if(c.getAlpha()>0) {
//                        System.out.println(c + "-" + c.getAlpha());
                        img.setRGB(j,i,new Color(0,0,255).getRGB());
                    }
                }
            }
            return new ImageIcon(img);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ImageIcon colorFillRed(String path){
        BufferedImage img;
        try {
            img = ImageIO.read(new File("src/istts/pbo/res/PlayerEnemy.png"));
            for (int i = 0; i < img.getWidth(); i++) {
                for (int j = 0; j < img.getHeight(); j++) {
                    Color c = new Color(img.getRGB(j,i),true);
                    if(c.getAlpha()>0) {
//                        System.out.println(c + "-" + c.getAlpha());
                        img.setRGB(j,i,new Color(255,0,0).getRGB());
                    }
                }
            }
            return new ImageIcon(img);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
