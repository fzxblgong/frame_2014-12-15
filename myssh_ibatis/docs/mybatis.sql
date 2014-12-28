/*
Navicat MySQL Data Transfer

Source Server         : localhost_5.1
Source Server Version : 50153
Source Host           : localhost:3306
Source Database       : mybatis

Target Server Type    : MYSQL
Target Server Version : 50153
File Encoding         : 65001

Date: 2014-12-28 23:12:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `organization`
-- ----------------------------
DROP TABLE IF EXISTS `organization`;
CREATE TABLE `organization` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `p_id` int(20) DEFAULT NULL,
  `name` varchar(25) DEFAULT NULL,
  `desc` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of organization
-- ----------------------------
INSERT INTO `organization` VALUES ('1', null, 'n1', 'd1');
INSERT INTO `organization` VALUES ('2', '1', 'n11', 'd11');
INSERT INTO `organization` VALUES ('3', '2', 'n111', 'd111');
INSERT INTO `organization` VALUES ('4', '2', 'n112', 'd112');
INSERT INTO `organization` VALUES ('5', '1', 'n2', 'd2');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `PASSWORD` varchar(20) DEFAULT NULL,
  `NAME` varchar(20) DEFAULT NULL,
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('pas', 'ag', '1');
INSERT INTO `user` VALUES ('bb', 'b', '2');
