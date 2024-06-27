use SolesSystem


DECLARE @Code char(8) = 'PROD001';
DECLARE @Name varchar(30) = 'Example Product';
DECLARE @StockAvailable INT = 100;
DECLARE @Price DECIMAL(5,2) = 50.99;
DECLARE @DniProvider CHAR(8) = '11111111';
DECLARE @LastDate DATE;

-- Execute the stored procedure
EXEC Insert_Product @Code, @Name, @StockAvailable, @Price, @DniProvider, @LastDate;

-- Execute the Update procedure
EXEC Update_Product @Code, @Name, @StockAvailable, @Price, @DniProvider,NULL

-- Execute select Products
EXEC Select_Product ;

-- Execute exits Product
EXEC Exits_Product 'PROD001';

-- Execute The Delete a product
EXEC Delete_Product 'PROD001';
SELECT * FROM Products;
select * from Providers;

INSERT INTO Providers (DniProvider, NameProvider, TelephoneProvider, CountrytProvider, RegistrationDate)
VALUES 
('11111111', 'Proveedor 1', '123456789', 'País 1', GETDATE()),
('22222222', 'Proveedor 2', '987654321', 'País 2', GETDATE()),
('33333333', 'Proveedor 3', '555555555', 'País 3', GETDATE());
