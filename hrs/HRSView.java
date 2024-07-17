package hrs;

import java.util.ArrayList;
import java.util.Scanner;

public class HRSView {
    private Scanner scanner;

    public HRSView() {
        this.scanner = new Scanner(System.in);
    }

    public void printViewMenu() {
        System.out.printf("Menu\n");
        System.out.printf("[1] Date Availability\n");
        System.out.printf("[2] Room Information\n");
        System.out.printf("[3] Reservation Information\n");
        System.out.printf("[0] Go Back\n");
    }

    public void printHotelsList(ArrayList<Hotel> hotels) {
        System.out.printf("Hotels\n");
        for (int i = 0; i < hotels.size(); i++) {
            System.out.printf("[%02d] %s\n", i + 1, hotels.get(i).getHotelName());
        }
    }

    public void printHotelDetails(Hotel hotel) {
        System.out.printf("\"%s\"\n", hotel.getHotelName());
        System.out.printf("Name: %s\n", hotel.getHotelName());
        System.out.printf("No. of Rooms: %d\n", hotel.countRooms(0));
        System.out.printf("Month's Estimated Earnings: %.2f\n", hotel.computeEarnings());
    }

    public void printRoomList(Hotel hotel) {
        System.out.printf("Rooms\n");
        for (int i = 0; i < hotel.countRooms(0); i++) {
            System.out.printf("[%02d] %s (%s)\n", i + 1, hotel.fetchRoom(i).getRoomName(), hotel.fetchRoom(i).getRoomType());
        }
    }

    public void printRoomDetails(Room room) {
        System.out.printf("\"%s\"\n", room.getRoomName());
        System.out.printf("Name: %s\n", room.getRoomName());
        System.out.printf("Type: %s\n", room.getRoomType());
        System.out.printf("Price per Night: %.2f\n", room.getRoomPrice());
    }

    public void printReservationList(Hotel hotel) {
        System.out.printf("Reservations\n");
        for (int i = 0; i < hotel.countReservations(); i++) {
            System.out.printf("[%02d] %s (%d to %d)\n", i + 1, hotel.fetchReservation(i).getGuestName(), hotel.fetchReservation(i).getCheckInDate(), hotel.fetchReservation(i).getCheckOutDate());
        }
    }

    public void printReservationDetails(Reservation reservation) {
        System.out.printf("\"%s's Reservation\"\n", reservation.getGuestName());
        System.out.printf("Guest Name: %s\n", reservation.getGuestName());
        System.out.printf("Room: %s (%s)\n", reservation.getRoom().getRoomName(), reservation.getRoom().getRoomType());
        System.out.printf("Check-In Date: %d\n", reservation.getCheckInDate());
        System.out.printf("Check-Out Date: %d\n", reservation.getCheckOutDate());
        System.out.printf("Cost Breakdown:\n");
        for (int i = reservation.getCheckInDate(); i < reservation.getCheckOutDate(); i++) {
            System.out.printf("    day %d - day %d -> %.2f\n", i, i + 1, reservation.retrieveCostPerNight(i));
        }
        System.out.printf("Total Price: %.2f\n", reservation.computeTotalPrice());
        if (reservation.getDiscountCode() != null) {
            System.out.printf("Discount: %.2f (%s)\n", reservation.getDiscountCode().computeDiscount(reservation), reservation.getDiscountCode().getCode());
        } else {
            System.out.printf("Discount: 0 (No discount applied)\n");
        }
        System.out.printf("Final Price: %.2f\n", reservation.computeFinalPrice());
    }

    public void promptForRoomType() {
        System.out.printf("Select Room Type\n");
        System.out.printf("[1] Standard\n");
        System.out.printf("[2] Deluxe\n");
        System.out.printf("[3] Executive\n");
    }

    public void promptForDiscountCode() {
        System.out.printf("Do you have a discount code?\n");
        System.out.printf("[1] Yes\n");
        System.out.printf("[0] No\n");
    }

    public void printSuccessMessage(String str1, String str2) {
        System.out.printf("\n%s was %s!\n", str1, str2);
    }

    public void printAvailableRooms(int availableRooms) {
        System.out.printf("Available Rooms: %d\n", availableRooms);
    }

    public void printBookedRooms(int bookedRooms) {
        System.out.printf("Booked Rooms: %d\n", bookedRooms);
    }

    public void printAvailableDates(int[] roomAvailability) {
        int dayCounter = 0;
        for (int i = 0; i < roomAvailability.length; i++) {
            if (roomAvailability[i] == 0) {
                System.out.printf("[%02d] ", i + 1);
                dayCounter++;
            }
            if (dayCounter % 5 == 0 && dayCounter > 0) {
                System.out.printf("\n");
            }
        }
        if (dayCounter == 0) {
            System.out.printf("No available dates for check-in.");
        }
        System.out.printf("\n");
    }

    public void printNoHotelsMessage() {
        System.out.printf("No hotels in list.\n");
        System.out.printf("-------------------------------------\n");
    }

    public void printNoReservationsMessage() {
        System.out.printf("No Reservations\n");
    }

    public void printReservationSaved() {
        System.out.printf("Reservation saved!\n");
    }

    public void printCancelMessage() {
        System.out.printf("\nCanceling...\n");
    }

    public void printError(String message) {
        System.out.printf("Error: %s\n", message);
    }

    public void printCancel() {
        System.out.printf("*Enter 0 to cancel*\n");
        System.out.printf("-------------------------------------\n");
    }

    public void promptForUserInput(String str) {
        System.out.printf("Enter %s: ", str);
    }


    public void printConfirmation() {
        System.out.printf("-------------------------------------\n");
        System.out.printf("Confirm modification?\n");
        System.out.printf("[1] Yes\n");
        System.out.printf("[0] No (The modification will be discarded)\n");
    }

    public void printManageMenu(String hotelName) {
        System.out.printf("-------------------------------------\n");
        System.out.printf("Manage \"%s\"\n", hotelName);
        System.out.printf("[1] Change Name\n");
        System.out.printf("[2] Add Room\n");
        System.out.printf("[3] Remove Room\n");
        System.out.printf("[4] Update Base Price\n");
        System.out.printf("[5] Edit Date Price Modifier\n");
        System.out.printf("[6] Remove Reservation\n");
        System.out.printf("[7] Remove Hotel\n");
        System.out.printf("[0] Go Back\n");
    }

    public void printBorder() {
        System.out.printf("-------------------------------------\n");
    }

    /* 
    public int getUserInput() {
        return scanner.nextInt();
    }

    public String getUserInputString() {
        return scanner.next();
    }
    */


}
