package src.HRS;

import src.HRS.Model.*;
import src.HRS.View.*;

public class HRSController {
    private HRSModel model;
    private MainFrame view;

    public HRSController(HRSModel model, MainFrame view) {
        this.model = model;
        this.view = view;
    }
}
