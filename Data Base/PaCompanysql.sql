USE SYSTEMSOLES

-- PA UPDATE INFORMATION FROM COMPANY 
CREATE PROCEDURE Update_Company
@Dni char(8),
@Name varchar(30),
@Telephone varchar(15),
@Addres varchar (30),
@BussinessName varchar(30)
AS BEGIN 
IF @Name IS NOT NULL or @Dni IS NOT NULL or @Telephone IS NOT NULL or @Addres IS NOT NULL OR  @BussinessName IS NOT NULL
BEGIN
UPDATE Company SET DniCompany = @Dni, NameCompany = @Name, TelephoneCompany = @Telephone, AddresCompany = @Addres, BussinessName = @BussinessName
END 
ELSE
RETURN
END

-- Insertion of the information to my Company
INSERT INTO Company VALUES ('11111111','COMPANY','9631585303','EL cedro','El chiste es hacer');

-- Update information
EXEC Update_Company '10101010','NEWCOMPANY','9631585999','EL cedro','Estamos empezando'

select * FROM Sales;
select * from SalesDetails;