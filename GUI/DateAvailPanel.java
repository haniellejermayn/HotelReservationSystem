import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class DateAvailPanel extends RoundPanel implements ButtonClickListener{

    CalendarView calendar;
    RoundLabel availPanel, bookedPanel;
    RoundLabel availRooms, bookedRooms;
    RoundLabel availNo, bookedNo;

    Font customFont15;
    Font customFont50;

                // change to Hotel hotel
    DateAvailPanel(String hotel){

        super(new Color(40, 68, 117));

        customFont15 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 15);
        customFont50 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 50);

        calendar = new CalendarView(this);

        availNo = new RoundLabel(new Color(40, 68, 117));
        availNo.setFont(customFont50);
        availNo.setText("30");
        availNo.setForeground(Color.white);
        availNo.setBounds(410, 20, 100, 55);

        availRooms = new RoundLabel(new Color(40, 68, 117));
        availRooms.setFont(customFont15);
        availRooms.setText("      available rooms");
        availRooms.setForeground(Color.white);
        availRooms.setBounds(5, 61, 165, 20);
        
        bookedNo = new RoundLabel(new Color(40, 68, 117));
        bookedNo.setFont(customFont50);
        bookedNo.setText("20");
        bookedNo.setForeground(Color.white);
        bookedNo.setBounds(410, 120, 100, 55);

        bookedRooms = new RoundLabel(new Color(40, 68, 117));
        bookedRooms.setFont(customFont15);
        bookedRooms.setText("       booked rooms");
        bookedRooms.setForeground(Color.white);
        bookedRooms.setBounds(5, 61, 165, 20);
        
        availPanel = new RoundLabel(new Color(40, 68, 117));
        availPanel.setBounds(355, 20, 175, 86);
        availPanel.setFont(customFont50);
        availPanel.setText("30");
        availPanel.setForeground(Color.white);
        availPanel.add(availRooms);
        availPanel.setVerticalAlignment(JLabel.TOP);;
        availPanel.setHorizontalAlignment(JLabel.CENTER);
        
        bookedPanel = new RoundLabel(new Color(40, 68, 117));
        bookedPanel.setBounds(355, 116, 175, 86);
        bookedPanel.setFont(customFont50);
        bookedPanel.setText("20");
        bookedPanel.setForeground(Color.white);
        bookedPanel.add(bookedRooms);
        bookedPanel.setVerticalAlignment(JLabel.TOP);
        bookedPanel.setHorizontalAlignment(JLabel.CENTER);

        this.setLayout(null);
        this.add(calendar);
        this.add(availPanel);
        this.add(bookedPanel);
    }

    @Override
    public void buttonClicked(String buttonName) {
        for (int i = 0; i < 31; i++){
            String dayIndex = String.format("%02d", i + 1); // change to necessary information

            if (buttonName.equals(dayIndex)){
                availPanel.setText(dayIndex);
                bookedPanel.setText(dayIndex);
            }
        }
    }

}
