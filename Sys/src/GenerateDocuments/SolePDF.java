package GenerateDocuments;

import View.SystemMain;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import static org.apache.poi.hssf.usermodel.HeaderFooter.file;

public class SolePDF extends Controller.Conexion {

    private final SystemMain system;
    private Document docTemp; // Document is a class that allows me create pdf and modify it
    private File fileImput;
    private FileOutputStream fileSole;
    final Connection con;
    private PreparedStatement ps;
    private ResultSet res;

    public SolePDF(SystemMain system) throws FileNotFoundException, DocumentException {
        con = establihsConnection();
        this.system = system;
    }

    public void generatePDF() {
        initPdfWrite();
        docTemp.open(); // I open the pdf to allow its modify
        generateInformationCompany();
        generateInformationClient();
        generateInformationProducts();
        generateTicketFoot();
        cleanTextEmptys(); // I let how before it is

    }

    // I init the pdf for write a new sole, but with the number sole current
    public void initPdfWrite() {
        try {
            int numberSoleCurrent = IdSoleDepends();
            String destinationPath = "C:\\CarreraInge\\NetBeansProjects\\Sys\\SolesPDF\\Ventas" + "Sole" +numberSoleCurrent+".pdf";
            fileImput = new File(destinationPath);
            fileSole = new FileOutputStream(fileImput);
            docTemp = new Document();
            PdfWriter.getInstance(docTemp, fileSole); // I provide the document and the path in which the new pdf Will be saved
        } catch (Exception ex) {
            Logger.getLogger(SolePDF.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // THIS METHOD GENERATE THE INFORMATION OF COMPANY(purchase Date,NumberBill and information about compu)
    private void generateInformationCompany() {
        try {
            /* PdfPTable firstHeader = new PdfPTable(4);
            firstHeader.setWidthPercentage(100); // Ii`ll occupy all the sheet
            firstHeader.getDefaultCell().setBorder(23); // Without border
            float[] measuresHeader = new float[]{20f, 30f, 70f, 40f}; // I create the measure the JTABLEPDF will has
            firstHeader.setWidths(measuresHeader);
            firstHeader.setHorizontalAlignment(Element.ALIGN_RIGHT);*/

            // CREATE IMAGE AND I ADD IMAGE
            Image image = Image.getInstance("C:\\CarreraInge\\NetBeansProjects\\Sys\\src\\Images\\Carrito-de-compras.png");
            image.setAlignment(Element.ALIGN_RIGHT);
            docTemp.add(image);

            // I CREATE BILL AND DATE
            Paragraph contentDate = new Paragraph(); // Class to write text in the PDF 
            // Font blackL = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.BLACK);
            LocalDate dateSale = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            // Formatear la fecha como una cadena
            String DateCurrent = dateSale.format(formatter);
            contentDate.add("Bill" + IdSoleDepends() + "\n Sole Date :" + DateCurrent);
            contentDate.setAlignment(Element.ALIGN_RIGHT);
            docTemp.add(contentDate);
            // CREATE THE INFORMATION FROM CLIENT AND ADD IN THE PDF
            ResultSet res = generateInfoCompany();
            if (res.next()) {
                final String dniCompany = res.getString("DniCompany");
                final String nameCompany = res.getString("NameCompany");
                final String telephone = res.getString("TelephoneCompany");
                final String addres = res.getString("AddresCompany");
                final String bussinesName = res.getString("BussinessName");
                Paragraph contentInfo = new Paragraph("\nDniCompany:" + dniCompany + "\nCompany :" + nameCompany + "\nTelephone" + telephone
                        + "\nAddres :" + addres + "\n Bussines Name :" + bussinesName);
                contentInfo.setAlignment(Element.ALIGN_LEFT);
                docTemp.add(contentInfo);
            }
        } catch (Exception e) {
            System.out.println("Erro generate image PDF");
            e.printStackTrace();
        }
    }

    // THIS METHOD GENERATE THE TITLES AND INFROMATION OF CLIENT
    private void generateInformationClient() {
        try {
            Paragraph fontClient = new Paragraph();
            fontClient.add(Chunk.NEWLINE);
            fontClient.add("DATA OF THE CUSTOMERS\n");
            fontClient.setAlignment(Paragraph.ALIGN_CENTER);
            fontClient.add(Chunk.NEWLINE);
            fontClient.add(Chunk.NEWLINE);
            docTemp.add(fontClient);

            // CREATE THE TITLES OF CLIENT
            PdfPTable contentClient = new PdfPTable(4);
            contentClient.setWidthPercentage(100);
            contentClient.getDefaultCell().setBorder(0);
            float[] measures = new float[]{50f, 50f, 40f, 70f};
            contentClient.setWidths(measures);
            contentClient.setHorizontalAlignment(Element.ALIGN_RIGHT);
            PdfPCell dniCust = new PdfPCell(new Phrase("Dni Customer"));
            PdfPCell NameCust = new PdfPCell(new Phrase("Name Customer"));
            PdfPCell Telephone = new PdfPCell(new Phrase("Telephone"));
            PdfPCell addres = new PdfPCell(new Phrase("Addres Customer"));
            dniCust.setBorder(0);
            NameCust.setBorder(0);
            Telephone.setBorder(0);
            addres.setBorder(0);
            contentClient.addCell(dniCust);
            contentClient.addCell(NameCust);
            contentClient.addCell(Telephone);
            contentClient.addCell(addres);

            Paragraph lineBreak = new Paragraph();
            lineBreak.add(Chunk.NEWLINE);
            // THE INFORMATION OD THE CLIENT AND I ADD IN  THE PDF
            ResultSet clientData = generateResultCustomer();
            if (clientData.next()) {
                contentClient.addCell(clientData.getString("DniCustomer"));
                contentClient.addCell(clientData.getString("NameCustomer"));
                contentClient.addCell(clientData.getString("Clave") + clientData.getString("TelephoneCustomer"));
                contentClient.addCell(clientData.getString("AddresCustomer"));
                docTemp.add(contentClient);
                lineBreak.add(Chunk.NEWLINE);
                docTemp.add(lineBreak);
            } else {
                System.out.println("nmsdlkjsd");
            }
        } catch (Exception ex) {
            System.out.println("Error generate information of Client ");
            ex.printStackTrace();
        }
    }

    // THIS  METHOD GENERATE THE TITLLES AND INFORMATION OF EACH PRODUCT
    private void generateInformationProducts() {
        try {
            Paragraph lineBreak = new Paragraph();
            // I CREATE THE TITLES OF THE PRODUCTS AND I ADD
            PdfPTable contentProducts = new PdfPTable(5);
            contentProducts.setWidthPercentage(100);
            contentProducts.getDefaultCell().setBorder(0);
            float[] measures = new float[]{30f, 20f, 40f, 20f, 50f};
            contentProducts.setWidths(measures);
            contentProducts.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell codePro = new PdfPCell(new Phrase("CodeProduct"));
            PdfPCell namePro = new PdfPCell(new Phrase("Name Product"));
            PdfPCell amountPro = new PdfPCell(new Phrase("Amount purchase"));
            PdfPCell pricePro = new PdfPCell(new Phrase("Price of Product"));
            PdfPCell totalBuy = new PdfPCell(new Phrase("Total to buy"));
            codePro.setBorder(0);
            amountPro.setBorder(0);
            pricePro.setBorder(0);
            totalBuy.setBorder(0);
            namePro.setBorder(0);
            contentProducts.addCell(codePro);
            contentProducts.addCell(namePro);
            contentProducts.addCell(amountPro);
            contentProducts.addCell(pricePro);
            contentProducts.addCell(totalBuy);
            // I CREATE THE INFORMATION ABOUT ALL PRODUCTS BOUGHT 
            for (int i = 0; i < system.tbNewSoles.getRowCount(); i++) {//When all the columns of the are completed, it automatically jumps to the other ROW
                final String dniProd = system.tbNewSoles.getValueAt(i, 0).toString();
                final String NameProBuy = system.tbNewSoles.getValueAt(i, 1).toString();
                final String amountProBuy = system.tbNewSoles.getValueAt(i, 2).toString();
                final String priceProBut = system.tbNewSoles.getValueAt(i, 3).toString();
                final String totalPurchase = system.tbNewSoles.getValueAt(i, 4).toString();
                // ADD SOME BREAK LINE
                contentProducts.addCell("\n");
                contentProducts.addCell("\n");
                contentProducts.addCell("\n");
                contentProducts.addCell("\n");
                contentProducts.addCell("\n");

                // DATA EACH PRODUCTS
                contentProducts.addCell(dniProd);
                contentProducts.addCell(NameProBuy);
                contentProducts.addCell(amountProBuy);
                contentProducts.addCell(priceProBut);
                contentProducts.addCell(totalPurchase);
            }
            docTemp.add(contentProducts);
        } catch (Exception ex) {
            System.out.println("Generate information Products error ");
            ex.printStackTrace();
        }
    }

    // THIS METHOD GENERATE THE FOOT OF TICKER (TotalBuy, signature,message)
    private void generateTicketFoot() {
        try {

            // I GENRATE THE MONE AMOUNT TO PAY
            Paragraph contentTotalPay = new Paragraph();
            contentTotalPay.add(Chunk.NEWLINE);
            contentTotalPay.add("Total to pay " + system.lblTotaBuy.getText());
            contentTotalPay.setAlignment(Element.ALIGN_RIGHT);
            docTemp.add(contentTotalPay);

            // I GENERATE THE SIGNATURE
            Paragraph contentSignature = new Paragraph();
            contentSignature.add(Chunk.NEWLINE);
            contentSignature.add("Signature");
            contentSignature.add(Chunk.NEWLINE);
            contentSignature.add(Chunk.NEWLINE);
            contentSignature.add(Chunk.NEWLINE);
            contentSignature.add(Chunk.NEWLINE);
            contentSignature.add(Chunk.NEWLINE);
            contentSignature.add(Chunk.NEWLINE);
            contentSignature.add("--------------------------");
            contentSignature.setAlignment(Element.ALIGN_CENTER);
            docTemp.add(contentSignature);

            // I GENERATE MESSAGE 
            Paragraph contentMessage = new Paragraph();
            contentMessage.add(Chunk.NEWLINE);
            contentMessage.add("Thank you for your purchase");
            contentMessage.setAlignment(Element.ALIGN_CENTER);
            docTemp.add(contentMessage);
            docTemp.close();
            Desktop.getDesktop().open(fileImput); // Open automatically the pdf in this Path

        } catch (DocumentException ex) {
            System.out.println("Error to generate the foot of ticker");
            ex.printStackTrace();

        } catch (IOException ex) {
            Logger.getLogger(SolePDF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // I recolected the information about the cliente that will buy the products
    private ResultSet generateResultCustomer() {
        try {
            final String sqlQuery = "SELECT c.DniCustomer,c.NameCustomer,c.TelephoneCustomer,c.AddresCustomer,cl.Clave"
                    + "  FROM Customers as c  JOIN Latam as cl ON c.IdClave = cl.IdClave  WHERE DniCustomer = (?) ";
            ps = con.prepareStatement(sqlQuery);
            ps.setString(1, system.txtDniNew.getText());
            res = ps.executeQuery();
            return res;
        } catch (SQLException e) {
            System.out.println("Error generateTicket  ");
            e.printStackTrace();
        }
        return null;
    }

    //I clean the fields
    private void cleanTextEmptys() {
        system.btnPrintTicketNew.setEnabled(false);
        system.txtAmountNew.setText("");
        system.txtDescriptionNew.setText("");
        system.txtAvaliableNew.setText("");
        system.txtPriceNew.setText("");
        system.txtCodeNew.setText("");
        system.txtDniCust.setText("");
        system.txtNameNew.setText("");
        system.txtDniNew.setText("");
        system.txtDniNew.setEnabled(false);
        system.lblTotaBuy.setText("0.0");
        system.txtCodeNew.requestFocus(); // I left the interface as if I had cacelled the purchase of this produc
        DefaultTableModel model = (DefaultTableModel) system.tbNewSoles.getModel(); // I clean the products bought previously
        model.setRowCount(0);
    }

    // I recolected the info the company 
    private ResultSet generateInfoCompany() {
        try {
            final String sqlQuery = "SELECT * FROM Company";
            ps = con.prepareStatement(sqlQuery);
            res = ps.executeQuery();
            return res;
        } catch (SQLException ex) {
            Logger.getLogger(SolePDF.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private int IdSoleDepends() {
        try {
            String sqlQuery = "SELECT MAX(IdSole) as LAST_SALE FROM Sales";
            ps = con.prepareStatement(sqlQuery);
            res = ps.executeQuery();
            if (res.next()) {

                return res.getInt("LAST_SALE");
            }
        } catch (SQLException e) {
            System.out.println("Error Combo ");
            e.printStackTrace();
            return 0;
        }
        return 0;
    }
}
