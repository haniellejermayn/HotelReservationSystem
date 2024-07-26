package src.HRS.View;

import src.HRS.Model.*;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.ScrollPaneConstants;

public class CreateHotelPanel extends RoundPanel implements ActionListener, ButtonClickListener{

    private RoundLabel title;
    private RoundPanel createContainer;
    private RoundPanel roomType;

    private TextFieldCustom hotelNameInput;
    private TextFieldCustom standardRoomInput, deluxeRoomInput, executiveRoomInput;
    private OptionButton createButton;
    private IconButton cancelButton;

    private Font customFont30;

    public CreateHotelPanel(ArrayList<Hotel> hotels){

        super(new Color(51, 88, 150));

        customFont30 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 30);

        // * Title * //
        title = new RoundLabel(new Color(51, 88, 150));
        title.setBounds(8, 10, 200, 40);
        title.setText("Create Hotel");
        title.setFont(customFont30);
        title.setForeground(Color.white);

        // * Guest Name * //
        hotelNameInput = new TextFieldCustom(new Color(40, 68, 117));
        hotelNameInput.setBounds(5, 10, 355, 55);
        hotelNameInput.setFieldName("Hotel Name");

        // * Add Room * //

        standardRoomInput = new TextFieldCustom(new Color(40, 68, 117));
        standardRoomInput.setBounds(5, 10, 355, 55);
        standardRoomInput.setFieldName("No. of Standard Rooms");

        deluxeRoomInput = new TextFieldCustom(new Color(40, 68, 117));
        deluxeRoomInput.setBounds(5, 70, 355, 55);
        deluxeRoomInput.setFieldName("No. of Deluxe Rooms");

        executiveRoomInput = new TextFieldCustom(new Color(40, 68, 117));
        executiveRoomInput.setBounds(5, 130, 355, 55);
        executiveRoomInput.setFieldName("No. of Executive Rooms");
        
        roomType = new RoundPanel(new Color(40, 68, 117));
        roomType.setLayout(null);
        roomType.setBounds(0, 70, 360, 215);
        roomType.add(standardRoomInput);
        roomType.add(deluxeRoomInput);
        roomType.add(executiveRoomInput);


        // * Create Button * //
        createButton = new OptionButton("Create");
        createButton.setBounds(260, 315, 100, 30);
        createButton.setColorOver(createButton.getColorClick());
        /*createButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){

                String name = hotelName.getTextField().getText().trim();
                int standard = Integer.valueOf(nStandardRooms.getTextField().getText().trim());
                int deluxe = Integer.valueOf(nDeluxeRooms.getTextField().getText().trim());
                int executive = Integer.valueOf(nExecutiveRooms.getTextField().getText().trim());

                // TODO: check if hotelName is unique
                if (!name.isEmpty() && standard + deluxe + executive > 0 && standard + deluxe + executive <= 50){
                    setNameInput(name);
                    setStandardRoomInput(standard);
                    setDeluxeRoomInput(deluxe);
                    setExecutiveRoomInput(executive);
                    
                    // TODO: set all necessary info into Hotel
                    
                    listener.buttonClicked("Create");
                }
            }
        });*/

        // * Cancel * //
        ImageIcon cancelIcon = new ImageIcon("Icons/CancelIcon.png");
        cancelIcon = Customization.resizeIcon(cancelIcon, 20, 20); 

        cancelButton = new IconButton(cancelIcon, "Create Cancel");
        cancelButton.setBounds(335, 8, 40, 40);
        cancelButton.setColorClick(createButton.getColorOver());
        /*cancelButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){
                setNameInput(""); 
                setStandardRoomInput(0);
                setDeluxeRoomInput(0);
                setExecutiveRoomInput(0);

                listener.buttonClicked("Create Cancel");
            }
        });*/

        // * Container * //
        createContainer = new RoundPanel(new Color(40, 68, 117));
        createContainer.setLayout(null);
        createContainer.setPreferredSize(new Dimension(375, 360));
        createContainer.add(hotelNameInput);
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

    public TextFieldCustom getNameInput(){
        return hotelNameInput;
    }

    public void setNameInput(TextFieldCustom hotelNameInput){
        this.hotelNameInput = hotelNameInput;
    }

    public TextFieldCustom getStandardRoomInput(){
        return standardRoomInput;
    }

    public void setStandardRoomInput(TextFieldCustom standardRoomInput){
        this.standardRoomInput = standardRoomInput;
    }

    public TextFieldCustom getDeluxeRoomInput(){
        return deluxeRoomInput;
    }

    public void setDeluxeRoomInput(TextFieldCustom deluxeRoomInput){
        this.deluxeRoomInput = deluxeRoomInput;
    }

    public TextFieldCustom getExecutiveRoomInput(){
        return executiveRoomInput;
    }

    public void setExecutiveRoomInput(TextFieldCustom executiveRoomInput){
        this.executiveRoomInput = executiveRoomInput;
    }
}