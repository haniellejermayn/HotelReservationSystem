import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class SelectedHotelPanel extends RoundPanel{
    
    private RoundPanel titlePanel;
    private JLabel hotelName;
    //private ArrayList<HotelOption> hotelCatalogue;
    private OptionButton bookButton;
    private IconButton manageButton;
    private ManagePanel managePanel;
    //private DateAvailPanel dateAvailPanel;
    //private RoomInfoPanel roomInfoPanel;
    //private ResInfoPanel resInfoPanel;
    //private boolean isVisible = false;


    Font customFont15;
    Font customFont35;
    Font customFont70;

        // change to Hotel hotels
    SelectedHotelPanel(String hotels){

        //super(new Color(13, 22, 45));
        super(Color.blue);

        customFont15 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 15);
        customFont35 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 35);
        customFont70 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 70);

        hotelName = new JLabel(hotels);
        hotelName.setFont(customFont35);
        hotelName.setForeground(Color.white);
        hotelName.setVerticalAlignment(JLabel.TOP);
        hotelName.setBounds(0, 0, 300, 100);


        ImageIcon manageIcon = new ImageIcon("Icons/FilterIcon.png"); // chage to manageIcon
        manageIcon = Customization.resizeIcon(manageIcon, 20, 20); 
        
        manageButton = new IconButton(manageIcon, "Manage");
        manageButton.setBounds(570, 0, 40, 40);
        manageButton.setColorClick(manageButton.getColorOver());
        //manageButton.addActionListener(this);

        managePanel = new ManagePanel(new Color(40, 68, 117)); // create ManagePanel
        managePanel.setVisible(false);

        bookButton = new OptionButton("Book"); // add picture
        bookButton.setBounds(285, 130, 100, 50);

        titlePanel = new RoundPanel(new Color(27, 43, 80));

        this.setLayout(null);
        this.setBounds(120, 80, 620, 470);
        this.add(hotelName);
        this.add(manageButton);
        this.add(managePanel);
        this.add(bookButton);






        // fix

        /*scrollPane = new JScrollPane(homePage);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);*/
        
    }

    /*@Override
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
    }*/
}
