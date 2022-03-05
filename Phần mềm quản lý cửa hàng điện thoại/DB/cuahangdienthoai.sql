-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: quanlybanhang
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
-- Table structure for table `tblchitiethoadon`
--

DROP TABLE IF EXISTS `tblchitiethoadon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblchitiethoadon` (
  `machitietHD` int NOT NULL,
  `maHD` int NOT NULL,
  `maSP` int DEFAULT NULL,
  `tenSP` varchar(45) DEFAULT NULL,
  `soluong` int DEFAULT NULL,
  `thanhtien` float DEFAULT NULL,
  PRIMARY KEY (`machitietHD`,`maHD`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblchitiethoadon`
--

LOCK TABLES `tblchitiethoadon` WRITE;
/*!40000 ALTER TABLE `tblchitiethoadon` DISABLE KEYS */;
INSERT INTO `tblchitiethoadon` VALUES (1,1000,145237,'Coca Cola chai lớn',1,20000),(1,1001,145234,'Coca Cola lon thường',2,16000),(1,1002,148653,'Mì Tôm Hảo Hảo lẩu thái',1,4000),(1,1003,145237,'Coca Cola chai lớn',2,40000),(1,1004,145237,'Coca Cola chai lớn',1,20000),(1,1005,145236,'Coca Cola chai nhỏ',5,40000),(1,1006,146232,'Bim Bim Tony phomai',3,21000),(1,1007,146352,'Bim Bim Khoai Tây',2,12000),(1,1008,145235,'Coca Cola lon cao',3,36000),(1,1009,145235,'Coca Cola lon cao',2,24000),(2,1000,146352,'Bim Bim Khoai Tây',1,6000),(2,1002,145237,'Coca Cola chai lớn',1,20000),(2,1003,146232,'Bim Bim Tony phomai',4,28000),(2,1004,146352,'Bim Bim Khoai Tây',1,6000),(2,1005,146233,'Bim Bim Tony gà BBQ',2,14000),(2,1006,146233,'Bim Bim Tony gà BBQ',1,7000),(3,1000,148653,'Mì Tôm Hảo Hảo lẩu thái',2,8000),(3,1004,147369,'Dầu gội đầu X-men',2,60000),(3,1005,148653,'Mì Tôm Hảo Hảo lẩu thái',2,8000);
/*!40000 ALTER TABLE `tblchitiethoadon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblchitietnhaphang`
--

DROP TABLE IF EXISTS `tblchitietnhaphang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblchitietnhaphang` (
  `machitietHD` int NOT NULL,
  `maHD` int NOT NULL,
  `maSP` int DEFAULT NULL,
  `tenSP` varchar(45) DEFAULT NULL,
  `soluong` int DEFAULT NULL,
  `thanhtien` float DEFAULT NULL,
  PRIMARY KEY (`machitietHD`,`maHD`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblchitietnhaphang`
--

LOCK TABLES `tblchitietnhaphang` WRITE;
/*!40000 ALTER TABLE `tblchitietnhaphang` DISABLE KEYS */;
INSERT INTO `tblchitietnhaphang` VALUES (1,1000,145234,'Coca Cola lon thường',20,120000),(1,1001,146352,'Bim Bim Khoai Tây',3,12000),(1,1002,146233,'Bim Bim Tony gà BBQ',10,50000),(1,1003,146233,'Bim Bim Tony gà BBQ',5,25000),(1,1004,146232,'Bim Bim Tony phomai',15,75000),(1,1005,145237,'Coca Cola chai lớn',20,300000),(1,1006,145237,'Coca Cola chai lớn',20,300000),(2,1000,145237,'Coca Cola chai lớn',15,225000),(2,1001,146232,'Bim Bim Tony phomai',6,30000),(2,1002,146352,'Bim Bim Khoai Tây',20,80000),(2,1003,148664,'Mì Tôm Ba Miền gà nấm',20,80000),(2,1005,146233,'Bim Bim Tony gà BBQ',4,20000),(3,1000,146352,'Bim Bim Khoai Tây',10,40000),(3,1001,145234,'Coca Cola lon thường',2,12000),(3,1002,145234,'Coca Cola lon thường',20,120000),(3,1003,148664,'Mì Tôm Ba Miền gà nấm',30,120000),(3,1005,147368,'Dầu gội đầu Clear',21,420000);
/*!40000 ALTER TABLE `tblchitietnhaphang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblchitietxuatkho`
--

DROP TABLE IF EXISTS `tblchitietxuatkho`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblchitietxuatkho` (
  `machitietHD` int NOT NULL,
  `maHD` int NOT NULL,
  `maSP` int DEFAULT NULL,
  `tenSP` varchar(45) DEFAULT NULL,
  `soluong` int DEFAULT NULL,
  `thanhtien` float DEFAULT NULL,
  PRIMARY KEY (`machitietHD`,`maHD`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblchitietxuatkho`
--

LOCK TABLES `tblchitietxuatkho` WRITE;
/*!40000 ALTER TABLE `tblchitietxuatkho` DISABLE KEYS */;
INSERT INTO `tblchitietxuatkho` VALUES (1,1000,146232,'Bim Bim Tony phomai',20,100000),(1,1001,145234,'Coca Cola lon thường',20,120000),(1,1002,145237,'Coca Cola chai lớn',20,300000),(1,1003,145236,'Coca Cola chai nhỏ',10,60000),(1,1004,145236,'Coca Cola chai nhỏ',20,120000),(2,1000,147369,'Dầu gội đầu X-men',10,200000),(2,1001,145235,'Coca Cola lon cao',5,40000),(2,1002,146352,'Bim Bim Khoai Tây',7,28000),(2,1003,146232,'Bim Bim Tony phomai',20,100000),(2,1004,148653,'Mì Tôm Hảo Hảo lẩu thái',5,15000),(3,1000,148663,'Mì Tôm Ba Miền chua cay',20,80000),(3,1001,145236,'Coca Cola chai nhỏ',10,60000),(3,1002,148652,'Mì Tôm Hảo Hảo chua cay',30,90000),(3,1003,148653,'Mì Tôm Hảo Hảo lẩu thái',6,18000),(3,1004,148653,'Mì Tôm Hảo Hảo lẩu thái',22,66000),(4,1001,145237,'Coca Cola chai lớn',6,90000),(4,1002,148663,'Mì Tôm Ba Miền chua cay',30,120000),(5,1001,146233,'Bim Bim Tony gà BBQ',12,60000),(5,1002,148664,'Mì Tôm Ba Miền gà nấm',20,80000),(6,1001,146352,'Bim Bim Khoai Tây',10,40000),(7,1001,147368,'Dầu gội đầu Clear',5,100000),(8,1001,148652,'Mì Tôm Hảo Hảo chua cay',5,15000),(9,1001,148653,'Mì Tôm Hảo Hảo lẩu thái',8,24000),(10,1001,148664,'Mì Tôm Ba Miền gà nấm',9,36000);
/*!40000 ALTER TABLE `tblchitietxuatkho` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblhoadon`
--

DROP TABLE IF EXISTS `tblhoadon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblhoadon` (
  `maHD` int NOT NULL,
  `maNV` int DEFAULT NULL,
  `ngaytao` date DEFAULT NULL,
  `tongtien` float DEFAULT NULL,
  PRIMARY KEY (`maHD`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblhoadon`
--

LOCK TABLES `tblhoadon` WRITE;
/*!40000 ALTER TABLE `tblhoadon` DISABLE KEYS */;
INSERT INTO `tblhoadon` VALUES (1000,999999999,'2020-07-13',34000),(1001,999999999,'2020-07-13',16000),(1002,999999999,'2020-07-13',24000),(1003,999999999,'2020-07-18',68000),(1004,999999999,'2020-07-18',86000),(1005,145871784,'2020-07-18',62000),(1006,145871784,'2020-07-18',28000),(1007,999999999,'2020-07-22',12000),(1008,999999999,'2020-07-22',36000),(1009,999999999,'2020-07-22',24000);
/*!40000 ALTER TABLE `tblhoadon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblnhanvien`
--

DROP TABLE IF EXISTS `tblnhanvien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblnhanvien` (
  `idNV` int NOT NULL,
  `hovaten` varchar(45) DEFAULT NULL,
  `diachi` varchar(45) DEFAULT NULL,
  `ngaysinh` date DEFAULT NULL,
  `sdt` int DEFAULT NULL,
  `taikhoan` varchar(45) NOT NULL,
  `matkhau` varchar(45) NOT NULL,
  `vitri` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idNV`,`taikhoan`),
  UNIQUE KEY `idNV_UNIQUE` (`idNV`),
  UNIQUE KEY `taikhoan_UNIQUE` (`taikhoan`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblnhanvien`
--

LOCK TABLES `tblnhanvien` WRITE;
/*!40000 ALTER TABLE `tblnhanvien` DISABLE KEYS */;
INSERT INTO `tblnhanvien` VALUES (145871784,'Ngô Quốc Ân','Thanh Xuân Hà Nội','1999-11-16',386126392,'ngoquocan','ngoquocan','Thu ngân'),(145871856,'Trần Tuấn Anh','Hà Đông Hà Nội','1999-07-05',378621257,'trantuananh','trantuananh','Kho'),(145872963,'Chu Bá Nghĩa','Cầu Giấy Hà Nội','1999-03-15',912345678,'chubanghia','chubanghia','Kho'),(145875632,'Đoàn Xuân Phi','Thanh Xuân Hà Nội','1999-07-20',987654321,'doanxuanphi','doanxuanphi','Thu ngân'),(147985362,'Hoàng Tùng Lâm','Hà Đông Hà Nội','1999-07-15',322446688,'hoangtunglam','hoangtunglam','Thu ngân'),(157683924,'Hoàng Mạnh Hùng','Đống Đa Hà Nội','1999-09-18',811335577,'hoangmanhhung','hoangmanhhung','Kho'),(2063028256,'phamquocchien','VietNam','2002-04-09',889655542,'chienpq','chienpq','Thu ngân');
/*!40000 ALTER TABLE `tblnhanvien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblnhaphang`
--

DROP TABLE IF EXISTS `tblnhaphang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblnhaphang` (
  `maHD` int NOT NULL,
  `maNV` int DEFAULT NULL,
  `ngaytao` date DEFAULT NULL,
  `tongtien` float DEFAULT NULL,
  PRIMARY KEY (`maHD`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblnhaphang`
--

LOCK TABLES `tblnhaphang` WRITE;
/*!40000 ALTER TABLE `tblnhaphang` DISABLE KEYS */;
INSERT INTO `tblnhaphang` VALUES (1000,999999999,'2020-07-12',385000),(1001,999999999,'2020-07-12',54000),(1002,999999999,'2020-07-18',250000),(1003,145871856,'2020-07-18',225000),(1004,999999999,'2020-07-22',75000),(1005,999999999,'2020-07-22',740000),(1006,999999999,'2020-08-02',300000);
/*!40000 ALTER TABLE `tblnhaphang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblsanpham`
--

DROP TABLE IF EXISTS `tblsanpham`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblsanpham` (
  `maSP` int NOT NULL,
  `tenSP` varchar(45) DEFAULT NULL,
  `nhomSP` varchar(45) DEFAULT NULL,
  `gianhap` float DEFAULT NULL,
  `giaban` float DEFAULT NULL,
  `ngaySX` date DEFAULT NULL,
  `hanSD` date DEFAULT NULL,
  `soluong` int DEFAULT NULL,
  `soluongtrenke` int DEFAULT NULL,
  PRIMARY KEY (`maSP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblsanpham`
--

LOCK TABLES `tblsanpham` WRITE;
/*!40000 ALTER TABLE `tblsanpham` DISABLE KEYS */;
INSERT INTO `tblsanpham` VALUES (145234,'Coca Cola lon thường','Hàng gia dụng',6000,8000,'2020-07-01','2021-01-01',70,18),(145235,'Coca Cola lon cao','Hàng gia dụng',8000,12000,'2020-07-01','2021-01-01',35,0),(145236,'Coca Cola chai nhỏ','Hàng gia dụng',6000,8000,'2020-07-01','2021-01-01',30,20),(145237,'Coca Cola chai lớn','Hàng gia dụng',15000,20000,'2020-07-01','2021-01-01',90,19),(146232,'Bim Bim Tony phomai','Hàng gia dụng',5000,7000,'2020-06-30','2020-10-30',116,33),(146233,'Bim Bim Tony gà BBQ','Hàng gia dụng',5000,7000,'2020-06-30','2020-10-30',108,9),(146352,'Bim Bim Khoai Tây','Hàng gia dụng',4000,6000,'2020-06-30','2020-10-30',90,4),(147365,'Pepsi chai to','Hàng tiêu dùng',10000,20000,'2020-06-02','2022-06-02',0,0),(147367,'Pepsi lon cao','Hàng tiêu dùng',5000,10000,'2020-06-02','2022-06-02',0,0),(147368,'Dầu gội đầu Clear','Hàng tiêu dùng',20000,30000,'2020-05-20','2022-08-20',85,5),(147369,'Dầu gội đầu X-men','Hàng tiêu dùng',25000,30000,'2020-06-20','2021-06-20',121,8),(148652,'Mì Tôm Hảo Hảo chua cay','Hàng gia dụng',3000,4000,'2020-06-20','2021-01-20',65,30),(148653,'Mì Tôm Hảo Hảo lẩu thái','Hàng gia dụng',3000,4000,'2020-06-20','2021-01-20',63,34),(148663,'Mì Tôm Ba Miền chua cay','Hàng gia dụng',4000,5000,'2020-06-20','2021-01-20',150,30),(148664,'Mì Tôm Ba Miền gà nấm','Hàng gia dụng',4000,5000,'2020-06-20','2021-01-20',122,20),(1234455,'sdfsd','Hàng gia dụng',232312,2432430,'2021-12-12','2022-01-12',0,0);
/*!40000 ALTER TABLE `tblsanpham` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblxuatkho`
--

DROP TABLE IF EXISTS `tblxuatkho`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblxuatkho` (
  `maHD` int NOT NULL,
  `maNV` int DEFAULT NULL,
  `ngaytao` date DEFAULT NULL,
  `tongtien` float DEFAULT NULL,
  PRIMARY KEY (`maHD`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblxuatkho`
--

LOCK TABLES `tblxuatkho` WRITE;
/*!40000 ALTER TABLE `tblxuatkho` DISABLE KEYS */;
INSERT INTO `tblxuatkho` VALUES (1000,999999999,'2020-07-12',380000),(1001,999999999,'2020-07-12',585000),(1002,999999999,'2020-07-18',618000),(1003,999999999,'2020-07-18',178000),(1004,145871856,'2020-07-18',201000);
/*!40000 ALTER TABLE `tblxuatkho` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-12 19:16:38
