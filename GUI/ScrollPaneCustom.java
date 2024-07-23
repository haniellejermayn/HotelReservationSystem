import javax.swing.*;
import java.awt.*;

public class ScrollPaneCustom extends JScrollPane{

    public ScrollPaneCustom(Component component){
        super(component);
    
        //this.setBounds(100, 100, 200, 100);
        this.setVerticalScrollBar(new ScrollBarCustom());
        this.setBorder(null);
        this.getViewport().setOpaque(false);
        this.setViewportBorder(null);
        this.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        this.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        this.setOpaque(false);
    }
        
    @Override
    protected void paintComponent(Graphics graphics){
        Graphics2D g2 = (Graphics2D)graphics;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(new Color(40, 68, 117));
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        super.paintComponent(g2);
    }
}
