package src.HRS.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents an abstract class for discount codes that can be applied to reservations.
 * It provides methods to check applicability and compute discounts for reservations.
 */
public abstract class DiscountCode {
    private String code;
    
    public static final List<String> CODE_LIST;

    // Static block to initialize code list
    static {
        ArrayList<String> tempList = new ArrayList<>();
        tempList.add("I_WORK_HERE");
        tempList.add("STAY4_GET1");
        tempList.add("PAYDAY");
        CODE_LIST = Collections.unmodifiableList(tempList);
    }

    // -- Public Abstract Methods -- //

    /**
     * Checks if the discount code is applicable to the given reservation.
     *
     * @param reservation the reservation to check applicability for
     * @return true if the discount code is applicable, false otherwise
     */
    public abstract boolean checkApplicability(Reservation reservation);

    /**
     * Computes the discount amount for the given reservation.
     *
     * @param reservation the reservation to compute the discount for
     * @return the discount amount
     */
    public abstract float computeDiscount(Reservation reservation);

    // -- Getter && Setter Methods -- //

    /**
     * Gets the discount code.
     *
     * @return the discount code
     */
    public String getCode() {
        return this.code;
    }

    /**
     * Sets the discount code.
     *
     * @param code the discount code to set
     */
    public void setCode(String code) {
        this.code = code;
    }
}
