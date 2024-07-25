package src.HRS.Model;

/**
 * Represents a hotel room with a name and base price.
 */
public class Room {
    private String roomName;
    private String roomType;
    protected float roomPrice;

    public static final int TYPE_STANDARD = 1;
    public static final int TYPE_DELUXE = 2;
    public static final int TYPE_EXECUTIVE = 3;

    // -- Constructors -- //

    /**
     * Constructs a new Room with the specified name and a default base price.
     *
     * @param roomName the name of the room
     */
    public Room(String roomName, float basePrice) {
        this.roomName = roomName; 
        this.roomType = "Standard";
        this.roomPrice = basePrice;
    }

    /**
     * Constructs a new Room with the specified base price and a temporary name.
     *
     * @param basePrice the base price of the room
     */
    public Room(float basePrice) {
        this.roomName = "TemporaryName"; 
        this.roomType = "Standard";
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
     * Gets the type of the room.
     *
     * @return the room type
     */
    public String getRoomType() {
        return this.roomType;
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
     * Sets the type of the room.
     *
     * @param newName the new type of the room
     */
    public void setRoomType(String type) {
        this.roomType = type;
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
