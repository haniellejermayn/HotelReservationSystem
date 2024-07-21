import javax.swing.*;
import java.awt.*;
import java.util.*;

public class HomePanel extends RoundPanel{
    
    JLabel hotelTitle;
    RoundPanel titlePanel;
    RoundLabel title;
    RoundLabel description;
    ArrayList<HotelItem> hotelCatalogue;

    Font customFont15;
    Font customFont30;
    Font customFont90;

        // TODO: change to Hotel hotels
    HomePanel(ArrayList<String> hotels, int nHotel){

        super(new Color(13, 22, 45));

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

        for(int i = 0; i < nHotel; i++){
            HotelItem itemTemp = new HotelItem(hotels.get(i));
            initializeHotelItem(itemTemp, hotels.get(i), i);
            hotelCatalogue.add(itemTemp);
        }

        this.setLayout(null);
        this.setBounds(120, 80, 620, 470);
        this.add(hotelTitle);
        this.add(titlePanel);
        this.add(star);

        for (int i = 0; i < nHotel; i++){
            this.add(hotelCatalogue.get(i));
        }
    }

                                // TODO: change to Hotel
    public void initializeHotelItem(HotelItem item, String hotel, int itemNo){

        String hotelName = hotel; // TODO: change to hotel name

        item.setBounds(itemNo * 190 + (itemNo * 25), 240, 190, 230);
        item.setLayout(null);

        RoundLabel content = item.getContent();
        content.setText(hotelName);
        item.setVerticalAlignment(JLabel.BOTTOM);
        
        item.setFocusable(false);
    }   
}
