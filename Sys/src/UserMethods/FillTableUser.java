package UserMethods;

import CustomerMethods.*;
import Controller.Conexion;
import View.SystemMain;
import View.SystemMain;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

public class FillTableUser extends Conexion {

    // THIS CLASS IS TO FILL ALL THE TEXTFIELDS WITH THE VALUES FROM THE TABLE
    private final Connection con;
    private ResultSet res;
    private final SystemMain system;
    private CallableStatement ps;

    public FillTableUser(SystemMain system) {
        this.con = establihsConnection();
        this.system = system;
    }

    // This method will active each turn I press a row in the table and the values are represented in the TEXTFIELD
    public void fillTextField(java.awt.event.MouseEvent evt) {
        try {
            system.txtIdUser.setEnabled(false);
            int selectedRecord = system.tbEmployess.rowAtPoint(evt.getPoint());
            String sqlExists = "SELECT IdUser,TypeUser,IdClave FROM UserMain WHERE IdUser = (?)"; // Get the Dni of the client preesing to get the clave of number +53 
            ps = con.prepareCall(sqlExists);
            ps.setString(1, system.tbEmployess.getValueAt(selectedRecord, 0).toString()); // I sent the ID of the user pressed
            res = ps.executeQuery();
            if (res.next()) {
                system.cbxEmpTel.setSelectedIndex(res.getInt("IdClave") - 1); // I increase the id to match with the data base of LATAMS
                system.cbxEmpTel.setEnabled(false);
            }
            system.txtIdUser.setText(system.tbEmployess.getValueAt(selectedRecord, 0).toString());
            system.PassWordUser.setText(system.tbEmployess.getValueAt(selectedRecord, 1).toString());
            String typeUser = system.tbEmployess.getValueAt(selectedRecord, 2).toString();
            system.txtNameUser.setText(system.tbEmployess.getValueAt(selectedRecord, 3).toString());
            system.txtTeleEmpl.setText(system.tbEmployess.getValueAt(selectedRecord, 4).toString());
            system.txtEmailEmpl.setText(system.tbEmployess.getValueAt(selectedRecord, 5).toString());
            // I select my type of user in the cbx 
            for (int i = 0; i < (system.cbxEmpPriv.getItemCount()); i++) {
                if (typeUser.equals(system.cbxEmpPriv.getItemAt(i))) {
                    system.cbxEmpPriv.setSelectedIndex(i);
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
