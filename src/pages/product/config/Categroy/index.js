export default {
  layout: 'Content',
  title: '产品类别',
  items: [
    {
      span: 24,
      layout: 'Empty',
      component: 'Search',
      config: {
        share: 'categroy',
        fields: [
          { field: 'name', label: '类别名称', type: 'input' }
        ]
      }
    },
    {
      span: 24,
      layout: 'Empty',
      component: 'TreeList',
      config: {
        share: 'categroy',
        field: 'subCategoryList',
        API: {
          listAPI: '/api/crud/product/productCategoryies',
          deleteAPI: '/api/crud/product/productCategoryies/(id)'
        },
        actions: [
          {
            title: '添加', type: 'path',
            options: {
              "style": "primary",
              path: '/product/categroyAdd'
            }
          }
        ],
        fields: [
          /*{ field: '--', label: '',  width:200 },*/

          { field: 'name', label: '名称' },
          { field: 'cover', label: '封面', valueType: 'image'},
          { field: 'promotedProductCount', label: '主页推荐数量' },
          { field: 'sortOrder', label: '排序号' },
          { field: 'operation' }
        ],
        operation: [
          {
            title: '查看', type: 'path',
            options: {
              outside: true,
              path: '/product/categroyView',
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
              path: '/product/categroyEdit',
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
