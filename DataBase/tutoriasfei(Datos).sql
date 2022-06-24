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
-- Dumping data for table `academico`
--

LOCK TABLES `academico` WRITE;
/*!40000 ALTER TABLE `academico` DISABLE KEYS */;
INSERT INTO `academico` VALUES (1,'Otto','Miguel','Jimenez','ottoMJ@uv.mx',1),(2,'Carlos ALberto','Martinez','Yedra','carlosYedra@uv.mx',1),(3,'Luis ALberto','Citalan','Jimenez','lacj12@uv.mx',1),(4,'Angel Juan','Sanchez','Garcia','angels@uv.mx',1),(5,'Peter','Parker','Parkinson','pParker@uv.mx',1),(6,'Collete','Danvers','Stark','msDanvers@uv.mx',1),(7,'Samuel','Jonson','Jameson','jjSamuel@uv.mx',1),(8,'Federica Peluche','Rodriguez','Lara','fpLara@uv.mx',1),(9,'Homero','Jay','Simpson','homeroj.s@uv.mx',1),(10,'Angel','Manuel','Alfonso','alfonsoM@uv.mx',1);
/*!40000 ALTER TABLE `academico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `estudiante`
--

LOCK TABLES `estudiante` WRITE;
/*!40000 ALTER TABLE `estudiante` DISABLE KEYS */;
INSERT INTO `estudiante` VALUES (1,'Joseph Hynimoto','Aguilar','Lopez','zs20015711@estudiantes.uv.mx','s20015711','4',4,1),(2,'Leonardo','Criollo','Ramirez','zs20015753@estudiantes.uv.mx','s20015753','4',4,1),(3,'Juan Pablo','Peredo','Martinez','zs20015724@estudiantes.uv.mx','s20015724','4',4,1),(4,'Roberto','Pozos','Martinez','zs21015980@estudiantes.uv.mx','s21015980','2',8,1),(5,'Carlos','Perez','Perez','zs21015640@estudiantes.uv.mx','s21015640','2',9,1),(6,'Mariana','Jimenez','Rios','zs19013560@estudiantes.uv.mx','s19013560','6',10,1),(7,'Luisa','Garcia','Gomez','zs19012650@estudiantes.uv.mx','s19012650','6',9,1),(8,'Karla','Corona','Galvan','zs19016550@estudiantes.uv.mx','s19016550','6',8,1),(9,'Guadalupe','Garcia','Ruiz','zs20015712@estudiantes.uv.mx','s20015712','4',10,1);
/*!40000 ALTER TABLE `estudiante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `experienciaeducativa`
--

LOCK TABLES `experienciaeducativa` WRITE;
/*!40000 ALTER TABLE `experienciaeducativa` DISABLE KEYS */;
INSERT INTO `experienciaeducativa` VALUES (1,'Matemáticas','74282','Ingenieria de Software',1,2,'Básica',1),(2,'Inglés','45689','Ingenieria de Software',1,1,'Básica',1),(3,'Programación','29846','Ingeniería de Software',1,2,'Disciplinaria',1),(4,'Estructura de Datos','46598','Ingenieria de Software',1,3,'Disciplinaria',1),(5,'Requerimientos de Software','46985','Ingenieria de Software',1,3,'Básica',1);
/*!40000 ALTER TABLE `experienciaeducativa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `horariosesion`
--

LOCK TABLES `horariosesion` WRITE;
/*!40000 ALTER TABLE `horariosesion` DISABLE KEYS */;
/*!40000 ALTER TABLE `horariosesion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `imparte`
--

LOCK TABLES `imparte` WRITE;
/*!40000 ALTER TABLE `imparte` DISABLE KEYS */;
INSERT INTO `imparte` VALUES (1,1,1),(2,NULL,2),(3,5,3),(4,NULL,4),(5,NULL,5);
/*!40000 ALTER TABLE `imparte` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `periodo`
--

LOCK TABLES `periodo` WRITE;
/*!40000 ALTER TABLE `periodo` DISABLE KEYS */;
INSERT INTO `periodo` VALUES (1,'2022-02-02','2022-06-06'),(2,'2022-08-15','2022-12-02');
/*!40000 ALTER TABLE `periodo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `problematicaacademica`
--

LOCK TABLES `problematicaacademica` WRITE;
/*!40000 ALTER TABLE `problematicaacademica` DISABLE KEYS */;
INSERT INTO `problematicaacademica` VALUES (1,17,'cosas chidas		','Moderada','Administracion',NULL,2,14),(2,5,'El transporte llega tarde, y es muy caro','Alta','Asistencia','Crear transporte oficial de la UV/FEI',2,15),(3,1,'me quedo dormido','Baja','Asistencia',NULL,2,16),(4,6,'no tienen internet por las mañanas','Crítica','Clases en Linea','pagar transporte y venir a la facultad',2,16),(5,4,'enfermitos','Crítica','COVID','vacunarse y sana distancia',2,16),(6,1,'test','Baja','Otro','test',2,17),(7,2,'test2','Moderada','Administracion','test2',2,17),(8,3,'test3','Alta','COVID','test3',2,17),(9,3,'dad','Moderada','Administracion','adad',2,18),(10,7,'dwadwa','Alta','Administracion',NULL,2,18),(11,3,'hice un nuevo clone por un problema en el netbeans','Moderada','Administracion',NULL,2,19),(12,9,':3','Moderada','Administracion','>:3',2,19);
/*!40000 ALTER TABLE `problematicaacademica` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `reportegeneral`
--

LOCK TABLES `reportegeneral` WRITE;
/*!40000 ALTER TABLE `reportegeneral` DISABLE KEYS */;
INSERT INTO `reportegeneral` VALUES (1,'2022-06-23','Planeacion de horario de Preinscripcion',12,11,'Los alumnos muestran una mejoria en su desempeño academico');
/*!40000 ALTER TABLE `reportegeneral` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `reportetutoria`
--

LOCK TABLES `reportetutoria` WRITE;
/*!40000 ALTER TABLE `reportetutoria` DISABLE KEYS */;
INSERT INTO `reportetutoria` VALUES (1,'2022-06-19','Ingenieria de Software',6,4,'Alumnos con deficiencia academica disminuyendo',1),(2,'2022-06-20','Ingenieria de Software',3,0,'Alumnos con excelencia',1),(3,'2022-06-23','Ingeniería en Software',3,1,'esto es un comentario ',NULL),(4,'2022-06-23','Ingeniería en Software',1,3,'1 asistencia 3 en riesgo',NULL),(13,'2022-06-23','Ingeniería en Software',3,1,'todos chidos',NULL),(14,'2022-06-23','Ingeniería en Software',3,3,'asi es ',NULL),(15,'2022-06-23','Ingeniería en Software',3,1,'todos sienten emocion por regresar a presencial',NULL),(16,'2022-06-23','Ingeniería en Software',1,0,'varias problematicas en un solo reporte',NULL),(17,'2022-06-23','Ingeniería en Software',1,2,'multiples problematicas alt',NULL),(18,'2022-06-23','Ingeniería en Software',1,2,'test',NULL),(19,'2022-06-23','Ingeniería en Software',3,2,'Nuevo clone',NULL);
/*!40000 ALTER TABLE `reportetutoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'administrador'),(2,'coordinador'),(3,'tutor'),(4,'profesor');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `rolesacademicousuarios`
--

LOCK TABLES `rolesacademicousuarios` WRITE;
/*!40000 ALTER TABLE `rolesacademicousuarios` DISABLE KEYS */;
INSERT INTO `rolesacademicousuarios` VALUES (1,4,1),(2,2,2),(3,1,3),(4,3,4),(9,4,5),(10,4,6),(11,4,7),(12,3,8),(13,3,9),(15,3,10);
/*!40000 ALTER TABLE `rolesacademicousuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `sesiontutoria`
--

LOCK TABLES `sesiontutoria` WRITE;
/*!40000 ALTER TABLE `sesiontutoria` DISABLE KEYS */;
/*!40000 ALTER TABLE `sesiontutoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'carlosA','USERCOOR',2),(2,'lacj','USERADMIN',3),(3,'angels','USERTUTOR',4),(4,'federica','USERTUTOR',12),(5,'homeroJ','USERTUTOR',13),(7,'angelM','USERTUTOR',15);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
SET @@SESSION.SQL_LOG_BIN = @MYSQLDUMP_TEMP_LOG_BIN;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-23 23:10:24
