package src.HRS.View;

/**
 * The ConfirmModPanel class represents a confirmation panel for modification actions.
 * It extends the ManageSubPanel class and provides Yes and No buttons for user confirmation.
 */
public class ConfirmModPanel extends ManageSubPanel {
    
    private OptionButton yesButton;
    private OptionButton noButton;
    private String panelName;

    /**
     * Constructs a new ConfirmModPanel with the specified panel name.
     *
     * @param panelName the name of the panel to be confirmed
     */
    public ConfirmModPanel(String panelName) {
        super("Confirm Modification");

        this.panelName = panelName;

        yesButton = new OptionButton("Yes");
        yesButton.setBounds(80, 170, 100, 30);
        yesButton.setColorOver(yesButton.getColorClick());
        
        noButton = new OptionButton("No");
        noButton.setBounds(185, 170, 100, 30);
        noButton.setColorOver(noButton.getColorClick());

        panelName = new String();

        this.getUpdateButton().setVisible(false);
        this.getCancelButton().setVisible(false);
        this.add(yesButton);
        this.add(noButton);
    }

    /**
     * Returns the panel name.
     *
     * @return the panel name
     */
    public String getPanelName() {
        return panelName;
    }

    /**
     * Sets the panel name.
     *
     * @param panelName the panel name to set
     */
    public void setPanelName(String panelName) {
        this.panelName = panelName;
    }

    /**
     * Returns the Yes button.
     *
     * @return the Yes button
     */
    public OptionButton getYesButton() {
        return yesButton;
    }

    /**
     * Sets the Yes button.
     *
     * @param yesButton the Yes button to set
     */
    public void setYesButton(OptionButton yesButton) {
        this.yesButton = yesButton;
    }

    /**
     * Returns the No button.
     *
     * @return the No button
     */
    public OptionButton getNoButton() {
        return noButton;
    }

    /**
     * Sets the No button.
     *
     * @param noButton the No button to set
     */
    public void setNoButton(OptionButton noButton) {
        this.noButton = noButton;
    }
}
