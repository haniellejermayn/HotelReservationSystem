package src.HRS.View;

import java.awt.*;
import java.util.*;
import src.HRS.Model.Hotel;
import src.HRS.Model.Reservation;

/**
 * The ReservationView class represents a panel that displays a list of reservations
 * for a specific hotel. Each reservation is shown as an OptionButton.
 */
public class ReservationView extends RoundPanel {

    private ArrayList<OptionButton> reservations;
    private Font customFont;

    /**
     * Constructs a new ReservationView for the specified hotel.
     *
     * @param hotel the hotel containing the reservations
     */
    public ReservationView(Hotel hotel) {
        super(new Color(27, 43, 80));

        customFont = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 10);
        reservations = new ArrayList<>();

        ArrayList<Reservation> reservationsTemp = hotel.getReservations();

        if (hotel.countReservations() == 0) {
            RoundLabel noReservations = new RoundLabel(new Color(27, 43, 80));
            noReservations.setText("No Reservations");
            noReservations.setFont(customFont);
            noReservations.setForeground(Color.white);
            noReservations.setBounds(85, 85, 100, 30);
            this.add(noReservations);
        } else {
            for (int i = 0; i < hotel.countReservations(); i++) {
                String reservationName = reservationsTemp.get(i).getGuestName();
                OptionButton reservation = new OptionButton(reservationName);
                reservation.setBounds(8, (i + 1) * 9 + (i * 30), 230, 30);
                reservation.setFont(customFont);

                reservations.add(reservation);
                this.add(reservations.get(i));
            }
        }

        this.setLayout(null);
    }

    /**
     * Returns the list of OptionButtons representing the reservations.
     *
     * @return the list of OptionButtons
     */
    public ArrayList<OptionButton> getReservations() {
        return reservations;
    }

    /**
     * Sets the list of OptionButtons representing the reservations.
     *
     * @param reservations the list of OptionButtons to set
     */
    public void setReservations(ArrayList<OptionButton> reservations) {
        this.reservations = reservations;
    }
}
