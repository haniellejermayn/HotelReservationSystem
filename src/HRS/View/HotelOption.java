package src.HRS.View;
//package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import src.HRS.Model.Hotel;

/**
 * The {@code HotelOption} class represents a graphical component displaying detailed information about a hotel.
 * It extends {@link PanelButton} and is designed to present various hotel attributes such as name, number of rooms,
 * reservations, and price with interactive features.
 */
public class HotelOption extends PanelButton{
    private boolean over;
    private Color color;
    private Color colorOver;
    private Color colorClick;
    private RoundLabel content;
    private JLabel name;
    private JLabel rooms;
    private JLabel reservations;
    private RoundLabel price;
    private String buttonName;
    private Hotel hotel;

    /**
     * Constructs a {@code HotelOption} with the specified {@code Hotel}.
     * Initializes the button's appearance, including font, icon, and colors, and sets up the component's layout.
     *
     * @param hotel the {@code Hotel} object associated with this option
     */
    public HotelOption(Hotel hotel) {
        super(hotel.getHotelName());

        this.hotel = hotel;

        Font customFont15 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 15);
        Font customFont20 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 20);

        ImageIcon icon = new ImageIcon("Icons/Hotel1.png");
        icon = Customization.resizeIcon(icon, 130, 85);

        price = new RoundLabel(super.getColor());
        price.setBounds(480, 5, 100, 25);
        price.setForeground(Color.white);
        price.setFont(customFont20);
        price.setVerticalAlignment(JLabel.CENTER);
        price.setHorizontalAlignment(JLabel.RIGHT);

        name = new JLabel();
        name.setFont(customFont20);
        name.setForeground(Color.white);
        name.setVerticalAlignment(JLabel.TOP);
        name.setBounds(150, 5, 200, 25);

        rooms = new JLabel();
        rooms.setFont(customFont15);
        rooms.setForeground(Color.white);
        rooms.setVerticalAlignment(JLabel.TOP);
        rooms.setBounds(150, 45, 100, 17);
        
        reservations = new JLabel();
        reservations.setFont(customFont15);
        reservations.setForeground(Color.white);
        reservations.setVerticalAlignment(JLabel.TOP);
        reservations.setBounds(150, 67, 150, 17);

        content = new RoundLabel(new Color(27, 43, 80));
        content.setBounds(8, 10, 599, 90);
        content.setIcon(icon);
        content.add(name);
        content.add(rooms);
        content.add(reservations);
        content.add(price);
        content.setFont(customFont20);
        content.setForeground(Color.white);
        content.setVerticalAlignment(JLabel.CENTER);
        content.setHorizontalAlignment(JLabel.LEFT);
        
        this.color = super.getColor();
        this.colorOver = super.getColorOver();
        this.colorClick = super.getColorClick();
        this.buttonName = super.getButtonName();
        this.setFont(customFont20);
        this.add(content);
        this.addMouseListener(this);
    }

    /**
     * Paints the component with a rounded rectangle background.
     * This method is overridden to provide custom painting behavior.
     *
     * @param graphics the {@code Graphics} object used for painting
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
     * Called when the mouse is clicked on the component.
     * This implementation does not perform any action.
     *
     * @param e the {@code MouseEvent} triggered by the click
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        // No action needed
    }

    /**
     * Called when the mouse is pressed on the component.
     * Changes the background color of the component to {@code colorClick}.
     *
     * @param e the {@code MouseEvent} triggered by the press
     */
    @Override
    public void mousePressed(MouseEvent e) {
        this.setBackground(colorClick);
        content.setBackground(colorClick);
        price.setBackground(colorClick);
    }

    /**
     * Called when the mouse is released on the component.
     * Restores the background color based on whether the mouse is over the component.
     *
     * @param e the {@code MouseEvent} triggered by the release
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        if (over) {
            this.setBackground(colorOver);
            content.setBackground(colorOver);
            price.setBackground(colorOver);
        } else {
            this.setBackground(color);
            content.setBackground(color);
            price.setBackground(color);
        }
    }

    /**
     * Called when the mouse enters the component's area.
     * Changes the background color to {@code colorOver}.
     *
     * @param e the {@code MouseEvent} triggered by the entry
     */
    @Override
    public void mouseEntered(MouseEvent e) {
        this.setBackground(colorOver);
        content.setBackground(colorOver);
        price.setBackground(colorOver);
        over = true;
    }

    /**
     * Called when the mouse exits the component's area.
     * Restores the background color to {@code color}.
     *
     * @param e the {@code MouseEvent} triggered by the exit
     */
    @Override
    public void mouseExited(MouseEvent e) {
        this.setBackground(color);
        content.setBackground(color);
        price.setBackground(color);
        over = false;
    }

    /**
     * Returns whether the mouse is currently over the component.
     *
     * @return {@code true} if the mouse is over the component; {@code false} otherwise
     */
    public boolean isOver() {
        return over;
    }

    /**
     * Sets whether the mouse is currently over the component.
     *
     * @param over {@code true} if the mouse is over the component; {@code false} otherwise
     */
    public void setOver(boolean over) {
        this.over = over;
    }

    /**
     * Returns the background color of the component.
     *
     * @return the background color
     */
    public Color getColor() {
        return color;
    }

    /**
     * Sets the background color of the component.
     *
     * @param color the background color to set
     */
    public void setColor(Color color) {
        this.color = color;
        setBackground(color);
    }

    /**
     * Returns the color of the component when the mouse is over it.
     *
     * @return the color when hovered
     */
    public Color getColorOver() {
        return colorOver;
    }

    /**
     * Sets the color of the component when the mouse is over it.
     *
     * @param colorOver the color to set when hovered
     */
    public void setColorOver(Color colorOver) {
        this.colorOver = colorOver;
    }

    /**
     * Returns the color of the component when it is clicked.
     *
     * @return the click color
     */
    public Color getColorClick() {
        return colorClick;
    }

    /**
     * Sets the color of the component when it is clicked.
     *
     * @param colorClick the color to set when clicked
     */
    public void setColorClick(Color colorClick) {
        this.colorClick = colorClick;
    }

    /**
     * Returns the {@code RoundLabel} displaying the content of the component.
     *
     * @return the {@code RoundLabel} for content
     */
    public RoundLabel getContent() {
        return content;
    }

    /**
     * Sets the {@code RoundLabel} displaying the content of the component.
     *
     * @param content the {@code RoundLabel} to set
     */
    public void setContent(RoundLabel content) {
        this.content = content;
    }

    /**
     * Returns the name of the button associated with this component.
     *
     * @return the button name
     */
    public String getButtonName() {
        return buttonName;
    }

    /**
     * Sets the name of the button associated with this component.
     *
     * @param buttonName the button name to set
     */
    public void setButtonName(String buttonName) {
        this.buttonName = buttonName;
    }

    /**
     * Returns the {@code JLabel} displaying the hotel name.
     *
     * @return the {@code JLabel} for hotel name
     */
    public JLabel getHotelName() {
        return name;
    }

    /**
     * Sets the {@code JLabel} displaying the hotel name.
     *
     * @param name the {@code JLabel} to set
     */
    public void setHotelName(JLabel name) {
        this.name = name;
    }

    /**
     * Returns the {@code JLabel} displaying the number of rooms in the hotel.
     *
     * @return the {@code JLabel} for hotel rooms
     */
    public JLabel getHotelRooms() {
        return rooms;
    }

    /**
     * Sets the {@code JLabel} displaying the number of rooms in the hotel.
     *
     * @param rooms the {@code JLabel} to set
     */
    public void setHotelRooms(JLabel rooms) {
        this.rooms = rooms;
    }

    /**
     * Returns the {@code JLabel} displaying the hotel reservations.
     *
     * @return the {@code JLabel} for hotel reservations
     */
    public JLabel getHotelRes() {
        return reservations;
    }

    /**
     * Sets the {@code JLabel} displaying the hotel reservations.
     *
     * @param reservations the {@code JLabel} to set
     */
    public void setHotelRes(JLabel reservations) {
        this.reservations = reservations;
    }

    /**
     * Returns the {@code RoundLabel} displaying the hotel price.
     *
     * @return the {@code RoundLabel} for hotel price
     */
    public RoundLabel getPrice() {
        return price;
    }

    /**
     * Sets the {@code RoundLabel} displaying the hotel price.
     *
     * @param price the {@code RoundLabel} to set
     */
    public void setPrice(RoundLabel price) {
        this.price = price;
    }

    /**
     * Returns the {@code Hotel} object associated with this option.
     *
     * @return the {@code Hotel} object
     */
    public Hotel getHotel() {
        return hotel;
    }

    /**
     * Sets the {@code Hotel} object associated with this option.
     *
     * @param hotel the {@code Hotel} object to set
     */
    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}
