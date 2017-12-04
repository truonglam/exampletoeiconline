CREATE DATABASE  IF NOT EXISTS `toeiconline` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `toeiconline`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: toeiconline
-- ------------------------------------------------------
-- Server version	5.7.14-log

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
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comment` (
  `commentid` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` text,
  `userid` bigint(20) DEFAULT NULL,
  `listenguidelineid` bigint(20) DEFAULT NULL,
  `createddate` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`commentid`),
  KEY `fk_user_comment` (`userid`),
  KEY `fk_listenguidline_comment` (`listenguidelineid`),
  CONSTRAINT `fk_listenguidline_comment` FOREIGN KEY (`listenguidelineid`) REFERENCES `listenguideline` (`listenguidelineid`),
  CONSTRAINT `fk_user_comment` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `examination`
--

DROP TABLE IF EXISTS `examination`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `examination` (
  `examinationid` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `createddate` timestamp NULL DEFAULT NULL,
  `modifieddate` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`examinationid`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `examination`
--

LOCK TABLES `examination` WRITE;
/*!40000 ALTER TABLE `examination` DISABLE KEYS */;
INSERT INTO `examination` VALUES (1,'Bài thi 1','2017-12-03 03:25:56',NULL);
/*!40000 ALTER TABLE `examination` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `examinationquestion`
--

DROP TABLE IF EXISTS `examinationquestion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `examinationquestion` (
  `examinationquestionid` bigint(20) NOT NULL AUTO_INCREMENT,
  `image` varchar(255) DEFAULT NULL,
  `audio` varchar(255) DEFAULT NULL,
  `question` text,
  `paragraph` text,
  `option1` varchar(300) DEFAULT NULL,
  `option2` varchar(300) DEFAULT NULL,
  `option3` varchar(300) DEFAULT NULL,
  `option4` varchar(300) DEFAULT NULL,
  `correctanswer` varchar(10) DEFAULT NULL,
  `examinationid` bigint(20) NOT NULL,
  `createddate` timestamp NULL DEFAULT NULL,
  `modifieddate` timestamp NULL DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`examinationquestionid`),
  KEY `fk_examinationquestion_examination` (`examinationid`),
  CONSTRAINT `fk_examinationquestion_examination` FOREIGN KEY (`examinationid`) REFERENCES `examination` (`examinationid`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `examinationquestion`
--

LOCK TABLES `examinationquestion` WRITE;
/*!40000 ALTER TABLE `examinationquestion` DISABLE KEYS */;
INSERT INTO `examinationquestion` VALUES (55,'examination/image_1.jpg','examination/audio_1.mp3','Look at the picture and listen to the sentences in the Part 1 TOEIC Test. Choose the sentence that best describes the picture:',NULL,'A. The man is diving into the water','B. The man is fishing from the railing','C. The man is packing up his fishing gear','D. The man is purchasing some fish','A',1,'2017-12-03 17:06:29',NULL,'PHOTO'),(56,'examination/image_2.jpg','examination/audio_2.mp3','Look at the picture and listen to the sentences in the Part 1 TOEIC Test. Choose the sentence that best describes the picture:',NULL,'A. The man is diving into the water','B. The man is fishing from the railing','C. The man is packing up his fishing gear','D. The man is purchasing some fish','B',1,'2017-12-03 17:06:29',NULL,'PHOTO'),(57,NULL,'examination/audio_3.mp3','Look at the picture and listen to the sentences in the Part 1 TOEIC Test. Choose the sentence that best describes the picture:',NULL,'A. The man is diving into the water','B. The man is fishing from the railing','C. The man is packing up his fishing gear','D. The man is purchasing some fish','B',1,'2017-12-03 17:06:29',NULL,'QUESTION_RESPONSE'),(58,NULL,'examination/audio_4.mp3','Listen to the question and the three responses. Choose the response that best answers the question:',NULL,'A. The man is diving into the water','B. The man is fishing from the railing','C. The man is packing up his fishing gear','D. The man is purchasing some fish','A',1,'2017-12-03 17:06:29',NULL,'QUESTION_RESPONSE'),(59,NULL,NULL,'Read the passage and choose the correct answer:','Eli Finance, the largest real estate financier in the Middle East by market value and total assets, today proudly announced that it received the award for the “Best Financial Services Company in the UAE” during the 2008 Liquid Real Estate Awards ceremony organized by Euromoney. Euromoney Liquid Real Estate Awards honor the world’s leading institutions for their ability to innovate and develop new products and services to meet the market’s demand in today’s increasingly challenging financial environment, as well as make the most efficient use of the inherent strengths within their organization. Speaking on the occasion, Mr. Ismael Alharmi, Chief Executive Officer of Eli Finance said, “We are honored to receive this prestigious award and I would like to thank our staff at Eli for their efforts',NULL,NULL,NULL,NULL,NULL,1,'2017-12-03 17:06:29',NULL,'SINGLE_PASSAGE'),(60,NULL,NULL,'What is the subject of the news report?',NULL,'A. A national park','B. A local zoo','C. Commercial products','D. Landscaping land','B',1,'2017-12-03 17:06:29',NULL,'SINGLE_PASSAGE'),(61,NULL,NULL,'According to the speaker, what does Algonquin National Park have?',NULL,'A. Unique rock formations','B. A lot of different animals','C. Unusual potted plants','D. Beautiful waterfalls','A',1,'2017-12-03 17:06:29',NULL,'SINGLE_PASSAGE'),(62,NULL,NULL,'What do some people expect will happen?',NULL,'A. The wildlife will relocate','B. It will increase local business',' C. New homes will be built','D. They will change their minds','B',1,'2017-12-03 17:06:29',NULL,'SINGLE_PASSAGE');
/*!40000 ALTER TABLE `examinationquestion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exercise`
--

DROP TABLE IF EXISTS `exercise`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `exercise` (
  `exerciseid` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `createddate` timestamp NULL DEFAULT NULL,
  `modifieddate` timestamp NULL DEFAULT NULL,
  `type` varchar(45) NOT NULL,
  PRIMARY KEY (`exerciseid`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exercise`
--

LOCK TABLES `exercise` WRITE;
/*!40000 ALTER TABLE `exercise` DISABLE KEYS */;
INSERT INTO `exercise` VALUES (1,'Bài tập nghe 1','2017-11-28 17:19:29',NULL,'listening'),(2,'Bài tập đọc 1','2017-11-28 17:19:29',NULL,'reading');
/*!40000 ALTER TABLE `exercise` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exercisequestion`
--

DROP TABLE IF EXISTS `exercisequestion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `exercisequestion` (
  `exercisequestionid` bigint(20) NOT NULL AUTO_INCREMENT,
  `image` varchar(255) DEFAULT NULL,
  `audio` varchar(255) DEFAULT NULL,
  `question` text NOT NULL,
  `option1` varchar(300) NOT NULL,
  `option2` varchar(300) NOT NULL,
  `option3` varchar(300) NOT NULL,
  `option4` varchar(300) NOT NULL,
  `correctanswer` varchar(10) NOT NULL,
  `exerciseid` bigint(20) NOT NULL,
  `createddate` timestamp NULL DEFAULT NULL,
  `modifieddate` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`exercisequestionid`),
  KEY `fk_exercisequestion_exercise` (`exerciseid`),
  CONSTRAINT `fk_exercisequestion_exercise` FOREIGN KEY (`exerciseid`) REFERENCES `exercise` (`exerciseid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exercisequestion`
--

LOCK TABLES `exercisequestion` WRITE;
/*!40000 ALTER TABLE `exercisequestion` DISABLE KEYS */;
INSERT INTO `exercisequestion` VALUES (1,'exercise/image_1.jpg','exercise/audio_1.mp3','Look at the picture and listen to the sentences in the Part 1 TOEIC Test. Choose the sentence that best describes the picture:','A','B','C','D','A',1,'2017-11-28 17:19:35',NULL),(2,'exercise/image_2.jpg','exercise/audio_2.mp3','Look at the picture and listen to the sentences in the Part 1 TOEIC Test. Choose the sentence that best describes the picture:','A','B','C','D','B',1,'2017-11-28 17:19:35',NULL),(3,'exercise/image_3.jpg','exercise/audio_3.mp3','Look at the picture and listen to the sentences in the Part 1 TOEIC Test. Choose the sentence that best describes the picture:','A','B','C','D','C',1,'2017-11-28 17:19:35',NULL),(4,'exercise/image_4.jpg','exercise/audio_4.mp3','Look at the picture and listen to the sentences in the Part 1 TOEIC Test. Choose the sentence that best describes the picture:','A','B','C','D','D',1,'2017-11-28 17:19:35',NULL),(5,NULL,NULL,'I dont think he will remember the appointment you remind him.','so','if','unless','lest','C',2,'2017-11-28 17:19:35',NULL),(6,NULL,NULL,'The river has overflowed his banks _____ it has been raining continuously for several days.','still','yet','when','as','D',2,'2017-11-28 17:19:35',NULL),(7,NULL,NULL,'Those village folk are poor _____ they always seem so contented.','still','yet','when','as','C',2,'2017-11-28 17:19:35',NULL),(8,NULL,NULL,'he was not interested in music, he agreed to go to the concert.','still','yet','when','as','A',2,'2017-11-28 17:19:35',NULL);
/*!40000 ALTER TABLE `exercisequestion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `listenguideline`
--

DROP TABLE IF EXISTS `listenguideline`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `listenguideline` (
  `listenguidelineid` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL,
  `image` varchar(100) NOT NULL,
  `content` text NOT NULL,
  `createddate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `modifieddate` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`listenguidelineid`),
  UNIQUE KEY `title` (`title`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `listenguideline`
--

LOCK TABLES `listenguideline` WRITE;
/*!40000 ALTER TABLE `listenguideline` DISABLE KEYS */;
INSERT INTO `listenguideline` VALUES (36,'REVIEW ĐỀ THI TOEIC IIG NGÀY 19/03/2015 by Ms Hiền Nhung','listenguideline\\image_4.jpg','<p><img alt=\"\" src=\"http://localhost:8080/ckfinder/core/connector/java/connector.java?command=Thumbnail&amp;type=Images&amp;currentFolder=%2F&amp;langCode=en&amp;hash=f9a65f6271336a0&amp;FileName=listenguideline_1.jpg\" style=\"height:200px; width:200px\" /></p>\r\n\r\n<p><strong>REVIEW ĐỀ THI TOEIC IIG NG&Agrave;Y 19/03/2015</strong><br />\r\n<br />\r\n<br />\r\n<strong><u>1. Part 1: 6 tranh tả người, 4 tranh tả vật&nbsp;</u></strong><br />\r\n<br />\r\nC&aacute;c bức tranh đều l&agrave; những bối cảnh th&acirc;n thuộc như trong c&aacute;c cuốn&nbsp;<a href=\"http://mshoatoeic.com/\">luyện thi toeic</a>&nbsp;của trung t&acirc;m mshoatoeic, cụ thể:<br />\r\n+ Bức tranh 2 người đang di chuyển 1 chiếc b&agrave;n đi nơi kh&aacute;c ( they are moving the table)<br />\r\n+ Tranh 2 người ngồi đối diện nhau nh&igrave;n nhau ( they are looking at each other)<br />\r\n+ 1 người đ&agrave;n &ocirc;ng đứng trong nh&agrave; h&agrave;ng, xung quanh kh&ocirc;ng c&oacute; người chỉ c&oacute; b&agrave;n ghế được xếp ngăn nắp<br />\r\n+ 5, 6 người ngồi quanh 1 c&aacute;i b&agrave;n<br />\r\n+ 1 người đ&agrave;n &ocirc;ng đang sửa ống nước tr&ecirc;n đường ( changing pipes)<br />\r\n+ T&agrave;u chuẩn bị v&agrave;o ga, ga ko c&oacute; người<br />\r\n+ 3 Xe đỗ b&ecirc;n đường trước d&atilde;y nh&agrave;, kh&ocirc;ng c&oacute; c&acirc;y cối xung quanh.<br />\r\n+ M&aacute;y t&iacute;nh/ hộp v&agrave; c&aacute;c đồ thiết bị kh&aacute;c được xếp tr&ecirc;n kệ<br />\r\n<strong><u>Note:</u></strong>&nbsp;Ch&uacute; &yacute; bẫy tả vật trong tranh c&oacute; người xuất hiện, cụ thể với bức tranh người đ&agrave;n &ocirc;ng đứng trong nh&agrave; h&agrave;ng, c&acirc;u mi&ecirc;u tả đ&uacute;ng lại mi&ecirc;u tả c&aacute;ch sắp xếp b&agrave;n ghế:&nbsp; chairs are arranged around the table.<br />\r\n<br />\r\n<br />\r\n<strong><u>2. Part 2:</u></strong><br />\r\n<br />\r\n- Phần 2 vẫn chứng tỏ l&agrave; 1 phần khoai với đa số c&aacute;c th&iacute; sinh: Kh&aacute; nhiều Wh-question (khoảng 15-17) bao gồm cả hỏi trực tiếp v&agrave; c&acirc;u hỏi dạng gi&aacute;n tiếp ẩn dưới c&acirc;u hỏi dạng yes/no questions. Đ&aacute;ng ch&uacute; &yacute; l&agrave; c&oacute; kh&aacute; nhiều c&acirc;u hỏi How long, how many v&agrave; who. &nbsp;Statement&nbsp; kh&aacute; nhiều khoảng 5-6 c&acirc;u. c&aacute;c loại Yes/ No + Negative question , Choice questions, tags , suggestion (why don&rsquo;t you, would you like &hellip;(movies + drinks) ) v&agrave; request&nbsp; ( can you) mỗi loại c&oacute; khoảng 3-4 c&acirc;u.<br />\r\n- C&aacute;c c&acirc;u hỏi kh&ocirc;ng qu&aacute; d&agrave;i. Chỉ c&oacute; khoảng 4-5 c&acirc;u thuộc nửa sau (đặc biệt l&agrave; c&acirc;u hỏi choice questions)&nbsp; mức độ kh&oacute; tăng l&ecirc;n v&agrave; cũng d&agrave;i hơn, nhưng c&oacute; thể loại trừ được một số đ&aacute;p &aacute;n trả lời cho loại c&acirc;u hỏi kh&aacute;c. Cụ thể: When (bẫy For + time, bẫy c&acirc;u trả lời của where ), why don&rsquo;t you (that&rsquo;s a great idea), would you like... C&oacute; nhiều c&acirc;u &nbsp;&ldquo;xơi lu&ocirc;n&rdquo; &nbsp;cho một số dạng c&acirc;u hỏi như dạng I don&rsquo;t know: &ldquo;Ask &hellip;.&rdquo;, &ldquo;It doesn&rsquo;t matter to me&rdquo;, &ldquo;Either would be good..&rdquo;, &ldquo;I&rsquo;ll take care of it&hellip;&rdquo;<br />\r\n<br />\r\n<strong><u>Note:</u></strong><br />\r\n- Rất nhiều bẫy similar sound v&agrave; family word. V&agrave; c&aacute;c bẫy kh&aacute;c như từ associated words (where do you&nbsp;<strong>store&nbsp;</strong>the document? &ndash; I buy some&nbsp;<strong>foods</strong>&hellip;. ) đ&aacute;nh bẫy những bạn kh&ocirc;ng bắt kịp từ để hỏi.<br />\r\n<br />\r\n&nbsp;<br />\r\n<strong><u>3. Part 3</u></strong><br />\r\n<br />\r\n- 10 đoạn đều l&agrave; Man vs Woman. Vẫn nhắc học sinh đặc biệt ch&uacute; &yacute; lượt n&oacute;i của từng người v&agrave; đọc kĩ c&acirc;u hỏi để xem lời của &ldquo;man&rdquo; hay &ldquo;woman&rdquo;. Trước khi nghe nhất thiết phải đọc trước c&acirc;u hỏi để x&aacute;c định Keyword v&agrave; đ&aacute;p &aacute;n để ph&acirc;n biệt được sự kh&aacute;c nhau Kh&ocirc;ng t&ocirc; k&iacute;n đ&aacute;p &aacute;n ngay m&agrave; chỉ n&ecirc;n khoanh nhẹ để d&agrave;nh thời gian đọc c&acirc;u hỏi tiếp theo.<br />\r\n- Nội dung gồm c&aacute;c vấn đề như: hai nh&acirc;n vi&ecirc;n trao đổi c&ocirc;ng việc, 2 nh&acirc;n vi&ecirc;n trao đổi về việc tham dự 1 triển l&atilde;m v&agrave; người phụ nữ quyết định đi tham dự v&igrave; deadline dc d&atilde;n ra, cuộc n&oacute;i chuyện trong ph&ograve;ng kh&aacute;m răng, cuộc n&oacute;i chuyện giữa nh&acirc;n vi&ecirc;n b&aacute;n h&agrave;ng v&agrave; kh&aacute;ch li&ecirc;n quan đến việc đổi h&agrave;ng h&oacute;a đ&atilde; mua,..)<br />\r\n- Dạng c&acirc;u hỏi về Location v&agrave; Occupation chiếm 6-7 c&acirc;u. C&aacute;c bối cảnh: hỏi đường đến 1 t&ograve;a nh&agrave; tr&ecirc;n đường, library, restaurant, office, clothes store,... job:&nbsp; interviewee, dentist,&hellip;<br />\r\n-&nbsp; Dạng c&acirc;u hỏi về topic&nbsp; chiếm 4-5 c&acirc;u (li&ecirc;n quan đến: chuẩn bị cho bữa tiệc &nbsp;sinh nhật của 1 th&agrave;nh vi&ecirc;n trong c&ocirc;ng ty, thay đổi trong 1 kế hoạch, hỏi đường, tham dự art exhibition,&hellip; )<br />\r\n- C&aacute;c c&acirc;u hỏi when như when do they meet? When did the meeting start? Kh&aacute; nhiều, l&agrave; những c&acirc;u ăn điểm cho c&aacute;c th&iacute; sinh v&igrave; hầu như kh&ocirc;ng c&oacute; bẫy m&agrave; nghe được chọn được lu&ocirc;n, kh&ocirc;ng c&oacute; nhiều con số được nhắc đến để đ&aacute;nh bẫy.<br />\r\n<br />\r\n<strong><u>Note:</u></strong><br />\r\n- Nửa sau của part 3 độ kh&oacute; tăng cao hơn; &nbsp;Những c&acirc;u trả lời c&oacute; thể nằm ở ngay 1 v&agrave;i gi&acirc;y đầu ti&ecirc;n n&ecirc;n cần chuẩn bị tinh thần thật kĩ. Ch&uacute; &yacute; đọc v&agrave; nắm bắt kĩ nội dung c&acirc;u hỏi v&agrave; th&ocirc;ng tin do ai n&oacute;i v&igrave; c&oacute; thể c&acirc;u trả lời cho c&acirc;u sau đến trước c&acirc;u trước l&agrave;m c&aacute;c th&iacute; sinh l&uacute;ng t&uacute;ng.<br />\r\n<br />\r\n&nbsp;<br />\r\n<strong><u>4. Part 4:</u></strong>&nbsp;&nbsp;Đủ c&aacute;c format được học, cụ thể:<br />\r\n<br />\r\n<strong>- Recorded message&nbsp;</strong>(1 anh nh&acirc;n vi&ecirc;n đi c&ocirc;ng t&aacute;c để lại hướng dẫn nếu cần li&ecirc;n lạc gấp th&igrave; để lại số điện thoại v&agrave; t&ecirc;n, hỏi l&yacute; do kh&ocirc;ng nhận được cuộc gọi, người n&oacute;i c&oacute; khả năng l&agrave;m g&igrave;)<br />\r\n<strong>- voice message&nbsp; (&nbsp;</strong>nh&acirc;n vi&ecirc;n c&ocirc;ng ty gọi cho kh&aacute;ch h&agrave;ng về order của kh&aacute;ch , gợi &yacute; chuyển sang 1 order kh&aacute;c để kh&ocirc;ng phải đợi l&acirc;u- y&ecirc;u cầu gọi lại để x&aacute;c nhận<strong>)&nbsp;</strong><br />\r\n<strong>- report ( bản tin giao th&ocirc;ng:&nbsp;</strong>đường sửa, sửa trong bao l&acirc;u bắt đầu từ khi n&agrave;o v&agrave; khuy&ecirc;n người&nbsp; nghe đi đường kh&aacute;c, hỏi thời gian ph&aacute;t s&oacute;ng bản tin, ai l&agrave; John&hellip; );<strong>&nbsp;(bản tin thời tiết:&nbsp;</strong>Dự b&aacute;o thời tiết, người nghe được khuy&ecirc;n l&agrave; n&ecirc;n l&agrave;m g&igrave; ( mang &ocirc; đi, thời tiết ng&agrave;y mai ra sao?)<br />\r\n<strong>- Speech (</strong>Giới thiệu một speaker, hỏi nghề nghiệp, topic của b&agrave;i ph&aacute;t biểu, sự kiện g&igrave; diễn ra tiếp theo)<br />\r\n<strong>- Announcement&nbsp;&nbsp;</strong>( li&ecirc;n quan đến ho&atilde;n kế hoạch sửa văn ph&ograve;ng c&ocirc;ng ty sang 1 ng&agrave;y kh&aacute;c v&igrave; đội sửa chữa chưa l&agrave;m xong ở 1 khu vực kh&aacute;c của c&ocirc;ng ty, nh&acirc;n vi&ecirc;n được khuy&ecirc;n dọn văn ph&ograve;ng để chuẩn bị sẵn cho việc sơn sửa)<br />\r\n<strong>- Meeting</strong>&nbsp;(T&igrave;nh h&igrave;nh sản phẩm c&ocirc;ng ty, intended audience l&agrave; ai, n&ecirc;n l&agrave;m g&igrave; để tăng doanh thu..)<br />\r\n<strong>- Tour&nbsp;</strong>(đi sở th&uacute;, lịch tr&igrave;nh tour, th&ocirc;ng b&aacute;o khu vực thăm quan chuồng hổ đang đ&oacute;ng cửa để l&agrave;m sạch n&ecirc;n sẽ kh&ocirc;ng đi tham quan khu vực đ&oacute;)<br />\r\n<br />\r\n<strong><u>Note:</u></strong>&nbsp;Nh&igrave;n chung, ở phần n&agrave;y c&aacute;c bạn th&iacute; sinh chỉ cần đọc kĩ trước c&acirc;u hỏi, nắm bắt thể loại v&agrave; tập trung nghe l&agrave; sẽ ăn điểm.<br />\r\n<br />\r\n<br />\r\n<strong><u>5. Part 5 and 6:</u></strong><br />\r\n<br />\r\nĐ&aacute;nh gi&aacute; chung cho đề thi part 5 , 6 s&aacute;ng 19/03 l&agrave; kh&ocirc;ng&nbsp; kh&oacute;, kh&ocirc;ng đ&aacute;nh đố, &iacute;t c&acirc;u hỏi về từ vựng. C&aacute;c chủ điểm ngữ ph&aacute;p được test bao gồm:<br />\r\n<strong>- Li&ecirc;n từ&nbsp;</strong>( although, furthermore, On the contrary,&nbsp; not only but also&hellip;..)<br />\r\n<strong>- Đại từ&nbsp;</strong>(they, their, đại từ quan hệ ( who, whom)<strong>&hellip;).&nbsp;</strong>Khoảng 5, 6 c&acirc;u kiểm tra về đại từ, thuộc loại dễ v&agrave; ăn sẵn cho th&iacute; sinh.<br />\r\n<strong>- Danh từ (</strong>khi chọn danh từ ch&uacute; &yacute; số &iacute;t số nhiều: Invitations, technical description, purpose, extension,&hellip;)<br />\r\n<strong>- Adj:&nbsp;</strong>rising rent, pleasing cent; so s&aacute;nh nhất : the most successful so far,&hellip;<br />\r\n<strong>- Giới từ&nbsp;</strong>(throughout, in, regardless of&hellip;)<br />\r\n<strong>- Adv:&nbsp;</strong>ko c&oacute; nhiều, c&acirc;u hỏi đơn giản, ch&uacute; &yacute; c&aacute;c adv ưa chuộm : promply, approximately, quickly,&hellip; chủ yếu test vị tr&iacute; của ADV: trước Adj, sau V (gồm c&aacute;c vị tr&iacute; be &hellip; Pii, &hellip;Adj, has/have &hellip; Pii).<br />\r\n- C&aacute;c cấu tr&uacute;c ngữ ph&aacute;p ( be about to V,&hellip;)<br />\r\n<br />\r\n<br />\r\n<strong><u>6. Part 7:</u></strong><br />\r\n<br />\r\n<br />\r\n- C&oacute; thể đ&aacute;nh gi&aacute; part 7 của b&agrave;i thi lần n&agrave;y kh&aacute; kh&oacute; với c&aacute;c th&iacute; sinh. Rất nhiều b&agrave;i đọc quảng c&aacute;o , article, review v&agrave; announcement độ d&agrave;i c&aacute;c b&agrave;i đọc vừa phải, kh&ocirc;ng qu&aacute; d&agrave;i.<br />\r\n<br />\r\n- Chỉ c&oacute; 1 c&acirc;u hỏi về nghĩa của từ trong c&acirc;u ( từ &ldquo;served&rdquo; ở paragraph 3 line 2 nghĩa l&agrave; j? ở đ&acirc;y đồng nghĩa &ldquo;worked as&rdquo;&hellip;); C&oacute; khoảng 5,6&nbsp; c&acirc;u hỏi &ldquo;Not&rdquo;.<br />\r\n<br />\r\n+ 1 article th&ocirc;ng b&aacute;o về việc nghỉ hưu của 1 cựu nh&acirc;n vi&ecirc;n c&ocirc;ng ty. Kể th&agrave;nh tựa của &ocirc;ng n&agrave;y trong c&ocirc;ng ty với việc lead 1 đội team ph&aacute;t triển 1 d&ograve;ng sản phẩm linh kiện m&aacute;y t&iacute;nh nổi tiếng. &Ocirc;ng n&agrave;y về hưu vẫn c&ograve;n nhiều dự định: l&agrave;m việc tại nh&agrave;, viết s&aacute;ch, tham gia c&aacute;c tổ chức x&atilde; hội.<br />\r\n+ 1 Email: thư mời l&agrave;m việc (offer letter) &ndash; hỏi vị tr&iacute;, được cung cấp ph&uacute;c lợi những g&igrave; &hellip;.<br />\r\n+ 1 advertisement cho 1 tổ chức l&agrave;m từ thiện muốn đăng tuyển th&ecirc;m t&igrave;nh nguyện vi&ecirc;n.<br />\r\n+ 1 th&ocirc;ng b&aacute;o tuyển th&agrave;nh vi&ecirc;n v&agrave; quảng c&aacute;o lợi &iacute;ch của việc đăng k&iacute; l&agrave;m th&agrave;nh vi&ecirc;n của 1 vườn c&acirc;y thực vật cảnh.<br />\r\n+ Double mess: 1 b&agrave;i article về 1 cuộc thi d&agrave;nh cho c&aacute;c c&ocirc;ng ty ng&agrave;nh đồ uống, th&ocirc;ng b&aacute;o c&ocirc;ng ty c&oacute; d&ograve;ng sản phẩm đoạt giải nhất, đưa nhận x&eacute;t của 1 chuy&ecirc;n gia về sự&nbsp; thịnh h&agrave;nh của loại đồ ăn thức uống mới. &ndash; 1 b&agrave;i review về sản phẩm v&agrave; c&ocirc;ng ty đoạt giải nhất &agrave; C&aacute;c c&acirc;u hỏi li&ecirc;n quan đến th&agrave;nh phần tham dự cuộc thi, sản phẩm n&agrave;o c&ocirc;ng ty đoạt giải nhất kh&ocirc;ng sản xuất, c&acirc;u hỏi infer từ lời nhận x&eacute;t của chuy&ecirc;n gia.<br />\r\n<br />\r\n-&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Double mess: 1 th&ocirc;ng b&aacute;o tuyển dụng nh&acirc;n vi&ecirc;n do mở rộng chi nh&aacute;nh của 1 c&ocirc;ng ty- 1 letter hỏi về c&aacute;c th&ocirc;ng tin li&ecirc;n quan đến vị tr&iacute; tuyển dụng. &agrave;&nbsp; Hỏi trụ sở của c&ocirc;ng ty, c&aacute;c y&ecirc;u cầu tuyển dụng, v&agrave; th&ocirc;ng tin li&ecirc;n quan đến c&ocirc;ng việc &ldquo;kh&ocirc;ng&rdquo; được hỏi đến trong phần letter.<br />\r\n<br />\r\n-&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Double mess: 1 b&agrave;i b&aacute;o th&ocirc;ng b&aacute;o chậm khởi chiếu phim do cần thay thế 1 diễn vi&ecirc;n ch&iacute;nh trong phim &ndash; 1 review film: khen sự kh&eacute;o l&eacute;o của đạo diễn đ&atilde; chuyển thể t&aacute;c phẩm văn học đầu tay của ch&iacute;nh m&igrave;nh l&ecirc;n phim. &agrave; hỏi t&ecirc;n diễn vi&ecirc;n thay thế, t&aacute;c phẩn văn học thứ mấy của đạo diễn, người viết review khẳng định điều g&igrave; về bộ phim,&hellip;<br />\r\n<br />\r\n-&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Double mess: 1 thư th&ocirc;ng b&aacute;o ho&atilde;n meeting giữa 2 c&ocirc;ng ty v&agrave; re-schedule &ndash; 1 thư trả lời từ chối ko theo dc schedule mới v&agrave; đ&iacute;nh k&egrave;m th&ecirc;m t&agrave;i liệu được y&ecirc;u cầu.</p>\r\n','2017-11-27 15:36:14','2017-11-27 15:48:09'),(37,'Unit 24: Phân biệt Just as, When, While, As soon as, Until','listenguideline\\listenguideline_2.png','<p><strong>WHAT</strong></p>\r\n\r\n<p>- Ch&uacute;ng ta sử dụng when + th&igrave; hiện tại để nối kết c&aacute;c sự kiện m&agrave; chắc chắn hoặc rất c&oacute; thể xảy ra trong tương lai.<br />\r\n<br />\r\nWhen I get back, I&rsquo;ll tell you all about my trip.<br />\r\n<br />\r\nI&rsquo;ll cook dinner when I get home.<br />\r\n<br />\r\n- Ch&uacute;ng ta sử dụng when + th&igrave; qu&aacute; khứ để&nbsp;nối kết c&aacute;c sự kiện m&agrave; đ&atilde; xảy ra trong qu&aacute; khứ.<br />\r\n<br />\r\nWhen I saw the pollution in the city, I was very disappointed.<br />\r\n<br />\r\nI screamed when the man grabbed my arm.</p>\r\n\r\n<p>&nbsp;</p>\r\n\r\n<p><strong>JUST AS</strong></p>\r\n\r\n<p>- Ch&uacute;ng ta sử dụng just as để n&oacute;i về 2 h&agrave;nh động hoặc sự kiện ngắn m&agrave; đ&atilde; xảy ra gần ch&iacute;nh x&aacute;c c&ugrave;ng thời điểm.<br />\r\n<br />\r\nThe bus pulled away from the bus stop just as I arrived!<br />\r\n<br />\r\nIt started to rain just as we left.</p>\r\n\r\n<p>&nbsp;</p>\r\n\r\n<p><strong>WHILE</strong></p>\r\n\r\n<p>- Ch&uacute;ng ta sử dụng while để diễn tả 2 h&agrave;nh động hoặc sự kiện d&agrave;i m&agrave; đ&atilde; đang xảy ra v&agrave;o thời điểm c&ugrave;ng với nhau một c&aacute;ch ch&iacute;nh x&aacute;c.<br />\r\n<br />\r\nWhile I was talking on the phone, they were calling for all passengers to board the bus to the beach.<br />\r\n<br />\r\nThere were lots of people trying to sell me things while I was waiting for the bus.</p>\r\n\r\n<p>&nbsp;</p>\r\n\r\n<p>&nbsp;</p>\r\n\r\n<p>&nbsp;</p>\r\n\r\n<p><strong>UNTIL</strong></p>\r\n\r\n<p>- Ch&uacute;ng ta sử dụng until hoặc till để đếm số lượng thời gian đến 1 sự kiện tương lai &ndash; th&ocirc;ng thường 1 sự kiện m&agrave; quan trọng hoặc ch&uacute;ng ta hồi hộp về n&oacute;.<br />\r\n<br />\r\nIt&rsquo;s only 2 months until my summer vacation.<br />\r\n<br />\r\nThere are only 3 weeks till the wedding. I need to buy a present.<br />\r\n<br />\r\nIt&rsquo;s only 5 minutes until the game starts. You&rsquo;d better hurry up if you want to see it!<br />\r\n<br />\r\nCh&uacute;ng ta sử dụng until v&agrave; till để diễn tả 1 khoảng thời gian từ cột mốc n&agrave;y đến cột mốc kh&aacute;c.<br />\r\n<br />\r\nI had to wait from 9:00 in the morning till 3:00 in the afternoon for the next bus.<br />\r\n<br />\r\nWe have class from 8:00 until 10:00.<br />\r\n<br />\r\nGhi ch&uacute; rằng till l&agrave; c&aacute;ch ngắn đến n&oacute;i until. Bạn c&oacute; thể sử dụng ch&uacute;ng thay đổi với nhau, mặc d&ugrave; until th&igrave; trang trọng hơn 1 ch&uacute;t.</p>\r\n\r\n<p>&nbsp;</p>\r\n\r\n<p>&nbsp;</p>\r\n\r\n<p>&nbsp;</p>\r\n\r\n<p><strong>AS SOON AS</strong></p>\r\n\r\n<p>&nbsp;</p>\r\n\r\n<p>&nbsp;</p>\r\n\r\n<p>- Ch&uacute;ng ta sử dụng as soon as để diễn tả 1 h&agrave;nh động m&agrave; đ&atilde; được thực hiện ngay tức th&igrave; sau 1 h&agrave;nh động kh&aacute;c trong qu&aacute; khứ.<br />\r\n<br />\r\nI called Mom as soon as I arrived to let her know that I was ok. (T&ocirc;i đ&atilde; đến nơi. T&ocirc;i gọi điện cho Mẹ ngay lập tức).<br />\r\n<br />\r\nCh&uacute;ng ta cũng sử dụng as soon as để diễn tả 1 h&agrave;nh động m&agrave; sẽ được thực hiện ngay tức th&igrave; sau 1 h&agrave;nh động kh&aacute;c trong tương lai.<br />\r\n<br />\r\nI&rsquo;ll call you as soon as I get home. (T&ocirc;i sẽ về nh&agrave;. T&ocirc;i sẽ gọi bạn ngay lập tức.)</p>\r\n','2017-11-24 17:48:51','2017-11-27 15:41:38'),(38,'Unit 23: Từ vựng theo chủ đề - TOEIC Listening&Reading; (phần 4)','listenguideline\\listenguideline_3.jpg','<p><strong>Chủ đề: C&aacute;c kĩ năng trong c&ocirc;ng việc</strong></p>\r\n\r\n<p><br />\r\n- communication skills: kĩ năng giao tiếp<br />\r\n- teamwork skills: kĩ năng l&agrave;m việc nh&oacute;m<br />\r\n- negotiation skills: kĩ năng thương thuyết<br />\r\n- event management skills: kĩ năng quản l&iacute; sự kiện<br />\r\n- problem-solving skills: kĩ năng giải quyết vấn đề<br />\r\n- public-speaking skills: kĩ năng n&oacute;i trước đ&aacute;m đ&ocirc;ng<br />\r\n- computer skills/ PC skills: c&aacute;c kĩ năng vi t&iacute;nh<br />\r\n- Internet Users Skills: kĩ năng sử dụng c&aacute;c ứng dụng tr&ecirc;n mạng<br />\r\n- Time management skills: kĩ năng quản l&iacute; thời gian<br />\r\n- Presentation skills: kĩ năng thuyết tr&igrave;nh<br />\r\n- Decision-making skills: kĩ năng đưa ra quyết định<br />\r\n- Sales skills: kĩ năng b&aacute;n h&agrave;ng</p>\r\n\r\n<p>&nbsp;</p>\r\n\r\n<p><strong>Chủ đề: Chứng chỉ v&agrave; bằng cấp</strong><br />\r\n&nbsp;</p>\r\n\r\n<p>- Qualifications: bằng cấp n&oacute;i chung.<br />\r\n- Bachelor&rsquo;s degree: bằng đại học<br />\r\n- Master&rsquo;s Degree: bằng thạc sĩ<br />\r\n- Doctoral&nbsp; degree: bằng tiến sĩ<br />\r\n- High school Diploma: bằng tốt nghiệp cấp 3<br />\r\n- Certificate: chứng chỉ (cho kh&oacute;a học ngắn hoặc c&aacute;c k&igrave; thi ngoại ngữ quốc tế)<br />\r\n&nbsp;</p>\r\n\r\n<p>&nbsp;</p>\r\n\r\n<p>&nbsp;</p>\r\n\r\n<p><strong>Chủ đề: Lương v&agrave; ph&uacute;c lợi&nbsp;</strong></p>\r\n\r\n<p><br />\r\n- income: thu nhập<br />\r\n- salary : lương (thường chỉ lương theo th&aacute;ng)<br />\r\n- wage: tiền c&ocirc;ng (theo giờ)<br />\r\n- compensation: th&ugrave; lao, tiền bồi thường c&ocirc;ng t&aacute;c<br />\r\n- pension: tiền trợ cấp, lương hưu<br />\r\n-pay raise: sự tăng lương<br />\r\n- bonus: tiền thưởng<br />\r\n<br />\r\n<em>Shared by Ms Thiện Minh - Hyperactive Messenger</em></p>\r\n','2017-11-24 17:49:20',NULL),(39,'Unit 22: Từ vựng theo chủ đề - TOEIC Listening (phần 3)','listenguideline\\listenguideline_4.png','<p><strong>Chủ đề: Văn ph&ograve;ng phẩm</strong></p>\r\n\r\n<p><br />\r\n1. Paper clips&nbsp;&ndash; ghim giấy<br />\r\n2. Stapler&nbsp;&ndash; dập ghim<br />\r\n3. Highlighter&nbsp;&ndash; b&uacute;t nhớ d&ograve;ng<br />\r\n4. Correction pen &ndash; B&uacute;t x&oacute;a<br />\r\n5. Adhesive tape&nbsp;&ndash; Băng d&iacute;nh<br />\r\n6. Calculator&nbsp;&ndash; M&aacute;y t&iacute;nh bỏ t&uacute;i<br />\r\n7. Marker&nbsp;&ndash; B&uacute;t viết bảng<br />\r\n8. Telephone &ndash; điện thoại để b&agrave;n<br />\r\n9. Computer &ndash; m&aacute;y vi t&iacute;nh<br />\r\n10. Envelope &ndash; phong b&igrave;<br />\r\n11. File cabinet &ndash; tủ đựng t&agrave;i liệu<br />\r\n12. Printer &ndash; m&aacute;y in<br />\r\n13. Photocopier &ndash; m&aacute;y photo<br />\r\n14. Projector &ndash; m&aacute;y chiếu</p>\r\n\r\n<p>&nbsp;</p>\r\n\r\n<p>&nbsp;</p>\r\n\r\n<p><strong>Chủ đề: Ph&ograve;ng ban, chức vụ trong m&ocirc;i trường c&ocirc;ng sở</strong></p>\r\n\r\n<p><br />\r\n1.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; CEO&nbsp;(Chief Executive Officer): gi&aacute;m đốc điều h&agrave;nh.<br />\r\n2.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Chairman/&nbsp;President: chủ tịch<br />\r\n3.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Vice president: ph&oacute; chủ tịch<br />\r\n4.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; CFO (Chief financial officer): gi&aacute;m đốc t&agrave;i ch&iacute;nh<br />\r\n5.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Board&nbsp;l&agrave; từ chỉ to&agrave;n thể c&aacute;c directors&nbsp;v&agrave; họ họp ở ph&ograve;ng gọi l&agrave; boardroom.<br />\r\n6.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Manager: quản l&yacute;<br />\r\n7.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Reception: Lễt&acirc;n<br />\r\n8.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Officer: Nh&acirc;n vi&ecirc;n văn ph&ograve;ng<br />\r\n9.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; C&aacute;c ph&ograve;ng ban: Department/ Division<br />\r\n&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;a.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Personnel/ Human Resources Department: Ph&ograve;ng nh&acirc;n sự<br />\r\n&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;b.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Marketing Department: Ph&ograve;ng Marketing<br />\r\n&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;c.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Sales Department: Ph&ograve;ng kinh doanh<br />\r\n&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;d.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; R &amp; D Department (Research and Development): Ph&ograve;ng nghi&ecirc;n cứu v&agrave; ph&aacute;t triển<br />\r\n&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;e.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Customer Service Department: Ph&ograve;ng dịch vụ kh&aacute;ch h&agrave;ng<br />\r\n<br />\r\n<em>Shared by Ms Ho&agrave;ng Anh - Shining Smile Messenger</em></p>\r\n','2017-11-24 17:49:46',NULL);
/*!40000 ALTER TABLE `listenguideline` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `result`
--

DROP TABLE IF EXISTS `result`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `result` (
  `resultid` bigint(20) NOT NULL AUTO_INCREMENT,
  `listenscore` int(11) NOT NULL,
  `readingscore` int(11) NOT NULL,
  `examinationid` bigint(20) NOT NULL,
  `userid` bigint(20) NOT NULL,
  `createddate` timestamp NULL DEFAULT NULL,
  `modifieddate` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`resultid`),
  KEY `fk_result_examination` (`examinationid`),
  KEY `fk_result_user` (`userid`),
  CONSTRAINT `fk_result_examination` FOREIGN KEY (`examinationid`) REFERENCES `examination` (`examinationid`),
  CONSTRAINT `fk_result_user` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `result`
--

LOCK TABLES `result` WRITE;
/*!40000 ALTER TABLE `result` DISABLE KEYS */;
INSERT INTO `result` VALUES (23,4,0,1,4,'2017-12-04 08:09:01',NULL),(24,4,3,1,4,'2017-12-04 08:23:30',NULL),(25,0,0,1,4,'2017-12-04 08:24:56',NULL);
/*!40000 ALTER TABLE `result` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `roleid` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`roleid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ADMIN'),(2,'USER');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `userid` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `fullname` varchar(300) DEFAULT NULL,
  `createddate` timestamp NULL DEFAULT NULL,
  `roleid` bigint(20) NOT NULL,
  PRIMARY KEY (`userid`),
  UNIQUE KEY `name` (`name`),
  KEY `FK_USER_ROLE_idx` (`roleid`),
  CONSTRAINT `FK_USER_ROLE` FOREIGN KEY (`roleid`) REFERENCES `role` (`roleid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (3,'admin','123456','admin','2017-08-02 22:09:43',1),(4,'truongtunglam','123456','trương tùng lâm ',NULL,2),(6,'ronaldo2','456789','ronaldo2',NULL,2),(7,'abc','123456','abc','2017-09-02 02:51:42',1),(12,'jspservlet3','123458','jspservlet3','2017-09-11 21:25:13',2),(13,'jspservlet5','123460','jspservlet5','2017-09-11 21:25:24',2),(14,'vanthidoantrang','123456','văn thị đoan trang','2017-11-13 02:42:19',2);
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

-- Dump completed on 2017-12-04 15:32:35
