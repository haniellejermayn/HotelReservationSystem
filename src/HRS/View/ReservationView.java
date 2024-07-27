package src.HRS.View;

//import src.HRS.Model.*;

import java.awt.*;
//import java.awt.event.*;
import java.util.*;

import src.HRS.Model.Hotel;
import src.HRS.Model.Reservation;

public class ReservationView extends RoundPanel{
    
    private ArrayList<OptionButton> reservations;

    private Font customFont;

    public ReservationView(Hotel hotel){
        
        super(new Color(27, 43, 80));

        customFont = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 10);

        reservations = new ArrayList<OptionButton>();
        
        ArrayList<Reservation> reservationsTemp = hotel.getReservations();

        if (hotel.countReservations() == 0){
            RoundLabel noReservations = new RoundLabel(new Color(27, 43, 80));
            noReservations.setText("No Reservations");
            noReservations.setFont(customFont);
            noReservations.setForeground(Color.white);
            noReservations.setBounds(85, 85, 100, 30);
            this.add(noReservations);
        }
        
        for (int i = 0; i < hotel.countReservations(); i++){
            
            String reservationName = reservationsTemp.get(i).getGuestName();
            OptionButton reservation = new OptionButton(reservationName);
            
            reservation.setBounds(8, (i + 1) * 9 + (i * 30), 230, 30);

            reservation.setFont(customFont);
            /*reservation.addActionListener(new ActionListener(){

                @Override
                public void actionPerformed(ActionEvent e){
                    listener.reservationButtonClicked(reservationName);
                }
            });*/

            reservations.add(reservation);
            this.add(reservations.get(i));
        }

        this.setLayout(null);
    }

    public ArrayList<OptionButton> getReservations(){
        return reservations;
    }

    public void setReservations(ArrayList<OptionButton> reservations){
        this.reservations = reservations;
    }
}
