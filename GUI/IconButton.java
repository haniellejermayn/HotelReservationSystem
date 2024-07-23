import javax.swing.*;
import java.awt.*;

public class IconButton extends PanelButton{
    /*private boolean over;
    private Color color;
    private Color colorOver;
    private Color colorClick;
    private String buttonName;*/
    
    IconButton(ImageIcon icon, String buttonName){
        
        super(buttonName);
        this.setIcon(icon);
        /*this.over = super.isOver();
        this.color = super.getColor();
        this.colorOver = super.getColorOver();
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
        this.setBackground(color);
    }

    public Color getcolorOver(){
        return colorOver;
    }

    public void setcolorOver(Color colorOver){
        this.colorOver = colorOver;
    }

    public Color getcolorClick(){
        return colorClick;
    }

    public void setcolorClick(Color colorClick){
        this.colorClick = colorClick;
    }

    public String getbuttonName(){
        return buttonName;
    }

    public void setbuttonName(String buttonName){
        this.buttonName = buttonName;
    }*/
    
}
