package src.HRS.View;

import src.HRS.Model.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class RoomInfoPanel extends RoundPanel implements EnhancedButtonClickListener{

    private int nStandardRooms, nDeluxeRooms, nExecutiveRooms;
    private CalendarView calendar;
    private RoomView roomView;
    private RoundLabel roomName, roomPrice, roomType;
    private RoundLabel availDates;
    private RoundLabel standardRooms, deluxeRooms, executiveRooms;
    private RoundLabel standardRoomPanel, deluxeRoomPanel, executiveRoomPanel;
    private RoundPanel roomInfoContainer;
    private ArrayList<OptionButton> days;
    private Font customFont15;
    private Font customFont30;
    private Font customFont50;
    private Hotel hotel;

    public RoomInfoPanel(Hotel hotel){

        super(new Color(40, 68, 117));
        this.hotel = hotel;

        customFont15 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 15);
        customFont30 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 30);
        customFont50 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 50);

        // * Available Dates * //
        calendar = new CalendarView();
        calendar.setBounds(180, 239, 335, 203);
        days = calendar.getDays();
        
        for(int i = 0; i < days.size(); i++){
            days.get(i).setEnabled(false);
            days.get(i).setColorOver(days.get(i).getColor());
            days.get(i).setColorClick(days.get(i).getColor());
        }
        
        // * Room Name * //
        roomName = new RoundLabel(new Color(40, 68, 117));
        roomName.setBounds(0, 306, 175, 36);
        roomName.setFont(customFont30);
        roomName.setText("Room 00");
        roomName.setForeground(Color.white);
        roomName.setVerticalAlignment(JLabel.CENTER);
        roomName.setHorizontalAlignment(JLabel.CENTER);
        
        // * Room Price * //
        roomPrice = new RoundLabel(new Color(40, 68, 117));
        roomPrice.setBounds(0, 347, 175, 26);
        roomPrice.setFont(customFont15);
        roomPrice.setText("1299.00 per night");
        roomPrice.setForeground(Color.white);
        roomPrice.setVerticalAlignment(JLabel.CENTER);
        roomPrice.setHorizontalAlignment(JLabel.CENTER);
        
        // * Room Type * //
        roomType = new RoundLabel(new Color(40, 68, 117));
        roomType.setBounds(0, 368, 175, 26);
        roomType.setFont(customFont15);
        roomType.setText("Standard Room");
        roomType.setForeground(Color.white);
        roomType.setVerticalAlignment(JLabel.CENTER);
        roomType.setHorizontalAlignment(JLabel.CENTER);
        
        // * Availdable Dates * //
        availDates = new RoundLabel(new Color(27, 43, 80));
        availDates.setBounds(360, 405, 155, 26);
        availDates.setFont(customFont15);
        availDates.setText("Available Dates");
        availDates.setForeground(new Color(51, 88, 150));
        availDates.setVerticalAlignment(JLabel.CENTER);
        availDates.setHorizontalAlignment(JLabel.CENTER);

        // * Room Types * //
        nStandardRooms = 0;
        nDeluxeRooms = 0;
        nExecutiveRooms = 0;

        standardRooms = new RoundLabel(new Color(40, 68, 117));
        standardRooms.setFont(customFont15);
        standardRooms.setText("  standard rooms");
        standardRooms.setForeground(Color.white);
        standardRooms.setBounds(5, 61, 160, 20);

        standardRoomPanel = new RoundLabel(new Color(40, 68, 117));
        standardRoomPanel.setBounds(263, 20, 140, 86);
        standardRoomPanel.setFont(customFont50);
        standardRoomPanel.setText(Integer.toString(nStandardRooms));
        standardRoomPanel.setForeground(Color.white);
        standardRoomPanel.add(standardRooms);
        standardRoomPanel.setVerticalAlignment(JLabel.TOP);;
        standardRoomPanel.setHorizontalAlignment(JLabel.CENTER);

        deluxeRooms = new RoundLabel(new Color(40, 68, 117));
        deluxeRooms.setFont(customFont15);
        deluxeRooms.setText("        deluxe rooms");
        deluxeRooms.setForeground(Color.white);
        deluxeRooms.setBounds(5, 61, 165, 20);

        deluxeRoomPanel = new RoundLabel(new Color(40, 68, 117));
        deluxeRoomPanel.setBounds(375, 20, 165, 86);
        deluxeRoomPanel.setFont(customFont50);
        deluxeRoomPanel.setText(Integer.toString(nDeluxeRooms)); 
        deluxeRoomPanel.setForeground(Color.white);
        deluxeRoomPanel.add(deluxeRooms);
        deluxeRoomPanel.setVerticalAlignment(JLabel.TOP);;
        deluxeRoomPanel.setHorizontalAlignment(JLabel.CENTER);

        executiveRooms = new RoundLabel(new Color(40, 68, 117));
        executiveRooms.setFont(customFont15);
        executiveRooms.setText("      executive rooms");
        executiveRooms.setForeground(Color.white);
        executiveRooms.setBounds(5, 61, 165, 20);

        executiveRoomPanel = new RoundLabel(new Color(40, 68, 117));
        executiveRoomPanel.setBounds(303, 116, 175, 86);
        executiveRoomPanel.setFont(customFont50);
        executiveRoomPanel.setText(Integer.toString(nExecutiveRooms)); 
        executiveRoomPanel.setForeground(Color.white);
        executiveRoomPanel.add(executiveRooms);
        executiveRoomPanel.setVerticalAlignment(JLabel.TOP);;
        executiveRoomPanel.setHorizontalAlignment(JLabel.CENTER);

        int roomViewHeight;

        if (hotel.countRooms(0) > 25){
            roomViewHeight = (((hotel.countRooms(0) - 1) / 5 - 3) * 9 + (((hotel.countRooms(0) - 1) / 5 - 4) * 30)) + 198 - 15;
        }
        else {
            roomViewHeight = 198;
        }

        roomView = new RoomView(hotel, this);
        roomView.setBounds(0, 0, 250, roomViewHeight);
        roomView.setPreferredSize(new Dimension(250, roomViewHeight));

        ScrollPaneCustom scrollPaneRoomView = new ScrollPaneCustom(roomView, new Color(40, 68, 117), new Color(40, 68, 117), new Color(27, 43, 80));
        scrollPaneRoomView.setBounds(2, 2, 250, 196);
        scrollPaneRoomView.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPaneRoomView.setPreferredSize(new Dimension(7, 7));

        // * Container * //
        RoundPanel roomViewContainer = new RoundPanel(new Color(27, 43, 80));
        roomViewContainer.setLayout(null);
        roomViewContainer.setBounds(5, 5, 255, 203);
        roomViewContainer.add(scrollPaneRoomView);
        
        roomInfoContainer = new RoundPanel(new Color(40, 68, 117));
        roomInfoContainer.setLayout(null);
        roomInfoContainer.setPreferredSize(new Dimension(530, 447));
        roomInfoContainer.add(availDates);
        roomInfoContainer.add(calendar);
        roomInfoContainer.add(roomName);
        roomInfoContainer.add(roomPrice);
        roomInfoContainer.add(roomType);
        roomInfoContainer.add(roomViewContainer);
        roomInfoContainer.add(standardRoomPanel);
        roomInfoContainer.add(deluxeRoomPanel);
        roomInfoContainer.add(executiveRoomPanel);
        
        ScrollPaneCustom scrollPane = new ScrollPaneCustom(roomInfoContainer, new Color(51, 88, 150), new Color(51, 88, 150), new Color(40, 68, 117));
        scrollPane.setBounds(5, 5, 530, 210);

        this.setLayout(null);
        this.add(scrollPane);
    }

    @Override
    public void buttonClicked(String buttonName) {

    }

    @Override
    public void roomButtonClicked(String roomButtonName) {
        /*for (int i = 0; i < hotel.countRooms(0); i++){
            ArrayList<OptionButton> roomButtons = roomView.getRooms();
            String type = hotel.fetchRoom(i).getRoomType();
            float pricePerNight = hotel.fetchRoom(i).getRoomPrice();
            String name = hotel.fetchRoom(i).getRoomName();
            String price = String.format("%.2f", pricePerNight * (i % 7)); 

            if (roomButtonName.equals(name)){
                roomName.setText("Room " + name);
                roomPrice.setText(price + " per night");
                roomType.setText(type + " Room");
                roomButtons.get(i).setColor(new Color(51, 88, 150));

                int[] availDatesTemp = hotel.checkRoomAvailability(hotel.fetchRoom(i));

                for (int j = 0; j < availDatesTemp.length; j++){
                    for (int k = 0; k < 31; k++){
                        if (k + 1 == availDatesTemp[j]){ 
                            days.get(k).setColor(new Color(51, 88, 150));
                            days.get(k).setColorOver(new Color(51, 88, 150));
                            days.get(k).setColorClick(new Color(51, 88, 150));
                        } 
                    }
                }
            }
            else {
                for (int j = 0; j < hotel.countRooms(0); j++){
                    roomButtons.get(i).setColor(new Color(27, 43, 80));
                }

            }
        }*/
    }

    @Override
    public void reservationButtonClicked(String reservationName) {

    }

    public CalendarView getCalendar(){
        return calendar;
    }

    public void setCalendar(CalendarView calendar){
        this.calendar = calendar;
    }

    public RoomView getRoomView(){
        return roomView;
    }

    public void setRoomView(RoomView roomView){
        this.roomView = roomView;
    }

    public RoundLabel getRoomName(){
        return roomName;
    }

    public void setRoomName(RoundLabel roomName){
        this.roomName = roomName;
    }

    public RoundLabel getRoomPrice(){
        return roomPrice;
    }

    public void setRoomPrice(RoundLabel roomPrice){
        this.roomPrice = roomPrice;
    }

    public RoundLabel getRoomType(){
        return roomType;
    }

    public void setRoomType(RoundLabel roomType){
        this.roomType = roomType;
    }

    public RoundLabel getAvailDates(){
        return availDates;
    }

    public void setAvailDates(RoundLabel availDates){
        this.availDates = availDates;
    }

    public RoundLabel getStandardRooms(){
        return standardRooms;
    }

    public void setStandardRooms(RoundLabel standardRooms){
        this.standardRooms = standardRooms;
    }

    public RoundLabel getDeluxeRooms(){
        return deluxeRooms;
    }

    public void setDeluxeRooms(RoundLabel deluxeRooms){
        this.deluxeRooms = deluxeRooms;
    }

    public RoundLabel getExecutiveRooms(){
        return executiveRooms;
    }

    public void setExecutiveRooms(RoundLabel executiveRooms){
        this.executiveRooms = executiveRooms;
    }    
}
