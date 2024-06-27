package ProductMethods;

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

public class RegisterProduct extends Conexion { // CLASS IS RESPONSABLE FOR INSERTING A NEW PRODUCT

    private final Connection con;
    private PreparedStatement ps;
    private SystemMain system;
    private CallableStatement pro;
    private CheckEmpty ck;
    private final ExitsProduct exitsCus;

    public RegisterProduct(SystemMain system) {
        this.con = establihsConnection();
        ps = null;
        this.system = system;
        this.pro = null;
        ck = new CheckEmpty();
        exitsCus = new ExitsProduct();
    }

    // Method responsable for register a new user
    public void register() {
        String dni = system.txtCodePro.getText();
        String name = system.txtNamePro.getText();
        if(system.txtStockProd.getText().isEmpty() || system.txtPricePro.getText().isEmpty()){ // I check The fields have a value to pass the variable int to avoid errors, if not it pass Null and will sucess a error
            return;
        }
        int stock = Integer.parseInt(system.txtStockProd.getText());
        float price = Float.parseFloat(system.txtPricePro.getText());
        String DniProv = system.cbxProvProd.getItemAt(system.cbxProvProd.getSelectedIndex()).getDniProv(); // I get the value of the provider selected form cbxProviders
        if (ck.isEmpty(dni).isPresent() && ck.isEmpty(name).isPresent() && ck.isEmpty(stock).isPresent() && ck.isEmpty(price).isPresent() && price >=0) {
            if (dni.length() == 8 && name.length() > 4 && stock >= 0 && price > 1) {
                if (!exitsCus.searchUser(dni)) { // i Check this Id there isnt in the DATA BASE
                    //  String date = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                    String sqlProcedimiento = "{CALL Insert_Product (?,?,?,?,?,?)}"; // I prepare my query to the procedure, with all the parameters and even the output value, Dont avoid the {}
                    try {
                        pro = con.prepareCall(sqlProcedimiento);
                        pro.setString(1, dni);
                        pro.setString(2, name);
                        pro.setInt(3, stock);
                        pro.setFloat(4, price);
                        pro.setString(5, DniProv);
                        pro.setDate(6, null);
                        pro.execute();
                        cleanText();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "This Product with this ID already there is ");
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Incomplete data, Cant Product this user", "WARNING", JOptionPane.WARNING_MESSAGE);
            Toolkit.getDefaultToolkit().beep();
        }
        Toolkit.getDefaultToolkit().beep();
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
