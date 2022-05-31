export default {
  layout: 'Content',
  title: '试用装管理',
  items: [
    {
      span: 24,
      layout: 'Empty',
      component: 'Search',
      config: {
        share: 'product',
        fields: [
          {
            field: 'enabled', label: '是否启用', type: 'select',
            options: [
              { label: '是', value: 1 },
              { label: '否', value: 0 },
            ]
          },
          { field: 'name', label: '名称', type: 'input' },
          { field: 'barcode', label: '条形码', type: 'input' },
          {
            field: 'categoryId', label: '类别', type: 'select-fetch',
            options: {
              API: '', label: '', value: ''
            }
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
          listAPI: '/api/crud/product/trials',
          deleteAPI: '/api/crud/product/trials/(id)'
        },
        actions: [
          {
            title: '添加', type: 'path',
            options: {
              "style": "primary",
              path: '/product/trialAdd'
            }
          }
        ],
        fields: [
          { field: 'id', label: '编号' },
          { field: 'cover', label: '封面', valueType: 'image' },
          { field: 'name', label: '名称' },
          {
            field: 'enabled', label: '是否启用', valueType: 'tag',
            options: {
              map: {
                0: '禁用',
                1: '启用'
              },
              colorMap: {
                0: '#777',
                1: '#428bca'
              }
            }
          },
          { field: 'sortOrder', label: '排序号' },
          { field: 'operation' }
        ],
        operation: [
          {
            title: '查看', type: 'path',
            options: {
              path: '/product/trialView',
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
              path: '/product/trialEdit',
              queryData: (records) => {
                const data = {
                  id: records.id,
                }
                return data
              }
            }
          },
          {
            title: '启用', type: 'request',
            options: {
              expectedField: [['enabled']],
              expectedValue: [[0]],
              API: '/api/crud/product/trials/(id)/1',
              method: 'post'
            }
          },
          {
            title: '禁用', type: 'request',
            options: {
              expectedField: [['enabled']],
              expectedValue: [[1]],
              API: '/api/crud/product/trials/(id)/0',
              method: 'post'
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
