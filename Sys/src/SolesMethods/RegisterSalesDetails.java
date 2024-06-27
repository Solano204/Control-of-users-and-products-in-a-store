package SolesMethods;

import Controller.Conexion;
import Entities.DetailSale;
import View.SystemMain;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterSalesDetails extends Conexion { // I REGISTER A NEW SOLES THAT DEPENDS OF ONLY GENERAL SOLE

    private final Connection con;
    private ResultSet res;
    private final SystemMain system;
    private PreparedStatement ps;
    private CallableStatement call;

    public RegisterSalesDetails(SystemMain system) {
        this.system = system;
        this.con = establihsConnection();
    }

    // I Register of each sole by each product
    public void registerSole() {
        try {
            StringBuilder codeProduc = new StringBuilder();
            int amountCurrentPro = 0;
            float totalBuy = 0;
            int soleFather = IdSoleDepends();
            String sqlQuery = "{CALL Insert_DetailSole (?,?,?,?)}";
            for (int i = 0; i < system.tbNewSoles.getRowCount(); i++) {
                codeProduc.setLength(0);
                codeProduc.append(system.tbNewSoles.getValueAt(i, 0).toString());
                amountCurrentPro = Integer.parseInt(system.tbNewSoles.getValueAt(i, 2).toString());
                totalBuy = Float.parseFloat(system.tbNewSoles.getValueAt(i, 4).toString());
                call = con.prepareCall(sqlQuery);
                call.setString(1, codeProduc.toString());
                call.setInt(2, amountCurrentPro);
                call.setFloat(3, totalBuy);
                call.setInt(4, soleFather);
                call.execute();
                updateStockBuyProduct(codeProduc.toString(), amountCurrentPro);
            }
        } catch (SQLException e) {
            System.out.println("Error Combo ");
            e.printStackTrace();
        }
    }

    // This method serve to decreased the avaible stock of a product after a buy 
    private void updateStockBuyProduct(final String dniProduct,final int amountDecrase) {
        String sqlProducts = "{CALL update_StockBuy (?,?)}";
        try {
            call.clearParameters();
            call = con.prepareCall(sqlProducts);
            call.setString(1,dniProduct);
            call.setInt(2, amountDecrase);
            call.execute();
            call.clearParameters();
        } catch (SQLException e) {
        }
    }

    private int IdSoleDepends() {
        try {
            String sqlQuery = "SELECT MAX(IdSole) as LAST_SALE FROM sales";
            ps = con.prepareStatement(sqlQuery);
            res = ps.executeQuery();
            if (res.next()) {
                return res.getInt("LAST_SALE");
            }
        } catch (SQLException e) {
            System.out.println("Error Combo ");
            e.printStackTrace();
            return 0;
        }
        return 0;
    }

}
