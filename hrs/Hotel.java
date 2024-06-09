package hrs;

import java.util.ArrayList;

public class Hotel {
    private String hotelName;
    private Room[] rooms;
    private ArrayList<Reservation> reservations;

    public Hotel(String hotelName, int roomAmt) {
        this.hotelName = hotelName;
        this.rooms = new Room[roomAmt];
        this.initializeRooms();
        //we should make sure roomAmt is 1 to 50
        this.reservations = new ArrayList<Reservation>();
    }

    //initialize rooms in hotel
    private void initializeRooms() {
        char letter = 'A';
        int number = 1;
        int roomAmt = this.rooms.length;

        for(int i = 0; i < roomAmt; i++) {
            this.rooms[i] = new Room(letter + String.valueOf(number));
            
            if(number == 5) {
                number = 0;
                letter += 1;
            }
            else {
                number += 1;
            }
        }
    }

    public String getHotelName() {
        return this.hotelName;
    }

    public void setHotelName(String newName) {
        this.hotelName = newName;
    }
}