package src.HRS.View;

import java.awt.*;
import javax.swing.*;

public class RoundLabel extends JLabel{
    
    public RoundLabel(Color bgColor){
        
        this.setOpaque(false);
        this.setBackground(bgColor);
    }

    @Override
    protected void paintComponent(Graphics graphics){
        Graphics2D g2 = (Graphics2D)graphics;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        super.paintComponent(g2);
    }
}

