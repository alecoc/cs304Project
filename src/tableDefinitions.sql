CREATE TABLE Borrower(
      bid int NOT NULL,
      password int,
      name varchar(30),
      address varchar(40),
      phone int,
      emailAddress varchar(40),
      sinOrStNo int,
      expiryDate int,
      type varchar(20),
      PRIMARY KEY(bid)
)
GO
CREATE TABLE BorrowerType (
      type varchar(20 NOT NULL,
      bookTimeLimit int,
      PRIMARY KEY(type)
)
GO
CREATE TABLE Book (
      callNumber int NOT NULL,
      isbn int,
      title varchar(20),
      mainAuthor varchar(30),
      publisher varchar(20),
      year int,
      PRIMARY KEY(callNumber)
)
GO
CREATE TABLE HasAuthor (
     callNumber int NOT NULL,
     name varchar(30) NOT NULL,
     PRIMARY KEY(callNumber, name)
)
GO
CREATE TABLE HasSubject (
     callNumber int NOT NULL,
     subject varchar(20) NOT NULL,
     PRIMARY KEY(callNumber, subject)
)
GO
CREATE TABLE BookCopy (
     callNumber int NOT NULL,
     copyNo int NOT NULL,
     status varchar,
     PRIMARY KEY (callNumber, copyNo)
)
GO
CREATE TABLE HoldRequest (
     hid int NOT NULL,
     bid int,
     callNumber int,
     issuedDate varchar(20),
     PRIMARY KEY (hid)
)
GO
CREATE TABLE Borrowing (
     borid int NOT NULL,
     bid int,
     callNumber int,
     copyNo int,
     outDate varchar(20),
     inDate varchar(20),
     PRIMARY KEY(borid)
)
GO
CREATE TABLE Fine (
     fid int NOT NULL,
     amount float,
     issuedDate varchar(20)
     paidDate varchar(20)
     borid int,
     PRIMARY KEY(fid)
);












