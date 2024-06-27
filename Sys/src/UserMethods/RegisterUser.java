package UserMethods;

import CustomerMethods.*;
import Controller.*;
import Validations.ValidateEmail;
import Validations.ValidatePassWord;
import View.SystemMain;
import java.awt.Toolkit;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import javax.swing.JOptionPane;

public class RegisterUser extends Conexion { // CLASS IS RESPONSABLE FOR INSERTING A NEW CLIENT

    private final Connection con;
    private PreparedStatement ps;
    private SystemMain system;
    private CallableStatement pro;
    private CheckEmpty ck;
    private final ExitsUser exitsCus;
    private final ValidateEmail validateEmail;
    private final EncrypPassWord encryp;

    public RegisterUser(SystemMain system) {
        this.con = establihsConnection();
        ps = null;
        validateEmail = new ValidateEmail();
        this.system = system;
        this.pro = null;
        ck = new CheckEmpty();
        exitsCus = new ExitsUser();
        encryp = new EncrypPassWord();
    }

    // Method responsable for register a new user
    public void register() {
        String dni = system.txtIdUser.getText();
        final String pass = String.valueOf(system.PassWordUser.getPassword());
        String name = system.txtNameUser.getText();
        String telephone = system.txtTeleEmpl.getText();
        String email = system.txtEmailEmpl.getText();
        String typeUser = system.cbxEmpPriv.getSelectedItem().toString();
        if (ck.isEmpty(dni).isPresent() && ck.isEmpty(name).isPresent() && ck.isEmpty(telephone).isPresent() && ck.isEmpty(email).isPresent() && ck.isEmpty(pass).isPresent()
                && ck.isEmpty(typeUser).isPresent()  && validateEmail.controllerEmail(email)) {
            if (dni.length() == 8 && name.length() > 4 && telephone.length() == 10 && email.length() > 5 && pass.length()== 8) {
                if (!exitsCus.searchUser(dni)) { // i Check this Id there isnt in the DATA BASE
                    //  String date = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                    String sqlProcedimiento = "{CALL Insert_Users (?,?,?,?,?,?,?)}"; // I prepare my query to the procedure, with all the parameters and even the output value, Dont avoid the {}
                    try {
                        String passsEncrypted = encryp.encryptPassword(dni,pass);
                        pro = con.prepareCall(sqlProcedimiento);
                        pro.setString(1, dni);
                        pro.setString(2, passsEncrypted);
                        pro.setString(3, typeUser);
                        pro.setString(4, name);
                        pro.setString(5, telephone);
                        pro.setString(6, email);
                        pro.setInt(7, (system.cbxEmpTel.getSelectedIndex() + 1));
                        pro.execute();
                        cleanText();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "This User with this ID already there is ");
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Incomplete data, Cant User this user", "WARNING", JOptionPane.WARNING_MESSAGE);
            Toolkit.getDefaultToolkit().beep();
        }
        Toolkit.getDefaultToolkit().beep();
    }

    // 
    // I clean the textField after eliminate a Customer
    public void cleanText(){
        system.txtIdUser.setText("");
        system.PassWordUser.setText("");
        system.txtNameUser.setText("");
        system.txtTeleEmpl.setText("");
        system.txtEmailEmpl.setText("");
        
    }
}
