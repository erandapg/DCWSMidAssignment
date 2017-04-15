/*
SQLyog Ultimate v11.33 (64 bit)
MySQL - 5.7.17-log : Database - hospitalsystem
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`hospitalsystem` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `hospitalsystem`;

/*Table structure for table `hospital_system_apointments` */

DROP TABLE IF EXISTS `hospital_system_apointments`;

CREATE TABLE `hospital_system_apointments` (
  `apo_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date_time` timestamp NULL DEFAULT NULL,
  `hospital` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`apo_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `hospital_system_apointments` */

insert  into `hospital_system_apointments`(`apo_id`,`date_time`,`hospital`,`name`,`status`) values (1,'2017-04-02 15:28:55','Nawaloka','Apointment 1',1),(2,'2017-04-02 15:28:55','Nawaloka','Apointment 2',1);

/*Table structure for table `hospital_system_doctor` */

DROP TABLE IF EXISTS `hospital_system_doctor`;

CREATE TABLE `hospital_system_doctor` (
  `doc_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_date` datetime DEFAULT NULL,
  `modify_date` datetime DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `speciality` varchar(255) DEFAULT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`doc_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `hospital_system_doctor` */

insert  into `hospital_system_doctor`(`doc_id`,`created_date`,`modify_date`,`name`,`speciality`,`status`) values (1,'2017-04-03 15:25:46',NULL,'Test Doctor 1','Test Speciality 1',1),(2,NULL,NULL,'Test Doctor 2','Test Speciality 2',1);

/*Table structure for table `hospital_system_doctor_apointments` */

DROP TABLE IF EXISTS `hospital_system_doctor_apointments`;

CREATE TABLE `hospital_system_doctor_apointments` (
  `doc_apo_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `status` int(11) NOT NULL,
  `apo_id` bigint(20) DEFAULT NULL,
  `doc_id` bigint(20) DEFAULT NULL,
  `charge` double NOT NULL,
  PRIMARY KEY (`doc_apo_id`),
  KEY `FK_i0idvpv8elb8b0e9strcau0i0` (`apo_id`),
  KEY `FK_eb9ivclq34sr2glwo9enifkqw` (`doc_id`),
  CONSTRAINT `FK_eb9ivclq34sr2glwo9enifkqw` FOREIGN KEY (`doc_id`) REFERENCES `hospital_system_doctor` (`doc_id`),
  CONSTRAINT `FK_i0idvpv8elb8b0e9strcau0i0` FOREIGN KEY (`apo_id`) REFERENCES `hospital_system_apointments` (`apo_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `hospital_system_doctor_apointments` */

insert  into `hospital_system_doctor_apointments`(`doc_apo_id`,`status`,`apo_id`,`doc_id`,`charge`) values (1,1,1,1,350),(2,1,2,2,450);

/*Table structure for table `hospital_system_hospital` */

DROP TABLE IF EXISTS `hospital_system_hospital`;

CREATE TABLE `hospital_system_hospital` (
  `host_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`host_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `hospital_system_hospital` */

/*Table structure for table `hospital_system_reserve_apointments` */

DROP TABLE IF EXISTS `hospital_system_reserve_apointments`;

CREATE TABLE `hospital_system_reserve_apointments` (
  `rez_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `charge` double NOT NULL,
  `created_date` datetime NOT NULL,
  `description` varchar(255) NOT NULL,
  `modify_date` datetime DEFAULT NULL,
  `payment_meth` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  `doc_apo_id` bigint(20) NOT NULL,
  `user` varchar(255) NOT NULL,
  PRIMARY KEY (`rez_id`),
  KEY `FK_8yuydsr6dk8rq1jx8l6loxlye` (`doc_apo_id`),
  CONSTRAINT `FK_8yuydsr6dk8rq1jx8l6loxlye` FOREIGN KEY (`doc_apo_id`) REFERENCES `hospital_system_doctor_apointments` (`doc_apo_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `hospital_system_reserve_apointments` */

insert  into `hospital_system_reserve_apointments`(`rez_id`,`charge`,`created_date`,`description`,`modify_date`,`payment_meth`,`status`,`doc_apo_id`,`user`) values (1,350,'2017-04-05 21:28:29','eranda_sliit',NULL,0,1,1,'eranda_sliit');

/*Table structure for table `hospitaluser` */

DROP TABLE IF EXISTS `hospitaluser`;

CREATE TABLE `hospitaluser` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `hospitaluser` */

insert  into `hospitaluser`(`userid`,`username`,`password`) values (1,'eranda_sliit','123456');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
