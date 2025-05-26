-- MySQL dump 10.13  Distrib 8.0.41, for Win64 (x86_64)
--
-- Host: localhost    Database: gestpharma
-- ------------------------------------------------------
-- Server version	8.0.41

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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `ID_admin` int NOT NULL AUTO_INCREMENT,
  `nom_admin` varchar(50) NOT NULL,
  `prenom_admin` varchar(50) NOT NULL,
  `ID_login` int NOT NULL,
  PRIMARY KEY (`ID_admin`),
  KEY `ID_login` (`ID_login`),
  CONSTRAINT `admin_ibfk_1` FOREIGN KEY (`ID_login`) REFERENCES `login` (`ID_login`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'Super','Admin',1);
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `classe_therapeutique`
--

DROP TABLE IF EXISTS `classe_therapeutique`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `classe_therapeutique` (
  `ID_classe` int NOT NULL,
  `nom_classe` varchar(100) NOT NULL,
  PRIMARY KEY (`ID_classe`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classe_therapeutique`
--

LOCK TABLES `classe_therapeutique` WRITE;
/*!40000 ALTER TABLE `classe_therapeutique` DISABLE KEYS */;
INSERT INTO `classe_therapeutique` VALUES (1,'Classe Cardiovasculaire'),(2,'Antibiotiques'),(3,'Antalgiques'),(9,'Antimitotique'),(50,'Antimitotique'),(90,'Antibiotique');
/*!40000 ALTER TABLE `classe_therapeutique` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `commande`
--

DROP TABLE IF EXISTS `commande`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `commande` (
  `ID_commande` varchar(40) NOT NULL,
  `date_commande` date NOT NULL,
  `ID_preparateur` int NOT NULL,
  `ID_produit` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID_commande`),
  KEY `ID_preparateur` (`ID_preparateur`),
  KEY `ID_produit` (`ID_produit`),
  CONSTRAINT `commande_ibfk_1` FOREIGN KEY (`ID_preparateur`) REFERENCES `preparateur` (`ID_preparateur`),
  CONSTRAINT `commande_ibfk_2` FOREIGN KEY (`ID_produit`) REFERENCES `produit` (`ID_produit`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commande`
--

LOCK TABLES `commande` WRITE;
/*!40000 ALTER TABLE `commande` DISABLE KEYS */;
INSERT INTO `commande` VALUES ('CMD-2025-04-28-35131','2025-05-23',1,'XX-250428-35131'),('CMD-2030-05-09-28083','2025-05-21',1,'XX-300509-28083'),('CMD-2030-05-15-85158','2025-05-21',1,'XX-300515-85158'),('CMD-2030-05-23-48494','2025-05-21',1,'XX-300523-48493'),('CMD-2032-05-06-10746','2025-05-21',1,'XX-320506-10746'),('CMD-2032-05-27-13184','2025-05-21',1,'XX-320527-13184'),('CMD-2032-05-27-45052','2025-05-21',1,'XX-320527-45052'),('CMD-2032-05-27-85905','2025-05-21',1,'XX-320527-85905'),('CMD-2032-05-27-89696','2025-05-21',1,'XX-320527-89696'),('CMD-2043-04-26-38034','2025-05-21',1,'XX-430426-38034');
/*!40000 ALTER TABLE `commande` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `check_date_commande_before_insert` BEFORE INSERT ON `commande` FOR EACH ROW BEGIN
    IF NEW.date_commande > CURDATE() THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'La date de commande ne peut pas être dans le futur.';
    END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `check_date_commande_before_update` BEFORE UPDATE ON `commande` FOR EACH ROW BEGIN
    IF NEW.date_commande > CURDATE() THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'La date de commande ne peut pas être dans le futur.';
    END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `comprend`
--

DROP TABLE IF EXISTS `comprend`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comprend` (
  `ID_produit_pharmaceutique` varchar(20) NOT NULL,
  `ID_sous_classe` int NOT NULL,
  PRIMARY KEY (`ID_produit_pharmaceutique`,`ID_sous_classe`),
  KEY `ID_sous_classe` (`ID_sous_classe`),
  CONSTRAINT `comprend_ibfk_1` FOREIGN KEY (`ID_produit_pharmaceutique`) REFERENCES `produit_pharmaceutique` (`ID_produit_pharmaceutique`),
  CONSTRAINT `comprend_ibfk_2` FOREIGN KEY (`ID_sous_classe`) REFERENCES `sous_classe` (`ID_sous_classe`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comprend`
--

LOCK TABLES `comprend` WRITE;
/*!40000 ALTER TABLE `comprend` DISABLE KEYS */;
INSERT INTO `comprend` VALUES ('XX-250428-35131',2),('XX-320506-10746',9);
/*!40000 ALTER TABLE `comprend` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contenu`
--

DROP TABLE IF EXISTS `contenu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contenu` (
  `ID_produit` varchar(50) NOT NULL,
  `id_lot` varchar(60) NOT NULL,
  PRIMARY KEY (`ID_produit`,`id_lot`),
  KEY `ID_lot` (`id_lot`),
  CONSTRAINT `contenu_ibfk_1` FOREIGN KEY (`ID_produit`) REFERENCES `produit` (`ID_produit`),
  CONSTRAINT `contenu_ibfk_2` FOREIGN KEY (`id_lot`) REFERENCES `lot` (`ID_lot`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contenu`
--

LOCK TABLES `contenu` WRITE;
/*!40000 ALTER TABLE `contenu` DISABLE KEYS */;
INSERT INTO `contenu` VALUES ('XX-300523-48493','0001'),('XX-300509-28083','0002'),('XX-320527-13184','0003'),('XX-320527-45052','0004'),('XX-320527-89696','0005'),('XX-320527-85905','0006'),('XX-300515-85158','0008'),('XX-320506-10746','0009'),('XX-250428-35131','0010');
/*!40000 ALTER TABLE `contenu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dispositif_medical`
--

DROP TABLE IF EXISTS `dispositif_medical`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dispositif_medical` (
  `ID_dispositif_medical` varchar(20) NOT NULL,
  `designation_dispositif_medical` varchar(100) NOT NULL,
  `ID_produit` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID_dispositif_medical`),
  KEY `ID_produit` (`ID_produit`),
  CONSTRAINT `dispositif_medical_ibfk_1` FOREIGN KEY (`ID_produit`) REFERENCES `produit` (`ID_produit`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dispositif_medical`
--

LOCK TABLES `dispositif_medical` WRITE;
/*!40000 ALTER TABLE `dispositif_medical` DISABLE KEYS */;
INSERT INTO `dispositif_medical` VALUES ('XX-320527-45052','Seringue stérile 5 mL','XX-320527-45052');
/*!40000 ALTER TABLE `dispositif_medical` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `facture`
--

DROP TABLE IF EXISTS `facture`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `facture` (
  `ID_facture` varchar(20) NOT NULL,
  `date_facture` date NOT NULL,
  PRIMARY KEY (`ID_facture`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `facture`
--

LOCK TABLES `facture` WRITE;
/*!40000 ALTER TABLE `facture` DISABLE KEYS */;
INSERT INTO `facture` VALUES ('FCT-202505-001','2025-05-25');
/*!40000 ALTER TABLE `facture` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `facturer`
--

DROP TABLE IF EXISTS `facturer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `facturer` (
  `ID_prescription` varchar(50) NOT NULL,
  `ID_facture` varchar(20) NOT NULL,
  PRIMARY KEY (`ID_prescription`,`ID_facture`),
  KEY `ID_facture` (`ID_facture`),
  CONSTRAINT `facturer_ibfk_1` FOREIGN KEY (`ID_facture`) REFERENCES `facture` (`ID_facture`),
  CONSTRAINT `facturer_ibfk_2` FOREIGN KEY (`ID_prescription`) REFERENCES `prescription` (`ID_prescription`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `facturer`
--

LOCK TABLES `facturer` WRITE;
/*!40000 ALTER TABLE `facturer` DISABLE KEYS */;
INSERT INTO `facturer` VALUES ('PRE-43123-09017','FCT-202505-001'),('PRE-54334-84001','FCT-202505-001'),('PRE-7654-96387','FCT-202505-001');
/*!40000 ALTER TABLE `facturer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fournisseur`
--

DROP TABLE IF EXISTS `fournisseur`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fournisseur` (
  `ID_fournisseur` int NOT NULL,
  `nom_fournisseur` varchar(100) NOT NULL,
  PRIMARY KEY (`ID_fournisseur`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fournisseur`
--

LOCK TABLES `fournisseur` WRITE;
/*!40000 ALTER TABLE `fournisseur` DISABLE KEYS */;
INSERT INTO `fournisseur` VALUES (1,'pharmacie Centrale'),(2,'autre');
/*!40000 ALTER TABLE `fournisseur` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `log`
--

DROP TABLE IF EXISTS `log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `log` (
  `ID_log` int NOT NULL AUTO_INCREMENT,
  `date_log` date NOT NULL,
  `type` enum('ENTREE','SORTIE','EN_ATTENTE') NOT NULL,
  `ID_commande` varchar(40) NOT NULL,
  `quantite_log` int DEFAULT NULL,
  PRIMARY KEY (`ID_log`),
  KEY `ID_commande` (`ID_commande`),
  CONSTRAINT `log_ibfk_1` FOREIGN KEY (`ID_commande`) REFERENCES `commande` (`ID_commande`)
) ENGINE=InnoDB AUTO_INCREMENT=177 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `log`
--

LOCK TABLES `log` WRITE;
/*!40000 ALTER TABLE `log` DISABLE KEYS */;
INSERT INTO `log` VALUES (140,'2025-05-21','ENTREE','CMD-2043-04-26-38034',50),(141,'2025-05-21','ENTREE','CMD-2030-05-09-28083',50),(142,'2025-05-21','ENTREE','CMD-2032-05-27-13184',40),(143,'2025-05-21','ENTREE','CMD-2032-05-27-45052',100),(144,'2025-05-21','ENTREE','CMD-2032-05-27-89696',20),(145,'2025-05-21','ENTREE','CMD-2032-05-27-85905',3),(146,'2025-05-21','ENTREE','CMD-2030-05-23-48494',60),(155,'2025-05-21','ENTREE','CMD-2030-05-15-85158',55),(160,'2025-05-21','ENTREE','CMD-2032-05-06-10746',20),(170,'2025-05-23','ENTREE','CMD-2025-04-28-35131',10),(172,'2025-05-24','SORTIE','CMD-2030-05-23-48494',40),(173,'2025-05-24','SORTIE','CMD-2030-05-23-48494',17),(174,'2025-05-25','SORTIE','CMD-2030-05-09-28083',10),(175,'2025-05-25','SORTIE','CMD-2030-05-23-48494',2),(176,'2025-05-26','SORTIE','CMD-2043-04-26-38034',48);
/*!40000 ALTER TABLE `log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `login` (
  `ID_login` int NOT NULL AUTO_INCREMENT,
  `nom_utilisateur` varchar(50) NOT NULL,
  `mot_de_passe` varchar(64) NOT NULL,
  PRIMARY KEY (`ID_login`),
  UNIQUE KEY `nom_utilisateur` (`nom_utilisateur`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES (1,'admin','$2a$10$xYBb79ZF.KfwTO0S/peZ.umtGmAzBJS/10L/zK1XDBFWgxec7kJKi'),(2,'user','$2a$10$TKwzt1dets8iLE/RjYRy/.DcGvfAFopT7YfFLwhLfTxuc6NaGJVq2'),(8,'prep','prep123');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lot`
--

DROP TABLE IF EXISTS `lot`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lot` (
  `ID_lot` varchar(60) NOT NULL,
  `date_fabrication` date NOT NULL,
  `date_expiration` date NOT NULL,
  `quantite_lot` int NOT NULL,
  PRIMARY KEY (`ID_lot`),
  CONSTRAINT `lot_chk_1` CHECK ((`quantite_lot` >= 0))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lot`
--

LOCK TABLES `lot` WRITE;
/*!40000 ALTER TABLE `lot` DISABLE KEYS */;
INSERT INTO `lot` VALUES ('0001','2019-05-08','2030-05-23',4),('0002','2017-05-03','2030-05-09',34),('0003','2019-04-30','2032-05-27',23),('0004','2019-04-30','2032-05-27',80),('0005','2019-04-30','2032-05-27',15),('0006','2019-04-30','2032-05-27',2),('0008','2018-05-09','2030-05-15',41),('0009','2016-05-08','2032-05-06',33),('0010','2022-05-10','2025-04-28',10);
/*!40000 ALTER TABLE `lot` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `check_dates_before_insert` BEFORE INSERT ON `lot` FOR EACH ROW BEGIN
    IF NEW.date_expiration <= NEW.date_fabrication THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'date_expiration doit être > date_fabrication';
    END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `check_dates_before_update` BEFORE UPDATE ON `lot` FOR EACH ROW BEGIN
    IF NEW.date_expiration <= NEW.date_fabrication THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'date_expiration doit être > date_fabrication';
    END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `materiel_hospitalier`
--

DROP TABLE IF EXISTS `materiel_hospitalier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `materiel_hospitalier` (
  `ID_materiel_hospitalier` varchar(20) NOT NULL,
  `designation_materiel_hospitalier` varchar(100) NOT NULL,
  `ID_produit` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID_materiel_hospitalier`),
  KEY `ID_produit` (`ID_produit`),
  CONSTRAINT `materiel_hospitalier_ibfk_1` FOREIGN KEY (`ID_produit`) REFERENCES `produit` (`ID_produit`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `materiel_hospitalier`
--

LOCK TABLES `materiel_hospitalier` WRITE;
/*!40000 ALTER TABLE `materiel_hospitalier` DISABLE KEYS */;
INSERT INTO `materiel_hospitalier` VALUES ('XX-320527-85905','Lampe dermatologique à lumière froide','XX-320527-85905');
/*!40000 ALTER TABLE `materiel_hospitalier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medecin`
--

DROP TABLE IF EXISTS `medecin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medecin` (
  `ID_medecin` varchar(50) NOT NULL,
  `nom_medecin` varchar(50) NOT NULL,
  `prenom_medecin` varchar(50) NOT NULL,
  `specialite_medecin` varchar(50) NOT NULL,
  PRIMARY KEY (`ID_medecin`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medecin`
--

LOCK TABLES `medecin` WRITE;
/*!40000 ALTER TABLE `medecin` DISABLE KEYS */;
INSERT INTO `medecin` VALUES ('MED-Dermatologie-09017','xxxx','xxxx','Dermatologie'),('MED-Dermatologie-84000','mr','mr','Dermatologie'),('MED-Dermatologie-96386','dr','docteur','Dermatologie'),('MED-Dermatologie-99548','dr','docteur','Dermatologie');
/*!40000 ALTER TABLE `medecin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `passer_commande`
--

DROP TABLE IF EXISTS `passer_commande`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `passer_commande` (
  `ID_fournisseur` int NOT NULL,
  `ID_commande` varchar(20) NOT NULL,
  PRIMARY KEY (`ID_fournisseur`,`ID_commande`),
  KEY `ID_commande` (`ID_commande`),
  CONSTRAINT `passer_commande_ibfk_1` FOREIGN KEY (`ID_fournisseur`) REFERENCES `fournisseur` (`ID_fournisseur`),
  CONSTRAINT `passer_commande_ibfk_2` FOREIGN KEY (`ID_commande`) REFERENCES `commande` (`ID_commande`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `passer_commande`
--

LOCK TABLES `passer_commande` WRITE;
/*!40000 ALTER TABLE `passer_commande` DISABLE KEYS */;
/*!40000 ALTER TABLE `passer_commande` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient`
--

DROP TABLE IF EXISTS `patient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patient` (
  `ID_patient` varchar(60) NOT NULL,
  `nom_patient` varchar(50) NOT NULL,
  `prenom_patient` varchar(50) NOT NULL,
  `date_naissance` date NOT NULL,
  `numero_de_telephone` varchar(20) NOT NULL,
  `genre` char(1) NOT NULL,
  PRIMARY KEY (`ID_patient`),
  CONSTRAINT `patient_chk_1` CHECK ((`genre` in (_utf8mb4'M',_utf8mb4'F')))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient`
--

LOCK TABLES `patient` WRITE;
/*!40000 ALTER TABLE `patient` DISABLE KEYS */;
INSERT INTO `patient` VALUES ('PAT-M-2009-04-27-09017','xxxxxxx','xxxx','2009-04-27','876543456','M'),('PAT-M-2015-05-06-84000','mr','mr','2015-05-06','543245','M'),('PAT-M-2016-05-09-99548','mr','patient','2016-05-09','987654','M'),('PAT-M-2018-05-14-96387','mr','patient','2018-05-14','87654','M');
/*!40000 ALTER TABLE `patient` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `check_date_naissance_before_insert` BEFORE INSERT ON `patient` FOR EACH ROW BEGIN
    IF NEW.date_naissance >= CURDATE() THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'La date de naissance ne peut pas être dans le futur.';
    END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `check_date_naissance_before_update` BEFORE UPDATE ON `patient` FOR EACH ROW BEGIN
    IF NEW.date_naissance >= CURDATE() THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'La date de naissance ne peut pas être dans le futur.';
    END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `preparateur`
--

DROP TABLE IF EXISTS `preparateur`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `preparateur` (
  `ID_preparateur` int NOT NULL AUTO_INCREMENT,
  `nom_preparateur` varchar(50) NOT NULL,
  `prenom_preparateur` varchar(50) NOT NULL,
  `ID_login` int NOT NULL,
  PRIMARY KEY (`ID_preparateur`),
  KEY `ID_login` (`ID_login`),
  CONSTRAINT `preparateur_ibfk_1` FOREIGN KEY (`ID_login`) REFERENCES `login` (`ID_login`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `preparateur`
--

LOCK TABLES `preparateur` WRITE;
/*!40000 ALTER TABLE `preparateur` DISABLE KEYS */;
INSERT INTO `preparateur` VALUES (1,'altesse','loulou',2),(4,'prep','prep',8);
/*!40000 ALTER TABLE `preparateur` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prescription`
--

DROP TABLE IF EXISTS `prescription`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prescription` (
  `ID_prescription` varchar(50) NOT NULL,
  `date_prescription` date NOT NULL,
  `numero_billet_salle` varchar(10) NOT NULL,
  `ID_medecin` varchar(60) DEFAULT NULL,
  `ID_patient` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`ID_prescription`),
  KEY `ID_medecin` (`ID_medecin`),
  KEY `ID_patient` (`ID_patient`),
  CONSTRAINT `prescription_ibfk_1` FOREIGN KEY (`ID_medecin`) REFERENCES `medecin` (`ID_medecin`),
  CONSTRAINT `prescription_ibfk_2` FOREIGN KEY (`ID_patient`) REFERENCES `patient` (`ID_patient`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prescription`
--

LOCK TABLES `prescription` WRITE;
/*!40000 ALTER TABLE `prescription` DISABLE KEYS */;
INSERT INTO `prescription` VALUES ('PRE-43123-09017','2025-05-25','43123','MED-Dermatologie-09017','PAT-M-2009-04-27-09017'),('PRE-54334-84001','2025-05-25','54334','MED-Dermatologie-84000','PAT-M-2015-05-06-84000'),('PRE-7654-96387','2025-05-26','7654','MED-Dermatologie-96386','PAT-M-2018-05-14-96387'),('PRE-7678-99549','2025-05-24','7678','MED-Dermatologie-99548','PAT-M-2016-05-09-99548');
/*!40000 ALTER TABLE `prescription` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prescrit`
--

DROP TABLE IF EXISTS `prescrit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prescrit` (
  `ID_produit_pharmaceutique` varchar(20) NOT NULL,
  `ID_prescription` varchar(50) NOT NULL,
  `quantite` int DEFAULT NULL,
  PRIMARY KEY (`ID_prescription`,`ID_produit_pharmaceutique`),
  KEY `ID_produit_pharmaceutique` (`ID_produit_pharmaceutique`),
  CONSTRAINT `prescrit_ibfk_1` FOREIGN KEY (`ID_prescription`) REFERENCES `prescription` (`ID_prescription`),
  CONSTRAINT `prescrit_ibfk_2` FOREIGN KEY (`ID_produit_pharmaceutique`) REFERENCES `produit_pharmaceutique` (`ID_produit_pharmaceutique`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prescrit`
--

LOCK TABLES `prescrit` WRITE;
/*!40000 ALTER TABLE `prescrit` DISABLE KEYS */;
INSERT INTO `prescrit` VALUES ('XX-300509-28083','PRE-43123-09017',10),('XX-300523-48493','PRE-54334-84001',2),('XX-430426-38034','PRE-7654-96387',48),('XX-300523-48493','PRE-7678-99549',40);
/*!40000 ALTER TABLE `prescrit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produit`
--

DROP TABLE IF EXISTS `produit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `produit` (
  `ID_produit` varchar(50) NOT NULL,
  `prix_unitaire` double NOT NULL,
  PRIMARY KEY (`ID_produit`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produit`
--

LOCK TABLES `produit` WRITE;
/*!40000 ALTER TABLE `produit` DISABLE KEYS */;
INSERT INTO `produit` VALUES ('XX-250428-35131',100),('XX-300509-28083',500),('XX-300515-85158',350),('XX-300523-48493',300),('XX-320506-10746',300),('XX-320527-13184',1000),('XX-320527-45052',100),('XX-320527-85905',1200),('XX-320527-89696',900),('XX-430426-38034',400);
/*!40000 ALTER TABLE `produit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produit_laboratoire`
--

DROP TABLE IF EXISTS `produit_laboratoire`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `produit_laboratoire` (
  `ID_produit_laboratoire` varchar(20) NOT NULL,
  `designation_produit_laboratoire` varchar(100) NOT NULL,
  `ID_produit` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID_produit_laboratoire`),
  KEY `ID_produit` (`ID_produit`),
  CONSTRAINT `produit_laboratoire_ibfk_1` FOREIGN KEY (`ID_produit`) REFERENCES `produit` (`ID_produit`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produit_laboratoire`
--

LOCK TABLES `produit_laboratoire` WRITE;
/*!40000 ALTER TABLE `produit_laboratoire` DISABLE KEYS */;
INSERT INTO `produit_laboratoire` VALUES ('XX-320527-89696','Réactif de glycémie','XX-320527-89696');
/*!40000 ALTER TABLE `produit_laboratoire` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produit_parapharmaceutique`
--

DROP TABLE IF EXISTS `produit_parapharmaceutique`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `produit_parapharmaceutique` (
  `ID_produit_parapharmaceutique` varchar(20) NOT NULL,
  `designation_produit_parapharmaceutique` varchar(100) NOT NULL,
  `ID_produit` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID_produit_parapharmaceutique`),
  KEY `ID_produit` (`ID_produit`),
  CONSTRAINT `produit_parapharmaceutique_ibfk_1` FOREIGN KEY (`ID_produit`) REFERENCES `produit` (`ID_produit`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produit_parapharmaceutique`
--

LOCK TABLES `produit_parapharmaceutique` WRITE;
/*!40000 ALTER TABLE `produit_parapharmaceutique` DISABLE KEYS */;
INSERT INTO `produit_parapharmaceutique` VALUES ('XX-320527-13184','Crème hydratante ','XX-320527-13184');
/*!40000 ALTER TABLE `produit_parapharmaceutique` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produit_pharmaceutique`
--

DROP TABLE IF EXISTS `produit_pharmaceutique`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `produit_pharmaceutique` (
  `ID_produit_pharmaceutique` varchar(50) NOT NULL,
  `forme_produit_pharmaceutique` varchar(50) NOT NULL,
  `ID_produit` varchar(50) DEFAULT NULL,
  `designation_produit_pharmaceutique` varchar(50) DEFAULT NULL,
  `dosage_produit_pharmaceutique` varchar(50) DEFAULT NULL,
  `mode_administration_produit_pharmaceutique` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID_produit_pharmaceutique`),
  KEY `ID_produit` (`ID_produit`),
  CONSTRAINT `produit_pharmaceutique_ibfk_1` FOREIGN KEY (`ID_produit`) REFERENCES `produit` (`ID_produit`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produit_pharmaceutique`
--

LOCK TABLES `produit_pharmaceutique` WRITE;
/*!40000 ALTER TABLE `produit_pharmaceutique` DISABLE KEYS */;
INSERT INTO `produit_pharmaceutique` VALUES ('XX-250428-35131','Pommade','XX-250428-35131','mebo','10mg','Intramusculaire'),('XX-300509-28083','Comprimé','XX-300509-28083','panadol','1000mg','Orale'),('XX-300515-85158','Capsule','XX-300515-85158','Amoxicilline','500mg','Orale'),('XX-300523-48493','Comprimé','XX-300523-48493','doliprane','1000mg','Orale'),('XX-320506-10746','Injectable','XX-320506-10746','Paclitaxel','100mg','Intraveineuse'),('XX-430426-38034','Comprimé','XX-430426-38034','doliprane','500mg','Orale');
/*!40000 ALTER TABLE `produit_pharmaceutique` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sous_classe`
--

DROP TABLE IF EXISTS `sous_classe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sous_classe` (
  `ID_sous_classe` int NOT NULL,
  `nom_sous_classe` varchar(100) NOT NULL,
  `code_atc` varchar(10) DEFAULT NULL,
  `ID_classe` int NOT NULL,
  PRIMARY KEY (`ID_sous_classe`),
  KEY `ID_classe` (`ID_classe`),
  CONSTRAINT `sous_classe_ibfk_1` FOREIGN KEY (`ID_classe`) REFERENCES `classe_therapeutique` (`ID_classe`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sous_classe`
--

LOCK TABLES `sous_classe` WRITE;
/*!40000 ALTER TABLE `sous_classe` DISABLE KEYS */;
INSERT INTO `sous_classe` VALUES (1,'Inhibiteurs de l\'enzyme de conversion','C01AA',1),(2,'Pénicillines',NULL,2),(3,'Céphalosporines',NULL,2),(4,'Paracétamol',NULL,3),(5,'Ibuprofène',NULL,3),(9,'Antimitotique','1022',9),(76,'Antimitotique B','A02',1),(987,'Antimitotique A','A01',1);
/*!40000 ALTER TABLE `sous_classe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stock`
--

DROP TABLE IF EXISTS `stock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stock` (
  `ID_stock` int NOT NULL AUTO_INCREMENT,
  `quantite_stock` int NOT NULL,
  `ID_lot` varchar(10) NOT NULL,
  PRIMARY KEY (`ID_stock`),
  KEY `ID_lot` (`ID_lot`),
  CONSTRAINT `stock_ibfk_1` FOREIGN KEY (`ID_lot`) REFERENCES `lot` (`ID_lot`),
  CONSTRAINT `stock_chk_1` CHECK ((`quantite_stock` >= 0))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stock`
--

LOCK TABLES `stock` WRITE;
/*!40000 ALTER TABLE `stock` DISABLE KEYS */;
/*!40000 ALTER TABLE `stock` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-05-26 12:36:21
