import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class BookCalendar extends CalendarView{
    
    ArrayList<RoundPanel> highlightedDays;

    BookCalendar(){

        setHighlightedDays(1, 4);

    }

    public void setHighlightedDays(int checkIn, int checkOut){

        highlightedDays = new ArrayList<RoundPanel>();
        
        for (int i = 0; i < 5; i++){

            int width;
            int height = 30;
            int xVal;
            int yVal; 
            RoundPanel highlightedDay = new RoundPanel(new Color(51, 88, 150));
            
            if ((checkIn - 1) / 7 == i || (checkOut - 1) / 7 == i){

                if ((checkIn - 1) / 7 != i){
                    width = (((checkOut - 1) % 7 + 1) * 41) + ((checkOut - 1) % 7) * 5;
                    xVal = 8;
                    yVal = (checkIn / 7 + (i - (checkIn - 1) / 7)) * 9 + (((checkIn - 1) / 7 + (i - (checkIn - 1) / 7)) * 30);
                    
                    yVal = ((checkOut - 1) / 7 + 1) * 9 + ((checkOut - 1) / 7 * 30);

                }
                else if ((checkOut - 1) / 7 != i){

                    width = ((7 - (checkIn - 1) % 7)) * 41 + (7 - (checkIn % 7)) * 5;
                    xVal = (((checkIn - 1) % 7) * 41) + ((checkIn % 7) * 5) + 3;
                    yVal = ((checkIn - 1) / 7 + 1) * 9 + ((checkIn - 1) / 7 * 30);

                    if (checkIn % 7 == 0){
                        width = 41;
                        xVal = 6 * 41 + 6 * 5 + 8;
                        yVal = (checkIn - 1) / 7 * 30 + checkIn / 7 * 9;
                    }
                    else if (checkIn % 7 == 1){
                        xVal = 8;
                    }

                    if (i == 0){
                        yVal = 5;
                    }
                }
                else{
                    width = ((checkOut - checkIn) + 1) * 41 + (checkOut - checkIn) * 5;
                    yVal = (checkIn / 7 + 1) * 9 + ((checkIn - 1) / 7 * 30);
                    xVal = ((checkIn - 1) % 7) * 41 + ((checkIn - 1) % 7 * 5 + 3) + 8;
                    
                    if (i == 0){
                        yVal = (checkIn / 7 + (i - (checkIn - 1) / 7)) * 9 + (((checkIn - 1) / 7 + (i - (checkIn - 1) / 7)) * 30);
                    }

                    if (checkIn % 7 == 1 || checkOut % 7 == 1){
                        xVal = (checkIn - 1) % 7 * 41 + (checkIn % 7 * 8);
                    }
                    else{
                        xVal = (checkIn - 1) % 7 * 41 + ((checkIn - 1) % 7 * 5) + 8;
                    }
                }  
            }
            else if ((checkIn - 1) / 7 < i && (checkOut - 1) / 7 > i){
                width = (7 * 41) + (6 * 5);
                xVal = 8;
                yVal = (i + 1) * 9 + (i * 30);
            }
            else{
                xVal = 0;
                yVal = 0;
                width = 0;
                height = 0;
            }

            if (i == 0){
                yVal = 9;
            }

            highlightedDay.setBounds(xVal, yVal, width, height);
            
            highlightedDays.add(highlightedDay);
            this.add(highlightedDays.get(i));
        }
    }
}
