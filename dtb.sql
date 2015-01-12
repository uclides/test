﻿# Host: localhost  (Version: 5.6.17)
# Date: 2015-01-12 07:19:06
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
  `id_blu` int(11) NOT NULL AUTO_INCREMENT,
  `type_blu` varchar(30) NOT NULL DEFAULT '',
  PRIMARY KEY (`id_blu`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

#
# Data for table "bluetooth"
#

INSERT INTO `bluetooth` VALUES (1,'Bluetooth v1.0'),(2,'Bluetooth v1.1'),(3,'Bluetooth v1.2'),(4,'Bluetooth v2.0'),(5,'Bluetooth v2.1'),(6,'Bluetooth v3.0'),(7,'Bluetooth v4.0');

#
# Structure for table "cpu"
#

CREATE TABLE `cpu` (
  `id_cpu` int(11) NOT NULL AUTO_INCREMENT,
  `name_cpu` varchar(255) NOT NULL DEFAULT '',
  `frec_cpu` varchar(20) NOT NULL DEFAULT '',
  `core_cpu` int(2) NOT NULL DEFAULT '0',
  `feature_cpu` varchar(255) NOT NULL DEFAULT '',
  `revision_cpu` varchar(30) NOT NULL DEFAULT '',
  `hard_cpu` varchar(30) NOT NULL DEFAULT '',
  `gpu` varchar(30) NOT NULL DEFAULT '',
  PRIMARY KEY (`id_cpu`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

#
# Data for table "cpu"
#

INSERT INTO `cpu` VALUES (1,'ere','ddweredd',1,'wer','dddwerwd','dwerrddd','ddwerdd'),(2,'ARMv7 Processor rev 3 (v7l)  1300MHz','1300000',4,';swp;half;thumb;fastmult;vfp;edsp;thumbee;neon;vfpv3;tls;vfpv4;idiva;idivt;',' 3',' 3','Mali');

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
  `locale_dev` varchar(20) NOT NULL DEFAULT '',
  `sto_ext_sd_t` varchar(20) NOT NULL DEFAULT '',
  `sto_ext_sd_d` varchar(20) NOT NULL DEFAULT '',
  `sto_s2sd_t` varchar(20) NOT NULL DEFAULT '',
  `sto_s2sd_d` varchar(20) NOT NULL DEFAULT '',
  `sto_inter_t` varchar(20) NOT NULL DEFAULT '',
  `sto_inter_d` varchar(20) NOT NULL DEFAULT '',
  `sto_sys_t` varchar(20) NOT NULL DEFAULT '',
  `sto_sys_d` varchar(20) NOT NULL DEFAULT '',
  `cache_sys_t` varchar(20) NOT NULL DEFAULT '',
  `cache_sys_d` varchar(20) NOT NULL DEFAULT '',
  `ram_t` varchar(20) NOT NULL DEFAULT '',
  `ram_d` varchar(20) NOT NULL DEFAULT '',
  `ram_l` varchar(20) NOT NULL DEFAULT '',
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

INSERT INTO `device` VALUES ('SP-5110',' SP-5110',' SP-5110',' 4.4.2','Linux version 3.4.67 (JB5@AndroidServer) (gcc version 4.7 (GCC) ) #1 SMP PREEMPT Tue Jun 3 143802 CST 2014',' KAAI277_VZA_En_1.06.603',' es_VE',' 7,46 GB',' 1,04 GB',' 145 MB',' 5,26 MB',' 13,24 GB',' 9,87 GB',' 886 MB',' 53,32 MB',' 123 MB',' 119 MB',' 0,94 GB',' 169 MB',' 24,89 MB','#663366','123','1233','123','123',7,X'31',X'7061636B6167653A636F6D2E616E64726F69642E646566636F6E7461696E65723B7061636B6167653A636F6D2E7072696D6174656C6162732E6765656B62656E63683B7061636B6167653A636F6D2E6D6564696174656B2E766F696365756E6C6F636B3B7061636B6167653A636F6D2E616E64726F69642E70686F6E653B7061636B6167653A636F6D2E627974656669736867616D65732E72696E6765643B7061636B6167653A636F6D2E676D2E64657370656761723B7061636B6167653A636F6D2E696E646965676F676F2E616E64726F69643B7061636B6167653A636F6D2E73706C6173687061646D6F62696C652E626174746572793B7061636B6167653A636F6D2E616E64726F69642E626C7565746F6F74683B7061636B6167653A636F6D2E616E64726F69642E70726F7669646572732E63616C656E6461723B7061636B6167653A6F72672E7567756573732E616E64726F69642E737973696E666F3B7061636B6167653A636F6D2E6D6564696174656B2E766F696365636F6D6D616E643B7061636B6167653A636F6D2E746D736F66742E636F6D70756C736976653B7061636B6167653A636F6D2E616E64726F69642E62726F777365723B7061636B6167653A636F6D2E6D67796170702E616E64726F69643B7061636B6167653A636F6D2E616E64726F69642E6D757369633B7061636B6167653A636F6D2E7169686F6F3336302E6C61756E636865723B7061636B6167653A636F6D2E616E64726F69642E70726F7669646572732E646F776E6C6F6164732E75693B7061636B6167653A636F6D2E616E64726F69642E6C61756E63686572333B7061636B6167653A636F6D2E616E64726F69642E646F63756D656E747375693B7061636B6167653A636F6D2E696E7374616772616D2E616E64726F69643B7061636B6167653A636F6D2E6D6564696174656B2E766964656F706C617965723B7061636B6167653A636F6D2E616E64726F69642E76706E6469616C6F67733B7061636B6167653A636F6D2E61636375776561746865722E616E64726F69643B7061636B6167653A636F6D2E616E64726F69642E6D6D733B7061636B6167653A636F6D2E616E64726F69642E70726F7669646572732E6D656469613B7061636B6167653A636F6D2E6F706572612E6272616E64696E673B7061636B6167653A636F6D2E6C756D6F736C6162732E6C756D6F736974793B7061636B6167653A636F6D2E6D6564696174656B2E626C7565746F6F74683B7061636B6167653A636F6D2E676F6F676C652E616E64726F69642E736574757077697A6172643B7061636B6167653A636F6D2E6D6564696174656B2E626174746572797761726E696E673B7061636B6167653A636F6D2E616E64726F69642E73657474696E67733B7061636B6167653A636F6D2E6D6F626973797374656D732E656469746F722E6F66666963655F6170705F6174746163683B7061636B6167653A636F6D2E6675747572656D61726B2E646D616E64726F69642E6170706C69636174696F6E3B7061636B6167653A636F6D2E676F6F676C652E616E64726F69642E7374726565743B7061636B6167653A636F6D2E676F6F676C652E616E64726F69642E617070732E67656E69652E67656E69657769646765743B7061636B6167653A636F6D2E6167696C65736F66747265736F757263653B7061636B6167653A636F6D2E6D6564696174656B2E746865726D616C6D616E616765723B7061636B6167653A636F6D2E6D6564696174656B2E63616C656E646172696D706F727465723B7061636B6167653A636F6D2E66616365626F6F6B2E6B6174616E613B7061636B6167653A636F6D2E676F6F676C652E616E64726F69642E676F6F676C65717569636B736561726368626F783B7061636B6167653A636F6D2E616E64726F69642E70726F7669646572732E64726D3B7061636B6167653A636F6D2E7370617274616E636F646572732E67746F6B3B7061636B6167653A636F6D2E616E64726F69642E6D757369637669733B7061636B6167653A636F6D2E616E64726F69642E65786368616E67653B7061636B6167653A636F6D2E676F6D626F736465762E646973706C61797465737465723B7061636B6167653A636F6D2E676F6F676C652E616E64726F69642E6261636B75707472616E73706F72743B7061636B6167653A636F6D2E616E64726F69642E70726F7669646572732E74656C6570686F6E793B7061636B6167653A636F6D2E6D6564696174656B2E43656C6C436F6E6E536572766963653B7061636B6167653A636F6D2E6D782E62726F777365723B7061636B6167653A636F6D2E676F6F676C652E616E64726F69642E617070732E6D6170733B7061636B6167653A636F6D2E616E64726F69642E6469616C65723B7061636B6167653A636F6D2E6461746176697A2E646F6373746F676F3B7061636B6167653A636F6D2E676F6F676C652E616E64726F69642E617070732E636C6F75647072696E743B7061636B6167653A636F6D2E65656D62632E636F72656D61726B3B7061636B6167653A636F6D2E616E747574752E4142656E63684D61726B3B7061636B6167653A636F6D2E616E64726F69642E70726F7669646572732E73657474696E67733B7061636B6167653A636F6D2E676F6F676C652E616E64726F69642E617070732E646F63733B7061636B6167653A636F6D2E616E64726F69642E70726F7669646572732E646F776E6C6F6164733B7061636B6167653A636F6D2E6B69646F7A3B7061636B6167653A636F6D2E6D6564696174656B2E464D526164696F3B7061636B6167653A636F6D2E7465616D7669657765722E7465616D7669657765722E6D61726B65742E6D6F62696C653B7061636B6167653A636F6D2E616E64726F69642E70686173656265616D3B7061636B6167653A636F6D2E6D6564696174656B2E746F646F733B7061636B6167653A6A702E636F2E7472616E736C696D69742E627261696E776172733B7061636B6167653A636F6D2E6D6564696174656B2E766C773B7061636B6167653A636F6D2E6275616B2E4C696E6B3253443B7061636B6167653A636F6D2E63707569642E6370755F7A3B7061636B6167653A636F6D2E676F6F676C652E616E64726F69642E6F6E6574696D65696E697469616C697A65723B7061636B6167653A636F6D2E61646F62652E7265616465723B7061636B6167653A636F6D2E6D6779756E2E7375706572757365723B7061636B6167653A636F6D2E616E64726F69642E696E707574646576696365733B7061636B6167653A737465726963736F6E2E62757379626F783B7061636B6167653A636F6D2E616E64726F69642E73746B3B7061636B6167653A636F6D2E6D6564696174656B2E766964656F6661766F72697465733B7061636B6167653A636F6D2E676F6F676C652E616E64726F69642E636F6E666967757064617465723B7061636B6167653A636F6D2E7765706C6179646F74732E74776F646F7473616E64726F69643B7061636B6167653A636F6D2E676F6F676C652E616E64726F69642E6B6565703B7061636B6167653A636F6D2E6261747465727962656E63683B7061636B6167653A636F6D2E6D6564696174656B3B7061636B6167653A616E64726F69643B7061636B6167653A636F6D2E616E64726F69642E70726F7669646572732E636F6E74616374733B7061636B6167653A636F6D2E616E64726F69642E70726F746970733B7061636B6167653A636F6D2E676F6F676C652E616E64726F69642E617070732E75706C6F616465723B7061636B6167653A636F6D2E616E64726F69642E65787465726E616C73746F726167653B7061636B6167653A636F6D2E676F6F676C652E616E64726F69642E617070732E7472616E736C6174653B7061636B6167653A636F6D2E616E64726F69642E70726F7669646572732E6170706C69636174696F6E733B7061636B6167653A636F6D2E746F756368747970652E73776966746B65792E70686F6E652E747269616C3B7061636B6167653A636F6D2E676F6F676C652E616E64726F69642E617070732E706C75733B7061636B6167653A636F6D2E616E64726F69642E76656E64696E673B7061636B6167653A636F6D2E476F2E456E674D6F64654D746B53686F72746375743B7061636B6167653A76652E636F6D2E736F6465786F2E62656E65666963696172696F736D6F62696C653B7061636B6167653A636F6D2E616E64726F69642E73696D6D656C6F636B3B7061636B6167653A636F6D2E736B67616D65732E7472616666696372616365723B7061636B6167653A636F6D2E616E64726F69642E6B6579636861696E3B7061636B6167653A636F6D2E6465766963656D616E616765723B7061636B6167653A636F6D2E676F6F676C652E616E64726F69642E7461673B7061636B6167653A636F6D2E616E64726F69642E77616C6C70617065723B7061636B6167653A636F6D2E7269676874776172652E426173656D61726B4F5349493B7061636B6167653A636F6D2E676F6F676C652E616E64726F69642E617070732E6D6167617A696E65733B7061636B6167653A636F6D2E6D6564696174656B2E656E67696E6565726D6F64653B7061636B6167653A636F6D2E6D65646961667269656E64732E6368696D653B7061636B6167653A636F6D2E676F6F676C652E616E64726F69642E6773663B7061636B6167653A636F6D2E6D6564696174656B2E73797374656D7570646174652E7379736F7065723B7061636B6167653A636F6D2E616E64726F69642E6B657967756172643B7061636B6167653A636F6D2E6A686F616E3B7061636B6167653A636F6D2E676F6F676C652E616E64726F69642E617070732E696E626F783B7061636B6167653A636F6D2E616E64726F69642E7368656C6C3B7061636B6167653A636F6D2E6D6564696174656B2E61707067756964652E706C7567696E3B7061636B6167653A64652E6F6E7978626974732E72656D6F74656B6579626F6172643B7061636B6167653A636F6D2E6D6564696174656B2E53746B53656C656374696F6E3B7061636B6167653A636F6D2E676F6F676C652E616E64726F69642E73796E6361646170746572732E636F6E74616374733B7061636B6167653A636F6D2E6D6564696174656B2E73656375726974793B7061636B6167653A64652E726F62762E616E64726F69642E78706F7365642E696E7374616C6C65723B7061636B6167653A636F6D2E616E64726F69642E70726F7669646572732E706172746E6572626F6F6B6D61726B733B7061636B6167653A636F6D2E616E64726F69642E636F6E74616374733B7061636B6167653A636F6D2E6D6564696174656B2E6C62732E656D3B7061636B6167653A636F6D2E7269676874776172652E426173656D61726B585F467265653B7061636B6167653A636F6D2E616E64726F69642E63616C63756C61746F72323B7061636B6167653A636F6D2E616E64726F69642E68746D6C7669657765723B7061636B6167653A636F6D2E676C62656E63686D61726B2E676C62656E63686D61726B32373B7061636B6167653A636F6D2E7468656D6F6E7374657269742E456E67696E656572537461727465723B7061636B6167653A636F6D2E73796E6572677967622E6D657263616E74696C2E62616E636F2E62616E63616D6F76696C3B7061636B6167653A636F6D2E676F6F676C652E616E64726F69642E6773662E6C6F67696E3B7061636B6167653A636F6D2E6D6F68616D6D616461672E636F6C6F757265647374617475736261723B7061636B6167653A636F6D2E6D6564696174656B2E6D746B6C6F676765723B7061636B6167653A6F72672E74656C656772616D2E6D657373656E6765723B7061636B6167653A636F6D2E616E64726F69642E6F6E6574696D65696E697469616C697A65723B7061636B6167653A636F6D2E6269616E6F722E616D733B7061636B6167653A636F6D2E616E64726F69642E73686172656473746F726167656261636B75703B7061636B6167653A636F6D2E6D6564696174656B2E66696C656D616E616765723B7061636B6167653A636F6D2E7375726D696E2E7371756172653B7061636B6167653A6F72672E756C722E77696E6D61696C3B7061636B6167653A636F6D2E676F6F676C652E616E64726F69642E6D617276696E2E74616C6B6261636B3B7061636B6167653A636F6D2E63616D706D6F62696C652E6C61756E636865723B7061636B6167653A636F6D2E616E64726F69642E63657274696E7374616C6C65723B7061636B6167653A636F6D2E6D6564696174656B2E636F6E6E65637469766974793B7061636B6167653A636F6D2E676F6F676C652E616E64726F69642E676D733B7061636B6167653A6E65742E736F75726365666F7267652E6F70656E63616D6572613B7061636B6167653A636F6D2E6E7261626F792E73716C746F6F6C3B7061636B6167653A636F6D2E6A72756D6D792E726F6F742E62726F77736572667265653B7061636B6167653A636F6D2E616E64726F69642E67616C6C65727933643B7061636B6167653A636F6D2E676F6F676C652E616E64726F69642E6D757369633B7061636B6167653A636F6D2E6D6564696174656B2E4461746155736167654C6F636B53637265656E436C69656E743B7061636B6167653A636F6D2E616E64726F69642E77616C6C70617065722E6C6976657069636B65723B7061636B6167653A636F6D2E676F6F676C652E616E64726F69642E696E7075746D6574686F642E6C6174696E3B7061636B6167653A636F6D2E616E64726F69642E7061636B616765696E7374616C6C65723B7061636B6167653A636F6D2E676F6F676C652E616E64726F69642E7474733B7061636B6167653A636F6D2E6D6564696174656B2E7363687077726F6E6F66663B7061636B6167653A636F6D2E616E64726F69642E6E6F6973656669656C643B7061636B6167653A636F6D2E616E64726F69642E656D61696C3B7061636B6167653A636F6D2E616E64726F69642E6C6F636174696F6E2E66757365643B7061636B6167653A636F6D2E616E64726F69642E6261636B7570636F6E6669726D3B7061636B6167653A636F6D2E616E64726F69642E6D61676963736D6F6B653B7061636B6167653A636F6D2E766572746963616C617070732E72657461696C766132303B7061636B6167653A636F6D2E666C79696E676F74746572736F6674776172652E6D6567613B7061636B6167653A636F6D2E6769746875622E6D6F62696C653B7061636B6167653A636F6D2E71756963696E632E76656C6C616D6F3B7061636B6167653A636F6D2E676F6F676C652E616E64726F69642E766964656F656469746F723B7061636B6167653A636F6D2E68756E677279626F6C6F2E72656D6F74656D6F757365616E64726F69643B7061636B6167653A636F6D2E616E64726F69642E6D7573696366783B7061636B6167653A636F6D2E676F6F676C652E616E64726F69642E617070732E626F6F6B733B7061636B6167653A636F6D2E616E64726F69642E736F756E647265636F726465723B7061636B6167653A636F6D2E676F6F676C652E616E64726F69642E706172746E657273657475703B7061636B6167653A636F6D2E616E64726F69642E70726F787968616E646C65723B7061636B6167653A636F6D2E6170706174746163682E737567676573746564617070733B7061636B6167653A636F6D2E616E64726F69642E77616C6C70617065722E686F6C6F73706972616C3B7061636B6167653A636F6D2E676F6F676C652E616E64726F69642E666565646261636B3B7061636B6167653A636F6D2E676F6F676C652E616E64726F69642E74616C6B3B7061636B6167653A636F6D2E77686174736170703B7061636B6167653A636F6D2E77696C6474616E67656E742E616E64726F69643B7061636B6167653A636F6D2E616E64726F69642E70726F7669646572732E7573657264696374696F6E6172793B7061636B6167653A636F6D2E7375706572636C65616E65723B7061636B6167653A636F6D2E6D6564696174656B2E617073742E7461726765743B7061636B6167653A636F6D2E747769747465722E616E64726F69643B7061636B6167653A636F6D2E6D6564696174656B2E73797374656D7570646174653B7061636B6167653A636F6D2E7375727061782E6C6564666C6173686C696768742E70616E656C3B7061636B6167653A636F6D2E616E64726F69642E70616370726F636573736F723B7061636B6167653A636F6D2E736B7970652E7261696465723B7061636B6167653A636F6D2E73686F6F7A686F6F2E696D616765726573697A65723B7061636B6167653A636F6D2E616E64726F69642E67616C617879343B7061636B6167653A636F6D2E616E64726F69642E7072696E7473706F6F6C65723B7061636B6167653A63632E6D61646B6974652E66726565646F6D3B7061636B6167653A636F6D2E6D6F76696C652E706C61796B6964733B7061636B6167653A636F6D2E616E64726F69642E647265616D732E62617369633B7061636B6167653A636F6D2E676F6F676C652E616E64726F69642E706C61792E67616D65733B7061636B6167653A636F6D2E616E64726F69642E73797374656D75693B7061636B6167653A636F6D2E7370656564736F6674776172652E73716C656469746F723B7061636B6167653A636F6D2E676F6F676C652E616E64726F69642E676D3B7061636B6167653A636F6D2E6F706572612E6D696E692E616E64726F69643B7061636B6167653A636F6D2E676F6F676C652E616E64726F69642E73796E6361646170746572732E626F6F6B6D61726B733B7061636B6167653A636F6D2E676F6F676C652E616E64726F69642E796F75747562653B7061636B6167653A636F6D2E616E64726F69642E6465736B636C6F636B3B7061636B6167653A636F6D2E676F6F676C652E616E64726F69642E63616C656E6461723B7061636B6167653A636F6D2E616E64726F69642E666163656C6F636B3B7061636B6167653A636F6D2E616E64726F69642E6368726F6D653B7061636B6167653A636F6D2E6D6564696174656B2E796770733B7061636B6167653A636F6D2E796F646F312E63726F737379726F61643B');

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

INSERT INTO `device_battery` VALUES ('SP-5110',1,'3000');

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

INSERT INTO `device_cam` VALUES ('SP-5110','primary',' 12.675 Megapixels',X'31','240x320;480x640;768x1024;720x1280;768x1280;960x1280;1200x1600;1536x2048;1440x2560;1920x2560;2448x3264;1872x3328;1728x2880;2160x3600;3072x4096;3120x4160;12.675Megapixels;','144x176;320x480;480x640;480x864;720x1280;1080x1920;','auto;macro;infinity;continuous-picture;continuous-video;manual;fullscan;',' auto',' 1','auto,incandescent,fluorescent,warm-fluorescent,daylight,cloudy-daylight,twilight,shade','auto,portrait,landscape,night,night-portrait,theatre,beach,snow,sunset,steadyphoto,fireworks,sports,party,candlelight,hdr',X'30',' 100',' 100'),('SP-5110','secundary',' 4.86 Megapixels',X'30','240x320;480x640;768x1024;720x1280;768x1280;960x1280;1200x1600;1536x2048;1440x2560;1920x2560;1728x2880;4.86Megapixels;','144x176;320x480;480x640;480x864;720x1280;1080x1920;','N/A','N/A','N/A','N/A','N/A',X'30','N/A','N/A');

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

INSERT INTO `device_cpu` VALUES ('SP-5110',2);

#
# Structure for table "display_tactil"
#

CREATE TABLE `display_tactil` (
  `id_tactil` int(11) NOT NULL AUTO_INCREMENT,
  `name_tactil` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`id_tactil`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

#
# Data for table "display_tactil"
#

INSERT INTO `display_tactil` VALUES (1,'capacitivo'),(2,'resistivo');

#
# Structure for table "display_type"
#

CREATE TABLE `display_type` (
  `id_type_dis` int(11) NOT NULL AUTO_INCREMENT,
  `name_dis` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`id_type_dis`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

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
  CONSTRAINT `i_dev` FOREIGN KEY (`i_dev`) REFERENCES `device` (`id_device`),
  CONSTRAINT `i_dis` FOREIGN KEY (`id_dis`) REFERENCES `display_type` (`id_type_dis`),
  CONSTRAINT `type_tac` FOREIGN KEY (`type_tac`) REFERENCES `display_tactil` (`id_tactil`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "display"
#

INSERT INTO `display` VALUES ('SP-5110',1,720,1280,1,' 4.59\"',' 59.370003\"',' 320 dpi','1234');

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
# Structure for table "device_format"
#

CREATE TABLE `device_format` (
  `id_dev` varchar(30) NOT NULL DEFAULT '0',
  `id_for` int(11) NOT NULL DEFAULT '0',
  KEY `id_for_for` (`id_for`),
  KEY `id_dev_for` (`id_dev`),
  CONSTRAINT `id_dev_for` FOREIGN KEY (`id_dev`) REFERENCES `device` (`id_device`),
  CONSTRAINT `id_for_for` FOREIGN KEY (`id_for`) REFERENCES `format` (`id_for`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "device_format"
#


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
# Structure for table "material"
#

CREATE TABLE `material` (
  `id_mat` int(11) NOT NULL AUTO_INCREMENT,
  `name_mat` varchar(30) NOT NULL DEFAULT '',
  PRIMARY KEY (`id_mat`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

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

INSERT INTO `device_mat` VALUES ('SP-5110',1),('SP-5110',2);

#
# Structure for table "network"
#

CREATE TABLE `network` (
  `id_net` int(11) NOT NULL AUTO_INCREMENT,
  `type_net` varchar(30) NOT NULL DEFAULT '',
  `val_net` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`id_net`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

#
# Data for table "network"
#

INSERT INTO `network` VALUES (1,'mobile','900 MHz'),(2,'mobile','850 MHz'),(3,'mobile','1900 Mhz'),(4,'mobile','1800 MHz'),(5,'wifi','802.11'),(6,'wifi','802.11A'),(7,'wifi','802.11b'),(8,'wifi','802.11N'),(9,'wifi','802.11g'),(10,'wifi','802.11CA');

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

INSERT INTO `device_network` VALUES ('SP-5110',1),('SP-5110',5),('SP-5110',6);

#
# Structure for table "other_support"
#

CREATE TABLE `other_support` (
  `id_sup` int(11) NOT NULL AUTO_INCREMENT,
  `name_sup` varchar(20) NOT NULL DEFAULT '',
  `desc_sup` varchar(20) NOT NULL DEFAULT '',
  `type` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`id_sup`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

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
  CONSTRAINT `id_sup_sup` FOREIGN KEY (`id_sup`) REFERENCES `other_support` (`id_sup`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "device_support"
#

INSERT INTO `device_support` VALUES ('SP-5110',1);

#
# Structure for table "params"
#

CREATE TABLE `params` (
  `idparams` int(11) NOT NULL AUTO_INCREMENT,
  `nparams` varchar(30) NOT NULL DEFAULT '',
  `values` varchar(400) NOT NULL DEFAULT '',
  PRIMARY KEY (`idparams`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

#
# Data for table "params"
#

INSERT INTO `params` VALUES (1,'del año','2014'),(2,'memoria RAM','512 MB;1 GB;2 GB'),(3,'tamaño','3.5;4.3;4.7;5.0;5.5'),(4,'núcleos','1;2;4;6;8');

#
# Structure for table "preferences"
#

CREATE TABLE `preferences` (
  `id_preference` int(11) NOT NULL AUTO_INCREMENT,
  `n_pref` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`id_preference`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

#
# Data for table "preferences"
#

INSERT INTO `preferences` VALUES (1,'info_initial');

#
# Structure for table "provider"
#

CREATE TABLE `provider` (
  `id_provider` int(11) NOT NULL AUTO_INCREMENT,
  `name_provider` varchar(255) NOT NULL DEFAULT '',
  `contacts_provider` varchar(255) NOT NULL DEFAULT '',
  `detail_provider` varchar(255) DEFAULT '',
  PRIMARY KEY (`id_provider`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

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
# Structure for table "device_report"
#

CREATE TABLE `device_report` (
  `id_dev` varchar(30) NOT NULL DEFAULT '0',
  `id_rep` int(11) NOT NULL DEFAULT '0',
  KEY `id_rep_rep` (`id_rep`),
  KEY `id_dev_rep` (`id_dev`),
  CONSTRAINT `id_dev_rep` FOREIGN KEY (`id_dev`) REFERENCES `device` (`id_device`),
  CONSTRAINT `id_rep_rep` FOREIGN KEY (`id_rep`) REFERENCES `report` (`id_rep`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "device_report"
#


#
# Structure for table "test"
#

CREATE TABLE `test` (
  `id_test` int(11) NOT NULL AUTO_INCREMENT,
  `name_test` varchar(255) NOT NULL DEFAULT '',
  `des_test` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_test`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;

#
# Data for table "test"
#

INSERT INTO `test` VALUES (1,'antutu','prueba todos los aspectos de un dispositivo, incluyendo UX, GPU, RAM, CPU, I / O'),(2,'battery benchmark','test de bateria  simula un uso pseudo-realista de su teléfono: GPS, WiFi, Bluetooth, CPU, pantalla, envía y recibe datos a través de la red'),(3,'AndEBench','método estandarizado, aceptada por la industria de la evaluación de rendimiento de la plataforma Android'),(4,'3DMark','prueba de OpenGL ES 2.0, prueba el rendimiento y la vida de la batería'),(6,'Geekbench',' pruebas diseñadas para simular escenarios del mundo real'),(7,'Vellamo','pruebas con el navegador web, multi-core y distintos componentes del dispositivo'),(10,'Basemark X','referencia de rendimiento para juegos profesionales'),(11,'Basemark OS II','ofrece puntuaciones generales en cinco áreas diferentes, incluyendo el sistema,\r\nmemoria, gráficos, navegación web y la cámara.'),(12,'Display Tester','poner a prueba los aspectos de la pantalla'),(13,'twitter','aplicación de red social'),(14,'instagram','aplicación de red social'),(15,'facebook','aplicación de red social'),(16,'whatsapp','aplicación de mensajeria'),(17,'skype','aplicación de mesajeria');

#
# Structure for table "device_test"
#

CREATE TABLE `device_test` (
  `id_test_test` int(11) NOT NULL DEFAULT '0',
  `id_dev_test` varchar(30) NOT NULL DEFAULT '',
  `result_test` int(11) NOT NULL DEFAULT '0',
  KEY `id_test_test` (`id_test_test`),
  KEY `id_dev_test` (`id_dev_test`),
  CONSTRAINT `id_dev_test` FOREIGN KEY (`id_dev_test`) REFERENCES `device` (`id_device`),
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

INSERT INTO `user` VALUES (1,'admin','admin',1,'file:C:\\\\application\\\\user\\\\icons\\\\admin.png','2014-10-10'),(2,'uclides','morales',0,'file:C:\\\\application\\\\user\\\\icons\\\\user.png','2014-10-10');

#
# Structure for table "device_failure"
#

CREATE TABLE `device_failure` (
  `id_dev` varchar(30) NOT NULL DEFAULT '0',
  `id_fail` int(11) NOT NULL DEFAULT '0',
  `sta_fail_dev` varchar(30) NOT NULL DEFAULT '',
  `date_fail_dev` date NOT NULL DEFAULT '0000-00-00',
  `id_img_fail` int(11) DEFAULT '0',
  `id_user` int(11) NOT NULL DEFAULT '0',
  KEY `id_fail` (`id_fail`),
  KEY `id_user_fail` (`id_user`),
  KEY `id_dev_fail` (`id_dev`),
  CONSTRAINT `id_dev_fail` FOREIGN KEY (`id_dev`) REFERENCES `device` (`id_device`),
  CONSTRAINT `id_fail` FOREIGN KEY (`id_fail`) REFERENCES `failure` (`id_fail`),
  CONSTRAINT `id_user_fail` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "device_failure"
#


#
# Structure for table "user_preferences"
#

CREATE TABLE `user_preferences` (
  `u_pref` int(11) NOT NULL DEFAULT '0',
  `id_pref` int(11) NOT NULL DEFAULT '0',
  `desc_pref` varchar(255) NOT NULL DEFAULT '',
  KEY `id_pref` (`u_pref`),
  CONSTRAINT `id_pref` FOREIGN KEY (`u_pref`) REFERENCES `preferences` (`id_preference`),
  CONSTRAINT `u_pref` FOREIGN KEY (`u_pref`) REFERENCES `user` (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "user_preferences"
#

INSERT INTO `user_preferences` VALUES (1,1,'true');
