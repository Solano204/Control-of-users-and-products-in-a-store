package SolesMethods;

import Controller.Conexion;
import ProductMethods.ProvTemp;
import View.SystemMain;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

public class FillCbxPayment extends Conexion{
    private final Connection con;
    private ResultSet res;
    private final SystemMain system;
    private PreparedStatement ps;
    private final ArrayList<MethodTem> provs;
    private DefaultComboBoxModel cbxModel;

    public FillCbxPayment (SystemMain system) {
        this.system = system;
        this.con = establihsConnection();
        provs = new ArrayList<>();
        fillCombo();
    }

    // I fill the cbx
    public void fillCombo() {
        try {
            String sqlQuery = "SELECT * FROM PayMent";
            ps = con.prepareStatement(sqlQuery);
            res = ps.executeQuery();
            while (res.next()) {
               MethodTem methodTem = new MethodTem(res.getInt("id"), res.getString("nameMethod"));
                provs.add(methodTem); // I obtain the clave of each Latam
            }
            if (!provs.isEmpty()) {
                cbxModel = new DefaultComboBoxModel(provs.stream().toArray()); // I sent it in the new model, this will pass its values in the original combo box 
                system.cbxPayments.setModel(cbxModel);
            }
        } catch (SQLException e) {
            System.out.println("Error Combo ");
            e.printStackTrace();
        }
    }
}
