package ProvidersMethods;

import CustomerMethods.*;
import Controller.Conexion;
import View.SystemMain;
import View.SystemMain;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

public class FillTableProviders extends Conexion {
    
    private final Connection con;
    private ResultSet res;
    private final SystemMain system;
    private CallableStatement ps;

    public FillTableProviders(SystemMain system) {
        this.con = establihsConnection();
        this.system = system;
    }
 
    // This method will active each turn I press a row in the table and the values are represented in the TEXTFIELD
    public void fillTextField(java.awt.event.MouseEvent evt) {
        try {
            system.txtDniProv.setEnabled(false);
            int selectedRecord = system.tbProviders.rowAtPoint(evt.getPoint());
            String sqlExists = "SELECT IdClave FROM Providers WHERE DniProvider = (?)"; // Get the Dni of the client preesing to get the clave of number +53 
            ps = con.prepareCall(sqlExists);
            ps.setString(1, system.tbProviders.getValueAt(selectedRecord, 0).toString()); // I sent the ID of the user pressed
            res = ps.executeQuery();
            if (res.next()) {
                system.cbxClavesPro.setSelectedIndex(res.getInt("IdClave") - 1); // I increase the id to match with the data base of LATAMS
                system.cbxClavesPro.setEnabled(false);
            }
            system.txtDniProv.setText(system.tbProviders.getValueAt(selectedRecord, 0).toString());
            system.TxtNameProv.setText(system.tbProviders.getValueAt(selectedRecord, 1).toString());
            String numberTel = system.tbProviders.getValueAt(selectedRecord, 2).toString();
            system.txtTeleProv.setText(numberTel);
            system.txtAddressProv.setText(system.tbProviders.getValueAt(selectedRecord, 3).toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
