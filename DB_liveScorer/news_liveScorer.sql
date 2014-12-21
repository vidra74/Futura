-- phpMyAdmin SQL Dump
-- version 4.0.10.6
-- http://www.phpmyadmin.net
--
-- Računalo: localhost
-- Vrijeme generiranja: Pro 21, 2014 u 10:30 PM
-- Verzija poslužitelja: 5.6.21
-- PHP verzija: 5.4.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Baza podataka: `news_liveScorer`
--
CREATE DATABASE IF NOT EXISTS `news_liveScorer` DEFAULT CHARACTER SET utf8 COLLATE utf8_croatian_ci;
USE `news_liveScorer`;

-- --------------------------------------------------------

--
-- Tablična struktura za tablicu `Klub`
--

DROP TABLE IF EXISTS `Klub`;
CREATE TABLE IF NOT EXISTS `Klub` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `IME_KLUBA` varchar(100) CHARACTER SET utf8 COLLATE utf8_croatian_ci NOT NULL,
  `ID_SPORT` int(50) NOT NULL COMMENT 'Klupski sport',
  `ID_SAVEZ` varchar(50) CHARACTER SET utf8 COLLATE utf8_croatian_ci NOT NULL COMMENT 'ID Kluba kod sportskog saveza',
  `ID_LOGO` int(11) NOT NULL COMMENT 'Logo će biti smješten u posebnom spremniku sa ID',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Izbacivanje podataka za tablicu `Klub`
--

INSERT INTO `Klub` (`ID`, `IME_KLUBA`, `ID_SPORT`, `ID_SAVEZ`, `ID_LOGO`) VALUES
(1, 'Špilja 94', 1, '', 0),
(2, 'Danče', 1, '', 0);

-- --------------------------------------------------------

--
-- Tablična struktura za tablicu `Kontakti`
--

DROP TABLE IF EXISTS `Kontakti`;
CREATE TABLE IF NOT EXISTS `Kontakti` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID korisnici',
  `mail` varchar(50) CHARACTER SET utf8 COLLATE utf8_croatian_ci NOT NULL COMMENT 'email za kontakt',
  `mobitel` varchar(15) CHARACTER SET utf8 COLLATE utf8_croatian_ci NOT NULL COMMENT 'mobitel za sms',
  UNIQUE KEY `ID` (`ID`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Izbacivanje podataka za tablicu `Kontakti`
--

INSERT INTO `Kontakti` (`ID`, `mail`, `mobitel`) VALUES
(1, 'fjancic@inet.hr', '00385959025049'),
(2, 'luka.krnetic@net.hr', '0038598358898');

-- --------------------------------------------------------

--
-- Tablična struktura za tablicu `Korisnici`
--

DROP TABLE IF EXISTS `Korisnici`;
CREATE TABLE IF NOT EXISTS `Korisnici` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Ime` varchar(50) CHARACTER SET utf8 COLLATE utf8_croatian_ci NOT NULL,
  `Prezime` varchar(50) CHARACTER SET utf8 COLLATE utf8_croatian_ci NOT NULL,
  `UlogeID` int(11) NOT NULL,
  `Login` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `Password` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Izbacivanje podataka za tablicu `Korisnici`
--

INSERT INTO `Korisnici` (`ID`, `Ime`, `Prezime`, `UlogeID`, `Login`, `Password`) VALUES
(1, 'Frano', 'Jancic', 2, 'frano', 'batina'),
(2, 'Lukša', 'Krnetic', 1, 'luka', 'skywalker');

-- --------------------------------------------------------

--
-- Tablična struktura za tablicu `Sport`
--

DROP TABLE IF EXISTS `Sport`;
CREATE TABLE IF NOT EXISTS `Sport` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `IME_SPORTA` varchar(100) CHARACTER SET utf8 COLLATE utf8_croatian_ci NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

--
-- Izbacivanje podataka za tablicu `Sport`
--

INSERT INTO `Sport` (`ID`, `IME_SPORTA`) VALUES
(1, 'Vaterpolo'),
(2, 'Šah'),
(3, 'Mali Nogomet'),
(4, 'Bridge');

-- --------------------------------------------------------

--
-- Tablična struktura za tablicu `Uloge`
--

DROP TABLE IF EXISTS `Uloge`;
CREATE TABLE IF NOT EXISTS `Uloge` (
  `UID` int(11) NOT NULL AUTO_INCREMENT,
  `Uloga` text CHARACTER SET utf8 COLLATE utf8_croatian_ci NOT NULL,
  PRIMARY KEY (`UID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='Uloge korisnika' AUTO_INCREMENT=4 ;

--
-- Izbacivanje podataka za tablicu `Uloge`
--

INSERT INTO `Uloge` (`UID`, `Uloga`) VALUES
(1, 'Korisnik'),
(2, 'Administrator'),
(3, 'Gost');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
