package src.HRS.View;

import javax.swing.*;
import java.awt.*;

public class ManageSubPanel extends RoundPanel{
    
    private OptionButton updateButton;
    private IconButton cancelButton;
    private String title;

    public ManageSubPanel(String title){

        super(new Color(40, 68, 117));

        this.title = title;

        Font customFont28 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 28);

        RoundPanel headerPanel = new RoundPanel(new Color(27, 43, 80));
        headerPanel.setBounds(0, 0, 365, 70);

        JPanel headerPanel2 = new JPanel();
        headerPanel2.setBackground(new Color(40, 68, 117));
        headerPanel2.setBounds(0, 60, 400, 15);

        RoundLabel panelTitle = new RoundLabel(new Color(27, 43, 80));
        panelTitle.setBounds(10, 10, 350, 40);
        panelTitle.setText(title); 
        panelTitle.setFont(customFont28);
        panelTitle.setForeground(Color.white);

        updateButton = new OptionButton("Update");
        updateButton.setBounds(255, 310, 100, 30);
        updateButton.setColorOver(updateButton.getColorClick());

        // * Cancel * //
        ImageIcon cancelIcon = new ImageIcon("Icons/CancelIcon.png");
        cancelIcon = Customization.resizeIcon(cancelIcon, 20, 20); 

        cancelButton = new IconButton(cancelIcon, "Manage Cancel");
        cancelButton.setBounds(318, 9, 40, 40);
        cancelButton.setColor(new Color(40, 68, 117));
        cancelButton.setColorOver(cancelButton.getColorClick());

        this.setLayout(null);
        this.setPreferredSize(new Dimension(365, 350));
        this.setBounds(10, 60, 365, 350);
        this.add(cancelButton);
        this.add(panelTitle);
        this.add(headerPanel2);
        this.add(headerPanel);
        this.add(updateButton);
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public OptionButton getUpdateButton(){
        return updateButton;
    }

    public void setUpdateButton(OptionButton updateButton){
        this.updateButton = updateButton;
    }

    public IconButton getCancelButton(){
        return cancelButton;
    }

    public void setCancelButton(IconButton cancelButton){
        this.cancelButton = cancelButton;
    }
}
