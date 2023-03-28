
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;


CREATE TABLE IF NOT EXISTS `mydb`.`grupos` (
  `codigo_grupo` INT(10) NOT NULL,
  `nombre` VARCHAR(20) NULL,
  `descripcion` VARCHAR(45) NULL,
  PRIMARY KEY (`codigo_grupo`))
ENGINE = InnoDB;



CREATE TABLE IF NOT EXISTS `mydb`.`usuarios` (
  `dni` VARCHAR(10) NOT NULL,
  `nombre` VARCHAR(45) NULL,
  `apellido1` VARCHAR(20) NULL,
  `apellido2` VARCHAR(20) NULL,
  `telefono` INT(9) NULL,
  `domicilio` VARCHAR(45) NULL,
  `grupos_codigo_grupo` INT(10) NOT NULL,
  PRIMARY KEY (`dni`),
  INDEX `fk_usuarios_grupos_idx` (`grupos_codigo_grupo` ASC),
  CONSTRAINT `fk_usuarios_grupos`
    FOREIGN KEY (`grupos_codigo_grupo`)
    REFERENCES `mydb`.`grupos` (`codigo_grupo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



CREATE TABLE IF NOT EXISTS `mydb`.`categoria` (
  `cod_cat` INT(12) NOT NULL,
  `nombre` VARCHAR(20) NULL,
  `descripcion` VARCHAR(100) NULL,
  PRIMARY KEY (`cod_cat`))
ENGINE = InnoDB;



CREATE TABLE IF NOT EXISTS `mydb`.`documentos` (
  `codigodocumento` VARCHAR(13) NOT NULL,
  `titulo` VARCHAR(45) NULL,
  `descripcion` VARCHAR(100) NULL,
  `categoria_cod_cat` INT(12) NOT NULL,
  `isbn` VARCHAR(13) NULL,
  PRIMARY KEY (`codigodocumento`, `categoria_cod_cat`),
  INDEX `fk_documentos_categoria1_idx` (`categoria_cod_cat` ASC),
  CONSTRAINT `fk_documentos_categoria1`
    FOREIGN KEY (`categoria_cod_cat`)
    REFERENCES `mydb`.`categoria` (`cod_cat`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



CREATE TABLE IF NOT EXISTS `mydb`.`autor` (
  `codigo_autor` INT NOT NULL,
  `nombre` VARCHAR(20) NULL,
  `apellido` VARCHAR(20) NULL,
  `apellido2` VARCHAR(20) NULL,
  PRIMARY KEY (`codigo_autor`))
ENGINE = InnoDB;



CREATE TABLE IF NOT EXISTS `mydb`.`documentos_has_autor` (
  `documentos_isbn` VARCHAR(13) NOT NULL,
  `documentos_categoria_cod_cat` INT(12) NOT NULL,
  `autor_codigo_autor` INT NOT NULL,
  PRIMARY KEY (`documentos_isbn`, `documentos_categoria_cod_cat`, `autor_codigo_autor`),
  INDEX `fk_documentos_has_autor_autor1_idx` (`autor_codigo_autor` ASC),
  INDEX `fk_documentos_has_autor_documentos1_idx` (`documentos_isbn` ASC, `documentos_categoria_cod_cat` ASC),
  CONSTRAINT `fk_documentos_has_autor_documentos1`
    FOREIGN KEY (`documentos_isbn` , `documentos_categoria_cod_cat`)
    REFERENCES `mydb`.`documentos` (`codigodocumento` , `categoria_cod_cat`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_documentos_has_autor_autor1`
    FOREIGN KEY (`autor_codigo_autor`)
    REFERENCES `mydb`.`autor` (`codigo_autor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



CREATE TABLE IF NOT EXISTS `mydb`.`reserva/prestamo/sanciones` (
  `usuarios_dni` VARCHAR(10) NOT NULL,
  `documentos_isbn` VARCHAR(13) NOT NULL,
  `documentos_categoria_cod_cat` INT(12) NOT NULL,
  `fecha_inicio` DATE NULL,
  `fecha_final` DATE NULL,
  `opinion` VARCHAR(200) NULL,
  `tipo` TINYINT(1) NULL,
  `fecha_real_devolucion` DATE NULL,
  `` VARCHAR(45) NULL,
  PRIMARY KEY (`usuarios_dni`, `documentos_isbn`, `documentos_categoria_cod_cat`),
  INDEX `fk_usuarios_has_documentos_documentos1_idx` (`documentos_isbn` ASC, `documentos_categoria_cod_cat` ASC),
  INDEX `fk_usuarios_has_documentos_usuarios1_idx` (`usuarios_dni` ASC),
  CONSTRAINT `fk_usuarios_has_documentos_usuarios1`
    FOREIGN KEY (`usuarios_dni`)
    REFERENCES `mydb`.`usuarios` (`dni`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuarios_has_documentos_documentos1`
    FOREIGN KEY (`documentos_isbn` , `documentos_categoria_cod_cat`)
    REFERENCES `mydb`.`documentos` (`codigodocumento` , `categoria_cod_cat`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



CREATE TABLE IF NOT EXISTS `mydb`.`libros` (
  `isbn` VARCHAR(13) NOT NULL,
  `editorial` VARCHAR(20) NULL,
  `titulo` VARCHAR(20) NULL,
  `autor` VARCHAR(20) NULL,
  `numerodepaginas` INT(4) NULL,
  `tematicas` VARCHAR(20) NULL,
  `codigodocumento` VARCHAR(20) NOT NULL,
  `documentos_codigodocumento` VARCHAR(13) NOT NULL,
  `documentos_categoria_cod_cat` INT(12) NOT NULL,
  PRIMARY KEY (`isbn`, `codigodocumento`),
  INDEX `fk_libros_documentos1_idx` (`documentos_codigodocumento` ASC, `documentos_categoria_cod_cat` ASC),
  CONSTRAINT `fk_libros_documentos1`
    FOREIGN KEY (`documentos_codigodocumento` , `documentos_categoria_cod_cat`)
    REFERENCES `mydb`.`documentos` (`codigodocumento` , `categoria_cod_cat`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



CREATE TABLE IF NOT EXISTS `mydb`.`peliculas` (
  `codigodigital` INT(10) NOT NULL,
  `director` VARCHAR(20) NULL,
  `duracion` DATE NULL,
  `actores` VARCHAR(20) NULL,
  `premios` VARCHAR(10) NULL,
  PRIMARY KEY (`codigodigital`))
ENGINE = InnoDB;



CREATE TABLE IF NOT EXISTS `mydb`.`documentales` (
  `codigodigital` INT(10) NOT NULL,
  `proiductora` VARCHAR(20) NULL,
  `premios` VARCHAR(20) NULL,
  PRIMARY KEY (`codigodigital`))
ENGINE = InnoDB;



CREATE TABLE IF NOT EXISTS `mydb`.`musica` (
  `codigodigital` INT NOT NULL,
  `cantantes` VARCHAR(45) NULL,
  PRIMARY KEY (`codigodigital`))
ENGINE = InnoDB;



CREATE TABLE IF NOT EXISTS `mydb`.`digital` (
  `codigodigital` INT(10) NOT NULL,
  `duracion` VARCHAR(5) NULL,
  `formato` VARCHAR(45) NOT NULL,
  `codigodocumento` VARCHAR(45) NOT NULL,
  `documentos_codigodocumento` VARCHAR(13) NOT NULL,
  `documentos_categoria_cod_cat` INT(12) NOT NULL,
  `peliculas_codigodigital` INT(10) NOT NULL,
  `documentales_codigodigital` INT(10) NOT NULL,
  `musica_codigodigital` INT NOT NULL,
  PRIMARY KEY (`codigodigital`, `codigodocumento`),
  INDEX `fk_digital_documentos1_idx` (`documentos_codigodocumento` ASC, `documentos_categoria_cod_cat` ASC),
  INDEX `fk_digital_peliculas1_idx` (`peliculas_codigodigital` ASC),
  INDEX `fk_digital_documentales1_idx` (`documentales_codigodigital` ASC),
  INDEX `fk_digital_musica1_idx` (`musica_codigodigital` ASC),
  CONSTRAINT `fk_digital_documentos1`
    FOREIGN KEY (`documentos_codigodocumento` , `documentos_categoria_cod_cat`)
    REFERENCES `mydb`.`documentos` (`codigodocumento` , `categoria_cod_cat`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_digital_peliculas1`
    FOREIGN KEY (`peliculas_codigodigital`)
    REFERENCES `mydb`.`peliculas` (`codigodigital`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_digital_documentales1`
    FOREIGN KEY (`documentales_codigodigital`)
    REFERENCES `mydb`.`documentales` (`codigodigital`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_digital_musica1`
    FOREIGN KEY (`musica_codigodigital`)
    REFERENCES `mydb`.`musica` (`codigodigital`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



CREATE TABLE IF NOT EXISTS `mydb`.`concierto` (
  `codigoconcierto` INT(10) NOT NULL,
  `lugar` VARCHAR(20) NULL,
  `fecha` DATE NULL,
  PRIMARY KEY (`codigoconcierto`))
ENGINE = InnoDB;



CREATE TABLE IF NOT EXISTS `mydb`.`musica_has_concierto` (
  `musica_codigodigital` INT NOT NULL,
  `concierto_codigoconcierto` INT(10) NOT NULL,
  PRIMARY KEY (`musica_codigodigital`, `concierto_codigoconcierto`),
  INDEX `fk_musica_has_concierto_concierto1_idx` (`concierto_codigoconcierto` ASC),
  INDEX `fk_musica_has_concierto_musica1_idx` (`musica_codigodigital` ASC),
  CONSTRAINT `fk_musica_has_concierto_musica1`
    FOREIGN KEY (`musica_codigodigital`)
    REFERENCES `mydb`.`musica` (`codigodigital`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_musica_has_concierto_concierto1`
    FOREIGN KEY (`concierto_codigoconcierto`)
    REFERENCES `mydb`.`concierto` (`codigoconcierto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

