package src.HRS.View;

//import src.HRS.Model.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import src.HRS.Model.Hotel;

public class RoomView extends RoundPanel{
    
    private ArrayList<OptionButton> rooms;
    private Font customFont;

    public RoomView(Hotel hotel){ // TODO: remove vutton listener
        
        super(new Color(27, 43, 80));

        customFont = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 9);

        rooms = new ArrayList<OptionButton>();
        
        for (int i = 0; i < hotel.countRooms(0); i++){
            OptionButton room = new OptionButton(hotel.fetchRoom(i).getRoomName()); 
            String name = hotel.fetchRoom(i).getRoomName();

            if ((i + 1) % 5 == 1){
                if (i >= 0 && i <= 4){
                    room.setBounds((i % 5 * 41) + (i % 5 + 1) * 8, (i / 5 + 1) * 5 + (i / 5 * 30), 41, 30);
                }
                else {
                    room.setBounds((i % 5 * 41) + (i % 5 + 1) * 8, (i / 5 + 1) * 9 - 4 + (i / 5 * 30), 41, 30);
                }
            }
            else {
                room.setBounds((i % 5 * 41) + (i % 5 + 1) * 5 + 3, (i / 5 + 1) * 9 - 4 + (i / 5 * 30), 41, 30);
            }

            room.setFont(customFont);
            /*room.addActionListener(new ActionListener(){

                @Override
                public void actionPerformed(ActionEvent e){
                    listener.roomButtonClicked(name);
                }
            });*/

            rooms.add(room);
            this.add(rooms.get(i));
        }
        this.setLayout(null);
    }

    public ArrayList<OptionButton> getRooms(){
        return rooms;
    }

    public void setRooms( ArrayList<OptionButton> rooms){
        this.rooms = rooms;
    }
}
