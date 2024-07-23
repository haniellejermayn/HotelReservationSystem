package GUI;

import java.awt.*;
import javax.swing.*;

public class ScrollBarCustom extends JScrollBar{
    
    public ScrollBarCustom(){
        this.setUI(new ModernScrollBarUI());
        this.setPreferredSize(new Dimension(7, 8));
        this.setForeground(new Color(51, 88, 150));
        //this.setBackground(Color.black);
        this.setOpaque(false);
    }
}
