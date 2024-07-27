package src.HRS.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    public abstract boolean checkApplicability(Reservation reservation);
    public abstract float computeDiscount(Reservation reservation);

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
