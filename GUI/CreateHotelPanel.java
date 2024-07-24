//package GUI;

//import hrs.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.ScrollPaneConstants;

public class CreateHotelPanel extends RoundPanel implements ActionListener, ButtonClickListener{

    private RoundLabel title;
    private BookCalendar calendar;
    private RoundPanel createContainer;
    private RoundLabel roomTypeTitle;
    private RoundPanel roomType;
    private RoundLabel checkInNOut;

    private TextFieldCustom hotelName;
    private TextFieldCustom nStandardRooms, nDeluxeRooms, nExecutiveRooms;
    private OptionButton createButton;
    private IconButton cancelButton;

    private String hotelNameInput;
    private int standardRoomInput, deluxeRoomInput, executiveRoomInput;

    private TextFieldCustom discount;
    private OptionButton hasDiscount;


    //private ButtonClickListener listener;
    private ArrayList<OptionButton> days;
    private ArrayList<String> clickedButtons;

    private Font customFont13;
    private Font customFont30;

                // TODO: change to Hotel hotel
    public CreateHotelPanel(ArrayList<String> hotel, ButtonClickListener listener){

        super(new Color(51, 88, 150));

        customFont13 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 13);
        customFont30 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 30);

        // * Title * //
        title = new RoundLabel(new Color(51, 88, 150));
        title.setBounds(8, 10, 200, 40);
        title.setText("Create Hotel");
        title.setFont(customFont30);
        title.setForeground(Color.white);

        // * Guest Name * //
        hotelName = new TextFieldCustom(new Color(40, 68, 117));
        hotelName.setBounds(5, 10, 355, 55);
        hotelName.setFieldName("Hotel Name");

        // * Add Room * //

        nStandardRooms = new TextFieldCustom(new Color(40, 68, 117));
        nStandardRooms.setBounds(5, 10, 355, 55);
        nStandardRooms.setFieldName("No. of Standard Rooms");
        //nStandardRooms.getTextContainer().setBounds(5, 25, 340, 27);

        nDeluxeRooms = new TextFieldCustom(new Color(40, 68, 117));
        nDeluxeRooms.setBounds(5, 70, 355, 55);
        nDeluxeRooms.setFieldName("No. of Deluxe Rooms");
        //nDeluxeRooms.getTextContainer().setBounds(5, 25, 340, 27);

        nExecutiveRooms = new TextFieldCustom(new Color(40, 68, 117));
        nExecutiveRooms.setBounds(5, 130, 355, 55);
        nExecutiveRooms.setFieldName("No. of Executive Rooms");
        //nExecutiveRooms.getTextContainer().setBounds(5, 25, 340, 27);
        
        roomType = new RoundPanel(new Color(40, 68, 117));
        roomType.setLayout(null);
        roomType.setBounds(0, 70, 360, 215);
        roomType.add(nStandardRooms);
        roomType.add(nDeluxeRooms);
        roomType.add(nExecutiveRooms);


        // * Create Button * //
        createButton = new OptionButton("Create");
        createButton.setBounds(260, 315, 100, 30);
        createButton.setColorOver(createButton.getColorClick());
        createButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){
                setNameInput(hotelName.getTextField().getText().trim()); // Get text and trim any leading/trailing whitespace
                setStandardRoomInput(Integer.valueOf(nStandardRooms.getTextField().getText().trim()));
                setDeluxeRoomInput(Integer.valueOf(nDeluxeRooms.getTextField().getText().trim()));
                setExecutiveRoomInput(Integer.valueOf(nExecutiveRooms.getTextField().getText().trim()));
                
                // TODO: check if all fields are filled
                // TODO: set all necessary info into Hotel
                
                listener.buttonClicked("Create");
            }
        });

        // * Cancel * //
        ImageIcon cancelIcon = new ImageIcon("Icons/CancelIcon.png");
        cancelIcon = Customization.resizeIcon(cancelIcon, 20, 20); 

        cancelButton = new IconButton(cancelIcon, "Create Cancel");
        cancelButton.setBounds(335, 8, 40, 40);
        cancelButton.setColorClick(createButton.getColorOver());
        cancelButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){
                setNameInput(""); 
                setStandardRoomInput(0);
                setDeluxeRoomInput(0);
                setExecutiveRoomInput(0);

                listener.buttonClicked("Create Cancel");
            }
        });

        // * Container * //
        createContainer = new RoundPanel(new Color(40, 68, 117));
        createContainer.setLayout(null);
        createContainer.setPreferredSize(new Dimension(375, 360));
        createContainer.add(hotelName);
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

    public String getNameInput(){
        return hotelNameInput;
    }

    public void setNameInput(String hotelNameInput){
        this.hotelNameInput = hotelNameInput;
    }

    public int getStandardRoomInput(){
        return standardRoomInput;
    }

    public void setStandardRoomInput(int standardRoomInput){
        this.standardRoomInput = standardRoomInput;
    }

    public int getDeluxeRoomInput(){
        return deluxeRoomInput;
    }

    public void setDeluxeRoomInput(int deluxeRoomInput){
        this.deluxeRoomInput = deluxeRoomInput;
    }

    public int getExecutiveRoomInput(){
        return executiveRoomInput;
    }

    public void setExecutiveRoomInput(int executiveRoomInput){
        this.executiveRoomInput = executiveRoomInput;
    }
}
