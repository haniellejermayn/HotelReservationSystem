package hrs;

public class ExecutiveRoom extends Room {
    
    public ExecutiveRoom(String roomName, float basePrice) {
        super(roomName, basePrice * 1.35f);
    }

    public ExecutiveRoom(float basePrice) {
        super(basePrice * 1.35f);
        this.roomPrice = this.roomPrice * 1.35f;
    }

    @Override
    public void setRoomPrice(float basePrice) {
        this.roomPrice = basePrice * 1.35f;
    }
}
