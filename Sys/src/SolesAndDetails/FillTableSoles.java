package SolesAndDetails;

import Entities.Sale;
import View.SystemMain;
import java.awt.List;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class FillTableSoles extends Controller.Conexion {// THIS CLASS FILL THE TABLE OF THE SALES MADE

    private final Connection con;
    private final SystemMain system;
    private FileOutputStream fileSole;
    private PreparedStatement ps;
    private ResultSet res;
    private CallableStatement call;
    private ArrayList<Sale> listSales;
    private DefaultTableModel modelTem;

    public FillTableSoles(SystemMain system) {
        con = establihsConnection();
        this.system = system;
        listSales = new ArrayList();
    }

    public void listSales() {
        listSales.clear();
        try {
            final String sqlQuery = "{CALL Select_Soles}";
            call = con.prepareCall(sqlQuery);
            res = call.executeQuery();
            while (res.next()) {
                Sale sale = new Sale(res.getInt("IdSole"), res.getString("DniCustomer"), res.getFloat("Total"), res.getString("datePurchase"), res.getString("nameMethod"));
                listSales.add(sale);
            }
        } catch (SQLException ex) {
            System.out.println("Error list Select Solect");
            ex.printStackTrace();
        }
    }

    public void fillTableSolesMade() {
        try {
        modelTem = (DefaultTableModel) system.tbSoles.getModel();
        cleanTable(); // First Clean the list and the table 
        listSales();    
        int tamList = listSales.size();
        Object[] arrayCust = new Object[5];
        for (int a = 0; a < tamList; a++) { // I fill the table
            arrayCust[0] = (int) listSales.get(a).getIdVenta();
            arrayCust[1] = (String) listSales.get(a).getDniCustomer();
            arrayCust[2] = (String) listSales.get(a).getNamePayment();
            arrayCust[3] = (float) listSales.get(a).getTotalBuy();
            arrayCust[4] = (String) listSales.get(a).getDate();
            modelTem.addRow(arrayCust);
        }
        system.tbSoles.setModel(modelTem); // I add the items in the model Table
        } catch (Exception e) {
            System.out.println("error fill table Sole");
            e.printStackTrace();
        }
        
    }

    // I clean the table of customers
    private void cleanTable() {
        listSales.clear(); // I clear the list of data obteins previously
        for (int i = modelTem.getRowCount() - 1; i >= 0; i--) {
            modelTem.removeRow(i);
        }
    }
}
