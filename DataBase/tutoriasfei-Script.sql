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

-- SET @@GLOBAL.GTID_PURGED=/*!80000 '+'*/ '8e70f8e7-ed2b-11ec-8472-000d3a12db5c:1-255';

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
-- Dumping data for table `academico`
--

LOCK TABLES `academico` WRITE;
/*!40000 ALTER TABLE `academico` DISABLE KEYS */;
INSERT INTO `academico` VALUES (1,'Otto','Miguel','Jimenez','ottoMJ@uv.mx',1),(2,'Carlos ALberto','Martinez','Yedra','carlosYedra@uv.mx',1),(3,'Luis ALberto','Citalan','Jimenez','lacj12@uv.mx',1),(4,'Angel Juan','Sanchez','Garcia','angels@uv.mx',1),(5,'Peter','Parker','Parkinson','pParker@uv.mx',1),(6,'Collete','Danvers','Stark','msDanvers@uv.mx',1),(7,'Samuel','Jonson','Jameson','jjSamuel@uv.mx',1),(8,'Federica Peluche','Rodriguez','Lara','fpLara@uv.mx',1),(9,'Homero','Jay','Simpson','homeroj.s@uv.mx',1),(10,'Angel','Manuel','Alfonso','alfonsoM@uv.mx',1);
/*!40000 ALTER TABLE `academico` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `estudiante`
--

LOCK TABLES `estudiante` WRITE;
/*!40000 ALTER TABLE `estudiante` DISABLE KEYS */;
INSERT INTO `estudiante` VALUES (1,'Joseph Hynimoto','Aguilar','Lopez','zs20015711@estudiantes.uv.mx','s20015711','4',4,1),(2,'Leonardo','Criollo','Ramirez','zs20015753@estudiantes.uv.mx','s20015753','4',4,1),(3,'Juan Pablo','Peredo','Martinez','zs20015724@estudiantes.uv.mx','s20015724','4',4,1),(4,'Roberto','Pozos','Martinez','zs21015980@estudiantes.uv.mx','s21015980','2',8,1),(5,'Carlos','Perez','Perez','zs21015640@estudiantes.uv.mx','s21015640','2',9,1),(6,'Mariana','Jimenez','Rios','zs19013560@estudiantes.uv.mx','s19013560','6',10,1),(7,'Luisa','Garcia','Gomez','zs19012650@estudiantes.uv.mx','s19012650','6',9,1),(8,'Karla','Corona','Galvan','zs19016550@estudiantes.uv.mx','s19016550','6',8,1),(9,'Guadalupe','Garcia','Ruiz','zs20015712@estudiantes.uv.mx','s20015712','4',10,1);
/*!40000 ALTER TABLE `estudiante` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `experienciaeducativa`
--

LOCK TABLES `experienciaeducativa` WRITE;
/*!40000 ALTER TABLE `experienciaeducativa` DISABLE KEYS */;
INSERT INTO `experienciaeducativa` VALUES (1,'Matemáticas','74282','Ingenieria de Software',1,2,'Básica',1),(2,'Inglés','45689','Ingenieria de Software',1,1,'Básica',1),(3,'Programación','29846','Ingeniería de Software',1,2,'Disciplinaria',1),(4,'Estructura de Datos','46598','Ingenieria de Software',1,3,'Disciplinaria',1),(5,'Requerimientos de Software','46985','Ingenieria de Software',1,3,'Básica',1);
/*!40000 ALTER TABLE `experienciaeducativa` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `horariosesion`
--

LOCK TABLES `horariosesion` WRITE;
/*!40000 ALTER TABLE `horariosesion` DISABLE KEYS */;
/*!40000 ALTER TABLE `horariosesion` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `imparte`
--

LOCK TABLES `imparte` WRITE;
/*!40000 ALTER TABLE `imparte` DISABLE KEYS */;
INSERT INTO `imparte` VALUES (1,1,1),(2,NULL,2),(3,NULL,3),(4,5,4),(5,6,5);
/*!40000 ALTER TABLE `imparte` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `periodo`
--

LOCK TABLES `periodo` WRITE;
/*!40000 ALTER TABLE `periodo` DISABLE KEYS */;
INSERT INTO `periodo` VALUES (1,'2022-02-02','2022-06-06'),(2,'2022-08-15','2022-12-02');
/*!40000 ALTER TABLE `periodo` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `problematicaacademica`
--

LOCK TABLES `problematicaacademica` WRITE;
/*!40000 ALTER TABLE `problematicaacademica` DISABLE KEYS */;
INSERT INTO `problematicaacademica` VALUES (16,5,'una nueva problematica','Alta','Administracion',NULL,2,22),(17,2,'UNA DESCIRPCION BONITA','Crítica','Otro','UNA SOLUCION BONITA',2,23),(18,1,'Descripción bonita 2','Baja','Asistencia',NULL,2,23),(19,3,'Problematica bonita','Crítica','Catedra',NULL,2,24);
/*!40000 ALTER TABLE `problematicaacademica` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `reportegeneral`
--

LOCK TABLES `reportegeneral` WRITE;
/*!40000 ALTER TABLE `reportegeneral` DISABLE KEYS */;
INSERT INTO `reportegeneral` VALUES (1,'2022-06-23','Planeacion de horario de Preinscripcion',12,11,'Los alumnos muestran una mejoria en su desempeño academico');
/*!40000 ALTER TABLE `reportegeneral` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reportetutoria`
--

LOCK TABLES `reportetutoria` WRITE;
/*!40000 ALTER TABLE `reportetutoria` DISABLE KEYS */;
INSERT INTO `reportetutoria` VALUES (1,'2022-06-19','Ingenieria de Software',6,4,'Alumnos con deficiencia academica disminuyendo',1),(2,'2022-06-20','Ingenieria de Software',3,0,'Alumnos con excelencia',1),(3,'2022-06-23','Ingeniería en Software',3,1,'esto es un comentario ',NULL),(4,'2022-06-23','Ingeniería en Software',1,3,'1 asistencia 3 en riesgo',NULL),(13,'2022-06-23','Ingeniería en Software',3,1,'todos chidos',NULL),(14,'2022-06-23','Ingeniería en Software',3,3,'asi es ',NULL),(15,'2022-06-23','Ingeniería en Software',3,1,'todos sienten emocion por regresar a presencial',NULL),(16,'2022-06-23','Ingeniería en Software',1,0,'varias problematicas en un solo reporte',NULL),(17,'2022-06-23','Ingeniería en Software',1,2,'multiples problematicas alt',NULL),(18,'2022-06-23','Ingeniería en Software',1,2,'test',NULL),(19,'2022-06-23','Ingeniería en Software',3,2,'Nuevo clone',NULL),(20,'2022-06-23','Ingeniería en Software',2,0,'ultima tutoria',NULL),(21,'2022-06-24','Ingeniería en Software',3,2,'Comentarios bonitos de prueba',NULL),(22,'2022-06-24','Ingeniería en Software',3,1,'un comentario general',NULL),(23,'2022-06-24','Ingeniería en Software',2,1,'COMENTARIO DE REVISION',NULL),(24,'2022-06-24','Ingeniería en Software',0,0,'',NULL);
/*!40000 ALTER TABLE `reportetutoria` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'administrador'),(2,'coordinador'),(3,'tutor'),(4,'profesor');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `rolesacademicousuarios`
--

LOCK TABLES `rolesacademicousuarios` WRITE;
/*!40000 ALTER TABLE `rolesacademicousuarios` DISABLE KEYS */;
INSERT INTO `rolesacademicousuarios` VALUES (1,4,1),(2,2,2),(3,1,3),(4,3,4),(9,4,5),(10,4,6),(11,4,7),(12,3,8),(13,3,9),(15,3,10);
/*!40000 ALTER TABLE `rolesacademicousuarios` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `sesiontutoria`
--

LOCK TABLES `sesiontutoria` WRITE;
/*!40000 ALTER TABLE `sesiontutoria` DISABLE KEYS */;
/*!40000 ALTER TABLE `sesiontutoria` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'carlosA','USERCOOR',2),(2,'lacj','USERADMIN',3),(3,'angels','USERTUTOR',4),(4,'federica','USERTUTOR',12),(5,'homeroJ','USERTUTOR',13),(7,'angelM','USERTUTOR',15);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

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

-- Dump completed on 2022-06-24 17:40:49
