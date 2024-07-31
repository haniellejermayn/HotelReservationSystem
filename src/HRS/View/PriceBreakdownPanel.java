package src.HRS.View;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import src.HRS.Model.Hotel;
import src.HRS.Model.Reservation;

/**
 * The PriceBreakdownPanel class represents a panel that displays the price breakdown
 * for a specific reservation in a hotel. It shows the price for each night of the stay,
 * the total price, and any applicable discounts.
 */
public class PriceBreakdownPanel extends RoundPanel {

    private ArrayList<JPanel> priceBreakdown;
    private ArrayList<String> dates;

    private String totalPrice;
    private String discount;

    /**
     * Constructs a new PriceBreakdownPanel for the specified hotel and reservation index.
     *
     * @param hotel the hotel containing the reservation
     * @param reservationIndex the index of the reservation
     */
    public PriceBreakdownPanel(Hotel hotel, int reservationIndex) {
        super(new Color(40, 68, 117));

        Font customFont13 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 13);
        Font customFont15 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 15);

        Reservation reservation = hotel.fetchReservation(reservationIndex);
        int checkIn = reservation.getCheckInDate();
        int checkOut = reservation.getCheckOutDate();
        int nDates = checkOut - checkIn;

        this.setPreferredSize(new Dimension(175, (nDates + 4) * 26 + (nDates + 3) * 5));
        this.setFont(customFont15);
        this.setForeground(Color.white);

        priceBreakdown = new ArrayList<>();

        dates = new ArrayList<>();
        dates.add("Price Breakdown");
        for (int i = 0; i < nDates; i++) {
            String dateRange = String.format((checkIn + i) + " to " + (checkIn + i + 1) + " -> ");
            String price = String.format("$%.2f", reservation.retrieveCostPerNight(checkIn + i));
            String breakdown = dateRange + price;
            dates.add(breakdown);
        }

        totalPrice = String.format("Total Price: $%.2f", reservation.computeTotalPrice());
        if (reservation.getDiscountCode() == null){
            discount = String.format(" ");
        }
        else {
            discount = String.format("Discount: $%.2f", reservation.getDiscountCode().computeDiscount(reservation));

        }
        dates.add(totalPrice);
        dates.add(discount);

        for (int i = 0; i < nDates + 3; i++) {
            JLabel dateTemp = new JLabel();
            dateTemp.setText(dates.get(i));
            dateTemp.setFont(customFont13);
            dateTemp.setForeground(Color.white);
            dateTemp.setVerticalAlignment(JLabel.CENTER);
            dateTemp.setHorizontalAlignment(JLabel.LEFT);

            JPanel panelTemp = new JPanel();
            panelTemp.setBounds(5, i * 26 + 5, 175, 23);
            panelTemp.setBackground(new Color(40, 68, 117));
            panelTemp.add(dateTemp);

            priceBreakdown.add(panelTemp);
            this.add(priceBreakdown.get(i));
        }
    }

    /**
     * Returns the list of date strings for the price breakdown.
     *
     * @return the list of date strings
     */
    public ArrayList<String> getDates() {
        return dates;
    }

    /**
     * Sets the list of date strings for the price breakdown.
     *
     * @param dates the list of date strings to set
     */
    public void setDates(ArrayList<String> dates) {
        this.dates = dates;
    }

    /**
     * Returns the total price string.
     *
     * @return the total price string
     */
    public String getTotalPrice() {
        return totalPrice;
    }

    /**
     * Sets the total price string.
     *
     * @param totalPrice the total price string to set
     */
    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * Returns the discount string.
     *
     * @return the discount string
     */
    public String getDiscount() {
        return discount;
    }

    /**
     * Sets the discount string.
     *
     * @param discount the discount string to set
     */
    public void setDiscount(String discount) {
        this.discount = discount;
    }
}
