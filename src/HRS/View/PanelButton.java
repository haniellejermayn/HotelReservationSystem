package src.HRS.View;
//package GUI;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class PanelButton extends JButton implements MouseListener{
    private boolean over;
    private Color color;
    private Color colorOver;
    private Color colorClick;
    private String buttonName;
    
    PanelButton(String buttonName){

        Font customFont = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 8);

        this.color = new Color(27, 43, 80);
        this.colorOver = new Color(40, 68, 117);
        this.colorClick = new Color(51, 88, 150);
        this.buttonName = buttonName;
        
        this.setOpaque(false);
        this.setBackground(color);
        this.setContentAreaFilled(false);
        this.setFocusPainted(false);
        this.setFont(customFont);
        this.setForeground(Color.white);
        this.addMouseListener(this);
    }
    
    @Override
    protected void paintComponent(Graphics graphics){
        Graphics2D g2 = (Graphics2D)graphics;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        super.paintComponent(g2);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }


    @Override
    public void mousePressed(MouseEvent e) {
        this.setBackground(colorClick);
    }


    @Override
    public void mouseReleased(MouseEvent e) {
        if (over){
            this.setBackground(color);
        } else {
            this.setBackground(color);
        }
    }


    @Override
    public void mouseEntered(MouseEvent e) {
        this.setBackground(colorOver);
        over = true;
    }


    @Override
    public void mouseExited(MouseEvent e) {
        this.setBackground(color);
        over = false;
    }


    public boolean isOver(){
        return over;
    }

    public void setOver(boolean over){
        this.over = over;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color color){
        this.color = color;
        setBackground(color);
    }

    public Color getColorOver(){
        return colorOver;
    }

    public void setColorOver(Color colorOver){
        this.colorOver = colorOver;
    }

    public Color getColorClick(){
        return colorClick;
    }

    public void setColorClick(Color colorClick){
        this.colorClick = colorClick;
    }

    public String getButtonName(){
        return buttonName;
    }

    public void setButtonName(String buttonName){
        this.buttonName = buttonName;
    }
}

