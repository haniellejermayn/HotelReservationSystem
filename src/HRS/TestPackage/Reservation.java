package src.HRS.TestPackage;

import java.util.ArrayList;

/**
 * Represents a reservation with guest details, check-in and check-out dates, and a room.
 */
public class Reservation {
    private String guestName;
    private int checkInDate;
    private int checkOutDate;
    private Room room;
    private DiscountCode discountCode;
    private ArrayList<Float> datePriceModifiers;

    // -- Constructor -- //

    /**
     * Constructs a new Reservation with the specified guest name, check-in date, check-out date, and room.
     *
     * @param guestName the name of the guest
     * @param checkInDate the check-in date
     * @param checkOutDate the check-out date
     * @param room the room reserved
     */
    public Reservation(String guestName, int checkInDate, int checkOutDate, Room room, ArrayList<Float> datePriceModifiers) {
        this.guestName = guestName;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.room = room;
        this.datePriceModifiers = datePriceModifiers;
    }

    // -- Public Methods -- //

    // Retrieves the cost per night of the reservation.
    public float retrieveCostPerNight(int day) {
        return this.room.getRoomPrice() * this.datePriceModifiers.get(day - 1);
    }

    // Computes the total (undiscounted) price of the reservation.
    public float computeTotalPrice() {
        float total = 0;

        for(int i = this.checkInDate; i < this.checkOutDate; i++) {
            total += this.retrieveCostPerNight(i);
        }

        return total;
    }

    /**
     * Computes the final (discounted if applicable) price of the reservation.
     * 
     * @return the final (discounted if applicable) price
     */
    public float computeFinalPrice() {
        if(this.discountCode == null) {
            return this.computeTotalPrice();
        }
        else {
            return this.computeTotalPrice() - this.discountCode.computeDiscount(this);
        }
    }

    // -- Getter && Setter Methods -- //

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

    /**
     * Gets the applied discount code.
     * 
     * @return the discount code applied
     */
    public DiscountCode getDiscountCode() {
        return this.discountCode;
    }

    /**
     * Sets the applied discount code to the reservation.
     * 
     * @param discountCode the applied discount code
     */
    public void setDiscountCode(DiscountCode discountCode) {
        this.discountCode = discountCode;
    }
}