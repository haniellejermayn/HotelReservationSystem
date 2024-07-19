import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ResInfoPanel extends RoundPanel implements ButtonClickListener{

    private int nReservations;
    private BookCalendar calendar;
    private ReservationView resView;
    private ArrayList<OptionButton> days;
    private RoundLabel totalPrice, roomType;
    //private RoundLabel availDates;
    //private RoundLabel standardRooms, deluxeRooms, executiveRooms;
    private RoundLabel guestInfoPanel;
    private RoundPanel resInfoContainer;

    private Font customFont15;
    private Font customFont30;
    private Font customFont50;


                // change to Hotel hotel
    ResInfoPanel(String hotel){

        super(new Color(40, 68, 117));


        customFont15 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 15);
        customFont30 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 30);
        customFont50 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 50);


        int checkIn = 12;
        int checkOut = 20;

        calendar = new BookCalendar(this);
        calendar.setBounds(5, 239, 335, 203);
        calendar.setHighlightedDays(checkIn, checkOut);
        days = calendar.getDays();
        
        for(int i = 0; i < days.size(); i++){
            days.get(i).setEnabled(false);
            days.get(i).setColorOver(days.get(i).getColor());
            days.get(i).setColorClick(days.get(i).getColor());
        }

        roomType = new RoundLabel(new Color(40, 68, 117));
        roomType.setBounds(0, 30, 200, 26);
        roomType.setFont(customFont15);
        roomType.setText("Standard Room"); // change to room type
        roomType.setForeground(Color.white);
        roomType.setVerticalAlignment(JLabel.CENTER);
        roomType.setHorizontalAlignment(JLabel.CENTER);

        guestInfoPanel = new RoundLabel(new Color(40, 68, 117));
        guestInfoPanel.setBounds(20, 75, 200, 75);
        guestInfoPanel.setFont(customFont15);
        guestInfoPanel.setText("Guest's Reservation"); // change to guest name
        guestInfoPanel.setForeground(Color.white);
        guestInfoPanel.add(roomType);
        guestInfoPanel.setVerticalAlignment(JLabel.TOP);;
        guestInfoPanel.setHorizontalAlignment(JLabel.CENTER);
        
        totalPrice = new RoundLabel(new Color(40, 68, 117));
        totalPrice.setBounds(345, 400, 175, 26);
        totalPrice.setFont(customFont15);
        totalPrice.setText("Total: 1299.00"); // change to total price
        totalPrice.setForeground(Color.white);
        totalPrice.setVerticalAlignment(JLabel.CENTER);
        totalPrice.setHorizontalAlignment(JLabel.CENTER);

        nReservations = 6;

        int resViewHeight = nReservations * 39 + 5;

        resView = new ReservationView(this, nReservations);
        resView.setBounds(0, 0, 250, resViewHeight);
        resView.setPreferredSize(new Dimension(250, resViewHeight));

        ScrollPaneCustom scrollPaneResView = new ScrollPaneCustom(resView, new Color(40, 68, 117), new Color(40, 68, 117), new Color(27, 43, 80));
        //ScrollPaneCustom scrollPaneRoomView = new ScrollPaneCustom(roomView, Color.white, Color.white, new Color(27, 43, 80));
        scrollPaneResView.setBounds(2, 2, 250, 196);
        scrollPaneResView.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPaneResView.setPreferredSize(new Dimension(7, 7));

        RoundPanel resViewContainer = new RoundPanel(new Color(27, 43, 80));
        resViewContainer.setLayout(null);
        resViewContainer.setBounds(255, 5, 257, 203);
        resViewContainer.add(scrollPaneResView);

        /*RoundPanel roomViewContainer = new RoundPanel(new Color(27, 43, 80));
        roomViewContainer.setLayout(null);
        roomViewContainer.setBounds(5, 5, 255, 203);
        //roomViewContainer.add(scrollPaneRoomView);
        
        resInfoContainer.add(roomViewContainer);
        resInfoContainer.add(standardRoomPanel);
        resInfoContainer.add(deluxeRoomPanel);
        resInfoContainer.add(executiveRoomPanel);*/
        
        resInfoContainer = new RoundPanel(new Color(40, 68, 117));
        resInfoContainer.setLayout(null);
        resInfoContainer.setPreferredSize(new Dimension(530, 447));
        resInfoContainer.add(guestInfoPanel);
        resInfoContainer.add(resViewContainer);
        resInfoContainer.add(calendar);
        resInfoContainer.add(totalPrice);

        ScrollPaneCustom scrollPane = new ScrollPaneCustom(resInfoContainer, new Color(51, 88, 150), new Color(51, 88, 150), new Color(40, 68, 117));
        scrollPane.setBounds(5, 5, 530, 210);
        

        /*scrollPane.setLayout(null);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setViewportBorder(null);*/

        this.setLayout(null);
        this.add(scrollPane);
    }

    @Override
    public void buttonClicked(String buttonName) {

        // change to necessary information
        //int nRooms = 30;
        ArrayList<String> reservationsTemp = new ArrayList<String>();
        reservationsTemp.add("Kelsey");
        reservationsTemp.add("Hep");
        reservationsTemp.add("Hanielle");
        reservationsTemp.add("Francine");
        reservationsTemp.add("Justine");
        reservationsTemp.add("Liane");

        //String name;
        String type = "Executive";
        //float pricePerNight = 1299.00f;

        for (int i = 0; i < nReservations; i++){
            ArrayList<OptionButton> resButtons = resView.getReservations();
            String resName = reservationsTemp.get(i); // change to reservation Name
            //String price = String.format("%.2f", pricePerNight * (i % 7)); // change later

            if (buttonName.equals(resName)){
                guestInfoPanel.setText(reservationsTemp.get(i) + "'s Reservation");
                guestInfoPanel.remove(roomType);
                roomType.setText(type + " Room");
                guestInfoPanel.add(roomType);
                resButtons.get(i).setColor(new Color(51, 88, 150));

                // call resView.selectedHighlights() and pass check In and check Out dates of reservation
                // 
            }
            else {
                for (int j = 0; j < nReservations; j++){
                    resButtons.get(i).setColor(new Color(27, 43, 80));
                }
            }
        }
    }

}
