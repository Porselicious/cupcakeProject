DROP DATABASE IF EXISTS `usersDB`;

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';


CREATE SCHEMA IF NOT EXISTS `usersDB` DEFAULT CHARACTER SET utf8 ;
USE `usersDB` ;

-- -----------------------------------------------------
-- Table `usersDB`.`bottom`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `usersDB`.`bottom` (
  `bottomName` VARCHAR(25) NOT NULL,
  `price` INT NULL,
  PRIMARY KEY (`bottomName`));


-- -----------------------------------------------------
-- Table `usersDB`.`topping`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `usersDB`.`topping` (
  `toppingName` VARCHAR(25) NOT NULL,
  `price` INT NOT NULL,
  PRIMARY KEY (`toppingName`));


-- -----------------------------------------------------
-- Table `usersDB`.`cupcake`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `usersDB`.`cupcake` (
  `cupcakeName` VARCHAR(45) NOT NULL,
  `bottomName` VARCHAR(25) NOT NULL,
  `toppingName` VARCHAR(25) NOT NULL,
  PRIMARY KEY (`bottomName`, `toppingName`, `cupcakeName`),
  INDEX `fk_cupcake_bottom_idx` (`bottomName` ASC),
  INDEX `fk_cupcake_topping1_idx` (`toppingName` ASC),
  CONSTRAINT `fk_cupcake_bottom`
    FOREIGN KEY (`bottomName`)
    REFERENCES `usersDB`.`bottom` (`bottomName`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cupcake_topping1`
    FOREIGN KEY (`toppingName`)
    REFERENCES `usersDB`.`topping` (`toppingName`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

USE `usersDB` ;

-- -----------------------------------------------------
-- Table `usersDB`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `usersDB`.`user` (
  `username` VARCHAR(8) NOT NULL,
  `password` VARCHAR(8) NOT NULL,
  `email` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`username`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `usersDB`.`balance`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `usersDB`.`balance` (
  `amount` INT(11) NOT NULL,
  `username` VARCHAR(8) NOT NULL,
  PRIMARY KEY (`username`),
  INDEX `fk_balance_user_idx` (`username` ASC),
  CONSTRAINT `fk_balance_user`
    FOREIGN KEY (`username`)
    REFERENCES `usersDB`.`user` (`username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
