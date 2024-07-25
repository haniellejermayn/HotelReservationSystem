package src.HRS;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import src.HRS.Model.*;
import src.HRS.View.*;

public class HRSController implements ButtonClickListener{
    private HRSModel model;
    private HRSView view;

    public HRSController(HRSModel model, HRSView view) {
        this.model = model;
        this.view = view;

        view.setHotelSelectedListener(new HotelSelectedListener());
        view.setSidePanelListener(new SidePanelListener());
        view.setHotelsPanelListener(new HotelsPanelListener());
        view.setFilterHotelListener(new FilterHotelListener());
    }

    public void start(){

    }

    private class SidePanelListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == view.getHomeButton()){
                view.getHomePanel().setVisible(true);
                view.getHotelsPanel().setVisible(false);
                view.getResPanel().setVisible(false);
                view.getAccountPanel().setVisible(false);
            }
            else if (e.getSource() == view.getHotelButton()){
                view.getHomePanel().setVisible(false);
                view.getHotelsPanel().setVisible(true);
                view.getResPanel().setVisible(false);
                view.getAccountPanel().setVisible(false);
            }
            else if (e.getSource() == view.getResButton()){
                view.getHomePanel().setVisible(false);
                view.getHotelsPanel().setVisible(false);
                view.getResPanel().setVisible(true);
                view.getAccountPanel().setVisible(false);
            }
            else if (e.getSource() == view.getAccountButton()){
                view.getHomePanel().setVisible(false);
                view.getHotelsPanel().setVisible(false);
                view.getResPanel().setVisible(false);
                view.getAccountPanel().setVisible(true);
            }
            else if (e.getSource() == view.getBackButton()){
                System.exit(0);
            }
        }
    }

    private class HotelSelectedListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < model.countHotels(); i++){
    
                if (e.getSource() == view.getHotelCatalogue().get(i)){
                    SelectedHotelPanel selectedHotel = view.getSelectedHotelPanels().get(i);
                    selectedHotel.setVisible(true);
                    view.getHomePanel().setVisible(false);
                    view.getHotelsPanel().setVisible(false);
                    view.getMainFrame().add(selectedHotel);
                }
                else if (e.getSource() == view.getHotelOptions().get(i)){
                    SelectedHotelPanel selectedHotel = view.getSelectedHotelPanels().get(i);
                    selectedHotel.setVisible(true);
                    view.getHomePanel().setVisible(false);
                    view.getHotelsPanel().setVisible(false);
                    view.getMainFrame().add(selectedHotel);
                }
                else {
                    view.getSelectedHotelPanels().get(i).setVisible(false);
                }
            }
        }
    }

    private class HotelsPanelListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Boolean isVisible = false;
            
            if (e.getSource() == view.getFilterButton()){
                isVisible = !isVisible;
                view.getFilterPanel().setVisible(isVisible);

                if (isVisible){
                    view.getFilterButton().setColor(new Color(40, 68, 117));
                }
                else {
                    view.getFilterButton().setColor(new Color(27, 43, 80));
                }

                view.getFilterButton().repaint();
            }
            else if (e.getSource() == view.getCreateHotelButton()){
                CreateHotelPanel createHotelPanel = new CreateHotelPanel(model.getHotels(), this);
                createHotelPanel.setBounds(152, 10, 385, 420);
                view.getHotelsPanel().add(createHotelPanel, JLayeredPane.POPUP_LAYER);
            }
        }
    }

    @Override
    public void buttonClicked(String buttonName) {
        
    }







    /*public void updateManagePanel(Hotel hotel) {
        String input = view.getHotelNameInput();
        boolean valid = model.isHotelNameUnique(input);

        if(valid) {
            model.get
        }
        view.setValid = valid;
    }*/
}
