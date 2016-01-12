
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

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
-- Table ``.`StationDistance`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `chugga_chugga`.`StationDistance` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `firstStation` INT NOT NULL,
  `secondStation` INT NOT NULL,
  `distance` INT,
  PRIMARY KEY (`id`),
  INDEX `fk_StationDistance_Station1_idx` (`firstStation` ASC),
  INDEX `fk_StationDistance_Station2_idx` (`secondStation` ASC),
  CONSTRAINT `fk_StationDistance_Station1_idx`
    FOREIGN KEY (`firstStation`)
    REFERENCES `chugga_chugga`.`Station` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_StationDistance_Station2_idx`
    FOREIGN KEY (`secondStation`)
    REFERENCES `chugga_chugga`.`Station` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table ``.`RouteStation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `chugga_chugga`.`RouteStation` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `stationId` INT NOT NULL,
  `stationNumber` INT NOT NULL,
  `routeId` INT NOT NULL,
  `arrival` TIME NOT NULL,
  `dayCount` INT NOT NULL,
  `waitingTime` TIME NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_RouteStation_Station1_idx` (`stationId` ASC),
  CONSTRAINT `station`
    FOREIGN KEY (`stationId`)
    REFERENCES `chugga_chugga`.`Station` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
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
  `routeId` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Train_RouteStation1_idx` (`arrivalStation` ASC),
  INDEX `fk_Train_RouteStation2_idx` (`departureStation` ASC),
  CONSTRAINT `fk_Train_RouteStation1`
    FOREIGN KEY (`arrivalStation`)
    REFERENCES `chugga_chugga`.`RouteStation` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Train_RouteStation2`
    FOREIGN KEY (`departureStation`)
    REFERENCES `chugga_chugga`.`RouteStation` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
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
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Timetable_Train1`
    FOREIGN KEY (`trainId`)
    REFERENCES `chugga_chugga`.`Train` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
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
  `birthDate` DATE NOT NULL,
  `balance` INT,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table ``.`UserRole`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `chugga_chugga`.`UserRole` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `userId` INT NOT NULL,
  `userRole` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_UserRole_User1_idx` (`userId` ASC),
  CONSTRAINT `fk_UserRole_User1_idx`
    FOREIGN KEY (`userId`)
    REFERENCES `chugga_chugga`.`User` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `chugga_chugga`.`RouteLength` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `routeLength` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;



-- -----------------------------------------------------
-- Table ``.`Ticket`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `chugga_chugga`.`Ticket` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `arrivalStation` VARCHAR(45) NULL,
  `departureStation` VARCHAR(45) NULL,
  `trainId` INT NOT NULL,
  `userId` INT NOT NULL,
  `purchaseDate` DATE NOT NULL,
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
    ON UPDATE cascade)
      
  
ENGINE = InnoDB;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


USE chugga_chugga;



#######################################################################

insert into USER (email, firstName, lastName, password, birthdate, balance)
 values ("david.koroteev@me", "David", "Koroteev", "qwe", '1993-12-25', 1000000000);
 
 
insert into USER (email, firstName, lastName, password, birthDate, balance)
 values ("alena.koroteeva@me", "Alena", "Koroteeva", "qwe", '1993-12-20', 10000);

insert into USER (email, firstName, lastName, password, birthDate, balance)
 values ("pavel.belov@me", "Pavel", "Belov", "qwe", '1991-10-22', 10);
 
###########################################################################

insert into userRole (userId, userRole)
 values (1, "ROLE_ADMIN");
 
 insert into userRole (userId, userRole)
 values (2, "ROLE_ADMIN");
 
insert into userRole (userId, userRole)
 values (3, "ROLE_USER");

insert into userRole (userId, userRole)
values (1, "ROLE_USER");

insert into userRole (userId, userRole)
values (2, "ROLE_USER");

###########################################################################


insert into Station (name)
 values ("Moscow");

insert into Station (name)
 values ("StPetersburg");
 
insert into Station (name)
 values ("Tver");

insert into Station (name)
 values ("Adler");
 
insert into Station (name)
 values ("Ufa");
 
insert into Station (name)
 values ("Helsinki");
 
insert into Station (name)
 values ("Omsk");
 
insert into Station (name)
 values ("Salavat");

insert into Station (name)
 values ("Samara");

insert into Station (name)
 values ("London");

###########################################################################
#9 Stations
###########################################################################

#adler->samara->ufa->omsk->novosib
insert into RouteStation (stationId, stationNumber, routeId, 
arrival, waitingTime, dayCount)
 values (4, 1, 1, '12:25:00', '00:00:00', 0);

insert into RouteStation (stationId, stationNumber, routeId, 
arrival, waitingTime, dayCount)
 values (9, 2, 1, '14:26:00', '00:00:01', 0);
 
insert into RouteStation (stationId, stationNumber, routeId, 
arrival, waitingTime, dayCount)
 values (5, 3, 1, '18:27:00', '00:00:40', 1);

insert into RouteStation (stationId, stationNumber, routeId, 
arrival, waitingTime, dayCount)
 values (7, 4, 1, '21:25:00', '00:00:20', 2);

insert into RouteStation (stationId, stationNumber, routeId, 
arrival, waitingTime, dayCount)
 values (8, 5, 1, '05:28:00', '00:00:20', 2);
 
 
#ufa->omsk->novosib
insert into RouteStation (stationId, stationNumber, routeId, 
arrival, waitingTime, dayCount)
 values (5, 1, 2, '14:38:00', '00:00:20', 0);

insert into RouteStation (stationId, stationNumber, routeId, 
arrival, waitingTime, dayCount)
 values (7, 2, 2, '08:39:00', '00:00:20', 1);

insert into RouteStation (stationId, stationNumber, routeId, 
arrival, waitingTime, dayCount)
 values (8, 3, 2, '13:50:00', '00:00:20', 1);
 
#msk->tver->spb->helsinki
insert into RouteStation (stationId, stationNumber, routeId, 
arrival, waitingTime, dayCount)
 values (1, 1, 3, '10:11:00', '00:00:20', 0);

insert into RouteStation (stationId, stationNumber, routeId, 
arrival, waitingTime, dayCount)
 values (3, 2, 3, '14:39:00', '00:00:20', 0);

insert into RouteStation (stationId, stationNumber, routeId, 
arrival, waitingTime, dayCount)
 values (2, 3, 3, '22:42:00', '00:00:20', 1);

insert into RouteStation (stationId, stationNumber, routeId, 
arrival, waitingTime, dayCount)
 values (6, 4, 3, '08:15:00', '00:01:20', 2);
 
#msk->tver->spb
insert into RouteStation (stationId, stationNumber, routeId, 
arrival, waitingTime, dayCount)
 values (1, 1, 4, '00:00:00', '00:00:20', 0);

insert into RouteStation (stationId, stationNumber, routeId, 
arrival, waitingTime, dayCount)
 values (2, 3, 4, '04:12:00', '00:00:20', 1);

insert into RouteStation (stationId, stationNumber, routeId, 
arrival, waitingTime, dayCount)
 values (3, 2, 4, '10:14:00', '00:01:20', 3);
 
#novosibirsk->helsinki
insert into RouteStation (stationId, stationNumber, routeId, 
arrival, waitingTime, dayCount)
 values (8, 1, 5, '04:12:00', '00:00:20', 0);

insert into RouteStation (stationId, stationNumber, routeId, 
arrival, waitingTime, dayCount)
 values (6, 2, 5, '10:14:00', '00:01:20', 1);

#London->stPetersburg
insert into RouteStation (stationId, stationNumber, routeId,
                          arrival, waitingTime, dayCount)
values (10, 1, 6, '19:12:00', '00:20:00', 0);

insert into RouteStation (stationId, stationNumber, routeId,
                          arrival, waitingTime, dayCount)
values (2, 2, 6, '15:46:00', '00:20:00', 6);

#stPetersburg->Helsinki
insert into RouteStation (stationId, stationNumber, routeId,
                          arrival, waitingTime, dayCount)
values (2, 1, 7, '17:46:00', '00:20:00', 0);

insert into RouteStation (stationId, stationNumber, routeId,
                          arrival, waitingTime, dayCount)
values (6, 2, 7, '23:51:00', '00:20:00', 0);

#London->Helsinki
insert into RouteStation (stationId, stationNumber, routeId,
                          arrival, waitingTime, dayCount)
values (10, 1, 8, '10:13:00', '00:20:00', 0);

insert into RouteStation (stationId, stationNumber, routeId,
                          arrival, waitingTime, dayCount)
values (6, 2, 8, '13:32:00', '00:20:00', 4);

#Moscow->Tver->Spb
insert into RouteStation (stationId, stationNumber, routeId,
                          arrival, waitingTime, dayCount)
values (1, 1, 9, '09:26:00', '00:20:00', 0);

insert into RouteStation (stationId, stationNumber, routeId,
                          arrival, waitingTime, dayCount)
values (3, 2, 9, '13:32:00', '00:20:00', 0);

insert into RouteStation (stationId, stationNumber, routeId,
                          arrival, waitingTime, dayCount)
values (2, 3, 9, '16:19:00', '00:20:00', 0);


#Tver->Ufa
insert into RouteStation (stationId, stationNumber, routeId,
                          arrival, waitingTime, dayCount)
values (3, 1, 10, '15:41:00', '00:20:00', 0);

insert into RouteStation (stationId, stationNumber, routeId,
                          arrival, waitingTime, dayCount)
values (5, 2, 10, '20:25:00', '00:20:00', 2);

#Ufa->Salavat
insert into RouteStation (stationId, stationNumber, routeId,
                          arrival, waitingTime, dayCount)
values (5, 1, 11, '00:19:00', '00:20:00', 0);

insert into RouteStation (stationId, stationNumber, routeId,
                          arrival, waitingTime, dayCount)
values (8, 2, 11, '10:25:00', '00:20:00', 0);

#Msk->Salavat->Omsk
insert into RouteStation (stationId, stationNumber, routeId,
                          arrival, waitingTime, dayCount)
values (1, 1, 12, '08:15:00', '00:20:00', 0);

insert into RouteStation (stationId, stationNumber, routeId,
                          arrival, waitingTime, dayCount)
values (8, 2, 12, '09:25:00', '00:20:00', 5);

insert into RouteStation (stationId, stationNumber, routeId,
                          arrival, waitingTime, dayCount)
values (7, 3, 12, '13:38:00', '00:20:00', 7);

###########################################################################

insert into Train (name, numberOfSeats, numberOfFreeSeats, 
cost, arrivalStation, departureStation, departureDate, routeId)
 values ("Arrow", 100, 99, 1000, 5, 1, "2016-02-20", 1);

insert into Train (name, numberOfSeats, numberOfFreeSeats, 
cost, arrivalStation, departureStation, departureDate, routeId)
 values ("Arrow1", 100, 99, 1000, 5, 1, "2016-12-04", 1);

 
insert into Train (name, numberOfSeats, numberOfFreeSeats, 
cost, arrivalStation, departureStation, departureDate, routeId)
 values ("Hogwarst express", 100, 99, 1000, 8, 6, "2016-01-28", 2);
 
insert into Train (name, numberOfSeats, numberOfFreeSeats, 
cost, arrivalStation, departureStation, departureDate, routeId)
 values ("Orient express", 100, 99, 1000, 12, 9, "2016-02-05", 3);
 
insert into Train (name, numberOfSeats, numberOfFreeSeats, 
cost, arrivalStation, departureStation, departureDate, routeId)
 values ("Pride of Africa", 100, 99, 10000, 14, 13, "2016-01-30", 4);

insert into Train (name, numberOfSeats, numberOfFreeSeats, 
cost, arrivalStation, departureStation, departureDate, routeId)
 values ("Tutu", 100, 99, 10000, 17, 16, "2016-01-30", 5);

insert into Train (name, numberOfSeats, numberOfFreeSeats,
                   cost, arrivalStation, departureStation, departureDate, routeId)
values ("A1", 1000, 1000, 7000, 19, 18, "2016-01-15", 6);

insert into Train (name, numberOfSeats, numberOfFreeSeats,
                   cost, arrivalStation, departureStation, departureDate, routeId)
values ("A2", 1000, 1000, 5000, 21, 20, "2016-01-21", 7);

insert into Train (name, numberOfSeats, numberOfFreeSeats,
                   cost, arrivalStation, departureStation, departureDate, routeId)
values ("A3", 1000, 1000, 6000, 23, 22, "2016-01-16", 8);

insert into Train (name, numberOfSeats, numberOfFreeSeats,
                   cost, arrivalStation, departureStation, departureDate, routeId)
values ("B1", 1000, 1000, 2000, 26, 24, "2016-01-22", 9);

insert into Train (name, numberOfSeats, numberOfFreeSeats,
                   cost, arrivalStation, departureStation, departureDate, routeId)
values ("B2", 1000, 1000, 5000, 28, 27, "2016-01-22", 10);

insert into Train (name, numberOfSeats, numberOfFreeSeats,
                   cost, arrivalStation, departureStation, departureDate, routeId)
values ("B3", 1000, 1000, 1000, 30, 29, "2016-01-25", 11);

insert into Train (name, numberOfSeats, numberOfFreeSeats,
                   cost, arrivalStation, departureStation, departureDate, routeId)
values ("B4", 1000, 1000, 9000, 33, 31, "2016-01-22", 12);

###########################################################################

insert into Timetable (routeStationId, trainId)
 values (1, 1);

###########################################################################
insert into RouteLength (routeLength)
 values (5);
insert into RouteLength (routeLength)
 values (3);
insert into RouteLength (routeLength)
 values (4);
insert into RouteLength (routeLength)
 values (3);
insert into RouteLength (routeLength)
values (2);
insert into RouteLength (routeLength)
values (2);
insert into RouteLength (routeLength)
values (2);
insert into RouteLength (routeLength)
values (2);


###########################################################################
insert into StationDistance (firstStation, secondStation, distance)
values (1,2,100);
insert into StationDistance (firstStation, secondStation, distance)
values (2,1,100);
