package hrs;

public class Room {
    private String roomName;
    private float basePrice;

    public Room(String roomName) {
        this.roomName = roomName; //may be modified to have automated naming
        this.basePrice = 1299.0f;
    }

    public String getRoomName() {
        return this.roomName;
    }

    public float getBasePrice() {
        return this.basePrice;
    }

    public void setRoomName(String newName) {
        this.roomName = newName;
    }

    public void setBasePrice(float newPrice) {
        this.basePrice = newPrice;
    }
}
