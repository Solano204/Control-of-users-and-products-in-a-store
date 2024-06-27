package UserMethods;

import Controller.CheckEmpty;
import Controller.Conexion;
import Controller.EncrypPassWord;
import View.Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import View.SystemMain;
import java.awt.HeadlessException;
import java.sql.CallableStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import org.apache.poi.poifs.crypt.ChainingMode;

public class LoginUser extends Conexion { // THIS CLASS IS CHARGE OF CONTROLLER THE LOGIN

    private final Connection con = establihsConnection();
    private CallableStatement pro;
    private CallableStatement ps;
    private ResultSet res;
    private Login system;
    private final CheckEmpty ck;
    private SystemMain viewSales;
    private final EncrypPassWord en;
    private ValidateData validateData;
    private boolean CLOSED_SYSTEM; // THIS VARIABLE WILL HELP ME TO CONTROL IF I CAN OPEN THE WINDOW SYSTEM OR NO 

    public LoginUser(Login system) {
        CLOSED_SYSTEM = false;
        this.viewSales = null;
        this.system = system;
        res = null;
        ps = null;
        en = new EncrypPassWord();
        this.ck = new CheckEmpty();
        validateData = new ValidateData(this.system);
        initValidation();
    }

    private void initValidation() {
        Thread.ofVirtual().start(() -> validateData.initComponents());
    }

    public void loginUser() {
        String sql = " SELECT IdUser,TypeUser FROM UserMain WHERE IdUser = ? AND PassWordUser  = ? AND TypeUser = ?";
        final String user = system.txtUserMain.getText();
        final String pass = system.txtPasswordMain.getText();
        final String typeUser = system.cbxLogPriv.getSelectedItem().toString();
        try {
            if (!user.isBlank() && !typeUser.isBlank() && !pass.isBlank()) {
                if (ck.isEmptyString(user).isPresent() && ck.isEmptyString(pass).isEmpty() && ck.isEmptyString(typeUser).isEmpty());
                {
                    String passEncrypt = en.encryptPassword(user, pass);
                    ps = con.prepareCall(sql);
                    ps.setString(1, user);
                    ps.setString(2, passEncrypt);
                    ps.setString(3, typeUser);
                    res = ps.executeQuery();
                    if (res.next()) {
                        if (res.getString(2).equalsIgnoreCase("ADMINISTRATOR") && this.viewSales == null) {
                            openWindowAdministrator();
                        }

                        if (res.getString(2).equalsIgnoreCase("ASSISTANT") && this.viewSales == null) {
                            openWindowAssistant();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "INCORRECT DATA", "", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Error Init Administrator");
            e.printStackTrace();
        }
    }

    // This window will open , when the user is ADMINISTRATOR and control that variables will shoAA
    private void openWindowAdministrator() {
        try {
            system.setVisible(false);
            viewSales = new SystemMain(this);
            viewSales.setLocationRelativeTo(null);
            viewSales.setVisible(true);
        } catch (Exception e) {
            System.out.println("error tried the window system by the administrator");
        }
    }

    // This window will open , when the user is ASSSISTANT and control that variables will show
    private void openWindowAssistant() {
        try {
            system.setVisible(false);
            viewSales = new SystemMain(this);
            viewSales.btnProvider.setVisible(false);
            viewSales.btnEployess.setVisible(false);
            viewSales.setLocationRelativeTo(null);
            viewSales.txtDniComp.setEnabled(false);
            viewSales.txtNameComp.setEnabled(false);
            viewSales.txtTeleCom.setEnabled(false);
            viewSales.txtAddressComp.setEnabled(false);
            viewSales.txtBussNameComp.setEnabled(false);
            viewSales.btnUpdComp.setEnabled(false);
            viewSales.setVisible(true);
        } catch (Exception e) {
            System.out.println("error tried the window system by the administrator");
        }
    }

    public void insertNewUser() {
        try {
            String user = "JOSUE666";
            String pass = "22700231";
            String typeUser = "Administrator";
            String name = "Carlos Josue Lopez Solano";
            String Telephone = "9631585308";
            String email = "carlosjosuelopezsolano98@gmail.com";
            String sqlProcedimiento = "{CALL Insert_Users (?,?,?,?,?,?,?)}"; // I prepare my query to the procedure, with all the parameters and even the output value, Dont avoid the {}
            try {
                String passsEncrypted = en.encryptPassword(user, pass);
                pro = con.prepareCall(sqlProcedimiento);
                pro.setString(1, user);
                pro.setString(2, passsEncrypted);
                pro.setString(3, typeUser);
                pro.setString(4, name);
                pro.setString(5, Telephone);
                pro.setString(6, email);
                pro.setInt(7, 1);
                pro.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.out.println("ERROR INSERT MAIN USER" + e.getMessage());

        }

    }

    public void insertNewEmpl() {
        try {
            String user = "Michell8";
            String pass = "22700230";
            String typeUser = "Assistant";
            String name = "Michelll Unknown";
            String Telephone = "9631897922";
            String email = "MichellTeAguilExtr98@gmail.com";
            String sqlProcedimiento = "{CALL Insert_Users (?,?,?,?,?,?,?)}"; // I prepare my query to the procedure, with all the parameters and even the output value, Dont avoid the {}
            try {
                String passsEncrypted = en.encryptPassword(user, pass);
                pro = con.prepareCall(sqlProcedimiento);
                pro.setString(1, user);
                pro.setString(2, passsEncrypted);
                pro.setString(3, typeUser);
                pro.setString(4, name);
                pro.setString(5, Telephone);
                pro.setString(6, email);
                pro.setInt(7, 1);
                pro.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.out.println("ERROR INSERT MAIN USER" + e.getMessage());

        }

    }

    // SET AND GETS TO CHANGE AND CONTROL THE WINDOWS EACH FRM, Use the SINGLENTON pattern
    public void setViewSales(SystemMain viewSales) {
        this.viewSales = viewSales;
    }

    public SystemMain getViewSales() {
        return viewSales;
    }

    public boolean isCLOSED_SYSTEM() {
        return CLOSED_SYSTEM;
    }

    public void setCLOSED_SYSTEM(boolean CLOSED_SYSTEM) {
        this.CLOSED_SYSTEM = CLOSED_SYSTEM;
    }

    public Login getSystem() {
        return system;
    }

    public void setSystem(Login system) {
        this.system = system;
    }

}
