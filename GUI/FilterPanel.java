//package GUI;

import java.awt.*;
import java.awt.event.*;

public class FilterPanel extends RoundPanel implements ActionListener{
    
    OptionButton mostBooked;
    OptionButton lowestPrice;
    OptionButton highestPrice;
    OptionButton newest;

    FilterPanel(Color bgColor, ButtonClickListener listener){

        super(bgColor);
        
        mostBooked = new OptionButton("Most Booked");
        mostBooked.setBounds(5,50, 140, 30);
        mostBooked.setColorOver(mostBooked.getColorClick());
        mostBooked.setText("Most Booked");
        mostBooked.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                listener.buttonClicked("Most Booked");
            }
        });
        
        lowestPrice = new OptionButton("Lowest Price");
        lowestPrice.setBounds(5,90, 140, 30);
        lowestPrice.setColorOver(lowestPrice.getColorClick());
        lowestPrice.setText("Lowest Price");
        lowestPrice.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                listener.buttonClicked("Lowest Price");
            }
        });
        
        highestPrice = new OptionButton("Highest Price");
        highestPrice.setBounds(5,130, 140, 30);
        highestPrice.setColorOver(highestPrice.getColorClick());
        highestPrice.setText("Highest Price");
        highestPrice.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                listener.buttonClicked("Highest Price");
            }
        });
        
        newest = new OptionButton("Newest");
        newest.setBounds(5,170, 140, 30);
        newest.setColorOver(newest.getColorClick());
        newest.setText("Newest");
        newest.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                listener.buttonClicked("Newest");
            }
        });
        
        this.setLayout(null);
        this.setBounds(460, 0, 150, 210);
        this.add(mostBooked);
        this.add(lowestPrice);
        this.add(highestPrice);
        this.add(newest);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }

}
