package src.HRS.View;

import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;

/**
 * The ModernScrollBarUI class customizes the appearance of a JScrollBar.
 * It sets custom colors for the thumb and track, and customizes the size
 * and shape of the scrollbar components.
 */
public class ModernScrollBarUI extends BasicScrollBarUI {

    private static final int THUMB_SIZE = 40;
    private final Color thumbColor;
    private final Color trackColor;

    /**
     * Constructs a ModernScrollBarUI with the specified thumb and track colors.
     *
     * @param thumbColor the color of the scrollbar thumb
     * @param trackColor the color of the scrollbar track
     */
    public ModernScrollBarUI(Color thumbColor, Color trackColor) {
        this.thumbColor = thumbColor;
        this.trackColor = trackColor;
    }

    /**
     * Returns the maximum size of the scrollbar thumb.
     *
     * @return the maximum size of the scrollbar thumb
     */
    @Override
    protected Dimension getMaximumThumbSize() {
        if (scrollbar.getOrientation() == JScrollBar.VERTICAL) {
            return new Dimension(0, THUMB_SIZE);
        } else {
            return new Dimension(THUMB_SIZE, 0);
        }
    }

    /**
     * Returns the minimum size of the scrollbar thumb.
     *
     * @return the minimum size of the scrollbar thumb
     */
    @Override
    protected Dimension getMinimumThumbSize() {
        if (scrollbar.getOrientation() == JScrollBar.VERTICAL) {
            return new Dimension(0, THUMB_SIZE);
        } else {
            return new Dimension(THUMB_SIZE, 0);
        }
    }

    /**
     * Creates the button to increase the scrollbar value.
     *
     * @param orientation the orientation of the scrollbar
     * @return a new ScrollBarButton
     */
    @Override
    protected JButton createIncreaseButton(int orientation) {
        return new ScrollBarButton();
    }

    /**
     * Creates the button to decrease the scrollbar value.
     *
     * @param orientation the orientation of the scrollbar
     * @return a new ScrollBarButton
     */
    @Override
    protected JButton createDecreaseButton(int orientation) {
        return new ScrollBarButton();
    }

    /**
     * Paints the track of the scrollbar.
     *
     * @param g the Graphics context in which to paint
     * @param c the component being painted
     * @param trackBounds the bounding box of the track
     */
    @Override
    protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int orientation = scrollbar.getOrientation();
        int size;
        int x;
        int y;
        int width;
        int height;
        if (orientation == JScrollBar.VERTICAL) {
            size = trackBounds.width / 2;
            x = trackBounds.x + ((trackBounds.width - size) / 2);
            y = trackBounds.y;
            width = size;
            height = trackBounds.height;
        } else {
            size = trackBounds.height / 2;
            y = trackBounds.y + ((trackBounds.height - size) / 2);
            x = 0;
            width = trackBounds.width;
            height = size;
        }
        g2.setColor(trackColor);
        g2.fillRoundRect(x, y + 15, width, height - 30, 10, 10);
    }

    /**
     * Paints the thumb of the scrollbar.
     *
     * @param g the Graphics context in which to paint
     * @param c the component being painted
     * @param thumbBounds the bounding box of the thumb
     */
    @Override
    protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int x = thumbBounds.x;
        int y = thumbBounds.y;
        int width = thumbBounds.width;
        int height = thumbBounds.height;
        if (scrollbar.getOrientation() == JScrollBar.VERTICAL) {
            y += 8;
            height -= 16;
        } else {
            x += 8;
            width -= 16;
        }
        g2.setColor(thumbColor);
        g2.fillRoundRect(x, y, width, height, 10, 10);
    }

    /**
     * The ScrollBarButton class creates a custom button for the scrollbar.
     * It sets the button size to zero and paints nothing.
     */
    private class ScrollBarButton extends JButton {

        /**
         * Constructs a new ScrollBarButton with zero size.
         */
        public ScrollBarButton() {
            setBorder(BorderFactory.createEmptyBorder());
            setPreferredSize(new Dimension(0, 0));
            setMinimumSize(new Dimension(0, 0));
            setMaximumSize(new Dimension(0, 0));
            setSize(new Dimension(0, 0));
        }

        /**
         * Paints the button.
         *
         * @param g the Graphics context in which to paint
         */
        @Override
        public void paint(Graphics g) {
            // No painting for the custom scroll bar button
        }
    }
}
