package src.HRS.Model;

public class IWorkHere extends DiscountCode {

    public IWorkHere() {
        this.setCode(DiscountCode.CODE_LIST.get(0));
    }

    @Override
    public boolean checkApplicability(Reservation reservation) {
        return true;
    }

    @Override
    public float computeDiscount(Reservation reservation) {
        return reservation.computeTotalPrice() * 0.10f;
    }
    
}
