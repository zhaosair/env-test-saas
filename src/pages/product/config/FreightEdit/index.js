import childFields from './childFields';

export default {
  layout: 'BaseTitle',
  title: '编辑运费模板',
  items: [
    {
      layout: 'Content',
      component: 'Form',
      config: {
        layout: 'Grid',
        layoutConfig: {
          value: [12,12],
        },
        API: {
          getAPI: '/api/crud/product/fareTemplates/[id]',
          updateAPI: '/api/crud/product/fareTemplates/[id]',
        },
        fields: [
          {
            field: 'name', label: '模板名称', type: 'input',
            rules: ['required']
          },
          {
            field: 'title', label: '标题', type: 'input',
            rules: ['required']
          },
          {
            field: 'dispatchTime', label: '发货时间', type: 'number',
            rules: ['required'],
            props: {
              placeholder: '单位: 每小时',
            }
          },
          {
            field: 'messageFormat', label: '消息格式', type: 'input',
            // opitons: {
            //   expectedField: 'name',
            //   expectedValue: 'IS_NOT_NULL',
            // }
          },
          {
            field: 'content', label: '内容', type: 'text-area', span: 24,
            rules: ['required']
          },
          {
            field: 'shopAddrList', label: '地址', type: 'pcdm', span: 24,
            options: {
              disable: {
                district: true,
              }
            }
          },
          {
            field: 'isInclPostage', label: '是否包邮', type: 'radio', options: [
              { label: '卖家承担运费', value: 1 },
              { label: '自定义运费', value: 0 },
            ]
          },

          {
            field: 'valuationModel', label: '计价方式', type: 'radio', options: [
              { label: '按件数', value: 0 },
              { label: '按重量', value: 1 },
              { label: '按体积', value: 2 },
            ],
            rules: ['required']
          },
          {
            field: 'isInclPostageByIf', label: '是否指定条件包邮', type: 'radio', options: [
              { label: '是', value: 1 },
              { label: '否', value: 0 },
            ]
          },
          { field: 'lastModifiedDate', label: '最后编辑时间', type: 'plain' },


          {
            field: 'items', label: '', type: 'one-mary', span: 24,
            options: {
              actions: [
                {
                  title: '运费模板', type: 'children-modal-add', options: {
                    modalTitle: '添加运费模板',
                    "style": "primary",
                    modalWidth: 580,
                    items: [
                      {
                        layout: 'Empty',
                        component: 'ChildrenForm',
                        config: {
                          layout: 'Grid',
                          layoutConfig: {
                            value: [24,0],
                          },
                          API: {},
                          fields: childFields,
                        },
                      }
                    ],
                  }
                },
              ],
              fields: [
                {
                  field: 'carryWay', label: '快递类型', valueType: 'tag',
                  options: {
                    map: {
                      0: '快递',
                      1: 'EMS',
                      2: '平邮',
                    }
                  }
                },
                {
                  field: 'region', label: '地区', valueType: 'tag',
                  options: {
                    map: {
                      '': '默认地区',
                    }
                  }
                },
                { field: 'firstPiece', label: '首件数量' },
                { field: 'firstAmount', label: '首费' },
                { field: 'secondPiece', label: '续件' },
                { field: 'secondAmount', label: '续费' },
              ],
              operation: [
                {
                  title: '移除', type: 'removeChild',
                  options: {
                    outside: true,
                  }
                },
              ],
            }
          }
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
    //         title: '运费模板', type: 'children-modal-add', options: {
    //           modalTitle: '添加运费模板',
    //           modalWidth: 580,
    //           items: [
    //             {
    //               layout: 'Empty',
    //               component: 'ChildrenForm',
    //               config: {
    //                 layout: 'Grid',
    //                 layoutConfig: {
    //                   value: [24, 0],
    //                 },
    //                 API: {},
    //                 fields: childFields,
    //               },
    //             }
    //           ],
    //         }
    //       },
    //     ],
    //     fields: [
    //       {
    //         field: 'carryWay', label: '快递类型', valueType: 'status',
    //         options: {
    //           statusMap: {
    //             0: '快递',
    //             1: 'EMS',
    //             2: '平邮',
    //           }
    //         }
    //       },
    //       {
    //         field: 'region', label: '地区', valueType: 'status',
    //         options: {
    //           statusMap: {
    //             '': '默认地区',
    //           }
    //         }
    //       },
    //       { field: 'firstPiece', label: '首件数量' },
    //       { field: 'firstAmount', label: '首费' },
    //       { field: 'secondPiece', label: '续件' },
    //       { field: 'secondAmount', label: '续费' },
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
