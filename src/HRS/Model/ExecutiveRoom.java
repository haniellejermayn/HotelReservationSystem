package src.HRS.Model;

/**
 * Represents an executive room in the hotel, extending the Room class.
 */
public class ExecutiveRoom extends Room {
    
    // -- Constructors -- //

    /**
     * Constructs a new ExecutiveRoom with the specified name and base price.
     *
     * @param roomName the name of the room
     * @param basePrice the base price of the room
     */
    public ExecutiveRoom(String roomName, float basePrice) {
        super(roomName, basePrice);
        this.setRoomType("Executive");
        this.roomPrice = basePrice * 1.35f;
    }

    /**
     * Constructs a new ExecutiveRoom with the specified base price and a temporary name.
     *
     * @param basePrice the base price of the room
     */
    public ExecutiveRoom(float basePrice) {
        super(basePrice);
        this.setRoomType("Executive");
        this.roomPrice = basePrice * 1.35f; 
    }

    // -- Overridden Methods -- //

    /**
     * Sets the base price of the executive room.
     *
     * @param basePrice the new base price of the room
     */
    @Override
    public void setRoomPrice(float basePrice) {
        this.roomPrice = basePrice * 1.35f;
    }
}
