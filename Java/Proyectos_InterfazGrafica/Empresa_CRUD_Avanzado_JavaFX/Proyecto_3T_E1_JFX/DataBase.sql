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


-- Volcando estructura de base de datos para proy3te1
CREATE DATABASE IF NOT EXISTS `proy3te1` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `proy3te1`;

-- Volcando estructura para tabla proy3te1.alumnos
CREATE TABLE IF NOT EXISTS `alumnos` (
  `CodigoAlumno` int(11) NOT NULL,
  `DNI` varchar(9) NOT NULL,
  `Nombre` varchar(40) NOT NULL,
  `Apellidos` varchar(80) NOT NULL,
  `FechaNac` date NOT NULL,
  PRIMARY KEY (`CodigoAlumno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Volcando datos para la tabla proy3te1.alumnos: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `alumnos` DISABLE KEYS */;
INSERT INTO `alumnos` (`CodigoAlumno`, `DNI`, `Nombre`, `Apellidos`, `FechaNac`) VALUES
	(1, '52680032F', 'Manuel', 'Perera Jiménez', '2001-10-02'),
	(2, '20095466K', 'Martín', 'Rodríguez García', '1998-04-18'),
	(3, '87623497A', 'Baldomero', 'Peña Peña', '1997-05-22'),
	(4, '77382991Y', 'Sara', 'Sánchez Martínez', '1990-12-28');
/*!40000 ALTER TABLE `alumnos` ENABLE KEYS */;

-- Volcando estructura para tabla proy3te1.asignados
CREATE TABLE IF NOT EXISTS `asignados` (
  `CodigoAlumno` int(11) NOT NULL,
  `CodEmpresa` int(11) NOT NULL,
  `CodigoTutor` int(11) NOT NULL,
  PRIMARY KEY (`CodigoAlumno`,`CodEmpresa`,`CodigoTutor`),
  KEY `CodEmpresa` (`CodEmpresa`),
  KEY `CodigoTutor` (`CodigoTutor`),
  CONSTRAINT `asignados_ibfk_1` FOREIGN KEY (`CodigoAlumno`) REFERENCES `alumnos` (`CodigoAlumno`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `asignados_ibfk_2` FOREIGN KEY (`CodEmpresa`) REFERENCES `empresas` (`CodEmpresa`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `asignados_ibfk_3` FOREIGN KEY (`CodigoTutor`) REFERENCES `tutoresdocentes` (`CodigoTutor`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Volcando datos para la tabla proy3te1.asignados: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `asignados` DISABLE KEYS */;
INSERT INTO `asignados` (`CodigoAlumno`, `CodEmpresa`, `CodigoTutor`) VALUES
	(1, 1, 1);
/*!40000 ALTER TABLE `asignados` ENABLE KEYS */;

-- Volcando estructura para tabla proy3te1.empresas
CREATE TABLE IF NOT EXISTS `empresas` (
  `CodEmpresa` int(11) NOT NULL,
  `Nombre` varchar(80) NOT NULL,
  `CIF` varchar(9) NOT NULL,
  `Dirección` varchar(150) NOT NULL,
  `CP` int(11) NOT NULL,
  `Localidad` varchar(60) NOT NULL,
  `TipoJornada` varchar(8) NOT NULL,
  `DNIResp` varchar(9) NOT NULL,
  `NombreResp` varchar(40) NOT NULL,
  `ApellidosResp` varchar(80) NOT NULL,
  `DNITL` varchar(9) NOT NULL,
  `NombreTL` varchar(40) NOT NULL,
  `ApellidosTL` varchar(80) NOT NULL,
  `MailTL` varchar(50) NOT NULL,
  `TelefonoTL` int(11) NOT NULL,
  PRIMARY KEY (`CodEmpresa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Volcando datos para la tabla proy3te1.empresas: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `empresas` DISABLE KEYS */;
INSERT INTO `empresas` (`CodEmpresa`, `Nombre`, `CIF`, `Dirección`, `CP`, `Localidad`, `TipoJornada`, `DNIResp`, `NombreResp`, `ApellidosResp`, `DNITL`, `NombreTL`, `ApellidosTL`, `MailTL`, `TelefonoTL`) VALUES
	(1, 'Spyro', '86022469L', 'c/ Tomatoe', 33967, 'Cádiz', 'Continua', '86477513P', 'Carlos', 'Rodríguez Ocelote', '16499237K', 'Laura', 'López Pérez', 'laurita_morenita1992@gmail.com', 916348162),
	(2, 'Wumpa Fruit', '16723549L', 'c/ Crash Bandicoot', 55691, 'Sevilla', 'Partida', '76284953L', 'Enrique', 'Cedeño Xpeke', '64523791K', 'Mario', 'Pepino Fernández', 'mario_redondito@gmail.com', 923652478),
	(3, 'SuperCell', '16481362L', 'c/ Bárbaro', 11339, 'Toledo', 'Continua', '91645129L', 'Salvador', 'Viciado Lolito', '61894635K', 'David', 'Torres Hernández', 'davisillo_lokillo@gmail.com', 945378162);
/*!40000 ALTER TABLE `empresas` ENABLE KEYS */;

-- Volcando estructura para tabla proy3te1.tutoresdocentes
CREATE TABLE IF NOT EXISTS `tutoresdocentes` (
  `CodigoTutor` int(11) NOT NULL,
  `NomAp` varchar(40) NOT NULL,
  `Correo` varchar(50) NOT NULL,
  `Telefono` varchar(9) NOT NULL,
  PRIMARY KEY (`CodigoTutor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Volcando datos para la tabla proy3te1.tutoresdocentes: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `tutoresdocentes` DISABLE KEYS */;
INSERT INTO `tutoresdocentes` (`CodigoTutor`, `NomAp`, `Correo`, `Telefono`) VALUES
	(1, 'Prudencio Ruiz', 'pruiz@fundacionsafa.es', '666777888');
/*!40000 ALTER TABLE `tutoresdocentes` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
