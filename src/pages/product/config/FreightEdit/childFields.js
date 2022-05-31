module.exports = [
  {
    field: 'carryWay', label: '快递类型', type: 'select',
    options: [
      { label: '快递', value: 0 },
      { label: 'EMS', value: 1 },
      { label: '平邮', value: 2 },
    ]
  },
  {
    field: 'region', label: '地区', type: 'input',
    props: {
      placeholder: '留空, 则是全地区默认运费',
    }
  },
  { field: 'firstPiece', label: '首件数量', type: 'number' },
  { field: 'firstAmount', label: '首费', type: 'number' },
  { field: 'secondPiece', label: '续件', type: 'number' },
  { field: 'secondAmount', label: '续费', type: 'number' },
];