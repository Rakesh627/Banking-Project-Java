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
  `ACCT_ID` int(11) NOT NULL AUTO_INCREMENT,
  `ACCOUNT_NUMBER` varchar(45) NOT NULL,
  `U_ID` int(11) DEFAULT NULL,
  `BALANCE` double NOT NULL,
  `TEMP_1` varchar(45) DEFAULT NULL,
  `TEMP_2` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ACCT_ID`),
  UNIQUE KEY `ACCT_ID_UNIQUE` (`ACCT_ID`),
  UNIQUE KEY `ACCOUNT_NUMBER_UNIQUE` (`ACCOUNT_NUMBER`),
  KEY `USER_ID_idx` (`U_ID`),
  CONSTRAINT `USER_ID` FOREIGN KEY (`U_ID`) REFERENCES `user` (`USER_ID`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_details`
--

LOCK TABLES `account_details` WRITE;
/*!40000 ALTER TABLE `account_details` DISABLE KEYS */;
INSERT INTO `account_details` VALUES (1,'736953878',11,644.244,NULL,NULL),(2,'342019236',12,355.756,NULL,NULL),(3,'132423552',19,500,NULL,NULL);
/*!40000 ALTER TABLE `account_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bill_pay`
--

DROP TABLE IF EXISTS `bill_pay`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bill_pay` (
  `BILL_ID` int(11) NOT NULL AUTO_INCREMENT,
  `MERCHANT_ID` int(11) DEFAULT NULL,
  `ACCT_NUMBER` varchar(45) DEFAULT NULL,
  `AMOUNT` double DEFAULT NULL,
  `STATUS` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`BILL_ID`),
  UNIQUE KEY `ACCT_NUMBER_UNIQUE` (`ACCT_NUMBER`),
  UNIQUE KEY `MERCHANT_ID_UNIQUE` (`MERCHANT_ID`),
  CONSTRAINT `MERCHANT_FK` FOREIGN KEY (`MERCHANT_ID`) REFERENCES `user` (`USER_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bill_pay`
--

LOCK TABLES `bill_pay` WRITE;
/*!40000 ALTER TABLE `bill_pay` DISABLE KEYS */;
/*!40000 ALTER TABLE `bill_pay` ENABLE KEYS */;
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
  CONSTRAINT `NOTIFICATION_USER_ID` FOREIGN KEY (`NOTIFICATION_USER_ID`) REFERENCES `user` (`USER_ID`) ON DELETE NO ACTION ON UPDATE CASCADE
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
  `IS_APPROVED` tinyint(1) DEFAULT NULL,
  `REQ_PRIORITY` varchar(25) DEFAULT NULL,
  `REQ_TRANS_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`REQ_ID`),
  UNIQUE KEY `REQ_TRANS_ID_UNIQUE` (`REQ_TRANS_ID`),
  KEY `REQ_USER_ID_idx` (`REQ_USER_ID`),
  CONSTRAINT `REQ_TRANS_ID` FOREIGN KEY (`REQ_TRANS_ID`) REFERENCES `transaction_details` (`TRANS_ID`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `REQ_USER_ID` FOREIGN KEY (`REQ_USER_ID`) REFERENCES `user` (`USER_ID`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `request_details`
--

LOCK TABLES `request_details` WRITE;
/*!40000 ALTER TABLE `request_details` DISABLE KEYS */;
INSERT INTO `request_details` VALUES (1,NULL,'asdada',NULL,NULL,'Second Issue',NULL,NULL,NULL),(2,NULL,'asdadsd',NULL,NULL,'Second Issue',NULL,NULL,NULL),(3,12,'asdasdsad',0,'2014-10-30 08:44:23','First Issue',NULL,'Critical',NULL),(4,12,'342019236,736953878,20',0,'2014-10-30 08:49:59','Transact',1,NULL,5);
/*!40000 ALTER TABLE `request_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `roles` (
  `ROLE_ID` int(11) NOT NULL,
  `ROLE_NAME` varchar(30) NOT NULL,
  `ROLE_DESC` varchar(60) DEFAULT NULL,
  `CREATED_DATE` datetime DEFAULT NULL,
  `IS_ACTIVE` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`ROLE_ID`),
  UNIQUE KEY `role_UNIQUE` (`ROLE_NAME`),
  UNIQUE KEY `ROLE_ID_UNIQUE` (`ROLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (6715,'ROLE_USER',NULL,NULL,NULL),(7879,'ROLE_EMPLOYEE',NULL,NULL,NULL),(8767,'ROLE_MERCHANT',NULL,NULL,NULL),(63908673,'ROLE_ADMIN',NULL,NULL,NULL);
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
  `TRANS_AMT` double NOT NULL,
  `FROM_ACCT` varchar(45) DEFAULT NULL,
  `TO_ACCT` varchar(45) DEFAULT NULL,
  `TEMP_1` varchar(45) DEFAULT NULL,
  `TEMP_2` varchar(45) DEFAULT NULL,
  `IS_AUTHORIZED` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`TRANS_ID`),
  KEY `FROM_ACCOUNT_idx` (`FROM_ACCT`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction_details`
--

LOCK TABLES `transaction_details` WRITE;
/*!40000 ALTER TABLE `transaction_details` DISABLE KEYS */;
INSERT INTO `transaction_details` VALUES (1,'2014-10-30 08:14:47',50,NULL,'342019236',NULL,NULL,NULL),(2,'2014-10-30 08:14:59',50,'342019236',NULL,NULL,NULL,NULL),(3,'2014-10-30 08:21:41',123,'342019236','736953878',NULL,NULL,NULL),(4,'2014-10-30 08:22:46',1.244,'342019236','736953878',NULL,NULL,NULL),(5,'2014-10-30 08:49:59',20,'342019236','736953878',NULL,NULL,1);
/*!40000 ALTER TABLE `transaction_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `USER_ID` int(11) NOT NULL AUTO_INCREMENT,
  `USER_NAME` varchar(30) NOT NULL,
  `PASSWORD` varchar(70) NOT NULL,
  `EMAIL_ID` varchar(255) NOT NULL,
  `CREATE_TIME` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `FIRST_NAME` varchar(60) NOT NULL,
  `LAST_NAME` varchar(60) NOT NULL,
  `ADDRESS` varchar(560) DEFAULT NULL,
  `DOB` date NOT NULL,
  `CONTACT_NUM` varchar(20) NOT NULL,
  `SEC_QUE1` varchar(128) NOT NULL,
  `SEC_ANS1` varchar(45) NOT NULL,
  `SEC_QUE2` varchar(128) NOT NULL,
  `SEC_ANS2` varchar(45) NOT NULL,
  `PKI_PATH` varchar(45) DEFAULT NULL,
  `PKI_CERTI` varchar(45) DEFAULT NULL,
  `PKI_NUMBER` varchar(45) DEFAULT NULL,
  `PUBLIC_KEY` varchar(240) DEFAULT NULL,
  `OTP` varchar(45) DEFAULT NULL,
  `LOGIN_ATTEMPTS` int(11) DEFAULT '0',
  `ACCT_LOCKED_STATUS` tinyint(1) DEFAULT '0',
  `ACTIVE_STATUS` tinyint(1) DEFAULT '1',
  `ROLE_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`USER_ID`),
  UNIQUE KEY `id_UNIQUE` (`USER_ID`),
  UNIQUE KEY `username_UNIQUE` (`USER_NAME`),
  UNIQUE KEY `email_UNIQUE` (`EMAIL_ID`),
  KEY `ROLE_ID_FK_idx` (`ROLE_ID`),
  CONSTRAINT `ROLE_ID_FK` FOREIGN KEY (`ROLE_ID`) REFERENCES `roles` (`ROLE_ID`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (11,'newuser1','$2a$10$ykGrPbCTGWBb6AiH8vfjXOey6dVuvcFPSfKWVFozOjFipZH0nh1Qy','newuser1@gmail.com',NULL,'newuser1','newuser1','sadada ','2014-10-13','adasda','asdad',' asdasds',' sdsadas','ddasdads',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,8767),(12,'newuser2','$2a$10$lH.eRAffO7VBfaXr60GxVe7874N5sr4pFYjUjZkZps03uGhpz268.','newuser2@gmail.com',NULL,'newuser2','newuser2','asdadssa ','2014-10-06','asdasd',' adasda','sdasd ','adads ','asdassds',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,6715),(13,'admin','$2a$10$bGb.zn9wT3gqKt02f2vxeuCGyXnCjX23JzoCkrt.uNxOcf1muymK2','admin@gmail.com',NULL,'admin','admin','asdasdas ','2014-10-06','adadad',' adadasd',' assdada',' adadad','adadasd',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,63908673),(16,'employee1','$2a$10$bBixETxMmc0hmiNw..yaxu2iJTBrRgcuQWZheyu36FSsXPlCGTC4K','employee1@gmail.com',NULL,'employee1','employee1','ssdasdas ','2014-10-01','asdasd',' sadasd','asdasdas ','asdasdasd ','asdasdasd',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,7879),(19,'merchant3','$2a$10$12TxFdAtUAEwRgOHu7UP2OGRZta1J6llsCpCmId5Vsls8UA4BFfhq','merchant3@gmail.com',NULL,'merchant3','merchant3',' adada','2014-10-03','sdada',' adsasd',' asddasdas',' asdasd','sadadasd',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,8767);
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

-- Dump completed on 2014-10-30 18:45:05
