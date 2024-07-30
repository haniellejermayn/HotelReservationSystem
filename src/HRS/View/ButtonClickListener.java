package src.HRS.View;

/**
 * The ButtonClickListener interface defines a callback method to handle button click events.
 * Classes that implement this interface can be used to respond to button clicks within the application.
 */
public interface ButtonClickListener {
    
    /**
     * This method is called when a button is clicked.
     *
     * @param buttonName the name of the button that was clicked
     */
    void buttonClicked(String buttonName);
}
