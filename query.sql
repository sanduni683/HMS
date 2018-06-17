CREATE DATABASE WMSdatabase;
USE WMSdatabase;
CREATE TABLE Users (
    ID int NOT NULL AUTO_INCREMENT,
    UserName varchar(20),
    Password varchar(20),
    Title varchar (6),
    FirstName varchar(255),
    LastName varchar(255),
    DOB date,
    IDnumber varchar(10),
    Gender varchar (6),
    MobileNumber int,
    TelephoneNumber int,
    EmailAddress varchar(20),
    Address varchar(255),
    PRIMARY KEY (ID)
);
INSERT INTO Users (UserName, Password, Title, FirstName, LastName, DOB, IDnumber, Gender, MobileNumber, TelephoneNumber, EmailAddress, Address )
VALUES ('Chamara','Chamara123','Mr','Chamara','Madhushan','1989.12.10','895647589V','Male','0775889564','0775499565','chamara@gmail.com','Akuressa' );

SELECT FirstName, LastName
FROM Users
WHERE UserName = 'Chamara';CREATE DATABASE WMSdatabase;
USE WMSdatabase;
CREATE TABLE Users (
    ID int NOT NULL AUTO_INCREMENT,
    UserName varchar(20),
    Password varchar(20),
    Title varchar (6),
    FirstName varchar(255),
    LastName varchar(255),
    DOB date,
    IDnumber varchar(10),
    Gender varchar (6),
    MobileNumber int,
    TelephoneNumber int,
    EmailAddress varchar(20),
    Address varchar(255),
    PRIMARY KEY (ID)
);
INSERT INTO Users (UserName, Password, Title, FirstName, LastName, DOB, IDnumber, Gender, MobileNumber, TelephoneNumber, EmailAddress, Address )
VALUES ('Chamara','Chamara123','Mr','Chamara','Madhushan','1989.12.10','895647589V','Male','0775889564','0775499565','chamara@gmail.com','Akuressa' );

SELECT FirstName, LastName
FROM Users
WHERE UserName = 'Chamara';
