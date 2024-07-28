package src.HRS.Controller;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

import src.HRS.View.*;
import src.HRS.Model.*;

public class HRSController{
    private HRSModel model;
    private HRSView view;

    public HRSController(HRSModel model, HRSView view) {
        this.model = model;
        this.view = view;
    }

    public void start(){
        view.setMainFrame(new MainFrame(model.getHotels(), model.countHotels()));
        view.setSidePanelListener(new SidePanelListener());
    }

    private class SidePanelListener implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e) {

            MainFrame mainFrame = view.getMainFrame();

            IconButton homeButton = mainFrame.getSidePanel().getHomeButton();
            IconButton hotelButton = mainFrame.getSidePanel().getHotelButton();
            IconButton resButton = mainFrame.getSidePanel().getReservationsButton();
            IconButton accountButton = mainFrame.getSidePanel().getAccountButton();
            IconButton backButton = mainFrame.getSidePanel().getBackButton();

            if (e.getSource() == homeButton){
                HomePanel newHomePanel = new HomePanel(model.getHotels(), model.countHotels());

                mainFrame.getHotelsPanel().setVisible(false);
                mainFrame.getResPanel().setVisible(false);
                mainFrame.getAccountPanel().setVisible(false);
                mainFrame.remove(mainFrame.getHomePanel());
                mainFrame.add(newHomePanel);
                mainFrame.setHomePanel(newHomePanel);
                mainFrame.getHomePanel().setVisible(true);
            }
            else if (e.getSource() == hotelButton){ // ! // BUG: going back to hotels panel after selected hotel
                HotelsPanel newHotelsPanel = new HotelsPanel(model.getHotels(), model.countHotels());

                mainFrame.getHomePanel().setVisible(false);
                mainFrame.getResPanel().setVisible(false);
                mainFrame.getAccountPanel().setVisible(false);
                mainFrame.remove(mainFrame.getHotelsPanel());
                mainFrame.add(newHotelsPanel);
                mainFrame.setHotelsPanel(newHotelsPanel);
                mainFrame.getHotelsPanel().setVisible(true);

                view.setHotelsPanelListener(new HotelsPanelListener());
            }
            else if (e.getSource() == resButton){
                ReservationsPanel newReservationsPanel = new ReservationsPanel(model.getHotels(), model.countHotels());

                mainFrame.getHomePanel().setVisible(false);
                mainFrame.getHotelsPanel().setVisible(false);
                mainFrame.getAccountPanel().setVisible(false);
                mainFrame.remove(mainFrame.getResPanel());
                mainFrame.add(newReservationsPanel);
                mainFrame.setResPanel(newReservationsPanel);
                mainFrame.getResPanel().setVisible(true);
            }
            else if (e.getSource() == accountButton){
                AccountPanel newAccountPanel = new AccountPanel();

                mainFrame.getHomePanel().setVisible(false);
                mainFrame.getHotelsPanel().setVisible(false);
                mainFrame.getResPanel().setVisible(false);
                mainFrame.remove(mainFrame.getAccountPanel());
                mainFrame.add(newAccountPanel);
                mainFrame.setAccountPanel(newAccountPanel);
                mainFrame.getAccountPanel().setVisible(true);
            }
            else if (e.getSource() == backButton){
                System.exit(0);
            }
        }
    }

    private class HotelSelectedListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            MainFrame mainFrame = view.getMainFrame();

            for (int i = 0; i < model.countHotels(); i++){
                    
                if (e.getSource() == mainFrame.getHomePanel().getHotelCatalogue().get(i)){
                    SelectedHotelPanel selectedHotel = mainFrame.getSelectedHotelPanels().get(i);
                    selectedHotel.setVisible(true);
                    mainFrame.setSelectedHotelPanel(selectedHotel);
                    view.initializeSelectedHotelPanel();
                    mainFrame.getHomePanel().setVisible(false);
                    mainFrame.getHotelsPanel().setVisible(false);
                    view.getMainFrame().add(selectedHotel);

                    view.setSelectedHotelListener(new SelectedHotelListener());
                    //view.setManageSubPanelListener(new ManageSubPanelListener());
                    //view.setConfirmModListener(new ConfirmModListener());
                }
                else if (e.getSource() == mainFrame.getHotelsPanel().getHotelCatalogue().get(i)){
                    SelectedHotelPanel selectedHotel = mainFrame.getSelectedHotelPanels().get(i);
                    selectedHotel.setVisible(true);
                    mainFrame.setSelectedHotelPanel(selectedHotel);
                    view.initializeSelectedHotelPanel();
                    mainFrame.getHomePanel().setVisible(false);
                    mainFrame.getHotelsPanel().setVisible(false);
                    view.getMainFrame().add(selectedHotel);

                    view.setSelectedHotelListener(new SelectedHotelListener());
                }
                else {
                    mainFrame.getSelectedHotelPanels().get(i).setVisible(false);
                }
            }
        }
    }

    private class HotelsPanelListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            MainFrame mainFrame = view.getMainFrame();
            HotelsPanel hotelsPanel = mainFrame.getHotelsPanel();
            Boolean isVisible = hotelsPanel.getFilterPanelVisible();
            
            if (e.getSource() == hotelsPanel.getFilterButton()){
                isVisible = !isVisible;
                hotelsPanel.setFilterPanelVisible(isVisible);
                hotelsPanel.getFilterPanel().setVisible(isVisible);

                if (isVisible){
                    hotelsPanel.getFilterButton().setColor(new Color(40, 68, 117));
                }
                else {
                    hotelsPanel.getFilterButton().setColor(new Color(27, 43, 80));
                }

                hotelsPanel.getFilterButton().repaint();

                view.setFilterPanelListener(new FilterPanelListener());
            }
            else if (e.getSource() == hotelsPanel.getCreateHotelButton()){

                CreateHotelPanel newCreateHotelPanel = new CreateHotelPanel();
                newCreateHotelPanel.setBounds(152, 10, 385, 420);

                hotelsPanel.setCreateHotelPanel(newCreateHotelPanel);
                hotelsPanel.add(newCreateHotelPanel);
                hotelsPanel.getCreateHotelPanel().setVisible(true);
                hotelsPanel.add(newCreateHotelPanel, JLayeredPane.POPUP_LAYER);
                view.setCreateHotelListener(new CreateHotelListener());
            }
        }
    }

    private class CreateHotelListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            MainFrame mainFrame = view.getMainFrame();
            CreateHotelPanel createHotelPanel = mainFrame.getHotelsPanel().getCreateHotelPanel();

            if (e.getSource() == mainFrame.getHotelsPanel().getCreateHotelPanel().getCreateButton()){

                TextFieldCustom nameTextField = createHotelPanel.getNameTextField();
                TextFieldCustom standardTextField = createHotelPanel.getStandardRoomTextField();
                TextFieldCustom deluxeTextField = createHotelPanel.getDeluxeRoomTextField();
                TextFieldCustom executiveTextField = createHotelPanel.getExecutiveRoomTextField();

                String name = nameTextField.getTextField().getText().trim();
                int standard = Integer.valueOf(standardTextField.getTextField().getText().trim());
                int deluxe = Integer.valueOf(deluxeTextField.getTextField().getText().trim());
                int executive = Integer.valueOf(executiveTextField.getTextField().getText().trim());

                // TODO: check if hotelName is unique

                // TODO: add method validateHotelName to model

                if (!name.isEmpty() && standard + deluxe + executive > 0 && standard + deluxe + executive <= 50){
                    
                    Hotel newHotel = new Hotel(name, standard, deluxe, executive);
                    model.addHotel(newHotel);

                    createHotelPanel.setVisible(false);
                    mainFrame.getHotelsPanel().remove(createHotelPanel);
    
                    HomePanel newHomePanel = new HomePanel(model.getHotels(), model.countHotels());
                    newHomePanel.setVisible(false);
                    mainFrame.remove(mainFrame.getHomePanel());
                    mainFrame.add(newHomePanel);
                    mainFrame.setHomePanel(newHomePanel);
    
                    HotelsPanel newHotelsPanel = new HotelsPanel(model.getHotels(), model.countHotels());
                    newHotelsPanel.setVisible(false);
                    mainFrame.remove(mainFrame.getHotelsPanel());
                    mainFrame.add(newHotelsPanel);
                    mainFrame.setHotelsPanel(newHotelsPanel);
                    
                    newHotelsPanel.setVisible(true);
                    
                    mainFrame.initializeSelectedHotels(model.getHotels(), model.countHotels());
                    view.setHotelsPanelListener(new HotelsPanelListener());
                    view.setHotelSelectedListener(new HotelSelectedListener());
                }
            }
            else if (e.getSource() == mainFrame.getHotelsPanel().getCreateHotelPanel().getCancelButton()){

                createHotelPanel.setVisible(false);
                mainFrame.getHotelsPanel().remove(createHotelPanel);
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
    
                ArrayList<Hotel> mostBooked = model.sortMostBooked();
    
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
    
                ArrayList<Hotel> lowestPrice = model.sortLeastExpensive();
    
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
    
                ArrayList<Hotel> highestPrice = model.sortMostExpensive();
    
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
    
                ArrayList<Hotel> newest = model.sortNewest();
    
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

            MainFrame mainFrame = view.getMainFrame();
            SelectedHotelPanel selectedHotelPanel = mainFrame.getSelectedHotelPanel();

            OptionButton dateAvailButton = selectedHotelPanel.getDateAvailButton();
            OptionButton roomInfoButton = selectedHotelPanel.getRoomInfoButton();
            OptionButton resInfoButton = selectedHotelPanel.getResInfoButton();
            OptionButton bookButton = selectedHotelPanel.getBookButton();
            IconButton manageButton = selectedHotelPanel.getManageButton();

            DateAvailPanel dateAvailPanel = selectedHotelPanel.getDateAvailPanel();
            RoomInfoPanel roomInfoPanel = selectedHotelPanel.getRoomInfoPanel();
            ResInfoPanel resInfoPanel = selectedHotelPanel.getResInfoPanel();
            BookHotelPanel bookPanel = selectedHotelPanel.getBookPanel();
            ManagePanel managePanel = selectedHotelPanel.getManagePanel();

            if (e.getSource() == dateAvailButton){

                DateAvailPanel newDateAvailPanel = new DateAvailPanel(selectedHotelPanel.getHotel());
                selectedHotelPanel.getViewPanel().remove(selectedHotelPanel.getDateAvailPanel());
                selectedHotelPanel.getViewPanel().add(newDateAvailPanel);
                selectedHotelPanel.setDateAvailPanel(newDateAvailPanel);
                newDateAvailPanel.setBounds(40, 60, 540, 220);
                newDateAvailPanel.setVisible(true);

                roomInfoPanel.setVisible(false);
                resInfoPanel.setVisible(false);
                dateAvailButton.setColor(new Color(40, 68, 117));
                roomInfoButton.setColor(new Color(27, 43, 80));
                resInfoButton.setColor(new Color(27, 43, 80));

                view.setDateAvailabilityListener(new DateAvailabilityListener());
            }
            else if (e.getSource() == roomInfoButton){

                RoomInfoPanel newRoomInfoPanel = new RoomInfoPanel(selectedHotelPanel.getHotel());
                selectedHotelPanel.getViewPanel().remove(selectedHotelPanel.getRoomInfoPanel());
                selectedHotelPanel.getViewPanel().add(newRoomInfoPanel);
                selectedHotelPanel.setRoomInfoPanel(newRoomInfoPanel);
                newRoomInfoPanel.setBounds(40, 60, 540, 220);
                newRoomInfoPanel.setVisible(true);
                
                dateAvailPanel.setVisible(false);
                resInfoPanel.setVisible(false);
                dateAvailButton.setColor(new Color(27, 43, 80));
                roomInfoButton.setColor(new Color(40, 68, 117));
                resInfoButton.setColor(new Color(27, 43, 80));

                view.setRoomInfoListener(new RoomInfoListener());
            }
            else if (e.getSource() == resInfoButton){

                ResInfoPanel newResInfoPanel = new ResInfoPanel(selectedHotelPanel.getHotel());
                selectedHotelPanel.getViewPanel().remove(selectedHotelPanel.getResInfoPanel());
                selectedHotelPanel.getViewPanel().add(newResInfoPanel);
                selectedHotelPanel.setResInfoPanel(newResInfoPanel);
                newResInfoPanel.setBounds(40, 60, 540, 220);
                newResInfoPanel.setVisible(true);

                dateAvailPanel.setVisible(false);
                roomInfoPanel.setVisible(false);
                dateAvailButton.setColor(new Color(27, 43, 80));
                roomInfoButton.setColor(new Color(27, 43, 80));
                resInfoButton.setColor(new Color(40, 68, 117));

                view.setResInfoListener(new ResInfoListener());
            }
            else if (e.getSource() == bookButton){

                BookHotelPanel newBookPanel = new BookHotelPanel(selectedHotelPanel.getHotel());
                selectedHotelPanel.setBookPanel(newBookPanel);
                newBookPanel.setBounds(152, 10, 385, 420);
                newBookPanel.setVisible(true);

                selectedHotelPanel.add(newBookPanel, JLayeredPane.POPUP_LAYER);

                view.setBookHotelListener(new BookHotelListener());
            }
            else if (e.getSource() == manageButton){
                managePanel = new ManagePanel(view.getSelectedHotelPanel().getHotel(), new Color(51, 88, 150)); 
                view.getSelectedHotelPanel().add(managePanel, JLayeredPane.POPUP_LAYER);

                view.setManageHotelListener(new ManageHotelListener());
            }
        }
    }

    private class BookHotelListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            MainFrame mainFrame = view.getMainFrame();
            SelectedHotelPanel selectedHotelPanel = mainFrame.getSelectedHotelPanel();
            int hotelIndex = selectedHotelPanel.getHotelIndex();
            BookHotelPanel bookHotelPanel = selectedHotelPanel.getBookPanel();
            OptionButton standardRoomButton = bookHotelPanel.getStandardRoomButton();
            OptionButton deluxeRoomButton = bookHotelPanel.getDeluxeRoomButton();
            OptionButton executiveRoomButton = bookHotelPanel.getExecutiveRoomButton();

            if (e.getSource() == standardRoomButton){
                standardRoomButton.setColor(new Color(51, 88, 150));
                deluxeRoomButton.setColor(new Color(27, 43, 80));
                executiveRoomButton.setColor(new Color(27, 43, 80));
                bookHotelPanel.setRoomTypeInput(1);
                bookHotelPanel.setRoomTypeSelected(true);
            }
            else if (e.getSource() == deluxeRoomButton){
                standardRoomButton.setColor(new Color(27, 43, 80));
                deluxeRoomButton.setColor(new Color(51, 88, 150));
                executiveRoomButton.setColor(new Color(27, 43, 80));
                bookHotelPanel.setRoomTypeInput(2);
                bookHotelPanel.setRoomTypeSelected(true);
            }
            else if (e.getSource() == executiveRoomButton){
                standardRoomButton.setColor(new Color(27, 43, 80));
                deluxeRoomButton.setColor(new Color(27, 43, 80));
                executiveRoomButton.setColor(new Color(51, 88, 150));
                bookHotelPanel.setRoomTypeInput(3);
                bookHotelPanel.setRoomTypeSelected(true);
            }
            else if (e.getSource() == bookHotelPanel.getBookButton()){
                String name = bookHotelPanel.getGuestNameTextField().getTextField().getText().trim();
                String disc = bookHotelPanel.getDiscountTextField().getTextField().getText().trim();
                boolean roomTypeSelected = bookHotelPanel.getRoomTypeSelected();
                int roomType = bookHotelPanel.getRoomTypeInput();
                boolean checkInNOutSelected = bookHotelPanel.getCheckInNOutSelected();
                int checkIn = bookHotelPanel.getCheckInInput();
                int checkOut = bookHotelPanel.getCheckOutInput();

                // TODO: (if filled) check if disc is valid 
                // TODO: check if selected room type is available within the checkIn and checkOut dates
                if (!name.isEmpty() && roomTypeSelected && checkInNOutSelected){
                    
                    Hotel hotel = model.getHotels().get(hotelIndex);
                    int roomIndex = hotel.checkDateAvailability(checkIn, checkOut, roomType);

                    if (roomIndex != -1){
                        
                        Room room = hotel.fetchRoom(roomIndex);
                        hotel.addReservation(name, checkIn, checkOut, room);

                        bookHotelPanel.setVisible(false); // ! // BUG: lags with visibility
                        selectedHotelPanel.remove(bookHotelPanel);

                        SelectedHotelPanel newSelectedHotelPanel = new SelectedHotelPanel(model.getHotels().get(hotelIndex), hotelIndex);
                        newSelectedHotelPanel.setVisible(true);
                        mainFrame.remove(mainFrame.getSelectedHotelPanel());
                        mainFrame.add(newSelectedHotelPanel);
                        mainFrame.setSelectedHotelPanel(newSelectedHotelPanel);

                        view.setSelectedHotelListener(new SelectedHotelListener());
                    }
                }
            }
            else if (e.getSource() == bookHotelPanel.getCancelButton()){
                bookHotelPanel.setVisible(false);
                selectedHotelPanel.remove(view.getBookHotelPanel());
            }

            ArrayList<OptionButton> days = bookHotelPanel.getDays();
            ArrayList<String> clickedButtons = bookHotelPanel.getClickedButtons();
            BookCalendar calendar = bookHotelPanel.getBookCalendar();

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
                        bookHotelPanel.setCheckInInput(Integer.valueOf(clickedButtons.get(0)));
                        bookHotelPanel.setCheckOutInput(Integer.valueOf(clickedButtons.get(1)));
    
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
    
                        bookHotelPanel.setCheckInNOutSelected(true);
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
            int hotelIndex = view.getSelectedHotelPanel().getHotelIndex();

            ManageSubPanel changeNamePanel = view.getManageHotelPanel().getChangeNamePanel();
            ManageSubPanel addRoomPanel = view.getManageHotelPanel().getAddRoomPanel();
            ManageSubPanel updateBasePricePanel = view.getManageHotelPanel().getUpdateBasePricePanel();
            ManageSubPanel datePriceModifierPanel = view.getManageHotelPanel().getDatePriceModifierPanel();
            ManageSubPanel removeRoomPanel = view.getManageHotelPanel().getRemoveRoomPanel();
            ManageSubPanel removeResPanel = view.getManageHotelPanel().getRemoveResPanel();
            ManageSubPanel removeHotelPanel = view.getManageHotelPanel().getRemoveHotelPanel();

            TextFieldCustom hotelNameTextField = view.getManageHotelPanel().getHotelNameTextField();
            TextFieldCustom standardRoomTextField = view.getManageHotelPanel().getStandardRoomTextField();
            TextFieldCustom deluxeRoomTextField = view.getManageHotelPanel().getDeluxeRoomTextField();
            TextFieldCustom executiveRoomTextField = view.getManageHotelPanel().getExecutiveRoomTextField();
            TextFieldCustom basePriceTextField = view.getManageHotelPanel().getBasePriceTextField();
            TextFieldCustom percentageTextField = view.getManageHotelPanel().getPercentageTextField();


            if (e.getSource() == changeNamePanel.getUpdateButton()){
                String hotelName = hotelNameTextField.getTextField().getText().trim();

                // TODO: check if name is valid
                // TODO: put validateHotelName method in model

                if (!hotelName.isEmpty()){
                    ConfirmModPanel confirmModPanel = new ConfirmModPanel("Change Name");

                    view.getManageHotelPanel().add(confirmModPanel, JLayeredPane.POPUP_LAYER);
                    confirmModPanel.setVisible(true);
                }
            }
            else if (e.getSource() == addRoomPanel.getUpdateButton()){
                int standard = Integer.valueOf(standardRoomTextField.getTextField().getText().trim());
                int deluxe = Integer.valueOf(deluxeRoomTextField.getTextField().getText().trim());
                int executive = Integer.valueOf(executiveRoomTextField.getTextField().getText().trim());

                if (standard + deluxe + executive > 0 && standard + deluxe + executive <= 50){
                    ConfirmModPanel confirmModPanel = new ConfirmModPanel("Add Room");

                    view.getManageHotelPanel().add(confirmModPanel, JLayeredPane.POPUP_LAYER);
                    confirmModPanel.setVisible(true);
                }
            }
            else if (e.getSource() == updateBasePricePanel.getUpdateButton()){
                Float basePrice = Float.valueOf(basePriceTextField.getTextField().getText().trim());

                // TODO: check if there are no reservations
                // TODO: create a countAllReservation method in model

                if (basePrice >= 100.00){
                    ConfirmModPanel confirmModPanel = new ConfirmModPanel("Update Base Price");

                    view.getManageHotelPanel().add(confirmModPanel, JLayeredPane.POPUP_LAYER);
                    confirmModPanel.setVisible(true);
                }
            }
            else if (e.getSource() == datePriceModifierPanel.getUpdateButton()){

                int percentage = Integer.valueOf(percentageTextField.getTextField().getText().trim());

                ConfirmModPanel confirmModPanel = new ConfirmModPanel("Date Price Modifier");

                view.getManageHotelPanel().add(confirmModPanel, JLayeredPane.POPUP_LAYER);
                confirmModPanel.setVisible(true);

            }
            else if (e.getSource() == removeRoomPanel.getUpdateButton()){
                
                if (model.getHotels().get(hotelIndex).countReservations() == 0){
                    ConfirmModPanel confirmModPanel = new ConfirmModPanel("Remove Room");

                    view.getManageHotelPanel().add(confirmModPanel, JLayeredPane.POPUP_LAYER);
                    confirmModPanel.setVisible(true);
                }

            }
            else if (e.getSource() == removeResPanel.getUpdateButton()){

                ConfirmModPanel confirmModPanel = new ConfirmModPanel("Remove Reservation");

                view.getManageHotelPanel().add(confirmModPanel, JLayeredPane.POPUP_LAYER);
                confirmModPanel.setVisible(true);

            }
            else if (e.getSource() == removeHotelPanel.getUpdateButton()){
                
                // TODO: check if there are no active reservations
                // TODO: create a countAllReservation method in model
                
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
                int nReservations = model.getHotels().get(hotelIndex).countReservations();

                ArrayList<OptionButton> resButtons = view.getManageHotelPanel().getResView().getReservations();

                if (e.getSource() == resButtons.get(i)){
                    int resIndex = i;
                    resButtons.get(i).setColor(new Color(51, 88, 150));
                    view.getManageHotelPanel().setRemoveResInput(resIndex); 
                }
                else {
                    for (int j = 0; j < nReservations; j++){
                        resButtons.get(i).setColor(new Color(27, 43, 80));
                    }
                }
            }

            for (int i = 0; i < view.getSelectedHotelPanel().getHotel().countRooms(0); i++){
                int nRooms = model.getHotels().get(hotelIndex).countRooms(0);

                ArrayList<OptionButton> roomButtons = view.getManageHotelPanel().getRoomView().getRooms();

                if (e.getSource() == roomButtons.get(i)){
                    int roomIndex = i;
                    roomButtons.get(i).setColor(new Color(51, 88, 150));
                    view.getManageHotelPanel().setRemoveRoomInput(roomIndex);
                }
                else {
                    for (int j = 0; j < nRooms; j++){
                        roomButtons.get(i).setColor(new Color(27, 43, 80));
                    }
                }
            }

            for (int i = 0; i < 31; i++){
                ArrayList<OptionButton> days = view.getManageHotelPanel().getCalendarView().getDays();
    
                if (e.getSource() == days.get(i)){
                    int dateIndex = i;
                    days.get(i).setColor(new Color(51, 88, 150));
                    view.getManageHotelPanel().setDateModInput(dateIndex);
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

            ManagePanel managePanel = view.getManageHotelPanel();
            TextFieldCustom hotelNameTextField = view.getManageHotelPanel().getHotelNameTextField();
            TextFieldCustom standardRoomTextField = view.getManageHotelPanel().getStandardRoomTextField();
            TextFieldCustom deluxeRoomTextField = view.getManageHotelPanel().getDeluxeRoomTextField();
            TextFieldCustom executiveRoomTextField = view.getManageHotelPanel().getExecutiveRoomTextField();
            TextFieldCustom basePriceTextField = view.getManageHotelPanel().getBasePriceTextField();
            TextFieldCustom percentageTextField = view.getManageHotelPanel().getPercentageTextField();
            String panelName = view.getManageHotelPanel().getConfirmModPanel().getPanelName();

            SelectedHotelPanel selectedHotelPanel = view.getSelectedHotelPanel();
            Hotel hotel = selectedHotelPanel.getHotel();
            int hotelIndex = selectedHotelPanel.getHotelIndex();

            if (panelName.equals("Change Name")){
                String newHotelName = hotelNameTextField.getTextField().getText().trim();
                    
                // TODO: set hotel name to newHotelName in model

                view.getMainFrame().remove(selectedHotelPanel);
                SelectedHotelPanel newSelectedHotelPanel = new SelectedHotelPanel(model.fetchHotel(hotelIndex), hotelIndex);
                newSelectedHotelPanel.setVisible(true);
                view.getMainFrame().add(newSelectedHotelPanel);
            }
            else if (panelName.equals("Add Room")){
                int standardRoom = Integer.valueOf(standardRoomTextField.getTextField().getText().trim());
                int deluxeRoom = Integer.valueOf(deluxeRoomTextField.getTextField().getText().trim());
                int executiveRoom = Integer.valueOf(executiveRoomTextField.getTextField().getText().trim());

                // TODO: add rooms based on room type in model
                
                view.getMainFrame().remove(selectedHotelPanel);
                SelectedHotelPanel newSelectedHotelPanel = new SelectedHotelPanel(model.fetchHotel(hotelIndex), hotelIndex);
                newSelectedHotelPanel.setVisible(true);
                view.getMainFrame().add(newSelectedHotelPanel);
            }
            else if (panelName.equals("Update Base Price")){
                Float newBasePrice = Float.valueOf(basePriceTextField.getTextField().getText().trim());
                
                // TODO: set hotel base price to newBasePrice in model

                view.getMainFrame().remove(selectedHotelPanel);
                SelectedHotelPanel newSelectedHotelPanel = new SelectedHotelPanel(model.fetchHotel(hotelIndex), hotelIndex);
                newSelectedHotelPanel.setVisible(true);
                view.getMainFrame().add(newSelectedHotelPanel);
            }
            else if (panelName.equals("Date Price Modifier")){
                int percentage = Integer.valueOf(percentageTextField.getTextField().getText().trim());
                
                // TODO: set percentage to datePriceModifier parameters in model

                view.getMainFrame().remove(selectedHotelPanel);
                SelectedHotelPanel newSelectedHotelPanel = new SelectedHotelPanel(model.fetchHotel(hotelIndex), hotelIndex);
                newSelectedHotelPanel.setVisible(true);
                view.getMainFrame().add(newSelectedHotelPanel);
            }
            else if (panelName.equals("Remove Room")){
                String roomName = "B5"; // TODO: replace with correct input from RoomListener

                // TODO: remove room from hotel in model

                view.getMainFrame().remove(selectedHotelPanel);
                SelectedHotelPanel newSelectedHotelPanel = new SelectedHotelPanel(model.fetchHotel(hotelIndex), hotelIndex);
                newSelectedHotelPanel.setVisible(true);
                view.getMainFrame().add(newSelectedHotelPanel);
            }
            else if (panelName.equals("Remove Reservation")){
                int resIndex = view.getManageHotelPanel().getRemoveResInput();

                model.getHotels().get(hotelIndex).removeReservation(resIndex);

                view.getMainFrame().remove(selectedHotelPanel);
                SelectedHotelPanel newSelectedHotelPanel = new SelectedHotelPanel(model.fetchHotel(hotelIndex), hotelIndex);
                newSelectedHotelPanel.setVisible(true);
                view.getMainFrame().add(newSelectedHotelPanel);
            }
            else if (panelName.equals("Remove Hotel")){
                
                selectedHotelPanel.setVisible(false);
                view.getMainFrame().remove(selectedHotelPanel);
                model.getHotels().remove(hotelIndex);
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

            MainFrame mainFrame = view.getMainFrame();
            SelectedHotelPanel selectedHotelPanel = mainFrame.getSelectedHotelPanel();
            Hotel hotel = selectedHotelPanel.getHotel();
            DateAvailPanel dateAvailPanel = selectedHotelPanel.getDateAvailPanel();
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

            MainFrame mainFrame = view.getMainFrame();
            SelectedHotelPanel selectedHotelPanel = mainFrame.getSelectedHotelPanel();
            Hotel hotel = selectedHotelPanel.getHotel();
            RoomInfoPanel roomInfoPanel = selectedHotelPanel.getRoomInfoPanel();
            RoomView roomView = roomInfoPanel.getRoomView();
            CalendarView calendar = roomInfoPanel.getCalendar();

            for (int i = 0; i < hotel.countRooms(0); i++){
                ArrayList<OptionButton> roomButtons = roomView.getRooms();
                ArrayList<OptionButton> days = calendar.getDays();
                String type = hotel.fetchRoom(i).getRoomType();
                float pricePerNight = hotel.fetchRoom(i).getRoomPrice();
                String name = hotel.fetchRoom(i).getRoomName();
                String price = String.format("%.2f", pricePerNight); 
    
                if (e.getSource() == roomButtons.get(i)){
                    roomInfoPanel.getRoomName().setText("Room " + name);
                    roomInfoPanel.getRoomPrice().setText(price + " per night");
                    roomInfoPanel.getRoomType().setText(type + " Room");
                    roomButtons.get(i).setColor(new Color(51, 88, 150));
    
                    int[] availDatesTemp = hotel.checkRoomAvailability(hotel.fetchRoom(i));
    
                    for (int j = 0; j < availDatesTemp.length; j++){

                        if (availDatesTemp[j] == 0){ 
                            days.get(j).setColor(new Color(51, 88, 150));
                            days.get(j).setColorOver(new Color(51, 88, 150));
                            days.get(j).setColorClick(new Color(51, 88, 150));
                        }
                        else {
                            days.get(j).setColor(new Color(27, 43, 80));
                            days.get(j).setColorOver(new Color(27, 43, 80));
                            days.get(j).setColorClick(new Color(27, 43, 80));
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

            MainFrame mainFrame = view.getMainFrame();
            SelectedHotelPanel selectedHotelPanel = mainFrame.getSelectedHotelPanel();
            ResInfoPanel resInfoPanel = selectedHotelPanel.getResInfoPanel();
            Hotel hotel = selectedHotelPanel.getHotel();

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

                    BookCalendar newCalendar = new BookCalendar();
                    newCalendar.setBounds(5, 239, 335, 203);
                    ArrayList<OptionButton> days = newCalendar.getDays();
                    
                    for(int j = 0; j < days.size(); j++){
                        days.get(j).setEnabled(false);
                        days.get(j).setColorOver(days.get(j).getColor());
                        days.get(j).setColorClick(days.get(j).getColor());
                    }

                    resInfoPanel.getResInfoContainer().remove(calendar);
                    resInfoPanel.getResInfoContainer().add(newCalendar);
                    resInfoPanel.setBookCalendar(newCalendar);
                    newCalendar.setHighlightedDays(reservations.get(i).getCheckInDate(), reservations.get(i).getCheckOutDate());

                    // ! // BUG: doesn't show breakdown
                    // TODO: create method to get the price breakdown
                    /*PriceBreakdownPanel newPriceBreakdownContainer = new PriceBreakdownPanel(reservations.get(i));
                    ScrollPaneCustom newPriceScrollPane = new ScrollPaneCustom(newPriceBreakdownContainer, new Color(51, 88, 150), new Color(51, 88, 150), new Color(40, 68, 117));
                    newPriceScrollPane.setBounds(345, 250, 175, 150);
                    newPriceScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
                    resInfoPanel.setPriceScrollPane(newPriceScrollPane);

                    resInfoPanel.getTotalPrice().setText(String.valueOf(hotel.getReservations().get(i).computeFinalPrice()));*/
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
