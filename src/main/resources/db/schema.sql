-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: ventas
-- ------------------------------------------------------
-- Server version	11.6.2-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `categorias`
--

DROP TABLE IF EXISTS `categorias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categorias` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `descripcion` text DEFAULT NULL,
  `fecha_creacion` timestamp NULL DEFAULT NULL,
  `fecha_actualizacion` timestamp NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre` (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorias`
--

LOCK TABLES `categorias` WRITE;
/*!40000 ALTER TABLE `categorias` DISABLE KEYS */;
INSERT INTO `categorias` VALUES (1,'DESENGRASANTE',NULL,'2025-04-25 19:29:29',NULL),(2,'SUAVISANTE',NULL,'2025-04-25 19:31:51',NULL),(3,'FABULOSO',NULL,'2025-04-25 19:31:51',NULL),(4,'DETERGENTE_ROPA',NULL,'2025-04-25 19:31:51',NULL),(5,'JABON_MANOS',NULL,'2025-04-25 19:31:51',NULL),(6,'TRASTES',NULL,'2025-04-25 19:31:51',NULL),(7,'AUTOS',NULL,'2025-04-25 22:41:51','2025-04-25 22:41:21');
/*!40000 ALTER TABLE `categorias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `apellido1` varchar(100) NOT NULL,
  `apellido2` varchar(100) DEFAULT NULL,
  `ciudad` varchar(100) DEFAULT NULL,
  `categoria` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'Aarón','Rivero','Gómez','Almería',100),(2,'Adela','Salas','Díaz','Granada',200),(3,'Adolfo','Rubio','Flores','Sevilla',NULL),(4,'Adrián','Suárez',NULL,'Jaén',300),(5,'Marcos','Loyola','Méndez','Almería',200),(6,'María','Santana','Moreno','Cádiz',100),(7,'Pilar','Ruiz',NULL,'Sevilla',300),(8,'Pepe','Ruiz','Santana','Huelva',200),(9,'Guillermo','López','Gómez','Granada',225),(10,'Daniel','Santana','Loyola','Sevilla',125);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comercial`
--

DROP TABLE IF EXISTS `comercial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comercial` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `apellido1` varchar(100) NOT NULL,
  `apellido2` varchar(100) DEFAULT NULL,
  `comision` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comercial`
--

LOCK TABLES `comercial` WRITE;
/*!40000 ALTER TABLE `comercial` DISABLE KEYS */;
INSERT INTO `comercial` VALUES (1,'Daniel','Sáez','Vega',0.15),(2,'Juan','Gómez','López',0.13),(3,'Diego','Flores','Salas',0.11),(4,'Marta','Herrera','Gil',0.14),(5,'Antonio','Carretero','Ortega',0.12),(6,'Manuel','Domínguez','Hernández',0.13),(7,'Antonio','Vega','Hernández',0.11),(8,'Alfredo','Ruiz','Flores',0.05);
/*!40000 ALTER TABLE `comercial` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedido`
--

DROP TABLE IF EXISTS `pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pedido` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `total` double NOT NULL,
  `fecha` date DEFAULT NULL,
  `id_cliente` int(10) unsigned NOT NULL,
  `id_comercial` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_cliente` (`id_cliente`),
  KEY `id_comercial` (`id_comercial`),
  CONSTRAINT `pedido_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id`),
  CONSTRAINT `pedido_ibfk_2` FOREIGN KEY (`id_comercial`) REFERENCES `comercial` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido`
--

LOCK TABLES `pedido` WRITE;
/*!40000 ALTER TABLE `pedido` DISABLE KEYS */;
INSERT INTO `pedido` VALUES (1,150.5,'2017-10-05',5,2),(2,270.65,'2016-09-10',1,5),(3,65.26,'2017-10-05',2,1),(4,110.5,'2016-08-17',8,3),(5,948.5,'2017-09-10',5,2),(6,2400.6,'2016-07-27',7,1),(7,5760,'2015-09-10',2,1),(8,1983.43,'2017-10-10',4,6),(9,2480.4,'2016-10-10',8,3),(10,250.45,'2015-06-27',8,2),(11,75.29,'2016-08-17',3,7),(12,3045.6,'2017-04-25',2,1),(13,545.75,'2019-01-25',6,1),(14,145.82,'2017-02-02',6,1),(15,370.85,'2019-03-11',1,5),(16,2389.23,'2019-03-11',1,5);
/*!40000 ALTER TABLE `pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productos`
--

DROP TABLE IF EXISTS `productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `PRECIO_UNITARIO` double NOT NULL,
  `PRECIO_VENTA` double NOT NULL,
  `FECHA_COMPRA` timestamp NOT NULL,
  `categoria` int(11) NOT NULL,
  `activo` tinyint(1) NOT NULL,
  `fecha_creacion` timestamp NOT NULL,
  `fecha_actualizacion` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` VALUES (1,'LAVANDA',20,8,13,'2025-04-25 23:00:19',3,1,'2025-04-25 23:00:19',NULL),(2,'LIMON',20,8,13,'2025-04-25 23:00:19',3,1,'2025-04-25 23:00:19',NULL),(3,'TROPICAL',20,8,13,'2025-04-25 23:00:19',3,1,'2025-04-25 23:00:19',NULL),(4,'MAR FRESCO',20,8,13,'2025-04-25 23:00:19',3,1,'2025-04-25 23:00:19',NULL),(5,'FRESA',20,8,13,'2025-04-25 23:00:19',3,1,'2025-04-25 23:00:19',NULL),(6,'MANZANA CANELA',20,8,13,'2025-04-25 23:00:19',3,1,'2025-04-25 23:00:19',NULL),(7,'ARIEL',20,11,16,'2025-04-25 23:00:19',4,1,'2025-04-25 23:00:19',NULL),(8,'MAS COLOR',20,11,16,'2025-04-25 23:00:19',4,1,'2025-04-25 23:00:19',NULL),(9,'PERSIL',20,11,16,'2025-04-25 23:00:19',4,1,'2025-04-25 23:00:19',NULL),(10,'VANISH',20,12,17,'2025-04-25 23:00:19',4,1,'2025-04-25 23:00:19',NULL),(11,'SUAVE PRIMAVERA',20,11,16,'2025-04-25 23:00:19',2,1,'2025-04-25 23:00:19',NULL),(12,'AMANECER',20,11,16,'2025-04-25 23:00:19',2,1,'2025-04-25 23:00:19',NULL),(13,'CARICIAS DE ALGODON',20,11,16,'2025-04-25 23:00:19',2,1,'2025-04-25 23:00:19',NULL),(14,'FRUTOS TROPICALES',20,11,16,'2025-04-25 23:00:19',2,1,'2025-04-25 23:00:19',NULL),(15,'DOWNY',20,11,16,'2025-04-25 23:00:19',2,1,'2025-04-25 23:00:19',NULL),(16,'TIPO BRASSO',20,13,19,'2025-04-25 23:00:19',1,1,'2025-04-25 23:00:19',NULL),(17,'DETERCON (TEXTIL)',20,13,18,'2025-04-25 23:00:19',1,1,'2025-04-25 23:00:19',NULL),(18,'ANTISARRO',5,10,15,'2025-04-25 23:00:19',1,1,'2025-04-25 23:00:19',NULL),(19,'SHAMPOO DE AUTO C/CERA',20,14,20,'2025-04-25 23:00:19',6,1,'2025-04-25 23:00:19',NULL),(20,'HUMECTADOR P/ INTERIORES GEL.',20,25,35,'2025-04-25 23:00:19',6,1,'2025-04-25 23:00:19',NULL),(21,'ABRILLANTADOR LLANTAS GEL',20,20,30,'2025-04-25 23:00:19',6,1,'2025-04-25 23:00:19',NULL),(22,'MANZANA CANELA',20,12,17,'2025-04-25 23:00:19',5,1,'2025-04-25 23:00:19',NULL),(23,'PASION DE FRUTAS',20,12,17,'2025-04-25 23:00:19',5,1,'2025-04-25 23:00:19',NULL),(24,'UVA',20,12,17,'2025-04-25 23:00:19',5,1,'2025-04-25 23:00:19',NULL),(25,'TIPO DOVE',20,12,17,'2025-04-25 23:00:19',5,1,'2025-04-25 23:00:19',NULL),(26,'AXION C BICARBONATO LIMON',20,11,16,'2025-04-25 23:00:19',6,1,'2025-04-25 23:00:19',NULL),(27,'SALVO CUIDADO DE MANOS',20,11,16,'2025-04-25 23:00:19',6,1,'2025-04-25 23:00:19',NULL),(28,'CLORO',20,5,7,'2025-04-25 23:00:19',6,1,'2025-04-25 23:00:19',NULL);
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ventas`
--

DROP TABLE IF EXISTS `ventas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ventas` (
  `ID_VENTA` int(11) NOT NULL,
  `FECHA_VENTA` timestamp NOT NULL,
  `TRANSACCION` bigint(20) DEFAULT NULL,
  `PRODUCTO` int(11) NOT NULL,
  `CANTIDAD` double NOT NULL,
  `TOTAL` double NOT NULL,
  `IVA` double DEFAULT NULL,
  `CLIENTE` int(11) DEFAULT NULL,
  `ESTADO` int(11) NOT NULL,
  PRIMARY KEY (`ID_VENTA`),
  KEY `ventas_productos_FK` (`PRODUCTO`),
  CONSTRAINT `ventas_productos_FK` FOREIGN KEY (`PRODUCTO`) REFERENCES `productos` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ventas`
--

LOCK TABLES `ventas` WRITE;
/*!40000 ALTER TABLE `ventas` DISABLE KEYS */;
/*!40000 ALTER TABLE `ventas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'ventas'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-04-25 18:00:38
