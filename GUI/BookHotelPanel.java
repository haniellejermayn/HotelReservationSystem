import java.awt.*;
import java.awt.event.*;

import javax.swing.JOptionPane;

public class BookHotelPanel extends RoundPanel implements ActionListener, ButtonClickListener{

    BookCalendar calendar;
    RoundPanel bookContainer;
    //RoundLabel guestName, roomType, discountCode;
    //RoundLabel totalPrice;
    //OptionButton bookButton;

    RoundPanel nameTextField, discountTextField;

    TextFieldCustom guestName;
    boolean roomTypeSelected;
    OptionButton standardRoom, deluxeRoom, executiveRoom;
    OptionButton bookButton;

    TextFieldCustom discount;
    OptionButton hasDiscount;

    String nameInput, roomTypeInput, discountInput;
    int checkIn, checkOut;

    ButtonClickListener listener;

    Font customFont13;
    Font customFont15;
    Font customFont30;
    Font customFont50;

                // change to Hotel hotel
    public BookHotelPanel(String hotel, ButtonClickListener listener){

        super(new Color(51, 88, 150));

        this.listener = listener;

        customFont13 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 13);
        customFont15 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 15);
        customFont30 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 30);
        customFont50 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 50);

        RoundLabel bookingTitle = new RoundLabel(new Color(51, 88, 150));
        bookingTitle.setBounds(8, 10, 200, 40);
        bookingTitle.setText("Booking");
        bookingTitle.setFont(customFont30);
        bookingTitle.setForeground(Color.white);

        //TextFieldCustom guestName = new TextFieldCustom(new Color(51, 88, 150));
        TextFieldCustom guestName = new TextFieldCustom(new Color(40, 68, 117));
        guestName.setBounds(5, 10, 355, 55);
        guestName.setFieldName("Name");

        roomTypeSelected = false;

        OptionButton standardRoom = new OptionButton("Standard");
        standardRoom.setBounds(32, 28, 100, 30);
        standardRoom.setColorOver(standardRoom.getColorClick());
        standardRoom.addActionListener(this);
        
        OptionButton deluxeRoom = new OptionButton("Deluxe");
        deluxeRoom.setBounds(137, 28, 100, 30);
        deluxeRoom.setColorOver(deluxeRoom.getColorClick());
        deluxeRoom.addActionListener(this);
        
        OptionButton executiveRoom = new OptionButton("Executive");
        executiveRoom.setBounds(242, 28, 100, 30);
        executiveRoom.setColorOver(executiveRoom.getColorClick());
        executiveRoom.addActionListener(this);

        //RoundLabel roomTypeTitle = new RoundLabel(new Color(51, 88, 150));
        RoundLabel roomTypeTitle = new RoundLabel(new Color(40, 68, 117));
        roomTypeTitle.setBounds(8, 1, 100, 20);
        roomTypeTitle.setText("Room Type");
        roomTypeTitle.setFont(customFont13);
        roomTypeTitle.setForeground(Color.white);
        
        //RoundPanel roomType = new RoundPanel(new Color(51, 88, 150));
        RoundPanel roomType = new RoundPanel(new Color(40, 68, 117));
        //RoundPanel roomType = new RoundPanel(Color.blue);
        //RoundPanel roomType = new RoundPanel(Color.white);
        roomType.setLayout(null);
        roomType.setBounds(5, 95, 350, 60);
        roomType.add(roomTypeTitle);
        roomType.add(standardRoom);
        roomType.add(deluxeRoom);
        roomType.add(executiveRoom);
        

        //RoundLabel checkInNOut = new RoundLabel(new Color(51, 88, 150));
        RoundLabel checkInNOut = new RoundLabel(new Color(40, 68, 117));
        checkInNOut.setBounds(13, 185, 200, 20);
        checkInNOut.setText("Check in / Check Out");
        checkInNOut.setFont(customFont13);
        checkInNOut.setForeground(Color.white);

        calendar = new BookCalendar(this);
        calendar.setBounds(18, 220, 335, 203);

        hasDiscount = new OptionButton("Discount");
        hasDiscount.setText("I have a discount code");
        hasDiscount.setForeground(new Color(27, 43, 80));
        hasDiscount.setColor(new Color(51, 88, 150));

        //discount = new TextFieldCustom(new Color(51, 88, 150));
        discount = new TextFieldCustom(new Color(40, 68, 117));
        discount.setBounds(5, 460, 355, 55);
        discount.setFieldName("Discount Code");

        OptionButton bookButton = new OptionButton("Book");
        //bookButton.setBounds(425, 545, 100, 30);
        bookButton.setBounds(260, 540, 100, 30);
        bookButton.setColorOver(bookButton.getColorClick());
        bookButton.addActionListener(this);


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
        this.add(scrollPane);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == standardRoom){
            roomTypeSelected = true;
            standardRoom.setColor(standardRoom.getColorClick());
            deluxeRoom.setColor(new Color(27, 43, 80));
            executiveRoom.setColor(new Color(27, 43, 80));

        }
        else if (e.getSource() == deluxeRoom){
            roomTypeSelected = true;
            deluxeRoom.setColor(standardRoom.getColorClick());
            standardRoom.setColor(new Color(27, 43, 80));
            executiveRoom.setColor(new Color(27, 43, 80));

        }
        else if (e.getSource() == executiveRoom){
            roomTypeSelected = true;
            executiveRoom.setColor(standardRoom.getColorClick());
            deluxeRoom.setColor(new Color(27, 43, 80));
            standardRoom.setColor(new Color(27, 43, 80));

        }
        
        
        if (e.getSource() == bookButton){
                
            String name = guestName.getTextField().getText().trim(); // Get text and trim any leading/trailing whitespace
            
            if (!name.isEmpty() && roomTypeSelected) {
                listener.buttonClicked("Book");
            } 
        }
    }

    @Override
    public void buttonClicked(String buttonName) {
        
    }

    public String getNameInput(){
        return nameInput;
    }

    public void setNameInput(String nameInput){
        this.nameInput = nameInput;
    }

    public String getroomTypeInput(){
        return nameInput;
    }

    public void setroomTypeInput(String roomTypeInput){
        this.roomTypeInput = roomTypeInput;
    }

    public String getDiscountInput(){
        return nameInput;
    }

    public void setDiscountInput(String discountInput){
        this.discountInput = discountInput;
    }
}


