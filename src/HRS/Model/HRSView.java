package src.HRS.Model;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JScrollPane;

import src.HRS.View.AccountPanel;
import src.HRS.View.CreateHotelPanel;
import src.HRS.View.FilterPanel;
import src.HRS.View.HomePanel;
import src.HRS.View.HotelItem;
import src.HRS.View.HotelOption;
import src.HRS.View.HotelsPanel;
import src.HRS.View.IconButton;
import src.HRS.View.MainFrame;
import src.HRS.View.ReservationsPanel;
import src.HRS.View.SelectedHotelPanel;
import src.HRS.View.SidePanel;

public class HRSView {
    
    private MainFrame mainFrame;
    private int nHotels;

    private SidePanel sidePanel;
    private JScrollPane scrollPane;
    private HomePanel homePanel;
    private HotelsPanel hotelsPanel;
    private ReservationsPanel resPanel;
    private AccountPanel accountPanel;
    
    // * Side Panel * //
    private IconButton homeButton;
    private IconButton hotelButton;
    private IconButton resButton;
    private IconButton accountButton;
    private IconButton backButton;

    // * Home Panel * //
    private ArrayList<HotelItem> hotelCatalogue;

    // * Selected Hotel Panel * //
    private ArrayList<SelectedHotelPanel> selectedHotelPanels;
    
    // * Hotel Panel * //
    private ArrayList<HotelOption> hotelOptions;
    private IconButton createHotelButton;
    private CreateHotelPanel createHotelPanel;
    private IconButton filterButton;
    private FilterPanel filterPanel; 
    
    public HRSView(ArrayList<Hotel> hotels, int nHotels){
        mainFrame = new MainFrame(hotels, nHotels);
        this.nHotels = nHotels;

        homeButton = mainFrame.getSidePanel().getHomeButton();
        homePanel = mainFrame.getHomePanel();
        hotelCatalogue = homePanel.getHotelCatalogue();
        
        hotelButton = mainFrame.getSidePanel().getHotelButton();
        hotelsPanel = mainFrame.getHotelsPanel();
        hotelOptions = hotelsPanel.getHotelCatalogue();
        createHotelButton = hotelsPanel.getCreateHotelButton();
        filterButton = hotelsPanel.getFilterButton();
        filterPanel = hotelsPanel.getFilterPanel();

        resButton = mainFrame.getSidePanel().getReservationsButton();
        resPanel = mainFrame.getResPanel();

        accountButton = mainFrame.getSidePanel().getAccountButton();
        accountPanel = mainFrame.getAccountPanel();

        backButton = sidePanel.getBackButton();
    }

    public void setSidePanelListener(ActionListener listener){
        homeButton.addActionListener(listener);
        hotelButton.addActionListener(listener);
        resButton.addActionListener(listener);
        accountButton.addActionListener(listener);
        backButton.addActionListener(listener);
    }

    public void setHotelSelectedListener(ActionListener listener) {
        for (int i = 0; i < nHotels; i++){
            hotelCatalogue.get(i).addActionListener(listener);
            hotelOptions.get(i).addActionListener(listener);
        }
    }

    public void setHotelsPanelListener(Actionlistener listener){
        createHotelButton.addActionListener(listener);
        filterButton.addActionListener(listener);
    }


    /*for (int i = 0; i < model.countHotels(); i++){
        String hotel = model.getHotels().get(i).getHotelName(); 

        if (hotelName.equals(hotel)){
            SelectedHotelPanel selectedHotel = view.getSelectedHotelPanels().get(i);
            selectedHotel.setVisible(true);
            view.getHomePanel().setVisible(false);
            view.getHotelsPanel().setVisible(false);
            view.getMainFrame().add(selectedHotel);
        }
        else {
            view.getSelectedHotelPanels().get(i).setVisible(false);
        }
    }*/

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

    public JScrollPane getScrollPane(){
        return scrollPane;
    }

    public void setSidePane(JScrollPane scrollPane){
        this.scrollPane = scrollPane;
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

    public IconButton getHomeButton(){
        return homeButton;
    }

    public void setHomeButton(IconButton homeButton){
        this.homeButton = homeButton;
    }

    public IconButton getHotelButton(){
        return hotelButton;
    }

    public void setHotelButton(IconButton hotelButton){
        this.hotelButton = hotelButton;
    }

    public IconButton getResButton(){
        return resButton;
    }

    public void setResButton(IconButton resButton){
        this.resButton = resButton;
    }

    public IconButton getAccountButton(){
        return accountButton;
    }

    public void setAccountButton(IconButton accountButton){
        this.accountButton = accountButton;
    }

    public IconButton getBackButton(){
        return backButton;
    }

    public void setBackButton(IconButton backButton){
        this.backButton = backButton;
    }

    public ArrayList<HotelItem> getHotelCatalogue(){
        return hotelCatalogue;
    }

    public void setHotelCatalogue(ArrayList<HotelItem> hotelCatalogue){
        this.hotelCatalogue = hotelCatalogue;
    }

    public ArrayList<HotelOption> getHotelOptions(){
        return hotelOptions;
    }

    public void setHotelOptions(ArrayList<HotelOption> hotelOptions){
        this.hotelOptions = hotelOptions;
    }

    public ArrayList<SelectedHotelPanel> getSelectedHotelPanels(){
        return selectedHotelPanels;
    }

    public void setselectedHotelPanels(ArrayList<SelectedHotelPanel> selectedHotelPanels){
        this.selectedHotelPanels = selectedHotelPanels;
    }

    public IconButton getCreateHotelButton(){
        return createHotelButton;
    }

    public void setCreateHotelButton(IconButton createHotelButton){
        this.createHotelButton = createHotelButton;
    }

    public IconButton getFilterButton(){
        return filterButton;
    }

    public void setFilterButton(IconButton filterButton){
        this.filterButton = filterButton;
    }

    public FilterPanel getFilterPanel(){
        return filterPanel;
    }

    public void setFilterPanel(FilterPanel filterPanel){
        this.filterPanel = filterPanel;
    }

    public CreateHotelPanel getCreateHotelPanel(){
        return createHotelPanel;
    }

    public void setCreateHotelPanel(CreateHotelPanel createHotelPanel){
        this.createHotelPanel = createHotelPanel;
    }
}
