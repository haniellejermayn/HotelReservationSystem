import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class SelectedHotelPanel extends LayeredRoundPanel implements ActionListener, ButtonClickListener{
    
    //private MainFrame mainFrame; // !: Darken background does not work
    private String hotel;
    // TODO: change String to Hotel
    
    private RoundPanel titlePanel;
    private RoundPanel viewPanel;
    private JLabel hotelName;
    private JLabel hotelPrice;
    private JLabel hotelRooms;
    private JLabel hotelRes;
    private IconButton manageButton;
    private OptionButton bookButton;
    private BookHotelPanel bookPanel;
    private ManagePanel managePanel;
    private OptionButton dateAvailButton;
    private DateAvailPanel dateAvailPanel;
    private OptionButton roomInfoButton;
    private RoomInfoPanel roomInfoPanel;
    private OptionButton resInfoButton;
    private ResInfoPanel resInfoPanel;

    private Font customFont15;
    private Font customFont35;
    private Font customFont50;

            // TODO: change to Hotel
    SelectedHotelPanel(String hotel, MainFrame mainFrame){

        super(new Color(13, 22, 45));

        //this.mainFrame = mainFrame; // !: Darken Background does not work
        this.hotel = hotel;

        customFont15 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 15);
        customFont35 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 35);
        customFont50 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 50);

        // * Hotel Info * //
        hotelName = new JLabel(hotel); // TODO: Change to hotel name
        hotelName.setFont(customFont35);
        hotelName.setForeground(Color.white);
        hotelName.setVerticalAlignment(JLabel.TOP);
        hotelName.setBounds(15, 20, 300, 50);
        
        hotelPrice = new JLabel("1,299.00"); // TODO: Change to hotel price
        hotelPrice.setFont(customFont50);
        hotelPrice.setForeground(Color.white);
        hotelPrice.setVerticalAlignment(JLabel.TOP);
        hotelPrice.setBounds(405, 10, 300, 100);
        
        hotelRooms = new JLabel("30 Rooms"); // TODO: Change to hotel rooms
        hotelRooms.setFont(customFont15);
        hotelRooms.setForeground(Color.white);
        hotelRooms.setVerticalAlignment(JLabel.TOP);
        hotelRooms.setBounds(17, 75, 300, 17);
        
        hotelRes = new JLabel("10 Reservations"); // TODO: Change to hotel reservations
        hotelRes.setFont(customFont15);
        hotelRes.setForeground(Color.white);
        hotelRes.setVerticalAlignment(JLabel.TOP);
        hotelRes.setBounds(17, 100, 300, 17);

        bookButton = new OptionButton("Book"); 
        bookButton.setBounds(420, 130, 140, 40);
        bookButton.setColor(bookButton.getColorOver());
        bookButton.setColorOver(bookButton.getColorClick());
        bookButton.addActionListener(this);

        ImageIcon manageIcon = new ImageIcon("Icons/StylusIcon.png"); 
        manageIcon = Customization.resizeIcon(manageIcon, 20, 20); 
        
        manageButton = new IconButton(manageIcon, "Manage");
        manageButton.setBounds(570, 130, 40, 40);
        manageButton.setColor(manageButton.getColorOver());
        manageButton.setColorOver(manageButton.getColorClick());
        manageButton.addActionListener(this);

        // !: Manage Panel not finished

        titlePanel = new RoundPanel(new Color(27, 43, 80));
        titlePanel.setLayout(null);
        titlePanel.setBounds(0, 0, 620, 180);
        titlePanel.add(hotelName);
        titlePanel.add(hotelPrice);
        titlePanel.add(hotelRooms);
        titlePanel.add(hotelRes);
        titlePanel.add(manageButton);
        titlePanel.add(bookButton);

        // * View Hotel * //
        dateAvailButton = new OptionButton("Date Availability"); 
        dateAvailButton.setBounds(90, 10, 140, 40);
        dateAvailButton.setColorClick(dateAvailButton.getColorOver());
        dateAvailButton.addActionListener(this);

        dateAvailPanel = new DateAvailPanel(hotel);
        dateAvailPanel.setBounds(40, 60, 540, 220);

        roomInfoButton = new OptionButton("Room Information"); 
        roomInfoButton.setBounds(240, 10, 140, 40);
        roomInfoButton.setColorClick(roomInfoButton.getColorOver());
        roomInfoButton.addActionListener(this);

        roomInfoPanel = new RoomInfoPanel(hotel);
        roomInfoPanel.setBounds(40, 60, 540, 220);

        resInfoButton = new OptionButton("Reservation Information"); 
        resInfoButton.setBounds(390, 10, 140, 40);
        resInfoButton.setColorClick(resInfoButton.getColorOver());
        resInfoButton.addActionListener(this);

        resInfoPanel = new ResInfoPanel(hotel);
        resInfoPanel.setBounds(40, 60, 540, 220);

        viewPanel = new RoundPanel(new Color(13, 22, 45));
        viewPanel.setLayout(null);
        viewPanel.setBounds(0, 190, 620, 280);
        viewPanel.add(dateAvailButton);
        viewPanel.add(dateAvailPanel);
        viewPanel.add(roomInfoButton);
        viewPanel.add(roomInfoPanel);
        viewPanel.add(resInfoButton);
        viewPanel.add(resInfoPanel);

        roomInfoPanel.setVisible(false);
        resInfoPanel.setVisible(false);        

        this.setLayout(null);
        this.setBounds(120, 80, 620, 470);
        this.add(titlePanel, JLayeredPane.DEFAULT_LAYER);
        this.add(viewPanel, JLayeredPane.DEFAULT_LAYER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == dateAvailButton){
            dateAvailPanel.setVisible(true);
            roomInfoPanel.setVisible(false);
            resInfoPanel.setVisible(false);
            dateAvailButton.setColor(new Color(40, 68, 117));
            roomInfoButton.setColor(new Color(27, 43, 80));
            resInfoButton.setColor(new Color(27, 43, 80));
        }
        else if (e.getSource() == roomInfoButton){
            dateAvailPanel.setVisible(false);
            roomInfoPanel.setVisible(true);
            resInfoPanel.setVisible(false);
            dateAvailButton.setColor(new Color(27, 43, 80));
            roomInfoButton.setColor(new Color(40, 68, 117));
            resInfoButton.setColor(new Color(27, 43, 80));
        }
        else if (e.getSource() == resInfoButton){
            dateAvailPanel.setVisible(false);
            roomInfoPanel.setVisible(false);
            resInfoPanel.setVisible(true);
            dateAvailButton.setColor(new Color(27, 43, 80));
            roomInfoButton.setColor(new Color(27, 43, 80));
            resInfoButton.setColor(new Color(40, 68, 117));
        }
        else if (e.getSource() == bookButton){
            //mainFrame.darkenBackground(true); // !: Darken Background does not work
            bookPanel = new BookHotelPanel(hotel, this);
            bookPanel.setBounds(152, 10, 385, 420);
            this.add(bookPanel, JLayeredPane.POPUP_LAYER);
        }
        else if (e.getSource() == manageButton){
            managePanel = new ManagePanel(hotel, this, new Color(51, 88, 150)); 
            this.add(managePanel, JLayeredPane.POPUP_LAYER);
        }
    }

    public OptionButton getBookButton(){
        return bookButton;
    }

    @Override
    public void buttonClicked(String buttonName) {
        if (buttonName.equals("Book")){
            bookPanel.setVisible(false);
            this.remove(bookPanel);
        }
        else if (buttonName.equals("Book Cancel")){
            bookPanel.setVisible(false);
            this.remove(bookPanel);
        }
        else if (buttonName.equals("Change Name")){
            managePanel.setVisible(false);
            this.remove(managePanel);
        }
        else if (buttonName.equals("Add Room")){
            managePanel.setVisible(false);
            this.remove(managePanel);
        }
        else if (buttonName.equals("Update Base Price")){
            managePanel.setVisible(false);
            this.remove(managePanel);
        }
        else if (buttonName.equals("Date Price Modifier")){
            managePanel.setVisible(false);
            this.remove(managePanel);
        }
        else if (buttonName.equals("Remove Room")){
            managePanel.setVisible(false);
            this.remove(managePanel);
        }
        else if (buttonName.equals("Remove Reservation")){
            managePanel.setVisible(false);
            this.remove(managePanel);
        }
        else if (buttonName.equals("Remove Hotel")){
            managePanel.setVisible(false);
            this.remove(managePanel);
        }
        else if (buttonName.equals("Manage Cancel")){
            managePanel.setVisible(false);
            this.remove(managePanel);
        }
    }
}
