const statusMap = {
  'Open': '开放',
  'Closed': '已关闭',
  'Invalid': '无效',
};
const colorMap = {
  'Open': '#135200',
  'Closed': '#666666',
  'Invalid': '#9E9E9E',
};
const statusOpts = [
  { label: '开放', value: 'Open' },
  { label: '已关闭', value: 'Closed' },
  { label: '无效', value: 'Invalid' },
];

module.exports = {
  statusMap,
  colorMap,
  statusOpts,
};