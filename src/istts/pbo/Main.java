package istts.pbo;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

public class Main {
    public static final int SWIDTH = 1280;
    public static final int SHEIGHT = 760;

    public static void main(String[] args)throws MalformedURLException {
        try{
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src/istts/pbo/res/njnaruto.ttf")));
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }

        Splash s = new Splash();
    }
}
