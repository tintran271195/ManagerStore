-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: product
-- ------------------------------------------------------
-- Server version	8.0.25

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
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `uID` int NOT NULL AUTO_INCREMENT,
  `user` varchar(255) DEFAULT NULL,
  `pass` varchar(255) DEFAULT NULL,
  `isSell` int DEFAULT NULL,
  `isAdmin` int DEFAULT NULL,
  PRIMARY KEY (`uID`),
  UNIQUE KEY `user` (`user`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,'admin','123123',1,1),(2,'Anjolie','SNZ6HE',0,1),(3,'Ferris','RXH3XJ',1,0),(4,'Katell','HWV8ZN',0,0),(5,'tin','1234',1,1),(6,'phong','123456',1,0),(8,'khanh','123456',0,0),(9,'mra','123123',1,1),(10,'Necki','123123',1,1);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `cid` int NOT NULL AUTO_INCREMENT,
  `cname` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cid`),
  UNIQUE KEY `cid_UNIQUE` (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'??i???n Tho???i'),(2,'Laptop'),(3,'SmartWatch'),(4,'Tablet'),(5,'Ph??? Ki???n');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `image` longtext,
  `price` double NOT NULL,
  `title` longtext NOT NULL,
  `description` longtext,
  `cid` int NOT NULL,
  `sellid` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `cid` (`cid`),
  KEY `sellid` (`sellid`),
  CONSTRAINT `product_ibfk_1` FOREIGN KEY (`cid`) REFERENCES `category` (`cid`),
  CONSTRAINT `product_ibfk_2` FOREIGN KEY (`sellid`) REFERENCES `account` (`uID`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (3,'Phong','https://picsum.photos/200',500,'Lang tu','da tinh',2,2),(4,'Huy','https://picsum.photos/200',500,'abc','cba',2,2),(8,'ROG Phone 5 Ultimate','https://www.xtmobile.vn/vnt_upload/product/08_2019/thumbs/600_asus-rog-phone-5-ultimate.jpg',550,'ROG Phone','Ch??i game Si??u c??p vip pro',1,2),(10,'Laptop Asus ROG Zephyrus Duo 15','http://vn-test-11.slatic.net/p/035621487ef727c554f26f767838acf7.jpg_720x720q80.jpg_.webp',2000,'Laptop Asus ROG Zephyrus Duo 15','Laptop m???c vl',2,1),(12,'Apple Watch SE','https://cdn.tgdd.vn/Products/Images/7077/233260/Slider/se-44mm-vien-nhom-day-cao-su-hong-060121-1106163.jpg',400,'Apple Watch','M??u H???ng Nam T??nh',3,1),(13,'Samsung Galaxy Watch Active 2','https://cdn.tgdd.vn/Products/Images/7077/219147/Slider/samsung-galaxy-watch-active-2-40-mm-den-273320-083347.jpg',200,'Samsung Watch','?????ng h??? th??ng minh Samsung Galaxy Watch Active 2 n???i b???t v???i m??n h??nh r???ng 1.2 Inch v???i ????? ph??n gi???i 360 x 360 Pixels v?? m???t k??nh c?????ng l???c gi??p ng?????i ??eo an t??m khi mang ra ngo??i. Giao di???n m???t ?????ng h??? c?? th??? thay ?????i tu??? ?? theo ph??ng c??ch ng?????i d??ng. D??y ??eo Silicone h???n ch??? b??? tr???y x?????c v?? d??? lau kh?? khi ti???p x??c v???i n?????c hay m??? h??i.',3,1),(14,'Huawei Watch Fit','https://cdn.tgdd.vn/Products/Images/7077/227985/Slider/vi-vn-huawei-watch-fit-day-silicone.jpg',50,'Huawei Watch Fit','MadeinChina',1,1),(15,'Xiaomi','https://picsum.photos/200',500,'Xiaomi','MadeinChina',3,1),(22,'Phong','https://cdn.tgdd.vn/Products/Images/7077/227985/Slider/vi-vn-huawei-watch-fit-day-silicone.jpg',110,'phong','phong',3,1),(24,'AVA+ Y68','https://cdn.tgdd.vn/Products/Images/57/241167/ava-plus-y68-den-1-org.jpg',25,'Pin s???c si??u c???p vippro','s???c si??u nhanh si??u mau ch??y',5,1),(26,'???p l??ng galaxy A32','https://cdn.tgdd.vn/Products/Images/60/237921/op-lung-galaxy-a32-nhua-cung-arden-ck-a002-20-2-org.jpg',2,'???p l??ng galaxy A32','Ch??a c?? ????nh gi??',5,1),(27,'Airpod Pro','https://cdn.tgdd.vn/Products/Images/54/236026/airpods-pro-wireless-charge-apple-mwp22-ava-2-org.jpg',200,'Airpod Pro','?????c ??i???m n???i b???t\r\n\r\nThi???t k??? in-ear ho??n to??n m???i v?? ?????c ????o.\r\nT??ch h???p c??ng ngh??? ch???ng ???n ch??? ?????ng (Active Noise Cancellation).\r\nChip H1 m???nh m???, x??? l?? ??m thanh k??? thu???t s??? v???i ????? tr??? g???n nh?? b???ng kh??ng.\r\nNghe nh???c ?????n 4.5 gi??? khi b???t ch???ng ???n, 5 gi??? khi t???t ch???ng ???n.\r\nS??? d???ng song song v???i h???p s???c c?? th??? d??ng ???????c ?????n 24 gi??? nghe nh???c.\r\nH??? tr??? s???c nhanh, cho th???i gian s??? d???ng ?????n 1 gi??? ch??? v???i 5 ph??t s???c.\r\nH???p s???c h??? tr??? s???c kh??ng d??y chu???n Qi, ti???n l???i khi s???c l???i.\r\nTrang b??? chu???n ch???ng n?????c IPX4, b???o v??? tai nghe an to??n d?????i m??a nh??? v?? m??? h??i.\r\nS???n ph???m ch??nh h??ng Apple, nguy??n seal 100%.\r\nL??u ??: Thanh to??n tr?????c khi m??? seal.',5,9),(28,'Shoshana Goodwin','https://cdn.tgdd.vn/Products/Images/44/237312/Slider/lenovo-ideapad-gaming-3-15imh05-i7-81y4013uvn-1.jpg',981,'Iusto dicta reprehen','Veniam et voluptate',2,1),(29,'Hop Goodwin','Voluptas corrupti q',190,'Voluptatem Nisi sin','Architecto in minima',3,10);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-09  8:34:57
