package src.HRS.View;
//package GUI;
import java.awt.*;
import java.awt.event.*;

public class OptionButton extends PanelButton{
    
    OptionButton(String buttonName){
        
        super(buttonName);
        
        Font customFont = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 10);
        
        this.setText(buttonName);
        this.setFont(customFont);
    }
}
