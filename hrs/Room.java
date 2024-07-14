package hrs;

/**
 * Represents a hotel room with a name and base price.
 */
public class Room {
    protected String roomName;
    protected float roomPrice;

    // -- Constructors -- //

    /**
     * Constructs a new Room with the specified name and a default base price.
     *
     * @param roomName the name of the room
     */
    public Room(String roomName, float basePrice) {
        this.roomName = roomName; 
        this.roomPrice = basePrice;
    }

    /**
     * Constructs a new Room with the specified base price and a temporary name.
     *
     * @param basePrice the base price of the room
     */
    public Room(float basePrice) {
        this.roomName = "TemporaryName"; 
        this.roomPrice = basePrice;
    }

    // -- Getters & Setters -- //

    /**
     * Gets the name of the room.
     *
     * @return the room name
     */
    public String getRoomName() {
        return this.roomName;
    }

    /**
     * Gets the base price of the room.
     *
     * @return the base price
     */
    public float getRoomPrice() {
        return this.roomPrice;
    }

    /**
     * Sets the name of the room.
     *
     * @param newName the new name of the room
     */
    public void setRoomName(String newName) {
        this.roomName = newName;
    }

    /**
     * Sets the base price of the room.
     *
     * @param newPrice the new base price of the room
     */
    public void setRoomPrice(float newPrice) {
        this.roomPrice = newPrice;
    }
}
