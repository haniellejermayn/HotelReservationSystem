package src.HRS.View;

import java.awt.*;
import javax.swing.*;

/**
 * The {@code LayeredRoundPanel} class is a custom {@link JLayeredPane} that supports rounded corners and a background color.
 * It allows for layering of components and provides a rounded rectangular background.
 */
public class LayeredRoundPanel extends JLayeredPane {

    private Color color;

    /**
     * Constructs a {@code LayeredRoundPanel} with the specified background color.
     *
     * @param color the {@code Color} to set as the background color of the panel
     */
    LayeredRoundPanel(Color color) {
        this.color = color;
        this.setOpaque(false);
        this.setBackground(color);
    }

    /**
     * Paints the component with a rounded rectangular background.
     * Overrides the {@link JLayeredPane#paintComponent(Graphics)} method to apply custom painting.
     *
     * @param graphics the {@code Graphics} object used to paint the component
     */
    @Override
    protected void paintComponent(Graphics graphics) {
        Graphics2D g2 = (Graphics2D) graphics;
        super.paintComponent(g2);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
    }

    /**
     * Gets the background color of the panel.
     *
     * @return the {@code Color} of the panel's background
     */
    public Color getColor() {
        return color;
    }

    /**
     * Sets the background color of the panel.
     *
     * @param color the {@code Color} to set as the panel's background
     */
    public void setColor(Color color) {
        this.color = color;
        this.setBackground(color);
    }
}
