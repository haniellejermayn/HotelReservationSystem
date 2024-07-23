package GUI;

import hrs.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;

public class HomePanel extends RoundPanel{
    
    private RoundPanel fillerPanel;
    private RoundLabel title;
    private RoundLabel description;
    private JLabel hotelTitle;
    private ArrayList<HotelItem> hotelCatalogue;

    private Font customFont15;
    private Font customFont30;
    private Font customFont90;

    public HomePanel(ArrayList<Hotel> hotels, int nHotels){

        super(new Color(13, 22, 45));

        customFont15 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 15);
        customFont30 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 30);
        customFont90 = Customization.createCustomFont("Fonts/POPPINS-BOLD.TTF", 90);

        title = new RoundLabel(new Color(27, 43, 80));
        //title = new RoundLabel(Color.red);
        title.setBounds(23, 15, 500, 115);
        title.setFont(customFont90);
        title.setForeground(Color.white);
        title.setText("NOIR HRS");
        
        description = new RoundLabel(new Color(27, 43, 80));
        //description = new RoundLabel(Color.blue);
        description.setBounds(28, 120, 430, 30);
        description.setFont(customFont15);
        description.setForeground(Color.white);
        description.setText("Highest rated hotel reservation system");

        fillerPanel = new RoundPanel(new Color(27, 43, 80));
        fillerPanel.setLayout(null);
        fillerPanel.setBounds(0, 0, 480, 170);
        fillerPanel.setBackground(new Color(27, 43, 80));
        fillerPanel.add(title);
        fillerPanel.add(description);

        ImageIcon starIcon = new ImageIcon("Icons/BadgeIcon.png");
        starIcon = Customization.resizeIcon(starIcon, 170, 170);

        JLabel star = new JLabel();
        star.setIcon(starIcon);
        star.setBounds(470, 0, 130, 170);

        hotelTitle = new JLabel("Hotels");
        hotelTitle.setFont(customFont30);
        hotelTitle.setForeground(Color.white);
        hotelTitle.setBounds(0, 160, 300, 100);

        // if (hotels[] != EMPTY)
        hotelCatalogue = new ArrayList<HotelItem>();

        // Room rooms;
        for(int i = 0; i < nHotels; i++){
            HotelItem itemTemp = new HotelItem(hotels.get(i).getHotelName());
            // add function initializeHotelItem(buttonTemp, hotels.get(i).getHotelName, rooms.getBasePrice())
            initializeHotelItem(itemTemp, hotels.get(i).getHotelName(), i);
            hotelCatalogue.add(itemTemp);
        }


        ImageIcon titleIcon = new ImageIcon("Icons/HRS_Logo&Name.jpg");
        titleIcon = Customization.resizeIcon(titleIcon, 400, 100);

        RoundLabel title = new RoundLabel(new Color(27, 43, 80));
        title.setIcon(titleIcon);

        this.setLayout(null);
        this.setBounds(120, 80, 620, 470);
        this.add(hotelTitle);
        this.add(fillerPanel);
        this.add(star);

        for (int i = 0; i < nHotels; i++){
            this.add(hotelCatalogue.get(i));
        }
        



        // fix

        /*scrollPane = new JScrollPane(homePage);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);*/

    }

    public void initializeHotelItem(HotelItem item, String hotelName, int itemNo){

        /* String hotelName = Hotel.getName()
            * item.setText("<html><body style='text-align:center;width:100px'>" + hotelName + "</body></html>");
            */

        item.setBounds(itemNo * 190 + (itemNo * 25), 240, 190, 230); // fix
        item.setLayout(null);

        RoundLabel content = item.getContent();
        content.setText(hotelName);
        item.setVerticalAlignment(JLabel.BOTTOM);
        
        item.setFocusable(false);
    }   
}
