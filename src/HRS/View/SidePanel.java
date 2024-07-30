package src.HRS.View;

import java.awt.*;
import javax.swing.*;

/**
 * The SidePanel class represents a side navigation panel with buttons for different sections
 * of the application, including Home, Hotels, Reservations, Account Settings, and Back.
 */
public class SidePanel extends RoundPanel {

    private IconButton homeButton;
    private IconButton hotelButton;
    private IconButton reservationsButton;
    private IconButton accountButton;
    private IconButton backButton;

    /**
     * Constructs a new SidePanel with the specified background color.
     *
     * @param color the background color of the side panel
     */
    public SidePanel(Color color) {
        super(color);
        this.setOpaque(false);
        this.setBackground(color);
        this.setLayout(null);

        ImageIcon homeIcon = new ImageIcon("Icons/HomeIcon.png");
        ImageIcon hotelIcon = new ImageIcon("Icons/HotelsIcon.png");
        ImageIcon reservationsIcon = new ImageIcon("Icons/BookIcon.png");
        ImageIcon accountIcon = new ImageIcon("Icons/AccountIcon.png");
        ImageIcon backIcon = new ImageIcon("Icons/CancelIcon.png");

        homeIcon = Customization.resizeIcon(homeIcon, 30, 30);
        hotelIcon = Customization.resizeIcon(hotelIcon, 30, 30);
        reservationsIcon = Customization.resizeIcon(reservationsIcon, 30, 30);
        accountIcon = Customization.resizeIcon(accountIcon, 30, 30);
        backIcon = Customization.resizeIcon(backIcon, 30, 30);

        homeButton = new IconButton(homeIcon, "Home");
        homeButton.setBounds(8, 30, 50, 50);

        hotelButton = new IconButton(hotelIcon, "Hotels");
        hotelButton.setBounds(8, 100, 50, 50);

        reservationsButton = new IconButton(reservationsIcon, "Reservations");
        reservationsButton.setBounds(8, 170, 50, 50);

        accountButton = new IconButton(accountIcon, "Settings");
        accountButton.setBounds(8, 240, 50, 50);

        backButton = new IconButton(backIcon, "Back");
        backButton.setBounds(8, 410, 50, 50);

        this.add(homeButton);
        this.add(hotelButton);
        this.add(reservationsButton);
        this.add(accountButton);
        this.add(backButton);
    }

    /**
     * Returns the home button.
     *
     * @return the home button
     */
    public IconButton getHomeButton() {
        return homeButton;
    }

    /**
     * Sets the home button.
     *
     * @param homeButton the home button to set
     */
    public void setHomeButton(IconButton homeButton) {
        this.homeButton = homeButton;
    }

    /**
     * Returns the hotel button.
     *
     * @return the hotel button
     */
    public IconButton getHotelButton() {
        return hotelButton;
    }

    /**
     * Sets the hotel button.
     *
     * @param hotelButton the hotel button to set
     */
    public void setHotelButton(IconButton hotelButton) {
        this.hotelButton = hotelButton;
    }

    /**
     * Returns the reservations button.
     *
     * @return the reservations button
     */
    public IconButton getReservationsButton() {
        return reservationsButton;
    }

    /**
     * Sets the reservations button.
     *
     * @param reservationsButton the reservations button to set
     */
    public void setReservationsButton(IconButton reservationsButton) {
        this.reservationsButton = reservationsButton;
    }

    /**
     * Returns the account button.
     *
     * @return the account button
     */
    public IconButton getAccountButton() {
        return accountButton;
    }

    /**
     * Sets the account button.
     *
     * @param accountButton the account button to set
     */
    public void setAccountButton(IconButton accountButton) {
        this.accountButton = accountButton;
    }

    /**
     * Returns the back button.
     *
     * @return the back button
     */
    public IconButton getBackButton() {
        return backButton;
    }

    /**
     * Sets the back button.
     *
     * @param backButton the back button to set
     */
    public void setBackButton(IconButton backButton) {
        this.backButton = backButton;
    }
}
