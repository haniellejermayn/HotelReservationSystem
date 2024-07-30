package src.HRS.View;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import src.HRS.Model.Hotel;

/**
 * The RoomInfoPanel class represents a panel that displays information about the rooms in a hotel.
 * It includes details such as room name, price, type, available dates, and counts of different room types.
 */
public class RoomInfoPanel extends RoundPanel {

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

    /**
     * Constructs a new RoomInfoPanel for the specified hotel.
     *
     * @param hotel the hotel containing the room information
     */
    public RoomInfoPanel(Hotel hotel) {
        super(new Color(40, 68, 117));

        customFont15 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 15);
        customFont30 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 30);
        customFont50 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 50);

        // * Available Dates * //
        calendar = new CalendarView();
        calendar.setBounds(180, 239, 335, 203);
        days = calendar.getDays();

        for (OptionButton day : days) {
            day.setEnabled(false);
            day.setColorOver(day.getColor());
            day.setColorClick(day.getColor());
        }
        days.get(30).setVisible(false);

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

        // * Available Dates * //
        availDates = new RoundLabel(new Color(27, 43, 80));
        availDates.setBounds(360, 405, 155, 26);
        availDates.setFont(customFont15);
        availDates.setText("Available Dates");
        availDates.setForeground(new Color(51, 88, 150));
        availDates.setVerticalAlignment(JLabel.CENTER);
        availDates.setHorizontalAlignment(JLabel.CENTER);

        // * Room Types * //
        nStandardRooms = hotel.countRooms(1);
        nDeluxeRooms = hotel.countRooms(2);
        nExecutiveRooms = hotel.countRooms(3);

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
        standardRoomPanel.setVerticalAlignment(JLabel.TOP);
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
        deluxeRoomPanel.setVerticalAlignment(JLabel.TOP);
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
        executiveRoomPanel.setVerticalAlignment(JLabel.TOP);
        executiveRoomPanel.setHorizontalAlignment(JLabel.CENTER);

        int roomViewHeight;
        if (hotel.countRooms(0) > 25) {
            roomViewHeight = (((hotel.countRooms(0) - 1) / 5 - 3) * 9 + (((hotel.countRooms(0) - 1) / 5 - 4) * 30)) + 198 - 15;
        } else {
            roomViewHeight = 198;
        }

        roomView = new RoomView(hotel);
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

    /**
     * Returns the CalendarView component.
     *
     * @return the CalendarView component
     */
    public CalendarView getCalendar() {
        return calendar;
    }

    /**
     * Sets the CalendarView component.
     *
     * @param calendar the CalendarView component to set
     */
    public void setCalendar(CalendarView calendar) {
        this.calendar = calendar;
    }

    /**
     * Returns the RoomView component.
     *
     * @return the RoomView component
     */
    public RoomView getRoomView() {
        return roomView;
    }

    /**
     * Sets the RoomView component.
     *
     * @param roomView the RoomView component to set
     */
    public void setRoomView(RoomView roomView) {
        this.roomView = roomView;
    }

    /**
     * Returns the room name label.
     *
     * @return the room name label
     */
    public RoundLabel getRoomName() {
        return roomName;
    }

    /**
     * Sets the room name label.
     *
     * @param roomName the room name label to set
     */
    public void setRoomName(RoundLabel roomName) {
        this.roomName = roomName;
    }

    /**
     * Returns the room price label.
     *
     * @return the room price label
     */
    public RoundLabel getRoomPrice() {
        return roomPrice;
    }

    /**
     * Sets the room price label.
     *
     * @param roomPrice the room price label to set
     */
    public void setRoomPrice(RoundLabel roomPrice) {
        this.roomPrice = roomPrice;
    }

    /**
     * Returns the room type label.
     *
     * @return the room type label
     */
    public RoundLabel getRoomType() {
        return roomType;
    }

    /**
     * Sets the room type label.
     *
     * @param roomType the room type label to set
     */
    public void setRoomType(RoundLabel roomType) {
        this.roomType = roomType;
    }

    /**
     * Returns the available dates label.
     *
     * @return the available dates label
     */
    public RoundLabel getAvailDates() {
        return availDates;
    }

    /**
     * Sets the available dates label.
     *
     * @param availDates the available dates label to set
     */
    public void setAvailDates(RoundLabel availDates) {
        this.availDates = availDates;
    }

    /**
     * Returns the standard rooms label.
     *
     * @return the standard rooms label
     */
    public RoundLabel getStandardRooms() {
        return standardRooms;
    }

    /**
     * Sets the standard rooms label.
     *
     * @param standardRooms the standard rooms label to set
     */
    public void setStandardRooms(RoundLabel standardRooms) {
        this.standardRooms = standardRooms;
    }

    /**
     * Returns the deluxe rooms label.
     *
     * @return the deluxe rooms label
     */
    public RoundLabel getDeluxeRooms() {
        return deluxeRooms;
    }

    /**
     * Sets the deluxe rooms label.
     *
     * @param deluxeRooms the deluxe rooms label to set
     */
    public void setDeluxeRooms(RoundLabel deluxeRooms) {
        this.deluxeRooms = deluxeRooms;
    }

    /**
     * Returns the executive rooms label.
     *
     * @return the executive rooms label
     */
    public RoundLabel getExecutiveRooms() {
        return executiveRooms;
    }

    /**
     * Sets the executive rooms label.
     *
     * @param executiveRooms the executive rooms label to set
     */
    public void setExecutiveRooms(RoundLabel executiveRooms) {
        this.executiveRooms = executiveRooms;
    }
}
