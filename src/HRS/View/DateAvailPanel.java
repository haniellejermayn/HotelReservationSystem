package src.HRS.View;

import java.awt.*;
import javax.swing.*;
import src.HRS.Model.Hotel;

/**
 * The {@code DateAvailPanel} class represents a panel displaying room availability and booking information for a specific hotel.
 * It includes a calendar view and labels showing the number of available and booked rooms.
 */
public class DateAvailPanel extends RoundPanel{

    CalendarView calendar;
    RoundLabel availPanel, bookedPanel;
    RoundLabel availRooms, bookedRooms;

    Hotel hotel;

    Font customFont15;
    Font customFont50;

    /**
     * Constructs a {@code DateAvailPanel} for the given hotel.
     * Initializes the panel with a calendar view and labels for available and booked rooms.
     *
     * @param hotel the {@link Hotel} for which this panel is to be created
     */
    public DateAvailPanel(Hotel hotel){

        super(new Color(40, 68, 117));
        this.hotel = hotel;

        customFont15 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 15);
        customFont50 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 50);

        calendar = new CalendarView();

        // * Available Rooms * //

        availRooms = new RoundLabel(new Color(40, 68, 117));
        availRooms.setFont(customFont15);
        availRooms.setText("      available rooms");
        availRooms.setForeground(Color.white);
        availRooms.setBounds(5, 61, 165, 20);

        availPanel = new RoundLabel(new Color(40, 68, 117));
        availPanel.setBounds(355, 20, 175, 86);
        availPanel.setFont(customFont50);
        availPanel.setText("00");
        availPanel.setForeground(Color.white);
        availPanel.add(availRooms);
        availPanel.setVerticalAlignment(JLabel.TOP);;
        availPanel.setHorizontalAlignment(JLabel.CENTER);

        // * Booked Rooms * //
        bookedRooms = new RoundLabel(new Color(40, 68, 117));
        bookedRooms.setFont(customFont15);
        bookedRooms.setText("       booked rooms");
        bookedRooms.setForeground(Color.white);
        bookedRooms.setBounds(5, 61, 165, 20);
        
        bookedPanel = new RoundLabel(new Color(40, 68, 117));
        bookedPanel.setBounds(355, 116, 175, 86);
        bookedPanel.setFont(customFont50);
        bookedPanel.setText("00");
        bookedPanel.setForeground(Color.white);
        bookedPanel.add(bookedRooms);
        bookedPanel.setVerticalAlignment(JLabel.TOP);
        bookedPanel.setHorizontalAlignment(JLabel.CENTER);

        this.setLayout(null);
        this.add(calendar);
        this.add(availPanel);
        this.add(bookedPanel);
    }

    /**
     * Returns the calendar view component.
     *
     * @return the {@link CalendarView} object representing the calendar
     */
    public CalendarView getCalendar(){
        return calendar;
    }

    /**
     * Sets the calendar view component.
     *
     * @param calendar the {@link CalendarView} object to set as the calendar view
     */
    public void setCalendar(CalendarView calendar){
        this.calendar = calendar;
    }

    /**
     * Returns the label displaying the available rooms.
     *
     * @return the {@link RoundLabel} object representing the available rooms panel
     */
    public RoundLabel getAvailPanel(){
        return availPanel;
    }

    /**
     * Sets the label displaying the available rooms.
     *
     * @param availPanel the {@link RoundLabel} object to set as the available rooms panel
     */
    public void setAvailPanel(RoundLabel availPanel){
        this.availPanel = availPanel;
    }

    /**
     * Returns the label displaying the booked rooms.
     *
     * @return the {@link RoundLabel} object representing the booked rooms panel
     */
    public RoundLabel getBookedPanel(){
        return bookedPanel;
    }

    /**
     * Sets the label displaying the booked rooms.
     *
     * @param bookedPanel the {@link RoundLabel} object to set as the booked rooms panel
     */
    public void setBookedPanel(RoundLabel bookedPanel){
        this.bookedPanel =  bookedPanel;
    }    
}
