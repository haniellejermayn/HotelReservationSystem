import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class ReservationsPanel extends RoundPanel implements ActionListener{
    
    private JLabel resTitle;
    private RoundPanel hotelPanel;
    private RoundPanel namePanel;
    private RoundPanel roomTypePanel;
    private RoundPanel checkInNOutPanel;
    private RoundPanel totalPricePanel;
    private RoundPanel resContainer;
    private int resContainerHeight;
    private ArrayList<HotelOption> hotelCatalogue;

    private Font customFont15;
    private Font customFont35;
    private Font customFont70;

        // TODO: change to Hotel hotels
    ReservationsPanel(ArrayList<String> hotels, int nHotel){

        super(new Color(13, 22, 45));

        customFont15 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 15);
        customFont35 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 35);
        customFont70 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 70);

        // * Reservations Title * //
        resTitle = new JLabel("Hotels");
        resTitle.setFont(customFont35);
        resTitle.setForeground(Color.white);
        resTitle.setVerticalAlignment(JLabel.TOP);
        resTitle.setBounds(0, 0, 300, 100);

        // * Hotel Catalogue * //
        hotelCatalogue = new ArrayList<HotelOption>();

        for(int i = 0; i < nHotel; i++){
            HotelOption optionTemp = new HotelOption(hotels.get(i));
            initializeHotelOption(optionTemp, hotels.get(i), i);
            hotelCatalogue.add(optionTemp);
        }

        // * Container * //
        resContainerHeight = (nHotel + 1) * 10 + (nHotel * 110) + 70;

        resContainer = new RoundPanel(new Color(13, 22, 45));
        resContainer.setLayout(null);;
        resContainer.setPreferredSize(new Dimension(620, resContainerHeight));

        for (int i = 0; i < nHotel; i++){
            resContainer.add(hotelCatalogue.get(i));
        }

        ScrollPaneCustom scrollPane = new ScrollPaneCustom(resContainer, new Color(40, 68, 117), new Color(40, 68, 117), new Color(13, 22, 45));
        scrollPane.setBounds(0, 60, 620, 405);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        this.setLayout(null);
        this.setBounds(120, 80, 620, 470);
        this.add(resTitle);
        this.add(scrollPane);
    }

                                            // TODO: change to Hotel
    public void initializeHotelOption(HotelOption item, String hotel, int itemNo){

        String hotelName = hotel; // TODO: change to hotel name
        float price = 1299.00f; // TODO: change to hotel price

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
    }

    public JLabel getHotelTitle(){
        return resTitle;
    }

    public void setHotelTitle(JLabel resTitle){
        this.resTitle = resTitle;
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
