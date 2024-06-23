package hrs;

public class Reservation {
    private String guestName;
    private int checkInDate;
    private int checkOutDate;
    private Room room;
    private float costPerNight;
    private float totalPrice;

    // -- Constructor -- //

    public Reservation(String guestName, int checkInDate, int checkOutDate, Room room) {
        this.guestName = guestName;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.room = room;
        this.costPerNight = room.getBasePrice();
        this.totalPrice = this.computeTotalPrice();
    }

    // -- Private Method -- //

    private float computeTotalPrice() {
        return this.costPerNight * (this.checkOutDate - this.checkInDate);
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

    public float getCostPerNight() {
        return this.costPerNight;
    }

    public float getTotalPrice() {
        return this.totalPrice;
    }
}
