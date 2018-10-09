/*
SQLyog Enterprise v12.2.6 (64 bit)
MySQL - 5.7.23 : Database - zzx
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`zzx` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `zzx`;

/*Table structure for table `menu` */

DROP TABLE IF EXISTS `menu`;

CREATE TABLE `menu` (
  `M_ID` varchar(64) NOT NULL COMMENT '资源id',
  `URL` varchar(100) NOT NULL COMMENT '访问url',
  `ICON` varchar(64) DEFAULT NULL COMMENT '图标',
  `ROUTE` varchar(100) DEFAULT NULL COMMENT '路由',
  `PARENTID` varchar(64) DEFAULT NULL COMMENT '父菜单id',
  `NAME` varchar(100) NOT NULL COMMENT '菜单名称',
  PRIMARY KEY (`M_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `menu` */

insert  into `menu`(`M_ID`,`URL`,`ICON`,`ROUTE`,`PARENTID`,`NAME`) values 
('04152a22c48411e889b4f48e38f6a292','/views/userpage',NULL,NULL,NULL,'用户页面'),
('04bec4bdc85b11e8a92900ff46f17c5f','/admin/**',NULL,'/admin1','f68f1cacc48311e889b4f48e38f6a292','管理员界面1'),
('194490d5c85b11e8a92900ff46f17c5f','/admin/**',NULL,'/admin2','f68f1cacc48311e889b4f48e38f6a292','管理员界面2'),
('c80b09e5c85a11e8a92900ff46f17c5f','/user/**',NULL,'/views/user1','04152a22c48411e889b4f48e38f6a292','用户界面1'),
('e9f28d26c85a11e8a92900ff46f17c5f','/user/**',NULL,'/views/user2','04152a22c48411e889b4f48e38f6a292','用户界面2'),
('f68f1cacc48311e889b4f48e38f6a292','/views/adminpage','el-icon-location',NULL,NULL,'管理员页面');

/*Table structure for table `menu_role` */

DROP TABLE IF EXISTS `menu_role`;

CREATE TABLE `menu_role` (
  `MR_ID` varchar(64) NOT NULL COMMENT '资源角色 id',
  `RID` varchar(64) NOT NULL COMMENT '角色id',
  `MID` varchar(64) NOT NULL COMMENT '资源id',
  PRIMARY KEY (`MR_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `menu_role` */

insert  into `menu_role`(`MR_ID`,`RID`,`MID`) values 
('0c9f206cc86a11e8a92900ff46f17c5f','eb324542c48311e889b4f48e38f6a292','c80b09e5c85a11e8a92900ff46f17c5f'),
('c7fa328cc85c11e8a92900ff46f17c5f','e1129ba2c48311e889b4f48e38f6a292','04bec4bdc85b11e8a92900ff46f17c5f'),
('d3c6c214c85c11e8a92900ff46f17c5f','e1129ba2c48311e889b4f48e38f6a292','194490d5c85b11e8a92900ff46f17c5f'),
('dc54d16bc85c11e8a92900ff46f17c5f','eb324542c48311e889b4f48e38f6a292','e9f28d26c85a11e8a92900ff46f17c5f'),
('ebb70234c48411e889b4f48e38f6a292','e1129ba2c48311e889b4f48e38f6a292','f68f1cacc48311e889b4f48e38f6a292'),
('f246d4c5c48411e889b4f48e38f6a292','eb324542c48311e889b4f48e38f6a292','04152a22c48411e889b4f48e38f6a292');

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `R_ID` varchar(64) NOT NULL COMMENT '角色id',
  `ROLENAME` varchar(64) NOT NULL COMMENT '角色名称ROLE_开头 spring security 规定',
  `ROLENAMEZH` varchar(64) NOT NULL COMMENT '角色中文名称',
  PRIMARY KEY (`R_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `role` */

insert  into `role`(`R_ID`,`ROLENAME`,`ROLENAMEZH`) values 
('e1129ba2c48311e889b4f48e38f6a292','ROLE_ADMIN','超级管理员'),
('eb324542c48311e889b4f48e38f6a292','ROLE_USER','普通用户');

/*Table structure for table `user_role` */

DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `UR_ID` varchar(64) NOT NULL COMMENT '用户角色id',
  `UID` varchar(64) NOT NULL COMMENT '用户id',
  `RID` varchar(64) NOT NULL COMMENT '角色id',
  PRIMARY KEY (`UR_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user_role` */

insert  into `user_role`(`UR_ID`,`UID`,`RID`) values 
('dbd4f2abc48411e889b4f48e38f6a292','c1a43798c48311e889b4f48e38f6a292','e1129ba2c48311e889b4f48e38f6a292'),
('e49e9d79c48411e889b4f48e38f6a292','cc548b19c48311e889b4f48e38f6a292','eb324542c48311e889b4f48e38f6a292');

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `U_ID` varchar(64) NOT NULL COMMENT '用户id',
  `USERNAME` varchar(64) NOT NULL COMMENT '用户名',
  `PASSWORD` varchar(64) NOT NULL COMMENT '密码',
  `TELEPTONE` varchar(11) DEFAULT NULL COMMENT '电话号码',
  `ADDRESS` varchar(100) DEFAULT NULL COMMENT '家庭住址',
  `ENABLED` varchar(1) NOT NULL COMMENT '是否启用 1 启用 0 禁止',
  `PETNAME` varchar(64) NOT NULL COMMENT '昵称',
  PRIMARY KEY (`U_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `users` */

insert  into `users`(`U_ID`,`USERNAME`,`PASSWORD`,`TELEPTONE`,`ADDRESS`,`ENABLED`,`PETNAME`) values 
('c1a43798c48311e889b4f48e38f6a292','admin','admin','13299090750','陕西省宝鸡市岐山县','1','管理员'),
('cc548b19c48311e889b4f48e38f6a292','user','user',NULL,NULL,'1','普通用户');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
