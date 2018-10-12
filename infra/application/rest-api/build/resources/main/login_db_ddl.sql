create database CaepiaLoginDB collate SQL_Latin1_General_CP1_CI_AS
go

create table CaepiaClients
(
	PK_Client int not null
		constraint PK_Clients
			primary key,
	Name varchar(128),
	ServerName varchar(256),
	Port int,
	BDName varchar(128),
	UserBDName varchar(128),
	UserDBPassword varchar(128),
	Version int
)
go

create table CaepiaAppUsers
(
	PK_User varchar(128) not null
		constraint PK_CaepiaAppUsers
			primary key,
	Name varchar(128),
	Password varchar(128),
	FK_Client int,
	Status int
)
go

create table LoginLog
(
	PK_User varchar(128) not null,
	PK_Date datetime not null,
	Status int not null,
	Message varchar(1024),
	constraint PK_LoginLog2
		primary key (PK_User, PK_Date)
)
go

CREATE VIEW dbo.vApiUserConnection
AS
SELECT        dbo.CaepiaAppUsers.PK_User, dbo.CaepiaClients.ServerName, dbo.CaepiaClients.Port, dbo.CaepiaClients.BDName, dbo.CaepiaClients.UserBDName, dbo.CaepiaClients.UserDBPassword, dbo.CaepiaClients.Version
FROM            dbo.CaepiaClients INNER JOIN
                         dbo.CaepiaAppUsers ON dbo.CaepiaClients.PK_Client = dbo.CaepiaAppUsers.FK_Client
WHERE        (dbo.CaepiaAppUsers.Status = 1)
go

-- =============================================
-- Author:		EDUARD PASCUAL
-- Description:	Validació Login usuari per instrucció POST de APIREST
-- =============================================
CREATE PROCEDURE [dbo].[spApiPostLogin](
	@pUser varchar(128),
	@pPassword varchar(128),
	@pVersion int
)
AS
	SET NOCOUNT ON;
	declare @vError int
	declare @vErrDescription varchar(1024)

BEGIN TRY

	declare @vVersion int
	declare @vStatus int
	declare @vPassword varchar(128)

	SET @vError = 0;
	SET @vErrDescription = 'OK'

	-- Recuperar Dades de l'usuari
	select  @vPassword=CaepiaAppUsers.Password, @vStatus=CaepiaAppUsers.Status, @vVersion = CaepiaClients.Version
	from CaepiaClients INNER JOIN CaepiaAppUsers ON CaepiaClients.PK_Client = CaepiaAppUsers.FK_Client
	WHERE CaepiaAppUsers.PK_User = @pUser

	IF @@ROWCOUNT = 0 BEGIN
		SET @vError = 90001;
		SET @vErrDescription = 'Código de usuario Inexistente'
	END ELSE IF @vVersion <> @pVersion BEGIN
		SET @vError = 90004;
		SET @vErrDescription = 'Versión de la base de datos no es compatible con la versión de la aplicación'
	END ELSE IF @vStatus <> 1 BEGIN
		SET @vError = 90003;
		SET @vErrDescription = 'Usuario de baja'
	END ELSE IF @vPassword <> @pPassword BEGIN
		SET @vError = 90002;
		SET @vErrDescription = 'Contraseña incorrecta'
	END

	INSERT INTO LoginLog (PK_user, PK_Date, Status, Message) VALUES (@pUser, Getdate(), @vError, @vErrDescription)

	SELECT @vError AS ErrorCode, @vErrDescription AS ErrorDescription;

END TRY
BEGIN CATCH

	SET @vError = @@ERROR
	SET @vErrDescription = 'Error SQL: ' + ERROR_MESSAGE();

	INSERT INTO LoginLog (PK_user, PK_Date, Status, Message) VALUES (@pUser, Getdate(), @vError, @vErrDescription)

	SELECT @vError AS ErrorCode, @vErrDescription AS ErrorDescription;

END CATCH

go

-- =============================================
-- Author:		EDUARD PASCUAL
-- Description:	Validació Login usuari per instrucció POST de APIREST
-- =============================================
CREATE PROCEDURE [dbo].[spApiPostUser](
	@pUser varchar(128),
	@pName varchar(128),
	@pPassword varchar(128),
	@pClient int
)
AS
	SET NOCOUNT ON;
	declare @vError int
	declare @vErrDescription varchar(1024)

BEGIN TRY

	declare @i int

	SET @i = 0;
	SET @vError = 0;
	SET @vErrDescription = 'OK'

	SELECT @i = COUNT(*) FROM CaepiaAppUsers WHERE PK_User = @pUser

	IF @i > 0 BEGIN
		SET @vError = 90101;
		SET @vErrDescription = 'Usuario duplicado'
	END ELSE
		INSERT INTO CaepiaAppUsers (PK_User, Name, Password, FK_Client, Status) VALUES (@pUser, @pName, @pPassword, @pClient, 1)

	SELECT @vError AS ErrorCode, @vErrDescription AS ErrorDescription;

END TRY
BEGIN CATCH

	SET @vError = @@ERROR
	SET @vErrDescription = 'Error SQL: ' + ERROR_MESSAGE();

--  pendent generar registre de LOG

	SELECT @vError AS ErrorCode, @vErrDescription AS ErrorDescription;

END CATCH

go


CREATE PROCEDURE [dbo].[spApiPutUserPasword](
	@pUser varchar(128),
	@pPassword varchar(128)
)
AS
	SET NOCOUNT ON;
	declare @vError int
	declare @vErrDescription varchar(1024)

BEGIN TRY

	SET @vError = 0;
	SET @vErrDescription = 'OK'

	UPDATE CaepiaAppUsers
	SET Password = @pPassword
	WHERE PK_User = @pUser

--	SET @vError = 12 / 0;  -- Test per excepció error SQL

	IF @@ROWCOUNT = 0 BEGIN
		SET @vError = 90001;
		SET @vErrDescription = 'Usuario inexistente'
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

