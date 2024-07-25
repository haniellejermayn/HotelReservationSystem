package src.HRS.View;
public interface EnhancedButtonClickListener extends ButtonClickListener {
    void roomButtonClicked(String roomButtonName);
    void reservationButtonClicked(String reservationButtonName);
}