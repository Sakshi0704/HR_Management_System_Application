-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: myproject
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `dept`
--

DROP TABLE IF EXISTS `dept`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dept` (
  `did` int NOT NULL AUTO_INCREMENT,
  `deptID` varchar(6) NOT NULL,
  `deptName` varchar(12) NOT NULL,
  `is_delete` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`did`),
  UNIQUE KEY `deptID` (`deptID`),
  UNIQUE KEY `deptName` (`deptName`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dept`
--

LOCK TABLES `dept` WRITE;
/*!40000 ALTER TABLE `dept` DISABLE KEYS */;
INSERT INTO `dept` VALUES (1,'d001','account',0),(2,'d007','mis8',0),(3,'d004','mis3',0),(4,'d005','mis4',0),(5,'d006','mis5',0);
/*!40000 ALTER TABLE `dept` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleave`
--

DROP TABLE IF EXISTS `empleave`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleave` (
  `leaveId` int NOT NULL AUTO_INCREMENT,
  `days_of_leave` int DEFAULT '0',
  `type` tinyint NOT NULL,
  `reason` varchar(75) NOT NULL,
  `date_of_leave` date NOT NULL,
  `status` varchar(15) DEFAULT 'panding',
  `is_removed` tinyint(1) DEFAULT '0',
  `eId` int DEFAULT NULL,
  PRIMARY KEY (`leaveId`),
  KEY `emp_leave` (`eId`),
  CONSTRAINT `emp_leave` FOREIGN KEY (`eId`) REFERENCES `employee` (`eId`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleave`
--

LOCK TABLES `empleave` WRITE;
/*!40000 ALTER TABLE `empleave` DISABLE KEYS */;
INSERT INTO `empleave` VALUES (1,12,3,'marriage','2023-05-04','panding',0,1),(2,2,3,'marriage','2023-04-02','panding',0,1);
/*!40000 ALTER TABLE `empleave` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `eId` int NOT NULL AUTO_INCREMENT,
  `empId` varchar(6) NOT NULL,
  `ename` varchar(12) NOT NULL,
  `email` varchar(15) NOT NULL,
  `password` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL DEFAULT '123456',
  `empAddress` varchar(25) DEFAULT NULL,
  `date_of_joining` date DEFAULT NULL,
  `is_delete` tinyint(1) DEFAULT '0',
  `Salary_Per_Month` double DEFAULT NULL,
  `did` int DEFAULT '1',
  PRIMARY KEY (`eId`),
  UNIQUE KEY `empId` (`empId`),
  UNIQUE KEY `email` (`email`),
  KEY `did` (`did`),
  CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`did`) REFERENCES `dept` (`did`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'e001','sakshi','sak@gmail.com','1253','noida','2020-02-12',0,18000,2),(2,'e002','bani','bani@gmail.com','1253','noida','2020-02-12',0,18000,1),(4,'e003','ajay','ajay@gmail.com','123456','1253','2020-05-04',0,16000,2);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-04-02 19:01:27
