package src.HRS.View;

import java.awt.*;
import javax.swing.*;

/**
 * The ScrollPaneCustom class extends JScrollPane to create a custom scroll pane with specified colors
 * for the thumb, track, and background, and a rounded background.
 */
public class ScrollPaneCustom extends JScrollPane {

    private Color bgColor;

    /**
     * Constructs a new ScrollPaneCustom with the specified component, thumb color, track color, and background color.
     *
     * @param component the component to display in the scroll pane
     * @param thumbColor the color of the scrollbar thumb
     * @param trackColor the color of the scrollbar track
     * @param bgColor the background color of the scroll pane
     */
    public ScrollPaneCustom(Component component, Color thumbColor, Color trackColor, Color bgColor) {
        super(component);
        
        this.bgColor = bgColor;
        this.setVerticalScrollBar(new ScrollBarCustom(thumbColor, trackColor));
        this.setBorder(null);
        this.getViewport().setOpaque(false);
        this.setViewportBorder(null);
        this.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        this.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        this.setOpaque(false);
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
        g2.setColor(bgColor);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        super.paintComponent(g2);
    }
}
