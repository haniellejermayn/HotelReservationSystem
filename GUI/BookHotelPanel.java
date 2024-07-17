import java.awt.*;

public class BookHotelPanel extends RoundPanel implements ButtonClickListener{

    BookCalendar calendar;
    RoundPanel bookContainer;
    //RoundLabel guestName, roomType, discountCode;
    //RoundLabel totalPrice;
    OptionButton book;

    RoundPanel nameTextField, discountTextField;

    TextFieldCustom discount;
    OptionButton hasDiscount;

    Font customFont13;
    Font customFont15;
    Font customFont50;

                // change to Hotel hotel
    public BookHotelPanel(String hotel){

        super(new Color(51, 88, 150));

        customFont13 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 13);
        customFont15 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 15);
        customFont50 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 50);

        /*guestName = new RoundLabel(new Color(40, 68, 117));
        availNo.setFont(customFont50);
        availNo.setText("30");
        availNo.setForeground(Color.white);
        availNo.setBounds(410, 20, 100, 55);

        availRooms = new RoundLabel(new Color(40, 68, 117));
        availRooms.setFont(customFont15);
        availRooms.setText("      available rooms");
        availRooms.setForeground(Color.white);
        availRooms.setBounds(5, 61, 165, 20);
        
        availPanel = new RoundLabel(new Color(40, 68, 117));
        availPanel.setBounds(355, 20, 175, 86);
        availPanel.setFont(customFont50);
        availPanel.setText("30");
        availPanel.setForeground(Color.white);
        availPanel.add(availRooms);
        availPanel.setVerticalAlignment(JLabel.TOP);;
        availPanel.setHorizontalAlignment(JLabel.CENTER);*/

        TextFieldCustom guestName = new TextFieldCustom(new Color(51, 88, 150));
        guestName.setBounds(5, 10, 340, 55);
        guestName.setFieldName("Name");

        OptionButton standardRoom = new OptionButton("Standard");
        standardRoom.setBounds(22, 28, 100, 30);
        standardRoom.setColorClick(standardRoom.getColorOver());
        
        OptionButton deluxeRoom = new OptionButton("Deluxe");
        deluxeRoom.setBounds(127, 28, 100, 30);
        deluxeRoom.setColorClick(deluxeRoom.getColorOver());
        
        OptionButton executiveRoom = new OptionButton("Executive");
        executiveRoom.setBounds(232, 28, 100, 30);
        executiveRoom.setColorClick(executiveRoom.getColorOver());

        RoundLabel roomTypeTitle = new RoundLabel(new Color(51, 88, 150));
        roomTypeTitle.setBounds(8, 1, 100, 20);
        roomTypeTitle.setText("Room Type");
        roomTypeTitle.setFont(customFont13);
        roomTypeTitle.setForeground(Color.white);
        
        RoundPanel roomType = new RoundPanel(new Color(51, 88, 150));
        //RoundPanel roomType = new RoundPanel(Color.blue);
        //RoundPanel roomType = new RoundPanel(Color.white);
        roomType.setLayout(null);
        roomType.setBounds(5, 95, 340, 60);
        roomType.add(roomTypeTitle);
        roomType.add(standardRoom);
        roomType.add(deluxeRoom);
        roomType.add(executiveRoom);
        

        RoundLabel checkInNOut = new RoundLabel(new Color(51, 88, 150));
        checkInNOut.setBounds(10, 185, 200, 20);
        checkInNOut.setText("Check in / Check Out");
        checkInNOut.setFont(customFont13);
        checkInNOut.setForeground(Color.white);

        calendar = new BookCalendar(this);
        calendar.setBounds(10, 220, 335, 203);

        hasDiscount = new OptionButton("Discount");
        hasDiscount.setText("I have a discount code");
        hasDiscount.setForeground(new Color(27, 43, 80));
        hasDiscount.setColor(new Color(51, 88, 150));

        discount = new TextFieldCustom(new Color(51, 88, 150));
        discount.setBounds(5, 480, 340, 55);
        discount.setFieldName("Discount Code");

        //OptionButton bookButton


        bookContainer = new RoundPanel(new Color(51, 88, 150));
        bookContainer.setLayout(null);
        bookContainer.setPreferredSize(new Dimension(530, 600));
        bookContainer.add(checkInNOut);
        bookContainer.add(guestName);
        bookContainer.add(roomType);
        bookContainer.add(discount);
        bookContainer.add(calendar);

        ScrollPaneCustom scrollPane = new ScrollPaneCustom(bookContainer, new Color(27, 43, 80), new Color(27, 43, 80), new Color(51, 88, 150));
        scrollPane.setBounds(5, 5, 375, 410);

        this.setLayout(null);
        this.add(scrollPane);
    }

    @Override
    public void buttonClicked(String buttonName) {
        for (int i = 0; i < 31; i++){
            //String dayIndex = String.format("%02d", i + 1); // change to necessary information

            /*if (buttonName.equals(dayIndex)){
                availPanel.setText(dayIndex);
                bookedPanel.setText(dayIndex);
            }*/
        }
    }

}
