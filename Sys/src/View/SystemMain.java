package View;

import CustomerMethods.FillTableCustomer;
import Validations.validateCode;
import Validations.ValidationsNumber;
import Validations.ValidationsName;
import Validations.ValidatePrice;
import Validations.ValidateAmount;
import CustomerMethods.DeleteCustomer;
import CustomerMethods.ExitsCustomer;
import CustomerMethods.PrintCustomer;
import CustomerMethods.UpdateCustomer;
import CustomerMethods.RegisterCustomer;
import GenerateDocuments.GenateCakeGraphic;
import ProductMethods.CbxProviders;
import ProductMethods.DeleteProducts;
import ProductMethods.ExcelProducts;
import ProductMethods.FillTableProducts;
import ProductMethods.PrintProducts;
import ProductMethods.ProvTemp;
import ProductMethods.RegisterProduct;
import ProductMethods.UpdateProduct;
import ProvidersMethods.DeleteProviders;
import ProvidersMethods.FillTableProviders;
import ProvidersMethods.PrintProviders;
import ProvidersMethods.RegisterProviders;
import ProvidersMethods.UpdateProviders;
import SolesMethods.CancelBuy;
import SolesMethods.DeletProSole;
import SolesMethods.ExistCustomer;
import SolesMethods.FillCbxPayment;
import SolesMethods.FillTextProduct;
import SolesMethods.MethodTem;
import SolesMethods.ProductsTable;
import SolesMethods.RegisterSalesDetails;
import SolesMethods.RegisterSole;
import GenerateDocuments.SolePDF;
import SolesAndDetails.FillTableSoles;
import SolesAndDetails.ObtainPDFSole;
import UserMethods.DeleteUsers;
import UserMethods.ExitsUser;
import UserMethods.FillTableUser;
import UserMethods.LoginUser;
import UserMethods.PrintUsers;
import UserMethods.RegisterUser;
import UserMethods.UpdateUser;
import Validations.ValidateEmail;
import Validations.ValidatePassWord;
import com.itextpdf.text.DocumentException;
import java.awt.event.KeyEvent;
import java.awt.event.WindowListener;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.util.calendar.CalendarUtils;

public class SystemMain extends javax.swing.JFrame {

    private final DeleteUsers deleteEmpl;
    private final FillTableUser fillTextEmpl;
    private final PrintUsers printEmpl;
    private final RegisterUser registerEmpl;
    private final UpdateUser updateEmpl;
    private final ValidationsName validationName;
    private final ValidationsNumber validationNumber;
    private final validateCode validationCode;
    private final ValidatePrice validatePrice;
    private final ValidateAmount validateAmount;
    private final RegisterCustomer registerUser;
    private final PrintCustomer printUsers;
    private final DeleteCustomer deleteUsers;
    private final FillCbx fillCombox;
    private final FillTableCustomer fillTable;
    private final UpdateCustomer updateUser;
    private final RegisterProviders registerProv;
    private final DeleteProviders deleteProv;
    private final FillTableProviders fillTableProv;
    private final PrintProviders printProv;
    private final UpdateProviders updateProv;
    private final RegisterProduct registerProd;
    private final CbxProviders fillCbxProvProd;
    private final DeleteProducts deleteProd;
    private final FillTableProducts fillProd;
    private final UpdateProduct updateProd;
    private final PrintProducts printProd;
    private final ExcelProducts createExcelPro;
    private final FillTextProduct fillTextView;
    private final CancelBuy cancelBuy;
    private final ProductsTable fillTableSoles;
    private final DeletProSole deletProTableSelected;
    private final ExistCustomer exitsCustomerSoles;
    private final FillCbxPayment fillCbxPayment;
    private final InformationCompany fillTextCompany;
    private SolePDF generatePdfSole;
    private final RegisterSole registerSole;
    private final RegisterSalesDetails registerDetails;
    private final FillTableSoles fillTableSolesMade;
    private final ObtainPDFSole obtainPdfSelectSole;
    private final GenateCakeGraphic generateCakeGraphic;
    private final ValidatePassWord validatePass;
    private final ValidateEmail validateEmail;
    private LoginUser loginHome;

    public SystemMain(LoginUser loginHome) {
        this.loginHome = loginHome;
        initComponents();
        Thread.ofVirtual().start(() -> coverItems());
        try {
            generatePdfSole = new SolePDF(this);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SystemMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(SystemMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        fillTextEmpl = new FillTableUser(this);
        deleteEmpl = new DeleteUsers(this);
        printEmpl = new PrintUsers(this);
        registerEmpl = new RegisterUser(this);
        updateEmpl = new UpdateUser(this);
        generateCakeGraphic = new GenateCakeGraphic(this);
        fillTableSolesMade = new FillTableSoles(this);
        obtainPdfSelectSole = new ObtainPDFSole(this);
        registerUser = new RegisterCustomer(this);
        validationName = new ValidationsName(this);
        validationNumber = new ValidationsNumber(this);
        validationCode = new validateCode(this);
        validatePrice = new ValidatePrice(this);
        validateAmount = new ValidateAmount(this);
        validatePass = new ValidatePassWord(this);
        validateEmail = new ValidateEmail(this);
        fillCombox = new FillCbx(this);
        printUsers = new PrintCustomer(this);
        deleteUsers = new DeleteCustomer(this);
        fillTable = new FillTableCustomer(this);
        updateUser = new UpdateCustomer(this);
        registerProv = new RegisterProviders(this);
        deleteProv = new DeleteProviders(this);
        fillTableProv = new FillTableProviders(this);
        printProv = new PrintProviders(this);
        updateProv = new UpdateProviders(this);
        registerProd = new RegisterProduct(this);
        fillCbxProvProd = new CbxProviders(this);
        deleteProd = new DeleteProducts(this);
        fillProd = new FillTableProducts(this);
        updateProd = new UpdateProduct(this);
        printProd = new PrintProducts(this);
        createExcelPro = new ExcelProducts();
        fillTextView = new FillTextProduct(this);
        cancelBuy = new CancelBuy(this);
        fillTableSoles = new ProductsTable(this);
        deletProTableSelected = new DeletProSole(this);
        exitsCustomerSoles = new ExistCustomer(this);
        fillCbxPayment = new FillCbxPayment(this);
        fillTextCompany = new InformationCompany(this);
        registerSole = new RegisterSole(this);
        registerDetails = new RegisterSalesDetails(this);
        validations();
    }

    private void validations() {
        fillTextCompany.fillInformation();
        Thread.ofVirtual().start(() -> validationName.initConditions());
        Thread.ofVirtual().start(() -> validationCode.initComponents());
        Thread.ofVirtual().start(() -> validationNumber.initComponents());
        Thread.ofVirtual().start(() -> validateAmount.initComponents());
        Thread.ofVirtual().start(() -> validatePrice.initComponents());
        Thread.ofVirtual().start(() -> validatePass.initCondition());
        Thread.ofVirtual().start(() -> validateEmail.initComponents());
    }

    // The method serve to desactive the elements in that I dont need without selecting a record, and then they are actived by pressing a record form the table,
    // these elements are updated, delete and cancel, this process helps me avoid errors
    private void coverItems() {
        btnCancelEmpl.setVisible(false);
        lblCancelEmpl.setVisible(false);
        btnUpdUser.setVisible(false);
        btnDeleteUser.setVisible(false);
        btnPdfSoles.setEnabled(false);
        btnPrintTicketNew.setEnabled(false);
        txtNameNew.setEnabled(false);
        txtDniNew.setEnabled(false);
        txtDescriptionNew.setEnabled(false);
        txtAmountNew.setEnabled(false);
        txtAvaliableNew.setEnabled(false);
        btnCancelCust.setVisible(false);
        lblCancelCust.setVisible(false);
        btnCancelProd.setVisible(false);
        lblCancelProd.setVisible(false);
        btnCancelProv.setVisible(false);
        lblCancelProv.setVisible(false);
        btnDeleteCus.setVisible(false);
        btnDeleteProd.setVisible(false);
        btnDeleteProv.setVisible(false);
        btnUpdCus.setVisible(false);
        btnUpdProd.setVisible(false);
        btnUpdProv.setVisible(false);
        btnCancelBuy.setVisible(false);
        lblCancelBuy.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnNewSale = new javax.swing.JButton();
        btnCustomers = new javax.swing.JButton();
        btnProvider = new javax.swing.JButton();
        btnProduct = new javax.swing.JButton();
        btnSales = new javax.swing.JButton();
        btnSetting = new javax.swing.JButton();
        btnEployess = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        ViewCompany = new javax.swing.JTabbedPane();
        viewNewSoles = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCodeNew = new javax.swing.JTextField();
        txtAmountNew = new javax.swing.JTextField();
        txtDescriptionNew = new javax.swing.JTextField();
        txtPriceNew = new javax.swing.JTextField();
        txtAvaliableNew = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbNewSoles = new javax.swing.JTable();
        b = new javax.swing.JLabel();
        txtDniNew = new javax.swing.JTextField();
        s = new javax.swing.JLabel();
        txtNameNew = new javax.swing.JTextField();
        lblTotaBuy = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblCancelBuy = new javax.swing.JLabel();
        btnCancelBuy = new javax.swing.JButton();
        cbxPayments = new javax.swing.JComboBox<>();
        s1 = new javax.swing.JLabel();
        btnPrintTicketNew = new javax.swing.JButton();
        viewCustomer = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbCustomers = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtDniCust = new javax.swing.JTextField();
        txtNameCus = new javax.swing.JTextField();
        txtTeleCust = new javax.swing.JTextField();
        txtAddressCust = new javax.swing.JTextField();
        btnSaveCus = new javax.swing.JButton();
        btnUpdCus = new javax.swing.JButton();
        btnDeleteCus = new javax.swing.JButton();
        btnNewCus = new javax.swing.JButton();
        cbxClaves = new javax.swing.JComboBox<>();
        btnCancelCust = new javax.swing.JButton();
        lblCancelCust = new javax.swing.JLabel();
        viewProvider = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbProviders = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtDniProv = new javax.swing.JTextField();
        TxtNameProv = new javax.swing.JTextField();
        txtTeleProv = new javax.swing.JTextField();
        txtAddressProv = new javax.swing.JTextField();
        btnSaveProv = new javax.swing.JButton();
        btnUpdProv = new javax.swing.JButton();
        btnDeleteProv = new javax.swing.JButton();
        btnNewProv = new javax.swing.JButton();
        cbxClavesPro = new javax.swing.JComboBox<>();
        btnCancelProv = new javax.swing.JButton();
        lblCancelProv = new javax.swing.JLabel();
        viewProducts = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbProducts = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtCodePro = new javax.swing.JTextField();
        txtNamePro = new javax.swing.JTextField();
        txtStockProd = new javax.swing.JTextField();
        txtPricePro = new javax.swing.JTextField();
        btnSaveProd = new javax.swing.JButton();
        btnUpdProd = new javax.swing.JButton();
        btnDeleteProd = new javax.swing.JButton();
        btnNewProd = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        btnExcelPro = new javax.swing.JButton();
        btnCancelProd = new javax.swing.JButton();
        lblCancelProd = new javax.swing.JLabel();
        cbxProvProd = new javax.swing.JComboBox<>();
        Employees = new javax.swing.JPanel();
        txtIdUser = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        txtNameUser = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        txtTeleEmpl = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        txtEmailEmpl = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        btnSaveUser = new javax.swing.JButton();
        btnUpdUser = new javax.swing.JButton();
        btnDeleteUser = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbEmployess = new javax.swing.JTable();
        PassWordUser = new javax.swing.JPasswordField();
        cbxEmpTel = new javax.swing.JComboBox<>();
        jLabel34 = new javax.swing.JLabel();
        cbxEmpPriv = new javax.swing.JComboBox<>();
        btnCancelEmpl = new javax.swing.JButton();
        lblCancelEmpl = new javax.swing.JLabel();
        btnNewEmpl = new javax.swing.JButton();
        ViewSoles = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbSoles = new javax.swing.JTable();
        btnPdfSoles = new javax.swing.JButton();
        btnGraphicCake = new javax.swing.JButton();
        ViewCompanyData = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txtDniComp = new javax.swing.JTextField();
        txtNameComp = new javax.swing.JTextField();
        txtAddressComp = new javax.swing.JTextField();
        txtBussNameComp = new javax.swing.JTextField();
        txtTeleCom = new javax.swing.JTextField();
        btnUpdComp = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1041, 685));
        setMinimumSize(new java.awt.Dimension(1041, 685));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setForeground(new java.awt.Color(204, 204, 204));

        btnNewSale.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnNewSale.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Nventa_1.png"))); // NOI18N
        btnNewSale.setText("New Sale");
        btnNewSale.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnNewSale.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnNewSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewSaleActionPerformed(evt);
            }
        });

        btnCustomers.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnCustomers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Clientes_1.png"))); // NOI18N
        btnCustomers.setText("Customers");
        btnCustomers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCustomersActionPerformed(evt);
            }
        });

        btnProvider.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnProvider.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/proveedor.png"))); // NOI18N
        btnProvider.setText("Provider");
        btnProvider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProviderActionPerformed(evt);
            }
        });

        btnProduct.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/producto.png"))); // NOI18N
        btnProduct.setText("Product");
        btnProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductActionPerformed(evt);
            }
        });

        btnSales.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnSales.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/compras_1.png"))); // NOI18N
        btnSales.setText("Sales");
        btnSales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalesActionPerformed(evt);
            }
        });

        btnSetting.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnSetting.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/config.png"))); // NOI18N
        btnSetting.setText("Setting");
        btnSetting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSettingActionPerformed(evt);
            }
        });

        btnEployess.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnEployess.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Clientes_1.png"))); // NOI18N
        btnEployess.setText("Employees");
        btnEployess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEployessActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnNewSale, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
            .addComponent(btnCustomers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnProvider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnSales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnSetting, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnEployess, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addComponent(btnNewSale, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCustomers, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnProvider, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEployess, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSales, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSetting, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/encabezado_1.png"))); // NOI18N

        ViewCompany.setBackground(new java.awt.Color(255, 255, 255));
        ViewCompany.setEnabled(false);

        viewNewSoles.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("Amount to buy");

        jLabel3.setText("Code");

        jLabel4.setText("Description");

        jLabel5.setText("Price");

        jLabel6.setText("Stock Available");

        txtCodeNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodeNewActionPerformed(evt);
            }
        });
        txtCodeNew.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodeNewKeyPressed(evt);
            }
        });

        txtAmountNew.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAmountNewKeyPressed(evt);
            }
        });

        txtDescriptionNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescriptionNewActionPerformed(evt);
            }
        });

        txtPriceNew.setToolTipText("");
        txtPriceNew.setEnabled(false);

        tbNewSoles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODE", "NAME PRODUCT", "AMOUNT", "PRICE", "TOTAL"
            }
        ));
        tbNewSoles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbNewSolesMouseClicked(evt);
            }
        });
        tbNewSoles.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbNewSolesKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbNewSoles);

        b.setText("DNI");

        txtDniNew.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDniNewFocusGained(evt);
            }
        });
        txtDniNew.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDniNewKeyPressed(evt);
            }
        });

        s.setText("NAME");

        lblTotaBuy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/money_1.png"))); // NOI18N
        lblTotaBuy.setText("Total to pay");

        jLabel11.setText("****");

        lblCancelBuy.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        lblCancelBuy.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCancelBuy.setText("CANCEL");

        btnCancelBuy.setBackground(new java.awt.Color(255, 255, 255));
        btnCancelBuy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/eliminar.png"))); // NOI18N
        btnCancelBuy.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCancelBuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelBuyActionPerformed(evt);
            }
        });

        cbxPayments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxPaymentsActionPerformed(evt);
            }
        });

        s1.setText("PAYMENT METHOD :");

        btnPrintTicketNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/print_1.png"))); // NOI18N
        btnPrintTicketNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintTicketNewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout viewNewSolesLayout = new javax.swing.GroupLayout(viewNewSoles);
        viewNewSoles.setLayout(viewNewSolesLayout);
        viewNewSolesLayout.setHorizontalGroup(
            viewNewSolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewNewSolesLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(viewNewSolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 849, Short.MAX_VALUE)
                    .addGroup(viewNewSolesLayout.createSequentialGroup()
                        .addGroup(viewNewSolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCodeNew)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(viewNewSolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDescriptionNew)
                            .addGroup(viewNewSolesLayout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(viewNewSolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtAmountNew)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(viewNewSolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                            .addComponent(txtPriceNew))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(viewNewSolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtAvaliableNew)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, viewNewSolesLayout.createSequentialGroup()
                        .addGroup(viewNewSolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(b, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                            .addComponent(txtDniNew))
                        .addGap(74, 74, 74)
                        .addGroup(viewNewSolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(s, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                            .addComponent(txtNameNew))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(viewNewSolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbxPayments, 0, 113, Short.MAX_VALUE)
                            .addComponent(s1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnPrintTicketNew)
                        .addGap(27, 27, 27)
                        .addComponent(lblTotaBuy, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, viewNewSolesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblCancelBuy, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancelBuy, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );
        viewNewSolesLayout.setVerticalGroup(
            viewNewSolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewNewSolesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(viewNewSolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCancelBuy, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCancelBuy))
                .addGap(31, 31, 31)
                .addGroup(viewNewSolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(viewNewSolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodeNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAmountNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescriptionNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPriceNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAvaliableNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(viewNewSolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(viewNewSolesLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(viewNewSolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(viewNewSolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblTotaBuy, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnPrintTicketNew, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)))
                    .addGroup(viewNewSolesLayout.createSequentialGroup()
                        .addGroup(viewNewSolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(b)
                            .addComponent(s)
                            .addComponent(s1))
                        .addGroup(viewNewSolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(viewNewSolesLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(viewNewSolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtDniNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNameNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(viewNewSolesLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(cbxPayments, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        ViewCompany.addTab("New Sole", viewNewSoles);

        viewCustomer.setBackground(new java.awt.Color(255, 255, 255));

        tbCustomers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DNI", "NAME", "TELEPHONE", "ADDRESS", "REGISTER DATE"
            }
        ));
        tbCustomers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbCustomersMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbCustomers);

        jLabel7.setText("DNI :");

        jLabel8.setText("Name:");

        jLabel9.setText("Telephone:");

        jLabel12.setText("Addres:");

        txtDniCust.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDniCustActionPerformed(evt);
            }
        });
        txtDniCust.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDniCustKeyTyped(evt);
            }
        });

        txtTeleCust.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTeleCustActionPerformed(evt);
            }
        });

        btnSaveCus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/GuardarTodo.png"))); // NOI18N
        btnSaveCus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveCusActionPerformed(evt);
            }
        });

        btnUpdCus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Actualizar (2).png"))); // NOI18N
        btnUpdCus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdCusActionPerformed(evt);
            }
        });

        btnDeleteCus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/eliminar.png"))); // NOI18N
        btnDeleteCus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteCusActionPerformed(evt);
            }
        });

        btnNewCus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/nuevo_1.png"))); // NOI18N
        btnNewCus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewCusActionPerformed(evt);
            }
        });

        cbxClaves.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxClavesActionPerformed(evt);
            }
        });

        btnCancelCust.setBackground(new java.awt.Color(255, 255, 153));
        btnCancelCust.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/eliminar.png"))); // NOI18N
        btnCancelCust.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCancelCust.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelCustActionPerformed(evt);
            }
        });

        lblCancelCust.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        lblCancelCust.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCancelCust.setText("CANCEL");

        javax.swing.GroupLayout viewCustomerLayout = new javax.swing.GroupLayout(viewCustomer);
        viewCustomer.setLayout(viewCustomerLayout);
        viewCustomerLayout.setHorizontalGroup(
            viewCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewCustomerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(viewCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(viewCustomerLayout.createSequentialGroup()
                        .addGroup(viewCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(viewCustomerLayout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxClaves, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtTeleCust, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(viewCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(viewCustomerLayout.createSequentialGroup()
                                    .addGroup(viewCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(viewCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtDniCust, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtNameCus, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(39, 39, 39))
                                .addGroup(viewCustomerLayout.createSequentialGroup()
                                    .addGroup(viewCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(btnSaveCus, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(viewCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(viewCustomerLayout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtAddressCust))
                                        .addGroup(viewCustomerLayout.createSequentialGroup()
                                            .addGap(86, 86, 86)
                                            .addComponent(btnUpdCus, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGroup(viewCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(viewCustomerLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane2))
                            .addGroup(viewCustomerLayout.createSequentialGroup()
                                .addGap(200, 200, 200)
                                .addComponent(btnCancelCust, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(viewCustomerLayout.createSequentialGroup()
                        .addComponent(btnDeleteCus, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(88, 88, 88)
                        .addComponent(btnNewCus, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(221, 221, 221)
                        .addComponent(lblCancelCust)
                        .addGap(237, 237, 237)))
                .addGap(67, 67, 67))
        );
        viewCustomerLayout.setVerticalGroup(
            viewCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewCustomerLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(viewCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtDniCust, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(viewCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtNameCus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(viewCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtTeleCust, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxClaves, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(viewCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtAddressCust, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(viewCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSaveCus, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdCus, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(viewCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDeleteCus, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNewCus, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 65, Short.MAX_VALUE))
            .addGroup(viewCustomerLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73)
                .addComponent(btnCancelCust, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblCancelCust, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );

        lblCancelCust.getAccessibleContext().setAccessibleName("CANCEL ");

        ViewCompany.addTab("Customers", viewCustomer);

        viewProvider.setBackground(new java.awt.Color(255, 255, 255));

        tbProviders.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DNI", "NAME", "TELEPHONE", "COUNTRY", "REGISTER DATE"
            }
        ));
        tbProviders.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbProvidersMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbProviders);

        jLabel13.setText("DNI :");

        jLabel14.setText("Name:");

        jLabel15.setText("Telephone:");

        jLabel16.setText("Country");

        btnSaveProv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/GuardarTodo.png"))); // NOI18N
        btnSaveProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveProvActionPerformed(evt);
            }
        });

        btnUpdProv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Actualizar (2).png"))); // NOI18N
        btnUpdProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdProvActionPerformed(evt);
            }
        });

        btnDeleteProv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/eliminar.png"))); // NOI18N
        btnDeleteProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteProvActionPerformed(evt);
            }
        });

        btnNewProv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/nuevo_1.png"))); // NOI18N
        btnNewProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewProvActionPerformed(evt);
            }
        });

        cbxClavesPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxClavesProActionPerformed(evt);
            }
        });

        btnCancelProv.setBackground(new java.awt.Color(255, 255, 153));
        btnCancelProv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/eliminar.png"))); // NOI18N
        btnCancelProv.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCancelProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelProvActionPerformed(evt);
            }
        });

        lblCancelProv.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        lblCancelProv.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCancelProv.setText("CANCEL");

        javax.swing.GroupLayout viewProviderLayout = new javax.swing.GroupLayout(viewProvider);
        viewProvider.setLayout(viewProviderLayout);
        viewProviderLayout.setHorizontalGroup(
            viewProviderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewProviderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(viewProviderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, viewProviderLayout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAddressProv, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, viewProviderLayout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbxClavesPro, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTeleProv, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, viewProviderLayout.createSequentialGroup()
                        .addGroup(viewProviderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(viewProviderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDniProv, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtNameProv, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
                .addGap(28, 28, 28))
            .addGroup(viewProviderLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(viewProviderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(viewProviderLayout.createSequentialGroup()
                        .addComponent(btnDeleteProv, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnNewProv, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(viewProviderLayout.createSequentialGroup()
                        .addComponent(btnSaveProv, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(btnUpdProv, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(viewProviderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(viewProviderLayout.createSequentialGroup()
                        .addGap(263, 263, 263)
                        .addComponent(btnCancelProv, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(viewProviderLayout.createSequentialGroup()
                        .addGap(242, 242, 242)
                        .addComponent(lblCancelProv, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(263, Short.MAX_VALUE))
        );
        viewProviderLayout.setVerticalGroup(
            viewProviderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewProviderLayout.createSequentialGroup()
                .addGroup(viewProviderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(viewProviderLayout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addGroup(viewProviderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txtDniProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(viewProviderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(TxtNameProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(viewProviderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(txtTeleProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxClavesPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(viewProviderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel16)
                            .addComponent(txtAddressProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(78, 78, 78)
                        .addGroup(viewProviderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSaveProv, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUpdProv, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(viewProviderLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelProv, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(viewProviderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(viewProviderLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(viewProviderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnDeleteProv, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNewProv, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(viewProviderLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCancelProv)))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        ViewCompany.addTab("Providers", viewProvider);

        viewProducts.setBackground(new java.awt.Color(255, 255, 255));

        tbProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODE", "NAME", "STOCK AVAILABLE", "PRICE", "PROVIDER", "REGISTER DATE"
            }
        ));
        tbProducts.setEnabled(false);
        tbProducts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbProductsMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbProducts);

        jLabel17.setText("Code:");

        jLabel18.setText("Name:");

        jLabel19.setText("Stock Available");

        jLabel20.setText("Price");

        btnSaveProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/GuardarTodo.png"))); // NOI18N
        btnSaveProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveProdActionPerformed(evt);
            }
        });

        btnUpdProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Actualizar (2).png"))); // NOI18N
        btnUpdProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdProdActionPerformed(evt);
            }
        });

        btnDeleteProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/eliminar.png"))); // NOI18N
        btnDeleteProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteProdActionPerformed(evt);
            }
        });

        btnNewProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/nuevo_1.png"))); // NOI18N
        btnNewProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewProdActionPerformed(evt);
            }
        });

        jLabel21.setText("Provider");

        btnExcelPro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/excel.png"))); // NOI18N
        btnExcelPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcelProActionPerformed(evt);
            }
        });

        btnCancelProd.setBackground(new java.awt.Color(255, 255, 153));
        btnCancelProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/eliminar.png"))); // NOI18N
        btnCancelProd.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCancelProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelProdActionPerformed(evt);
            }
        });

        lblCancelProd.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        lblCancelProd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCancelProd.setText("CANCEL");

        javax.swing.GroupLayout viewProductsLayout = new javax.swing.GroupLayout(viewProducts);
        viewProducts.setLayout(viewProductsLayout);
        viewProductsLayout.setHorizontalGroup(
            viewProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewProductsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(viewProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, viewProductsLayout.createSequentialGroup()
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtStockProd))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, viewProductsLayout.createSequentialGroup()
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNamePro))
                    .addGroup(viewProductsLayout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCodePro, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(viewProductsLayout.createSequentialGroup()
                        .addGroup(viewProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(viewProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxProvProd, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtPricePro))))
                .addGap(38, 38, 38)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
                .addGap(59, 59, 59))
            .addGroup(viewProductsLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(viewProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(viewProductsLayout.createSequentialGroup()
                        .addComponent(btnDeleteProd, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnNewProd, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(viewProductsLayout.createSequentialGroup()
                        .addComponent(btnSaveProd, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(btnUpdProd, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(37, 37, 37)
                .addComponent(btnExcelPro, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(viewProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(viewProductsLayout.createSequentialGroup()
                        .addGap(169, 169, 169)
                        .addComponent(btnCancelProd, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(viewProductsLayout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(lblCancelProd)))
                .addContainerGap(289, Short.MAX_VALUE))
        );
        viewProductsLayout.setVerticalGroup(
            viewProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewProductsLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(viewProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(viewProductsLayout.createSequentialGroup()
                        .addGroup(viewProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(txtCodePro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(viewProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(txtNamePro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(viewProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(txtStockProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(viewProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(txtPricePro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(viewProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(cbxProvProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(viewProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(viewProductsLayout.createSequentialGroup()
                        .addGroup(viewProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnSaveProd, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                            .addComponent(btnUpdProd, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                            .addComponent(btnExcelPro, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE))
                        .addGap(29, 29, 29)
                        .addGroup(viewProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnDeleteProd, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNewProd, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(viewProductsLayout.createSequentialGroup()
                        .addComponent(btnCancelProd, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCancelProd, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        ViewCompany.addTab("Products", viewProducts);

        jLabel28.setText("IdUser");

        jLabel29.setText("PassWord");

        jLabel30.setText("Name");

        jLabel31.setText("Telephone");

        jLabel32.setText("Email");

        btnSaveUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/GuardarTodo.png"))); // NOI18N
        btnSaveUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveUserActionPerformed(evt);
            }
        });

        btnUpdUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Actualizar (2).png"))); // NOI18N
        btnUpdUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdUserActionPerformed(evt);
            }
        });

        btnDeleteUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/eliminar.png"))); // NOI18N
        btnDeleteUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteUserActionPerformed(evt);
            }
        });

        tbEmployess.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IdUser", "PASSWORD", "TYPE USER", "NAME", "TELEPHONE", "EMAIL", "REGISTER DATE"
            }
        ));
        tbEmployess.setEnabled(false);
        tbEmployess.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbEmployessMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tbEmployess);

        jLabel34.setText("Typé User");

        cbxEmpPriv.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Assistant", "Administrator" }));

        btnCancelEmpl.setBackground(new java.awt.Color(255, 255, 153));
        btnCancelEmpl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/eliminar.png"))); // NOI18N
        btnCancelEmpl.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCancelEmpl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelEmplActionPerformed(evt);
            }
        });

        lblCancelEmpl.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        lblCancelEmpl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCancelEmpl.setText("CANCEL");

        btnNewEmpl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/nuevo_1.png"))); // NOI18N
        btnNewEmpl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewEmplActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout EmployeesLayout = new javax.swing.GroupLayout(Employees);
        Employees.setLayout(EmployeesLayout);
        EmployeesLayout.setHorizontalGroup(
            EmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EmployeesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(EmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EmployeesLayout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(btnSaveUser, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(btnDeleteUser, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(btnUpdUser, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnNewEmpl, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelEmpl, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblCancelEmpl)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(EmployeesLayout.createSequentialGroup()
                        .addGroup(EmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane6)
                            .addGroup(EmployeesLayout.createSequentialGroup()
                                .addGroup(EmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtIdUser, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(EmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(PassWordUser, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(EmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(EmployeesLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(EmployeesLayout.createSequentialGroup()
                                        .addGap(14, 14, 14)
                                        .addComponent(txtNameUser, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(21, 21, 21)
                                        .addGroup(EmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtTeleEmpl, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbxEmpTel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(18, 18, 18)
                                .addGroup(EmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtEmailEmpl, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(EmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbxEmpPriv, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 51, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        EmployeesLayout.setVerticalGroup(
            EmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EmployeesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(EmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(EmployeesLayout.createSequentialGroup()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addGroup(EmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnUpdUser, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSaveUser, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDeleteUser, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNewEmpl, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCancelEmpl, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblCancelEmpl, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(EmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(jLabel29)
                    .addComponent(jLabel30)
                    .addComponent(jLabel31)
                    .addComponent(jLabel32)
                    .addComponent(jLabel34))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(EmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PassWordUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNameUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxEmpTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmailEmpl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxEmpPriv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(txtTeleEmpl, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
        );

        ViewCompany.addTab("Employes", Employees);

        ViewSoles.setBackground(new java.awt.Color(255, 255, 255));

        tbSoles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "CLIENT", "METHODPAY", "TOTAL", "DATE"
            }
        ));
        tbSoles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbSolesMouseClicked(evt);
            }
        });
        tbSoles.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbSolesKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbSolesKeyReleased(evt);
            }
        });
        jScrollPane5.setViewportView(tbSoles);

        btnPdfSoles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/pdf.png"))); // NOI18N
        btnPdfSoles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPdfSolesActionPerformed(evt);
            }
        });

        btnGraphicCake.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/torta_1.png"))); // NOI18N
        btnGraphicCake.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGraphicCakeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ViewSolesLayout = new javax.swing.GroupLayout(ViewSoles);
        ViewSoles.setLayout(ViewSolesLayout);
        ViewSolesLayout.setHorizontalGroup(
            ViewSolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ViewSolesLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(ViewSolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 810, Short.MAX_VALUE)
                    .addGroup(ViewSolesLayout.createSequentialGroup()
                        .addComponent(btnPdfSoles, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnGraphicCake, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        ViewSolesLayout.setVerticalGroup(
            ViewSolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ViewSolesLayout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(ViewSolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnPdfSoles, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGraphicCake, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(127, Short.MAX_VALUE))
        );

        ViewCompany.addTab("Soles", ViewSoles);

        ViewCompanyData.setBackground(new java.awt.Color(255, 255, 255));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel22.setText("DNI");

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel23.setText("ADDRESS");

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel24.setText("NAME");

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel25.setText("BUSSINESS NAME");

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel26.setText("TELEPHONE");

        txtDniComp.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N

        txtNameComp.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N

        txtAddressComp.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N

        txtBussNameComp.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N

        txtTeleCom.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N

        btnUpdComp.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnUpdComp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Actualizar (2).png"))); // NOI18N
        btnUpdComp.setText("UPDATE");
        btnUpdComp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdCompActionPerformed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel27.setText("COMPANY DATA");

        javax.swing.GroupLayout ViewCompanyDataLayout = new javax.swing.GroupLayout(ViewCompanyData);
        ViewCompanyData.setLayout(ViewCompanyDataLayout);
        ViewCompanyDataLayout.setHorizontalGroup(
            ViewCompanyDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ViewCompanyDataLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(ViewCompanyDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ViewCompanyDataLayout.createSequentialGroup()
                        .addGroup(ViewCompanyDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ViewCompanyDataLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(95, 95, 95)
                        .addGroup(ViewCompanyDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(ViewCompanyDataLayout.createSequentialGroup()
                                .addComponent(txtBussNameComp, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(77, 77, 77)
                                .addComponent(btnUpdComp, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(ViewCompanyDataLayout.createSequentialGroup()
                                .addGroup(ViewCompanyDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNameComp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(77, 77, 77)
                                .addGroup(ViewCompanyDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTeleCom, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(ViewCompanyDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtDniComp, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                        .addComponent(txtAddressComp)))
                .addContainerGap(220, Short.MAX_VALUE))
        );
        ViewCompanyDataLayout.setVerticalGroup(
            ViewCompanyDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ViewCompanyDataLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(ViewCompanyDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ViewCompanyDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDniComp, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNameComp, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTeleCom, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(89, 89, 89)
                .addGroup(ViewCompanyDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ViewCompanyDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBussNameComp, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAddressComp, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdComp, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(185, Short.MAX_VALUE))
        );

        ViewCompany.addTab("Company Data", ViewCompanyData);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(180, 180, 180))
                    .addComponent(ViewCompany, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE))
                .addGap(1, 1, 1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(ViewCompany)))
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodeNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodeNewActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodeNewActionPerformed

    private void btnNewSaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewSaleActionPerformed
        ViewCompany.setSelectedIndex(0);
    }//GEN-LAST:event_btnNewSaleActionPerformed

    private void btnNewProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewProvActionPerformed
        deleteProv.cleanText();
    }//GEN-LAST:event_btnNewProvActionPerformed

    private void btnNewProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewProdActionPerformed
        deleteProd.cleanText();
    }//GEN-LAST:event_btnNewProdActionPerformed

    private void btnExcelProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcelProActionPerformed
        createExcelPro.createExcel();
    }//GEN-LAST:event_btnExcelProActionPerformed

    private void txtDescriptionNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescriptionNewActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescriptionNewActionPerformed

    private void txtDniCustActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDniCustActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDniCustActionPerformed

    // This method controls the number of characters and emits a soun when the limit is exceeded
    private void txtDniCustKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniCustKeyTyped

    }//GEN-LAST:event_txtDniCustKeyTyped

    private void cbxClavesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxClavesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxClavesActionPerformed

    private void btnSaveCusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveCusActionPerformed
        registerUser.register();
        printUsers.fillOutTable();
    }//GEN-LAST:event_btnSaveCusActionPerformed

    //Fill the table of clients
    private void btnCustomersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCustomersActionPerformed
        ViewCompany.setSelectedIndex(1);
        printUsers.fillOutTable();
    }//GEN-LAST:event_btnCustomersActionPerformed

    // Delete a client 
    private void btnDeleteCusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteCusActionPerformed
        deleteUsers.deleteCustomer();
        printUsers.fillOutTable();
        btnCancelCustActionPerformed(evt);

    }//GEN-LAST:event_btnDeleteCusActionPerformed

    private void tbCustomersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbCustomersMouseClicked
        btnCancelCust.setVisible(true);
        lblCancelCust.setVisible(true);
        btnUpdCus.setVisible(true);
        btnDeleteCus.setVisible(true);
        btnSaveCus.setVisible(false);
        btnNewCus.setVisible(false);
        fillTable.fillTextField(evt);

    }//GEN-LAST:event_tbCustomersMouseClicked

    private void txtTeleCustActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTeleCustActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTeleCustActionPerformed

    private void btnUpdCusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdCusActionPerformed
        updateUser.modifyUser();
        printUsers.fillOutTable();
        btnCancelCustActionPerformed(evt);
    }//GEN-LAST:event_btnUpdCusActionPerformed

    private void cbxClavesProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxClavesProActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxClavesProActionPerformed

    private void tbProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProductsMouseClicked
        btnCancelProd.setVisible(true);
        lblCancelProd.setVisible(true);
        btnUpdProd.setVisible(true);
        btnDeleteProd.setVisible(true);
        btnSaveProd.setVisible(false);
        btnNewProd.setVisible(false);
        fillProd.fillTextField(evt);
    }//GEN-LAST:event_tbProductsMouseClicked

    private void tbProvidersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProvidersMouseClicked
        btnCancelProv.setVisible(true);
        lblCancelProv.setVisible(true);
        btnUpdProv.setVisible(true);
        btnDeleteProv.setVisible(true);
        btnSaveProv.setVisible(false);
        btnNewProv.setVisible(false);
        fillTableProv.fillTextField(evt);

    }//GEN-LAST:event_tbProvidersMouseClicked

    private void btnSaveProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveProvActionPerformed
        registerProv.register();
        printProv.fillOutTable();
    }//GEN-LAST:event_btnSaveProvActionPerformed

    private void btnUpdProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdProvActionPerformed
        updateProv.modifyUser();
        printProv.fillOutTable();
        btnCancelProvActionPerformed(evt);
    }//GEN-LAST:event_btnUpdProvActionPerformed

    private void btnDeleteProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteProvActionPerformed
        deleteProv.deleteCustomer();
        printProv.fillOutTable();
        btnCancelProvActionPerformed(evt);

    }//GEN-LAST:event_btnDeleteProvActionPerformed

    private void btnProviderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProviderActionPerformed
        ViewCompany.setSelectedIndex(2);
        printProv.fillOutTable();

    }//GEN-LAST:event_btnProviderActionPerformed

    private void btnCancelCustActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelCustActionPerformed
        deleteUsers.cleanText(); // I return to normalcy
        tbCustomers.clearSelection();
        btnCancelCust.setVisible(false);
        lblCancelCust.setVisible(false);
        btnUpdCus.setVisible(false);
        btnDeleteCus.setVisible(false);
        btnSaveCus.setVisible(true);
        btnNewCus.setVisible(true);
    }//GEN-LAST:event_btnCancelCustActionPerformed

    private void btnCancelProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelProvActionPerformed
        deleteProv.cleanText();
        tbProviders.clearSelection();
        btnCancelProv.setVisible(false);
        lblCancelProv.setVisible(false);
        btnUpdProv.setVisible(false);
        btnDeleteProv.setVisible(false);
        btnSaveProv.setVisible(true);
        btnNewProv.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelProvActionPerformed

    private void btnCancelProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelProdActionPerformed
        deleteProd.cleanText();
        tbProducts.clearSelection();
        btnCancelProd.setVisible(false);
        lblCancelProd.setVisible(false);
        btnUpdProd.setVisible(false);
        btnDeleteProd.setVisible(false);
        btnSaveProd.setVisible(true);
        btnNewProd.setVisible(true);
    }//GEN-LAST:event_btnCancelProdActionPerformed

    private void btnProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductActionPerformed
        ViewCompany.setSelectedIndex(3);
        printProd.fillOutTable();
        fillCbxProvProd.fillCombo();
    }//GEN-LAST:event_btnProductActionPerformed

    private void btnSaveProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveProdActionPerformed
        registerProd.register();
        printProd.fillOutTable();
    }//GEN-LAST:event_btnSaveProdActionPerformed

    private void btnDeleteProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteProdActionPerformed
        deleteProd.deleteCustomer();
        printProd.fillOutTable();
        btnCancelProdActionPerformed(evt);


    }//GEN-LAST:event_btnDeleteProdActionPerformed

    private void btnUpdProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdProdActionPerformed
        updateProd.modifyUser();
        printProd.fillOutTable();
        btnCancelProdActionPerformed(evt);
    }//GEN-LAST:event_btnUpdProdActionPerformed

    private void txtCodeNewKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodeNewKeyPressed
        fillTextView.searchProduct(evt);
    }//GEN-LAST:event_txtCodeNewKeyPressed

    private void btnCancelBuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelBuyActionPerformed
        cancelBuy.cancelBuyProduct();
    }//GEN-LAST:event_btnCancelBuyActionPerformed

    private void txtAmountNewKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAmountNewKeyPressed
        fillTableSoles.fillTableBuys(evt);
    }//GEN-LAST:event_txtAmountNewKeyPressed

    private void tbNewSolesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbNewSolesKeyPressed
    }//GEN-LAST:event_tbNewSolesKeyPressed

    private void tbNewSolesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbNewSolesMouseClicked
        deletProTableSelected.deleteProductSelect();
    }//GEN-LAST:event_tbNewSolesMouseClicked

    private void txtDniNewFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDniNewFocusGained

    }//GEN-LAST:event_txtDniNewFocusGained

    private void txtDniNewKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniNewKeyPressed
        exitsCustomerSoles.searchUser(evt);
    }//GEN-LAST:event_txtDniNewKeyPressed

    private void cbxPaymentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxPaymentsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxPaymentsActionPerformed

    private void btnPrintTicketNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintTicketNewActionPerformed
        registerSole.registerSole();
        registerDetails.registerSole();
        generatePdfSole.generatePDF();
        fillTextCompany.fillInformation();
    }//GEN-LAST:event_btnPrintTicketNewActionPerformed

    private void btnSettingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSettingActionPerformed
        ViewCompany.setSelectedIndex(6);
        fillTextCompany.fillInformation();
    }//GEN-LAST:event_btnSettingActionPerformed

    private void btnUpdCompActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdCompActionPerformed
        fillTextCompany.updateInformationCompany();
        fillTextCompany.fillInformation();
    }//GEN-LAST:event_btnUpdCompActionPerformed

    private void btnPdfSolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPdfSolesActionPerformed
        obtainPdfSelectSole.obtainPDFSelectSole();
    }//GEN-LAST:event_btnPdfSolesActionPerformed

    private void tbSolesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbSolesKeyPressed
    }//GEN-LAST:event_tbSolesKeyPressed

    private void tbSolesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbSolesKeyReleased


    }//GEN-LAST:event_tbSolesKeyReleased

    private void btnSalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalesActionPerformed
        ViewCompany.setSelectedIndex(5);
        fillTableSolesMade.fillTableSolesMade();
    }//GEN-LAST:event_btnSalesActionPerformed

    private void tbSolesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSolesMouseClicked
        btnPdfSoles.setEnabled(true);
    }//GEN-LAST:event_tbSolesMouseClicked

    private void btnGraphicCakeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGraphicCakeActionPerformed
        generateCakeGraphic.chooseYourOption();
    }//GEN-LAST:event_btnGraphicCakeActionPerformed

    private void btnSaveUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveUserActionPerformed
        registerEmpl.register();
        printEmpl.fillOutTable();
    }//GEN-LAST:event_btnSaveUserActionPerformed

    private void btnUpdUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdUserActionPerformed
        updateEmpl.modifyUser();
        printEmpl.fillOutTable();
        btnCancelEmplActionPerformed(evt);
    }//GEN-LAST:event_btnUpdUserActionPerformed

    private void btnDeleteUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteUserActionPerformed
        deleteEmpl.deleteCustomer();
        printEmpl.fillOutTable();
        btnCancelEmplActionPerformed(evt);

    }//GEN-LAST:event_btnDeleteUserActionPerformed

    private void tbEmployessMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbEmployessMouseClicked
        btnCancelEmpl.setVisible(true);
        lblCancelEmpl.setVisible(true);
        btnUpdUser.setVisible(true);
        btnDeleteUser.setVisible(true);
        btnSaveUser.setVisible(false);
        btnNewEmpl.setVisible(false);
        fillTextEmpl.fillTextField(evt);
    }//GEN-LAST:event_tbEmployessMouseClicked

    private void btnEployessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEployessActionPerformed
        ViewCompany.setSelectedIndex(4);
        printEmpl.fillOutTable();
    }//GEN-LAST:event_btnEployessActionPerformed

    private void btnCancelEmplActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelEmplActionPerformed
        deleteEmpl.cleanText();
        tbEmployess.clearSelection();
        btnCancelEmpl.setVisible(false);
        lblCancelEmpl.setVisible(false);
        btnUpdUser.setVisible(false);
        btnDeleteUser.setVisible(false);
        btnSaveUser.setVisible(true);
        btnNewEmpl.setVisible(true);
    }//GEN-LAST:event_btnCancelEmplActionPerformed

    private void btnNewEmplActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewEmplActionPerformed
        deleteEmpl.cleanText();
    }//GEN-LAST:event_btnNewEmplActionPerformed

    private void btnNewCusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewCusActionPerformed
        deleteUsers.cleanText();        // TODO add your handling code here:
    }//GEN-LAST:event_btnNewCusActionPerformed

    // This methos is use to control when a window is closing
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
        } catch (Exception ex) {
            Logger.getLogger(SystemMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosing

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        try {
            System.out.println("JSKOAHDFLKHSAD");
        } catch (Exception ex) {
            Logger.getLogger(SystemMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Employees;
    public javax.swing.JPasswordField PassWordUser;
    public javax.swing.JTextField TxtNameProv;
    public javax.swing.JTabbedPane ViewCompany;
    private javax.swing.JPanel ViewCompanyData;
    private javax.swing.JPanel ViewSoles;
    private javax.swing.JLabel b;
    public javax.swing.JButton btnCancelBuy;
    public javax.swing.JButton btnCancelCust;
    public javax.swing.JButton btnCancelEmpl;
    public javax.swing.JButton btnCancelProd;
    public javax.swing.JButton btnCancelProv;
    public javax.swing.JButton btnCustomers;
    public javax.swing.JButton btnDeleteCus;
    public javax.swing.JButton btnDeleteProd;
    public javax.swing.JButton btnDeleteProv;
    public javax.swing.JButton btnDeleteUser;
    public javax.swing.JButton btnEployess;
    public javax.swing.JButton btnExcelPro;
    private javax.swing.JButton btnGraphicCake;
    public javax.swing.JButton btnNewCus;
    public javax.swing.JButton btnNewEmpl;
    public javax.swing.JButton btnNewProd;
    public javax.swing.JButton btnNewProv;
    public javax.swing.JButton btnNewSale;
    public javax.swing.JButton btnPdfSoles;
    public javax.swing.JButton btnPrintTicketNew;
    public javax.swing.JButton btnProduct;
    public javax.swing.JButton btnProvider;
    public javax.swing.JButton btnSales;
    public javax.swing.JButton btnSaveCus;
    public javax.swing.JButton btnSaveProd;
    public javax.swing.JButton btnSaveProv;
    public javax.swing.JButton btnSaveUser;
    public javax.swing.JButton btnSetting;
    public javax.swing.JButton btnUpdComp;
    public javax.swing.JButton btnUpdCus;
    public javax.swing.JButton btnUpdProd;
    public javax.swing.JButton btnUpdProv;
    public javax.swing.JButton btnUpdUser;
    public javax.swing.JComboBox<String> cbxClaves;
    public javax.swing.JComboBox<String> cbxClavesPro;
    public javax.swing.JComboBox<String> cbxEmpPriv;
    public javax.swing.JComboBox<ProvTemp> cbxEmpTel;
    public javax.swing.JComboBox<MethodTem> cbxPayments;
    public javax.swing.JComboBox<ProvTemp> cbxProvProd;
    public javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    public javax.swing.JLabel lblCancelBuy;
    private javax.swing.JLabel lblCancelCust;
    private javax.swing.JLabel lblCancelEmpl;
    private javax.swing.JLabel lblCancelProd;
    private javax.swing.JLabel lblCancelProv;
    public javax.swing.JLabel lblTotaBuy;
    private javax.swing.JLabel s;
    private javax.swing.JLabel s1;
    public javax.swing.JTable tbCustomers;
    public javax.swing.JTable tbEmployess;
    public javax.swing.JTable tbNewSoles;
    public javax.swing.JTable tbProducts;
    public javax.swing.JTable tbProviders;
    public javax.swing.JTable tbSoles;
    public javax.swing.JTextField txtAddressComp;
    public javax.swing.JTextField txtAddressCust;
    public javax.swing.JTextField txtAddressProv;
    public javax.swing.JTextField txtAmountNew;
    public javax.swing.JTextField txtAvaliableNew;
    public javax.swing.JTextField txtBussNameComp;
    public javax.swing.JTextField txtCodeNew;
    public javax.swing.JTextField txtCodePro;
    public javax.swing.JTextField txtDescriptionNew;
    public javax.swing.JTextField txtDniComp;
    public javax.swing.JTextField txtDniCust;
    public javax.swing.JTextField txtDniNew;
    public javax.swing.JTextField txtDniProv;
    public javax.swing.JTextField txtEmailEmpl;
    public javax.swing.JTextField txtIdUser;
    public javax.swing.JTextField txtNameComp;
    public javax.swing.JTextField txtNameCus;
    public javax.swing.JTextField txtNameNew;
    public javax.swing.JTextField txtNamePro;
    public javax.swing.JTextField txtNameUser;
    public javax.swing.JTextField txtPriceNew;
    public javax.swing.JTextField txtPricePro;
    public javax.swing.JTextField txtStockProd;
    public javax.swing.JTextField txtTeleCom;
    public javax.swing.JTextField txtTeleCust;
    public javax.swing.JTextField txtTeleEmpl;
    public javax.swing.JTextField txtTeleProv;
    public javax.swing.JPanel viewCustomer;
    public javax.swing.JPanel viewNewSoles;
    public javax.swing.JPanel viewProducts;
    public javax.swing.JPanel viewProvider;
    // End of variables declaration//GEN-END:variables

    public static int getALLBITS() {
        return ALLBITS;
    }

    public LoginUser getLoginHome() {
        return loginHome;
    }

    public void setLoginHome(LoginUser loginHome) {
        this.loginHome = loginHome;
    }

}
