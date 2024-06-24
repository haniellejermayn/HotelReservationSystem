package hrs;

public class SyntaxDriver {

    public static void displayReservation(Reservation res) {
        System.out.printf("%s's Reservation\n", res.getGuestName());
        System.out.printf("Guest Name: %s\n", res.getGuestName());
        System.out.printf("Room: %s\n", res.getRoom().getRoomName());
        System.out.printf("Check-In Date: %d\n", res.getCheckInDate());
        System.out.printf("Check-Out Date: %d\n", res.getCheckOutDate());
        
        // RESERVATION
        System.out.printf("Price per Night: %.2f\n", res.retrieveCostPerNight());
        System.out.printf("Total Price: %.2f\n", res.computeTotalPrice());
    }

    public static void displayRoom(Room room) {
        System.out.printf("%s's Room\n", room.getRoomName());
        System.out.printf("Base Price: %.2f\n", room.getBasePrice());
    }

    public static void main(String[] args) {
        HotelReservationSystem sys = new HotelReservationSystem();
        Reservation res;
        Hotel hotel = new Hotel("K&H Hotel", 50);
        Room room;
        
        // HOTEL
        System.out.printf("Compute earnings: %.2f\n", hotel.computeEarnings());

        System.out.printf("Fetch reservation\n");
        res = hotel.fetchReservation(0);
        
        displayReservation(res);

        System.out.printf("Fetch room\n");
        room = hotel.fetchRoom(0);

        displayRoom(room);

        System.out.printf("No. of reservations: %d\n", hotel.countReservations());
        System.out.printf("No. of rooms: %d\n", hotel.countRooms());
        System.out.printf("No. of booked rooms: %d\n", hotel.countBookedRooms(15));
        System.out.printf("No. of available rooms: %d\n", hotel.countAvailableRooms(15));
        
        int[] AvailDays = hotel.checkRoomAvailability(room);
        
        System.out.printf("Available Dates:\n");
        for (int i = 0; i < 30; i++) {
            if(AvailDays[i] == 0) {
                System.out.printf("%02d\n", i + 1);
            }
        }

        Room hepRoom = new Room("Hep's Room");
        hotel.addReservation("hep", 14, 20, hepRoom);
        
        displayReservation(hotel.fetchReservations(1));

        hotel.removeReservation(1);
        displayReservation(hotel.fetchReservation(1));

        hotel.addRoom() // if room is full
        
        // display all rooms

        hotel.removeRoom(2);

        // display all rooms

        System.out.printf("Base Price: %.2f\n", room.getBasePrice());
        hotel.updateRoomPrice(70.00f);
        System.out.printf("Updated Base Price: %.2f\n", room.getBasePrice());

        hotel.initializeRooms(30);

        
        // HRS

    }
}


