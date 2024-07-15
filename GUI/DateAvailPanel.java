import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class DateAvailPanel extends RoundPanel{

    CalendarView calendar;

                // change to Hotel hotel
    DateAvailPanel(String hotel){

        super(new Color(40, 68, 117));

        calendar = new CalendarView();
        calendar.setVisible(false);

        this.setLayout(null);
        this.add(calendar);
    }
    
}
