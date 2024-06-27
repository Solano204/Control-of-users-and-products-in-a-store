package SolesMethods;

import Controller.Conexion;
import View.SystemMain;
import java.awt.event.KeyEvent;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class FillTextProduct extends Conexion { // THIS CLASSS IS RESPONSIBLE FOR FILLING OUT THE TEXT FIELD ABOUT THE PRODUCTS OF ACCORDING WITH CODE

    private final Connection con;
    private ResultSet res;
    private final SystemMain system;
    private PreparedStatement ps;

    public FillTextProduct(SystemMain system) {
        this.con = establihsConnection();
        this.system = system;
    }

    public void searchProduct(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() != KeyEvent.VK_ENTER) { // I check the button pressed was TABULADOR
            return;
        }
        cleanTextEmptys();
        final String codeSearch = system.txtCodeNew.getText();
        if (codeSearch.isEmpty() && codeSearch.isBlank()&& codeSearch.length() != 8) {
            JOptionPane.showMessageDialog(null, "Code is missing, Cant search a Product", "WARNING", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            final String sqlQuery = "SELECT CodeProduct,NameProduct,StockAvailable,Price FROM Products WHERE CodeProduct = (?)";
            ps = con.prepareStatement(sqlQuery);
            ps.setString(1, codeSearch);
            res = ps.executeQuery();
            if (res.next()) { // if fields are complete , so I give the amount to buy
                hideElements();
                system.txtAvaliableNew.setText(String.valueOf(res.getInt("StockAvailable")));
                system.txtDescriptionNew.setText(res.getString("NameProduct"));
                system.txtPriceNew.setText(String.valueOf(res.getFloat("Price")));
                system.txtAmountNew.requestFocus(); // I pay it attention to that field
                system.btnCancelBuy.setVisible(true); // I active the button to cancel the buy
                system.lblCancelBuy.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "This Product with this ID there isnt");
                system.txtCodeNew.requestFocus();
            }
        } catch (SQLException e) {
            System.out.println("Error search product Soles");
            e.printStackTrace();
        }
    }

    // It´ll hide items based on the value shipped  
    private void hideElements() {
        system.txtCodeNew.setEnabled(false);
        system.txtDescriptionNew.setEnabled(false);
        system.txtDescriptionNew.setEditable(false);
        system.txtAvaliableNew.setEnabled(false);
        system.txtAvaliableNew.setEditable(false);
        system.txtAmountNew.setEnabled(true);
        system.txtAmountNew.setEditable(true);
        system.txtPriceNew.setEnabled(false);
        system.txtPriceNew.setEditable(false);

    }

    private void cleanTextEmptys() {
        system.txtAmountNew.setText("");
        system.txtDescriptionNew.setText("");
        system.txtAvaliableNew.setText("");
        system.txtPriceNew.setText("");
    }
}
