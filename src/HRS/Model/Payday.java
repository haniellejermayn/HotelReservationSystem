package src.HRS.Model;

/**
 * Represents a Payday discount code, providing a 7% discount for reservations spanning certain dates.
 */
public class Payday extends DiscountCode {
    
    // -- Constructor -- //

    /**
     * Constructs a new Payday discount code and sets its code.
     */
    public Payday() {
        this.setCode(DiscountCode.CODE_LIST.get(2));
    }

    // -- Overridden Methods -- //

    /**
     * Checks if the discount code is applicable to the given reservation.
     * This discount is applicable if the reservation spans the 15th or the 30th of the month.
     *
     * @param reservation the reservation to check applicability for
     * @return true if the reservation spans the 15th or the 30th, false otherwise
     */
    @Override
    public boolean checkApplicability(Reservation reservation) {
        if(reservation.getCheckInDate() <= 15 && reservation.getCheckOutDate() > 15) {
            return true;
        }
        else if(reservation.getCheckInDate() <= 30 && reservation.getCheckOutDate() > 30) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Computes the discount amount for the given reservation.
     * This discount provides a 7% reduction on the total price.
     *
     * @param reservation the reservation to compute the discount for
     * @return the discount amount, which is 7% of the total price
     */
    @Override
    public float computeDiscount(Reservation reservation) {
        return reservation.computeTotalPrice() * 0.07f;
    }
}
