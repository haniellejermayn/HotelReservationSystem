import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HotelOption extends PanelButton{
    private boolean over;
    private Color color;
    private Color colorOver;
    private Color colorClick;
    private RoundLabel content;
    private String buttonName;
    
    HotelOption(String buttonName){
        
        super(buttonName);

        Font customFont = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 20);

        ImageIcon icon = new ImageIcon("Icons/Hotel1.png");
        icon = Customization.resizeIcon(icon, 130, 85);

        content = new RoundLabel(new Color(27, 43, 80));
        content.setBounds(8, 10, 350, 90);
        content.setIcon(icon);
        content.setFont(customFont);
        content.setForeground(Color.white);
        content.setVerticalTextPosition(JLabel.CENTER);
        content.setHorizontalTextPosition(JLabel.RIGHT);
        content.setIconTextGap(15);
        content.setVerticalAlignment(JLabel.CENTER);
        content.setHorizontalAlignment(JLabel.LEFT);
        
        this.color = super.getColor();
        this.colorOver = super.getColorOver();
        this.colorClick = super.getColorClick();
        this.buttonName = super.getButtonName();
        this.setFont(customFont);
        this.add(content);
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
        content.setBackground(colorClick);
    }


    @Override
    public void mouseReleased(MouseEvent e) {
        if (over){
            this.setBackground(color);
            content.setBackground(color);
        } else {
            this.setBackground(color);
            content.setBackground(color);
        }
    }


    @Override
    public void mouseEntered(MouseEvent e) {
        this.setBackground(colorOver);
        content.setBackground(colorOver);
        over = true;
    }


    @Override
    public void mouseExited(MouseEvent e) {
        this.setBackground(color);
        content.setBackground(color);
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

    public RoundLabel getContent(){
        return content;
    }

    public void setContent(RoundLabel content){
        this.content = content;
    }

    public String getButtonName(){
        return buttonName;
    }

    public void setButtonName(String buttonName){
        this.buttonName = buttonName;
    }
}
