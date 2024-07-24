package hrs;

import java.util.*;

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

    // Original: Oldest to Newest
    public ArrayList<Hotel> getHotels() {
        return this.hotels;
    }

    // Most to Least Booked
    public ArrayList<Hotel> sortMostBooked() {
        ArrayList<Hotel> sorted = new ArrayList<>(this.hotels);
        int maxInd;

        for(int i = 0; i < this.countHotels(); i++) {
            maxInd = i;

            for(int j = i + 1; j < this.countHotels(); j++) {
                if(this.hotels.get(j).countReservations() > this.hotels.get(maxInd).countReservations()) {
                    maxInd = j;
                }
            }

            if(maxInd != i) {
                Collections.swap(sorted, i, maxInd);
            }
        }

        return sorted;
    }

    // Newest to Oldest
    public ArrayList<Hotel> sortNewest() {
        ArrayList<Hotel> sorted = new ArrayList<>(this.hotels);
        Collections.reverse(sorted);
        return sorted;
    }

    // Most to Least Expensive
    public ArrayList<Hotel> sortMostExpensive() {
        ArrayList<Hotel> sorted = new ArrayList<>(this.hotels);
        int maxInd;

        for(int i = 0; i < this.countHotels(); i++) {
            maxInd = i;

            for(int j = i + 1; j < this.countHotels(); j++) {
                if(this.hotels.get(j).getBasePrice() > this.hotels.get(maxInd).getBasePrice()) {
                    maxInd = j;
                }
            }

            if(maxInd != i) {
                Collections.swap(sorted, i, maxInd);
            }
        }

        return sorted;
    }

    // Least to Most Expensive
    public ArrayList<Hotel> sortLeastExpensive() {
        ArrayList<Hotel> sorted = this.sortMostExpensive();
        Collections.reverse(sorted);
        return sorted;
    }
}
