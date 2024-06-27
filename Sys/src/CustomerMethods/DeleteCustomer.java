package CustomerMethods;

import Controller.Conexion;
import View.SystemMain;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DeleteCustomer extends Conexion {

    private final Connection con;
    private ResultSet res;
    private final SystemMain system;
    private CallableStatement ps;
    private final ExitsCustomer existcus;

    public DeleteCustomer(SystemMain system) {
        this.con = establihsConnection();
        this.system = system;
        existcus = new ExitsCustomer();
    }

    public void deleteCustomer() { // It will when press the delete bottomb
        try {
            final String idDelete = system.txtDniCust.getText();
            if (!idDelete.isBlank() && !idDelete.isEmpty()) {
                if (existcus.searchUser(idDelete)) { // I searh the user with ID
                    int choice = JOptionPane.showConfirmDialog(null, "Are you sure to eliminate this client?");
                    if (choice == 0) {
                        String deleteQuery = "{CALL Delete_Customer(?)}"; // I call the Pa to eliminate a client
                        ps = con.prepareCall(deleteQuery);
                        ps.setString(1, idDelete);
                        ps.execute();
                        cleanText();
                    }
                } else {
                        JOptionPane.showMessageDialog(null, "This client with this ID there isnt");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Id is missing, Cant search a client", "WARNING", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            System.out.println("Error delete ");
            e.printStackTrace();
        }
    }
    
    
    
    // I clean the textField after eliminate a Customer
    public void cleanText(){
        system.txtDniCust.setText("");
        system.txtNameCus.setText("");
        system.txtTeleCust.setText("");
        system.txtAddressCust.setText("");
        system.cbxClaves.setEnabled(true);
        system.txtDniCust.setEnabled(true);
    }
}
