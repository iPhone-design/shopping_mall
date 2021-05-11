CREATE DATABASE  IF NOT EXISTS `mall_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `mall_db`;
-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: mall_db
-- ------------------------------------------------------
-- Server version	8.0.20

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
-- Table structure for table `product_upload`
--

DROP TABLE IF EXISTS `product_upload`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_upload` (
  `number` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `photo_1` text NOT NULL,
  `photo_2` text,
  `photo_3` text,
  `price` int NOT NULL,
  `description` text NOT NULL,
  PRIMARY KEY (`number`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_upload`
--

LOCK TABLES `product_upload` WRITE;
/*!40000 ALTER TABLE `product_upload` DISABLE KEYS */;
INSERT INTO `product_upload` VALUES (14,'사진','2021-05-10-11_28_39_8.jpg',NULL,NULL,123,'123'),(15,'한글','2021-05-10-11_29_25_240814485574155029.jfif',NULL,NULL,123,'asdf'),(16,'강아지 귀엽당','2021-05-10-11_29_56_asdf.jpg',NULL,NULL,123,'ㅋㅌㅊ'),(17,'됨?','2021-05-10-11_41_53_KakaoTalk_20210510_114116376.png',NULL,NULL,123,'21`3'),(18,'한글','2021-05-10-11_43_36_KakaoTalk_20210510_114116376.png',NULL,NULL,12,'123'),(19,'한글','2021-05-10-11_46_02_asdf.jpg',NULL,NULL,213,'123');
/*!40000 ALTER TABLE `product_upload` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `review`
--

DROP TABLE IF EXISTS `review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `review` (
  `number` int NOT NULL AUTO_INCREMENT,
  `id` varchar(50) NOT NULL,
  `fileName` varchar(500) NOT NULL,
  `text` text NOT NULL,
  UNIQUE KEY `number_UNIQUE` (`number`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `review`
--

LOCK TABLES `review` WRITE;
/*!40000 ALTER TABLE `review` DISABLE KEYS */;
INSERT INTO `review` VALUES (1,'임시계정','2021-05-10-12_07_23_옷.PNG','테스트 임다!!! 우와아아아앙ㅇ 신기방기');
/*!40000 ALTER TABLE `review` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `user_num` int NOT NULL AUTO_INCREMENT,
  `id` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `birth` date NOT NULL,
  `phone_num` int NOT NULL,
  `address` varchar(50) NOT NULL,
  `join_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `grade` tinyint NOT NULL DEFAULT '1',
  PRIMARY KEY (`user_num`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `phone_num_UNIQUE` (`phone_num`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'111','111','ㅇㅅㅇ','1999-01-01',111,'111','2021-05-10 21:41:21',1),(2,'222','222','ㅎㅅㅎ','1998-02-02',222,'222','2021-05-10 21:47:44',1),(3,'333','333','ㅇㅂㅇ','1997-03-03',333,'333','2021-05-10 21:49:02',1),(4,'444','444','ㅍㅅㅍ','1996-04-04',444,'444','2021-05-10 21:49:24',1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'mall_db'
--

--
-- Dumping routines for database 'mall_db'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-11  9:02:07
