package SolesMethods;

import View.SystemMain;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.formula.ptg.TblPtg;

public class ProductsTable {

    private final SystemMain systemMain;
    DefaultTableModel tempModel;
    private final CancelBuy cancelBuy;
    private final CanSellProducts canSell;

    public ProductsTable(SystemMain systemMain) {
        this.systemMain = systemMain;
        cancelBuy = new CancelBuy(systemMain);
        canSell = new CanSellProducts(systemMain);
    }

    public void fillTableBuys(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() != KeyEvent.VK_ENTER) { // I check the crushed button was the ENTER
            return;
        }

        // i check the amount the amoubnt to buy doesnt empty or the product already exits in the table
        if (existProductTable() || systemMain.txtAmountNew.getText().isBlank() || systemMain.txtAmountNew.getText().isEmpty()
                || (Integer.parseInt(systemMain.txtAvaliableNew.getText()) < Integer.parseInt(systemMain.txtAmountNew.getText()))) {
            Toolkit.getDefaultToolkit().beep();
            return;
        }

        final String codePro = systemMain.txtCodeNew.getText();
        final String descrition = systemMain.txtDescriptionNew.getText();
        int requeriedAmount = Integer.parseInt(systemMain.txtAmountNew.getText());
        float pricePro = Float.parseFloat(systemMain.txtPriceNew.getText());
        float totalPay = requeriedAmount * pricePro;
        tempModel = (DefaultTableModel) systemMain.tbNewSoles.getModel();
        ArrayList list = new ArrayList();
        list.add(codePro);
        list.add(descrition);
        list.add(requeriedAmount);
        list.add(pricePro);
        list.add(totalPay);

        Object[] fields = new Object[6];
        fields[0] = list.get(0);
        fields[1] = list.get(1);
        fields[2] = list.get(2);
        fields[3] = list.get(3);
        fields[4] = list.get(4);
        tempModel.addRow(fields);
        systemMain.tbNewSoles.setModel(tempModel); // I add a new peroduct in the table 
        totalGeneral();
        cleanTextEmptys();
        cancelBuy.cancelBuyProduct(); // i left the interface as if I had cancelled the purchase of this products(EVEN IF IT ISNT)
        canSell.canSell();
    }

    //  I check this products doesnt exist in the table
    private boolean existProductTable() {
        final String codeProductDelete = systemMain.txtCodeNew.getText();
        for (int i = 0; i < systemMain.tbNewSoles.getRowCount(); i++) {
            if (systemMain.tbNewSoles.getValueAt(i, 0).equals(codeProductDelete)) {
                JOptionPane.showMessageDialog(null, "This Product with this ID already exits");
                cancelBuy.cancelBuyProduct();
                return true;
            }
        }
        return false;
    }

    
    /// I calculate the value of buy of all products
    private void totalGeneral() {
        float totalGeneral = 0;
        int amountRowProducts = systemMain.tbNewSoles.getRowCount();
        for (int i = 0; i < amountRowProducts; i++) {
            totalGeneral += Float.parseFloat(systemMain.tbNewSoles.getValueAt(i, 4).toString());
        }
        systemMain.lblTotaBuy.setText(String.format("%.2f", totalGeneral));
    }
    
    
    //I clean the fields
    private void cleanTextEmptys() {
        systemMain.txtAmountNew.setText("");
        systemMain.txtDescriptionNew.setText("");
        systemMain.txtAvaliableNew.setText("");
        systemMain.txtPriceNew.setText("");
        systemMain.txtCodeNew.setText("");
        systemMain.txtAmountNew.requestFocus(); // I left the interface as if I had cacelled the purchase of this product
    }
}
