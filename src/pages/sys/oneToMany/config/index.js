
const {
  statusMap, colorMap, statusOpts,
} = require('./setting');

module.exports = {
  layout: 'Content',
  title: '合约列表',
  items: [
    {
      layout: 'Empty',
      component: 'Search',
      config: {
        share: 'salesChance',
        fields: [
          { field: 'opportunityNumber', label: '机会编号', type: 'input' },
          { field: 'contactNumber', label: '联系人编号', type: 'input' },
          { field: 'name', label: '姓名', type: 'input' },
          { field: 'address', label: '联系地址', type: 'input' },
          { field: 'email', label: '邮箱', type: 'input' },
          { field: 'phone', label: '联系电话', type: 'input' },
          { field: 'wechat', label: '微信', type: 'input' },
          {
            field: 'status', label: '状态', type: 'select',
            options: [
              { label: '', value: '' },
              ...statusOpts
            ],
          },
          { field: 'ownerStaff', label: '拥有人', type: 'input' },
          { field: 'salesLeadNum', label: '线索编号', type: 'input' },
          {
            field: 'isOrganization', label: '客户类型', type: 'input',
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
          { field: 'facebook', label: 'Facebook', type: 'input' },
          { field: 'updateMsg', label: '更新内容', type: 'input' },
          {
            field: 'createTime', label: '创建时间', type: 'range', span: 12,
            options: {
              format: 'DD/MM/YYYY',
            }
          },
        ],
      },
    },
    {
      layout: 'Empty',
      component: 'Table',
      config: {
        share: 'salesChance',
        API: {
          listAPI: '/api/contract/contracts',
          deleteAPI: '/api/contract/contracts/(id)/(version)',
        },
        actions: [],
        fields: [
          {
            field: 'powerContractNum', label: '合约编号', width: 150, sorter: true,
            valueType: 'path',
            options: {
              path: '/contract/contract-view'
            },
          },
          { field: 'icp', label: 'ICP No.', width: 150, sorter: true },
          { field: ['account', 'accountNumber'], label: '账户编号', width: 150, sorter: true },
          { field: ['account', 'accountName'], label: '账户名称', width: 150, sorter: true },
          { field: 'address', label: '地址', width: 150, valueType: 'ellipsis', sorter: true },
          // { field: 'contractProjectType', label: '合约产品类型', width: 150, sorter: true },
          { field: 'powerContractPlanName', label: '合约产品类型', width: 150, sorter: true },
          { field: 'billingPeriod', label: '计费周期', width: 150, sorter: true },
          { field: 'priceperDay', label: '每日收费($/day)', width: 150, sorter: true },
          { field: 'pricePerKWH', label: '每千瓦时收费($/kwh)', width: 150, sorter: true },
          { field: 'contractStartDate', label: '开始时间', width: 150, sorter: true },
          { field: 'ownerStaff', label: '结束时间', width: 150, sorter: true },
          { field: 'ownerStaffName', label: '销售人员', width: 150, sorter: true },
          {
            field: 'status', label: '状态', width: 150, sorter: true,
            valueType: 'tag',
            options: {
              map: statusMap,
              color: colorMap,
            }
          },
        ],
        operation: [
          {
            title: '编辑', type: 'path',
            options: {
              outside: true,
              path: '/contract/contract-edit',
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
