package hrs;

/**
 * Represents a reservation with guest details, check-in and check-out dates, and a room.
 */
public class Reservation {
    private String guestName;
    private int checkInDate;
    private int checkOutDate;
    private Room room;

    // -- Constructor -- //

    /**
     * Constructs a new Reservation with the specified guest name, check-in date, check-out date, and room.
     *
     * @param guestName the name of the guest
     * @param checkInDate the check-in date
     * @param checkOutDate the check-out date
     * @param room the room reserved
     */
    public Reservation(String guestName, int checkInDate, int checkOutDate, Room room) {
        this.guestName = guestName;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.room = room;
    }

    // -- Public Methods -- //

    /**
     * Retrieves the cost per night of the reservation.
     * 
     * @return the cost per night
     */
    public float retrieveCostPerNight() {
        return this.room.getRoomPrice();
    }

    /**
     * Computes the total price of the reservation.
     * 
     * @return the total price
     */
    public float computeTotalPrice() {
        return this.retrieveCostPerNight() * (this.checkOutDate - this.checkInDate);
    }

    // -- Getters -- //

    /**
     * Gets the name of the guest.
     * 
     * @return the guest's name
     */
    public String getGuestName() {
        return this.guestName;
    }

    /**
     * Gets the check-in date of the reservation.
     * 
     * @return the check-in date
     */
    public int getCheckInDate() {
        return this.checkInDate;
    }

    /**
     * Gets the check-out date of the reservation.
     * 
     * @return the check-out date
     */
    public int getCheckOutDate() {
        return this.checkOutDate;
    }

    /**
     * Gets the room reserved.
     * 
     * @return the reserved room
     */
    public Room getRoom() {
        return this.room;
    }
}
