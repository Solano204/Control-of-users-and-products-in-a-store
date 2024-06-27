-- INSERTS CLIENTS
use SYSTEMSOLES;

DECLARE @Retorn int;
EXEC Insert_Customer '11111111', 'ClienteUno', '1234567893', 'Dirección', NULL,1, @Retorn OUTPUT;
EXEC Insert_Customer '22222222', 'ClienteDos', '9876543212', 'Dirección',NULL,2, @Retorn OUTPUT;
EXEC Insert_Customer '33333333', 'ClienteThree', '9876543216', 'Dirección', NULL,2, @Retorn OUTPUT;
EXEC Insert_Customer '44444444', 'ClienteFour', '9876543217', 'Dirección', NULL,3, @Retorn OUTPUT;
EXEC Insert_Customer '55555555', 'ClienteFive', '9876543212', 'Direccion', NULL,4, @Retorn OUTPUT;
EXEC Insert_Customer '66666666', 'ClienteSix', '9876543213', 'Direccion', NULL,2, @Retorn OUTPUT
EXEC Insert_Customer '77777777', 'ClienteSeven', '9876543214', 'Direccion', NULL,1, @Retorn OUTPUT;
EXEC Insert_Customer '88888888', 'ClienteEight', '9876543215', 'Direccion', NULL,1, @Retorn OUTPUT;
EXEC Insert_Customer '99999999', 'ClienteNine', '9876543211', 'Direccion', NULL,4, @Retorn OUTPUT;
EXEC Insert_Customer '10101010', 'ClienteTen', '9876543212', 'Dirección', NULL,3, @Retorn OUTPUT;

SELECT * FROM Customers;
delete from Customers;


-- INSERT DATA LATAM
INSERT INTO Latam VALUES ('+52-');
INSERT INTO Latam VALUES ('+1-');
INSERT INTO Latam VALUES ('+7-');
INSERT INTO Latam VALUES ('+55-');

select * from Latam;
-- Select of a join between the tables Customer and Latam
SELECT IdClave FROM Customers WHERE DniCustomer = '66666666';