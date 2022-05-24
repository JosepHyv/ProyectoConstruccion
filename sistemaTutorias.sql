-- MariaDB dump 10.19  Distrib 10.7.3-MariaDB, for Linux (x86_64)
--
-- Host: localhost    Database: sistemaTutorias
-- ------------------------------------------------------
-- Server version	10.7.3-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `estudiante`
--

DROP TABLE IF EXISTS `estudiante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estudiante` (
  `idEstudiante` int(11) NOT NULL AUTO_INCREMENT,
  `nombres` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `apellidoPaterno` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `apellidoMaterno` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `correo` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `matricula` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `semestre` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `idTutorAcademico` int(11) DEFAULT NULL,
  `idPeriodo` int(11) DEFAULT NULL,
  PRIMARY KEY (`idEstudiante`),
  KEY `estudiante_tutorAcademico_FK` (`idTutorAcademico`),
  KEY `estudiante_periodo_FK` (`idPeriodo`),
  CONSTRAINT `estudiante_periodo_FK` FOREIGN KEY (`idPeriodo`) REFERENCES `periodo` (`idPeriodo`),
  CONSTRAINT `estudiante_tutorAcademico_FK` FOREIGN KEY (`idTutorAcademico`) REFERENCES `tutorAcademico` (`idTutorAcademico`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estudiante`
--

LOCK TABLES `estudiante` WRITE;
/*!40000 ALTER TABLE `estudiante` DISABLE KEYS */;
/*!40000 ALTER TABLE `estudiante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `experienciaEducativa`
--

DROP TABLE IF EXISTS `experienciaEducativa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `experienciaEducativa` (
  `idExperienciaEducativa` int(11) NOT NULL AUTO_INCREMENT,
  `nrc` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `programaEducativo` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `esOfertada` tinyint(1) DEFAULT NULL,
  `semestreRecomendado` int(11) DEFAULT NULL,
  `area` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `idPeriodo` int(11) DEFAULT NULL,
  `idProfesor` int(11) DEFAULT NULL,
  PRIMARY KEY (`idExperienciaEducativa`),
  KEY `experienciaEducativa_periodo_FK` (`idPeriodo`),
  KEY `experienciaEducativa_profesor_FK` (`idProfesor`),
  CONSTRAINT `experienciaEducativa_periodo_FK` FOREIGN KEY (`idPeriodo`) REFERENCES `periodo` (`idPeriodo`),
  CONSTRAINT `experienciaEducativa_profesor_FK` FOREIGN KEY (`idProfesor`) REFERENCES `profesor` (`idProfesor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `experienciaEducativa`
--

LOCK TABLES `experienciaEducativa` WRITE;
/*!40000 ALTER TABLE `experienciaEducativa` DISABLE KEYS */;
/*!40000 ALTER TABLE `experienciaEducativa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `horarioSesion`
--

DROP TABLE IF EXISTS `horarioSesion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `horarioSesion` (
  `idHorarioSesion` int(11) NOT NULL AUTO_INCREMENT,
  `horaInicio` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `horaFin` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `modalidad` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `locacion` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `idSesionTutoria` int(11) DEFAULT NULL,
  PRIMARY KEY (`idHorarioSesion`),
  KEY `horarioSesion_FK` (`idSesionTutoria`),
  CONSTRAINT `horarioSesion_FK` FOREIGN KEY (`idSesionTutoria`) REFERENCES `sesionTutoria` (`idSesionTutoria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `horarioSesion`
--

LOCK TABLES `horarioSesion` WRITE;
/*!40000 ALTER TABLE `horarioSesion` DISABLE KEYS */;
/*!40000 ALTER TABLE `horarioSesion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `periodo`
--

DROP TABLE IF EXISTS `periodo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `periodo` (
  `idPeriodo` int(11) NOT NULL AUTO_INCREMENT,
  `fechaInicio` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `fechaFin` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`idPeriodo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `periodo`
--

LOCK TABLES `periodo` WRITE;
/*!40000 ALTER TABLE `periodo` DISABLE KEYS */;
/*!40000 ALTER TABLE `periodo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `problematicaAcademica`
--

DROP TABLE IF EXISTS `problematicaAcademica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `problematicaAcademica` (
  `idProblematicaAcademica` int(11) NOT NULL AUTO_INCREMENT,
  `numAlum` int(11) DEFAULT NULL,
  `descripcion` text COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `gravedad` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `categoria` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `solucion` text COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `idPeriodo` int(11) DEFAULT NULL,
  `idReporteTutoria` int(11) DEFAULT NULL,
  PRIMARY KEY (`idProblematicaAcademica`),
  KEY `problematicaAcademica_periodo_FK` (`idPeriodo`),
  KEY `problematicaAcademica_reporteTutoria_FK` (`idReporteTutoria`),
  CONSTRAINT `problematicaAcademica_periodo_FK` FOREIGN KEY (`idPeriodo`) REFERENCES `periodo` (`idPeriodo`),
  CONSTRAINT `problematicaAcademica_reporteTutoria_FK` FOREIGN KEY (`idReporteTutoria`) REFERENCES `reporteTutoria` (`idReporteTutoria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `problematicaAcademica`
--

LOCK TABLES `problematicaAcademica` WRITE;
/*!40000 ALTER TABLE `problematicaAcademica` DISABLE KEYS */;
/*!40000 ALTER TABLE `problematicaAcademica` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profesor`
--

DROP TABLE IF EXISTS `profesor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `profesor` (
  `idProfesor` int(11) NOT NULL AUTO_INCREMENT,
  `nombres` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `apellidoPaterno` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `apellidoMaterno` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `correo` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `tipoDeProfesor` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `esActivo` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`idProfesor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profesor`
--

LOCK TABLES `profesor` WRITE;
/*!40000 ALTER TABLE `profesor` DISABLE KEYS */;
/*!40000 ALTER TABLE `profesor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reporteGeneral`
--

DROP TABLE IF EXISTS `reporteGeneral`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reporteGeneral` (
  `idReporteGeneral` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `objetivo` text COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `totalAlumRegistrados` int(11) DEFAULT NULL,
  `totalAlumAsistencia` int(11) DEFAULT NULL,
  `comentarios` text COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`idReporteGeneral`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reporteGeneral`
--

LOCK TABLES `reporteGeneral` WRITE;
/*!40000 ALTER TABLE `reporteGeneral` DISABLE KEYS */;
/*!40000 ALTER TABLE `reporteGeneral` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reporteTutoria`
--

DROP TABLE IF EXISTS `reporteTutoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reporteTutoria` (
  `idReporteTutoria` int(11) NOT NULL AUTO_INCREMENT,
  `numReporte` int(11) DEFAULT NULL,
  `fecha` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `programaEducativo` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `numAsistencia` int(11) DEFAULT NULL,
  `numRiesgo` int(11) DEFAULT NULL,
  `comentarios` text COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `idReporteGeneral` int(11) DEFAULT NULL,
  PRIMARY KEY (`idReporteTutoria`),
  KEY `reporteTutoria_FK` (`idReporteGeneral`),
  CONSTRAINT `reporteTutoria_FK` FOREIGN KEY (`idReporteGeneral`) REFERENCES `reporteGeneral` (`idReporteGeneral`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reporteTutoria`
--

LOCK TABLES `reporteTutoria` WRITE;
/*!40000 ALTER TABLE `reporteTutoria` DISABLE KEYS */;
/*!40000 ALTER TABLE `reporteTutoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sesionTutoria`
--

DROP TABLE IF EXISTS `sesionTutoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sesionTutoria` (
  `idSesionTutoria` int(11) NOT NULL AUTO_INCREMENT,
  `fechaLimite` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `numSesion` int(11) DEFAULT NULL,
  `idTutorAcademico` int(11) DEFAULT NULL,
  `idPeriodo` int(11) DEFAULT NULL,
  PRIMARY KEY (`idSesionTutoria`),
  KEY `sesionTutoria_tutorAcademico_FK` (`idTutorAcademico`),
  KEY `sesionTutoria_periodo_FK` (`idPeriodo`),
  CONSTRAINT `sesionTutoria_periodo_FK` FOREIGN KEY (`idPeriodo`) REFERENCES `periodo` (`idPeriodo`),
  CONSTRAINT `sesionTutoria_tutorAcademico_FK` FOREIGN KEY (`idTutorAcademico`) REFERENCES `tutorAcademico` (`idTutorAcademico`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sesionTutoria`
--

LOCK TABLES `sesionTutoria` WRITE;
/*!40000 ALTER TABLE `sesionTutoria` DISABLE KEYS */;
/*!40000 ALTER TABLE `sesionTutoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tutorAcademico`
--

DROP TABLE IF EXISTS `tutorAcademico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tutorAcademico` (
  `idTutorAcademico` int(11) NOT NULL AUTO_INCREMENT,
  `nombres` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `apellidoPaterno` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `apellidoMaterno` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `tipoTutor` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`idTutorAcademico`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tutorAcademico`
--

LOCK TABLES `tutorAcademico` WRITE;
/*!40000 ALTER TABLE `tutorAcademico` DISABLE KEYS */;
/*!40000 ALTER TABLE `tutorAcademico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `pasword` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `rol` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`idUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'sistemaTutorias'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-24 10:33:54
