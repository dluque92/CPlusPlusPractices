SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema ACADEMIA_BD
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `ACADEMIA_BD` ;
CREATE SCHEMA IF NOT EXISTS `ACADEMIA_BD` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `ACADEMIA_BD` ;

-- -----------------------------------------------------
-- Table `ACADEMIA_BD`.`ASIGNATURA`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ACADEMIA_BD`.`ASIGNATURA` ;

CREATE TABLE IF NOT EXISTS `ACADEMIA_BD`.`ASIGNATURA` (
  `idASIGNATURA` INT NOT NULL AUTO_INCREMENT,
  `NOMBRE` VARCHAR(50) NOT NULL,
  `HORARIO` VARCHAR(45) NOT NULL,
  `AULA` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`idASIGNATURA`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ACADEMIA_BD`.`PROFESOR`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ACADEMIA_BD`.`PROFESOR` ;

CREATE TABLE IF NOT EXISTS `ACADEMIA_BD`.`PROFESOR` (
  `idPROFESOR` INT NOT NULL AUTO_INCREMENT,
  `NOMBRE` VARCHAR(50) NOT NULL,
  `APELLIDOS` VARCHAR(100) NOT NULL,
  `TELEFONO` VARCHAR(10) NOT NULL,
  `EMAIL` VARCHAR(50) NOT NULL,
  `idASIGNATURA` INT NOT NULL,
  PRIMARY KEY (`idPROFESOR`),
  INDEX `fk_PROFESOR_ASIGNATURA1_idx` (`idASIGNATURA` ASC),
  UNIQUE INDEX `idASIGNATURA_UNIQUE` (`idASIGNATURA` ASC),
  CONSTRAINT `fk_PROFESOR_ASIGNATURA1`
    FOREIGN KEY (`idASIGNATURA`)
    REFERENCES `ACADEMIA_BD`.`ASIGNATURA` (`idASIGNATURA`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ACADEMIA_BD`.`ALUMNO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ACADEMIA_BD`.`ALUMNO` ;

CREATE TABLE IF NOT EXISTS `ACADEMIA_BD`.`ALUMNO` (
  `idALUMNO` INT NOT NULL AUTO_INCREMENT,
  `NOMBRE` VARCHAR(50) NOT NULL,
  `APELLIDOS` VARCHAR(100) NOT NULL,
  `TELEFONO` VARCHAR(10) NOT NULL,
  `EMAIL` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`idALUMNO`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ACADEMIA_BD`.`REL_ALUMNO_ASIGNATURA`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ACADEMIA_BD`.`REL_ALUMNO_ASIGNATURA` ;

CREATE TABLE IF NOT EXISTS `ACADEMIA_BD`.`REL_ALUMNO_ASIGNATURA` (
  `idRELACION` INT NOT NULL AUTO_INCREMENT,
  `idALUMNO` INT NOT NULL,
  `idASIGNATURA` INT NOT NULL,
  PRIMARY KEY (`idRELACION`),
  INDEX `fk_ALUMNO_has_ASIGNATURAS_ASIGNATURAS1_idx` (`idASIGNATURA` ASC),
  INDEX `fk_ALUMNO_has_ASIGNATURAS_ALUMNO1_idx` (`idALUMNO` ASC),
  CONSTRAINT `fk_ALUMNO_has_ASIGNATURAS_ALUMNO1`
    FOREIGN KEY (`idALUMNO`)
    REFERENCES `ACADEMIA_BD`.`ALUMNO` (`idALUMNO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ALUMNO_has_ASIGNATURAS_ASIGNATURAS1`
    FOREIGN KEY (`idASIGNATURA`)
    REFERENCES `ACADEMIA_BD`.`ASIGNATURA` (`idASIGNATURA`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ACADEMIA_BD`.`CALENDARIO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ACADEMIA_BD`.`CALENDARIO` ;

CREATE TABLE IF NOT EXISTS `ACADEMIA_BD`.`CALENDARIO` (
  `idEVENTO` VARCHAR(45) NOT NULL,
  `NOMBRE` VARCHAR(60) NOT NULL,
  `START_DATE` DATETIME NOT NULL,
  `END_DATE` DATETIME NOT NULL,
  `ALL_DAY` TINYINT(1) NOT NULL,
  PRIMARY KEY (`NOMBRE`, `START_DATE`, `END_DATE`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
