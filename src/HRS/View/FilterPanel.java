package src.HRS.View;

import java.awt.*;

/**
 * The {@code FilterPanel} class represents a panel containing filtering options for displaying hotels.
 * This panel includes buttons that allow users to filter hotels based on different criteria such as
 * "Most Booked", "Lowest Price", "Highest Price", and "Newest".
 * <p>
 * The {@code FilterPanel} extends {@link RoundPanel} and provides a graphical user interface for filtering
 * hotels based on the selected criteria.
 * </p>
 */
public class FilterPanel extends RoundPanel{
    
    private OptionButton mostBooked;
    private OptionButton lowestPrice;
    private OptionButton highestPrice;
    private OptionButton newest;

    /**
     * Constructs a {@code FilterPanel} with the specified background color.
     * Initializes the filter buttons and sets their properties and positions within the panel.
     *
     * @param bgColor the background color for the panel
     */
    public FilterPanel(Color bgColor){

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

    /**
     * Returns the "Most Booked" filter button.
     *
     * @return the {@code OptionButton} for "Most Booked"
     */
    public OptionButton getMostBookedButton(){
        return mostBooked;
    }

    /**
     * Sets the "Most Booked" filter button.
     *
     * @param mostBooked the {@code OptionButton} for "Most Booked"
     */
    public void setMostBookedButton(OptionButton mostBooked){
        this.mostBooked = mostBooked;
    }

    /**
     * Returns the "Lowest Price" filter button.
     *
     * @return the {@code OptionButton} for "Lowest Price"
     */
    public OptionButton getLowestPriceButton(){
        return lowestPrice;
    }

    /**
     * Sets the "Lowest Price" filter button.
     *
     * @param lowestPrice the {@code OptionButton} for "Lowest Price"
     */
    public void setLowestPriceButton(OptionButton lowestPrice){
        this.lowestPrice = lowestPrice;
    }

    /**
     * Returns the "Highest Price" filter button.
     *
     * @return the {@code OptionButton} for "Highest Price"
     */
    public OptionButton getHighestPriceButton(){
        return highestPrice;
    }

    /**
     * Sets the "Highest Price" filter button.
     *
     * @param highestPrice the {@code OptionButton} for "Highest Price"
     */
    public void setHighestPriceButton(OptionButton highestPrice){
        this.highestPrice = highestPrice;
    }

    /**
     * Returns the "Newest" filter button.
     *
     * @return the {@code OptionButton} for "Newest"
     */
    public OptionButton getNewestButton(){
        return newest;
    }

    /**
     * Sets the "Newest" filter button.
     *
     * @param newest the {@code OptionButton} for "Newest"
     */
    public void setNewestButton(OptionButton newest){
        this.newest = newest;
    }
}
