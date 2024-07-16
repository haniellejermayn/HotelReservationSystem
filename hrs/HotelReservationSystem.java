package hrs;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * The HotelReservationSystem class represents a system for managing hotel reservations.
 * It allows creating hotels, viewing and managing hotels, and booking rooms.
 */
public class HotelReservationSystem {
    private ArrayList<Hotel> hotels;

    // -- Constructor -- //

    /**
     * Constructs a new HotelReservationSystem with an empty list of hotels.
     * Initializes the hotel list as an ArrayList of Hotel objects.
     */
    public HotelReservationSystem() {
        this.hotels = new ArrayList<Hotel>();
    }

    // -- Public Methods -- //

    /**
     * Prompts the user to enter details for a new hotel and adds it to the hotel list.
     * Ensures the hotel name is unique and prompts for the number of rooms.
     */
    public void createHotel() {
        Scanner sc = new Scanner(System.in);
        String hotelName;
        int standardAmount, deluxeAmount, executiveAmount;

        do { 
            System.out.printf("*Enter 0 to cancel*\n");
            System.out.printf("-------------------------------------\n");
            System.out.printf("Enter Hotel Name: ");
            hotelName = sc.nextLine();

            if(!validateHotelName(hotelName)) {
                System.out.printf("Error: Hotel name already taken.\n");
                System.out.printf("-------------------------------------\n");
            }
        } while (!validateHotelName(hotelName) && !hotelName.equals("0"));
        
        if (!hotelName.equals("0")) {
            do { 
                standardAmount = promptOption(0, 50, "No. of Standard Rooms");
                deluxeAmount = promptOption(0, 50 - standardAmount, "No. of Deluxe Rooms");
                executiveAmount = promptOption(0, 50 - standardAmount - deluxeAmount, "No. of Executive Rooms");

                if(standardAmount + deluxeAmount + executiveAmount == 0) {
                    System.out.printf("Error: A hotel needs at least 1 room.\n");
                    System.out.printf("-------------------------------------\n");
                }
            } while (standardAmount + deluxeAmount + executiveAmount == 0);
    
            //add hotel to list
            this.hotels.add(new Hotel(hotelName, standardAmount, deluxeAmount, executiveAmount));
    
            System.out.printf("%s added!\n", hotelName);
        }
        else {
            System.out.printf("\nCanceling...\n");
        }

        System.out.printf("-------------------------------------\n");
    }

    /**
     * Displays the list of hotels and prompts the user to select one.
     * Shows detailed information (low-level and high-level) about the selected hotel including
     * available rooms, room information, and reservation information.
     */
    public void viewHotel() {
        Hotel hotel;
        int option;

        if(this.hotels.isEmpty()) { 
            System.out.printf("No hotels in list.\n");
            System.out.printf("-------------------------------------\n");
        }
        else {
            System.out.printf("Hotels\n");
            for(int i = 0; i < this.hotels.size(); i++) {
                System.out.printf("[%02d] %s\n", i + 1, this.hotels.get(i).getHotelName());
            }
            
            option = promptOption(1, this.hotels.size(), "Hotel No.");
            hotel = this.hotels.get(option - 1);

            do { 
                System.out.printf("-------------------------------------\n");
                System.out.printf("\"%s\"\n", hotel.getHotelName());
                System.out.printf("Name: %s\n", hotel.getHotelName());
                System.out.printf("No. of Rooms: %d\n", hotel.countRooms(0));
                System.out.printf("Month's Estimated Earnings: %.2f\n", hotel.computeEarnings());
                System.out.printf("-------------------------------------\n");
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

    /**
     * Allows the user to manage an existing hotel by changing its name, adding or removing rooms,
     * updating room prices, removing reservations, or removing the hotel itself.
     */
    public void manageHotel() {
        Hotel hotel;
        int hotelOption, menuOption;
        
        if(this.hotels.isEmpty()) { 
            System.out.printf("No hotels in list.\n");
            System.out.printf("-------------------------------------\n");
        }
        else {
            System.out.printf("Hotels\n");
            for(int i = 0; i < this.hotels.size(); i++) {
                System.out.printf("[%02d] %s\n", i + 1, this.hotels.get(i).getHotelName());
            }
            
            hotelOption = promptOption(1, this.hotels.size(), "Hotel No.");
            hotel = this.hotels.get(hotelOption - 1);
            
            System.out.printf("-------------------------------------\n");
            
            do { 
                System.out.printf("-------------------------------------\n");
                System.out.printf("Manage \"%s\"\n", hotel.getHotelName());
                System.out.printf("[1] Change Name\n");
                System.out.printf("[2] Add Room\n");
                System.out.printf("[3] Remove Room\n");
                System.out.printf("[4] Update Base Price\n");
                System.out.printf("[5] Edit Date Price Modifier\n");
                System.out.printf("[6] Remove Reservation\n");
                System.out.printf("[7] Remove Hotel\n");
                System.out.printf("[0] Go Back\n");

                menuOption = promptOption(0, 6, "Option");

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
                        editDatePriceModifier(hotel);
                        break;
                    case 6:
                        removeReservation(hotel);
                        break;
                    case 7: 
                        menuOption = removeHotel(hotelOption - 1);
                        break;
                    default:
                        break;
                }

            } while (menuOption != 0);

            System.out.printf("-------------------------------------\n");
        }
    }

    /**
     * Prompts the user to select a hotel and book a room by providing the guest name, check-in, and check-out dates.
     * If a room is available for the specified dates, the reservation is saved.
     */
    public void bookRoom() {
        int hotelOption;
        Hotel hotel;
        int roomIndex;
        
        String guestName;
        int checkInDate, checkOutDate;
        int roomType;
        Room room;
        DiscountCode discountCode;


        if(this.hotels.isEmpty()) {
            System.out.printf("No hotels to book.\n");
            System.out.printf("-------------------------------------\n");
        }
        else {
            System.out.printf("*Enter 0 to cancel*\n");
            System.out.printf("-------------------------------------\n");
            System.out.printf("Hotels\n");
            for(int i = 0; i < this.hotels.size(); i++) {
                System.out.printf("[%02d] %s\n", i + 1, this.hotels.get(i).getHotelName());
            }

            hotelOption = promptOption(0, this.hotels.size(), "Hotel No.");

            if (hotelOption != 0) {
                hotel = this.hotels.get(hotelOption - 1);
                
                System.out.printf("-------------------------------------\n");
    
                guestName = promptGuestName();
                checkInDate = promptOption(1, 30, "Check-in Date");
                checkOutDate = promptOption(checkInDate + 1, 31, "Check-out Date");

                System.out.printf("\nSelect Room Type\n");
                System.out.printf("[1] Standard\n");
                System.out.printf("[2] Deluxe\n");
                System.out.printf("[3] Executive\n");

                do { 
                    roomType = promptOption(0, 3, "Option");

                    if(hotel.countRooms(roomType) == 0) {
                        System.out.printf("There are no rooms of this type in this hotel.\n\n");
                    }
                } while (hotel.countRooms(roomType) == 0);

                roomIndex = hotel.checkDateAvailability(checkInDate, checkOutDate, roomType);
    
                System.out.printf("-------------------------------------\n");

                if(roomIndex == -1) {
                    switch (roomType) {
                        case 1: System.out.printf("No Standard room available given the check-in and check-out dates.\n"); break;
                        case 2: System.out.printf("No Deluxe room available given the check-in and check-out dates.\n"); break;
                        case 3: System.out.printf("No Executive room available given the check-in and check-out dates.\n"); break;
                    }
                }
                else {
                    room = hotel.fetchRoom(roomIndex);
                    hotel.addReservation(guestName, checkInDate, checkOutDate, room);

                    System.out.printf("Do you have a discount code?\n");
                    System.out.printf("[1] Yes\n");
                    System.out.printf("[0] No\n");
                    hotelOption = promptOption(0, 1, "Option");
                    
                    if(hotelOption == 1) {
                        discountCode = promptDiscountCode(hotel);
                        
                        if(discountCode == null) {
                            System.out.printf("\nNo discount was applied.\n");
                        }
                        else {
                            System.out.printf("\n%s was applied!\n", discountCode.getCode());
                            hotel.fetchReservation(hotel.countReservations() - 1).setDiscountCode(discountCode);
                        }
                    }
                    else {
                        System.out.printf("\nNo discount was applied.\n");
                    }

                    System.out.printf("-------------------------------------\n");
                    System.out.printf("Reservation saved!\n");
                }
            }
            else {
                System.out.printf("\nCanceling...\n");
            }

            System.out.printf("-------------------------------------\n");
        }
    }

    // -- Private Methods -- //

    /**
     * Validates the given hotel name to ensure it is unique among the existing hotels.
     * 
     * @param name the name of the hotel to validate
     * @return true if the hotel name is unique, false otherwise
     */
    private boolean validateHotelName(String name) {
        boolean result = true;

        for(int i = 0; i < hotels.size() && result == true; i++) {
            if(name.equals(hotels.get(i).getHotelName())) {
                result = false;
            }
        }

        return result;
    }

    /**
     * Prompts the user to select an option within a specified range.
     * 
     * @param start the starting range of the option
     * @param end the ending range of the option
     * @param str the prompt message
     * @return the selected option within the specified range
     */
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

    /**
     * Prompts the user to enter the guest name.
     * 
     * @return the guest name entered by the user
     */
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

    /**
     * Prompts the user to confirm a modification.
     * 
     * @return 1 if the modification is confirmed, 0 otherwise
     */
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

    /**
     * Displays the date availability of the given hotel.
     * 
     * @param hotel the hotel to check date availabilty
     */
    private void showDateAvailability(Hotel hotel) {
        int date = promptOption(1, 30, "Date");
        System.out.printf("Available Rooms: %d\n", hotel.countAvailableRooms(date));
        System.out.printf("Booked Rooms: %d\n", hotel.countBookedRooms(date));
        System.out.printf("-------------------------------------\n");
    }

    /**
     * Displays the room information of the given hotel.
     * 
     * @param hotel the hotel to check room information
     */
    private void showRoomInformation(Hotel hotel) {
        int option;
        Room room;
        int[] roomAvailability;
        int dayCounter = 0;

        System.out.printf("Rooms\n");

        for(int i = 0; i < hotel.countRooms(0); i++) {
            System.out.printf("[%02d] %s (%s)\n", i + 1, hotel.fetchRoom(i).getRoomName(), hotel.fetchRoom(i).getRoomType());
        }

        option = promptOption(1, hotel.countRooms(0), "Room No.");

        room = hotel.fetchRoom(option - 1);
        roomAvailability = hotel.checkRoomAvailability(room);

        System.out.printf("-------------------------------------\n");
        System.out.printf("\"%s\"\n", room.getRoomName());
        System.out.printf("Name: %s\n", room.getRoomName());
        System.out.printf("Type: %s\n", room.getRoomType());
        System.out.printf("Price per Night: %.2f\n", room.getRoomPrice());
        System.out.printf("Available Dates for Check-in:\n");

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
            System.out.printf("No available dates for check-in.");
        }

        System.out.printf("\n");

        System.out.printf("-------------------------------------\n");
    }

    /**
     * Displays the reservation information of the given hotel.
     * 
     * @param hotel the hotel to check reservation information
     */
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
            System.out.printf("Room: %s (%s)\n", reservation.getRoom().getRoomName(), reservation.getRoom().getRoomType());
            System.out.printf("Check-In Date: %d\n", reservation.getCheckInDate());
            System.out.printf("Check-Out Date: %d\n", reservation.getCheckOutDate());

            System.out.printf("Cost Breakdown:\n");
            for(int i = reservation.getCheckInDate(); i < reservation.getCheckOutDate(); i++) {
                System.out.printf("    day %d - day %d -> %.2f\n", i, i + 1, reservation.retrieveCostPerNight(i));
            }
            System.out.printf("Total Price: %.2f\n", reservation.computeTotalPrice());

            if(reservation.getDiscountCode() != null) {
                System.out.printf("Discount: %.2f (%s)\n", reservation.getDiscountCode().computeDiscount(reservation), reservation.getDiscountCode().getCode());
            }
            else {
                System.out.printf("Discount: 0 (No discount applied)\n");
            }

            System.out.printf("Final Price: %.2f\n", reservation.computeFinalPrice());    
        }

        System.out.printf("-------------------------------------\n");
    }

    /**
     * Changes the name of the given hotel.
     * 
     * @param hotel the hotel to change the name
     */
    private void changeHotelName(Hotel hotel) {
        Scanner sc = new Scanner(System.in);
        String newName;

        do { 
            System.out.printf("-------------------------------------\n");
            System.out.printf("*Enter 0 to cancel*\n");
            System.out.printf("-------------------------------------\n");
            System.out.printf( "Enter new Hotel Name: ");
            newName = sc.nextLine();

            if (hotel.getHotelName().equals(newName)) {
                System.out.printf("Error: Hotel name is the same as its current name\n");
            }
            else if(!validateHotelName(newName)) {
                System.out.printf("Error: Hotel name already taken.\n");
            }
        } while ((hotel.getHotelName().equals(newName) || !validateHotelName(newName)) && !newName.equals("0"));

        if (!newName.equals("0")) {
            if (confirmMod() == 1) {
                hotel.setHotelName(newName);
                System.out.printf("Hotel name has been changed to \"%s\"\n", newName);
            }
            else {
                System.out.printf("Hotel name remained as \"%s\"\n", hotel.getHotelName());
            }
        }
        else {
            System.out.printf("\nCanceling...\n");
        }

        System.out.printf("-------------------------------------\n");
    }

    /**
     * Adds a new room to the given hotel.
     * 
     * @param hotel the hotel to add a new room
     */
    private void addRoom(Hotel hotel) {
        String typeString = "";
        int typeOption;

        if (hotel.countRooms(0) < 50) {
            
            System.out.printf("-------------------------------------\n");
            System.out.printf("Type of Room\n");
            System.out.printf("[1] Standard\n");
            System.out.printf("[2] Deluxe\n");
            System.out.printf("[3] Executive\n");

            typeOption = promptOption(1, 3, "Option");

            if (confirmMod() == 1) {
                hotel.addRoom(typeOption);

                switch(typeOption) {
                    case 1: typeString = "Standard"; break;
                    case 2: typeString = "Deluxe"; break;
                    case 3: typeString = "Executive"; break;
                }

                System.out.printf("New %s room has been added!\n", typeString);
                System.out.printf("-------------------------------------\n");
            }
            else {
                System.out.printf("No new room added.\n");
                System.out.printf("-------------------------------------\n");
            }
        } 
        else {
            System.out.printf("Maximum room capacity already reached.\n");
            System.out.printf("-------------------------------------\n");
        }     
    }

    /**
     * Removes a room from the given hotel.
     * 
     * @param hotel the hotel to remove a room
     */
    private void removeRoom(Hotel hotel) { 
        int option;
        Room room;
        int[] roomAvailability;
        boolean booked = false;

        if(hotel.countRooms(0) == 1) {
            System.out.printf("-------------------------------------\n");
            System.out.printf("Error: can't delete the only room in the hotel.\n");
            System.out.printf("-------------------------------------\n");
        }
        else {
            System.out.printf("-------------------------------------\n");
            System.out.printf("*Enter 0 to cancel*\n");
            System.out.printf("-------------------------------------\n");
            
            System.out.printf("Rooms\n");

            for(int i = 0; i < hotel.countRooms(0); i++) {
                room = hotel.fetchRoom(i);
                System.out.printf("[%02d] %s (%s)\n", i + 1, room.getRoomName(), room.getRoomType());
            }
            
            option = promptOption(0, hotel.countRooms(0), "Room Option");

            if (option != 0) {
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
                        System.out.printf("Room has been removed.\n");
                    } 
                    else {
                        System.out.printf("Room was retained.\n");
                    }
                }
                else {
                    System.out.printf("-------------------------------------\n");
                    System.out.printf("Room is currently booked.\n");
                }
            }
            else {
                System.out.printf("\nCanceling...\n");
            }
        }
        System.out.printf("-------------------------------------\n");
    }

    /**
     * Updates the base price of the rooms in the given hotel.
     * 
     * @param hotel the hotel to update the base price
     */
    private void updateBasePrice(Hotel hotel) {
        Scanner sc = new Scanner(System.in);
        float newPrice;

        if (hotel.countReservations() == 0) {
            do { 
                System.out.printf("-------------------------------------\n");
                System.out.printf("Current Base Price: %.2f\n", hotel.getBasePrice());
                System.out.printf("Enter New Base Price: ");
                newPrice = sc.nextFloat();

                if(newPrice < 100.0f) {
                    System.out.printf("Error: Base price should be >= 100.00\n");
                }
            } while (newPrice < 100.0f);

            if(confirmMod() == 1) {
                hotel.setBasePrice(newPrice);
                System.out.printf("Base Price updated!\n");
            }
            else {
                System.out.printf("Base Price retained.\n");
            }
        }
        else {
            System.out.printf("-------------------------------------\n");
            System.out.printf("There are currently reservations in the hotel. Base price cannot be changed.\n");
        }
        
        System.out.printf("-------------------------------------\n");
    }

    /**
     * Removes a reservation from the given hotel.
     * 
     * @param hotel the hotel to remove a reservation
     */
    private void removeReservation(Hotel hotel) {
        int option;

        if (hotel.countReservations() != 0) {   
            System.out.printf("-------------------------------------\n");
            System.out.printf("*Enter 0 to cancel*\n");
            System.out.printf("-------------------------------------\n");
            
            System.out.printf("Reservations\n");

            for(int i = 0; i < hotel.countReservations(); i++) {
                System.out.printf("[%02d] %s (%d to %d)\n", i + 1, hotel.fetchReservation(i).getGuestName(), 
                        hotel.fetchReservation(i).getCheckInDate(), hotel.fetchReservation(i).getCheckOutDate());
            }

            option = promptOption(0, hotel.countReservations(), "Reservation No.");

            if (option != 0) {
                if (confirmMod() == 1) {
                    hotel.removeReservation(option - 1);
                    System.out.printf("Reservation has been removed.\n");
                }
                else {
                    System.out.printf("Reservation has been retained.\n");
                }
            }
            else {
                System.out.printf("\nCanceling...\n");
            }
        }
        else {
            System.out.printf("-------------------------------------\n");
            System.out.printf("There are currently no reservations in the hotel.\n");
        }

        System.out.printf("-------------------------------------\n");
    }

    /**
     * Removes a hotel from the hotel list.
     * 
     * @param index the index of the hotel to remove
     * @return 0 if the hotel is removed, 1 if the hotel is retained
     */
    private int removeHotel(int index) {
        if(this.hotels.get(index).countReservations() > 0) {
            System.out.printf("-------------------------------------\n");
            System.out.printf("Warning: There is/are active reservation/s in this hotel!\n");
        }
        
        if (confirmMod() == 1) {
            System.out.printf("\"%s\" has been removed.\n", this.hotels.get(index).getHotelName());
            System.out.printf("-------------------------------------\n");
            this.hotels.remove(index);
            return 0;
        }
        else {
            System.out.printf("\"%s\" was retained.\n", index + 1);
            System.out.printf("-------------------------------------\n");
            return 1;
        }
    }

    // Prompts for discount code, checking if the code valid and applicable
    private DiscountCode promptDiscountCode(Hotel hotel) {
        Scanner sc = new Scanner(System.in);
        String code;
        DiscountCode discountCode = null;
        boolean applicable = false;

        do { 
            System.out.printf("-------------------------------------\n");
            System.out.printf("*Enter 0 to cancel*\n");
            System.out.printf("-------------------------------------\n");
            System.out.printf("Enter Discount Code: ");
            code = sc.next();

            if(code.equals("0")) {
                discountCode = null;
            }
            else {
                if(!(DiscountCode.CODE_LIST.contains(code))) {
                    System.out.printf("Error: Discount code does not exist.\n");
                }
                else { // Check if applicable given the reservation made
                    if(code.equals(DiscountCode.CODE_LIST.get(0))) {
                        discountCode = new IWorkHere();
                    }
                    else if(code.equals(DiscountCode.CODE_LIST.get(1))) {
                        discountCode = new Stay4Get1();
                    }
                    else if (code.equals(DiscountCode.CODE_LIST.get(2))) {
                        discountCode = new Payday();
                    }
    
                    if(discountCode != null && discountCode.checkApplicability(hotel.fetchReservation(hotel.countReservations() - 1))) {
                        applicable = true;
                    }
                    else {
                        System.out.printf("Error: Discount code is not applicable.\n");
                        discountCode = null;  // reset discountCode if not applicable
                    }
                }
            }
        } while(!code.equals("0") && !(applicable && discountCode != null));

        return discountCode;
    }

    // Edits Selected Date Price Modifier
    public void editDatePriceModifier(Hotel hotel) {
        Scanner sc = new Scanner(System.in);
        int day;
        float newModifier;

        if (hotel.countReservations() == 0) {
            System.out.printf("-------------------------------------\n");
            day = promptOption(1, 30, "Day to Edit Modifier");

            do { 
                System.out.printf("-------------------------------------\n");
                System.out.printf("Current Modifier of day %d - day %d: %.2f%%\n", day, day + 1, hotel.fetchDatePriceModifier(day) * 100.0f);
                System.out.printf("Enter New Modfier (in %%): ");
                newModifier = sc.nextFloat();
    
                if(newModifier < 50.0f || newModifier > 150.0f) {
                    System.out.printf("Error: Modifier should be from 50%% to 150%% only.\n");
                }
            } while (newModifier < 50.0f || newModifier > 150.0f);

            if(confirmMod() == 1) {
                hotel.updateDatePrice(day, newModifier / 100.0f);
                System.out.printf("Day %d - day %d price modifier updated!\n", day, day + 1);
            }
            else {
                System.out.printf("Day %d - day %d price modifier retained.\n", day, day + 1);
            }
        }
        else {
            System.out.printf("-------------------------------------\n");
            System.out.printf("There are currently reservations in the hotel. Modifiers cannot be changed.\n");
        }
        
        System.out.printf("-------------------------------------\n");
    }
}
