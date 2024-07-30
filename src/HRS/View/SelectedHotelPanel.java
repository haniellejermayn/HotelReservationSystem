package src.HRS.View;

import java.awt.*;
import javax.swing.*;
import src.HRS.Model.Hotel;

/**
 * The SelectedHotelPanel class represents a panel that displays detailed information
 * about a selected hotel. It includes hotel information, buttons for managing the hotel,
 * booking a room, and viewing date availability, room information, and reservation information.
 */
public class SelectedHotelPanel extends LayeredRoundPanel {
    
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

    /**
     * Constructs a new SelectedHotelPanel for the specified hotel and hotel index.
     *
     * @param hotel the hotel to display information for
     * @param hotelIndex the index of the hotel
     */
    public SelectedHotelPanel(Hotel hotel, int hotelIndex) {
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

        hotelEarnings = new JLabel(String.valueOf("Earnings: $" + hotel.computeEarnings()));
        hotelEarnings.setFont(customFont15);
        hotelEarnings.setForeground(Color.white);
        hotelEarnings.setVerticalAlignment(JLabel.TOP);
        hotelEarnings.setBounds(17, 125, 300, 20);

        bookButton = new OptionButton("Book"); 
        bookButton.setBounds(420, 130, 140, 40);
        bookButton.setColor(bookButton.getColorOver());
        bookButton.setColorOver(bookButton.getColorClick());

        setHasBookPanel(false);

        ImageIcon manageIcon = new ImageIcon("Icons/StylusIcon.png"); 
        manageIcon = Customization.resizeIcon(manageIcon, 20, 20); 
        manageButton = new IconButton(manageIcon, "Manage");
        manageButton.setBounds(570, 130, 40, 40);
        manageButton.setColor(manageButton.getColorOver());
        manageButton.setColorOver(manageButton.getColorClick());

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
        dateAvailPanel = new DateAvailPanel(hotel);
        dateAvailPanel.setBounds(40, 60, 540, 220);

        roomInfoButton = new OptionButton("Room Information"); 
        roomInfoButton.setBounds(240, 10, 140, 40);
        roomInfoButton.setColorClick(roomInfoButton.getColorOver());
        roomInfoPanel = new RoomInfoPanel(hotel);
        roomInfoPanel.setBounds(40, 60, 540, 220);

        resInfoButton = new OptionButton("Reservation Information"); 
        resInfoButton.setBounds(390, 10, 140, 40);
        resInfoButton.setColorClick(resInfoButton.getColorOver());
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

    /**
     * Returns the title panel.
     *
     * @return the title panel
     */
    public RoundPanel getTitlePanel() {
        return titlePanel;
    }

    /**
     * Sets the title panel.
     *
     * @param titlePanel the title panel to set
     */
    public void setTitlePanel(RoundPanel titlePanel) {
        this.titlePanel = titlePanel;
    }

    /**
     * Returns the hotel name label.
     *
     * @return the hotel name label
     */
    public JLabel getHotelNameLabel() {
        return hotelName;
    }

    /**
     * Sets the hotel name label.
     *
     * @param hotelName the hotel name label to set
     */
    public void setHotelNameLabel(JLabel hotelName) {
        this.hotelName = hotelName;
    }

    /**
     * Returns the hotel price label.
     *
     * @return the hotel price label
     */
    public JLabel getHotelPriceLabel() {
        return hotelPrice;
    }

    /**
     * Sets the hotel price label.
     *
     * @param hotelPrice the hotel price label to set
     */
    public void setHotelPriceLabel(JLabel hotelPrice) {
        this.hotelPrice = hotelPrice;
    }

    /**
     * Returns the hotel rooms label.
     *
     * @return the hotel rooms label
     */
    public JLabel getHotelRoomsLabel() {
        return hotelRooms;
    }

    /**
     * Sets the hotel rooms label.
     *
     * @param hotelRooms the hotel rooms label to set
     */
    public void setHotelRoomsLabel(JLabel hotelRooms) {
        this.hotelRooms = hotelRooms;
    }

    /**
     * Returns the hotel reservations label.
     *
     * @return the hotel reservations label
     */
    public JLabel getHotelResLabel() {
        return hotelRes;
    }

    /**
     * Sets the hotel reservations label.
     *
     * @param hotelRes the hotel reservations label to set
     */
    public void setHotelResLabel(JLabel hotelRes) {
        this.hotelRes = hotelRes;
    }
    
    /**
     * Returns the manage button.
     *
     * @return the manage button
     */
    public IconButton getManageButton() {
        return manageButton;
    }

    /**
     * Sets the manage button.
     *
     * @param manageButton the manage button to set
     */
    public void setManageButton(IconButton manageButton) {
        this.manageButton = manageButton;
    }

    /**
     * Returns the book button.
     *
     * @return the book button
     */
    public OptionButton getBookButton() {
        return bookButton;
    }

    /**
     * Sets the book button.
     *
     * @param bookButton the book button to set
     */
    public void setBookButton(OptionButton bookButton) {
        this.bookButton = bookButton;
    }

    /**
     * Returns whether the book panel is visible.
     *
     * @return true if the book panel is visible, false otherwise
     */
    public boolean hasBookPanel() {
        return hasBookPanel;
    }

    /**
     * Sets whether the book panel is visible.
     *
     * @param hasBookPanel true to make the book panel visible, false otherwise
     */
    public void setHasBookPanel(boolean hasBookPanel) {
        this.hasBookPanel = hasBookPanel;
    }

    /**
     * Returns the book panel.
     *
     * @return the book panel
     */
    public BookHotelPanel getBookPanel() {
        return bookPanel;
    }

    /**
     * Sets the book panel.
     *
     * @param bookPanel the book panel to set
     */
    public void setBookPanel(BookHotelPanel bookPanel) {
        this.bookPanel = bookPanel;
    }

    /**
     * Returns the manage panel.
     *
     * @return the manage panel
     */
    public ManagePanel getManagePanel() {
        return managePanel;
    }

    /**
     * Sets the manage panel.
     *
     * @param managePanel the manage panel to set
     */
    public void setManagePanel(ManagePanel managePanel) {
        this.managePanel = managePanel;
    }

    /**
     * Returns the view panel.
     *
     * @return the view panel
     */
    public RoundPanel getViewPanel() {
        return viewPanel;
    }

    /**
     * Sets the view panel.
     *
     * @param viewPanel the view panel to set
     */
    public void setViewPanel(RoundPanel viewPanel) {
        this.viewPanel = viewPanel;
    }

    /**
     * Returns the date availability button.
     *
     * @return the date availability button
     */
    public OptionButton getDateAvailButton() {
        return dateAvailButton;
    }

    /**
     * Sets the date availability button.
     *
     * @param dateAvailButton the date availability button to set
     */
    public void setDateAvailButton(OptionButton dateAvailButton) {
        this.dateAvailButton = dateAvailButton;
    }

    /**
     * Returns the date availability panel.
     *
     * @return the date availability panel
     */
    public DateAvailPanel getDateAvailPanel() {
        return dateAvailPanel;
    }

    /**
     * Sets the date availability panel.
     *
     * @param dateAvailPanel the date availability panel to set
     */
    public void setDateAvailPanel(DateAvailPanel dateAvailPanel) {
        this.dateAvailPanel = dateAvailPanel;
    }

    /**
     * Returns the room information button.
     *
     * @return the room information button
     */
    public OptionButton getRoomInfoButton() {
        return roomInfoButton;
    }

    /**
     * Sets the room information button.
     *
     * @param roomInfoButton the room information button to set
     */
    public void setRoomInfoButton(OptionButton roomInfoButton) {
        this.roomInfoButton = roomInfoButton;
    }

    /**
     * Returns the room information panel.
     *
     * @return the room information panel
     */
    public RoomInfoPanel getRoomInfoPanel() {
        return roomInfoPanel;
    }

    /**
     * Sets the room information panel.
     *
     * @param roomInfoPanel the room information panel to set
     */
    public void setRoomInfoPanel(RoomInfoPanel roomInfoPanel) {
        this.roomInfoPanel = roomInfoPanel;
    }

    /**
     * Returns the reservation information button.
     *
     * @return the reservation information button
     */
    public OptionButton getResInfoButton() {
        return resInfoButton;
    }

    /**
     * Sets the reservation information button.
     *
     * @param resInfoButton the reservation information button to set
     */
    public void setResInfoButton(OptionButton resInfoButton) {
        this.resInfoButton = resInfoButton;
    }

    /**
     * Returns the reservation information panel.
     *
     * @return the reservation information panel
     */
    public ResInfoPanel getResInfoPanel() {
        return resInfoPanel;
    }

    /**
     * Sets the reservation information panel.
     *
     * @param resInfoPanel the reservation information panel to set
     */
    public void setResInfoPanel(ResInfoPanel resInfoPanel) {
        this.resInfoPanel = resInfoPanel;
    }

    /**
     * Returns the hotel.
     *
     * @return the hotel
     */
    public Hotel getHotel() {
        return hotel;
    }

    /**
     * Sets the hotel.
     *
     * @param hotel the hotel to set
     */
    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    /**
     * Returns the hotel index.
     *
     * @return the hotel index
     */
    public int getHotelIndex() {
        return hotelIndex;
    }

    /**
     * Sets the hotel index.
     *
     * @param hotelIndex the hotel index to set
     */
    public void setHotelIndex(int hotelIndex) {
        this.hotelIndex = hotelIndex;
    }

    /**
     * Returns the hotel name.
     *
     * @return the hotel name
     */
    public JLabel getHotelName() {
        return hotelName;
    }

    /**
     * Sets the hotel name.
     *
     * @param hotelName the hotel name to set
     */
    public void setHotelName(JLabel hotelName) {
        this.hotelName = hotelName;
    }

    /**
     * Returns the hotel price.
     *
     * @return the hotel price
     */
    public JLabel getHotelPrice() {
        return hotelPrice;
    }

    /**
     * Sets the hotel price.
     *
     * @param hotelPrice the hotel price to set
     */
    public void setHotelPrice(JLabel hotelPrice) {
        this.hotelPrice = hotelPrice;
    }

    /**
     * Returns the hotel rooms.
     *
     * @return the hotel rooms
     */
    public JLabel getHotelRooms() {
        return hotelRooms;
    }

    /**
     * Sets the hotel rooms.
     *
     * @param hotelRooms the hotel rooms to set
     */
    public void setHotelRooms(JLabel hotelRooms) {
        this.hotelRooms = hotelRooms;
    }

    /**
     * Returns the hotel reservations.
     *
     * @return the hotel reservations
     */
    public JLabel getHotelRes() {
        return hotelRes;
    }

    /**
     * Sets the hotel reservations.
     *
     * @param hotelRes the hotel reservations to set
     */
    public void setHotelRes(JLabel hotelRes) {
        this.hotelRes = hotelRes;
    }
}
