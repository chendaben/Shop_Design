/*
Navicat MySQL Data Transfer

Source Server         : 本地连接
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : chenyanqiu

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2016-05-24 15:52:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for books
-- ----------------------------
DROP TABLE IF EXISTS `books`;
CREATE TABLE `books` (
  `BookId` int(7) NOT NULL AUTO_INCREMENT,
  `BookName` varchar(40) NOT NULL,
  `BookAuthor` varchar(10) NOT NULL,
  `BookPress` varchar(30) DEFAULT NULL,
  `BookPrice` decimal(6,2) NOT NULL,
  `BookTotalNum` int(7) NOT NULL,
  `BookRemainNum` int(7) NOT NULL,
  `CategoryId` int(11) DEFAULT NULL,
  `ImageUrl` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`BookId`),
  KEY `CategoryId` (`CategoryId`)
) ENGINE=MyISAM AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of books
-- ----------------------------
INSERT INTO `books` VALUES ('12', '神奇校车', '乔安娜', '贵州人民出版社', '91.50', '200', '200', '3', 'image/shenqi.jpg');
INSERT INTO `books` VALUES ('6', 'java程序设计', '不知道', '人民邮电出版社', '40.00', '100', '100', '2', 'image/java.jpg');
INSERT INTO `books` VALUES ('5', 'springmvc指南', 'paulDeck', '人民邮电出版社', '49.00', '1000', '10', '2', 'image/springmvc.jpg');
INSERT INTO `books` VALUES ('7', '从你的全世界路过', '张嘉佳', '湖南文艺出版社', '21.50', '100', '100', '1', 'image/toyou.jpg');
INSERT INTO `books` VALUES ('8', '饿童时代', '殳俏', '重庆大学出版社', '31.50', '100', '100', '5', 'image/child.jpg');
INSERT INTO `books` VALUES ('17', 'chen', 'cjen', 'chen', '1.00', '1', '1', '4', 'image/1.png');

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `CategoryId` int(3) NOT NULL AUTO_INCREMENT,
  `CategoryName` varchar(20) NOT NULL,
  PRIMARY KEY (`CategoryId`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '文学');
INSERT INTO `category` VALUES ('2', '科学');
INSERT INTO `category` VALUES ('3', '儿童');
INSERT INTO `category` VALUES ('4', '励志');
INSERT INTO `category` VALUES ('5', '生活');
INSERT INTO `category` VALUES ('6', '经管');
INSERT INTO `category` VALUES ('7', '小说');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `orderId` int(10) NOT NULL AUTO_INCREMENT,
  `lineId` int(10) NOT NULL,
  `cost` decimal(8,2) NOT NULL,
  `payType` varchar(10) NOT NULL,
  `userId` int(11) NOT NULL,
  `payTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`orderId`),
  KEY `userId` (`userId`),
  KEY `lineId` (`lineId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------

-- ----------------------------
-- Table structure for shopbook
-- ----------------------------
DROP TABLE IF EXISTS `shopbook`;
CREATE TABLE `shopbook` (
  `shopId` int(10) NOT NULL AUTO_INCREMENT,
  `userId` int(10) NOT NULL,
  `bookId` int(7) NOT NULL,
  `ordermount` int(4) NOT NULL DEFAULT '1',
  `price` decimal(7,2) NOT NULL,
  `ispay` varchar(7) NOT NULL,
  PRIMARY KEY (`shopId`),
  KEY `userId` (`userId`),
  KEY `bookId` (`bookId`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shopbook
-- ----------------------------
INSERT INTO `shopbook` VALUES ('5', '5', '7', '1', '21.50', 'no');
INSERT INTO `shopbook` VALUES ('6', '5', '6', '1', '40.00', 'no');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `UserId` int(10) NOT NULL AUTO_INCREMENT,
  `UserName` varchar(30) NOT NULL,
  `UserPhone` varchar(14) NOT NULL,
  `UserEmail` varchar(22) NOT NULL,
  `UserPassword` varchar(16) NOT NULL,
  `UserGrade` int(1) NOT NULL DEFAULT '1',
  `UserIsUse` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`UserId`),
  UNIQUE KEY `UserPhone` (`UserPhone`),
  UNIQUE KEY `UserEmail` (`UserEmail`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('5', 'chenyanqiu', '15708444524', '931380058@qq.com', '123456', '2', '1');
INSERT INTO `users` VALUES ('6', 'test', '15708441004', '1004@qq.com', '123456', '1', '1');
