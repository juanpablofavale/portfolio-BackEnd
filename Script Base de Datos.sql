-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema portfolio
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema portfolio
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `portfolio` DEFAULT CHARACTER SET utf8 ;
USE `portfolio` ;

-- -----------------------------------------------------
-- Table `portfolio`.`persona`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `portfolio`.`persona` (
  `id` INT NOT NULL,
  `img-banner` VARCHAR(200) NOT NULL,
  `img-perfil` VARCHAR(200) NOT NULL,
  `nombre-y-apellido` VARCHAR(100) NOT NULL,
  `subtitulo` VARCHAR(45) NOT NULL,
  `acerca` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `portfolio`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `portfolio`.`usuario` (
  `id` INT NOT NULL,
  `nombre_usuario` VARCHAR(45) NOT NULL,
  `contraseña` VARCHAR(45) NOT NULL,
  `nombre y apellido` VARCHAR(100) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `telefono` VARCHAR(20) NOT NULL,
  `usuariocol` VARCHAR(45) NOT NULL,
  `persona_id` INT NOT NULL,
  PRIMARY KEY (`id`, `persona_id`),
  INDEX `fk_usuario_persona_idx` (`persona_id` ASC) VISIBLE,
  CONSTRAINT `fk_usuario_persona`
    FOREIGN KEY (`persona_id`)
    REFERENCES `portfolio`.`persona` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `portfolio`.`proyecto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `portfolio`.`proyecto` (
  `id` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `imagen` VARCHAR(100) NOT NULL,
  `descripcion` VARCHAR(200) NOT NULL,
  `enlace` VARCHAR(100) NOT NULL,
  `persona_id` INT NOT NULL,
  PRIMARY KEY (`id`, `persona_id`),
  INDEX `fk_proyecto_persona1_idx` (`persona_id` ASC) VISIBLE,
  CONSTRAINT `fk_proyecto_persona1`
    FOREIGN KEY (`persona_id`)
    REFERENCES `portfolio`.`persona` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `portfolio`.`experiencia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `portfolio`.`experiencia` (
  `id` INT NOT NULL,
  `img-logo` VARCHAR(45) NOT NULL,
  `nombre-empresa` VARCHAR(45) NOT NULL,
  `titulo` VARCHAR(100) NOT NULL,
  `fecha` DATE NOT NULL,
  `persona_id` INT NOT NULL,
  PRIMARY KEY (`id`, `persona_id`),
  INDEX `fk_experiencia_persona1_idx` (`persona_id` ASC) VISIBLE,
  CONSTRAINT `fk_experiencia_persona1`
    FOREIGN KEY (`persona_id`)
    REFERENCES `portfolio`.`persona` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `portfolio`.`tecnologias`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `portfolio`.`tecnologias` (
  `id` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `img-logo` VARCHAR(100) NOT NULL,
  `porcentaje` INT NOT NULL,
  `persona_id` INT NOT NULL,
  PRIMARY KEY (`id`, `persona_id`),
  INDEX `fk_tecnologias_persona1_idx` (`persona_id` ASC) VISIBLE,
  CONSTRAINT `fk_tecnologias_persona1`
    FOREIGN KEY (`persona_id`)
    REFERENCES `portfolio`.`persona` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `portfolio`.`educacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `portfolio`.`educacion` (
  `id` INT NOT NULL,
  `img-logo` VARCHAR(100) NOT NULL,
  `nombre-institucion` VARCHAR(45) NOT NULL,
  `titulo` VARCHAR(45) NOT NULL,
  `fecha` DATE NOT NULL,
  `persona_id` INT NOT NULL,
  PRIMARY KEY (`id`, `persona_id`),
  INDEX `fk_educacion_persona1_idx` (`persona_id` ASC) VISIBLE,
  CONSTRAINT `fk_educacion_persona1`
    FOREIGN KEY (`persona_id`)
    REFERENCES `portfolio`.`persona` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
