import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class ReservationsPanel extends RoundPanel{
    
    private JLabel resTitle;
    private RoundPanel hotelPanel;
    private RoundPanel namePanel;
    private RoundPanel roomTypePanel;
    private RoundPanel checkInNOutPanel;
    private RoundPanel totalPricePanel;
    private RoundPanel resContainer;
    private int resContainerHeight;
    private ArrayList<HotelOption> hotelCatalogue;

    private Font customFont15;
    private Font customFont20;
    private Font customFont35;

        // TODO: change to Hotel hotels
    ReservationsPanel(ArrayList<String> hotels, int nHotel){

        super(new Color(13, 22, 45));

        customFont15 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 15);
        customFont20 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 20);
        customFont35 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 35);

        // * Reservations Title * //
        resTitle = new JLabel("Reservations");
        resTitle.setFont(customFont35);
        resTitle.setForeground(Color.white);
        resTitle.setVerticalAlignment(JLabel.TOP);
        resTitle.setBounds(0, 0, 300, 100);

        resContainerHeight = (nHotel + 1) * 20 + (nHotel + 1) * 5 + 20;

        JTable reservationsTable = new JTable(initializeData());
        reservationsTable.setBounds(15, 10, 590, resContainerHeight);
        reservationsTable.setBackground(new Color(27, 43, 80));
        reservationsTable.setForeground(Color.white);
        reservationsTable.setFont(customFont15);
        reservationsTable.setRowHeight(25);
        reservationsTable.setBorder(null);

        reservationsTable.setRowHeight(0, 40);
        reservationsTable.getColumnModel().getColumn(0).setPreferredWidth(50);
        reservationsTable.getColumnModel().getColumn(4).setPreferredWidth(30);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.RIGHT );
        reservationsTable.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
        reservationsTable.getColumnModel().getColumn(4).setCellRenderer( centerRenderer );

        
        // * Container * //

        resContainer = new RoundPanel(new Color(27, 43, 80));
        resContainer.setLayout(null);;
        resContainer.setPreferredSize(new Dimension(615, resContainerHeight));
        resContainer.add(reservationsTable);

        ScrollPaneCustom scrollPane = new ScrollPaneCustom(resContainer, new Color(40, 68, 117), new Color(40, 68, 117), new Color(27, 43, 80));

        scrollPane.setBounds(0, 60, 620, 405);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        this.setLayout(null);
        this.setBounds(120, 80, 620, 470);
        this.add(resTitle);
        this.add(scrollPane);
    }

    public DefaultTableModel initializeData(){

        int nReservations = 6; // TODO: remove

        String[] hotelNameTemp = {"A", "B", "C", "D", "E", "F"}; // TODO: remove
        String[] guestNameTemp = {"Kelsey", "Hanielle", "Hep", "Francine", "Justine", "Liane"}; // TODO: remove
        String[] roomTypeTemp = {"Standard", "Deluxe", "Deluxe", "Executive", "Standard", "Executive"}; // TODO: remove
        String[] checkInTemp = {"8", "3", "17", "5", "20", "12"}; // TODO: remove
        String[] checkOutTemp = {"16", "12", "20", "9", "25", "18"}; // TODO: remove
        float[] priceTemp = {1500.00f, 749.00f, 1299.00f, 1650.00f, 599.00f, 1000.00f}; // TODO: remove

        Object[] columnNames = {"Hotel", "Name", "Room Type", "Check In / Out", "Price"};
        Object[][] data = new Object[nReservations + 1][columnNames.length];

        data[0][0] = columnNames[0]; 
        data[0][1] = columnNames[1]; 
        data[0][2] = columnNames[2]; 
        data[0][3] = columnNames[3]; 
        data[0][4] = columnNames[4];

                        // TODO: change to total no. of reservations of all hotels
        for (int i = 1; i <= nReservations; i++){
            
            data[i][0] = hotelNameTemp[i - 1]; // TODO: change to hotel name
            data[i][1] = guestNameTemp[i - 1]; // TODO: change to guest name
            data[i][2] = roomTypeTemp[i - 1]; // TODO: change to room type
            data[i][3] = checkInTemp[i - 1] + " to " + checkOutTemp[i - 1]; // TODO: change to check In and check Out
            data[i][4] = priceTemp[i - 1]; // TODO: change to price
            
        }
        
        DefaultTableModel model = new DefaultTableModel(data, columnNames); 

        return model;
    }

    public JLabel getHotelTitle(){
        return resTitle;
    }

    public void setHotelTitle(JLabel resTitle){
        this.resTitle = resTitle;
    }

    public ArrayList<HotelOption> getHotelCatalogue(){
        return hotelCatalogue;
    }

    public void setHotelCatalogue(ArrayList<HotelOption> hotelCatalogue){
        this.hotelCatalogue = hotelCatalogue;
    }
}
