package src.HRS.View;

import javax.swing.*;
import src.HRS.Model.Hotel;
import java.awt.*;
import java.util.ArrayList;

public class ResInfoPanel extends RoundPanel{
    
    private int nReservations;
    private ReservationView resView;
    private BookCalendar calendar;
    private ArrayList<JPanel> priceBreakdown;
    private RoundLabel totalPrice;
    private RoundLabel roomType;
    private RoundLabel guestInfoPanel;
    private RoundPanel resInfoContainer;
    private PriceBreakdownPanel priceBreakdownContainer;
    private ArrayList<OptionButton> days;
    private ScrollPaneCustom priceScrollPane;

    private Font customFont15;

    public ResInfoPanel(Hotel hotel){

        super(new Color(40, 68, 117));

        customFont15 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 15);

        // * Check In / Out * //
        
        calendar = new BookCalendar();
        calendar.setBounds(5, 239, 335, 203);
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
        roomType.setText("Standard Room"); 
        roomType.setForeground(Color.white);
        roomType.setVerticalAlignment(JLabel.CENTER);
        roomType.setHorizontalAlignment(JLabel.CENTER);

        // * Guest Info * //
        guestInfoPanel = new RoundLabel(new Color(40, 68, 117));
        guestInfoPanel.setBounds(20, 75, 200, 75);
        guestInfoPanel.setFont(customFont15);
        guestInfoPanel.setText("Guest's Reservation");
        guestInfoPanel.setForeground(Color.white);
        guestInfoPanel.add(roomType);
        guestInfoPanel.setVerticalAlignment(JLabel.TOP);;
        guestInfoPanel.setHorizontalAlignment(JLabel.CENTER);
        
        // * Price BreakDown * //

        JPanel tempContainer = new JPanel();

        priceScrollPane = new ScrollPaneCustom(tempContainer, new Color(51, 88, 150), new Color(51, 88, 150), new Color(40, 68, 117));
        priceScrollPane.setBounds(345, 250, 175, 150);
        priceScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        priceScrollPane.setVisible(false);

        // * Total Price * //
        totalPrice = new RoundLabel(new Color(40, 68, 117));
        totalPrice.setBounds(345, 410, 175, 26);
        totalPrice.setFont(customFont15);
        totalPrice.setForeground(Color.white);
        totalPrice.setVerticalAlignment(JLabel.CENTER);
        totalPrice.setHorizontalAlignment(JLabel.CENTER);
        totalPrice.setVisible(false);

        nReservations = hotel.countReservations(); 

        int resViewHeight = nReservations * 39 + 5;

        // * Reservations * //
        resView = new ReservationView(hotel);
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

    public ReservationView getResView(){
        return resView;
    }

    public void setResView(ReservationView resView){
        this.resView = resView;
    }

    public BookCalendar getBookCalendar(){
        return calendar;
    }

    public void setBookCalendar(BookCalendar calendar){
        this.calendar = calendar;
    }

    public ArrayList<JPanel> getPriceBreakdown(){
        return priceBreakdown;
    }

    public void setPriceBreakdown(ArrayList<JPanel> priceBreakdown){
        this.priceBreakdown = priceBreakdown;
    }

    public RoundLabel getTotalPrice(){
        return totalPrice;
    }

    public void setTotalPrice(RoundLabel totalPrice){
        this.totalPrice = totalPrice;
    }

    public RoundLabel getRoomType(){
        return roomType;
    }

    public void setRoomType(RoundLabel roomType){
        this.roomType = roomType;
    }

    public RoundLabel getGuestInfoPanel(){
        return guestInfoPanel;
    }

    public void setGuestInfoPanel(RoundLabel guestInfoPanel){
        this.guestInfoPanel = guestInfoPanel;
    }

    public RoundPanel getResInfoContainer(){
        return resInfoContainer;
    }

    public void setResInfoContainer(RoundPanel resInfoContainer){
        this.resInfoContainer = resInfoContainer;
    }

    public PriceBreakdownPanel getPriceBreakdownContainer(){
        return priceBreakdownContainer;
    }

    public void setPriceBreakdownContainer(PriceBreakdownPanel priceBreakdownContainer){
        this.priceBreakdownContainer = priceBreakdownContainer;
    }

    public ScrollPaneCustom getPriceScrollPane(){
        return priceScrollPane;
    }

    public void setPriceScrollPane(ScrollPaneCustom priceScrollPane){
        this.priceScrollPane = priceScrollPane;
    }
}
