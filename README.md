# Alura_Hotel
here you will find the SQL data to create the data base 

create database alura_hotel;
use alura_hotel;


CREATE TABLE reservations (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    DATE_OF_ENTRY DATE NOT NULL,
    DEPARTURE_DATE DATE,
    Gvalue DECIMAL(10, 2) NOT NULL,
    payment VARCHAR(50)
)engine= InnoDB;

CREATE TABLE Guests (
    id INT AUTO_INCREMENT primary key,
    Gname VARCHAR(50) NOT NULL,
    Gsurname VARCHAR(50),
    Date_of_birth DATE,
    nationality VARCHAR(50),
    Phone_Number VARCHAR(15) NOT NULL,
    Idreservation INT NOT NULL,
    FOREIGN KEY (Idreservation) REFERENCES reservations(id)
)engine= InnoDB;


INSERT INTO reservations (DATE_OF_ENTRY, DEPARTURE_DATE, Gvalue, payment)
VALUES ('2023-10-02', NULL, 1500.00, 'debit card');

INSERT INTO Guests (Gname, Gsurname, Date_of_birth, nationality, Phone_Number, Idreservation)
VALUES ('angelica ', 'Garcia', '1998-01-24', 'Mexicano', '123456789', '5');

CREATE TABLE users (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_name VARCHAR(100) NOT NULL,
    user_password VARCHAR(100) NOT NULL
)engine= InnoDB;

insert into users (user_name, user_password) values('karol','hotel');

select * from users;

select * from reservations ;
