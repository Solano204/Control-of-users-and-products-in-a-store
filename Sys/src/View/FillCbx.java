package View;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

    public class FillCbx extends Controller.Conexion { //THIS CLASS SERVES TO FILL THE LAMBA COMBOX WITH THE LAMBAS DATA FROM THE DATA BASE

    private final Connection con;
    private ResultSet res;
    private final SystemMain system;
    private CallableStatement ps;
    private final ArrayList<String> latams;
    private DefaultComboBoxModel cbxModel;

    public FillCbx(SystemMain system) {
        this.system = system;
        this.con = establihsConnection();
        latams = new ArrayList<>();
        fillCombo();
    }

    public void fillCombo() {
        try {
            latams.clear();
            String sqlQuery = "{CAll Select_Latams}";
            ps = con.prepareCall(sqlQuery);
            res = ps.executeQuery();
            while (res.next()) {
                    latams.add(res.getString("clave")); // I obtain the clave of each Latam
            }
            if (!latams.isEmpty()) {
                cbxModel = new DefaultComboBoxModel(latams.stream().toArray()); // I sent it in the new model, this will pass its values in the original combo box 
                system.cbxClaves.setModel(cbxModel);
                system.cbxClavesPro.setModel(cbxModel);
                system.cbxEmpTel.setModel(cbxModel);
            }
        } catch (SQLException e) {
            System.out.println("Error Combo ");
            e.printStackTrace();
        }
    }
   


}
