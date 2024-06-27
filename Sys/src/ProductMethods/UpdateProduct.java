package ProductMethods;

import CustomerMethods.*;
import Controller.CheckEmpty;
import Controller.Conexion;
import View.SystemMain;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class UpdateProduct extends Conexion {

    private final Connection con;
    private final SystemMain system;
    private CallableStatement ps;
    private final ExitsProduct existcus;

    public UpdateProduct(SystemMain system) {
        this.con = establihsConnection();
        this.system = system;
        this.existcus = new ExitsProduct();
    }

    public void modifyUser() {
        String dni = system.txtCodePro.getText();
        String name = system.txtNamePro.getText();
        int stock = Integer.parseInt(system.txtStockProd.getText());
        if (system.txtStockProd.getText().isEmpty() || system.txtPricePro.getText().isEmpty()) { // I check The fields have a value to pass the variable int to avoid errors, if not it pass Null and will sucess a error
            return;
        }
        Double price = Double.parseDouble(system.txtPricePro.getText());
        String dniProvider = system.cbxProvProd.getItemAt(system.cbxProvProd.getSelectedIndex()).getDniProv();
        if (!dni.isBlank() && !name.isBlank() && stock > 0 && price > 1) {
            if (dni.length() == 8 && name.length() > 4) {
                if (existcus.searchUser(dni)) { // i Check this Id there isnt in the DATA BASE
                    try {
                        String sqlUpdate = " {CALL Update_Product (?,?,?,?,?,?)}";
                        ps = con.prepareCall(sqlUpdate);
                        ps.setString(1, dni);
                        ps.setString(2, name);
                        ps.setInt(3, stock);
                        ps.setDouble(4, price);
                        ps.setString(5, dniProvider);
                        ps.setString(6, null);
                        ps.execute();
                        cleanText();
                    } catch (SQLException e) {
                        System.out.println("Update Product error");
                        e.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "This Product with this ID there isnt");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Id is missing, Cant search a Product", "WARNING", JOptionPane.WARNING_MESSAGE);
        }

    }

    // I clean the textField after eliminate a Customer
    public void cleanText() {
        system.txtCodePro.setText("");
        system.txtNamePro.setText("");
        system.txtStockProd.setText("");
        system.txtPricePro.setText("");
        system.txtCodePro.setEnabled(true);

    }
}
