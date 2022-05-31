module.exports = [
  { field: 'displayName', label: '显示名称', type: 'input' },
  {
    field: 'valueType', label: '值类型', type: 'select',
    options: [
      { label: '字符串', value: 'STRING' },
      { label: '整形', value: 'INTEGER' },
      { label: '布尔值', value: 'BOOLEAN' },
      { label: '日期', value: 'DATE' },
    ]
  },
  {
    field: 'inputType', label: '输入类型', type: 'select',
    options: [
      { label: '文本输入框', value: 'INPUT_TEXT' },
      { label: '数字输入框', value: 'INPUT_NUMBER' },
      { label: '日期输入框', value: 'INPUT_DATE' },
      { label: '多行文本框', value: 'TEXTAREA' },
      { label: '多选框', value: 'CHECKBOX' },
      { label: '单选框', value: 'RADIO' },
      { label: '下拉框', value: 'SELECT' },
    ]
  },
  { field: 'candidateValues', label: '可选值', type: 'input' },
  { field: 'defaultValue', label: '默认值', type: 'input' },
  {
    field: 'isRequired', label: '是否必填', type: 'radio', options: [
      { label: '是', value: 1 },
      { label: '否', value: 0 },
    ]
  },
  { field: 'sortOrder', label: '排序号', type: 'number' },
];
