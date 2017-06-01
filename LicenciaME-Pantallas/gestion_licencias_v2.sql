-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jun 01, 2017 at 11:43 AM
-- Server version: 10.1.19-MariaDB
-- PHP Version: 7.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gestion_licencias_v2`
--

-- --------------------------------------------------------

--
-- Table structure for table `doc_necesaria_titularidad`
--

CREATE TABLE `doc_necesaria_titularidad` (
  `titularidad` int(11) NOT NULL,
  `estructura_propiedad` tinyint(1) NOT NULL,
  `planos_distribucion` tinyint(1) NOT NULL,
  `licencia_anterior` tinyint(1) NOT NULL,
  `numero_expediente` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `persona`
--

CREATE TABLE `persona` (
  `id_persona` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `cif` varchar(15) NOT NULL,
  `direccion` varchar(250) NOT NULL,
  `municipio` varchar(50) NOT NULL,
  `cp` int(11) NOT NULL,
  `tlf_fijo` int(11) NOT NULL,
  `tlf_movil` int(11) NOT NULL,
  `email` varchar(100) NOT NULL,
  `tipo` enum('Física','Jurídica') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `persona`
--

INSERT INTO `persona` (`id_persona`, `nombre`, `cif`, `direccion`, `municipio`, `cp`, `tlf_fijo`, `tlf_movil`, `email`, `tipo`) VALUES
(24, 'Sergio Redondo', '49104206', 'rabida', 'madrid', 28039, 911111111, 620162208, 'sergio@sergio.com', 'Física'),
(25, 'Sergio Redondo', '49104206', 'rabida', 'madrid', 28039, 911111111, 620162208, 'sergio@sergio.com', 'Física'),
(26, 'Sergio Redondo', '49104206', 'rabida', 'madrid', 28039, 911111111, 620162208, 'sergio@sergio.com', 'Física'),
(27, 'Sergio Redondo', '49104206', 'rabida', 'madrid', 28039, 911111111, 620162208, 'sergio@sergio.com', 'Física'),
(28, 'Sergio Redondo', '49104206', 'rabida', 'madrid', 28039, 911111111, 620162208, 'sergio@sergio.com', 'Física'),
(29, 'Sergio Redondo', '49104206', 'rabida', 'madrid', 28039, 911111111, 620162208, 'sergio@sergio.com', 'Física'),
(30, 'Sergio Redondo', '49104206', 'rabida', 'madrid', 28039, 911111111, 620162208, 'sergio@sergio.com', 'Física'),
(31, 'Sergio Redondo', '49104206', 'rabida', 'madrid', 28039, 911111111, 620162208, 'sergio@sergio.com', 'Física'),
(32, 'Sergio Redondo', '49104206', 'rabida', 'madrid', 28039, 911111111, 620162208, 'sergio@sergio.com', 'Física'),
(33, 'Sergio Redondo', '49104206', 'rabida', 'madrid', 28039, 911111111, 620162208, 'sergio@sergio.com', 'Física'),
(34, 'Sergio Redondo', '49104206', 'rabida', 'madrid', 28039, 911111111, 620162208, 'sergio@sergio.com', 'Física'),
(35, 'Sergio Redondo', '49104206', 'rabida', 'madrid', 28039, 911111111, 620162208, 'sergio@sergio.com', 'Física'),
(36, 'Sergio Redondo', '49104206', 'rabida', 'madrid', 28039, 911111111, 620162208, 'sergio@sergio.com', 'Física'),
(37, 'Sergio Redondo', '49104206', 'rabida', 'madrid', 28039, 911111111, 620162208, 'sergio@sergio.com', 'Física'),
(38, 'Sergio Redondo', '49104206', 'rabida', 'madrid', 28039, 911111111, 620162208, 'sergio@sergio.com', 'Física'),
(39, 'Sergio Redondo', '49104206', 'rabida', 'madrid', 28039, 911111111, 620162208, 'sergio@sergio.com', 'Física'),
(40, 'Sergio Redondo', '49104206', 'rabida', 'madrid', 28039, 911111111, 620162208, 'sergio@sergio.com', 'Física'),
(41, 'Sergio Redondo', '49104206', 'rabida', 'madrid', 28039, 911111111, 620162208, 'sergio@sergio.com', 'Física'),
(42, 'Sergio Redondo', '49104206', 'rabida', 'madrid', 28039, 911111111, 620162208, 'sergio@sergio.com', 'Física'),
(43, 'Sergio Redondo', '49104206', 'rabida', 'madrid', 28039, 911111111, 620162208, 'sergio@sergio.com', 'Física'),
(44, 'Sergio Redondo', '49104206', 'rabida', 'madrid', 28039, 911111111, 620162208, 'sergio@sergio.com', 'Física'),
(45, 'Sergio Redondo', '49104206', 'rabida', 'madrid', 28039, 911111111, 620162208, 'sergio@sergio.com', 'Física'),
(46, 'Sergio Redondo', '49104206', 'rabida', 'madrid', 28039, 911111111, 620162208, 'sergio@sergio.com', 'Física'),
(47, 'Sergio Redondo', '49104206', 'rabida', 'madrid', 28039, 911111111, 620162208, 'sergio@sergio.com', 'Física'),
(48, 'Sergio Redondo', '49104206', 'rabida', 'madrid', 28039, 911111111, 620162208, 'sergio@sergio.com', 'Física'),
(49, 'Sergio Redondo', '49104206', 'rabida', 'madrid', 28039, 911111111, 620162208, 'sergio@sergio.com', 'Física'),
(50, 'Sergio Redondo', '49104206', 'rabida', 'madrid', 28039, 911111111, 620162208, 'sergio@sergio.com', 'Física'),
(51, 'Sergio Redondo', '49104206', 'rabida', 'madrid', 28039, 911111111, 620162208, 'sergio@sergio.com', 'Física'),
(52, 'Sergio Redondo', '49104206', 'rabida', 'madrid', 28039, 911111111, 620162208, 'sergio@sergio.com', 'Física'),
(53, 'Sergio Redondo', '49104206', 'rabida', 'madrid', 28039, 911111111, 620162208, 'sergio@sergio.com', 'Física'),
(54, 'Sergio Redondo', '49104206', 'rabida', 'madrid', 28039, 911111111, 620162208, 'sergio@sergio.com', 'Física'),
(55, 'Sergio Redondo', '49104206', 'rabida', 'madrid', 28039, 911111111, 620162208, 'sergio@sergio.com', 'Física'),
(56, 'Sergio Redondo', '49104206', 'rabida', 'madrid', 28039, 911111111, 620162208, 'sergio@sergio.com', 'Física'),
(57, 'tuy', '98', 'hj', 'hbjh', 89, 89, 89, '98', 'Física'),
(58, 'Manuel Blanco', '5558784', 'c/ hola', 'adios', 28240, 918566029, 66659852, 'hol@gl.com', 'Jurídica'),
(59, 'Taysir Alsafir', '666666', 'c/ hola bebe', 'Bebelandia', 28240, 96588745, 666158125, 'tay@gmail.com', 'Jurídica');

-- --------------------------------------------------------

--
-- Table structure for table `representa`
--

CREATE TABLE `representa` (
  `persona` int(11) NOT NULL,
  `representante` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `representa`
--

INSERT INTO `representa` (`persona`, `representante`) VALUES
(58, 19),
(59, 20);

-- --------------------------------------------------------

--
-- Table structure for table `representante`
--

CREATE TABLE `representante` (
  `id_representante` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `nif_nie` varchar(15) NOT NULL,
  `direccion` varchar(250) NOT NULL,
  `municipio` varchar(100) NOT NULL,
  `cp` int(11) NOT NULL,
  `tlf_fijo` int(11) NOT NULL,
  `tlf_movil` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `representante`
--

INSERT INTO `representante` (`id_representante`, `nombre`, `nif_nie`, `direccion`, `municipio`, `cp`, `tlf_fijo`, `tlf_movil`) VALUES
(19, 'Ramses Diez', '52999064', 'c/sobras', 'Hoyo', 28240, 918569898, 666751854),
(20, 'Jorge pico', '1254', 'c/ola', 'adios', 12548, 1547825, 666598856);

-- --------------------------------------------------------

--
-- Table structure for table `solicitud`
--

CREATE TABLE `solicitud` (
  `id_solicitud` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `tipo` enum('Suelo calificado como industrial','Suelo urbano','Casa de ahorro, bancos','Compañias de seguros','Bares, Cafetrias, Restaurantes','Salones recreativos','Establecimientos Alimentarios','Hoteles, Hostales, Pensiones','Terrazas de verano','Gasolineras, Depositos combustible') NOT NULL,
  `desc_actividad` varchar(500) NOT NULL,
  `ref_catastral` int(150) NOT NULL,
  `tipo_suelo` enum('Urbano','Rústico') NOT NULL,
  `fecha_inicio` date DEFAULT NULL,
  `estado` enum('En proceso','Aceptada','Rechazada','Archivada') NOT NULL,
  `fotocopia_dni` tinyint(1) NOT NULL,
  `fotocopia_imp_actividades` tinyint(1) NOT NULL,
  `fotocopia_escritura` tinyint(1) NOT NULL,
  `justificante_pago` tinyint(1) NOT NULL,
  `memoria_actividad` tinyint(1) NOT NULL,
  `planos` tinyint(1) NOT NULL,
  `licencia_obra` tinyint(1) NOT NULL,
  `otras_autorizaciones` tinyint(1) NOT NULL,
  `certificado_colegio_oficial` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `solicitud`
--

INSERT INTO `solicitud` (`id_solicitud`, `fecha`, `tipo`, `desc_actividad`, `ref_catastral`, `tipo_suelo`, `fecha_inicio`, `estado`, `fotocopia_dni`, `fotocopia_imp_actividades`, `fotocopia_escritura`, `justificante_pago`, `memoria_actividad`, `planos`, `licencia_obra`, `otras_autorizaciones`, `certificado_colegio_oficial`) VALUES
(21, '2017-05-26', 'Suelo urbano', 'yupiiiiii', 1, 'Urbano', '2017-05-12', 'En proceso', 1, 1, 1, 1, 1, 1, 1, 1, 1),
(23, '2017-05-26', 'Suelo urbano', 'yupiiiiii', 1, 'Urbano', '2017-05-12', 'En proceso', 1, 1, 1, 1, 1, 1, 1, 1, 1),
(24, '2017-05-26', 'Suelo urbano', 'yupiiiiii', 1, 'Urbano', '2017-05-12', 'En proceso', 1, 1, 1, 1, 1, 1, 1, 1, 1),
(25, '2017-05-26', 'Suelo urbano', 'yupiiiiii', 1, 'Urbano', '2017-05-12', 'En proceso', 1, 1, 1, 1, 1, 1, 1, 1, 1),
(26, '2017-05-26', 'Suelo urbano', 'yupiiiiii', 1, 'Urbano', '2017-05-12', 'En proceso', 1, 1, 1, 1, 1, 1, 1, 1, 1),
(27, '2017-05-26', 'Suelo urbano', 'yupiiiiii', 1, 'Urbano', '2017-05-12', 'En proceso', 1, 1, 1, 1, 1, 1, 1, 1, 1),
(28, '2017-05-26', 'Suelo urbano', 'yupiiiiii', 1, 'Urbano', '2017-05-12', 'En proceso', 1, 1, 1, 1, 1, 1, 1, 1, 1),
(29, '2017-05-26', 'Suelo urbano', 'yupiiiiii', 1, 'Urbano', '2017-05-12', 'En proceso', 1, 1, 1, 1, 1, 1, 1, 1, 1),
(30, '2017-05-26', 'Suelo urbano', 'yupiiiiii', 1, 'Urbano', '2017-05-12', 'En proceso', 1, 1, 1, 1, 1, 1, 1, 1, 1),
(31, '2017-05-26', 'Suelo urbano', 'yupiiiiii', 1, 'Urbano', '2017-05-12', 'En proceso', 1, 1, 1, 1, 1, 1, 1, 1, 1),
(32, '2017-05-26', 'Suelo urbano', 'yupiiiiii', 1, 'Urbano', '2017-05-12', 'En proceso', 1, 1, 1, 1, 1, 1, 1, 1, 1),
(33, '2017-05-26', 'Suelo urbano', 'yupiiiiii', 1, 'Urbano', '2017-05-12', 'En proceso', 1, 1, 1, 1, 1, 1, 1, 1, 1),
(34, '2017-05-26', 'Suelo urbano', 'yupiiiiii', 1, 'Urbano', '2017-05-12', 'En proceso', 1, 1, 1, 1, 1, 1, 1, 1, 1),
(35, '2017-05-26', 'Suelo urbano', 'yupiiiiii', 1, 'Urbano', '2017-05-12', 'En proceso', 1, 1, 1, 1, 1, 1, 1, 1, 1),
(36, '2017-05-26', 'Suelo urbano', 'yupiiiiii', 1, 'Urbano', '2017-05-12', 'En proceso', 1, 1, 1, 1, 1, 1, 1, 1, 1),
(37, '2017-05-26', 'Suelo urbano', 'yupiiiiii', 1, 'Urbano', '2017-05-12', 'En proceso', 1, 1, 1, 1, 1, 1, 1, 1, 1),
(38, '2017-05-26', 'Suelo urbano', 'yupiiiiii', 1, 'Urbano', '2017-05-12', 'En proceso', 1, 1, 1, 1, 1, 1, 1, 1, 1),
(39, '2017-05-26', 'Suelo urbano', 'yupiiiiii', 1, 'Urbano', '2017-05-12', 'En proceso', 1, 1, 1, 1, 1, 1, 1, 1, 1),
(40, '2017-05-26', 'Suelo urbano', 'yupiiiiii', 1, 'Urbano', '2017-05-12', 'En proceso', 1, 1, 1, 1, 1, 1, 1, 1, 1),
(41, '2017-05-26', 'Suelo urbano', 'yupiiiiii', 1, 'Urbano', '2017-05-12', 'En proceso', 1, 1, 1, 1, 1, 1, 1, 1, 1),
(42, '2017-05-26', 'Suelo urbano', 'yupiiiiii', 1, 'Urbano', '2017-05-12', 'En proceso', 1, 1, 1, 1, 1, 1, 1, 1, 1),
(43, '2017-05-26', 'Suelo urbano', 'yupiiiiii', 1, 'Urbano', '2017-05-12', 'En proceso', 1, 1, 1, 1, 1, 1, 1, 1, 1),
(44, '2017-05-26', 'Suelo urbano', 'yupiiiiii', 1, 'Urbano', '2017-05-12', 'En proceso', 1, 1, 1, 1, 1, 1, 1, 1, 1),
(45, '2017-05-26', 'Suelo urbano', 'yupiiiiii', 1, 'Urbano', '2017-05-12', 'En proceso', 1, 1, 1, 1, 1, 1, 1, 1, 1),
(46, '2017-05-26', 'Suelo urbano', 'yupiiiiii', 1, 'Urbano', '2017-05-12', 'En proceso', 1, 1, 1, 1, 1, 1, 1, 1, 1),
(47, '2017-05-26', 'Suelo urbano', 'yupiiiiii', 1, 'Urbano', '2017-05-12', 'En proceso', 1, 1, 1, 1, 1, 1, 1, 1, 1),
(48, '2017-05-26', 'Suelo urbano', 'yupiiiiii', 1, 'Urbano', '2017-05-12', 'En proceso', 1, 1, 1, 1, 1, 1, 1, 1, 1),
(49, '2017-05-26', 'Suelo urbano', 'yupiiiiii', 1, 'Urbano', '2017-05-12', 'En proceso', 1, 1, 1, 1, 1, 1, 1, 1, 1),
(50, '2017-05-26', 'Suelo urbano', 'yupiiiiii', 1, 'Urbano', '2017-05-12', 'En proceso', 1, 1, 1, 1, 1, 1, 1, 1, 1),
(51, '2017-05-26', 'Suelo urbano', 'yupiiiiii', 1, 'Urbano', '2017-05-12', 'En proceso', 1, 1, 1, 1, 1, 1, 1, 1, 1),
(52, '2017-05-26', 'Suelo urbano', 'yupiiiiii', 1, 'Urbano', '2017-05-12', 'En proceso', 1, 1, 1, 1, 1, 1, 1, 1, 1),
(53, '2017-05-26', 'Suelo urbano', 'yupiiiiii', 2, 'Urbano', '2017-05-12', 'En proceso', 1, 1, 1, 1, 1, 1, 1, 1, 1),
(54, '2017-05-12', 'Compañias de seguros', '98', 98, 'Rústico', '2017-05-11', 'En proceso', 0, 0, 1, 0, 0, 0, 0, 0, 0),
(55, '2017-05-06', 'Suelo urbano', 'Muy bonita', 123, 'Rústico', '2017-05-06', 'En proceso', 1, 0, 0, 0, 0, 0, 0, 1, 1),
(56, '2017-05-06', 'Suelo calificado como industrial', 'Un bar ', 123548, 'Rústico', '2017-05-06', 'En proceso', 1, 0, 0, 1, 1, 1, 1, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `titularidad`
--

CREATE TABLE `titularidad` (
  `id_titularidad` int(11) NOT NULL,
  `persona` int(11) NOT NULL,
  `solicitud` int(11) NOT NULL,
  `fecha_inicio` date NOT NULL,
  `fecha_fin` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `titularidad`
--

INSERT INTO `titularidad` (`id_titularidad`, `persona`, `solicitud`, `fecha_inicio`, `fecha_fin`) VALUES
(8, 24, 21, '2017-05-26', NULL),
(10, 26, 23, '2017-05-26', NULL),
(11, 27, 24, '2017-05-26', NULL),
(12, 28, 25, '2017-05-26', NULL),
(13, 29, 26, '2017-05-26', NULL),
(14, 30, 27, '2017-05-26', NULL),
(15, 31, 28, '2017-05-26', NULL),
(16, 32, 29, '2017-05-26', NULL),
(17, 33, 30, '2017-05-26', NULL),
(18, 34, 31, '2017-05-26', NULL),
(19, 35, 32, '2017-05-26', NULL),
(20, 36, 33, '2017-05-26', NULL),
(21, 37, 34, '2017-05-26', NULL),
(22, 38, 35, '2017-05-26', NULL),
(23, 39, 36, '2017-05-26', NULL),
(24, 40, 37, '2017-05-26', NULL),
(25, 41, 38, '2017-05-26', NULL),
(26, 42, 39, '2017-05-26', NULL),
(27, 43, 40, '2017-05-26', NULL),
(28, 44, 41, '2017-05-26', NULL),
(29, 45, 42, '2017-05-26', NULL),
(30, 46, 43, '2017-05-26', NULL),
(31, 47, 44, '2017-05-26', NULL),
(32, 48, 45, '2017-05-26', NULL),
(33, 49, 46, '2017-05-26', NULL),
(34, 50, 47, '2017-05-26', NULL),
(35, 51, 48, '2017-05-26', NULL),
(36, 52, 49, '2017-05-26', NULL),
(37, 53, 50, '2017-05-26', NULL),
(38, 54, 51, '2017-05-26', NULL),
(39, 55, 52, '2017-05-26', NULL),
(40, 56, 53, '2017-05-26', NULL),
(41, 57, 54, '2017-05-12', NULL),
(42, 58, 55, '2017-05-06', NULL),
(43, 59, 56, '2017-05-06', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `doc_necesaria_titularidad`
--
ALTER TABLE `doc_necesaria_titularidad`
  ADD PRIMARY KEY (`titularidad`);

--
-- Indexes for table `persona`
--
ALTER TABLE `persona`
  ADD PRIMARY KEY (`id_persona`);

--
-- Indexes for table `representa`
--
ALTER TABLE `representa`
  ADD PRIMARY KEY (`persona`,`representante`),
  ADD KEY `representante` (`representante`);

--
-- Indexes for table `representante`
--
ALTER TABLE `representante`
  ADD PRIMARY KEY (`id_representante`);

--
-- Indexes for table `solicitud`
--
ALTER TABLE `solicitud`
  ADD PRIMARY KEY (`id_solicitud`);

--
-- Indexes for table `titularidad`
--
ALTER TABLE `titularidad`
  ADD PRIMARY KEY (`id_titularidad`),
  ADD KEY `persona` (`persona`),
  ADD KEY `actividad` (`solicitud`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `persona`
--
ALTER TABLE `persona`
  MODIFY `id_persona` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=60;
--
-- AUTO_INCREMENT for table `representante`
--
ALTER TABLE `representante`
  MODIFY `id_representante` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
--
-- AUTO_INCREMENT for table `solicitud`
--
ALTER TABLE `solicitud`
  MODIFY `id_solicitud` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=57;
--
-- AUTO_INCREMENT for table `titularidad`
--
ALTER TABLE `titularidad`
  MODIFY `id_titularidad` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=44;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `doc_necesaria_titularidad`
--
ALTER TABLE `doc_necesaria_titularidad`
  ADD CONSTRAINT `ftitularidad` FOREIGN KEY (`titularidad`) REFERENCES `titularidad` (`id_titularidad`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `representa`
--
ALTER TABLE `representa`
  ADD CONSTRAINT `representa_ibfk_1` FOREIGN KEY (`persona`) REFERENCES `persona` (`id_persona`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `representa_ibfk_2` FOREIGN KEY (`representante`) REFERENCES `representante` (`id_representante`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `titularidad`
--
ALTER TABLE `titularidad`
  ADD CONSTRAINT `titularidad_ibfk_1` FOREIGN KEY (`persona`) REFERENCES `persona` (`id_persona`),
  ADD CONSTRAINT `titularidad_ibfk_2` FOREIGN KEY (`solicitud`) REFERENCES `solicitud` (`id_solicitud`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
