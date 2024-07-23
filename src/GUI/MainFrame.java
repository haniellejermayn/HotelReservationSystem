package GUI;

import hrs.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

public class MainFrame extends JFrame implements ActionListener{
    
    // Edit: placeholder
    private CreateHotelPanel createHotelPanel;
    
    private RoundPanel homePage;
    private RoundPanel hotelsPage;
    private RoundPanel reservationsPage;
    private RoundPanel settingsPopUp;

    private RoundPanel accountPanel;
    private RoundPanel datePanel;
    private RoundPanel reservationsPanel;
    private RoundPanel fillerPanel; // edit
    private SidePanel sidePanel;
    private JScrollPane scrollPane;

    private JLabel reservationsNo;

    private ImageIcon logo;
    private ImageIcon logoAndName;
    private JLabel logoName;
    private JLabel hotelTitle;

    private Font customFont30;
    private Font customFont15;
    private Font customFont60;

    private HomePanel homePanel;
    private HotelsPanel hotelsPanel;
    private SelectedHotelPanel selectedHotel;
    private OptionButton bookButton;
    
    private IconButton homeButton;
    private IconButton hotelButton;
    
    private ArrayList<HotelItem> hotelCatalogue;
    private ArrayList<HotelOption> hotelOptions;
    private ArrayList<SelectedHotelPanel> selectedHotelPanels;

    private HRSController controller;
    
    public MainFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null); // change(?)
        this.setSize(1000, 600);
        this.getContentPane().setBackground(new Color(13, 22, 45));

        // Allows for rounded components
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // DEFAULT COMPONENTS

        logo = new ImageIcon("Icons/HRS_Logo.jpg");

        logoAndName = new ImageIcon("Icons/HRS_Logo&Name.jpg");
        logoAndName = Customization.resizeIcon(logoAndName, 150, 50);

        logoName = new JLabel();
        logoName.setIcon(logoAndName);
        logoName.setHorizontalAlignment(JLabel.CENTER);
        logoName.setVerticalAlignment(JLabel.CENTER);
        logoName.setBounds(15, 15, 150, 50);
        
        customFont15 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 15);
        customFont30 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 30);
        customFont60 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 60);


        // DEFAULT PANELS

        ImageIcon accountIcon = new ImageIcon("Icons/AccountIcon.png");
        accountIcon = Customization.resizeIcon(accountIcon, 100, 100);
        
        // fix text gap
        RoundLabel account = new RoundLabel(new Color(27, 43, 80));
        account.setBounds(10, 10, 100, 100);
        account.setIcon(accountIcon);
        account.setText("<html><p style='font-size: 15pt; margin:0;'>Gabrielle Kelsey</p><br><p style='font-size: 13pt; margin:0; text-align:center;'>12307572</p></html>"); // name, worker/guest
        account.setForeground(Color.white);
        account.setFont(customFont15);
        account.setVerticalTextPosition(JLabel.BOTTOM);
        account.setHorizontalTextPosition(JLabel.CENTER);
        account.setIconTextGap(10);
        account.setVerticalAlignment(JLabel.CENTER);
        account.setHorizontalAlignment(JLabel.CENTER);
        
        accountPanel = new RoundPanel(new Color(27, 43, 80));
        accountPanel.setLayout(new BorderLayout());
        accountPanel.setBounds(775, 15, 200, 200);
        accountPanel.setBackground(new Color(27, 43, 80));
        accountPanel.add(account);
        
        datePanel = new RoundPanel(new Color(27, 43, 80));
        datePanel.setBounds(775, 225, 200, 120);
        datePanel.setBackground(new Color(27, 43, 80));
        
        reservationsNo = new JLabel();
        reservationsNo.setText("462");
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
    }

    public void initializeMainFrame(ArrayList<Hotel> hotels, int nHotels) {
        homePanel = new HomePanel(hotels, nHotels); 
        homeButton = sidePanel.getHomeButton();
        homeButton.addActionListener(this);
        
        // Edit: all hotels should be passed here
        hotelsPanel = new HotelsPanel(hotels, nHotels); 
        hotelButton = sidePanel.getHotelButton();
        hotelButton.addActionListener(this);

        // ---------- Fix ---------- //

        hotelOptions = new ArrayList<HotelOption>();
        selectedHotelPanels = new ArrayList<SelectedHotelPanel>();

        // Edit: Fetch hotel
        selectedHotel = new SelectedHotelPanel(hotels.get(0));

        for (int i = 0; i < nHotels; i++){
            HotelOption option = new HotelOption("Hotel" + (i + 1));
            option.addActionListener(this);
            hotelOptions.add(option);
            
            SelectedHotelPanel selectedHotel = new SelectedHotelPanel(hotels.get(i)); //Edit: not sure
            selectedHotel.setVisible(false);
            selectedHotelPanels.add(selectedHotel);
        }

        // ---------- Fix ---------- //

        SelectedHotelPanel testSelectedHotel = new SelectedHotelPanel(hotels.get(0)); //Edit: not sure

        bookButton = testSelectedHotel.getBookButton();
        bookButton.addActionListener(this);

        this.setIconImage(logo.getImage());
        this.add(logoName);
        this.add(sidePanel);
        this.add(homePanel);
        this.add(hotelsPanel);
        this.add(selectedHotel);
        this.add(testSelectedHotel);
        this.add(accountPanel);
        this.add(datePanel);
        this.add(reservationsPanel);


        homePanel.setVisible(false);
        hotelsPanel.setVisible(false);
        selectedHotel.setVisible(false);
        testSelectedHotel.setVisible(true);


        //this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == homeButton){
            homePanel.setVisible(true);
            hotelsPanel.setVisible(false);
        }
        else if (e.getSource() == hotelButton){
            hotelsPanel.setVisible(true);
            homePanel.setVisible(false);
        }
        else if (e.getSource() == bookButton){
            this.darkenBackground(true);
        }
        else { // Hotels Panel, gets Selected Hotel
            for (int i = 0; i < hotelOptions.size(); i++){
                if (e.getSource() == hotelOptions.get(i)){
                    selectedHotel = selectedHotelPanels.get(i);

                    selectedHotel.setVisible(true);
                    hotelsPanel.setVisible(false);
                    homePanel.setVisible(false);
                }
            }
        } 
    }

    public void darkenBackground(boolean darken){
        if (darken){
            JPanel glassPane = new JPanel();
            glassPane.setBackground(new Color(0, 0, 0, 100));
            glassPane.setOpaque(true);
            this.setGlassPane(glassPane);
            glassPane.setVisible(true);
        }
        else {
            this.getGlassPane().setVisible(false);
        }
    }

    // Edit: Placeholder
    public CreateHotelPanel getCreateHotelPanel() {
        return this.createHotelPanel;
    }
}
