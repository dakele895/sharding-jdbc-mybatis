

-- ----------------------------
-- Table structure for t_student_00
-- ----------------------------
DROP TABLE IF EXISTS `t_student_00`;
CREATE TABLE `t_student_00` (
  `id` varchar(36) CHARACTER SET utf8mb4 NOT NULL DEFAULT '0' COMMENT '主键',
  `student_id` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `age` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ;

-- ----------------------------
-- Table structure for t_student_01
-- ----------------------------
DROP TABLE IF EXISTS `t_student_01`;
CREATE TABLE `t_student_01` (
  `id`varchar(36) CHARACTER SET utf8mb4 NOT NULL DEFAULT '0' COMMENT '主键',
  `student_id` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `age` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_user_00
-- ----------------------------
DROP TABLE IF EXISTS `t_user_00`;
CREATE TABLE `t_user_00` (
  `id` varchar(36) CHARACTER SET utf8mb4 NOT NULL DEFAULT '0' COMMENT '主键',
  `user_id` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `age` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_user_01
-- ----------------------------
DROP TABLE IF EXISTS `t_user_01`;
CREATE TABLE `t_user_01` (
  `id` varchar(36) CHARACTER SET utf8mb4 NOT NULL DEFAULT '0' COMMENT '主键',
  `user_id` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `age` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_user_02
-- ----------------------------
DROP TABLE IF EXISTS `t_user_02`;
CREATE TABLE `t_user_02` (
  `id` varchar(36) CHARACTER SET utf8mb4 NOT NULL DEFAULT '0' COMMENT '主键',
  `user_id` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `age` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
