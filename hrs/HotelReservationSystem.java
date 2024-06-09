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
            if(name.equals(hotels.get(i).getHotelName())) {
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
    public void viewHotel() {
        Hotel hotel;
        int option;

        if(this.hotels.isEmpty()) {
            System.out.printf("\nError: No hotels in list.\n");
        }
        else {
            System.out.printf("\nHotels\n");
            for(int i = 0; i < this.hotels.size(); i++) {
                System.out.printf("%d - %s\n", i + 1, this.hotels.get(i).getHotelName());
            }
            
            option = promptOption(1, this.hotels.size(), "Hotel No.");
            hotel = this.hotels.get(option - 1);

            System.out.printf("\n\"%s\"\n", hotel.getHotelName());
            System.out.printf("Name: %s\n", hotel.getHotelName());
            System.out.printf("No. of Rooms: %d\n", hotel.getRoomAmt());
            System.out.printf("Month's Estimated Earnings: %.2f\n", hotel.computeEarnings());

            System.out.printf("-------------------------------------\n");

            do { 
                System.out.printf("Menu\n");
                System.out.printf("1 - Date Availability\n");
                System.out.printf("2 - Room Information\n");
                System.out.printf("3 - Reservation Information\n");
                System.out.printf("0 - Go Back\n");

                option = promptOption(0, 3, "Option");

                //Edit: complete switch function
                switch (option) {
                    case 1:
                        showDateAvailability(hotel);
                        break;
                    case 2:
                        showRoomInformation(hotel);
                        break;
                    case 3:
                        break;
                    default:
                        break;
                }

            } while (option != 0);
            
        }
    }

    private int promptOption(int start, int end, String str) {
        Scanner sc = new Scanner(System.in);
        int option;
        
        do { 
            System.out.printf("Enter %s: ", str);
            option = sc.nextInt();

            if(option < start || option > end) {
                if(start == end) {
                    System.out.printf("Error: Only option is %d.\n", start);
                }
                else {
                    System.out.printf("Error: Options are only from %d to %d.\n", start, end);
                }
                
            }
        } while (option < start || option > end);

        return option;
    }

    private void showDateAvailability(Hotel hotel) {
        int date = promptOption(1, 31, "Date");
        System.out.printf("Available Rooms: %d\n", hotel.countAvailableRooms(date));
        System.out.printf("Available Rooms: %d\n", hotel.countBookedRooms(date));
    }

    private void showRoomInformation(Hotel hotel) {
        int option;
        Room room;
        int[] roomAvailability;

        System.out.printf("\nRooms\n");

        for(int i = 0; i < hotel.getRoomAmt(); i++) {
            System.out.printf("%d - %s\n", i + 1, hotel.getRoom(i));
        }

        option = promptOption(1, hotel.getRoomAmt(), "Room No.");
        room = hotel.getRoom(option - 1);
        roomAvailability = hotel.checkRoomAvailability(room);

        System.out.printf("/n\"%s\"\n", room.getRoomName());
        System.out.printf("Name: %s\n", room.getRoomName());
        System.out.printf("Price per Night: %f\n", room.getBasePrice());
        System.out.printf("Available Dates: ");

        for(int i = 0; i < 31; i++) {
            if(roomAvailability[i] == 0) {
                System.out.printf("%d ", i + 1);
            }
        }

        System.out.printf("\n");
    }

    private void showReservationInformation() {
        
    }


}
