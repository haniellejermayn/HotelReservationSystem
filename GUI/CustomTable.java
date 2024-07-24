import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class CustomTable extends JTable{
    
    CustomTable(DefaultTableModel model){

        super(model);

        this.setOpaque(false);
        this.setForeground(Color.white);
        this.setBackground(new Color(27, 43, 80));
    }

    @Override
    protected void paintComponent(Graphics graphics){
        Graphics2D g2 = (Graphics2D)graphics;
        super.paintComponent(g2);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
    }
}