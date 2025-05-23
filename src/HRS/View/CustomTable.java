package src.HRS.View;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * The CustomTable class extends JTable to provide a customized table with a specific color scheme and rounded corners.
 */
public class CustomTable extends JTable {

    /**
     * Constructs a new CustomTable with the specified table model.
     *
     * @param model the DefaultTableModel to be used for the table
     */
    public CustomTable(DefaultTableModel model) {
        super(model);
        this.setOpaque(false);
        this.setForeground(Color.white);
        this.setBackground(new Color(27, 43, 80));
    }

    /**
     * Paints the table with custom rendering settings, including rounded corners.
     *
     * @param graphics the Graphics object to protect
     */
    @Override
    protected void paintComponent(Graphics graphics) {
        Graphics2D g2 = (Graphics2D) graphics;
        super.paintComponent(g2);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
    }
}
