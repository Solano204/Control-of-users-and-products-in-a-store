package ProductMethods;

import View.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

public class CbxProviders extends Controller.Conexion { //THIS CLASS SERVES TO FILL THE LAMBA COMBOX WITH THE PROVIDER DATA FROM THE DATA BASE

    private final Connection con;
    private ResultSet res;
    private final SystemMain system;
    private PreparedStatement ps;
    private final ArrayList<ProvTemp> provs;
    private DefaultComboBoxModel cbxModel;

    public CbxProviders(SystemMain system) {
        this.system = system;
        this.con = establihsConnection();
        provs = new ArrayList<>();
    }

    // I fill the cbx
    public void fillCombo() {
        provs.clear();
        try {
            String sqlQuery = "SELECT DniProvider,NameProvider FROM providers";
            ps = con.prepareStatement(sqlQuery);
            res = ps.executeQuery();
            ProvTemp provTem;
            while (res.next()) {
                provTem = new ProvTemp(res.getString("DniProvider"), res.getString("NameProvider")); // I use an object temporalProvider to save him information in a cbxProviders
                provs.add(provTem); // I obtain the clave of each Latam
            }
            if (!provs.isEmpty()) {
                cbxModel = new DefaultComboBoxModel(provs.stream().toArray()); // I sent it in the new model, this will pass its values in the original combo box 
                system.cbxProvProd.setModel(cbxModel);
            }
        } catch (SQLException e) {
            System.out.println("Error Combo ");
            e.printStackTrace();
        }
    }

}
