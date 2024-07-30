package src.HRS.View;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class CalendarView extends RoundPanel{
    
    private ArrayList<OptionButton> days;
    private Font customFont;
    private ActionListener action;

    public CalendarView(){
        
        super(new Color(27, 43, 80));

        customFont = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 10);

        days = new ArrayList<OptionButton>();
        
        for (int i = 0; i < 31; i++){
            OptionButton day = new OptionButton(Integer.toString(i + 1));

            if ((i + 1) % 7 == 1){
                day.setBounds((i % 7 * 41) + (i % 7 + 1) * 8, (i / 7 + 1) * 9 + (i / 7 * 30), 41, 30);
            }
            else {
                day.setBounds((i % 7 * 41) + (i % 7 + 1) * 5 + 3, (i / 7 + 1) * 9 + (i / 7 * 30), 41, 30);
            }

            day.setFont(customFont);

            days.add(day);
            this.add(days.get(i));
        }


        this.setLayout(null);
        this.setBounds(10, 10, 335, 203);
    }

    public ArrayList<OptionButton> getDays(){
        return days;
    }

    public ActionListener getActionListener(){
        return action;
    }
}
