package CustomerMethods;

import Controller.CheckEmpty;
import Controller.Conexion;
import View.SystemMain;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class UpdateCustomer extends Conexion {

    private final Connection con;
    private final SystemMain system;
    private CallableStatement ps;
    private final ExitsCustomer existcus;
    private final CheckEmpty ck;

    public UpdateCustomer(SystemMain system) {
        this.con = establihsConnection();
        this.system = system;
        this.existcus = new ExitsCustomer();
        ck = new CheckEmpty();
    }

    public void modifyUser() {
        String dni = system.txtDniCust.getText();
        String name = system.txtNameCus.getText();
        String telephone = system.txtTeleCust.getText();
        String addres = system.txtAddressCust.getText();
        system.cbxClaves.setEnabled(true);
        if (!dni.isBlank() && !name.isBlank() && !telephone.isBlank() && !addres.isBlank()) {
            if (dni.length() == 8 && name.length() > 4 && system.txtTeleCust.getText().length() == 10 && addres.length() > 5) {
                if (existcus.searchUser(dni)) { // i Check this Id there isnt in the DATA BASE
                    try {
                        String sqlUpdate = " {CALL Update_Customer (?,?,?,?)}";
                        ps = con.prepareCall(sqlUpdate);
                        ps.setString(1, dni);
                        ps.setString(2, name);
                        ps.setString(3, telephone);
                        ps.setString(4, addres);
                        ps.execute();
                        cleanText();
                    } catch (SQLException e) {
                        System.out.println("Update customer error");
                        e.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "This client with this ID there isnt");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Id is missing, Cant search a client", "WARNING", JOptionPane.WARNING_MESSAGE);
        }

    }

    // I clean the textField after eliminate a Customer
    private void cleanText() {
        system.txtDniCust.setText("");
        system.txtNameCus.setText("");
        system.txtTeleCust.setText("");
        system.txtAddressCust.setText("");
        system.cbxClaves.setEnabled(true);
        system.txtDniCust.setEnabled(true);

    }
}
