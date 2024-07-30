package src.HRS.View;

import java.awt.*;
import java.util.*;
import javax.swing.*;

/**
 * The AccountPanel class represents a user account panel displaying account details
 * such as the user's name, ID number, and status, along with a profile picture and header.
 */
public class AccountPanel extends RoundPanel {

    private JLabel hotelTitle;
    private RoundPanel header;
    private RoundLabel headerLabel;
    private RoundLabel profileLabel;
    private RoundLabel name;
    private RoundLabel status;
    private RoundLabel idNumber;
    private RoundPanel accountInfo;
    private ArrayList<HotelOption> hotelCatalogue;

    private Font customFont15;
    private Font customFont20;

    /**
     * Constructs a new AccountPanel with predefined UI elements.
     */
    public AccountPanel() {
        super(new Color(13, 22, 45));

        customFont15 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 15);
        customFont20 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 20);

        ImageIcon headerIcon = new ImageIcon("Icons/HeaderBackground.jpg");

        headerLabel = new RoundLabel(Color.red);
        headerLabel.setIcon(headerIcon);
        headerLabel.setBounds(2, 2, 616, 150);

        ImageIcon profileIcon = new ImageIcon("Icons/AccountIcon.png");
        profileIcon = Customization.resizeIcon(profileIcon, 90, 90);

        profileLabel = new RoundLabel(new Color(27, 43, 80));
        profileLabel.setIcon(profileIcon);
        profileLabel.setBounds(25, 90, 120, 120);
        profileLabel.setVerticalAlignment(JLabel.CENTER);
        profileLabel.setHorizontalAlignment(JLabel.CENTER);

        header = new RoundPanel(new Color(13, 22, 45));
        header.setLayout(null);
        header.setBounds(0, 0, 620, 215);
        header.add(profileLabel);
        header.add(headerLabel);

        name = new RoundLabel(new Color(13, 22, 45));
        name.setBounds(5, 5, 200, 22);
        name.setText("User #462005");
        name.setFont(customFont20);
        name.setForeground(Color.white);

        idNumber = new RoundLabel(new Color(13, 22, 45));
        idNumber.setBounds(5, 42, 200, 16);
        idNumber.setText("12356473");
        idNumber.setFont(customFont15);
        idNumber.setForeground(Color.white);

        status = new RoundLabel(new Color(13, 22, 45));
        status.setBounds(5, 70, 200, 17);
        status.setText("Guest"); 
        status.setFont(customFont15);
        status.setForeground(Color.white);

        accountInfo = new RoundPanel(new Color(13, 22, 45));
        accountInfo.setLayout(null);
        accountInfo.setBounds(20, 220, 300, 100);
        accountInfo.add(name);
        accountInfo.add(idNumber);
        accountInfo.add(status);

        this.setLayout(null);
        this.setBounds(120, 80, 620, 470);
        this.add(header);
        this.add(accountInfo);
    }

    /**
     * Returns the hotel title label.
     *
     * @return the hotel title label
     */
    public JLabel getHotelTitle() {
        return hotelTitle;
    }

    /**
     * Sets the hotel title label.
     *
     * @param hotelTitle the hotel title label to set
     */
    public void setHotelTitle(JLabel hotelTitle) {
        this.hotelTitle = hotelTitle;
    }

    /**
     * Returns the hotel catalogue.
     *
     * @return the hotel catalogue
     */
    public ArrayList<HotelOption> getHotelCatalogue() {
        return hotelCatalogue;
    }

    /**
     * Sets the hotel catalogue.
     *
     * @param hotelCatalogue the hotel catalogue to set
     */
    public void setHotelCatalogue(ArrayList<HotelOption> hotelCatalogue) {
        this.hotelCatalogue = hotelCatalogue;
    }
}
