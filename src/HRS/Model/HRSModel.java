package src.HRS.Model;

import java.util.*;

/**
 * The HRSModel class represents a model for managing a collection of hotels.
 * It provides methods to add, fetch, remove, and count hotels, as well as to
 * sort hotels based on different criteria such as booking count and price.
 */
public class HRSModel {
    private ArrayList<Hotel> hotels;

    // -- Constructor -- //

    /**
     * Constructs an HRSModel with an empty list of hotels.
     */
    public HRSModel() {
        this.hotels = new ArrayList<>();
    }

    // -- Public Methods -- //

    /**
     * Adds a hotel to the list of hotels.
     *
     * @param hotel the Hotel object to add
     */
    public void addHotel(Hotel hotel) {
        hotels.add(hotel);
    }

    /**
     * Fetches a hotel by its index in the list.
     *
     * @param index the index of the hotel to fetch
     * @return the Hotel object at the specified index
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public Hotel fetchHotel(int index) {
        return hotels.get(index);
    }

    /**
     * Removes a hotel by its index in the list.
     *
     * @param index the index of the hotel to remove
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public void removeHotel(int index) {
        hotels.remove(index);
    }

    /**
     * Returns the number of hotels in the hotels list.
     *
     * @return the number of hotels
     */

    public int countHotels() {
        return hotels.size();
    }

    /**
     * Checks if a hotel name is unique.
     *
     * @param name the name of the hotel to check
     * @return true if the hotel name is unique, false otherwise
     */
    public boolean isHotelNameUnique(String name) {
        for (Hotel hotel : hotels) {
            if (hotel.getHotelName().equals(name)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns the list of hotels in the model.
     * The hotels are returned in the order they were added (oldest to newest).
     *
     * @return the list of hotels
     */
    public ArrayList<Hotel> getHotels() {
        return this.hotels;
    }

    /**
     * Returns a list of hotels sorted from newest to oldest.
     *
     * @return the list of hotels sorted from newest to oldest
     */
    public ArrayList<Hotel> sortNewest() {
        ArrayList<Hotel> sorted = new ArrayList<>(this.hotels);
        Collections.reverse(sorted);
        return sorted;
    }

     /**
     * Returns a list of hotels sorted from most to least booked.
     *
     * @return the list of hotels sorted from most to least booked
     */
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

    /**
     * Returns a list of hotels sorted from least to most booked.
     *
     * @return the list of hotels sorted from least to most booked
     */
    public ArrayList<Hotel> sortLeastBooked() {
        ArrayList<Hotel> sorted = this.sortMostBooked();
        Collections.reverse(sorted);
        return sorted;
    }

    /**
     * Returns a list of hotels sorted from most to least expensive.
     *
     * @return the list of hotels sorted from most to least expensive
     */
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

    /**
     * Returns a list of hotels sorted from least to most expensive.
     *
     * @return the list of hotels sorted from least to most expensive
     */
    public ArrayList<Hotel> sortLeastExpensive() {
        ArrayList<Hotel> sorted = this.sortMostExpensive();
        Collections.reverse(sorted);
        return sorted;
    }
}
