package src.HRS.Model;

import java.util.ArrayList;

/**
 * Represents a hotel with a name, base price, list of rooms, ist of reservations, and list of date price modifiers.
 */
public class Hotel {
    private String hotelName;
    protected float basePrice;
    private ArrayList<Room> rooms;
    private ArrayList<Reservation> reservations;
    private ArrayList<Float> datePriceModifiers;

    // -- Constructor -- //

    /**
     * Constructs a new Hotel with the specified name and initializes rooms and date price modifiers.
     *
     * @param hotelName the name of the hotel
     * @param standardAmount the number of standard rooms
     * @param deluxeAmount the number of deluxe rooms
     * @param executiveAmount the number of executive rooms
     */
    public Hotel(String hotelName, int standardAmount, int deluxeAmount, int executiveAmount) {
        this.hotelName = hotelName;
        this.basePrice = 1299.0f;
        this.rooms = new ArrayList<Room>();
        this.initializeRooms(standardAmount, deluxeAmount, executiveAmount);
        this.reservations = new ArrayList<Reservation>();
        this.datePriceModifiers = new ArrayList<Float>();
        
        //initialize datePriceMultipliers all to 1.0f
        for(int i = 0; i < 30; i++) {
            this.datePriceModifiers.add(1.0f);
        }
    }
    
    // -- Public Methods -- //

    /**
     * Computes the total earnings from all reservations.
     * 
     * @return the total earnings
     */
    public float computeEarnings() {
        float total = 0;

        for(int i = 0; i < reservations.size(); i++) {
            total += reservations.get(i).computeFinalPrice();
        }

        return total;
    }

    /**
     * Fetches a reservation by its index.
     * 
     * @param index the index of the reservation
     * @return the reservation at the specified index
     */
    public Reservation fetchReservation(int index) {
        return this.reservations.get(index);
    }

    /**
     * Fetches a room by its index.
     * 
     * @param index the index of the room
     * @return the room at the specified index
     */
    public Room fetchRoom(int index) {
        return this.rooms.get(index);
    }

    /**
     * Counts the total number of reservations.
     * 
     * @return the number of reservations
     */
    public int countReservations() {
        return this.reservations.size();
    }

    /**
     * Counts the number of rooms per type. Also counts the total rooms.
     * 
     * @param type the type of room (0 - total, 1 - standard, 2 - deluxe, 3 - executive)
     * @return the number of rooms given selected type.
     */
    public int countRooms(int type) {
        int result = 0;
        
        if(type == 0) {
            result = this.rooms.size();
        }
        else if(type == 1) {
            result = this.countRooms(0) - this.countRooms(2) - this.countRooms(3);
        }
        else if(type == 2) {
            for(int i = 0; i < this.rooms.size(); i++) {
                if(this.rooms.get(i) instanceof DeluxeRoom) {
                    result += 1;
                }
            }
        }
        else if(type == 3) {
            for(int i = 0; i < this.rooms.size(); i++) {
                if(this.rooms.get(i) instanceof ExecutiveRoom) {
                    result += 1;
                }
            }
        }
        
        return result;
    }

    /**
     * Counts the number of booked rooms on a specific date.
     * 
     * @param date the date to check
     * @return the number of booked rooms on the specified date
     */
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

    /**
     * Counts the number of available rooms on a specified date.
     * 
     * @param date the date to check
     * @return the number of available rooms on the specified date
     */
    public int countAvailableRooms(int date) {
        return this.rooms.size() - this.countBookedRooms(date);
    }

    /**
     * Checks the availability of a specific room across all days of the month.
     * 
     * @param room the room to check
     * @return an array representing the availability of the room (0 = available, 1 = booked)
     */
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

    /**
     * Checks date availability across all rooms of a given type and returns the index of an available room.
     *
     * @param start the start date
     * @param end the end date
     * @param type the type of room (1 - standard, 2 - deluxe, 3 - executive)
     * @return the index of an available room, or -1 if none are available
     */
    public int checkDateAvailability(int start, int end, int type) {
        int[] availableDays;
        int roomIndex = -1;
        boolean isAvailable;

        for(int i = 0; i < this.rooms.size() && roomIndex == -1; i++) {
            if ((type == Room.TYPE_DELUXE && this.rooms.get(i) instanceof DeluxeRoom) ||
                (type == Room.TYPE_EXECUTIVE && this.rooms.get(i) instanceof ExecutiveRoom) ||
                (type == Room.TYPE_STANDARD && !(this.rooms.get(i) instanceof DeluxeRoom) && !(this.rooms.get(i) instanceof ExecutiveRoom))) {

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
        }

        return roomIndex;
    }

    /**
     * Adds a reservation to the hotel.
     * 
     * @param guestName the name of the guest
     * @param checkInDate the check-in date
     * @param checkOutDate the check-out date
     * @param room the room to reserve
     */
    public void addReservation(String guestName, int checkInDate, int checkOutDate, Room room) {
        this.reservations.add(new Reservation(guestName, checkInDate, checkOutDate, room, this.datePriceModifiers));
    }

    /**
     * Removes a reservation by its index.
     * 
     * @param index the index of the reservation to remove
     */
    public void removeReservation(int index) {
        this.reservations.remove(index);
    }

    /**
     * Adds rooms to the hotel.
     *
     * @param standardAmount the number of standard rooms
     * @param deluxeAmount the number of deluxe rooms
     * @param executiveAmount the number of executive rooms
     */
    public void addRooms(int standardAmount, int deluxeAmount, int executiveAmount) {
        for(int i = 0; i < standardAmount; i++) {
            this.rooms.add(new Room(this.basePrice));
        }
        for(int i = 0; i < deluxeAmount; i++) {
            this.rooms.add(new DeluxeRoom(this.basePrice));
        }
        for(int i = 0; i < executiveAmount; i++) {
            this.rooms.add(new ExecutiveRoom(this.basePrice));
        }
        
        this.reinitializeRooms();
    }

    /**
     * Removes a room by its index.
     * 
     * @param index the index of the room to remove
     */
    public void removeRoom(int index) {
        this.rooms.remove(index);
        this.reinitializeRooms();
        //this.datePriceModifiers.remove(index);
    }

    /**
     * Fetches the price modifier for a specific day.
     *
     * @param day the day to fetch the price modifier for
     * @return the price modifier for the specified day
     */
    public float fetchDatePriceModifier(int day) {
        return this.datePriceModifiers.get(day - 1);
    }

    /**
     * Updates the price modifier for a specific day.
     *
     * @param day the day to update the price for
     * @param newPrice the new price modifier
     */
    public void updateDatePrice(int day, float newPrice) {
        this.datePriceModifiers.set(day - 1, newPrice);
    }

    // -- Private Methods -- //

    /**
     * Initializes rooms with the specified amounts for each type.
     *
     * @param standardAmount the number of standard rooms
     * @param deluxeAmount the number of deluxe rooms
     * @param executiveAmount the number of executive rooms
     */
    private void initializeRooms(int standardAmount, int deluxeAmount, int executiveAmount) {
        int totalRooms = standardAmount + deluxeAmount + executiveAmount;
        int roomCounter = 0;
        int number = 1;
        char letter = 'A';

        for(int i = 0; i < totalRooms; i++) {
            if(roomCounter < standardAmount) {
                this.rooms.add(new Room(String.valueOf(number) + letter, this.basePrice));
            }
            else if(roomCounter < standardAmount + deluxeAmount) {
                this.rooms.add(new DeluxeRoom(String.valueOf(number) + letter, this.basePrice));
            }
            else {
                this.rooms.add(new ExecutiveRoom(String.valueOf(number) + letter, this.basePrice));
            }

            roomCounter += 1;
            
            if(letter == 'E') {
                letter = 'A';
                number += 1;
            }
            else {
                letter += 1;
            }
        }
    }

    /**
     * Reinitializes rooms' names and prices.
     */
    public void reinitializeRooms() {
        int number = 1;
        char letter = 'A';

        for(int i = 0; i < this.rooms.size(); i++) {
            this.rooms.get(i).setRoomName(String.valueOf(number) + letter);
            this.rooms.get(i).setRoomPrice(this.basePrice);
            
            if(letter == 'E') {
                letter = 'A';
                number += 1;
            }
            else {
                letter += 1;
            }
        }
    }

    // -- Getter & Setter Methods -- //

    /**
     * Gets the name of the hotel.
     * 
     * @return the name of the hotel
     */
    public String getHotelName() {
        return this.hotelName;
    }

    /**
     * Gets the base price of the hotel.
     *
     * @return the base price of the hotel
     */
    public float getBasePrice() {
        return this.basePrice;
    }

    /**
     * Gets the list of reservations for the hotel.
     *
     * @return the list of reservations
     */
    public ArrayList<Reservation> getReservations() {
        return this.reservations;
    }

    /**
     * Sets the name of the hotel.
     * 
     * @param newName the new name of the hotel
     */
    public void setHotelName(String newName) {
        this.hotelName = newName;
    }

    /**
     * Sets the base price of the hotel and reinitializes room prices.
     *
     * @param newPrice the new base price
     */
    public void setBasePrice(float newPrice) {
        this.basePrice = newPrice;
        this.reinitializeRooms();
    }
}