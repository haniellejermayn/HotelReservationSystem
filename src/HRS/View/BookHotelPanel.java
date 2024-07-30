package src.HRS.View;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import src.HRS.Model.Hotel;

/**
 * The BookHotelPanel class represents a panel for booking a hotel room.
 * It allows the user to select a room type, check-in and check-out dates, and apply a discount code.
 */
public class BookHotelPanel extends RoundPanel{

    private RoundLabel bookingTitle;
    private BookCalendar calendar;
    private RoundPanel bookContainer;
    private RoundLabel roomTypeTitle;
    private RoundPanel roomType;
    private RoundLabel checkInNOut;

    private TextFieldCustom guestNameTextField;
    private boolean roomTypeSelected;
    private boolean checkInNOutSelected;
    private OptionButton standardRoomButton, deluxeRoomButton, executiveRoomButton;
    private OptionButton bookButton;
    private IconButton cancelButton;

    private TextFieldCustom discountTextField;

    private int roomTypeInput;
    private int checkInInput, checkOutInput;

    private ArrayList<OptionButton> days;
    private ArrayList<String> clickedButtons;

    private Font customFont13;
    private Font customFont30;

    /**
     * Constructs a new BookHotelPanel for the specified hotel.
     *
     * @param hotel the Hotel object to be used for booking
     */
    public BookHotelPanel(Hotel hotel){

        super(new Color(51, 88, 150));

        customFont13 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 13);
        customFont30 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 30);

        // * Title * //
        bookingTitle = new RoundLabel(new Color(51, 88, 150));
        bookingTitle.setBounds(8, 10, 200, 40);
        bookingTitle.setText("Booking");
        bookingTitle.setFont(customFont30);
        bookingTitle.setForeground(Color.white);

        // * Guest Name * //
        guestNameTextField = new TextFieldCustom(new Color(40, 68, 117));
        guestNameTextField.setBounds(5, 10, 355, 55);
        guestNameTextField.setFieldName("Name");

        // * Room Types * //
        roomTypeSelected = false; 

        standardRoomButton = new OptionButton("Standard");
        standardRoomButton.setBounds(32, 28, 100, 30);
        standardRoomButton.setColorOver(standardRoomButton.getColorClick());
        
        deluxeRoomButton = new OptionButton("Deluxe");
        deluxeRoomButton.setBounds(137, 28, 100, 30);
        deluxeRoomButton.setColorOver(deluxeRoomButton.getColorClick());
        
        executiveRoomButton = new OptionButton("Executive");
        executiveRoomButton.setBounds(242, 28, 100, 30);
        executiveRoomButton.setColorOver(executiveRoomButton.getColorClick());

        roomTypeTitle = new RoundLabel(new Color(40, 68, 117));
        roomTypeTitle.setBounds(8, 1, 100, 20);
        roomTypeTitle.setText("Room Type");
        roomTypeTitle.setFont(customFont13);
        roomTypeTitle.setForeground(Color.white);
        
        roomType = new RoundPanel(new Color(40, 68, 117));
        roomType.setLayout(null);
        roomType.setBounds(5, 95, 350, 60);
        roomType.add(roomTypeTitle);
        roomType.add(standardRoomButton);
        roomType.add(deluxeRoomButton);
        roomType.add(executiveRoomButton);

        // * Check In / Out * //
        checkInNOutSelected = false;

        checkInNOut = new RoundLabel(new Color(40, 68, 117));
        checkInNOut.setBounds(13, 185, 200, 20);
        checkInNOut.setText("Check in / Check Out");
        checkInNOut.setFont(customFont13);
        checkInNOut.setForeground(Color.white);

        clickedButtons = new ArrayList<String>();

        calendar = new BookCalendar();
        calendar.setBounds(18, 220, 335, 203);
        days = calendar.getDays();
        days.get(30).setEnabled(false);
        days.get(30).setColor(new Color(27, 43, 80));
        days.get(30).setColorOver(new Color(27, 43, 80));
        days.get(30).setColorClick(new Color(27, 43, 80));

        discountTextField = new TextFieldCustom(new Color(40, 68, 117));
        discountTextField.setBounds(5, 460, 355, 55);
        discountTextField.setFieldName("Discount Code");

        // * Book Button * //
        bookButton = new OptionButton("Book");
        bookButton.setBounds(260, 540, 100, 30);
        bookButton.setColorOver(bookButton.getColorClick());

        // * Cancel * //
        ImageIcon cancelIcon = new ImageIcon("Icons/CancelIcon.png");
        cancelIcon = Customization.resizeIcon(cancelIcon, 20, 20); 

        cancelButton = new IconButton(cancelIcon, "Book Cancel");
        cancelButton.setBounds(335, 8, 40, 40);
        cancelButton.setColorClick(bookButton.getColorOver());

        // * Container * //
        bookContainer = new RoundPanel(new Color(40, 68, 117));
        bookContainer.setLayout(null);
        bookContainer.setPreferredSize(new Dimension(530, 585));
        bookContainer.add(checkInNOut);
        bookContainer.add(guestNameTextField);
        bookContainer.add(roomType);
        bookContainer.add(calendar);
        bookContainer.add(discountTextField);
        bookContainer.add(bookButton);

        ScrollPaneCustom scrollPane = new ScrollPaneCustom(bookContainer, new Color(27, 43, 80), new Color(27, 43, 80), new Color(40, 68, 117));
        scrollPane.setBounds(5, 55, 375, 360);

        this.setLayout(null);
        this.add(bookingTitle);
        this.add(cancelButton);
        this.add(scrollPane);
    }

    /**
     * Gets the guest name text field.
     *
     * @return the TextFieldCustom object for guest name
     */
    public TextFieldCustom getGuestNameTextField(){
        return guestNameTextField;
    }

    /**
     * Sets the guest name text field.
     *
     * @param guestNameTextField the TextFieldCustom object for guest name
     */
    public void setGuestNameTextField(TextFieldCustom guestNameTextField){
        this.guestNameTextField = guestNameTextField;
    }

    /**
     * Gets the standard room button.
     *
     * @return the OptionButton for standard room
     */
    public OptionButton getStandardRoomButton(){
        return standardRoomButton;
    }

    /**
     * Sets the standard room button.
     *
     * @param standardRoomButton the OptionButton for standard room
     */
    public void setStandardRoomButton(OptionButton standardRoomButton){
        this.standardRoomButton = standardRoomButton;
    }
    
    /**
     * Gets the deluxe room button.
     *
     * @return the OptionButton for deluxe room
     */
    public OptionButton getDeluxeRoomButton() {
        return deluxeRoomButton;
    }

    /**
     * Sets the deluxe room button.
     *
     * @param deluxeRoomButton the OptionButton for deluxe room
     */
    public void setDeluxeRoomButton(OptionButton deluxeRoomButton) {
        this.deluxeRoomButton = deluxeRoomButton;
    }

    /**
     * Gets the executive room button.
     *
     * @return the OptionButton for executive room
     */
    public OptionButton getExecutiveRoomButton() {
        return executiveRoomButton;
    }

    /**
     * Sets the executive room button.
     *
     * @param executiveRoomButton the OptionButton for executive room
     */
    public void setExecutiveRoomButton(OptionButton executiveRoomButton) {
        this.executiveRoomButton = executiveRoomButton;
    }

    /**
     * Gets the room type input.
     *
     * @return the int representing the room type input
     */
    public int getRoomTypeInput() {
        return roomTypeInput;
    }

    /**
     * Sets the room type input.
     *
     * @param roomTypeInput the int representing the room type input
     */
    public void setRoomTypeInput(int roomTypeInput) {
        this.roomTypeInput = roomTypeInput;
    }

    /**
     * Gets the BookCalendar object.
     *
     * @return the BookCalendar object
     */
    public BookCalendar getBookCalendar() {
        return calendar;
    }

    /**
     * Sets the BookCalendar object.
     *
     * @param calendar the BookCalendar object
     */
    public void setBookCalendar(BookCalendar calendar) {
        this.calendar = calendar;
    }

    /**
     * Gets the check-in input.
     *
     * @return the int representing the check-in input
     */
    public int getCheckInInput() {
        return checkInInput;
    }

    /**
     * Sets the check-in input.
     *
     * @param checkInInput the int representing the check-in input
     */
    public void setCheckInInput(int checkInInput) {
        this.checkInInput = checkInInput;
    }

    /**
     * Gets the check-out input.
     *
     * @return the int representing the check-out input
     */
    public int getCheckOutInput() {
        return checkOutInput;
    }

    /**
     * Sets the check-out input.
     *
     * @param checkOutInput the int representing the check-out input
     */
    public void setCheckOutInput(int checkOutInput) {
        this.checkOutInput = checkOutInput;
    }

    /**
     * Gets the room type selection status.
     *
     * @return true if room type is selected, false otherwise
     */
    public boolean getRoomTypeSelected() {
        return roomTypeSelected;
    }

    /**
     * Sets the room type selection status.
     *
     * @param roomTypeSelected the boolean representing the room type selection status
     */
    public void setRoomTypeSelected(boolean roomTypeSelected) {
        this.roomTypeSelected = roomTypeSelected;
    }

    /**
     * Gets the list of days as OptionButtons.
     *
     * @return the ArrayList of OptionButton objects representing days
     */
    public ArrayList<OptionButton> getDays() {
        return days;
    }

    /**
     * Sets the list of days as OptionButtons.
     *
     * @param days the ArrayList of OptionButton objects representing days
     */
    public void setDays(ArrayList<OptionButton> days) {
        this.days = days;
    }

    /**
     * Gets the list of clicked buttons as strings.
     *
     * @return the ArrayList of String objects representing clicked buttons
     */
    public ArrayList<String> getClickedButtons() {
        return clickedButtons;
    }

    /**
     * Sets the list of clicked buttons as strings.
     *
     * @param clickedButtons the ArrayList of String objects representing clicked buttons
     */
    public void setClickedButtons(ArrayList<String> clickedButtons) {
        this.clickedButtons = clickedButtons;
    }
    
    /**
     * Gets the check-in and check-out selection status.
     *
     * @return true if check-in and check-out dates are selected, false otherwise
     */
    public boolean getCheckInNOutSelected() {
        return checkInNOutSelected;
    }

    /**
     * Sets the check-in and check-out selection status.
     *
     * @param checkInNOutSelected the boolean representing the check-in and check-out selection status
     */
    public void setCheckInNOutSelected(boolean checkInNOutSelected) {
        this.checkInNOutSelected = checkInNOutSelected;
    }

    /**
     * Gets the discount text field.
     *
     * @return the TextFieldCustom object for the discount code
     */
    public TextFieldCustom getDiscountTextField() {
        return discountTextField;
    }

    /**
     * Sets the discount text field.
     *
     * @param discountTextField the TextFieldCustom object for the discount code
     */
    public void setDiscountTextField(TextFieldCustom discountTextField) {
        this.discountTextField = discountTextField;
    }

    /**
     * Gets the book button.
     *
     * @return the OptionButton for booking
     */
    public OptionButton getBookButton() {
        return bookButton;
    }

    /**
     * Sets the book button.
     *
     * @param bookButton the OptionButton for booking
     */
    public void setBookButton(OptionButton bookButton) {
        this.bookButton = bookButton;
    }

    /**
     * Gets the cancel button.
     *
     * @return the IconButton for canceling the booking
     */
    public IconButton getCancelButton() {
        return cancelButton;
    }

    /**
     * Sets the cancel button.
     *
     * @param cancelButton the IconButton for canceling the booking
     */
    public void setCancelButton(IconButton cancelButton) {
        this.cancelButton = cancelButton;
    }
}