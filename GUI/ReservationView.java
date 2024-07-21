import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class ReservationView extends RoundPanel{
    
    private ArrayList<OptionButton> reservations;

    private Font customFont;

    ReservationView(ButtonClickListener listener, int nReservations){
        
        super(new Color(27, 43, 80));

        customFont = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 10);

        reservations = new ArrayList<OptionButton>();

        // TODO: remove
        ArrayList<String> reservationsTemp = new ArrayList<String>();
        reservationsTemp.add("Kelsey");
        reservationsTemp.add("Hep"); 
        reservationsTemp.add("Hanielle");
        reservationsTemp.add("Francine");
        reservationsTemp.add("Justine");
        reservationsTemp.add("Liane");
        
        for (int i = 0; i < nReservations; i++){
            
            String reservationName = reservationsTemp.get(i); // TODO: replace with hotel reservations
            OptionButton reservation = new OptionButton(reservationName);
            
            reservation.setBounds(8, (i + 1) * 9 + (i * 30), 230, 30);

            reservation.setFont(customFont);
            reservation.addActionListener(new ActionListener(){

                @Override
                public void actionPerformed(ActionEvent e){
                    listener.buttonClicked(reservationName);
                }
            });

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
