-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: localhost    Database: quanlycaphe
-- ------------------------------------------------------
-- Server version	8.0.39

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
-- Table structure for table `chitietban`
--

DROP TABLE IF EXISTS `chitietban`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chitietban` (
  `MAHDBH` varchar(10) NOT NULL,
  `MASP` varchar(10) NOT NULL,
  `SOLUONGBAN` int DEFAULT NULL,
  PRIMARY KEY (`MAHDBH`,`MASP`),
  KEY `MASP` (`MASP`),
  CONSTRAINT `chitietban_ibfk_1` FOREIGN KEY (`MAHDBH`) REFERENCES `hoadonbanhang` (`MAHDBH`),
  CONSTRAINT `chitietban_ibfk_2` FOREIGN KEY (`MASP`) REFERENCES `sanpham` (`MASP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chitietban`
--

LOCK TABLES `chitietban` WRITE;
/*!40000 ALTER TABLE `chitietban` DISABLE KEYS */;
INSERT INTO `chitietban` VALUES ('HDBH01','SP01',2),('HDBH01','SP02',1),('HDBH02','SP03',2);
/*!40000 ALTER TABLE `chitietban` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chitietnhap`
--

DROP TABLE IF EXISTS `chitietnhap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chitietnhap` (
  `MAHDNH` varchar(10) NOT NULL,
  `MANL` varchar(10) NOT NULL,
  `SOLUONGNHAP` int DEFAULT NULL,
  PRIMARY KEY (`MAHDNH`,`MANL`),
  KEY `MANL` (`MANL`),
  CONSTRAINT `chitietnhap_ibfk_1` FOREIGN KEY (`MAHDNH`) REFERENCES `hoadonnhaphang` (`MAHDNH`),
  CONSTRAINT `chitietnhap_ibfk_2` FOREIGN KEY (`MANL`) REFERENCES `nguyenlieu` (`MANL`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chitietnhap`
--

LOCK TABLES `chitietnhap` WRITE;
/*!40000 ALTER TABLE `chitietnhap` DISABLE KEYS */;
INSERT INTO `chitietnhap` VALUES ('HDNH01','NL01',10),('HDNH01','NL02',20),('HDNH02','NL03',15);
/*!40000 ALTER TABLE `chitietnhap` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hoadonbanhang`
--

DROP TABLE IF EXISTS `hoadonbanhang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hoadonbanhang` (
  `MAHDBH` varchar(10) NOT NULL,
  `THOIGIAN` datetime DEFAULT NULL,
  `TONGTIEN` decimal(10,2) DEFAULT NULL,
  `MANV` varchar(10) DEFAULT NULL,
  `MAKH` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`MAHDBH`),
  KEY `MANV` (`MANV`),
  KEY `MAKH` (`MAKH`),
  CONSTRAINT `hoadonbanhang_ibfk_1` FOREIGN KEY (`MANV`) REFERENCES `nhanvien` (`MANV`),
  CONSTRAINT `hoadonbanhang_ibfk_2` FOREIGN KEY (`MAKH`) REFERENCES `khachhang` (`SDTKH`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hoadonbanhang`
--

LOCK TABLES `hoadonbanhang` WRITE;
/*!40000 ALTER TABLE `hoadonbanhang` DISABLE KEYS */;
INSERT INTO `hoadonbanhang` VALUES ('HDB001','2025-04-02 14:00:27',500000.00,'NV01','1234567890'),('HDBH01','2024-03-26 08:30:00',60000.00,'NV02','0912345678'),('HDBH02','2024-03-26 09:45:00',65000.00,'NV02','0965432187');
/*!40000 ALTER TABLE `hoadonbanhang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hoadonnhaphang`
--

DROP TABLE IF EXISTS `hoadonnhaphang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hoadonnhaphang` (
  `MAHDNH` varchar(10) NOT NULL,
  `THOIGIAN` datetime DEFAULT NULL,
  `THANHTIEN` decimal(10,2) DEFAULT NULL,
  `MANV` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`MAHDNH`),
  KEY `MANV` (`MANV`),
  CONSTRAINT `hoadonnhaphang_ibfk_1` FOREIGN KEY (`MANV`) REFERENCES `nhanvien` (`MANV`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hoadonnhaphang`
--

LOCK TABLES `hoadonnhaphang` WRITE;
/*!40000 ALTER TABLE `hoadonnhaphang` DISABLE KEYS */;
INSERT INTO `hoadonnhaphang` VALUES ('HDN001','2025-04-02 13:57:39',200000.00,'NV01'),('HDNH01','2024-03-25 14:00:00',220000.00,'NV03'),('HDNH02','2024-03-26 10:00:00',75000.00,'NV03');
/*!40000 ALTER TABLE `hoadonnhaphang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `khachhang`
--

DROP TABLE IF EXISTS `khachhang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `khachhang` (
  `SDTKH` varchar(15) NOT NULL,
  `TENKH` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`SDTKH`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khachhang`
--

LOCK TABLES `khachhang` WRITE;
/*!40000 ALTER TABLE `khachhang` DISABLE KEYS */;
INSERT INTO `khachhang` VALUES ('0321567890','Nguyễn Văn F'),('0912345678','Phạm Minh D'),('0965432187','Hoàng Thị E'),('1234567890','Beo');
/*!40000 ALTER TABLE `khachhang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nguyenlieu`
--

DROP TABLE IF EXISTS `nguyenlieu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nguyenlieu` (
  `MANL` varchar(10) NOT NULL,
  `TENNL` varchar(50) DEFAULT NULL,
  `GIANL` decimal(10,2) DEFAULT NULL,
  `NHACC` varchar(50) DEFAULT NULL,
  `trangthainl` varchar(50) DEFAULT 'Còn',
  PRIMARY KEY (`MANL`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nguyenlieu`
--

LOCK TABLES `nguyenlieu` WRITE;
/*!40000 ALTER TABLE `nguyenlieu` DISABLE KEYS */;
INSERT INTO `nguyenlieu` VALUES ('NL01','Cà phê hạt',150000.00,'Nhà cung cấp A','Còn'),('NL02','Đường',20000.00,'Nhà cung cấp B','Còn'),('NL03','Sữa đặc',50000.00,'Nhà cung cấp C','Còn'),('NL04','Cafe',10000.00,'Cong ty D','Còn'),('NL05','Cafe',10000.00,'Cong ty D','Còn');
/*!40000 ALTER TABLE `nguyenlieu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nhanvien`
--

DROP TABLE IF EXISTS `nhanvien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nhanvien` (
  `MANV` varchar(10) NOT NULL,
  `TENNV` varchar(50) DEFAULT NULL,
  `SDTNV` varchar(15) DEFAULT NULL,
  `GIOITINH` enum('Nam','Nữ') DEFAULT NULL,
  `DIACHI` text,
  `NGAYSINH` date DEFAULT NULL,
  `LUONG` decimal(10,2) DEFAULT NULL,
  `CHUCVU` varchar(50) DEFAULT NULL,
  `TThoatdong` varchar(50) DEFAULT 'Đang làm việc',
  `matkhau` varchar(50) DEFAULT 'Tuandeptrai',
  PRIMARY KEY (`MANV`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhanvien`
--

LOCK TABLES `nhanvien` WRITE;
/*!40000 ALTER TABLE `nhanvien` DISABLE KEYS */;
INSERT INTO `nhanvien` VALUES ('NV01','Nguyễn Văn A','0123456789','Nam','Hà Nội','1990-05-10',12000000.00,'Quản lý','Nghỉ việc','Tuandeptrai'),('NV02','Trần Thị B','0987654321','Nữ','Hồ Chí Minh','1995-08-15',9000000.00,'Nhân viên bán hàng','Đang làm việc','Tuandeptrai'),('NV03','Lê Văn C','0345678912','Nam','Đà Nẵng','1992-11-20',10000000.00,'Nhân viên kho','Đang làm việc','Tuandeptrai'),('NV04','Nguyen Van D','0123456789','Nam','Ha Noi','1990-01-01',5000000.00,'Quan ly','Đang làm việc','Tuandeptrai'),('NV05','Nguyen Van E','0123456789','Nam','Ha Noi','1990-01-01',5000000.00,'Quan ly','Đang làm việc','Tuandeptrai');
/*!40000 ALTER TABLE `nhanvien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sanpham`
--

DROP TABLE IF EXISTS `sanpham`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sanpham` (
  `MASP` varchar(10) NOT NULL,
  `TENSP` varchar(50) DEFAULT NULL,
  `GIASP` decimal(10,2) DEFAULT NULL,
  `trangthaisp` varchar(50) DEFAULT 'Đang bán',
  PRIMARY KEY (`MASP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sanpham`
--

LOCK TABLES `sanpham` WRITE;
/*!40000 ALTER TABLE `sanpham` DISABLE KEYS */;
INSERT INTO `sanpham` VALUES ('SP01','Cà phê đen',25000.00,'Đang bán'),('SP02','Cà phê sữa',30000.00,'Đang bán'),('SP03','Trà sữa',35000.00,'Hết bán'),('SP04','Cafe',20000.00,'Đang bán'),('SP05','Cafe',20000.00,'Đang bán');
/*!40000 ALTER TABLE `sanpham` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-04-04 14:53:14
