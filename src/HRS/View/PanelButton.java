package src.HRS.View;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * The PanelButton class extends JButton to create a custom-styled button with
 * specified colors for different states (normal, hover, and click) and a custom font.
 * It implements MouseListener to handle mouse events and change the button's background color accordingly.
 */
public class PanelButton extends JButton implements MouseListener {

    private boolean over;
    private Color color;
    private Color colorOver;
    private Color colorClick;
    private String buttonName;

    /**
     * Constructs a new PanelButton with the specified button name.
     *
     * @param buttonName the name of the button
     */
    public PanelButton(String buttonName) {
        Font customFont = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 8);

        this.color = new Color(27, 43, 80);
        this.colorOver = new Color(40, 68, 117);
        this.colorClick = new Color(51, 88, 150);
        this.buttonName = buttonName;

        this.setOpaque(false);
        this.setBackground(color);
        this.setContentAreaFilled(false);
        this.setFocusPainted(false);
        this.setFont(customFont);
        this.setForeground(Color.white);
        this.addMouseListener(this);
    }

    /**
     * Paints the component with custom rendering for the button background.
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

    /**
     * Invoked when the mouse button has been clicked (pressed and released) on a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        // No action needed for mouseClicked
    }

    /**
     * Invoked when a mouse button has been pressed on a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mousePressed(MouseEvent e) {
        this.setBackground(colorClick);
    }

    /**
     * Invoked when a mouse button has been released on a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        if (over) {
            this.setBackground(colorOver);
        } else {
            this.setBackground(color);
        }
    }

    /**
     * Invoked when the mouse enters a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseEntered(MouseEvent e) {
        this.setBackground(colorOver);
        over = true;
    }

    /**
     * Invoked when the mouse exits a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseExited(MouseEvent e) {
        this.setBackground(color);
        over = false;
    }

    /**
     * Returns whether the mouse is over the button.
     *
     * @return true if the mouse is over the button, false otherwise
     */
    public boolean isOver() {
        return over;
    }

    /**
     * Sets whether the mouse is over the button.
     *
     * @param over true if the mouse is over the button, false otherwise
     */
    public void setOver(boolean over) {
        this.over = over;
    }

    /**
     * Returns the color of the button.
     *
     * @return the color of the button
     */
    public Color getColor() {
        return color;
    }

    /**
     * Sets the color of the button.
     *
     * @param color the color to set
     */
    public void setColor(Color color) {
        this.color = color;
        setBackground(color);
    }

    /**
     * Returns the hover color of the button.
     *
     * @return the hover color of the button
     */
    public Color getColorOver() {
        return colorOver;
    }

    /**
     * Sets the hover color of the button.
     *
     * @param colorOver the hover color to set
     */
    public void setColorOver(Color colorOver) {
        this.colorOver = colorOver;
    }

    /**
     * Returns the click color of the button.
     *
     * @return the click color of the button
     */
    public Color getColorClick() {
        return colorClick;
    }

    /**
     * Sets the click color of the button.
     *
     * @param colorClick the click color to set
     */
    public void setColorClick(Color colorClick) {
        this.colorClick = colorClick;
    }

    /**
     * Returns the name of the button.
     *
     * @return the name of the button
     */
    public String getButtonName() {
        return buttonName;
    }

    /**
     * Sets the name of the button.
     *
     * @param buttonName the name to set
     */
    public void setButtonName(String buttonName) {
        this.buttonName = buttonName;
    }
}
