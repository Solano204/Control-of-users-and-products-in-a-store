package Validations;

import View.SystemMain;
import java.awt.Toolkit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;

public class ValidatePrice { // This class is responsible for validating the validate the price from product

    private SystemMain system;
    private Pattern pattern;
    private Matcher matcher;

    public ValidatePrice(SystemMain system) {
        this.system = system;
        this.matcher = null;
        this.pattern = null;
        initComponents();
    }

    public void initComponents() {
        validatePrice(system.txtPricePro);
        validatePrice(system.txtPriceNew);
        validatePrice(system.txtPricePro);
    }

    private void validatePrice(JTextField price) {
        Document validations = new PlainDocument() {
            private boolean decimalText = false;

            // I validate the characters
            @Override
            public void insertString(int offs, String newNumber, AttributeSet a) throws BadLocationException {
                String claveNum = (String) system.cbxClaves.getSelectedItem();
                //I valid that the fields has more tham 10 numbers
                if (newNumber != null && (getLength() + newNumber.length()) > 8) {
                    Toolkit.getDefaultToolkit().beep();
                    return;
                }

                // I validate that The textChain only has a .
                if (getText(0, getLength()).contains(".") && newNumber.contains(".")) {
                    return;
                } else if (newNumber.contains(".")){
                    super.insertString(offs, newNumber, a);
                }
                
                // I validate that the new Character is a number
                String regex = "^[0-9]+$";
                pattern = Pattern.compile(regex);
                matcher = pattern.matcher(newNumber);
                if (!matcher.matches()) {
                    Toolkit.getDefaultToolkit().beep();
                    return;
                }

                super.insertString(offs, newNumber, a);
            }
        };
        price.setDocument(validations);
    }

}
