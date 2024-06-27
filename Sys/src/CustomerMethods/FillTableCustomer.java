package CustomerMethods;

import Controller.Conexion;
import View.SystemMain;
import View.SystemMain;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

public class FillTableCustomer extends Conexion {

    // THIS CLASS IS TO FILL ALL THE TEXTFIELDS WITH THE VALUES FROM THE TABLE
    private final Connection con;
    private ResultSet res;
    private final SystemMain system;
    private CallableStatement ps;

    public FillTableCustomer(SystemMain system) {
        this.con = establihsConnection();
        this.system = system;
    }

    // This method will active each turn I press a row in the table and the values are represented in the TEXTFIELD
    public void fillTextField(java.awt.event.MouseEvent evt) {
        try {
            system.txtDniCust.setEnabled(false);
            int selectedRecord = system.tbCustomers.rowAtPoint(evt.getPoint());
            String sqlExists = "SELECT IdClave FROM Customers WHERE DniCustomer = (?)"; // Get the Dni of the client preesing to get the clave of number +53 
            ps = con.prepareCall(sqlExists);
            ps.setString(1, system.tbCustomers.getValueAt(selectedRecord, 0).toString()); // I sent the ID of the user pressed
            res = ps.executeQuery();
            if (res.next()) {
                system.cbxClaves.setSelectedIndex(res.getInt("IdClave") - 1); // I increase the id to match with the data base of LATAMS
                system.cbxClaves.setEnabled(false);
            }
            system.txtDniCust.setText(system.tbCustomers.getValueAt(selectedRecord, 0).toString());
            system.txtNameCus.setText(system.tbCustomers.getValueAt(selectedRecord, 1).toString());
            String numberTel = system.tbCustomers.getValueAt(selectedRecord, 2).toString();
            system.txtTeleCust.setText(numberTel);
            system.txtAddressCust.setText(system.tbCustomers.getValueAt(selectedRecord, 3).toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
