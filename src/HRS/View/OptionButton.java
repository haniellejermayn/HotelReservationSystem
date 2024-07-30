package src.HRS.View;

import java.awt.*;

/**
 * The OptionButton class extends the PanelButton class to create a custom button
 * with a specified name and a custom font.
 */
public class OptionButton extends PanelButton {

    /**
     * Constructs a new OptionButton with the specified button name.
     *
     * @param buttonName the name of the button
     */
    public OptionButton(String buttonName) {
        super(buttonName);
        
        Font customFont = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 10);
        
        this.setText(buttonName);
        this.setFont(customFont);
    }
}
