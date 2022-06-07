DROP TABLE IF EXISTS `t_company`;
CREATE TABLE `t_company`(
`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
`name` VARCHAR(150) NOT NULL COMMENT '公司名称',
PRIMARY KEY(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `t_department`;
CREATE TABLE `t_department` (
`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
`name` VARCHAR(30) NOT NULL COMMENT '部门名称',
`company_id` INT(20) NOT NULL COMMENT '公司id',
PRIMARY KEY(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `t_employee`;
CREATE TABLE `t_employee` (
`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
`name` VARCHAR(30) NOT NULL COMMENT '员工名称',
`company_id` INT(20) NOT NULL COMMENT '公司id',
PRIMARY KEY(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

