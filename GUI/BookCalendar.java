import java.awt.*;
import java.util.*;

public class BookCalendar extends CalendarView{
    
    private ArrayList<RoundPanel> highlightedDays;
    private ArrayList<OptionButton> days;

    public BookCalendar(ButtonClickListener listener){

        super(listener);
        this.days = super.getDays();


        /*Font customFont = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 10);

        ArrayList<OptionButton> days = new ArrayList<OptionButton>();

        for (int i = 0; i < 31; i++){

            OptionButton day = new OptionButton(Integer.toString(i + 1));
            String dayIndex = String.format("%02d", i + 1);

            if ((i + 1) % 7 == 1){
                day.setBounds((i % 7 * 41) + (i % 7 + 1) * 8, (i / 7 + 1) * 9 + (i / 7 * 30), 41, 30);
            }
            else {
                day.setBounds((i % 7 * 41) + (i % 7 + 1) * 5 + 3, (i / 7 + 1) * 9 + (i / 7 * 30), 41, 30);
            }

            day.setFont(customFont);
            day.addActionListener(new ActionListener(){

                @Override
                public void actionPerformed(ActionEvent e){

                    listener.buttonClicked(dayIndex);
                }
            });

            days.add(day);
            this.add(days.get(i));
        }*/
    }

    public void setHighlightedDays(int checkIn, int checkOut){

        highlightedDays = new ArrayList<RoundPanel>();

        for (int i = 0; i < 31; i++){
            if (Integer.valueOf(days.get(i).getButtonName()) >= checkIn && Integer.valueOf(days.get(i).getButtonName()) <= checkOut){
                days.get(i).setColor(new Color(51, 88, 150));
                days.get(i).setColorOver(new Color(51, 88, 150));
            }
        }
        
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
