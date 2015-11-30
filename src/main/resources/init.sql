-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema 
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema 
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema new_schema1
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema new_schema2
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema chugga_chugga
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema chugga_chugga
-- -----------------------------------------------------
DROP DATABASE chugga_chugga;
CREATE DATABASE IF NOT EXISTS chugga_chugga DEFAULT CHARACTER SET utf8 ;
USE `chugga_chugga` ;

-- -----------------------------------------------------
-- Table ``.`Station`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `chugga_chugga`.`Station` (
  `name` VARCHAR(30) NULL,
  `id` INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table ``.`RouteStation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `chugga_chugga`.`RouteStation` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `stationId` INT NOT NULL,
  `stationNumber` INT NULL,
  `routeId` INT NULL,
  `arrival` TIME NULL,
  `waitingTime` INT NULL,
  `onWheel` TIME NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_RouteStation_Station1_idx` (`stationId` ASC),
  CONSTRAINT `station`
    FOREIGN KEY (`stationId`)
    REFERENCES `chugga_chugga`.`Station` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table ``.`Train`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `chugga_chugga`.`Train` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `numberOfSeats` INT NOT NULL,
  `numberOfFreeSeats` INT NOT NULL,
  `cost` INT NOT NULL,
  `arrivalStation` INT NOT NULL,
  `departureStation` INT NOT NULL,
  `departureDate` DATE NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Train_RouteStation1_idx` (`arrivalStation` ASC),
  INDEX `fk_Train_RouteStation2_idx` (`departureStation` ASC),
  CONSTRAINT `fk_Train_RouteStation1`
    FOREIGN KEY (`arrivalStation`)
    REFERENCES `chugga_chugga`.`RouteStation` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Train_RouteStation2`
    FOREIGN KEY (`departureStation`)
    REFERENCES `chugga_chugga`.`RouteStation` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table ``.`Timetable`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `chugga_chugga`.`Timetable` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `routeStationId` INT NOT NULL,
  `trainId` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Timetable_RouteStation1_idx` (`routeStationId` ASC),
  INDEX `fk_Timetable_Train1_idx` (`trainId` ASC),
  CONSTRAINT `fk_Timetable_RouteStation1`
    FOREIGN KEY (`routeStationId`)
    REFERENCES `chugga_chugga`.`RouteStation` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Timetable_Train1`
    FOREIGN KEY (`trainId`)
    REFERENCES `chugga_chugga`.`Train` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table ``.`UserType`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `chugga_chugga`.`UserType` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table ``.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `chugga_chugga`.`User` (
  `email` VARCHAR(45) NULL,
  `firstName` VARCHAR(45) NULL,
  `lastName` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `id` INT NOT NULL AUTO_INCREMENT,
  `userTypeId` INT NOT NULL,
  `birthDate` DATE NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_User_UserType1_idx` (`userTypeId` ASC),
  CONSTRAINT `type`
    FOREIGN KEY (`userTypeId`)
    REFERENCES `chugga_chugga`.`UserType` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table ``.`Ticket`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `chugga_chugga`.`Ticket` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `departureStationId` INT NULL,
  `arrivalStationId` INT NULL,
  `trainId` INT NOT NULL,
  `userId` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Ticket_Train1_idx` (`trainId` ASC),
  INDEX `fk_Ticket_User1_idx` (`userId` ASC),
  CONSTRAINT `fk_Ticket_Train1`
    FOREIGN KEY (`trainId`)
    REFERENCES `chugga_chugga`.`Train` (`id`)
    ON DELETE cascade
    ON UPDATE cascade,
  CONSTRAINT `fk_Ticket_User1`
    FOREIGN KEY (`userId`)
    REFERENCES `chugga_chugga`.`User` (`id`)
    ON DELETE cascade
    ON UPDATE cascade,
  CONSTRAINT `fk_Ticket_RouteStation1`
    FOREIGN KEY (`arrivalStationId`)
    REFERENCES `chugga_chugga`.`RouteStation` (`id`)
    ON DELETE cascade
    ON UPDATE cascade,
  CONSTRAINT `fk_Ticket_RouteStation2`
    FOREIGN KEY (`departureStationId`)
    REFERENCES `chugga_chugga`.`RouteStation` (`id`)
    ON DELETE cascade
    ON UPDATE cascade)
      
  
ENGINE = InnoDB;






SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


USE chugga_chugga;

insert into usertype (type)
 values ("admin");
 
insert into usertype (type)
 values ("customer");


#######################################################################
#add admins:

insert into USER (email, firstName, lastName, password, userTypeId, birthdate)
 values ("david.koroteev@me", "David", "Koroteev", "qwe", 1, '1993-12-25');
 
 
insert into USER (email, firstName, lastName, password, userTypeId, birthDate)
 values ("alena.koroteeva@me", "Alena", "Koroteeva", "qwe", 1, '1993-12-20');

#add customers:
insert into USER (email, firstName, lastName, password, userTypeId, birthDate)
 values ("pavel.belov@me", "Pavel", "Belov", "qwe", 2, '1993-12-25');
 
insert into USER (email, firstName, lastName, password, userTypeId, birthDate)
 values ("andrey.mischenko@me", "Andrey", "Mischenko", "qwe", 2, '1973-12-25');
 
insert into USER (email, firstName, lastName, password, userTypeId, birthDate)
 values ("lina.miller@me", "Lina", "Miller", "qwe", 2, '1993-12-25');
###########################################################################

insert into Station (name)
 values ("Moscow");

insert into Station (name)
 values ("StPetersburg");
 
insert into Station (name)
 values ("Tver");

insert into Station (name)
 values ("Salavat");

###########################################################################

insert into RouteStation (stationId, stationNumber, routeId, 
arrival, waitingTime, onWheel)
 values (1, 1, 1, '18:33:55', 15, '00:00:00');

insert into RouteStation (stationId, stationNumber, routeId, 
arrival, waitingTime, onWheel)
 values (2, 3, 1, '05:33:55', 10, '02:33:55');
 
insert into RouteStation (stationId, stationNumber, routeId, 
arrival, waitingTime, onWheel)
 values (3, 2, 1, '00:33:55', 30, '07:33:55');

insert into routestation (stationId, stationNumber, routeId, arrival, waitingTime, onWheel)
values (4, 1, 2, "18:33:00", 21, '00:00:00');

insert into routestation (stationId, stationNumber, routeId, arrival, waitingTime, onWheel)
values (3, 2, 2, "18:39:00", 40, '07:33:55');


###########################################################################

insert into Train (name, numberOfSeats, numberOfFreeSeats, 
cost, arrivalStation, departureStation, departureDate)
 values ("Train to hell", 100, 99, 1000, 1, 3, "2013-07-19");

###########################################################################

insert into Timetable (routeStationId, trainId)
 values (1, 1);

insert into Timetable (routeStationId, trainId)
 values (2, 1);
 
insert into Timetable (routeStationId, trainId)
 values (3, 1); 

###########################################################################

insert into Ticket (departureStationId, arrivalStationId,
trainId, userId)
 values (1, 3, 1, 1);

############################################################################

 