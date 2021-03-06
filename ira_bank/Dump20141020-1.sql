CREATE DATABASE  IF NOT EXISTS `sbs` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `sbs`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: localhost    Database: sbs
-- ------------------------------------------------------
-- Server version	5.6.20-log

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
-- Table structure for table `account_details`
--

DROP TABLE IF EXISTS `account_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account_details` (
  `ACCT_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ACCOUNT_NUMBER` varchar(45) NOT NULL,
  `U_ID` int(11) DEFAULT NULL,
  `BALANCE` int(11) NOT NULL,
  PRIMARY KEY (`ACCT_ID`,`ACCOUNT_NUMBER`),
  UNIQUE KEY `ACCOUNT_NUMBER_UNIQUE` (`ACCOUNT_NUMBER`),
  KEY `USER_ID_idx` (`U_ID`),
  CONSTRAINT `USER_ID` FOREIGN KEY (`U_ID`) REFERENCES `users` (`USER_ID`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_details`
--

LOCK TABLES `account_details` WRITE;
/*!40000 ALTER TABLE `account_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `account_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notification_details`
--

DROP TABLE IF EXISTS `notification_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `notification_details` (
  `NOTIFICATION_ID` int(11) NOT NULL AUTO_INCREMENT,
  `NOTIFICATION_NAME` varchar(45) NOT NULL,
  `NOTIFICATION_DESCRIPTION` varchar(128) DEFAULT NULL,
  `NOTIFICATION_STATUS` int(11) DEFAULT NULL,
  `NOTIFICATION_USER_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`NOTIFICATION_ID`),
  KEY `NOTIFICATION_USER_ID_idx` (`NOTIFICATION_USER_ID`),
  CONSTRAINT `NOTIFICATION_USER_ID` FOREIGN KEY (`NOTIFICATION_USER_ID`) REFERENCES `users` (`USER_ID`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notification_details`
--

LOCK TABLES `notification_details` WRITE;
/*!40000 ALTER TABLE `notification_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `notification_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `request_details`
--

DROP TABLE IF EXISTS `request_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `request_details` (
  `REQ_ID` int(11) NOT NULL AUTO_INCREMENT,
  `REQ_USER_ID` int(11) DEFAULT NULL,
  `REQ_DESC` varchar(90) DEFAULT NULL,
  `REQ_STATUS` int(11) DEFAULT NULL,
  `REQ_DATE` timestamp NULL DEFAULT NULL,
  `REQ_TYPE` varchar(25) DEFAULT NULL,
  `IS_AUTHORIZED` int(11) DEFAULT NULL,
  PRIMARY KEY (`REQ_ID`),
  KEY `REQ_USER_ID_idx` (`REQ_USER_ID`),
  CONSTRAINT `REQ_USER_ID` FOREIGN KEY (`REQ_USER_ID`) REFERENCES `users` (`USER_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `request_details`
--

LOCK TABLES `request_details` WRITE;
/*!40000 ALTER TABLE `request_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `request_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `roles` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `role` varchar(30) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `role_UNIQUE` (`role`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=63908674 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (63908673,'ADMIN'),(7879,'EMPLOYEE'),(8767,'MERCHANT'),(6715,'USER');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction_details`
--

DROP TABLE IF EXISTS `transaction_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transaction_details` (
  `TRANS_ID` int(11) NOT NULL AUTO_INCREMENT,
  `TRANS_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `TRANS_AMT` int(11) NOT NULL,
  `FROM_ACCT` varchar(45) DEFAULT NULL,
  `TO_ACCT` varchar(45) DEFAULT NULL,
  `TEMP_1` varchar(45) DEFAULT NULL,
  `TEMP_2` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`TRANS_ID`),
  KEY `FROM_ACCOUNT_idx` (`FROM_ACCT`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction_details`
--

LOCK TABLES `transaction_details` WRITE;
/*!40000 ALTER TABLE `transaction_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `transaction_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `USER_ID` int(11) NOT NULL AUTO_INCREMENT,
  `USER_NAME` varchar(30) NOT NULL,
  `PASSWORD` varchar(70) NOT NULL,
  `EMAIL_ID` varchar(255) NOT NULL,
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `FIRST_NAME` varchar(60) NOT NULL,
  `LAST_NAME` varchar(60) NOT NULL,
  `ADDRESS` varchar(560) NOT NULL,
  `DOB` date NOT NULL,
  `CONTACT_NUM` varchar(20) NOT NULL,
  `SEC_QUE1` varchar(128) NOT NULL,
  `SEC_ANS1` varchar(45) NOT NULL,
  `SEC_QUE2` varchar(128) NOT NULL,
  `SEC_ANS2` varchar(45) NOT NULL,
  `PKI_PATH` varchar(45) DEFAULT NULL,
  `PKI_CERTI` varchar(45) DEFAULT NULL,
  `PKI_NUMBER` varchar(45) DEFAULT NULL,
  `ROLE_ID` int(11) DEFAULT NULL,
  `PUBLIC_KEY` varchar(240) DEFAULT NULL,
  `OTP` varchar(45) DEFAULT NULL,
  `LOGIN_ATTEMPTS` int(11) DEFAULT NULL,
  `ACCT_LOCKED_STATUS` int(11) DEFAULT NULL,
  PRIMARY KEY (`USER_ID`),
  UNIQUE KEY `id_UNIQUE` (`USER_ID`),
  UNIQUE KEY `username_UNIQUE` (`USER_NAME`),
  UNIQUE KEY `email_UNIQUE` (`EMAIL_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'admin','$2a$10$23RoEaykJR6FGoJ9kMVaBuH/BG2oQwqKwCcabAmaCajtHWm50BJpG','admin@gmail.com','2014-10-19 01:07:43','admin','admin','adasd]','2014-10-05','adadd','asdasdasd','asdasdasd','adads','sdasdasd',NULL,NULL,NULL,6715,NULL,NULL,NULL,NULL),(2,'user1','$2a$10$d1Sao39b20GmsQBiZ/Tz1OfEEFTO3v5QGmaeebvttnsIGq3An75bG','user1@gmail.com','2014-10-19 05:48:14','user1','user1','adasd]','2014-10-06','asdadsad','asdasd','dasdas','asdasd','asdasd',NULL,NULL,NULL,6715,NULL,NULL,NULL,NULL),(3,'user2','$2a$10$BwrtAcpiAVJd06xQ2/IjrOz7XTSkJOiF8l1EhJwSFN5NJWjXHWYv2','user2@gmail.com','2014-10-19 07:53:45','user2','user2','No . 2/19 Puthu','2014-10-13','adsdadas','asdasd','dasdas','adads','asdasdasd',NULL,NULL,NULL,8767,NULL,NULL,NULL,NULL),(4,'user3','$2a$10$jfjPoiihZkOxO/UxJ0kNq.yUalg1OAAGHJIoqw7LFu5By6Nr.K0WC','user3@gmail.com','2014-10-19 08:27:38','user3','user3','adasd','2014-10-01','adsdadas','asdasdasd','asdasdasd','asdasd','sdasdasd',NULL,NULL,NULL,8767,NULL,NULL,NULL,NULL),(5,'user4','$2a$10$twwW6Kdwa9WYQ2O4JPe9i.dEr6mUJMD4U2O.E.mJo/h7riY.ZhYb6','user4@gmail.com','2014-10-19 08:37:43','user4','user4','adasdads','2014-10-01','adsdadas','asdasdasddasd','adasdasd','assdasdas','asdasdasd',NULL,NULL,NULL,8767,NULL,NULL,NULL,NULL),(6,'user5','$2a$10$kqR5OyBJbHi96LDtlWcZ2.rhQ.khGTJ5faeqOX5uLDZfEeSsUP2We','user5@gmail.com','2014-10-19 09:02:00','user5','user5','aasdad','2014-10-13','sadasdasd','asdasdasd','dasdas','adasdasd','asdasdasd',NULL,NULL,NULL,8767,NULL,NULL,NULL,NULL),(7,'user6','$2a$10$tqlDe/ONb/nt9dL6BGEvCe80Vd25PqNQ748UkOUXnT3ESTz7PjOwW','user6@gmail.com','2014-10-19 09:08:00','user6','user6','userwadas','2014-07-21','qasdasdasd','asdasdasdASDASD','asdasdasdSDASDAS','asdasd','ASDASD',NULL,NULL,NULL,8767,NULL,NULL,NULL,NULL),(8,'user7','$2a$10$fU1uL3ugjencZte.M1W2/u/U/ADybYvN8YTLHh7DmclZIGjuTClMC','user7@gmail.com','2014-10-19 09:14:57','user7','user7','userdadas','2014-07-29','asdasdsadasd','asdasdasdASDASD','asdasdasdSDASDAS','asdasd','ASDASD',NULL,NULL,NULL,8767,NULL,NULL,NULL,NULL),(10,'user8','$2a$10$BuFT0EVwODZAQxuFT4.yF.COATH07YyOO5IT8OOcaJnXp3d88ZGYe','user8@gmail.com','2014-10-19 09:27:11','user8','user8','adasd','2014-10-12','asdasdasd','asdasd','asdasd','sadasd','asdasd',NULL,NULL,NULL,8767,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-10-19  2:29:27
