export default {
  layout: 'BaseTitle',
  title: '编辑试用装',
  items: [
    {
      layout: 'Content',
      component: 'Form',
      config: {
        layout: 'Grid',
        layoutConfig: {
          value: [24, 0],
        },
        API: {
          getAPI: '/api/crud/product/trials/[id]',
          updateAPI: '/api/crud/product/trials/[id]',
        },
        fields: [
          { field: 'name', label: '名称', type: 'input', rules: ['required'] },
          {
            field: 'shortNote', label: '简短描述', type: 'input', rules: ['required']
          },
          // { field: 'startTime', label: '开始时间', type: 'date' },
          // { field: 'endTime', label: '结束时间', type: 'date' },
          { field: 'sortOrder', label: '排序号', type: 'number' },
          {
            field: 'enabled', label: '是否启用', type: 'radio', options: [
              { label: '是', value: 1 },
              { label: '否', value: 0 },
            ]
          },
          {
            field: 'cover', label: '封面', type: 'upload-image',
            options: {
              max: 1,
            }
          },
          {
            field: 'productId', label: '推荐产品', type: 'select-fetch',
            options: {
              API: '/api/crud/product/products',
              label: 'name',
              value: 'id',
            },
            rules: ['required']
          },

          { field: 'description', label: '描述', type: 'rich-text', span: 24 },
        ],
      },
    },
  ]
}
