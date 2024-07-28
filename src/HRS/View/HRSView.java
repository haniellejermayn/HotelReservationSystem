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
    //public HRSView(){
        //mainFrame = new MainFrame(hotels, nHotels);
        this.hotels = hotels;
        this.nHotels = nHotels;
    }

    public void initializeMainFrame(){
        sidePanel = mainFrame.getSidePanel();
        homePanel = mainFrame.getHomePanel();        
        hotelsPanel = mainFrame.getHotelsPanel();
        resPanel = mainFrame.getResPanel();
        accountPanel = mainFrame.getAccountPanel();

        createHotelPanel = hotelsPanel.getCreateHotelPanel();
        filterPanel = hotelsPanel.getFilterPanel();
    }

    public void initializeSelectedHotelPanel(){
        // BUG: should get actual selected hotel
        //selectedHotelPanel = new SelectedHotelPanel(hotels.get(0), 0);
        bookHotelPanel = mainFrame.getSelectedHotelPanel().getBookPanel();
        manageHotelPanel = mainFrame.getSelectedHotelPanel().getManagePanel();

        dateAvailPanel = mainFrame.getSelectedHotelPanel().getDateAvailPanel();
        roomInfoPanel = mainFrame.getSelectedHotelPanel().getRoomInfoPanel();
        resInfoPanel = mainFrame.getSelectedHotelPanel().getResInfoPanel();
    }

    public void setSidePanelListener(ActionListener listener){
        sidePanel.getHomeButton().addActionListener(listener);
        sidePanel.getHotelButton().addActionListener(listener);
        sidePanel.getReservationsButton().addActionListener(listener);
        sidePanel.getAccountButton().addActionListener(listener);
        sidePanel.getBackButton().addActionListener(listener);
    }

    public void setHotelSelectedListener(ActionListener listener) {
        if (mainFrame.getHotelsPanel().getnHotels() != 0){
            for (int i = 0; i < hotels.size(); i++){
                mainFrame.getHomePanel().getHotelCatalogue().get(i).addActionListener(listener);
                mainFrame.getHotelsPanel().getHotelCatalogue().get(i).addActionListener(listener);
            }
        }
    }

    public void setHotelsPanelListener(ActionListener listener){
        mainFrame.getHotelsPanel().getCreateHotelButton().addActionListener(listener);
        mainFrame.getHotelsPanel().getFilterButton().addActionListener(listener);
    }

    public void setCreateHotelListener(ActionListener listener){
        mainFrame.getHotelsPanel().getCreateHotelPanel().getCreateButton().addActionListener(listener);
        mainFrame.getHotelsPanel().getCreateHotelPanel().getCancelButton().addActionListener(listener);
    }

    public void setFilterPanelListener(ActionListener listener){
        filterPanel.getMostBookedButton().addActionListener(listener);
        filterPanel.getLowestPriceButton().addActionListener(listener);
        filterPanel.getHighestPriceButton().addActionListener(listener);
        filterPanel.getNewestButton().addActionListener(listener);
    }

    public void setSelectedHotelListener(ActionListener listener){
        mainFrame.getSelectedHotelPanel().getDateAvailButton().addActionListener(listener);
        mainFrame.getSelectedHotelPanel().getRoomInfoButton().addActionListener(listener);
        mainFrame.getSelectedHotelPanel().getResInfoButton().addActionListener(listener);
        mainFrame.getSelectedHotelPanel().getBookButton().addActionListener(listener);
        mainFrame.getSelectedHotelPanel().getManageButton().addActionListener(listener);
    }

    public void setBookHotelListener(ActionListener listener){
        bookHotelPanel.getBookButton().addActionListener(listener);
        bookHotelPanel.getCancelButton().addActionListener(listener);
        bookHotelPanel.getStandardRoomButton().addActionListener(listener);
        bookHotelPanel.getDeluxeRoomButton().addActionListener(listener);
        bookHotelPanel.getExecutiveRoomButton().addActionListener(listener);

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
            mainFrame.getSelectedHotelPanel().getDateAvailPanel().getCalendar().getDays().get(i).addActionListener(listener);
        }
    }

    public void setRoomInfoListener(ActionListener listener){
        for (int i = 0; i < mainFrame.getSelectedHotelPanel().getHotel().countRooms(0); i++){
            mainFrame.getSelectedHotelPanel().getRoomInfoPanel().getRoomView().getRooms().get(i).addActionListener(listener);
        }
    }

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
