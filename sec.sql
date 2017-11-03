/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50713
Source Host           : localhost:3306
Source Database       : sec

Target Server Type    : MYSQL
Target Server Version : 50713
File Encoding         : 65001

Date: 2017-11-03 16:45:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for resources
-- ----------------------------
DROP TABLE IF EXISTS `resources`;
CREATE TABLE `resources` (
  `url` varchar(255) DEFAULT NULL,
  `resourcename` varchar(255) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of resources
-- ----------------------------
INSERT INTO `resources` VALUES ('/main/common', '主界面页面', '1');
INSERT INTO `resources` VALUES ('/main/admin', 'adminpage页面', '2');
INSERT INTO `resources` VALUES ('/main/normal', 'normalpage页面', '3');

-- ----------------------------
-- Table structure for roles
-- ----------------------------
DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles` (
  `rolename` varchar(255) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of roles
-- ----------------------------
INSERT INTO `roles` VALUES ('超级管理员', '1');
INSERT INTO `roles` VALUES ('普通管理员', '2');
INSERT INTO `roles` VALUES ('普通用户', '3');
INSERT INTO `roles` VALUES ('自定义角色', '4');

-- ----------------------------
-- Table structure for roles_resources
-- ----------------------------
DROP TABLE IF EXISTS `roles_resources`;
CREATE TABLE `roles_resources` (
  `rsid` int(11) DEFAULT NULL,
  `rid` int(11) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of roles_resources
-- ----------------------------
INSERT INTO `roles_resources` VALUES ('1', '1', '1');
INSERT INTO `roles_resources` VALUES ('2', '1', '2');
INSERT INTO `roles_resources` VALUES ('3', '1', '3');
INSERT INTO `roles_resources` VALUES ('1', '2', '4');
INSERT INTO `roles_resources` VALUES ('2', '2', '5');
INSERT INTO `roles_resources` VALUES ('1', '3', '6');
INSERT INTO `roles_resources` VALUES ('3', '3', '7');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('21232f297a57a5a743894a0e4a801fc3', 'zhangsan', '1');
INSERT INTO `users` VALUES ('21232f297a57a5a743894a0e4a801fc3', 'admin', '2');
INSERT INTO `users` VALUES ('21232f297a57a5a743894a0e4a801fc3', 'lisi', '3');

-- ----------------------------
-- Table structure for users_roles
-- ----------------------------
DROP TABLE IF EXISTS `users_roles`;
CREATE TABLE `users_roles` (
  `uid` int(11) DEFAULT NULL,
  `rid` int(11) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users_roles
-- ----------------------------
INSERT INTO `users_roles` VALUES ('2', '1', '1');
INSERT INTO `users_roles` VALUES ('1', '2', '2');
INSERT INTO `users_roles` VALUES ('3', '3', '3');
