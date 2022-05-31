import childFields from './childFields';

export default {
  layout: 'BaseTitle',
  title: '添加产品类别',
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
          createAPI: '/api/crud/product/productCategoryies',
        },
        fields: [
          { field: 'name', label: '名称', type: 'input', rules: ['required'] },
          {
            field: 'parentId', label: '父类别', type: 'select-fetch',
            options: {
              API: '/api/crud/product/productCategoryies',
              label: 'name',
              value: 'id',
            }
          },
          {
            field: 'isShowProducts', label: '主页展示', type: 'radio', options: [
              { label: '是', value: 1 },
              { label: '否', value: 0 },
            ]
          },
          {
            field: 'wholesale', label: '销售类别', type: 'radio', options: [
              { label: '批发', value: 1 },
              { label: '零售', value: 0 },
              { label: '试用', value: 2 },
            ],
            rules: ['required']
          },
          {
            field: 'visible', label: '产品详情', type: 'radio', options: [
              { label: '是', value: 1 },
              { label: '否', value: 0 },
            ]
          },
          { field: 'promotedProductCount', label: '主页推荐的数量', type: 'number' },
          { field: 'sortOrder', label: '排序号', type: 'number' },
          {
            field: 'cover', label: '封面', type: 'upload-image',
            options: {
              max: 1,
            }
          },
          { field: 'description', label: '描述', type: 'text-area', span: 24 },
          {
            field: 'productCategoryPropertyList', label: '', type: 'one-mary', span: 24,
            options: {
              actions: [
                {
                  title: '添加属性', type: 'children-modal-add', options: {
                    modalTitle: '添加属性',
                    modalWidth: 580,
                    "style": "primary",
                    items: [
                      {
                        layout: 'Empty',
                        component: 'ChildrenForm',
                        config: {
                          layout: 'Grid',
                          layoutConfig: {
                            layoutType: 'horizontal',
                            value: [24, 0],
                          },
                          fields: childFields,
                        },
                      }
                    ],
                  }
                },
              ],
              fields: [
                { field: 'displayName', label: '显示名称' },
                { field: 'valueType', label: '值类型' },
                { field: 'inputType', label: '输入类型' },
                { field: 'candidateValues', label: '可选值' },
                { field: 'defaultValue', label: '默认值' },
                { field: 'isRequired', label: '是否必填' },
                { field: 'sortOrder', label: '排序号' },
              ],
              operation: [
                {
                  title: '编辑', type: 'childEditModal',
                  options: {
                    outside: true,
                    modalTitle: '编辑属性',
                    modalWidth: 720,
                    layout: 'Content',
                    items: [
                      {
                        layout: 'Empty',
                        component: 'ChildrenForm',
                        config: {
                          layout: 'Grid',
                          layoutConfig: {
                            layoutType: 'horizontal',
                            value: [24, 0],
                          },
                          fields: childFields,
                        },
                      }
                    ],
                  }
                },
                {
                  title: '移除', type: 'removeChild',
                  options: {
                    outside: true,
                  }
                },
              ],
            },
          }
        ],
      },
    }
  ]
}
