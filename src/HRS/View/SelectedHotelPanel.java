package src.HRS.View;

//import src.HRS.Model.*;

import javax.swing.*;

import src.HRS.Model.Hotel;

import java.awt.*;
import java.awt.event.*;

public class SelectedHotelPanel extends LayeredRoundPanel implements ActionListener, ButtonClickListener{
    
    private Hotel hotel;
    private int hotelIndex;
    
    private RoundPanel titlePanel;
    private RoundPanel viewPanel;
    private JLabel hotelName;
    private JLabel hotelPrice;
    private JLabel hotelRooms;
    private JLabel hotelRes;
    private JLabel hotelEarnings;

    private IconButton manageButton;
    private OptionButton bookButton;
    private BookHotelPanel bookPanel;
    private boolean hasBookPanel;
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

    public SelectedHotelPanel(Hotel hotel, int hotelIndex){

        super(new Color(13, 22, 45));

        this.hotel = hotel;
        this.hotelIndex = hotelIndex;

        customFont15 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 15);
        customFont35 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 35);
        customFont50 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 50);

        // * Hotel Info * //
        hotelName = new JLabel(hotel.getHotelName()); 
        hotelName.setFont(customFont35);
        hotelName.setForeground(Color.white);
        hotelName.setVerticalAlignment(JLabel.TOP);
        hotelName.setBounds(15, 20, 300, 50);
        
        hotelPrice = new JLabel(String.format("$%.2f", hotel.getBasePrice())); 
        hotelPrice.setFont(customFont50);
        hotelPrice.setForeground(Color.white);
        hotelPrice.setVerticalAlignment(JLabel.TOP);
        hotelPrice.setHorizontalAlignment(JLabel.RIGHT);
        hotelPrice.setBounds(300, 10, 300, 100);
        
        hotelRooms = new JLabel(String.valueOf(hotel.countRooms(0) + " rooms"));
        hotelRooms.setFont(customFont15);
        hotelRooms.setForeground(Color.white);
        hotelRooms.setVerticalAlignment(JLabel.TOP);
        hotelRooms.setBounds(17, 75, 300, 17);
        
        hotelRes = new JLabel(String.valueOf(hotel.countReservations() + " reservations"));
        hotelRes.setFont(customFont15);
        hotelRes.setForeground(Color.white);
        hotelRes.setVerticalAlignment(JLabel.TOP);
        hotelRes.setBounds(17, 100, 300, 17);

        hotelEarnings = new JLabel(String.valueOf("Earnings: " + hotel.computeEarnings()));
        hotelEarnings.setFont(customFont15);
        hotelEarnings.setForeground(Color.white);
        hotelEarnings.setVerticalAlignment(JLabel.TOP);
        hotelEarnings.setBounds(17, 125, 300, 20);

        bookButton = new OptionButton("Book"); 
        bookButton.setBounds(420, 130, 140, 40);
        bookButton.setColor(bookButton.getColorOver());
        bookButton.setColorOver(bookButton.getColorClick());
        bookButton.addActionListener(this);

        setHasBookPanel(false);

        ImageIcon manageIcon = new ImageIcon("Icons/StylusIcon.png"); 

        manageIcon = Customization.resizeIcon(manageIcon, 20, 20); 
        
        manageButton = new IconButton(manageIcon, "Manage");
        manageButton.setBounds(570, 130, 40, 40);
        manageButton.setColor(manageButton.getColorOver());
        manageButton.setColorOver(manageButton.getColorClick());
        manageButton.addActionListener(this);

        titlePanel = new RoundPanel(new Color(27, 43, 80));
        titlePanel.setLayout(null);
        titlePanel.setBounds(0, 0, 620, 180);
        titlePanel.add(hotelName);
        titlePanel.add(hotelPrice);
        titlePanel.add(hotelRooms);
        titlePanel.add(hotelRes);
        titlePanel.add(hotelEarnings);
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

        dateAvailPanel.setVisible(false);
        roomInfoPanel.setVisible(false);
        resInfoPanel.setVisible(false);        

        this.setLayout(null);
        this.setBounds(120, 80, 620, 470);
        this.add(titlePanel, JLayeredPane.DEFAULT_LAYER);
        this.add(viewPanel, JLayeredPane.DEFAULT_LAYER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }

    @Override
    public void buttonClicked(String buttonName) {
        
    }

    public RoundPanel getTitlePanel(){
        return titlePanel;
    }

    public void setTitlePanel(RoundPanel titlePanel){
        this.titlePanel = titlePanel;
    }

    public JLabel getHotelNameLabel(){
        return hotelName;
    }

    public void setHotelNameLabel(JLabel hotelName){
        this.hotelName = hotelName;
    }

    public JLabel getHotelPriceLabel(){
        return hotelPrice;
    }

    public void setHotelPriceLabel(JLabel hotelPrice){
        this.hotelPrice = hotelPrice;
    }

    public JLabel getHotelRoomsLabel(){
        return hotelRooms;
    }

    public void setHotelRoomsLabel(JLabel hotelRooms){
        this.hotelRooms = hotelRooms;
    }

    public JLabel getHotelResLabel(){
        return hotelRes;
    }

    public void setHotelResLabel(JLabel hotelRes){
        this.hotelRes = hotelRes;
    }
    
    public IconButton getManageButton(){
        return manageButton;
    }

    public void setManageButton(IconButton manageButton){
        this.manageButton = manageButton;
    }

    public OptionButton getBookButton(){
        return bookButton;
    }

    public void setBookButton(OptionButton bookButton){
        this.bookButton = bookButton;
    }

    public boolean hasBookPanel(){
        return hasBookPanel;
    }

    public void setHasBookPanel(boolean hasBookPanel){
        this.hasBookPanel = hasBookPanel;
    }

    public BookHotelPanel getBookPanel(){
        return bookPanel;
    }

    public void setBookPanel(BookHotelPanel bookPanel){
        this.bookPanel = bookPanel;
    }

    public ManagePanel getManagePanel(){
        return managePanel;
    }

    public void setManagePanel(ManagePanel managePanel){
        this.managePanel = managePanel;
    }

    public RoundPanel getViewPanel(){
        return viewPanel;
    }

    public void setViewPanel(RoundPanel viewPanel){
        this.viewPanel = viewPanel;
    }

    public OptionButton getDateAvailButton(){
        return dateAvailButton;
    }

    public void setDateAvailButton(OptionButton dateAvailButton){
        this.dateAvailButton = dateAvailButton;
    }

    public DateAvailPanel getDateAvailPanel(){
        return dateAvailPanel;
    }

    public void setDateAvailPanel(DateAvailPanel dateAvailPanel){
        this.dateAvailPanel = dateAvailPanel;
    }

    public OptionButton getRoomInfoButton(){
        return roomInfoButton;
    }

    public void setRoomInfoButton(OptionButton roomInfoButton){
        this.roomInfoButton = roomInfoButton;
    }

    public RoomInfoPanel getRoomInfoPanel(){
        return roomInfoPanel;
    }

    public void setRoomInfoPanel(RoomInfoPanel roomInfoPanel){
        this.roomInfoPanel = roomInfoPanel;
    }

    public OptionButton getResInfoButton(){
        return resInfoButton;
    }

    public void setResInfoButton(OptionButton resInfoButton){
        this.resInfoButton = resInfoButton;
    }

    public ResInfoPanel getResInfoPanel(){
        return resInfoPanel;
    }

    public void setResInfoPanel(ResInfoPanel resInfoPanel){
        this.resInfoPanel = resInfoPanel;
    }

    public Hotel getHotel(){
        return hotel;
    }

    public void setHotel(Hotel hotel){
        this.hotel = hotel;
    }

    public int getHotelIndex(){
        return hotelIndex;
    }

    public void setHotel(int hotelIndex){
        this.hotelIndex = hotelIndex;
    }

    public JLabel getHotelName(){
        return hotelName;
    }

    public void setHotelName(JLabel hotelName){
        this.hotelName = hotelName;
    }

    public JLabel getHotelPrice(){
        return hotelPrice;
    }

    public void setHotelPrice(JLabel hotelPrice){
        this.hotelPrice = hotelPrice;
    }

    public JLabel getHotelRooms(){
        return hotelRooms;
    }

    public void setHotelRooms(JLabel hotelRooms){
        this.hotelRooms = hotelRooms;
    }

    public JLabel getHotelRes(){
        return hotelRes;
    }

    public void setHotelRes(JLabel hotelRes){
        this.hotelRes = hotelRes;
    }
}
