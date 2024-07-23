import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class AccountPanel extends RoundPanel implements ActionListener{
    
    private JLabel hotelTitle;
    private RoundPanel hotelContainer;
    private RoundPanel header;
    private RoundLabel headerLabel;
    private RoundLabel profileLabel;
    private RoundLabel name, status, idNumber;
    private RoundPanel accountInfo;
    private ButtonClickListener listener;
    private ArrayList<HotelOption> hotelCatalogue;
    private int hotelContainerHeight;
    private boolean isVisible = false;

    private Font customFont12;
    private Font customFont15;
    private Font customFont20;
    private Font customFont70;

        // TODO: change to Hotel hotels
    AccountPanel(ButtonClickListener listener){

        super(new Color(13, 22, 45));

        this.listener = listener;

        customFont12 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 12);
        customFont15 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 15);
        customFont20 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 20);
        customFont70 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 70);

        ImageIcon headerIcon = new ImageIcon("Icons/HeaderBackground.jpg");
        //headerIcon = 

        headerLabel = new RoundLabel(Color.red);
        headerLabel.setIcon(headerIcon);
        headerLabel.setBounds(2, 2, 616, 150);

        ImageIcon profileIcon = new ImageIcon("Icons/AccountIcon.png");
        profileIcon = Customization.resizeIcon(profileIcon, 90, 90);

        profileLabel = new RoundLabel(new Color(27, 43, 80));
        profileLabel.setIcon(profileIcon);
        profileLabel.setBounds(25, 90, 120, 120);
        profileLabel.setVerticalAlignment(JLabel.CENTER);
        profileLabel.setHorizontalAlignment(JLabel.CENTER);

        header = new RoundPanel(new Color(13, 22, 45));
        //header = new RoundPanel(Color.red);
        header.setLayout(null);
        header.setBounds(0, 0, 620, 215);
        header.add(profileLabel);
        header.add(headerLabel);

        name = new RoundLabel(new Color(13, 22, 45));
        //name = new RoundLabel(Color.green);
        name.setBounds(5, 5, 200, 22);
        name.setText("User #462005"); // TODO: change to account name
        name.setFont(customFont20);
        name.setForeground(Color.white);

        idNumber = new RoundLabel(new Color(13, 22, 45));
        //idNumber = new RoundLabel(Color.blue);
        idNumber.setBounds(5, 42, 200, 16);
        idNumber.setText("12356473"); // TODO: change to Account id number
        idNumber.setFont(customFont15);
        idNumber.setForeground(Color.white);

        status = new RoundLabel(new Color(13, 22, 45));
        //status = new RoundLabel(Color.red);
        status.setBounds(5, 70, 200, 17);
        status.setText("Guest"); // TODO: change to Account status (Guest / Employee)
        status.setFont(customFont15);
        status.setForeground(Color.white);

        accountInfo = new RoundPanel(new Color(13, 22, 45));
        //accountInfo = new RoundPanel(Color.yellow);
        accountInfo.setLayout(null);
        accountInfo.setBounds(20, 220, 300, 100);
        accountInfo.add(name);
        accountInfo.add(idNumber);
        accountInfo.add(status);



        // * Hotel Title * //
        /*hotelTitle = new JLabel("Hotels");
        hotelTitle.setFont(customFont35);
        hotelTitle.setForeground(Color.white);
        hotelTitle.setVerticalAlignment(JLabel.TOP);
        hotelTitle.setBounds(0, 0, 300, 100);*/

        // * Filter * //
        /*ImageIcon filterIcon = new ImageIcon("Icons/AccountIcon.png"); 
        filterIcon = Customization.resizeIcon(filterIcon, 20, 20); 
        
        filterButton = new IconButton(filterIcon, "Filter");
        filterButton.setBounds(570, 0, 40, 40);
        filterButton.setColorClick(filterButton.getColorOver());
        filterButton.addActionListener(this);

        filterPanel = new FilterPanel(new Color(40, 68, 117));
        filterPanel.setVisible(false);*/

        // * Container * //
        /*hotelContainerHeight = (nHotel + 1) * 10 + (nHotel * 110) + 70;

        hotelContainer = new RoundPanel(new Color(13, 22, 45));
        hotelContainer.setLayout(null);;
        hotelContainer.setPreferredSize(new Dimension(620, hotelContainerHeight));

        for (int i = 0; i < nHotel; i++){
            hotelContainer.add(hotelCatalogue.get(i));
        }

        hotelContainer.add(createHotelButton);*/

        this.setLayout(null);
        this.setBounds(120, 80, 620, 470);
        this.add(header);
        this.add(accountInfo);
    }

                                            // TODO: change to Hotel
    public void initializeHotelOption(HotelOption item, String hotel, int itemNo){

        String hotelName = hotel; // TODO: change to hotel name
        float price = 1299.00f; // TODO: change to hotel price

        item.setBounds(0, (itemNo + 1) * 10 + (itemNo * 110), 600, 110);
        item.setLayout(null);

        RoundLabel content = item.getContent();
        content.setText(hotelName);
        item.setVerticalAlignment(JLabel.CENTER);
        item.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                listener.buttonClicked(hotelName);
            }
        });
        
        item.setFocusable(false);
        // TODO: add other hotel information
        // TODO: add option if there is hotel picture
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        /*if (e.getSource() == filterButton){
            isVisible = !isVisible;
            filterPanel.setVisible(isVisible);

            if (isVisible){
                filterButton.setColor(new Color(40, 68, 117));
            }
            else {
                filterButton.setColor(new Color(27, 43, 80));
            }

            filterButton.repaint();
        }*/
    }

    public JLabel getHotelTitle(){
        return hotelTitle;
    }

    public void setHotelTitle(JLabel hotelTitle){
        this.hotelTitle = hotelTitle;
    }

    public ArrayList<HotelOption> getHotelCatalogue(){
        return hotelCatalogue;
    }

    public void setHotelCatalogue(ArrayList<HotelOption> hotelCatalogue){
        this.hotelCatalogue = hotelCatalogue;
    }

    /*public IconButton getCreateHotelButton(){
        return createHotelButton;
    }

    public void setCreateHotelButton(IconButton createHotelButton){
        this.createHotelButton = createHotelButton;
    }

    public IconButton getFilterButton(){
        return filterButton;
    }

    public void setFilterButton(IconButton filterButton){
        this.filterButton = filterButton;
    }

    public FilterPanel getFilterPanel(){
        return filterPanel;
    }

    public void setFilterPanel(FilterPanel filterPanel){
        this.filterPanel = filterPanel;
    }

    public boolean getVisible(){
        return isVisible;
    }

    public void getVisible(boolean isVisible){
        this.isVisible = isVisible;
    }*/
}
