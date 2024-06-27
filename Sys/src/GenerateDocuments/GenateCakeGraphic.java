/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GenerateDocuments;

import SolesMethods.MethodTem;
import View.SystemMain;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author GAMER
 */
public class GenateCakeGraphic extends Controller.Conexion {

    private final Connection con;
    private ResultSet res;
    private final SystemMain system;
    private CallableStatement call;
    private DefaultComboBoxModel cbxModel;

    public GenateCakeGraphic(SystemMain system) {
        this.con = establihsConnection();
        this.system = system;
    }

    // This method will work according your selection
    public void chooseYourOption() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setPreferredSize(new Dimension(200, 100)); // Establecer el tamaño deseado
        panel.add(new JLabel("You wish to know the porcentage of sales per specific date "
                + "\n by a date range:"));
        Object[] options = {"Per specific date ", "By a date range"};
        // I generate a small window to you chosee your view about porcentage of SALES
        int result = JOptionPane.showOptionDialog(
                null, panel,
                "Diálogo de Confirmación Personalizado",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options,
                options[0]);

        if (result == JOptionPane.OK_OPTION) {
            calculateByDateSpecific();
        } else {
            calculateDateRange();
        }
    }

    // This method works to receive the date and sent the method will make the graphic
    private void calculateByDateSpecific() {
        try {
            SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd"); // I establish the format that the dates will have 
            JPanel panel = new JPanel();
            panel.setLayout(new BorderLayout());
            panel.setPreferredSize(new Dimension(100, 40)); // Establecer el tamaño deseado
            JDateChooser dateChooser = new JDateChooser();
            panel.add(dateChooser);
            do {
                JOptionPane.showInternalMessageDialog(null, panel, "Chosse your date ", JOptionPane.INFORMATION_MESSAGE);
            } while (!Optional.ofNullable(dateChooser.getDate()).isPresent());
            generateGraphicByDate(convertDate(dateChooser));
        } catch (Exception ex) {
            System.out.println("Error panel By date specific ");
            Logger.getLogger(GenateCakeGraphic.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // This method works by creating a graph according to a specific date
    private void generateGraphicByDate(final Date dateSelected) {
        try {
            final String callSql = "{CALL Select_ByDate (?)}";
            call = con.prepareCall(callSql);
            call.setDate(1, dateSelected);
            res = call.executeQuery();
            DefaultPieDataset generateCake = new DefaultPieDataset(); //This class allow me to create cake graphics
            while (res.next()) {
                generateCake.setValue(res.getString("IdSole"), res.getFloat("Total")); // I add a new value in the graphics, firs value is a KEY , second value is the value that it´ll representr in the graphics
            }
            JFreeChart screenGraphics = ChartFactory.createPieChart("Report of Sales a specific date", generateCake); // I create the graphic final
            ChartFrame frame = new ChartFrame("SOLES GENERATES", screenGraphics); // I create a new Frame to show the GRAPHIC
            frame.setSize(1000, 500);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        } catch (SQLException ex) {
            System.out.println("Generate the Graphic per a specific date");
            Logger.getLogger(GenateCakeGraphic.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // This method works by creating a graph according a date range
    private void calculateDateRange() {
        try {
            JPanel panel = new JPanel();
            JDateChooser dateChooser = new JDateChooser();
            JDateChooser dateChooser2 = new JDateChooser();
            panel.add(dateChooser);
            panel.add(dateChooser2);
            do {
                // Check the dates arent null
                JOptionPane.showInternalMessageDialog(null, panel, "Chosse yours date to query ", JOptionPane.INFORMATION_MESSAGE); // I Can put the panel inside a message 
            } while (!Optional.ofNullable(dateChooser.getDate()).isPresent() || !Optional.ofNullable(dateChooser2.getDate()).isPresent());
            generateGraphicByRange(convertDate(dateChooser), convertDate(dateChooser2));
        } catch (Exception e) {
            System.out.println("Error panel By date specific ");
            Logger.getLogger(GenateCakeGraphic.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    private void generateGraphicByRange(final Date dateSelected, final Date dateSelected2) {
        try {
            final String callSql = "{CALL Select_ByRangeDate (?,?)}";
            call = con.prepareCall(callSql);
            call.setDate(1, dateSelected);
            call.setDate(2, dateSelected2);
            res = call.executeQuery();
            DefaultPieDataset generateCake = new DefaultPieDataset(); //This class allow me to create cake graphics
            while (res.next()) {
                generateCake.setValue(res.getString("IdSole"), res.getFloat("Total")); // I add a new value in the graphics, firs value is a KEY , second value is the value that it´ll representr in the graphics
            }
            JFreeChart screenGraphics = ChartFactory.createPieChart("Report of Sales a date range", generateCake); // I create the graphic final
            ChartFrame frame = new ChartFrame("SOLES GENERATES", screenGraphics); // I create a new Frame to show the GRAPHIC
            frame.setSize(1000, 500);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        } catch (SQLException ex) {
            System.out.println("Error genrate the grafich per date range");
            Logger.getLogger(GenateCakeGraphic.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    // This method convert the date in SQL formatte 
    private  java.sql.Date convertDate(JDateChooser dateChooser) {
        try {

            String dateSelected1 = new SimpleDateFormat("yyyy-MM-dd").format(dateChooser.getDate());
            java.util.Date utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateSelected1);
            java.sql.Date dateCorrect = new java.sql.Date(utilDate.getTime());
            return dateCorrect;
        } catch (ParseException ex) {
            Logger.getLogger(GenateCakeGraphic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
