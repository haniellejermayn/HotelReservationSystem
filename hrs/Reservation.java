package hrs;

public class Reservation {
    private String guestName;
    private int checkInDate;
    private int checkOutDate;
    private Room room;
    private float costPerNight;
    private float totalPrice;

    public Reservation(String guestName, int checkInDate, int checkOutDate, Room room) {
        this.guestName = guestName;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.room = room;
        this.costPerNight = room.getBasePrice();
        this.totalPrice = this.computeTotalPrice();
    }

    private float computeTotalPrice() {
        return this.costPerNight * (this.checkOutDate - this.checkInDate);
    }
}
