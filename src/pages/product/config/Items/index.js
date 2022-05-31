export default {
  layout: 'Content',
  title: '产品列表',
  items: [
    {
      span: 24,
      layout: 'Empty',
      component: 'Search',
      config: {
        share: 'product',
        fields: [
          { field: 'search', label: '搜索', type: 'input', placeholder: '名称/条形码/类别/品牌' },
          {
            field: 'status', label: '状态', type: 'select',
            options: [
              { label: '草稿', value: 'DRAFT' },
              { label: '上架', value: 'ONSELL' },
              { label: '下架', value: 'OFFSELL' }
            ]
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
          listAPI: '/api/crud/product/products',
          deleteAPI: '/api/crud/product/products/(id)'
        },
        actions: [
          {
            title: '添加', type: 'path',
            options: {
              "style": "primary",
              path: '/product/itemsAdd'
            }
          }
        ],
        fields: [
          // { field: 'skuCode', label: '编号' },
          { field: 'cover', label: '封面', valueType: 'image' },
          { field: 'categoryName', label: '类别' },
          { field: 'brandName', label: '品牌' },
          {
            field: 'name', label: '名称',
            valueType: 'path',
            options: {
              path: '/product/productView',
            }
          },
          { field: 'barcode', label: '条形码' },
          {
            field: 'status', label: '状态', valueType: 'tag',
            theme:"status",
            type:"Dot",
            options: {
              map: {
                'DRAFT': '草稿',
                'ONSELL': '上架',
                'OFFSELL': '下架'
              },
              chy: {
                'DRAFT': 'processing',
                'ONSELL': 'open',
                'OFFSELL': 'close'
              }
            }
          },
          {
            field: 'suggestedPrice', label: '零售价',
            valueType: 'currency',
            align: 'right'
          },
          {
            field: 'price', label: '价格',
            valueType: 'currency',
            align: 'right'
          },
          {
            field: 'sortOrder', label: '排序号',
            align: 'right'
          },
          { field: 'operation' }
        ],
        operation: [
          {
            title: '查看', type: 'path',
            options: {
              outside: true,
              path: '/product/productView',
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

              path: '/product/itemsEdit',
              queryData: (records) => {
                const data = {
                  id: records.id,
                }
                return data
              }
            }
          },
          {
            title: '上架', type: 'request',
            options: {
              outside: true,
              API: '/api/crud/product/products/(id)/ONSELL',
              method: 'put',
              tips: '确定要 上架 该商品?',
            },
            "expect": {
              "field": "status",
              "value": "OFFSELL"
            }
          },
          {
            title: '上架', type: 'request',
            options: {
              outside: true,
              API: '/api/crud/product/products/(id)/ONSELL',
              method: 'put',
              tips: '确定要 上架 该商品?',
            },
            "expect": {
              "field": "status",
              "value": "DRAFT"
            }
          },
          {
            title: '下架', type: 'request',
            options: {
              outside: true,
              API: '/api/crud/product/products/(id)/OFFSELL',
              method: 'put',
              tips: '确定要 下架 该商品?',
            },
            "expect": {
              "field": "status",
              "value": "ONSELL"
            }
          },
          {
            title: '删除', type: 'delete',
            options: {
            },
            "expect": {
              "field": "status",
              "value": "/(OFFSELL|DRAFT)/"
            }
          }
        ],
      },
    },
  ]
}
