package hrs;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        HotelReservationSystem sys = new HotelReservationSystem();
        Scanner sc = new Scanner(System.in);
        int option;

        do { 
            System.out.printf("HRS Main Menu\n");
            System.out.printf("[1] Create Hotel\n");
            System.out.printf("[2] View Hotel\n");
            System.out.printf("[3] Manage Hotel\n");
            System.out.printf("[4] Book Room\n");
            System.out.printf("[0] Exit\n");

            do { 
                System.out.printf("Enter Option: ");
                option = sc.nextInt();

                if(option < 0 || option > 4) {
                    System.out.printf("Error: Choose only from 0 to 4\n");
                }
            } while (option < 0 || option > 4);

            System.out.printf("-------------------------------------\n");

            switch (option) {
                case 1:
                    sys.createHotel();
                    break;
                case 2:
                    sys.viewHotel();
                    break;
                case 3:
                    sys.manageHotel();
                    break;
                case 4:
                    sys.bookRoom();
                    break;
                default:
                    break;
            }
        } while (option != 0);
    }
}
