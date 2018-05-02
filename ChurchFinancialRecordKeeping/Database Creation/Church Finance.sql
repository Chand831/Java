CREATE DATABASE `Church Finance`;

USE `church finance`;

CREATE TABLE `church finance`.`Members`(  
  `Envelope Number` INT(8) NOT NULL,
  `First Name` VARCHAR(16),
  `Middle Name` VARCHAR(16),
  `Last Name` VARCHAR(16),
  `Address Line1` VARCHAR(32),
  `Address Line2` VARCHAR(16),
  `City` VARCHAR(16),
  `State` VARCHAR(16),
  `Country` VARCHAR(16),
  `Zip Code` INT(8),
  PRIMARY KEY (`Envelope Number`)
);




CREATE TABLE `church finance`.`Funds`(  
  `Fund Number` INT(4) NOT NULL,
  `Fund Name` VARCHAR(32),
  PRIMARY KEY (`Fund Number`)
);



CREATE TABLE `church finance`.`Donations`(  
  `Donation ID` INT(8) NOT NULL,
  `Fund Name` VARCHAR(32),
  `Amount` DOUBLE(8,2),
  `Amount Type` VARCHAR(8),
  `Date` DATE,
  `Envelope Number` INT(8),
  PRIMARY KEY (`Donation ID`),
  CONSTRAINT `Members_Donation_FK` FOREIGN KEY (`Envelope Number`) REFERENCES `church finance`.`members`(`Envelope Number`) ON UPDATE CASCADE ON DELETE CASCADE
);



ALTER TABLE `church finance`.`members`   
  ADD COLUMN `Phone` INT(10) NULL AFTER `Zip Code`,
  ADD COLUMN `Email` VARCHAR(32) NULL AFTER `Phone`;

