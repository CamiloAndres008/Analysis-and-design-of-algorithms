CREATE SCHEMA IF NOT EXISTS panaderia;
USE `panaderia` ;
show tables from panaderia;

drop table ventas;
drop table productos;

CREATE TABLE IF NOT EXISTS `panaderia`.`productos` (
  `nombre` VARCHAR(50) NOT NULL,
  `marca` VARCHAR(50) NOT NULL,
  `costo` DECIMAL NOT NULL,
  `cant` INT NOT NULL,
  PRIMARY KEY (`nombre`));

CREATE TABLE IF NOT EXISTS `panaderia`.`ventas` (
	idVenta int NOT NULL AUTO_INCREMENT,  
	`productos` VARCHAR(70) NOT NULL,
	fecha VARCHAR(70) NOT NULL,
    cantidad int NOT NULL,
	PRIMARY KEY (`idVenta`),
	constraint ventas_productos_fk foreign key (productos)references productos(nombre) on delete restrict on update cascade);

SELECT * FROM productos;
SELECT * FROM ventas;
