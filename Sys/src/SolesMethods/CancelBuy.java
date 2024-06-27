package SolesMethods;

import View.SystemMain;

public class CancelBuy {

    final SystemMain system;

    public CancelBuy(SystemMain system) {
        this.system = system;
    }

    // This method is use to cancel a new buy of a product
    public void cancelBuyProduct() {
        system.txtPriceNew.setText("");
        system.txtAmountNew.setText("");    
        system.txtDescriptionNew.setText("");
        system.txtAvaliableNew.setText("");
        system.txtAmountNew.setEnabled(false);
        system.txtCodeNew.setText("");
        system.txtCodeNew.requestFocus();
        system.txtCodeNew.setEnabled(true); // I active a new code product , to put new products
        system.btnCancelBuy.setVisible(false); // I desactive buttom to cancel the buy
        system.lblCancelBuy.setVisible(false);
        
    }
}
