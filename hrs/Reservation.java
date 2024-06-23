package hrs;

public class Reservation {
    private String guestName;
    private int checkInDate;
    private int checkOutDate;
    private Room room;

    // -- Constructor -- //

    public Reservation(String guestName, int checkInDate, int checkOutDate, Room room) {
        this.guestName = guestName;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.room = room;
    }

    // -- Public Methods -- //

    public float retrieveCostPerNight() {
        return this.room.getBasePrice();
    }

    public float computeTotalPrice() {
        return this.retrieveCostPerNight() * (this.checkOutDate - this.checkInDate);
    }

    // -- Getters -- //

    public String getGuestName() {
        return this.guestName;
    }

    public int getCheckInDate() {
        return this.checkInDate;
    }

    public int getCheckOutDate() {
        return this.checkOutDate;
    }

    public Room getRoom() {
        return this.room;
    }
}
