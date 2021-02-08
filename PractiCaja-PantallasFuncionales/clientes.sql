-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 08-02-2021 a las 10:22:31
-- Versión del servidor: 10.4.17-MariaDB
-- Versión de PHP: 8.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `clientes`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cuentas`
--

CREATE TABLE `cuentas` (
  `idCuenta` int(11) NOT NULL,
  `nombreCliente` varchar(80) NOT NULL,
  `password` varchar(40) NOT NULL,
  `saldo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cuentas`
--

INSERT INTO `cuentas` (`idCuenta`, `nombreCliente`, `password`, `saldo`) VALUES
(1, 'Pedro', 'contrasena', 804),
(2, 'Pedro Perez', 'unapass', 1100),
(3, 'asdasdasd', 'asdasdasdas', 800),
(4, 'Panchooo', 'asdasdasd', 2400),
(5, 'Gonzalo', 'lagatirris', 0),
(6, 'Chano', 'chanochano', 0),
(7, 'JuanSinMiedo', '123456789', 900),
(8, 'Luciano', 'contrasena', 8000),
(9, 'Alan', 'mauricio', 1600),
(10, 'Jesus', 'contrasena', 0),
(11, 'Jorge', 'contrasena', 800);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `movimientos`
--

CREATE TABLE `movimientos` (
  `idMovimiento` int(11) NOT NULL,
  `nombreCliente` varchar(100) NOT NULL,
  `tipoMovimiento` varchar(100) NOT NULL,
  `fecha` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `movimientos`
--

INSERT INTO `movimientos` (`idMovimiento`, `nombreCliente`, `tipoMovimiento`, `fecha`) VALUES
(1, 'Pedro', 'Depositó: 600 al cliente: JuanSinMiedo', '2021-02-07'),
(2, 'Luciano', 'Depositó: 8000 al cliente: Luciano', '2021-02-07'),
(3, 'Alan', 'Depositó: 900 al cliente: Alan', '2021-02-07'),
(4, 'Pedro', 'Depositó: 700 al cliente: Alan', '2021-02-07'),
(5, 'Pedro', 'Transfirió: 600 al cliente: Panchooo', '2021-02-08'),
(6, 'Pedro', 'Pedrodepositó: $800', '2021-02-08'),
(7, 'Pedro', 'Pedro realizó:Pago de: Agua por el monto de: 600', '2021-02-08'),
(8, 'Pedro', 'Pedro depositó: $600', '2021-02-08'),
(9, 'Pedro', 'Pedro depositó: $600', '2021-02-08'),
(10, 'Pedro', 'Pedro realizó:Recarga Telefónica de 700 al número: 4931123406', '2021-02-08'),
(11, 'Pedro', 'Pedro depositó: $800', '2021-02-08'),
(12, 'Pedro', 'Transfirió: 900 al cliente: Panchooo', '2021-02-08'),
(13, 'Pedro', 'Transfirió: 300 al cliente: JuanSinMiedo', '2021-02-08'),
(14, 'Pedro', 'Pedro depositó: $800', '2021-02-08'),
(15, 'Pedro', 'Transfirió: 900 al cliente: Panchooo', '2021-02-08'),
(16, 'Pedro', 'Pedro realizó:Pago de: Agua por el monto de: 900', '2021-02-08'),
(17, 'Pedro', 'Pedro depositó: $1200', '2021-02-08'),
(18, 'Pedro', 'Transfirió: 600 al cliente: asdasdasd', '2021-02-08'),
(19, 'Pedro', 'Pedro realizó:Recarga Telefónica de 30 al número: 4931123406', '2021-02-08'),
(20, 'Pedro', 'Transfirió: 200 al cliente: asdasdasd', '2021-02-08'),
(21, 'Pedro', 'Pedro depositó: $500', '2021-02-08'),
(22, 'Jorge', 'Jorge depositó: $800', '2021-02-08');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cuentas`
--
ALTER TABLE `cuentas`
  ADD PRIMARY KEY (`idCuenta`);

--
-- Indices de la tabla `movimientos`
--
ALTER TABLE `movimientos`
  ADD PRIMARY KEY (`idMovimiento`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cuentas`
--
ALTER TABLE `cuentas`
  MODIFY `idCuenta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `movimientos`
--
ALTER TABLE `movimientos`
  MODIFY `idMovimiento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
