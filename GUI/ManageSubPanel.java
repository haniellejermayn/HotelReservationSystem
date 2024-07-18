import javax.swing.*;
import java.awt.*;

public class ManageSubPanel extends RoundPanel{
    
    public ManageSubPanel(String title){

        super(new Color(40, 68, 117));

        Font customFont30 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 30);

        RoundPanel headerPanel = new RoundPanel(new Color(27, 43, 80));
        headerPanel.setBounds(0, 0, 365, 70);

        JPanel headerPanel2 = new JPanel();
        headerPanel2.setBackground(new Color(40, 68, 117));
        headerPanel2.setBounds(0, 60, 400, 15);

        RoundLabel panelTitle = new RoundLabel(new Color(27, 43, 80));
        panelTitle.setBounds(10, 10, 350, 40);
        panelTitle.setText(title); // set to cureent hotel name
        panelTitle.setFont(customFont30);
        panelTitle.setForeground(Color.white);

        this.setLayout(null);
        this.setPreferredSize(new Dimension(365, 350));
        this.setBounds(10, 60, 365, 350);
        this.add(panelTitle);
        this.add(headerPanel2);
        this.add(headerPanel);
    }
}
