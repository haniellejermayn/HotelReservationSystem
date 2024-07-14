package hrs;

public class Stay4Get1 extends DiscountCode {
    
    public Stay4Get1() {
        this.setCode(DiscountCode.CODE_LIST.get(1));
    }

    @Override
    public boolean checkApplicability(Reservation reservation) {
        if(reservation.getCheckOutDate() - reservation.getCheckInDate() >= 5) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public float computeDiscount(Reservation reservation) {
        return reservation.retrieveCostPerNight();
    }
}
