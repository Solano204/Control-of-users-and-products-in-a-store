package Validations;

import View.SystemMain;
import java.awt.Toolkit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;

public class ValidateEmail { // THIS CLASS WORKS TO CHECK THE PASSWORD
    
     private SystemMain system;

    public ValidateEmail(SystemMain system) {
        this.system = system;
    }
    
    public ValidateEmail()
    {
        
    }
    
    public boolean controllerEmail(final String correo) {
        if (!validarCorreoGmail(correo)) {
            if (!validarCorreoHotmail(correo)) {
                if (!validarCorreoOutlook(correo)) {
                    JOptionPane.showMessageDialog(null, " This email doesn't correct");
                    return false;
                }
                return true;
            }
            return true;
        }
        return true;
    }
    
    public static boolean validarCorreoGmail( final String correo) {
        // Patrón para validar una dirección de correo electrónico de Gmail
        String patronGmail = "^[a-zA-Z0-9_]+(\\.[a-zA-Z0-9_]+)*@gmail\\.com$";
        // Compilar la expresión regular
        Pattern pattern = Pattern.compile(patronGmail);

        // Crear el objeto Matcher
        Matcher matcher = pattern.matcher(correo);
        // Verificar si la cadena coincide con el patrón
        return matcher.matches();
    }

    public static boolean validarCorreoHotmail(final String correo) {
        // Patrón para validar correos de Hotmail
        String patronHotmail = "^\\b[A-Za-z0-9._%+-]+@hotmail\\.com\\b$";

        // Compilar la expresión regular
        Pattern pattern = Pattern.compile(patronHotmail);

        // Crear un objeto Matcher
        Matcher matcher = pattern.matcher(correo);

        // Verificar si coincide con el patrón
        return matcher.matches();
    }

    public static boolean validarCorreoOutlook(final String correo) {
        // Expresión regular para validar direcciones de correo de Outlook
        String patronCorreoOutlook = "^[a-zA-Z0-9._%+-]+@outlook\\.com$";

        // Compilar la expresión regular
        Pattern pattern = Pattern.compile(patronCorreoOutlook);

        // Crear un objeto Matcher que utilizará la expresión regular y el correo proporcionado
        Matcher matcher = pattern.matcher(correo);

        // Realizar la validación
        return matcher.matches();
    }
    
   
    public void initComponents(){
        validateEmail(system.txtEmailEmpl);
    }
    private void validateEmail(JTextField name) {
        Document validations = new PlainDocument() {
            @Override
            /*-The OFFS value is where it starts adding the new chacacter in the TEXTFIELD(Position) if I follow the rules I wll always advance one step fruther in the content of the TEXTFIELD
            -NewChacaracter is the new chacaracter to be added to the TEXTFIELD, AttributesSet never use it*/
            
            // I check that the lenght is not great that 30
            public void insertString(int offs, String name, AttributeSet a) throws BadLocationException { // I sum the new charcater with old TextField 
                if (name != null && getLength() + name.length() >= 50) {
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
