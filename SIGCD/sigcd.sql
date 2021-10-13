CREATE SCHEMA IF NOT EXISTS `sigcd` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `sigcd` ;

-- -----------------------------------------------------
-- Table `sigcd`.`GradoAcademicoAA`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `sigcd`.`Persona` (
    `idPersona` INT NOT NULL AUTO_INCREMENT,
    `cedula` VARCHAR(45) NOT NULL,
    `nombre` VARCHAR(45) NOT NULL,
    `primerApellido` VARCHAR(45) NOT NULL,
    `segundoApellido` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`idPersona`)
);

-- -----------------------------------------------------
-- Table `sigcd`.`GradoAcademicoAA`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `sigcd`.`GradoAcademico` (
    `idGradoAcademico` INT NOT NULL AUTO_INCREMENT,
    `nombre` VARCHAR(45),
    PRIMARY KEY (`idGradoAcademico`)
);

-- -----------------------------------------------------
-- Table `sigcd`.`Estado`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `sigcd`.`Estado` (
    `idEstado` INT NOT NULL AUTO_INCREMENT,
    `descripcion` VARCHAR(45),
    PRIMARY KEY (`idEstado`)
);

-- -----------------------------------------------------
-- Table `sigcd`.`Distrito`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `sigcd`.`Distrito` (
    `idDistrito` INT NOT NULL AUTO_INCREMENT,
    `nombre` VARCHAR(45),
    PRIMARY KEY (`idDistrito`)
);

-- -----------------------------------------------------
-- Table `sigcd`.`Barrio`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `sigcd`.`Barrio` (
    `idBarrio` INT NOT NULL AUTO_INCREMENT,
    `nombre` VARCHAR(45),
    PRIMARY KEY (`idBarrio`)
);

-- -----------------------------------------------------
-- Table `sigcd`.`Estudiante`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `sigcd`.`Estudiante` (
    `idEstudiante` INT NOT NULL AUTO_INCREMENT,
    `persona` INT NOT NULL,
    `gradoAcademico` INT NOT NULL,
    `edad` INT NOT NULL,
    `fechaNacimiento` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`idEstudiante`),
    CONSTRAINT `fkPersonaE` FOREIGN KEY (`persona`)
        REFERENCES `sigcd`.`Persona` (`idPersona`),
    CONSTRAINT `fkGradoAcademico` FOREIGN KEY (`gradoAcademico`)
        REFERENCES `sigcd`.`GradoAcademico` (`idGradoAcademico`)
);

-- -----------------------------------------------------
-- Table `sigcd`.`Solicitante`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `sigcd`.`Solicitante` (
    `idSolicitante` INT NOT NULL AUTO_INCREMENT,
    `persona` INT NOT NULL,
    `telefonoHabitacion` VARCHAR(45),
    `telefonoCelular` VARCHAR(45) NOT NULL,
    `distrito` INT NOT NULL,
    `barrio` INT NOT NULL,
    `direccionExacta` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`idSolicitante`),
    CONSTRAINT `fkPersonaS` FOREIGN KEY (`persona`)
        REFERENCES `sigcd`.`Persona` (`idPersona`),
    CONSTRAINT `fkDistritoS` FOREIGN KEY (`distrito`)
        REFERENCES `sigcd`.`Distrito` (`idDistrito`),
    CONSTRAINT `fkBarrioS` FOREIGN KEY (`barrio`)
        REFERENCES `sigcd`.`Barrio` (`idBarrio`)
);

-- -----------------------------------------------------
-- Table `sigcd`.`AyudaTemporal`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `sigcd`.`AyudaTemporal` (
    `idAyudaTemporal` INT NOT NULL AUTO_INCREMENT,
    `estado` INT NOT NULL,
    `solicitante` INT NOT NULL,
    `motivoAyuda` VARCHAR(200) NOT NULL,
    `fechaCreacion` TIMESTAMP NOT NULL,
    PRIMARY KEY (`idAyudaTemporal`),
    CONSTRAINT `fkSolicitanteAT` FOREIGN KEY (`solicitante`)
        REFERENCES `sigcd`.`Solicitante` (`idSolicitante`),
    CONSTRAINT `fkEstadoAY` FOREIGN KEY (`estado`)
        REFERENCES `sigcd`.`Estado` (`idEstado`)
);

-- -----------------------------------------------------
-- Table `sigcd`.`BecaMunicipal`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `sigcd`.`BecaMunicipal` (
    `idBecaMunicipal` INT NOT NULL AUTO_INCREMENT,
    `estado` INT NOT NULL,
    `solicitante` INT NOT NULL,
    `estudiante` INT NOT NULL,
    `segundoEncargado` INT,
    `fechaCreacion` TIMESTAMP NOT NULL,
    PRIMARY KEY (`idBecaMunicipal`),
    CONSTRAINT `fkSolicitanteBM` FOREIGN KEY (`solicitante`)
        REFERENCES `sigcd`.`Solicitante` (`idSolicitante`),
    CONSTRAINT `fkEstudiante` FOREIGN KEY (`estudiante`)
        REFERENCES `sigcd`.`Estudiante` (`idEstudiante`),
    CONSTRAINT `fkSegundoEncargado` FOREIGN KEY (`segundoEncargado`)
        REFERENCES `sigcd`.`Persona` (`idPersona`),
    CONSTRAINT `fkEstadoBM` FOREIGN KEY (`estado`)
        REFERENCES `sigcd`.`Estado` (`idEstado`)
);  

-- -----------------------------------------------------
-- Estados por defecto
-- -----------------------------------------------------

insert  into Estado values(1, "A espera de revisión");
insert	into Estado values(2, "Rechazada");
insert	into Estado values(3, "Aceptada");

-- -----------------------------------------------------
-- Distritos por defecto
-- -----------------------------------------------------

insert into Distrito values(1, "San Pablo");
insert into Distrito values(2, "Rincón de Sabanilla");

-- -----------------------------------------------------
-- Barrios por defecto
-- -----------------------------------------------------

insert into Barrio values(1, "Las Cruces");
insert into Barrio values(2, "Las Joyas");
insert into Barrio values(3, "María Auxiliadora");
insert into Barrio values(4, "La Puebla");
insert into Barrio values(5, "Las Quintanas");
insert into Barrio values(6, "Uriche");
insert into Barrio values(7, "La Amelia");
insert into Barrio values(8, "Las Pastoras");
insert into Barrio values(9, "Rincón de Ricardo");
insert into Barrio values(10, "Miraflores");
insert into Barrio values(11, "Calle Cordero");
insert into Barrio values(12, "Rinconada");

-- -----------------------------------------------------
-- Grados académicos por defecto
-- -----------------------------------------------------

insert into GradoAcademico  values(1, "Primer grado");
insert into GradoAcademico  values(2, "Segundo grado");
insert into GradoAcademico  values(3, "Tercer grado");
insert into GradoAcademico  values(4, "Cuarto grado");
insert into GradoAcademico  values(5, "Quinto grado");
insert into GradoAcademico  values(6, "Sexto grado");
insert into GradoAcademico  values(7, "Sétimo año");
insert into GradoAcademico  values(8, "Octavo año");
insert into GradoAcademico  values(9, "Noveno año");
insert into GradoAcademico  values(10, "Décimo año");
insert into GradoAcademico  values(11, "Undécimo año");
insert into GradoAcademico  values(12, "Duodécimo año");

-- -----------------------------------------------------
-- Pruebas
-- -----------------------------------------------------