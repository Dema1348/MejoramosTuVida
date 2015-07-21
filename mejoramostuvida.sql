-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 24-11-2014 a las 04:23:32
-- Versión del servidor: 5.5.24-log
-- Versión de PHP: 5.4.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `mejoramostuvida`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `calendario`
--

CREATE TABLE IF NOT EXISTS `calendario` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Fecha` date NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=14 ;

--
-- Volcado de datos para la tabla `calendario`
--

INSERT INTO `calendario` (`Id`, `Fecha`) VALUES
(1, '2014-11-24'),
(2, '2014-11-25'),
(3, '2014-11-26'),
(4, '2014-11-27'),
(5, '2014-11-28'),
(6, '2014-11-29'),
(7, '2014-11-30'),
(8, '2014-12-01'),
(9, '2014-12-02'),
(10, '2014-12-03'),
(11, '2014-12-04'),
(12, '2014-12-05'),
(13, '2014-12-06');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE IF NOT EXISTS `cliente` (
  `Rut` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `Nombres` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `Apellidos` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `Correo` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `Pass` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`Rut`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`Rut`, `Nombres`, `Apellidos`, `Correo`, `Pass`) VALUES
('1212', 'Juanito dd', 'fdsfds', 'dsfds@gmail.com', '11'),
('121212', 'Juanito', 'Lolin', 'asdsa@gmail.com', '1348'),
('17564403-2', 'Edson Pérez', 'Demanet', 'eds.perez@alumnos.duoc.cl', '1348'),
('17586123-4', 'Juanito Diego', 'Mota', 'asdas@gmail.com', '1111'),
('18946346-2', 'Rocio Constanza', 'Sepulveda', 'negruta@gmail.com', '6969');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `horas_dsponibles`
--

CREATE TABLE IF NOT EXISTS `horas_dsponibles` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Estado` tinyint(1) NOT NULL,
  `Valor` int(11) NOT NULL,
  `Id_modulo` int(11) NOT NULL,
  `Id_calentadrio` int(11) NOT NULL,
  `Id_rut_user` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `Rut_usuario` (`Id_modulo`),
  KEY `Id_modulo` (`Id_modulo`),
  KEY `Id_calentadrio` (`Id_calentadrio`),
  KEY `Id_rut_user` (`Id_rut_user`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=26 ;

--
-- Volcado de datos para la tabla `horas_dsponibles`
--

INSERT INTO `horas_dsponibles` (`Id`, `Estado`, `Valor`, `Id_modulo`, `Id_calentadrio`, `Id_rut_user`) VALUES
(16, 1, 35000, 8, 4, '4-4'),
(18, 1, 35000, 6, 4, '4-4'),
(20, 1, 35000, 4, 4, '4-4'),
(21, 1, 1000, 1, 1, '17'),
(22, 1, 1000, 1, 2, '17'),
(23, 1, 1000, 2, 1, '17'),
(24, 1, 1000, 1, 13, '17'),
(25, 1, 2000, 1, 8, '4-4');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `modulo`
--

CREATE TABLE IF NOT EXISTS `modulo` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Incio` time NOT NULL,
  `Termino` time NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=12 ;

--
-- Volcado de datos para la tabla `modulo`
--

INSERT INTO `modulo` (`Id`, `Incio`, `Termino`) VALUES
(1, '08:00:01', '08:30:00'),
(2, '08:30:01', '09:00:00'),
(3, '09:00:01', '09:30:00'),
(4, '09:30:01', '10:00:00'),
(6, '10:30:01', '11:00:00'),
(7, '11:00:01', '11:30:00'),
(8, '11:30:01', '12:00:00'),
(9, '12:00:01', '12:30:00'),
(10, '13:00:01', '13:30:00'),
(11, '13:31:01', '14:00:00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pago`
--

CREATE TABLE IF NOT EXISTS `pago` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Fecha_pago` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `Id_rut_cliente` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `Id_rut_user` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `Total` int(11) NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `Id_rut_user` (`Id_rut_user`),
  KEY `Id_rut_cliente` (`Id_rut_cliente`),
  KEY `Id_rut_user_2` (`Id_rut_user`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Volcado de datos para la tabla `pago`
--

INSERT INTO `pago` (`Id`, `Fecha_pago`, `Id_rut_cliente`, `Id_rut_user`, `Total`) VALUES
(1, '2014-11-19 06:20:48', '17564403-2', '4-4', 35000),
(2, '2014-11-19 06:20:58', '17564403-2', '4-4', 35000),
(3, '2014-11-19 06:21:02', '17564403-2', '4-4', 35000),
(4, '2014-11-19 06:21:06', '121212', '3-3', 25000),
(5, '2014-11-19 06:21:10', '17564403-2', '3-3', 25000),
(6, '2014-11-19 06:21:15', '17564403-2', '4-4', 35000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reserva_hora`
--

CREATE TABLE IF NOT EXISTS `reserva_hora` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Id_hora` int(11) NOT NULL,
  `Id_rut_cliente` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `Id_hora` (`Id_hora`,`Id_rut_cliente`),
  KEY `Id_rut_cliente` (`Id_rut_cliente`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=42 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

CREATE TABLE IF NOT EXISTS `rol` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Cargo` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `Detalle` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Volcado de datos para la tabla `rol`
--

INSERT INTO `rol` (`Id`, `Cargo`, `Detalle`) VALUES
(1, 'Administrador', 'Encargado de la administracion del sistema'),
(2, 'Asistente', 'Encargado de controlar el pago de la consulta, asistencia o anulación de los paciente'),
(3, 'Sicologo', 'Encargado de asistir directamente a un paciente que se encuentra en dificultades relacionadas a su comportamiento o forma de ser.'),
(4, 'Especialista ', 'Encargado del desarrollo de instrumentos y procedimientos técnicos específicos, empíricamente fundamentados, para la evaluación, el diagnóstico, la prevención y el tratamiento de los trastornos mental');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `Rut` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `Nombres` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `Apellidos` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `Pass` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `Correo` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `rol_id` int(11) NOT NULL,
  PRIMARY KEY (`Rut`),
  KEY `rol_id` (`rol_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`Rut`, `Nombres`, `Apellidos`, `Pass`, `Correo`, `rol_id`) VALUES
('1-1', 'Juanito', 'Perez', '11', 'edads@gmail.com', 1),
('17', 'Diego Alexander', 'Perez Demanet', '1348', 'asdsa@hotmial.com', 4),
('2-2', 'sfdfds', 'Perez', '22', 'edads@gmail.com', 2),
('3-3', 'vxxvc', 'Perez', '33', 'edads@gmail.com', 3),
('4-4', 'rtter', 'Perez', '44', 'edads@gmail.com', 4);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `horas_dsponibles`
--
ALTER TABLE `horas_dsponibles`
  ADD CONSTRAINT `horas_dsponibles_ibfk_1` FOREIGN KEY (`Id_modulo`) REFERENCES `modulo` (`Id`),
  ADD CONSTRAINT `horas_dsponibles_ibfk_2` FOREIGN KEY (`Id_calentadrio`) REFERENCES `calendario` (`Id`),
  ADD CONSTRAINT `horas_dsponibles_ibfk_3` FOREIGN KEY (`Id_rut_user`) REFERENCES `usuario` (`Rut`);

--
-- Filtros para la tabla `pago`
--
ALTER TABLE `pago`
  ADD CONSTRAINT `pago_ibfk_1` FOREIGN KEY (`Id_rut_cliente`) REFERENCES `cliente` (`Rut`),
  ADD CONSTRAINT `pago_ibfk_2` FOREIGN KEY (`Id_rut_user`) REFERENCES `usuario` (`Rut`);

--
-- Filtros para la tabla `reserva_hora`
--
ALTER TABLE `reserva_hora`
  ADD CONSTRAINT `reserva_hora_ibfk_1` FOREIGN KEY (`Id_hora`) REFERENCES `horas_dsponibles` (`Id`),
  ADD CONSTRAINT `reserva_hora_ibfk_2` FOREIGN KEY (`Id_rut_cliente`) REFERENCES `cliente` (`Rut`);

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`rol_id`) REFERENCES `rol` (`Id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
