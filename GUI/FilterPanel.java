//package GUI;

import java.awt.*;

public class FilterPanel extends RoundPanel{
    
    OptionButton mostBooked;
    OptionButton lowestPrice;
    OptionButton highestPrice;
    OptionButton newest;

    FilterPanel(Color bgColor){

        super(bgColor);
        
        mostBooked = new OptionButton("Most Booked");
        mostBooked.setBounds(5,50, 140, 30);
        mostBooked.setColorOver(mostBooked.getColorClick());
        mostBooked.setText("Most Booked");
        
        lowestPrice = new OptionButton("Lowest Price");
        lowestPrice.setBounds(5,90, 140, 30);
        lowestPrice.setColorOver(lowestPrice.getColorClick());
        lowestPrice.setText("Lowest Price");
        
        highestPrice = new OptionButton("Highest Price");
        highestPrice.setBounds(5,130, 140, 30);
        highestPrice.setColorOver(highestPrice.getColorClick());
        highestPrice.setText("Highest Price");
        
        newest = new OptionButton("Newest");
        newest.setBounds(5,170, 140, 30);
        newest.setColorOver(newest.getColorClick());
        newest.setText("Newest");
        
        this.setLayout(null);
        this.setBounds(460, 0, 150, 210);
        this.add(mostBooked);
        this.add(lowestPrice);
        this.add(highestPrice);
        this.add(newest);
    }

}
