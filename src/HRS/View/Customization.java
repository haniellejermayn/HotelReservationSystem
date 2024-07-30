package src.HRS.View;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;

/**
 * The Customization class provides utility methods for customizing UI components.
 * It includes methods for resizing icons and creating custom fonts.
 */
public class Customization {

    /**
     * Default constructor for the Customization class.
     */
    public Customization() {
        // Empty constructor
    }

    // * ---------- Thematic Components ---------- * //

    /*  
     *  Font: Poppins SemiBold
     *  Background Color: (13, 22, 45) || 0D162D
     *  Panel/Button Color: (27, 43, 80) || 1B2B50
     *  Button Color Hover: (40, 68, 117) || 284475
     *  Button Color Click: (51, 88, 150) || 335896
     */

    // * ---------- Set to full screen ---------- * //
    
    // * Resize Image * //

    /**
     * Resizes the given icon to the specified width and height.
     *
     * @param icon the original ImageIcon to be resized
     * @param iconWidth the desired width of the resized icon
     * @param iconHeight the desired height of the resized icon
     * @return the resized ImageIcon
     */
    public static ImageIcon resizeIcon(ImageIcon icon, int iconWidth, int iconHeight) {
        Image iconImage = icon.getImage();
        Image resizedImage = iconImage.getScaledInstance(iconWidth, iconHeight, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }

    /**
     * Creates a custom font from the specified font file.
     *
     * @param fontName the path to the font file
     * @param size the desired size of the font
     * @return the created Font, or a default Arial font if the custom font cannot be loaded
     */
    public static Font createCustomFont(String fontName, int size) {
        Font customFont = new Font("Arial", Font.PLAIN, size);

        try {
            File fontFile = new File(fontName);
            customFont = Font.createFont(Font.TRUETYPE_FONT, fontFile);

            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(customFont);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }

        return customFont.deriveFont((float) size);
    }
}


