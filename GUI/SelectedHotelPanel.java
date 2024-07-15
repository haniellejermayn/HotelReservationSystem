import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class SelectedHotelPanel extends RoundPanel{
    
    private RoundPanel titlePanel;
    private RoundPanel viewPanel;
    private JLabel hotelName;
    private JLabel hotelPrice;
    private JLabel hotelRooms;
    private JLabel hotelRes;
    //private ArrayList<HotelOption> hotelCatalogue;
    private IconButton manageButton;
    private OptionButton bookButton;
    private ManagePanel managePanel;
    private OptionButton dateAvailButton;
    private DateAvailPanel dateAvailPanel;
    private OptionButton roomInfoButton;
    //private RoomInfoPanel roomInfoPanel;
    private OptionButton resInfoButton;
    //private ResInfoPanel resInfoPanel;
    //private boolean isVisible = false;

    Font customFont15;
    Font customFont35;
    Font customFont50;
    Font customFont70;

        // change to Hotel hotels
    SelectedHotelPanel(String hotel){

        super(new Color(13, 22, 45));
        //super(Color.blue);

        customFont15 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 15);
        customFont35 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 35);
        customFont70 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 70);
        customFont50 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 50);

        hotelName = new JLabel(hotel);
        hotelName.setFont(customFont35);
        hotelName.setForeground(Color.white);
        //hotelName.setBackground(Color.black);
        hotelName.setVerticalAlignment(JLabel.TOP);
        hotelName.setBounds(15, 20, 300, 50);
        
        hotelPrice = new JLabel("1,299.00");
        hotelPrice.setFont(customFont50);
        hotelPrice.setForeground(Color.white);
        //hotelPrice.setBackground(Color.black);
        hotelPrice.setVerticalAlignment(JLabel.TOP);
        hotelPrice.setBounds(405, 10, 300, 100);
        
        hotelRooms = new JLabel("30 Rooms");
        hotelRooms.setFont(customFont15);
        hotelRooms.setForeground(Color.white);
        //hotelName.setBackground(Color.black);
        hotelRooms.setVerticalAlignment(JLabel.TOP);
        hotelRooms.setBounds(17, 75, 300, 17);
        
        hotelRes = new JLabel("10 Reservations");
        hotelRes.setFont(customFont15);
        hotelRes.setForeground(Color.white);
        //hotelName.setBackground(Color.black);
        hotelRes.setVerticalAlignment(JLabel.TOP);
        hotelRes.setBounds(17, 100, 300, 17);

        bookButton = new OptionButton("Book"); 
        bookButton.setBounds(420, 130, 140, 40);
        bookButton.setColor(bookButton.getColorOver());
        bookButton.setColorOver(bookButton.getColorClick());

        // change icon
        ImageIcon manageIcon = new ImageIcon("Icons/StylusIcon.png"); // chage to manageIcon
        manageIcon = Customization.resizeIcon(manageIcon, 20, 20); 
        
        manageButton = new IconButton(manageIcon, "Manage");
        manageButton.setBounds(570, 130, 40, 40);
        manageButton.setColor(manageButton.getColorOver());
        manageButton.setColorOver(manageButton.getColorClick());
        //manageButton.addActionListener(this);

        managePanel = new ManagePanel(new Color(40, 68, 117)); // create ManagePanel
        managePanel.setVisible(false);

        titlePanel = new RoundPanel(new Color(27, 43, 80));
        //titlePanel = new RoundPanel(Color.red);
        titlePanel.setLayout(null);
        titlePanel.setBounds(0, 0, 620, 180);
        titlePanel.add(hotelName);
        titlePanel.add(hotelPrice);
        titlePanel.add(hotelRooms);
        titlePanel.add(hotelRes);
        titlePanel.add(manageButton);
        titlePanel.add(managePanel);
        titlePanel.add(bookButton);

        dateAvailButton = new OptionButton("Date Availability"); 
        dateAvailButton.setBounds(90, 10, 140, 40);
        //dateAvailButton.setColor(bookButton.getColorOver());
        //dateAvailButton.setColorOver(bookButton.getColorClick());
        dateAvailButton.setColorClick(dateAvailButton.getColorOver());

        dateAvailPanel = new DateAvailPanel(hotel);
        dateAvailPanel.setBounds(50, 60, 520, 220);

        roomInfoButton = new OptionButton("Room Information"); 
        roomInfoButton.setBounds(240, 10, 140, 40);
        //dateAvailButton.setColor(bookButton.getColorOver());
        //dateAvailButton.setColorOver(bookButton.getColorClick());
        roomInfoButton.setColorClick(roomInfoButton.getColorOver());

        resInfoButton = new OptionButton("Reservation Information"); 
        resInfoButton.setBounds(390, 10, 140, 40);
        //dateAvailButton.setColor(bookButton.getColorOver());
        //dateAvailButton.setColorOver(bookButton.getColorClick());
        resInfoButton.setColorClick(resInfoButton.getColorOver());

        viewPanel = new RoundPanel(new Color(13, 22, 45));
        //viewPanel = new RoundPanel(Color.red);
        viewPanel.setLayout(null);
        viewPanel.setBounds(0, 190, 620, 280);
        viewPanel.add(dateAvailButton);
        viewPanel.add(dateAvailPanel);
        viewPanel.add(roomInfoButton);
        viewPanel.add(resInfoButton);
        




        this.setLayout(null);
        this.setBounds(120, 80, 620, 470);
        this.add(titlePanel);
        this.add(viewPanel);






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
