import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class OptionButton extends PanelButton{
    /*private boolean over;
    private Color color;
    private Color colorOver;
    private Color colorClick;
    private String buttonName;*/
    
    OptionButton(String buttonName){
        
        super(buttonName);
        
        Font customFont = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 10);
        
        this.setText(buttonName);
        this.setFont(customFont);
        /*this.over = super.isOver();
        this.color = super.getColor();
        this.colorOver = super.getColorClick();
        this.colorClick = super.getColorClick();
        this.buttonName = super.getButtonName();*/
    }


    /*public boolean isOver(){
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
    }*/

}
