-- Pa to insert a new ADMINISTRATOR OR ASSISTANT
USE SYSTEMSOLES
-- PO INSERT A NEW ADMINISTRATOR OR ASSISTANT
CREATE PROCEDURE Insert_Users
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

drop procedure Select_Users
-- Pa to consult all users
CREATE PROCEDURE Select_User
AS BEGIN
SELECT us.*,cl.* FROM UserMain AS us JOIN Latam as cl ON us.IdClave = cl.IdClave;
END


-- Pa to consult a users
CREATE PROCEDURE Search_User
@DniDelete VARCHAR (8)
AS BEGIN
IF @DniDelete is not null
BEGIN
Select 'Exits' FROM UserMain WHERE IdUser = @DniDelete;
END 
END


-- pa to delete a users
CREATE PROCEDURE Delete_User
@DniDelete VARCHAR (8) 
AS BEGIN
IF @DniDelete is not null
BEGIN
DELETE FROM UserMain WHERE IdUser = @DniDelete;
END		
END				

drop procedure Update_User

CREATE PROCEDURE Update_User
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

use SYSTEMSOLES


select * from UserMain;
select * from Latam
delete from UserMain