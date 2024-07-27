package src.HRS.TestPackage;

public class Payday extends DiscountCode {
    
    public Payday() {
        this.setCode(DiscountCode.CODE_LIST.get(2));
    }

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

    @Override
    public float computeDiscount(Reservation reservation) {
        return reservation.computeTotalPrice() * 0.07f;
    }
}
