package src.HRS.TestPackage;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

//import src.HRS.Model.*;
//import src.HRS.View.*;

public class HRSController{
    private HRSModel model;
    private HRSView view;

    public HRSController(HRSModel model, HRSView view) {
        this.model = model;
        this.view = view;

        view.setHotelSelectedListener(new HotelSelectedListener());
        view.setSidePanelListener(new SidePanelListener());
        view.setHotelsPanelListener(new HotelsPanelListener());
        view.setCreateHotelListener(new CreateHotelListener());
        view.setFilterPanelListener(new FilterPanelListener());
        view.setSelectedHotelListener(new SelectedHotelListener());
        view.setBookHotelListener(new BookHotelListener());
        view.setManageHotelListener(new ManageHotelListener());
        view.setManageSubPanelListener(new ManageSubPanelListener());
        view.setConfirmModListener(new ConfirmModListener());
        view.setDateAvailabilityListener(new DateAvailabilityListener());
        view.setRoomInfoListener(new RoomInfoListener());
        view.setResInfoListener(new ResInfoListener());
    }

    public void start(){
        view.setMainFrame(new MainFrame(model.getHotels(), model.countHotels()));
    }

    private class SidePanelListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            IconButton homeButton = view.getSidePanel().getHomeButton();
            IconButton hotelButton = view.getSidePanel().getHotelButton();
            IconButton resButton = view.getSidePanel().getReservationsButton();
            IconButton accountButton = view.getSidePanel().getAccountButton();
            IconButton backButton = view.getSidePanel().getBackButton();

            if (e.getSource() == homeButton){
                view.getHomePanel().setVisible(true);
                view.getHotelsPanel().setVisible(false);
                view.getResPanel().setVisible(false);
                view.getAccountPanel().setVisible(false);
            }
            else if (e.getSource() == hotelButton){
                view.getHomePanel().setVisible(false);
                view.getHotelsPanel().setVisible(true);
                view.getResPanel().setVisible(false);
                view.getAccountPanel().setVisible(false);
            }
            else if (e.getSource() == resButton){
                view.getHomePanel().setVisible(false);
                view.getHotelsPanel().setVisible(false);
                view.getResPanel().setVisible(true);
                view.getAccountPanel().setVisible(false);
            }
            else if (e.getSource() == accountButton){
                view.getHomePanel().setVisible(false);
                view.getHotelsPanel().setVisible(false);
                view.getResPanel().setVisible(false);
                view.getAccountPanel().setVisible(true);
            }
            else if (e.getSource() == backButton){
                System.exit(0);
            }
        }
    }

    private class HotelSelectedListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < model.countHotels(); i++){
    
                if (e.getSource() == view.getHomePanel().getHotelCatalogue().get(i)){
                    SelectedHotelPanel selectedHotel = view.getSelectedHotelPanels().get(i);
                    selectedHotel.setVisible(true);
                    view.setSelectedHotelPanel(selectedHotel);
                    view.getHomePanel().setVisible(false);
                    view.getHotelsPanel().setVisible(false);
                    view.getMainFrame().add(selectedHotel);
                }
                else if (e.getSource() == view.getHotelsPanel().getHotelCatalogue().get(i)){
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
            
            if (e.getSource() == view.getHotelsPanel().getFilterButton()){
                isVisible = !isVisible;
                view.getFilterPanel().setVisible(isVisible);

                if (isVisible){
                    view.getHotelsPanel().getFilterButton().setColor(new Color(40, 68, 117));
                }
                else {
                    view.getHotelsPanel().getFilterButton().setColor(new Color(27, 43, 80));
                }

                view.getHotelsPanel().getFilterButton().repaint();
            }
            else if (e.getSource() == view.getHotelsPanel().getCreateHotelButton()){
                CreateHotelPanel createHotelPanel = new CreateHotelPanel(model.getHotels());
                createHotelPanel.setBounds(152, 10, 385, 420);
                view.setCreateHotelPanel(createHotelPanel);
                view.getHotelsPanel().add(createHotelPanel, JLayeredPane.POPUP_LAYER);
            }
        }
    }

    private class CreateHotelListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == view.getCreateHotelPanel().getCreateButton()){

                TextFieldCustom nameInput = view.getCreateHotelPanel().getNameInput();
                TextFieldCustom standardInput = view.getCreateHotelPanel().getStandardRoomInput();
                TextFieldCustom deluxeInput = view.getCreateHotelPanel().getDeluxeRoomInput();
                TextFieldCustom executiveInput = view.getCreateHotelPanel().getExecutiveRoomInput();

                String name = nameInput.getTextField().getText().trim();
                int standard = Integer.valueOf(standardInput.getTextField().getText().trim());
                int deluxe = Integer.valueOf(deluxeInput.getTextField().getText().trim());
                int executive = Integer.valueOf(executiveInput.getTextField().getText().trim());

                // TODO: check if hotelName is unique
                if (!name.isEmpty() && standard + deluxe + executive > 0 && standard + deluxe + executive <= 50){
                    
                    // TODO: set all necessary info into Hotel
                    
                }

                view.getCreateHotelPanel().setVisible(false);
                view.getHotelsPanel().remove(view.getCreateHotelPanel());
                view.setHotelsPanel(new HotelsPanel(model.getHotels(), model.countHotels()));
            }
            else if (e.getSource() == view.getCreateHotelPanel().getCancelButton()){

                view.getCreateHotelPanel().setVisible(false);
                view.getHotelsPanel().remove(view.getCreateHotelPanel());
            }
        }
    }

    private class FilterPanelListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            HotelsPanel hotelsPanel = view.getHotelsPanel();

            OptionButton mostBookedButton = hotelsPanel.getFilterPanel().getMostBookedButton();
            OptionButton lowestPriceButton = hotelsPanel.getFilterPanel().getLowestPriceButton();
            OptionButton highestPriceButton = hotelsPanel.getFilterPanel().getHighestPriceButton();
            OptionButton newestButton = hotelsPanel.getFilterPanel().getNewestButton();

            if (e.getSource() == mostBookedButton){
    
                hotelsPanel.getHotelScrollPane().setVisible(false);
                hotelsPanel.remove(hotelsPanel.getHotelScrollPane());
                hotelsPanel.getHotelContainer().removeAll();
    
                ArrayList<HotelOption> mostBookedCatalogue = new ArrayList<HotelOption>();
    
                // TODO: add filter function for most booked
                ArrayList<Hotel> mostBooked = new ArrayList<Hotel>();
                mostBooked.add(model.getHotels().get(3));
                mostBooked.add(model.getHotels().get(2));
                mostBooked.add(model.getHotels().get(1));
                mostBooked.add(model.getHotels().get(4));
                mostBooked.add(model.getHotels().get(0));
                mostBooked.add(model.getHotels().get(5));
    
                for(int i = 0; i < model.countHotels(); i++){
                    HotelOption optionTemp = new HotelOption(mostBooked.get(i));
                    hotelsPanel.initializeHotelOption(optionTemp, mostBooked.get(i), i);
                    mostBookedCatalogue.add(optionTemp);
                    hotelsPanel.getHotelContainer().add(mostBookedCatalogue.get(i));
                }
    
                hotelsPanel.getHotelContainer().add(view.getHotelsPanel().getCreateHotelButton());
    
                ScrollPaneCustom scrollPane = new ScrollPaneCustom(hotelsPanel.getHotelContainer(), new Color(40, 68, 117), new Color(40, 68, 117), new Color(13, 22, 45));
                scrollPane.setBounds(0, 60, 620, 405);
                scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
    
                hotelsPanel.add(scrollPane, JLayeredPane.DEFAULT_LAYER);
            }
            else if (e.getSource() == lowestPriceButton){
    
                hotelsPanel.getHotelScrollPane().setVisible(false);
                hotelsPanel.remove(hotelsPanel.getHotelScrollPane());
    
                hotelsPanel.getHotelContainer().removeAll();
    
                ArrayList<HotelOption> lowestPriceCatalogue = new ArrayList<HotelOption>();
    
                // TODO: add filter function for lowest price
                ArrayList<Hotel> lowestPrice = new ArrayList<Hotel>();
                lowestPrice.add(model.getHotels().get(3));
                lowestPrice.add(model.getHotels().get(2));
                lowestPrice.add(model.getHotels().get(4));
                lowestPrice.add(model.getHotels().get(1));
                lowestPrice.add(model.getHotels().get(5));
                lowestPrice.add(model.getHotels().get(0));
    
                for(int i = 0; i < model.countHotels(); i++){
                    HotelOption optionTemp = new HotelOption(lowestPrice.get(i));
                    hotelsPanel.initializeHotelOption(optionTemp, lowestPrice.get(i), i); 
                    lowestPriceCatalogue.add(optionTemp);
                    hotelsPanel.getHotelContainer().add(lowestPriceCatalogue.get(i));
                }
    
                hotelsPanel.getHotelContainer().add(hotelsPanel.getCreateHotelButton());
    
                ScrollPaneCustom scrollPane = new ScrollPaneCustom(hotelsPanel.getHotelContainer(), new Color(40, 68, 117), new Color(40, 68, 117), new Color(13, 22, 45));
                scrollPane.setBounds(0, 60, 620, 405);
                scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
    
                hotelsPanel.add(scrollPane, JLayeredPane.DEFAULT_LAYER);
            }
            else if (e.getSource() == highestPriceButton){
    
                hotelsPanel.getHotelScrollPane().setVisible(false);
                hotelsPanel.remove(hotelsPanel.getHotelScrollPane());
    
                hotelsPanel.getHotelContainer().removeAll();
    
                ArrayList<HotelOption> highestPriceCatalogue = new ArrayList<HotelOption>();
    
                // TODO: add filter function for highest price
                ArrayList<Hotel> highestPrice = new ArrayList<Hotel>();
                highestPrice.add(model.getHotels().get(4));
                highestPrice.add(model.getHotels().get(3));
                highestPrice.add(model.getHotels().get(2));
                highestPrice.add(model.getHotels().get(5));
                highestPrice.add(model.getHotels().get(0));
                highestPrice.add(model.getHotels().get(1));
    
                for(int i = 0; i < model.countHotels(); i++){
                    HotelOption optionTemp = new HotelOption(highestPrice.get(i));
                    hotelsPanel.initializeHotelOption(optionTemp, highestPrice.get(i), i);
                    highestPriceCatalogue.add(optionTemp);
                    hotelsPanel.getHotelContainer().add(highestPriceCatalogue.get(i));
                }
    
                hotelsPanel.getHotelContainer().add(hotelsPanel.getCreateHotelButton());
    
                ScrollPaneCustom scrollPane = new ScrollPaneCustom(hotelsPanel.getHotelContainer(), new Color(40, 68, 117), new Color(40, 68, 117), new Color(13, 22, 45));
                scrollPane.setBounds(0, 60, 620, 405);
                scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
    
                hotelsPanel.add(scrollPane);
            }
            else if (e.getSource() == newestButton){
    
                hotelsPanel.getHotelScrollPane().setVisible(false);
                hotelsPanel.remove(hotelsPanel.getHotelScrollPane());
    
                hotelsPanel.getHotelContainer().removeAll();
    
                ArrayList<HotelOption> newestCatalogue = new ArrayList<HotelOption>();
    
                // TODO: add filter function for newest
                ArrayList<Hotel> newest = new ArrayList<Hotel>();
                newest.add(model.getHotels().get(0));
                newest.add(model.getHotels().get(1));
                newest.add(model.getHotels().get(2));
                newest.add(model.getHotels().get(3));
                newest.add(model.getHotels().get(4));
                newest.add(model.getHotels().get(5));
    
                for(int i = 0; i < model.countHotels(); i++){
                    HotelOption optionTemp = new HotelOption(newest.get(i));
                    hotelsPanel.initializeHotelOption(optionTemp, newest.get(i), i);
                    newestCatalogue.add(optionTemp);
                    hotelsPanel.getHotelContainer().add(newestCatalogue.get(i));
                }
    
                hotelsPanel.getHotelContainer().add(hotelsPanel.getCreateHotelButton());
    
                ScrollPaneCustom scrollPane = new ScrollPaneCustom(hotelsPanel.getHotelContainer(), new Color(40, 68, 117), new Color(40, 68, 117), new Color(13, 22, 45));
                scrollPane.setBounds(0, 60, 620, 405);
                scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
    
                hotelsPanel.add(scrollPane);
            }
        }   
    }

    private class SelectedHotelListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            OptionButton dateAvailButton = view.getSelectedHotelPanel().getDateAvailButton();
            OptionButton roomInfoButton = view.getSelectedHotelPanel().getRoomInfoButton();
            OptionButton resInfoButton = view.getSelectedHotelPanel().getResInfoButton();
            OptionButton bookButton = view.getSelectedHotelPanel().getBookButton();
            IconButton manageButton = view.getSelectedHotelPanel().getManageButton();

            DateAvailPanel dateAvailPanel = view.getSelectedHotelPanel().getDateAvailPanel();
            RoomInfoPanel roomInfoPanel = view.getSelectedHotelPanel().getRoomInfoPanel();
            ResInfoPanel resInfoPanel = view.getSelectedHotelPanel().getResInfoPanel();
            BookHotelPanel bookPanel = view.getSelectedHotelPanel().getBookPanel();
            ManagePanel managePanel = view.getSelectedHotelPanel().getManagePanel();

            if (e.getSource() == dateAvailButton){
                dateAvailPanel.setVisible(true);
                roomInfoPanel.setVisible(false);
                resInfoPanel.setVisible(false);
                dateAvailButton.setColor(new Color(40, 68, 117));
                roomInfoButton.setColor(new Color(27, 43, 80));
                resInfoButton.setColor(new Color(27, 43, 80));
            }
            else if (e.getSource() == roomInfoButton){
                dateAvailPanel.setVisible(false);
                roomInfoPanel.setVisible(true);
                resInfoPanel.setVisible(false);
                dateAvailButton.setColor(new Color(27, 43, 80));
                roomInfoButton.setColor(new Color(40, 68, 117));
                resInfoButton.setColor(new Color(27, 43, 80));
            }
            else if (e.getSource() == resInfoButton){
                dateAvailPanel.setVisible(false);
                roomInfoPanel.setVisible(false);
                resInfoPanel.setVisible(true);
                dateAvailButton.setColor(new Color(27, 43, 80));
                roomInfoButton.setColor(new Color(27, 43, 80));
                resInfoButton.setColor(new Color(40, 68, 117));
            }
            else if (e.getSource() == bookButton){
                bookPanel = new BookHotelPanel(view.getSelectedHotelPanel().getHotel());
                bookPanel.setBounds(152, 10, 385, 420);
                view.getSelectedHotelPanel().add(bookPanel, JLayeredPane.POPUP_LAYER);
            }
            else if (e.getSource() == manageButton){
                managePanel = new ManagePanel(view.getSelectedHotelPanel().getHotel(), new Color(51, 88, 150)); 
                view.getSelectedHotelPanel().add(managePanel, JLayeredPane.POPUP_LAYER);
            }
        }
    }

    private class BookHotelListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            OptionButton standardRoomInput = view.getBookHotelPanel().getStandardRoomInput();
            OptionButton deluxeRoomInput = view.getBookHotelPanel().getDeluxeRoomInput();
            OptionButton executiveRoomInput = view.getBookHotelPanel().getExecutiveRoomInput();

            if (e.getSource() == standardRoomInput){
                standardRoomInput.setColor(new Color(51, 88, 150));
                deluxeRoomInput.setColor(new Color(27, 43, 80));
                executiveRoomInput.setColor(new Color(27, 43, 80));
                view.getBookHotelPanel().setRoomTypeInput("Standard");
                view.getBookHotelPanel().setRoomTypeSelected(true);
            }
            else if (e.getSource() == deluxeRoomInput){
                standardRoomInput.setColor(new Color(27, 43, 80));
                deluxeRoomInput.setColor(new Color(51, 88, 150));
                executiveRoomInput.setColor(new Color(27, 43, 80));
                view.getBookHotelPanel().setRoomTypeInput("Deluxe");
                view.getBookHotelPanel().setRoomTypeSelected(true);
            }
            else if (e.getSource() == executiveRoomInput){
                standardRoomInput.setColor(new Color(27, 43, 80));
                deluxeRoomInput.setColor(new Color(27, 43, 80));
                executiveRoomInput.setColor(new Color(51, 88, 150));
                view.getBookHotelPanel().setRoomTypeInput("Executive");
                view.getBookHotelPanel().setRoomTypeSelected(true);
            }
            else if (e.getSource() == view.getBookHotelPanel().getBookButton()){
                String name = view.getBookHotelPanel().getGuestNameInput().getTextField().getText().trim();
                String disc = view.getBookHotelPanel().getDiscountInput().getTextField().getText().trim();
                boolean roomTypeSelected = view.getBookHotelPanel().getRoomTypeSelected();
                boolean checkInNOutSelected = view.getBookHotelPanel().getCheckInNOutSelected();

                // TODO: (if filled) check if disc is valid 
                // TODO: check if selected room type is available within the checkIn and checkOut dates
                if (!name.isEmpty() && roomTypeSelected && checkInNOutSelected){
                    
                    // TODO: set all necessary info into Hotel
    
                    view.getBookHotelPanel().setVisible(false);
                    view.getSelectedHotelPanel().remove(view.getBookHotelPanel());
                }
            }
            else if (e.getSource() == view.getBookHotelPanel().getCancelButton()){
                view.getBookHotelPanel().setVisible(false);
                view.getSelectedHotelPanel().remove(view.getBookHotelPanel());
            }

            ArrayList<OptionButton> days = view.getBookHotelPanel().getDays();
            ArrayList<String> clickedButtons = view.getBookHotelPanel().getClickedButtons();
            BookCalendar calendar = view.getBookHotelPanel().getBookCalendar();

            for (int i = 0; i < 31; i++){
                if (e.getSource() == days.get(i)){

                    clickedButtons.add(days.get(i).getButtonName());
    
                    if (clickedButtons.size() > 2){
                        clickedButtons.remove(0);
                        clickedButtons.remove(1);
                    }
    
                    if (clickedButtons.size() == 1){
                        
                        days.get(Integer.valueOf(clickedButtons.get(0)) - 1).setColor(new Color(51, 88, 150));
                        days.get(Integer.valueOf(clickedButtons.get(0)) - 1).setColorOver(new Color(51, 88, 150));
                        
                        for (int j = 0; j < 31; j++){
                            if (j < Integer.valueOf(clickedButtons.get(0)) - 1){
                                days.get(j).setEnabled(false);
                                days.get(j).setColor(new Color(27, 43, 80));
                                days.get(j).setColorOver(new Color(27, 43, 80));
                                days.get(j).setColorClick(new Color(27, 43, 80));
                            }
                        }
                        
                        days.get(30).setEnabled(true);
                        days.get(30).setColor(new Color(27, 43, 80));
                        days.get(30).setColorOver(new Color(40, 68, 117));
                        days.get(30).setColorClick(new Color(51, 88, 150));
                    }
    
                    if (clickedButtons.size() == 2 && !clickedButtons.get(0).equals(clickedButtons.get(1))){
                        calendar.setHighlightedDays(Integer.valueOf(clickedButtons.get(0)), Integer.valueOf(clickedButtons.get(1)));
                        view.getBookHotelPanel().setCheckInInput(Integer.valueOf(clickedButtons.get(0)));
                        view.getBookHotelPanel().setCheckOutInput(Integer.valueOf(clickedButtons.get(1)));
    
                        for (int j = 0; j < 31; j++){
                            if (j >= Integer.valueOf(clickedButtons.get(1))){
                                days.get(j).setColor(new Color(27, 43, 80));
                                days.get(j).setColorOver(new Color(27, 43, 80));
                                days.get(j).setColorClick(new Color(27, 43, 80));
                            }
                            
                            if (j >= Integer.valueOf(clickedButtons.get(0)) && j < Integer.valueOf(clickedButtons.get(1))){
                                days.get(j).setColor(new Color(51, 88, 150));
                                days.get(j).setColorOver(new Color(51, 88, 150));
                            }
    
                            days.get(j).setEnabled(false);
                        }
    
                        view.getBookHotelPanel().setCheckInNOutSelected(true);
                    }
                }
            }
        }
    }

    private class ManageHotelListener implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e) {

            IconButton changeName = view.getManageHotelPanel().getChangeNameButton();
            IconButton addRoom = view.getManageHotelPanel().getAddRoomButton();
            IconButton updateBasePrice = view.getManageHotelPanel().getUpdateBasePriceButton();
            IconButton datePriceModifier = view.getManageHotelPanel().getDatePriceModifierButton();
            IconButton removeRoom = view.getManageHotelPanel().getRemoveRoomButton();
            IconButton removeRes = view.getManageHotelPanel().getRemoveResButton();
            IconButton removeHotel = view.getManageHotelPanel().getRemoveHotelButton();

            RoundPanel manageContainer = view.getManageHotelPanel().getManageContainer();
            ManageSubPanel changeNamePanel = view.getManageHotelPanel().getChangeNamePanel();
            ManageSubPanel addRoomPanel = view.getManageHotelPanel().getAddRoomPanel();
            ManageSubPanel updateBasePricePanel = view.getManageHotelPanel().getUpdateBasePricePanel();
            ManageSubPanel datePriceModifierPanel = view.getManageHotelPanel().getDatePriceModifierPanel();
            ManageSubPanel removeRoomPanel = view.getManageHotelPanel().getRemoveRoomPanel();
            ManageSubPanel removeResPanel = view.getManageHotelPanel().getRemoveResPanel();
            ManageSubPanel removeHotelPanel = view.getManageHotelPanel().getRemoveHotelPanel();

            if (e.getSource() == changeName){
                manageContainer.setVisible(false);
                changeNamePanel.setVisible(true);
                addRoomPanel.setVisible(false);
                updateBasePricePanel.setVisible(false);
                datePriceModifierPanel.setVisible(false);
                removeRoomPanel.setVisible(false);
                removeResPanel.setVisible(false);
                removeHotelPanel.setVisible(false);
            }
            else if (e.getSource() == addRoom){
                manageContainer.setVisible(false);
                changeNamePanel.setVisible(false);
                addRoomPanel.setVisible(true);
                updateBasePricePanel.setVisible(false);
                datePriceModifierPanel.setVisible(false);
                removeRoomPanel.setVisible(false);
                removeResPanel.setVisible(false);
                removeHotelPanel.setVisible(false);
            }
            else if (e.getSource() == updateBasePrice){
                manageContainer.setVisible(false);
                changeNamePanel.setVisible(false);
                addRoomPanel.setVisible(false);
                updateBasePricePanel.setVisible(true);
                datePriceModifierPanel.setVisible(false);
                removeRoomPanel.setVisible(false);
                removeResPanel.setVisible(false);
                removeHotelPanel.setVisible(false);
            }
            else if (e.getSource() == datePriceModifier){
                manageContainer.setVisible(false);
                changeNamePanel.setVisible(false);
                addRoomPanel.setVisible(false);
                updateBasePricePanel.setVisible(false);
                datePriceModifierPanel.setVisible(true);
                removeRoomPanel.setVisible(false);
                removeResPanel.setVisible(false);
                removeHotelPanel.setVisible(false);
            }
            else if (e.getSource() == removeRoom){
                manageContainer.setVisible(false);
                changeNamePanel.setVisible(false);
                addRoomPanel.setVisible(false);
                updateBasePricePanel.setVisible(false);
                datePriceModifierPanel.setVisible(false);
                removeRoomPanel.setVisible(true);
                removeResPanel.setVisible(false);
                removeHotelPanel.setVisible(false);
            }
            else if (e.getSource() == removeRes){
                manageContainer.setVisible(false);
                changeNamePanel.setVisible(false);
                addRoomPanel.setVisible(false);
                updateBasePricePanel.setVisible(false);
                datePriceModifierPanel.setVisible(false);
                removeRoomPanel.setVisible(false);
                removeResPanel.setVisible(true);
                removeHotelPanel.setVisible(false);
            }
            else if (e.getSource() == removeHotel){
                manageContainer.setVisible(false);
                changeNamePanel.setVisible(false);
                addRoomPanel.setVisible(false);
                updateBasePricePanel.setVisible(false);
                datePriceModifierPanel.setVisible(false);
                removeRoomPanel.setVisible(false);
                removeResPanel.setVisible(false);
                removeHotelPanel.setVisible(true);
            }
        }
    }

    private class ManageSubPanelListener implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e) {
            ManageSubPanel changeNamePanel = view.getManageHotelPanel().getChangeNamePanel();
            ManageSubPanel addRoomPanel = view.getManageHotelPanel().getAddRoomPanel();
            ManageSubPanel updateBasePricePanel = view.getManageHotelPanel().getUpdateBasePricePanel();
            ManageSubPanel datePriceModifierPanel = view.getManageHotelPanel().getDatePriceModifierPanel();
            ManageSubPanel removeRoomPanel = view.getManageHotelPanel().getRemoveRoomPanel();
            ManageSubPanel removeResPanel = view.getManageHotelPanel().getRemoveResPanel();
            ManageSubPanel removeHotelPanel = view.getManageHotelPanel().getRemoveHotelPanel();

            TextFieldCustom hotelNameInput = view.getManageHotelPanel().getHotelNameInput();
            TextFieldCustom standardRoomInput = view.getManageHotelPanel().getStandardRoomInput();
            TextFieldCustom deluxeRoomInput = view.getManageHotelPanel().getDeluxeRoomInput();
            TextFieldCustom executiveRoomInput = view.getManageHotelPanel().getExecutiveRoomInput();
            TextFieldCustom basePriceInput = view.getManageHotelPanel().getBasePriceInput();
            TextFieldCustom percentageInput = view.getManageHotelPanel().getPercentageInput();


            if (e.getSource() == changeNamePanel.getUpdateButton()){
                String hotelName = hotelNameInput.getTextField().getText().trim();

                // TODO: check if name is valid

                if (!hotelName.isEmpty()){
                    ConfirmModPanel confirmModPanel = new ConfirmModPanel("Change Name");

                    view.getManageHotelPanel().add(confirmModPanel, JLayeredPane.POPUP_LAYER);
                    confirmModPanel.setVisible(true);
                }
            }
            else if (e.getSource() == addRoomPanel.getUpdateButton()){
                int standard = Integer.valueOf(standardRoomInput.getTextField().getText().trim());
                int deluxe = Integer.valueOf(deluxeRoomInput.getTextField().getText().trim());
                int executive = Integer.valueOf(executiveRoomInput.getTextField().getText().trim());

                if (standard + deluxe + executive > 0 && standard + deluxe + executive <= 50){
                    ConfirmModPanel confirmModPanel = new ConfirmModPanel("Add Room");

                    view.getManageHotelPanel().add(confirmModPanel, JLayeredPane.POPUP_LAYER);
                    confirmModPanel.setVisible(true);
                }
            }
            else if (e.getSource() == updateBasePricePanel.getUpdateButton()){
                Float basePrice = Float.valueOf(basePriceInput.getTextField().getText().trim());

                // TODO: check if there are no reservations

                if (basePrice >= 100.00){
                    ConfirmModPanel confirmModPanel = new ConfirmModPanel("Update Base Price");

                    view.getManageHotelPanel().add(confirmModPanel, JLayeredPane.POPUP_LAYER);
                    confirmModPanel.setVisible(true);
                }
            }
            else if (e.getSource() == datePriceModifierPanel.getUpdateButton()){
                int percentage = Integer.valueOf(percentageInput.getTextField().getText().trim());

                // ?: is there a restriction for percentage input
                ConfirmModPanel confirmModPanel = new ConfirmModPanel("Date Price Modifier");

                view.getManageHotelPanel().add(confirmModPanel, JLayeredPane.POPUP_LAYER);
                confirmModPanel.setVisible(true);

            }
            else if (e.getSource() == removeRoomPanel.getUpdateButton()){
                
                // TODO: check if the selected room has no active reservation
                if (true){
                    ConfirmModPanel confirmModPanel = new ConfirmModPanel("Remove Room");

                    view.getManageHotelPanel().add(confirmModPanel, JLayeredPane.POPUP_LAYER);
                    confirmModPanel.setVisible(true);
                }

            }
            else if (e.getSource() == removeResPanel.getUpdateButton()){

                // ?: is there a restriction for removing a reservation
                ConfirmModPanel confirmModPanel = new ConfirmModPanel("Remove Reservation");

                view.getManageHotelPanel().add(confirmModPanel, JLayeredPane.POPUP_LAYER);
                confirmModPanel.setVisible(true);

            }
            else if (e.getSource() == removeHotelPanel.getUpdateButton()){
                
                // TODO: check if there are no active reservations
                if (true){
                    ConfirmModPanel confirmModPanel = new ConfirmModPanel("Remove Hotel");

                    view.getManageHotelPanel().add(confirmModPanel, JLayeredPane.POPUP_LAYER);
                    confirmModPanel.setVisible(true);
                }
            }
            else if (e.getSource() == changeNamePanel.getCancelButton() || 
                     e.getSource() == addRoomPanel.getCancelButton() ||
                     e.getSource() == updateBasePricePanel.getCancelButton() ||
                     e.getSource() == datePriceModifierPanel.getCancelButton() ||
                     e.getSource() == removeRoomPanel.getCancelButton() ||
                     e.getSource() == removeResPanel.getCancelButton() ||
                     e.getSource() == removeHotelPanel.getCancelButton()){
                view.getManageHotelPanel().setVisible(false);
                view.getSelectedHotelPanel().remove(view.getManageHotelPanel());
            }

            for (int i = 0; i < view.getSelectedHotelPanel().getHotel().countReservations(); i++){
                int nReservations = 6; // TODO: remove
                String name = "";

                ArrayList<OptionButton> resButtons = view.getManageHotelPanel().getResView().getReservations();
                name = resButtons.get(i).getButtonName();

                if (e.getSource() == resButtons.get(i)){
                    resButtons.get(i).setColor(new Color(51, 88, 150));
                    //setRemoveResInput(name); // ! TODO: fix
                }
                else {
                    for (int j = 0; j < nReservations; j++){
                        resButtons.get(i).setColor(new Color(27, 43, 80));
                    }
                }
            }

            for (int i = 0; i < view.getSelectedHotelPanel().getHotel().countRooms(0); i++){
                int nRooms = 30; // TODO: remove
                String name = "";

                ArrayList<OptionButton> roomButtons = view.getManageHotelPanel().getRoomView().getRooms();
                name = roomButtons.get(i).getButtonName();

                if (e.getSource() == roomButtons.get(i)){
                    roomButtons.get(i).setColor(new Color(51, 88, 150));
                    //setRemoveRoomInput(name); // ! TODO: fix
                }
                else {
                    for (int j = 0; j < nRooms; j++){
                        roomButtons.get(i).setColor(new Color(27, 43, 80));
                    }
                }
            }

            for (int i = 0; i < 31; i++){
                ArrayList<OptionButton> days = view.getManageHotelPanel().getCalendarView().getDays();
                String dayIndex = days.get(i).getButtonName(); 
    
                if (e.getSource() == days.get(i)){
                    days.get(i).setColor(new Color(51, 88, 150));
                    //setDateModInput(i); // ! TODO: fix
                }
                else {
                    for (int j = 0; j < 31; j++){
                        days.get(i).setColor(new Color(27, 43, 80));
                    }
                }
            }
        }
    }

    private class ConfirmModListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            TextFieldCustom hotelNameInput = view.getManageHotelPanel().getHotelNameInput();
            TextFieldCustom standardRoomInput = view.getManageHotelPanel().getStandardRoomInput();
            TextFieldCustom deluxeRoomInput = view.getManageHotelPanel().getDeluxeRoomInput();
            TextFieldCustom executiveRoomInput = view.getManageHotelPanel().getExecutiveRoomInput();
            TextFieldCustom basePriceInput = view.getManageHotelPanel().getBasePriceInput();
            TextFieldCustom percentageInput = view.getManageHotelPanel().getPercentageInput();
            String panelName = view.getManageHotelPanel().getConfirmModPanel().getPanelName();

            SelectedHotelPanel selectedHotelPanel = view.getSelectedHotelPanel();
            Hotel hotel = selectedHotelPanel.getHotel();
            int hotelIndex = selectedHotelPanel.getHotelIndex();

            if (panelName.equals("Change Name")){
                String newHotelName = hotelNameInput.getTextField().getText().trim();
                    
                // TODO: set hotel name to getHotelNameInput() in model

                view.getMainFrame().remove(selectedHotelPanel);
                SelectedHotelPanel newSelectedHotelPanel = new SelectedHotelPanel(model.fetchHotel(hotelIndex), hotelIndex);
                newSelectedHotelPanel.setVisible(true);
                view.getMainFrame().add(newSelectedHotelPanel);

                // * Alternative * //
                //selectedHotelPanel.getHotelName().setText(hotel.getHotelName());

            }
            else if (panelName.equals("Add Room")){
                int standardRoom = Integer.valueOf(standardRoomInput.getTextField().getText().trim());
                int deluxeRoom = Integer.valueOf(deluxeRoomInput.getTextField().getText().trim());
                int executiveRoom = Integer.valueOf(executiveRoomInput.getTextField().getText().trim());

                // TODO: add rooms based on room type using getStandardRoomInput(), getDeluxeRoomInput(), and getExecutiveRoomInput() in model
                
                view.getMainFrame().remove(selectedHotelPanel);
                SelectedHotelPanel newSelectedHotelPanel = new SelectedHotelPanel(model.fetchHotel(hotelIndex), hotelIndex);
                newSelectedHotelPanel.setVisible(true);
                view.getMainFrame().add(newSelectedHotelPanel);

                // * Alternative * //
                //selectedHotelPanel.getHotelRooms().setText(String.valueOf(hotel.countRooms(0))); 
            }
            else if (panelName.equals("Update Base Price")){
                Float newBasePrice = Float.valueOf(basePriceInput.getTextField().getText().trim());
                
                // TODO: set hotel base price to getBasePriceInput() in model

                view.getMainFrame().remove(selectedHotelPanel);
                SelectedHotelPanel newSelectedHotelPanel = new SelectedHotelPanel(model.fetchHotel(hotelIndex), hotelIndex);
                newSelectedHotelPanel.setVisible(true);
                view.getMainFrame().add(newSelectedHotelPanel);

                // * Alternative * //
                //selectedHotelPanel.getHotelPrice().setText(String.valueOf(hotel.getBasePrice()));

            }
            else if (panelName.equals("Date Price Modifier")){
                int percentage = Integer.valueOf(percentageInput.getTextField().getText().trim());
                
                // TODO: set percentageInput to datePriceModifier parameters in model

                view.getMainFrame().remove(selectedHotelPanel);
                SelectedHotelPanel newSelectedHotelPanel = new SelectedHotelPanel(model.fetchHotel(hotelIndex), hotelIndex);
                newSelectedHotelPanel.setVisible(true);
                view.getMainFrame().add(newSelectedHotelPanel);
            }
            else if (panelName.equals("Remove Room")){
                String roomName = "Standard"; // TODO: replace with correct input from RoomListener

                // TODO: remove room from hotel using getRemoveRoomInput() in model

                view.getMainFrame().remove(selectedHotelPanel);
                SelectedHotelPanel newSelectedHotelPanel = new SelectedHotelPanel(model.fetchHotel(hotelIndex), hotelIndex);
                newSelectedHotelPanel.setVisible(true);
                view.getMainFrame().add(newSelectedHotelPanel);

                // * Alternative * //
                //selectedHotelPanel.getHotelRooms().setText(String.valueOf(hotel.countRooms(0))); 
            }
            else if (panelName.equals("Remove Reservation")){
                String resName = "Hanielle"; // TODO: replace with correct input from ResListener

                // TODO: remove reservation from hotel using getRemoveResInput() in model

                view.getMainFrame().remove(selectedHotelPanel);
                SelectedHotelPanel newSelectedHotelPanel = new SelectedHotelPanel(model.fetchHotel(hotelIndex), hotelIndex);
                newSelectedHotelPanel.setVisible(true);
                view.getMainFrame().add(newSelectedHotelPanel);

                // * Alternative *//
                //selectedHotelPanel.getHotelRes().setText(String.valueOf(hotel.countReservations())); 
            }
            else if (panelName.equals("Remove Hotel")){

                // TODO: remove hotel in model

                selectedHotelPanel.setVisible(false);
                view.getMainFrame().remove(selectedHotelPanel);
                view.setHotelsPanel(new HotelsPanel(model.getHotels(), model.countHotels()));
                view.getHotelsPanel().setVisible(true);
            }

            view.getManageHotelPanel().getConfirmModPanel().setVisible(false);
            view.getManageHotelPanel().remove(view.getManageHotelPanel().getConfirmModPanel());
            view.getManageHotelPanel().setVisible(false);
            view.getSelectedHotelPanel().remove(view.getManageHotelPanel());
        }
    }

    private class DateAvailabilityListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            Hotel hotel = view.getSelectedHotelPanel().getHotel();
            DateAvailPanel dateAvailPanel = view.getSelectedHotelPanel().getDateAvailPanel();
            CalendarView calendar = dateAvailPanel.getCalendar();

            for (int i = 0; i < 31; i++){
                ArrayList<OptionButton> days = calendar.getDays();
    
                if (e.getSource() == days.get(i)){
                    dateAvailPanel.getAvailPanel().setText(String.valueOf(hotel.countAvailableRooms(i + 1)));
                    dateAvailPanel.getBookedPanel().setText(String.valueOf(hotel.countBookedRooms(i + 1)));
                    days.get(i).setColor(new Color(51, 88, 150));
                }
                else {
                    for (int j = 0; j < 31; j++){
                        days.get(i).setColor(new Color(27, 43, 80));
                    }
                }
            }
        }
    }

    private class RoomInfoListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            Hotel hotel = view.getSelectedHotelPanel().getHotel();
            RoomInfoPanel roomInfoPanel = view.getSelectedHotelPanel().getRoomInfoPanel();
            RoomView roomView = roomInfoPanel.getRoomView();
            CalendarView calendar = roomInfoPanel.getCalendar();

            for (int i = 0; i < hotel.countRooms(0); i++){
                ArrayList<OptionButton> roomButtons = roomView.getRooms();
                ArrayList<OptionButton> days = calendar.getDays();
                String type = hotel.fetchRoom(i).getRoomType();
                float pricePerNight = hotel.fetchRoom(i).getRoomPrice();
                String name = hotel.fetchRoom(i).getRoomName();
                String price = String.format("%.2f", pricePerNight * (i % 7)); 
    
                if (e.getSource() == roomButtons.get(i)){
                    roomInfoPanel.getRoomName().setText("Room " + name);
                    roomInfoPanel.getRoomPrice().setText(price + " per night");
                    roomInfoPanel.getRoomType().setText(type + " Room");
                    roomButtons.get(i).setColor(new Color(51, 88, 150));
    
                    int[] availDatesTemp = hotel.checkRoomAvailability(hotel.fetchRoom(i));
    
                    for (int j = 0; j < availDatesTemp.length; j++){
                        for (int k = 0; k < 31; k++){
                            if (k + 1 == availDatesTemp[j]){ 
                                days.get(k).setColor(new Color(51, 88, 150));
                                days.get(k).setColorOver(new Color(51, 88, 150));
                                days.get(k).setColorClick(new Color(51, 88, 150));
                            } 
                        }
                    }
                }
                else {
                    for (int j = 0; j < hotel.countRooms(0); j++){
                        roomButtons.get(i).setColor(new Color(27, 43, 80));
                    }
    
                }
            }
        }
    }

    private class ResInfoListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            ResInfoPanel resInfoPanel = view.getSelectedHotelPanel().getResInfoPanel();
            Hotel hotel = view.getSelectedHotelPanel().getHotel();

            ArrayList<OptionButton> resButtons = resInfoPanel.getResView().getReservations();
            ArrayList<Reservation> reservations = hotel.getReservations();
            BookCalendar calendar = resInfoPanel.getBookCalendar();

            for (int i = 0; i < hotel.countReservations(); i++){
                String resName = reservations.get(i).getGuestName(); 
                String type = reservations.get(i).getRoom().getRoomType();
                
                if (e.getSource() == resButtons.get(i)){
                    resInfoPanel.getGuestInfoPanel().setText(resName + "'s Reservation");
                    resInfoPanel.getRoomType().setText(type + " Room"); 
                    resButtons.get(i).setColor(new Color(51, 88, 150));
                    calendar.setHighlightedDays(reservations.get(i).getCheckInDate(), reservations.get(i).getCheckOutDate());

                    PriceBreakdownPanel newPriceBreakdownContainer = new PriceBreakdownPanel(reservations.get(i));
                    ScrollPaneCustom newPriceScrollPane = new ScrollPaneCustom(newPriceBreakdownContainer, new Color(51, 88, 150), new Color(51, 88, 150), new Color(40, 68, 117));
                    newPriceScrollPane.setBounds(345, 250, 175, 150);
                    newPriceScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
                    resInfoPanel.setPriceScrollPane(newPriceScrollPane);

                    resInfoPanel.getTotalPrice().setText(String.valueOf(hotel.getReservations().get(i).computeFinalPrice()));
                }
                else {
                    for (int j = 0; j < hotel.countReservations(); j++){
                        resButtons.get(i).setColor(new Color(27, 43, 80));
                    }
                }
            }
        }
    }

}
