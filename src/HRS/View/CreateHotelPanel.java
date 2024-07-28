package src.HRS.View;

//import src.HRS.Model.*;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.ScrollPaneConstants;

import src.HRS.Model.Hotel;

public class CreateHotelPanel extends RoundPanel implements ActionListener, ButtonClickListener{

    private RoundLabel title;
    private RoundPanel createContainer;
    private RoundPanel roomType;

    private TextFieldCustom hotelNameTextField;
    private TextFieldCustom standardRoomTextField, deluxeRoomTextField, executiveRoomTextField;
    private OptionButton createButton;
    private IconButton cancelButton;

    private Font customFont30;

    public CreateHotelPanel(){

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

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }

    @Override
    public void buttonClicked(String buttonName) {

    }

    public OptionButton getCreateButton(){
        return createButton;
    }

    public void setCreateButton(OptionButton createButton){
        this.createButton = createButton;
    }

    public IconButton getCancelButton(){
        return cancelButton;
    }

    public void setCancelButton(IconButton cancelButton){
        this.cancelButton = cancelButton;
    }

    public TextFieldCustom getNameTextField(){
        return hotelNameTextField;
    }

    public void setNameTextField(TextFieldCustom hotelNameTextField){
        this.hotelNameTextField = hotelNameTextField;
    }

    public TextFieldCustom getStandardRoomTextField(){
        return standardRoomTextField;
    }

    public void setStandardRoomTextField(TextFieldCustom standardRoomTextField){
        this.standardRoomTextField = standardRoomTextField;
    }

    public TextFieldCustom getDeluxeRoomTextField(){
        return deluxeRoomTextField;
    }

    public void setDeluxeRoomTextField(TextFieldCustom deluxeRoomTextField){
        this.deluxeRoomTextField = deluxeRoomTextField;
    }

    public TextFieldCustom getExecutiveRoomTextField(){
        return executiveRoomTextField;
    }

    public void setExecutiveRoomTextField(TextFieldCustom executiveRoomTextField){
        this.executiveRoomTextField = executiveRoomTextField;
    }
}