package UserMethods;

import CustomerMethods.*;
import Controller.CheckEmpty;
import Controller.Conexion;
import Controller.EncrypPassWord;
import View.SystemMain;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class UpdateUser extends Conexion {

    private final Connection con;
    private final SystemMain system;
    private CallableStatement ps;
    private final ExitsUser existcus;
    private final CheckEmpty ck;
    private final EncrypPassWord en;

    public UpdateUser(SystemMain system) {
        this.con = establihsConnection();
        this.system = system;
        this.existcus = new ExitsUser();
        ck = new CheckEmpty();
        en = new EncrypPassWord();
    }

    public void modifyUser() {
        String dni = system.txtIdUser.getText();
        final String pass = String.valueOf(system.PassWordUser.getPassword());
        String name = system.txtNameUser.getText();
        String telephone = system.txtTeleEmpl.getText();
        String email = system.txtEmailEmpl.getText();
        String typeUser = system.cbxEmpPriv.getSelectedItem().toString();
        if (ck.isEmpty(dni).isPresent() && ck.isEmpty(name).isPresent() && ck.isEmpty(telephone).isPresent() && ck.isEmpty(email).isPresent() && ck.isEmpty(pass).isPresent() && ck.isEmpty(typeUser).isPresent()) {
            if (dni.length() == 8 && name.length() > 4 && telephone.length() == 10 && email.length() > 5 && pass.length() == 8) {
                if (existcus.searchUser(dni)) { // i Check this Id there isnt in the DATA BASE
                    try {
                        final String passEncrypted = en.encryptPassword(dni,pass);
                        String sqlUpdate = " {CALL Update_User (?,?,?,?,?,?,?)}";
                        ps = con.prepareCall(sqlUpdate);
                        ps.setString(1, dni);
                        ps.setString(2, passEncrypted);
                        ps.setString(3, typeUser);
                        ps.setString(4, name);
                        ps.setString(5, telephone);
                        ps.setString(6, email);
                        ps.setInt(7, (system.cbxEmpTel.getSelectedIndex() + 1));
                        ps.execute();
                        System.out.println("jxd");
                        cleanText();
                    } catch (SQLException e) {
                        System.out.println("Update customer error");
                        e.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "This User with this ID there isnt");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Id is missing, Cant search a User", "WARNING", JOptionPane.WARNING_MESSAGE);
        }

    }

    // I clean the textField after eliminate a Customer
     public void cleanText(){
        system.txtIdUser.setText("");
        system.PassWordUser.setText("");
        system.txtNameUser.setText("");
        system.txtTeleEmpl.setText("");
        system.txtEmailEmpl.setText("");
    }
}
