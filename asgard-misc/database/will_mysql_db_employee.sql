USE will;
SET NAMES 'utf8mb4';

#员工基本帐号信息
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee`(
    `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
    `name` varchar(20) NOT NULL DEFAULT '' COMMENT '名字',
    `sex` varchar(20) NOT NULL DEFAULT '' COMMENT '性别',
    `age` bigint(20) unsigned NOT NULL DEFAULT 0 COMMENT '年龄',
    primary key(`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO employee (name, sex, age) VALUES ("Jack", "male", "20");
INSERT INTO employee (name, sex, age) VALUES ("Tom", "male", "25");
INSERT INTO employee (name, sex, age) VALUES ("Rose", "female", "18");
INSERT INTO employee (name, sex, age) VALUES ("Mao", "male", "26");
INSERT INTO employee (name, sex, age) VALUES ("Kobe", "male", "40");

