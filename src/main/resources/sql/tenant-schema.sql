SET FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS `t_tenant_user`;
CREATE TABLE `t_tenant_user`(
`id` BIGINT(20) auto_increment,
`name` VARCHAR(50) NOT NULL COMMENT '用户名',
`check_in` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '入住时间时间',
`occupancy-days` INT DEFAULT NULL COMMENT '入住天数',
`room_number` VARCHAR(50) NOT NULL COMMENT '入住房间',
`org_id` BIGINT(20) NOT NULL COMMENT '数据隔离级别',
PRIMARY KEY(`id`)
)