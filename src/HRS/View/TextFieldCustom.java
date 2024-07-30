package src.HRS.View;

import java.awt.*;
import javax.swing.*;

/**
 * The TextFieldCustom class represents a custom text field component with a rounded background,
 * a label for the field name, and a text input area.
 */
public class TextFieldCustom extends RoundPanel {

    private String textFieldName;
    private RoundLabel fieldName;
    private JTextField textField;
    private RoundPanel textContainer;

    /**
     * Constructs a new TextFieldCustom with the specified background color.
     *
     * @param bgColor the background color of the custom text field
     */
    public TextFieldCustom(Color bgColor) {
        super(bgColor);

        Font customFont13 = Customization.createCustomFont("Fonts/POPPINS-SEMIBOLD.TTF", 13);

        fieldName = new RoundLabel(bgColor);
        fieldName.setBounds(7, 1, 300, 20);
        fieldName.setForeground(Color.white);
        fieldName.setFont(customFont13);
        fieldName.setText(textFieldName);

        textField = new JTextField();
        textField.setBackground(Color.white);
        textField.setOpaque(false);
        textField.setEditable(true);
        textField.setFont(customFont13);
        textField.setBorder(null);
        textField.setBounds(5, 4, 315, 20);

        textContainer = new RoundPanel(Color.white);
        textContainer.setLayout(null);
        textContainer.setBounds(5, 25, 350, 27);
        textContainer.add(textField);

        this.setLayout(null);
        this.add(fieldName);
        this.add(textContainer);
    }

    /**
     * Returns the name of the text field.
     *
     * @return the name of the text field
     */
    public String getFieldName() {
        return textFieldName;
    }

    /**
     * Sets the name of the text field and updates the label.
     *
     * @param textFieldName the name of the text field to set
     */
    public void setFieldName(String textFieldName) {
        fieldName.setText(textFieldName);
        this.textFieldName = textFieldName;
    }

    /**
     * Returns the JTextField component.
     *
     * @return the JTextField component
     */
    public JTextField getTextField() {
        return textField;
    }

    /**
     * Sets the JTextField component.
     *
     * @param textField the JTextField component to set
     */
    public void setTextField(JTextField textField) {
        this.textField = textField;
    }

    /**
     * Returns the text container panel.
     *
     * @return the text container panel
     */
    public RoundPanel getTextContainer() {
        return textContainer;
    }

    /**
     * Sets the text container panel.
     *
     * @param textContainer the text container panel to set
     */
    public void setTextContainer(RoundPanel textContainer) {
        this.textContainer = textContainer;
    }
}
