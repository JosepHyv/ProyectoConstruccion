CREATE DATABASE  IF NOT EXISTS `tutoriasfei` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `tutoriasfei`;
-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: sistemadegestiondetutorias.mysql.database.azure.com    Database: tutoriasfei
-- ------------------------------------------------------
-- Server version	5.7.37-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
SET @MYSQLDUMP_TEMP_LOG_BIN = @@SESSION.SQL_LOG_BIN;
SET @@SESSION.SQL_LOG_BIN= 0;

--
-- GTID state at the beginning of the backup 
--

-- SET @@GLOBAL.GTID_PURGED=/*!80000 '+'*/ '8e70f8e7-ed2b-11ec-8472-000d3a12db5c:1-235';

--
-- Table structure for table `academico`
--

DROP TABLE IF EXISTS `academico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `academico` (
  `idAcademico` int(11) NOT NULL AUTO_INCREMENT COMMENT 'llave primaria',
  `nombres` varchar(100) NOT NULL,
  `apellidoPaterno` varchar(100) NOT NULL,
  `apellidoMaterno` varchar(100) NOT NULL,
  `correo` varchar(100) NOT NULL,
  `esActivo` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`idAcademico`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `estudiante`
--

DROP TABLE IF EXISTS `estudiante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estudiante` (
  `idEstudiante` int(11) NOT NULL AUTO_INCREMENT,
  `nombres` varchar(100) NOT NULL,
  `apellidoPaterno` varchar(100) NOT NULL,
  `apellidoMaterno` varchar(100) NOT NULL,
  `correo` varchar(100) NOT NULL,
  `matricula` varchar(10) NOT NULL,
  `semestre` varchar(100) NOT NULL,
  `idTutorAcademico` int(11) DEFAULT NULL,
  `idPeriodo` int(11) NOT NULL,
  PRIMARY KEY (`idEstudiante`),
  KEY `idPeriodo` (`idPeriodo`),
  KEY `estudiante_ibfk_1` (`idTutorAcademico`),
  CONSTRAINT `estudiante_ibfk_1` FOREIGN KEY (`idTutorAcademico`) REFERENCES `academico` (`idAcademico`),
  CONSTRAINT `estudiante_ibfk_2` FOREIGN KEY (`idPeriodo`) REFERENCES `periodo` (`idPeriodo`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `experienciaeducativa`
--

DROP TABLE IF EXISTS `experienciaeducativa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `experienciaeducativa` (
  `idExperienciaEducativa` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  `nrc` varchar(5) NOT NULL,
  `programaEducativo` varchar(100) NOT NULL,
  `esOfertada` tinyint(1) DEFAULT NULL,
  `semestreRecomendado` int(11) DEFAULT NULL,
  `area` varchar(100) NOT NULL,
  `idPeriodo` int(11) DEFAULT NULL,
  PRIMARY KEY (`idExperienciaEducativa`),
  KEY `idPeriodo` (`idPeriodo`),
  CONSTRAINT `experienciaeducativa_ibfk_1` FOREIGN KEY (`idPeriodo`) REFERENCES `periodo` (`idPeriodo`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `horariosesion`
--

DROP TABLE IF EXISTS `horariosesion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `horariosesion` (
  `idHorarioSesion` int(11) NOT NULL AUTO_INCREMENT COMMENT 'llave primaria',
  `horaInicio` time NOT NULL,
  `horaFin` time NOT NULL,
  `modalidad` varchar(100) NOT NULL,
  `locacion` varchar(100) NOT NULL,
  `idSesionTutoria` int(11) NOT NULL,
  PRIMARY KEY (`idHorarioSesion`),
  KEY `idSesionTutoria` (`idSesionTutoria`),
  CONSTRAINT `horariosesion_ibfk_1` FOREIGN KEY (`idSesionTutoria`) REFERENCES `sesiontutoria` (`idSesionTutoria`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `imparte`
--

DROP TABLE IF EXISTS `imparte`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `imparte` (
  `idImparte` int(11) NOT NULL AUTO_INCREMENT,
  `idAcademico` int(11) DEFAULT NULL,
  `idExperienciaEducativa` int(5) DEFAULT NULL,
  PRIMARY KEY (`idImparte`),
  KEY `imparte_ibfk_1` (`idAcademico`),
  KEY `imparte_ibfk_2` (`idExperienciaEducativa`),
  CONSTRAINT `imparte_ibfk_1` FOREIGN KEY (`idAcademico`) REFERENCES `academico` (`idAcademico`),
  CONSTRAINT `imparte_ibfk_2` FOREIGN KEY (`idExperienciaEducativa`) REFERENCES `experienciaeducativa` (`idExperienciaEducativa`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `periodo`
--

DROP TABLE IF EXISTS `periodo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `periodo` (
  `idPeriodo` int(11) NOT NULL AUTO_INCREMENT,
  `fechaInicio` date NOT NULL,
  `fechaFin` date NOT NULL,
  PRIMARY KEY (`idPeriodo`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `problematicaacademica`
--

DROP TABLE IF EXISTS `problematicaacademica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `problematicaacademica` (
  `idProblematicaAcademica` int(11) NOT NULL AUTO_INCREMENT,
  `numAlum` int(11) DEFAULT NULL,
  `descripcion` text,
  `gravedad` varchar(100) NOT NULL,
  `categoria` varchar(100) NOT NULL,
  `solucion` text,
  `idPeriodo` int(11) NOT NULL,
  `idReporteTutoria` int(11) NOT NULL,
  PRIMARY KEY (`idProblematicaAcademica`),
  KEY `idPeriodo` (`idPeriodo`),
  KEY `idReporteTutoria` (`idReporteTutoria`),
  CONSTRAINT `problematicaacademica_ibfk_1` FOREIGN KEY (`idPeriodo`) REFERENCES `periodo` (`idPeriodo`),
  CONSTRAINT `problematicaacademica_ibfk_2` FOREIGN KEY (`idReporteTutoria`) REFERENCES `reportetutoria` (`idReporteTutoria`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `reportegeneral`
--

DROP TABLE IF EXISTS `reportegeneral`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reportegeneral` (
  `idReporteGeneral` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `objetivo` text NOT NULL,
  `totalAlumnosRegistrados` int(11) NOT NULL,
  `totalAlumnosAsistencia` int(11) NOT NULL,
  `comentarios` text,
  PRIMARY KEY (`idReporteGeneral`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `reportetutoria`
--

DROP TABLE IF EXISTS `reportetutoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reportetutoria` (
  `idReporteTutoria` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `programaEducativo` varchar(100) NOT NULL,
  `numAsistencia` int(11) NOT NULL,
  `numRiesgo` int(11) NOT NULL,
  `comentarios` text,
  `idReporteGeneral` int(11) DEFAULT NULL,
  PRIMARY KEY (`idReporteTutoria`),
  KEY `reportetutoria_ibfk_1` (`idReporteGeneral`),
  CONSTRAINT `reportetutoria_ibfk_1` FOREIGN KEY (`idReporteGeneral`) REFERENCES `reportegeneral` (`idReporteGeneral`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `idRol` int(11) NOT NULL AUTO_INCREMENT COMMENT 'llave primaria',
  `nombreRol` varchar(100) NOT NULL,
  PRIMARY KEY (`idRol`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `rolesacademicousuarios`
--

DROP TABLE IF EXISTS `rolesacademicousuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rolesacademicousuarios` (
  `idRolUsuario` int(11) NOT NULL AUTO_INCREMENT COMMENT 'llave primaria',
  `idRol` int(11) NOT NULL,
  `idAcademico` int(11) NOT NULL,
  PRIMARY KEY (`idRolUsuario`),
  KEY `idRol` (`idRol`),
  KEY `idAcademico` (`idAcademico`),
  CONSTRAINT `rolesacademicousuarios_ibfk_1` FOREIGN KEY (`idRol`) REFERENCES `roles` (`idRol`),
  CONSTRAINT `rolesacademicousuarios_ibfk_2` FOREIGN KEY (`idAcademico`) REFERENCES `academico` (`idAcademico`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sesiontutoria`
--

DROP TABLE IF EXISTS `sesiontutoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sesiontutoria` (
  `idSesionTutoria` int(11) NOT NULL AUTO_INCREMENT,
  `fechaLimiteEntrega` date NOT NULL,
  `numSesion` int(11) NOT NULL,
  `idTutorAcademico` int(11) NOT NULL,
  `idPeriodo` int(11) NOT NULL,
  PRIMARY KEY (`idSesionTutoria`),
  KEY `idTutorAcademico` (`idTutorAcademico`),
  KEY `idPeriodo` (`idPeriodo`),
  CONSTRAINT `sesiontutoria_ibfk_1` FOREIGN KEY (`idTutorAcademico`) REFERENCES `academico` (`idAcademico`),
  CONSTRAINT `sesiontutoria_ibfk_2` FOREIGN KEY (`idPeriodo`) REFERENCES `periodo` (`idPeriodo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT COMMENT 'llave primaria',
  `username` varchar(100) NOT NULL,
  `password` varchar(32) NOT NULL,
  `idRolUsuario` int(11) NOT NULL,
  PRIMARY KEY (`idUsuario`),
  KEY `idRolUsuario` (`idRolUsuario`),
  CONSTRAINT `usuarios_ibfk_1` FOREIGN KEY (`idRolUsuario`) REFERENCES `rolesacademicousuarios` (`idRolUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping events for database 'tutoriasfei'
--

--
-- Dumping routines for database 'tutoriasfei'
--
SET @@SESSION.SQL_LOG_BIN = @MYSQLDUMP_TEMP_LOG_BIN;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-23 23:09:38
