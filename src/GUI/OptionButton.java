import java.awt.*;

public class OptionButton extends PanelButton{
    
    OptionButton(String buttonName){
        
        super(buttonName);
        
        Font customFont = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 10);
        
        this.setText(buttonName);
        this.setFont(customFont);
    }
}
