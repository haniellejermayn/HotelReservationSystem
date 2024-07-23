import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class RoomView extends RoundPanel{
    
    private ArrayList<OptionButton> rooms;
    private ButtonClickListener listener;

    private Font customFont;

    RoomView(ButtonClickListener listener){
        
        super(new Color(27, 43, 80));

        this.listener = listener;

        customFont = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 10);

        rooms = new ArrayList<OptionButton>();

        int nRooms = 50;
        
        for (int i = 0; i < nRooms; i++){
            OptionButton room = new OptionButton(Integer.toString(i + 1));
            String dayIndex = String.format("%02d", i + 1);

            if ((i + 1) % 7 == 1){
                room.setBounds((i % 7 * 41) + (i % 7 + 1) * 8, (i / 7 + 1) * 9 + (i / 7 * 30), 41, 30);
            }
            else {
                room.setBounds((i % 7 * 41) + (i % 7 + 1) * 5 + 3, (i / 7 + 1) * 9 + (i / 7 * 30), 41, 30);
            }

            room.setFont(customFont);
            room.addActionListener(new ActionListener(){

                @Override
                public void actionPerformed(ActionEvent e){
                    listener.buttonClicked(dayIndex);
                }
            });

            rooms.add(room);
            this.add(rooms.get(i));
        }


        this.setLayout(null);
        this.setBounds(10, 10, 335, 203);
    }
}
