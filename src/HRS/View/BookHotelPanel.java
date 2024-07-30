package src.HRS.View;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import src.HRS.Model.Hotel;

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

    public TextFieldCustom getGuestNameTextField(){
        return guestNameTextField;
    }

    public void setGuestNameTextField(TextFieldCustom guestNameTextField){
        this.guestNameTextField = guestNameTextField;
    }

    public OptionButton getStandardRoomButton(){
        return standardRoomButton;
    }

    public void setStandardRoomButton(OptionButton standardRoomButton){
        this.standardRoomButton = standardRoomButton;
    }
    
    public OptionButton getDeluxeRoomButton(){
        return deluxeRoomButton;
    }
    
    public void setDeluxeRoomButton(OptionButton deluxeRoomButton){
        this.deluxeRoomButton = deluxeRoomButton;
    }
    
    public OptionButton getExecutiveRoomButton(){
        return executiveRoomButton;
    }
    
    public void setExecutiveRoomButton(OptionButton executiveRoomButton){
        this.executiveRoomButton = executiveRoomButton;
    }
    

    public int getRoomTypeInput(){
        return roomTypeInput;
    }

    public void setRoomTypeInput(int roomTypeInput){
        this.roomTypeInput = roomTypeInput;
    }

    public BookCalendar getBookCalendar(){
        return calendar;
    }

    public void setBookCalendar(BookCalendar calendar){
        this.calendar = calendar;
    }

    public int getCheckInInput(){
        return checkInInput;
    }

    public void setCheckInInput(int checkInInput){
        this.checkInInput = checkInInput;
    }

    public int getCheckOutInput(){
        return checkOutInput;
    }

    public void setCheckOutInput(int checkOutInput){
        this.checkOutInput = checkOutInput;
    }

    public boolean getRoomTypeSelected(){
        return roomTypeSelected;
    }

    public void setRoomTypeSelected(boolean roomTypeSelected){
        this.roomTypeSelected =roomTypeSelected;
    }

    public ArrayList<OptionButton> getDays(){
        return days;
    }

    public void setDays(ArrayList<OptionButton> days){
        this.days = days;
    }

    public ArrayList<String> getClickedButtons(){
        return clickedButtons;
    }

    public void setClickedButtons(ArrayList<String> clickedButtons){
        this.clickedButtons = clickedButtons;
    }
    
    public boolean getCheckInNOutSelected(){
        return checkInNOutSelected;
    }

    public void setCheckInNOutSelected(boolean checkInNOutSelected){
        this.checkInNOutSelected = checkInNOutSelected;
    }

    public TextFieldCustom getDiscountTextField(){
        //discountTextField = discount.getTextField().getText().trim();
        return discountTextField;
    }

    public void setDiscountTextField(TextFieldCustom discountTextField){
        this.discountTextField = discountTextField;
    }

    public OptionButton getBookButton(){
        return bookButton;
    }

    public void setBookButton(OptionButton bookButton){
        this.bookButton = bookButton;
    }

    public IconButton getCancelButton(){
        return cancelButton;
    }

    public void setCancelButton(IconButton cancelButton){
        this.cancelButton = cancelButton;
    }
}