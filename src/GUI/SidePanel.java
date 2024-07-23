//package GUI;
import javax.swing.*;
import java.awt.*;

public class SidePanel extends RoundPanel{
    
    private IconButton homeButton;
    private IconButton hotelButton;
    private IconButton reservationsButton;
    private IconButton accountButton;
    private IconButton backButton;

    SidePanel(Color color){
        
        super(color);
        this.setOpaque(false);
        this.setBackground(color);
        this.setLayout(null);

        ImageIcon homeIcon = new ImageIcon("Icons/HomeIcon.png"); 
        ImageIcon hotelIcon = new ImageIcon("Icons/HotelsIcon.png"); 
        ImageIcon reservationsIcon = new ImageIcon("Icons/BookIcon.png"); 
        ImageIcon accountIcon = new ImageIcon("Icons/AccountIcon.png"); 
        ImageIcon backIcon = new ImageIcon("Icons/BackIcon.png"); 
        
        homeIcon = Customization.resizeIcon(homeIcon, 30, 30); 
        hotelIcon = Customization.resizeIcon(hotelIcon, 30, 30); 
        reservationsIcon = Customization.resizeIcon(reservationsIcon, 30, 30); 
        accountIcon = Customization.resizeIcon(accountIcon, 30, 30); 
        backIcon = Customization.resizeIcon(backIcon, 30, 30); 
        
        homeButton = new IconButton(homeIcon, "Home");
        homeButton.setBounds(8, 30, 50, 50);
        
        hotelButton = new IconButton(hotelIcon, "Hotels");
        hotelButton.setBounds(8,100, 50, 50);
        
        reservationsButton = new IconButton(reservationsIcon, "Reservations");
        reservationsButton.setBounds(8, 170, 50, 50);
        
        accountButton = new IconButton(accountIcon, "Settings");
        accountButton.setBounds(8, 240, 50, 50);
        
        backButton = new IconButton(backIcon, "Back");
        backButton.setBounds(8, 410, 50, 50);

        this.add(homeButton);
        this.add(hotelButton);
        this.add(reservationsButton);
        this.add(accountButton);
        this.add(backButton);
    }

    public IconButton getHomeButton(){
        return homeButton;
    };

    public void setHomeButton(IconButton homeButton){
        this.homeButton = homeButton;
    }

    public IconButton getHotelButton(){
        return hotelButton;
    };

    public void setHotelButton(IconButton hotelButton){
        this.hotelButton = hotelButton;
    }

    public IconButton getReservationsButton(){
        return reservationsButton;
    };

    public void setReservationButton(IconButton reservationsButton){
        this.reservationsButton = reservationsButton;
    }

    public IconButton getAccountButton(){
        return accountButton;
    };

    public void setAccountButton(IconButton accountButton){
        this.accountButton = accountButton;
    }

    public IconButton getBackButton(){
        return backButton;
    };

    public void setBackButton(IconButton backButton){
        this.backButton = backButton;
    }
}
