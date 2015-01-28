# Host: localhost  (Version: 5.6.17)
# Date: 2015-01-28 07:30:41
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
  PRIMARY KEY (`id_bat`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

#
# Data for table "battery"
#

INSERT INTO `battery` VALUES (1,'Ion-Litio'),(2,'Polímero-Litio');

#
# Structure for table "bluetooth"
#

CREATE TABLE `bluetooth` (
  `id_blu` int(11) NOT NULL DEFAULT '0',
  `type_blu` varchar(30) NOT NULL DEFAULT '',
  PRIMARY KEY (`id_blu`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "bluetooth"
#

INSERT INTO `bluetooth` VALUES (1,'Bluetooth v1.0'),(2,'Bluetooth v1.1'),(3,'Bluetooth v1.2'),(4,'Bluetooth v2.0'),(5,'Bluetooth v2.1'),(6,'Bluetooth v3.0'),(7,'Bluetooth v4.0');

#
# Structure for table "cpu"
#

CREATE TABLE `cpu` (
  `id_cpu` int(11) NOT NULL DEFAULT '0',
  `name_cpu` varchar(255) NOT NULL DEFAULT '',
  `frec_cpu` varchar(20) NOT NULL DEFAULT '',
  `core_cpu` int(2) NOT NULL DEFAULT '0',
  `feature_cpu` varchar(255) NOT NULL DEFAULT '',
  `revision_cpu` varchar(30) NOT NULL DEFAULT '',
  `hard_cpu` varchar(30) NOT NULL DEFAULT '',
  `gpu` varchar(30) NOT NULL DEFAULT '',
  PRIMARY KEY (`id_cpu`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "cpu"
#

INSERT INTO `cpu` VALUES (1,'ARMv7 Processor rev 3 (v7l)  1300MHz','1300000',4,';swp;half;thumb;fastmult;vfp;edsp;thumbee;neon;vfpv3;tls;vfpv4;idiva;idivt;',' 3',' 3','mali'),(2,'ARMv7 Processor rev 3 (v7l)  1040MHz','1040000',4,';swp;half;thumb;fastmult;vfp;edsp;thumbee;neon;vfpv3;tls;vfpv4;idiva;idivt;',' 3',' 3','Mali-400 MP');

#
# Structure for table "device"
#

CREATE TABLE `device` (
  `id_device` varchar(30) NOT NULL DEFAULT '0',
  `name_dev` varchar(30) NOT NULL DEFAULT '',
  `model_dev` varchar(30) NOT NULL DEFAULT '',
  `ver_so` varchar(10) NOT NULL DEFAULT '',
  `kernel` varchar(255) NOT NULL DEFAULT '',
  `build_dev` varchar(50) NOT NULL DEFAULT '',
  `locale_dev` varchar(50) NOT NULL DEFAULT '',
  `sto_ext_sd_t` varchar(50) NOT NULL DEFAULT '',
  `sto_ext_sd_d` varchar(50) NOT NULL DEFAULT '',
  `sto_s2sd_t` varchar(50) NOT NULL DEFAULT '',
  `sto_s2sd_d` varchar(50) NOT NULL DEFAULT '',
  `sto_inter_t` varchar(50) NOT NULL DEFAULT '',
  `sto_inter_d` varchar(50) NOT NULL DEFAULT '',
  `sto_sys_t` varchar(50) NOT NULL DEFAULT '',
  `sto_sys_d` varchar(50) NOT NULL DEFAULT '',
  `cache_sys_t` varchar(50) NOT NULL DEFAULT '',
  `cache_sys_d` varchar(50) NOT NULL DEFAULT '',
  `ram_t` varchar(50) NOT NULL DEFAULT '',
  `ram_d` varchar(50) NOT NULL DEFAULT '',
  `ram_l` varchar(50) NOT NULL DEFAULT '',
  `color` varchar(11) NOT NULL DEFAULT '0',
  `h_dev` varchar(10) NOT NULL DEFAULT '',
  `w_dev` varchar(10) NOT NULL DEFAULT '',
  `bulk_dev` varchar(10) NOT NULL DEFAULT '',
  `weight_dev` varchar(10) NOT NULL DEFAULT '',
  `id_blu` int(11) NOT NULL DEFAULT '0',
  `cert_google` binary(1) NOT NULL DEFAULT '\0',
  `all_app_dev` blob NOT NULL,
  PRIMARY KEY (`id_device`),
  UNIQUE KEY `iddispositivos_UNIQUE` (`id_device`),
  KEY `color_dev` (`color`),
  KEY `id_blu` (`id_blu`),
  CONSTRAINT `id_blu` FOREIGN KEY (`id_blu`) REFERENCES `bluetooth` (`id_blu`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "device"
#


#
# Structure for table "device_app"
#

CREATE TABLE `device_app` (
  `id_dev` varchar(30) NOT NULL DEFAULT '0',
  `id_app` int(11) NOT NULL DEFAULT '0',
  KEY `id_app` (`id_app`),
  KEY `id_dev_app` (`id_dev`),
  CONSTRAINT `id_app` FOREIGN KEY (`id_app`) REFERENCES `app` (`id_app`),
  CONSTRAINT `id_dev_app` FOREIGN KEY (`id_dev`) REFERENCES `device` (`id_device`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "device_app"
#


#
# Structure for table "device_battery"
#

CREATE TABLE `device_battery` (
  `id_dev_b` varchar(30) NOT NULL DEFAULT '0',
  `type_bat` int(11) NOT NULL DEFAULT '0',
  `capacity` varchar(20) DEFAULT '',
  KEY `id_dev_bat` (`id_dev_b`),
  KEY `id_bat_dev` (`type_bat`),
  CONSTRAINT `id_bat_dev` FOREIGN KEY (`type_bat`) REFERENCES `battery` (`id_bat`),
  CONSTRAINT `id_dev_bat` FOREIGN KEY (`id_dev_b`) REFERENCES `device` (`id_device`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "device_battery"
#


#
# Structure for table "device_cam"
#

CREATE TABLE `device_cam` (
  `id_dev_cam` varchar(30) NOT NULL DEFAULT '',
  `type_cam` varchar(10) NOT NULL DEFAULT '',
  `mp_cam` varchar(255) NOT NULL DEFAULT '',
  `flash_cam` binary(1) NOT NULL DEFAULT '\0',
  `supp_img_cam` varchar(400) NOT NULL DEFAULT '',
  `supp_vid_cam` varchar(400) NOT NULL DEFAULT '',
  `dis_focus` varchar(255) DEFAULT NULL,
  `focus_enabled` varchar(30) DEFAULT NULL,
  `focus_area` varchar(10) DEFAULT NULL,
  `whitebalance` varchar(255) DEFAULT NULL,
  `scene_mode` varchar(255) DEFAULT NULL,
  `sta_vid` binary(1) NOT NULL DEFAULT '\0',
  `q_jpeg` varchar(30) DEFAULT NULL,
  `q_thum` varchar(30) DEFAULT NULL,
  KEY `id_dev_cam` (`id_dev_cam`),
  CONSTRAINT `id_dev_cam` FOREIGN KEY (`id_dev_cam`) REFERENCES `device` (`id_device`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "device_cam"
#


#
# Structure for table "device_cpu"
#

CREATE TABLE `device_cpu` (
  `id_dev_cpu` varchar(30) NOT NULL DEFAULT '',
  `id_cpu_c` int(11) NOT NULL DEFAULT '0',
  KEY `id_dev_cpu` (`id_dev_cpu`),
  KEY `id_cpu_c` (`id_cpu_c`),
  CONSTRAINT `id_cpu_c` FOREIGN KEY (`id_cpu_c`) REFERENCES `cpu` (`id_cpu`),
  CONSTRAINT `id_dev_cpu` FOREIGN KEY (`id_dev_cpu`) REFERENCES `device` (`id_device`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "device_cpu"
#


#
# Structure for table "display_tactil"
#

CREATE TABLE `display_tactil` (
  `id_tactil` int(11) NOT NULL DEFAULT '0',
  `name_tactil` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`id_tactil`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "display_tactil"
#

INSERT INTO `display_tactil` VALUES (1,'capacitivo'),(2,'resistivo');

#
# Structure for table "display_type"
#

CREATE TABLE `display_type` (
  `id_type_dis` int(11) NOT NULL DEFAULT '0',
  `name_dis` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`id_type_dis`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "display_type"
#

INSERT INTO `display_type` VALUES (1,'LCD'),(2,'AMOLED'),(3,'TFT'),(4,'IPS'),(5,'S-LCD'),(6,'Super AMOLED'),(7,'TRI LUMINOUS');

#
# Structure for table "display"
#

CREATE TABLE `display` (
  `i_dev` varchar(30) NOT NULL DEFAULT '0',
  `id_dis` int(11) NOT NULL DEFAULT '0',
  `x_dis` int(11) NOT NULL DEFAULT '0',
  `y_dis` int(11) NOT NULL DEFAULT '0',
  `type_tac` int(11) NOT NULL DEFAULT '0',
  `size_dis` varchar(20) NOT NULL DEFAULT '',
  `r_rate` varchar(30) NOT NULL DEFAULT '',
  `dpi_dis` varchar(10) NOT NULL DEFAULT '',
  `contrast` varchar(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_dis`),
  KEY `type_tac` (`type_tac`),
  KEY `i_dev` (`i_dev`),
  CONSTRAINT `id_dis` FOREIGN KEY (`id_dis`) REFERENCES `display_type` (`id_type_dis`),
  CONSTRAINT `i_dev` FOREIGN KEY (`i_dev`) REFERENCES `device` (`id_device`),
  CONSTRAINT `type_tac` FOREIGN KEY (`type_tac`) REFERENCES `display_tactil` (`id_tactil`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "display"
#


#
# Structure for table "format"
#

CREATE TABLE `format` (
  `id_for` int(11) NOT NULL DEFAULT '0',
  `type_for` varchar(20) NOT NULL DEFAULT '',
  `desc_for` varchar(20) NOT NULL DEFAULT '',
  PRIMARY KEY (`id_for`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "format"
#


#
# Structure for table "device_format"
#

CREATE TABLE `device_format` (
  `id_dev` varchar(30) NOT NULL DEFAULT '0',
  `id_for` int(11) NOT NULL DEFAULT '0',
  KEY `id_for_for` (`id_for`),
  KEY `id_dev_for` (`id_dev`),
  CONSTRAINT `id_dev_for` FOREIGN KEY (`id_dev`) REFERENCES `device` (`id_device`),
  CONSTRAINT `id_for` FOREIGN KEY (`id_for`) REFERENCES `format` (`id_for`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "device_format"
#


#
# Structure for table "image"
#

CREATE TABLE `image` (
  `id_image` int(11) NOT NULL DEFAULT '0',
  `id_dev` varchar(30) DEFAULT '0',
  `type_img` varchar(20) NOT NULL DEFAULT '',
  `date_img` date NOT NULL DEFAULT '0000-00-00',
  `file_img` varchar(400) NOT NULL DEFAULT '',
  PRIMARY KEY (`id_image`),
  KEY `id_dev_i` (`id_dev`),
  CONSTRAINT `id_dev_i` FOREIGN KEY (`id_dev`) REFERENCES `device` (`id_device`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "image"
#


#
# Structure for table "device_failure"
#

CREATE TABLE `device_failure` (
  `id_fail` int(11) NOT NULL DEFAULT '0',
  `id_dev` varchar(30) NOT NULL DEFAULT '',
  `name_fail` varchar(255) NOT NULL DEFAULT '',
  `desc_fail` varchar(255) DEFAULT NULL,
  `id_img_fail` int(11) DEFAULT '0',
  `date_fail_dev` date NOT NULL DEFAULT '0000-00-00',
  `id_user` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_fail`),
  KEY `id_img_fail` (`id_img_fail`),
  CONSTRAINT `id_img_fail` FOREIGN KEY (`id_img_fail`) REFERENCES `image` (`id_image`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "device_failure"
#


#
# Structure for table "material"
#

CREATE TABLE `material` (
  `id_mat` int(11) NOT NULL DEFAULT '0',
  `name_mat` varchar(30) NOT NULL DEFAULT '',
  PRIMARY KEY (`id_mat`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "material"
#

INSERT INTO `material` VALUES (1,'aluminio y plastico'),(2,'aluminio'),(3,'plastico');

#
# Structure for table "device_mat"
#

CREATE TABLE `device_mat` (
  `id_dev_mat` varchar(30) NOT NULL DEFAULT '0',
  `id_mate` int(11) NOT NULL DEFAULT '0',
  KEY `id_mate` (`id_mate`),
  KEY `id_dev_mat` (`id_dev_mat`),
  CONSTRAINT `id_dev_mat` FOREIGN KEY (`id_dev_mat`) REFERENCES `device` (`id_device`),
  CONSTRAINT `id_mate` FOREIGN KEY (`id_mate`) REFERENCES `material` (`id_mat`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "device_mat"
#


#
# Structure for table "network"
#

CREATE TABLE `network` (
  `id_net` int(11) NOT NULL DEFAULT '0',
  `type_net` varchar(30) NOT NULL DEFAULT '',
  `val_net` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`id_net`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "network"
#

INSERT INTO `network` VALUES (1,'mobile','900 MHz'),(2,'mobile','850 MHz'),(3,'mobile','1900 MHz'),(4,'mobile','1800 MHz'),(5,'mobile','2100 MHz'),(6,'wifi','802.11'),(7,'wifi','802.11a'),(8,'wifi','802.11b'),(9,'wifi','802.11c'),(10,'wifi','802.11g'),(11,'wifi','802.11n');

#
# Structure for table "device_network"
#

CREATE TABLE `device_network` (
  `id_dev` varchar(30) NOT NULL DEFAULT '0',
  `net_dev` int(11) NOT NULL DEFAULT '0',
  KEY `id_net_net` (`net_dev`),
  KEY `id_dev_net` (`id_dev`),
  CONSTRAINT `id_dev_net` FOREIGN KEY (`id_dev`) REFERENCES `device` (`id_device`),
  CONSTRAINT `id_net_net` FOREIGN KEY (`net_dev`) REFERENCES `network` (`id_net`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "device_network"
#


#
# Structure for table "other_support"
#

CREATE TABLE `other_support` (
  `id_sup` int(11) NOT NULL DEFAULT '0',
  `name_sup` varchar(20) NOT NULL DEFAULT '',
  `desc_sup` varchar(20) NOT NULL DEFAULT '',
  `type` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`id_sup`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "other_support"
#

INSERT INTO `other_support` VALUES (1,'Acelerómetro','','sensor'),(2,'Giroscopio','','sensor'),(3,'Magnetómetro','','sensor'),(4,'Sensor de proximidad','','sensor'),(5,'Sensor de luz','','sensor'),(6,'Barómetro','','sensor'),(7,'Sensor de ritmo card','','sensor'),(8,'Termómetro y sensor ','','sensor'),(9,'Podómetro','','sensor'),(10,'Detector de huellas','','sensor');

#
# Structure for table "device_support"
#

CREATE TABLE `device_support` (
  `id_dev` varchar(30) NOT NULL DEFAULT '0',
  `id_sup` int(11) NOT NULL DEFAULT '0',
  KEY `id_sup_sup` (`id_sup`),
  KEY `id_dev_sup` (`id_dev`),
  CONSTRAINT `id_dev_sup` FOREIGN KEY (`id_dev`) REFERENCES `device` (`id_device`),
  CONSTRAINT `id_other_sup` FOREIGN KEY (`id_sup`) REFERENCES `other_support` (`id_sup`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "device_support"
#


#
# Structure for table "params"
#

CREATE TABLE `params` (
  `idparams` int(11) NOT NULL DEFAULT '0',
  `nparams` varchar(30) NOT NULL DEFAULT '',
  `nvalues` varchar(400) NOT NULL DEFAULT '',
  PRIMARY KEY (`idparams`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "params"
#

INSERT INTO `params` VALUES (1,'memoria RAM','512MB;1GB;2GB;3GB'),(2,'tamaño','3.5;4.3;4.7;5.0;5.5'),(3,'cores','1;2;4;6;8'),(4,'general','general');

#
# Structure for table "preferences"
#

CREATE TABLE `preferences` (
  `id_preference` int(11) NOT NULL DEFAULT '0',
  `n_pref` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`id_preference`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "preferences"
#

INSERT INTO `preferences` VALUES (1,'info_initial');

#
# Structure for table "provider"
#

CREATE TABLE `provider` (
  `id_provider` int(11) NOT NULL DEFAULT '0',
  `name_provider` varchar(255) NOT NULL DEFAULT '',
  `contacts_provider` varchar(255) NOT NULL DEFAULT '',
  `detail_provider` varchar(255) DEFAULT '',
  PRIMARY KEY (`id_provider`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "provider"
#

INSERT INTO `provider` VALUES (1,'konka','','');

#
# Structure for table "device_provider"
#

CREATE TABLE `device_provider` (
  `id_dev_prov` varchar(30) NOT NULL DEFAULT '',
  `id_prov` int(11) NOT NULL DEFAULT '0',
  KEY `id_dev_prov` (`id_dev_prov`),
  KEY `id_prov` (`id_prov`),
  CONSTRAINT `id_dev_prov` FOREIGN KEY (`id_dev_prov`) REFERENCES `device` (`id_device`),
  CONSTRAINT `id_prov` FOREIGN KEY (`id_prov`) REFERENCES `provider` (`id_provider`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "device_provider"
#


#
# Structure for table "report"
#

CREATE TABLE `report` (
  `id_rep` int(11) NOT NULL DEFAULT '0',
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
  `id_record` int(11) NOT NULL DEFAULT '0',
  `id_rep` int(11) DEFAULT '0',
  `id_user` int(11) NOT NULL DEFAULT '0',
  `comm_rec` varchar(255) NOT NULL DEFAULT '',
  `date_rec` date NOT NULL DEFAULT '0000-00-00',
  `id_app` int(11) NOT NULL DEFAULT '0',
  `id_img` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_record`),
  KEY `id_rec_rep` (`id_rep`),
  KEY `id_rec_app` (`id_app`),
  KEY `id_rec_img` (`id_img`),
  CONSTRAINT `id_rec_app` FOREIGN KEY (`id_app`) REFERENCES `app` (`id_app`),
  CONSTRAINT `id_rec_img` FOREIGN KEY (`id_img`) REFERENCES `image` (`id_image`),
  CONSTRAINT `id_rep` FOREIGN KEY (`id_rep`) REFERENCES `report` (`id_rep`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "record"
#


#
# Structure for table "device_report"
#

CREATE TABLE `device_report` (
  `id_dev` varchar(30) NOT NULL DEFAULT '0',
  `id_rep` int(11) NOT NULL DEFAULT '0',
  KEY `id_rep_rep` (`id_rep`),
  KEY `id_dev_rep` (`id_dev`),
  CONSTRAINT `id_dev_rep` FOREIGN KEY (`id_dev`) REFERENCES `device` (`id_device`),
  CONSTRAINT `id_report` FOREIGN KEY (`id_rep`) REFERENCES `report` (`id_rep`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "device_report"
#


#
# Structure for table "test"
#

CREATE TABLE `test` (
  `id_test` int(11) NOT NULL DEFAULT '0',
  `name_test` varchar(255) NOT NULL DEFAULT '',
  `des_test` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_test`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "test"
#

INSERT INTO `test` VALUES (1,'antutu','prueba todos los aspectos de un dispositivo, incluyendo UX, GPU, RAM, CPU, I / O'),(2,'battery benchmark','test de bateria  simula un uso pseudo-realista de su teléfono: GPS, WiFi, Bluetooth, CPU, pantalla, envía y recibe datos a través de la red'),(3,'AndEBench','método estandarizado, aceptada por la industria de la evaluación de rendimiento de la plataforma Android'),(4,'3DMark','prueba de OpenGL ES 2.0, prueba el rendimiento y la vida de la batería'),(5,'Geekbench',' pruebas diseñadas para simular escenarios del mundo real'),(6,'Vellamo','pruebas con el navegador web, multi-core y distintos componentes del dispositivo'),(7,'Basemark X','referencia de rendimiento para juegos profesionales'),(8,'Basemark OS II','ofrece puntuaciones generales en cinco áreas diferentes, incluyendo el sistema,\r\nmemoria, gráficos, navegación web y la cámara.'),(9,'Display Tester','poner a prueba los aspectos de la pantalla'),(10,'twitter','aplicación de red social'),(11,'instagram','aplicación de red social'),(12,'facebook','aplicación de red social'),(13,'whatsapp','aplicación de mensajeria'),(14,'skype','aplicación de mesajeria');

#
# Structure for table "device_test"
#

CREATE TABLE `device_test` (
  `id_test_test` int(11) NOT NULL DEFAULT '0',
  `id_dev_test` varchar(30) NOT NULL DEFAULT '',
  `id_img_test` int(11) NOT NULL DEFAULT '0',
  `compatibility` varchar(255) NOT NULL DEFAULT '',
  `result_test1` int(11) DEFAULT '0',
  `result_test2` int(11) DEFAULT '0',
  `result_test3` int(11) DEFAULT '0',
  `result_test4` int(11) DEFAULT '0',
  `result_test5` int(11) DEFAULT '0',
  KEY `id_test_test` (`id_test_test`),
  KEY `id_dev_test` (`id_dev_test`),
  KEY `id_img_test` (`id_img_test`),
  CONSTRAINT `id_dev_test` FOREIGN KEY (`id_dev_test`) REFERENCES `device` (`id_device`),
  CONSTRAINT `id_img_test` FOREIGN KEY (`id_img_test`) REFERENCES `image` (`id_image`),
  CONSTRAINT `id_test_test` FOREIGN KEY (`id_test_test`) REFERENCES `test` (`id_test`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "device_test"
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

INSERT INTO `user` VALUES (1,'admin','admin',1,'file:C:/application/user/icons/admin.png','2014-10-10'),(2,'uclides','morales',0,'file:C:/application/user/icons/user.png','2014-10-10');

#
# Structure for table "user_preferences"
#

CREATE TABLE `user_preferences` (
  `u_pref` int(11) NOT NULL DEFAULT '0',
  `id_pref` int(11) NOT NULL DEFAULT '0',
  `desc_pref` varchar(255) NOT NULL DEFAULT '',
  KEY `id_pref` (`u_pref`),
  KEY `id_pref_user` (`id_pref`),
  CONSTRAINT `id_pref_user` FOREIGN KEY (`id_pref`) REFERENCES `preferences` (`id_preference`),
  CONSTRAINT `u_pref` FOREIGN KEY (`u_pref`) REFERENCES `user` (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "user_preferences"
#

INSERT INTO `user_preferences` VALUES (1,1,'true');
