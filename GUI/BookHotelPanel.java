//package GUI;

//import hrs.*;
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

    private TextFieldCustom guestName;
    private boolean roomTypeSelected;
    private OptionButton standardRoom, deluxeRoom, executiveRoom;
    private OptionButton bookButton;
    private IconButton cancelButton;

    private TextFieldCustom discount;
    private OptionButton hasDiscount;

    private String nameInput, roomTypeInput, discountInput;
    private int checkInInput, checkOutInput;

    //private ButtonClickListener listener;
    private ArrayList<OptionButton> days;
    private ArrayList<String> clickedButtons;

    private Font customFont13;
    private Font customFont30;

                // TODO: change to Hotel hotel
    public BookHotelPanel(String hotel, ButtonClickListener listener){

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
        guestName = new TextFieldCustom(new Color(40, 68, 117));
        guestName.setBounds(5, 10, 355, 55);
        guestName.setFieldName("Name");

        // * Room Types * //
        roomTypeSelected = false; 

        standardRoom = new OptionButton("Standard");
        standardRoom.setBounds(32, 28, 100, 30);
        standardRoom.setColorOver(standardRoom.getColorClick());
        standardRoom.addActionListener(this);
        
        deluxeRoom = new OptionButton("Deluxe");
        deluxeRoom.setBounds(137, 28, 100, 30);
        deluxeRoom.setColorOver(deluxeRoom.getColorClick());
        deluxeRoom.addActionListener(this);
        
        executiveRoom = new OptionButton("Executive");
        executiveRoom.setBounds(242, 28, 100, 30);
        executiveRoom.setColorOver(executiveRoom.getColorClick());
        executiveRoom.addActionListener(this);

        roomTypeTitle = new RoundLabel(new Color(40, 68, 117));
        roomTypeTitle.setBounds(8, 1, 100, 20);
        roomTypeTitle.setText("Room Type");
        roomTypeTitle.setFont(customFont13);
        roomTypeTitle.setForeground(Color.white);
        
        roomType = new RoundPanel(new Color(40, 68, 117));
        roomType.setLayout(null);
        roomType.setBounds(5, 95, 350, 60);
        roomType.add(roomTypeTitle);
        roomType.add(standardRoom);
        roomType.add(deluxeRoom);
        roomType.add(executiveRoom);

        // * Check In / Out * //
        checkInNOut = new RoundLabel(new Color(40, 68, 117));
        checkInNOut.setBounds(13, 185, 200, 20);
        checkInNOut.setText("Check in / Check Out");
        checkInNOut.setFont(customFont13);
        checkInNOut.setForeground(Color.white);

        clickedButtons = new ArrayList<String>();

        calendar = new BookCalendar(this);
        calendar.setBounds(18, 220, 335, 203);
        days = calendar.getDays();
        days.get(30).setEnabled(false);
        days.get(30).setColor(new Color(27, 43, 80));
        days.get(30).setColorOver(new Color(27, 43, 80));
        days.get(30).setColorClick(new Color(27, 43, 80));

        // * Discount * //
        hasDiscount = new OptionButton("Discount");
        hasDiscount.setText("I have a discount code");
        hasDiscount.setForeground(new Color(27, 43, 80));
        hasDiscount.setColor(new Color(51, 88, 150));

        discount = new TextFieldCustom(new Color(40, 68, 117));
        discount.setBounds(5, 460, 355, 55);
        discount.setFieldName("Discount Code");

        // * Book Button * //
        bookButton = new OptionButton("Book");
        bookButton.setBounds(260, 540, 100, 30);
        bookButton.setColorOver(bookButton.getColorClick());
        bookButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){
                setNameInput(guestName.getTextField().getText().trim()); // Get text and trim any leading/trailing whitespace
                setDiscountInput(discount.getTextField().getText().trim()); // Get text and trim any leading/trailing whitespace
                
                // TODO: check if all fields are filled
                // TODO: set all necessary info into Hotel
                

                listener.buttonClicked("Book");
            }
        });

        // * Cancel * //
        ImageIcon cancelIcon = new ImageIcon("Icons/CancelIcon.png");
        cancelIcon = Customization.resizeIcon(cancelIcon, 20, 20); 

        cancelButton = new IconButton(cancelIcon, "Book Cancel");
        cancelButton.setBounds(335, 8, 40, 40);
        cancelButton.setColorClick(bookButton.getColorOver());
        cancelButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){
                setNameInput(""); 
                setRoomTypeInput("");
                setCheckInInput(0);
                setCheckOutInput(0);
                setDiscountInput("");

                listener.buttonClicked("Book Cancel");
            }
        });

        // * Container * //
        bookContainer = new RoundPanel(new Color(40, 68, 117));
        bookContainer.setLayout(null);
        bookContainer.setPreferredSize(new Dimension(530, 585));
        bookContainer.add(checkInNOut);
        bookContainer.add(guestName);
        bookContainer.add(roomType);
        bookContainer.add(calendar);
        bookContainer.add(discount);
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
        if (e.getSource() == standardRoom){
            roomTypeSelected = true;
            deluxeRoom.setColor(new Color(27, 43, 80));
            executiveRoom.setColor(new Color(27, 43, 80));
            standardRoom.setColor(new Color(51, 88, 150));
            setRoomTypeInput("Standard");
        }
        else if (e.getSource() == deluxeRoom){
            roomTypeSelected = true;
            standardRoom.setColor(new Color(27, 43, 80));
            executiveRoom.setColor(new Color(27, 43, 80));
            deluxeRoom.setColor(new Color(51, 88, 150));
            setRoomTypeInput("Deluxe");
        }
        else if (e.getSource() == executiveRoom){
            roomTypeSelected = true;
            standardRoom.setColor(new Color(27, 43, 80));
            deluxeRoom.setColor(new Color(27, 43, 80));
            executiveRoom.setColor(new Color(51, 88, 150));
            setRoomTypeInput("Executive");
        }
    }

    @Override
    public void buttonClicked(String buttonName) {

        clickedButtons.add(buttonName);

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
        }
    }

    public String getNameInput(){
        return nameInput;
    }

    public void setNameInput(String nameInput){
        this.nameInput = nameInput;
    }

    public String getRoomTypeInput(){
        return roomTypeInput;
    }

    public void setRoomTypeInput(String roomTypeInput){
        this.roomTypeInput = roomTypeInput;
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

    public String getDiscountInput(){
        discountInput = discount.getTextField().getText().trim();
        return discountInput;
    }

    public void setDiscountInput(String discountInput){
        this.discountInput = discountInput;
    }
}
