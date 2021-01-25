-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.4.11-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Volcando estructura de base de datos para puntu4
CREATE DATABASE IF NOT EXISTS `puntu4` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `puntu4`;

-- Volcando estructura para tabla puntu4.notas
CREATE TABLE IF NOT EXISTS `notas` (
  `codigo` int(11) NOT NULL,
  `nomasig` varchar(60) DEFAULT NULL,
  `nota1` decimal(4,2) DEFAULT NULL,
  `nota2` decimal(4,2) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Volcando datos para la tabla puntu4.notas: ~6 rows (aproximadamente)
/*!40000 ALTER TABLE `notas` DISABLE KEYS */;
INSERT INTO `notas` (`codigo`, `nomasig`, `nota1`, `nota2`) VALUES
	(1, 'Bases de datos', 3.00, 7.00),
	(2, 'Lenguajes', 6.25, 2.15),
	(4, 'Programación', 9.00, 7.25),
	(5, 'Entornos', 11.00, 7.25),
	(6, 'PSP', 8.00, 7.00);
/*!40000 ALTER TABLE `notas` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
