CREATE DATABASE  IF NOT EXISTS `upc_sistema_control` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `upc_sistema_control`;
-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: localhost    Database: upc_sistema_control
-- ------------------------------------------------------
-- Server version	5.7.26-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tb_acceso`
--

DROP TABLE IF EXISTS `tb_acceso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tb_acceso` (
  `idtb_acceso` int(11) NOT NULL,
  `usuario` varchar(45) DEFAULT NULL,
  `contraseña` varchar(45) DEFAULT NULL,
  `dniPersona` char(8) DEFAULT NULL,
  `tb_perfil_descripcion` varchar(45) NOT NULL,
  PRIMARY KEY (`idtb_acceso`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_acceso`
--

LOCK TABLES `tb_acceso` WRITE;
/*!40000 ALTER TABLE `tb_acceso` DISABLE KEYS */;
INSERT INTO `tb_acceso` VALUES (1,'rcarrast','12345678','72239335','Administrador'),(2,'palarcov','12345678','72245887','Alumno'),(3,'afrancor','12345678','78258669','Docente'),(4,'epamelo','12345678','75582261','Alumno');
/*!40000 ALTER TABLE `tb_acceso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_cursorecomendado`
--

DROP TABLE IF EXISTS `tb_cursorecomendado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tb_cursorecomendado` (
  `idet_curso` int(11) NOT NULL,
  `puntaje` int(11) DEFAULT NULL,
  `motivo` varchar(45) DEFAULT NULL,
  `tb_cursos_idtb_cursos` int(11) NOT NULL,
  PRIMARY KEY (`idet_curso`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_cursorecomendado`
--

LOCK TABLES `tb_cursorecomendado` WRITE;
/*!40000 ALTER TABLE `tb_cursorecomendado` DISABLE KEYS */;
INSERT INTO `tb_cursorecomendado` VALUES (1,5,'Muy bueno',1),(2,3,'Regular',2),(3,4,'Bueno',3),(4,1,'Malo',4);
/*!40000 ALTER TABLE `tb_cursorecomendado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_cursos`
--

DROP TABLE IF EXISTS `tb_cursos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tb_cursos` (
  `idtb_cursos` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) DEFAULT NULL,
  `codigoCurso` char(5) DEFAULT NULL,
  `credito` int(11) DEFAULT NULL,
  `costo` double DEFAULT NULL,
  PRIMARY KEY (`idtb_cursos`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_cursos`
--

LOCK TABLES `tb_cursos` WRITE;
/*!40000 ALTER TABLE `tb_cursos` DISABLE KEYS */;
INSERT INTO `tb_cursos` VALUES (1,'Física','RT3E',2,23),(2,'Química','TR3F',2,3),(3,'Java','KRT1',2,34),(5,'Java básico','FGT4R',3,45),(6,'Contabilidad','TR2S',13,120);
/*!40000 ALTER TABLE `tb_cursos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_detcurso`
--

DROP TABLE IF EXISTS `tb_detcurso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tb_detcurso` (
  `idtb_detCurso` int(11) NOT NULL AUTO_INCREMENT,
  `pesos` double DEFAULT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  `tb_cursos_idtb_cursos` int(11) NOT NULL,
  PRIMARY KEY (`idtb_detCurso`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_detcurso`
--

LOCK TABLES `tb_detcurso` WRITE;
/*!40000 ALTER TABLE `tb_detcurso` DISABLE KEYS */;
INSERT INTO `tb_detcurso` VALUES (1,12,'TA1',1),(2,20,'PA1',2),(3,23,'PA2',3),(5,5,'PA2',4),(6,20,'PT1',5);
/*!40000 ALTER TABLE `tb_detcurso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_detpersona`
--

DROP TABLE IF EXISTS `tb_detpersona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tb_detpersona` (
  `idtb_detPersona` int(11) NOT NULL AUTO_INCREMENT,
  `tb_persona_idtb_persona` int(11) NOT NULL,
  `tb_perfil_descripcion` varchar(45) NOT NULL,
  `cuenta` char(10) DEFAULT NULL,
  PRIMARY KEY (`idtb_detPersona`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_detpersona`
--

LOCK TABLES `tb_detpersona` WRITE;
/*!40000 ALTER TABLE `tb_detpersona` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_detpersona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_horariodet`
--

DROP TABLE IF EXISTS `tb_horariodet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tb_horariodet` (
  `idtb_horarioDet` int(11) NOT NULL AUTO_INCREMENT,
  `tb_horarios_idtb_horarios` int(11) NOT NULL,
  `estado` char(2) DEFAULT NULL,
  `seccion` varchar(45) DEFAULT NULL,
  `curso` varchar(45) DEFAULT NULL,
  `docente` varchar(45) DEFAULT NULL,
  `horaInicio` varchar(10) DEFAULT NULL,
  `horaFin` varchar(10) DEFAULT NULL,
  `dia` varchar(45) DEFAULT NULL,
  `turno` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idtb_horarioDet`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_horariodet`
--

LOCK TABLES `tb_horariodet` WRITE;
/*!40000 ALTER TABLE `tb_horariodet` DISABLE KEYS */;
INSERT INTO `tb_horariodet` VALUES (8,7,'SI','SE3D-AULA2-Virtual','KRT1-Java','78258669-Alisa Franco','2','4','Lunes','1-Mañana'),(10,7,'SI','SE3D-AULA2-Virtual','TR2S-Contabilidad','78258669-Alisa Franco','5','8','Sábado','2-Tarde');
/*!40000 ALTER TABLE `tb_horariodet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_horarios`
--

DROP TABLE IF EXISTS `tb_horarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tb_horarios` (
  `idtb_horarios` int(11) NOT NULL AUTO_INCREMENT,
  `fecInicio` date DEFAULT NULL,
  `fecFin` date DEFAULT NULL,
  `periodo` varchar(10) DEFAULT NULL,
  `nivel` varchar(10) DEFAULT NULL,
  `grado` varchar(10) DEFAULT NULL,
  `tipoHorario` varchar(30) DEFAULT NULL,
  `estado` char(2) DEFAULT NULL,
  PRIMARY KEY (`idtb_horarios`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_horarios`
--

LOCK TABLES `tb_horarios` WRITE;
/*!40000 ALTER TABLE `tb_horarios` DISABLE KEYS */;
INSERT INTO `tb_horarios` VALUES (7,'2021-09-01','2021-09-05','UPC202109','Básico','Sección 1','Curso Libre','SI');
/*!40000 ALTER TABLE `tb_horarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_notas`
--

DROP TABLE IF EXISTS `tb_notas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tb_notas` (
  `idtb_notas` int(11) NOT NULL AUTO_INCREMENT,
  `curso` varchar(45) DEFAULT NULL,
  `seccion` varchar(45) DEFAULT NULL,
  `usuAlumno` varchar(45) DEFAULT NULL,
  `periodo` varchar(45) DEFAULT NULL,
  `nota1` double DEFAULT NULL,
  `nota2` double DEFAULT NULL,
  `nota3` double DEFAULT NULL,
  `nota4` double DEFAULT NULL,
  `promedio` double DEFAULT NULL,
  `estado` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idtb_notas`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_notas`
--

LOCK TABLES `tb_notas` WRITE;
/*!40000 ALTER TABLE `tb_notas` DISABLE KEYS */;
INSERT INTO `tb_notas` VALUES (4,'KRT1-Java','SE3D-AULA2-Virtual','epamelo','P202109',20,20,15,20,18.75,'Aprobado'),(5,'TR2S-Contabilidad','SE3D-AULA2-Virtual','epamelo','P202109',14,10,16,20,15,'Aprobado'),(6,'TR2S-Contabilidad','SE3D-AULA2-Virtual','palarcov','P202109',0,0,0,0,0,'Sin Nota'),(7,'KRT1-Java','SE3D-AULA2-Virtual','palarcov','P202109',20,20,15,20,18.75,'Aprobado'),(8,'TR2S-Contabilidad','SE3D-AULA2-Virtual','palarcov','P202109',0,0,0,0,0,'Sin Nota');
/*!40000 ALTER TABLE `tb_notas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_oferta`
--

DROP TABLE IF EXISTS `tb_oferta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tb_oferta` (
  `idtb_oferta` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  `empresa` varchar(45) DEFAULT NULL,
  `sueldo` double DEFAULT NULL,
  `moneda` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`idtb_oferta`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_oferta`
--

LOCK TABLES `tb_oferta` WRITE;
/*!40000 ALTER TABLE `tb_oferta` DISABLE KEYS */;
INSERT INTO `tb_oferta` VALUES (7,NULL,'Analista Junior QA','TSOFT',1400,'PEN'),(9,NULL,'Practicante BD','Everis',2500,'PEN'),(10,NULL,'Practicante de contabilidad','BCP',1400,'PEN');
/*!40000 ALTER TABLE `tb_oferta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_ofertacurso`
--

DROP TABLE IF EXISTS `tb_ofertacurso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tb_ofertacurso` (
  `idofertacurso` int(11) NOT NULL AUTO_INCREMENT,
  `curso` varchar(45) DEFAULT NULL,
  `oferta` varchar(45) DEFAULT NULL,
  `tb_oferta_idtb_oferta` int(11) NOT NULL,
  `notaAplica` double DEFAULT NULL,
  PRIMARY KEY (`idofertacurso`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_ofertacurso`
--

LOCK TABLES `tb_ofertacurso` WRITE;
/*!40000 ALTER TABLE `tb_ofertacurso` DISABLE KEYS */;
INSERT INTO `tb_ofertacurso` VALUES (8,'KRT1-Java','Analista Junior QA',7,16),(10,'KRT1-Java','Practicante BD',9,18),(11,'TR2S-Contabilidad','Practicante de contabilidad',10,15);
/*!40000 ALTER TABLE `tb_ofertacurso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_pagoinscripcion`
--

DROP TABLE IF EXISTS `tb_pagoinscripcion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tb_pagoinscripcion` (
  `idtb_pagoInscripcion` int(11) NOT NULL AUTO_INCREMENT,
  `formaPago` varchar(45) DEFAULT NULL,
  `monto` double DEFAULT NULL,
  `curso` varchar(45) DEFAULT NULL,
  `seccion` varchar(45) DEFAULT NULL,
  `usuario` varchar(45) DEFAULT NULL,
  `recibo` varchar(45) DEFAULT NULL,
  `docente` varchar(45) DEFAULT NULL,
  `periodo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idtb_pagoInscripcion`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_pagoinscripcion`
--

LOCK TABLES `tb_pagoinscripcion` WRITE;
/*!40000 ALTER TABLE `tb_pagoinscripcion` DISABLE KEYS */;
INSERT INTO `tb_pagoinscripcion` VALUES (13,'Tarjeta Débito',34,'KRT1-Java','SE3D-AULA2-Virtual','epamelo','202109184317','78258669-Alisa Franco','P202109'),(14,'Tarjeta Débito',120,'TR2S-Contabilidad','SE3D-AULA2-Virtual','epamelo','202109201946','78258669-Alisa Franco','P202109'),(15,'Visa Tarjeta Débito',120,'TR2S-Contabilidad','SE3D-AULA2-Virtual','palarcov','202109182548','78258669-Alisa Franco','P202109'),(16,'Paypal',34,'KRT1-Java','SE3D-AULA2-Virtual','palarcov','202109182548','78258669-Alisa Franco','P202109'),(17,'Visa Tarjeta Débito',120,'TR2S-Contabilidad','SE3D-AULA2-Virtual','palarcov','20210922111','78258669-Alisa Franco','P202109');
/*!40000 ALTER TABLE `tb_pagoinscripcion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_perfil`
--

DROP TABLE IF EXISTS `tb_perfil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tb_perfil` (
  `idtb_perfil` int(11) DEFAULT NULL,
  `descripcion` varchar(45) NOT NULL,
  `estado` char(2) DEFAULT NULL,
  PRIMARY KEY (`descripcion`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_perfil`
--

LOCK TABLES `tb_perfil` WRITE;
/*!40000 ALTER TABLE `tb_perfil` DISABLE KEYS */;
INSERT INTO `tb_perfil` VALUES (1,'Administrador','SI'),(2,'Alumno','SI'),(3,'Docente','SI');
/*!40000 ALTER TABLE `tb_perfil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_persona`
--

DROP TABLE IF EXISTS `tb_persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tb_persona` (
  `idtb_persona` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `sexo` char(1) DEFAULT NULL,
  `fechaNacimiento` date DEFAULT NULL,
  `estado` char(2) DEFAULT NULL,
  `correo` varchar(45) DEFAULT NULL,
  `numeroTelefono` char(11) DEFAULT NULL,
  `dniPersona` char(8) DEFAULT NULL,
  `tb_tipo_descripcion` varchar(45) NOT NULL,
  PRIMARY KEY (`idtb_persona`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_persona`
--

LOCK TABLES `tb_persona` WRITE;
/*!40000 ALTER TABLE `tb_persona` DISABLE KEYS */;
INSERT INTO `tb_persona` VALUES (1,'Ronald','Carrasco','M','2021-08-19','SI','ronald@gmail.com','98526314','72258669','Alumno'),(2,'Alisa','Franco','F','2021-08-19','SI','alid@gmail.com','98526314','78258669','Docente'),(3,'Paula','Alarcon','F','2021-08-25','SI','paula@gmail.com','985214567','72245887','Alumno'),(4,'Edu','Pamelo','M','2021-08-09','SI','sdd@aes','98741526','75582261','Alumno'),(5,'Juan','Valencia','M','2021-08-09','SI','juan@gmail.com','985236478','78852336','Administrador');
/*!40000 ALTER TABLE `tb_persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_seccion`
--

DROP TABLE IF EXISTS `tb_seccion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tb_seccion` (
  `idtb_seccion` int(11) NOT NULL AUTO_INCREMENT,
  `codigoSeccion` varchar(45) NOT NULL,
  `seccion` varchar(45) DEFAULT NULL,
  `tipoSeccion` varchar(45) DEFAULT NULL,
  `estado` char(2) DEFAULT NULL,
  `cantiMin` int(11) DEFAULT NULL,
  `cantMax` int(11) DEFAULT NULL,
  PRIMARY KEY (`idtb_seccion`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_seccion`
--

LOCK TABLES `tb_seccion` WRITE;
/*!40000 ALTER TABLE `tb_seccion` DISABLE KEYS */;
INSERT INTO `tb_seccion` VALUES (1,'SC2R','AULA1','Presencial','SI',2,10),(2,'SE3D','AULA2','Virtual','SI',15,5),(3,'OP4RT','AULA3','Virtual','SI',10,6),(4,'AULA3','FRT3A','Virtual','SI',4,23),(5,'WE2E','Seccion3','Virtual','SI',5,40);
/*!40000 ALTER TABLE `tb_seccion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_tipo`
--

DROP TABLE IF EXISTS `tb_tipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tb_tipo` (
  `idtb_tipo` int(11) NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  PRIMARY KEY (`descripcion`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_tipo`
--

LOCK TABLES `tb_tipo` WRITE;
/*!40000 ALTER TABLE `tb_tipo` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_tipo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `view_reporte`
--

DROP TABLE IF EXISTS `view_reporte`;
/*!50001 DROP VIEW IF EXISTS `view_reporte`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8mb4;
/*!50001 CREATE VIEW `view_reporte` AS SELECT 
 1 AS `dniPersona`,
 1 AS `NombreCompleto`,
 1 AS `curso`,
 1 AS `promedio`*/;
SET character_set_client = @saved_cs_client;

--
-- Dumping events for database 'upc_sistema_control'
--

--
-- Dumping routines for database 'upc_sistema_control'
--
/*!50003 DROP PROCEDURE IF EXISTS `usp_actualizarNotas` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_actualizarNotas`(usu  varchar(45),cur varchar(45), sec varchar(45),peri varchar(45), nt1 double,nt2 double, nt3 double, nt4 double, pro double, est varchar(45))
BEGIN
update tb_notas
set nota1=nt1,
  nota2=nt2,
    nota3=nt3,    
    nota4=nt4,
    promedio=pro,
    estado=est
where usuAlumno=usu and SUBSTRING(curso,6,10)=cur and SUBSTRING(seccion,1,4) =sec and periodo =peri ;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_detalleInscripcion` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_detalleInscripcion`(codigoDet int)
BEGIN
SELECT c.descripcion,c.codigoCurso,c.credito,c.costo,s.seccion,s.codigoSeccion,s.tipoSeccion,s.cantiMin,s.cantMax,p.nombre,p.apellido,p.correo
FROM tb_horariodet det 
inner join tb_cursos c
on SUBSTRING(det.curso,1,4)=c.codigoCurso
inner join tb_seccion s
on SUBSTRING(det.seccion,1,4)=s.codigoSeccion
inner join tb_persona p
on SUBSTRING(det.docente,1,8)=p.dniPersona
where det.idtb_horarioDet=codigoDet;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_InscripcionCostoCurso` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_InscripcionCostoCurso`(precio double)
BEGIN
SELECT c.costo FROM tb_horariodet det inner join tb_cursos c
on SUBSTRING(det.curso,1,4)=c.codigoCurso
where det.idtb_horarioDet=precio;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_insertar_oferta` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_insertar_oferta`(descri varchar(45),empre varchar(45), sueldo double,moneda varchar(3))
BEGIN
insert into tb_oferta values (null, null,descri,empre,sueldo,moneda);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_insert_curso` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_insert_curso`(
   nombre varchar(45),codigoCurso varchar(45),credito int,costo double
)
begin
  insert into tb_cursos value (null,nombre,codigoCurso,credito,costo);
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_insert_cursodet` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_insert_cursodet`(
   pesos double,descripcion varchar(45),tb_cursos_idtb_cursos int
)
begin
  insert into tb_detcurso value (null,pesos,descripcion,tb_cursos_idtb_cursos);
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_insert_persona` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_insert_persona`(
   nombre varchar(45),apellido varchar(45),sexo char(2),fecha date, correo varchar(45),numero char(11), dni char(8), tipo varchar(45)
)
begin
  insert into tb_persona value (null,nombre,apellido,sexo,fecha,"SI",correo,numero,dni,tipo);
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_listacurso` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_listacurso`()
BEGIN
select descripcion,codigoCurso,credito,costo from tb_cursos;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_listadoCursoRecomendado` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_listadoCursoRecomendado`()
BEGIN
select concat(c.codigoCurso,'-',c.descripcion) as Curso, cr.motivo,cr.puntaje from tb_cursoRecomendado cr inner join tb_cursos c
on cr.tb_cursos_idtb_cursos=c.idtb_cursos;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_listadoPerfil` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_listadoPerfil`()
BEGIN

select descripcion from tb_perfil;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_listaPagoInscrpcion` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_listaPagoInscrpcion`(usuarioUSP varchar(45))
BEGIN
select curso,seccion,docente,formaPago,recibo,monto from tb_pagoinscripcion
where usuario = usuarioUSP;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_listaPersona` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_listaPersona`()
BEGIN
select nombre,apellido,sexo,dniPersona,tb_tipo_descripcion from tb_persona;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_listaprogramacionhorario` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_listaprogramacionhorario`(tipo varchar(45))
begin
select h.idtb_horarios,h.tipoHorario,h.nivel,h.grado,h.periodo,h.fecinicio,fecFin
       from tb_horarios h
where h.tipoHorario =tipo
order by h.idtb_horarios asc;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_listarCursoInscripcion` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_listarCursoInscripcion`()
BEGIN
select det.idtb_horarioDet,det.curso,det.seccion,det.docente from tb_horariodet det inner join tb_horarios cab
on cab.idtb_horarios=det.tb_horarios_idtb_horarios;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_listarDetalleNotaMatriculado` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_listarDetalleNotaMatriculado`(cur varchar(45),sec varchar(45),per varchar(45),usu varchar(45))
BEGIN
select nota1,nota2,nota3,nota4,promedio,estado from tb_notas
where SUBSTRING(curso,6,10)=cur
and SUBSTRING(seccion,1,4) =sec
and periodo=per
and usuAlumno=usu;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_listarDocenteHorario` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_listarDocenteHorario`()
BEGIN
select concat(dniPersona,'-',nombre,' ',apellido) as Dato from tb_persona
where tb_tipo_descripcion='DOCENTE';
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_listarHorariosProfe` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_listarHorariosProfe`(usuarioProfe varchar(45))
BEGIN
select 
SUBSTRING(p.curso,1,4) as codCurso,
SUBSTRING(p.curso,6,10) as Curso,
SUBSTRING(p.seccion,1,4) as codSeccion,
SUBSTRING(p.seccion,6,5) as Aula,
SUBSTRING(p.seccion,12,10) as Seccion,
SUBSTRING(p.docente,1,8) as codDocente,
SUBSTRING(p.docente,10,20) as Docente
from tb_pagoinscripcion p   inner join tb_acceso a
on a.dniPersona=SUBSTRING(p.docente,1,8)
where a.usuario=usuarioProfe;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_listarMAtriculaCurso` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_listarMAtriculaCurso`(usuario  varchar(45))
BEGIN
select SUBSTRING(curso,6,10) as curso,SUBSTRING(seccion,1,4) as seccion,periodo,promedio,estado from tb_notas
where usuAlumno=usuario;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_listarMatriculaNota` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_listarMatriculaNota`(usuario varchar(45),per varchar(45))
BEGIN
select 
SUBSTRING(p.curso,1,4) as codCurso,
SUBSTRING(p.curso,6,10) as Curso,
SUBSTRING(p.seccion,1,4) as codSeccion
from tb_pagoinscripcion p   inner join tb_acceso a
on a.dniPersona=SUBSTRING(p.docente,1,8)
where a.usuario=usuario
and p.periodo=per;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_listarNombreCursos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_listarNombreCursos`()
BEGIN
select concat(codigoCurso,'-',descripcion) as Nombrecurso from tb_cursos;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_listarNombreSeccion` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_listarNombreSeccion`()
BEGIN
select concat(codigoSeccion,'-',seccion,'-',tipoSeccion) as nombreSeccion from tb_seccion;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_listarnotasalumno` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_listarnotasalumno`(usu varchar(8),cur varchar(45), sec varchar(45),peri varchar(45))
begin
   select nota1,nota2,nota3,nota4,promedio from tb_notas 
where usuAlumno=usu and SUBSTRING(curso,6,10)=cur and SUBSTRING(seccion,1,4) =sec and periodo =peri ;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_listarnotasregistradas` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_listarnotasregistradas`(cur varchar(45),sec varchar(45),per varchar(45))
BEGIN
select SUBSTRING(n.curso,1,4) as curso,a.usuario, concat(p.nombre,' ',p.apellido) as NombreCompleto, n.promedio
 from tb_notas n
inner join tb_acceso a
on n.usuAlumno=a.usuario
inner join tb_persona p
on a.dniPersona=p.dniPersona
where SUBSTRING(n.curso,6,10)=cur
and SUBSTRING(n.seccion,1,4)=sec
and periodo =per;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_listarProgramacionDet` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_listarProgramacionDet`(horario int)
BEGIN
select dia,horainicio,horafin,seccion, curso,docente from tb_horarioDet
where tb_horarios_idtb_horarios =horario;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_listaseccion` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_listaseccion`()
BEGIN
select codigoSeccion,seccion,tipoSeccion,cantiMin,cantMax from tb_seccion;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_login` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_login`(perf varchar(45), usr varchar(45), pas varchar(45))
BEGIN
select * from tb_acceso where tb_perfil_descripcion=perf and usuario = usr and contraseña = pas;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_obtenerultimocodigohorario` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_obtenerultimocodigohorario`()
BEGIN
select idtb_horarios from  tb_horarios
order by idtb_horarios desc;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_ofertaNotaAprobado` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_ofertaNotaAprobado`(nota double, cur varchar(45))
BEGIN

select of.notaAplica,o.descripcion,o.empresa,o.sueldo,o.moneda,SUBSTRING(of.curso,6,10) as curso from tb_oferta o inner join tb_ofertacurso of
on o.idtb_oferta=of.tb_oferta_idtb_oferta
WHERE of.notaAplica<=nota
and SUBSTRING(of.curso,6,10)=cur;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_registrarNota` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_registrarNota`(cur varchar(45),sec varchar(45),usu varchar(45),per varchar(45),nt1 double,nt2 double,nt3 double,nt4 double,pr double, est varchar(45))
BEGIN
insert into tb_notas values(null,cur,sec,usu,per,nt1,nt2,nt3,nt4,pr,est);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_registrarPago` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_registrarPago`(fP varchar(45),monto double, curso varchar(45),seccion varchar(45),usuario varchar(45),recibo varchar(45),docente varchar(45), periodo varchar(45))
BEGIN
insert into tb_pagoinscripcion values (null,fp,monto,curso,seccion,usuario,recibo,docente,periodo);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_registrar_seccion` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_registrar_seccion`(codigo varchar(45), nombre varchar(45), tipo varchar(45), cantmin int, cantmax int)
BEGIN
	insert into tb_seccion values (null,codigo,nombre,tipo,"SI",cantmin,cantmax);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_ultimoCodigoCurso` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_ultimoCodigoCurso`()
BEGIN
select MAX(idtb_cursos) from tb_cursos
order by idtb_cursos desc;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Final view structure for view `view_reporte`
--

/*!50001 DROP VIEW IF EXISTS `view_reporte`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `view_reporte` AS select `p`.`dniPersona` AS `dniPersona`,concat(`p`.`nombre`,' ',`p`.`apellido`) AS `NombreCompleto`,`s`.`curso` AS `curso`,`n`.`promedio` AS `promedio` from (((`tb_persona` `p` join `tb_acceso` `a` on((`p`.`dniPersona` = `a`.`dniPersona`))) join `tb_pagoinscripcion` `s` on((`s`.`usuario` = `a`.`usuario`))) join `tb_notas` `n` on((`s`.`curso` = `n`.`curso`))) where ((`p`.`dniPersona` = '75582261') and (`n`.`estado` = 'Aprobado') and (`s`.`curso` = 'TY7J-Scrum')) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-10-02 16:53:19
