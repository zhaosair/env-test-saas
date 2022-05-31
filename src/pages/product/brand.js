import React from 'react';
import ZEle from 'zero-element';
import config from './config/Brand';
import useBreadcrumb from '@/framework/useBreadcrumb';

export default function Brand(props) {
  useBreadcrumb([
    { title: '主页', path: '/' },
    { title: '产品管理' },
    { title: '品牌管理' },
  ]);
  return <ZEle namespace='product_brand' config={config} />;
}