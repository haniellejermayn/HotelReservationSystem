package src.HRS.Model;

/**
 * Represents a discount code for employees, providing a 10% discount.
 */
public class IWorkHere extends DiscountCode {

    /**
     * Constructs a new IWorkHere discount code and sets its code.
     */
    public IWorkHere() {
        this.setCode(DiscountCode.CODE_LIST.get(0));
    }

    /**
     * Checks if the discount code is applicable to the given reservation.
     * This discount is always applicable.
     *
     * @param reservation the reservation to check applicability for
     * @return true, as this discount is always applicable
     */
    @Override
    public boolean checkApplicability(Reservation reservation) {
        return true;
    }

    /**
     * Computes the discount amount for the given reservation.
     * This discount provides a 10% reduction on the total price.
     *
     * @param reservation the reservation to compute the discount for
     * @return the discount amount, which is 10% of the total price
     */
    @Override
    public float computeDiscount(Reservation reservation) {
        return reservation.computeTotalPrice() * 0.10f;
    }
    
}
