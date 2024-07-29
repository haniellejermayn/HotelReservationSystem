package src.HRS.View;

//import src.HRS.Model.*;

import javax.swing.*;

import src.HRS.Model.Hotel;

import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.util.*;

public class MainFrame extends JFrame{
    
    private RoundPanel homePage;
    private RoundPanel hotelsPage;
    private RoundPanel reservationsPage;
    private RoundPanel settingsPopUp;

    private RoundPanel accountSidePanel;
    private RoundPanel fillerPanel;
    private RoundPanel reservationsPanel;
    private SidePanel sidePanel;
    private JScrollPane scrollPane;

    private JLabel reservationsNo;

    private ImageIcon logo;
    private ImageIcon logoAndName;
    private JLabel logoName;
    private JLabel hotelTitle;

    private Font customFont15;
    private Font customFont25;
    private Font customFont30;
    private Font customFont60;

    private HomePanel homePanel;
    private HotelsPanel hotelsPanel;
    private ReservationsPanel resPanel;
    private AccountPanel accountPanel;
    
    private ArrayList<SelectedHotelPanel> selectedHotelPanels;
    private SelectedHotelPanel selectedHotelPanel;
    private boolean isHotelSelected;

    private ArrayList<Hotel> hotels;
    private int nHotels;
    
    public MainFrame(ArrayList<Hotel> hotels, int nHotels){

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null); 
        this.setSize(1000, 600);
        this.getContentPane().setBackground(new Color(13, 22, 45));

        this.hotels = hotels;
        this.nHotels = nHotels;

        // * Allows for rounded components * //
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // * DEFAULT COMPONENTS * //

        logo = new ImageIcon("Icons/HRS_Logo.jpg");

        logoAndName = new ImageIcon("Icons/HRS_Logo&Name.jpg");
        logoAndName = Customization.resizeIcon(logoAndName, 150, 50);

        logoName = new JLabel();
        logoName.setIcon(logoAndName);
        logoName.setHorizontalAlignment(JLabel.CENTER);
        logoName.setVerticalAlignment(JLabel.CENTER);
        logoName.setBounds(15, 15, 150, 50);
        
        customFont15 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 15);
        customFont25 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 25);
        customFont30 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 30);
        customFont60 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 60);


        // * Default Panels * //

        ImageIcon accountIcon = new ImageIcon("Icons/AccountIcon.png");
        accountIcon = Customization.resizeIcon(accountIcon, 120, 120);
        
        RoundLabel account = new RoundLabel(new Color(27, 43, 80));
        account.setBounds(10, 20, 100, 100);
        account.setIcon(accountIcon);
        account.setText("User #462005");
        account.setForeground(Color.white);
        account.setFont(customFont15);
        account.setVerticalTextPosition(JLabel.BOTTOM);
        account.setHorizontalTextPosition(JLabel.CENTER);
        account.setIconTextGap(10);
        account.setVerticalAlignment(JLabel.CENTER);
        account.setHorizontalAlignment(JLabel.CENTER);
        
        accountSidePanel = new RoundPanel(new Color(27, 43, 80));
        accountSidePanel.setLayout(new BorderLayout());
        accountSidePanel.setBounds(775, 15, 200, 200);
        accountSidePanel.setBackground(new Color(27, 43, 80));
        accountSidePanel.add(account);
        
        RoundLabel filler1 = new RoundLabel(new Color(27, 43, 80));
        filler1.setBounds(0, 20, 200, 35);
        filler1.setText("New Features");
        filler1.setForeground(Color.white);
        filler1.setFont(customFont25);
        filler1.setVerticalAlignment(JLabel.CENTER);
        filler1.setHorizontalAlignment(JLabel.CENTER);
        
        RoundLabel filler2 = new RoundLabel(new Color(27, 43, 80));
        filler2.setBounds(0, 70, 200, 35);
        filler2.setText("Available!"); 
        filler2.setForeground(Color.white);
        filler2.setFont(customFont25);
        filler2.setVerticalAlignment(JLabel.CENTER);
        filler2.setHorizontalAlignment(JLabel.CENTER);
        
        fillerPanel = new RoundPanel(new Color(27, 43, 80));
        fillerPanel.setLayout(null);
        fillerPanel.setBounds(775, 225, 200, 120);
        fillerPanel.setBackground(new Color(27, 43, 80));
        fillerPanel.add(filler1);
        fillerPanel.add(filler2);
        //fillerPanel.add(filler3);

        int nReservations = 0;
        for(int i = 0; i < hotels.size(); i++) {
            nReservations += hotels.get(i).countReservations();
        }
        
        reservationsNo = new JLabel();
        reservationsNo.setText(String.valueOf(nReservations)); 
        reservationsNo.setFont(customFont60);
        reservationsNo.setForeground(Color.white);
        reservationsNo.setBounds(10, 40, 150, 100);
        
        JLabel reservations = new JLabel();
        reservations.setText("Reservations made");
        reservations.setFont(customFont15);
        reservations.setForeground(Color.white);
        reservations.setBounds(10, 110, 180, 50);
        
        ImageIcon resIcon = new ImageIcon("Icons/ReservationsIcon.png");
        resIcon = Customization.resizeIcon(resIcon, 40, 40);

        JLabel reservationsIcon = new JLabel();
        reservationsIcon.setIcon(resIcon);
        reservationsIcon.setBounds(150, 5, 45, 45);

        reservationsPanel = new RoundPanel(new Color(27, 43, 80));
        reservationsPanel.setLayout(null);
        reservationsPanel.setBounds(775, 355, 200, 160);
        reservationsPanel.setBackground(new Color(27, 43, 80));
        reservationsPanel.add(reservationsNo);
        reservationsPanel.add(reservations);
        reservationsPanel.add(reservationsIcon);

        sidePanel = new SidePanel(new Color(27, 43, 80));
        sidePanel.setBounds(15, 80, 65, 470);

        homePanel = new HomePanel(hotels, nHotels);
        hotelsPanel = new HotelsPanel(hotels, nHotels); 
        resPanel = new ReservationsPanel(hotels, nHotels); 
        accountPanel = new AccountPanel();
        
        selectedHotelPanels = new ArrayList<SelectedHotelPanel>();
        setIsHotelSelected(false);

        initializeSelectedHotels(hotels, nHotels);

        this.setIconImage(logo.getImage());
        this.add(logoName);
        this.add(sidePanel);
        this.add(homePanel);
        this.add(hotelsPanel);
        this.add(resPanel);
        this.add(accountPanel);
        this.add(accountSidePanel);
        this.add(fillerPanel);
        this.add(reservationsPanel);


        hotelsPanel.setVisible(false);
        resPanel.setVisible(false);
        accountPanel.setVisible(false);

        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void initializeSelectedHotels(ArrayList<Hotel> Selectedhotels, int SelectednHotels){

        for (int i = 0; i < SelectednHotels; i++){
            SelectedHotelPanel hotelTemp = new SelectedHotelPanel(Selectedhotels.get(i), i);

            /*System.out.printf("init hotel\n");
            System.out.printf("init hotel name = %s\n", hotelTemp.getHotel().getHotelName());
            System.out.printf("init hotel index = %d\n", i);
            System.out.printf("init nHotels = %d\n\n", SelectednHotels);*/

            hotelTemp.setVisible(false);
            this.selectedHotelPanels.add(hotelTemp);
        }
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
    }

    public JScrollPane getScrollPane(){
        return scrollPane;
    }

    public void setSidePane(JScrollPane scrollPane){
        this.scrollPane = scrollPane;
    }

    public RoundPanel getSideResPanel(){
        return reservationsPanel;
    }

    public void setSideResPanel(RoundPanel reservationsPanel){
        this.reservationsPanel = reservationsPanel;
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

    public boolean isHotelSelected(){
        return isHotelSelected;
    }

    public void setIsHotelSelected(boolean isHotelSelected){
        this.isHotelSelected = isHotelSelected;
    }
}
