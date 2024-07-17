import java.awt.*;

import javax.swing.*;

public class ScrollBarCustom extends JScrollBar{
    
    public ScrollBarCustom(Color thumbColor, Color trackColor){
        this.setUI(new ModernScrollBarUI(thumbColor, trackColor));
        this.setPreferredSize(new Dimension(7, 8));
        //this.setForeground(thumbColor);
        //this.setBackground(Color.black);
        this.setOpaque(false);
    }
}
