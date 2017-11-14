USE master;

IF EXISTS(SELECT [name]
          FROM sys.databases
          WHERE [name] = 'TestDB')
  BEGIN
    DROP DATABASE TestDB;
  END
ELSE
  BEGIN
    CREATE DATABASE TestDB;
  END
GO

USE TestDB;

CREATE TABLE Users
(
  username VARCHAR(50) PRIMARY KEY  NOT NULL,
  password VARCHAR(50)              NOT NULL,
  fullname NVARCHAR(50)             NOT NULL,
  photo    VARCHAR(50)              NOT NULL,
  email    VARCHAR(50)              NOT NULL,
  [level]  TINYINT                  NOT NULL
);

INSERT INTO Users VALUES ('aptech01', '12345', 'aptech', 'aptech.jpg', 'aptech@gmai.com', 1);
INSERT INTO Users VALUES ('dieuly', '123', N'Lý Quan Diệu', 'dieuly.jpg', 'DieuLy@gmai.com', 2);
INSERT INTO Users VALUES ('obama', '123', 'Donal Trump', 'trump.jpg', 'Trump@gmai.com', 2);
INSERT INTO Users VALUES ('trump', '123', 'Obama', 'obama.jpg', 'Obama@gmai.com', 1);

SELECT *
FROM Users;
