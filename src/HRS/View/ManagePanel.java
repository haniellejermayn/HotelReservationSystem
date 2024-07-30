package src.HRS.View;

import javax.swing.*;
import src.HRS.Model.Hotel;
import java.awt.*;
import java.util.ArrayList;

public class ManagePanel extends LayeredRoundPanel{

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

    private TextFieldCustom newHotelNameTextField;
    private TextFieldCustom standardRoomTextField, deluxeRoomTextField, executiveRoomTextField;
    private TextFieldCustom newBasePriceTextField;
    private TextFieldCustom percentageTextField;

    private int dateModInput;
    private float percentModInput;
    private int removeRoomInput;
    private int removeResInput;

    private ArrayList<OptionButton> days;
    private ArrayList<OptionButton> rooms;
    private ArrayList<OptionButton> reservations;

    private RoomView roomView;
    private ReservationView resView;
    private CalendarView calendarView;

    private RoundPanel manageContainer;

    public ManagePanel(Hotel hotel, Color color) {
        super(color);
        
        this.setLayout(null);
        this.setBounds(152, 10, 385, 420);

        Font customFont20 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 20);

        // * Change Name * //
        ImageIcon changeNameIcon = new ImageIcon("Icons/ChangeNameIcon.png"); 
        changeNameIcon = Customization.resizeIcon(changeNameIcon, 20, 20);

        changeName = new IconButton(changeNameIcon, "Change Name");
        changeName.setBounds(23,10, 40, 40);
        changeName.setColorClick(changeName.getColorOver());

        RoundLabel currentName = new RoundLabel(new Color(40, 68, 117));
        currentName.setBounds(122, 80, 200, 40);
        currentName.setText(hotel.getHotelName());
        currentName.setFont(customFont20);
        currentName.setForeground(Color.white);

        newHotelNameTextField = new TextFieldCustom(new Color(40, 68, 117));
        newHotelNameTextField.setBounds(5, 130, 350, 55);
        newHotelNameTextField.setFieldName("New Hotel Name");
        newHotelNameTextField.getTextContainer().setBounds(5, 25, 340, 27);

        changeNamePanel = new ManageSubPanel("Change Name");
        changeNamePanel.add(currentName);
        changeNamePanel.add(newHotelNameTextField);

        // * Add Room * //
        ImageIcon addRoomIcon = new ImageIcon("Icons/AddIcon.png");
        addRoomIcon = Customization.resizeIcon(addRoomIcon, 20, 20);

        addRoom = new IconButton(addRoomIcon, "Add Room");
        addRoom.setBounds(73,10, 40, 40);
        addRoom.setColorClick(addRoom.getColorOver());

        standardRoomTextField = new TextFieldCustom(new Color(40, 68, 117));
        standardRoomTextField.setBounds(5, 90, 350, 55);
        standardRoomTextField.setFieldName("No. of Standard Rooms");
        standardRoomTextField.getTextContainer().setBounds(5, 25, 340, 27);

        deluxeRoomTextField = new TextFieldCustom(new Color(40, 68, 117));
        deluxeRoomTextField.setBounds(5, 150, 350, 55);
        deluxeRoomTextField.setFieldName("No. of Deluxe Rooms");
        deluxeRoomTextField.getTextContainer().setBounds(5, 25, 340, 27);

        executiveRoomTextField = new TextFieldCustom(new Color(40, 68, 117));
        executiveRoomTextField.setBounds(5, 210, 350, 55);
        executiveRoomTextField.setFieldName("No. of Executive Rooms");
        executiveRoomTextField.getTextContainer().setBounds(5, 25, 340, 27);

        addRoomPanel = new ManageSubPanel("Add Room");
        addRoomPanel.add(standardRoomTextField);
        addRoomPanel.add(deluxeRoomTextField);
        addRoomPanel.add(executiveRoomTextField);

        // * Update Price * //
        ImageIcon updatePriceIcon = new ImageIcon("Icons/UpdatePriceIcon.png"); 
        updatePriceIcon = Customization.resizeIcon(updatePriceIcon, 20, 20);

        updateBasePrice = new IconButton(updatePriceIcon, "Update Base Price");
        updateBasePrice.setBounds(123,10, 40, 40);
        updateBasePrice.setColorClick(updateBasePrice.getColorOver());

        RoundLabel currentBasePrice = new RoundLabel(new Color(40, 68, 117));
        currentBasePrice.setBounds(142, 80, 200, 40); 
        currentBasePrice.setText(String.format("%.2f", hotel.getBasePrice()));
        currentBasePrice.setFont(customFont20);
        currentBasePrice.setForeground(Color.white);

        newBasePriceTextField = new TextFieldCustom(new Color(40, 68, 117));
        newBasePriceTextField.setBounds(5, 130, 350, 55);
        newBasePriceTextField.setFieldName("New Base Price");
        newBasePriceTextField.getTextContainer().setBounds(5, 25, 340, 27);

        updateBasePricePanel = new ManageSubPanel("Update Base Price");
        updateBasePricePanel.add(currentBasePrice);
        updateBasePricePanel.add(newBasePriceTextField);

        // * Date Price Modifier * //
        ImageIcon datePriceModifierIcon = new ImageIcon("Icons/DatePriceModifierIcon.png"); 
        datePriceModifierIcon = Customization.resizeIcon(datePriceModifierIcon, 20, 20);

        datePriceModifier = new IconButton(datePriceModifierIcon, "Date Price Modifier");
        datePriceModifier.setBounds(173,10, 40, 40);
        datePriceModifier.setColorClick(datePriceModifier.getColorOver());

        calendarView = new CalendarView();
        calendarView.setBounds(2, 2, 335, 203);
        days = calendarView.getDays();
        days.get(30).setEnabled(false);
        days.get(30).setColor(new Color(27, 43, 80));
        days.get(30).setColorOver(new Color(27, 43, 80));
        days.get(30).setColorClick(new Color(27, 43, 80));

        percentageTextField = new TextFieldCustom(new Color(40, 68, 117));
        percentageTextField.setBounds(0, 220, 340, 55);
        percentageTextField.setFieldName("New Date Price");
        percentageTextField.getTextContainer().setBounds(5, 25, 330, 27);

        RoundPanel datePriceContainer = new RoundPanel(new Color(40, 68, 117));
        datePriceContainer.setLayout(null);
        datePriceContainer.setPreferredSize(new Dimension(350, 280));
        datePriceContainer.add(calendarView);
        datePriceContainer.add(percentageTextField);

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
        
        // * Remove Room * //
        ImageIcon removeRoomIcon = new ImageIcon("Icons/RoomIcon.png"); 
        removeRoomIcon = Customization.resizeIcon(removeRoomIcon, 20, 20);

        removeRoom = new IconButton(removeRoomIcon, "Remove Room");
        removeRoom.setBounds(223,10, 40, 40);
        removeRoom.setColorClick(removeRoom.getColorOver());

        int nRooms = hotel.countRooms(0);
        int roomViewHeight;

        if (nRooms > 25){
            roomViewHeight = (((nRooms - 1) / 5 - 3) * 9 + (((nRooms - 1) / 5 - 4) * 30)) + 198 - 15;
        }
        else {
            roomViewHeight = 198;
        }

        roomView = new RoomView(hotel);
        rooms = roomView.getRooms();

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
        
        // * Remove Reservation * //
        ImageIcon removeResIcon = new ImageIcon("Icons/ReservationsIcon.png"); 
        removeResIcon = Customization.resizeIcon(removeResIcon, 20, 20);

        removeRes = new IconButton(removeResIcon, "Remove Reservation");
        removeRes.setBounds(273,10, 40, 40);
        removeRes.setColorClick(removeRes.getColorOver());

        int nReservations = hotel.countReservations(); 
        int resViewHeight = nReservations * 39 + 5;

        resView = new ReservationView(hotel); 
        reservations = resView.getReservations();

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
        
        // * Remove Hotel * //
        ImageIcon removeHotelIcon = new ImageIcon("Icons/HotelsIcon.png"); 
        removeHotelIcon = Customization.resizeIcon(removeHotelIcon, 20, 20);

        removeHotel = new IconButton(removeHotelIcon, "Remove Hotel");
        removeHotel.setBounds(323,10, 40, 40);
        removeHotel.setColorClick(removeHotel.getColorOver());

        removeHotelPanel = new ManageSubPanel("Remove Hotel");
        removeHotelPanel.getUpdateButton().setText("Remove");
        removeHotelPanel.getUpdateButton().setBounds(130, 170, 100, 30);

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

        confirmModPanel = new ConfirmModPanel(panelName);

        this.add(confirmModPanel, JLayeredPane.POPUP_LAYER);
        confirmModPanel.setVisible(true);
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

    public RoundPanel getManageContainer(){
        return manageContainer;
    }

    public void setManageContainer(RoundPanel manageContainer){
        this.manageContainer = manageContainer;
    }

    public TextFieldCustom getHotelNameTextField(){
        return newHotelNameTextField;
    }

    public void setHotelNameTextField(TextFieldCustom newHotelNameTextField){
        this.newHotelNameTextField = newHotelNameTextField;
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

    public TextFieldCustom getBasePriceTextField(){
        return newBasePriceTextField;
    }

    public void setBasePriceTextField(TextFieldCustom newBasePriceTextField){
        this.newBasePriceTextField = newBasePriceTextField;
    }

    public TextFieldCustom getPercentageTextField(){ 
        return percentageTextField;
    }

    public void setPercentageTextField(TextFieldCustom percentageTextField){
        this.percentageTextField = percentageTextField;
    }

    public float getPriceModInput(){ 
        return percentModInput;
    }

    public void setPriceModInput(float percentModInput){
        this.percentModInput = percentModInput;
    }

    public int getDateModInput(){
        return dateModInput;
    }

    public void setDateModInput(int dateModInput){
        this.dateModInput = dateModInput;
    }

    public int getRemoveRoomInput(){ 
        return removeRoomInput;
    }

    public void setRemoveRoomInput(int removeRoomInput){
        this.removeRoomInput = removeRoomInput;
    }

    public int getRemoveResInput(){ 
        return removeResInput;
    }

    public void setRemoveResInput(int removeResInput){
        this.removeResInput = removeResInput;
    }

    public ReservationView getResView(){
        return resView;
    }

    public void setResView(ReservationView resView){
        this.resView = resView;
    }

    public ArrayList<OptionButton> getReservations(){
        return reservations;
    }

    public void setReservations(ArrayList<OptionButton> reservations){
        this.reservations = reservations;
    }

    public RoomView getRoomView(){
        return roomView;
    }

    public void setRoomView(RoomView roomView){
        this.roomView = roomView;
    }

    public ArrayList<OptionButton> getRooms(){
        return rooms;
    }

    public void setRooms(ArrayList<OptionButton> rooms){
        this.rooms = rooms;
    }
    
    public CalendarView getCalendarView(){
        return calendarView;
    }
    
    public void setCalendarView(CalendarView calendarView){
        this.calendarView = calendarView;
    }
    
    public ArrayList<OptionButton> getDays(){
        return days;
    }

    public void setDays(ArrayList<OptionButton> days){
        this.days = days;
    }
}
