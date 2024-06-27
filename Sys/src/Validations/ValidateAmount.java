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

public class ValidateAmount { // This class is responsable for validating the amout of products

    private SystemMain system;
    private Pattern pattern;
    private Matcher matcher;

    public ValidateAmount(SystemMain system) {
        this.system = system;
        this.matcher = null;
        this.pattern = null;
    }

    public void initComponents() {
        validateNumber(system.txtStockProd);
        validateNumber(system.txtAmountNew);
        validateNumber(system.txtStockProd);
        validateNumber(system.txtAvaliableNew);
    }

    public void validateNumber(JTextField amount) {
        Document validations = new PlainDocument() {
            @Override
            public void insertString(int offs, String newNumber, AttributeSet a) throws BadLocationException {
                //I valid that the fields has more tham 10 numbers
                if (newNumber != null && (getLength() + newNumber.length()) > 8) {
                    Toolkit.getDefaultToolkit().beep();
                    return;
                }
                
                // I validate that the text hasnt letters
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
        amount.setDocument(validations);
    }
}
