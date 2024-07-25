package src.HRS.View;
//package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HotelOption extends PanelButton{
    private boolean over;
    private Color color;
    private Color colorOver;
    private Color colorClick;
    private RoundLabel content;
    private JLabel name;
    private JLabel rooms;
    private JLabel reservations;
    private RoundLabel price;
    private String buttonName;
    
    HotelOption(String buttonName){

        super(buttonName);

        Font customFont15 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 15);
        Font customFont20 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 20);

        ImageIcon icon = new ImageIcon("Icons/Hotel1.png");
        icon = Customization.resizeIcon(icon, 130, 85);

        price = new RoundLabel(super.getColor());
        price.setBounds(480, 5, 100, 25);
        price.setForeground(Color.white);
        price.setFont(customFont20);
        price.setVerticalAlignment(JLabel.CENTER);
        price.setHorizontalAlignment(JLabel.RIGHT);

        name = new JLabel();
        name.setFont(customFont20);
        name.setForeground(Color.white);
        name.setVerticalAlignment(JLabel.TOP);
        name.setBounds(150, 5, 200, 25);

        rooms = new JLabel();
        rooms.setFont(customFont15);
        rooms.setForeground(Color.white);
        rooms.setVerticalAlignment(JLabel.TOP);
        rooms.setBounds(150, 45, 100, 17);
        
        reservations = new JLabel();
        reservations.setFont(customFont15);
        reservations.setForeground(Color.white);
        reservations.setVerticalAlignment(JLabel.TOP);
        reservations.setBounds(150, 67, 150, 17);

        content = new RoundLabel(new Color(27, 43, 80));
        content.setBounds(8, 10, 599, 90);
        content.setIcon(icon);
        content.add(name);
        content.add(rooms);
        content.add(reservations);
        content.add(price);
        content.setFont(customFont20);
        content.setForeground(Color.white);
        //content.setVerticalTextPosition(JLabel.TOP);
        //content.setHorizontalTextPosition(JLabel.RIGHT);
        //content.setIconTextGap(15);
        content.setVerticalAlignment(JLabel.CENTER);
        content.setHorizontalAlignment(JLabel.LEFT);
        
        this.color = super.getColor();
        this.colorOver = super.getColorOver();
        this.colorClick = super.getColorClick();
        this.buttonName = super.getButtonName();
        this.setFont(customFont20);
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
        price.setBackground(colorClick);
    }


    @Override
    public void mouseReleased(MouseEvent e) {
        if (over){
            this.setBackground(color);
            content.setBackground(color);
            price.setBackground(color);
        } else {
            this.setBackground(color);
            content.setBackground(color);
            price.setBackground(color);
        }
    }


    @Override
    public void mouseEntered(MouseEvent e) {
        this.setBackground(colorOver);
        content.setBackground(colorOver);
        price.setBackground(colorOver);
        over = true;
    }


    @Override
    public void mouseExited(MouseEvent e) {
        this.setBackground(color);
        content.setBackground(color);
        price.setBackground(color);
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

    public JLabel getHotelName(){
        return name;
    }

    public void setHotelName(JLabel name){
        this.name = name;
    }

    public JLabel getHotelRooms(){
        return rooms;
    }

    public void setHotelRooms(JLabel rooms){
        this.rooms = rooms;
    }

    public JLabel getHotelRes(){
        return reservations;
    }

    public void setHotelRes(JLabel reservations){
        this.reservations = reservations;
    }

    public RoundLabel getPrice(){
        return price;
    }

    public void setPrice(RoundLabel price){
        this.price = price;
    }
}
