# Host: localhost  (Version: 5.6.17)
# Date: 2014-11-24 23:19:36
# Generator: MySQL-Front 5.3  (Build 4.136)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "device"
#

CREATE TABLE `device` (
  `id_device` varchar(30) NOT NULL DEFAULT '0',
  `name_dev` varchar(30) NOT NULL DEFAULT '',
  `model_dev` varchar(30) NOT NULL DEFAULT '',
  `provider_dev` varchar(30) NOT NULL DEFAULT '',
  `ver_so` varchar(10) NOT NULL DEFAULT '',
  `build_dev` varchar(20) NOT NULL DEFAULT '',
  `locale_dev` varchar(20) NOT NULL DEFAULT '',
  `kernel_dev` varchar(255) NOT NULL DEFAULT '',
  `sto_ext_sd` varchar(20) NOT NULL DEFAULT '',
  `sto_s2sd` varchar(20) NOT NULL DEFAULT '',
  `sto_inter` varchar(20) NOT NULL DEFAULT '',
  `sto_sys` varchar(20) NOT NULL DEFAULT '',
  `cache_sys` varchar(20) NOT NULL DEFAULT '',
  `ram` varchar(20) NOT NULL DEFAULT '',
  `cpu` int(11) NOT NULL DEFAULT '0',
  `color` int(11) NOT NULL DEFAULT '0',
  `h_dev` varchar(10) NOT NULL DEFAULT '',
  `w_dev` varchar(10) NOT NULL DEFAULT '',
  `bulk_dev` varchar(10) NOT NULL DEFAULT '',
  `weight_dev` varchar(10) NOT NULL DEFAULT '',
  `mat` int(11) NOT NULL DEFAULT '0',
  `id_blu` int(11) NOT NULL DEFAULT '0',
  `cert_google` binary(1) NOT NULL DEFAULT '\0',
  `id_dis` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_device`),
  UNIQUE KEY `iddispositivos_UNIQUE` (`id_device`),
  KEY `cpu_dev` (`cpu`),
  KEY `color_dev` (`color`),
  KEY `mat_dev` (`mat`),
  KEY `id_blu` (`id_blu`),
  KEY `id_dis` (`id_dis`),
  CONSTRAINT `color_dev` FOREIGN KEY (`color`) REFERENCES `color` (`id_color`),
  CONSTRAINT `cpu_dev` FOREIGN KEY (`cpu`) REFERENCES `cpu` (`id_cpu`),
  CONSTRAINT `id_blu` FOREIGN KEY (`id_blu`) REFERENCES `bluetooth` (`id_blu`),
  CONSTRAINT `id_dis` FOREIGN KEY (`id_dis`) REFERENCES `display` (`id_dis`),
  CONSTRAINT `mat_dev` FOREIGN KEY (`mat`) REFERENCES `material` (`id_mat`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "device"
#

