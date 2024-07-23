package hrs;

import java.util.Scanner;

public class HRSController {
    private HRSModel model;
    private HRSView view;
    private Scanner sc;

    public HRSController() {
        this.model = new HRSModel();
        this.view = new HRSView();
    }

    public void createHotel() {
        String hotelName;
        int standardAmount, deluxeAmount, executiveAmount;

        do {
            view.printCancel();
            hotelName = this.promptStringInput("Hotel Name");

            if (!model.isHotelNameUnique(hotelName)) {
                view.printError("Hotel name already taken.");
            }
        } while (!model.isHotelNameUnique(hotelName) && !hotelName.equals("0"));

        if (!hotelName.equals("0")) {
            standardAmount = this.promptIntInput(0, 50, "No. of Standard Rooms");
            deluxeAmount = this.promptIntInput(0, 50 - standardAmount, "No. of Deluxe Rooms");
            executiveAmount = this.promptIntInput(0, 50 - standardAmount - deluxeAmount, "No. of Executive Rooms");

            if (standardAmount + deluxeAmount + executiveAmount == 0) {
                view.printError("A hotel needs at least 1 room.");
            } 
            else {
                model.addHotel(new Hotel(hotelName, standardAmount, deluxeAmount, executiveAmount));
                view.printSuccessMessage(hotelName, "added");
            }
        } 
        else {
            view.printCancelMessage();
        }

        view.printBorder();
    }

    public void viewHotel() {
        Hotel hotel;
        int option;

        if (model.countHotels() == 0) {
            view.printNoHotelsMessage();
        } 
        else {
            view.printHotelsList(model.getHotels());

            option = this.promptIntInput(1, model.countHotels(), "Hotel No.");
            hotel = model.fetchHotel(option - 1);

            view.printBorder();
            do {
                view.printHotelDetails(hotel);
                view.printBorder();
                view.printViewMenu();

                option = this.promptIntInput(0, 3, "Option");
                view.printBorder();

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

                view.printBorder();
            } while (option != 0);
        }
    }

    public void manageHotel() {
        Hotel hotel;
        int hotelOption, menuOption;

        if (model.countHotels() == 0) {
            view.printNoHotelsMessage();
        } 
        else {
            view.printHotelsList(model.getHotels());

            hotelOption = this.promptIntInput(1, model.countHotels(), "Hotel No.");
            hotel = model.fetchHotel(hotelOption - 1);

            view.printBorder();
            do {
                view.printHotelDetails(hotel);
                view.printManageMenu(hotel.getHotelName());

                menuOption = this.promptIntInput(0, 7, "Option");
                view.printBorder();

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

                view.printBorder();
            } while (menuOption != 0);
        }
    }

    public void bookRoom() {
        int hotelOption;
        int discountOption;
        Hotel hotel;
        int roomIndex;
        String guestName;
        int checkInDate, checkOutDate;
        int roomType;
        Room room;
        DiscountCode discountCode;

        if (model.countHotels() == 0) {
            view.printNoHotelsMessage();
        } 
        else {
            view.printHotelsList(model.getHotels());

            hotelOption = this.promptIntInput(0, model.countHotels(), "Hotel No.");
            view.printBorder();

            if (hotelOption != 0) {
                hotel = model.fetchHotel(hotelOption - 1);

                guestName = this.promptStringInput("Guest Name");
                checkInDate = this.promptIntInput(1, 30, "Check-in Date");
                checkOutDate = this.promptIntInput(checkInDate + 1, 31, "Check-out Date");

                view.promptForRoomType();
                do {
                    roomType = this.promptIntInput(1, 3, "Option");

                    if (hotel.countRooms(roomType) == 0) {
                        view.printError("There are no rooms of this type in this hotel.");
                    }
                } while (hotel.countRooms(roomType) == 0);

                roomIndex = hotel.checkDateAvailability(checkInDate, checkOutDate, roomType);

                if (roomIndex == -1) {
                    switch (roomType) {
                        case 1:
                            view.printError("No Standard room available given the check-in and check-out dates.");
                            break;
                        case 2:
                            view.printError("No Deluxe room available given the check-in and check-out dates.");
                            break;
                        case 3:
                            view.printError("No Executive room available given the check-in and check-out dates.");
                            break;
                    }
                } 
                else {
                    room = hotel.fetchRoom(roomIndex);
                    hotel.addReservation(guestName, checkInDate, checkOutDate, room);
                    view.printBorder();

                    view.promptForDiscountCode();
                    discountOption = this.promptIntInput(0, 1, "Option");
                    view.printBorder();

                    if (discountOption == 1) {
                        view.printCancel();
                        discountCode = this.promptDiscountCode(hotel);

                        if (discountCode == null) {
                            view.printError("No discount was applied."); // edit: should not be error
                        } 
                        else {
                            view.printSuccessMessage(discountCode.getCode(), "applied");
                            hotel.fetchReservation(hotel.countReservations() - 1).setDiscountCode(discountCode);
                        }
                    } 
                    else {
                        view.printError("No discount was applied.");
                    }

                    view.printBorder();
                    view.printReservationSaved();
                }
            } 
            else {
                view.printBorder();
                view.printCancelMessage();
            }
        }

        view.printBorder();
    }

    private int promptIntInput(int start, int end, String str) {
        sc = new Scanner(System.in);
        
        int option;
        do {
            view.promptForUserInput(str);
            option = sc.nextInt();

            if (option < start || option > end) {
                if (start == end) {
                    view.printError("Only option is " + start + ".");
                } else {
                    view.printError("Options are only from " + start + " to " + end + ".");
                }
            }
        } while (option < start || option > end);

        return option;
    }

    private String promptStringInput(String prompt) {
        sc = new Scanner(System.in);
        
        String str;
        do {
            view.promptForUserInput(prompt);
            str = sc.nextLine();

            if (str.length() == 0) {
                view.printError("Input should be at least 1 character.");
            }
        } while(str.length() == 0);

        return str;
    }

    private float promptFloatInput(float min, float max, String str) {
        sc = new Scanner(System.in);
        
        float value;

        do {
            view.promptForUserInput(str);
            value = sc.nextFloat();

            if(value < min && min == max) {
                view.printError(String.format("Input should be at least %.2f", min));
            }
            else if ((value < min || value > max) && min != max) {
                view.printError(String.format("Input should be at least %.2f but less than %.2f", min, max));
            }
        } while (((value < min || value > max) && min != max) || (value < min && min == max));

        return value;
    }

    private int confirmMod() {
        sc = new Scanner(System.in);

        int option;
        do {
            view.printConfirmation();
            view.promptForUserInput("Option");
            option = sc.nextInt();

            if (option < 0 || option > 1) {
                view.printError("Options are only 0 or 1.");
            }
        } while (option < 0 || option > 1);

        return option;
    }

    private void showDateAvailability(Hotel hotel) {
        int date = this.promptIntInput(1, 30, "Date");
        view.printAvailableRooms(hotel.countAvailableRooms(date));
        view.printBookedRooms(hotel.countBookedRooms(date));
    }

    private void showRoomInformation(Hotel hotel) {
        int option;
        Room room;
        int[] roomAvailability;
        
        view.printRoomList(hotel);

        option = promptIntInput(1, hotel.countRooms(0), "Room No.");
        view.printBorder();

        room = hotel.fetchRoom(option - 1);
        roomAvailability = hotel.checkRoomAvailability(room);

        view.printRoomDetails(room);
        view.printAvailableDates(roomAvailability);
    }

    private void showReservationInformation(Hotel hotel) {
        int option;
        Reservation reservation;

        if (hotel.countReservations() == 0) {
            view.printNoReservationsMessage(); //Edit: error message
        } 
        else {
            view.printReservationList(hotel);

            option = this.promptIntInput(1, hotel.countReservations(), "Reservation No.");

            reservation = hotel.fetchReservation(option - 1);
            view.printReservationDetails(reservation);
        }
    }

    private void changeHotelName(Hotel hotel) {
        String newName;
        do {
            view.printCancel();
            newName = this.promptStringInput("New Hotel Name");

            if (hotel.getHotelName().equals(newName)) {
                view.printError("Hotel name is the same as its current name");
                view.printBorder();
            } 
            else if (!model.isHotelNameUnique(newName)) {
                view.printError("Hotel name already taken.");
                view.printBorder();
            }
        } while ((hotel.getHotelName().equals(newName) || !model.isHotelNameUnique(newName)) && !newName.equals("0"));

        if (!newName.equals("0")) {
            if (confirmMod() == 1) {
                hotel.setHotelName(newName);
                view.printSuccessMessage(newName, "updated");
            } 
            else {
                view.printCancelMessage();
            }
        } 
        else {
            view.printCancelMessage();
        }
    }

    private void addRoom(Hotel hotel) {
        String typeString = "";
        int typeOption;

        if (hotel.countRooms(0) < 50) {
            view.promptForRoomType();
            typeOption = this.promptIntInput(1, 3, "Option");

            if (confirmMod() == 1) {
                hotel.addRoom(typeOption);

                switch (typeOption) {
                    case 1:
                        typeString = "Standard";
                        break;
                    case 2:
                        typeString = "Deluxe";
                        break;
                    case 3:
                        typeString = "Executive";
                        break;
                }

                view.printSuccessMessage(typeString + " room", "added");
            } 
            else {
                view.printCancelMessage();
            }
        } 
        else {
            view.printError("Maximum room capacity already reached.");
        }
    }

    private void removeRoom(Hotel hotel) {
        int option;
        Room room;
        int[] roomAvailability;
        boolean booked = false;

        if (hotel.countRooms(0) == 1) {
            view.printError("Error: can't delete the only room in the hotel.");
        } else {
            view.printRoomList(hotel);

            option = this.promptIntInput(0, hotel.countRooms(0), "Room Option");

            if (option != 0) {
                room = hotel.fetchRoom(option - 1);
                roomAvailability = hotel.checkRoomAvailability(room);

                for (int i = 0; i < 30; i++) {
                    if (roomAvailability[i] == 1) {
                        booked = true;
                    }
                }

                if (!booked) {
                    if (confirmMod() == 1) {
                        hotel.removeRoom(option - 1);
                        view.printSuccessMessage("Room", "removed");
                    } else {
                        view.printCancelMessage();
                    }
                } else {
                    view.printError("Room is currently booked.");
                }
            } else {
                view.printCancelMessage();
            }
        }
    }

    private void updateBasePrice(Hotel hotel) {
        float newPrice;

        if (hotel.countReservations() == 0) {
            newPrice = this.promptFloatInput(100.0f, 100.0f, "New Base Price");

            if (confirmMod() == 1) {
                hotel.setBasePrice(newPrice);
                view.printSuccessMessage("Base Price", "updated");
            } 
            else {
                view.printCancelMessage();
            }
        } 
        else {
            view.printError("There are currently reservations in the hotel. Base price cannot be changed.");
        }
    }

    private void removeReservation(Hotel hotel) {
        int option;

        if (hotel.countReservations() != 0) {
            view.printReservationList(hotel);

            option = this.promptIntInput(0, hotel.countReservations(), "Reservation No.");

            if (option != 0) {
                if (confirmMod() == 1) {
                    hotel.removeReservation(option - 1);
                    view.printSuccessMessage("Reservation", "removed");
                } 
                else {
                    view.printCancelMessage();
                }
            } 
            else {
                view.printCancelMessage();
            }
        } 
        else {
            view.printError("There are currently no reservations in the hotel.");
        }
    }

    private int removeHotel(int index) {
        if (model.fetchHotel(index).countReservations() > 0) {
            view.printError("Warning: There is/are active reservation/s in this hotel!");
        }

        if (confirmMod() == 1) {
            view.printSuccessMessage(model.fetchHotel(index).getHotelName(), "removed");
            model.removeHotel(index);
            return 0;
        } 
        else {
            view.printCancelMessage();
            return 1;
        }
    }

    private DiscountCode promptDiscountCode(Hotel hotel) {
        sc = new Scanner(System.in);
        
        String code;
        DiscountCode discountCode = null;
        boolean applicable = false;

        do {
            view.promptForUserInput("Discount Code");
            code = sc.nextLine();

            if (code.equals("0")) {
                discountCode = null;
            } else {
                if (!DiscountCode.CODE_LIST.contains(code)) {
                    view.printError("Discount code does not exist.");
                } else {
                    if (code.equals(DiscountCode.CODE_LIST.get(0))) {
                        discountCode = new IWorkHere();
                    } else if (code.equals(DiscountCode.CODE_LIST.get(1))) {
                        discountCode = new Stay4Get1();
                    } else if (code.equals(DiscountCode.CODE_LIST.get(2))) {
                        discountCode = new Payday();
                    }

                    if (discountCode != null && discountCode.checkApplicability(hotel.fetchReservation(hotel.countReservations() - 1))) {
                        applicable = true;
                    } else {
                        view.printError("Discount code is not applicable.");
                        discountCode = null;
                    }
                }
            }
        } while (!code.equals("0") && !(applicable && discountCode != null));

        return discountCode;
    }

    public void editDatePriceModifier(Hotel hotel) {
        sc = new Scanner(System.in);

        int day;
        float newModifier;

        if (hotel.countReservations() == 0) {
            day = this.promptIntInput(1, 30, "Day to Edit Modifier");
            newModifier = this.promptFloatInput(50.0f, 150.0f, "New Price Modifier");

            if (confirmMod() == 1) {
                hotel.updateDatePrice(day, newModifier / 100.0f);
                view.printSuccessMessage("Day " + day + " - day " + (day + 1) + " price modifier", "updated");
            } else {
                view.printCancelMessage();
            }
        } else {
            view.printError("There are currently reservations in the hotel. Modifiers cannot be changed.");
        }
    }
}
