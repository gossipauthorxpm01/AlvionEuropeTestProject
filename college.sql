-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: college
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(256) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `id_professor_lector` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `course_id_professor_lector_index` (`id_professor_lector`),
  CONSTRAINT `course_professors_id_fk` FOREIGN KEY (`id_professor_lector`) REFERENCES `professors` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (1,'Теория разработки ПО',80000,4),(2,'Теория разработки ПО, углубленная',150000,3),(3,'Математическая логика',20000,NULL),(4,'Стандарты автоматизации',65000,1),(5,'Практика автоматизации',40000,1),(6,'История России',100000,5),(7,'Общая история',150000,5),(8,'Практические методы изучения истории',45000,NULL),(9,'Программирование на C++',200000,7),(10,'Программирование на C#',200000,7),(11,'Программирование на Java',150000,7);
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_enrollments`
--

DROP TABLE IF EXISTS `course_enrollments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course_enrollments` (
  `id_student` int DEFAULT NULL,
  `id_course` int DEFAULT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `course_enrollments_id_course_index` (`id_course`),
  KEY `course_enrollments_id_student_index` (`id_student`),
  CONSTRAINT `course_enrollments_course_id_fk` FOREIGN KEY (`id_course`) REFERENCES `course` (`id`),
  CONSTRAINT `course_enrollments_students_id_fk` FOREIGN KEY (`id_student`) REFERENCES `students` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_enrollments`
--

LOCK TABLES `course_enrollments` WRITE;
/*!40000 ALTER TABLE `course_enrollments` DISABLE KEYS */;
INSERT INTO `course_enrollments` VALUES (403,1,1),(412,2,2),(404,4,3),(403,2,4),(405,5,5),(408,7,6),(408,5,7),(408,2,8),(409,9,9),(410,10,10),(411,10,11),(411,11,12),(406,8,13),(404,8,14),(404,3,15),(403,7,16);
/*!40000 ALTER TABLE `course_enrollments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_enrollments_seq`
--

DROP TABLE IF EXISTS `course_enrollments_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course_enrollments_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_enrollments_seq`
--

LOCK TABLES `course_enrollments_seq` WRITE;
/*!40000 ALTER TABLE `course_enrollments_seq` DISABLE KEYS */;
INSERT INTO `course_enrollments_seq` VALUES (1);
/*!40000 ALTER TABLE `course_enrollments_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_seq`
--

DROP TABLE IF EXISTS `course_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_seq`
--

LOCK TABLES `course_seq` WRITE;
/*!40000 ALTER TABLE `course_seq` DISABLE KEYS */;
INSERT INTO `course_seq` VALUES (1);
/*!40000 ALTER TABLE `course_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `professors`
--

DROP TABLE IF EXISTS `professors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `professors` (
  `id` int NOT NULL,
  `name` varchar(256) NOT NULL,
  `payment` float NOT NULL,
  `address` varchar(256) DEFAULT NULL,
  `phone_number` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `phone_number` (`phone_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `professors`
--

LOCK TABLES `professors` WRITE;
/*!40000 ALTER TABLE `professors` DISABLE KEYS */;
INSERT INTO `professors` VALUES (1,'Маркова Варвара Лукинична',25000,'801664, Томская область, город Солнечногорск, пл. Чехова, 59','7(3412)676-63-24'),(2,'Захаров Артём Егорович',75000,'637734, Читинская область, город Подольск, ул. Космонавтов, 57','7(076)720-81-78'),(3,'Сергеев Данила Демидович',35120,'480322, Мурманская область, город Коломна, въезд Бухарестская, 71','7(8965)693-71-13'),(4,'Семенов Максим Игоревич',35000,'379195, Липецкая область, город Мытищи, пр. Бухарестская, 86','7(7920)611-22-95'),(5,'Фомин Михаил Николаевич',40000,'801080, Ульяновская область, город Чехов, въезд 1905 года, 16','7(76)539-40-43'),(6,'Гусев Тимофей Иванович',40000,'526956, Псковская область, город Ступино, спуск Косиора, 92','7(363)864-66-66'),(7,'Измайлова Милана Николаевна',40000,'861514, Ростовская область, город Серпухов, пл. Ленина, 63','7(38)601-22-88');
/*!40000 ALTER TABLE `professors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `professors_seq`
--

DROP TABLE IF EXISTS `professors_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `professors_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `professors_seq`
--

LOCK TABLES `professors_seq` WRITE;
/*!40000 ALTER TABLE `professors_seq` DISABLE KEYS */;
INSERT INTO `professors_seq` VALUES (401);
/*!40000 ALTER TABLE `professors_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `students`
--

DROP TABLE IF EXISTS `students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `students` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(256) NOT NULL,
  `address` varchar(256) NOT NULL,
  `email` varchar(256) NOT NULL,
  `average_performance` float DEFAULT NULL,
  `id_record_book` int NOT NULL,
  `phone_number` varchar(256) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `idRecordBook` (`id_record_book`),
  UNIQUE KEY `phoneNumber` (`phone_number`),
  CONSTRAINT `students_students_record_book_id_fk` FOREIGN KEY (`id_record_book`) REFERENCES `students_record_book` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=413 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students`
--

LOCK TABLES `students` WRITE;
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
INSERT INTO `students` VALUES (403,'Серов Никита Семёнович','185847, Тульская область, город Талдом, ул. Чехова, 28','aemiliop@pianoxltd.com',NULL,2,'7(42)826-28-09'),(404,'Юдина Анастасия Эмировна','663659, Томская область, город Кашира, проезд Балканская, 04','asaf199@alertslit.top',NULL,3,'7(58)945-51-69'),(405,'Севастьянов Леонид Макарович','966913, Смоленская область, город Раменское, бульвар Бухарестская, 60','euro0069@vaneroln.space',NULL,4,'7(8500)386-62-98'),(406,'Захарова Валерия Фёдоровна','660868, Брянская область, город Раменское, бульвар Космонавтов, 40','nataalex06@edume.me',NULL,5,'7(180)345-73-67'),(407,'Богданова Камила Матвеевна','510070, Калининградская область, город Серпухов, бульвар Славы, 68','mtarsia@postfach2go.de',NULL,6,'7(937)830-15-61'),(408,'Данилова Анастасия Владимировна','709183, Сахалинская область, город Клин, наб. Сталина, 77','pramoolb@messagesino.xyz',NULL,7,'7(576)832-01-20'),(409,'Чистяков Лев Егорович','533855, Ивановская область, город Сергиев Посад, бульвар Бухарестская, 00','messina399@kimchung.xyz',NULL,8,'7(762)305-33-21'),(410,'Белоусова Марина Данииловна','042237, Ленинградская область, город Пушкино, въезд Домодедовская, 15','kostikovakarina@bdredemptionservices.com',NULL,9,'7(52)085-74-23'),(411,'Юдина София Степановна','597662, Ивановская область, город Озёры, наб. Ломоносова, 49','ivaniusbx@pliqya.xyz',NULL,10,'7(16)285-33-20'),(412,'Антонов Ярослав Кириллович','532814, Калужская область, город Лотошино, бульвар Сталина, 48','hjwsw@googl.win',NULL,11,'7(236)700-82-50');
/*!40000 ALTER TABLE `students` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `students_record_book`
--

DROP TABLE IF EXISTS `students_record_book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `students_record_book` (
  `math` int DEFAULT NULL,
  `russian_language` int DEFAULT NULL,
  `english_language` int DEFAULT NULL,
  `programming` int DEFAULT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  `id_record_book` bigint NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students_record_book`
--

LOCK TABLES `students_record_book` WRITE;
/*!40000 ALTER TABLE `students_record_book` DISABLE KEYS */;
INSERT INTO `students_record_book` VALUES (2,5,3,5,2,0),(2,5,3,5,3,0),(4,5,3,5,4,0),(4,5,4,5,5,0),(4,5,4,5,6,0),(4,5,4,5,7,0),(3,4,4,5,8,0),(5,4,4,5,9,0),(5,4,5,5,10,0),(5,4,5,5,11,0);
/*!40000 ALTER TABLE `students_record_book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `students_record_book_seq`
--

DROP TABLE IF EXISTS `students_record_book_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `students_record_book_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students_record_book_seq`
--

LOCK TABLES `students_record_book_seq` WRITE;
/*!40000 ALTER TABLE `students_record_book_seq` DISABLE KEYS */;
INSERT INTO `students_record_book_seq` VALUES (1);
/*!40000 ALTER TABLE `students_record_book_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `students_seq`
--

DROP TABLE IF EXISTS `students_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `students_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students_seq`
--

LOCK TABLES `students_seq` WRITE;
/*!40000 ALTER TABLE `students_seq` DISABLE KEYS */;
INSERT INTO `students_seq` VALUES (501);
/*!40000 ALTER TABLE `students_seq` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-04-28 15:30:41
