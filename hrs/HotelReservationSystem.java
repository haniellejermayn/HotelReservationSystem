package hrs;

import java.util.ArrayList;

public class HotelReservationSystem {
    private ArrayList<Hotel> hotels;

    public HotelReservationSystem() {
        this.hotels = new ArrayList<Hotel>();
    }

    //returns 1 if valid and 0 otherwise
    public int validateHotelName(String name) {
        int result = 0;

        for(int i = 0; i < hotels.size() && result == 0; i++) {
            if(name == hotels.get(i).getHotelName()) {
                result = 1;
            }
        }

        return result;
    }
}
