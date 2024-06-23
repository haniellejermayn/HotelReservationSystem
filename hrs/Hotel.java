package hrs;

import java.util.ArrayList;

public class Hotel {
    private String hotelName;
    private ArrayList<Room> rooms;
    private ArrayList<Reservation> reservations;

    // -- Constructor -- //

    public Hotel(String hotelName, int roomAmt) {
        this.hotelName = hotelName;
        this.rooms = new ArrayList<Room>();
        this.initializeRooms(roomAmt);
        this.reservations = new ArrayList<Reservation>();
    }
    
    // -- Public Methods -- //

    public float computeEarnings() {
        float total = 0;

        for(int i = 0; i < reservations.size(); i++) {
            total += reservations.get(i).computeTotalPrice();
        }

        return total;
    }

    public Reservation fetchReservation(int index) {
        return this.reservations.get(index);
    }

    public Room fetchRoom(int index) {
        return this.rooms.get(index);
    }

    public int countReservations() {
        return this.reservations.size();
    }

    public int countRooms() {
        return this.rooms.size();
    }

    public int countBookedRooms(int date) {
        int counter = 0;
        int start, end;

        //counts booked rooms based on reservations
        for(int i = 0; i < this.reservations.size(); i++) {
            start = this.reservations.get(i).getCheckInDate();
            end = this.reservations.get(i).getCheckOutDate();

            if(date >= start && date <= end) {
                counter += 1;
            }
        }

        return counter;
    }

    public int countAvailableRooms(int date) {
        return this.rooms.size() - this.countBookedRooms(date);
    }

    public int[] checkRoomAvailability(Room room) {
        //Note: 31 not included since no check in on the 31st
        int[] availableDays = new int[30]; 
        int start, end;

        for(int i = 0; i < this.reservations.size(); i++) {
            if(this.reservations.get(i).getRoom().equals(room)) {
                start = this.reservations.get(i).getCheckInDate();
                end = this.reservations.get(i).getCheckOutDate();

                while(start < end) {
                    availableDays[start - 1] = 1; //1 signifies booked
                    start += 1;
                }
            }
        }

        return availableDays;
    }

    //returns room index if available and -1 otherwise
    public int checkDateAvailability(int start, int end) {
        int[] availableDays;
        int roomIndex = -1;
        boolean isAvailable;

        for(int i = 0; i < this.rooms.size() && roomIndex == -1; i++) {
            availableDays = this.checkRoomAvailability(this.rooms.get(i));
            isAvailable = true;

            //end - 1 is the check-out date (not counted as booked)
            for(int j = start - 1; j < end - 1 && isAvailable == true; j++) { 
                if(availableDays[j] == 1) {
                    isAvailable = false;
                }
            }

            if(isAvailable) {
                roomIndex = i;
            }
        }

        return roomIndex;
    }

    public void addReservation(String guestName, int checkInDate, int checkOutDate, Room room) {
        this.reservations.add(new Reservation(guestName, checkInDate, checkOutDate, room));
    }

    public void removeReservation(int index) {
        this.reservations.remove(index);
    }

    public void addRoom() {
        this.rooms.add(new Room(hotelName));
        this.reinitializeRooms(this.rooms.get(0).getBasePrice());
    }

    public void removeRoom(int index) {
        this.rooms.remove(index);
        this.reinitializeRooms(this.rooms.get(0).getBasePrice());
    }

    public void updateRoomPrice(float newPrice) {
        for(int i = 0; i < this.rooms.size(); i++) {
            this.rooms.get(i).setBasePrice(newPrice);
        }
    }

    // -- Private Methods -- //

    private void initializeRooms(int roomAmt) {
        char letter = 'A';
        int number = 1;

        for(int i = 0; i < roomAmt; i++) {
            this.rooms.add(new Room(letter + String.valueOf(number)));
            
            if(number == 5) {
                number = 1;
                letter += 1;
            }
            else {
                number += 1;
            }
        }
    }

    //reinitializes rooms name and basePrice (used for addRoom, removeRoom, & updatePrice)
    private void reinitializeRooms(float basePrice) {
        char letter = 'A';
        int number = 1;

        for(int i = 0; i < this.rooms.size(); i++) {
            this.rooms.get(i).setRoomName(letter + String.valueOf(number));
            this.rooms.get(i).setBasePrice(basePrice);
            
            if(number == 5) {
                number = 1;
                letter += 1;
            }
            else {
                number += 1;
            }
        }
    }

    // -- Getter & Setter Methods -- //

    public String getHotelName() {
        return this.hotelName;
    }

    public void setHotelName(String newName) {
        this.hotelName = newName;
    }

    
}