import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManagePanel extends RoundPanel implements ActionListener{

    IconButton changeName;
    IconButton addRoom;
    IconButton updateBasePrice;
    IconButton datePriceModifier;
    IconButton removeRoom;
    IconButton removeRes;
    IconButton removeHotel;

    ManageSubPanel changeNamePanel;
    ManageSubPanel addRoomPanel;
    ManageSubPanel updateBasePricePanel;
    ManageSubPanel datePriceModifierPanel;
    ManageSubPanel removeRoomPanel;
    ManageSubPanel removeResPanel;
    ManageSubPanel removeHotelPanel;

    RoundPanel manageContainer;

    ManagePanel(Color color) {
        super(color);

        this.setLayout(null);
        this.setBounds(152, 10, 385, 420);

        Font customFont13 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 13);
        Font customFont15 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 15);
        Font customFont20 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 20);
        Font customFont30 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 30);
        Font customFont50 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 50);

        ImageIcon changeNameIcon = new ImageIcon("Icons/ChangeNameIcon.png"); // add icon
        changeNameIcon = Customization.resizeIcon(changeNameIcon, 20, 20);

        changeName = new IconButton(changeNameIcon, "Change Name");
        changeName.setBounds(23,10, 40, 40);
        changeName.setColorClick(changeName.getColorOver());
        changeName.addActionListener(this);

        RoundLabel currentName = new RoundLabel(new Color(40, 68, 117));
        currentName.setBounds(122, 80, 200, 40); // change to border layout
        currentName.setText("Kelsey Hotel"); // set to cureent hotel name
        currentName.setFont(customFont20);
        currentName.setForeground(Color.white);

        TextFieldCustom newHotelName = new TextFieldCustom(new Color(40, 68, 117));
        newHotelName.setBounds(5, 130, 350, 55);
        newHotelName.setFieldName("New Hotel Name");
        newHotelName.getTextContainer().setBounds(5, 25, 340, 27);

        changeNamePanel = new ManageSubPanel("Change Name");
        changeNamePanel.add(currentName);
        changeNamePanel.add(newHotelName);


        ImageIcon addRoomIcon = new ImageIcon("Icons/AddIcon.png"); // add icon
        addRoomIcon = Customization.resizeIcon(addRoomIcon, 20, 20);

        addRoom = new IconButton(addRoomIcon, "Add Room");
        addRoom.setBounds(73,10, 40, 40);
        addRoom.setColorClick(addRoom.getColorOver());
        addRoom.addActionListener(this);

        addRoomPanel = new ManageSubPanel("Add Room");

        ImageIcon updatePriceIcon = new ImageIcon("Icons/UpdatePriceIcon.png"); // add icon
        updatePriceIcon = Customization.resizeIcon(updatePriceIcon, 20, 20);

        updateBasePrice = new IconButton(updatePriceIcon, "Update Base Price");
        updateBasePrice.setBounds(123,10, 40, 40);
        updateBasePrice.setColorClick(updateBasePrice.getColorOver());
        updateBasePrice.addActionListener(this);

        RoundLabel currentBasePrice = new RoundLabel(new Color(40, 68, 117));
        currentBasePrice.setBounds(142, 80, 200, 40); // set to border layout
        currentBasePrice.setText("1299.00"); // set to curent base price
        currentBasePrice.setFont(customFont20);
        currentBasePrice.setForeground(Color.white);

        TextFieldCustom newBasePrice = new TextFieldCustom(new Color(40, 68, 117));
        newBasePrice.setBounds(5, 130, 350, 55);
        newBasePrice.setFieldName("New Base Price");
        newBasePrice.getTextContainer().setBounds(5, 25, 340, 27);

        updateBasePricePanel = new ManageSubPanel("Update Base Price");
        updateBasePricePanel.add(currentBasePrice);
        updateBasePricePanel.add(newBasePrice);

        ImageIcon datePriceModifierIcon = new ImageIcon("Icons/DatePriceModifierIcon.png"); // add icon
        datePriceModifierIcon = Customization.resizeIcon(datePriceModifierIcon, 20, 20);

        datePriceModifier = new IconButton(datePriceModifierIcon, "Date Price Modifier");
        datePriceModifier.setBounds(173,10, 40, 40);
        datePriceModifier.setColorClick(datePriceModifier.getColorOver());
        datePriceModifier.addActionListener(this);

        datePriceModifierPanel = new ManageSubPanel("Date Price Modifier");

        ImageIcon removeRoomIcon = new ImageIcon("Icons/RoomIcon.png"); // add icon
        removeRoomIcon = Customization.resizeIcon(removeRoomIcon, 20, 20);

        removeRoom = new IconButton(removeRoomIcon, "Remove Room");
        removeRoom.setBounds(223,10, 40, 40);
        removeRoom.setColorClick(removeRoom.getColorOver());
        removeRoom.addActionListener(this);

        removeRoomPanel = new ManageSubPanel("Remove Room");

        ImageIcon removeResIcon = new ImageIcon("Icons/ReservationsIcon.png"); // add icon
        removeResIcon = Customization.resizeIcon(removeResIcon, 20, 20);

        removeRes = new IconButton(removeResIcon, "Remove Reservation");
        removeRes.setBounds(273,10, 40, 40);
        removeRes.setColorClick(removeRes.getColorOver());
        removeRes.addActionListener(this);

        removeResPanel = new ManageSubPanel("Remove Reservation");

        ImageIcon removeHotelIcon = new ImageIcon("Icons/HotelsIcon.png"); // add icon
        removeHotelIcon = Customization.resizeIcon(removeHotelIcon, 20, 20);

        removeHotel = new IconButton(removeHotelIcon, "Remove Hotel");
        removeHotel.setBounds(323,10, 40, 40);
        removeHotel.setColorClick(removeHotel.getColorOver());
        removeHotel.addActionListener(this);

        removeHotelPanel = new ManageSubPanel("Remove Hotel");
        

        manageContainer = new RoundPanel(new Color(40, 68, 117));
        manageContainer.setLayout(null);
        manageContainer.setPreferredSize(new Dimension(530, 585));
        manageContainer.setBounds(10, 60, 365, 350);

        //ScrollPaneCustom scrollPane = new ScrollPaneCustom(manageContainer, new Color(27, 43, 80), new Color(27, 43, 80), new Color(40, 68, 117));
        /*ScrollPaneCustom scrollPane = new ScrollPaneCustom(changeNamePanel, new Color(27, 43, 80), new Color(27, 43, 80), new Color(40, 68, 117));
        scrollPane.setBounds(10, 60, 365, 350);*/
        //scrollPane.remove(manageContainer);
        //scrollPane.add(changeNamePanel);
        
        this.add(manageContainer);
        this.add(changeName);
        this.add(addRoom);
        this.add(updateBasePrice);
        this.add(removeRoom);
        this.add(removeRes);
        this.add(removeHotel);
        this.add(datePriceModifier);
        this.add(changeNamePanel);
        this.add(addRoomPanel);
        this.add(updateBasePricePanel);
        this.add(datePriceModifierPanel);
        this.add(removeRoomPanel);
        this.add(removeResPanel);
        this.add(removeHotelPanel);

        changeNamePanel.setVisible(false);
        addRoomPanel.setVisible(false);
        updateBasePricePanel.setVisible(false);
        datePriceModifierPanel.setVisible(false);
        removeRoomPanel.setVisible(false);
        removeResPanel.setVisible(false);
        removeHotelPanel.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == changeName){
            manageContainer.setVisible(false);
            changeNamePanel.setVisible(true);
            addRoomPanel.setVisible(false);
            updateBasePricePanel.setVisible(false);
            datePriceModifierPanel.setVisible(false);
            removeRoomPanel.setVisible(false);
            removeResPanel.setVisible(false);
            removeHotelPanel.setVisible(false);
        }
        else if (e.getSource() == addRoom){
            manageContainer.setVisible(false);
            changeNamePanel.setVisible(false);
            addRoomPanel.setVisible(true);
            updateBasePricePanel.setVisible(false);
            datePriceModifierPanel.setVisible(false);
            removeRoomPanel.setVisible(false);
            removeResPanel.setVisible(false);
            removeHotelPanel.setVisible(false);
        }
        else if (e.getSource() == updateBasePrice){
            manageContainer.setVisible(false);
            changeNamePanel.setVisible(false);
            addRoomPanel.setVisible(false);
            updateBasePricePanel.setVisible(true);
            datePriceModifierPanel.setVisible(false);
            removeRoomPanel.setVisible(false);
            removeResPanel.setVisible(false);
            removeHotelPanel.setVisible(false);
        }
        else if (e.getSource() == datePriceModifier){
            manageContainer.setVisible(false);
            changeNamePanel.setVisible(false);
            addRoomPanel.setVisible(false);
            updateBasePricePanel.setVisible(false);
            datePriceModifierPanel.setVisible(true);
            removeRoomPanel.setVisible(false);
            removeResPanel.setVisible(false);
            removeHotelPanel.setVisible(false);
        }
        else if (e.getSource() == removeRoom){
            manageContainer.setVisible(false);
            changeNamePanel.setVisible(false);
            addRoomPanel.setVisible(false);
            updateBasePricePanel.setVisible(false);
            datePriceModifierPanel.setVisible(false);
            removeRoomPanel.setVisible(true);
            removeResPanel.setVisible(false);
            removeHotelPanel.setVisible(false);
        }
        else if (e.getSource() == removeRes){
            manageContainer.setVisible(false);
            changeNamePanel.setVisible(false);
            addRoomPanel.setVisible(false);
            updateBasePricePanel.setVisible(false);
            datePriceModifierPanel.setVisible(false);
            removeRoomPanel.setVisible(false);
            removeResPanel.setVisible(true);
            removeHotelPanel.setVisible(false);
        }
        else if (e.getSource() == removeHotel){
            manageContainer.setVisible(false);
            changeNamePanel.setVisible(false);
            addRoomPanel.setVisible(false);
            updateBasePricePanel.setVisible(false);
            datePriceModifierPanel.setVisible(false);
            removeRoomPanel.setVisible(false);
            removeResPanel.setVisible(false);
            removeHotelPanel.setVisible(true);
        }
    }
    
}
