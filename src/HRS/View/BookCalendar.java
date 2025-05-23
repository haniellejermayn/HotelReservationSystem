package src.HRS.View;

import java.awt.*;
import java.util.*;

/**
 * The BookCalendar class extends CalendarView to provide functionality for highlighting
 * a range of days based on check-in and check-out dates.
 */
public class BookCalendar extends CalendarView {

    private ArrayList<RoundPanel> highlightedDays;
    private ArrayList<OptionButton> days;

    /**
     * Constructs a new BookCalendar.
     */
    public BookCalendar() {
        super();
        this.days = super.getDays();
    }

    /**
     * Sets the highlighted days in the calendar based on the check-in and check-out dates.
     *
     * @param checkIn the check-in date
     * @param checkOut the check-out date
     */
    public void setHighlightedDays(int checkIn, int checkOut) {
        highlightedDays = new ArrayList<>();

        if (!(checkIn == 0 && checkOut == 0)) {
            for (int i = 0; i < 31; i++) {
                if (Integer.valueOf(days.get(i).getButtonName()) >= checkIn && Integer.valueOf(days.get(i).getButtonName()) <= checkOut) {
                    days.get(i).setColor(new Color(51, 88, 150));
                    days.get(i).setColorOver(new Color(51, 88, 150));
                }
            }

            for (int i = 0; i < 5; i++) {
                int width;
                int height = 30;
                int xVal;
                int yVal; 
                RoundPanel highlightedDay = new RoundPanel(new Color(51, 88, 150));

                if ((checkIn - 1) / 7 == i || (checkOut - 1) / 7 == i) {
                    if ((checkIn - 1) / 7 != i) {
                        width = (((checkOut - 1) % 7 + 1) * 41) + ((checkOut - 1) % 7) * 5;
                        xVal = 8;
                        yVal = (checkIn / 7 + (i - (checkIn - 1) / 7)) * 9 + (((checkIn - 1) / 7 + (i - (checkIn - 1) / 7)) * 30);
                        yVal = ((checkOut - 1) / 7 + 1) * 9 + ((checkOut - 1) / 7 * 30);

                    } else if ((checkOut - 1) / 7 != i) {
                        width = ((7 - (checkIn - 1) % 7)) * 41 + (7 - (checkIn % 7)) * 5;
                        xVal = (((checkIn - 1) % 7) * 41) + ((checkIn % 7) * 5) + 3;
                        yVal = ((checkIn - 1) / 7 + 1) * 9 + ((checkIn - 1) / 7 * 30);

                        if (checkIn % 7 == 0) {
                            width = 41;
                            xVal = 6 * 41 + 6 * 5 + 8;
                            yVal = (checkIn - 1) / 7 * 30 + checkIn / 7 * 9;
                        } else if (checkIn % 7 == 1) {
                            xVal = 8;
                        }

                        if (i == 0) {
                            yVal = 5;
                        }
                    } else {
                        width = ((checkOut - checkIn) + 1) * 41 + (checkOut - checkIn) * 5;
                        yVal = (checkIn / 7 + 1) * 9 + ((checkIn - 1) / 7 * 30);
                        xVal = ((checkIn - 1) % 7) * 41 + ((checkIn - 1) % 7 * 5 + 3) + 8;

                        if (i == 0) {
                            yVal = (checkIn / 7 + (i - (checkIn - 1) / 7)) * 9 + (((checkIn - 1) / 7 + (i - (checkIn - 1) / 7)) * 30);
                        }

                        if (checkIn % 7 == 1 || checkOut % 7 == 1) {
                            xVal = (checkIn - 1) % 7 * 41 + (checkIn % 7 * 8);
                        } else {
                            xVal = (checkIn - 1) % 7 * 41 + ((checkIn - 1) % 7 * 5) + 8;
                        }
                    }
                } else if ((checkIn - 1) / 7 < i && (checkOut - 1) / 7 > i) {
                    width = (7 * 41) + (6 * 5);
                    xVal = 8;
                    yVal = (i + 1) * 9 + (i * 30);
                } else {
                    xVal = 0;
                    yVal = 0;
                    width = 0;
                    height = 0;
                }

                if (i == 0) {
                    yVal = 9;
                }

                highlightedDay.setBounds(xVal, yVal, width, height);
                highlightedDays.add(highlightedDay);
                this.add(highlightedDays.get(i));
            }
        }
    }

    /**
     * Returns the list of highlighted days.
     *
     * @return the list of highlighted days
     */
    public ArrayList<RoundPanel> getHighlightedDays() {
        return highlightedDays;
    }
}
