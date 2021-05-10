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
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-10 12:34:00
