import React from 'react';
import ZEle from 'zero-element';
import useBreadcrumb from '@/framework/useBreadcrumb';
import config from './config/FreightAdd';

export default function FreightAdd(props) {
  useBreadcrumb([
    { title: '主页', path: '/' },
    { title: '产品管理' },
    { title: '运费模板', path: '/product/freight' },
    { title: '添加运费模板' },
  ]);

  return <ZEle namespace='product_freight_add' config={config} />;
}