package src.HRS.View;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import src.HRS.Model.Hotel;

/**
 * The ResInfoPanel class represents a panel that displays reservation information
 * for a specific hotel, including guest information, room type, check-in/check-out dates,
 * price breakdown, and total price.
 */
public class ResInfoPanel extends RoundPanel {

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

    /**
     * Constructs a new ResInfoPanel for the specified hotel.
     *
     * @param hotel the hotel containing the reservation information
     */
    public ResInfoPanel(Hotel hotel) {
        super(new Color(40, 68, 117));

        customFont15 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 15);

        // * Check In / Out * //
        calendar = new BookCalendar();
        calendar.setBounds(5, 239, 335, 203);
        days = calendar.getDays();

        for (OptionButton day : days) {
            day.setEnabled(false);
            day.setColorOver(day.getColor());
            day.setColorClick(day.getColor());
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
        guestInfoPanel.setVerticalAlignment(JLabel.TOP);
        guestInfoPanel.setHorizontalAlignment(JLabel.CENTER);

        // * Price Breakdown * //
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

    /**
     * Returns the ReservationView component.
     *
     * @return the ReservationView component
     */
    public ReservationView getResView() {
        return resView;
    }

    /**
     * Sets the ReservationView component.
     *
     * @param resView the ReservationView component to set
     */
    public void setResView(ReservationView resView) {
        this.resView = resView;
    }

    /**
     * Returns the BookCalendar component.
     *
     * @return the BookCalendar component
     */
    public BookCalendar getBookCalendar() {
        return calendar;
    }

    /**
     * Sets the BookCalendar component.
     *
     * @param calendar the BookCalendar component to set
     */
    public void setBookCalendar(BookCalendar calendar) {
        this.calendar = calendar;
    }

    /**
     * Returns the list of JPanel objects representing the price breakdown.
     *
     * @return the list of JPanel objects
     */
    public ArrayList<JPanel> getPriceBreakdown() {
        return priceBreakdown;
    }

    /**
     * Sets the list of JPanel objects representing the price breakdown.
     *
     * @param priceBreakdown the list of JPanel objects to set
     */
    public void setPriceBreakdown(ArrayList<JPanel> priceBreakdown) {
        this.priceBreakdown = priceBreakdown;
    }

    /**
     * Returns the total price label.
     *
     * @return the total price label
     */
    public RoundLabel getTotalPrice() {
        return totalPrice;
    }

    /**
     * Sets the total price label.
     *
     * @param totalPrice the total price label to set
     */
    public void setTotalPrice(RoundLabel totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * Returns the room type label.
     *
     * @return the room type label
     */
    public RoundLabel getRoomType() {
        return roomType;
    }

    /**
     * Sets the room type label.
     *
     * @param roomType the room type label to set
     */
    public void setRoomType(RoundLabel roomType) {
        this.roomType = roomType;
    }

    /**
     * Returns the guest information panel label.
     *
     * @return the guest information panel label
     */
    public RoundLabel getGuestInfoPanel() {
        return guestInfoPanel;
    }

    /**
     * Sets the guest information panel label.
     *
     * @param guestInfoPanel the guest information panel label to set
     */
    public void setGuestInfoPanel(RoundLabel guestInfoPanel) {
        this.guestInfoPanel = guestInfoPanel;
    }

    /**
     * Returns the reservation information container panel.
     *
     * @return the reservation information container panel
     */
    public RoundPanel getResInfoContainer() {
        return resInfoContainer;
    }

    /**
     * Sets the reservation information container panel.
     *
     * @param resInfoContainer the reservation information container panel to set
     */
    public void setResInfoContainer(RoundPanel resInfoContainer) {
        this.resInfoContainer = resInfoContainer;
    }

    /**
     * Returns the PriceBreakdownPanel component.
     *
     * @return the PriceBreakdownPanel component
     */
    public PriceBreakdownPanel getPriceBreakdownContainer() {
        return priceBreakdownContainer;
    }

    /**
     * Sets the PriceBreakdownPanel component.
     *
     * @param priceBreakdownContainer the PriceBreakdownPanel component to set
     */
    public void setPriceBreakdownContainer(PriceBreakdownPanel priceBreakdownContainer) {
        this.priceBreakdownContainer = priceBreakdownContainer;
    }

    /**
     * Returns the ScrollPaneCustom component for the price breakdown.
     *
     * @return the ScrollPaneCustom component
     */
    public ScrollPaneCustom getPriceScrollPane() {
        return priceScrollPane;
    }

    /**
     * Sets the ScrollPaneCustom component for the price breakdown.
     *
     * @param priceScrollPane the ScrollPaneCustom component to set
     */
    public void setPriceScrollPane(ScrollPaneCustom priceScrollPane) {
        this.priceScrollPane = priceScrollPane;
    }
}
