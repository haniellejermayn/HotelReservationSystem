package hrs;

public class ExecutiveRoom extends Room {
    
    public ExecutiveRoom(String roomName, float basePrice) {
        super(roomName, basePrice * 1.35f);
        this.setRoomType("Executive");
    }

    public ExecutiveRoom(float basePrice) {
        super(basePrice);
        this.setRoomType("Executive");
        this.roomPrice = basePrice * 1.35f; 
    }

    @Override
    public void setRoomPrice(float basePrice) {
        this.roomPrice = basePrice * 1.35f;
    }
}
