-- PA general Soles 


-- Pa to insert a new sol
CREATE PROCEDURE Insert_Sole
@DniCustomer CHAR(8),
@IdPaymentMethod INT,
@TotalGeneralBuy float
AS BEGIN 
DECLARE @registerDate DATE = GETDATE()
IF @DniCustomer IS NULL OR @IdPaymentMethod IS NULL OR @TotalGeneralBuy IS NULL
RETURN
ELSE
BEGIN
INSERT INTO Sales VALUES (@DniCustomer,@IdPaymentMethod,@TotalGeneralBuy,@registerDate)
END 
END
Use SYSTEMSOLES

drop procedure Insert_Sole
delete from sales;
SELECT * FROM sales;
select * from SalesDetails
select * from Customers;
SELECT MAX(IdSole) as LAST_SALE FROM sales;
select * from PayMent
-- pa to selected all soles
CREATE PROCEDURE Select_Soles
AS BEGIN 
SELECT  s.IdSole,s.DniCustomer,me.nameMethod,s.Total,s.datePurchase FROM Sales AS s JOIN PayMent AS me ON s.IdPaymentMethod = me.id
END


drop procedure Select_ByDate;

-- PA to selected some date by a date
CREATE PROCEDURE Select_ByDate
@dateSelected DATE
AS BEGIN 
IF @dateSelected IS NULL
RETURN 
ELSE
SELECT IdSole,Total FROM Sales WHERE datePurchase = @dateSelected;
END

--PA to selected some soles by a range date
CREATE PROCEDURE Select_ByRangeDate
@dateMin DATE,
@dateMax DATE
AS BEGIN 
IF @dateMIn IS NULL OR @dateMax IS NULL
RETURN 
ELSE
SELECT IdSole,Total FROM Sales WHERE datePurchase between  @dateMin and @dateMax ;
END

use SYSTEMSOLES
select * from Sales as s Join SalesDetails as sd ON s.IdSole = sd.IdSole where s.IdSole = 14;


-- Init the primary key, it just functions when the table doesnt values
-- DBCC CHECKIDENT(Sales, RESEED, 0);
-- DBCC CHECKIDENT(SalesDetails, RESEED, 0);

CREATE PROCEDURE Update_User
@IdUser CHAR(8),
@Password VARCHAR(100),
@TypeUser VARCHAR(30),
@NameUser VARCHAR(30),
@TelephoneUser VARCHAR(15),
@emailUser VARCHAR(30),
@IdClave INT
AS BEGIN 
IF @IdUser IS NULL OR @Password IS NULL OR @TypeUser IS NULL OR @NameUser IS NULL OR @emailUser IS NULL OR @TelephoneUser  IS NULL OR @IdClave IS NULL
RETURN
ELSE
BEGIN
UPDATE UserMain SET  IdUser =  @IdUser,PassWordUser =  @Password,TypeUser = @TypeUser, NameUser = @NameUser, TelephoneUser = @TelephoneUser,emailUser = @emailUser ,IdClave = @IdClave
END 
END