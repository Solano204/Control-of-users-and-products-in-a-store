package SolesAndDetails;

import View.SystemMain;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ObtainPDFSole { // THIS CLASS IS IN CHARGE OF SEARCHING FOR THE TICKET OF THE SALE RELATED TO THE SELECTD COLUMN

    private final SystemMain system;

    public ObtainPDFSole(SystemMain system) {
        this.system = system;
    }

    public void obtainPDFSelectSole() {
        try {
            int idSelectedSole = (int) system.tbSoles.getValueAt(system.tbSoles.getSelectedRow(), 0);
            String destinationPath = "C:\\CarreraInge\\NetBeansProjects\\Sys\\SolesPDF\\Ventas" + "Sole" + idSelectedSole + ".pdf";
            File file = new File(destinationPath);
            Desktop.getDesktop().open(file);
            system.btnPdfSoles.setEnabled(false);
        } catch (IOException ex) {
            Logger.getLogger(ObtainPDFSole.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
