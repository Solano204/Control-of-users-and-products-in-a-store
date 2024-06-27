package Validations;
import View.SystemMain;
 import java.awt.Toolkit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;

public class ValidationsName { // This class is responsable for validating the name or addres

    private java.awt.event.KeyEvent evt;
    private Pattern pattern;
    private Matcher matcher;
    private SystemMain system;

    public ValidationsName(SystemMain system) {
        this.system = system;
        this.matcher = null;
        this.pattern = null;
    }

    public void initConditions() {
        // I control the lenthg of textChain 
        validateName(system.txtNameCus);
        validateName(system.txtAddressCust);
        validateName(system.txtDescriptionNew);
        validateName(system.txtNameNew);
        validateName(system.TxtNameProv);
        validateName(system.txtAddressProv);
        validateName(system.txtNamePro);
        validateName(system.txtNameComp);
        validateName(system.txtAddressComp);
        validateName(system.txtBussNameComp);
        validateName(system.txtNameUser);
    }
    
   
    /*In this method, I create the PlaintDocument which implements the INSERTSTRING() METHOD, this method helps me to insert new characters into the TEXTFIELD, as long as it meets the conditions,
    Important Note: Its vital that new character adds up to the previous lenght of TEXTFIELD, If dont do this, it may happen that the new charcater is independt and never meets the condtions*/
    private void validateName(JTextField name) {
        Document validations = new PlainDocument() {
            @Override
            /*-The OFFS value is where it starts adding the new chacacter in the TEXTFIELD(Position) if I follow the rules I wll always advance one step fruther in the content of the TEXTFIELD
            -NewChacaracter is the new chacaracter to be added to the TEXTFIELD, AttributesSet never use it*/
            
            // I check that the lenght is not great that 30
            public void insertString(int offs, String name, AttributeSet a) throws BadLocationException { // I sum the new charcater with old TextField 
                if (name != null && getLength() + name.length() >= 30) {
                    Toolkit.getDefaultToolkit().beep();
                    return;
                }
                
                // I check that I doesnt accepted numbers
                String regex = "^[a-zA-Záéíóú ]+$";
                pattern = Pattern.compile(regex);
                matcher = pattern.matcher(name);
                if (!matcher.matches()) {
                    Toolkit.getDefaultToolkit().beep();
                    return;
                }
                // I add the new chacaracter into TEXTFIELD
                super.insertString(offs, name, a); //  If it doesnt meet the condition or the insertio, it doesnt avancem from this step
            }
        };
        
        name.setDocument(validations);
    }

    /*DocumentListener  is an interface that acts as a real-time OBSERVER and works with TextField and textArea, it implements 3 methods 
    -- InsertUpdate : is used to insert new data into the textField
    -- DeleteUpdate : is used to delete into the textField
    -- ChangeUpdate : is used when the true text is modified but fills its value from the TextField, an example new Instance*/
    class observerText implements DocumentListener {

        final private Runnable change;

        public observerText(Runnable change) {
            this.change = change;
        }

        @Override
        public void insertUpdate(DocumentEvent e) {
            change.run();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            change.run();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            change.run();
        }

    }
}
