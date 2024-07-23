package GUI;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.swing.*;

public class Customization {
    
    public Customization(){

    }

    //---------- Thematic Components ----------//

    /*  Font: Poppins SemiBold
     *  Background Color: (13, 22, 45) || 0D162D
     *  Panel/Button Color: (27, 43, 80) || 1B2B50
     *  Button Color Hover: (40, 68, 117) || 284475
     *  Button Color Click: (51, 88, 150) || 335896
     */

    //---------- Set to full screen ----------//

    /*Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
      int screenWidth = (int)screenSize.getWidth();*/

    //---------- Resize Image ---------//

    public static ImageIcon resizeIcon(ImageIcon icon, int iconWidth, int iconHeight){
        Image iconImage = icon.getImage();

        Image resizedImage = iconImage.getScaledInstance(iconWidth, iconHeight, Image.SCALE_SMOOTH);

        ImageIcon resizedIcon = new ImageIcon(resizedImage);
        
        return resizedIcon;
    }

    public static Font createCustomFont(String fontName, int size){
        Font customFont = new Font("Arial", Font.PLAIN, size);

        try {
            File fontFile = new File(fontName);
            customFont = Font.createFont(Font.TRUETYPE_FONT, fontFile);
    
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(customFont);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }

        customFont = customFont.deriveFont((float)size);

        return customFont;
    }
}
