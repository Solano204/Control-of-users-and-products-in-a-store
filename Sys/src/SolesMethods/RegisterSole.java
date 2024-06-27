package SolesMethods;

import Controller.Conexion;
import ProductMethods.ProvTemp;
import View.SystemMain;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

public class RegisterSole extends Conexion{  // I REGISTER A NEW GENERAL SOLE
    private final Connection con;
    private ResultSet res;
    private final SystemMain system;
    private CallableStatement ps;

    public RegisterSole (SystemMain system) {
        this.system = system;
        this.con = establihsConnection();
    }

    public void registerSole() {
        try {
            int idPayment = system.cbxPayments.getItemAt(system.cbxPayments.getSelectedIndex()).getIdPayment();
            String sqlQuery = "{CALL Insert_Sole (?,?,?)}";
            ps = con.prepareCall(sqlQuery);
            ps.setString(1, system.txtDniNew.getText());
            ps.setInt(2,idPayment);
            ps.setFloat(3,Float.parseFloat(system.lblTotaBuy.getText()));
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Error Combo ");
            e.printStackTrace();
        }
    }
}
