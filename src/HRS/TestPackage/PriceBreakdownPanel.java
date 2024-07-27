package src.HRS.TestPackage;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class PriceBreakdownPanel extends RoundPanel{
    
    private ArrayList<JPanel> priceBreakdown;
    ArrayList<String> dates; 

    public PriceBreakdownPanel(Reservation reservation){

        super(new Color(40, 68, 117));

        Font customFont13 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 13);
        Font customFont15 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 15);

        int nDates = reservation.getCheckOutDate() - reservation.getCheckInDate();

        this.setPreferredSize(new Dimension(175, (nDates + 1) * 26 + nDates * 5));
        this.setFont(customFont15);
        this.setForeground(Color.white);

        priceBreakdown = new ArrayList<JPanel>();
        dates = new ArrayList<String>(); 

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
            this.add(priceBreakdown.get(i));
        } 
    }
}
