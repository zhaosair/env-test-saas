import React from 'react';
import ZEle from 'zero-element';
import useBreadcrumb from '@/framework/useBreadcrumb';
import config from './config/ItemsEdit';

export default function ItemsEdit(props) {
  useBreadcrumb([
    { title: '主页', path: '/' },
    { title: '产品管理' },
    { title: '产品', path: '/product/items' },
    { title: '编辑产品' },
  ]);

  return <ZEle namespace='product_items_edit' config={config} />;
}