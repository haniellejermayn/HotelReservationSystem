package hrs;

import java.util.ArrayList;

public class Hotel {
    private String hotelName;
    private Room[] rooms;
    private ArrayList<Reservation> reservations;

    public Hotel(String hotelName, int roomAmt) {
        this.hotelName = hotelName;
        this.rooms = new Room[roomAmt];
        //we should make sure roomAmt is 1 to 50
        this.reservations = new ArrayList<Reservation>();
    }
}