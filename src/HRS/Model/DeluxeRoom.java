package src.HRS.Model;

/**
 * Represents a deluxe room in the hotel, extending the Room class.
 */
public class DeluxeRoom extends Room {

    // -- Constructors -- //

    /**
     * Constructs a new DeluxeRoom with the specified name and base price.
     *
     * @param roomName the name of the room
     * @param basePrice the base price of the room
     */
    public DeluxeRoom(String roomName, float basePrice) {
        super(roomName, basePrice);
        this.setRoomType("Deluxe");
        this.roomPrice = basePrice * 1.20f;
    }

    /**
     * Constructs a new DeluxeRoom with the specified base price and a temporary name.
     *
     * @param basePrice the base price of the room
     */
    public DeluxeRoom(float basePrice) {
        super(basePrice);
        this.setRoomType("Deluxe");
        this.roomPrice = basePrice * 1.20f;
    } 

    // -- Overridden Methods -- //

    /**
     * Sets the base price of the deluxe room.
     *
     * @param basePrice the new base price of the room
     */
    @Override
    public void setRoomPrice(float basePrice) {
        this.roomPrice = basePrice * 1.20f;
    }
    
}
