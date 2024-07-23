package GUI;

import hrs.*;

public class Main {

    public static void main(String[] args) {
        // PlaceHolder
        /*
        ArrayList<String> hotels = new ArrayList<String>();

        hotels.add("Kelsey Hotel");
        hotels.add("Hep Hotel");
        hotels.add("Hanielle Hotel");
         * 
         */
        
        HRSModel model = new HRSModel();
        MainFrame view = new MainFrame();
        HRSController controller = new HRSController(model, view);
    }
}