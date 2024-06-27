package SolesMethods;

import Controller.Conexion;
import View.SystemMain;
import java.awt.event.KeyEvent;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ExistCustomer extends Conexion {

    private final Connection con;
    private ResultSet res;
    private CallableStatement ps;
    final private SystemMain system;

    public ExistCustomer(SystemMain system) {
        this.con = establihsConnection();
        this.system = system;
    }

    public void searchUser(java.awt.event.KeyEvent evt) {
        try {
            if (evt.getKeyCode() != KeyEvent.VK_ENTER) { // I check the button pressed was TABULADOR
                return;
            }
            
            final String idCustomerSearch = system.txtDniNew.getText();
            if (idCustomerSearch.isBlank() || idCustomerSearch.isEmpty()) {
                return;
            }
            String searchQuery = "  SELECT DniCustomer, NameCustomer FROM Customers WHERE DniCustomer = (?)";
            ps = con.prepareCall(searchQuery);
            ps.setString(1, idCustomerSearch);
            res = ps.executeQuery();
            if (res.next()) {
                system.txtDniNew.setText(res.getString("DniCustomer"));
                system.txtNameNew.setText(res.getString("NameCustomer"));
                system.btnPrintTicketNew.setEnabled(true); // I ACTIVE THE BUTTON TO DO  BUY
            } else {
                JOptionPane.showMessageDialog(null, "This client with this ID there isnt");
                system.txtNameCus.requestFocus();
            }
        } catch (SQLException e) {
            System.out.println("error search cust in sole");
            e.printStackTrace();
        }
    }
}
