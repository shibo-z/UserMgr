create database users CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

use users;

create table tb_users(
`id` BIGINT primary key AUTO_INCREMENT,
`user_name` varchar(50) not NULL,
`gender` varchar(1) not null COMMENT '男：1 ; 女：0',
`age` int(3) not null,
`phone` varchar(11) not null default '',
`created_by` varchar(32)     NOT NULL DEFAULT '' COMMENT '创建人',
`created_at` datetime        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`updated_by` varchar(32)     NOT NULL DEFAULT '' COMMENT '更新人',
`updated_at` datetime        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间'
);

insert into tb_users values
(default,'张三','1',18,'13193594444','admin',NOW(),'admin',NOW()),
(default,'李四','1',18,'15946482456','admin',NOW(),'admin',NOW()),
(default,'王舞','0',250,'13939359666','admin',NOW(),'admin',NOW())
