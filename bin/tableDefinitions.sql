CREATE TABLE Borrower(
      bid INT,
      password INT,
      name NVARCHAR(30),
      address NVARCHAR(40),
      phone INT,
      emailAddress NVARCHAR(40),
      sinOrStNo INT,
      expiryDate INT,
      type NVARCHAR(20),
      PRIMARY KEY(bid)
)
GO
CREATE TABLE BorrowerType (
      type NVARCHAR(20),
      bookTimeLimit INT,
      PRIMARY KEY(type)
)
GO
CREATE TABLE Book (
      callNumber INT,
      isbn INT,
      title NVARCHAR(20),
      mainAuthor NVARCHAR(30),
      publisher NVARCHAR(20),
      year INT,
      PRIMARY KEY(callNumber)
)
GO
CREATE TABLE HasAuthor (
     callNumber INT,
     name NVARCHAR(30),
     PRIMARY KEY(callNumber, name)
)
GO
CREATE TABLE HasSubject (
     callNumber INT,
     subject NVARCHAR(20),
     PRIMARY KEY(callNumber, subject)
)
GO
CREATE TABLE BookCopy (
     callNumber INT,
     copyNo INT,
     status NVARCHAR,
     PRIMARY KEY (callNumber, copyNo)
)
GO
CREATE TABLE HoldRequest (
     hid INT,
     bid INT,
     callNumber INT,
     issuedDate NVARCHAR(20),
     PRIMARY KEY (hid)
)
GO
CREATE TABLE Borrowing (
     borid INT,
     bid INT,
     callNumber INT,
     copyNo INT,
     outDate NVARCHAR(20),
     inDate NVARCHAR(20),
     PRIMARY KEY(borid)
)
GO
CREATE TABLE Fine (
     fid INT,
     amount FLOAT,
     issuedDate NVARCHAR(20)
     paidDate NVARCHAR(20)
     borid INT,
     PRIMARY KEY(fid)
);












