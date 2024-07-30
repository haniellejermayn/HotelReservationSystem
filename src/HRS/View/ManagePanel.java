package src.HRS.View;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import src.HRS.Model.Hotel;

/**
 * The ManagePanel class represents a management panel for hotel operations.
 * It provides various options to change hotel details, add or remove rooms,
 * update prices, and manage reservations.
 */
public class ManagePanel extends LayeredRoundPanel {

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

    /**
     * Constructs a new ManagePanel with the specified hotel and color.
     *
     * @param hotel the Hotel object containing hotel data
     * @param color the background color of the panel
     */
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

    /**
     * Displays a confirmation panel with the specified panel name.
     *
     * @param panelName the name of the panel to confirm the modification for
     */
    public void confirmMod(String panelName) {
        confirmModPanel = new ConfirmModPanel(panelName);
        this.add(confirmModPanel, JLayeredPane.POPUP_LAYER);
        confirmModPanel.setVisible(true);
    }

    /**
     * Returns the change name button.
     *
     * @return the change name button
     */
    public IconButton getChangeNameButton() {
        return changeName;
    }

    /**
     * Sets the change name button.
     *
     * @param changeName the change name button to set
     */
    public void setChangeNameButton(IconButton changeName) {
        this.changeName = changeName;
    }

    /**
     * Returns the add room button.
     *
     * @return the add room button
     */
    public IconButton getAddRoomButton() {
        return addRoom;
    }

    /**
     * Sets the add room button.
     *
     * @param addRoom the add room button to set
     */
    public void setAddRoomButton(IconButton addRoom) {
        this.addRoom = addRoom;
    }

    /**
     * Returns the update base price button.
     *
     * @return the update base price button
     */
    public IconButton getUpdateBasePriceButton() {
        return updateBasePrice;
    }

    /**
     * Sets the update base price button.
     *
     * @param updateBasePrice the update base price button to set
     */
    public void setUpdateBasePriceButton(IconButton updateBasePrice) {
        this.updateBasePrice = updateBasePrice;
    }

    /**
     * Returns the date price modifier button.
     *
     * @return the date price modifier button
     */
    public IconButton getDatePriceModifierButton() {
        return datePriceModifier;
    }

    /**
     * Sets the date price modifier button.
     *
     * @param datePriceModifier the date price modifier button to set
     */
    public void setDatePriceModifierButton(IconButton datePriceModifier) {
        this.datePriceModifier = datePriceModifier;
    }

    /**
     * Returns the remove room button.
     *
     * @return the remove room button
     */
    public IconButton getRemoveRoomButton() {
        return removeRoom;
    }

    /**
     * Sets the remove room button.
     *
     * @param removeRoom the remove room button to set
     */
    public void setRemoveRoomButton(IconButton removeRoom) {
        this.removeRoom = removeRoom;
    }

    /**
     * Returns the remove reservation button.
     *
     * @return the remove reservation button
     */
    public IconButton getRemoveResButton() {
        return removeRes;
    }

    /**
     * Sets the remove reservation button.
     *
     * @param removeRes the remove reservation button to set
     */
    public void setRemoveResButton(IconButton removeRes) {
        this.removeRes = removeRes;
    }

    /**
     * Returns the remove hotel button.
     *
     * @return the remove hotel button
     */
    public IconButton getRemoveHotelButton() {
        return removeHotel;
    }

    /**
     * Sets the remove hotel button.
     *
     * @param removeHotel the remove hotel button to set
     */
    public void setRemoveHotelButton(IconButton removeHotel) {
        this.removeHotel = removeHotel;
    }

    /**
     * Returns the change name panel.
     *
     * @return the change name panel
     */
    public ManageSubPanel getChangeNamePanel() {
        return changeNamePanel;
    }

    /**
     * Sets the change name panel.
     *
     * @param changeNamePanel the change name panel to set
     */
    public void setChangeNamePanel(ManageSubPanel changeNamePanel) {
        this.changeNamePanel = changeNamePanel;
    }

    /**
     * Returns the add room panel.
     *
     * @return the add room panel
     */
    public ManageSubPanel getAddRoomPanel() {
        return addRoomPanel;
    }

    /**
     * Sets the add room panel.
     *
     * @param addRoomPanel the add room panel to set
     */
    public void setAddRoomPanel(ManageSubPanel addRoomPanel) {
        this.addRoomPanel = addRoomPanel;
    }

    /**
     * Returns the update base price panel.
     *
     * @return the update base price panel
     */
    public ManageSubPanel getUpdateBasePricePanel() {
        return updateBasePricePanel;
    }

    /**
     * Sets the update base price panel.
     *
     * @param updateBasePricePanel the update base price panel to set
     */
    public void setUpdateBasePricePanel(ManageSubPanel updateBasePricePanel) {
        this.updateBasePricePanel = updateBasePricePanel;
    }

    /**
     * Returns the date price modifier panel.
     *
     * @return the date price modifier panel
     */
    public ManageSubPanel getDatePriceModifierPanel() {
        return datePriceModifierPanel;
    }

    /**
     * Sets the date price modifier panel.
     *
     * @param datePriceModifierPanel the date price modifier panel to set
     */
    public void setDatePriceModifierPanel(ManageSubPanel datePriceModifierPanel) {
        this.datePriceModifierPanel = datePriceModifierPanel;
    }

    /**
     * Returns the remove room panel.
     *
     * @return the remove room panel
     */
    public ManageSubPanel getRemoveRoomPanel() {
        return removeRoomPanel;
    }

    /**
     * Sets the remove room panel.
     *
     * @param removeRoomPanel the remove room panel to set
     */
    public void setRemoveRoomPanel(ManageSubPanel removeRoomPanel) {
        this.removeRoomPanel = removeRoomPanel;
    }

    /**
     * Returns the remove reservation panel.
     *
     * @return the remove reservation panel
     */
    public ManageSubPanel getRemoveResPanel() {
        return removeResPanel;
    }

    /**
     * Sets the remove reservation panel.
     *
     * @param removeResPanel the remove reservation panel to set
     */
    public void setRemoveResPanel(ManageSubPanel removeResPanel) {
        this.removeResPanel = removeResPanel;
    }

    /**
     * Returns the remove hotel panel.
     *
     * @return the remove hotel panel
     */
    public ManageSubPanel getRemoveHotelPanel() {
        return removeHotelPanel;
    }

    /**
     * Sets the remove hotel panel.
     *
     * @param removeHotelPanel the remove hotel panel to set
     */
    public void setRemoveHotelPanel(ManageSubPanel removeHotelPanel) {
        this.removeHotelPanel = removeHotelPanel;
    }

    /**
     * Returns the confirm modification panel.
     *
     * @return the confirm modification panel
     */
    public ConfirmModPanel getConfirmModPanel() {
        return confirmModPanel;
    }

    /**
     * Sets the confirm modification panel.
     *
     * @param confirmModPanel the confirm modification panel to set
     */
    public void setConfirmModPanel(ConfirmModPanel confirmModPanel) {
        this.confirmModPanel = confirmModPanel;
    }

    /**
     * Returns the manage container panel.
     *
     * @return the manage container panel
     */
    public RoundPanel getManageContainer() {
        return manageContainer;
    }

    /**
     * Sets the manage container panel.
     *
     * @param manageContainer the manage container panel to set
     */
    public void setManageContainer(RoundPanel manageContainer) {
        this.manageContainer = manageContainer;
    }

    /**
     * Returns the new hotel name text field.
     *
     * @return the new hotel name text field
     */
    public TextFieldCustom getHotelNameTextField() {
        return newHotelNameTextField;
    }

    /**
     * Sets the new hotel name text field.
     *
     * @param newHotelNameTextField the new hotel name text field to set
     */
    public void setHotelNameTextField(TextFieldCustom newHotelNameTextField) {
        this.newHotelNameTextField = newHotelNameTextField;
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

    /**
     * Returns the new base price text field.
     *
     * @return the new base price text field
     */
    public TextFieldCustom getBasePriceTextField() {
        return newBasePriceTextField;
    }

    /**
     * Sets the new base price text field.
     *
     * @param newBasePriceTextField the new base price text field to set
     */
    public void setBasePriceTextField(TextFieldCustom newBasePriceTextField) {
        this.newBasePriceTextField = newBasePriceTextField;
    }

    /**
     * Returns the percentage text field.
     *
     * @return the percentage text field
     */
    public TextFieldCustom getPercentageTextField() {
        return percentageTextField;
    }

    /**
     * Sets the percentage text field.
     *
     * @param percentageTextField the percentage text field to set
     */
    public void setPercentageTextField(TextFieldCustom percentageTextField) {
        this.percentageTextField = percentageTextField;
    }

    /**
     * Returns the price modification input value.
     *
     * @return the price modification input value
     */
    public float getPriceModInput() {
        return percentModInput;
    }

    /**
     * Sets the price modification input value.
     *
     * @param percentModInput the price modification input value to set
     */
    public void setPriceModInput(float percentModInput) {
        this.percentModInput = percentModInput;
    }

    /**
     * Returns the date modification input value.
     *
     * @return the date modification input value
     */
    public int getDateModInput() {
        return dateModInput;
    }

    /**
     * Sets the date modification input value.
     *
     * @param dateModInput the date modification input value to set
     */
    public void setDateModInput(int dateModInput) {
        this.dateModInput = dateModInput;
    }

    /**
     * Returns the remove room input value.
     *
     * @return the remove room input value
     */
    public int getRemoveRoomInput() {
        return removeRoomInput;
    }

    /**
     * Sets the remove room input value.
     *
     * @param removeRoomInput the remove room input value to set
     */
    public void setRemoveRoomInput(int removeRoomInput) {
        this.removeRoomInput = removeRoomInput;
    }

    /**
     * Returns the remove reservation input value.
     *
     * @return the remove reservation input value
     */
    public int getRemoveResInput() {
        return removeResInput;
    }

    /**
     * Sets the remove reservation input value.
     *
     * @param removeResInput the remove reservation input value to set
     */
    public void setRemoveResInput(int removeResInput) {
        this.removeResInput = removeResInput;
    }

    /**
     * Returns the reservation view.
     *
     * @return the reservation view
     */
    public ReservationView getResView() {
        return resView;
    }

    /**
     * Sets the reservation view.
     *
     * @param resView the reservation view to set
     */
    public void setResView(ReservationView resView) {
        this.resView = resView;
    }

    /**
     * Returns the list of reservations.
     *
     * @return the list of reservations
     */
    public ArrayList<OptionButton> getReservations() {
        return reservations;
    }

    /**
     * Sets the list of reservations.
     *
     * @param reservations the list of reservations to set
     */
    public void setReservations(ArrayList<OptionButton> reservations) {
        this.reservations = reservations;
    }

    /**
     * Returns the room view.
     *
     * @return the room view
     */
    public RoomView getRoomView() {
        return roomView;
    }

    /**
     * Sets the room view.
     *
     * @param roomView the room view to set
     */
    public void setRoomView(RoomView roomView) {
        this.roomView = roomView;
    }

    /**
     * Returns the list of rooms.
     *
     * @return the list of rooms
     */
    public ArrayList<OptionButton> getRooms() {
        return rooms;
    }

    /**
     * Sets the list of rooms.
     *
     * @param rooms the list of rooms to set
     */
    public void setRooms(ArrayList<OptionButton> rooms) {
        this.rooms = rooms;
    }

    /**
     * Returns the calendar view.
     *
     * @return the calendar view
     */
    public CalendarView getCalendarView() {
        return calendarView;
    }

    /**
     * Sets the calendar view.
     *
     * @param calendarView the calendar view to set
     */
    public void setCalendarView(CalendarView calendarView) {
        this.calendarView = calendarView;
    }

    /**
     * Returns the list of days.
     *
     * @return the list of days
     */
    public ArrayList<OptionButton> getDays() {
        return days;
    }

    /**
     * Sets the list of days.
     *
     * @param days the list of days to set
     */
    public void setDays(ArrayList<OptionButton> days) {
        this.days = days;
    }
}
