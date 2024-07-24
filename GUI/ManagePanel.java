//package GUI;
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
    private ManageSubPanel confirmModPanel;

    private TextFieldCustom newHotelName;
    private TextFieldCustom nStandardRooms, nDeluxeRooms, nExecutiveRooms;
    private TextFieldCustom newBasePrice;
    private TextFieldCustom newDatePrice;

    private String hotelNameInput;
    private int standardRoomInput, deluxeRoomInput, executiveRoomInput;
    private float basePriceInput;
    private int dateModInput;
    private int percentModInput;
    private String removeRoomInput;
    private String removeResInput;

    private ArrayList<OptionButton> days;
    private OptionButton yesButton;
    private OptionButton noButton;

    private RoomView roomView;
    private ReservationView resView;
    private CalendarView calendarView;

    private RoundPanel manageContainer;
    private ButtonClickListener listener;

    // TODO: change to Hotel
    ManagePanel(String hotel, ButtonClickListener listener, Color color) {
        super(color);
        
        this.listener = listener;
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
        currentName.setText("Kelsey Hotel"); // TODO: set to curent hotel name
        currentName.setFont(customFont20);
        currentName.setForeground(Color.white);

        newHotelName = new TextFieldCustom(new Color(40, 68, 117));
        newHotelName.setBounds(5, 130, 350, 55);
        newHotelName.setFieldName("New Hotel Name");
        newHotelName.getTextContainer().setBounds(5, 25, 340, 27);

        changeNamePanel = new ManageSubPanel("Change Name");
        changeNamePanel.add(currentName);
        changeNamePanel.add(newHotelName);
        changeNamePanel.getUpdateButton().addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){

                String hotelName = newHotelName.getTextField().getText().trim();

                // TODO: check if name is valid

                if (!hotelName.isEmpty()){
                    setHotelNameInput(hotelName); 
    
                    confirmMod("Change Name");
                }
            }
        });
        changeNamePanel.getCancelButton().addActionListener(new ActionListener(){

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
        });



        // * Add Room * //
        ImageIcon addRoomIcon = new ImageIcon("Icons/AddIcon.png");
        addRoomIcon = Customization.resizeIcon(addRoomIcon, 20, 20);

        addRoom = new IconButton(addRoomIcon, "Add Room");
        addRoom.setBounds(73,10, 40, 40);
        addRoom.setColorClick(addRoom.getColorOver());
        addRoom.addActionListener(this);

        nStandardRooms = new TextFieldCustom(new Color(40, 68, 117));
        nStandardRooms.setBounds(5, 90, 350, 55);
        nStandardRooms.setFieldName("No. of Standard Rooms");
        nStandardRooms.getTextContainer().setBounds(5, 25, 340, 27);

        nDeluxeRooms = new TextFieldCustom(new Color(40, 68, 117));
        nDeluxeRooms.setBounds(5, 150, 350, 55);
        nDeluxeRooms.setFieldName("No. of Deluxe Rooms");
        nDeluxeRooms.getTextContainer().setBounds(5, 25, 340, 27);

        nExecutiveRooms = new TextFieldCustom(new Color(40, 68, 117));
        nExecutiveRooms.setBounds(5, 210, 350, 55);
        nExecutiveRooms.setFieldName("No. of Executive Rooms");
        nExecutiveRooms.getTextContainer().setBounds(5, 25, 340, 27);

        addRoomPanel = new ManageSubPanel("Add Room");
        addRoomPanel.add(nStandardRooms);
        addRoomPanel.add(nDeluxeRooms);
        addRoomPanel.add(nExecutiveRooms);
        addRoomPanel.getUpdateButton().addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){
                int standard = Integer.valueOf(nStandardRooms.getTextField().getText().trim());
                int deluxe = Integer.valueOf(nDeluxeRooms.getTextField().getText().trim());
                int executive = Integer.valueOf(nExecutiveRooms.getTextField().getText().trim());

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
        });



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

        newBasePrice = new TextFieldCustom(new Color(40, 68, 117));
        newBasePrice.setBounds(5, 130, 350, 55);
        newBasePrice.setFieldName("New Base Price");
        newBasePrice.getTextContainer().setBounds(5, 25, 340, 27);

        updateBasePricePanel = new ManageSubPanel("Update Base Price");
        updateBasePricePanel.add(currentBasePrice);
        updateBasePricePanel.add(newBasePrice);
        updateBasePricePanel.getUpdateButton().addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){

                Float basePrice = Float.valueOf(newBasePrice.getTextField().getText().trim());

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
        });



        // * Date Price Modifier * //
        ImageIcon datePriceModifierIcon = new ImageIcon("Icons/DatePriceModifierIcon.png"); 
        datePriceModifierIcon = Customization.resizeIcon(datePriceModifierIcon, 20, 20);

        datePriceModifier = new IconButton(datePriceModifierIcon, "Date Price Modifier");
        datePriceModifier.setBounds(173,10, 40, 40);
        datePriceModifier.setColorClick(datePriceModifier.getColorOver());
        datePriceModifier.addActionListener(this);

        calendarView = new CalendarView(this);
        calendarView.setBounds(2, 2, 335, 203);
        days = calendarView.getDays();
        days.get(30).setEnabled(false);
        days.get(30).setColor(new Color(27, 43, 80));
        days.get(30).setColorOver(new Color(27, 43, 80));
        days.get(30).setColorClick(new Color(27, 43, 80));

        newDatePrice = new TextFieldCustom(new Color(40, 68, 117));
        newDatePrice.setBounds(0, 220, 340, 55);
        newDatePrice.setFieldName("New Date Price");
        newDatePrice.getTextContainer().setBounds(5, 25, 330, 27);

        RoundPanel datePriceContainer = new RoundPanel(new Color(40, 68, 117));
        datePriceContainer.setLayout(null);
        datePriceContainer.setPreferredSize(new Dimension(350, 280));
        datePriceContainer.add(calendarView);
        datePriceContainer.add(newDatePrice);

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
        datePriceModifierPanel.getUpdateButton().addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){

                int percentage = Integer.valueOf(newDatePrice.getTextField().getText().trim());

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
        });



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

        roomView = new RoomView(this, nRooms); // TODO: set to no. of rooms

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
        removeRoomPanel.getUpdateButton().addActionListener(new ActionListener(){

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
        });



        // * Remove Reservation * //
        ImageIcon removeResIcon = new ImageIcon("Icons/ReservationsIcon.png"); 
        removeResIcon = Customization.resizeIcon(removeResIcon, 20, 20);

        removeRes = new IconButton(removeResIcon, "Remove Reservation");
        removeRes.setBounds(273,10, 40, 40);
        removeRes.setColorClick(removeRes.getColorOver());
        removeRes.addActionListener(this);

        int nReservations = 6; // TODO: remove
        int resViewHeight = nReservations * 39 + 5;

        resView = new ReservationView(this, nReservations); // TODO: change to no. of reservations
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
        removeResPanel.getUpdateButton().addActionListener(new ActionListener(){

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
        });



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
        removeHotelPanel.getUpdateButton().addActionListener(new ActionListener(){

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
        });        

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
        yesButton = new OptionButton("Yes");
        yesButton.setBounds(80, 170, 100, 30);
        yesButton.setColorOver(yesButton.getColorClick());
        
        noButton = new OptionButton("No");
        noButton.setBounds(185, 170, 100, 30);
        noButton.setColorOver(noButton.getColorClick());

        confirmModPanel = new ManageSubPanel("Confirm Modification");
        confirmModPanel.getUpdateButton().setVisible(false);
        confirmModPanel.getCancelButton().setVisible(false);
        confirmModPanel.add(yesButton);
        confirmModPanel.add(noButton);

        this.add(confirmModPanel, JLayeredPane.POPUP_LAYER);
        confirmModPanel.setVisible(true);

        yesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (panelName.equals("Change Name")){
                    
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
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == changeName){
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
        }
    }

    @Override
    public void buttonClicked(String buttonName) {
        for (int i = 0; i < 31; i++){
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
        }
    }

    @Override
    public void roomButtonClicked(String roomButtonName) {
        int nRooms = 30; // TODO: remove
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
        }
    }

    @Override
    public void reservationButtonClicked(String reservationButtonName) {
        int nReservations = 6; // TODO: remove
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
        }
    }

    public String getHotelNameInput(){
        return hotelNameInput;
    }

    public void setHotelNameInput(String hotelNameInput){
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

    public float getBasePriceInput(){
        return basePriceInput;
    }

    public void setBasePriceInput(float basePriceInput){
        this.basePriceInput = basePriceInput;
    }

    public int getDateModInput(){ 
        return dateModInput;
    }

    public void setDateModInput(int dateModInput){
        this.dateModInput = dateModInput;
    }

    public int getPriceModInput(){ 
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
    }
}
