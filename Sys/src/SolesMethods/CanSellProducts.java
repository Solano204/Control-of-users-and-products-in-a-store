package SolesMethods;

import View.SystemMain;

public class CanSellProducts {// This classs is charge of check the lista has products to sell
    
    final SystemMain system;

    public CanSellProducts(SystemMain system) {
        this.system = system;
    }

     
    // This check that after a product, Now I can sell a products to a customer, if there is no product I cant sell anything
    public void canSell(){
        if (system.tbNewSoles.getRowCount()>0) {  // If the list has 1 products to sell
            system.txtDniNew.setEnabled(true);
            return;
        }
        system.txtDniNew.setEnabled(false); // If the list doesnt has products to sell
        
    }
}
