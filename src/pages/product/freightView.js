import React from 'react';
import ZEle from 'zero-element';
import config from './config/view/freightView-config';
import useBreadcrumb from '@/framework/useBreadcrumb';

export  default function freightView(){
    useBreadcrumb([
        { title: '主页', path: '/' },
        { title: '运费模板详情' }
      ]);
    return <ZEle namespace="product_freight_view" config={config} />;
}
