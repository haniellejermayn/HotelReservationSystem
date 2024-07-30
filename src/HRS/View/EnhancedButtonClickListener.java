package src.HRS.View;

/**
 * The {@code EnhancedButtonClickListener} interface extends {@link ButtonClickListener} to provide additional
 * event handling capabilities for button clicks in the application. It includes methods specifically for handling
 * clicks on room and reservation buttons.
 * <p>
 * Classes implementing this interface should define the behavior for handling clicks on room and reservation buttons,
 * as well as any other button click events defined in the {@link ButtonClickListener} interface.
 * </p>
 */
public interface EnhancedButtonClickListener extends ButtonClickListener {
    /**
     * Called when a room button is clicked.
     *
     * @param roomButtonName the name or identifier of the room button that was clicked
     */
    void roomButtonClicked(String roomButtonName);
    
    /**
     * Called when a reservation button is clicked.
     *
     * @param reservationButtonName the name or identifier of the reservation button that was clicked
     */
    void reservationButtonClicked(String reservationButtonName);
}