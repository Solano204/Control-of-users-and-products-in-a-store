package Validations;

import View.Login;
import View.SystemMain;
import java.awt.Toolkit;
import java.util.regex.Pattern;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;

public class ValidatePassWord {
    
    private final SystemMain system;

    public ValidatePassWord(SystemMain system) {
        this.system = system;
    }
    
    public void initCondition(){
        validatePassWord(system.PassWordUser);
    }
    
    
    /*In this method, I create the PlaintDocument which implements the INSERTSTRING() METHOD, this method helps me to insert new characters into the TEXTFIELD, as long as it meets the conditions,
    Important Note: Its vital that new character adds up to the previous lenght of TEXTFIELD, If dont do this, it may happen that the new charcater is independt and never meets the condtions*/
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
