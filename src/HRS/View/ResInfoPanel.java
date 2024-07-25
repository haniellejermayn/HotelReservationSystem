package src.HRS.View;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ResInfoPanel extends RoundPanel implements EnhancedButtonClickListener{

    private int nReservations; // TODO: remove
    private ReservationView resView;
    private BookCalendar calendar;
    private ArrayList<JPanel> priceBreakdown;
    private RoundLabel totalPrice;
    private RoundLabel roomType;
    private RoundLabel guestInfoPanel;
    private RoundPanel resInfoContainer;
    private RoundPanel priceBreakdownContainer;
    private ArrayList<OptionButton> days;
    private ScrollPaneCustom priceScrollPane;

    private Font customFont13;
    private Font customFont15;


    // TODO: change to Hotel hotel
    ResInfoPanel(String hotel){

        super(new Color(40, 68, 117));

        customFont13 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 13);
        customFont15 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 15);

        // * Check In / Out * //
        int checkIn = 12; // TODO: change to reservation check In
        int checkOut = 20; // TODO: change to reservation check Out

        calendar = new BookCalendar(this);
        calendar.setBounds(5, 239, 335, 203);
        calendar.setHighlightedDays(checkIn, checkOut);
        days = calendar.getDays();
        
        for(int i = 0; i < days.size(); i++){
            days.get(i).setEnabled(false);
            days.get(i).setColorOver(days.get(i).getColor());
            days.get(i).setColorClick(days.get(i).getColor());
        }

        // * Room Type * //
        roomType = new RoundLabel(new Color(40, 68, 117));
        roomType.setBounds(0, 30, 200, 26);
        roomType.setFont(customFont15);
        roomType.setText("Standard Room"); // TODO: change to room type
        roomType.setForeground(Color.white);
        roomType.setVerticalAlignment(JLabel.CENTER);
        roomType.setHorizontalAlignment(JLabel.CENTER);

        // * Guest Info * //
        guestInfoPanel = new RoundLabel(new Color(40, 68, 117));
        guestInfoPanel.setBounds(20, 75, 200, 75);
        guestInfoPanel.setFont(customFont15);
        guestInfoPanel.setText("Guest's Reservation"); // TODO: change to guest name
        guestInfoPanel.setForeground(Color.white);
        guestInfoPanel.add(roomType);
        guestInfoPanel.setVerticalAlignment(JLabel.TOP);;
        guestInfoPanel.setHorizontalAlignment(JLabel.CENTER);
        
        // * Price BreakDown * //

        int nDates = 5; // TODO: remove
        ArrayList<String> dates = new ArrayList<String>(); // TODO: remove and replace
        dates.add("5th - 6th -> 110%");
        dates.add("6th - 7th -> 110%");
        dates.add("7th - 8th -> 100%");
        dates.add("8th - 9th -> 90%");
        dates.add("9th - 10th -> 120%");

        priceBreakdownContainer = new RoundPanel(new Color(40, 68, 117));
        priceBreakdownContainer.setPreferredSize(new Dimension(175, (nDates + 1) * 26 + nDates * 5));
        priceBreakdownContainer.setFont(customFont15);
        priceBreakdownContainer.setForeground(Color.white);

        priceBreakdown = new ArrayList<JPanel>();

        for (int i = 0; i < nDates; i++){ // TODO: replace with no. of dates
            JLabel dateTemp = new JLabel();
            dateTemp.setText(dates.get(i)); 
            dateTemp.setFont(customFont13);
            dateTemp.setForeground(Color.white);
            //dateTemp.setBackground(new Color(40, 68, 117));
            dateTemp.setVerticalAlignment(JLabel.CENTER);
            dateTemp.setHorizontalAlignment(JLabel.LEFT);

            JPanel panelTemp = new JPanel();
            panelTemp.setBounds(5, i * 26 + 5, 175, 23);
            panelTemp.setBackground(new Color(40, 68, 117));
            panelTemp.add(dateTemp);
            
            priceBreakdown.add(panelTemp);
            priceBreakdownContainer.add(priceBreakdown.get(i));
        } 

        priceScrollPane = new ScrollPaneCustom(priceBreakdownContainer, new Color(51, 88, 150), new Color(51, 88, 150), new Color(40, 68, 117));
        priceScrollPane.setBounds(345, 250, 175, 150);
        priceScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        // * Total Price * //
        totalPrice = new RoundLabel(new Color(40, 68, 117));
        totalPrice.setBounds(345, 400, 175, 26);
        totalPrice.setFont(customFont15);
        totalPrice.setText("Total: 1299.00"); // TODO: change to total price
        totalPrice.setForeground(Color.white);
        totalPrice.setVerticalAlignment(JLabel.CENTER);
        totalPrice.setHorizontalAlignment(JLabel.CENTER);

        nReservations = 6; // TODO: change to hotel reservations

        int resViewHeight = nReservations * 39 + 5;

        // * Reservations * //
        resView = new ReservationView(this, nReservations);
        resView.setBounds(0, 0, 250, resViewHeight);
        resView.setPreferredSize(new Dimension(250, resViewHeight));

        ScrollPaneCustom scrollPaneResView = new ScrollPaneCustom(resView, new Color(40, 68, 117), new Color(40, 68, 117), new Color(27, 43, 80));
        scrollPaneResView.setBounds(2, 2, 250, 196);
        scrollPaneResView.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPaneResView.setPreferredSize(new Dimension(7, 7));

        // * Reservation Container * //
        RoundPanel resViewContainer = new RoundPanel(new Color(27, 43, 80));
        resViewContainer.setLayout(null);
        resViewContainer.setBounds(255, 5, 257, 203);
        resViewContainer.add(scrollPaneResView);
        
        resInfoContainer = new RoundPanel(new Color(40, 68, 117));
        resInfoContainer.setLayout(null);
        resInfoContainer.setPreferredSize(new Dimension(530, 447));
        resInfoContainer.add(guestInfoPanel);
        resInfoContainer.add(resViewContainer);
        resInfoContainer.add(calendar);
        resInfoContainer.add(priceScrollPane);
        resInfoContainer.add(totalPrice);

        ScrollPaneCustom scrollPane = new ScrollPaneCustom(resInfoContainer, new Color(51, 88, 150), new Color(51, 88, 150), new Color(40, 68, 117));
        scrollPane.setBounds(5, 5, 530, 210);

        this.setLayout(null);
        this.add(scrollPane);
    }

    @Override
    public void buttonClicked(String buttonName) {

    }

    @Override
    public void roomButtonClicked(String roomName) {

    }

    @Override
    public void reservationButtonClicked(String reservationButtonName) {
        // TODO: change to hotel reservations
        /*ArrayList<String> reservationsTemp = new ArrayList<String>();
        reservationsTemp.add("Kelsey");
        reservationsTemp.add("Hep");
        reservationsTemp.add("Hanielle");
        reservationsTemp.add("Francine");
        reservationsTemp.add("Justine");
        reservationsTemp.add("Liane");*/

        String type = "Executive"; // change to reservation room type

        for (int i = 0; i < nReservations; i++){
            ArrayList<OptionButton> resButtons = resView.getReservations();
            String resName = resButtons.get(i).getButtonName(); // TODO: change to reservation Name

            if (reservationButtonName.equals(resName)){
                guestInfoPanel.setText(resName + "'s Reservation");
                guestInfoPanel.remove(roomType);
                roomType.setText(type + " Room");
                guestInfoPanel.add(roomType);
                resButtons.get(i).setColor(new Color(51, 88, 150));

                // TODO: call resView.setHighlightedDays() and pass check In and check Out dates of reservation
            }
            else {
                for (int j = 0; j < nReservations; j++){
                    resButtons.get(i).setColor(new Color(27, 43, 80));
                }
            }
        }
    }
}
