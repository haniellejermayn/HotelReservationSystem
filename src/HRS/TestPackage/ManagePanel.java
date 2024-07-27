package src.HRS.TestPackage;

//import src.HRS.Model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ManagePanel extends LayeredRoundPanel implements ActionListener, EnhancedButtonClickListener{

    private IconButton changeName;
    private IconButton addRoom;
    private IconButton updateBasePrice;
    private IconButton datePriceModifier;
    private IconButton removeRoom;
    private IconButton removeRes;
    private IconButton removeHotel;

    private ManageSubPanel changeNamePanel;
    private ManageSubPanel addRoomPanel;
    private ManageSubPanel updateBasePricePanel;
    private ManageSubPanel datePriceModifierPanel;
    private ManageSubPanel removeRoomPanel;
    private ManageSubPanel removeResPanel;
    private ManageSubPanel removeHotelPanel;
    private ConfirmModPanel confirmModPanel;

    private TextFieldCustom newHotelNameInput;
    private TextFieldCustom standardRoomInput, deluxeRoomInput, executiveRoomInput;
    private TextFieldCustom newBasePriceInput;
    private TextFieldCustom percentageInput;

    /*private String hotelNameInput;
    private int standardRoomInput, deluxeRoomInput, executiveRoomInput;
    private float basePriceInput;
    private int dateModInput;
    private int percentModInput;
    private String removeRoomInput;
    private String removeResInput;*/

    private ArrayList<OptionButton> days;

    private RoomView roomView;
    private ReservationView resView;
    private CalendarView calendarView;

    private RoundPanel manageContainer;

    private Hotel hotel;


    public ManagePanel(Hotel hotel, Color color) {
        super(color);
        this.hotel = hotel;
        
        this.setLayout(null);
        this.setBounds(152, 10, 385, 420);

        Font customFont20 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 20);

        // TODO: consider empty and invalid inputs


        // * Change Name * //
        ImageIcon changeNameIcon = new ImageIcon("Icons/ChangeNameIcon.png"); 
        changeNameIcon = Customization.resizeIcon(changeNameIcon, 20, 20);

        changeName = new IconButton(changeNameIcon, "Change Name");
        changeName.setBounds(23,10, 40, 40);
        changeName.setColorClick(changeName.getColorOver());
        changeName.addActionListener(this);

        RoundLabel currentName = new RoundLabel(new Color(40, 68, 117));
        currentName.setBounds(122, 80, 200, 40); // TODO: change to border layout
        currentName.setText(hotel.getHotelName());
        currentName.setFont(customFont20);
        currentName.setForeground(Color.white);

        newHotelNameInput = new TextFieldCustom(new Color(40, 68, 117));
        newHotelNameInput.setBounds(5, 130, 350, 55);
        newHotelNameInput.setFieldName("New Hotel Name");
        newHotelNameInput.getTextContainer().setBounds(5, 25, 340, 27);

        changeNamePanel = new ManageSubPanel("Change Name");
        changeNamePanel.add(currentName);
        changeNamePanel.add(newHotelNameInput);
        /*changeNamePanel.getUpdateButton().addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){

                String hotelName = newHotelNameInput.getTextField().getText().trim();

                // TODO: check if name is valid

                if (!hotelName.isEmpty()){
                    setHotelNameInput(hotelName); 
    
                    confirmMod("Change Name");
                }
            }
        });*/
        /*changeNamePanel.getCancelButton().addActionListener(new ActionListener(){

            /*@Override
            public void actionPerformed(ActionEvent e){
                setHotelNameInput(""); 
                setStandardRoomInput(0);
                setDeluxeRoomInput(0);
                setExecutiveRoomInput(0);
                setBasePriceInput(0.00f);
                setDateModInput(0);
                setPriceModInput(0);
                setRemoveRoomInput("");
                setRemoveResInput("");

                listener.buttonClicked("Manage Cancel");
            }
        });*/



        // * Add Room * //
        ImageIcon addRoomIcon = new ImageIcon("Icons/AddIcon.png");
        addRoomIcon = Customization.resizeIcon(addRoomIcon, 20, 20);

        addRoom = new IconButton(addRoomIcon, "Add Room");
        addRoom.setBounds(73,10, 40, 40);
        addRoom.setColorClick(addRoom.getColorOver());
        addRoom.addActionListener(this);

        standardRoomInput = new TextFieldCustom(new Color(40, 68, 117));
        standardRoomInput.setBounds(5, 90, 350, 55);
        standardRoomInput.setFieldName("No. of Standard Rooms");
        standardRoomInput.getTextContainer().setBounds(5, 25, 340, 27);

        deluxeRoomInput = new TextFieldCustom(new Color(40, 68, 117));
        deluxeRoomInput.setBounds(5, 150, 350, 55);
        deluxeRoomInput.setFieldName("No. of Deluxe Rooms");
        deluxeRoomInput.getTextContainer().setBounds(5, 25, 340, 27);

        executiveRoomInput = new TextFieldCustom(new Color(40, 68, 117));
        executiveRoomInput.setBounds(5, 210, 350, 55);
        executiveRoomInput.setFieldName("No. of Executive Rooms");
        executiveRoomInput.getTextContainer().setBounds(5, 25, 340, 27);

        addRoomPanel = new ManageSubPanel("Add Room");
        addRoomPanel.add(standardRoomInput);
        addRoomPanel.add(deluxeRoomInput);
        addRoomPanel.add(executiveRoomInput);
        /*addRoomPanel.getUpdateButton().addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){
                /*int standard = Integer.valueOf(standardRoomInput.getTextField().getText().trim());
                int deluxe = Integer.valueOf(deluxeRoomInput.getTextField().getText().trim());
                int executive = Integer.valueOf(executiveRoomInput.getTextField().getText().trim());

                if (standard + deluxe + executive > 0 && standard + deluxe + executive <= 50){
                    setStandardRoomInput(standard);
                    setDeluxeRoomInput(deluxe);
                    setExecutiveRoomInput(executive);
        
                    confirmMod("Add Room");
                }
            }
        });
        addRoomPanel.getCancelButton().addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){
                setHotelNameInput(""); 
                setStandardRoomInput(0);
                setDeluxeRoomInput(0);
                setExecutiveRoomInput(0);
                setBasePriceInput(0.00f);
                setDateModInput(0);
                setPriceModInput(0);
                setRemoveRoomInput("");
                setRemoveResInput("");

                listener.buttonClicked("Manage Cancel");
            }
        });*/



        // * Update Price * //
        ImageIcon updatePriceIcon = new ImageIcon("Icons/UpdatePriceIcon.png"); 
        updatePriceIcon = Customization.resizeIcon(updatePriceIcon, 20, 20);

        updateBasePrice = new IconButton(updatePriceIcon, "Update Base Price");
        updateBasePrice.setBounds(123,10, 40, 40);
        updateBasePrice.setColorClick(updateBasePrice.getColorOver());
        updateBasePrice.addActionListener(this);

        RoundLabel currentBasePrice = new RoundLabel(new Color(40, 68, 117));
        currentBasePrice.setBounds(142, 80, 200, 40); // TODO: set to border layout
        currentBasePrice.setText("1299.00"); // TODO: set to curent base price
        currentBasePrice.setFont(customFont20);
        currentBasePrice.setForeground(Color.white);

        newBasePriceInput = new TextFieldCustom(new Color(40, 68, 117));
        newBasePriceInput.setBounds(5, 130, 350, 55);
        newBasePriceInput.setFieldName("New Base Price");
        newBasePriceInput.getTextContainer().setBounds(5, 25, 340, 27);

        updateBasePricePanel = new ManageSubPanel("Update Base Price");
        updateBasePricePanel.add(currentBasePrice);
        updateBasePricePanel.add(newBasePriceInput);
        /*updateBasePricePanel.getUpdateButton().addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){

                /*Float basePrice = Float.valueOf(newBasePriceInput.getTextField().getText().trim());

                // TODO: check if there are no reservations

                if (basePrice >= 100.00){
                    setBasePriceInput(basePrice);
        
                    confirmMod("Update Base Price");
                }
            }
        });
        updateBasePricePanel.getCancelButton().addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){
                setHotelNameInput(""); 
                setStandardRoomInput(0);
                setDeluxeRoomInput(0);
                setExecutiveRoomInput(0);
                setBasePriceInput(0.00f);
                setDateModInput(0);
                setPriceModInput(0);
                setRemoveRoomInput("");
                setRemoveResInput("");

                listener.buttonClicked("Manage Cancel");
            }
        });*/



        // * Date Price Modifier * //
        ImageIcon datePriceModifierIcon = new ImageIcon("Icons/DatePriceModifierIcon.png"); 
        datePriceModifierIcon = Customization.resizeIcon(datePriceModifierIcon, 20, 20);

        datePriceModifier = new IconButton(datePriceModifierIcon, "Date Price Modifier");
        datePriceModifier.setBounds(173,10, 40, 40);
        datePriceModifier.setColorClick(datePriceModifier.getColorOver());
        datePriceModifier.addActionListener(this);

        calendarView = new CalendarView();
        calendarView.setBounds(2, 2, 335, 203);
        days = calendarView.getDays();
        days.get(30).setEnabled(false);
        days.get(30).setColor(new Color(27, 43, 80));
        days.get(30).setColorOver(new Color(27, 43, 80));
        days.get(30).setColorClick(new Color(27, 43, 80));

        percentageInput = new TextFieldCustom(new Color(40, 68, 117));
        percentageInput.setBounds(0, 220, 340, 55);
        percentageInput.setFieldName("New Date Price");
        percentageInput.getTextContainer().setBounds(5, 25, 330, 27);

        RoundPanel datePriceContainer = new RoundPanel(new Color(40, 68, 117));
        datePriceContainer.setLayout(null);
        datePriceContainer.setPreferredSize(new Dimension(350, 280));
        datePriceContainer.add(calendarView);
        datePriceContainer.add(percentageInput);

        ScrollPaneCustom scrollPaneDatePriceView = new ScrollPaneCustom(datePriceContainer, new Color(27, 43, 80), new Color(27, 43, 80), new Color(40, 68, 117));
        scrollPaneDatePriceView.setBounds(2, 5, 350, 230);
        scrollPaneDatePriceView.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPaneDatePriceView.setPreferredSize(new Dimension(7, 7));

        RoundPanel datePriceScrollView = new RoundPanel(new Color(40, 68, 117));
        datePriceScrollView.setLayout(null);
        datePriceScrollView.setBounds(6, 70, 354, 240);
        datePriceScrollView.add(scrollPaneDatePriceView);

        datePriceModifierPanel = new ManageSubPanel("Date Price Modifier");
        datePriceModifierPanel.add(datePriceScrollView);
        /*datePriceModifierPanel.getUpdateButton().addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){

                /*int percentage = Integer.valueOf(percentageInput.getTextField().getText().trim());

                // ?: is there a restriction for percentage input

                setPriceModInput(percentage);

                confirmMod("Date Price Modifier");
            }
        });
        datePriceModifierPanel.getCancelButton().addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){
                setHotelNameInput(""); 
                setStandardRoomInput(0);
                setDeluxeRoomInput(0);
                setExecutiveRoomInput(0);
                setBasePriceInput(0.00f);
                setDateModInput(0);
                setPriceModInput(0);
                setRemoveRoomInput("");
                setRemoveResInput("");

                listener.buttonClicked("Manage Cancel");
            }
        });*/



        // * Remove Room * //
        ImageIcon removeRoomIcon = new ImageIcon("Icons/RoomIcon.png"); 
        removeRoomIcon = Customization.resizeIcon(removeRoomIcon, 20, 20);

        removeRoom = new IconButton(removeRoomIcon, "Remove Room");
        removeRoom.setBounds(223,10, 40, 40);
        removeRoom.setColorClick(removeRoom.getColorOver());
        removeRoom.addActionListener(this);

        int nRooms = 30; // TODO: remove
        int roomViewHeight;

        if (nRooms > 25){
            roomViewHeight = (((nRooms - 1) / 5 - 3) * 9 + (((nRooms - 1) / 5 - 4) * 30)) + 198 - 15;
        }
        else {
            roomViewHeight = 198;
        }

        roomView = new RoomView(hotel); // TODO: set to no. of rooms

        roomView.setBounds(0, 0, 250, roomViewHeight);
        roomView.setPreferredSize(new Dimension(250, roomViewHeight));

        ScrollPaneCustom scrollPaneRoomView = new ScrollPaneCustom(roomView, new Color(40, 68, 117), new Color(40, 68, 117), new Color(27, 43, 80));
        scrollPaneRoomView.setBounds(2, 2, 250, 196);
        scrollPaneRoomView.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPaneRoomView.setPreferredSize(new Dimension(7, 7));

        RoundPanel roomViewContainer = new RoundPanel(new Color(27, 43, 80));
        roomViewContainer.setLayout(null);
        roomViewContainer.setBounds(58, 85, 255, 203);
        roomViewContainer.add(scrollPaneRoomView);

        removeRoomPanel = new ManageSubPanel("Remove Room");
        removeRoomPanel.add(roomViewContainer);
        removeRoomPanel.getUpdateButton().setText("Remove");
        /*removeRoomPanel.getUpdateButton().addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){

                // TODO: check if the selected room has no active reservation

                confirmMod("Remove Room");
            }
        });
        removeRoomPanel.getCancelButton().addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){
                setHotelNameInput(""); 
                setStandardRoomInput(0);
                setDeluxeRoomInput(0);
                setExecutiveRoomInput(0);
                setBasePriceInput(0.00f);
                setDateModInput(0);
                setPriceModInput(0);
                setRemoveRoomInput("");
                setRemoveResInput("");

                listener.buttonClicked("Manage Cancel");
            }
        });*/



        // * Remove Reservation * //
        ImageIcon removeResIcon = new ImageIcon("Icons/ReservationsIcon.png"); 
        removeResIcon = Customization.resizeIcon(removeResIcon, 20, 20);

        removeRes = new IconButton(removeResIcon, "Remove Reservation");
        removeRes.setBounds(273,10, 40, 40);
        removeRes.setColorClick(removeRes.getColorOver());
        removeRes.addActionListener(this);

        int nReservations = 6; // TODO: remove
        int resViewHeight = nReservations * 39 + 5;

        resView = new ReservationView(hotel); // TODO: change to no. of reservations
        resView.setBounds(0, 0, 250, resViewHeight);
        resView.setPreferredSize(new Dimension(250, resViewHeight));

        ScrollPaneCustom scrollPaneResView = new ScrollPaneCustom(resView, new Color(40, 68, 117), new Color(40, 68, 117), new Color(27, 43, 80));
        scrollPaneResView.setBounds(2, 2, 250, 196);
        scrollPaneResView.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPaneResView.setPreferredSize(new Dimension(7, 7));

        RoundPanel resViewContainer = new RoundPanel(new Color(27, 43, 80));
        resViewContainer.setLayout(null);
        resViewContainer.setBounds(58, 85, 255, 203);
        resViewContainer.add(scrollPaneResView);

        removeResPanel = new ManageSubPanel("Remove Reservation");
        removeResPanel.add(resViewContainer);
        removeResPanel.getUpdateButton().setText("Remove");
        /*removeResPanel.getUpdateButton().addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){

                // ?: is there a restriction for removing a reservation

                confirmMod("Remove Reservation");
            }
        });
        removeResPanel.getCancelButton().addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){
                setHotelNameInput(""); 
                setStandardRoomInput(0);
                setDeluxeRoomInput(0);
                setExecutiveRoomInput(0);
                setBasePriceInput(0.00f);
                setDateModInput(0);
                setPriceModInput(0);
                setRemoveRoomInput("");
                setRemoveResInput("");

                listener.buttonClicked("Manage Cancel");
            }
        });*/



        // * Remove Hotel * //
        ImageIcon removeHotelIcon = new ImageIcon("Icons/HotelsIcon.png"); 
        removeHotelIcon = Customization.resizeIcon(removeHotelIcon, 20, 20);

        removeHotel = new IconButton(removeHotelIcon, "Remove Hotel");
        removeHotel.setBounds(323,10, 40, 40);
        removeHotel.setColorClick(removeHotel.getColorOver());
        removeHotel.addActionListener(this);

        removeHotelPanel = new ManageSubPanel("Remove Hotel");
        removeHotelPanel.getUpdateButton().setText("Remove");
        removeHotelPanel.getUpdateButton().setBounds(130, 170, 100, 30);
        /*removeHotelPanel.getUpdateButton().addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){

                // TODO: check if there are no active reservations
                
                confirmMod("Remove Hotel");
            }
        });
        removeHotelPanel.getCancelButton().addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){
                setHotelNameInput(""); 
                setStandardRoomInput(0);
                setDeluxeRoomInput(0);
                setExecutiveRoomInput(0);
                setBasePriceInput(0.00f);
                setDateModInput(0);
                setPriceModInput(0);
                setRemoveRoomInput("");
                setRemoveResInput("");

                listener.buttonClicked("Manage Cancel");
            }
        });*/

        manageContainer = new RoundPanel(new Color(40, 68, 117));
        manageContainer.setLayout(null);
        manageContainer.setPreferredSize(new Dimension(530, 585));
        manageContainer.setBounds(10, 60, 365, 350);
        
        this.add(manageContainer);
        this.add(changeName);
        this.add(addRoom);
        this.add(updateBasePrice);
        this.add(removeRoom);
        this.add(removeRes);
        this.add(removeHotel);
        this.add(datePriceModifier);
        this.add(changeNamePanel);
        this.add(addRoomPanel);
        this.add(updateBasePricePanel);
        this.add(datePriceModifierPanel);
        this.add(removeRoomPanel);
        this.add(removeResPanel);
        this.add(removeHotelPanel);

        changeNamePanel.setVisible(false);
        addRoomPanel.setVisible(false);
        updateBasePricePanel.setVisible(false);
        datePriceModifierPanel.setVisible(false);
        removeRoomPanel.setVisible(false);
        removeResPanel.setVisible(false);
        removeHotelPanel.setVisible(false);
    }

    public void confirmMod(String panelName){
        /*yesButton = new OptionButton("Yes");
        yesButton.setBounds(80, 170, 100, 30);
        yesButton.setColorOver(yesButton.getColorClick());
        
        noButton = new OptionButton("No");
        noButton.setBounds(185, 170, 100, 30);
        noButton.setColorOver(noButton.getColorClick());

        confirmModPanel = new ManageSubPanel("Confirm Modification");
        confirmModPanel.getUpdateButton().setVisible(false);
        confirmModPanel.getCancelButton().setVisible(false);
        confirmModPanel.add(yesButton);
        confirmModPanel.add(noButton);*/

        confirmModPanel = new ConfirmModPanel(panelName);

        this.add(confirmModPanel, JLayeredPane.POPUP_LAYER);
        confirmModPanel.setVisible(true);

        /*yesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                /*if (panelName.equals("Change Name")){
                    
                    // TODO: set hotel name to getHotelNameInput();

                    listener.buttonClicked(panelName);

                }
                else if (panelName.equals("Add Room")){
    
                    // TODO: add rooms based on room type using getStandardRoomInput(), getDeluxeRoomInput(), and getExecutiveRoomInput()
                
                    listener.buttonClicked(panelName);
                }
                else if (panelName.equals("Update Base Price")){
                    
                    // TODO: set hotel base price to getBasePriceInput();

                    listener.buttonClicked(panelName);
                }
                else if (panelName.equals("Date Price Modifier")){
                    
                    // TODO: set getDateModInput() and getPriceModInput() to datePriceModifier parameters
                
                    listener.buttonClicked(panelName);
                }
                else if (panelName.equals("Remove Room")){
                    
                    // TODO: remove room from hotel using getRemoveRoomInput();

                    listener.buttonClicked(panelName);
                }
                else if (panelName.equals("Remove Reservation")){

                    // TODO: remove reservation from hotel using getRemoveResInput();

                    listener.buttonClicked(panelName);
                }
                else if (panelName.equals("Remove Hotel")){

                    // TODO: remove hotel

                    listener.buttonClicked(panelName);
                }

                confirmModPanel.setVisible(false);
            }
        });

        noButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirmModPanel.setVisible(false);
            }
        });*/
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /*if (e.getSource() == changeName){
            manageContainer.setVisible(false);
            changeNamePanel.setVisible(true);
            addRoomPanel.setVisible(false);
            updateBasePricePanel.setVisible(false);
            datePriceModifierPanel.setVisible(false);
            removeRoomPanel.setVisible(false);
            removeResPanel.setVisible(false);
            removeHotelPanel.setVisible(false);
        }
        else if (e.getSource() == addRoom){
            manageContainer.setVisible(false);
            changeNamePanel.setVisible(false);
            addRoomPanel.setVisible(true);
            updateBasePricePanel.setVisible(false);
            datePriceModifierPanel.setVisible(false);
            removeRoomPanel.setVisible(false);
            removeResPanel.setVisible(false);
            removeHotelPanel.setVisible(false);
        }
        else if (e.getSource() == updateBasePrice){
            manageContainer.setVisible(false);
            changeNamePanel.setVisible(false);
            addRoomPanel.setVisible(false);
            updateBasePricePanel.setVisible(true);
            datePriceModifierPanel.setVisible(false);
            removeRoomPanel.setVisible(false);
            removeResPanel.setVisible(false);
            removeHotelPanel.setVisible(false);
        }
        else if (e.getSource() == datePriceModifier){
            manageContainer.setVisible(false);
            changeNamePanel.setVisible(false);
            addRoomPanel.setVisible(false);
            updateBasePricePanel.setVisible(false);
            datePriceModifierPanel.setVisible(true);
            removeRoomPanel.setVisible(false);
            removeResPanel.setVisible(false);
            removeHotelPanel.setVisible(false);
        }
        else if (e.getSource() == removeRoom){
            manageContainer.setVisible(false);
            changeNamePanel.setVisible(false);
            addRoomPanel.setVisible(false);
            updateBasePricePanel.setVisible(false);
            datePriceModifierPanel.setVisible(false);
            removeRoomPanel.setVisible(true);
            removeResPanel.setVisible(false);
            removeHotelPanel.setVisible(false);
        }
        else if (e.getSource() == removeRes){
            manageContainer.setVisible(false);
            changeNamePanel.setVisible(false);
            addRoomPanel.setVisible(false);
            updateBasePricePanel.setVisible(false);
            datePriceModifierPanel.setVisible(false);
            removeRoomPanel.setVisible(false);
            removeResPanel.setVisible(true);
            removeHotelPanel.setVisible(false);
        }
        else if (e.getSource() == removeHotel){
            manageContainer.setVisible(false);
            changeNamePanel.setVisible(false);
            addRoomPanel.setVisible(false);
            updateBasePricePanel.setVisible(false);
            datePriceModifierPanel.setVisible(false);
            removeRoomPanel.setVisible(false);
            removeResPanel.setVisible(false);
            removeHotelPanel.setVisible(true);
        }*/
    }

    @Override
    public void buttonClicked(String buttonName) {
        /*for (int i = 0; i < 31; i++){
            ArrayList<OptionButton> days = calendarView.getDays();
            String dayIndex = days.get(i).getButtonName(); 

            if (buttonName.equals(dayIndex)){
                days.get(i).setColor(new Color(51, 88, 150));
                setDateModInput(i);
            }
            else {
                for (int j = 0; j < 31; j++){
                    days.get(i).setColor(new Color(27, 43, 80));
                }
            }
        }*/
    }

    @Override
    public void roomButtonClicked(String roomButtonName) {
        /*int nRooms = 30; // TODO: remove
        String name = "";

        for (int i = 0; i < nRooms; i++){
            ArrayList<OptionButton> roomButtons = roomView.getRooms();
            name = roomButtons.get(i).getButtonName();

            if (roomButtonName.equals(name)){
                roomButtons.get(i).setColor(new Color(51, 88, 150));
                setRemoveRoomInput(name);
            }
            else {
                for (int j = 0; j < nRooms; j++){
                    roomButtons.get(i).setColor(new Color(27, 43, 80));
                }
            }
        }*/
    }

    @Override
    public void reservationButtonClicked(String reservationButtonName) {
        /*int nReservations = 6; // TODO: remove
        String name = "";

        for (int i = 0; i < nReservations; i++){
            ArrayList<OptionButton> resButtons = resView.getReservations();
            name = resButtons.get(i).getButtonName();

            if (reservationButtonName.equals(name)){
                resButtons.get(i).setColor(new Color(51, 88, 150));
                setRemoveResInput(name);
            }
            else {
                for (int j = 0; j < nReservations; j++){
                    resButtons.get(i).setColor(new Color(27, 43, 80));
                }
            }
        }*/
    }

    public IconButton getChangeNameButton(){
        return changeName;
    }

    public void setChangeNameButton(IconButton changeName){
        this.changeName = changeName;
    }

    public IconButton getAddRoomButton(){
        return addRoom;
    }

    public void setAddRoomButton(IconButton addRoom){
        this.addRoom = addRoom;
    }

    public IconButton getUpdateBasePriceButton(){
        return updateBasePrice;
    }

    public void setUpdateBasePriceButton(IconButton updateBasePrice){
        this.updateBasePrice = updateBasePrice;
    }

    public IconButton getDatePriceModifierButton(){
        return datePriceModifier;
    }

    public void setDatePriceModifierButton(IconButton datePriceModifier){
        this.datePriceModifier = datePriceModifier;
    }

    public IconButton getRemoveRoomButton(){
        return removeRoom;
    }

    public void setRemoveRoomButton(IconButton removeRoom){
        this.removeRoom = removeRoom;
    }

    public IconButton getRemoveResButton(){
        return removeRes;
    }

    public void setRemoveResButton(IconButton removeRes){
        this.removeRes = removeRes;
    }

    public IconButton getRemoveHotelButton(){
        return removeHotel;
    }

    public void setRemoveHotelButton(IconButton removeHotel){
        this.removeHotel = removeHotel;
    }

    public ManageSubPanel getChangeNamePanel(){
        return changeNamePanel;
    }

    public void setChangeNamePanel(ManageSubPanel changeNamePanel){
        this.changeNamePanel = changeNamePanel;
    }

    public ManageSubPanel getAddRoomPanel(){
        return addRoomPanel;
    }

    public void setAddRoomPanel(ManageSubPanel addRoomPanel){
        this.addRoomPanel = addRoomPanel;
    }

    public ManageSubPanel getUpdateBasePricePanel(){
        return updateBasePricePanel;
    }

    public void setUpdateBasePricePanel(ManageSubPanel updateBasePricePanel){
        this.updateBasePricePanel = updateBasePricePanel;
    }

    public ManageSubPanel getDatePriceModifierPanel(){
        return datePriceModifierPanel;
    }

    public void setDatePriceModifierPanel(ManageSubPanel datePriceModifierPanel){
        this.datePriceModifierPanel = datePriceModifierPanel;
    }

    public ManageSubPanel getRemoveRoomPanel(){
        return removeRoomPanel;
    }

    public void setRemoveRoomPanel(ManageSubPanel removeRoomPanel){
        this.removeRoomPanel = removeRoomPanel;
    }

    public ManageSubPanel getRemoveResPanel(){
        return removeResPanel;
    }

    public void setRemoveResPanel(ManageSubPanel removeResPanel){
        this.removeResPanel = removeResPanel;
    }

    public ManageSubPanel getRemoveHotelPanel(){
        return removeHotelPanel;
    }

    public void setRemoveHotelPanel(ManageSubPanel removeHotelPanel){
        this.removeHotelPanel = removeHotelPanel;
    }

    public ConfirmModPanel getConfirmModPanel(){
        return confirmModPanel;
    }

    public void setConfirmModPanel(ConfirmModPanel confirmModPanel){
        this.confirmModPanel = confirmModPanel;
    }

    /*public OptionButton getYesButton(){
        return yesButton;
    }

    public void setYesButton(OptionButton yesButton){
        this.yesButton = yesButton;
    }

    public OptionButton getNoButton(){
        return noButton;
    }

    public void setNoButton(OptionButton noButton){
        this.noButton = noButton;
    }*/

    public RoundPanel getManageContainer(){
        return manageContainer;
    }

    public void setManageContainer(RoundPanel manageContainer){
        this.manageContainer = manageContainer;
    }

    public TextFieldCustom getHotelNameInput(){
        return newHotelNameInput;
    }

    public void setHotelNameInput(TextFieldCustom newHotelNameInput){
        this.newHotelNameInput = newHotelNameInput;
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

    public TextFieldCustom getBasePriceInput(){
        return newBasePriceInput;
    }

    public void setBasePriceInput(TextFieldCustom newBasePriceInput){
        this.newBasePriceInput = newBasePriceInput;
    }

    public TextFieldCustom getPercentageInput(){ 
        return percentageInput;
    }

    public void setPercentageInput(TextFieldCustom percentageInput){
        this.percentageInput = percentageInput;
    }

    /*public int getPriceModInput(){ 
        return percentModInput;
    }

    public void setPriceModInput(int percentModInput){
        this.percentModInput = percentModInput;
    }

    public String getRemoveRoomInput(){ 
        return removeRoomInput;
    }

    public void setRemoveRoomInput(String removeRoomInput){
        this.removeRoomInput = removeRoomInput;
    }

    public String getRemoveResInput(){ 
        return removeResInput;
    }

    public void setRemoveResInput(String removeResInput){
        this.removeResInput = removeResInput;
    }*/

    public ReservationView getResView(){
        return resView;
    }

    public void setResView(ReservationView resView){
        this.resView = resView;
    }

    public RoomView getRoomView(){
        return roomView;
    }

    public void setRoomView(RoomView roomView){
        this.roomView = roomView;
    }

    public CalendarView getCalendarView(){
        return calendarView;
    }

    public void setCalendarView(CalendarView calendarView){
        this.calendarView = calendarView;
    }
}
