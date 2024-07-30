package src.HRS.View;

import java.awt.*;
import javax.swing.*;

public class RoundPanel extends JPanel{
    
    Color color;

    RoundPanel(Color color){
        
        this.color = color;
        this.setOpaque(false);
        this.setBackground(color);
    }

    @Override
    protected void paintComponent(Graphics graphics){
        Graphics2D g2 = (Graphics2D)graphics;
        super.paintComponent(g2);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color color){
        this.color = color;
    }
}