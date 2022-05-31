import React from 'react';
import ZEle from 'zero-element';
import config from './config/Tag';
import useBreadcrumb from '@/framework/useBreadcrumb';


export default function Tag() {
  useBreadcrumb([
    { title: '主页', path: '/' },
    { title: '产品管理' },
    { title: '标签管理' },
  ]);
  return <ZEle namespace='product_tag' config={config} />;
}