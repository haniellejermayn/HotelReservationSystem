package src.HRS.View;

import javax.swing.*;
import src.HRS.Model.Hotel;
import java.awt.*;
import java.util.*;

/**
 * The {@code MainFrame} class represents the main window of the Hotel Reservation System (HRS) application.
 * <p>
 * This class sets up and manages the primary user interface components of the application, including panels for home,
 * hotels, reservations, and account information. It also handles the display and organization of various elements
 * within the main frame of the application.
 * </p>
 */
public class MainFrame extends JFrame{

    private RoundPanel accountSidePanel;
    private RoundPanel fillerPanel;
    private RoundPanel reservationsPanel;
    private SidePanel sidePanel;
    private JScrollPane scrollPane;

    private JLabel reservationsNo;

    private ImageIcon logo;
    private ImageIcon logoAndName;
    private JLabel logoName;

    private Font customFont15;
    private Font customFont25;
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
    
    /**
     * Constructs a {@code MainFrame} with the specified list of hotels and the number of hotels.
     * <p>
     * This constructor sets up the main application window with various user interface components including panels
     * for home, hotels, reservations, and account information. It also initializes and configures these components,
     * sets their layouts, and adds them to the frame.
     * </p>
     *
     * @param hotels  an {@code ArrayList} of {@link Hotel} objects representing the hotels to be managed by this frame
     * @param nHotels an {@code int} representing the number of hotels
     */
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

    /**
     * Initializes the list of selected hotel panels with the given hotels and number of hotels.
     * <p>
     * This method creates a new {@link SelectedHotelPanel} for each hotel in the provided list of hotels.
     * Each panel is initialized with its corresponding hotel and index. The visibility of each panel is
     * set to {@code false}, and then each panel is added to the {@code selectedHotelPanels} list.
     * </p>
     *
     * @param Selectedhotels an {@code ArrayList} of {@link Hotel} objects representing the hotels for which
     *                       the selected hotel panels are to be created
     * @param SelectednHotels an {@code int} representing the number of hotels in the {@code Selectedhotels} list
     */
    public void initializeSelectedHotels(ArrayList<Hotel> Selectedhotels, int SelectednHotels){

        for (int i = 0; i < SelectednHotels; i++){
            SelectedHotelPanel hotelTemp = new SelectedHotelPanel(Selectedhotels.get(i), i);
            hotelTemp.setVisible(false);
            this.selectedHotelPanels.add(hotelTemp);
        }
    }

    /**
     * Returns the list of hotels.
     *
     * @return an {@code ArrayList} of {@link Hotel} objects
     */
    public ArrayList<Hotel> getHotels(){
        return hotels;
    }

    /**
     * Sets the list of hotels.
     *
     * @param hotels an {@code ArrayList} of {@link Hotel} objects to set
     */
    public void setHotels(ArrayList<Hotel> hotels){
        this.hotels = hotels;
    }

    /**
     * Returns the number of hotels.
     *
     * @return an {@code int} representing the number of hotels
     */
    public int getnHotels(){
        return nHotels;
    }

    /**
     * Sets the number of hotels.
     *
     * @param nHotels an {@code int} representing the number of hotels to set
     */
    public void setnHotels(int nHotels){
        this.nHotels = nHotels;
    }

    /**
     * Returns the side panel of the main frame.
     *
     * @return the {@link SidePanel} object representing the side panel
     */
    public SidePanel getSidePanel(){
        return sidePanel;
    }

    /**
     * Sets the side panel of the main frame.
     *
     * @param sidePanel a {@link SidePanel} object to set as the side panel
     */
    public void setSidePanel(SidePanel sidePanel){
        this.sidePanel = sidePanel;
    }

    /**
     * Returns the scroll pane of the main frame.
     *
     * @return the {@link JScrollPane} object representing the scroll pane
     */
    public JScrollPane getScrollPane(){
        return scrollPane;
    }

    /**
     * Sets the side panel of the main frame.
     *
     * @param sidePanel a {@link SidePanel} object to set as the side panel
     */
    public void setSidePane(JScrollPane scrollPane){
        this.scrollPane = scrollPane;
    }

    /**
     * Returns the scroll pane of the main frame.
     *
     * @return the {@link JScrollPane} object representing the scroll pane
     */
    public JLabel getSideResPanel(){
        return reservationsNo;
    }

    /**
     * Sets the label displaying the number of reservations.
     *
     * @param reservationsNo a {@link JLabel} object to set as the reservations count label
     */
    public void setSideResPanel(JLabel reservationsNo){
        this.reservationsNo = reservationsNo;
    }

    /**
     * Returns the home panel of the main frame.
     *
     * @return the {@link HomePanel} object representing the home panel
     */
    public HomePanel getHomePanel(){
        return homePanel;
    }

    /**
     * Sets the home panel of the main frame.
     *
     * @param homePanel a {@link HomePanel} object to set as the home panel
     */
    public void setHomePanel(HomePanel homePanel){
        this.homePanel = homePanel;
    }

    /**
     * Returns the hotels panel of the main frame.
     *
     * @return the {@link HotelsPanel} object representing the hotels panel
     */
    public HotelsPanel getHotelsPanel(){
        return hotelsPanel;
    }

    /**
     * Sets the hotels panel of the main frame.
     *
     * @param hotelsPanel a {@link HotelsPanel} object to set as the hotels panel
     */
    public void setHotelsPanel(HotelsPanel hotelsPanel){
        this.hotelsPanel = hotelsPanel;
    }

    /**
     * Returns the reservations panel of the main frame.
     *
     * @return the {@link ReservationsPanel} object representing the reservations panel
     */
    public ReservationsPanel getResPanel(){
        return resPanel;
    }

    /**
     * Sets the reservations panel of the main frame.
     *
     * @param resPanel a {@link ReservationsPanel} object to set as the reservations panel
     */
    public void setResPanel(ReservationsPanel resPanel){
        this.resPanel = resPanel;
    }

    /**
     * Returns the account panel of the main frame.
     *
     * @return the {@link AccountPanel} object representing the account panel
     */
    public AccountPanel getAccountPanel(){
        return accountPanel;
    }

    /**
     * Sets the account panel of the main frame.
     *
     * @param accountPanel an {@link AccountPanel} object to set as the account panel
     */
    public void setAccountPanel(AccountPanel accountPanel){
        this.accountPanel = accountPanel;
    }

    /**
     * Returns the list of selected hotel panels.
     *
     * @return an {@code ArrayList} of {@link SelectedHotelPanel} objects
     */
    public ArrayList<SelectedHotelPanel> getSelectedHotelPanels(){
        return selectedHotelPanels;
    }

    /**
     * Sets the list of selected hotel panels.
     *
     * @param selectedHotelPanels an {@code ArrayList} of {@link SelectedHotelPanel} objects to set
     */
    public void setselectedHotelPanels(ArrayList<SelectedHotelPanel> selectedHotelPanels){
        this.selectedHotelPanels = selectedHotelPanels;
    }

    /**
     * Returns the currently selected hotel panel.
     *
     * @return the {@link SelectedHotelPanel} object representing the currently selected hotel panel
     */
    public SelectedHotelPanel getSelectedHotelPanel(){
        return selectedHotelPanel;
    }

    /**
     * Sets the currently selected hotel panel.
     *
     * @param selectedHotelPanel a {@link SelectedHotelPanel} object to set as the selected hotel panel
     */
    public void setSelectedHotelPanel(SelectedHotelPanel selectedHotelPanel){
        this.selectedHotelPanel = selectedHotelPanel;
    }

    /**
     * Checks if a hotel is currently selected.
     *
     * @return {@code true} if a hotel is selected, {@code false} otherwise
     */
    public boolean isHotelSelected(){
        return isHotelSelected;
    }

    /**
     * Sets the state of whether a hotel is currently selected.
     *
     * @param isHotelSelected {@code true} to indicate that a hotel is selected, {@code false} otherwise
     */
    public void setIsHotelSelected(boolean isHotelSelected){
        this.isHotelSelected = isHotelSelected;
    }
}
