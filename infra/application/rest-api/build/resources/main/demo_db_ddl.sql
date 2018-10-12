create database CaepiaDemoBD collate SQL_Latin1_General_CP1_CI_AS
go

create table VendorCostCenters
(
	PK_Vendor int not null,
	PK_CostCenter int not null,
	CatalogType int not null,
	VendorPriority int constraint DF_VendorCostCenters_VendorPriority default 0 not null,
	AlterCalendarFixed int,
	AlterCalendarType int,
	AlterCalendarParams int,
	AlterCalendarInfo varchar(512),
	AlterSendChannels int,
	AlterContactName varchar(128),
	AlterContactCellPhone varchar(16),
	Status int constraint DF_VendorCostCenters_Status default 1 not null,
	InsertDate datetime constraint DF_VendorCostCenters_InsertDate default getdate() not null,
	UpdateDate datetime constraint DF_VendorCostCenters_UpdateDate default getdate() not null,
	UpdateUser int constraint DF_VendorCostCenters_UpdateUser default 0 not null,
	constraint PK_VendorCostCenters
		primary key (PK_Vendor, PK_CostCenter)
)
go

create table SalesProducts
(
	PK_SalesProduct int not null
		constraint PK_SalesProducts
			primary key,
	Name varchar(128) not null,
	FK_SalesCategoryL3 int not null,
	ProductType int constraint DF_SalesProducts_ProductType default 1 not null,
	FK_Unit int,
	FK_BaseUnit int,
	BaseUnitRatio decimal(18,3),
	Comment varchar(128),
	Status int constraint DF_SalesProducts_Status default 1 not null,
	InsertDate datetime constraint DF_SalesProducts_InsertDate default getdate() not null,
	UpdateDate datetime constraint DF_SalesProducts_UpdateDate default getdate() not null,
	UpdateUser int constraint DF_SalesProducts_UpdateUser default 0 not null
)
go

create table PurchasesTrends
(
	PK_Product int not null,
	PK_CostCenter int not null,
	PK_Vendor int not null,
	GraphType int not null,
	BeginMonth int not null,
	BeginYear int not null,
	ValueMonth1 decimal(18,3),
	ValueMonth2 decimal(18,3),
	ValueMonth3 decimal(18,3),
	ValueMonth4 decimal(18,3),
	ValueMonth5 decimal(18,3),
	ValueMonth6 decimal(18,3),
	ValueMonth7 decimal(18,3),
	ValueMonth8 decimal(18,3),
	ValueMonth9 decimal(18,3),
	ValueMonth10 decimal(18,3),
	ValueMonth11 decimal(18,3),
	ValueMonth12 decimal(18,3),
	ValueKpi1 decimal(18,3),
	ValueKpi2 decimal(18,3),
	ValueKpi3 decimal(18,3),
	constraint PK_PurchasesTrends
		primary key (PK_Product, PK_CostCenter, PK_Vendor, GraphType)
)
go

create table SalesProductCostCenters
(
	PK_SalesProduct int not null,
	PK_CostCenter int not null,
	Status int constraint DF_SalesProductCostCenters_Status default 1 not null,
	InsertDate datetime constraint DF_SalesProductCostCenters_InsertDate default getdate() not null,
	UpdateDate datetime constraint DF_SalesProductCostCenters_UpdateDate default getdate() not null,
	UpdateUser int constraint DF_SalesProductCostCenters_UpdateUser default 0 not null,
	constraint PK_SalesProductCostCenters
		primary key (PK_SalesProduct, PK_CostCenter)
)
go

create table ProdOrdersSalesProdDet
(
	PK_ProductionOrder int not null,
	PK_SalesProduct int not null,
	Quantity int not null,
	InsertDate datetime constraint DF_ProdOrdersSalesProductCab_InsertDate default getdate() not null,
	UpdateDate datetime constraint DF_ProdOrdersSalesProductCab_UpdateDate default getdate() not null,
	UpdateUser int constraint DF_ProdOrdersSalesProductCab_UpdateUser default 0 not null,
	constraint PK_ProdOrdersSalesProductCab
		primary key (PK_ProductionOrder, PK_SalesProduct)
)
go

create table Products
(
	PK_Product int not null
		constraint PK_Products
			primary key,
	Name varchar(128) not null,
	FK_CategoryL3 int not null,
	FK_Unit int not null,
	ProductType int constraint DF_Products_ProductType default 1 not null,
	FK_BaseUnit int,
	BaseUnitRatio decimal(18,3),
	AlterTaxCode int,
	Status int constraint DF_Products_Status default 1 not null,
	InsertDate datetime constraint DF_Products_InsertDate default getdate() not null,
	UpdateDate datetime constraint DF_Products_UpdateDate default getdate() not null,
	UpdateUser int constraint DF_Products_UpdateUser default 0 not null
)
go

create table ProdOrdersProdDet
(
	PK_ProductionOrder int not null,
	PK_Row int not null,
	FK_Vendor int,
	FK_Product int not null,
	FK_LogisticChain int not null,
	FK_Pack int not null,
	PackItems decimal(18,3),
	PackQuantity decimal(18,3),
	BaseQuantity decimal(18,3),
	Amount decimal(18,3),
	AmountTax decimal(18,3),
	TaxCode int,
	Tax decimal(18,3),
	Comments varchar(512),
	InsertDate datetime constraint DF_ProdOrdersProdDet_InsertDate default getdate() not null,
	UpdateDate datetime constraint DF_ProdOrdersProdDet_UpdateDate default getdate() not null,
	UpdateUser int constraint DF_ProdOrdersProdDet_UpdateUser default 0 not null,
	constraint PK_ProdOrdersProdDet
		primary key (PK_ProductionOrder, PK_Row)
)
go

create table ProdOrdersConnectionDet
(
	PK_ProductionOrder int not null,
	PK_Row int not null,
	PK_SalesProduct int not null,
	Quantity decimal(18,3),
	InsertDate datetime constraint DF_ProdOrdersConnectionDet_InsertDate default getdate() not null,
	UpdateDate datetime constraint DF_ProdOrdersConnectionDet_UpdateDate default getdate() not null,
	UpdateUser int constraint DF_ProdOrdersConnectionDet_UpdateUser default 0 not null,
	constraint PK_ProdOrdersConnectionDet
		primary key (PK_ProductionOrder, PK_Row, PK_SalesProduct)
)
go

create table OrdersCab
(
	PK_Order int not null
		constraint PK_OrdersCab
			primary key,
	FK_CostCenter int not null,
	OrderDate datetime not null,
	OrderType char(1) not null,
	FK_Vendor int,
	FK_CostCenterDst int,
	TotalAmount decimal(18,3),
	TotalAmountTax decimal(18,3),
	TotalTax decimal(18,3),
	DeliveryDate datetime,
	DeliveryPlanDate datetime,
	Comments varchar(512),
	FK_ProductionOrder int,
	TextWhatsAppOrder varchar(2048),
	Status int not null,
	Owner int not null,
	UserSent int,
	InsertDate datetime constraint DF_OrdersCab_InsertDate default getdate() not null,
	UpdateDate datetime constraint DF_OrdersCab_UpdateDate default getdate() not null,
	UpdateUser int constraint DF_OrdersCab_UpdateUser default 0 not null
)
go

create table SendChannels
(
	PK_SendChannel int not null
		constraint PK_SendChannels
			primary key,
	Name varchar(64)
)
go

create table UsersApp
(
	PK_User int not null
		constraint PK_UsersApp
			primary key,
	Name varchar(64),
	Surname varchar(128),
	Email varchar(256),
	UK_UserLogin varchar(256) not null,
	Status int constraint DF_UsersApp_Status default 1 not null,
	InsertDate datetime constraint DF_UsersApp_InsertDate default getdate() not null,
	UpdateDate datetime constraint DF_UsersApp_UpdateDate default getdate() not null,
	UpdateUser int constraint DF_UsersApp_UpdateUser default 0 not null
)
go

create table UserCostCenters
(
	PK_User int not null,
	PK_CostCenter int not null,
	Status int constraint DF_UserCostCenters_Status default 1 not null,
	InsertDate datetime constraint DF_UserCostCenters_InsertDate default getdate() not null,
	UpdateDate datetime constraint DF_UserCostCenters_UpdateDate default getdate() not null,
	UpdateUser int constraint DF_UserCostCenters_UpdateUser default 0 not null,
	constraint PK_UserCostCenters
		primary key (PK_User, PK_CostCenter)
)
go

create table VendorCostCentersProducts
(
	PK_Vendor int not null,
	PK_CostCenter int not null,
	PK_Product int not null,
	PK_LogisticChain int not null,
	FK_Pack int not null,
	PackItems decimal(18,3) not null,
	VendorRef varchar(32),
	VendorDesc varchar(128),
	EAN varchar(16),
	VendorCategory varchar(32),
	VendorCatDesc varchar(128),
	LogisticChainPriority int constraint DF_VendorCostCentersProducts_LogisticChainPriority default 0 not null,
	swOrderEnabled int constraint DF_VendorCostCentersProducts_swOrderEnabled default 1 not null,
	CurrentCost decimal(18,3),
	CurrentCostTax decimal(18,3),
	CurrentCostTrend int,
	swBookmark int constraint DF_VendorCostCentersProducts_swBooakmark default 1 not null,
	MinimumOrder decimal(18,3),
	AlterCostType int,
	Status int constraint DF_VendorCostCentersProducts_Status default 1 not null,
	InsertDate datetime constraint DF_VendorCostCentersProducts_InsertDate default getdate() not null,
	UpdateDate datetime constraint DF_VendorCostCentersProducts_UpdateDate default getdate() not null,
	UpdateUser int constraint DF_VendorCostCentersProducts_UpdateUser default 0 not null,
	constraint PK_VendorCostCentersProducts
		primary key (PK_Vendor, PK_CostCenter, PK_Product, PK_LogisticChain)
)
go

create table UserProfiles
(
	PK_User int not null,
	PK_Profile varchar(64) not null,
	Actions varchar(8) not null,
	InsertDate datetime constraint DF_UserProfiles_InsertDate default getdate() not null,
	UpdateDate datetime constraint DF_UserProfiles_UpdateDate default getdate() not null,
	UpdateUser int constraint DF_UserProfiles_UpdateUser default 0 not null,
	constraint PK_UserProfiles
		primary key (PK_User, PK_Profile)
)
go

create table StatusDocs
(
	PK_Status int not null,
	PK_Document int not null,
	StatusName varchar(32),
	StatusOrder int,
	constraint PK_Status
		primary key (PK_Status, PK_Document)
)
go

create table CostCenters
(
	PK_CostCenter int not null
		constraint PK_CostCenters
			primary key,
	FK_Company int not null,
	Name varchar(64) not null,
	Adress1 varchar(64),
	Adress2 varchar(64),
	ZipCode varchar(16),
	City varchar(64),
	State varchar(64),
	Comment varchar(256),
	Status int constraint DF_CostCenters_Status default 1 not null,
	InsertDate datetime constraint DF_CostCenters_InsertDate default getdate() not null,
	UpdateDate datetime constraint DF_CostCenters_UpdateDate default getdate() not null,
	UpdateUser int constraint DF_CostCenters_UpdateUser default 0 not null
)
go

create table Companies
(
	PK_Company int not null
		constraint PK_Companies
			primary key,
	Name varchar(64) not null,
	Adress1 varchar(64),
	Adress2 varchar(64),
	ZipCode varchar(16),
	City varchar(64),
	State varchar(64),
	Comment varchar(256),
	Status int constraint DF_Companies_Status default 1 not null,
	InsertDate datetime constraint DF_Companies_InsertDate default getdate() not null,
	UpdateDate datetime constraint DF_Companies_UpdateDate default getdate() not null,
	UpdateUser int constraint DF_Companies_UpdateUser default 0 not null
)
go

create table AppParams
(
	PK_Param varchar(32) not null
		constraint PK_AppParams
			primary key,
	Value varchar(256) not null,
	InsertDate datetime constraint DF_AppParams_InsertDate default getdate() not null,
	UpdateDate datetime constraint DF_AppParams_UpdateDate default getdate() not null,
	UpdateUser int constraint DF_AppParams_UpdateUser default 0 not null
)
go

create table OrdersDet
(
	PK_Order int not null,
	PK_Row int not null,
	FK_Product int not null,
	FK_LogisticChain int not null,
	FK_Pack int not null,
	PackItems decimal(18,3),
	PackQuantity decimal(18,3),
	BaseQuantity decimal(18,3),
	Amount decimal(18,3),
	AmountTax decimal(18,3),
	TaxCode int,
	Tax decimal(18,3),
	Comments varchar(512),
	InsertDate datetime constraint DF_OrdersDet_InsertDate default getdate() not null,
	UpdateDate datetime constraint DF_OrdersDet_UpdateDate default getdate() not null,
	UpdateUser int constraint DF_OrdersDet_UpdateUser default 0 not null,
	constraint PK_OrdersDet
		primary key (PK_Order, PK_Row)
)
go

create table ProdOrdersCab
(
	PK_ProductionOrder int not null
		constraint PK_ProductionOrdersCab
			primary key,
	FK_CostCenter int not null,
	ProdOrderDate datetime not null,
	Status int not null,
	Owner int not null,
	InsertDate datetime constraint DF_ProductionOrdersCab_InsertDate default getdate() not null,
	UpdateDate datetime constraint DF_ProductionOrdersCab_UpdateDate default getdate() not null,
	UpdateUser int constraint DF_ProductionOrdersCab_UpdateUser default 0 not null
)
go

create table Categories
(
	PK_Category int not null
		constraint PK_Categories
			primary key,
	FK_CategoryL1 int not null,
	FK_CategoryL2 int not null,
	Name varchar(64) not null,
	CategoryLevel int not null,
	TaxCode int,
	Status int constraint DF_Categories_Status default 1 not null,
	InsertDate datetime constraint DF_Categories_InsertDate default getdate() not null,
	UpdateDate datetime constraint DF_Categories_UpdateDate default getdate() not null,
	UpdateUser int constraint DF_Categories_UpdateUser default 0 not null
)
go

create table Vendors
(
	PK_Vendor int not null
		constraint PK_Vendors
			primary key,
	Name varchar(64) not null,
	NIF varchar(16),
	Adress1 varchar(64),
	Adress2 varchar(64),
	ZipCode varchar(16),
	City varchar(64),
	State varchar(64),
	CostType int constraint DF_Vendors_CostType default 0 not null,
	UpdateCostType int constraint DF_Vendors_UpdateCostType default 0 not null,
	swCatalogFixed int constraint DF_Vendors_swCatalogFixed default 0 not null,
	CalendarFixed int constraint DF_Vendors_CalendarFixed default 0 not null,
	CalendarType int constraint DF_Vendors_CalendarType default 0 not null,
	CalendarParams int constraint DF_Vendors_CalendarParams default 0 not null,
	CalendarInfo varchar(512),
	SendChannels int constraint DF_Vendors_SendChannels default 0 not null,
	ImportCatalogProcess varchar(64),
	ExportOrderEDIProcess varchar(64),
	ExportOrderMailProcess varchar(64),
	ExportOrderWhatsAppProcess varchar(64),
	ContactName varchar(128),
	ContactPhone varchar(16),
	ContactCellPhone varchar(16),
	Status int constraint DF_Vendors_Status default 1 not null,
	InsertDate datetime constraint DF_Vendors_InsertDate default getdate() not null,
	UpdateDate datetime constraint DF_Vendors_UpdateDate default getdate() not null,
	UpdateUser int constraint DF_Vendors_UpdateUser default 0 not null
)
go

create table Packs
(
	PK_Pack int not null
		constraint PK_Packs
			primary key,
	Name varchar(32) not null,
	ShortName varchar(8) not null,
	PackType int constraint DF_Packs_PackType default 1 not null,
	Status int constraint DF_Packs_Status default 1 not null,
	InsertDate datetime constraint DF_Packs_InsertDate default getdate() not null,
	UpdateDate datetime constraint DF_Packs_UpdateDate default getdate() not null,
	UpdateUser int constraint DF_Packs_UpdateUser default 0 not null
)
go

create table Units
(
	PK_Unit int not null
		constraint PK_Units
			primary key,
	Name varchar(32) not null,
	ShortName varchar(5) not null,
	Status int constraint DF_Units_Status default 1 not null,
	InsertDate datetime constraint DF_Units_InsertDate default getdate() not null,
	UpdateDate datetime constraint DF_Units_UpdateDate default getdate() not null,
	UpdateUser int constraint DF_Units_UpdateUser default 0 not null
)
go

CREATE VIEW dbo.vApiUnits
AS
SELECT        PK_Unit, Name, ShortName, Status
FROM            dbo.Units
go

CREATE VIEW dbo.vApiOrdersWhatsAppParams
AS
SELECT        dbo.OrdersCab.PK_Order, dbo.OrdersCab.TextWhatsAppOrder, dbo.vApiCenterVendors.ContactCellPhone
FROM            dbo.OrdersCab LEFT OUTER JOIN
                         dbo.vApiCenterVendors ON dbo.OrdersCab.FK_CostCenter = dbo.vApiCenterVendors.PK_CostCenter AND dbo.OrdersCab.FK_Vendor = dbo.vApiCenterVendors.PK_Vendor
go

CREATE VIEW dbo.vAPIOrdersRows
AS
SELECT        dbo.OrdersDet.PK_Order, dbo.OrdersDet.PK_Row, dbo.OrdersDet.FK_Product, dbo.vApiVendorCostCentersProducts.ProductName, dbo.vApiVendorCostCentersProducts.PackName, dbo.OrdersDet.PackQuantity,
                         dbo.OrdersDet.BaseQuantity, - 1 AS PackCost, - 1 AS PackCostTax, - 1 AS BaseCost, - 1 AS BaseCostTax, dbo.OrdersDet.Amount, dbo.OrdersDet.AmountTax, dbo.OrdersDet.TaxCode, CASE ISNULL(dbo.OrdersDet.PackQuantity,
                         0) WHEN 0 THEN 'R' ELSE 'W' END AS getType, dbo.vApiVendorCostCentersProducts.FK_CategoryL3, dbo.vApiVendorCostCentersProducts.swBookmark, dbo.vApiVendorCostCentersProducts.UnitShortName,
                         dbo.vApiVendorCostCentersProducts.PackItems, dbo.vApiVendorCostCentersProducts.CurrentCostTrend, dbo.vApiVendorCostCentersProducts.MinimumOrder, dbo.vApiVendorCostCentersProducts.VendorRef,
                         dbo.vApiVendorCostCentersProducts.VendorDesc
FROM            dbo.OrdersDet INNER JOIN
                         dbo.OrdersCab ON dbo.OrdersDet.PK_Order = dbo.OrdersCab.PK_Order LEFT OUTER JOIN
                         dbo.vApiVendorCostCentersProducts ON dbo.OrdersCab.FK_CostCenter = dbo.vApiVendorCostCentersProducts.PK_CostCenter AND dbo.OrdersDet.FK_Product = dbo.vApiVendorCostCentersProducts.PK_Product AND
                         dbo.OrdersCab.FK_Vendor = dbo.vApiVendorCostCentersProducts.PK_Vendor AND dbo.OrdersDet.FK_LogisticChain = dbo.vApiVendorCostCentersProducts.PK_LogisticChain
go

CREATE VIEW dbo.vAPIProdOrdersHeader
AS
SELECT        dbo.ProdOrdersCab.PK_ProductionOrder, RIGHT(CAST(100000000 + dbo.ProdOrdersCab.PK_ProductionOrder AS varchar), 8) AS ProductionOrderNum, dbo.ProdOrdersCab.FK_CostCenter, dbo.ProdOrdersCab.ProdOrderDate,
                         dbo.ProdOrdersCab.Status, dbo.ProdOrdersCab.Owner, dbo.vApiUsers.Name AS UserName, dbo.CostCenters.Name AS CostCenterName
FROM            dbo.ProdOrdersCab LEFT OUTER JOIN
                         dbo.CostCenters ON dbo.ProdOrdersCab.FK_CostCenter = dbo.CostCenters.PK_CostCenter LEFT OUTER JOIN
                         dbo.vApiUsers ON dbo.ProdOrdersCab.Owner = dbo.vApiUsers.PK_User
go

CREATE VIEW dbo.vAPIProdOrdersSalesProducts
AS
SELECT        dbo.ProdOrdersSalesProdDet.PK_ProductionOrder, dbo.ProdOrdersSalesProdDet.PK_SalesProduct, dbo.ProdOrdersSalesProdDet.Quantity, dbo.SalesProducts.Name, dbo.SalesProducts.Comment AS UnitsName
FROM            dbo.ProdOrdersSalesProdDet LEFT OUTER JOIN
                         dbo.SalesProducts ON dbo.ProdOrdersSalesProdDet.PK_SalesProduct = dbo.SalesProducts.PK_SalesProduct
go

CREATE VIEW dbo.vAPIProdOrdersProducts
AS
SELECT        dbo.ProdOrdersProdDet.PK_ProductionOrder, dbo.ProdOrdersProdDet.PK_Row, dbo.ProdOrdersProdDet.FK_Product, dbo.vApiVendorCostCentersProducts.ProductName, NULL AS PK_SalesProduct, NULL
                         AS SalesProductName, NULL AS ReceiptCount, dbo.vApiVendorCostCentersProducts.PackName, dbo.ProdOrdersProdDet.PackQuantity, dbo.ProdOrdersProdDet.BaseQuantity, - 1 AS PackCost, - 1 AS PackCostTax,
                         - 1 AS BaseCost, - 1 AS BaseCostTax, dbo.ProdOrdersProdDet.Amount, dbo.ProdOrdersProdDet.AmountTax, dbo.ProdOrdersProdDet.TaxCode, 'W' AS getType, dbo.vApiVendorCostCentersProducts.FK_CategoryL3,
                         dbo.vApiVendorCostCentersProducts.swBookmark, dbo.vApiVendorCostCentersProducts.UnitShortName, dbo.vApiVendorCostCentersProducts.PackItems, dbo.vApiVendorCostCentersProducts.CurrentCostTrend,
                         dbo.vApiVendorCostCentersProducts.MinimumOrder
FROM            dbo.ProdOrdersProdDet INNER JOIN
                         dbo.ProdOrdersCab ON dbo.ProdOrdersProdDet.PK_ProductionOrder = dbo.ProdOrdersCab.PK_ProductionOrder LEFT OUTER JOIN
                         dbo.vApiVendorCostCentersProducts ON dbo.ProdOrdersCab.FK_CostCenter = dbo.vApiVendorCostCentersProducts.PK_CostCenter AND
                         dbo.ProdOrdersProdDet.FK_LogisticChain = dbo.vApiVendorCostCentersProducts.PK_LogisticChain AND dbo.ProdOrdersProdDet.FK_Product = dbo.vApiVendorCostCentersProducts.PK_Product AND
                         dbo.ProdOrdersProdDet.FK_Vendor = dbo.vApiVendorCostCentersProducts.PK_Vendor
go

CREATE VIEW dbo.vAPIProdOrdersProductsByReceipt
AS
SELECT        dbo.ProdOrdersProdDet.PK_ProductionOrder, dbo.ProdOrdersProdDet.PK_Row, dbo.ProdOrdersProdDet.FK_Product, dbo.vApiVendorCostCentersProducts.ProductName, dbo.ProdOrdersConnectionDet.PK_SalesProduct,
                         dbo.SalesProducts.Name AS SalesProductName, dbo.vProdOrdersRowReceiptCount.ReceiptCount, dbo.vApiVendorCostCentersProducts.PackName, dbo.ProdOrdersProdDet.PackQuantity, dbo.ProdOrdersProdDet.BaseQuantity,
                         - 1 AS PackCost, - 1 AS PackCostTax, - 1 AS BaseCost, - 1 AS BaseCostTax, dbo.ProdOrdersProdDet.Amount, dbo.ProdOrdersProdDet.AmountTax, dbo.ProdOrdersProdDet.TaxCode, 'W' AS getType,
                         dbo.vApiVendorCostCentersProducts.FK_CategoryL3, dbo.vApiVendorCostCentersProducts.swBookmark, dbo.vApiVendorCostCentersProducts.UnitShortName, dbo.vApiVendorCostCentersProducts.PackItems,
                         dbo.vApiVendorCostCentersProducts.CurrentCostTrend, dbo.vApiVendorCostCentersProducts.MinimumOrder
FROM            dbo.vProdOrdersRowReceiptCount RIGHT OUTER JOIN
                         dbo.ProdOrdersProdDet INNER JOIN
                         dbo.ProdOrdersCab ON dbo.ProdOrdersProdDet.PK_ProductionOrder = dbo.ProdOrdersCab.PK_ProductionOrder ON dbo.vProdOrdersRowReceiptCount.PK_ProductionOrder = dbo.ProdOrdersProdDet.PK_ProductionOrder AND
                         dbo.vProdOrdersRowReceiptCount.PK_Row = dbo.ProdOrdersProdDet.PK_Row LEFT OUTER JOIN
                         dbo.SalesProducts RIGHT OUTER JOIN
                         dbo.ProdOrdersConnectionDet ON dbo.SalesProducts.PK_SalesProduct = dbo.ProdOrdersConnectionDet.PK_SalesProduct ON
                         dbo.ProdOrdersProdDet.PK_ProductionOrder = dbo.ProdOrdersConnectionDet.PK_ProductionOrder AND dbo.ProdOrdersProdDet.PK_Row = dbo.ProdOrdersConnectionDet.PK_Row LEFT OUTER JOIN
                         dbo.vApiVendorCostCentersProducts ON dbo.ProdOrdersCab.FK_CostCenter = dbo.vApiVendorCostCentersProducts.PK_CostCenter AND
                         dbo.ProdOrdersProdDet.FK_LogisticChain = dbo.vApiVendorCostCentersProducts.PK_LogisticChain AND dbo.ProdOrdersProdDet.FK_Product = dbo.vApiVendorCostCentersProducts.PK_Product AND
                         dbo.ProdOrdersProdDet.FK_Vendor = dbo.vApiVendorCostCentersProducts.PK_Vendor
go

CREATE VIEW dbo.vBaseCategoryL1
AS
SELECT        PK_Category, Name, Status, CategoryLevel
FROM            dbo.Categories
WHERE        (CategoryLevel = 1)
go

CREATE VIEW dbo.vProdOrdersRowReceiptCount
AS
SELECT        PK_ProductionOrder, PK_Row, COUNT(PK_SalesProduct) AS ReceiptCount
FROM            dbo.ProdOrdersConnectionDet
GROUP BY PK_ProductionOrder, PK_Row
go

CREATE VIEW dbo.vBaseCategoryL2
AS
SELECT        PK_Category, FK_CategoryL1, Name, Status
FROM            dbo.Categories
WHERE        (CategoryLevel = 2)
go

CREATE VIEW dbo.vBaseCategoryL3
AS
SELECT        PK_Category, FK_CategoryL1, FK_CategoryL2, Name, TaxCode, Status
FROM            dbo.Categories
WHERE        (CategoryLevel = 3)
go

CREATE VIEW dbo.vBaseProducts
AS
SELECT        dbo.Products.PK_Product, dbo.Products.Name, dbo.Products.FK_CategoryL3, dbo.vBaseCategoryL3.Name AS CategoryL3Name, dbo.Products.FK_Unit, dbo.Units.Name AS UnitName, dbo.Units.ShortName AS UnitShortName,
                         dbo.Products.ProductType, dbo.Products.FK_BaseUnit, Units_1.Name AS BaseUnitName, Units_1.ShortName AS BaseUnitShortName, dbo.Products.BaseUnitRatio, dbo.Products.Status, ISNULL(dbo.Products.AlterTaxCode,
                         dbo.vBaseCategoryL3.TaxCode) AS TaxCode
FROM            dbo.vBaseCategoryL3 RIGHT OUTER JOIN
                         dbo.Units AS Units_1 RIGHT OUTER JOIN
                         dbo.Products ON Units_1.PK_Unit = dbo.Products.FK_BaseUnit LEFT OUTER JOIN
                         dbo.Units ON dbo.Products.FK_Unit = dbo.Units.PK_Unit ON dbo.vBaseCategoryL3.PK_Category = dbo.Products.FK_CategoryL3
go

CREATE VIEW dbo.vApiCenterVendors
AS
SELECT        dbo.VendorCostCenters.PK_CostCenter, dbo.CostCenters.Name AS CenterName, dbo.VendorCostCenters.PK_Vendor, dbo.Vendors.Name AS VendorName, dbo.Vendors.NIF, dbo.Vendors.Adress1, dbo.Vendors.Adress2,
                         dbo.Vendors.ZipCode, dbo.Vendors.City, dbo.Vendors.State, dbo.VendorCostCenters.CatalogType, dbo.VendorCostCenters.VendorPriority, ISNULL(dbo.VendorCostCenters.AlterCalendarFixed, dbo.Vendors.CalendarFixed)
                         AS CalendarFixed, ISNULL(dbo.VendorCostCenters.AlterCalendarType, dbo.Vendors.CalendarType) AS CalendarType, ISNULL(dbo.VendorCostCenters.AlterCalendarParams, dbo.Vendors.CalendarParams) AS CalendarParams,
                         ISNULL(dbo.VendorCostCenters.AlterCalendarInfo, dbo.Vendors.CalendarInfo) AS CalendarInfo, ISNULL(dbo.VendorCostCenters.AlterSendChannels, dbo.Vendors.SendChannels) AS SendChannels,
                         ISNULL(SendChannels_1.Name, dbo.SendChannels.Name) AS SendChannelsName, ISNULL(dbo.VendorCostCenters.AlterContactName, dbo.Vendors.ContactName) AS ContactName, dbo.Vendors.ContactPhone,
                         ISNULL(dbo.VendorCostCenters.AlterContactCellPhone, dbo.Vendors.ContactCellPhone) AS ContactCellPhone, dbo.VendorCostCenters.Status, ISNULL(dbo.vBaseCenterVendorsProductsCount.ProductsCount, 0) AS ProductsCount,
                         ISNULL(dbo.vBaseCenterVendorsProductsBookmarkCount.ProductsBookmarkCount, 0) AS ProductsBookmarkCount, dbo.Vendors.swCatalogFixed
FROM            dbo.SendChannels AS SendChannels_1 RIGHT OUTER JOIN
                         dbo.VendorCostCenters LEFT OUTER JOIN
                         dbo.vBaseCenterVendorsProductsBookmarkCount ON dbo.VendorCostCenters.PK_Vendor = dbo.vBaseCenterVendorsProductsBookmarkCount.PK_Vendor AND
                         dbo.VendorCostCenters.PK_CostCenter = dbo.vBaseCenterVendorsProductsBookmarkCount.PK_CostCenter LEFT OUTER JOIN
                         dbo.vBaseCenterVendorsProductsCount ON dbo.VendorCostCenters.PK_Vendor = dbo.vBaseCenterVendorsProductsCount.PK_Vendor AND
                         dbo.VendorCostCenters.PK_CostCenter = dbo.vBaseCenterVendorsProductsCount.PK_CostCenter ON SendChannels_1.PK_SendChannel = dbo.VendorCostCenters.AlterSendChannels LEFT OUTER JOIN
                         dbo.CostCenters ON dbo.VendorCostCenters.PK_CostCenter = dbo.CostCenters.PK_CostCenter LEFT OUTER JOIN
                         dbo.SendChannels RIGHT OUTER JOIN
                         dbo.Vendors ON dbo.SendChannels.PK_SendChannel = dbo.Vendors.SendChannels ON dbo.VendorCostCenters.PK_Vendor = dbo.Vendors.PK_Vendor
go

CREATE VIEW dbo.vBaseCenterVendorsProductsCount
AS
SELECT        PK_Vendor, PK_CostCenter, COUNT(PK_Product) AS ProductsCount
FROM            dbo.VendorCostCentersProducts
GROUP BY PK_Vendor, PK_CostCenter, PK_LogisticChain, Status
HAVING        (PK_LogisticChain = 0) AND (Status = 1)
go

CREATE VIEW dbo.vBaseCenterVendorsProductsBookmarkCount
AS
SELECT        PK_Vendor, PK_CostCenter, COUNT(PK_Product) AS ProductsBookmarkCount
FROM            dbo.VendorCostCentersProducts
GROUP BY PK_Vendor, PK_CostCenter, PK_LogisticChain, Status, swBookmark
HAVING        (PK_LogisticChain = 0) AND (Status = 1) AND (swBookmark = 1)
go

CREATE VIEW dbo.vAPICenterVendorsCategoriesL3
AS
SELECT        dbo.VendorCostCentersProducts.PK_Vendor, dbo.VendorCostCentersProducts.PK_CostCenter, dbo.Products.FK_CategoryL3, dbo.vBaseCategoryL3.Name AS CategoryName
FROM            dbo.VendorCostCentersProducts INNER JOIN
                         dbo.Products ON dbo.VendorCostCentersProducts.PK_Product = dbo.Products.PK_Product INNER JOIN
                         dbo.vBaseCategoryL3 ON dbo.Products.FK_CategoryL3 = dbo.vBaseCategoryL3.PK_Category
GROUP BY dbo.VendorCostCentersProducts.PK_Vendor, dbo.VendorCostCentersProducts.PK_CostCenter, dbo.Products.FK_CategoryL3, dbo.vBaseCategoryL3.Name
go

CREATE VIEW dbo.vApiPurchasesTrends
AS
SELECT        PK_Product, PK_CostCenter, PK_Vendor, GraphType, BeginMonth, BeginYear, ValueMonth1, ValueMonth2, ValueMonth3, ValueMonth4, ValueMonth5, ValueMonth6, ValueMonth7, ValueMonth8, ValueMonth9, ValueMonth10,
                         ValueMonth11, ValueMonth12, ValueKpi1, ValueKpi2, ValueKpi3
FROM            dbo.PurchasesTrends
go

CREATE VIEW dbo.vApiVendorCostCentersProducts
AS
SELECT        dbo.VendorCostCentersProducts.PK_Vendor, dbo.VendorCostCentersProducts.PK_CostCenter, dbo.VendorCostCentersProducts.PK_Product, dbo.VendorCostCentersProducts.PK_LogisticChain,
                         CASE PK_LogisticChain WHEN 0 THEN 0 ELSE 1 END AS LogisticChainType, dbo.VendorCostCentersProducts.FK_Pack, dbo.VendorCostCentersProducts.PackItems, dbo.VendorCostCentersProducts.VendorRef,
                         dbo.VendorCostCentersProducts.swOrderEnabled, dbo.VendorCostCentersProducts.CurrentCost, CONVERT(varchar, dbo.VendorCostCentersProducts.CurrentCost)
                         + ' € / ' + dbo.vBaseProducts.UnitShortName AS CurrentCostFormat, dbo.VendorCostCentersProducts.CurrentCostTax, dbo.VendorCostCentersProducts.CurrentCostTrend, dbo.VendorCostCentersProducts.swBookmark,
                         dbo.VendorCostCentersProducts.MinimumOrder, dbo.VendorCostCentersProducts.Status, CASE PK_LogisticChain WHEN 0 THEN dbo.vBaseProducts.UnitShortName ELSE dbo.Packs.Name + ' ' + CONVERT(varchar,
                         dbo.VendorCostCentersProducts.PackItems) + ' ' + dbo.vBaseProducts.UnitShortName END AS PackName, dbo.vBaseProducts.Name AS ProductName, dbo.vBaseProducts.FK_CategoryL3, dbo.vBaseProducts.CategoryL3Name,
                         dbo.vBaseProducts.FK_Unit, dbo.vBaseProducts.UnitName, dbo.vBaseProducts.UnitShortName, dbo.VendorCostCentersProducts.CurrentCost * dbo.vBaseProducts.BaseUnitRatio AS CostBaseUnits, CONVERT(varchar,
                         dbo.VendorCostCentersProducts.CurrentCost) + ' € / ' + dbo.vBaseProducts.UnitShortName AS CostBaseUnitsFormat, dbo.vBaseProducts.BaseUnitShortName, dbo.VendorCostCentersProducts.EAN, dbo.vBaseProducts.TaxCode,
                         dbo.VendorCostCentersProducts.VendorDesc
FROM            dbo.VendorCostCentersProducts INNER JOIN
                         dbo.vBaseProducts ON dbo.VendorCostCentersProducts.PK_Product = dbo.vBaseProducts.PK_Product LEFT OUTER JOIN
                         dbo.Packs ON dbo.VendorCostCentersProducts.FK_Pack = dbo.Packs.PK_Pack
go

CREATE VIEW dbo.vAPIStatusMaster
AS
SELECT        PK_Status, PK_Document, StatusName, StatusOrder
FROM            dbo.StatusDocs
go

CREATE VIEW dbo.vAPIOrdersHeader
AS
SELECT        dbo.OrdersCab.PK_Order, RIGHT(CAST(100000000 + dbo.OrdersCab.PK_Order AS varchar), 8) AS OrderNum, dbo.OrdersCab.FK_CostCenter, dbo.OrdersCab.OrderDate, dbo.OrdersCab.FK_Vendor, dbo.OrdersCab.TotalAmount,
                         dbo.OrdersCab.TotalAmountTax, dbo.OrdersCab.TotalTax, dbo.OrdersCab.DeliveryDate, dbo.OrdersCab.DeliveryPlanDate, dbo.OrdersCab.Comments, dbo.OrdersCab.FK_ProductionOrder, dbo.OrdersCab.Status,
                         dbo.OrdersCab.Owner, dbo.OrdersCab.UserSent, dbo.CostCenters.Name AS CostCenterName, ISNULL(dbo.UsersApp.Name, '') + ' ' + ISNULL(dbo.UsersApp.Surname, '') AS UserName, dbo.vApiCenterVendors.VendorName,
                         dbo.vApiCenterVendors.SendChannels, dbo.vApiCenterVendors.CalendarInfo, dbo.vApiCenterVendors.CatalogType, dbo.vApiCenterVendors.ContactCellPhone
FROM            dbo.OrdersCab LEFT OUTER JOIN
                         dbo.UsersApp ON dbo.OrdersCab.Owner = dbo.UsersApp.PK_User LEFT OUTER JOIN
                         dbo.CostCenters ON dbo.OrdersCab.FK_CostCenter = dbo.CostCenters.PK_CostCenter LEFT OUTER JOIN
                         dbo.vApiCenterVendors ON dbo.OrdersCab.FK_CostCenter = dbo.vApiCenterVendors.PK_CostCenter AND dbo.OrdersCab.FK_Vendor = dbo.vApiCenterVendors.PK_Vendor
go

CREATE VIEW dbo.vApiUserParams
AS
SELECT        dbo.AppParams.PK_Param, dbo.AppParams.Value, dbo.UsersApp.PK_User
FROM            dbo.AppParams CROSS JOIN
                         dbo.UsersApp
go

CREATE VIEW dbo.vApiUsers
AS
SELECT        UK_UserLogin, PK_User, Name, Email, Status
FROM            dbo.UsersApp
go

CREATE VIEW dbo.vApiUserCenters
AS
SELECT        dbo.UserCostCenters.PK_User, dbo.UserCostCenters.PK_CostCenter, dbo.CostCenters.Name AS CostCenterName
FROM            dbo.UserCostCenters LEFT OUTER JOIN
                         dbo.CostCenters ON dbo.UserCostCenters.PK_CostCenter = dbo.CostCenters.PK_CostCenter
WHERE        (dbo.UserCostCenters.Status = 1)
go

CREATE VIEW dbo.vApiUserPermits
AS
SELECT        PK_User, PK_Profile, Actions
FROM            dbo.UserProfiles
go

-- =============================================
-- Author:		EDUARD PASCUAL
-- Description:	Canvia l'estat de la comanda a anulada
-- =============================================
CREATE PROCEDURE [dbo].[spApiPutCancelOrder](
	@pOrder int,
	@pUser int

)
AS
	SET NOCOUNT ON;
	declare @prevStatus int
	declare @vError int
	declare @vErrDescription varchar(1024)

BEGIN TRY

	SET @vError = 0;
	SET @vErrDescription = 'OK'

	SELECT @prevStatus = Status FROM OrdersCab WHERE PK_Order = @pOrder

	IF @prevStatus >= 6 BEGIN
		SET @vError = 11009;
		SET @vErrDescription = 'No se puede modificar a estado Anulado un pedido en el estado actual'
	END ELSE BEGIN

		UPDATE OrdersCab
		SET Status = 9,
			UpdateDate = getdate(),
			UpdateUser = @pUser
		WHERE PK_Order = @pOrder

		IF @@ROWCOUNT = 0 BEGIN
			SET @vError = 11001;
			SET @vErrDescription = 'Cabecera de pedido no encontrado en la base de datos'
		END

	END

	SELECT @vError AS ErrorCode, @vErrDescription AS ErrorDescription;

END TRY
BEGIN CATCH

	SET @vError = @@ERROR
	SET @vErrDescription = 'Error SQL: ' + ERROR_MESSAGE();

--  pendent generar registre de LOG

	SELECT @vError AS ErrorCode, @vErrDescription AS ErrorDescription;

END CATCH
go

-- =============================================
-- Author:		EDUARD PASCUAL
-- Description:	Canvia l'estat de la comanda a Enviada i fa les accions pertinents
-- =============================================
CREATE PROCEDURE [dbo].[spApiPutSendOrder](
	@pOrder int,
	@pUser int

)
AS
	SET NOCOUNT ON;
	declare @vPrevStatus int
	declare @vSendChannels int
	declare @vError int
	declare @vErrDescription varchar(1024)
	declare @vtextWhatsApp varchar(2048)
	declare @vtextWhatsAppLin varchar(2048)
	declare @vContactCellPhone varchar(64)

	-- Variables per recorrer el detall de la comanda
	declare @vVendorRef varchar(64)
	declare @vPackName varchar(64)
	declare @vProductName varchar(128)
	declare @vBaseQuantity decimal(18,3)

BEGIN TRY

-- PENDENT TOTA LA GESTIO D'ENVIAMENTS FORA DE TEXT WHATSAPP

	SET @vError = 0;
	SET @vSendChannels = 0
	SET @vErrDescription = 'OK'
	SET @vtextWhatsApp = ''

	SELECT @vPrevStatus = Status, @vSendChannels = SendChannels, @vContactCellPhone = ContactCellPhone FROM vAPIOrdersHeader WHERE PK_Order = @pOrder

	IF @vPrevStatus >= 4 BEGIN
		SET @vError = 11009;
		SET @vErrDescription = 'No se puede modificar a estado a enviado un pedido en el estado actual'
	END ELSE BEGIN

		IF (@vSendChannels % 10) = 1 -- CANAL EDI
		BEGIN

			-- ****************
			-- PENDENT implementar canal EDI
			SET @vError = 0;

		END

		IF (@vSendChannels % 100 / 10) = 1 -- CANAL EMAIL
		BEGIN -- CANAL EMAIL

			-- ****************
			-- PENDENT implementar canal EMAIL
			SET @vError = 0;

		END

		IF ( @vSendChannels % 1000 / 100) = 1 -- CANAL WHATSAPP
		BEGIN

			DECLARE cursorOrderDet CURSOR FOR
			SELECT VendorRef, CASE ISNULL(VendorDesc,'') WHEN '' THEN  ProductName ELSE VendorDesc END AS ProductName, BaseQuantity, PackName
			FROM vAPIOrdersRows
			WHERE PK_Order = @pOrder
			ORDER BY PK_Row

			OPEN cursorOrderDet

			FETCH NEXT FROM cursorOrderDet
			INTO @vVendorRef, @vProductName, @vBaseQuantity, @vPackName

			WHILE @@FETCH_STATUS = 0
			BEGIN

				SET @vtextWhatsAppLin = cast(@vBaseQuantity AS varchar) + ' ' + @vPackName + ' ' +
					@vProductName + '(' + @vVendorRef + ')' + CHAR(13) + CHAR(10)


				IF (LEN(@vtextWhatsAppLin) + LEN(@vtextWhatsApp)) > 2028
				BEGIN

					SET @vError = 11019;
					SET @vErrDescription = 'Pedido demasiado largo para ser enviado por wharsapp'

					BREAK

				END

				SET @vtextWhatsApp = @vtextWhatsApp + @vtextWhatsAppLin

				FETCH NEXT FROM cursorOrderDet
				INTO @vVendorRef, @vProductName, @vBaseQuantity, @vPackName

			END

			CLOSE cursorOrderDet;
			DEALLOCATE cursorOrderDet;

		END

		IF @vError = 0
		BEGIN

			UPDATE OrdersCab
			SET Status = 4,
				TextWhatsAppOrder = @vtextWhatsApp,
				UpdateDate = getdate(),
				UpdateUser = @pUser
			WHERE PK_Order = @pOrder

			IF @@ROWCOUNT = 0 BEGIN
				SET @vError = 11001;
				SET @vErrDescription = 'Cabecera de pedido no encontrado en la base de datos'
			END

		END

	END

	SELECT @vError AS ErrorCode, @vErrDescription AS ErrorDescription, @vtextWhatsApp AS WhatsAppBody, @vContactCellPhone AS WhatsAppTel;

END TRY
BEGIN CATCH

	SET @vError =  @@ERROR
	SET @vErrDescription = 'spApiPutSendOrder - Error SQL: ' + ERROR_MESSAGE();

	DEALLOCATE cursorOrderDet;

	IF ( @vSendChannels % 1000 / 100) = 1  -- CANAL WHATSAPP
	BEGIN
		--CLOSE cursorOrderDet;
		DEALLOCATE cursorOrderDet;
	END

--  pendent generar registre de LOG

	SELECT @vError AS ErrorCode, @vErrDescription AS ErrorDescription, NULL AS WhatsAppBody, NULL AS WhatsAppTel;

END CATCH
go

-- =============================================
-- Author:		EDUARD PASCUAL
-- Description:	Crea el text WhatsApp a enviar de la comanda
-- =============================================
CREATE PROCEDURE [dbo].[spCreateTextOrderWhatsApp](
	@pOrder int
)
AS
	SET NOCOUNT ON;
	declare @vText varchar(2048)

BEGIN TRY

	RETURN @vText

END TRY
BEGIN CATCH

--  pendent generar registre de LOG

	RETURN ''

END CATCH
go

-- =============================================
-- Author:		EDUARD PASCUAL
-- Description:	Canvia l'estat de la comanda a Rebuda, crea l'albarà i fa les accions pertinents
-- =============================================
CREATE PROCEDURE [dbo].[spApiPutReceiveOrder](
	@pOrder int,
	@pUser int

)
AS
	SET NOCOUNT ON;
	declare @prevStatus int
	declare @vError int
	declare @vErrDescription varchar(1024)
	declare @vDeliveryNoteId int

BEGIN TRY

	SET @vError = 0;
	SET @vErrDescription = 'OK'

	SELECT @prevStatus = Status FROM OrdersCab WHERE PK_Order = @pOrder

	IF @prevStatus <> 4 BEGIN
		SET @vError = 11009;
		SET @vErrDescription = 'No se puede modificar a estado a recibido un pedido en el estado actual'
	END ELSE BEGIN

		UPDATE OrdersCab
		SET Status = 6,
			UpdateDate = getdate(),
			UpdateUser = @pUser
		WHERE PK_Order = @pOrder

		IF @@ROWCOUNT = 0 BEGIN
			SET @vError = 11001;
			SET @vErrDescription = 'Cabecera de pedido no encontrado en la base de datos'
		END

	END

	-- **********
	-- PENDENT TOTA LA GESTIO DE GENERACIO DE L'ALBARA
	SET @vDeliveryNoteId = 0

	SELECT @vError AS ErrorCode, @vErrDescription AS ErrorDescription, @vDeliveryNoteId AS RecordId;

END TRY
BEGIN CATCH

	SET @vError = @@ERROR
	SET @vErrDescription = 'Error SQL: ' + ERROR_MESSAGE();

--  pendent generar registre de LOG

	SELECT @vError AS ErrorCode, @vErrDescription AS ErrorDescription, NULL AS RecordId;

END CATCH
go

-- =============================================
-- Author:		EDUARD PASCUAL
-- Description:	Crea capçalera de ordre de producció
-- =============================================
CREATE PROCEDURE [dbo].[spApiPostCreateProductOrder](
	@pCostCenter int,
	@pUser int

)
AS
	SET NOCOUNT ON;
	declare @vError int
	declare @vErrDescription varchar(1024)
	declare @vOrderId int

BEGIN TRY

	SET @vError = 0;
	SET @vErrDescription = 'OK'
/*
	SELECT @vOrderId = MAX(PK_Order)+1 FROM OrdersCab
	IF @vOrderId IS NULL SET @vOrderId = 1

	INSERT INTO OrdersCab
		(PK_Order, FK_CostCenter, OrderDate, OrderType, FK_Vendor, FK_CostCenterDst, TotalAmount, TotalAmountTax,
		TotalTax, DeliveryDate, DeliveryPlanDate, Comments, FK_ProductionOrder, Status, Owner,
		UserSent, InsertDate, UpdateDate, UpdateUser)
	VALUES
		(@vOrderId, @pCostCenter, @pOrderDate, 'V', @pVendor, NULL, 0, 0, 0, NULL, @pDeliveryPlanDate, @pComments,
		NULL, @pStatus, @pUser, NULL, Getdate(), Getdate(), @pUser)
*/
	SELECT @vError AS ErrorCode, @vErrDescription AS ErrorDescription, @vOrderId AS RecordId;

END TRY
BEGIN CATCH

	SET @vError = @@ERROR
	SET @vErrDescription = 'Error SQL: ' + ERROR_MESSAGE();

--  pendent generar registre de LOG

	SELECT @vError AS ErrorCode, @vErrDescription AS ErrorDescription, NULL AS RecordId;

END CATCH
go

-- =============================================
-- Author:		EDUARD PASCUAL
-- Description:	Canvia l'estat de la comanda a anulada
-- =============================================
CREATE PROCEDURE [dbo].[spApiPutStatusProductOrder](
	@pOrder int,
	@pStatus int,
	@pUser int

)
AS
	SET NOCOUNT ON;
	declare @prevStatus int
	declare @vError int
	declare @vErrDescription varchar(1024)

BEGIN TRY

	SET @vError = 0;
	SET @vErrDescription = 'OK'
/*
	SELECT @prevStatus = Status FROM OrdersCab WHERE PK_Order = @pOrder

	IF @prevStatus >= 6 BEGIN
		SET @vError = 11009;
		SET @vErrDescription = 'No se puede modificar a estado Anulado un pedido en el estado actual'
	END ELSE BEGIN

		UPDATE OrdersCab
		SET Status = 9,
			UpdateDate = getdate(),
			UpdateUser = @pUser
		WHERE PK_Order = @pOrder

		IF @@ROWCOUNT = 0 BEGIN
			SET @vError = 11001;
			SET @vErrDescription = 'Cabecera de pedido no encontrado en la base de datos'
		END

	END
*/
	SELECT @vError AS ErrorCode, @vErrDescription AS ErrorDescription;

END TRY
BEGIN CATCH

	SET @vError = @@ERROR
	SET @vErrDescription = 'Error SQL: ' + ERROR_MESSAGE();

--  pendent generar registre de LOG

	SELECT @vError AS ErrorCode, @vErrDescription AS ErrorDescription;

END CATCH
go

-- =============================================
-- Author:		EDUARD PASCUAL
-- Description:	Modificació d'una linia de producte de venta de ordre de producció
-- =============================================
CREATE PROCEDURE [dbo].[spApiPutProdOrderSalesProduct](
	@pOrder int,
	@pSalesProduct int,
	@pQuantity int,
	@pUser int
)
AS
	SET NOCOUNT ON;
	declare @vError int
	declare @vErrDescription varchar(1024)

BEGIN TRY

	SET @vError = 0;
	SET @vErrDescription = 'OK'

/*	UPDATE OrdersCab
	SET FK_CostCenter = @pCostCenter,
		OrderDate = @pOrderDate,
		FK_Vendor = @pVendor,
		DeliveryPlanDate = @pDeliveryPlanDate,
		Comments = @pComments,
		Status = @pStatus,
		UpdateDate = getdate(),
		UpdateUser = @pUser
	WHERE PK_Order = @pOrder
*/
/*
PK_Order	int	Unchecked
PK_Row	int	Unchecked
FK_Product	int	Unchecked
FK_LogisticChain	int	Unchecked
FK_Pack	int	Unchecked
PackItems	decimal(18, 3)	Checked
PackQuantity	decimal(18, 3)	Checked
BaseQuantity	decimal(18, 3)	Checked
Amount	decimal(18, 3)	Checked
AmountTax	decimal(18, 3)	Checked
TaxCode	int	Checked
Tax	decimal(18, 3)	Checked
Comments	varchar(512)	Checked
InsertDate	datetime	Unchecked
UpdateDate	datetime	Unchecked
UpdateUser	int	Unchecked
*/



	IF @@ROWCOUNT = 0 BEGIN
		SET @vError = 11001;
		SET @vErrDescription = 'Cabecera de pedido no encontrado en la base de datos'
	END

	SELECT @vError AS ErrorCode, @vErrDescription AS ErrorDescription;

END TRY
BEGIN CATCH

	SET @vError = @@ERROR
	SET @vErrDescription = 'Error SQL: ' + ERROR_MESSAGE();

--  pendent generar registre de LOG

	SELECT @vError AS ErrorCode, @vErrDescription AS ErrorDescription;

END CATCH
go

-- =============================================
-- Author:		EDUARD PASCUAL
-- Description:	Modificació d'una linia de detall d'article de compra d'una ordre de producció
-- =============================================
CREATE PROCEDURE [dbo].[spApiPutProdOrderProduct](
	@pProductOrder int,
	@pRow int,
	@pPackQuantity decimal(18,3),
	@pComments varchar(512),
	@pUser int
)
AS
	SET NOCOUNT ON;
	declare @vError int
	declare @vErrDescription varchar(1024)

BEGIN TRY

	SET @vError = 0;
	SET @vErrDescription = 'OK'

/*	UPDATE OrdersCab
	SET FK_CostCenter = @pCostCenter,
		OrderDate = @pOrderDate,
		FK_Vendor = @pVendor,
		DeliveryPlanDate = @pDeliveryPlanDate,
		Comments = @pComments,
		Status = @pStatus,
		UpdateDate = getdate(),
		UpdateUser = @pUser
	WHERE PK_Order = @pOrder
*/
/*
PK_Order	int	Unchecked
PK_Row	int	Unchecked
FK_Product	int	Unchecked
FK_LogisticChain	int	Unchecked
FK_Pack	int	Unchecked
PackItems	decimal(18, 3)	Checked
PackQuantity	decimal(18, 3)	Checked
BaseQuantity	decimal(18, 3)	Checked
Amount	decimal(18, 3)	Checked
AmountTax	decimal(18, 3)	Checked
TaxCode	int	Checked
Tax	decimal(18, 3)	Checked
Comments	varchar(512)	Checked
InsertDate	datetime	Unchecked
UpdateDate	datetime	Unchecked
UpdateUser	int	Unchecked
*/



	IF @@ROWCOUNT = 0 BEGIN
		SET @vError = 11001;
		SET @vErrDescription = 'Cabecera de pedido no encontrado en la base de datos'
	END

	SELECT @vError AS ErrorCode, @vErrDescription AS ErrorDescription;

END TRY
BEGIN CATCH

	SET @vError = @@ERROR
	SET @vErrDescription = 'Error SQL: ' + ERROR_MESSAGE();

--  pendent generar registre de LOG

	SELECT @vError AS ErrorCode, @vErrDescription AS ErrorDescription;

END CATCH
go

-- =============================================
-- Author:		EDUARD PASCUAL
-- Description:	Modificació del flag de swBookmark de la taula VendorCostCentersProducts per instrucció PUT de APIREST
--				Es canvien tots els estats per un mateix PK_Vendor, PK_CostCenter, PK_Product per tantes PK_LogisticChain com tingui
-- =============================================
CREATE PROCEDURE [dbo].[spApiPutCatalogBookmark](
	@pVendor int,
	@pCostCenter int,
	@pProduct int,
	@pBookmark int
)
AS
	SET NOCOUNT ON;
	declare @vError int
	declare @vErrDescription varchar(1024)

BEGIN TRY

	SET @vError = 0;
	SET @vErrDescription = 'OK'

	UPDATE VendorCostCentersProducts
	SET swBookmark = @pBookmark
	WHERE PK_Vendor = @pVendor AND PK_CostCenter = @pCostCenter AND PK_Product = @pProduct

	IF @@ROWCOUNT = 0 BEGIN
		SET @vError = 10001;
		SET @vErrDescription = 'Producto no encontrado en el catálogo del proveedor para este centro'
	END

	SELECT @vError AS ErrorCode, @vErrDescription AS ErrorDescription;

END TRY
BEGIN CATCH

	SET @vError = @@ERROR
	SET @vErrDescription = 'Error SQL: ' + ERROR_MESSAGE();

--  pendent generar registre de LOG

	SELECT @vError AS ErrorCode, @vErrDescription AS ErrorDescription;

END CATCH
go

-- =============================================
-- Author:		EDUARD PASCUAL
-- Description:	Modificació de la capçalera de comanda
--				L'unic camp que no es pot modificar per UPDATE es Status ja que requereix d'accions complementaries
-- =============================================
CREATE PROCEDURE [dbo].[spApiPutOrderHeader](
	@pOrder int,
	@pCostCenter int,
	@pOrderDate datetime,
	@pVendor int,
	@pDeliveryPlanDate datetime,
	@pComments varchar(512),
	@pUser int

)
AS
	SET NOCOUNT ON;
	declare @vError int
	declare @vErrDescription varchar(1024)

BEGIN TRY

	SET @vError = 0;
	SET @vErrDescription = 'OK'

	UPDATE OrdersCab
	SET FK_CostCenter = @pCostCenter,
		OrderDate = @pOrderDate,
		FK_Vendor = @pVendor,
		DeliveryPlanDate = @pDeliveryPlanDate,
		Comments = @pComments,
		UpdateDate = getdate(),
		UpdateUser = @pUser
	WHERE PK_Order = @pOrder

	IF @@ROWCOUNT = 0 BEGIN
		SET @vError = 11001;
		SET @vErrDescription = 'Cabecera de pedido no encontrado en la base de datos'
	END

	SELECT @vError AS ErrorCode, @vErrDescription AS ErrorDescription;

END TRY
BEGIN CATCH

	SET @vError = @@ERROR
	SET @vErrDescription = 'Error SQL: ' + ERROR_MESSAGE();

--  pendent generar registre de LOG

	SELECT @vError AS ErrorCode, @vErrDescription AS ErrorDescription;

END CATCH
go

-- =============================================
-- Author:		EDUARD PASCUAL
-- Description:	Alta de la capçalera de comanda, amb el catàleg per defecte del proveidor per aquest centre en el moment de crear la comanda
-- =============================================
CREATE PROCEDURE [dbo].[spApiPostOrderHeader](
	@pCostCenter int,
	@pOrderDate datetime,
	@pVendor int,
	@pDeliveryPlanDate datetime,
	@pComments varchar(512),
	@pUser int
)
AS
	SET NOCOUNT ON;
	declare @vError int
	declare @vErrDescription varchar(1024)
	declare @vOrderId int

BEGIN TRY

	SET @vError = 0;
	SET @vErrDescription = 'OK'

	-- Inserta capçalera de la comanda

	SELECT @vOrderId = MAX(PK_Order)+1 FROM OrdersCab
	IF @vOrderId IS NULL SET @vOrderId = 1

	INSERT INTO OrdersCab
		(PK_Order, FK_CostCenter, OrderDate, OrderType, FK_Vendor, FK_CostCenterDst, TotalAmount, TotalAmountTax,
		TotalTax, DeliveryDate, DeliveryPlanDate, Comments, FK_ProductionOrder, TextWhatsAppOrder, Status, Owner,
		UserSent, InsertDate, UpdateDate, UpdateUser)
	VALUES
		(@vOrderId, @pCostCenter, @pOrderDate, 'V', @pVendor, NULL, 0, 0, 0, NULL, @pDeliveryPlanDate, @pComments,
		NULL, NULL, 1, @pUser, NULL, Getdate(), Getdate(), @pUser)

	-- Inserta detall de la comanda segons catàleg del proveidor en el moment de la creació
	-- La comanda queda en estat de catàleg actiu + preus del moment de la creació
	-- *******
	-- PENDENT: Recalcul de la comanda quan es carreguen els catàlegs de preus si aquesta encara no està en estat enviat

	INSERT INTO OrdersDet
	SELECT
		@vOrderId AS PK_Order, ROW_NUMBER() OVER(ORDER BY FK_CategoryL3, ProductName, PK_LogisticChain DESC) AS PK_Row,
		PK_Product, PK_LogisticChain, FK_Pack, PackItems,0 AS PackQuantity, 0 AS BaseQuantity, 0 AS Amount,0 AS AmountTax,
		TaxCode, 0 AS Tax, NULL AS Comments, Getdate() AS InsertDate, Getdate() AS UpdateDate, @pUser AS UpdateUser
	FROM vApiVendorCostCentersProducts
    WHERE PK_Vendor = @pVendor and PK_CostCenter= @pCostCenter AND swOrderEnabled = 1

	-- Retorna status de la funció i ID de la ordre creada
	SELECT @vError AS ErrorCode, @vErrDescription AS ErrorDescription, @vOrderId AS RecordId;


END TRY
BEGIN CATCH

	SET @vError = @@ERROR
	SET @vErrDescription = 'Error SQL: ' + ERROR_MESSAGE();

--  pendent generar registre de LOG

	SELECT @vError AS ErrorCode, @vErrDescription AS ErrorDescription, NULL AS RecordId;

END CATCH
go

-- =============================================
-- Author:		EDUARD PASCUAL
-- Description:	Crea una nova en estat borrador a partir de la comanda passada per paràmetre
-- =============================================
CREATE PROCEDURE [dbo].[spApiPostCopyOrder](
	@pOrder int,
    @pUser int
)
AS
	SET NOCOUNT ON;
	declare @vError int
	declare @vErrDescription varchar(1024)
	declare @vOrderId int

BEGIN TRY

	SET @vError = 0;
	SET @vErrDescription = 'OK'

	SELECT @vOrderId = MAX(PK_Order)+1 FROM OrdersCab
	IF @vOrderId IS NULL SET @vOrderId = 1

	-- Copia capçalera de la comanda

	INSERT INTO OrdersCab
	SELECT
		@vOrderId AS PK_Order, FK_CostCenter, Getdate() AS OrderDate, OrderType, FK_Vendor, FK_CostCenterDst, TotalAmount,
		TotalAmountTax, TotalTax, NULL AS DeliveryDate, NULL AS DeliveryPlanDate, Comments, FK_ProductionOrder, NULL AS TextWhatsAppOrder,
		1 AS Status, @pUser AS Owner, NULL AS UserSent, Getdate() AS InsertDate, Getdate() AS UpdateDate, @pUser AS UpdateUser
	FROM OrdersCab
	WHERE PK_Order = @pOrder

	-- Copia detall de la comanda
	-- ***********
	-- PENDENT: Al ser en estat borrador hauria de carregar tots els articles del proveidor com en una alta
	-- i després fer un update dels articles segons la comanda a copiar
	INSERT INTO OrdersDet
	SELECT
		@vOrderId AS PK_Order, PK_Row, FK_Product, FK_LogisticChain, FK_Pack, PackItems, PackQuantity, BaseQuantity, Amount,
		AmountTax, TaxCode, Tax, Comments, Getdate() AS InsertDate, Getdate() AS UpdateDate, @pUser AS UpdateUser
	FROM OrdersDet
	WHERE PK_Order = @pOrder

	SELECT @vError AS ErrorCode, @vErrDescription AS ErrorDescription, @vOrderId AS RecordId;

END TRY
BEGIN CATCH

	SET @vError = @@ERROR
	SET @vErrDescription = 'Error SQL: ' + ERROR_MESSAGE();

--  pendent generar registre de LOG

	SELECT @vError AS ErrorCode, @vErrDescription AS ErrorDescription, NULL AS RecordId;

END CATCH
go

-- =============================================
-- Author:		EDUARD PASCUAL
-- Description:	Modificació d'una linia de comanda
-- =============================================
CREATE PROCEDURE [dbo].[spApiPutOrderRow](
	@pOrder int,
	@pRow int,
	@pPackQuantity decimal(18,3),
	@pComments varchar(512),
	@pUser int
)
AS
	SET NOCOUNT ON;
	declare @vError int
	declare @vErrDescription varchar(1024)
	declare @prevStatus int

BEGIN TRY

	SET @vError = 0;
	SET @vErrDescription = 'OK'


	SELECT @prevStatus = Status FROM OrdersCab WHERE PK_Order = @pOrder

	IF @prevStatus > 1 BEGIN

		SET @vError = 11009;
		SET @vErrDescription = 'No se puede modificar la linea de detalle ya que el pedido no está en estado borrador'

	END ELSE BEGIN

		UPDATE OrdersDet
		SET PackQuantity = @pPackQuantity,
			Comments = @pComments,
			UpdateDate = GetDate(),
			UpdateUser = @pUser
		WHERE PK_Order = @pOrder AND PK_Row = @pRow

		IF @@ROWCOUNT = 0 BEGIN
			SET @vError = 11001;
			SET @vErrDescription = 'linea de pedido no encontrado en la base de datos'
		END

	END

	SELECT @vError AS ErrorCode, @vErrDescription AS ErrorDescription;

END TRY
BEGIN CATCH

	SET @vError = @@ERROR
	SET @vErrDescription = 'Error SQL: ' + ERROR_MESSAGE();

--  pendent generar registre de LOG

	SELECT @vError AS ErrorCode, @vErrDescription AS ErrorDescription;

END CATCH
go

-- =============================================
-- Author:		EDUARD PASCUAL
-- Description:	Crea un nou article (provisional) al proveidor durant la generació de la comanda
-- =============================================
CREATE PROCEDURE [dbo].[spApiPostVendorProduct](
	@pOrder int,
	@ProductName varchar(128),
	@pCategoryL3 int,
	@pUnits int,
	@pPackQuantity decimal(18,3),
	@pCost decimal(18,3),
	@pComments varchar(512),
	@pUser int
)
AS
	SET NOCOUNT ON;
	declare @vError int
	declare @vErrDescription varchar(1024)
	declare @vOrderId int

BEGIN TRY

-- control de que el proveidor pot donar d'alta la comanda

	SET @vError = 0;
	SET @vErrDescription = 'OK'
/*
	SELECT @vOrderId = MAX(PK_Order)+1 FROM OrdersCab
	IF @vOrderId IS NULL SET @vOrderId = 1

	INSERT INTO OrdersCab
		(PK_Order, FK_CostCenter, OrderDate, OrderType, FK_Vendor, FK_CostCenterDst, TotalAmount, TotalAmountTax,
		TotalTax, DeliveryDate, DeliveryPlanDate, Comments, FK_ProductionOrder, Status, Owner,
		UserSent, InsertDate, UpdateDate, UpdateUser)
	VALUES
		(@vOrderId, @pCostCenter, @pOrderDate, 'V', @pVendor, NULL, 0, 0, 0, NULL, @pDeliveryPlanDate, @pComments,
		NULL, @pStatus, @pUser, NULL, Getdate(), Getdate(), @pUser)

	SELECT @vError AS ErrorCode, @vErrDescription AS ErrorDescription, @vOrderId AS RecordId;
*/

END TRY
BEGIN CATCH

	SET @vError = @@ERROR
	SET @vErrDescription = 'Error SQL: ' + ERROR_MESSAGE();

--  pendent generar registre de LOG

	SELECT @vError AS ErrorCode, @vErrDescription AS ErrorDescription, NULL AS RecordId;

END CATCH
go

