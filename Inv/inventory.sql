-- MySQL dump 10.13  Distrib 5.6.24, for Win64 (x86_64)
-- Host: localhost    Database: Inventory
-- Server version	5.7.7-rc-log

--
-- Table structure for table `dept`
--

DROP TABLE IF EXISTS `dept`;

CREATE TABLE `dept` (
  `dept_id` varchar(20) NOT NULL,
  `dept_name` varchar(50) DEFAULT NULL,
  `dept_desc` varchar(150) DEFAULT NULL,
  `prod_id` varchar(20) NOT NULL,
  `qnty` int(11) DEFAULT NULL,
  PRIMARY KEY (`dept_id`,`prod_id`),
  KEY `dept_prod_fk_idx` (`prod_id`),
  CONSTRAINT `dept_prod_fk` FOREIGN KEY (`prod_id`) REFERENCES `product` (`prod_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `inactive_inventory`
--

DROP TABLE IF EXISTS `inactive_inventory`;

CREATE TABLE `inactive_inventory` (
  `id` varchar(20) NOT NULL,
  `prod_id` varchar(20) DEFAULT NULL,
  `qnty` int(11) DEFAULT NULL,
  `reason` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `inact_prod_fk_idx` (`prod_id`),
  CONSTRAINT `inact_prod_fk` FOREIGN KEY (`prod_id`) REFERENCES `product` (`prod_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `order_inventory`
--

DROP TABLE IF EXISTS `order_inventory`;

CREATE TABLE `order_inventory` (
  `order_id` varchar(20) NOT NULL,
  `prod_id` varchar(20) DEFAULT NULL,
  `qnty` int(11) DEFAULT NULL,
  `status` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  KEY `order_prod_fk_idx` (`prod_id`),
  CONSTRAINT `order_prod_fk` FOREIGN KEY (`prod_id`) REFERENCES `product` (`prod_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `prod_id` varchar(20) NOT NULL,
  `prod_name` varchar(50) DEFAULT NULL,
  `prod_desc` varchar(150) DEFAULT NULL,
  `prod_qnty` int(11) DEFAULT NULL,
  PRIMARY KEY (`prod_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;