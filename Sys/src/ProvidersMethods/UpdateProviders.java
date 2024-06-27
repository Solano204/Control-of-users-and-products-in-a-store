package ProvidersMethods;

import CustomerMethods.*;
import Controller.CheckEmpty;
import Controller.Conexion;
import View.SystemMain;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class UpdateProviders extends Conexion {

    private final Connection con;
    private final SystemMain system;
    private CallableStatement ps;
    private final ExitsProvider existcus;

    public UpdateProviders(SystemMain system) {
        this.con = establihsConnection();
        this.system = system;
        this.existcus = new ExitsProvider();
    }

    public void modifyUser() {
        String dni = system.txtDniProv.getText();
        String name = system.TxtNameProv.getText();
        String telephone = system.txtTeleProv.getText();
        String addres = system.txtAddressProv.getText();
        system.cbxClavesPro.setEnabled(true);
        if (!dni.isBlank() && !name.isBlank() && !telephone.isBlank() && !addres.isBlank()) {
            if (dni.length() == 8 && name.length() > 4 && system.txtTeleProv.getText().length() == 10 && addres.length() > 5) {
                if (existcus.searchUser(dni)) { // i Check this Id there isnt in the DATA BASE
                    try {
                        String sqlUpdate = " {CALL Update_Provider (?,?,?,?)}";
                        ps = con.prepareCall(sqlUpdate);
                        ps.setString(1, dni);
                        ps.setString(2, name);
                        ps.setString(3, telephone);
                        ps.setString(4, addres);
                        ps.execute();
                        cleanText();
                    } catch (SQLException e) {
                        System.out.println("Update Provider error");
                        e.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "This Provider with this ID there isnt");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Id is missing, Cant search a Provider", "WARNING", JOptionPane.WARNING_MESSAGE);
        }

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
