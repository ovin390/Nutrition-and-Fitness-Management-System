CREATE DATABASE  IF NOT EXISTS `nutrition` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `nutrition`;
-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: nutrition
-- ------------------------------------------------------
-- Server version	8.0.31

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

--
-- Table structure for table `enrolls_to`
--

DROP TABLE IF EXISTS `enrolls_to`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `enrolls_to` (
  `EUid` varchar(10) NOT NULL,
  `EPid` varchar(10) NOT NULL,
  `Join_date` date NOT NULL,
  PRIMARY KEY (`EUid`,`EPid`),
  KEY `EPid_idx` (`EPid`),
  CONSTRAINT `EPid` FOREIGN KEY (`EPid`) REFERENCES `plan` (`Pid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `EUid` FOREIGN KEY (`EUid`) REFERENCES `user` (`Uid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enrolls_to`
--

LOCK TABLES `enrolls_to` WRITE;
/*!40000 ALTER TABLE `enrolls_to` DISABLE KEYS */;
INSERT INTO `enrolls_to` VALUES ('m2','P1','2023-07-08');
/*!40000 ALTER TABLE `enrolls_to` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `health_status`
--

DROP TABLE IF EXISTS `health_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `health_status` (
  `Hid` varchar(10) NOT NULL,
  `Fat` float NOT NULL,
  `Calories` float NOT NULL,
  `Remarks` varchar(45) DEFAULT NULL,
  `HInid` varchar(10) NOT NULL,
  PRIMARY KEY (`Hid`),
  KEY `HInid_idx` (`HInid`),
  CONSTRAINT `HInid` FOREIGN KEY (`HInid`) REFERENCES `instructor` (`Inid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `health_status`
--

LOCK TABLES `health_status` WRITE;
/*!40000 ALTER TABLE `health_status` DISABLE KEYS */;
INSERT INTO `health_status` VALUES ('h1',0,0,'no remarks','i1'),('h2',0,0,'no remarks','i1'),('H5',30,50,'GOOD','I1');
/*!40000 ALTER TABLE `health_status` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `health_status_BEFORE_INSERT` BEFORE INSERT ON `health_status` FOR EACH ROW BEGIN
 SET NEW.Fat=0;

 SET NEW.Calories=0;

 SET NEW.Remarks='no remarks';

END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `instructor`
--

DROP TABLE IF EXISTS `instructor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `instructor` (
  `Inname` varchar(45) NOT NULL,
  `Inid` varchar(10) NOT NULL,
  `Inphone` varchar(45) NOT NULL,
  `Age` int NOT NULL,
  PRIMARY KEY (`Inid`),
  CONSTRAINT `instructor_chk_1` CHECK ((`Age` >= 25))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `instructor`
--

LOCK TABLES `instructor` WRITE;
/*!40000 ALTER TABLE `instructor` DISABLE KEYS */;
INSERT INTO `instructor` VALUES ('ovin','i1','9902177557',56),('raja','i3','1597532589',50);
/*!40000 ALTER TABLE `instructor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plan`
--

DROP TABLE IF EXISTS `plan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `plan` (
  `Pid` varchar(10) NOT NULL,
  `Pname` varchar(45) NOT NULL,
  `Validity` date NOT NULL,
  `Session` varchar(45) NOT NULL,
  `Amount` int NOT NULL,
  PRIMARY KEY (`Pid`),
  CONSTRAINT `plan_chk_1` CHECK ((`Amount` > 0))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plan`
--

LOCK TABLES `plan` WRITE;
/*!40000 ALTER TABLE `plan` DISABLE KEYS */;
INSERT INTO `plan` VALUES ('P1','Fat Loss','2023-02-14','Morning',6);
/*!40000 ALTER TABLE `plan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `routine`
--

DROP TABLE IF EXISTS `routine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `routine` (
  `RPid` varchar(10) NOT NULL,
  `D1` varchar(45) NOT NULL,
  `D2` varchar(45) NOT NULL,
  `D3` varchar(45) NOT NULL,
  `D4` varchar(45) NOT NULL,
  `D5` varchar(45) NOT NULL,
  `D6` varchar(45) NOT NULL,
  `Routine_name` varchar(45) NOT NULL,
  PRIMARY KEY (`RPid`),
  CONSTRAINT `RPid` FOREIGN KEY (`RPid`) REFERENCES `plan` (`Pid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `routine`
--

LOCK TABLES `routine` WRITE;
/*!40000 ALTER TABLE `routine` DISABLE KEYS */;
INSERT INTO `routine` VALUES ('P1','chest','pushups','hip','benchpress','plank','nill','Fatloss');
/*!40000 ALTER TABLE `routine` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `u_phone`
--

DROP TABLE IF EXISTS `u_phone`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `u_phone` (
  `UPhid` varchar(10) NOT NULL,
  `UPhone` varchar(45) NOT NULL,
  PRIMARY KEY (`UPhid`,`UPhone`),
  CONSTRAINT `UPhid` FOREIGN KEY (`UPhid`) REFERENCES `user` (`Uid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `u_phone`
--

LOCK TABLES `u_phone` WRITE;
/*!40000 ALTER TABLE `u_phone` DISABLE KEYS */;
INSERT INTO `u_phone` VALUES ('m2','9874589685');
/*!40000 ALTER TABLE `u_phone` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `Uid` varchar(10) NOT NULL,
  `Fname` varchar(45) NOT NULL,
  `Lname` varchar(45) DEFAULT NULL,
  `Dob` date NOT NULL,
  `Gender` varchar(45) NOT NULL,
  `State` varchar(45) NOT NULL,
  `UHid` varchar(10) NOT NULL,
  `UInid` varchar(10) NOT NULL,
  PRIMARY KEY (`Uid`),
  KEY `UHid_idx` (`UHid`),
  KEY `UInid_idx` (`UInid`),
  CONSTRAINT `UHid` FOREIGN KEY (`UHid`) REFERENCES `health_status` (`Hid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `UInid` FOREIGN KEY (`UInid`) REFERENCES `instructor` (`Inid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('m2','savita','sundar','2003-08-09','female','delhi','h1','i1');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'nutrition'
--

--
-- Dumping routines for database 'nutrition'
--
/*!50003 DROP PROCEDURE IF EXISTS `user_gender` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `user_gender`(IN gen varchar(6))
BEGIN
SELECT * FROM user WHERE Gender=gen;
SELECT COUNT(Uid) AS Total_Mmbers FROM user;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-07-12 16:17:49
