package src.HRS.View;

import java.awt.*;
import javax.swing.*;

/**
 * The ManageSubPanel class represents a sub-panel used within the ManagePanel.
 * It includes a title, an update button, and a cancel button.
 */
public class ManageSubPanel extends RoundPanel {
    
    private OptionButton updateButton;
    private IconButton cancelButton;
    private String title;

    /**
     * Constructs a new ManageSubPanel with the specified title.
     *
     * @param title the title of the sub-panel
     */
    public ManageSubPanel(String title) {
        super(new Color(40, 68, 117));

        this.title = title;

        Font customFont28 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 28);

        RoundPanel headerPanel = new RoundPanel(new Color(27, 43, 80));
        headerPanel.setBounds(0, 0, 365, 70);

        JPanel headerPanel2 = new JPanel();
        headerPanel2.setBackground(new Color(40, 68, 117));
        headerPanel2.setBounds(0, 60, 400, 15);

        RoundLabel panelTitle = new RoundLabel(new Color(27, 43, 80));
        panelTitle.setBounds(10, 10, 350, 40);
        panelTitle.setText(title); 
        panelTitle.setFont(customFont28);
        panelTitle.setForeground(Color.white);

        updateButton = new OptionButton("Update");
        updateButton.setBounds(255, 310, 100, 30);
        updateButton.setColorOver(updateButton.getColorClick());

        // * Cancel * //
        ImageIcon cancelIcon = new ImageIcon("Icons/CancelIcon.png");
        cancelIcon = Customization.resizeIcon(cancelIcon, 20, 20); 

        cancelButton = new IconButton(cancelIcon, "Manage Cancel");
        cancelButton.setBounds(318, 9, 40, 40);
        cancelButton.setColor(new Color(40, 68, 117));
        cancelButton.setColorOver(cancelButton.getColorClick());

        this.setLayout(null);
        this.setPreferredSize(new Dimension(365, 350));
        this.setBounds(10, 60, 365, 350);
        this.add(cancelButton);
        this.add(panelTitle);
        this.add(headerPanel2);
        this.add(headerPanel);
        this.add(updateButton);
    }

    /**
     * Returns the title of the sub-panel.
     *
     * @return the title of the sub-panel
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the sub-panel.
     *
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Returns the update button.
     *
     * @return the update button
     */
    public OptionButton getUpdateButton() {
        return updateButton;
    }

    /**
     * Sets the update button.
     *
     * @param updateButton the update button to set
     */
    public void setUpdateButton(OptionButton updateButton) {
        this.updateButton = updateButton;
    }

    /**
     * Returns the cancel button.
     *
     * @return the cancel button
     */
    public IconButton getCancelButton() {
        return cancelButton;
    }

    /**
     * Sets the cancel button.
     *
     * @param cancelButton the cancel button to set
     */
    public void setCancelButton(IconButton cancelButton) {
        this.cancelButton = cancelButton;
    }
}
