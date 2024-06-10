package hrs;

import java.util.ArrayList;
import java.util.Scanner;

public class HotelReservationSystem {
    private ArrayList<Hotel> hotels;
    private int hotelsAmt;

    public HotelReservationSystem(int hotelsAmt) {
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
        
        roomAmt = promptOption(1, 50, "No. of Rooms");

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

    //Edit: add user interface
    public void viewHotel() {
        Hotel hotel;
        int option;

        if(this.hotels.isEmpty()) { // create isEmpty() function
            System.out.printf("\nNo hotels in list.\n");
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
                        showReservationInformation(hotel);
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
        System.out.printf("Booked Rooms: %d\n", hotel.countBookedRooms(date));
    }

    private void showRoomInformation(Hotel hotel) {
        int option;
        Room room;
        int[] roomAvailability;

        System.out.printf("\nRooms\n");

        for(int i = 0; i < hotel.getRoomAmt(); i++) {
            System.out.printf("%d - %s\n", i + 1, hotel.getRoom(i).getRoomName());
        }

        option = promptOption(1, hotel.getRoomAmt(), "Room No.");
        room = hotel.getRoom(option - 1);
        roomAvailability = hotel.checkRoomAvailability(room);

        System.out.printf("\n\"%s\"\n", room.getRoomName());
        System.out.printf("Name: %s\n", room.getRoomName());
        System.out.printf("Price per Night: %.2f\n", room.getBasePrice());
        System.out.printf("Available Dates: ");

        for(int i = 0; i < 31; i++) {
            if(roomAvailability[i] == 0) {
                System.out.printf("%d ", i + 1);
            }
        }

        System.out.printf("\n");
    }

    private void showReservationInformation(Hotel hotel) {
        int option;
        Reservation reservation;

        if(hotel.getReservationAmt() == 0) {
            System.out.printf("No Reservations\n");
        }
        else {
            System.out.printf("\nReservations\n");

            for(int i = 0; i < hotel.getReservationAmt(); i++) {
                System.out.printf("%d - %s (%d to %d)\n", i + 1, hotel.getReservation(i), 
                        hotel.getReservation(i).getCheckInDate(), hotel.getReservation(i).getCheckOutDate());
            }

            option = promptOption(1, hotel.getReservationAmt(), "Reservation No.");
            reservation = hotel.getReservation(option - 1);

            System.out.printf("\n\"%s's Reservation\"\n", reservation.getGuestName());
            System.out.printf("Guest Name: %s\n", reservation.getGuestName());
            System.out.printf("Check-In Date: %d\n", reservation.getCheckInDate());
            System.out.printf("Check-Out Date: %d\n", reservation.getCheckOutDate());
            System.out.printf("Price per Night: %.2f\n", reservation.getCostPerNight());
            System.out.printf("Total Price: %.2f\n", reservation.getTotalPrice());
        }
    }

    public void manageHotel() {
        Hotel hotel;
        int hotelOption, menuOption;
        
        if(this.hotels.isEmpty()) { // create isEmpty() function
            System.out.printf("\nNo hotels in list.\n");
        }
        else {
            System.out.printf("\nHotels\n");
            for(int i = 0; i < this.hotels.size(); i++) {
                System.out.printf("%d - %s\n", i + 1, this.hotels.get(i).getHotelName());
            }
            
            hotelOption = promptOption(1, this.hotels.size(), "Hotel No.");
            hotel = this.hotels.get(hotelOption - 1);
            
            System.out.printf("-------------------------------------\n");
            
            do { 

                System.out.printf("Menu\n");
                System.out.printf("1 - Change Name\n");
                System.out.printf("2 - Add Room\n");
                System.out.printf("3 - Remove Room\n");
                System.out.printf("4 - Update Base Price\n");
                System.out.printf("5 - Remove Reservation\n");
                System.out.printf("6 - Remove Hotel\n");
                System.out.printf("0 - Go Back\n");

                menuOption = promptOption(0, 6, "Option");

                //Edit: complete switch function
                switch (menuOption) {
                    case 1: 
                        changeHotelName(hotel);
                        break;
                    case 2:
                        addRoom(hotel);
                        break;
                    case 3:
                        removeRoom(hotel);
                        break;
                    case 4:
                        updateBasePrice(hotel);
                        break;
                    case 5:
                        removeReservation(hotel);
                        break;
                    case 6: 
                        removeHotel(hotelOption - 1);
                        break;
                    default:
                        break;
                }

            } while (menuOption != 0);
        }
    }

    // should we add a cancel option
    private void changeHotelName(Hotel hotel) {
        Scanner sc = new Scanner(System.in);
        String newName;

        do { 
            System.out.printf("Enter new Hotel Name: ");
            newName = sc.nextLine();

            if(validateHotelName(newName) == 0) {
                System.out.printf("Error: Hotel name already taken.\n");
            }
        } while (validateHotelName(newName) == 0);

        if (confirmMod() == 1) {
            hotel.setHotelName(newName);
            System.out.printf("Hotel name has been changed to \"%s\"", newName);
        }
        else {
            System.out.printf("Hotel name remained as \"%s\"", hotel.getHotelName());
        }
    }

    private void addRoom(Hotel hotel) {
        if (confirmMod() == 1) {
            hotel.addRoom();
            System.out.printf("\nNew room has been added!\n");
        }
        else {
            System.out.printf("\nNo new room has been added.\n");
        }
    }

    private void removeRoom(Hotel hotel) { 
        int option;
        Room room;
        int[] roomAvailability;
        boolean booked = false;
        
        option = promptOption(1, hotel.getRoomAmt(), "Room No.");
        room = hotel.getRoom(option - 1);
        roomAvailability = hotel.checkRoomAvailability(room);

        for(int i = 0; i < 31; i++) {
            if(roomAvailability[i] == 1) {
                booked = true;
            }
        }
        
        if (!booked) { // room has no reservation
            if (confirmMod() == 1) {
                hotel.removeRoom(option - 1);
                System.out.printf("\nRoom has been removed\n");
            } 
            else {
                System.out.printf("\nRoom has been retained\n");
            }
        }
        else {
            System.out.printf("\nRoom is currently booked.\n");
        }
    }

    private void updateBasePrice(Hotel hotel) {
        Scanner sc = new Scanner(System.in);
        float newPrice;

        if (hotel.getReservationAmt() == 0) {
            System.out.printf("\nEnter new base price for rooms: ");
            newPrice = promptPrice();
        }
        else {
            System.out.printf("\nThere are currently reservations in the hotel. Base price cannot be changed.\n");
        }
    }

    private float promptPrice() {
        Scanner sc = new Scanner(System.in);
        float price;
        
        do { 
            System.out.printf("Enter New Price: ");
            price = sc.nextFloat();

            if(price < 100.0f) {
                System.out.printf("Error: Price should be >= 100.0");
            }
        } while (price < 100.0f);

        return price;
    }
    private void removeReservation(int hotel) { // should the user input the room name?
        int reservationIndex = -1;

        if (this.hotels.get(hotel).getReservationAmt() != 0) {
            
            // get room of reservation
            reservationIndex = this.hotels.get(hotel).getRoomIndex();
            int option = promptOption(1, hotel.getRoomAmt(), "Room No.");
            Room room = hotel.getRoom(option - 1);
            int[] roomAvailability = this.hotels.get(hotel).checkRoomAvailability(room);

            if (reservationIndex != -1) {
                if (roomAvailability[reservationIndex] == 1) { // checks if the room has a reservation 
                    if (confirmMod()) {
                        this.hotels.get(hotel).reservations.remove(reservationIndex);
                        System.out.printf("\nReservation has been removed.\n");
                    }
                    else {
                        System.out.printf("\nReservation has been retained.\n");
                    }
                }
                else {
                    Sytem.out.printf("This room does not have a current reservation.\n");
                }
            }
        }
        else {
            System.out.printf("\nThere are currently no reservations in the hotel.\n");
        }
    }

    private void removeHotel(int hotel) {
        if (confirmMod()) {
            this.hotels.remove(hotel);
            System.out,printf("\nHotel no. %d has been removed.\n", hotel + 1);
        }
        else {
            System.out,printf("\nHotel no. %d has been retained.\n", hotel + 1);
        }
    }

    private int confirmMod() {
        Scanner sc = new Scanner(System.in);
        int option;
        
        do { 
            System.out.printf("Confirm modification?\n");
            System.out.printf("[1] Yes\n");
            System.out.printf("[0] No (The modification will be discarded)\n");
            option = sc.nextInt();

            if(option < 0 || option > 1) {
                System.out.printf("Error: Options are only 0 or 1.\n");
            }
        } while (option < 0 || option > 1);

        return option;
    }
}
