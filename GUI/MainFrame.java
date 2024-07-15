import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class MainFrame extends JFrame implements ActionListener{
    
    RoundPanel homePage;
    RoundPanel hotelsPage;
    RoundPanel reservationsPage;
    RoundPanel settingsPopUp;

    RoundPanel accountPanel;
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
    SelectedHotelPanel selectedHotel;
    
    IconButton homeButton;
    IconButton hotelButton;
    
    ArrayList<HotelItem> hotelCatalogue;
    ArrayList<HotelOption> hotelOptions;
    ArrayList<SelectedHotelPanel> selectedHotelPanels;
    
        // change to Hotel
    MainFrame(ArrayList<String> hotels, int nHotel){

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

        homePanel = new HomePanel(hotels, nHotel); 
        homeButton = sidePanel.getHomeButton();
        homeButton.addActionListener(this);
        
        hotelsPanel = new HotelsPanel(hotels, nHotel); 
        hotelButton = sidePanel.getHotelButton();
        hotelButton.addActionListener(this);

        // ---------- Fix ---------- //

        hotelOptions = new ArrayList<HotelOption>();
        selectedHotelPanels = new ArrayList<SelectedHotelPanel>();

        selectedHotel = new SelectedHotelPanel(hotels.get(0));

        for (int i = 0; i < nHotel; i++){
            HotelOption option = new HotelOption("Hotel" + (i + 1));
            option.addActionListener(this);
            hotelOptions.add(option);
            
            SelectedHotelPanel selectedHotel = new SelectedHotelPanel("Hotel" + (i + 1));
            selectedHotel.setVisible(false);
            selectedHotelPanels.add(selectedHotel);
        }

        // ---------- Fix ---------- //

        SelectedHotelPanel testSelectedHotel = new SelectedHotelPanel("Kelsey");


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
}
