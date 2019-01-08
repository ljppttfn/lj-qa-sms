DROP TABLE IF EXISTS `port_info`;
CREATE TABLE IF NOT EXISTS `port_info` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `PortNum` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '端口号',
  `IMSI` varchar(255) NOT NULL DEFAULT '' COMMENT '用户识别码(IMSI)',
  `ICCID` varchar(255) DEFAULT '' COMMENT '卡识别码(ICCID)',
  `PhoNum` varchar(255) DEFAULT NULL COMMENT '手机号',
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

# Data exporting was unselected.


# Dumping structure for table spcard.sms_recv
DROP TABLE IF EXISTS `sms_recv`;
CREATE TABLE IF NOT EXISTS `sms_recv` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `PortNum` int(11) unsigned DEFAULT '0' COMMENT '接收短信的端口号',
  `PhoNum` varchar(255) DEFAULT '' COMMENT '手机号',
  `IMSI` varchar(255) DEFAULT NULL COMMENT '用户识别码(IMSI)',
  `ICCID` varchar(255) DEFAULT NULL COMMENT '卡识别码(ICCID)',
  `smsDate` varchar(255) NOT NULL DEFAULT '' COMMENT '短信日期，注意是smsDate而不是smsData',
  `smsNumber` varchar(255) NOT NULL DEFAULT '' COMMENT '短信号码',
  `smsContent` varchar(255) NOT NULL DEFAULT '' COMMENT '短信内容',
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

# Data exporting was unselected.


# Dumping structure for table spcard.sms_send
DROP TABLE IF EXISTS `sms_send`;
CREATE TABLE IF NOT EXISTS `sms_send` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `PortNum` int(11) DEFAULT '-1' COMMENT '大于0表示指定端口号发送',
  `smsNumber` varchar(255) NOT NULL DEFAULT '' COMMENT '接收号码',
  `smsSubject` varchar(255) DEFAULT '' COMMENT '彩信标题，如果发送彩信不能为空',
  `smsContent` varchar(255) NOT NULL DEFAULT '' COMMENT '发送内容',
  `smsType` int(11) unsigned DEFAULT '0' COMMENT '0:短信 1:彩信',
  `PhoNum` varchar(255) DEFAULT NULL COMMENT '手机号',
  `smsState` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '0:未发送 1:已在发送队列 2:发送成功 3:发送失败',
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;


DROP TABLE IF EXISTS `card_position`;
create table if not exists `card_position` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `PhoNum` varchar(20) NOT NULL DEFAULT '' COMMENT '手机号',
  `Pwd` varchar(20) DEFAULT '' COMMENT '服务密码',
  `IdCard` varchar(20) DEFAULT '' COMMENT '身份证信息，可能是身份证后6位',
  `Name` varchar(20) DEFAULT '' COMMENT '姓名，可选',
  `Type` varchar(5) DEFAULT '' COMMENT '运营商类型：10010 联通 ； 10086 移动；10000 电信',
  `Province` varchar(10) DEFAULT '' COMMENT '省份',
  `City` varchar(10) DEFAULT '' COMMENT '城市',
  `PoolID` int(11) NOT NULL  COMMENT '猫池设备编号',
  `PortNum` int(11) unsigned DEFAULT '0' COMMENT '接收短信的端口号',
  `Fee` int(5) DEFAULT 0 COMMENT '月套餐费',
  `Desc` varchar(255) COMMENT '其他备选信息',
  PRIMARY KEY (`Id`),
  unique KEY (`PhoNum`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT '手机号和猫池位置关系映射表';