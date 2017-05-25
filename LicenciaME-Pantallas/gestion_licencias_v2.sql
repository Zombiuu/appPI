-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 25-05-2017 a las 19:18:16
-- Versión del servidor: 10.1.21-MariaDB
-- Versión de PHP: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `gestion_licencias_v2`
--
CREATE DATABASE IF NOT EXISTS `gestion_licencias_v2` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `gestion_licencias_v2`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `doc_necesaria_titularidad`
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
-- Estructura de tabla para la tabla `persona`
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
-- Volcado de datos para la tabla `persona`
--

INSERT INTO `persona` (`id_persona`, `nombre`, `cif`, `direccion`, `municipio`, `cp`, `tlf_fijo`, `tlf_movil`, `email`, `tipo`) VALUES
(2, '1', '1', '1', '1', 1, 1, 1, '1', 'Física');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `representa`
--

CREATE TABLE `representa` (
  `persona` int(11) NOT NULL,
  `representante` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `representante`
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
-- Volcado de datos para la tabla `representante`
--

INSERT INTO `representante` (`id_representante`, `nombre`, `nif_nie`, `direccion`, `municipio`, `cp`, `tlf_fijo`, `tlf_movil`) VALUES
(1, 'Sergio Redondo', '52999065', 'c / hola', 'Madrid', 28250, 918569858, 666758785),
(2, '2', '2', '2', '2', 2, 2, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `solicitud`
--

CREATE TABLE `solicitud` (
  `id_solicitud` int(11) NOT NULL,
  `fecha` datetime NOT NULL,
  `tipo` varchar(100) NOT NULL,
  `desc_actividad` varchar(500) NOT NULL,
  `ref_catastral` varchar(150) NOT NULL,
  `tipo_suelo` enum('Urbano','Rústico') NOT NULL,
  `fecha_inicio` datetime NOT NULL,
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
-- Volcado de datos para la tabla `solicitud`
--

INSERT INTO `solicitud` (`id_solicitud`, `fecha`, `tipo`, `desc_actividad`, `ref_catastral`, `tipo_suelo`, `fecha_inicio`, `estado`, `fotocopia_dni`, `fotocopia_imp_actividades`, `fotocopia_escritura`, `justificante_pago`, `memoria_actividad`, `planos`, `licencia_obra`, `otras_autorizaciones`, `certificado_colegio_oficial`) VALUES
(1, '2017-05-06 00:00:00', 'Suelo calificado como industrial', '3', '3', 'Rústico', '2017-05-25 00:00:00', 'En proceso', 1, 1, 1, 1, 1, 1, 1, 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `titularidad`
--

CREATE TABLE `titularidad` (
  `id_titularidad` int(11) NOT NULL,
  `persona` int(11) NOT NULL,
  `solicitud` int(11) NOT NULL,
  `fecha_inicio` datetime NOT NULL,
  `fecha_fin` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `doc_necesaria_titularidad`
--
ALTER TABLE `doc_necesaria_titularidad`
  ADD PRIMARY KEY (`titularidad`);

--
-- Indices de la tabla `persona`
--
ALTER TABLE `persona`
  ADD PRIMARY KEY (`id_persona`);

--
-- Indices de la tabla `representa`
--
ALTER TABLE `representa`
  ADD PRIMARY KEY (`persona`,`representante`),
  ADD KEY `representante` (`representante`);

--
-- Indices de la tabla `representante`
--
ALTER TABLE `representante`
  ADD PRIMARY KEY (`id_representante`);

--
-- Indices de la tabla `solicitud`
--
ALTER TABLE `solicitud`
  ADD PRIMARY KEY (`id_solicitud`);

--
-- Indices de la tabla `titularidad`
--
ALTER TABLE `titularidad`
  ADD PRIMARY KEY (`id_titularidad`),
  ADD KEY `persona` (`persona`),
  ADD KEY `actividad` (`solicitud`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `persona`
--
ALTER TABLE `persona`
  MODIFY `id_persona` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `representante`
--
ALTER TABLE `representante`
  MODIFY `id_representante` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `solicitud`
--
ALTER TABLE `solicitud`
  MODIFY `id_solicitud` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `titularidad`
--
ALTER TABLE `titularidad`
  MODIFY `id_titularidad` int(11) NOT NULL AUTO_INCREMENT;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `doc_necesaria_titularidad`
--
ALTER TABLE `doc_necesaria_titularidad`
  ADD CONSTRAINT `ftitularidad` FOREIGN KEY (`titularidad`) REFERENCES `titularidad` (`id_titularidad`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `representa`
--
ALTER TABLE `representa`
  ADD CONSTRAINT `representa_ibfk_1` FOREIGN KEY (`persona`) REFERENCES `persona` (`id_persona`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `representa_ibfk_2` FOREIGN KEY (`representante`) REFERENCES `representante` (`id_representante`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `titularidad`
--
ALTER TABLE `titularidad`
  ADD CONSTRAINT `titularidad_ibfk_1` FOREIGN KEY (`persona`) REFERENCES `persona` (`id_persona`),
  ADD CONSTRAINT `titularidad_ibfk_2` FOREIGN KEY (`solicitud`) REFERENCES `solicitud` (`id_solicitud`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
