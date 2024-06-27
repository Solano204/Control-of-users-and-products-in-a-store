package ProductMethods;

import CustomerMethods.*;
import Controller.CheckEmpty;
import Controller.Conexion;
import Entities.Product;
import View.SystemMain;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class PrintProducts extends Conexion {

    
    
    private final Connection con;
    private ResultSet res;
    private SystemMain system;
    private CallableStatement ps;
    private final ArrayList<Product> listCus;
    private DefaultTableModel modelTable;

    public PrintProducts(SystemMain system) {
        this.con = establihsConnection();
        ps = null;
        res = null;
        this.system = system;
        listCus = new ArrayList<>();
        modelTable = (DefaultTableModel) system.tbProducts.getModel();

    }

    // I get all the values from the list
    private void printCus() {
        try {
            final String querySql = "{CALL Select_Product}"; // I call the PA
            ps = con.prepareCall(querySql);
            res = ps.executeQuery();
            Product pro;
            while (res.next()) { // Fill the ArrayList
                pro = new Product(res.getString("CodeProduct"),res.getString("NameProduct"), res.getInt("StockAvailable"),
                        res.getDouble("Price"),res.getString("NameProvider"),res.getString("lastUpdate"));
                listCus.add(pro);
            }
        } catch (SQLException e) {
            System.out.println("Error print the products " + e.getMessage());
        }
    }

    // I fill out the table with all the items from list
    public void fillOutTable() {
        cleanTable(); // First Clean the list and the table 
        printCus(); // Obtain the values from data base Customers
        modelTable = (DefaultTableModel) system.tbProducts.getModel(); 
        int tamList = listCus.size();
        Object[] arrayCust = new Object[6];
        for (int a = 0; a < tamList; a++) { // I fill the table
            arrayCust[0] =  listCus.get(a).getCode();
            arrayCust[1] =  listCus.get(a).getName();
            arrayCust[2] =  listCus.get(a).getStock();
            arrayCust[3] =  String.format("%.2f", listCus.get(a).getPrice());
            arrayCust[4] =  listCus.get(a).getNameProvider();
            arrayCust[5] =  listCus.get(a).getDate();
            modelTable.addRow(arrayCust);
        }
        system.tbCustomers.setModel(modelTable); // I add the items in the model Table
    }

    // I clean the table of customers
    private void cleanTable() {
        listCus.clear(); // I clear the list of data obteins previously
        for (int i = modelTable.getRowCount()-1; i >=0; i--) {
            modelTable.removeRow(i);
        }
    }

}
