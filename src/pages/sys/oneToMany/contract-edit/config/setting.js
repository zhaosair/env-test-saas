const statusMap = {
  'Open': '编辑中',
  'Submitted': '待分配',
  'Assigned': '待处理',
  'GenerateOpportunity': '已生成销售机会',
  'Closed': '已关闭',
  'Invalid': '无效',
};
const colorMap = {
  'Open': '',
  'Submitted': '#673AB7',
  'Assigned': '#ff2233',
  'GenerateOpportunity': '#135200',
  'Closed': '#666666',
  'Invalid': '#9E9E9E',
};

const ContactInfoMap = {
  'null': '未知有效性',
  0: '无效',
  1: '有效',
}
const ContactInfoColorMap = {
  'null': '#9E9E9E',
  0: '#ff2233',
  1: '#135200',
}

module.exports = {
  statusMap,
  colorMap,
  ContactInfoMap,
  ContactInfoColorMap,
};