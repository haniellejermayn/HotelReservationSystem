package hrs;

/**
 * Represents a hotel room with a name and base price.
 */
public class Room {
    private String roomName;
    private float basePrice;

    // -- Constructors -- //

    /**
     * Constructs a new Room with the specified name and a default base price.
     *
     * @param roomName the name of the room
     */
    public Room(String roomName) {
        this.roomName = roomName; 
        this.basePrice = 1299.0f;
    }

    /**
     * Constructs a new Room with the specified base price and a temporary name.
     *
     * @param basePrice the base price of the room
     */
    public Room(float basePrice) {
        this.roomName = "TemporaryName"; 
        this.basePrice = basePrice;
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
    public float getBasePrice() {
        return this.basePrice;
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
    public void setBasePrice(float newPrice) {
        this.basePrice = newPrice;
    }
}
