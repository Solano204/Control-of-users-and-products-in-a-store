package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Conexion {

    protected Connection conectar = null;
    protected String user = "sa";
    protected String password = "12345";
    protected String dataBase = "SYSTEMSOLES";
    protected String ip = "";
    protected String puerto = "1433";

    public Connection establihsConnection() {
        try {
            
            String cadena = "jdbc:sqlserver://localhost:" + puerto + ";" + "databaseName=" + dataBase + ";"
                    + "trustServerCertificate = true;";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conectar = DriverManager.getConnection(cadena, user, password);
            return (Connection) conectar;
        } catch (Exception e) {
            System.out.println("Conecction Error " + e.toString());
            return null;
        }
    }
}
