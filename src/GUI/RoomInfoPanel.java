package GUI;

import hrs.*;
import java.awt.*;
import javax.swing.*;

public class RoomInfoPanel extends RoundPanel implements ButtonClickListener{

    private CalendarView calendar;
    private RoundLabel roomName, roomPrice, roomType;
    private RoundLabel availRooms, bookedRooms;
    private RoundLabel availNo, bookedNo;
    private RoundLabel availDates;
    private RoundPanel roomInfoContainer;

    private Font customFont15;
    private Font customFont30;
    private Font customFont50;

    public RoomInfoPanel(Hotel hotel){

        super(new Color(40, 68, 117));

        roomInfoContainer = new RoundPanel(new Color(40, 68, 117));
        //roomInfoContainer = new RoundPanel(Color.red);

        /*JScrollPane scrollPane = new JScrollPane(roomInfoContainer);
        scrollPane.setBounds(5, 5, 300, 200);*/

        customFont15 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 15);
        customFont30 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 30);
        customFont50 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 50);

        //calendar = new CalendarView(this);
        //calendar.setBounds(5, 5, 335, 203);

        calendar = new CalendarView(this);
        calendar.setBounds(180, 259, 335, 203);

        availNo = new RoundLabel(new Color(40, 68, 117));
        availNo.setFont(customFont50);
        availNo.setText("30"); // Edit: what should this display
        availNo.setForeground(Color.white);
        availNo.setBounds(410, 20, 100, 55);

        availRooms = new RoundLabel(new Color(40, 68, 117));
        availRooms.setFont(customFont15);
        availRooms.setText("      available rooms");
        availRooms.setForeground(Color.white);
        availRooms.setBounds(5, 61, 165, 20);
        
        bookedNo = new RoundLabel(new Color(40, 68, 117));
        bookedNo.setFont(customFont50);
        bookedNo.setText("20"); // Edit: what should this display
        bookedNo.setForeground(Color.white);
        bookedNo.setBounds(410, 120, 100, 55);

        bookedRooms = new RoundLabel(new Color(40, 68, 117));
        bookedRooms.setFont(customFont15);
        bookedRooms.setText("       booked rooms");
        bookedRooms.setForeground(Color.white);
        bookedRooms.setBounds(5, 61, 165, 20);
        
        roomName = new RoundLabel(new Color(40, 68, 117));
        roomName.setBounds(0, 326, 175, 36);
        roomName.setFont(customFont30);
        roomName.setText("Room 00");
        roomName.setForeground(Color.white);
        roomName.setVerticalAlignment(JLabel.CENTER);
        roomName.setHorizontalAlignment(JLabel.CENTER);
        
        roomPrice = new RoundLabel(new Color(40, 68, 117));
        roomPrice.setBounds(0, 367, 175, 26);
        roomPrice.setFont(customFont15);
        roomPrice.setText("1299.00 per night");
        roomPrice.setForeground(Color.white);
        roomPrice.setVerticalAlignment(JLabel.CENTER);
        roomPrice.setHorizontalAlignment(JLabel.CENTER);
        
        roomType = new RoundLabel(new Color(40, 68, 117));
        roomType.setBounds(0, 388, 175, 26);
        roomType.setFont(customFont15);
        roomType.setText("Standard Room");
        roomType.setForeground(Color.white);
        roomType.setVerticalAlignment(JLabel.CENTER);
        roomType.setHorizontalAlignment(JLabel.CENTER);
        
        //availDates = new RoundLabel(new Color(40, 68, 117));
        //availDates.setBounds(267, 228, 175, 26);
        availDates = new RoundLabel(new Color(27, 43, 80));
        availDates.setBounds(360, 425, 155, 26);
        availDates.setFont(customFont15);
        availDates.setText("Available Dates");
        //availDates.setForeground(Color.white);
        availDates.setForeground(new Color(51, 88, 150));
        availDates.setVerticalAlignment(JLabel.CENTER);
        availDates.setHorizontalAlignment(JLabel.CENTER);


        roomInfoContainer.setLayout(null);
        //roomInfoContainer.setBounds(5, 5, 530, 310);
        //roomInfoContainer.setBounds(5, 5, 530, 500);
        roomInfoContainer.setPreferredSize(new Dimension(530, 467));
        roomInfoContainer.add(availDates);
        roomInfoContainer.add(calendar);
        roomInfoContainer.add(roomName);
        roomInfoContainer.add(roomPrice);
        roomInfoContainer.add(roomType);

        ScrollPaneCustom scrollPane = new ScrollPaneCustom(roomInfoContainer);
        scrollPane.setBounds(5, 5, 530, 210);
        /*scrollPane.setLayout(null);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setViewportBorder(null);*/

        this.setLayout(null);
        //this.add(roomInfoContainer);
        this.add(scrollPane);
    }

    @Override
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
    }

}
