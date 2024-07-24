import javax.swing.*;
import java.awt.*;

public class IconButton extends PanelButton{
    
    IconButton(ImageIcon icon, String buttonName){
        
        super(buttonName);
        this.setIcon(icon);
    }
}
