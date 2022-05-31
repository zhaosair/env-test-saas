export default {
  layout: 'BaseTitle',
  title: '编辑产品',
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
          getAPI: '/api/crud/product/products/[id]',
          updateAPI: '/api/crud/product/products/[id]',
        },
        fields: [
          { field: 'group_1', type: 'group', value: '产品信息', span: 24 },
          {
            field: 'layout_1', label: '', type: 'plain', value: '基本属性:',
            style: {
              fontSize: 18,
            },
            span: 24,
          },
          {
            field: 'name', label: '名称', type: 'input',
            rules: ['required']
          },
          {
            field: 'shortName', label: '缩略名称', type: 'input',
            rules: ['required']
          },
          {
            field: 'brandId', label: '品牌', type: 'select-fetch',
            options: {
              API: '/api/crud/product/productBrands',
              label: 'name',
              value: 'id',
            },
            // rules: ['required']
          },
          {
            field: 'barcode', label: '条形码', type: 'input',
          },
          {
            field: 'categoryId', label: '类别', type: 'select-fetch',
            options: {
              API: '/api/crud/product/productCategoryies',
              label: 'name',
              value: 'id',
            },
            rules: ['required']
          },
          { field: 'sortOrder', label: '排序号', type: 'number' },
          {
            field: 'partnerLevelZone', label: '分区', type: 'select', options: [
              { label: '零元区', value: 1 },
              { label: '精品区', value: 2 },
              { label: '特价区', value: '3' },
            ]
          },
          {
            field: 'promoted', label: '推荐', type: 'radio',
            value: 0,
            options: [
              { label: '是', value: 1 },
              { label: '否', value: 0 },
            ]
          },


          {
            field: 'layout_2', label: '', type: 'plain', value: '规格:',
            style: {
              fontSize: 18,
            },
          },
          {
            field: 'hidden_1', label: '', type: 'hidden', value: '',
          },
          {
            field: 'unit', label: '产品单位', type: 'input',
            rules: ['required']
          },
          {
            field: 'weight', label: '重量(克)', type: 'number',
            rules: ['required']
          },
          {
            field: 'bulk', label: '体积', type: 'number',
            props: {
              min: 0,
            },
            // rules: ['required']
          },


          {
            field: 'layout_3', label: '', type: 'plain', value: '价格与活动:',
            span: 24,
            style: {
              fontSize: 18,
            }
          },
          {
            field: 'price', label: '价格', type: 'number',
            props: {
              min: 0,
            },
            rules: ['required']
          },
          {
            field: 'suggestedPrice', label: '建议售价', type: 'number',
            props: {
              min: 0,
            },
            rules: ['required']
          },
          {
            field: 'costPrice', label: '成本价', type: 'number',
            props: {
              min: 0,
            },
            rules: ['required']
          },
          {
            field: 'distributionPrice', label: '分销价', type: 'number',
            props: {
              min: 0,
            }
          },
          {
            field:"stockBalance",label:"库存",type:"number",
            props: {
              min: 0,
            }
          },
          {
            field: 'credit', label: '优惠活动-积分', type: 'number',
          },
          {
            field: 'allowCoupon', label: '优惠活动-优惠券', type: 'radio',
            value: 0,
            options: [
              { label: '允许使用', value: 1 },
              { label: '不允许使用', value: 0 },
            ]
          },


          {
            field: 'layout_4', label: '', type: 'plain', value: '其它信息:',
            span: 24,
            style: {
              fontSize: 18,
            }
          },
          {
            field: 'productImageList', label: '产品图片', type: 'upload-image',
            options: {
              max: 9,
            },
            span: 24
          },
          {
            field: 'bannerList', label: '海报', type: 'upload-image',
            options: {
              API: `/api/fs/uploadfile`,
              max: 1
            }
          },
          {
            field: 'vedio', label: '视频', type: 'upload-file',
            options: {
              max: 6,
            },
            span: 24
          },
          {
            field: 'tagIds', label: '标签', type: 'checkbox-fetch',
            span: 24,
            options: {
              API: '/api/crud/product/productTags',
              label: 'name',
              value: 'id',
            }
          },
          {
            field: 'fareId', label: '运费模板', type: 'select-fetch',
            options: {
              API: '/api/crud/product/fareTemplates',
              label: 'name',
              value: 'id',
            }
          },


          {
            field: 'layout_5', label: '', type: 'plain', value: '产品描述:',
            span: 24,
            style: {
              fontSize: 18,
            }
          },
          { field: 'description', label: '', type: 'rich-text', span: 24 },

          { field: 'group_2', type: 'group', value: '分成设置', span: 24 },
          {
            field: 'productSettlementProportionList', label: '', type: 'one-mary', span: 24,
            options: {
              API: '/api/crud/product/productSettlementProportions/settingGroup',
              actions: [],
              fields: [
                { field: 'level', label: '级别' },
                { field: 'name', label: '级别名称' },
                {
                  field: 'value', label: '每件分成', valueType: 'input-number',
                  width: 120,
                },
                { field: 'rewardType', label: '单位' },
              ],
              operation: [],
            }
          }
        ],
      },
    },
  ]
}
