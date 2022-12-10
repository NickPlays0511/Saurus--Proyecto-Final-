-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 10-12-2022 a las 14:19:24
-- Versión del servidor: 5.7.36
-- Versión de PHP: 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `poo`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

DROP TABLE IF EXISTS `clientes`;
CREATE TABLE IF NOT EXISTS `clientes` (
  `ID_CLIENTE` int(4) NOT NULL,
  `NOMBRES` text NOT NULL,
  `APELLIDOS` text NOT NULL,
  `DNI` text NOT NULL,
  `TELEFONO` int(7) NOT NULL,
  PRIMARY KEY (`ID_CLIENTE`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`ID_CLIENTE`, `NOMBRES`, `APELLIDOS`, `DNI`, `TELEFONO`) VALUES
(0, 'Cesar', 'Torres Zea', '123456789', 1234567),
(1343, 'Vanesa', 'Vante', '987654321', 1234567),
(134, 'Vanesa', 'Vante', '987654321', 1234567),
(1234, 'Vanesa', 'Vante', '987654321', 1234567),
(789, 'Maria Luz', 'Baro Campo', '54687912', 4567891),
(4345, 'gsd', 'ffsgfg', '32545', 3243425);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleados`
--

DROP TABLE IF EXISTS `empleados`;
CREATE TABLE IF NOT EXISTS `empleados` (
  `ID_EMPLEADO` int(4) NOT NULL,
  `NOMBRES` text NOT NULL,
  `APELLIDOS` text NOT NULL,
  `DNI` text NOT NULL,
  `TELEFONO` int(9) NOT NULL,
  `CORREO` text NOT NULL,
  PRIMARY KEY (`ID_EMPLEADO`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empresa`
--

DROP TABLE IF EXISTS `empresa`;
CREATE TABLE IF NOT EXISTS `empresa` (
  `ID_VENTA` int(4) NOT NULL,
  `ID_EMPLEADO` int(4) NOT NULL,
  `ID_CLIENTE` int(4) NOT NULL,
  `ID_PROD` int(4) NOT NULL,
  `ID_PROVEEDOR` int(4) NOT NULL,
  PRIMARY KEY (`ID_VENTA`),
  KEY `ID_EMPLEADO` (`ID_EMPLEADO`),
  KEY `ID_CLIENTE` (`ID_CLIENTE`),
  KEY `ID_PROD` (`ID_PROD`),
  KEY `ID_PROVEEDOR` (`ID_PROVEEDOR`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

DROP TABLE IF EXISTS `productos`;
CREATE TABLE IF NOT EXISTS `productos` (
  `ID_PROD` int(11) NOT NULL,
  `PRECIO_VENTA` double NOT NULL,
  `PRECIO_COMPRA` decimal(8,2) NOT NULL,
  PRIMARY KEY (`ID_PROD`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`ID_PROD`, `PRECIO_VENTA`, `PRECIO_COMPRA`) VALUES
(124, 59.4, '54.20'),
(122, 50, '44.10'),
(125, 660, '650.20');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `prod_detalles`
--

DROP TABLE IF EXISTS `prod_detalles`;
CREATE TABLE IF NOT EXISTS `prod_detalles` (
  `ID_PROD` int(11) NOT NULL,
  `NOMBRE` text NOT NULL,
  `MARCA` varchar(20) NOT NULL,
  `DESCRIPCION` varchar(100) NOT NULL,
  `STOCK` text NOT NULL,
  PRIMARY KEY (`ID_PROD`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `prod_detalles`
--

INSERT INTO `prod_detalles` (`ID_PROD`, `NOMBRE`, `MARCA`, `DESCRIPCION`, `STOCK`) VALUES
(124, 'Extension', 'AOC', 'Extension de 2 metros', '22'),
(122, 'Mouse', 'Logitech', 'Mouse para computadora', '15'),
(125, 'Pantalla', 'Teros', 'Pantalla para computadora', '11');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedores`
--

DROP TABLE IF EXISTS `proveedores`;
CREATE TABLE IF NOT EXISTS `proveedores` (
  `ID_PROVEEDOR` int(11) NOT NULL,
  `MARCA` text NOT NULL,
  `TELEFONO` double NOT NULL,
  `DIRECCION` text NOT NULL,
  `DESCRIPCION` text NOT NULL,
  `CATEGORIA` text NOT NULL,
  PRIMARY KEY (`ID_PROVEEDOR`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `proveedores`
--

INSERT INTO `proveedores` (`ID_PROVEEDOR`, `MARCA`, `TELEFONO`, `DIRECCION`, `DESCRIPCION`, `CATEGORIA`) VALUES
(78945, 'Danino', 789456, 'Av. Pacifico N°123', 'fjankljfgbakfjb', 'Lácteos'),
(7895, 'Danino', 789456, 'Av. Pacifico N°123', 'fjankljfgbakfjb', 'Lácteos'),
(78329, 'Danino', 789456, 'Av. Pacifico N°123', 'fjankljfgbakfjb', 'Lácteos'),
(3445, 'fgdf', 67567, 'hdfhg', 'fhjfg', 'dfsfa');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `venta`
--

DROP TABLE IF EXISTS `venta`;
CREATE TABLE IF NOT EXISTS `venta` (
  `ID_VENTA` int(11) NOT NULL AUTO_INCREMENT,
  `FECHA_VENTA` varchar(20) NOT NULL,
  `ID_PROD` int(11) NOT NULL,
  `CANTIDAD` int(11) NOT NULL,
  `PRECIO_FINAL` double NOT NULL,
  PRIMARY KEY (`ID_VENTA`),
  KEY `ID_PROD` (`ID_PROD`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `venta`
--

INSERT INTO `venta` (`ID_VENTA`, `FECHA_VENTA`, `ID_PROD`, `CANTIDAD`, `PRECIO_FINAL`) VALUES
(1, '10-12-2022', 124, 1, 59.4),
(3, '10/12/2022', 124, 2, 118.8),
(4, '10/12/2022', 124, 5, 297);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
