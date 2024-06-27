package ProductMethods;

import CustomerMethods.*;
import Controller.Conexion;
import View.SystemMain;
import View.SystemMain;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

public class FillTableProducts extends Conexion {
    private final SystemMain system;
    private CallableStatement ps;

    public FillTableProducts(SystemMain system) {
        this.system = system;
    }

    // This method will active each turn I press a row in the table and the values are represented in the TEXTFIELD
    public void fillTextField(java.awt.event.MouseEvent evt) {
        try {
            
            int selectedRecord = system.tbProducts.rowAtPoint(evt.getPoint());
            system.txtCodePro.setEnabled(false);
            system.txtCodePro.setText(system.tbProducts.getValueAt(selectedRecord, 0).toString());
            system.txtNamePro.setText(system.tbProducts.getValueAt(selectedRecord, 1).toString());
            system.txtStockProd.setText(system.tbProducts.getValueAt(selectedRecord, 2).toString());
            system.txtPricePro.setText(system.tbProducts.getValueAt(selectedRecord, 3).toString());
            String ptoTem = (String) (system.tbProducts.getValueAt(selectedRecord,4));
            for (int i = 0; i < (system.cbxProvProd.getItemCount()); i++) {
                if (ptoTem.equals(system.cbxProvProd.getItemAt(i).getNameProv())) {
                    system.cbxProvProd.setSelectedIndex(i);
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
