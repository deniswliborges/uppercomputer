-- MariaDB dump 10.18  Distrib 10.4.17-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: uppercomputer
-- ------------------------------------------------------
-- Server version	10.4.17-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cargo`
--

DROP TABLE IF EXISTS `cargo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cargo` (
  `cd_cargo` int(11) NOT NULL AUTO_INCREMENT,
  `nm_cargo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cd_cargo`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cargo`
--

LOCK TABLES `cargo` WRITE;
/*!40000 ALTER TABLE `cargo` DISABLE KEYS */;
INSERT INTO `cargo` VALUES (1,'DEV'),(2,'DBA'),(3,'BI'),(4,'MANAGER PROJECT'),(5,'FIELFD SERVICE'),(6,'SECURITY'),(7,'SQUAD'),(8,'MARKET');
/*!40000 ALTER TABLE `cargo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `endereco`
--

DROP TABLE IF EXISTS `endereco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `endereco` (
  `id` int(11) NOT NULL,
  `bairro` varchar(255) DEFAULT NULL,
  `cep` varchar(255) DEFAULT NULL,
  `complemento` varchar(255) DEFAULT NULL,
  `logradouro` varchar(255) DEFAULT NULL,
  `numero` varchar(255) DEFAULT NULL,
  `funcionario_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmq19g9m9rc7qcb00ps45cnxu` (`funcionario_id`),
  CONSTRAINT `FKmq19g9m9rc7qcb00ps45cnxu` FOREIGN KEY (`funcionario_id`) REFERENCES `funcionario` (`cd_func`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `endereco`
--

LOCK TABLES `endereco` WRITE;
/*!40000 ALTER TABLE `endereco` DISABLE KEYS */;
/*!40000 ALTER TABLE `endereco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ferramenta`
--

DROP TABLE IF EXISTS `ferramenta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ferramenta` (
  `cd_ferramenta` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  `vs` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cd_ferramenta`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ferramenta`
--

LOCK TABLES `ferramenta` WRITE;
/*!40000 ALTER TABLE `ferramenta` DISABLE KEYS */;
INSERT INTO `ferramenta` VALUES (1,'Artia','7.3'),(2,'Slack','10.3'),(3,'Podio','2.5'),(4,'Asana','1.7'),(5,'Conta Azul','2.1'),(6,'Service Now','7.1'),(7,'QuickBooks\'','20.9'),(8,'Trello','2020.13'),(9,'Oracle 11g','11.2'),(10,'MongoDB','7.3'),(11,'SQL Server','7.3'),(12,'PostgreSQL 2012 R2','9.6'),(13,'Android Studio','3.6'),(14,'SpringBoot','4.2'),(15,'Eclypse','7.3'),(16,'GitKraken','7.3');
/*!40000 ALTER TABLE `ferramenta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `funcionario` (
  `cd_func` int(11) NOT NULL AUTO_INCREMENT,
  `bairro` varchar(55) DEFAULT NULL,
  `cep` varchar(55) DEFAULT NULL,
  `complemento` varchar(55) DEFAULT NULL,
  `cpf_func` varchar(55) DEFAULT NULL,
  `email_func` varchar(55) DEFAULT NULL,
  `logradouro` varchar(55) DEFAULT NULL,
  `nm_func` varchar(55) DEFAULT NULL,
  `numero` varchar(55) DEFAULT NULL,
  `rg_fun` varchar(55) DEFAULT NULL,
  `salario` double NOT NULL,
  `senha` varchar(55) DEFAULT NULL,
  `tipo` int(11) DEFAULT NULL,
  `cd_cargo` int(11) DEFAULT NULL,
  PRIMARY KEY (`cd_func`),
  UNIQUE KEY `UK_aq2yntaxvhywsy6xsn5ifm8gt` (`email_func`),
  KEY `FKqcm54ej8sdir3i4vau739w519` (`cd_cargo`),
  CONSTRAINT `FKqcm54ej8sdir3i4vau739w519` FOREIGN KEY (`cd_cargo`) REFERENCES `cargo` (`cd_cargo`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `funcionario` VALUES (1,' Jardins','38220834','apto 303 ','548657459-41','denis@gmail.com','Rua Flores','Denis Willian','300','96458754-x',6500,'123',1,1),(2,'Centro','38777012','Sala 800','451230562-47','Michel@gmail.com','Avenida Matos','Michel Gonçalves','105','56985471-0',10800,'123',2,2),(3,'Vila Andrade','281777012',NULL,'548625419-12','david@gmail','Avenida Floriano','David Cayuella','2106','02354209-6',4500,'123',3,3),(4,'Vila Morumbi','281777012','casa 3','478563256-52','andre@gmail','Alamenda Tocantins','Andre Martins','26','52145236-8',7250,'123',4,4);
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `telefone`
--

DROP TABLE IF EXISTS `telefone`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `telefone` (
  `funcionario_cd_func` int(11) NOT NULL,
  `telefones` varchar(255) DEFAULT NULL,
  KEY `FK9jp3kc1epgtgrg36sugaaneak` (`funcionario_cd_func`),
  CONSTRAINT `FK9jp3kc1epgtgrg36sugaaneak` FOREIGN KEY (`funcionario_cd_func`) REFERENCES `funcionario` (`cd_func`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `telefone`
--

LOCK TABLES `telefone` WRITE;
/*!40000 ALTER TABLE `telefone` DISABLE KEYS */;
INSERT INTO `telefone` VALUES (1,'963254456'),(1,'56215547'),(2,'915246600'),(2,'45963522'),(3,'962110455'),(4,'962110455');
/*!40000 ALTER TABLE `telefone` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-01-31 20:51:06
