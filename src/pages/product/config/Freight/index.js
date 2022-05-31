export default {
  layout: 'Content',
  title: '运费模板',
  items: [
    {
      span: 24,
      layout: 'Empty',
      component: 'Search',
      config: {
        share: 'product',
        fields: [
          {
            field: 'content', label: '搜索', type: 'input',
            placeholder: '模板名称/模板标题',
          },
        ]
      }
    },
    {
      span: 24,
      layout: 'Empty',
      component: 'TreeList',
      config: {
        share: 'product',
        // scroll:{x:2750},
        API: {
          listAPI: '/api/crud/product/fareTemplates',
          deleteAPI: '/api/crud/product/fareTemplates/(id)'
        },
        actions: [
          {
            title: '新增运费模板', type: 'path',
            options: {
              "style": "primary",
              path: '/product/freightAdd'
            }
          }
        ],
        fields: [
          { field: 'name', label: '模板名称' },
          {
            field: 'title', label: '模板标题'
          },

          {
            field: 'isInclPostage', label: '是否包邮', valueType: 'tag',
            type:"default",
            theme:"security",
            options: {
              map: {
                1: '卖家承担运费',
                0: '自定义运费'
              },
              chy: {
                1: 'danger',
                0: 'error',
              }
            }
          },

          {
            field: 'valuationModel', label: '计价方式', valueType: 'tag',
            type:"Online",
            theme:"option",
            options: {
              map: {
                0: '按件数',
                1: '按重量',
                2: '按体积'
              },
              chy: {
                0: 'orange',
                1: 'blue',
                2: 'cyan'
              }
            }
          },
          {
            field: 'isInclPostageByIf', label: '是否指定条件包邮', valueType: 'tag',
            type:"default",
            theme:"status",
            options: {
              map: {
                1: '是',
                0: '否'
              },
              chy: {
                1: 'open',
                0: 'close'
              }
            }
          },

          { field: 'lastModifiedDate', label: '最后编辑时间' },
          { field: 'operation' }

        ],
        operation: [
          {
            title: '查看', type: 'path',
            options: {
              outside: true,
              path: '/product/freightView',
              // permission:'apply.view',
              // location:true
              queryData: (records) => {
                const data = {
                  id: records.id,
                }
                return data
              }
            }
          },
          {
            title: '编辑', type: 'path',
            options: {
              outside: true,
              path: '/product/freightEdit',
              queryData: (records) => {
                const data = {
                  id: records.id,
                }
                return data
              }
            }
          },
          {
            title: '删除', type: 'delete'
          }
        ],
      },
    },
  ]
}
