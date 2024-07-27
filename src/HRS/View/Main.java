package src.HRS.View;
import src.HRS.Model.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        
        ArrayList<Hotel> hotels = new ArrayList<Hotel>();
        
        new MainFrame(hotels, hotels.size());
    }
}