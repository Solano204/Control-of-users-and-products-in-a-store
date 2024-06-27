package CustomerMethods;

import View.SystemMain;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExitsCustomer extends Controller.Conexion { // THIS CLAS SERVES TO SEARCH A CLIENT BY DNI CUSTOMER

    private final Connection con;
    private ResultSet res;
    private CallableStatement ps;

    public ExitsCustomer() {
        this.con = establihsConnection();
    }

    public boolean searchUser(String DniCustomer) {
        try {
            String searchQuery = "{CALL Search_Customer (?)}";
            ps = con.prepareCall(searchQuery);
            ps.setString(1, DniCustomer);
            res = ps.executeQuery();
            if (res.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
