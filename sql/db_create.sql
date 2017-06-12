-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema smartfood
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema smartfood
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `smartfood` DEFAULT CHARACTER SET utf8 ;
USE `smartfood` ;

-- -----------------------------------------------------
-- Table `smartfood`.`Tipo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `smartfood`.`Tipo` ;

CREATE TABLE IF NOT EXISTS `smartfood`.`Tipo` (
  `idTipo` INT NOT NULL AUTO_INCREMENT,
  `nombreTipo` VARCHAR(45) NOT NULL,
  `fechaRegistro` DATETIME NOT NULL,
  PRIMARY KEY (`idTipo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `smartfood`.`Categoria`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `smartfood`.`Categoria` ;

CREATE TABLE IF NOT EXISTS `smartfood`.`Categoria` (
  `idCategoria` INT NOT NULL AUTO_INCREMENT,
  `nombreCategoria` VARCHAR(45) NULL,
  `fechaRegistro` DATETIME NULL,
  PRIMARY KEY (`idCategoria`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `smartfood`.`Rol`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `smartfood`.`Rol` ;

CREATE TABLE IF NOT EXISTS `smartfood`.`Rol` (
  `idRol` INT NOT NULL AUTO_INCREMENT,
  `nombreRol` VARCHAR(45) NOT NULL,
  `fechaRegistro` DATETIME NOT NULL,
  PRIMARY KEY (`idRol`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `smartfood`.`Usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `smartfood`.`Usuario` ;

CREATE TABLE IF NOT EXISTS `smartfood`.`Usuario` (
  `idUsuario` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(100) NOT NULL,
  `apellido` VARCHAR(100) NOT NULL,
  `correo` VARCHAR(100) NOT NULL,
  `usuario` VARCHAR(45) NOT NULL,
  `contrasenia` VARCHAR(45) NOT NULL,
  `rol` INT NOT NULL,
  `fechaRegistro` DATETIME NOT NULL,
  `activo` TINYINT NOT NULL DEFAULT 1,
  PRIMARY KEY (`idUsuario`),
  INDEX `fk_Usuario_Rol_idx` (`rol` ASC),
  UNIQUE INDEX `correo_UNIQUE` (`correo` ASC),
  UNIQUE INDEX `usuario_UNIQUE` (`usuario` ASC),
  CONSTRAINT `fk_Usuario_Rol`
    FOREIGN KEY (`rol`)
    REFERENCES `smartfood`.`Rol` (`idRol`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `smartfood`.`Restaurante`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `smartfood`.`Restaurante` ;

CREATE TABLE IF NOT EXISTS `smartfood`.`Restaurante` (
  `idRestaurante` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `ubicacion` VARCHAR(150) NOT NULL,
  PRIMARY KEY (`idRestaurante`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `smartfood`.`Servido`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `smartfood`.`Servido` ;

CREATE TABLE IF NOT EXISTS `smartfood`.`Servido` (
  `idServido` INT NOT NULL AUTO_INCREMENT,
  `nombreServido` VARCHAR(45) NOT NULL,
  `fechaRegistro` DATETIME NOT NULL,
  PRIMARY KEY (`idServido`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `smartfood`.`Plato`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `smartfood`.`Plato` ;

CREATE TABLE IF NOT EXISTS `smartfood`.`Plato` (
  `idPlato` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(50) NULL DEFAULT NULL,
  `descripcion` VARCHAR(200) NULL DEFAULT NULL,
  `img` LONGBLOB NULL DEFAULT NULL,
  `categoria` INT NOT NULL,
  `servido` INT NOT NULL,
  `tipo` INT NOT NULL,
  `restaurante` INT NOT NULL,
  `fechaRegistro` DATETIME NULL,
  PRIMARY KEY (`idPlato`),
  INDEX `fk_Plato_Tipo1_idx` (`tipo` ASC),
  INDEX `fk_Plato_Categoria1_idx` (`categoria` ASC),
  INDEX `fk_Plato_Restaurante1_idx` (`restaurante` ASC),
  INDEX `fk_Plato_Servido1_idx` (`servido` ASC),
  CONSTRAINT `fk_Plato_Tipo1`
    FOREIGN KEY (`tipo`)
    REFERENCES `smartfood`.`Tipo` (`idTipo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Plato_Categoria1`
    FOREIGN KEY (`categoria`)
    REFERENCES `smartfood`.`Categoria` (`idCategoria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Plato_Restaurante1`
    FOREIGN KEY (`restaurante`)
    REFERENCES `smartfood`.`Restaurante` (`idRestaurante`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Plato_Servido1`
    FOREIGN KEY (`servido`)
    REFERENCES `smartfood`.`Servido` (`idServido`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `smartfood`.`UsuarioRestaurante`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `smartfood`.`UsuarioRestaurante` ;

CREATE TABLE IF NOT EXISTS `smartfood`.`UsuarioRestaurante` (
  `idUsuarioRestaurante` INT NOT NULL AUTO_INCREMENT,
  `usuario` INT NOT NULL,
  `restaurante` INT NOT NULL,
  PRIMARY KEY (`idUsuarioRestaurante`),
  INDEX `fk_UsuarioRestaurante_Usuario1_idx` (`usuario` ASC),
  INDEX `fk_UsuarioRestaurante_Restaurante1_idx` (`restaurante` ASC),
  CONSTRAINT `fk_UsuarioRestaurante_Usuario1`
    FOREIGN KEY (`usuario`)
    REFERENCES `smartfood`.`Usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_UsuarioRestaurante_Restaurante1`
    FOREIGN KEY (`restaurante`)
    REFERENCES `smartfood`.`Restaurante` (`idRestaurante`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
