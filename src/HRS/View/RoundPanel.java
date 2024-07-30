package src.HRS.View;

import java.awt.*;
import javax.swing.*;

/**
 * The RoundPanel class extends JPanel to create a panel with rounded corners and a custom background color.
 */
public class RoundPanel extends JPanel {
    
    private Color color;

    /**
     * Constructs a new RoundPanel with the specified background color.
     *
     * @param color the background color of the panel
     */
    public RoundPanel(Color color) {
        this.color = color;
        this.setOpaque(false);
        this.setBackground(color);
    }

    /**
     * Paints the component with custom rendering for the background with rounded corners.
     *
     * @param graphics the Graphics context in which to paint
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
     * Returns the color of the panel.
     *
     * @return the color of the panel
     */
    public Color getColor() {
        return color;
    }

    /**
     * Sets the color of the panel.
     *
     * @param color the color to set
     */
    public void setColor(Color color) {
        this.color = color;
    }
}
