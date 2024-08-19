# **Store Management System**

### *Efficient User and Product Management for Small Retail Stores*

---

## 📝 **Project Overview**

This project is a comprehensive solution for managing users, products, customers, suppliers, and sales within a small retail store. Developed using **pure Java** and **SQL Server**, this system operates without the use of frameworks like Spring Boot. It is designed for store managers or other authorized users, providing a user-friendly interface to manage various store operations efficiently.

---

## 💻 **Java Development**

- **Programming Paradigm**: Functional programming.
- **UI Components**: Managed using Swing libraries.
- **External Libraries**:
  - **JDBC**: For database connectivity.
  - **Document Generation**: Excel and PDF files.
  - **Graphical Bar Charts**: For visual representation of data.
  - **Calendar Library**: For date management.

---

## 🗄️ **SQL Development**

- **Functions**: Implemented for various database operations.
- **Triggers**: Used to automate tasks within the database.
- **Stored Procedures** (`CALLABLE`): Core of the SQL operations, handling the creation, deletion, update, and selection of users and products.

These stored procedures are executed from the Java application, ensuring seamless interaction between the front-end and the database.

---

## 📋 **Application Features**

The application provides a menu with seven main views, each tailored to specific management tasks:

### 1. **🔐 Login **
   - Secure login with encrypted credentials.
   - Role-based access to different views and features.
  ![Captura de pantalla 2024-08-19 043431](https://github.com/user-attachments/assets/b4db67ee-9a1a-45f0-98b2-595e61b32383)

### 2. **💰 Sales Management**
   - Conduct sales transactions with customer and product selection.
   - Generate and print receipts for each sale.
   - Validate inputs to ensure transaction accuracy.
  ![Captura de pantalla 2024-08-19 050436](https://github.com/user-attachments/assets/616c0a47-a288-4009-8ae1-b1cea1a9ed5e)

![Captura de pantalla 2024-08-19 050456](https://github.com/user-attachments/assets/f6f3f0f0-8072-478a-a5d1-a754a27bce3a)

![Captura de pantalla 2024-08-19 050932](https://github.com/user-attachments/assets/30c59731-449c-498f-baea-10cefd738b0c)

### 3. **👥 Customer Management **
   - View and manage customer information.
   - Add, update, or delete customer records.

![Captura de pantalla 2024-08-19 050522](https://github.com/user-attachments/assets/fb99277d-de7c-4ab4-bfbf-f5979271cbc0)
   

### 4. **🏭 Supplier Management **
   - Manage supplier details.
   - Edit and update supplier information as needed.

     ![Captura de pantalla 2024-08-19 050626](https://github.com/user-attachments/assets/27df846d-a550-47bc-8524-9377e19518d9)


### 5. **📦 Product Management **
   - Insert, select, delete, and update product records.
   - Generate and print Excel reports with stock levels and best-selling products.


![Captura de pantalla 2024-08-19 055117](https://github.com/user-attachments/assets/b621966e-37e4-422a-841a-3e66761e90dc)

![Captura de pantalla 2024-08-19 051018](https://github.com/user-attachments/assets/fb9eabb3-a78c-4eb4-923d-ad481ef85a97)

### 6. **👤 User Management **
   - Manage user accounts, including creation, updates, and deletions.
   - Assign roles and permissions to users.

     ![Captura de pantalla 2024-08-19 050730](https://github.com/user-attachments/assets/366ca71c-c2aa-464e-9ceb-46175094e196)

### 7. **📊 Sales Overview**
   - View and manage all sales transactions.
   - Visualize sales trends over time (daily, monthly, yearly).
   - Retrieve and reprint receipts for previous purchases.

![Captura de pantalla 2024-08-19 050744](https://github.com/user-attachments/assets/9d424353-9da6-4058-8ed9-2197ebe87d46)

![Captura de pantalla 2024-08-19 050832](https://github.com/user-attachments/assets/ad21986d-f1de-481d-b35e-89ac671ae381)

### 8. **🏪 Store Information **
   - Overview of the store’s key information and metrics.



## 📂 **Project Structure**

- **Java Code**: Handles UI, business logic, and database interactions.
- **SQL Scripts**: Contains the functions, triggers, and stored procedures required for database management.

---

## 🌟 **Getting Started**

### Prerequisites:
- **Java Development Kit (JDK)**
- **SQL Server**

### Setup:
1. **Clone the Repository**:
    ```bash
    git clone https://github.com/your-username/store-management-system.git
    ```
2. **Import the Project**:
    - Open the project in your favorite Java IDE (e.g., IntelliJ IDEA, Eclipse).
3. **Configure the Database**:
    - Import the SQL scripts into your SQL Server instance.
    - Update database connection settings in the Java code.

4. **Run the Application**:
    - Compile and run the Java application from your IDE.

---

## 🚀 **Future Enhancements**

- **Integration with Web Frameworks**: Consider migrating to Spring Boot for scalability.
- **Enhanced Security**: Implement OAuth2 or JWT for improved authentication.
- **Reporting Features**: Add more detailed reports and analytics.

---

## 🤝 **Contributing**

Contributions are welcome! Please fork this repository and submit a pull request for any improvements.

---

## 📄 **License**

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

## 📧 **Contact**

For any inquiries or support, please contact [your-email@example.com](mailto:your-email@example.com).
