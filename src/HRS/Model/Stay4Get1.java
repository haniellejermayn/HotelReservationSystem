package src.HRS.Model;

/**
 * Represents a Stay4Get1 discount code, providing a free night for reservations of five or more nights.
 */
public class Stay4Get1 extends DiscountCode {
    
    // -- Constructor -- //

    /**
     * Constructs a new Stay4Get1 discount code and sets its code.
     */
    public Stay4Get1() {
        this.setCode(DiscountCode.CODE_LIST.get(1));
    }

    // -- Overridden Methods -- //

    /**
     * Checks if the discount code is applicable to the given reservation.
     * This discount is applicable if the reservation is for five or more nights.
     *
     * @param reservation the reservation to check applicability for
     * @return true if the reservation is for five or more nights, false otherwise
     */
    @Override
    public boolean checkApplicability(Reservation reservation) {
        if(reservation.getCheckOutDate() - reservation.getCheckInDate() >= 5) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Computes the discount amount for the given reservation.
     * This discount provides a free night, equivalent to the cost of the first night.
     *
     * @param reservation the reservation to compute the discount for
     * @return the discount amount, which is the cost of the first night
     */
    @Override
    public float computeDiscount(Reservation reservation) {
        return reservation.retrieveCostPerNight(reservation.getCheckInDate());
    }
}
