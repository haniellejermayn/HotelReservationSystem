import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class MainFrame extends JFrame implements ActionListener, ButtonClickListener{
    
    // TODO: fill empty panel;
    // TODO: add listeners to homepage hotels
    // TODO: add back button

    JPanel darkPanel;

    RoundPanel homePage;
    RoundPanel hotelsPage;
    RoundPanel reservationsPage;
    RoundPanel settingsPopUp;

    RoundPanel accountSidePanel;
    RoundPanel datePanel;
    RoundPanel reservationsPanel;
    RoundPanel fillerPanel; // edit
    SidePanel sidePanel;
    JScrollPane scrollPane;

    JLabel reservationsNo;

    ImageIcon logo;
    ImageIcon logoAndName;
    JLabel logoName;
    JLabel hotelTitle;

    Font customFont30;
    Font customFont15;
    Font customFont60;

    HomePanel homePanel;
    HotelsPanel hotelsPanel;
    ReservationsPanel resPanel;
    AccountPanel accountPanel;
    
    IconButton homeButton;
    IconButton hotelButton;
    IconButton resButton;
    IconButton accountButton;
    IconButton backButton;
    
    ArrayList<HotelItem> hotelCatalogue;
    ArrayList<HotelOption> hotelOptions;
    ArrayList<SelectedHotelPanel> selectedHotelPanels;
    ArrayList<String> hotels;
    int nHotels;
    
        // TODO: change to Hotel
    MainFrame(ArrayList<String> hotels, int nHotels){ // TODO: change to hrs.getHotel();

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
        customFont30 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 30);
        customFont60 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 60);


        // * Default Panels * //

        ImageIcon accountIcon = new ImageIcon("Icons/AccountIcon.png");
        accountIcon = Customization.resizeIcon(accountIcon, 120, 120);
        
        RoundLabel account = new RoundLabel(new Color(27, 43, 80));
        account.setBounds(10, 20, 100, 100);
        account.setIcon(accountIcon);
        account.setText("User #462005"); // TODO: change to username
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

        homePanel = new HomePanel(hotels, nHotels, this); 
        homeButton = sidePanel.getHomeButton();
        homeButton.addActionListener(this);
        
        hotelsPanel = new HotelsPanel(hotels, nHotels, this); 
        hotelButton = sidePanel.getHotelButton();
        hotelButton.addActionListener(this);
        
        resPanel = new ReservationsPanel(hotels, nHotels); 
        resButton = sidePanel.getReservationsButton();
        resButton.addActionListener(this);

        accountPanel = new AccountPanel(this);
        accountButton = sidePanel.getAccountButton();
        accountButton.addActionListener(this);

        backButton = sidePanel.getBackButton();
        backButton.addActionListener(this);
        
        selectedHotelPanels = new ArrayList<SelectedHotelPanel>();

        initializeSelectedHotels(hotels, nHotels);

        this.setIconImage(logo.getImage());
        this.add(logoName);
        this.add(sidePanel);
        this.add(homePanel);
        this.add(hotelsPanel);
        this.add(resPanel);
        this.add(accountPanel);
        this.add(accountSidePanel);
        this.add(datePanel);
        this.add(reservationsPanel);


        hotelsPanel.setVisible(false);
        resPanel.setVisible(false);
        accountPanel.setVisible(false);

        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
                                            // TODO: change to Hotel
    public void initializeSelectedHotels(ArrayList<String> hotels, int nHotels){
        for (int i = 0; i < nHotels; i++){
            SelectedHotelPanel hotelTemp = new SelectedHotelPanel(hotels.get(i)); // TODO: change to take Hotel
            hotelTemp.setVisible(false);
            this.selectedHotelPanels.add(hotelTemp);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == homeButton){
            homePanel.setVisible(true);
            hotelsPanel.setVisible(false);
            resPanel.setVisible(false);
            accountPanel.setVisible(false);
        }
        else if (e.getSource() == hotelButton){
            homePanel.setVisible(false);
            hotelsPanel.setVisible(true);
            resPanel.setVisible(false);
            accountPanel.setVisible(false);
        }
        else if (e.getSource() == resButton){
            homePanel.setVisible(false);
            hotelsPanel.setVisible(false);
            resPanel.setVisible(true);
            accountPanel.setVisible(false);
        }
        else if (e.getSource() == accountButton){
            homePanel.setVisible(false);
            hotelsPanel.setVisible(false);
            resPanel.setVisible(false);
            accountPanel.setVisible(true);
        }
        else if (e.getSource() == backButton){
            System.exit(0);
        }
    }

    @Override
    public void buttonClicked(String buttonName) {

        for (int i = 0; i < nHotels; i++){
            String hotel = hotels.get(i); // TODO: change to getHotelName

            if (buttonName.equals(hotel)){
                SelectedHotelPanel selectedHotel = selectedHotelPanels.get(i);
                selectedHotel.setVisible(true);
                homePanel.setVisible(false);
                hotelsPanel.setVisible(false);
                this.add(selectedHotel);
            }
            else {
                selectedHotelPanels.get(i).setVisible(false);
            }
        }
    }
}
