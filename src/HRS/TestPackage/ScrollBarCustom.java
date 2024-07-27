package src.HRS.TestPackage;
//package GUI;

import java.awt.*;

import javax.swing.*;
import javax.swing.plaf.ScrollBarUI;

public class ScrollBarCustom extends JScrollBar{
    
    public ScrollBarCustom(Color thumbColor, Color trackColor){
        this.setUI(new ModernScrollBarUI(thumbColor, trackColor));
        this.setPreferredSize(new Dimension(7, 8));
        this.setOpaque(false);
    }
}
