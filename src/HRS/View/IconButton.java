package src.HRS.View;

import javax.swing.*;

/**
 * The {@code IconButton} class represents a button with an icon.
 * It extends {@link PanelButton} and is used to display buttons with images/icons.
 */
public class IconButton extends PanelButton {

    /**
     * Constructs an {@code IconButton} with the specified icon and button name.
     * Initializes the button with the provided icon and sets its name.
     *
     * @param icon the {@code ImageIcon} to set as the button's icon
     * @param buttonName the name of the button
     */
    IconButton(ImageIcon icon, String buttonName) {
        super(buttonName);
        this.setIcon(icon);
    }
}
