package src.HRS.View;

import src.HRS.Model.*;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class BookHotelPanel extends RoundPanel implements ActionListener, ButtonClickListener{

    private RoundLabel bookingTitle;
    private BookCalendar calendar;
    private RoundPanel bookContainer;
    private RoundLabel roomTypeTitle;
    private RoundPanel roomType;
    private RoundLabel checkInNOut;

    private TextFieldCustom guestNameInput;
    private boolean roomTypeSelected;
    private boolean checkInNOutSelected;
    private OptionButton standardRoomInput, deluxeRoomInput, executiveRoomInput;
    private OptionButton bookButton;
    private IconButton cancelButton;

    private TextFieldCustom discountInput;

    private String roomTypeInput;
    private int checkInInput, checkOutInput;

    private ArrayList<OptionButton> days;
    private ArrayList<String> clickedButtons;

    private Font customFont13;
    private Font customFont30;

    private Hotel hotel;

    public BookHotelPanel(Hotel hotel){

        super(new Color(51, 88, 150));
        this.hotel = hotel;

        customFont13 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 13);
        customFont30 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 30);

        // * Title * //
        bookingTitle = new RoundLabel(new Color(51, 88, 150));
        bookingTitle.setBounds(8, 10, 200, 40);
        bookingTitle.setText("Booking");
        bookingTitle.setFont(customFont30);
        bookingTitle.setForeground(Color.white);

        // * Guest Name * //
        guestNameInput = new TextFieldCustom(new Color(40, 68, 117));
        guestNameInput.setBounds(5, 10, 355, 55);
        guestNameInput.setFieldName("Name");

        // * Room Types * //
        roomTypeSelected = false; 

        standardRoomInput = new OptionButton("Standard");
        standardRoomInput.setBounds(32, 28, 100, 30);
        standardRoomInput.setColorOver(standardRoomInput.getColorClick());
        standardRoomInput.addActionListener(this);
        
        deluxeRoomInput = new OptionButton("Deluxe");
        deluxeRoomInput.setBounds(137, 28, 100, 30);
        deluxeRoomInput.setColorOver(deluxeRoomInput.getColorClick());
        deluxeRoomInput.addActionListener(this);
        
        executiveRoomInput = new OptionButton("Executive");
        executiveRoomInput.setBounds(242, 28, 100, 30);
        executiveRoomInput.setColorOver(executiveRoomInput.getColorClick());
        executiveRoomInput.addActionListener(this);

        roomTypeTitle = new RoundLabel(new Color(40, 68, 117));
        roomTypeTitle.setBounds(8, 1, 100, 20);
        roomTypeTitle.setText("Room Type");
        roomTypeTitle.setFont(customFont13);
        roomTypeTitle.setForeground(Color.white);
        
        roomType = new RoundPanel(new Color(40, 68, 117));
        roomType.setLayout(null);
        roomType.setBounds(5, 95, 350, 60);
        roomType.add(roomTypeTitle);
        roomType.add(standardRoomInput);
        roomType.add(deluxeRoomInput);
        roomType.add(executiveRoomInput);

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

        // * Discount * //
        /*hasDiscount = new OptionButton("Discount");
        hasDiscount.setText("I have a discount code");
        hasDiscount.setForeground(new Color(27, 43, 80));
        hasDiscount.setColor(new Color(51, 88, 150));*/

        discountInput = new TextFieldCustom(new Color(40, 68, 117));
        discountInput.setBounds(5, 460, 355, 55);
        discountInput.setFieldName("Discount Code");

        // * Book Button * //
        bookButton = new OptionButton("Book");
        bookButton.setBounds(260, 540, 100, 30);
        bookButton.setColorOver(bookButton.getColorClick());
        /*bookButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){

                String name = guestName.getTextField().getText().trim();
                String disc = discount.getTextField().getText().trim();

                // TODO: (if filled) check if disc is valid 
                // TODO: check if selected room type is available within the checkIn and checkOut dates
                if (!name.isEmpty() && roomTypeSelected && checkInNOutSelected){
                    setNameInput(name);
                    setDiscountInput(disc);
                    
                    // TODO: set all necessary info into Hotel
    
                    listener.buttonClicked("Book");
                }
            }
        });*/

        // * Cancel * //
        ImageIcon cancelIcon = new ImageIcon("Icons/CancelIcon.png");
        cancelIcon = Customization.resizeIcon(cancelIcon, 20, 20); 

        cancelButton = new IconButton(cancelIcon, "Book Cancel");
        cancelButton.setBounds(335, 8, 40, 40);
        cancelButton.setColorClick(bookButton.getColorOver());
        /*cancelButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){
                setNameInput(""); 
                setRoomTypeInput("");
                setCheckInInput(0);
                setCheckOutInput(0);
                setDiscountInput("");

                listener.buttonClicked("Book Cancel");
            }
        });*/

        // * Container * //
        bookContainer = new RoundPanel(new Color(40, 68, 117));
        bookContainer.setLayout(null);
        bookContainer.setPreferredSize(new Dimension(530, 585));
        bookContainer.add(checkInNOut);
        bookContainer.add(guestNameInput);
        bookContainer.add(roomType);
        bookContainer.add(calendar);
        bookContainer.add(discountInput);
        bookContainer.add(bookButton);

        ScrollPaneCustom scrollPane = new ScrollPaneCustom(bookContainer, new Color(27, 43, 80), new Color(27, 43, 80), new Color(40, 68, 117));
        scrollPane.setBounds(5, 55, 375, 360);

        this.setLayout(null);
        this.add(bookingTitle);
        this.add(cancelButton);
        this.add(scrollPane);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /*if (e.getSource() == standardRoomInput){
            roomTypeSelected = true;
            standardRoomInput.setColor(new Color(51, 88, 150));
            deluxeRoomInput.setColor(new Color(27, 43, 80));
            executiveRoomInput.setColor(new Color(27, 43, 80));
            setRoomTypeInput("Standard");
        }
        else if (e.getSource() == deluxeRoomInput){
            roomTypeSelected = true;
            standardRoomInput.setColor(new Color(27, 43, 80));
            deluxeRoomInput.setColor(new Color(51, 88, 150));
            executiveRoomInput.setColor(new Color(27, 43, 80));
            setRoomTypeInput("Deluxe");
        }
        else if (e.getSource() == executiveRoomInput){
            roomTypeSelected = true;
            standardRoomInput.setColor(new Color(27, 43, 80));
            deluxeRoomInput.setColor(new Color(27, 43, 80));
            executiveRoomInput.setColor(new Color(51, 88, 150));
            setRoomTypeInput("Executive");
        }*/
    }

    @Override
    public void buttonClicked(String buttonName) {

        /*clickedButtons.add(buttonName);

        if (clickedButtons.size() > 2){
            clickedButtons.remove(0);
            clickedButtons.remove(1);
        }

        if (clickedButtons.size() == 1){
            
            days.get(Integer.valueOf(clickedButtons.get(0)) - 1).setColor(new Color(51, 88, 150));
            days.get(Integer.valueOf(clickedButtons.get(0)) - 1).setColorOver(new Color(51, 88, 150));
            
            for (int i = 0; i < 31; i++){
                if (i < Integer.valueOf(clickedButtons.get(0)) - 1){
                    days.get(i).setEnabled(false);
                    days.get(i).setColor(new Color(27, 43, 80));
                    days.get(i).setColorOver(new Color(27, 43, 80));
                    days.get(i).setColorClick(new Color(27, 43, 80));
                }
            }
            
            days.get(30).setEnabled(true);
            days.get(30).setColor(new Color(27, 43, 80));
            days.get(30).setColorOver(new Color(40, 68, 117));
            days.get(30).setColorClick(new Color(51, 88, 150));
        }

        if (clickedButtons.size() == 2 && !clickedButtons.get(0).equals(clickedButtons.get(1))){
            calendar.setHighlightedDays(Integer.valueOf(clickedButtons.get(0)), Integer.valueOf(clickedButtons.get(1)));
            setCheckInInput(Integer.valueOf(clickedButtons.get(0)));
            setCheckOutInput(Integer.valueOf(clickedButtons.get(1)));

            for (int i = 0; i < 31; i++){
                if (i >= Integer.valueOf(clickedButtons.get(1))){
                    days.get(i).setColor(new Color(27, 43, 80));
                    days.get(i).setColorOver(new Color(27, 43, 80));
                    days.get(i).setColorClick(new Color(27, 43, 80));
                }
                
                if (i >= Integer.valueOf(clickedButtons.get(0)) && i < Integer.valueOf(clickedButtons.get(1))){
                    days.get(i).setColor(new Color(51, 88, 150));
                    days.get(i).setColorOver(new Color(51, 88, 150));
                }

                days.get(i).setEnabled(false);
            }

            checkInNOutSelected = true;
        }*/
    }

    public TextFieldCustom getGuestNameInput(){
        return guestNameInput;
    }

    public void setGuestNameInput(TextFieldCustom guestNameInput){
        this.guestNameInput = guestNameInput;
    }

    public OptionButton getStandardRoomInput(){
        return standardRoomInput;
    }

    public void setStandardRoomInput(OptionButton standardRoomInput){
        this.standardRoomInput = standardRoomInput;
    }
    
    public OptionButton getDeluxeRoomInput(){
        return deluxeRoomInput;
    }
    
    public void setDeluxeRoomInput(OptionButton deluxeRoomInput){
        this.deluxeRoomInput = deluxeRoomInput;
    }
    
    public OptionButton getExecutiveRoomInput(){
        return executiveRoomInput;
    }
    
    public void setExecutiveRoomInput(OptionButton executiveRoomInput){
        this.executiveRoomInput = executiveRoomInput;
    }
    

    public String getRoomTypeInput(){
        return roomTypeInput;
    }

    public void setRoomTypeInput(String roomTypeInput){
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

    public TextFieldCustom getDiscountInput(){
        //discountInput = discount.getTextField().getText().trim();
        return discountInput;
    }

    public void setDiscountInput(TextFieldCustom discountInput){
        this.discountInput = discountInput;
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