package GUI;

import java.awt.*;
import javax.swing.*;

public class ManagePanel extends RoundPanel {

    private IconButton changeName;
    private IconButton addRoom;
    private IconButton updateBasePrice;
    private IconButton removeRoom;
    private IconButton removeRes;
    private IconButton removeHotel;

    public ManagePanel(Color color) {
        super(color);

        this.setLayout(null);
        this.setBounds(460, 0, 150, 210);

        ImageIcon changeNameIcon = new ImageIcon("Icons/FilterIcon.png"); // add icon
        changeNameIcon = Customization.resizeIcon(changeNameIcon, 20, 20);

        changeName = new IconButton(changeNameIcon, "Change Name");
        changeName.setBounds(5,50, 40, 40);
        changeName.setColorOver(changeName.getColorClick());
        //changeName.setText("Add Room");

        ImageIcon addRoomIcon = new ImageIcon("Icons/FilterIcon.png"); // add icon
        addRoomIcon = Customization.resizeIcon(addRoomIcon, 20, 20);

        addRoom = new IconButton(addRoomIcon, "Add Room");
        addRoom.setBounds(5,50, 40, 40);
        addRoom.setColorOver(addRoom.getColorClick());
        //addRoom.setText("Add Room");

        ImageIcon updatePriceIcon = new ImageIcon("Icons/FilterIcon.png"); // add icon
        updatePriceIcon = Customization.resizeIcon(updatePriceIcon, 20, 20);

        updateBasePrice = new IconButton(updatePriceIcon, "Update Base Price");
        updateBasePrice.setBounds(5,50, 40, 40);
        updateBasePrice.setColorOver(updateBasePrice.getColorClick());
        //updateBasePrice.setText("Add Room");

        ImageIcon removeRoomIcon = new ImageIcon("Icons/FilterIcon.png"); // add icon
        removeRoomIcon = Customization.resizeIcon(removeRoomIcon, 20, 20);

        removeRoom = new IconButton(removeRoomIcon, "Remove Room");
        removeRoom.setBounds(5,50, 40, 40);
        removeRoom.setColorOver(removeRoom.getColorClick());
        //removeRoom.setText("Add Room");

        ImageIcon removeResIcon = new ImageIcon("Icons/FilterIcon.png"); // add icon
        removeResIcon = Customization.resizeIcon(removeResIcon, 20, 20);

        removeRes = new IconButton(removeRoomIcon, "Remove Reservation");
        removeRes.setBounds(5,50, 40, 40);
        removeRes.setColorOver(removeRes.getColorClick());
        //removeRes.setText("Add Room");

        ImageIcon removeHotelIcon = new ImageIcon("Icons/FilterIcon.png"); // add icon
        removeHotelIcon = Customization.resizeIcon(removeHotelIcon, 20, 20);

        removeHotel = new IconButton(removeHotelIcon, "Remove Hotel");
        removeHotel.setBounds(5,50, 40, 40);
        removeHotel.setColorOver(removeHotel.getColorClick());
        //removeHotel.setText("Add Room");
        
        this.add(changeName);
        this.add(addRoom);
        this.add(updateBasePrice);
        this.add(removeRoom);
        this.add(removeRes);
        this.add(removeHotel);
    }
    
}
