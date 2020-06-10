Drop table if EXISTS Contract;
Drop table if EXISTS Subject_Room;
Drop table if EXISTS Booking;
Drop table if EXISTS Subject_Teacher;

drop table if exists Customer_Lesson;
Drop table if exists SchoolClass;

Drop table if EXISTS Employee_Subject;
Drop table if exists Lesson;
Drop table if EXISTS Employee;
Drop table if EXISTS Tarif;
Drop table if EXISTS Room;
Drop table if EXISTS Teacher;
Drop table if EXISTS Customer;
drop table if exists person;
Drop table if EXISTS Account;
Drop table if EXISTS Address;
Drop table if EXISTS Subject;


CREATE TABLE Account
(
    ID        INTEGER IDENTITY (1,1) NOT NULL,
    IBAN      TEXT                   NOT NULL,
    BIC       TEXT                   NOT NULL,
    Firstname Text                   NOT NULL,
    Lastname  Text                   NOT NULL,
    CONSTRAINT Account_pk PRIMARY KEY (ID)
);


CREATE TABLE Address
(
    ID       INTEGER IDENTITY (1,1) NOT NULL,
    Street   TEXT,
    Zip_Code INTEGER,
    City     TEXT,
    Number   TEXT,
    CONSTRAINT Address_pk PRIMARY KEY (ID)
);

CREATE TABLE Person
(
    ID         INTEGER IDENTITY (1,1) NOT NULL,
    Account_ID INTEGER,
    Address_ID INTEGER,
    Name       TEXT,
    Lastname   TEXT                   NOT NULL,
    Email      TEXT,
    Passwort   TEXT,
    Birthplace TEXT,
    Birthdate  DATE,
    Phone      INTEGER,
    CONSTRAINT Person_pk PRIMARY KEY (ID),
    FOREIGN KEY (account_ID) REFERENCES account (ID),
    FOREIGN KEY ([Address_ID]) REFERENCES [Address] (ID)
);

CREATE TABLE Employee
(
    ID       INTEGER NOT NULL,
    Is_Admin BIT     NOT NULL DEFAULT (0),
    Salary   FLOAT,
    CONSTRAINT Employee_pk PRIMARY KEY (ID),
    FOREIGN KEY (ID) REFERENCES Person (ID)
);


CREATE TABLE Customer
(
    ID INTEGER NOT NULL,
    CONSTRAINT Customer_pk PRIMARY KEY (ID),
    FOREIGN KEY (ID) REFERENCES Person (ID),
);


CREATE TABLE Subject
(
    ID   INTEGER IDENTITY (1,1) NOT NULL,
    Name TEXT                   NOT NULL,
    Info TEXT,
    CONSTRAINT Subject_pk PRIMARY KEY (ID)
);


--Zuweisungstabelle
CREATE TABLE Employee_Subject
(
    Subject_ID  INTEGER NOT NULL,
    Employee_ID INTEGER NOT NULL,
    FOREIGN KEY ([Subject_ID]) REFERENCES [Subject] (ID),
    FOREIGN KEY (Employee_ID) REFERENCES Employee (ID)
);


CREATE TABLE Tarif
(
    ID                  INTEGER IDENTITY (1,1) NOT NULL,
    Subject_ID          INTEGER                NOT NULL,
    Duration            INTEGER,
    Name                TEXT                   NOT NULL,
    Cancellation_Period INTEGER,
    Deprecated          BIT                    NOT NULL DEFAULT (0),
    Lesson_Per_Week     INTEGER,
    Lesson_Length       INTEGER,
    Price               FLOAT,
    CONSTRAINT Tarif_pk PRIMARY KEY (ID),
    FOREIGN KEY ([Subject_ID]) REFERENCES [Subject] (ID)
);


CREATE TABLE Contract
(
    ID          INTEGER IDENTITY (1,1) NOT NULL,
    Customer_ID INTEGER                NOT NULL,
    Tarif_ID    INTEGER                NOT NULL,
    Start_Date  DATE                   NOT NULL,
    End_Date    DATE                   NOT NULL,
    CONSTRAINT Contract_pk PRIMARY KEY (ID),
    FOREIGN KEY (Customer_ID) REFERENCES Customer (ID),
    FOREIGN KEY (Tarif_ID) REFERENCES Tarif (ID)
);

CREATE TABLE Room
(
    ID       INTEGER IDENTITY (1,1) NOT NULL,
    Info     TEXT                   NOT NULL,
    Capacity Integer,
    CONSTRAINT Room_pk PRIMARY KEY (ID)
);


--Zuweisungstabelle
CREATE TABLE Subject_Room
(
    Subject_ID INTEGER NOT NULL,
    Room_ID    INTEGER NOT NULL,
    FOREIGN KEY (Subject_ID) REFERENCES Subject (ID),
    FOREIGN KEY (Room_ID) REFERENCES Room (ID)
);


CREATE TABLE Lesson
(
    ID          INTEGER IDENTITY (1,1) NOT NULL,
    Employee_ID INTEGER                NOT NULL,
    Subject_ID  INTEGER                NOT NULL,
    Start_Time  TIME                   NOT NULL,
    End_Time    TIME                   NOT NULL,
    Date        DATE                   NOT NULL,
    Is_Canceled BIT                    NOT NULL DEFAULT (0),
    Topic       TEXT,
    CONSTRAINT Lesson_pk PRIMARY KEY (ID),
    FOREIGN KEY (Subject_ID) REFERENCES Subject (ID),
    FOREIGN KEY (Employee_ID) REFERENCES Employee (ID)
);


CREATE TABLE Booking
(
    ID         INTEGER IDENTITY (1,1) NOT NULL,
    Room_ID    INTEGER                NOT NULL,
    Lesson_ID  INTEGER                NOT NULL,
    Date       DATE                   NOT NULL,
    End_Time   TIME                   NOT NULL,
    Start_Time TIME                   NOT NULL,
    CONSTRAINT Booking_pk PRIMARY KEY (ID),
    FOREIGN KEY (Room_ID) REFERENCES Room (ID),
    FOREIGN KEY (Lesson_ID) REFERENCES Lesson (ID),
);


--Zuweisungstabelle
CREATE TABLE Customer_Lesson
(
    Lesson_ID   INTEGER NOT NULL,
    Customer_ID INTEGER NOT NULL,
    FOREIGN KEY (Lesson_ID) REFERENCES Lesson (ID),
    FOREIGN KEY (Customer_ID) REFERENCES Customer (ID)
);