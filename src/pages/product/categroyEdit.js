import React from 'react';
import ZEle from 'zero-element';
import useBreadcrumb from '@/framework/useBreadcrumb';
import config from './config/CategroyEdit';

export default function CategroyEdit(props) {
  useBreadcrumb([
    { title: '主页', path: '/' },
    { title: '产品管理' },
    { title: '产品类别', path: '/product/categroy' },
    { title: '编辑产品类别' },
  ]);

  return <ZEle namespace='product_categroy_edit' config={config} />;
}