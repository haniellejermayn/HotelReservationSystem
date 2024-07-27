package src.HRS.Model;

public class DeluxeRoom extends Room {

    public DeluxeRoom(String roomName, float basePrice) {
        super(roomName, basePrice);
        this.setRoomType("Deluxe");
        this.roomPrice = basePrice * 1.20f;
    }

    public DeluxeRoom(float basePrice) {
        super(basePrice);
        this.setRoomType("Deluxe");
        this.roomPrice = basePrice * 1.20f;
    } 

    @Override
    public void setRoomPrice(float basePrice) {
        this.roomPrice = basePrice * 1.20f;
    }
    
}
