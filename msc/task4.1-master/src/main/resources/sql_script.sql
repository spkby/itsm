-- MySQL dump 10.13  Distrib 5.7.24, for Linux (x86_64)
--
-- Host: localhost    Database: task3_pharmacy
-- ------------------------------------------------------
-- Server version	5.7.24-0ubuntu0.16.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `audit`
--

DROP TABLE IF EXISTS `audit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `audit` (
  `audit_id` int(11) NOT NULL AUTO_INCREMENT,
  `audit_status` int(11) DEFAULT NULL,
  `audit_action` int(11) DEFAULT NULL,
  `audit_date` datetime NOT NULL,
  `audit_user_id` int(11) NOT NULL,
  PRIMARY KEY (`audit_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `audit`
--

LOCK TABLES `audit` WRITE;
/*!40000 ALTER TABLE `audit` DISABLE KEYS */;
/*!40000 ALTER TABLE `audit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient`
--

DROP TABLE IF EXISTS `patient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patient` (
  `pat_id` int(11) NOT NULL AUTO_INCREMENT,
  `pat_phone` int(11) NOT NULL,
  `pat_st_id` int(11) NOT NULL,
  `pat_createdByUser_id` int(11) DEFAULT NULL,
  `pat_createdDate` datetime DEFAULT NULL,
  `pat_updatedByUser_id` int(11) DEFAULT NULL,
  `pat_updatedDate` datetime DEFAULT NULL,
  PRIMARY KEY (`pat_id`)
) ENGINE=InnoDB AUTO_INCREMENT=92 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient`
--

LOCK TABLES `patient` WRITE;
/*!40000 ALTER TABLE `patient` DISABLE KEYS */;
INSERT INTO `patient` VALUES (81,123456,2,NULL,NULL,NULL,NULL),(82,7878,2,NULL,NULL,NULL,NULL),(83,456999,1,1,'2018-11-12 00:00:00',1,'2018-11-12 00:00:00'),(84,8855885,1,1,'2018-11-12 00:00:00',1,'2018-11-12 00:00:00'),(85,789587,1,1,'2018-11-12 16:18:18',1,'2018-11-12 16:18:18'),(86,456789,1,1,'2018-11-19 19:18:46',1,'2018-11-19 19:18:46'),(87,774455,1,1,'2018-11-19 19:20:45',1,'2018-11-19 19:20:45'),(88,546546,2,1,'2018-11-19 19:23:42',1,'2018-11-19 19:23:42'),(89,7978,2,1,'2018-11-19 19:26:38',1,'2018-11-19 19:26:38'),(90,546546,2,1,'2018-11-21 15:48:16',1,'2018-11-21 15:48:16'),(91,546546,2,1,'2018-11-21 15:57:29',1,'2018-11-21 15:57:29');
/*!40000 ALTER TABLE `patient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `product_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(45) NOT NULL,
  `product_st_id` int(11) NOT NULL,
  `product_createdByUser_id` int(11) DEFAULT NULL,
  `product_createdDate` date DEFAULT NULL,
  `product_updatedByUser_id` int(11) DEFAULT NULL,
  `product_updatedDate` date DEFAULT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'Strip',5,NULL,NULL,NULL,NULL),(2,'Insulin',5,NULL,NULL,NULL,NULL),(4,'Insulin2',1,NULL,NULL,1,'2018-11-12'),(5,'Insulin',2,1,'2018-11-12',1,'2018-11-12'),(6,'qwe',2,1,'2018-11-19',1,'2018-11-19');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `state`
--

DROP TABLE IF EXISTS `state`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `state` (
  `st_id` int(11) NOT NULL AUTO_INCREMENT,
  `st_code` int(11) NOT NULL,
  `st_name` varchar(45) NOT NULL,
  `st_createdByUser_id` int(11) DEFAULT NULL,
  `st_createdDate` datetime DEFAULT NULL,
  `st_updatedByUser_id` int(11) DEFAULT NULL,
  `st_updatedDate` datetime DEFAULT NULL,
  PRIMARY KEY (`st_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `state`
--

LOCK TABLES `state` WRITE;
/*!40000 ALTER TABLE `state` DISABLE KEYS */;
INSERT INTO `state` VALUES (1,205,'AL',NULL,NULL,NULL,NULL),(2,718,'NY',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `state` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction`
--

DROP TABLE IF EXISTS `transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transaction` (
  `tr_id` int(11) NOT NULL AUTO_INCREMENT,
  `tr_pat_id` int(11) NOT NULL,
  `tr_product_id` int(11) NOT NULL,
  `tr_date` date NOT NULL,
  `tr_user_id` varchar(45) NOT NULL,
  PRIMARY KEY (`tr_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction`
--

LOCK TABLES `transaction` WRITE;
/*!40000 ALTER TABLE `transaction` DISABLE KEYS */;
INSERT INTO `transaction` VALUES (15,81,4,'2018-11-09','1'),(16,81,4,'2018-11-09','1'),(17,81,4,'2018-11-09','1'),(18,81,4,'2018-11-12','1'),(19,81,4,'2018-11-12','1'),(20,81,4,'2018-11-12','1');
/*!40000 ALTER TABLE `transaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_email` varchar(45) NOT NULL,
  `user_password` varchar(45) NOT NULL,
  `user_login` varchar(45) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_login_UNIQUE` (`user_login`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'vse@itsupportme.by','12345','vse');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-21 18:01:11