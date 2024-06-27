package View;

import java.awt.Toolkit;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class InformationCompany extends Controller.Conexion {

    private final Connection con;
    private PreparedStatement ps;
    private CallableStatement call;
    private ResultSet res;
    private final SystemMain system ;

    public InformationCompany(SystemMain system) {
        this.con = establihsConnection();
        this.system = system;
        
    }

    // This Method is charge of fill out the textField about information from COMPANY 
    public void fillInformation() {
        try {
            final String sqlQuery = "SELECT * FROM Company";
            ps = con.prepareStatement(sqlQuery);
            res = ps.executeQuery();
            if (res.next()) {
                system.txtDniComp.setText(res.getString("DniCompany"));
                system.txtNameComp.setText(res.getString("NameCompany"));
                system.txtTeleCom.setText(res.getString("TelephoneCompany"));
                system.txtAddressComp.setText(res.getString("AddresCompany"));
                system.txtBussNameComp.setText(res.getString("BussinessName"));
            }
        } catch (SQLException ex) {
            System.out.println("fill text Company");
            Logger.getLogger(InformationCompany.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // This method modify the information from company
    public void updateInformationCompany() {
        try {
            if (system.txtBussNameComp.getText().isEmpty() || system.txtBussNameComp.getText().isBlank() || system.txtAddressComp.getText().isBlank() || system.txtAddressComp.getText().isEmpty()
                    || system.txtTeleCom.getText().isEmpty() || system.txtTeleCom.getText().isBlank() || system.txtDniComp.getText().isEmpty() || system.txtDniComp.getText().isBlank()
                    || system.txtNameComp.getText().isEmpty() || system.txtNameComp.getText().isBlank()) {
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null, "data missing, Cant update the information", "WARNING", JOptionPane.WARNING_MESSAGE);
                return;
            }
            final String sqlQuery = "{CALL Update_Company (?,?,?,?,?)}";
            call = con.prepareCall(sqlQuery);
            call.setString(1,system.txtDniComp.getText());
            call.setString(2,system.txtNameComp.getText());
            call.setString(3,system.txtTeleCom.getText());
            call.setString(4,system.txtAddressComp.getText());
            call.setString(5,system.txtBussNameComp.getText());
            call.execute();
        } catch (SQLException ex) {
            System.out.println("Error update information company");
            Logger.getLogger(InformationCompany.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }

}
