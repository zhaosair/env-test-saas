import React from 'react';
import ZEle from 'zero-element';
import useBreadcrumb from '@/framework/useBreadcrumb';
import config from './config/FreightEdit';

export default function FreightEdit(props) {
  useBreadcrumb([
    { title: '主页', path: '/' },
    { title: '产品管理' },
    { title: '运费模板', path: '/product/freight' },
    { title: '编辑运费模板' },
  ]);

  return <ZEle namespace='product_freight_edit' config={config} />;
}