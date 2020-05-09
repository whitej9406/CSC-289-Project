-- --------------------------------------------------------
-- Host:                         localhost
-- Server version:               10.4.6-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for csc-289
CREATE DATABASE IF NOT EXISTS `csc-289` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `csc-289`;

-- Dumping structure for table csc-289.console
CREATE TABLE IF NOT EXISTS `console` (
  `consoleID` int(12) NOT NULL,
  `consoleName` varchar(50) NOT NULL,
  `price` decimal(10,0) NOT NULL,
  `developer` varchar(50) NOT NULL,
  `manufacturer` varchar(50) NOT NULL,
  `type` varchar(50) NOT NULL,
  `releaseDate` date NOT NULL,
  `mediaType` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table csc-289.console: ~0 rows (approximately)
DELETE FROM `console`;
/*!40000 ALTER TABLE `console` DISABLE KEYS */;
/*!40000 ALTER TABLE `console` ENABLE KEYS */;

-- Dumping structure for table csc-289.customer
CREATE TABLE IF NOT EXISTS `customer` (
  `userID` int(12) NOT NULL,
  `userName` varchar(12) NOT NULL,
  `userPass` varchar(20) NOT NULL,
  `firstName` varchar(50) NOT NULL,
  `lastName` varchar(50) NOT NULL,
  `emailAddress` varchar(50) NOT NULL,
  `address` varchar(50) NOT NULL,
  `telephoneNum` varchar(10) NOT NULL,
  `dateBirth` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table csc-289.customer: ~0 rows (approximately)
DELETE FROM `customer`;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;

-- Dumping structure for table csc-289.game
CREATE TABLE IF NOT EXISTS `game` (
  `gameID` int(12) NOT NULL,
  `gameName` varchar(50) NOT NULL,
  `genre` varchar(50) NOT NULL,
  `platform` varchar(50) NOT NULL,
  `developer` varchar(50) NOT NULL,
  `publisher` varchar(50) NOT NULL,
  `series` varchar(50) NOT NULL,
  `price` decimal(10,0) NOT NULL,
  `releaseDate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table csc-289.game: ~0 rows (approximately)
DELETE FROM `game`;
/*!40000 ALTER TABLE `game` DISABLE KEYS */;
/*!40000 ALTER TABLE `game` ENABLE KEYS */;

-- Dumping structure for table csc-289.order
CREATE TABLE IF NOT EXISTS `order` (
  `orderID` int(12) NOT NULL,
  `orderDate` date NOT NULL,
  `orderTotal` decimal(10,0) NOT NULL,
  `shipDate` date NOT NULL,
  `orderName` varchar(50) NOT NULL,
  `shipAddress` varchar(50) NOT NULL,
  `billAdrress` varchar(50) NOT NULL,
  `orderQty` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table csc-289.order: ~0 rows (approximately)
DELETE FROM `order`;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
/*!40000 ALTER TABLE `order` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
