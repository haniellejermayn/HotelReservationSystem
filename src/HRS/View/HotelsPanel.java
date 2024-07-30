package src.HRS.View;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import src.HRS.Model.Hotel;

/**
 * The {@code HotelsPanel} class represents a panel that displays a list of hotels with options to filter and add new hotels.
 * It extends {@link LayeredRoundPanel} and provides interactive components such as a title label, filter button, and a scrollable list of hotel options.
 */
public class HotelsPanel extends LayeredRoundPanel {
    
    private JLabel hotelTitle;
    private CreateHotelPanel createHotelPanel;
    private IconButton createHotelButton;
    private IconButton filterButton;
    private FilterPanel filterPanel;
    private RoundPanel hotelContainer;
    private ArrayList<HotelOption> hotelCatalogue;
    private int hotelContainerHeight;
    private ScrollPaneCustom hotelScrollPane;
    private boolean isVisible = false;
    private Font customFont35;
    private ArrayList<Hotel> hotels;
    private int nHotels;

    /**
     * Constructs a {@code HotelsPanel} with the specified list of hotels and the number of hotels.
     * Initializes the panel's components, including the title, buttons, filter panel, and the scrollable container for hotel options.
     *
     * @param hotels the list of {@code Hotel} objects to display
     * @param nHotels the number of hotels to display
     */
    public HotelsPanel(ArrayList<Hotel> hotels, int nHotels) {
        super(new Color(13, 22, 45));

        this.hotels = hotels;
        this.nHotels = nHotels;

        customFont35 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 35);

        // * Hotel Title * //

        hotelTitle = new JLabel("Hotels");
        hotelTitle.setFont(customFont35);
        hotelTitle.setForeground(Color.white);
        hotelTitle.setVerticalAlignment(JLabel.TOP);
        hotelTitle.setBounds(0, 0, 300, 100);

        // * Hotel Catalogue * //

        hotelCatalogue = new ArrayList<>();

        for (int i = 0; i < nHotels; i++) {
            HotelOption optionTemp = new HotelOption(hotels.get(i));
            initializeHotelOption(optionTemp, hotels.get(i), i);
            hotelCatalogue.add(optionTemp);
        }

        // * Filter * //

        ImageIcon filterIcon = new ImageIcon("Icons/FilterIcon.png"); 
        filterIcon = Customization.resizeIcon(filterIcon, 20, 20); 
        
        filterButton = new IconButton(filterIcon, "Filter");
        filterButton.setBounds(570, 0, 40, 40);
        filterButton.setColorClick(filterButton.getColorOver());

        filterPanel = new FilterPanel(new Color(40, 68, 117));
        filterPanel.setVisible(false);

        // * Create Hotel * //

        ImageIcon createHotelIcon = new ImageIcon("Icons/AddIcon.png");
        createHotelIcon = Customization.resizeIcon(createHotelIcon, 30, 30);

        createHotelButton = new IconButton(createHotelIcon, "Create Hotel");
        createHotelButton.setBounds(285, (nHotels + 1) * 10 + (nHotels * 110) + 10, 50, 50);

        // * Container * //
        hotelContainerHeight = (nHotels + 1) * 10 + (nHotels * 110) + 70;

        hotelContainer = new RoundPanel(new Color(13, 22, 45));
        hotelContainer.setLayout(null);
        hotelContainer.setPreferredSize(new Dimension(620, hotelContainerHeight));

        for (int i = 0; i < nHotels; i++) {
            hotelContainer.add(hotelCatalogue.get(i));
        }

        hotelContainer.add(createHotelButton);

        hotelScrollPane = new ScrollPaneCustom(hotelContainer, new Color(40, 68, 117), new Color(40, 68, 117), new Color(13, 22, 45));
        hotelScrollPane.setBounds(0, 60, 620, 405);
        hotelScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        this.setLayout(null);
        this.setBounds(120, 80, 620, 470);
        this.add(hotelTitle, JLayeredPane.DEFAULT_LAYER);
        this.add(filterButton, JLayeredPane.DEFAULT_LAYER);
        this.add(filterPanel, JLayeredPane.DEFAULT_LAYER);
        this.add(hotelScrollPane, JLayeredPane.DEFAULT_LAYER);
    }

    /**
     * Initializes the properties of a {@code HotelOption} item with the specified {@code Hotel} and item number.
     * Sets the text for the hotel name, number of rooms, number of reservations, and price.
     *
     * @param item the {@code HotelOption} to initialize
     * @param hotel the {@code Hotel} to set information for
     * @param itemNo the index of the item in the list
     */
    public void initializeHotelOption(HotelOption item, Hotel hotel, int itemNo) {
        String hotelName = hotel.getHotelName(); 

        float price = hotel.getBasePrice(); 
        int rooms = hotel.countRooms(0);
        int reservations = hotel.countReservations();

        item.setBounds(0, (itemNo + 1) * 10 + (itemNo * 110), 600, 110);

        item.setLayout(null);

        item.getHotelName().setText(hotelName);
        item.getHotelRooms().setText(String.valueOf(rooms) + " rooms");
        item.getHotelRes().setText(String.valueOf(reservations) + " reservations");
        item.getPrice().setText("$" + String.format("%.2f", price));
        item.setVerticalAlignment(JLabel.CENTER);

        item.setFocusable(false);
    }

    /**
     * Returns the {@code JLabel} used as the title of the hotel panel.
     *
     * @return the hotel title label
     */
    public JLabel getHotelTitle() {
        return hotelTitle;
    }

    /**
     * Sets the {@code JLabel} used as the title of the hotel panel.
     *
     * @param hotelTitle the {@code JLabel} to set as the hotel title
     */
    public void setHotelTitle(JLabel hotelTitle) {
        this.hotelTitle = hotelTitle;
    }

    /**
     * Returns the list of {@code HotelOption} objects representing the catalogue of hotels.
     *
     * @return the list of hotel options
     */
    public ArrayList<HotelOption> getHotelCatalogue() {
        return hotelCatalogue;
    }

    /**
     * Sets the list of {@code HotelOption} objects representing the catalogue of hotels.
     *
     * @param hotelCatalogue the list of hotel options to set
     */
    public void setHotelCatalogue(ArrayList<HotelOption> hotelCatalogue) {
        this.hotelCatalogue = hotelCatalogue;
    }

    /**
     * Returns the {@code IconButton} used to create a new hotel.
     *
     * @return the create hotel button
     */
    public IconButton getCreateHotelButton() {
        return createHotelButton;
    }

    /**
     * Sets the {@code IconButton} used to create a new hotel.
     *
     * @param createHotelButton the {@code IconButton} to set
     */
    public void setCreateHotelButton(IconButton createHotelButton) {
        this.createHotelButton = createHotelButton;
    }

    /**
     * Returns the {@code CreateHotelPanel} used for creating new hotels.
     *
     * @return the create hotel panel
     */
    public CreateHotelPanel getCreateHotelPanel() {
        return createHotelPanel;
    }

    /**
     * Sets the {@code CreateHotelPanel} used for creating new hotels.
     *
     * @param createHotelPanel the {@code CreateHotelPanel} to set
     */
    public void setCreateHotelPanel(CreateHotelPanel createHotelPanel) {
        this.createHotelPanel = createHotelPanel;
    }

    /**
     * Returns the {@code IconButton} used to filter hotels.
     *
     * @return the filter button
     */
    public IconButton getFilterButton() {
        return filterButton;
    }

    /**
     * Sets the {@code IconButton} used to filter hotels.
     *
     * @param filterButton the {@code IconButton} to set
     */
    public void setFilterButton(IconButton filterButton) {
        this.filterButton = filterButton;
    }

    /**
     * Returns the {@code FilterPanel} used to filter the list of hotels.
     *
     * @return the filter panel
     */
    public FilterPanel getFilterPanel() {
        return filterPanel;
    }

    /**
     * Sets the {@code FilterPanel} used to filter the list of hotels.
     *
     * @param filterPanel the {@code FilterPanel} to set
     */
    public void setFilterPanel(FilterPanel filterPanel) {
        this.filterPanel = filterPanel;
    }

    /**
     * Returns whether the filter panel is currently visible.
     *
     * @return {@code true} if the filter panel is visible; {@code false} otherwise
     */
    public boolean getFilterPanelVisible() {
        return isVisible;
    }

    /**
     * Sets the visibility of the filter panel.
     *
     * @param isVisible {@code true} to make the filter panel visible; {@code false} to hide it
     */
    public void setFilterPanelVisible(boolean isVisible) {
        this.isVisible = isVisible;
    }

    /**
     * Returns the {@code ScrollPaneCustom} used to scroll through the list of hotel options.
     *
     * @return the hotel scroll pane
     */
    public ScrollPaneCustom getHotelScrollPane() {
        return hotelScrollPane;
    }

    /**
     * Sets the {@code ScrollPaneCustom} used to scroll through the list of hotel options.
     *
     * @param hotelScrollPane the {@code ScrollPaneCustom} to set
     */
    public void setHotelScrollPane(ScrollPaneCustom hotelScrollPane) {
        this.hotelScrollPane = hotelScrollPane;
    }

    /**
     * Returns the {@code RoundPanel} containing the hotel options.
     *
     * @return the hotel container panel
     */
    public RoundPanel getHotelContainer() {
        return hotelContainer;
    }

    /**
     * Sets the {@code RoundPanel} containing the hotel options.
     *
     * @param hotelContainer the {@code RoundPanel} to set
     */
    public void setHotelContainer(RoundPanel hotelContainer) {
        this.hotelContainer = hotelContainer;
    }

    /**
     * Returns the list of {@code Hotel} objects.
     *
     * @return the list of hotels
     */
    public ArrayList<Hotel> getHotels() {
        return hotels;
    }

    /**
     * Sets the list of {@code Hotel} objects.
     *
     * @param hotels the list of {@code Hotel} objects to set
     */
    public void setHotels(ArrayList<Hotel> hotels) {
        this.hotels = hotels;
    }

    /**
     * Returns the number of hotels currently displayed.
     *
     * @return the number of hotels
     */
    public int getnHotels() {
        return nHotels;
    }

    /**
     * Sets the number of hotels to display.
     *
     * @param nHotels the number of hotels to set
     */
    public void setnHotels(int nHotels) {
        this.nHotels = nHotels;
    }
}
