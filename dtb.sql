# Host: localhost  (Version: 5.6.17)
# Date: 2014-10-19 17:47:33
# Generator: MySQL-Front 5.3  (Build 4.136)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "app"
#

CREATE TABLE `app` (
  `id_app` int(11) NOT NULL AUTO_INCREMENT,
  `name_app` varchar(30) NOT NULL DEFAULT '',
  `desc_app` varchar(30) NOT NULL DEFAULT '',
  `file_app` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`id_app`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "app"
#


#
# Structure for table "battery"
#

CREATE TABLE `battery` (
  `id_bat` int(11) NOT NULL AUTO_INCREMENT,
  `type_bat` varchar(20) NOT NULL DEFAULT '',
  `cap_bat` varchar(20) NOT NULL DEFAULT '',
  PRIMARY KEY (`id_bat`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "battery"
#

INSERT INTO `battery` VALUES (1,'sd','sdsd');

#
# Structure for table "bluetooth"
#

CREATE TABLE `bluetooth` (
  `id_blu` int(11) NOT NULL AUTO_INCREMENT,
  `type_blu` varchar(30) NOT NULL DEFAULT '',
  PRIMARY KEY (`id_blu`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

#
# Data for table "bluetooth"
#

INSERT INTO `bluetooth` VALUES (1,'dsd');

#
# Structure for table "camera"
#

CREATE TABLE `camera` (
  `id_cam` int(11) NOT NULL AUTO_INCREMENT,
  `name_cam` varchar(30) NOT NULL DEFAULT '',
  `type_cam` varchar(20) NOT NULL DEFAULT '',
  `prov_cam` varchar(20) NOT NULL DEFAULT '',
  `mp_cam` varchar(255) NOT NULL DEFAULT '',
  `flash_cam` binary(1) NOT NULL DEFAULT '\0',
  `supp_img_cam` varchar(400) NOT NULL DEFAULT '',
  `supp_vid_cam` varchar(400) NOT NULL DEFAULT '',
  `feat_cam` varchar(400) NOT NULL DEFAULT '',
  PRIMARY KEY (`id_cam`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "camera"
#


#
# Structure for table "color"
#

CREATE TABLE `color` (
  `id_color` int(11) NOT NULL AUTO_INCREMENT,
  `desc_color` varchar(20) NOT NULL DEFAULT '',
  PRIMARY KEY (`id_color`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

#
# Data for table "color"
#

INSERT INTO `color` VALUES (1,'sdsfsf');

#
# Structure for table "cpu"
#

CREATE TABLE `cpu` (
  `id_cpu` int(11) NOT NULL AUTO_INCREMENT,
  `name_cpu` varchar(30) DEFAULT NULL,
  `frec_cpu` varchar(20) NOT NULL DEFAULT '',
  `core_cpu` int(2) NOT NULL DEFAULT '0',
  `feature_cpu` varchar(255) NOT NULL DEFAULT '',
  `revision_cpu` varchar(30) NOT NULL DEFAULT '',
  `hard_cpu` varchar(30) NOT NULL DEFAULT '',
  `gpu` varchar(30) NOT NULL DEFAULT '',
  PRIMARY KEY (`id_cpu`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

#
# Data for table "cpu"
#

INSERT INTO `cpu` VALUES (1,'df','df',1,'sds','qsdd','sds','dsds');

#
# Structure for table "display"
#

CREATE TABLE `display` (
  `id_dis` int(11) NOT NULL AUTO_INCREMENT,
  `type_dis` varchar(30) NOT NULL DEFAULT '',
  `w_dis` varchar(10) NOT NULL DEFAULT '',
  `h_dis` varchar(10) NOT NULL DEFAULT '',
  `dpi_dis` varchar(10) NOT NULL DEFAULT '',
  `tech_dis` varchar(30) NOT NULL DEFAULT '',
  PRIMARY KEY (`id_dis`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

#
# Data for table "display"
#

INSERT INTO `display` VALUES (1,'dsd','sd','sd','sd','sd');

#
# Structure for table "failure"
#

CREATE TABLE `failure` (
  `id_fail` int(11) NOT NULL AUTO_INCREMENT,
  `type_fail` varchar(30) NOT NULL DEFAULT '',
  `desc_fail` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`id_fail`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "failure"
#


#
# Structure for table "format"
#

CREATE TABLE `format` (
  `id_for` int(11) NOT NULL AUTO_INCREMENT,
  `type_for` varchar(20) NOT NULL DEFAULT '',
  `desc_for` varchar(20) NOT NULL DEFAULT '',
  PRIMARY KEY (`id_for`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "format"
#


#
# Structure for table "material"
#

CREATE TABLE `material` (
  `id_mat` int(11) NOT NULL AUTO_INCREMENT,
  `name_mat` varchar(30) NOT NULL DEFAULT '',
  PRIMARY KEY (`id_mat`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

#
# Data for table "material"
#

INSERT INTO `material` VALUES (1,'dsdsf');

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

INSERT INTO `device` VALUES ('0123456789ABCDEF','wt','ert','rt','rt','et','ouh','oh','oh','oh','piih','bo','ppi','piih',1,1,'1','1pj','pij','pj',1,1,X'31',1);

#
# Structure for table "image"
#

CREATE TABLE `image` (
  `id_img` int(11) NOT NULL AUTO_INCREMENT,
  `type_img` varchar(20) NOT NULL DEFAULT '',
  `name_img` varchar(30) NOT NULL DEFAULT '',
  `date_img` date NOT NULL DEFAULT '0000-00-00',
  `file_img` varchar(255) NOT NULL DEFAULT '',
  `id_dev` varchar(30) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_img`),
  KEY `id_dev_img` (`id_dev`),
  CONSTRAINT `id_dev_img` FOREIGN KEY (`id_dev`) REFERENCES `device` (`id_device`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "image"
#


#
# Structure for table "device-format"
#

CREATE TABLE `device-format` (
  `id_dev` varchar(30) NOT NULL DEFAULT '0',
  `id_for` int(11) NOT NULL DEFAULT '0',
  KEY `id_for_for` (`id_for`),
  KEY `id_dev_for` (`id_dev`),
  CONSTRAINT `id_dev_for` FOREIGN KEY (`id_dev`) REFERENCES `device` (`id_device`),
  CONSTRAINT `id_for_for` FOREIGN KEY (`id_for`) REFERENCES `format` (`id_for`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "device-format"
#


#
# Structure for table "device-camera"
#

CREATE TABLE `device-camera` (
  `id_dev` varchar(30) NOT NULL DEFAULT '0',
  `id_cam` int(11) NOT NULL DEFAULT '0',
  KEY `id_cam_cam` (`id_cam`),
  KEY `id_dev_cam` (`id_dev`),
  CONSTRAINT `id_dev_cam` FOREIGN KEY (`id_dev`) REFERENCES `device` (`id_device`),
  CONSTRAINT `id_cam_cam` FOREIGN KEY (`id_cam`) REFERENCES `camera` (`id_cam`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "device-camera"
#


#
# Structure for table "device-app"
#

CREATE TABLE `device-app` (
  `id_dev` varchar(30) NOT NULL DEFAULT '0',
  `id_app` int(11) NOT NULL DEFAULT '0',
  KEY `id_app` (`id_app`),
  KEY `id_dev_app` (`id_dev`),
  CONSTRAINT `id_dev_app` FOREIGN KEY (`id_dev`) REFERENCES `device` (`id_device`),
  CONSTRAINT `id_app` FOREIGN KEY (`id_app`) REFERENCES `app` (`id_app`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "device-app"
#


#
# Structure for table "device_battery"
#

CREATE TABLE `device_battery` (
  `id_dev_b` varchar(30) NOT NULL DEFAULT '0',
  `id_bat` int(11) NOT NULL DEFAULT '0',
  KEY `id_dev_bat` (`id_dev_b`),
  KEY `id_bat_dev` (`id_bat`),
  CONSTRAINT `id_bat_dev` FOREIGN KEY (`id_bat`) REFERENCES `battery` (`id_bat`),
  CONSTRAINT `id_dev_bat` FOREIGN KEY (`id_dev_b`) REFERENCES `device` (`id_device`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "device_battery"
#

INSERT INTO `device_battery` VALUES ('0123456789ABCDEF',1);

#
# Structure for table "network"
#

CREATE TABLE `network` (
  `id_net` int(11) NOT NULL AUTO_INCREMENT,
  `type_net` varchar(30) NOT NULL DEFAULT '',
  `val_net` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`id_net`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "network"
#


#
# Structure for table "device-network"
#

CREATE TABLE `device-network` (
  `id_dev` varchar(30) NOT NULL DEFAULT '0',
  `net_dev` int(11) NOT NULL DEFAULT '0',
  KEY `id_net_net` (`net_dev`),
  KEY `id_dev_net` (`id_dev`),
  CONSTRAINT `id_dev_net` FOREIGN KEY (`id_dev`) REFERENCES `device` (`id_device`),
  CONSTRAINT `id_net_net` FOREIGN KEY (`net_dev`) REFERENCES `network` (`id_net`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "device-network"
#


#
# Structure for table "other_support"
#

CREATE TABLE `other_support` (
  `id_sup` int(11) NOT NULL AUTO_INCREMENT,
  `name_sup` varchar(20) NOT NULL DEFAULT '',
  `desc_sup` varchar(20) NOT NULL DEFAULT '',
  PRIMARY KEY (`id_sup`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "other_support"
#


#
# Structure for table "device-support"
#

CREATE TABLE `device-support` (
  `id_dev` varchar(30) NOT NULL DEFAULT '0',
  `id_sup` int(11) NOT NULL DEFAULT '0',
  KEY `id_sup_sup` (`id_sup`),
  KEY `id_dev_sup` (`id_dev`),
  CONSTRAINT `id_dev_sup` FOREIGN KEY (`id_dev`) REFERENCES `device` (`id_device`),
  CONSTRAINT `id_sup_sup` FOREIGN KEY (`id_sup`) REFERENCES `other_support` (`id_sup`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "device-support"
#


#
# Structure for table "report"
#

CREATE TABLE `report` (
  `id_rep` int(11) NOT NULL AUTO_INCREMENT,
  `name_rep` varchar(30) NOT NULL DEFAULT '',
  `desc_rep` varchar(255) NOT NULL DEFAULT '',
  `file_rep` varchar(255) NOT NULL DEFAULT '',
  `type_rep` varchar(20) NOT NULL DEFAULT '',
  `date_rep` date NOT NULL DEFAULT '0000-00-00',
  PRIMARY KEY (`id_rep`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "report"
#


#
# Structure for table "record"
#

CREATE TABLE `record` (
  `id_record` int(11) NOT NULL AUTO_INCREMENT,
  `id_rep` int(11) DEFAULT '0',
  `id_user` int(11) NOT NULL DEFAULT '0',
  `comm_rec` varchar(255) NOT NULL DEFAULT '',
  `date_rec` date NOT NULL DEFAULT '0000-00-00',
  `id_app` int(11) NOT NULL DEFAULT '0',
  `id_fail` int(11) DEFAULT '0',
  `id_img` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_record`),
  KEY `id_rec_rep` (`id_rep`),
  KEY `id_rec_app` (`id_app`),
  KEY `id_rec_fail` (`id_fail`),
  KEY `id_rec_img` (`id_img`),
  CONSTRAINT `id_rec_app` FOREIGN KEY (`id_app`) REFERENCES `app` (`id_app`),
  CONSTRAINT `id_rec_fail` FOREIGN KEY (`id_fail`) REFERENCES `failure` (`id_fail`),
  CONSTRAINT `id_rec_img` FOREIGN KEY (`id_img`) REFERENCES `image` (`id_img`),
  CONSTRAINT `id_rec_rep` FOREIGN KEY (`id_rep`) REFERENCES `report` (`id_rep`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "record"
#


#
# Structure for table "device-report"
#

CREATE TABLE `device-report` (
  `id_dev` varchar(30) NOT NULL DEFAULT '0',
  `id_rep` int(11) NOT NULL DEFAULT '0',
  KEY `id_rep_rep` (`id_rep`),
  KEY `id_dev_rep` (`id_dev`),
  CONSTRAINT `id_dev_rep` FOREIGN KEY (`id_dev`) REFERENCES `device` (`id_device`),
  CONSTRAINT `id_rep_rep` FOREIGN KEY (`id_rep`) REFERENCES `report` (`id_rep`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "device-report"
#


#
# Structure for table "user"
#

CREATE TABLE `user` (
  `id_user` int(11) NOT NULL DEFAULT '0',
  `name_user` varchar(45) NOT NULL DEFAULT '',
  `password` varchar(45) NOT NULL,
  `permission` int(1) NOT NULL DEFAULT '0',
  `avatar` varchar(255) NOT NULL DEFAULT '',
  `sesion` date NOT NULL DEFAULT '0000-00-00',
  PRIMARY KEY (`id_user`),
  UNIQUE KEY `idusuarios_UNIQUE` (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "user"
#

INSERT INTO `user` VALUES (1,'uclides@gmail.com','morales',0,'','0000-00-00');

#
# Structure for table "device-failure"
#

CREATE TABLE `device-failure` (
  `id_dev` varchar(30) NOT NULL DEFAULT '0',
  `id_fail` int(11) NOT NULL DEFAULT '0',
  `sta_fail_dev` varchar(30) NOT NULL DEFAULT '',
  `date_fail_dev` date NOT NULL DEFAULT '0000-00-00',
  `id_user` int(11) NOT NULL DEFAULT '0',
  KEY `id_fail` (`id_fail`),
  KEY `id_user_fail` (`id_user`),
  KEY `id_dev_fail` (`id_dev`),
  CONSTRAINT `id_dev_fail` FOREIGN KEY (`id_dev`) REFERENCES `device` (`id_device`),
  CONSTRAINT `id_fail` FOREIGN KEY (`id_fail`) REFERENCES `failure` (`id_fail`),
  CONSTRAINT `id_user_fail` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "device-failure"
#

