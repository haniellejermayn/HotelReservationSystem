package src.HRS.View;

import java.awt.*;
import javax.swing.*;

/**
 * The RoundLabel class extends JLabel to create a label with rounded corners and a custom background color.
 */
public class RoundLabel extends JLabel {
    
    /**
     * Constructs a new RoundLabel with the specified background color.
     *
     * @param bgColor the background color of the label
     */
    public RoundLabel(Color bgColor) {
        this.setOpaque(false);
        this.setBackground(bgColor);
    }

    /**
     * Paints the component with custom rendering for the background with rounded corners.
     *
     * @param graphics the Graphics context in which to paint
     */
    @Override
    protected void paintComponent(Graphics graphics) {
        Graphics2D g2 = (Graphics2D) graphics;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        super.paintComponent(g2);
    }
}
