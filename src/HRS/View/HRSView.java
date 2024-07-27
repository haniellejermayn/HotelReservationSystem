package src.HRS.View;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import src.HRS.Model.Hotel;


public class HRSView {
    
    private MainFrame mainFrame;
    private ArrayList<Hotel> hotels;

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

    
    //public HRSView(ArrayList<Hotel> hotels, int nHotels){
    public HRSView(){
        //mainFrame = new MainFrame(hotels, nHotels);
        //hotels = hotels;

        sidePanel = mainFrame.getSidePanel();
        homePanel = mainFrame.getHomePanel();        
        hotelsPanel = mainFrame.getHotelsPanel();
        resPanel = mainFrame.getResPanel();
        accountPanel = mainFrame.getAccountPanel();

        createHotelPanel = hotelsPanel.getCreateHotelPanel();
        filterPanel = hotelsPanel.getFilterPanel();

        bookHotelPanel = selectedHotelPanel.getBookPanel();
        manageHotelPanel = selectedHotelPanel.getManagePanel();

        dateAvailPanel = selectedHotelPanel.getDateAvailPanel();
        roomInfoPanel = selectedHotelPanel.getRoomInfoPanel();
        resInfoPanel = selectedHotelPanel.getResInfoPanel();

    }

    public void setSidePanelListener(ActionListener listener){
        sidePanel.getHomeButton().addActionListener(listener);
        sidePanel.getHotelButton().addActionListener(listener);
        sidePanel.getReservationsButton().addActionListener(listener);
        sidePanel.getAccountButton().addActionListener(listener);
        sidePanel.getBackButton().addActionListener(listener);
    }

    public void setHotelSelectedListener(ActionListener listener) {
        for (int i = 0; i < hotels.size(); i++){
            mainFrame.getHomePanel().getHotelCatalogue().get(i).addActionListener(listener);
            mainFrame.getHotelsPanel().getHotelCatalogue().get(i).addActionListener(listener);
        }
    }

    public void setHotelsPanelListener(ActionListener listener){
        hotelsPanel.getCreateHotelButton().addActionListener(listener);
        hotelsPanel.getFilterButton().addActionListener(listener);
    }

    public void setCreateHotelListener(ActionListener listener){
        createHotelPanel.getCreateButton().addActionListener(listener);
        createHotelPanel.getCancelButton().addActionListener(listener);
    }

    public void setFilterPanelListener(ActionListener listener){
        filterPanel.getMostBookedButton().addActionListener(listener);
        filterPanel.getLowestPriceButton().addActionListener(listener);
        filterPanel.getHighestPriceButton().addActionListener(listener);
        filterPanel.getNewestButton().addActionListener(listener);
    }

    public void setSelectedHotelListener(ActionListener listener){
        selectedHotelPanel.getDateAvailButton().addActionListener(listener);
        selectedHotelPanel.getRoomInfoButton().addActionListener(listener);
        selectedHotelPanel.getResInfoButton().addActionListener(listener);
        selectedHotelPanel.getBookButton().addActionListener(listener);
        selectedHotelPanel.getManageButton().addActionListener(listener);
    }

    public void setBookHotelListener(ActionListener listener){
        bookHotelPanel.getBookButton().addActionListener(listener);
        bookHotelPanel.getCancelButton().addActionListener(listener);
        bookHotelPanel.getStandardRoomInput().addActionListener(listener);
        bookHotelPanel.getDeluxeRoomInput().addActionListener(listener);
        bookHotelPanel.getExecutiveRoomInput().addActionListener(listener);

        for (int i = 0; i < 31; i++){
            bookHotelPanel.getDays().get(i).addActionListener(listener);
        }
    }

    public void setManageHotelListener(ActionListener listener){
        manageHotelPanel.getChangeNameButton().addActionListener(listener);
        manageHotelPanel.getAddRoomButton().addActionListener(listener);
        manageHotelPanel.getUpdateBasePriceButton().addActionListener(listener);
        manageHotelPanel.getDatePriceModifierButton().addActionListener(listener);
        manageHotelPanel.getRemoveRoomButton().addActionListener(listener);
        manageHotelPanel.getRemoveResButton().addActionListener(listener);
        manageHotelPanel.getRemoveHotelButton().addActionListener(listener);
    }

    public void setManageSubPanelListener(ActionListener listener){
        manageHotelPanel.getChangeNamePanel().getUpdateButton().addActionListener(listener);
        manageHotelPanel.getAddRoomPanel().getUpdateButton().addActionListener(listener);
        manageHotelPanel.getUpdateBasePricePanel().getUpdateButton().addActionListener(listener);
        manageHotelPanel.getDatePriceModifierPanel().getUpdateButton().addActionListener(listener);
        manageHotelPanel.getRemoveRoomPanel().getUpdateButton().addActionListener(listener);
        manageHotelPanel.getRemoveResPanel().getUpdateButton().addActionListener(listener);
        manageHotelPanel.getRemoveHotelPanel().getUpdateButton().addActionListener(listener);

        manageHotelPanel.getChangeNamePanel().getCancelButton().addActionListener(listener);
        manageHotelPanel.getAddRoomPanel().getCancelButton().addActionListener(listener);
        manageHotelPanel.getUpdateBasePricePanel().getCancelButton().addActionListener(listener);
        manageHotelPanel.getDatePriceModifierPanel().getCancelButton().addActionListener(listener);
        manageHotelPanel.getRemoveRoomPanel().getCancelButton().addActionListener(listener);
        manageHotelPanel.getRemoveResPanel().getCancelButton().addActionListener(listener);
        manageHotelPanel.getRemoveHotelPanel().getCancelButton().addActionListener(listener);
    }

    public void setConfirmModListener(ActionListener listener){
        manageHotelPanel.getConfirmModPanel().getYesButton().addActionListener(listener);
        manageHotelPanel.getConfirmModPanel().getNoButton().addActionListener(listener);
        manageHotelPanel.getConfirmModPanel().getCancelButton().addActionListener(listener);
    }

    public void setDateAvailabilityListener(ActionListener listener){
        for (int i = 0; i < 31; i++){
            dateAvailPanel.getCalendar().getDays().get(i).addActionListener(listener);
        }
    }

    public void setRoomInfoListener(ActionListener listener){
        for (int i = 0; i < selectedHotelPanel.getHotel().countRooms(0); i++){
            roomInfoPanel.getRoomView().getRooms().get(i).addActionListener(listener);
        }
    }

    public void setResInfoListener(ActionListener listener){
        for (int i = 0; i < selectedHotelPanel.getHotel().countReservations(); i++){
            resInfoPanel.getResView().getReservations().get(i).addActionListener(listener);
        }
    }

    public MainFrame getMainFrame(){
        return mainFrame;
    }

    public void setMainFrame(MainFrame mainFrame){
        this.mainFrame = mainFrame;
    }

    public SidePanel getSidePanel(){
        return sidePanel;
    }

    public void setSidePanel(SidePanel sidePanel){
        this.sidePanel = sidePanel;
    }

    public HomePanel getHomePanel(){
        return homePanel;
    }

    public void setHomePanel(HomePanel homePanel){
        this.homePanel = homePanel;
    }

    public HotelsPanel getHotelsPanel(){
        return hotelsPanel;
    }

    public void setHotelsPanel(HotelsPanel hotelsPanel){
        this.hotelsPanel = hotelsPanel;
    }

    public ReservationsPanel getResPanel(){
        return resPanel;
    }

    public void setResPanel(ReservationsPanel resPanel){
        this.resPanel = resPanel;
    }

    public AccountPanel getAccountPanel(){
        return accountPanel;
    }

    public void setAccountPanel(AccountPanel accountPanel){
        this.accountPanel = accountPanel;
    }

    public ArrayList<SelectedHotelPanel> getSelectedHotelPanels(){
        return selectedHotelPanels;
    }

    public void setselectedHotelPanels(ArrayList<SelectedHotelPanel> selectedHotelPanels){
        this.selectedHotelPanels = selectedHotelPanels;
    }

    public SelectedHotelPanel getSelectedHotelPanel(){
        return selectedHotelPanel;
    }

    public void setSelectedHotelPanel(SelectedHotelPanel selectedHotelPanel){
        this.selectedHotelPanel = selectedHotelPanel;
    }

    public CreateHotelPanel getCreateHotelPanel(){
        return createHotelPanel;
    }

    public void setCreateHotelPanel(CreateHotelPanel createHotelPanel){
        this.createHotelPanel = createHotelPanel;
    }

    public FilterPanel getFilterPanel(){
        return filterPanel;
    }

    public void setFilterPanel(FilterPanel filterPanel){
        this.filterPanel = filterPanel;
    }

    public BookHotelPanel getBookHotelPanel(){
        return bookHotelPanel;
    }

    public void setBookHotelPanel(BookHotelPanel bookHotelPanel){
        this.bookHotelPanel = bookHotelPanel;
    }

    public ManagePanel getManageHotelPanel(){
        return manageHotelPanel;
    }

    public void setManageHotelPanel(ManagePanel manageHotelPanel){
        this.manageHotelPanel = manageHotelPanel;
    }

}
