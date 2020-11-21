-- MySQL dump 10.13  Distrib 8.0.17, for macos10.14 (x86_64)
--
-- Host: localhost    Database: interfloraiv
-- ------------------------------------------------------
-- Server version	8.0.17

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
-- Table structure for table `bukets`
--

DROP TABLE IF EXISTS `bukets`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bukets` (
  `buketID` int(11) NOT NULL AUTO_INCREMENT,
  `buketIndhold` varchar(255) DEFAULT NULL,
  `buketPris` int(11) DEFAULT NULL,
  PRIMARY KEY (`buketID`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bukets`
--

LOCK TABLES `bukets` WRITE;
/*!40000 ALTER TABLE `bukets` DISABLE KEYS */;
INSERT INTO `bukets` VALUES (1,'Bundt med 5 stilke mørkerøde hortensia',230),(2,'Mix bundt med 7 stilke hortensia',275),(3,'Mix bundt med 7 stilke pastel hortensia',275),(4,'Unika blomsterbuket',325),(5,'Arranger selv bundt',225),(6,'Multifarvet blomsterbuket',250),(7,'Efterårsbuket',200),(8,'Efterårsbuket med vingummi',250),(9,'Tak for dig blomsterbuket',250),(10,'Trendy efterårsbuket',225),(11,'Trendy Queen efterårsbuket',275),(12,'Trendy Queen efterårsbuket med marcipanhjerte',350),(13,'Queen blomsterbuket',275),(14,'Multifarvet kærlighedsbuket med marcipanhjerte',275);
/*!40000 ALTER TABLE `bukets` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customers` (
  `customerID` int(11) NOT NULL AUTO_INCREMENT,
  `customerName` varchar(255) DEFAULT NULL,
  `phone` int(11) DEFAULT NULL,
  PRIMARY KEY (`customerID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customers`
--

LOCK TABLES `customers` WRITE;
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
INSERT INTO `customers` VALUES (1,'Kurt',NULL),(2,'Anton',NULL),(3,'viggo',NULL),(4,'Snurre Snup',NULL),(5,'Valde',12121221),(6,'Ursula',34434343),(7,'Anders Snup',56122111),(8,'Biger',34342121),(9,'Frida',3111211),(10,'Anders And',5644411);
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_buket`
--

DROP TABLE IF EXISTS `order_buket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_buket` (
  `orderBuketID` int(11) NOT NULL AUTO_INCREMENT,
  `buketID` int(11) DEFAULT NULL,
  `orderID` int(11) DEFAULT NULL,
  PRIMARY KEY (`orderBuketID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_buket`
--

LOCK TABLES `order_buket` WRITE;
/*!40000 ALTER TABLE `order_buket` DISABLE KEYS */;
INSERT INTO `order_buket` VALUES (1,3,3),(2,11,3),(3,10,6),(4,11,6),(5,3,6);
/*!40000 ALTER TABLE `order_buket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `orderID` int(11) NOT NULL AUTO_INCREMENT,
  `orderStatus` varchar(255) DEFAULT NULL,
  `orderDate` date DEFAULT NULL,
  `customerID` int(11) DEFAULT NULL,
  `orderItems` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`orderID`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,'CREATED','2020-11-17',1,NULL),(2,'CREATED','2020-11-17',1,NULL),(3,'CREATED','2020-11-17',2,NULL),(4,'CREATED','2020-11-17',8,NULL),(5,'CREATED','2020-03-03',7,NULL),(6,'CREATED','2020-05-02',7,NULL),(7,NULL,'2020-11-18',NULL,NULL),(8,NULL,'2020-11-18',NULL,NULL),(9,NULL,'2020-11-18',NULL,NULL),(10,NULL,'2020-11-18',NULL,NULL),(11,NULL,'2020-11-18',NULL,NULL),(12,NULL,'2020-11-18',NULL,NULL),(13,'CREATED','2020-11-18',32324512,'3@5@'),(14,'CREATED','2020-11-18',32324512,'3@5@'),(15,'CREATED','2020-11-18',1991,'@3@5'),(16,'CREATED','2020-11-18',1991,'@3@5'),(17,'CREATED','2020-11-18',23232323,'@3@5'),(18,'CREATED','2020-11-18',23232323,'@3@5'),(19,'CREATED','2020-11-18',23232323,'@3@5'),(20,'CREATED','2020-11-18',23232323,'@3@5'),(21,'CREATED','2020-11-18',23232323,'@3@5'),(22,'CREATED','2020-11-18',23232323,'@3@5'),(23,'CREATED','2020-11-18',23232323,'@3@5'),(24,'CREATED','2020-11-17',0,'@3@5'),(25,'CREATED','2020-11-17',0,'@3@5'),(26,'CREATED','2020-11-17',0,'@3@5'),(27,'CREATED','2020-11-17',0,'@3@5'),(28,'CREATED','2020-11-17',0,'@3@5'),(29,'CREATED','2020-11-17',0,'@3@5'),(30,'CREATED','2020-11-17',0,'@3@5'),(31,'CREATED','2020-11-17',0,'@3@5'),(32,'CREATED','2020-11-17',0,'@3@5'),(33,'CREATED','2020-11-17',12123433,'@3@5'),(34,'CREATED','2020-11-17',12123433,'@3@5@5');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-11-19 14:44:53
