USE will;
DROP TABLE IF EXISTS user;
CREATE TABLE user(
    `user_id` varchar(20) NOT NULL COMMENT 'userId',
     `name` varchar(20) NOT NULL  COMMENT '名字',
     `password` varchar(20) NOT NULL  COMMENT '密码',
    primary key(`user_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;