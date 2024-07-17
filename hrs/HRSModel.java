package hrs;

import java.util.ArrayList;

public class HRSModel {
    private ArrayList<Hotel> hotels;

    public HRSModel() {
        this.hotels = new ArrayList<>();
    }

    public void addHotel(Hotel hotel) {
        hotels.add(hotel);
    }

    public Hotel fetchHotel(int index) {
        return hotels.get(index);
    }

    public void removeHotel(int index) {
        hotels.remove(index);
    }

    public int countHotels() {
        return hotels.size();
    }

    public boolean isHotelNameUnique(String name) {
        for (Hotel hotel : hotels) {
            if (hotel.getHotelName().equals(name)) {
                return false;
            }
        }
        return true;
    }

    public ArrayList<Hotel> getHotels() {
        return hotels;
    }
}
