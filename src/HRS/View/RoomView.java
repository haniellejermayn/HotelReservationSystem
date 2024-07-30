package src.HRS.View;

import java.awt.*;
import java.util.*;
import src.HRS.Model.Hotel;

/**
 * The RoomView class represents a panel that displays a list of rooms for a specific hotel.
 * Each room is shown as an OptionButton.
 */
public class RoomView extends RoundPanel {

    private ArrayList<OptionButton> rooms;
    private Font customFont;

    /**
     * Constructs a new RoomView for the specified hotel.
     *
     * @param hotel the hotel containing the rooms
     */
    public RoomView(Hotel hotel) {
        super(new Color(27, 43, 80));

        customFont = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 9);
        rooms = new ArrayList<>();

        for (int i = 0; i < hotel.countRooms(0); i++) {
            OptionButton room = new OptionButton(hotel.fetchRoom(i).getRoomName());

            if ((i + 1) % 5 == 1) {
                if (i >= 0 && i <= 4) {
                    room.setBounds((i % 5 * 41) + (i % 5 + 1) * 8, (i / 5 + 1) * 5 + (i / 5 * 30), 41, 30);
                } else {
                    room.setBounds((i % 5 * 41) + (i % 5 + 1) * 8, (i / 5 + 1) * 9 - 4 + (i / 5 * 30), 41, 30);
                }
            } else {
                room.setBounds((i % 5 * 41) + (i % 5 + 1) * 5 + 3, (i / 5 + 1) * 9 - 4 + (i / 5 * 30), 41, 30);
            }

            room.setFont(customFont);
            rooms.add(room);
            this.add(rooms.get(i));
        }

        this.setLayout(null);
    }

    /**
     * Returns the list of OptionButtons representing the rooms.
     *
     * @return the list of OptionButtons
     */
    public ArrayList<OptionButton> getRooms() {
        return rooms;
    }

    /**
     * Sets the list of OptionButtons representing the rooms.
     *
     * @param rooms the list of OptionButtons to set
     */
    public void setRooms(ArrayList<OptionButton> rooms) {
        this.rooms = rooms;
    }
}
