import React from 'react';
import ZEle from 'zero-element';
import config from './config/view/productView-config';
import useBreadcrumb from '@/framework/useBreadcrumb';

export default function productView() {
    useBreadcrumb([
        { title: '主页', path: '/' },
        { title: '产品详情' }
      ]);
    return <ZEle namespace="product_items_view" config={config} />;
}
