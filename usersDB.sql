-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `usersDB` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema usersDB
-- -----------------------------------------------------
USE `usersDB` ;

-- -----------------------------------------------------
-- Table `mydb`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `usersDB`.`users` (
  `password` INT NOT NULL,
  `name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`password`, `name`));


-- -----------------------------------------------------
-- Table `mydb`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `usersDB`.`user` (
  `username` VARCHAR(8) NOT NULL,
  `password` VARCHAR(8) NOT NULL,
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`username`));


-- -----------------------------------------------------
-- Table `mydb`.`balance`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `usersDB`.`balance` (
  `amount` INT NOT NULL,
  `username` VARCHAR(8) NOT NULL,
  PRIMARY KEY (`username`),
  INDEX `fk_balance_user_idx` (`username` ASC),
  CONSTRAINT `fk_balance_user`
    FOREIGN KEY (`username`)
    REFERENCES `usersDB`.`user` (`username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
