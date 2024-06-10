package hrs;

public class Room {
    private String roomName;
    private float basePrice;

    public Room(String roomName) {
        this.roomName = roomName; 
        this.basePrice = 1299.0f;
    }

    public Room(float basePrice) {
        this.roomName = "TemporaryName"; 
        this.basePrice = basePrice;
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
