DROP DATABASE chugga_chugga;
CREATE DATABASE chugga_chugga;
USE chugga_chugga;

CREATE TABLE user (
email VARCHAR(30) PRIMARY KEY,
password VARCHAR(30),
firstName VARCHAR(20),
lastName VARCHAR(20),
birthDate date
);