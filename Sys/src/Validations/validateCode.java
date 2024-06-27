package Validations;

import View.Login;
import View.SystemMain;
import java.awt.Toolkit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;

public class validateCode { // This class is responsable for validating the code o Dni of each people
    private SystemMain system;
    private Pattern pattern;
    private Matcher matcher;
    private Login login ;

    public validateCode(SystemMain system) {
        this.system = system;
        this.matcher = null;
        this.pattern = null;
        
    }
    
    public void initComponents(){
        validationsCode(system.txtDniCust);
        validationsCode(system.txtCodeNew);
        validationsCode(system.txtDniProv);
        validationsCode(system.txtCodePro);
        validationsCode(system.txtDniComp);
        validationsCode(system.txtDniNew);
        validationsCode(system.txtIdUser);
    }

    private void validationsCode(JTextField code) {
        Document validations = new PlainDocument() {
            @Override
            public void insertString(int offs, String newCode, AttributeSet a) throws BadLocationException {
                String claveNum = (String) system.cbxClaves.getSelectedItem();
                //I valid that the fields has more tham 10 numbers
                if (newCode != null && (getLength() + newCode.length()) > 8) {
                    Toolkit.getDefaultToolkit().beep();
                    return;
                }
                
                // I validate that text hasnt letters 
                String regex = "^[0-9]+$";
                pattern = Pattern.compile(regex);
                matcher = pattern.matcher(newCode);
                if (!matcher.matches()) {
                    Toolkit.getDefaultToolkit().beep();
                    return;
                }
                super.insertString(offs, newCode, a);
            }
        };
        code.setDocument(validations);
    }
}
