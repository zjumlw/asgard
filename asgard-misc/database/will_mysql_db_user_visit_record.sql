USE will;
SET NAMES 'utf8mb4';

# 用户访问操作记录
DROP TABLE IF EXISTS `visit_record`;
CREATE TABLE `visit_record`(
    `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
    `user_id` varchar(20)  NOT NULL DEFAULT '' COMMENT '用户 id',
    `operation` varchar(20) NOT NULL DEFAULT '' COMMENT '操作',
    `date` varchar(20)  NOT NULL DEFAULT '' COMMENT '日期',
    primary key(`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO visit_record (user_id, operation, date) VALUES ("111", "visit", "20191101");
INSERT INTO visit_record (user_id, operation, date) VALUES ("111", "search", "20191101");
INSERT INTO visit_record (user_id, operation, date) VALUES ("111", "publish", "20191102");

INSERT INTO visit_record (user_id, operation, date) VALUES ("222", "visit", "20191101");

INSERT INTO visit_record (user_id, operation, date) VALUES ("333", "visit", "20191101");
INSERT INTO visit_record (user_id, operation, date) VALUES ("333", "like", "20191101");

INSERT INTO visit_record (user_id, operation, date) VALUES ("444", "visit", "20191101");
INSERT INTO visit_record (user_id, operation, date) VALUES ("444", "search", "20191102");
INSERT INTO visit_record (user_id, operation, date) VALUES ("444", "publish", "20191103");
INSERT INTO visit_record (user_id, operation, date) VALUES ("444", "delete", "20191103");

INSERT INTO visit_record (user_id, operation, date) VALUES ("555", "visit", "20191101");
INSERT INTO visit_record (user_id, operation, date) VALUES ("555", "visit", "20191102");
INSERT INTO visit_record (user_id, operation, date) VALUES ("555", "search", "20191102");
INSERT INTO visit_record (user_id, operation, date) VALUES ("555", "visit", "20191103");
INSERT INTO visit_record (user_id, operation, date) VALUES ("555", "search", "20191103");
INSERT INTO visit_record (user_id, operation, date) VALUES ("555", "visit", "20191104");

# 查询至少两天进行访问的user_id及访问天数
select user_id, count(distinct date) as diff_date from visit_record group by user_id having count(distinct date)>=2;