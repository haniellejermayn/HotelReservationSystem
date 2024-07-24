//package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class HotelsPanel extends LayeredRoundPanel implements ActionListener, ButtonClickListener{
    
    private JLabel hotelTitle;
    private CreateHotelPanel createHotelPanel;
    private IconButton createHotelButton;
    private IconButton filterButton;
    private FilterPanel filterPanel;
    private RoundPanel hotelContainer;
    private ButtonClickListener listener;
    private ArrayList<HotelOption> hotelCatalogue;
    private int hotelContainerHeight;
    private ScrollPaneCustom scrollPane;
    private boolean isVisible = false;
    private Font customFont35;
    private ArrayList<String> hotels;
    private int nHotels;

        // TODO: change to Hotel hotels
    HotelsPanel(ArrayList<String> hotels, int nHotels, ButtonClickListener listener){

        super(new Color(13, 22, 45));

        this.listener = listener;
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
        filterButton.addActionListener(this);

        filterPanel = new FilterPanel(new Color(40, 68, 117), this);
        filterPanel.setVisible(false);

        // * Create Hotel * //
        ImageIcon createHotelIcon = new ImageIcon("Icons/AddIcon.png");
        createHotelIcon = Customization.resizeIcon(createHotelIcon, 30, 30);

        createHotelButton = new IconButton(createHotelIcon, "Create Hotel"); // add picture
        createHotelButton.setBounds(285, (nHotels + 1) * 10 + (nHotels * 110) + 10, 50, 50);
        createHotelButton.addActionListener(this);


        // * Container * //
        hotelContainerHeight = (nHotels + 1) * 10 + (nHotels * 110) + 70;

        hotelContainer = new RoundPanel(new Color(13, 22, 45));
        hotelContainer.setLayout(null);;
        hotelContainer.setPreferredSize(new Dimension(620, hotelContainerHeight));

        for (int i = 0; i < nHotels; i++){
            hotelContainer.add(hotelCatalogue.get(i));
        }

        hotelContainer.add(createHotelButton);

        scrollPane = new ScrollPaneCustom(hotelContainer, new Color(40, 68, 117), new Color(40, 68, 117), new Color(13, 22, 45));
        scrollPane.setBounds(0, 60, 620, 405);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        this.setLayout(null);
        this.setBounds(120, 80, 620, 470);
        this.add(hotelTitle, JLayeredPane.DEFAULT_LAYER);
        this.add(filterButton, JLayeredPane.DEFAULT_LAYER);
        this.add(filterPanel, JLayeredPane.DEFAULT_LAYER);
        this.add(scrollPane, JLayeredPane.DEFAULT_LAYER);
    }

                                            // TODO: change to Hotel
    public void initializeHotelOption(HotelOption item, String hotel, int itemNo){

        // TODO: add price to hotelOption
        String hotelName = hotel; // TODO: change to hotel name
        //float price = 1299.00f; // TODO: change to hotel price

        item.setBounds(0, (itemNo + 1) * 10 + (itemNo * 110), 600, 110);

        item.setLayout(null);

        RoundLabel content = item.getContent();
        content.setText(hotelName);
        item.setVerticalAlignment(JLabel.CENTER);
        item.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                listener.buttonClicked(hotelName);
            }
        });
        
        item.setFocusable(false);
        // TODO: add other hotel information
        // TODO: add option if there is hotel picture
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == filterButton){
            isVisible = !isVisible;
            filterPanel.setVisible(isVisible);

            if (isVisible){
                filterButton.setColor(new Color(40, 68, 117));
            }
            else {
                filterButton.setColor(new Color(27, 43, 80));
            }

            filterButton.repaint();
        }
        else if (e.getSource() == createHotelButton){
            createHotelPanel = new CreateHotelPanel(hotels, this);
            createHotelPanel.setBounds(152, 10, 385, 420);
            this.add(createHotelPanel, JLayeredPane.POPUP_LAYER);
        }
    }

    @Override
    public void buttonClicked(String buttonName) {
        if (buttonName.equals("Create")){
            createHotelPanel.setVisible(false);
            this.remove(createHotelPanel);
            nHotels++;
        }
        else if (buttonName.equals("Create Cancel")){
            createHotelPanel.setVisible(false);
            this.remove(createHotelPanel);
        }
        else if (buttonName.equals("Most Booked")){

            scrollPane.setVisible(false);
            this.remove(scrollPane);

            hotelContainer.removeAll();

            ArrayList<HotelOption> mostBookedCatalogue = new ArrayList<HotelOption>();

            // TODO: add filter function for most booked
            ArrayList<String> mostBooked = new ArrayList<String>();
            mostBooked.add(hotels.get(3));
            mostBooked.add(hotels.get(2));
            mostBooked.add(hotels.get(1));
            mostBooked.add(hotels.get(4));
            mostBooked.add(hotels.get(0));
            mostBooked.add(hotels.get(5));

            for(int i = 0; i < nHotels; i++){
                HotelOption optionTemp = new HotelOption(mostBooked.get(i));
                initializeHotelOption(optionTemp, mostBooked.get(i), i);
                mostBookedCatalogue.add(optionTemp);
                hotelContainer.add(mostBookedCatalogue.get(i));
            }

            hotelContainer.add(createHotelButton);

            scrollPane = new ScrollPaneCustom(hotelContainer, new Color(40, 68, 117), new Color(40, 68, 117), new Color(13, 22, 45));
            scrollPane.setBounds(0, 60, 620, 405);
            scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

            this.add(scrollPane, JLayeredPane.DEFAULT_LAYER);
        }
        else if (buttonName.equals("Lowest Price")){

            scrollPane.setVisible(false);
            this.remove(scrollPane);

            hotelContainer.removeAll();

            ArrayList<HotelOption> lowestPriceCatalogue = new ArrayList<HotelOption>();

            // TODO: add filter function for lowest price
            ArrayList<String> lowestPrice = new ArrayList<String>();
            lowestPrice.add(hotels.get(3));
            lowestPrice.add(hotels.get(2));
            lowestPrice.add(hotels.get(4));
            lowestPrice.add(hotels.get(1));
            lowestPrice.add(hotels.get(5));
            lowestPrice.add(hotels.get(0));

            for(int i = 0; i < nHotels; i++){
                HotelOption optionTemp = new HotelOption(lowestPrice.get(i));
                initializeHotelOption(optionTemp, lowestPrice.get(i), i);
                lowestPriceCatalogue.add(optionTemp);
                hotelContainer.add(lowestPriceCatalogue.get(i));
            }

            hotelContainer.add(createHotelButton);

            scrollPane = new ScrollPaneCustom(hotelContainer, new Color(40, 68, 117), new Color(40, 68, 117), new Color(13, 22, 45));
            scrollPane.setBounds(0, 60, 620, 405);
            scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

            this.add(scrollPane, JLayeredPane.DEFAULT_LAYER);
        }
        else if (buttonName.equals("Highest Price")){

            scrollPane.setVisible(false);
            this.remove(scrollPane);

            hotelContainer.removeAll();

            ArrayList<HotelOption> highestPriceCatalogue = new ArrayList<HotelOption>();

            // TODO: add filter function for highest price
            ArrayList<String> highestPrice = new ArrayList<String>();
            highestPrice.add(hotels.get(4));
            highestPrice.add(hotels.get(3));
            highestPrice.add(hotels.get(2));
            highestPrice.add(hotels.get(5));
            highestPrice.add(hotels.get(0));
            highestPrice.add(hotels.get(1));

            for(int i = 0; i < nHotels; i++){
                HotelOption optionTemp = new HotelOption(highestPrice.get(i));
                initializeHotelOption(optionTemp, highestPrice.get(i), i);
                highestPriceCatalogue.add(optionTemp);
                hotelContainer.add(highestPriceCatalogue.get(i));
            }

            hotelContainer.add(createHotelButton);

            scrollPane = new ScrollPaneCustom(hotelContainer, new Color(40, 68, 117), new Color(40, 68, 117), new Color(13, 22, 45));
            scrollPane.setBounds(0, 60, 620, 405);
            scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

            this.add(scrollPane);
        }
        else if (buttonName.equals("Newest")){

            scrollPane.setVisible(false);
            this.remove(scrollPane);

            hotelContainer.removeAll();

            ArrayList<HotelOption> newestCatalogue = new ArrayList<HotelOption>();

            // TODO: add filter function for newest
            ArrayList<String> newest = new ArrayList<String>();
            newest.add(hotels.get(0));
            newest.add(hotels.get(1));
            newest.add(hotels.get(2));
            newest.add(hotels.get(3));
            newest.add(hotels.get(4));
            newest.add(hotels.get(5));

            for(int i = 0; i < nHotels; i++){
                HotelOption optionTemp = new HotelOption(newest.get(i));
                initializeHotelOption(optionTemp, newest.get(i), i);
                newestCatalogue.add(optionTemp);
                hotelContainer.add(newestCatalogue.get(i));
            }

            hotelContainer.add(createHotelButton);

            scrollPane = new ScrollPaneCustom(hotelContainer, new Color(40, 68, 117), new Color(40, 68, 117), new Color(13, 22, 45));
            scrollPane.setBounds(0, 60, 620, 405);
            scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

            this.add(scrollPane);
        }
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

    public boolean getVisible(){
        return isVisible;
    }

    public void getVisible(boolean isVisible){
        this.isVisible = isVisible;
    }
}
