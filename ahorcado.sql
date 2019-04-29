-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Apr 29, 2019 at 12:21 AM
-- Server version: 5.7.24
-- PHP Version: 7.2.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ahorcado`
--

-- --------------------------------------------------------

--
-- Table structure for table `ganadores`
--

CREATE TABLE `ganadores` (
  `id` int(11) NOT NULL,
  `nombre` varchar(60) NOT NULL,
  `fecha` date NOT NULL,
  `id_palabra` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `palabras`
--

CREATE TABLE `palabras` (
  `id` int(11) NOT NULL,
  `palabra` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `palabras`
--

INSERT INTO `palabras` (`id`, `palabra`) VALUES
(1, 'ave'),
(2, 'pimiento'),
(3, 'roca'),
(4, 'colina'),
(5, 'acuario'),
(6, 'rectangulo'),
(7, 'plata'),
(8, 'corto'),
(9, 'laboratorio'),
(10, 'oso'),
(11, 'anarquia'),
(12, 'asfalto'),
(13, 'camiseta'),
(14, 'nalga'),
(15, 'sorpresa'),
(16, 'desgaste'),
(17, 'pintura'),
(18, 'tablero'),
(19, 'laberinto'),
(20, 'perfume'),
(21, 'helado'),
(22, 'otorrinonaringologo');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `ganadores`
--
ALTER TABLE `ganadores`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_ganadores_palabras` (`id_palabra`);

--
-- Indexes for table `palabras`
--
ALTER TABLE `palabras`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `ganadores`
--
ALTER TABLE `ganadores`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `palabras`
--
ALTER TABLE `palabras`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `ganadores`
--
ALTER TABLE `ganadores`
  ADD CONSTRAINT `fk_ganadores_palabras` FOREIGN KEY (`id_palabra`) REFERENCES `palabras` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
