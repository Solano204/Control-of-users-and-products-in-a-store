/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UserMethods;

import View.Login;
import View.SystemMain;
import java.awt.Toolkit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;

/**
 *
 * @author GAMER
 */
public class ValidateData {
    
    private Pattern pattern;
    private Matcher matcher;
    private Login login ;

    public ValidateData(Login login) {
        this.matcher = null;
        this.pattern = null;
        this.login = login;
        
    }
    
    public void initComponents(){
        validationsCode(login.txtUserMain);
        validatePassWord(login.txtPasswordMain);
    }

    private void validationsCode(JTextField code) {
        Document validations = new PlainDocument() {
            @Override
            public void insertString(int offs, String newCode, AttributeSet a) throws BadLocationException {
                //I valid that the fields has more tham 10 numbers
                if (newCode != null && (getLength() + newCode.length()) > 8) {
                    Toolkit.getDefaultToolkit().beep();
                    return;
                }
                super.insertString(offs, newCode, a);
            }
        };
        code.setDocument(validations);
    }
    
    
    private void validatePassWord(JPasswordField name) {
        Document validations = new PlainDocument() {
            @Override
            /*-The OFFS value is where it starts adding the new chacacter in the TEXTFIELD(Position) if I follow the rules I wll always advance one step fruther in the content of the TEXTFIELD
            -NewChacaracter is the new chacaracter to be added to the TEXTFIELD, AttributesSet never use it*/
            
            // I check that the lenght is not great that 30
            public void insertString(int offs, String name, AttributeSet a) throws BadLocationException { // I sum the new charcater with old TextField 
                if (name != null && getLength() + name.length() > 8) {
                    Toolkit.getDefaultToolkit().beep();
                    return;
                }
                // I add the new chacaracter into TEXTFIELD
                super.insertString(offs, name, a); //  If it doesnt meet the condition or the insertio, it doesnt avancem from this step
            }
        };
        
        name.setDocument(validations);
    }
    
}
