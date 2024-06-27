package ProvidersMethods;

import CustomerMethods.*;
import Controller.*;
import View.SystemMain;
import java.awt.Toolkit;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import javax.swing.JOptionPane;

public class RegisterProviders extends Conexion { // CLASS IS RESPONSABLE FOR INSERTING A NEW CLIENT

    private final Connection con;
    private PreparedStatement ps;
    private SystemMain system;
    private CallableStatement pro;
    private CheckEmpty ck;
    private final ExitsProvider exitsPro;

    public RegisterProviders(SystemMain system) {
        this.con = establihsConnection();
        ps = null;
        this.system = system;
        this.pro = null;
        ck = new CheckEmpty();
        exitsPro = new ExitsProvider();
    }

    // Method responsable for register a new user
    public void register() {
        String dni = system.txtDniProv.getText();
        String name = system.TxtNameProv.getText();
        String telephone = system.txtTeleProv.getText();
        String addres = system.txtAddressProv.getText();
        if (ck.isEmpty(dni).isPresent() && ck.isEmpty(name).isPresent() && ck.isEmpty(telephone).isPresent() && ck.isEmpty(addres).isPresent()) {
            if (dni.length() == 8 && name.length() > 4 && system.txtTeleProv.getText().length() == 10 && addres.length() > 5) {
                if (!exitsPro.searchUser(dni)) { // i Check this Id there isnt in the DATA BASE
                    //  String date = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                    String sqlProcedimiento = "{CALL Insert_Provider (?,?,?,?,?,?,?)}"; // I prepare my query to the procedure, with all the parameters and even the output value, Dont avoid the {}
                    try {
                        pro = con.prepareCall(sqlProcedimiento);
                        pro.setString(1, dni);
                        pro.setString(2, name);
                        pro.setString(3, telephone);
                        pro.setString(4, addres);
                        pro.setDate(5, null);
                        pro.setInt(6, (system.cbxClavesPro.getSelectedIndex() + 1));
                        pro.registerOutParameter(7, Types.INTEGER); // I sent the type of data that the produce returns and in order to receive it, They've to be the same Type data
                        pro.execute();
                        cleanText();
                        int returnedPro = pro.getInt(7); // I get the value returned by the PROCEDURE 
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "This Provider with this ID already there is ");
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Incomplete data, Cant register this Provider", "WARNING", JOptionPane.WARNING_MESSAGE);
            Toolkit.getDefaultToolkit().beep();
        }
        Toolkit.getDefaultToolkit().beep();
    }

    // I clean the textField after eliminate a Customer
    private void cleanText() {
        system.txtDniProv.setText("");
        system.TxtNameProv.setText("");
        system.txtTeleProv.setText("");
        system.txtAddressProv.setText("");
        system.cbxClavesPro.setEnabled(true);
        system.txtDniProv.setEnabled(true);

    }
}
