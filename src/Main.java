package src;

import src.HRS.Model.HRSController;
import src.HRS.Model.HRSModel;
import src.HRS.View.HRSView;

public class Main {

    public static void main(String[] args) {

        HRSModel model = new HRSModel();
        HRSView view = new HRSView(model.getHotels(), model.countHotels());
        
        HRSController controller = new HRSController(model, view);

        controller.start();
    }
}