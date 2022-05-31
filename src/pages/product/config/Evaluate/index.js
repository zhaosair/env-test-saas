export default {
  layout: 'Content',
  title: '评价管理',
  items: [
    {
      span: 24,
      layout: 'Empty',
      component: 'Search',
      config: {
        share: 'product',
        fields: [
          { field: 'name', label: '商品名称', type: 'input' },
        ]
      }
    },
    {
      span: 24,
      layout: 'Empty',
      component: 'TreeList',
      config: {
        share: 'product',
        API: {
          listAPI: '/api/cms/evaluations',
          deleteAPI: '/api/cms/evaluations/(id)'
        },
        fields: [
          { field: 'tradeNumber', label: '订单编号' },
          { field: 'tradeTime', label: '下单时间' },
          { field: 'productNames', label: '商品名称', valueType: 'productNames' },
          { field: 'commentStar', label: '评价等级' },
          { field: 'commentContent', label: '评价内容' },
          { field: 'createTime', label: '评价时间' },
          { field: 'replyTime', label: '回复时间' },
          {
            field: 'isStick', label: '置顶', valueType: 'status',
            options: {
              0: '不置顶',
              1: '置顶'
            }
          },
          {
            field: 'isDisplay', label: '屏蔽', valueType: 'status',
            options: {
              0: '不屏蔽',
              1: '屏蔽'
            }
          },
          { field: 'operation' }
        ],
        operation: [
          {
            title: '查看', type: 'path',
            options: {
              path: '/product/evaluateView',
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
            title: '删除', type: 'delete'
          }
        ],
      },
    },
  ]
}
