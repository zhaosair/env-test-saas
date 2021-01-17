SET FOREIGN_KEY_CHECKS=0;

-- INSERT INTO `sys_perm_group` ( `id`, `org_id`, `pid`, `identifier`, `name` )
-- VALUES ( '200600001231122010', '100000000000000010', '200200000000000010', 'test', '自定义表单管理' );
-- INSERT INTO `sys_perm` ( `id`, `group_id`, `identifier`, `name`, `tag` )
-- VALUES ( '300700004000000010', '200600001231122010', 'Test.SaaS.View', '查看自定义表单', '0' );
-- INSERT INTO `sys_perm` ( `id`, `group_id`, `identifier`, `name`, `tag` )
-- VALUES ( '300700001000000010', '200600001231122010', 'Test.SaaS.Add', '新建自定义表单', '0' );
-- INSERT INTO `sys_perm` ( `id`, `group_id`, `identifier`, `name`, `tag` )
-- VALUES ( '300700002000000010', '200600001231122010', 'Test.SaaS.Edit', '删除自定义表单', '0' );
-- INSERT INTO `sys_perm` ( `id`, `group_id`, `identifier`, `name`, `tag` )
-- VALUES ( '300700003000000010', '200600001231122010', 'Test.SaaS.Delete', '编辑自定义表单', '0' );