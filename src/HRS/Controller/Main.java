package src.HRS.Controller;

//import src.HRS.Controller.HRSController;
import src.HRS.Model.HRSModel;
import src.HRS.View.HRSView;

/**
 * The main class for launching the Hotel Reservation System application.
 * 
 * <p>This class is the entry point of the application. It initializes the model,
 * view, and controller, and starts the application.</p>
 */
public class Main {

    /**
     * The main method to launch the Hotel Reservation System application.
     * 
     * @param args Command-line arguments (not used in this application).
     */
    public static void main(String[] args) {

        HRSModel model = new HRSModel();
        HRSView view = new HRSView(model.getHotels(), model.countHotels());
        
        HRSController controller = new HRSController(model, view);

        controller.start();
    }
}