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

### 1. **🔐 Login View**
   - Secure login with encrypted credentials.
   - Role-based access to different views and features.
  ![Captura de pantalla 2024-08-19 043431](https://github.com/user-attachments/assets/b4db67ee-9a1a-45f0-98b2-595e61b32383)

### 2. **💰 Sales Management View**
   - Conduct sales transactions with customer and product selection.
   - Generate and print receipts for each sale.
   - Validate inputs to ensure transaction accuracy.
   ![alt text](<../Images/Captura de pantalla 2024-08-19 050436.png>)

### 3. **👥 Customer Management View**
   - View and manage customer information.
   - Add, update, or delete customer records.
   

### 4. **🏭 Supplier Management View**
   - Manage supplier details.
   - Edit and update supplier information as needed.

### 5. **📦 Product Management View**
   - Insert, select, delete, and update product records.
   - Generate and print Excel reports with stock levels and best-selling products.

### 6. **👤 User Management View**
   - Manage user accounts, including creation, updates, and deletions.
   - Assign roles and permissions to users.

### 7. **📊 Sales Overview View**
   - View and manage all sales transactions.
   - Visualize sales trends over time (daily, monthly, yearly).
   - Retrieve and reprint receipts for previous purchases.

### 8. **🏪 Store Information View**
   - Overview of the store’s key information and metrics.

---

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
