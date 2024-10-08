USE [master]
GO
/****** Object:  Database [SYSTEMSOLES]    Script Date: 05/03/2024 01:11:39 a. m. ******/
CREATE DATABASE [SYSTEMSOLES]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'SYSTEMSOLES', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.SQLSERVER\MSSQL\DATA\SYSTEMSOLES.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'SYSTEMSOLES_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.SQLSERVER\MSSQL\DATA\SYSTEMSOLES_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT, LEDGER = OFF
GO
ALTER DATABASE [SYSTEMSOLES] SET COMPATIBILITY_LEVEL = 160
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [SYSTEMSOLES].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [SYSTEMSOLES] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [SYSTEMSOLES] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [SYSTEMSOLES] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [SYSTEMSOLES] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [SYSTEMSOLES] SET ARITHABORT OFF 
GO
ALTER DATABASE [SYSTEMSOLES] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [SYSTEMSOLES] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [SYSTEMSOLES] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [SYSTEMSOLES] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [SYSTEMSOLES] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [SYSTEMSOLES] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [SYSTEMSOLES] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [SYSTEMSOLES] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [SYSTEMSOLES] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [SYSTEMSOLES] SET  ENABLE_BROKER 
GO
ALTER DATABASE [SYSTEMSOLES] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [SYSTEMSOLES] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [SYSTEMSOLES] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [SYSTEMSOLES] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [SYSTEMSOLES] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [SYSTEMSOLES] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [SYSTEMSOLES] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [SYSTEMSOLES] SET RECOVERY FULL 
GO
ALTER DATABASE [SYSTEMSOLES] SET  MULTI_USER 
GO
ALTER DATABASE [SYSTEMSOLES] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [SYSTEMSOLES] SET DB_CHAINING OFF 
GO
ALTER DATABASE [SYSTEMSOLES] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [SYSTEMSOLES] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [SYSTEMSOLES] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [SYSTEMSOLES] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'SYSTEMSOLES', N'ON'
GO
ALTER DATABASE [SYSTEMSOLES] SET QUERY_STORE = ON
GO
ALTER DATABASE [SYSTEMSOLES] SET QUERY_STORE (OPERATION_MODE = READ_WRITE, CLEANUP_POLICY = (STALE_QUERY_THRESHOLD_DAYS = 30), DATA_FLUSH_INTERVAL_SECONDS = 900, INTERVAL_LENGTH_MINUTES = 60, MAX_STORAGE_SIZE_MB = 1000, QUERY_CAPTURE_MODE = AUTO, SIZE_BASED_CLEANUP_MODE = AUTO, MAX_PLANS_PER_QUERY = 200, WAIT_STATS_CAPTURE_MODE = ON)
GO
USE [SYSTEMSOLES]
GO
/****** Object:  Table [dbo].[Company]    Script Date: 05/03/2024 01:11:39 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Company](
	[DniCompany] [char](8) NOT NULL,
	[NameCompany] [varchar](30) NULL,
	[TelephoneCompany] [varchar](15) NULL,
	[AddresCompany] [varchar](50) NULL,
	[BussinessName] [varchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[DniCompany] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Customers]    Script Date: 05/03/2024 01:11:39 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Customers](
	[DniCustomer] [char](8) NOT NULL,
	[NameCustomer] [varchar](30) NULL,
	[TelephoneCustomer] [varchar](15) NULL,
	[AddresCustomer] [varchar](30) NULL,
	[RegistrationDate] [date] NULL,
	[IdClave] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[DniCustomer] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Latam]    Script Date: 05/03/2024 01:11:39 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Latam](
	[IdClave] [int] IDENTITY(1,1) NOT NULL,
	[clave] [varchar](5) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdClave] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PayMent]    Script Date: 05/03/2024 01:11:39 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PayMent](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[nameMethod] [varchar](20) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Products]    Script Date: 05/03/2024 01:11:39 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Products](
	[CodeProduct] [char](8) NOT NULL,
	[NameProduct] [varchar](30) NULL,
	[StockAvailable] [int] NOT NULL,
	[Price] [float] NULL,
	[DniProvider] [char](8) NOT NULL,
	[lastUpdate] [date] NULL,
PRIMARY KEY CLUSTERED 
(
	[CodeProduct] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Providers]    Script Date: 05/03/2024 01:11:39 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Providers](
	[DniProvider] [char](8) NOT NULL,
	[NameProvider] [varchar](30) NULL,
	[TelephoneProvider] [varchar](15) NULL,
	[CountryProvider] [varchar](20) NULL,
	[RegistrationDate] [date] NULL,
	[IdClave] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[DniProvider] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Sales]    Script Date: 05/03/2024 01:11:39 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Sales](
	[IdSole] [int] IDENTITY(1,1) NOT NULL,
	[DniCustomer] [char](8) NULL,
	[IdPaymentMethod] [int] NULL,
	[Total] [float] NULL,
	[datePurchase] [date] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdSole] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SalesDetails]    Script Date: 05/03/2024 01:11:39 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SalesDetails](
	[IdDetailSole] [int] IDENTITY(1,1) NOT NULL,
	[CodeProduct] [char](8) NULL,
	[QuantitySold] [int] NULL,
	[Total] [float] NULL,
	[IdSole] [int] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[UserMain]    Script Date: 05/03/2024 01:11:39 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[UserMain](
	[IdUser] [char](8) NOT NULL,
	[PassWordUser] [varchar](100) NOT NULL,
	[TypeUser] [varchar](30) NOT NULL,
	[NameUser] [varchar](30) NULL,
	[TelephoneUser] [varchar](15) NULL,
	[emailUser] [varchar](30) NULL,
	[RegistrationDate] [date] NULL,
	[IdClave] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdUser] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Company] ([DniCompany], [NameCompany], [TelephoneCompany], [AddresCompany], [BussinessName]) VALUES (N'11111111', N'COMPANYdffdfdsdfdffaaaa', N'9631585303', N'EL cedro', N'El chiste es hacer')
GO
INSERT [dbo].[Customers] ([DniCustomer], [NameCustomer], [TelephoneCustomer], [AddresCustomer], [RegistrationDate], [IdClave]) VALUES (N'11111111', N'DFFGFGSDDFGDF', N'3443534545', N'FGDFGGFG DFGDFGSS', CAST(N'2024-03-01' AS Date), 1)
INSERT [dbo].[Customers] ([DniCustomer], [NameCustomer], [TelephoneCustomer], [AddresCustomer], [RegistrationDate], [IdClave]) VALUES (N'22222222', N'dfdfg', N'3443333333', N'dsfdsf hdsfh', CAST(N'2024-03-02' AS Date), 1)
INSERT [dbo].[Customers] ([DniCustomer], [NameCustomer], [TelephoneCustomer], [AddresCustomer], [RegistrationDate], [IdClave]) VALUES (N'23444444', N'fgdfgsfgd', N'4563455344', N'fgdddggd', CAST(N'2024-02-23' AS Date), 3)
INSERT [dbo].[Customers] ([DniCustomer], [NameCustomer], [TelephoneCustomer], [AddresCustomer], [RegistrationDate], [IdClave]) VALUES (N'32444444', N'dfgffd', N'4355555555', N'fddddddddddddddddddd', CAST(N'2024-03-03' AS Date), 1)
INSERT [dbo].[Customers] ([DniCustomer], [NameCustomer], [TelephoneCustomer], [AddresCustomer], [RegistrationDate], [IdClave]) VALUES (N'34344343', N'fddddrfd', N'2323232323', N'dfsssssssss', CAST(N'2024-02-24' AS Date), 1)
INSERT [dbo].[Customers] ([DniCustomer], [NameCustomer], [TelephoneCustomer], [AddresCustomer], [RegistrationDate], [IdClave]) VALUES (N'43443554', N'dsfdfsg', N'4343344434', N'dffffffff', CAST(N'2024-02-24' AS Date), 1)
GO
SET IDENTITY_INSERT [dbo].[Latam] ON 

INSERT [dbo].[Latam] ([IdClave], [clave]) VALUES (1, N'+52-')
INSERT [dbo].[Latam] ([IdClave], [clave]) VALUES (2, N'+1-')
INSERT [dbo].[Latam] ([IdClave], [clave]) VALUES (3, N'+7-')
INSERT [dbo].[Latam] ([IdClave], [clave]) VALUES (4, N'+55-')
SET IDENTITY_INSERT [dbo].[Latam] OFF
GO
SET IDENTITY_INSERT [dbo].[PayMent] ON 

INSERT [dbo].[PayMent] ([id], [nameMethod]) VALUES (1, N'Cash')
INSERT [dbo].[PayMent] ([id], [nameMethod]) VALUES (2, N'Debit Card')
INSERT [dbo].[PayMent] ([id], [nameMethod]) VALUES (3, N'Credit Card')
INSERT [dbo].[PayMent] ([id], [nameMethod]) VALUES (4, N'PayPal')
SET IDENTITY_INSERT [dbo].[PayMent] OFF
GO
INSERT [dbo].[Products] ([CodeProduct], [NameProduct], [StockAvailable], [Price], [DniProvider], [lastUpdate]) VALUES (N'11111111', N'dsddf fd', 2332, 23.232999801635742, N'66567823', CAST(N'2024-03-01' AS Date))
INSERT [dbo].[Products] ([CodeProduct], [NameProduct], [StockAvailable], [Price], [DniProvider], [lastUpdate]) VALUES (N'22222222', N'SDFGGFDFG', 34, 34.345001220703125, N'23234434', CAST(N'2024-03-01' AS Date))
INSERT [dbo].[Products] ([CodeProduct], [NameProduct], [StockAvailable], [Price], [DniProvider], [lastUpdate]) VALUES (N'23323223', N'cvcvxcxv', 2332, 23.23, N'12340679', CAST(N'2024-02-24' AS Date))
INSERT [dbo].[Products] ([CodeProduct], [NameProduct], [StockAvailable], [Price], [DniProvider], [lastUpdate]) VALUES (N'23433341', N'dffgfdggffgd', 344, 3444, N'12340679', CAST(N'2024-02-24' AS Date))
INSERT [dbo].[Products] ([CodeProduct], [NameProduct], [StockAvailable], [Price], [DniProvider], [lastUpdate]) VALUES (N'32323232', N'cvbvbcb', 443, 3443, N'12340679', CAST(N'2024-02-24' AS Date))
INSERT [dbo].[Products] ([CodeProduct], [NameProduct], [StockAvailable], [Price], [DniProvider], [lastUpdate]) VALUES (N'32342424', N'dfvdfg', 34342, 213.23, N'12340679', CAST(N'2024-03-01' AS Date))
INSERT [dbo].[Products] ([CodeProduct], [NameProduct], [StockAvailable], [Price], [DniProvider], [lastUpdate]) VALUES (N'34234532', N'erferre', 434, 34.340000152587891, N'23234434', CAST(N'2024-03-01' AS Date))
INSERT [dbo].[Products] ([CodeProduct], [NameProduct], [StockAvailable], [Price], [DniProvider], [lastUpdate]) VALUES (N'34343434', N'ewwefddf', 34233333, 23, N'34255555', CAST(N'2024-03-01' AS Date))
INSERT [dbo].[Products] ([CodeProduct], [NameProduct], [StockAvailable], [Price], [DniProvider], [lastUpdate]) VALUES (N'34555555', N'dfffffffffffffffff', 34434334, 33.34442138671875, N'12340679', CAST(N'2024-02-24' AS Date))
INSERT [dbo].[Products] ([CodeProduct], [NameProduct], [StockAvailable], [Price], [DniProvider], [lastUpdate]) VALUES (N'43344322', N'fgfdfg', 33, 22, N'12340679', CAST(N'2024-03-01' AS Date))
GO
INSERT [dbo].[Providers] ([DniProvider], [NameProvider], [TelephoneProvider], [CountryProvider], [RegistrationDate], [IdClave]) VALUES (N'12340679', N'Carlos', N'1234567890', N'United', CAST(N'2024-02-23' AS Date), 1)
INSERT [dbo].[Providers] ([DniProvider], [NameProvider], [TelephoneProvider], [CountryProvider], [RegistrationDate], [IdClave]) VALUES (N'23234434', N'BETO FG', N'2334443343', N'FSGDFSFGDFGDFG ', CAST(N'2024-03-01' AS Date), 1)
INSERT [dbo].[Providers] ([DniProvider], [NameProvider], [TelephoneProvider], [CountryProvider], [RegistrationDate], [IdClave]) VALUES (N'23973897', N'MICHAEL', N'3443478347', N'SDFGSDFGFGF', CAST(N'2024-03-01' AS Date), 1)
INSERT [dbo].[Providers] ([DniProvider], [NameProvider], [TelephoneProvider], [CountryProvider], [RegistrationDate], [IdClave]) VALUES (N'34255555', N'drtgfssssssssssssss', N'3422222233', N'dffffffffffffff', CAST(N'2024-02-23' AS Date), 2)
INSERT [dbo].[Providers] ([DniProvider], [NameProvider], [TelephoneProvider], [CountryProvider], [RegistrationDate], [IdClave]) VALUES (N'43445434', N'ffdfddfd', N'3423444444', N'xcvvcvv', CAST(N'2024-02-24' AS Date), 1)
INSERT [dbo].[Providers] ([DniProvider], [NameProvider], [TelephoneProvider], [CountryProvider], [RegistrationDate], [IdClave]) VALUES (N'66567823', N'Daniel', N'8239898947', N'Chamula', CAST(N'2024-02-23' AS Date), 4)
INSERT [dbo].[Providers] ([DniProvider], [NameProvider], [TelephoneProvider], [CountryProvider], [RegistrationDate], [IdClave]) VALUES (N'93443789', N'SDFAKLDFHSDFIHSDF', N'4343434453', N'DFGGDF CFGFGBFG', CAST(N'2024-03-01' AS Date), 1)
GO
SET IDENTITY_INSERT [dbo].[Sales] ON 

INSERT [dbo].[Sales] ([IdSole], [DniCustomer], [IdPaymentMethod], [Total], [datePurchase]) VALUES (1, N'11111111', 1, 1064.6800537109375, CAST(N'2024-03-02' AS Date))
INSERT [dbo].[Sales] ([IdSole], [DniCustomer], [IdPaymentMethod], [Total], [datePurchase]) VALUES (2, N'22222222', 3, 1702.0899658203125, CAST(N'2024-03-02' AS Date))
SET IDENTITY_INSERT [dbo].[Sales] OFF
GO
SET IDENTITY_INSERT [dbo].[SalesDetails] ON 

INSERT [dbo].[SalesDetails] ([IdDetailSole], [CodeProduct], [QuantitySold], [Total], [IdSole]) VALUES (0, N'11111111', 34, 789.9219970703125, 1)
INSERT [dbo].[SalesDetails] ([IdDetailSole], [CodeProduct], [QuantitySold], [Total], [IdSole]) VALUES (1, N'22222222', 8, 274.760009765625, 1)
INSERT [dbo].[SalesDetails] ([IdDetailSole], [CodeProduct], [QuantitySold], [Total], [IdSole]) VALUES (2, N'11111111', 23, 534.3590087890625, 2)
INSERT [dbo].[SalesDetails] ([IdDetailSole], [CodeProduct], [QuantitySold], [Total], [IdSole]) VALUES (3, N'22222222', 34, 1167.72998046875, 2)
SET IDENTITY_INSERT [dbo].[SalesDetails] OFF
GO
INSERT [dbo].[UserMain] ([IdUser], [PassWordUser], [TypeUser], [NameUser], [TelephoneUser], [emailUser], [RegistrationDate], [IdClave]) VALUES (N'11111111', N'd2MKtovsovI3F/kYDQQJaw==', N'Assistant', N'dfsdfgdf', N'3243433334', N'fgdfg@gmail.com', CAST(N'2024-03-05' AS Date), 2)
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__UserMain__2B5070C25F1DFA0C]    Script Date: 05/03/2024 01:11:39 a. m. ******/
ALTER TABLE [dbo].[UserMain] ADD UNIQUE NONCLUSTERED 
(
	[PassWordUser] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Company] ADD  DEFAULT ('Unknown') FOR [NameCompany]
GO
ALTER TABLE [dbo].[Company] ADD  DEFAULT ('Unknown') FOR [TelephoneCompany]
GO
ALTER TABLE [dbo].[Company] ADD  DEFAULT ('UnKnown') FOR [AddresCompany]
GO
ALTER TABLE [dbo].[Company] ADD  DEFAULT ('UnKnown') FOR [BussinessName]
GO
ALTER TABLE [dbo].[Customers] ADD  DEFAULT ('Unknown') FOR [NameCustomer]
GO
ALTER TABLE [dbo].[Customers] ADD  DEFAULT ('Unknown') FOR [TelephoneCustomer]
GO
ALTER TABLE [dbo].[Customers] ADD  DEFAULT ('UnKnown') FOR [AddresCustomer]
GO
ALTER TABLE [dbo].[Customers] ADD  DEFAULT (getdate()) FOR [RegistrationDate]
GO
ALTER TABLE [dbo].[Products] ADD  DEFAULT ('UnKnown') FOR [NameProduct]
GO
ALTER TABLE [dbo].[Products] ADD  DEFAULT (getdate()) FOR [lastUpdate]
GO
ALTER TABLE [dbo].[Providers] ADD  DEFAULT ('UnKnown') FOR [NameProvider]
GO
ALTER TABLE [dbo].[Providers] ADD  DEFAULT ('UnKnown') FOR [TelephoneProvider]
GO
ALTER TABLE [dbo].[Providers] ADD  DEFAULT ('UnKnown') FOR [CountryProvider]
GO
ALTER TABLE [dbo].[Providers] ADD  DEFAULT (getdate()) FOR [RegistrationDate]
GO
ALTER TABLE [dbo].[UserMain] ADD  DEFAULT ('Unknown') FOR [NameUser]
GO
ALTER TABLE [dbo].[UserMain] ADD  DEFAULT ('Unknown') FOR [TelephoneUser]
GO
ALTER TABLE [dbo].[UserMain] ADD  DEFAULT ('Unknowm') FOR [emailUser]
GO
ALTER TABLE [dbo].[UserMain] ADD  DEFAULT (getdate()) FOR [RegistrationDate]
GO
ALTER TABLE [dbo].[Customers]  WITH CHECK ADD FOREIGN KEY([IdClave])
REFERENCES [dbo].[Latam] ([IdClave])
GO
ALTER TABLE [dbo].[Products]  WITH CHECK ADD FOREIGN KEY([DniProvider])
REFERENCES [dbo].[Providers] ([DniProvider])
GO
ALTER TABLE [dbo].[Providers]  WITH CHECK ADD  CONSTRAINT [FK_Provider_IdClave] FOREIGN KEY([IdClave])
REFERENCES [dbo].[Latam] ([IdClave])
GO
ALTER TABLE [dbo].[Providers] CHECK CONSTRAINT [FK_Provider_IdClave]
GO
ALTER TABLE [dbo].[Sales]  WITH CHECK ADD FOREIGN KEY([DniCustomer])
REFERENCES [dbo].[Customers] ([DniCustomer])
GO
ALTER TABLE [dbo].[Sales]  WITH CHECK ADD FOREIGN KEY([IdPaymentMethod])
REFERENCES [dbo].[PayMent] ([id])
GO
ALTER TABLE [dbo].[SalesDetails]  WITH CHECK ADD FOREIGN KEY([CodeProduct])
REFERENCES [dbo].[Products] ([CodeProduct])
GO
ALTER TABLE [dbo].[SalesDetails]  WITH CHECK ADD FOREIGN KEY([IdSole])
REFERENCES [dbo].[Sales] ([IdSole])
GO
ALTER TABLE [dbo].[UserMain]  WITH CHECK ADD FOREIGN KEY([IdClave])
REFERENCES [dbo].[Latam] ([IdClave])
GO
/****** Object:  StoredProcedure [dbo].[Delete_Customer]    Script Date: 05/03/2024 01:11:39 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[Delete_Customer]
@DniDelete VARCHAR (8) 
AS BEGIN
IF @DniDelete is not null
BEGIN
DELETE FROM Customers WHERE DniCustomer = @DniDelete;
END 
END
GO
/****** Object:  StoredProcedure [dbo].[Delete_Product]    Script Date: 05/03/2024 01:11:39 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[Delete_Product]
@Code CHAR(8)
AS BEGIN
IF @Code IS NULL
RETURN
ELSE 
BEGIN
DELETE Products WHERE CodeProduct = @Code
END
END
GO
/****** Object:  StoredProcedure [dbo].[Delete_Provider]    Script Date: 05/03/2024 01:11:39 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[Delete_Provider]
@DniDelete VARCHAR (8) 
AS BEGIN
IF @DniDelete is not null
BEGIN
DELETE FROM Providers WHERE DniProvider = @DniDelete;
END 
END
GO
/****** Object:  StoredProcedure [dbo].[Delete_User]    Script Date: 05/03/2024 01:11:39 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[Delete_User]
@DniDelete VARCHAR (8) 
AS BEGIN
IF @DniDelete is not null
BEGIN
DELETE FROM UserMain WHERE IdUser = @DniDelete;
END		
END	
GO
/****** Object:  StoredProcedure [dbo].[Exits_Product]    Script Date: 05/03/2024 01:11:39 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[Exits_Product]
@Code CHAR(8)
AS BEGIN
IF @Code IS NULL
RETURN
ELSE 
BEGIN
SELECT 'EXITS' FROM Products WHERE CodeProduct = @Code
END
END
GO
/****** Object:  StoredProcedure [dbo].[Exits_User]    Script Date: 05/03/2024 01:11:39 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
  CREATE PROCEDURE [dbo].[Exits_User]
  @DniSearch VARCHAR (8)
  AS BEGIN
  SELECT IdClave FROM Customers WHERE DniCustomer = @DniSearch
  END
GO
/****** Object:  StoredProcedure [dbo].[Insert_Customer]    Script Date: 05/03/2024 01:11:39 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[Insert_Customer] 
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
GO
/****** Object:  StoredProcedure [dbo].[Insert_DetailSole]    Script Date: 05/03/2024 01:11:39 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[Insert_DetailSole]
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
GO
/****** Object:  StoredProcedure [dbo].[Insert_Product]    Script Date: 05/03/2024 01:11:39 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[Insert_Product]
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
GO
/****** Object:  StoredProcedure [dbo].[Insert_Provider]    Script Date: 05/03/2024 01:11:39 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[Insert_Provider]
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

GO
/****** Object:  StoredProcedure [dbo].[Insert_Sole]    Script Date: 05/03/2024 01:11:39 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[Insert_Sole]
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
GO
/****** Object:  StoredProcedure [dbo].[Insert_Users]    Script Date: 05/03/2024 01:11:39 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[Insert_Users]
@IdUser CHAR(8),
@Password VARCHAR(100),
@TypeUser VARCHAR(30),
@NameUser VARCHAR(30),
@TelephoneUser VARCHAR(15),
@emailUser VARCHAR(30),
@IdClave INT
AS BEGIN 
DECLARE @registerDate DATE
SET @registerDate = GETDATE()
IF @IdUser IS NULL OR @Password IS NULL OR @TypeUser IS NULL OR @NameUser IS NULL OR @emailUser IS NULL OR @TelephoneUser IS NULL OR @registerDate IS NULL OR @IdClave IS NULL
RETURN
ELSE
BEGIN
INSERT INTO  UserMain VALUES (@IdUser,@Password,@TypeUser,@NameUser,@TelephoneUser,@emailUser,@registerDate,@IdClave)
END 
END
GO
/****** Object:  StoredProcedure [dbo].[Search_Customer]    Script Date: 05/03/2024 01:11:39 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[Search_Customer]
@DniDelete VARCHAR (8) 
AS BEGIN
IF @DniDelete is not null
BEGIN
Select 'Exits' FROM Customers WHERE DniCustomer = @DniDelete;
END 
END
GO
/****** Object:  StoredProcedure [dbo].[Search_Provider]    Script Date: 05/03/2024 01:11:39 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[Search_Provider]
@DniDelete VARCHAR (8) 
AS BEGIN
IF @DniDelete is not null
BEGIN
Select 'Exits' FROM Providers WHERE DniProvider = @DniDelete;
END 
END 
GO
/****** Object:  StoredProcedure [dbo].[Search_User]    Script Date: 05/03/2024 01:11:39 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[Search_User]
@DniDelete VARCHAR (8)
AS BEGIN
IF @DniDelete is not null
BEGIN
Select 'Exits' FROM UserMain WHERE IdUser = @DniDelete;
END 
END
GO
/****** Object:  StoredProcedure [dbo].[Select_ByDate]    Script Date: 05/03/2024 01:11:39 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[Select_ByDate]
@dateSelected DATE
AS BEGIN 
IF @dateSelected IS NULL
RETURN 
ELSE
SELECT IdSole,Total FROM Sales WHERE datePurchase = @dateSelected;
END
GO
/****** Object:  StoredProcedure [dbo].[Select_ByRangeDate]    Script Date: 05/03/2024 01:11:39 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[Select_ByRangeDate]
@dateMin DATE,
@dateMax DATE
AS BEGIN 
IF @dateMIn IS NULL OR @dateMax IS NULL
RETURN 
ELSE
SELECT IdSole,Total FROM Sales WHERE datePurchase between  @dateMin and @dateMax ;
END
GO
/****** Object:  StoredProcedure [dbo].[Select_Latams]    Script Date: 05/03/2024 01:11:39 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
  CREATE PROCEDURE [dbo].[Select_Latams] 
  AS BEGIN
  SELECT clave FROM Latam
  END
GO
/****** Object:  StoredProcedure [dbo].[Select_Product]    Script Date: 05/03/2024 01:11:39 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[Select_Product]
AS BEGIN 
SELECT pro.*, P.NameProvider FROM Products AS pro JOIN Providers as p ON p.DniProvider = pro.DniProvider 
END
GO
/****** Object:  StoredProcedure [dbo].[Select_Provider]    Script Date: 05/03/2024 01:11:39 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[Select_Provider]
AS
BEGIN
	SELECT * FROM Providers;
END
GO
/****** Object:  StoredProcedure [dbo].[Select_Soles]    Script Date: 05/03/2024 01:11:39 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[Select_Soles]
AS BEGIN 
SELECT  s.IdSole,s.DniCustomer,me.nameMethod,s.Total,s.datePurchase FROM Sales AS s JOIN PayMent AS me ON s.IdPaymentMethod = me.id
END
GO
/****** Object:  StoredProcedure [dbo].[Select_Table]    Script Date: 05/03/2024 01:11:39 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[Select_Table]
AS
BEGIN
	SELECT * FROM Customers;
END
GO
/****** Object:  StoredProcedure [dbo].[Select_User]    Script Date: 05/03/2024 01:11:39 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[Select_User]
AS BEGIN
SELECT us.*,cl.* FROM UserMain AS us JOIN Latam as cl ON us.IdClave = cl.IdClave;
END
GO
/****** Object:  StoredProcedure [dbo].[Update_Company]    Script Date: 05/03/2024 01:11:39 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[Update_Company]
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
GO
/****** Object:  StoredProcedure [dbo].[Update_Customer]    Script Date: 05/03/2024 01:11:39 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[Update_Customer]
@Dni char(8),
@Name varchar(30),
@Telephone varchar(15),
@Addres varchar (30)
AS BEGIN 
IF @Name IS NOT NULL or @Dni IS NOT NULL or @Telephone IS NOT NULL or @Addres IS NOT NULL 
UPDATE Customers SET DniCustomer = @Dni, NameCustomer = @Name, TelephoneCustomer = @Telephone, AddresCustomer = @Addres WHERE DniCustomer = @Dni
END 
GO
/****** Object:  StoredProcedure [dbo].[Update_Product]    Script Date: 05/03/2024 01:11:39 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[Update_Product]
@Code char(8),
@Name varchar(30),
@StockAvailable INT,
@Price DECIMAL (5,2),
@DniProvider CHAR(8),
@LastDate DATE
AS BEGIN 
SET @LastDate = GETDATE()
IF @Code IS NULL OR @Name IS NULL OR @StockAvailable IS NULL OR @Price IS NULL OR @DniProvider IS NULL
return
ELSE
BEGIN 
UPDATE Products SET CodeProduct = @Code, NameProduct = @Name, StockAvailable = @StockAvailable, Price = @Price, Dniprovider = @DniProvider,lastUpdate = @LastDate WHERE CodeProduct = @Code
END
END
GO
/****** Object:  StoredProcedure [dbo].[Update_Provider]    Script Date: 05/03/2024 01:11:39 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[Update_Provider] 
@Dni char(8),
@Name varchar(30),
@Telephone varchar(15),
@Country varchar (30)
AS BEGIN 
IF @Name IS NOT NULL or @Dni IS NOT NULL or @Telephone IS NOT NULL or @Country IS NOT NULL 
UPDATE Providers SET DniProvider = @Dni, NameProvider = @Name, TelephoneProvider = @Telephone, CountryProvider = @Country WHERE DniProvider = @Dni
END

GO
/****** Object:  StoredProcedure [dbo].[update_StockBuy]    Script Date: 05/03/2024 01:11:39 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[update_StockBuy]
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
GO
/****** Object:  StoredProcedure [dbo].[Update_User]    Script Date: 05/03/2024 01:11:39 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[Update_User]
    @IdUser CHAR(8),
    @Password VARCHAR(100),
    @TypeUser VARCHAR(30),
    @NameUser VARCHAR(30),
    @TelephoneUser VARCHAR(15),
    @emailUser VARCHAR(30),
    @IdClave INT
AS 
BEGIN 
    IF @IdUser IS NULL OR @Password IS NULL OR @TypeUser IS NULL OR @NameUser IS NULL OR @emailUser IS NULL OR @TelephoneUser IS NULL OR @IdClave IS NULL
    RETURN;
    ELSE
    BEGIN
        UPDATE UserMain 
        SET PassWordUser = @Password,
            TypeUser = @TypeUser,
            NameUser = @NameUser,
            TelephoneUser = @TelephoneUser,
            emailUser = @emailUser,
            IdClave = @IdClave 
        WHERE IdUser = @IdUser;
    END 
END
GO
USE [master]
GO
ALTER DATABASE [SYSTEMSOLES] SET  READ_WRITE 
GO
