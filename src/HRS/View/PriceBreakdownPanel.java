package src.HRS.View;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

import src.HRS.Model.Hotel;
import src.HRS.Model.Reservation;

public class PriceBreakdownPanel extends RoundPanel{
    
    private ArrayList<JPanel> priceBreakdown;
    ArrayList<String> dates; 

    String totalPrice;
    String discount;

    public PriceBreakdownPanel(Hotel hotel, int reservationIndex){

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

        priceBreakdown = new ArrayList<JPanel>();

        dates = new ArrayList<String>(); 
        dates.add("Price Breakdown");
        for (int i = 0; i < nDates; i++){
            String dateRange = String.format((checkIn + i) + " to " + (checkIn + i + 1) + " -> ");
            String price = String.format("$%.2f", reservation.retrieveCostPerNight(checkIn + i));
            String breakdown = dateRange + price;
            dates.add(breakdown);
        }
        
        String totalPrice = String.format("Total Price: $%.2f", reservation.computeTotalPrice());
        String discount = String.format("Discount: $%.2f", reservation.getDiscountCode().computeDiscount(reservation));
        dates.add(totalPrice);
        dates.add(discount);

        for (int i = 0; i < nDates + 3; i++){
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

    public ArrayList<String> getDates(){
        return dates;
    }

    public void setDates(ArrayList<String> dates){
        this.dates = dates;
    }
 
    public String getTotalPrice(){
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice){
        this.totalPrice = totalPrice;
    }

    public String getDiscount(){
        return discount;
    }

    public void setDiscount(String discount){
        this.discount = discount;
    }
}
