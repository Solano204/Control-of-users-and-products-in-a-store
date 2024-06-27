package CustomerMethods;

import Controller.CheckEmpty;
import Controller.Conexion;
import Entities.Customer;
import View.SystemMain;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class PrintCustomer extends Conexion {

    
    // THIS CLASS IS TO FILL THE TABLE WITH THE VALUES FROM QUERIE
    private final Connection con;
    private ResultSet res;
    private SystemMain system;
    private CallableStatement ps;
    private final ArrayList<Customer> listCus;
    private DefaultTableModel modelTable;

    public PrintCustomer(SystemMain system) {
        this.con = establihsConnection();
        ps = null;
        res = null;
        this.system = system;
        listCus = new ArrayList<>();
        modelTable = (DefaultTableModel) system.tbCustomers.getModel();

    }

    // I get all the valuyes from the list
    private void printCus() {
        try {
            final String querySql = "{CALL Select_Table}"; // I call the PA
            ps = con.prepareCall(querySql);
            res = ps.executeQuery();
            while (res.next()) { // Fill the ArrayList
                Customer cus = new Customer(res.getString("DniCustomer"), res.getString("NameCustomer"), res.getString("TelephoneCustomer"),
                        res.getString("AddresCustomer"), res.getString("RegistrationDate"));
                listCus.add(cus);
            }
        } catch (SQLException e) {
            System.out.println("Error print the users" + e.getMessage());
        }
    }

    // I fill out the table with all the items from list
    public void fillOutTable() {
        cleanTable(); // First Clean the list and the table 
        printCus(); // Obtain the values from data base Customers
        modelTable = (DefaultTableModel) system.tbCustomers.getModel(); 
        int tamList = listCus.size();
        Object[] arrayCust = new Object[5];
        for (int a = 0; a < tamList; a++) { // I fill the table
            arrayCust[0] = (String) listCus.get(a).getDni();
            arrayCust[1] = (String) listCus.get(a).getName();
            arrayCust[2] = (String) listCus.get(a).getTelephone();
            arrayCust[3] = (String) listCus.get(a).getAddres();
            arrayCust[4] = (String) listCus.get(a).getRegistrationDate();
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
