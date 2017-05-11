-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: jspdb2
-- ------------------------------------------------------
-- Server version	5.7.17-log

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
-- Table structure for table `basket`
--

DROP TABLE IF EXISTS `basket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `basket` (
  `b_num` int(11) NOT NULL,
  `b_m_id` varchar(20) DEFAULT NULL,
  `b_g_num` int(11) DEFAULT NULL,
  `b_g_amount` int(11) DEFAULT NULL,
  `b_g_size` varchar(10) DEFAULT NULL,
  `b_g_color` varchar(20) DEFAULT NULL,
  `b_date` date DEFAULT NULL,
  PRIMARY KEY (`b_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `basket`
--

LOCK TABLES `basket` WRITE;
/*!40000 ALTER TABLE `basket` DISABLE KEYS */;
/*!40000 ALTER TABLE `basket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `board`
--

DROP TABLE IF EXISTS `board`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `board` (
  `num` int(11) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `pass` varchar(20) DEFAULT NULL,
  `subject` varchar(50) DEFAULT NULL,
  `content` varchar(2000) DEFAULT NULL,
  `readcount` int(11) DEFAULT NULL,
  `re_ref` int(11) DEFAULT NULL,
  `re_lev` int(11) DEFAULT NULL,
  `re_seq` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `ip` varchar(30) DEFAULT NULL,
  `file` varchar(100) DEFAULT NULL,
  `id` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `board`
--

LOCK TABLES `board` WRITE;
/*!40000 ALTER TABLE `board` DISABLE KEYS */;
INSERT INTO `board` VALUES (1,'testman','test','1','1',3,1,0,0,'2017-03-22','0:0:0:0:0:0:0:1',NULL,NULL),(2,'testman','test','2','2',0,1,1,1,'2017-03-22','0:0:0:0:0:0:0:1',NULL,NULL),(3,'admin',NULL,'Deleted',NULL,NULL,3,NULL,NULL,NULL,NULL,NULL,NULL),(4,'testman','test','b','b',0,3,1,1,'2017-03-22','0:0:0:0:0:0:0:1',NULL,NULL),(6,'testman','test','file test','file test',3,6,0,0,'2017-03-22','0:0:0:0:0:0:0:1','jquery-3.2.0.js',NULL),(7,'id','pass','3/22 안 된 것.','비밀번호 바꾸기.\r\n글 순서.\r\n',5,7,0,0,'2017-03-22','0:0:0:0:0:0:0:1',NULL,NULL),(9,'sdfsadf','sadfsadf','1','1',2,9,0,0,'2017-03-23','0:0:0:0:0:0:0:1',NULL,NULL),(10,'asdfsafe','312313','2','2',1,9,1,3,'2017-03-23','0:0:0:0:0:0:0:1',NULL,NULL),(11,'234234','234234','3','3',0,9,2,4,'2017-03-23','0:0:0:0:0:0:0:1',NULL,NULL),(12,'2342342',NULL,'4234324','3423423',1,9,1,1,'2017-03-23','0:0:0:0:0:0:0:1',NULL,NULL),(13,'234242','3243242','324324','324234324',0,9,2,2,'2017-03-23','0:0:0:0:0:0:0:1',NULL,NULL),(14,'testman','test','1','1',1,14,0,0,'2017-03-23','0:0:0:0:0:0:0:1',NULL,NULL),(15,'testman','test','2','2',1,14,1,2,'2017-03-23','0:0:0:0:0:0:0:1',NULL,NULL),(16,'testman','test','3','3',0,14,2,1,'2017-03-23','0:0:0:0:0:0:0:1',NULL,NULL),(17,'testman','test','1','1',1,17,0,0,'2017-03-23','0:0:0:0:0:0:0:1',NULL,NULL),(18,'testman','test','2','2',1,17,1,2,'2017-03-23','0:0:0:0:0:0:0:1',NULL,NULL),(19,'testman','test','3','3',0,17,2,1,'2017-03-23','0:0:0:0:0:0:0:1',NULL,NULL),(20,'safsd','fsadf','1','1',4,20,0,0,'2017-03-23','0:0:0:0:0:0:0:1',NULL,NULL),(21,'123123','1231','2','2',1,20,1,2,'2017-03-23','0:0:0:0:0:0:0:1',NULL,NULL),(22,'13123','123123','3','3',0,20,1,1,'2017-03-23','0:0:0:0:0:0:0:1',NULL,NULL),(23,'324234','234324','4','4',0,20,2,3,'2017-03-23','0:0:0:0:0:0:0:1',NULL,NULL),(24,'testman','test','1','1',134,24,0,0,'2017-03-23','0:0:0:0:0:0:0:1',NULL,NULL),(25,'testman','test','2','2',2,24,1,3,'2017-03-23','0:0:0:0:0:0:0:1',NULL,NULL),(26,'testman','test','3','3',2,24,2,5,'2017-03-23','0:0:0:0:0:0:0:1',NULL,NULL),(27,'testman','test','4','4',0,24,2,4,'2017-03-23','0:0:0:0:0:0:0:1',NULL,NULL),(28,'testman','test','5','5',5,24,1,1,'2017-03-23','0:0:0:0:0:0:0:1',NULL,NULL),(29,'testman','test','6','6',18,24,2,2,'2017-03-23','0:0:0:0:0:0:0:1',NULL,NULL),(30,'admin',NULL,'Deleted',NULL,NULL,30,NULL,NULL,NULL,NULL,NULL,NULL),(31,'testman','test','test2','test2',2,30,1,1,'2017-03-23','0:0:0:0:0:0:0:1',NULL,NULL),(32,'testman','test','test3','test3',1,30,2,2,'2017-03-23','0:0:0:0:0:0:0:1',NULL,NULL),(36,'testman','test','3434','e233',5,36,0,0,'2017-03-23','192.168.2.17','jquery-3.2.01.js',NULL),(37,'tete','test','1','1',27,37,0,0,'2017-03-23','192.168.2.200',NULL,NULL),(38,'tete','test','2','2',1,37,1,1,'2017-03-23','192.168.2.200',NULL,NULL),(39,'testman','test','google.png','google.png',6,39,0,0,'2017-03-31','0:0:0:0:0:0:0:1','google.png',NULL),(40,'testman','test','test','test',1,40,0,0,'2017-03-31','0:0:0:0:0:0:0:1','tumblr_n3d681N93e1r4s8who8_250.gif',NULL),(41,'testman','test','testtest','testtest',17,41,0,0,'2017-03-31','0:0:0:0:0:0:0:1','img021.png',NULL),(42,'testman','test','man','man',1,41,1,1,'2017-04-12','0:0:0:0:0:0:0:1',NULL,NULL);
/*!40000 ALTER TABLE `board` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `g_order`
--

DROP TABLE IF EXISTS `g_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `g_order` (
  `o_num` int(11) NOT NULL,
  `o_trade_num` varchar(50) DEFAULT NULL,
  `o_g_num` int(11) DEFAULT NULL,
  `o_g_name` varchar(50) DEFAULT NULL,
  `o_g_amount` int(11) DEFAULT NULL,
  `o_g_size` varchar(10) DEFAULT NULL,
  `o_g_color` varchar(20) DEFAULT NULL,
  `o_m_id` varchar(20) DEFAULT NULL,
  `o_receive_name` varchar(20) DEFAULT NULL,
  `o_receive_addr1` varchar(70) DEFAULT NULL,
  `o_receive_addr2` varchar(70) DEFAULT NULL,
  `o_receive_phone` varchar(13) DEFAULT NULL,
  `o_receive_mobile` varchar(13) DEFAULT NULL,
  `o_memo` varchar(3000) DEFAULT NULL,
  `o_sum_money` int(11) DEFAULT NULL,
  `o_trade_type` varchar(20) DEFAULT NULL,
  `o_trade_payer` varchar(20) DEFAULT NULL,
  `o_trade_date` date DEFAULT NULL,
  `o_trans_num` varchar(50) DEFAULT NULL,
  `o_date` date DEFAULT NULL,
  `o_status` int(11) DEFAULT NULL,
  PRIMARY KEY (`o_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `g_order`
--

LOCK TABLES `g_order` WRITE;
/*!40000 ALTER TABLE `g_order` DISABLE KEYS */;
INSERT INTO `g_order` VALUES (1,'20170425-1',1,'티티',1,'l','파랑','testman','박','ㄴㅁㅇㄹ','ㄴㅇㅁㄹ','ㄴㅇㄹ','ㄴㅇㅁㄹ','ㄴㅇㅁㄹ',20,'온라인입금','박','2017-04-25','','2017-04-25',0),(2,'20170425-2',1,'티티',111,'l','파랑','testman','박','ㄴㅇㄹ','sㅇㅁㄹ','ㄴㅇㄹ','ㄴㅇㄹ','ㄴㅇㅁㄹ',2220,'온라인입금','박','2017-04-25','','2017-04-25',0),(3,'20170511-3',1,'티티',1,'l','파랑','psw607me@naver.com','박성우','sdafsadf','sdafsdaf','sdfsadf','sdfsdaf','sdafsdfa',20,'온라인입금','박성우','2017-05-11','','2017-05-11',0);
/*!40000 ALTER TABLE `g_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `goods`
--

DROP TABLE IF EXISTS `goods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `goods` (
  `num` int(11) NOT NULL,
  `category` varchar(20) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `content` varchar(3000) DEFAULT NULL,
  `size` varchar(10) DEFAULT NULL,
  `color` varchar(20) DEFAULT NULL,
  `amount` int(11) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `image` varchar(100) DEFAULT NULL,
  `best` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `goods`
--

LOCK TABLES `goods` WRITE;
/*!40000 ALTER TABLE `goods` DISABLE KEYS */;
INSERT INTO `goods` VALUES (1,'Tshirts','티티','티티','l','파랑',20,20,'img021.png,tumblr_n3d681N93e1r4s8who8_250.gif,audience-1866738_1920.jpg,farmer.JPG',0,'2017-04-19');
/*!40000 ALTER TABLE `goods` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `images`
--

DROP TABLE IF EXISTS `images`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `images` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `filename` varchar(50) DEFAULT NULL,
  `file` mediumblob,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `images`
--

LOCK TABLES `images` WRITE;
/*!40000 ALTER TABLE `images` DISABLE KEYS */;
/*!40000 ALTER TABLE `images` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `member` (
  `id` varchar(20) NOT NULL,
  `pass` varchar(20) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `reg_date` datetime DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `gender` varchar(5) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `address` varchar(30) DEFAULT NULL,
  `phone` int(11) DEFAULT NULL,
  `mobile` int(12) DEFAULT NULL,
  `postcode` varchar(20) DEFAULT NULL,
  `address2` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` VALUES ('123','123','123','2017-04-05 17:19:17',123,'man','',NULL,NULL,NULL,NULL,NULL),('12345','','1','2017-02-01 14:19:26',1,'man','1',NULL,NULL,NULL,NULL,NULL),('admin','admin','1','2017-02-02 11:42:22',1,'man','1',NULL,NULL,NULL,NULL,NULL),('bb','bb','bb',NULL,NULL,NULL,'bb@bb','bb',2,2,NULL,NULL),('boy','boypass',NULL,NULL,NULL,NULL,'boy@n.com','boyboyboy',1111111111,1234,NULL,NULL),('id','pass','name','2017-03-22 17:24:29',NULL,NULL,'mail@mail','부산 부산진구 거제대로 1',518956079,1084561287,'47215','3동'),('l','1','11','2017-03-23 16:12:24',NULL,NULL,'1@1.com',NULL,0,0,NULL,NULL),('psw607me@naver.com','s524w526*','박성우','2017-05-11 11:53:21',28,'man','psw607me@naver.com',NULL,NULL,NULL,NULL,NULL),('sadlkfj','lksajdfkj','ksam','2017-01-26 13:37:42',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('testman','test','박','2017-02-01 14:21:23',2,'man','test@test','서울 도봉구 노해로 133',1111,1050356077,'01370','tt'),('woohyeok','wowo','우혁',NULL,NULL,NULL,'mail@mail.com',NULL,0,0,NULL,NULL),('ㄷㄷ','ee','ㄷㄷ','2017-03-22 11:53:50',NULL,NULL,'ee@ee',NULL,2,2,NULL,'ee'),('ㅂㅂ','qq','ㅂㅂ','2017-03-22 12:05:07',NULL,NULL,'qq@qq','부산 남구 유엔평화로10번길 28',123,123,'48493','qq'),('ㅅㅅ','tt','ㅅㅅ',NULL,NULL,NULL,'tt@tt',NULL,515786232,1084561287,NULL,'234'),('유재석','dbwotjr','유재석',NULL,NULL,NULL,'db@db',NULL,0,0,NULL,NULL);
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reply`
--

DROP TABLE IF EXISTS `reply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reply` (
  `num` int(11) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `pass` varchar(20) DEFAULT NULL,
  `re_con` varchar(200) DEFAULT NULL,
  `re_ref` int(11) NOT NULL,
  `re_lev` int(11) DEFAULT NULL,
  `re_seq` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`num`,`re_ref`),
  CONSTRAINT `num_fk` FOREIGN KEY (`num`) REFERENCES `board` (`num`) ON DELETE CASCADE,
  CONSTRAINT `num_up` FOREIGN KEY (`num`) REFERENCES `board` (`num`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reply`
--

LOCK TABLES `reply` WRITE;
/*!40000 ALTER TABLE `reply` DISABLE KEYS */;
INSERT INTO `reply` VALUES (24,'eee','eee','sadfsafsaf',5,0,0,'2017-03-23'),(24,'eee','eee','zvzsdfe',6,0,0,'2017-03-23'),(24,'eee','eee','ㅇㅊㄴㅁㅇㅊㅇㄴㅇㅊㄴㅁㅇㅊㅇㄴㅇㅊㄴㅁㅇㅊㅇㄴㅇㅊㄴㅁㅇㅊㅇㄴㅇㅊㄴㅁㅇㅊㅇㄴㅇㅊㄴㅁㅇㅊㅇㄴㅇㅊㄴㅁㅇㅊㅇㄴㅇㅊㄴㅁㅇㅊㅇㄴㅇㅊㄴㅁㅇㅊㅇㄴㅇㅊㄴㅁㅇㅊㅇㄴㅇㅊㄴㅁㅇㅊㅇㄴㅇㅊㄴㅁㅇㅊㅇㄴ',7,0,0,'2017-03-23'),(24,'eee','eee','ㅇㅊㄴㅁㅇㅊㅇㄴㅇㅊㄴㅁㅇㅊㅇㄴㅇㅊㄴㅁㅇㅊㅇㄴㅇㅊㄴㅁㅇㅊㅇㄴㅇㅊㄴㅁㅇㅊㅇㄴㅇㅊㄴㅁㅇㅊㅇㄴㅇㅊㄴㅁㅇㅊㅇㄴㅇㅊㄴㅁㅇㅊㅇㄴㅇㅊㄴㅁㅇㅊㅇㄴㅇㅊㄴㅁㅇㅊㅇㄴㅇㅊㄴㅁㅇㅊㅇㄴㅇㅊㄴㅁㅇㅊㅇㄴ',8,0,0,'2017-03-23'),(24,'eee','eee','xvcxcv',9,0,0,'2017-03-23'),(39,'testman','test','dfgfdgdfg',1,0,0,'2017-03-31');
/*!40000 ALTER TABLE `reply` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `num` int(11) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,'홍길동'),(2,'김길동'),(4,'산투스'),(4,'기운찬'),(10,'선가드'),(7,'도롱뇽'),(8,'디기리'),(9,'너무핵'),(11,'꼬북꼬북');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-05-11 12:07:35
