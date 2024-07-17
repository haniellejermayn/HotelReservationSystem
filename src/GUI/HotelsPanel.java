package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.*;

import hrs.*;

public class HotelsPanel extends RoundPanel implements ActionListener{
    
    private JLabel hotelTitle;
    private ArrayList<HotelOption> hotelCatalogue;
    private IconButton createHotelButton;
    private IconButton filterButton;
    private FilterPanel filterPanel;
    private boolean isVisible = false;

    private Font customFont15;
    private Font customFont35;
    private Font customFont70;

    public HotelsPanel(ArrayList<Hotel> hotels, int nHotels){

        super(new Color(13, 22, 45));
        //super(Color.white);

        customFont15 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 15);
        customFont35 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 35);
        customFont70 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 70);

        hotelTitle = new JLabel("Hotels");
        hotelTitle.setFont(customFont35);
        hotelTitle.setForeground(Color.white);
        hotelTitle.setVerticalAlignment(JLabel.TOP);
        hotelTitle.setBounds(0, 0, 300, 100);

        // if (hotels[] != EMPTY)
        hotelCatalogue = new ArrayList<HotelOption>();

        // Room rooms;
        for(int i = 0; i < nHotels; i++){
            HotelOption optionTemp = new HotelOption(hotels.get(i).getHotelName());
            initializeHotelOption(optionTemp, hotels.get(i), i);
            hotelCatalogue.add(optionTemp);
        }

        ImageIcon filterIcon = new ImageIcon("Icons/FilterIcon.png"); 
        filterIcon = Customization.resizeIcon(filterIcon, 20, 20); 
        
        filterButton = new IconButton(filterIcon, "Filter");
        filterButton.setBounds(570, 0, 40, 40);
        filterButton.setColorClick(filterButton.getColorOver());
        filterButton.addActionListener(this);

        filterPanel = new FilterPanel(new Color(40, 68, 117));
        filterPanel.setVisible(false);

        ImageIcon createHotelIcon = new ImageIcon("Icons/AddIcon.png");
        createHotelIcon = Customization.resizeIcon(createHotelIcon, 30, 30);

        createHotelButton = new IconButton(createHotelIcon, "Create Hotel"); // add picture
        createHotelButton.setBounds(285, (nHotels + 1) * 60 + (nHotels * 60) + 10, 50, 50);

        this.setLayout(null);
        this.setBounds(120, 80, 620, 470);
        this.add(hotelTitle);
        this.add(filterButton);
        this.add(filterPanel);
        
        for (int i = 0; i < nHotels; i++){
            this.add(hotelCatalogue.get(i));
        }

        this.add(createHotelButton);






        // fix

        /*scrollPane = new JScrollPane(homePage);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);*/
        
    }

    public void initializeHotelOption(HotelOption item, Hotel hotel, int itemNo){

        String hotelName = hotel.getHotelName(); // change later


        item.setBounds(0, (itemNo + 1) * 60 + (itemNo * 60), 620, 110); // fix
        item.setLayout(null);

        RoundLabel content = item.getContent();
        content.setText(hotelName);
        item.setVerticalAlignment(JLabel.CENTER);
        
        
        item.setFocusable(false);
        //item.setText(price); // change to string
    }   // add option if there is hotel picture

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
