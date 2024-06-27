package SolesMethods;

import View.SystemMain;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DeletProSole {

    final CanSellProducts canSell;
    final SystemMain system;
    DefaultTableModel modelTemp; // I use a temporary model to delete row and then update the table source

    public DeletProSole(SystemMain system) {
        this.system = system;
        canSell = new CanSellProducts(system);
    }

    // Method to eliminate a product
    public void deleteProductSelect() {
        int choice = JOptionPane.showConfirmDialog(null, "Are you sure to eliminate this Product of your buy?");
        if (choice == 0) {
            modelTemp = (DefaultTableModel) system.tbNewSoles.getModel();
            modelTemp.removeRow(system.tbNewSoles.getSelectedRow()); // a proof that an element can be affected indirectly by another component having the same data as it
            totalGeneral(); // I update the new bill}
            canSell.canSell(); // I update the capacity to puchase a new product
            if (modelTemp.getRowCount()== 0) { // I desactive to avoid problems , and there isnt empty buys
                system.btnPrintTicketNew.setEnabled(false);
                system.txtDniNew.setText("");
                system.txtNameNew.setText("");
                system.txtDniNew.setEnabled(false);
            }
        }
    }

    /// I calculate the value of buy of all products
    private void totalGeneral() {
        float totalGeneral = 0;
        int amountRowProducts = system.tbNewSoles.getRowCount();
        for (int i = 0; i < amountRowProducts; i++) {
            totalGeneral += Float.parseFloat(system.tbNewSoles.getValueAt(i, 4).toString());
        }
        system.lblTotaBuy.setText(String.format("%.2f", totalGeneral));
        system.txtCodeNew.requestFocus();
    }

}
