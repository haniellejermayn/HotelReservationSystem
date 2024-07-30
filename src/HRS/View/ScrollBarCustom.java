package src.HRS.View;

import java.awt.*;
import javax.swing.*;

/**
 * The ScrollBarCustom class extends JScrollBar to create a scrollbar with custom thumb and track colors.
 */
public class ScrollBarCustom extends JScrollBar {

    /**
     * Constructs a new ScrollBarCustom with the specified thumb and track colors.
     *
     * @param thumbColor the color of the scrollbar thumb
     * @param trackColor the color of the scrollbar track
     */
    public ScrollBarCustom(Color thumbColor, Color trackColor) {
        this.setUI(new ModernScrollBarUI(thumbColor, trackColor));
        this.setPreferredSize(new Dimension(7, 8));
        this.setOpaque(false);
    }
}
