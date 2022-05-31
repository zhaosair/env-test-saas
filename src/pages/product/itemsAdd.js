import React from 'react';
import ZEle from 'zero-element';
import useBreadcrumb from '@/framework/useBreadcrumb';
import config from './config/ItemsAdd';

export default function ItemsAdd(props) {
  useBreadcrumb([
    { title: '主页', path: '/' },
    { title: '产品管理' },
    { title: '产品', path: '/product/items' },
    { title: '添加产品' },
  ]);

  return <ZEle namespace='product_items_add' config={config} />;
}