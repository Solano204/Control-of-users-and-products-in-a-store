
-- creation of the PA to delete an customerU
USE SYSTEMSOLES;
select * FROM Customers
 drop proc Insert_Customer;

  -- PA for insert a new Customer
CREATE PROCEDURE Insert_Customer 
@Dni char(8),
@Name varchar(30),
@Telephone varchar(15),
@Addres varchar (30),
@registrationDate Date,
@IdClave INT,
@Retorn INT OUTPUT
AS 
BEGIN 
 SET @registrationDate = GETDATE()
  IF @Name IS NULL or @Dni IS NULL or @Telephone IS NULL or @Addres IS NULL or @registrationDate IS NULL or @IdClave IS NULL
  BEGIN
    SET @Retorn = 0
  END
  ELSE 
  BEGIN
    INSERT INTO Customers VALUES (@Dni, @Name, @Telephone, @Addres, @registrationDate,@IdClave)
    SET @Retorn = 1
  END
end

--------------------------------------------------------------------------
-- PA responsable for print all itemns in the list
CREATE PROCEDURE Select_Table
AS
BEGIN
	SELECT * FROM Customers;
END

EXEC Select_Table;

-------------------------------------------------------------------------
-- PA to search a determinate customer
CREATE PROCEDURE Search_Customer
@DniDelete VARCHAR (8) 
AS BEGIN
IF @DniDelete is not null
BEGIN
Select 'Exits' FROM Customers WHERE DniCustomer = @DniDelete;
END 
EXEC Search_Customer '10101010' ;

----------------------------------------------------------------------------------
-- PA to delete an Customer
CREATE PROCEDURE Delete_Customer
@DniDelete VARCHAR (8) 
AS BEGIN
IF @DniDelete is not null
BEGIN
DELETE FROM Customers WHERE DniCustomer = @DniDelete;
END 
END
EXEC Delete_Customer '12345678';
DECLARE @ReturnCode INT

-----------------------------------------------------------------------------------
-- PA to update customer details
CREATE PROCEDURE Update_Customer
@Dni char(8),
@Name varchar(30),
@Telephone varchar(15),
@Addres varchar (30)
AS BEGIN 
IF @Name IS NOT NULL or @Dni IS NOT NULL or @Telephone IS NOT NULL or @Addres IS NOT NULL 
UPDATE Customers SET DniCustomer = @Dni, NameCustomer = @Name, TelephoneCustomer = @Telephone, AddresCustomer = @Addres WHERE DniCustomer = @Dni
END 

DECLARE @DniToUpdate char(8) = '12345678'
DECLARE @NewName varchar(30) = 'Updated Name'
DECLARE @NewTelephone varchar(15) = '555-555-5555'
DECLARE @NewAddres varchar(30) = 'Updated Address'
DECLARE @NewRegistrationDate Date = '2024-02-20'

-- Execute the stored procedure
EXEC Update_Customer
  @Dni = @DniToUpdate,
  @Name = @NewName,
  @Telephone = @NewTelephone,
  @Addres = @NewAddres,
  @registrationDate = @NewRegistrationDate



DECLARE @ReturnCode INT
EXEC Insert_Customer 
  @Dni = '12345678',
  @Name = 'John Doe',
  @Telephone = '123-456-7890',
  @Addres = '123 Main St',
  @registrationDate = '2024-02-20',
  @Retorn = @ReturnCode OUTPUT

  drop Procedure Delete_Customer;
  DROP PROCEDURE Update_Customer

  ---------------------------------------------------------
  -- Pa to select all latams
  CREATE PROCEDURE Select_Latams 
  AS BEGIN
  SELECT clave FROM Latam
  END

  EXEC Select_Latams

 SELECT DniCustomer, NameCustomer FROM Customers WHERE DniCustomer = 'dds';