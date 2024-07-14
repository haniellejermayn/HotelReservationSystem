package hrs;

public class DeluxeRoom extends Room {

    public DeluxeRoom(String roomName, float basePrice) {
        super(roomName, basePrice * 1.20f);
    }

    public DeluxeRoom(float basePrice) {
        super(basePrice * 1.20f);
    }

    @Override
    public void setRoomPrice(float basePrice) {
        this.roomPrice = basePrice * 1.20f;
    }
    
}
