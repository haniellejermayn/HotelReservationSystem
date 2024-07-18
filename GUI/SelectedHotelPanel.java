import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class SelectedHotelPanel extends RoundPanel implements ActionListener, ButtonClickListener{
    
    private MainFrame mainFrame;
    //private ArrayList<String> hotels;
    
    private RoundPanel titlePanel;
    private RoundPanel viewPanel;
    private JLabel hotelName;
    private JLabel hotelPrice;
    private JLabel hotelRooms;
    private JLabel hotelRes;
    //private ArrayList<HotelOption> hotelCatalogue;
    private IconButton manageButton;
    private OptionButton bookButton;
    private BookHotelPanel bookPanel;
    private ManagePanel managePanel;
    private OptionButton dateAvailButton;
    private DateAvailPanel dateAvailPanel;
    private OptionButton roomInfoButton;
    private RoomInfoPanel roomInfoPanel;
    private OptionButton resInfoButton;
    //private ResInfoPanel resInfoPanel;
    //private boolean isVisible = false;

    Font customFont15;
    Font customFont35;
    Font customFont50;
    Font customFont70;

        // change to Hotel hotels
    SelectedHotelPanel(String hotel, MainFrame mainFrame){

        super(new Color(13, 22, 45));

        this.mainFrame = mainFrame;
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
        bookButton.addActionListener(this);

        // change icon
        ImageIcon manageIcon = new ImageIcon("Icons/StylusIcon.png"); // chage to manageIcon
        manageIcon = Customization.resizeIcon(manageIcon, 20, 20); 
        
        manageButton = new IconButton(manageIcon, "Manage");
        manageButton.setBounds(570, 130, 40, 40);
        manageButton.setColor(manageButton.getColorOver());
        manageButton.setColorOver(manageButton.getColorClick());
        manageButton.addActionListener(this);

        managePanel = new ManagePanel(new Color(51, 88, 150)); // create ManagePanel
        managePanel.setVisible(false);

        titlePanel = new RoundPanel(new Color(27, 43, 80));
        titlePanel.setLayout(null);
        titlePanel.setBounds(0, 0, 620, 180);
        titlePanel.add(hotelName);
        titlePanel.add(hotelPrice);
        titlePanel.add(hotelRooms);
        titlePanel.add(hotelRes);
        titlePanel.add(manageButton);
        titlePanel.add(managePanel);
        titlePanel.add(bookButton);

        bookPanel = new BookHotelPanel(hotel, this);
        bookPanel.setBounds(152, 10, 385, 420);

        dateAvailButton = new OptionButton("Date Availability"); 
        dateAvailButton.setBounds(90, 10, 140, 40);
        dateAvailButton.setColorClick(dateAvailButton.getColorOver());
        dateAvailButton.addActionListener(this);
        /*dateAvailButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){
                this.buttonClicked(dateAvailButton.getName());
            }
        });*/

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

        viewPanel = new RoundPanel(new Color(13, 22, 45));
        viewPanel.setLayout(null);
        viewPanel.setBounds(0, 190, 620, 280);
        viewPanel.add(dateAvailButton);
        viewPanel.add(dateAvailPanel);
        viewPanel.add(roomInfoButton);
        viewPanel.add(roomInfoPanel);
        viewPanel.add(resInfoButton);


        //dateAvailPanel.setVisible(false);
        roomInfoPanel.setVisible(false);
        




        this.setLayout(null);
        this.setBounds(120, 80, 620, 470);
        this.add(bookPanel);
        this.add(managePanel);
        this.add(titlePanel);
        this.add(viewPanel);


        bookPanel.setVisible(false);



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

    /*@Override
    public void buttonClicked(String buttonName) {

        // change to necessary information
        int nRooms = 30;
        String name;
        String type = "Deluxe";
        float pricePerNight = 1299.00f;

        for (int i = 0; i < nRooms; i++){
            String roomIndex = String.format("%02d", i + 1);
            String price = String.format("%.2f", pricePerNight * (i % 7)); // change later
            name = roomIndex; 

            if (buttonName.equals(roomIndex)){
                roomName.setText("Room " + name);
                roomPrice.setText(price + " per night");
                roomType.setText(type + " Room");
            }
        }
    }*/

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == dateAvailButton){
            dateAvailPanel.setVisible(true);
            roomInfoPanel.setVisible(false);
        }
        else if (e.getSource() == roomInfoButton){
            roomInfoPanel.setVisible(true);
            dateAvailPanel.setVisible(false);
        }
        else if (e.getSource() == bookButton){
            //mainFrame.darkenBackground(true); // fix
            bookPanel.setVisible(true);
        }
        else if (e.getSource() == manageButton){
            managePanel.setVisible(true);
        }
    }


    public OptionButton getBookButton(){
        return bookButton;
    }

    @Override
    public void buttonClicked(String buttonName) {
        if (buttonName.equals("Book")){
            bookPanel.setVisible(false);
        }
    }
}
