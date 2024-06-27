package UserMethods;

import CustomerMethods.*;
import Controller.CheckEmpty;
import Controller.Conexion;
import Entities.Customer;
import Entities.Users;
import View.SystemMain;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class PrintUsers extends Conexion {

    
    // THIS CLASS IS TO FILL THE TABLE WITH THE VALUES FROM QUERIE
    private final Connection con;
    private ResultSet res;
    private SystemMain system;
    private CallableStatement ps;
    private final ArrayList<Users> listCus;
    private DefaultTableModel modelTable;

    public PrintUsers(SystemMain system) {
        this.con = establihsConnection();
        ps = null;
        res = null;
        this.system = system;
        listCus = new ArrayList<>();
        modelTable = (DefaultTableModel) system.tbEmployess.getModel();

    }

    // I get all the valuyes from the list
    private void printCus() {
        try {
            final String querySql = "{CALL Select_User}"; // I call the PA
            ps = con.prepareCall(querySql);
            res = ps.executeQuery();
            while (res.next()) { // Fill the ArrayList
                Users user = new Users(res.getString("IdUser"),res.getString("PassWordUser"), res.getString("TypeUser"), res.getString("NameUser"),
                        res.getString("TelephoneUser"),res.getString("emailUser"), res.getString("RegistrationDate"),res.getString("clave"));
                listCus.add(user);
            }
        } catch (SQLException e) {
            System.out.println("Error print the users" + e.getMessage());
            e.printStackTrace();
        }
    }

    // I fill out the table with all the items from list
    public void fillOutTable() {
        cleanTable(); // First Clean the list and the table 
        printCus(); // Obtain the values from data base Customers
        modelTable = (DefaultTableModel) system.tbEmployess.getModel(); 
        int tamList = listCus.size();
        Object[] arrayCust = new Object[7];
        for (int a = 0; a < tamList; a++) { // I fill the table
            arrayCust[0] = (String) listCus.get(a).getIdUser();
            arrayCust[1] = (String) "ANONYMUS";
            arrayCust[2] = (String) listCus.get(a).getTypeUser();
            arrayCust[3] = (String) listCus.get(a).getName();
            arrayCust[4] = (String) listCus.get(a).getTelephone();
            arrayCust[5] = (String) listCus.get(a).getEmail();
            arrayCust[6] = (String) listCus.get(a).getDate();
            modelTable.addRow(arrayCust);
        }
        system.tbEmployess.setModel(modelTable); // I add the items in the model Table
    }

    // I clean the table of customers
    private void cleanTable() {
        listCus.clear(); // I clear the list of data obteins previously
        for (int i = modelTable.getRowCount()-1; i >=0; i--) {
            modelTable.removeRow(i);
        }
    }

}
