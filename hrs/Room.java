package hrs;

public class Room {
    private String roomName;
    private float basePrice;

    public Room(String roomName) {
        this.roomName = roomName; //may be modified to have automated naming
        this.basePrice = 1299.0f;
    }
}
