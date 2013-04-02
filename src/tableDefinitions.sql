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
);

INSERT INTO Borrower VALUES ( 8, 123, 'Alec', '1234 Vancouver', 60431, 'Alecgmailcom', 2305, 1, 'Student' );


CREATE TABLE BorrowerType (
      type varchar(20) NOT NULL,
      bookTimeLimit int,
      PRIMARY KEY(type)
);

INSERT INTO BorrowerType VALUES ( 'Student',  5 );

CREATE TABLE Book (
      callNumber int NOT NULL,
      isbn int,
      title varchar(20),
      mainAuthor varchar(30),
      publisher varchar(20),
      subject varchar(20),
      year int,
      timesOut int,
      PRIMARY KEY(callNumber)
);

INSERT INTO Book VALUES ( 1, 1584, 'TheHobbit', 'JKRowling', 'LucasFilms', 'Sports', 2007 );

CREATE TABLE HasAuthor (
     callNumber int NOT NULL,
     name varchar(30) NOT NULL,
     PRIMARY KEY(callNumber, name)
);
CREATE TABLE HasSubject (
     callNumber int NOT NULL,
     subject varchar(20) NOT NULL,
     PRIMARY KEY(callNumber, subject)
);
CREATE TABLE BookCopy (
     callNumber int NOT NULL,
     copyNo int NOT NULL,
     status int,
     PRIMARY KEY (callNumber, copyNo)
);

INSERT INTO BookCopy VALUES ( 1, 5, 1 );

CREATE TABLE HoldRequest (
     hid int NOT NULL,
     bid int,
     callNumber int,
     issuedDate varchar(20),
     PRIMARY KEY (hid)
);
CREATE TABLE Borrowing (
     borid int NOT NULL,
     bid int,
     callNumber int,
     copyNo int,
     outDate varchar(20),
     inDate varchar(20),
     PRIMARY KEY(borid)
);
CREATE TABLE Fine (
     fid int NOT NULL,
     amount int,
     issuedDate varchar(20),
     paidDate varchar(20),
     borid int,
     PRIMARY KEY(fid)
);

INSERT INTO Fine VALUES ( 5, 15, 'Yesterday', 'Today', 25 );












