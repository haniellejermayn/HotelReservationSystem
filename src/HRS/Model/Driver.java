package src.HRS.Model;

import java.util.Scanner;
import GUI.*;

/**
 * The Driver class contains the main method to run the Hotel Reservation System (HRS).
 * It provides a console-based menu for users to create, view, manage hotels, and book rooms.
 */
//public class Driver {
    /**
     * The main method to run the Hotel Reservation System.
     * Displays a menu and performs actions based on user input.
     *
     * @param args command-line arguments (not used)
     
    public static void main(String[] args) {
        HRSController sys = new HRSController();
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
*/