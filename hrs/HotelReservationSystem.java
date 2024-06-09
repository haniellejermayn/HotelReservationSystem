package hrs;

import java.util.ArrayList;
import java.util.Scanner;

public class HotelReservationSystem {
    private ArrayList<Hotel> hotels;

    public HotelReservationSystem() {
        this.hotels = new ArrayList<Hotel>();
    }

    public void createHotel() {
        Scanner sc = new Scanner(System.in);
        String hotelName;
        int roomAmt;

        //Edit: Should we add an exit signal for all input?
        do { 
            System.out.printf("Enter Hotel Name: ");
            hotelName = sc.nextLine();

            if(validateHotelName(hotelName) == 0) {
                System.out.printf("Error: Hotel name already taken.\n");
            }
        } while (validateHotelName(hotelName) == 0);
        
        do { 
            System.out.printf("Enter Number of Rooms: ");
            roomAmt = sc.nextInt();

            if(validateRoomAmt(roomAmt) == 0) {
                System.out.printf("Error: No. of rooms should be 1 to 50.\n");
            }
        } while (validateRoomAmt(roomAmt) == 0);

        //add hotel to list
        this.hotels.add(new Hotel(hotelName, roomAmt));

        System.out.printf("%s added!\n", hotelName);
    }

    //returns 1 if valid and 0 otherwise
    private int validateHotelName(String name) {
        int result = 1;

        for(int i = 0; i < hotels.size() && result == 0; i++) {
            if(name == hotels.get(i).getHotelName()) {
                result = 0;
            }
        }

        return result;
    }

    //returns 1 if valid and 0 otherwise
    private int validateRoomAmt(int roomAmt) {
        if(roomAmt >= 1 && roomAmt <= 50) {
            return 1;
        }
        else {
            return 0;
        }
    }

    //add user interface
    public void viewHotel(Hotel hotel) {
        System.out.printf("\n\"%s\"\n", hotel.getHotelName());
        System.out.printf("Name: %s\n", hotel.getHotelName());
        System.out.printf("No. of Rooms: %d\n", hotel.getRoomAmt());
        System.out.printf("Month's Estimate Earnings: %.2f\n", hotel.computeEarnings());
        System.out.printf("-------------------------------------\n");

    }

    public Hotel getHotel(int index) {
        return this.hotels.get(index);
    }
}
