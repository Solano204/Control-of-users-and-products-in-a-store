USE SYSTEMSOLES;
SELECT * FROM Products;
SELECT * FROM Providers;

DROP Procedure Insert_Product;
-- PA to insert a new Product 
CREATE PROCEDURE Insert_Product
@Code char(8),
@Name varchar(30),
@StockAvailable INT,
@Price float,
@DniProvider CHAR(8),
@LastDate DATE
AS BEGIN 
SET @LastDate = GETDATE()
IF @Code IS NULL OR @Name IS NULL OR @StockAvailable IS NULL OR @Price IS NULL OR @DniProvider IS NULL
RETURN
ELSE
BEGIN
INSERT INTO  Products VALUES (@Code,@Name,@StockAvailable,@Price,@DniProvider,@LastDate)
END 
END

select * FROm Products;
----------------------------------------------------------------
-- Pa to check if the product exists
CREATE PROCEDURE Exits_Product
@Code CHAR(8)
AS BEGIN
IF @Code IS NULL
RETURN
ELSE 
BEGIN
SELECT 'EXITS' FROM Products WHERE CodeProduct = @Code
END
END

------------------------------------------------------------------
-- PA TO DELETE A PRODUCT
CREATE PROCEDURE Delete_Product
@Code CHAR(8)
AS BEGIN
IF @Code IS NULL
RETURN
ELSE 
BEGIN
DELETE Products WHERE CodeProduct = @Code
END
END

use SYSTEMSOLES;

SELECT CodeProduct,NameProduct,StockAvailable,Price FROM Products WHERE CodeProduct = '22332';
-------------------------------------------------------------
--Pa to select a product with Join Provider
CREATE PROCEDURE Select_Product
AS BEGIN 
SELECT pro.*, P.NameProvider FROM Products AS pro JOIN Providers as p ON p.DniProvider = pro.DniProvider 
END
---------------------------------------------------------------------------
-- Pa to Update a Product
CREATE PROCEDURE Update_Product
@Code char(8),
@Name varchar(30),
@StockAvailable INT,
@Price DECIMAL (5,2),
@DniProvider CHAR(8),
@LastDate DATE
AS BEGIN S
SET @LastDate = GETDATE()
IF @Code IS NULL OR @Name IS NULL OR @StockAvailable IS NULL OR @Price IS NULL OR @DniProvider IS NULL
return
ELSE
BEGIN 
UPDATE Products SET CodeProduct = @Code, NameProduct = @Name, StockAvailable = @StockAvailable, Price = @Price, Dniprovider = @DniProvider,lastUpdate = @LastDate WHERE CodeProduct = @Code
END
END

select * from Customers;