USE SYSTEMSOLES;

select * FROM Customers
 drop proc Insert_Customer;

  -- PA for insert a new Customer
CREATE PROCEDURE Insert_Provider
@Dni char(8),
@Name varchar(30),
@Telephone varchar(15),
@Country varchar (30),
@registrationDate Date,
@IdClave INT,
@Retorn INT OUTPUT
AS 
BEGIN 
 SET @registrationDate = GETDATE()
  IF @Name IS NULL or @Dni IS NULL or @Telephone IS NULL or @Country IS NULL or @registrationDate IS NULL or @IdClave IS NULL
  BEGIN
    SET @Retorn = 0
  END
  ELSE 
  BEGIN 
    INSERT INTO Providers VALUES (@Dni, @Name, @Telephone, @Country, @registrationDate,@IdClave)
    SET @Retorn = 1
  END
  END

--------------------------------------------------------------------------
-- PA responsable for print all itemns in the list
CREATE PROCEDURE Select_Provider
AS
BEGIN
	SELECT * FROM Providers;
END

-------------------------------------------------------------------------
-- PA to search a determinate customer
CREATE PROCEDURE Search_Provider
@DniDelete VARCHAR (8) 
AS BEGIN
IF @DniDelete is not null
BEGIN
Select 'Exits' FROM Providers WHERE DniProvider = @DniDelete;
END 
END 

----------------------------------------------------------------------------------
-- PA to delete an Customer
CREATE PROCEDURE Delete_Provider
@DniDelete VARCHAR (8) 
AS BEGIN
IF @DniDelete is not null
BEGIN
DELETE FROM Providers WHERE DniProvider = @DniDelete;
END 
END

-----------------------------------------------------------------------------------
-- PA to update customer details
CREATE PROCEDURE Update_Provider 
@Dni char(8),
@Name varchar(30),
@Telephone varchar(15),
@Country varchar (30)
AS BEGIN 
IF @Name IS NOT NULL or @Dni IS NOT NULL or @Telephone IS NOT NULL or @Country IS NOT NULL 
UPDATE Providers SET DniProvider = @Dni, NameProvider = @Name, TelephoneProvider = @Telephone, CountryProvider = @Country WHERE DniProvider = @Dni
END

DROP PROCEDURE Update_Provider;