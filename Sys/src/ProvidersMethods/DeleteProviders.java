package ProvidersMethods;

import CustomerMethods.*;
import Controller.Conexion;
import View.SystemMain;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DeleteProviders extends Conexion {

    private final Connection con;
    private ResultSet res;
    private final SystemMain system;
    private CallableStatement ps;
    private final ExitsProvider existcus;

    public DeleteProviders(SystemMain system) {
        this.con = establihsConnection();
        this.system = system;
        existcus = new ExitsProvider();
    }

    public void deleteCustomer() { // It will when press the delete bottomb
        try {
            final String idDelete = system.txtDniProv.getText();
            if (!idDelete.isBlank() && !idDelete.isEmpty()) {
                if (existcus.searchUser(idDelete)) { // I searh the user with ID
                    int choice = JOptionPane.showConfirmDialog(null, "Are you sure to eliminate this Provider?");
                    if (choice == 0) {
                        String deleteQuery = "{CALL Delete_Provider(?)}"; // I call the Pa to eliminate a client
                        ps = con.prepareCall(deleteQuery);
                        ps.setString(1, idDelete);
                        ps.execute();
                        cleanText();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "This Provider with this ID there isnt");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Id is missing, Cant search a Provider", "WARNING", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            System.out.println("Error delete ");
            e.printStackTrace();
        }
    }
    
    
    
    // I clean the textField after eliminate a Customer
    public void cleanText(){
        system.txtDniProv.setText("");
        system.TxtNameProv.setText("");
        system.txtTeleProv.setText("");
        system.txtAddressProv.setText("");
        system.cbxClavesPro.setEnabled(true);
        system.txtDniProv.setEnabled(true);
    }
}
