CREATE DATABASE SYSTEMSOLES;
USE SYSTEMSOLES;
-- user table for get in
drop table SalesDetails;
drop table Customers;
drop table Latam;
drop table Sales;
drop table providers;	
drop table Products;
drop TABLE UserMain;
CREATE TABLE UserMain(
	IdUser CHAR (8) NOT NULL,
	PassWordUser VARCHAR(100) NOT NULL UNIQUE,
	TypeUser VARCHAR(30) NOT NULL,
	NameUser VARCHAR(30) DEFAULT ('Unknown'),
	TelephoneUser VARCHAR(15) DEFAULT ('Unknown'),
    emailUser VARCHAR(100) DEFAULT ('Unknowm'),
	RegistrationDate DATE DEFAULT GETDATE(),	
	IdClave INT,
	FOREIGN KEY (IdClave) REFERENCES Latam (IdClave),
	PRIMARY KEY(IdUser)
);

USE SYSTEMSOLES	
SELECT * FROM UserMain

CREATE TABLE Customers(
	DniCustomer CHAR(8) NOT NULL,
	NameCustomer VARCHAR(30) DEFAULT ('Unknown'),
	TelephoneCustomer VARCHAR(15) DEFAULT ('Unknown'),
	AddresCustomer VARCHAR(30) DEFAULT ('UnKnown'),
	RegistrationDate DATE DEFAULT GETDATE(),
	IdClave INT,
	FOREIGN KEY (IdClave) REFERENCES Latam (IdClave),
	PRIMARY KEY(DniCustomer)
);

CREATE TABLE Providers(
	DniProvider CHAR(8) NOT NULL, 
	NameProvider VARCHAR(30) DEFAULT ('UnKnown'),
	TelephoneProvider VARCHAR(15) DEFAULT ('UnKnown'),
	CountrytProvider VARCHAR(20) DEFAULT ('UnKnown'),
	RegistrationDate DATE DEFAULT GETDATE(),
	IdClave INT,
	FOREIGN KEY (IdClave) REFERENCES Latam (IdClave),
	PRIMARY KEY(DniProvider)
);


select * from Products;



CREATE TABLE Products(
	CodeProduct CHAR(8) NOT NULL,
	NameProduct VARCHAR(30) DEFAULT ('UnKnown'),
	StockAvailable INT NOT NULL,
	Price FLOAT  NOT NULL,
	DniProvider CHAR(8) NOT NULL,
	lastUpdate DATE DEFAULT GETDATE(),
	PRIMARY KEY(CodeProduct),
	FOREIGN KEY (DniProvider) REFERENCES Providers(DniProvider),
);


ALTER TABLE products ALTER COLUMN Price FloaT;

CREATE TABLE PayMent(
	id INT IDENTITY,
	nameMethod VARCHAR (20)
	PRIMARY KEY(id)
);

INSERT INTO PayMent VALUES ('Cash'),('Debit Card'), ('Credit Card'), ('PayPal');
select * from PayMent;
CREATE TABLE SalesDetails(
	IdDetailSole INT IDENTITY,
	CodeProduct CHAR(8),
	QuantitySold INT,
	Total float,
	IdSole INT,
	FOREIGN KEY (IdSole) REFERENCES Sales(IdSole),
	-- FOREING KEY(I mean this foreign key has to be in the main table)
	FOREIGN KEY (CodeProduct) REFERENCES Products(CodeProduct)
	);

ALTER TABLE SalesDetails ALTER COLUMN Total FloaT;

CREATE TABLE Sales(
	IdSole INT IDENTITY,
	DniCustomer CHAR (8),
	IdPaymentMethod INT,
    Total float,
	datePurchase DATE,
    FOREIGN KEY (DniCustomer) REFERENCES Customers(DniCustomer),
	FOREIGN KEY (IdPaymentMethod) REFERENCES PayMent(id),
	PRIMARY KEY (IdSole)
);

CREATE TABLE Latam(
	IdClave INT IDENTITY,
	clave VARCHAR(5),
	PRIMARY KEY (IdClave)
);
 
CREATE TABLE Company (
	DniCompany CHAR(8) NOT NULL PRIMARY KEY,
	NameCompany VARCHAR(30) DEFAULT ('Unknown'),
	TelephoneCompany VARCHAR(15) DEFAULT ('Unknown'),
	AddresCompany VARCHAR(50) DEFAULT ('UnKnown'),
	BussinessName VARCHAR(100) DEFAULT ('UnKnown'),
);

drop table company;
SELECT MAX(IdVenta) as LASTSALE FROM Sales

SELECT * FROM UserMain;
select * from Customers;

select * from Providers;
 
 EXEC sp_rename 'Providers.Country','CountryProvider','COLUMN' ;





 