import javax.swing.*;
import java.awt.*;

public class TextFieldCustom extends RoundPanel{

    private String textFieldName;
    private RoundLabel fieldName;

    TextFieldCustom(Color bgColor){
        
        super(bgColor);
        //super(Color.red);

        Font customFont15 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 15);
        Font customFont13 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 13);

        fieldName = new RoundLabel(bgColor);
        fieldName.setBounds(7, 1, 300, 20);
        fieldName.setForeground(Color.white);
        fieldName.setFont(customFont13);
        fieldName.setText(textFieldName);

        JTextField textField = new JTextField();
        textField.setBackground(Color.white);
        textField.setOpaque(false);
        textField.setEditable(true);
        textField.setFont(customFont13);
        textField.setBorder(null);
        textField.setBounds(5, 4, 315, 20);

        RoundPanel textContainer = new RoundPanel(Color.white);
        textContainer.setLayout(null);
        textContainer.setBounds(5, 25, 335, 27);
        textContainer.add(textField);

        this.setLayout(null);
        this.add(fieldName);
        this.add(textContainer);
    }

    public String getFieldName(){
        return textFieldName;
    }

    public void setFieldName(String textFieldName){
        fieldName.setText(textFieldName);
        this.textFieldName = textFieldName;
    }
    
}
