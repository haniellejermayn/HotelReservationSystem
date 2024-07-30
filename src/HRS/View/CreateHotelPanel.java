package src.HRS.View;

import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.ScrollPaneConstants;

/**
 * The CreateHotelPanel class represents a panel for creating a new hotel.
 * It extends RoundPanel and provides input fields for hotel name and room types, along with Create and Cancel buttons.
 */
public class CreateHotelPanel extends RoundPanel {

    private RoundLabel title;
    private RoundPanel createContainer;
    private RoundPanel roomType;

    private TextFieldCustom hotelNameTextField;
    private TextFieldCustom standardRoomTextField, deluxeRoomTextField, executiveRoomTextField;
    private OptionButton createButton;
    private IconButton cancelButton;

    private Font customFont30;

    /**
     * Constructs a new CreateHotelPanel.
     */
    public CreateHotelPanel() {
        super(new Color(51, 88, 150));

        customFont30 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 30);

        // * Title * //
        title = new RoundLabel(new Color(51, 88, 150));
        title.setBounds(8, 10, 200, 40);
        title.setText("Create Hotel");
        title.setFont(customFont30);
        title.setForeground(Color.white);

        // * Guest Name * //
        hotelNameTextField = new TextFieldCustom(new Color(40, 68, 117));
        hotelNameTextField.setBounds(5, 10, 355, 55);
        hotelNameTextField.setFieldName("Hotel Name");

        // * Add Room * //
        standardRoomTextField = new TextFieldCustom(new Color(40, 68, 117));
        standardRoomTextField.setBounds(5, 10, 355, 55);
        standardRoomTextField.setFieldName("No. of Standard Rooms");

        deluxeRoomTextField = new TextFieldCustom(new Color(40, 68, 117));
        deluxeRoomTextField.setBounds(5, 70, 355, 55);
        deluxeRoomTextField.setFieldName("No. of Deluxe Rooms");

        executiveRoomTextField = new TextFieldCustom(new Color(40, 68, 117));
        executiveRoomTextField.setBounds(5, 130, 355, 55);
        executiveRoomTextField.setFieldName("No. of Executive Rooms");
        
        roomType = new RoundPanel(new Color(40, 68, 117));
        roomType.setLayout(null);
        roomType.setBounds(0, 70, 360, 215);
        roomType.add(standardRoomTextField);
        roomType.add(deluxeRoomTextField);
        roomType.add(executiveRoomTextField);

        // * Create Button * //
        createButton = new OptionButton("Create");
        createButton.setBounds(260, 315, 100, 30);
        createButton.setColorOver(createButton.getColorClick());

        // * Cancel * //
        ImageIcon cancelIcon = new ImageIcon("Icons/CancelIcon.png");
        cancelIcon = Customization.resizeIcon(cancelIcon, 20, 20); 

        cancelButton = new IconButton(cancelIcon, "Create Cancel");
        cancelButton.setBounds(335, 8, 40, 40);
        cancelButton.setColorClick(createButton.getColorOver());

        // * Container * //
        createContainer = new RoundPanel(new Color(40, 68, 117));
        createContainer.setLayout(null);
        createContainer.setPreferredSize(new Dimension(375, 360));
        createContainer.add(hotelNameTextField);
        createContainer.add(roomType);
        createContainer.add(createButton);

        ScrollPaneCustom scrollPane = new ScrollPaneCustom(createContainer, new Color(27, 43, 80), new Color(27, 43, 80), new Color(40, 68, 117));
        scrollPane.setBounds(5, 55, 375, 360);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        this.setLayout(null);
        this.add(title);
        this.add(cancelButton);
        this.add(scrollPane);
    }

    /**
     * Returns the create button.
     *
     * @return the create button
     */
    public OptionButton getCreateButton() {
        return createButton;
    }

    /**
     * Sets the create button.
     *
     * @param createButton the create button to set
     */
    public void setCreateButton(OptionButton createButton) {
        this.createButton = createButton;
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

    /**
     * Returns the hotel name text field.
     *
     * @return the hotel name text field
     */
    public TextFieldCustom getNameTextField() {
        return hotelNameTextField;
    }

    /**
     * Sets the hotel name text field.
     *
     * @param hotelNameTextField the hotel name text field to set
     */
    public void setNameTextField(TextFieldCustom hotelNameTextField) {
        this.hotelNameTextField = hotelNameTextField;
    }

    /**
     * Returns the standard room text field.
     *
     * @return the standard room text field
     */
    public TextFieldCustom getStandardRoomTextField() {
        return standardRoomTextField;
    }

    /**
     * Sets the standard room text field.
     *
     * @param standardRoomTextField the standard room text field to set
     */
    public void setStandardRoomTextField(TextFieldCustom standardRoomTextField) {
        this.standardRoomTextField = standardRoomTextField;
    }

    /**
     * Returns the deluxe room text field.
     *
     * @return the deluxe room text field
     */
    public TextFieldCustom getDeluxeRoomTextField() {
        return deluxeRoomTextField;
    }

    /**
     * Sets the deluxe room text field.
     *
     * @param deluxeRoomTextField the deluxe room text field to set
     */
    public void setDeluxeRoomTextField(TextFieldCustom deluxeRoomTextField) {
        this.deluxeRoomTextField = deluxeRoomTextField;
    }

    /**
     * Returns the executive room text field.
     *
     * @return the executive room text field
     */
    public TextFieldCustom getExecutiveRoomTextField() {
        return executiveRoomTextField;
    }

    /**
     * Sets the executive room text field.
     *
     * @param executiveRoomTextField the executive room text field to set
     */
    public void setExecutiveRoomTextField(TextFieldCustom executiveRoomTextField) {
        this.executiveRoomTextField = executiveRoomTextField;
    }
}
