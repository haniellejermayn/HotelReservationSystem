package src.HRS.View;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import src.HRS.Model.Hotel;


public class HRSView {
    
    private MainFrame mainFrame;
    private ArrayList<Hotel> hotels;
    private int nHotels;

    // * MainFrame * //
    private SidePanel sidePanel;
    private HomePanel homePanel;
    private HotelsPanel hotelsPanel;
    private ReservationsPanel resPanel;
    private AccountPanel accountPanel;
    
    // * Hotel Panel * //
    private CreateHotelPanel createHotelPanel;
    private FilterPanel filterPanel; 
    
    // * Selected Hotel Panel * //
    private ArrayList<SelectedHotelPanel> selectedHotelPanels;
    private SelectedHotelPanel selectedHotelPanel;
    private BookHotelPanel bookHotelPanel;
    private ManagePanel manageHotelPanel;
    private DateAvailPanel dateAvailPanel;
    private RoomInfoPanel roomInfoPanel;
    private ResInfoPanel resInfoPanel;

    
    public HRSView(ArrayList<Hotel> hotels, int nHotels){

        this.hotels = hotels;
        this.nHotels = nHotels;
    }

    /*
    * Initializes the main frame by setting up various panels.
    * This method retrieves and assigns the different panels from the
    * mainFrame  to the corresponding member variables.
    * This setup is essential for organizing the main frame's UI components and
    * preparing them for interaction and display.
    */
    public void initializeMainFrame(){
        sidePanel = mainFrame.getSidePanel();
        homePanel = mainFrame.getHomePanel();        
        hotelsPanel = mainFrame.getHotelsPanel();
        resPanel = mainFrame.getResPanel();
        accountPanel = mainFrame.getAccountPanel();
        createHotelPanel = hotelsPanel.getCreateHotelPanel();
        filterPanel = hotelsPanel.getFilterPanel();
    }

    /*
    * Initializes the panels associated with the selected hotel.
    * This method retrieves and assigns various panels from the
    * selectedHotelPanel obtained from mainFrame.
    * This setup is crucial for providing detailed interaction options and information
    * for the selected hotel.
    */
    public void initializeSelectedHotelPanel(){
        bookHotelPanel = mainFrame.getSelectedHotelPanel().getBookPanel();
        manageHotelPanel = mainFrame.getSelectedHotelPanel().getManagePanel();
        dateAvailPanel = mainFrame.getSelectedHotelPanel().getDateAvailPanel();
        roomInfoPanel = mainFrame.getSelectedHotelPanel().getRoomInfoPanel();
        resInfoPanel = mainFrame.getSelectedHotelPanel().getResInfoPanel();
    }

    /**
    * Sets the action listener for all buttons in the side panel of the main frame.
    * This method assigns the provided listener to handle action events for the buttons
    * located in the side panel of mainFrame.
    * This setup allows the side panel buttons to respond to user actions by invoking
    * the specified listener.
    *
    * @param listener the action listener to be added to the buttons
    */
    public void setSidePanelListener(ActionListener listener){
        mainFrame.getSidePanel().getHomeButton().addActionListener(listener);
        mainFrame.getSidePanel().getHotelButton().addActionListener(listener);
        mainFrame.getSidePanel().getReservationsButton().addActionListener(listener);
        mainFrame.getSidePanel().getAccountButton().addActionListener(listener);
        mainFrame.getSidePanel().getBackButton().addActionListener(listener);
    }

    /**
     * Sets the action listener for all hotel selection buttons in the hotel catalog.
     * This method assigns the provided listener to handle action events for the hotel selection
     * buttons in both the home panel and hotels panel of the  mainFrame.
     * Checks if there are any hotels in the catalog (i.e., getnHotels() returns a value greater than 0).
     * Iterates through each hotel button in the catalog and adds the listener to handle actions for each button.
     * This setup allows user interactions with the hotel selection buttons to be processed by the specified listener.
     *
     * @param listener the action listener to be added to the hotel selection buttons
     */
    public void setHotelSelectedListener(ActionListener listener) {
        if (mainFrame.getHotelsPanel().getnHotels() != 0){
            for (int i = 0; i < mainFrame.getHotelsPanel().getnHotels(); i++){
                mainFrame.getHomePanel().getHotelCatalogue().get(i).addActionListener(listener);
                mainFrame.getHotelsPanel().getHotelCatalogue().get(i).addActionListener(listener);
            }
        }
    }

    /**
     * Sets the action listener for the buttons in the hotels panel.
     * This method assigns the provided listener to handle action events for the buttons
     * in the hotels panel of mainFrame.
     * This setup allows user interactions with these buttons to be processed by the specified listener.
     *
     * @param listener the action listener to be added to the buttons
     */
    public void setHotelsPanelListener(ActionListener listener){
        mainFrame.getHotelsPanel().getCreateHotelButton().addActionListener(listener);
        mainFrame.getHotelsPanel().getFilterButton().addActionListener(listener);
    }

    /**
     * Sets the action listener for the buttons in the create hotel panel.
     * This method assigns the provided listener to handle action events for the buttons
     * in the create hotel panel of the hotels panel in mainFrame.
     * This setup allows user interactions with these buttons to be processed by the specified listener.
     *
     * @param listener the action listener to be added to the buttons
     */
    public void setCreateHotelListener(ActionListener listener){
        mainFrame.getHotelsPanel().getCreateHotelPanel().getCreateButton().addActionListener(listener);
        mainFrame.getHotelsPanel().getCreateHotelPanel().getCancelButton().addActionListener(listener);
    }

    /**
     * Sets the action listener for the buttons in the filter panel.
     * This method assigns the provided listener to handle action events for the filter
     * buttons in the filter panel of the hotels panel in mainFrame.
     * This setup allows user interactions with these filter buttons to be processed by the specified listener.
     *
     * @param listener the action listener to be added to the buttons
     */
    public void setFilterPanelListener(ActionListener listener){
        mainFrame.getHotelsPanel().getFilterPanel().getMostBookedButton().addActionListener(listener);
        mainFrame.getHotelsPanel().getFilterPanel().getLowestPriceButton().addActionListener(listener);
        mainFrame.getHotelsPanel().getFilterPanel().getHighestPriceButton().addActionListener(listener);
        mainFrame.getHotelsPanel().getFilterPanel().getNewestButton().addActionListener(listener);
    }

    /**
    * Sets the action listener for the buttons in the selected hotel panel.
    * This method assigns the provided listener to handle action events for the buttons
    * in the selected hotel panel of mainFrame.
    * This setup allows user interactions with these buttons to be processed by the specified listener.
    *
    * @param listener the action listener to be added to the buttons
    */
    public void setSelectedHotelListener(ActionListener listener){
        mainFrame.getSelectedHotelPanel().getDateAvailButton().addActionListener(listener);
        mainFrame.getSelectedHotelPanel().getRoomInfoButton().addActionListener(listener);
        mainFrame.getSelectedHotelPanel().getResInfoButton().addActionListener(listener);
        mainFrame.getSelectedHotelPanel().getBookButton().addActionListener(listener);
        mainFrame.getSelectedHotelPanel().getManageButton().addActionListener(listener);
    }

    /**
    * Sets the action listener for the booking-related components in the book panel of the selected hotel.
    * This method assigns the provided listener to handle action events for the components
    * in the book panel of the selected hotel panel in mainFrame.
    * Additionally, this method assigns the listener to each of the 31 day buttons in the book panel
    * to handle day selection events.
    * This setup allows user interactions with these booking components to be processed by the specified listener.
    *
    * @param listener the action listener to be added to the booking-related components
    */
    public void setBookHotelListener(ActionListener listener){
        mainFrame.getSelectedHotelPanel().getBookPanel().getBookButton().addActionListener(listener);
        mainFrame.getSelectedHotelPanel().getBookPanel().getCancelButton().addActionListener(listener);
        mainFrame.getSelectedHotelPanel().getBookPanel().getStandardRoomButton().addActionListener(listener);
        mainFrame.getSelectedHotelPanel().getBookPanel().getDeluxeRoomButton().addActionListener(listener);
        mainFrame.getSelectedHotelPanel().getBookPanel().getExecutiveRoomButton().addActionListener(listener);

        for (int i = 0; i < 31; i++){
            mainFrame.getSelectedHotelPanel().getBookPanel().getDays().get(i).addActionListener(listener);
        }
    }

    /**
    * Sets the action listener for the management-related buttons in the manage panel of the selected hotel.
    * This method assigns the provided listener to handle action events for the buttons
    * in the manage panel of the selected hotel panel in mainFrame.
    * This setup allows user interactions with these management buttons to be processed by the specified listener.
    *
    * @param listener the action listener to be added to the management-related buttons
    */
    public void setManageHotelListener(ActionListener listener){
        ManagePanel manageHotelPanel = mainFrame.getSelectedHotelPanel().getManagePanel();
        manageHotelPanel.getChangeNameButton().addActionListener(listener);
        manageHotelPanel.getAddRoomButton().addActionListener(listener);
        manageHotelPanel.getUpdateBasePriceButton().addActionListener(listener);
        manageHotelPanel.getDatePriceModifierButton().addActionListener(listener);
        manageHotelPanel.getRemoveRoomButton().addActionListener(listener);
        manageHotelPanel.getRemoveResButton().addActionListener(listener);
        manageHotelPanel.getRemoveHotelButton().addActionListener(listener);
    }

    /**
    * Sets the action listener for the buttons in various sub-panels of the manage panel
    * in the selected hotel panel.
    * This method assigns the provided listener to handle action events for the buttons
    * across multiple sub-panels within the manage panel of the selected hotel in mainFrame.
    * This setup allows user interactions with these management sub-panel components to be processed by the specified listener.
    *
    * @param listener the action listener to be added to the sub-panel buttons
    */
    public void setManageSubPanelListener(ActionListener listener){
        ManagePanel manageHotelPanel = mainFrame.getSelectedHotelPanel().getManagePanel();
        
        // Add listener to update buttons
        manageHotelPanel.getChangeNamePanel().getUpdateButton().addActionListener(listener);
        manageHotelPanel.getAddRoomPanel().getUpdateButton().addActionListener(listener);
        manageHotelPanel.getUpdateBasePricePanel().getUpdateButton().addActionListener(listener);
        manageHotelPanel.getDatePriceModifierPanel().getUpdateButton().addActionListener(listener);
        manageHotelPanel.getRemoveRoomPanel().getUpdateButton().addActionListener(listener);
        manageHotelPanel.getRemoveResPanel().getUpdateButton().addActionListener(listener);
        manageHotelPanel.getRemoveHotelPanel().getUpdateButton().addActionListener(listener);

        // Add listener to cancel buttons
        manageHotelPanel.getChangeNamePanel().getCancelButton().addActionListener(listener);
        manageHotelPanel.getAddRoomPanel().getCancelButton().addActionListener(listener);
        manageHotelPanel.getUpdateBasePricePanel().getCancelButton().addActionListener(listener);
        manageHotelPanel.getDatePriceModifierPanel().getCancelButton().addActionListener(listener);
        manageHotelPanel.getRemoveRoomPanel().getCancelButton().addActionListener(listener);
        manageHotelPanel.getRemoveResPanel().getCancelButton().addActionListener(listener);
        manageHotelPanel.getRemoveHotelPanel().getCancelButton().addActionListener(listener);

        // Add listener to option buttons in calendar, room, and reservation views
        ArrayList<OptionButton> days = manageHotelPanel.getCalendarView().getDays();
        for (int i = 0; i < days.size(); i++){
            days.get(i).addActionListener(listener);
        }

        ArrayList<OptionButton> rooms = manageHotelPanel.getRoomView().getRooms();
        for (int i = 0; i < rooms.size(); i++){
            rooms.get(i).addActionListener(listener);
        }

        ArrayList<OptionButton> reservations = manageHotelPanel.getResView().getReservations();
        for (int i = 0; i < reservations.size(); i++){
            reservations.get(i).addActionListener(listener);
        }
    }

    /**
    * Sets the action listener for the confirmation modification panel in the manage panel of the selected hotel.
    * This method assigns the provided listener to handle action events for the buttons
    * in the confirmation modification panel of the manage panel in mainFrame.
    * This setup allows user interactions with these confirmation buttons to be processed by the specified listener.
    *
    * @param listener the action listener to be added to the confirmation buttons
    */
    public void setConfirmModListener(ActionListener listener){
        ManagePanel manageHotelPanel = mainFrame.getSelectedHotelPanel().getManagePanel();
        manageHotelPanel.getConfirmModPanel().getYesButton().addActionListener(listener);
        manageHotelPanel.getConfirmModPanel().getNoButton().addActionListener(listener);
        manageHotelPanel.getConfirmModPanel().getCancelButton().addActionListener(listener);
    }

    /**
    * Sets the action listener for the day buttons in the date availability panel.
    * This method assigns the provided listener to handle action events for the day buttons
    * in the calendar of the date availability panel in the selected hotel panel of mainFrame.
    * The panel contains 31 day buttons, one for each day in a typical month.
    * 
    * @param listener the action listener to be added to the day buttons in the date availability panel
    */
    public void setDateAvailabilityListener(ActionListener listener){

        for (int i = 0; i < 31; i++){
            mainFrame.getSelectedHotelPanel().getDateAvailPanel().getCalendar().getDays().get(i).addActionListener(listener);
        }
    }

    /**
    * Sets the action listener for the room buttons in the room information panel.
    * This method assigns the provided listener to handle action events for the room buttons
    * in the room view of the room information panel in the selected hotel panel of mainFrame.
    * The number of room buttons is determined by the count of rooms returned by countRooms().
    * 
    * @param listener the action listener to be added to the room buttons in the room information panel
    */
    public void setRoomInfoListener(ActionListener listener){
        for (int i = 0; i < mainFrame.getSelectedHotelPanel().getHotel().countRooms(0); i++){
            mainFrame.getSelectedHotelPanel().getRoomInfoPanel().getRoomView().getRooms().get(i).addActionListener(listener);
        }
    }

    /**
    * Sets the action listener for the reservation buttons in the reservation information panel.
    * This method assigns the provided listener to handle action events for the reservation buttons
    * in the reservation view of the reservation information panel in the selected hotel panel of mainFrame.
    * The number of reservation buttons is determined by the count of reservations returned by countReservations().
    * 
    * @param listener the action listener to be added to the reservation buttons in the reservation information panel
    */
    public void setResInfoListener(ActionListener listener){
        for (int i = 0; i < mainFrame.getSelectedHotelPanel().getHotel().countReservations(); i++){
            mainFrame.getSelectedHotelPanel().getResInfoPanel().getResView().getReservations().get(i).addActionListener(listener);
        }
    }

    public MainFrame getMainFrame(){
        return mainFrame;
    }

    public void setMainFrame(MainFrame mainFrame){
        this.mainFrame = mainFrame;
        initializeMainFrame();
    }

    public ArrayList<Hotel> getHotels(){
        return hotels;
    }

    public void setHotels(ArrayList<Hotel> hotels){
        this.hotels = hotels;
    }

    public int getnHotels(){
        return nHotels;
    }

    public void setnHotels(int nHotels){
        this.nHotels = nHotels;
    }

    public SidePanel getSidePanel(){
        return sidePanel;
        
    }

    public void setSidePanel(SidePanel sidePanel){
        this.sidePanel = sidePanel;
        mainFrame.setSidePanel(sidePanel);
    }

    public HomePanel getHomePanel(){
        return homePanel;
    }

    public void setHomePanel(HomePanel homePanel){
        this.homePanel = homePanel;
        mainFrame.setHomePanel(homePanel);
    }

    public HotelsPanel getHotelsPanel(){
        return hotelsPanel;
    }

    public void setHotelsPanel(HotelsPanel hotelsPanel){
        this.hotelsPanel = hotelsPanel;
        mainFrame.setHotelsPanel(hotelsPanel);
    }

    public ReservationsPanel getResPanel(){
        return resPanel;
    }

    public void setResPanel(ReservationsPanel resPanel){
        this.resPanel = resPanel;
        mainFrame.setResPanel(resPanel);
    }

    public AccountPanel getAccountPanel(){
        return accountPanel;
    }

    public void setAccountPanel(AccountPanel accountPanel){
        this.accountPanel = accountPanel;
        mainFrame.setAccountPanel(accountPanel);
    }

    public ArrayList<SelectedHotelPanel> getSelectedHotelPanels(){
        return selectedHotelPanels;
    }

    public void setselectedHotelPanels(ArrayList<SelectedHotelPanel> selectedHotelPanels){
        this.selectedHotelPanels = selectedHotelPanels;
        mainFrame.setselectedHotelPanels(selectedHotelPanels);
    }

    public SelectedHotelPanel getSelectedHotelPanel(){
        return selectedHotelPanel;
    }

    public void setSelectedHotelPanel(SelectedHotelPanel selectedHotelPanel){
        this.selectedHotelPanel = selectedHotelPanel;
        mainFrame.setSelectedHotelPanel(selectedHotelPanel);
        initializeSelectedHotelPanel();
    }

    public DateAvailPanel getDateAvailPanel(){
        return dateAvailPanel;
    }

    public void setDateAvailPanel(DateAvailPanel dateAvailPanel){
        this.dateAvailPanel = dateAvailPanel;
    }

    public RoomInfoPanel getRoomInfoPanel(){
        return roomInfoPanel;
    }

    public void setRoomInfoPanel(RoomInfoPanel roomInfoPanel){
        this.roomInfoPanel = roomInfoPanel;
    }

    public  ResInfoPanel getResInfoPanel(){
        return resInfoPanel;
    }

    public void setResInfoPanel(ResInfoPanel resInfoPanel){
        this.resInfoPanel = resInfoPanel;
    }

    public CreateHotelPanel getCreateHotelPanel(){
        return createHotelPanel;
    }

    public void setCreateHotelPanel(CreateHotelPanel createHotelPanel){
        this.createHotelPanel = createHotelPanel;
        hotelsPanel.setCreateHotelPanel(createHotelPanel);
    }

    public FilterPanel getFilterPanel(){
        return filterPanel;
    }

    public void setFilterPanel(FilterPanel filterPanel){
        this.filterPanel = filterPanel;
        hotelsPanel.setFilterPanel(filterPanel);
    }

    public BookHotelPanel getBookHotelPanel(){
        return bookHotelPanel;
    }

    public void setBookHotelPanel(BookHotelPanel bookHotelPanel){
        this.bookHotelPanel = bookHotelPanel;
        selectedHotelPanel.setBookPanel(bookHotelPanel);
    }

    public ManagePanel getManageHotelPanel(){
        return manageHotelPanel;
    }

    public void setManageHotelPanel(ManagePanel manageHotelPanel){
        this.manageHotelPanel = manageHotelPanel;
        selectedHotelPanel.setManagePanel(manageHotelPanel);
    }

}
