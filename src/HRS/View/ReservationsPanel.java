package src.HRS.View;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import src.HRS.Model.Hotel;

/**
 * The ReservationsPanel class represents a panel that displays a table of reservations
 * for a list of hotels. It includes the reservation details such as guest name, room type,
 * check-in and check-out dates, and the price.
 */
public class ReservationsPanel extends RoundPanel {

    private JLabel resTitle;
    private RoundPanel resContainer;
    private int resContainerHeight;
    private ArrayList<HotelOption> hotelCatalogue;

    private Font customFont15;
    private Font customFont35;

    /**
     * Constructs a new ReservationsPanel for the specified list of hotels and hotel index.
     *
     * @param hotels the list of hotels
     * @param nHotel the index of the hotel
     */
    public ReservationsPanel(ArrayList<Hotel> hotels, int nHotel) {
        super(new Color(13, 22, 45));

        customFont15 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 15);
        customFont35 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 35);

        // * Reservations Title * //
        resTitle = new JLabel("Reservations");
        resTitle.setFont(customFont35);
        resTitle.setForeground(Color.white);
        resTitle.setVerticalAlignment(JLabel.TOP);
        resTitle.setBounds(0, 0, 300, 100);

        int nReservations = 0;
        for (Hotel hotel : hotels) {
            nReservations += hotel.countReservations();
        }

        resContainerHeight = (nReservations + 1) * 20 + (nReservations + 1) * 5 + 20;

        JTable reservationsTable = new JTable(initializeData(hotels, nHotel));
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
        centerRenderer.setHorizontalAlignment(JLabel.RIGHT);
        reservationsTable.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        reservationsTable.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);

        // * Container * //
        resContainer = new RoundPanel(new Color(27, 43, 80));
        resContainer.setLayout(null);
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

    /**
     * Initializes the data for the reservations table.
     *
     * @param tableHotels the list of hotels
     * @param tablenHotel the index of the hotel
     * @return a DefaultTableModel containing the reservations data
     */
    public DefaultTableModel initializeData(ArrayList<Hotel> tableHotels, int tablenHotel) {
        int rowCounter = 1;
        Hotel temp;
        Object[] columnNames = {"Hotel", "Name", "Room Type", "Check In / Out", "Price"};

        int nReservations = 0;
        for (Hotel hotel : tableHotels) {
            nReservations += hotel.countReservations();
        }

        Object[][] data = new Object[nReservations + 1][columnNames.length];

        data[0][0] = columnNames[0];
        data[0][1] = columnNames[1];
        data[0][2] = columnNames[2];
        data[0][3] = columnNames[3];
        data[0][4] = columnNames[4];

        while (rowCounter <= nReservations) {
            for (int i = 1; i <= tableHotels.size(); i++) {
                temp = tableHotels.get(i - 1);
                for (int j = 1; j <= temp.countReservations(); j++) {
                    data[rowCounter][0] = temp.getHotelName();
                    data[rowCounter][1] = temp.fetchReservation(j - 1).getGuestName();
                    data[rowCounter][2] = temp.fetchReservation(j - 1).getRoom().getRoomType();
                    data[rowCounter][3] = temp.fetchReservation(j - 1).getCheckInDate() + " to " + temp.fetchReservation(j - 1).getCheckOutDate();
                    data[rowCounter][4] = String.format("%.2f", temp.fetchReservation(j - 1).computeFinalPrice());
                    rowCounter++;
                }
            }
        }

        return new DefaultTableModel(data, columnNames);
    }

    /**
     * Returns the reservations title label.
     *
     * @return the reservations title label
     */
    public JLabel getHotelTitle() {
        return resTitle;
    }

    /**
     * Sets the reservations title label.
     *
     * @param resTitle the reservations title label to set
     */
    public void setHotelTitle(JLabel resTitle) {
        this.resTitle = resTitle;
    }

    /**
     * Returns the hotel catalogue.
     *
     * @return the hotel catalogue
     */
    public ArrayList<HotelOption> getHotelCatalogue() {
        return hotelCatalogue;
    }

    /**
     * Sets the hotel catalogue.
     *
     * @param hotelCatalogue the hotel catalogue to set
     */
    public void setHotelCatalogue(ArrayList<HotelOption> hotelCatalogue) {
        this.hotelCatalogue = hotelCatalogue;
    }
}
