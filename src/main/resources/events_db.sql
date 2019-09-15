-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:8889
-- Generation Time: Sep 15, 2019 at 06:31 PM
-- Server version: 5.6.34-log
-- PHP Version: 7.2.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `events_db`
--

-- --------------------------------------------------------

--
-- Stand-in structure for view `event_details`
-- (See below for the actual view)
--
CREATE TABLE `event_details` (
`name` varchar(235)
,`address` varchar(235)
,`event_name` varchar(235)
,`date` varchar(100)
,`details` varchar(500)
);

-- --------------------------------------------------------

--
-- Table structure for table `event_stuff`
--

CREATE TABLE `event_stuff` (
  `name` varchar(235) DEFAULT NULL,
  `date` varchar(100) DEFAULT NULL,
  `details` varchar(500) DEFAULT NULL,
  `venue_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `venue`
--

CREATE TABLE `venue` (
  `name` varchar(235) DEFAULT NULL,
  `address` varchar(235) DEFAULT NULL,
  `venue_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure for view `event_details`
--
DROP TABLE IF EXISTS `event_details`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `event_details`  AS  select `venue`.`name` AS `name`,`venue`.`address` AS `address`,`event_stuff`.`name` AS `event_name`,`event_stuff`.`date` AS `date`,`event_stuff`.`details` AS `details` from (`venue` join `event_stuff` on((`venue`.`venue_id` = `event_stuff`.`venue_id`))) ;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
