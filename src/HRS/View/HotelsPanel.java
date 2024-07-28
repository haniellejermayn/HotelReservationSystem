package src.HRS.View;

//import src.HRS.Model.*;

import javax.swing.*;

import src.HRS.Model.Hotel;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class HotelsPanel extends LayeredRoundPanel{
    
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

        // TODO: change to Hotel hotels
    public HotelsPanel(ArrayList<Hotel> hotels, int nHotels){

        super(new Color(13, 22, 45));

        this.hotels = hotels;
        this. nHotels = nHotels;

        customFont35 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 35);

        // * Hotel Title * //

        hotelTitle = new JLabel("Hotels");
        hotelTitle.setFont(customFont35);
        hotelTitle.setForeground(Color.white);
        hotelTitle.setVerticalAlignment(JLabel.TOP);
        hotelTitle.setBounds(0, 0, 300, 100);

        // * Hotel Catalogue * //

        hotelCatalogue = new ArrayList<HotelOption>();

        for(int i = 0; i < nHotels; i++){
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
        //filterButton.addActionListener(this);

        filterPanel = new FilterPanel(new Color(40, 68, 117));
        filterPanel.setVisible(false);

        // * Create Hotel * //
        ImageIcon createHotelIcon = new ImageIcon("Icons/AddIcon.png");
        createHotelIcon = Customization.resizeIcon(createHotelIcon, 30, 30);

        createHotelButton = new IconButton(createHotelIcon, "Create Hotel");
        createHotelButton.setBounds(285, (nHotels + 1) * 10 + (nHotels * 110) + 10, 50, 50);
        //createHotelButton.addActionListener(this);


        // * Container * //
        hotelContainerHeight = (nHotels + 1) * 10 + (nHotels * 110) + 70;

        hotelContainer = new RoundPanel(new Color(13, 22, 45));
        hotelContainer.setLayout(null);;
        hotelContainer.setPreferredSize(new Dimension(620, hotelContainerHeight));

        for (int i = 0; i < nHotels; i++){
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

    public void initializeHotelOption(HotelOption item, Hotel hotel, int itemNo){

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

    public JLabel getHotelTitle(){
        return hotelTitle;
    }

    public void setHotelTitle(JLabel hotelTitle){
        this.hotelTitle = hotelTitle;
    }

    public ArrayList<HotelOption> getHotelCatalogue(){
        return hotelCatalogue;
    }

    public void setHotelCatalogue(ArrayList<HotelOption> hotelCatalogue){
        this.hotelCatalogue = hotelCatalogue;
    }

    public IconButton getCreateHotelButton(){
        return createHotelButton;
    }

    public void setCreateHotelButton(IconButton createHotelButton){
        this.createHotelButton = createHotelButton;
    }

    public CreateHotelPanel getCreateHotelPanel(){
        return createHotelPanel;
    }

    public void setCreateHotelPanel(CreateHotelPanel createHotelPanel){
        this.createHotelPanel = createHotelPanel;
    }

    public IconButton getFilterButton(){
        return filterButton;
    }

    public void setFilterButton(IconButton filterButton){
        this.filterButton = filterButton;
    }

    public FilterPanel getFilterPanel(){
        return filterPanel;
    }

    public void setFilterPanel(FilterPanel filterPanel){
        this.filterPanel = filterPanel;
    }

    public boolean getFilterPanelVisible(){
        return isVisible;
    }

    public void setFilterPanelVisible(boolean isVisible){
        this.isVisible = isVisible;
    }

    public ScrollPaneCustom getHotelScrollPane(){
        return hotelScrollPane;
    }

    public void setHotelScrollPane(ScrollPaneCustom hotelScrollPane){
        this.hotelScrollPane = hotelScrollPane;
    }

    public RoundPanel getHotelContainer(){
        return hotelContainer;
    }

    public void setHotelContainer(RoundPanel hotelContainer){
        this.hotelContainer = hotelContainer;
    }

    public ArrayList<Hotel> getHotels(){
        return hotels;
    }

    public void setHotels(ArrayList<Hotel> hotels){
        this. hotels = hotels;
    }

    public int getnHotels(){
        return nHotels;
    }

    public void setnHotels(int nHotels){
        this.nHotels = nHotels;
    }
}
