
module.exports = {
  layout: 'TitleContent',
  title: '账户',
  items: [
    {
      component: 'Search',
      config: {
        fields: [
          { field: 'name', label: '姓名', type: 'input' },
          { field: 'phone', label: '电话', type: 'input' },
          { field: 'wechat', label: '微信', type: 'input' },
          { field: 'address', label: '地址', type: 'input' },
          { field: 'accountNumber', label: '账户编号', type: 'input' },
          { field: 'accountName', label: '账户名', type: 'input' },
          {
            field: 'isOrganization', label: '账户类型', type: 'select',
            options: [
              { label: '', value: '' },
              { label: '组织', value: 1 },
              { label: '个人', value: 0 },
            ]
          },
          {
            field: 'sex', label: '性别', type: 'select',
            options: [
              { label: '', value: '' },
              { label: '男', value: 'Male' },
              { label: '女', value: 'Female' },
            ]
          },
        ],
      },
    },
    {
      component: 'Table',
      config: {
        API: {
          listAPI: '/api/account/accounts',
          deleteAPI: '/api/account/accounts/(id)/(version)',
        },
        actions: [
          {
            title: '新建账户', type: 'path',
            options: {
              path: '/account/account-add',
            }
          },
        ],
        fields: [
          {
            field: 'accountNumber', label: '账户编号',
            valueType: 'path',
            options: {
              path: '/account/account-view',
            },
            width: 150, fixed: 'left', sorter: true,
          },
          { field: 'info', label: '账户信息', width: 550, valueType: 'account-info' },
          // { field: 'accountName', label: '账户名', width: 150 },
          // {
          //   field: 'isOrganization', label: '账户类型', width: 180,
          //   valueType: 'tag',
          //   options: {
          //     map: {
          //       0: '个人',
          //       1: '组织',
          //     },
          //     color: {
          //       0: '#673AB7',
          //     }
          //   }
          // },
          {
            field: 'universalName', label: '姓名', valueType: 'format', width: 150,
            options: {
              format: '<lastName> <firstName>',
            }
          },
          {
            field: 'IDTypeName', label: '证件类型', width: 150,
          },
          { field: 'IDNumber', label: '证件号', width: 150 },
          { field: 'registeredMobile', label: '注册手机号', width: 150 },
          { field: 'registeredEmail', label: '注册邮箱', width: 150 },
          { field: 'registeredWechat', label: '注册微信', width: 150, },
          { field: 'address', label: '地址', valueType: 'ellipsis', width: 150 },
          { field: 'balance', label: '余额', width: 150, sorter: true },
        ],
        operation: [
          {
            title: '编辑', type: 'path',
            options: {
              outside: true,
              path: '/account/account-edit',
            },
          },

          {
            title: '删除', type: 'delete',
          },
        ],
      },
    },
  ],
};
