package hrs;

import java.util.ArrayList;
import java.util.Scanner;

public class HotelReservationSystem {
    private ArrayList<Hotel> hotels;

    // -- Constructor -- //

    public HotelReservationSystem() {
        this.hotels = new ArrayList<Hotel>();
    }

    // -- Public Methods -- //

    public void createHotel() {
        Scanner sc = new Scanner(System.in);
        String hotelName;
        int roomAmt;

        //Edit: Should we add an exit signal for all input?
        do { 
            System.out.printf("Enter Hotel Name: ");
            hotelName = sc.nextLine();

            if(!validateHotelName(hotelName)) {
                System.out.printf("Error: Hotel name already taken.\n");
            }
        } while (!validateHotelName(hotelName));
        
        roomAmt = promptOption(1, 50, "No. of Rooms");

        //add hotel to list
        this.hotels.add(new Hotel(hotelName, roomAmt));

        System.out.printf("%s added!\n", hotelName);

        System.out.printf("-------------------------------------\n");
    }

    public void viewHotel() {
        Hotel hotel;
        int option;

        if(this.hotels.isEmpty()) { 
            System.out.printf("No hotels in list.\n");
        }
        else {
            System.out.printf("Hotels\n");
            for(int i = 0; i < this.hotels.size(); i++) {
                System.out.printf("[%d] %s\n", i + 1, this.hotels.get(i).getHotelName());
            }
            
            option = promptOption(1, this.hotels.size(), "Hotel No.");
            hotel = this.hotels.get(option - 1);

            System.out.printf("-------------------------------------\n");
            System.out.printf("\"%s\"\n", hotel.getHotelName());
            System.out.printf("Name: %s\n", hotel.getHotelName());
            System.out.printf("No. of Rooms: %d\n", hotel.countRooms());
            System.out.printf("Month's Estimated Earnings: %.2f\n", hotel.computeEarnings());

            System.out.printf("-------------------------------------\n");

            do { 
                System.out.printf("Menu\n");
                System.out.printf("[1] Date Availability\n");
                System.out.printf("[2] Room Information\n");
                System.out.printf("[3] Reservation Information\n");
                System.out.printf("[0] Go Back\n");

                option = promptOption(0, 3, "Option");

                System.out.printf("-------------------------------------\n");

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

    public void manageHotel() {
        Hotel hotel;
        int hotelOption, menuOption;
        
        if(this.hotels.isEmpty()) { 
            System.out.printf("No hotels in list.\n");
        }
        else {
            System.out.printf("Hotels\n");
            for(int i = 0; i < this.hotels.size(); i++) {
                System.out.printf("[%02d] %s\n", i + 1, this.hotels.get(i).getHotelName());
            }
            
            hotelOption = promptOption(1, this.hotels.size(), "Hotel No.");
            hotel = this.hotels.get(hotelOption - 1);
            
            do { 
                System.out.printf("-------------------------------------\n");
                System.out.printf("Menu\n");
                System.out.printf("[1] Change Name\n");
                System.out.printf("[2] Add Room\n");
                System.out.printf("[3] Remove Room\n");
                System.out.printf("[4] Update Base Price\n");
                System.out.printf("[5] Remove Reservation\n");
                System.out.printf("[6] Remove Hotel\n");
                System.out.printf("[0] Go Back\n");

                menuOption = promptOption(0, 6, "Option");

                System.out.printf("-------------------------------------\n");

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
                        menuOption = removeHotel(hotelOption - 1);
                        break;
                    default:
                        break;
                }

            } while (menuOption != 0);
        }
    }

    public void bookRoom() {
        int hotelOption;
        Hotel hotel;
        int roomIndex;

        String guestName;
        int checkInDate, checkOutDate;
        Room room;


        if(this.hotels.isEmpty()) {
            System.out.printf("No hotels to book.\n");
        }
        else {
            System.out.printf("Hotels\n");
            for(int i = 0; i < this.hotels.size(); i++) {
                System.out.printf("[%02d] %s\n", i + 1, this.hotels.get(i).getHotelName());
            }

            hotelOption = promptOption(1, this.hotels.size(), "Hotel No.");
            hotel = this.hotels.get(hotelOption - 1);
            
            System.out.printf("-------------------------------------\n");

            guestName = promptGuestName();
            checkInDate = promptOption(1, 30, "Check-in Date");
            checkOutDate = promptOption(checkInDate + 1, 31, "Check-out Date");

            roomIndex = hotel.checkDateAvailability(checkInDate, checkOutDate);

            if(roomIndex == -1) {
                System.out.printf("No rooms available given check-in and check-out dates.\n");
            }
            else {
                room = hotel.fetchRoom(roomIndex);
                hotel.addReservation(guestName, checkInDate, checkOutDate, room);

                System.out.printf("Reservation saved!\n");
            }

            System.out.printf("-------------------------------------\n");
        }
    }

    // -- Private Methods -- //

    private boolean validateHotelName(String name) {
        boolean result = true;

        for(int i = 0; i < hotels.size() && result == true; i++) {
            if(name.equals(hotels.get(i).getHotelName())) {
                result = false;
            }
        }

        return result;
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

    private String promptGuestName() {
        Scanner sc = new Scanner(System.in);
        String guestName;

        do { 
            System.out.printf("Enter Guest Name: ");
            guestName = sc.nextLine();

            if(guestName.length() == 0) {
                System.out.printf("Error: Guest name should be at least 1 character.\n");
            }
        } while(guestName.length() == 0);

        return guestName;
    }

    private int confirmMod() {
        Scanner sc = new Scanner(System.in);
        int option;
        
        do { 
            System.out.printf("-------------------------------------\n");
            System.out.printf("Confirm modification?\n");
            System.out.printf("[1] Yes\n");
            System.out.printf("[0] No (The modification will be discarded)\n");
            System.out.printf("Enter option: ");
            option = sc.nextInt();

            if(option < 0 || option > 1) {
                System.out.printf("Error: Options are only 0 or 1.\n");
            }
        } while (option < 0 || option > 1);

        System.out.printf("-------------------------------------\n");

        return option;
    }

    private void showDateAvailability(Hotel hotel) {
        int date = promptOption(1, 30, "Date");
        System.out.printf("Available Rooms: %d\n", hotel.countAvailableRooms(date));
        System.out.printf("Booked Rooms: %d\n", hotel.countBookedRooms(date));
        System.out.printf("-------------------------------------\n");
    }

    private void showRoomInformation(Hotel hotel) {
        int option;
        Room room;
        int[] roomAvailability;
        int dayCounter = 0;

        System.out.printf("Rooms\n");

        for(int i = 0; i < hotel.countRooms(); i++) {
            System.out.printf("[%02d] %s\n", i + 1, hotel.fetchRoom(i).getRoomName());
        }

        option = promptOption(1, hotel.countRooms(), "Room No.");
        room = hotel.fetchRoom(option - 1);
        roomAvailability = hotel.checkRoomAvailability(room);

        System.out.printf("-------------------------------------\n");
        System.out.printf("\"%s\"\n", room.getRoomName());
        System.out.printf("Name: %s\n", room.getRoomName());
        System.out.printf("Price per Night: %.2f\n", room.getBasePrice());
        System.out.printf("Available Dates:\n");

        for(int i = 0; i < 30; i++) {
            if(roomAvailability[i] == 0) {
                System.out.printf("[%02d] ", i + 1);
                dayCounter += 1;
            }

            if(dayCounter % 5 == 0 && dayCounter > 0) {
                System.out.printf("\n");
            }
        }

        if(dayCounter == 0) {
            System.out.printf("No available dates.");
        }

        System.out.printf("\n");
        System.out.printf("-------------------------------------\n");
    }

    private void showReservationInformation(Hotel hotel) {
        int option;
        Reservation reservation;

        if(hotel.countReservations() == 0) {
            System.out.printf("No Reservations\n");
        }
        else {
            System.out.printf("Reservations\n");

            for(int i = 0; i < hotel.countReservations(); i++) {
                System.out.printf("[%02d] %s (%d to %d)\n", i + 1, hotel.fetchReservation(i).getGuestName(), 
                        hotel.fetchReservation(i).getCheckInDate(), hotel.fetchReservation(i).getCheckOutDate());
            }

            option = promptOption(1, hotel.countReservations(), "Reservation No.");
            reservation = hotel.fetchReservation(option - 1);

            System.out.printf("-------------------------------------\n");
            System.out.printf("\"%s's Reservation\"\n", reservation.getGuestName());
            System.out.printf("Guest Name: %s\n", reservation.getGuestName());
            System.out.printf("Room: %s\n", reservation.getRoom().getRoomName());
            System.out.printf("Check-In Date: %d\n", reservation.getCheckInDate());
            System.out.printf("Check-Out Date: %d\n", reservation.getCheckOutDate());
            System.out.printf("Price per Night: %.2f\n", reservation.retrieveCostPerNight());
            System.out.printf("Total Price: %.2f\n", reservation.computeTotalPrice());
        }

        System.out.printf("-------------------------------------\n");
    }

    //Edit: should we add a cancel option
    private void changeHotelName(Hotel hotel) {
        Scanner sc = new Scanner(System.in);
        String newName;

        do { 
            System.out.printf("Enter new Hotel Name: ");
            newName = sc.nextLine();

            //Edit: consider if same as original name is entered (currently an error)
            if(!validateHotelName(newName)) {
                System.out.printf("Error: Hotel name already taken.\n");
            }
        } while (!validateHotelName(newName));

        if (confirmMod() == 1) {
            hotel.setHotelName(newName);
            System.out.printf("Hotel name has been changed to \"%s\"\n", newName);
        }
        else {
            System.out.printf("Hotel name remained as \"%s\"\n", hotel.getHotelName());
        }
    }

    private void addRoom(Hotel hotel) {
        if (confirmMod() == 1) {
            hotel.addRoom();
            System.out.printf("New room has been added!\n");
        }
        else {
            System.out.printf("No new room has been added.\n");
        }
    }

    private void removeRoom(Hotel hotel) { 
        int option;
        Room room;
        int[] roomAvailability;
        boolean booked = false;

        if(hotel.countRooms() == 1) {
            System.out.printf("Error: can't delete the only room in the hotel.\n");
        }
        else {
            System.out.printf("Rooms\n");

            for(int i = 0; i < hotel.countRooms(); i++) {
                System.out.printf("[%02d] %s\n", i + 1, hotel.fetchRoom(i).getRoomName());
            }
            
            option = promptOption(1, hotel.countRooms(), "Room No.");
            room = hotel.fetchRoom(option - 1);
            roomAvailability = hotel.checkRoomAvailability(room);

            for(int i = 0; i < 30; i++) {
                if(roomAvailability[i] == 1) {
                    booked = true;
                }
            }
            
            if (!booked) { // room has no reservation
                if (confirmMod() == 1) {
                    hotel.removeRoom(option - 1);
                    System.out.printf("Room has been removed\n");
                } 
                else {
                    System.out.printf("Room has been retained\n");
                }
            }
            else {
                System.out.printf("Room is currently booked.\n");
            }
        }
    }

    private void updateBasePrice(Hotel hotel) {
        Scanner sc = new Scanner(System.in);
        float newPrice;

        if (hotel.countReservations() == 0) {
            newPrice = promptPrice();
            hotel.updateRoomPrice(newPrice);
            System.out.printf("Base Price updated!\n");
        }
        else {
            System.out.printf("There are currently reservations in the hotel. Base price cannot be changed.\n");
        }
    }

    private void removeReservation(Hotel hotel) {
        int option;

        if (hotel.countReservations() != 0) {   
            
            System.out.printf("Reservations\n");

            for(int i = 0; i < hotel.countReservations(); i++) {
                System.out.printf("[02d] %s (%d to %d)\n", i + 1, hotel.fetchReservation(i).getGuestName(), 
                        hotel.fetchReservation(i).getCheckInDate(), hotel.fetchReservation(i).getCheckOutDate());
            }

            option = promptOption(1, hotel.countReservations(), "Reservation No.");

            if (confirmMod() == 1) {
                hotel.removeReservation(option - 1);
                System.out.printf("Reservation has been removed.\n");
            }
            else {
                System.out.printf("Reservation has been retained.\n");
            }
        }
        else {
            System.out.printf("There are currently no reservations in the hotel.\n");
        }
    }

    private int removeHotel(int index) {
        if (confirmMod() == 1) {
            this.hotels.remove(index);
            System.out.printf("Hotel no. %d has been removed.\n", index + 1);
            System.out.printf("-------------------------------------\n");
            return 0;
        }
        else {
            System.out.printf("Hotel no. %d has been retained.\n", index + 1);
            System.out.printf("-------------------------------------\n");
            return 1;
        }
    }
}
