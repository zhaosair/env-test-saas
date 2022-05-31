export default {
  layout: 'BaseTitle',
  title: '添加试用装',
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
          createAPI: '/api/crud/product/trials',
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
    // {
    //   layout: 'Empty',
    //   component: 'ChildrenList',
    //   config: {
    //     itemsField: 'items',
    //     actions: [
    //       {
    //         title: '关联产品', type: 'children-modal-add', options: {
    //           modalTitle: '添加关联产品',
    //           modalWidth: 580,
    //           childAppendField: 'items',
    //           items: [
    //             {
    //               layout: 'Empty',
    //               component: 'ChildrenForm',
    //               config: {
    //                 API: {},
    //                 fields: [
    //                   {
    //                     label: '', field: 'items', type: 'table-select',
    //                     options: {
    //                       API: '/api/crud/product/products',
    //                       fields: [
    //                         { label: '名称', field: 'name' },
    //                         { label: '价格', field: 'price' },
    //                       ]
    //                     }
    //                   }
    //                 ],
    //               },
    //             }
    //           ],
    //         }
    //       },
    //     ],
    //     fields: [
    //       { field: 'name', label: '产品名称' },
    //       { field: 'costPrice', label: '成本价' },
    //       { field: 'suggestedPrice', label: '市场价' },
    //       { field: 'price', label: '零售价' },
    //     ],
    //     operation: [
    //       {
    //         title: '移除', type: 'removeChild',
    //         options: {
    //           outside: true,
    //         }
    //       },
    //     ],
    //   },
    // }
  ]
}
