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
  `ACCT_ID` int(11) NOT NULL DEFAULT '0',
  `ACCOUNT_NUMBER` varchar(45) NOT NULL,
  `U_ID` int(11) DEFAULT NULL,
  `BALANCE` int(11) NOT NULL,
  PRIMARY KEY (`ACCT_ID`),
  UNIQUE KEY `ACCOUNT_NUMBER_UNIQUE` (`ACCOUNT_NUMBER`),
  UNIQUE KEY `ACCT_ID_UNIQUE` (`ACCT_ID`),
  KEY `USER_ID_idx` (`U_ID`),
  CONSTRAINT `ACCT_ID` FOREIGN KEY (`ACCT_ID`) REFERENCES `user` (`ACCT_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
  CONSTRAINT `REQ_USER_ID` FOREIGN KEY (`REQ_USER_ID`) REFERENCES `user` (`USER_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
  `ROLE_ID` int(11) DEFAULT NULL,
  `PUBLIC_KEY` varchar(240) DEFAULT NULL,
  `OTP` varchar(45) DEFAULT NULL,
  `LOGIN_ATTEMPTS` int(11) DEFAULT NULL,
  `ACCT_LOCKED_STATUS` int(11) DEFAULT NULL,
  `ACCT_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`USER_ID`),
  UNIQUE KEY `id_UNIQUE` (`USER_ID`),
  UNIQUE KEY `username_UNIQUE` (`USER_NAME`),
  UNIQUE KEY `email_UNIQUE` (`EMAIL_ID`),
  UNIQUE KEY `ACCT_ID_UNIQUE` (`ACCT_ID`),
  KEY `ACCT_ID_idx` (`ACCT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-10-20  0:28:20
