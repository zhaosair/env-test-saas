import React from 'react';
import useBreadcrumb from '@/framework/useBreadcrumb';
import Details from '@/components/Details';
import Content from '@/layouts/Content';

export default function EvaluateView(props) {

  // const [details, loading] = useDetails('product', props);

  useBreadcrumb([
    { title: '主页', path: '/' },
    { title: '产品管理' },
    { title: '产品评价', path: '/product/evaluate' },
    { title: '评价详情' },
  ]);

  const imgStyle = {
    wordWrap: 'break-word'
  }

  return <Content>
    <Details
      namespace="product_evaluate_view"
      goBack
      // loading={loading}
      // data={details}
      fields={[
        { label: '名称', field: 'name' },
        { label: '父类别', field: 'parentId' },
        {
          label: '主页展示', field: 'isShowProducts',
          map: {
            '1': '是',
            '0': '否',
          }
        },
        { label: '销售类别', field: 'wholesale' },
        {
          label: '点击类别显示产品详情', field: 'visible',
          map: {
            '1': '是',
            '0': '否',
          }
        },
        { label: '主页推荐产品数量', field: 'promotedProductCount' },
        { label: '排序号', field: 'sortOrder' },
        {
          label: '封面', valueType:"image",field:"cover"
        },
        { label: '描述', field: 'description' },
        {
          label: '属性', field: 'productCategoryPropertyList',
          columns: [
            { label: '时间', field: 'processDate', },
            { label: '内容', field: 'content' },

            { label: '显示名称', field: 'displayName' },
            {
              label: '值类型', field: 'valueType', valueType: 'tag',
              options: {
                map: {
                  'STRING': '字符串',
                  'INTEGER': '整形',
                  'BOOLEAN': '布尔值',
                  'DATE': '日期'
                }
              }
            },
            {
              label: '输入类型', field: 'inputType', valueType: 'tag',
              options: {
                map: {
                  'INPUT_TEXT': '文本输入框',
                  'INPUT_NUMBER': '数字输入框',
                  'INPUT_DATE': '日期输入框',
                  'TEXTAREA': '多行文本框',
                  'CHECKBOX': '多选框',
                  'RADIO': '单选框',
                  'SELECT': '下拉框'
                }
              }
            },
            { label: '可选值', field: 'candidateValues' },
            { label: '默认值', field: 'defaultValue' },
            { label: '是否必填', field: 'isRequired' },
            { label: '排序号', field: 'sortOrder' },
          ]
        },
      ]}
    />
  </Content>;
}
