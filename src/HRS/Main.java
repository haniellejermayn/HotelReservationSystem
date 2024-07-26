package src.HRS;
import src.HRS.Model.*;
//import src.HRS.View.MainFrame;

//import java.util.*;

public class Main {

    public static void main(String[] args) {

        HRSModel model = new HRSModel();
        HRSView view = new HRSView();
        
        HRSController controller = new HRSController(model, view);

        controller.start();
    }
}