-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: testdb
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `ceo_tp`
--

DROP TABLE IF EXISTS `ceo_tp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ceo_tp` (
  `ceo_idx` int NOT NULL,
  `ceo_id` varchar(45) NOT NULL,
  `ceo_pw` varchar(100) NOT NULL,
  `ceo_name` varchar(45) NOT NULL,
  `ceo_store` varchar(45) DEFAULT NULL,
  `ceo_main_menu` varchar(45) DEFAULT NULL,
  `ceo_detail_manu` varchar(45) DEFAULT NULL,
  `ceo_menu_img` varchar(100) DEFAULT NULL,
  `ceo_opetime` varchar(45) DEFAULT NULL,
  `ceo_city_address` varchar(45) DEFAULT NULL,
  `ceo_full_address` varchar(100) DEFAULT NULL,
  `ceo_callnumber` varchar(45) DEFAULT NULL,
  `ceo_contents` varchar(200) DEFAULT NULL,
  `ceo_category_m` varchar(200) DEFAULT NULL,
  `ceo_category_s` varchar(200) DEFAULT NULL,
  `ceo_thumnail_img` varchar(100) DEFAULT NULL,
  `ceo_main_img` varchar(100) DEFAULT NULL,
  `ceo_score` int DEFAULT NULL,
  PRIMARY KEY (`ceo_idx`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ceo_tp`
--

LOCK TABLES `ceo_tp` WRITE;
/*!40000 ALTER TABLE `ceo_tp` DISABLE KEYS */;
/*!40000 ALTER TABLE `ceo_tp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_tp`
--

DROP TABLE IF EXISTS `customer_tp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer_tp` (
  `customer_idx` int NOT NULL,
  `customer_id` varchar(45) NOT NULL,
  `customer_pw` varchar(100) NOT NULL,
  `customer_name` varchar(45) NOT NULL,
  `customer_nick` varchar(45) NOT NULL,
  `customer_gender` varchar(45) NOT NULL,
  `customer_age` int NOT NULL,
  `customer_favorites` varchar(45) DEFAULT NULL,
  `customer_grade` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`customer_idx`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_tp`
--

LOCK TABLES `customer_tp` WRITE;
/*!40000 ALTER TABLE `customer_tp` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer_tp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `question_tp`
--

DROP TABLE IF EXISTS `question_tp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `question_tp` (
  `question_idx` int NOT NULL,
  `customer_idx` int NOT NULL,
  `ceo_idx` int NOT NULL,
  `question_complete` varchar(45) NOT NULL DEFAULT 'N',
  `question_title` varchar(45) NOT NULL,
  `question_contents` varchar(200) NOT NULL,
  `question_date` date NOT NULL,
  `answer_contents` varchar(200) DEFAULT NULL,
  `answer_date` date DEFAULT NULL,
  PRIMARY KEY (`question_idx`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question_tp`
--

LOCK TABLES `question_tp` WRITE;
/*!40000 ALTER TABLE `question_tp` DISABLE KEYS */;
/*!40000 ALTER TABLE `question_tp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservation_tp`
--

DROP TABLE IF EXISTS `reservation_tp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reservation_tp` (
  `reservation_idx` int NOT NULL,
  `customer_idx` int NOT NULL,
  `ceo_idx` int NOT NULL,
  `reservation_stat` int NOT NULL DEFAULT '0' COMMENT '0 - 예약 가능상태(거절)\n1 - 예약 불가상태(승인)\n2 - 예약 불가상태(불가)',
  `reservation_people` int NOT NULL,
  `reservation_contents` varchar(45) NOT NULL,
  `reservation_date` date NOT NULL,
  `reservation_time` int NOT NULL,
  PRIMARY KEY (`reservation_idx`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservation_tp`
--

LOCK TABLES `reservation_tp` WRITE;
/*!40000 ALTER TABLE `reservation_tp` DISABLE KEYS */;
/*!40000 ALTER TABLE `reservation_tp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `review_tp`
--

DROP TABLE IF EXISTS `review_tp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `review_tp` (
  `review_idx` int NOT NULL,
  `customer_idx` int NOT NULL,
  `ceo_idx` int NOT NULL,
  `review_title` varchar(45) NOT NULL,
  `review_contents` varchar(200) NOT NULL,
  `review_img` varchar(100) NOT NULL,
  `review_date` date NOT NULL,
  `review_score` double NOT NULL,
  `review_delete` varchar(45) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`review_idx`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `review_tp`
--

LOCK TABLES `review_tp` WRITE;
/*!40000 ALTER TABLE `review_tp` DISABLE KEYS */;
/*!40000 ALTER TABLE `review_tp` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-30 10:05:15
