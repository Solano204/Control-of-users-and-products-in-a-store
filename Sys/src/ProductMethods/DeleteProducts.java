package ProductMethods;
import Controller.Conexion;
import View.SystemMain;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DeleteProducts extends Conexion {

    private final Connection con;
    private ResultSet res;
    private final SystemMain system;
    private CallableStatement ps;
    private final ExitsProduct existcus;

    public DeleteProducts(SystemMain system) {
        this.con = establihsConnection();
        this.system = system;
        existcus = new ExitsProduct();
    }

    public void deleteCustomer() { // It will when press the delete bottomb
        try {
            final String idDelete = system.txtCodePro.getText();
            if (!idDelete.isBlank() && !idDelete.isEmpty()) {
                if (existcus.searchUser(idDelete)) { // I searh the user with ID
                    int choice = JOptionPane.showConfirmDialog(null, "Are you sure to eliminate this Product?");
                    if (choice == 0) {
                        String deleteQuery = "{CALL Delete_Product(?)}"; // I call the Pa to eliminate a client
                        ps = con.prepareCall(deleteQuery);
                        ps.setString(1, idDelete);
                        ps.execute();
                        cleanText();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "This Product with this ID there isnt");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Id is missing, Cant search a Product", "WARNING", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            System.out.println("Error delete ");
            e.printStackTrace();
        }
    }
    
    
    
    // I clean the textField after eliminate a Customer
    public void cleanText(){
        system.txtCodePro.setText("");
        system.txtNamePro.setText("");
        system.txtStockProd.setText("");
        system.txtPricePro.setText("");
        system.txtCodePro.setEnabled(true);
    }
}
