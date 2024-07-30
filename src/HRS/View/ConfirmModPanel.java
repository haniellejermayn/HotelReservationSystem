package src.HRS.View;

public class ConfirmModPanel extends ManageSubPanel{
    
    private OptionButton yesButton;
    private OptionButton noButton;
    private String panelName;

    public ConfirmModPanel(String panelName){

        super("Confirm Modification");

        this.panelName = panelName;

        yesButton = new OptionButton("Yes");
        yesButton.setBounds(80, 170, 100, 30);
        yesButton.setColorOver(yesButton.getColorClick());
        
        noButton = new OptionButton("No");
        noButton.setBounds(185, 170, 100, 30);
        noButton.setColorOver(noButton.getColorClick());

        panelName = new String();

        this.getUpdateButton().setVisible(false);
        this.getCancelButton().setVisible(false);
        this.add(yesButton);
        this.add(noButton);
    }

    public String getPanelName(){
        return panelName;
    }

    public void setPanelName(String panelName){
        this.panelName = panelName;
    }

    public OptionButton getYesButton(){
        return yesButton;
    }

    public void setYesButton(OptionButton yesButton){
        this.yesButton = yesButton;
    }

    public OptionButton getNoButton(){
        return noButton;
    }

    public void setNoButton(OptionButton noButton){
        this.noButton = noButton;
    }
}
