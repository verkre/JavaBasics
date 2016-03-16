-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Erstellungszeit: 16. Mrz 2016 um 15:14
-- Server-Version: 10.1.10-MariaDB
-- PHP-Version: 7.0.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Datenbank: `primeeuler`
--
CREATE DATABASE IF NOT EXISTS `primeeuler` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `primeeuler`;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `eulersolutions`
--

DROP TABLE IF EXISTS `eulersolutions`;
CREATE TABLE `eulersolutions` (
  `uid` int(11) NOT NULL,
  `problemNumber` varchar(5) NOT NULL,
  `problemSolution` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `eulersolutions`
--

INSERT INTO `eulersolutions` (`uid`, `problemNumber`, `problemSolution`) VALUES
(16, '2', '4613732'),
(17, '3', '6857'),
(18, '4', '906609'),
(19, '7', '104743'),
(20, '75', '161667');

--
-- Indizes der exportierten Tabellen
--

--
-- Indizes für die Tabelle `eulersolutions`
--
ALTER TABLE `eulersolutions`
  ADD PRIMARY KEY (`uid`);

--
-- AUTO_INCREMENT für exportierte Tabellen
--

--
-- AUTO_INCREMENT für Tabelle `eulersolutions`
--
ALTER TABLE `eulersolutions`
  MODIFY `uid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
