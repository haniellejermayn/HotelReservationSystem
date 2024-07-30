package src.HRS.View;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import src.HRS.Model.Hotel;

/**
 * The {@code HomePanel} class represents the main panel of the application, which displays
 * a title, description, and a catalog of hotels. It provides a visual interface for users
 * to view and interact with a list of hotels.
 * <p>
 * The {@code HomePanel} extends {@link RoundPanel} and includes various components such as
 * titles, descriptions, and a list of {@link HotelItem} objects representing individual hotels.
 * </p>
 */
public class HomePanel extends RoundPanel{
    
    private ArrayList<Hotel> hotels;
    private int nHotels;
    
    private JLabel hotelTitle;
    private RoundPanel titlePanel;
    private RoundLabel title;
    private RoundLabel description;
    private ArrayList<HotelItem> hotelCatalogue;

    private Font customFont15;
    private Font customFont30;
    private Font customFont90;

    /**
     * Constructs a {@code HomePanel} with the specified list of hotels and number of hotels.
     * Initializes and sets up the user interface components of the panel, including the title,
     * description, and a catalog of hotels.
     *
     * @param hotels the list of {@code Hotel} objects to be displayed in the catalog
     * @param nHotels the number of hotels in the list
     */
    public HomePanel(ArrayList<Hotel> hotels, int nHotels){

        super(new Color(13, 22, 45));
        this.hotels = hotels;
        this.nHotels = nHotels;

        customFont15 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 15);
        customFont30 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 30);
        customFont90 = Customization.createCustomFont("Fonts/POPPINS-BOLD.TTF", 90);

        // * Title Panel * //

        title = new RoundLabel(new Color(27, 43, 80));
        title.setBounds(23, 15, 500, 115);
        title.setFont(customFont90);
        title.setForeground(Color.white);
        title.setText("NOIR HRS");
        
        description = new RoundLabel(new Color(27, 43, 80));
        description.setBounds(28, 120, 430, 30);
        description.setFont(customFont15);
        description.setForeground(Color.white);
        description.setText("Highest rated hotel reservation system");

        titlePanel = new RoundPanel(new Color(27, 43, 80));
        titlePanel.setLayout(null);
        titlePanel.setBounds(0, 0, 480, 170);
        titlePanel.setBackground(new Color(27, 43, 80));
        titlePanel.add(title);
        titlePanel.add(description);

        ImageIcon starIcon = new ImageIcon("Icons/BadgeIcon.png");
        starIcon = Customization.resizeIcon(starIcon, 170, 170);

        JLabel star = new JLabel();
        star.setIcon(starIcon);
        star.setBounds(470, 0, 130, 170);

        // * Hotel Panel * //

        hotelTitle = new JLabel("Hotels");
        hotelTitle.setFont(customFont30);
        hotelTitle.setForeground(Color.white);
        hotelTitle.setBounds(0, 160, 300, 100);

        hotelCatalogue = new ArrayList<HotelItem>();

        for(int i = 0; i < nHotels; i++){
            HotelItem itemTemp = new HotelItem(hotels.get(i));
            initializeHotelItem(itemTemp, hotels.get(i), i);
            hotelCatalogue.add(itemTemp);
        }

        this.setLayout(null);
        this.setBounds(120, 80, 620, 470);
        this.add(hotelTitle);
        this.add(titlePanel);
        this.add(star);

        for (int i = 0; i < nHotels; i++){
            this.add(hotelCatalogue.get(i));
        }
    }

    /**
     * Initializes a {@code HotelItem} with the specified {@code Hotel} and item number.
     * Sets the properties and layout of the hotel item.
     *
     * @param item the {@code HotelItem} to be initialized
     * @param hotel the {@code Hotel} associated with the item
     * @param itemNo the item number used for positioning
     */
    public void initializeHotelItem(HotelItem item, Hotel hotel, int itemNo){

        String hotelName = hotel.getHotelName();

        item.setBounds(itemNo * 190 + (itemNo * 25), 240, 190, 230);
        item.setLayout(null);

        RoundLabel content = item.getContent();
        content.setText(hotelName);
        item.setButtonName(hotelName);
        item.setVerticalAlignment(JLabel.BOTTOM);
        
        item.setFocusable(false);
    }

    /**
     * Returns the list of {@code HotelItem} objects representing the hotel catalog.
     *
     * @return the {@code ArrayList} of {@code HotelItem} objects
     */
    public ArrayList<HotelItem> getHotelCatalogue(){
        return hotelCatalogue;
    }

    /**
     * Sets the list of {@code HotelItem} objects representing the hotel catalog.
     *
     * @param hotelCatalogue the {@code ArrayList} of {@code HotelItem} objects to set
     */
    public void setHotelCatalogue(ArrayList<HotelItem> hotelCatalogue){
        this.hotelCatalogue = hotelCatalogue;
    }

    /**
     * Returns the list of {@code Hotel} objects associated with the panel.
     *
     * @return the {@code ArrayList} of {@code Hotel} objects
     */
    public ArrayList<Hotel> getHotels(){
        return hotels;
    }

    /**
     * Sets the list of {@code Hotel} objects associated with the panel.
     *
     * @param hotels the {@code ArrayList} of {@code Hotel} objects to set
     */
    public void setHotels(ArrayList<Hotel> hotels){
        this. hotels = hotels;
    }

    /**
     * Returns the number of hotels in the list.
     *
     * @return the number of hotels
     */
    public int getnHotels(){
        return nHotels;
    }

    /**
     * Sets the number of hotels in the list.
     *
     * @param nHotels the number of hotels to set
     */
    public void setnHotels(int nHotels){
        this.nHotels = nHotels;
    }
}
