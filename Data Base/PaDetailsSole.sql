-- PA Details Soles

use SYSTEMSOLES
CREATE PROCEDURE Insert_DetailSole
@CodeProduct CHAR(8),
@QuantitySold INT,
@totalPurchase float,
@IdSole INT
AS BEGIN 
IF @CodeProduct IS NULL OR @QuantitySold IS NULL OR @totalPurchase IS NULL OR @IdSole IS NULL
RETURN
ELSE
BEGIN
INSERT INTO SalesDetails VALUES (@CodeProduct,@QuantitySold,@totalPurchase,@IdSole)
END 
END

-- PA to update the stock available of a product after buy it
CREATE PROCEDURE update_StockBuy
@CodeProductBought CHAR(8),
@amountPurchase INT
AS BEGIN 
IF @amountPurchase IS NULL 
RETURN 
ELSE 
BEGIN
UPDATE Products SET StockAvailable = (StockAvailable-@amountPurchase) WHERE CodeProduct = @CodeProductBought
END
END

SELECT * FROM SalesDetails;
