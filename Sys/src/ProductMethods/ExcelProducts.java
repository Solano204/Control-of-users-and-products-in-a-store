package ProductMethods;

import Entities.Product;
import View.SystemMain;
import com.sun.security.ntlm.Client;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelProducts extends Controller.Conexion {

    // The colums  start in index 0  and row in index 1
    private final Workbook bookToWrite;
    private final Sheet sheetCurrent;
    private InputStream logo;
    private final Connection con;
    private ResultSet res;
    private SystemMain system;
    private CallableStatement ps;

    public ExcelProducts() {
        con = establihsConnection();
        this.bookToWrite = new XSSFWorkbook();
        this.sheetCurrent = bookToWrite.createSheet(" PRODUCTS ");
    }

    public void createExcel() {
        createIcon();
        createTitleGeneral();
        createTitles();
        createContent();
        createPathFile();
    }

    private void createContent() {

        try {
            final String querySql = "{CALL Select_Product}"; // I call the PA
            ps = con.prepareCall(querySql);
            res = ps.executeQuery();
            int numColumn = res.getMetaData().getColumnCount(); // I get the number of columns
            int rowCurrent = 5; // I define the row , when it´ll start to insert data
            // Create the design from the records
            CellStyle recordStyle = bookToWrite.createCellStyle();
            recordStyle.setBorderBottom(BorderStyle.THIN);
            recordStyle.setBorderLeft(BorderStyle.THIN);
            recordStyle.setBorderRight(BorderStyle.THIN);
            recordStyle.setBorderBottom(BorderStyle.THIN);

            // Im about fill the excel with data
            while (res.next()) {
                Row recordCurrent = sheetCurrent.createRow(rowCurrent);
                for (int i = 0; i < numColumn; i++) { // Advance a new Column to fill in the excel
                    Cell dataCell = recordCurrent.createCell(i);
                    dataCell.setCellStyle(recordStyle);
                    dataCell.setCellValue(res.getString(i + 1)); // I´ll ger each column every time it avance a new itereations in a internal loops
                }
                rowCurrent++; // I advance a new row to write
            }

            // Automatically adjusts the content of each coumns to its content
            sheetCurrent.autoSizeColumn(0);
            sheetCurrent.autoSizeColumn(1);
            sheetCurrent.autoSizeColumn(2);
            sheetCurrent.autoSizeColumn(3);
            sheetCurrent.autoSizeColumn(4);
            sheetCurrent.autoSizeColumn(5);
            sheetCurrent.autoSizeColumn(6);

        } catch (SQLException e) {
            System.out.println("Error excel content");
            e.printStackTrace();
        }
    }

    // CREATE A IMAGE IN THE EXCEL
    private void createIcon() {
        try {
            try {
                InputStream logoTem = new FileInputStream("C:\\CarreraInge\\NetBeansProjects\\Sys\\src\\Images\\producto_1.png");
                logo = logoTem;
            } catch (Exception e) {
            }
            byte[] bytes = IOUtils.toByteArray(logo); // it serves me to get the byte INPUT DOCUMENT
            int dniImage = bookToWrite.addPicture(bytes, Workbook.PICTURE_TYPE_PNG); // I create a new images, but get the image id to indetify it, and it makes it easy for me to put in anywhere
            logo.close();

            CreationHelper helpModify = bookToWrite.getCreationHelper(); // Its a method that allows me to create several object according of a file (Images,cells,columns,rows)
            Drawing drawingGriphics = sheetCurrent.createDrawingPatriarch(); // Is a class that allows me to create graphics or Picture
            ClientAnchor measureGraphics = helpModify.createClientAnchor(); // Its an object that allows me to control the pocisition and size from a graph,it also specifies the column where it´ll start and where end
            measureGraphics.setCol1(0);// I Define the cell it´ll start
            measureGraphics.setRow1(1);// I Define the cell it´ll end   
            Picture picturee = drawingGriphics.createPicture(measureGraphics, dniImage); // Object help me to modify the measures units(Width,Height)
            picturee.resize(1, 3); // I define the (Width ,Highter)
        } catch (IOException e) {
            System.out.println("Excel image ");
            e.printStackTrace();
        }
    }

    // CREATE TITLE GENERAL OF MY BOOK 
    private void createTitleGeneral() {
        try {
            
        // DESIGN THE TITLE GENERAL
        // Create the cells style
        CellStyle titleGeneralStyle = bookToWrite.createCellStyle();// Its a type of cell that allows me to control the design and apply it to any cell so that they have the same design or style
        titleGeneralStyle.setAlignment(HorizontalAlignment.CENTER);
        titleGeneralStyle.setVerticalAlignment(VerticalAlignment.CENTER);

        // Create the font 
        Font fontTitleGeneral = bookToWrite.createFont();
        fontTitleGeneral.setFontName("Arial");
        fontTitleGeneral.setBold(true);
        fontTitleGeneral.setFontHeightInPoints((short) 14);
        titleGeneralStyle.setFont(fontTitleGeneral); // I assigned the resource

        // DESIGN THE TITLES FIELDS
        // Create the TITLE ROWS 
        Row titlesRow = sheetCurrent.createRow(1); // I define the row it´ll be
        Cell titlesCell = titlesRow.createCell(1); // I create a new cell in the row current
        titlesCell.setCellStyle(titleGeneralStyle); // I assigned the style in that cell
        titlesCell.setCellValue("PRODUCTS REPORT");
        } catch (Exception e) {
            System.out.println("Error create Title General");
            e.printStackTrace();
        }
    }

    private void createTitles() {
        try {
            
        // DESIGN THE TITLES FIELDS
        // Create the TITLE ROWS 
        sheetCurrent.addMergedRegion(new CellRangeAddress(1, 2, 1, 5)); // Add the columns where I specify the places to occupy (Inital Row,End Row, Initial Cell, End Cell)

        // I define the new styleCell that I Control the BORDER of each column
        CellStyle titleStyle = bookToWrite.createCellStyle();
        titleStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
        titleStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        titleStyle.setBorderBottom(BorderStyle.THIN);
        titleStyle.setBorderLeft(BorderStyle.THIN);
        titleStyle.setBorderRight(BorderStyle.THIN);
        titleStyle.setBorderBottom(BorderStyle.THIN);

        // I define the font 
        Font fontTitles = bookToWrite.createFont();
        fontTitles.setFontName("Arial");
        fontTitles.setBold(true);
        fontTitles.setColor(IndexedColors.WHITE.getIndex());
        fontTitles.setFontHeightInPoints((short)14);
        titleStyle.setFont(fontTitles);

        String[] titlesArray = {"CodeProduct", "NameProduct", "StockAvailable", "Price", "CodeProvider","DateRegister","NameProvider"}; // Titles from fields
        Row rowCurrent = sheetCurrent.createRow(4); // I create a new row in the index 4 , there I start

        for (int i = 0; i < titlesArray.length; i++) {
            Cell titleCurrent = rowCurrent.createCell(i); // I create a cell in the row current
            titleCurrent.setCellStyle(titleStyle);
            titleCurrent.setCellValue(titlesArray[i]);
        }
        } catch (Exception e) {
            System.out.println("Error createTitles");
            e.printStackTrace();
        }

    }

    private void createPathFile() {
        sheetCurrent.setZoom(150); // I adjust the size of the sheet
        final String fileName = "Products";
        String home = System.getProperty("user.Home");
        try {
            File file = new File("ProductsList.xlsx");
            FileOutputStream destinationFile = new FileOutputStream(file);
            bookToWrite.write(destinationFile); // I write the content from book in the OUTPUTFILE
            bookToWrite.close();
            Desktop.getDesktop().open(file);
            JOptionPane.showMessageDialog(null, " EXCEL GENERATED");
        } catch (IOException e) {
            System.out.println("Error destination path");
            e.printStackTrace();
        }
    }
}
